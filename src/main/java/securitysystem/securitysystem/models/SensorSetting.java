package securitysystem.securitysystem.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sensorsetting", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"maxTemperature", "movementAllowedLevel", "maxSmokeLevel"})
})
public class SensorSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double maxTemperature;

    @Column(nullable = false)
    private double movementAllowedLevel;

    @Column(nullable = false)
    private int maxSmokeLevel;


    // Конструктор за замовчуванням
    public SensorSetting() {
        this.maxTemperature = Double.MAX_VALUE;
        this.movementAllowedLevel = Double.MAX_VALUE;
        this.maxSmokeLevel = Integer.MAX_VALUE;
    }

    // Конструктор з параметрами
    public SensorSetting(double maxTemperature, double movementAllowedLevel, int maxSmokeLevel) {
        this.maxTemperature = maxTemperature;
        this.movementAllowedLevel = movementAllowedLevel;
        this.maxSmokeLevel = maxSmokeLevel;
    }

    // Геттери та сеттери
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getMovementAllowedLevel() {
        return movementAllowedLevel;
    }

    public void setMovementAllowedLevel(double movementAllowedLevel) {
        this.movementAllowedLevel = movementAllowedLevel;
    }

    public int getMaxSmokeLevel() {
        return maxSmokeLevel;
    }

    public void setMaxSmokeLevel(int maxSmokeLevel) {
        this.maxSmokeLevel = maxSmokeLevel;
    }



    @Override
    public String toString() {
        return "SensorSetting{" +
                "id=" + id +
                ", maxTemperature=" + maxTemperature +
                ", movementAllowedLevel=" + movementAllowedLevel +
                ", maxSmokeLevel=" + maxSmokeLevel +
                '}';
    }
}
