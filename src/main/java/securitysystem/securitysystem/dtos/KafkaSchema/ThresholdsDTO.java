package securitysystem.securitysystem.dtos.KafkaSchema;

public class ThresholdsDTO {
    private double min;
    private double max;

    public ThresholdsDTO() {}

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }
}
