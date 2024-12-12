package champollion;

public class ServicePrevu {
    protected double volumeTD;
    protected double volumeTP;
    protected double volumeCM;

    public ServicePrevu(double volumeCM, double volumeTD, double volumeTP) {
        this.volumeTD = volumeTD;
        this.volumeTP = volumeTP;
        this.volumeCM = volumeCM;
    }
}
