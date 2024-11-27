package securitysystem.securitysystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import securitysystem.securitysystem.logic.BuildingGenerator.BuildingBuilder;
import securitysystem.securitysystem.logic.BuildingGenerator.ManyFloorBuilder;
//import securitysystem.securitysystem.logic.BuildingGenerator.OneFloorBuilder;
import securitysystem.securitysystem.dtos.BuildingDTO;
import securitysystem.securitysystem.mappers.BuildingMapper;
import securitysystem.securitysystem.models.Building;
import securitysystem.securitysystem.models.Room;
import securitysystem.securitysystem.models.Sensor;
import securitysystem.securitysystem.models.SensorStatus;
import securitysystem.securitysystem.repositories.BuildingRepository;
import securitysystem.securitysystem.repositories.IRoomRepository;
import securitysystem.securitysystem.repositories.ISensorSettingRepository;
import securitysystem.securitysystem.wrappers.room.IRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;
    private final IRoomRepository roomRepository;
    private final ISensorSettingRepository sensorSettingRepository;
    private  BuildingBuilder buildingBuilder;
    @Autowired
    public BuildingService(BuildingRepository buildingRepository,
                           IRoomRepository roomRepository,
                           ISensorSettingRepository sensorSettingRepository) {
        this.buildingRepository = buildingRepository;
        this.roomRepository = roomRepository;
        this.sensorSettingRepository = sensorSettingRepository;

    }

    public Building getBuilding() {
       return buildingRepository.findById(buildingBuilder.getBuilding().getId()).get();
    }
    public BuildingDTO generateManyFloorBuilding(String name, String location,List<Integer> config) {
        buildingBuilder = new ManyFloorBuilder();
        Building b = buildingBuilder
                .setName(name)
                .setLocation(location)
                .setNumberOfFloors( config )
                .createFloorsAndRooms()
                .build();
        buildingRepository.save(b);
        return BuildingMapper.toDTO(b);
    }

    public void setTriggers(Map<Long, List<Long>> sensors) {
        sensors.forEach((r_id, list) -> {
            Optional<Room> roomOpt = roomRepository.findById(r_id); // Використовуємо findById, щоб отримати повну сутність.
            if (roomOpt.isPresent()) {
                Room room = roomOpt.get();
                room.setSensors(new ArrayList<>());
                list.forEach(v -> {
                    Sensor sensor = new Sensor();
                    sensor.setStatus(SensorStatus.ACTIVE);
                    sensor.setRoom(room);
                    sensor.setSensorSetting(sensorSettingRepository.findById(v).get()); // Можна залишити getReferenceById для SensorSettings.
                    room.getSensors().add(sensor);
                });

                roomRepository.save(room);
            } else {

                System.out.println("Room with id " + r_id + " not found!");
            }
        });
    }


    public List<BuildingDTO> getAllBuildings() {
        return buildingRepository.findAll().stream().map(BuildingMapper::toDTO).collect(Collectors.toList());
    }
}