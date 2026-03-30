public class Main {
  public static void main(String[] args) {
    SmartHomeManager manager = new SmartHomeManaer();

    DoorLock lock = new DoorLock("DL", "Door Lock");
    SmartLight light = new SmartLight("SL", "Light", 70);
    Thermostat thermostat = new Thermostat("TS", "Thermostat", 72);
    
    manager.addDevice(lock);
    manager.addDevice(light);
    manager.addDevice(thermostat);
    manager.displayAllStatuses();
    
    Controllable controllableDevice = light;
    controllableDevice.turnOn();
    
    try {
      manager.findDevice("N/A");
    } catch (SmartHomeManager.DeviceNotFoundExcption e) {
      System.out.println(e.getMessage());
    }
    
    try {
      manager.turnOnDevice("TS");
    } catch (SmartHomeManager.UnsupportedDeviceOperationException e) {
      System.out.println(e.getMessage());
    }
    
    manager.displayAllStatuses();
  }
}
