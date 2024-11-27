package securitysystem.securitysystem.mappers;

import securitysystem.securitysystem.dtos.SimulatorMessageDTO;
import securitysystem.securitysystem.models.SimulatorMessage;

public class SimulatorMessageMapper {

    public static SimulatorMessageDTO toDTO(SimulatorMessage simulatorMessage) {
        if (simulatorMessage == null) {
            return null;
        }

        SimulatorMessageDTO dto = new SimulatorMessageDTO();
        dto.setId(simulatorMessage.getId());
        dto.setRoomId(simulatorMessage.getRoom_id());
        dto.setDeltaTemperature(simulatorMessage.getDeltaTemperature());
        dto.setDeltaSmokePercent(simulatorMessage.getDeltaSmokePercent());
        dto.setMovementLevelChanges(simulatorMessage.getMovementLevelChanges());
        dto.setTimestamp(simulatorMessage.getTimestamp());

        return dto;
    }
}
