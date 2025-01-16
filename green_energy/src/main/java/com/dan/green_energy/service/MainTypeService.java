package com.dan.green_energy.service;

import com.dan.green_energy.enums.GreenEnergySource;
import com.dan.green_energy.exceptions.BaluException;
import com.dan.green_energy.model.dto.MainTypeDTO;
import com.dan.green_energy.model.entity.MainType;
import com.dan.green_energy.model.repository.MainTypeRepository;
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
public class MainTypeService {
    static final Logger logger = LoggerFactory.getLogger(MainTypeService.class);

    private MainTypeRepository mainTypeRepository;
    private ModelMapper modelMapper;

    @Autowired
    public MainTypeService(MainTypeRepository mainTypeRepository,ModelMapper modelMapper){
        this.mainTypeRepository=mainTypeRepository;
        this.modelMapper=modelMapper;
    }

    public List<MainTypeDTO> getAllMainTypes(){
        return mainTypeRepository.findAll().stream()
                .map(maintype-> {
                    MainTypeDTO mainTypeDTO = modelMapper.map(maintype,MainTypeDTO.class);
                    mainTypeDTO.setMainType(GreenEnergySource.fromValue(maintype.getMainType()));
                    return mainTypeDTO;
                })
                .collect(Collectors.toList());
    }

    public MainTypeDTO createMainType(MainTypeDTO mainTypeDTO)throws BaluException{
        MainType mainType = modelMapper.map(mainTypeDTO,MainType.class);
        mainType.setMainType(mainTypeDTO.getMainType().getValue());
        try{
            mainType=mainTypeRepository.save(mainType);
        }
        catch (Exception e){
            logger.warn("The object you wanted to create was not saved succesfully");
            throw new BaluException("Nu merge boss",e);
        }
        MainTypeDTO newMainTypeDTO=modelMapper.map(mainType,MainTypeDTO.class);
        newMainTypeDTO.setMainType(GreenEnergySource.fromValue(mainType.getMainType()));
        return newMainTypeDTO;
    }

    public MainTypeDTO updateMainType(Integer id,MainTypeDTO mainTypeDTO) {
        MainType existingMainType=mainTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't find the next id:"+ id));
        modelMapper.map(mainTypeDTO,existingMainType);
        existingMainType.setMainType(mainTypeDTO.getMainType().getValue());
        existingMainType=mainTypeRepository.save(existingMainType);

        MainTypeDTO existingMainTypeDTO=modelMapper.map(existingMainType,MainTypeDTO.class);
        existingMainTypeDTO.setMainType(GreenEnergySource.fromValue(existingMainType.getMainType()));
        return existingMainTypeDTO;

    }

    public void deleteMainType(Integer id) {
        MainType mainType=mainTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't find the next id:"+id));
        mainTypeRepository.delete(mainType);
    }

}