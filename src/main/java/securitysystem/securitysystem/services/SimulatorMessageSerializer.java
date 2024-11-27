package securitysystem.securitysystem.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import securitysystem.securitysystem.dtos.BuildingDTO;
import securitysystem.securitysystem.mappers.BuildingMapper;
import securitysystem.securitysystem.models.Building;
import securitysystem.securitysystem.logic.parameters.InputSimulatorMessage;

public class SimulatorMessageSerializer {
    private static final Gson gson = new Gson();
    static public String serializeInputSimulatorMessage(Building building) {
       return gson.toJson(BuildingMapper.toDTO(building), BuildingDTO.class);
    }

    static public InputSimulatorMessage deserializeInputSimulatorMessage(String message) {
            return gson.fromJson(message, InputSimulatorMessage.class);
    }
}
