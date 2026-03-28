import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Central manager for all smart devices in the home.
 * 
 * This class stores every device through the abstract
 * smartDevice base type so the rest of the program can
 * work with different device subclasses polymorphically.
 */
public class SmartHomeManager {

    // The manager owns one shared collection of all registered devices.
    private final List<smartDevice> devices;

    public SmartHomeManager() {
        devices = new ArrayList<>();
    }

    /**
     * Adds a new device to the home.
     * Rejects null devices and duplicate IDs so each device
     * can be looked up safely later.
     */
    public void addDevice(smartDevice device) {
        if (device == null) {
            throw new IllegalArgumentException("Device cannot be null.");
        }

        if (hasDevice(device.getDeviceID())) {
            throw new DuplicateDeviceException(
                "A device with ID " + device.getDeviceID() + " already exists."
            );
        }

        devices.add(device);
    }

    // Removes a device after confirming that the ID exists.
    public void removeDevice(String deviceID) {
        smartDevice device = findDevice(deviceID);
        devices.remove(device);
    }

    /**
     * Finds a device by ID and returns the matching object.
     * This method is reused by other manager operations so
     * all lookup rules stay in one place.
     */
    public smartDevice findDevice(String deviceID) {
        validateDeviceID(deviceID);

        for (smartDevice device : devices) {
            if (device.getDeviceID().equalsIgnoreCase(deviceID)) {
                return device;
            }
        }

        throw new DeviceNotFoundException("No device found with ID " + deviceID + ".");
    }

    // Convenience check for code that only needs to know whether an ID exists.
    public boolean hasDevice(String deviceID) {
        validateDeviceID(deviceID);

        for (smartDevice device : devices) {
            if (device.getDeviceID().equalsIgnoreCase(deviceID)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Displays the status of every registered device.
     * Each concrete device decides what its own status
     * output looks like through its overridden method.
     */
    public void displayAllStatuses() {
        if (devices.isEmpty()) {
            System.out.println("No devices are currently registered.");
            return;
        }

        for (smartDevice device : devices) {
            System.out.println("Device ID: " + device.getDeviceID());
            System.out.println("Name: " + device.getName());
            device.displayStatus();
            System.out.println();
        }
    }

    /**
     * Turns on a device only if it supports the Controllable interface.
     * This keeps the manager flexible because not every smart device
     * must have on/off behavior.
     */
    public void turnOnDevice(String deviceID) {
        smartDevice device = findDevice(deviceID);

        if (!(device instanceof Controllable)) {
            throw new UnsupportedDeviceOperationException(
                device.getName() + " does not support power controls."
            );
        }

        ((Controllable) device).turnOn();
    }

    // Same interface-based control pattern as turnOnDevice.
    public void turnOffDevice(String deviceID) {
        smartDevice device = findDevice(deviceID);

        if (!(device instanceof Controllable)) {
            throw new UnsupportedDeviceOperationException(
                device.getName() + " does not support power controls."
            );
        }

        ((Controllable) device).turnOff();
    }

    // Returns a read-only view so outside code cannot modify the internal list directly.
    public List<smartDevice> getDevices() {
        return Collections.unmodifiableList(devices);
    }

    // Useful for summary output or quick validation in main().
    public int getDeviceCount() {
        return devices.size();
    }

    // Shared validation for all methods that accept a device ID string.
    private void validateDeviceID(String deviceID) {
        if (deviceID == null || deviceID.trim().isEmpty()) {
            throw new IllegalArgumentException("Device ID cannot be empty.");
        }
    }

    // Thrown when code tries to access a device that is not registered.
    public static class DeviceNotFoundException extends RuntimeException {
        public DeviceNotFoundException(String message) {
            super(message);
        }
    }

    // Thrown when code tries to add a second device with the same ID.
    public static class DuplicateDeviceException extends RuntimeException {
        public DuplicateDeviceException(String message) {
            super(message);
        }
    }

    // Thrown when a device exists, but does not support the requested control action.
    public static class UnsupportedDeviceOperationException extends RuntimeException {
        public UnsupportedDeviceOperationException(String message) {
            super(message);
        }
    }
}
