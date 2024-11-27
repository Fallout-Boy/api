package securitysystem.securitysystem.mappers;

import securitysystem.securitysystem.dtos.ViolationDTO;
import securitysystem.securitysystem.models.Violation;

public class ViolationMapper {

    public static ViolationDTO toDTO(Violation violation) {
        if (violation == null) {
            return null;
        }

        ViolationDTO dto = new ViolationDTO();
        dto.setId(violation.getId());
        dto.setType(violation.getType() != null ? violation.getType().toString() : null);
        dto.setLog(violation.getLog());
        dto.setTimestamp(violation.getTimestamp());
        dto.setSensorId(violation.getSensor() != null ? violation.getSensor().getId() : null);

        return dto;
    }
}
