package com.dan.green_energy.service;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.dan.green_energy.exceptions.BaluException;
import com.dan.green_energy.model.dto.GreenEnergyDTO;
import com.dan.green_energy.model.dto.MainTypeDTO;
import com.dan.green_energy.model.entity.GreenEnergy;
import com.dan.green_energy.model.entity.MainType;
import com.dan.green_energy.model.repository.GreenEnergyRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
                .map(greenEnergy-> modelMapper.map(greenEnergy, GreenEnergyDTO.class))
                .collect(Collectors.toList());
    }
    public GreenEnergyDTO createGreenEnergy(GreenEnergyDTO greenEnergyDTO) throws BaluException{
        GreenEnergy greenEnergy=modelMapper.map(greenEnergyDTO,GreenEnergy.class);
        try{
            greenEnergy=greenEnergyRepository.save(greenEnergy);
        }
        catch (Exception e){
            logger.warn("The object you wanted to create was not saved succesfully");
            throw new BaluException("Nu merge boss",e);
        }
        return modelMapper.map(greenEnergy,GreenEnergyDTO.class);
    }

    public MainTypeDTO updateMainType(int id, GreenEnergyDTO greenEnergyDTO) throws BaluException {
        GreenEnergy existingGreenEnergy=greenEnergyRepository.findById(id)
                .orElseThrow(() -> new BaluException("Couldn't find the next id:"+ id));
        modelMapper.map(greenEnergyDTO,existingGreenEnergy);
        existingGreenEnergy=greenEnergyRepository.save(existingGreenEnergy);
        return modelMapper.map(existingGreenEnergy,MainTypeDTO.class);

    }
    public void deleteMainType(int id) throws BaluException {
        GreenEnergy greenEnergy=greenEnergyRepository.findById(id)
                .orElseThrow(() -> new BaluException("Couldn't find the next id:"+id));
        greenEnergyRepository.delete(greenEnergy);
    }
}
