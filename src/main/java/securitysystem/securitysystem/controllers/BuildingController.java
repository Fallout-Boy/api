package securitysystem.securitysystem.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import securitysystem.securitysystem.dtos.BuildingDTO;
import securitysystem.securitysystem.dtos.CreateBuildingDTO;
import securitysystem.securitysystem.logic.BuildingGenerator.SecondConfigurationFloorBuilder;
import securitysystem.securitysystem.mappers.BuildingMapper;
import securitysystem.securitysystem.models.Sensor;
import securitysystem.securitysystem.models.SensorSetting;
import securitysystem.securitysystem.models.SensorStatus;
import securitysystem.securitysystem.repositories.ISensorSettingRepository;
import securitysystem.securitysystem.services.BuildingService;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/buildings")
public class BuildingController extends ApplicationController {

    private final BuildingService buildingService;
    private final ISensorSettingRepository sensorSettingRepository;

    @Autowired
    public BuildingController(BuildingService buildingService,
                              ISensorSettingRepository sensorSettingRepository) {
        this.buildingService = buildingService;
        this.sensorSettingRepository = sensorSettingRepository;
    }


    @PostMapping("/generate_many_floors")
    public BuildingDTO generateManyFloorBuilding(@RequestBody CreateBuildingDTO buildingRequest) {
        return buildingService.generateManyFloorBuilding(
                buildingRequest.getName(),
                buildingRequest.getLocation(),
                buildingRequest.getFloorsConfig()
        );
    }

    @GetMapping
    public List<BuildingDTO> getAllBuildings() {
        return buildingService.getAllBuildings();
    }

    @PostMapping("/set_sensors")
    public BuildingDTO setSensors(@RequestParam String simulatorTypesStr) {
        Gson gson = new Gson();

        Type mapType = new TypeToken<Map<Long, List<Long>>>(){}.getType();

        Map<Long, List<Long>> simulatorTypesMap = gson.fromJson(simulatorTypesStr, mapType);
        buildingService.setTriggers(simulatorTypesMap);

        return BuildingMapper.toDTO(buildingService.getBuilding());

    }
}