public class Clock {

    private int hours;   // 0 to 23
    private int minutes; // 0 to 59

    // Constructor
    public Clock(int h, int m) {
        if (h < 0 || h > 23)
            throw new IllegalArgumentException("Hours must be between 0 and 23");
        if (m < 0 || m > 59)
            throw new IllegalArgumentException("Minutes must be between 0 and 59");
        hours = h;
        minutes = m;
    }

    // Returns string representation in HH:MM
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    // Adds 1 minute
    public void tick() {
        minutes++;
        if (minutes == 60) {
            minutes = 0;
            hours++;
            if (hours == 24) {
                hours = 0;
            }
        }
    }

    // Adds delta minutes
    public void timeTo(int delta) {
        if (delta < 0)
            throw new IllegalArgumentException("Delta must be non-negative");
        int totalMinutes = hours * 60 + minutes + delta;
        totalMinutes %= 1440;
        hours = totalMinutes / 60;
        minutes = totalMinutes % 60;
    }

    // Sample client
    public static void main(String[] args) {
        Clock clock = new Clock(23, 59);
        System.out.println(clock);
        clock.tick();
        System.out.println(clock);
        clock.timeTo(62);
        System.out.println(clock);
    }
}
