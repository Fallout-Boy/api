package securitysystem.securitysystem.dtos.KafkaSchema;

public class SensorDTO {
    private Long sensorId;
    private String sensorType;
    private double sensorValue;
    private ThresholdsDTO thresholds;
    private String status;

    public SensorDTO() {}

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    public double getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(double sensorValue) {
        this.sensorValue = sensorValue;
    }

    public ThresholdsDTO getThresholds() {
        return thresholds;
    }

    public void setThresholds(ThresholdsDTO thresholds) {
        this.thresholds = thresholds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
