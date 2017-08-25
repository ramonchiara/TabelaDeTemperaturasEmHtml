package modelos;

public class TemperaturaC {

    private double c;

    public TemperaturaC(double c) {
        this.c = c;
    }

    public double getC() {
        return c;
    }

    public double getF() {
        return 9.0 / 5.0 * c + 32;
    }

}
