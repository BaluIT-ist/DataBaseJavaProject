package com.dan.green_energy.controller;

import com.dan.green_energy.exceptions.BaluException;
import com.dan.green_energy.model.dto.GreenEnergyDTO;
import com.dan.green_energy.service.GreenEnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/green-energy")
public class GreenEnergyController {

    private final GreenEnergyService greenEnergyService;
    @Autowired
    public GreenEnergyController(GreenEnergyService greenEnergyService) {
        this.greenEnergyService=greenEnergyService;
    }

    @GetMapping
    public List<GreenEnergyDTO> getAllGreenEnergy(){
        return greenEnergyService.getAllGreenEnergy();
    }

    @PostMapping
    public ResponseEntity.BodyBuilder createGreenEnergy(@RequestBody GreenEnergyDTO greenEnergyDTO) {
        try {
            GreenEnergyDTO createGreenEnergy = greenEnergyService.createGreenEnergy(greenEnergyDTO);
        } catch (BaluException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.CREATED);

    }
    @PutMapping("/{id}")
    public ResponseEntity<GreenEnergyDTO> updateGreenEnergy(@PathVariable Integer id,@RequestBody GreenEnergyDTO greenEnergyDTO){
        GreenEnergyDTO updateGreenEnergy=greenEnergyService.updateGreenEnergy(id,greenEnergyDTO);
        return ResponseEntity.ok(updateGreenEnergy);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGreenEnergy(@PathVariable Integer id){
        greenEnergyService.deleteGreenEnergy(id);
        return ResponseEntity.noContent().build();
    }
}
