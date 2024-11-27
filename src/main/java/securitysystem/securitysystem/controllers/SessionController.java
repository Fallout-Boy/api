package securitysystem.securitysystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import securitysystem.securitysystem.dtos.BuildingDTO;
import securitysystem.securitysystem.dtos.SimulatorMessageDTO;
import securitysystem.securitysystem.dtos.ViolationDTO;
import securitysystem.securitysystem.mappers.BuildingMapper;
import securitysystem.securitysystem.mappers.SimulatorMessageMapper;
import securitysystem.securitysystem.mappers.ViolationMapper;
import securitysystem.securitysystem.models.Building;
import securitysystem.securitysystem.models.SimulatorMessage;
import securitysystem.securitysystem.models.Violation;
import securitysystem.securitysystem.models.ViolationType;
import securitysystem.securitysystem.repositories.BuildingRepository;
import securitysystem.securitysystem.repositories.SimulatorMessageRepository;
import securitysystem.securitysystem.repositories.ViolationRepository;
import securitysystem.securitysystem.wrappers.building.BuildingWrapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/sessions")
public class SessionController extends ApplicationController {
    private final BuildingRepository buildingRepository;
    private final ViolationRepository violationRepository;
    private final SimulatorMessageRepository simulatorMessageRepository;

    @Autowired
    public SessionController(BuildingRepository buildingRepository, ViolationRepository violationRepository,
                             SimulatorMessageRepository simulatorMessageRepository) {
        this.buildingRepository = buildingRepository;
        this.violationRepository = violationRepository;
        this.simulatorMessageRepository = simulatorMessageRepository;
    }

    @GetMapping("/current-house")
    public ResponseEntity<BuildingDTO> getCurrentHouse() {
        BuildingWrapper buildingWrapper = BuildingWrapper.getInstance();
        if (buildingWrapper != null && buildingWrapper.getBuilding() != null) {
            return ResponseEntity.ok(BuildingMapper.toDTO(buildingWrapper.getBuilding()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("/current-house")
    public ResponseEntity<BuildingDTO> setCurrentHouse(@RequestParam Long house) {
        Optional<Building> optionalBuilding = buildingRepository.findById(house);
        if (optionalBuilding.isPresent()) {
            Building b = optionalBuilding.get();
            if (b.getId().equals(house)) {
                BuildingWrapper.setInstance(b);
                return ResponseEntity.ok(BuildingMapper.toDTO(BuildingWrapper.getInstance().getBuilding()));
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/logs")
    public ResponseEntity<Map<String, List<?>>> getLogs() {
        Building building = BuildingWrapper.getInstance().getBuilding();

        if (building == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Long buildingId = building.getId();


        List<Violation> violations = violationRepository.findAll().stream()
                .filter(v ->
                        v.getBuilding() != null &&
                        v.getBuilding().getId().equals(buildingId))
                .collect(Collectors.toList());

        List<SimulatorMessage> simulatorMessages = simulatorMessageRepository.findAll().stream()
                .filter(sm -> sm.getBuilding() != null &&
                        sm.getBuilding().getId().equals(buildingId)
                ).collect(Collectors.toList());

        List<ViolationDTO> violationDTOs = violations.stream()
                .map(ViolationMapper::toDTO)
                .collect(Collectors.toList());

        List<SimulatorMessageDTO> simulatorMessageDTOs = simulatorMessages.stream()
                .map(SimulatorMessageMapper::toDTO)
                .collect(Collectors.toList());


        Map<String, List<?>> response = new HashMap<>();
        response.put("violations", violationDTOs);
        response.put("simulatorMessages", simulatorMessageDTOs);

        return ResponseEntity.ok(response);
    }


    @PutMapping("/current-house-stats")
    public ResponseEntity<String> setCurrentHouseStats() {
        Building building = BuildingWrapper.getInstance().getBuilding();
        if (building == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Building not set");
        }
        building.getFloors().stream()
                .flatMap(floor -> floor.getRooms().stream())
                .forEach(room -> {

                    room.setCurrentTemperature(room.getCurrentTemperature() + 10);
                    room.setCurrentSmokeLevel(room.getCurrentSmokeLevel() + 10);
                    room.setSensitivityLevel(room.getSensitivityLevel() + 10);
                });
        buildingRepository.save(building);

        return ResponseEntity.ok("Room parameters updated successfully");
    }
}
