//This class is to extend to specific Smart Devices.
public abstract class smartDevice {

    private String deviceID;
    private String name;

    /**
    * Constructor for all Smart Device subclasses,
    * Sets name and serial number ot class that calls.
    */
    public smartDevice(String deviceID, String name) {
        this.deviceID = deviceID;
        this.name = name;
    }

    //Returns serial number
    public String getDeviceID() {
        return deviceID;
    }

    //Returns device name
    public String getName() {
        return name;
    }

    /**
     * Return current status of device,
     * Lights on or off
     * Thermostat current temp
     * DoorLock on or off
     */
    public abstract void displayStatus();
}