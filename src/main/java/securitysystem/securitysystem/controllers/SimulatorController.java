package securitysystem.securitysystem.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import securitysystem.securitysystem.services.Simulator.SimulatorProducerService;


// TODO: destroy later
//@RestController
//@RequestMapping("/api/v1/simulator")
//public class SimulatorController {
//
//    private final SimulatorProducerService simulatorService;
//
//    public SimulatorController(SimulatorProducerService simulatorService) {
//        this.simulatorService = simulatorService;
//    }
//
//    @PostMapping("/start")
//    public ResponseEntity<String> startSimulator() {
////        simulatorService.start();
//        return ResponseEntity.ok("Simulator started");
//    }
//}