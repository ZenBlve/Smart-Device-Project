/**
 * Represents a smart door lock.
 * Implements Controllable where turnOn() means lock and turnOff() means unlock.
 * Also tracks the number of failed unlock attempts for security purposes.
 */
public class DoorLock extends smartDevice implements Controllable {

    private boolean isLocked;
    private int failedAttempts;
    private static final int MAX_FAILED_ATTEMPTS = 3;

    public DoorLock(String deviceID, String name) {
        super(deviceID, name);
        this.isLocked = true; // locked by default
        this.failedAttempts = 0;
    }

    /** turnOn = lock the door. */
    @Override
    public void turnOn() {
        isLocked = true;
        System.out.println(getName() + " is now LOCKED.");
    }

    /** turnOff = unlock the door. */
    @Override
    public void turnOff() {
        if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
            throw new IllegalStateException(
                getName() + " is disabled due to too many failed attempts."
            );
        }
        isLocked = false;
        System.out.println(getName() + " is now UNLOCKED.");
    }

    public void recordFailedAttempt() {
        failedAttempts++;
        System.out.println(getName() + " — failed attempt #" + failedAttempts + ".");
    }

    public boolean isLocked() {
        return isLocked;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    @Override
    public void displayStatus() {
        System.out.println("  Status         : " + (isLocked ? "LOCKED" : "UNLOCKED"));
        System.out.println("  Failed Attempts: " + failedAttempts);
    }
}
