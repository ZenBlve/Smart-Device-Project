# Smart Home Automation System

## Files

### `smartDevice.java`

This file defines the abstract base class for all smart devices.

Current responsibilities:
- stores each device's `deviceID`
- stores each device's `name`
- provides getters for shared device information
- declares the abstract `displayStatus()` method that all device subclasses must implement

### `Controllable.java`

This file defines the `Controllable` interface.

Current responsibilities:
- requires implementing classes to define `turnOn()`
- requires implementing classes to define `turnOff()`

This interface is intended for devices that support basic power or state control.

### `SmartHomeManager.java`

This file defines the manager class for the smart home system.

Current responsibilities:
- stores devices polymorphically in a `List<smartDevice>`
- adds devices to the system
- removes devices from the system
- looks up devices by ID
- displays the status of all registered devices
- turns devices on and off when they implement `Controllable`
- prevents duplicate device IDs
- throws custom exceptions for invalid operations

Custom exceptions currently included in the manager:
- `DeviceNotFoundException`
- `DuplicateDeviceException`
- `UnsupportedDeviceOperationException`

## Current Design

The project currently uses these object-oriented design features:
- abstraction through the `smartDevice` abstract class
- polymorphism through storing all devices as `smartDevice` references
- an interface through `Controllable`
- encapsulation through private fields and public getters
- custom exceptions through the manager class
