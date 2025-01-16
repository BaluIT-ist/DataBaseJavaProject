package com.dan.green_energy.controller;

import com.dan.green_energy.model.dto.TotalGreenEnergyDTO;
import com.dan.green_energy.service.TotalGreenEnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/total-green-energy")
public class TotalGreenEnergyController {
    private final TotalGreenEnergyService totalGreenEnergyService;

    @Autowired
    public TotalGreenEnergyController(TotalGreenEnergyService totalGreenEnergyService) {
        this.totalGreenEnergyService = totalGreenEnergyService;
    }

    @GetMapping
    public List<TotalGreenEnergyDTO> getAllTotalGreenEnergy() {
        return totalGreenEnergyService.getAllTotalGreenEnergy();
    }

    @PostMapping
    public ResponseEntity.BodyBuilder createTotalGreenEnergy(@RequestBody TotalGreenEnergyDTO totalGreenEnergyDTO) {
        TotalGreenEnergyDTO createTotalGreenEnergy = totalGreenEnergyService.createTotalGreenEnergy(totalGreenEnergyDTO);
        return ResponseEntity.status(HttpStatus.CREATED);

    }
    @PutMapping("/{id}/{id2}")
    public ResponseEntity<TotalGreenEnergyDTO> updateTotalGreenEnergy(@PathVariable Integer id,@PathVariable Integer id2,@RequestBody TotalGreenEnergyDTO totalGreenEnergyDTO){
        TotalGreenEnergyDTO updateTotalGreenEnergy=totalGreenEnergyService.updateTotalGreenEnergy(id,id2,totalGreenEnergyDTO);
        return ResponseEntity.ok(updateTotalGreenEnergy);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTotalGreenEnergy(@PathVariable Integer id,Integer id2){
        totalGreenEnergyService.deleteTotalGreenEnergy(id,id2);
        return ResponseEntity.noContent().build();
    }
}
