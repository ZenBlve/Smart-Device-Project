/**
 * Represents a smart thermostat.
 * Does NOT implement Controllable because a thermostat is always
 * "active" - it does not have a simple on/off state like a light.
 * Instead it exposes temperature-specific controls.
 */
public class Thermostat extends smartDevice {

    private double targetTemperature; // in Fahrenheit
    private double currentTemperature;

    public static final double MIN_TEMP = 50.0;
    public static final double MAX_TEMP = 90.0;

    public Thermostat(String deviceID, String name, double currentTemperature) {
        super(deviceID, name);
        this.currentTemperature = currentTemperature;
        this.targetTemperature = currentTemperature;
    }

    public void setTargetTemperature(double temp) {
        if (temp < MIN_TEMP || temp > MAX_TEMP) {
            throw new IllegalArgumentException(
                "Temperature must be between " + MIN_TEMP + "°F and " + MAX_TEMP + "°F."
            );
        }
        this.targetTemperature = temp;
        System.out.println(getName() + " target temperature set to " + temp + "°F.");
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    @Override
    public void displayStatus() {
        System.out.println("  Current Temp: " + currentTemperature + "°F");
        System.out.println("  Target Temp : " + targetTemperature + "°F");
    }
}
