package com.dan.green_energy.controller;

import com.dan.green_energy.exceptions.BaluException;
import com.dan.green_energy.model.dto.TotalDTO;
import com.dan.green_energy.service.TotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/total")
public class TotalController {

    private final TotalService totalService;
    @Autowired
    public TotalController(TotalService totalService) {
        this.totalService=totalService;
    }

    @GetMapping
    public List<TotalDTO> getAllTotal(){
        return totalService.getAllTotal();
    }

    @PostMapping
    public ResponseEntity.BodyBuilder createTotal(@RequestBody TotalDTO totalDTO) {
        try {
            TotalDTO createTotal = totalService.createTotal(totalDTO);
        } catch (BaluException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<TotalDTO> updateTotal(@PathVariable Integer id,@RequestBody TotalDTO totalDTO){
        TotalDTO updateTotal=totalService.updateTotal(id,totalDTO);
        return ResponseEntity.ok(updateTotal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTotal(@PathVariable Integer id){
        totalService.deleteTotal(id);
        return ResponseEntity.noContent().build();
    }
}
