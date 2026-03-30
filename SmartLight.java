/**
 * Represents a smart light bulb.
 * Supports basic on/off control through the Controllable interface
 * and can also have its brightness adjusted.
 */
public class SmartLight extends smartDevice implements Controllable {

    private boolean isOn;
    private int brightness; // 0-100

    public SmartLight(String deviceID, String name, int brightness) {
        super(deviceID, name);
        if (brightness < 0 || brightness > 100) {
            throw new IllegalArgumentException("Brightness must be between 0 and 100.");
        }
        this.isOn = false;
        this.brightness = brightness;
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println(getName() + " light turned ON.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println(getName() + " light turned OFF.");
    }

    public void setBrightness(int brightness) {
        if (brightness < 0 || brightness > 100) {
            throw new IllegalArgumentException("Brightness must be between 0 and 100.");
        }
        this.brightness = brightness;
        System.out.println(getName() + " brightness set to " + brightness + "%.");
    }

    public int getBrightness() {
        return brightness;
    }

    public boolean isOn() {
        return isOn;
    }

    @Override
    public void displayStatus() {
        System.out.println("  Status    : " + (isOn ? "ON" : "OFF"));
        System.out.println("  Brightness: " + brightness + "%");
    }
}
