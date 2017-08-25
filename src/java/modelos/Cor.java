package modelos;

public class Cor {

    private double r, g, b;

    public Cor(double r, double g, double b) {
        this.r = r;
        this.g = g;
        this.b = b;
        preservaCoresDentroDosLimites();
    }

    public void incR(double delta) {
        r += delta;
        preservaCoresDentroDosLimites();
    }

    public void decB(double delta) {
        b -= delta;
        preservaCoresDentroDosLimites();
    }

    private void preservaCoresDentroDosLimites() {
        if (r < 0) {
            r = 0;
        } else if (r > 255) {
            r = 255;
        }

        if (g < 0) {
            g = 0;
        } else if (g > 255) {
            g = 255;
        }

        if (b < 0) {
            b = 0;
        } else if (b > 255) {
            b = 255;
        }
    }

    @Override
    public String toString() {
        return String.format("#%02x%02x%02x", (int) r, (int) g, (int) b);
    }

}
