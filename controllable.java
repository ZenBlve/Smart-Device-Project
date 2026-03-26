/**
 * This interface represents basic power controls.
 * 
 * Any smart device that turns on or off uses this
 * interface. Implementing classes need to define
 * what turnOn and turnOff should do.
 * 
 * (Example: Lights on and off, SmartLock on being 
 * locked while off is unlocked)
 */

public interface Controllable {
    void turnOn();
    void turnOff();
}