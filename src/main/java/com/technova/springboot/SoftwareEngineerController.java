package com.technova.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/software-engineers")
public class SoftwareEngineerController {

    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @GetMapping("{id}")
    public SoftwareEngineer getEngineerById(
            @PathVariable Integer id
    ) {
        return softwareEngineerService.getSoftwareEngineerById(id);
    }

    @PostMapping
    public void addNewSoftwareEngineer(
            @RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    @PutMapping
    public ResponseEntity<SoftwareEngineer> updateSoftwareEngineer(
            @RequestBody SoftwareEngineer softwareEngineer
    ) {
        SoftwareEngineer updated = softwareEngineerService.updateSoftwareEngineer(softwareEngineer);
        return ResponseEntity.ok(updated);
    }
}
