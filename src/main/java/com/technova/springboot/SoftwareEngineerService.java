package com.technova.springboot;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(id + " not found"));
    }

    public SoftwareEngineer updateSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        // Optionally: validate entity exists before saving
        if (!softwareEngineerRepository.existsById(softwareEngineer.getId())) {
            throw new EntityNotFoundException("Software Engineer not found with id " + softwareEngineer.getId());
        }
        return softwareEngineerRepository.save(softwareEngineer);
    }
}
