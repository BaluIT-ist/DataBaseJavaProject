package com.dan.green_energy.service;

import com.dan.green_energy.enums.RomanianCounty;
import com.dan.green_energy.exceptions.BaluException;
import com.dan.green_energy.model.dto.GreenEnergyDTO;
import com.dan.green_energy.model.entity.GreenEnergy;
import com.dan.green_energy.model.repository.GreenEnergyRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j

public class GreenEnergyService {
    static final Logger logger= LoggerFactory.getLogger(GreenEnergyService.class);

    private GreenEnergyRepository greenEnergyRepository;
    private ModelMapper modelMapper;

    @Autowired
    public GreenEnergyService(GreenEnergyRepository greenEnergyRepository,ModelMapper modelMapper) {
        this.greenEnergyRepository=greenEnergyRepository;
        this.modelMapper=modelMapper;

    }
    public List<GreenEnergyDTO> getAllGreenEnergy(){
        return greenEnergyRepository.findAll().stream()
                .map(greenEnergy-> {
                GreenEnergyDTO greenEnergyDTO = modelMapper.map(greenEnergy,GreenEnergyDTO.class);
                greenEnergyDTO.setCounty(RomanianCounty.fromValue(greenEnergy.getCounty()));
                return greenEnergyDTO;
                })
                .collect(Collectors.toList());
    }
    public GreenEnergyDTO createGreenEnergy(GreenEnergyDTO greenEnergyDTO) throws BaluException{
        GreenEnergy greenEnergy=modelMapper.map(greenEnergyDTO,GreenEnergy.class);
        greenEnergy.setCounty(greenEnergyDTO.getCounty().getValue());
        try{
            greenEnergy=greenEnergyRepository.save(greenEnergy);
        }
        catch (Exception e){
            logger.warn("The object you wanted to create was not saved succesfully");
            throw new BaluException("Nu merge boss",e);
        }
        GreenEnergyDTO newGreenEnergyDTO=modelMapper.map(greenEnergy,GreenEnergyDTO.class);
        newGreenEnergyDTO.setCounty(RomanianCounty.fromValue(greenEnergy.getCounty()));
        return newGreenEnergyDTO;
    }

    public GreenEnergyDTO updateGreenEnergy(int id, GreenEnergyDTO greenEnergyDTO){
        GreenEnergy existingGreenEnergy=greenEnergyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't find the next id:"+ id));
        modelMapper.map(greenEnergyDTO,existingGreenEnergy);
        existingGreenEnergy.setCounty(greenEnergyDTO.getCounty().getValue());
        existingGreenEnergy=greenEnergyRepository.save(existingGreenEnergy);

        GreenEnergyDTO existingGreenEnergyDTO=modelMapper.map(existingGreenEnergy,GreenEnergyDTO.class);
        existingGreenEnergyDTO.setCounty(RomanianCounty.fromValue(existingGreenEnergy.getCounty()));
        return existingGreenEnergyDTO;
    }
    public void deleteGreenEnergy(int id){
        GreenEnergy greenEnergy=greenEnergyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't find the next id:"+id));
        greenEnergyRepository.delete(greenEnergy);
    }
}
