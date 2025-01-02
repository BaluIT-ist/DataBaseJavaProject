package com.dan.green_energy.service;

import com.dan.green_energy.exceptions.BaluException;
import com.dan.green_energy.model.dto.MainTypeDTO;
import com.dan.green_energy.model.dto.TotalGreenEnergyDTO;
import com.dan.green_energy.model.entity.MainType;
import com.dan.green_energy.model.entity.TotalGreenEnergy;
import com.dan.green_energy.model.entity.id.TotalGreenEnergyID;
import com.dan.green_energy.model.repository.MainTypeRepository;
import com.dan.green_energy.model.repository.TotalGreenEnergyRepository;
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
public class TotalGreenEnergyService {
    static final Logger logger = LoggerFactory.getLogger(TotalGreenEnergyDTO.class);

    private TotalGreenEnergyRepository totalGreenEnergyRepository;
    private ModelMapper modelMapper;

    @Autowired
    public TotalGreenEnergyService(TotalGreenEnergyRepository totalGreenEnergy, ModelMapper modelMapper){
        this.totalGreenEnergyRepository=totalGreenEnergy;
        this.modelMapper=modelMapper;
    }
    public List<TotalGreenEnergyDTO> getAllTotalGreenEnergy(){
        return totalGreenEnergyRepository.findAll().stream()
                .map(totalGreenEnergy-> modelMapper.map(totalGreenEnergy,TotalGreenEnergyDTO.class))
                .collect(Collectors.toList());
    }

    public TotalGreenEnergyDTO createTotalGreenEnergy(TotalGreenEnergyDTO totalGreenEnergyDTO)throws BaluException {
        TotalGreenEnergy totalGreenEnergy = modelMapper.map(totalGreenEnergyDTO,TotalGreenEnergy.class);
        try{
            totalGreenEnergy=totalGreenEnergyRepository.save(totalGreenEnergy);
        }
        catch (Exception e){
            logger.warn("The object you wanted to create was not saved succesfully");
            throw new BaluException("Nu merge boss",e);
        }
        return modelMapper.map(totalGreenEnergy,TotalGreenEnergyDTO.class);
    }
    public TotalGreenEnergyDTO updateTotalGreenEnergy(Integer greenEnergyID,Integer referencedYearID,TotalGreenEnergyDTO totalGreenEnergyDTO) throws BaluException {
        TotalGreenEnergyID totalGreenEnergyID=new TotalGreenEnergyID();
        totalGreenEnergyID.setGreenEnergyID(greenEnergyID);
        totalGreenEnergyID.setReferencedYearID(referencedYearID);

        TotalGreenEnergy existingTotalGreenEnergy=totalGreenEnergyRepository.findById(totalGreenEnergyID)
                .orElseThrow(() -> new BaluException("Couldn't find the next id:"+ totalGreenEnergyID));
        modelMapper.map(totalGreenEnergyDTO,existingTotalGreenEnergy);
        existingTotalGreenEnergy=totalGreenEnergyRepository.save(existingTotalGreenEnergy);
        return modelMapper.map(existingTotalGreenEnergy,TotalGreenEnergyDTO.class);

    }
}