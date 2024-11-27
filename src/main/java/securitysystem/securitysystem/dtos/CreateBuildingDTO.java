package securitysystem.securitysystem.dtos;

import java.util.List;

public class CreateBuildingDTO {
    private String name;
    private String location;
    private List<Integer> floorsConfig;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Integer> getFloorsConfig() {
        return floorsConfig;
    }

    public void setFloorsConfig(List<Integer> floorsConfig) {
        this.floorsConfig = floorsConfig;
    }
}
