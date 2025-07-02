public class ColorHSB {

    private final int hue;        // 0 to 359
    private final int saturation; // 0 to 100
    private final int brightness; // 0 to 100

    // Constructor
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359)
            throw new IllegalArgumentException("Hue must be between 0 and 359");
        if (s < 0 || s > 100)
            throw new IllegalArgumentException("Saturation must be between 0 and 100");
        if (b < 0 || b > 100)
            throw new IllegalArgumentException("Brightness must be between 0 and 100");
        hue = h;
        saturation = s;
        brightness = b;
    }

    // Getters
    public int getHue() {
        return hue;
    }

    public int getSaturation() {
        return saturation;
    }

    public int getBrightness() {
        return brightness;
    }

    // Is grayscale?
    public boolean isGrayscale() {
        return (saturation == 0 || brightness == 0);
    }

    // Distance squared between two colors
    public int distanceSquaredTo(ColorHSB that) {
        int hueDiff = Math.min(Math.abs(this.hue - that.hue), 360 - Math.abs(this.hue - that.hue));
        int satDiff = this.saturation - that.saturation;
        int briDiff = this.brightness - that.brightness;
        return hueDiff * hueDiff + satDiff * satDiff + briDiff * briDiff;
    }

    // String representation
    public String toString() {
        return "(" + hue + ", " + saturation + ", " + brightness + ")";
    }

    // Sample client
    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        ColorHSB color = new ColorHSB(h, s, b);
        System.out.println(color);
        System.out.println("Is grayscale? " + color.isGrayscale());
    }
}
