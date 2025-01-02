package com.dan.green_energy.service;

import com.dan.green_energy.exceptions.BaluException;
import com.dan.green_energy.model.dto.MainTypeDTO;
import com.dan.green_energy.model.dto.TotalDTO;
import com.dan.green_energy.model.entity.MainType;
import com.dan.green_energy.model.entity.Total;
import com.dan.green_energy.model.repository.MainTypeRepository;
import com.dan.green_energy.model.repository.TotalRepository;
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
public class TotalService {
    static final Logger logger = LoggerFactory.getLogger(TotalRepository.class);

    private TotalRepository totalRepository;
    private ModelMapper modelMapper;

    @Autowired
    public TotalService(TotalRepository totalRepository,ModelMapper modelMapper){
        this.totalRepository=totalRepository;
        this.modelMapper=modelMapper;
    }

    public List<TotalDTO> getAllTotal(){
        return totalRepository.findAll().stream()
                .map(total-> modelMapper.map(total,TotalDTO.class))
                .collect(Collectors.toList());
    }

    public TotalDTO createTotal(TotalDTO totalDTO)throws BaluException {
        Total total = modelMapper.map(totalDTO,Total.class);
        try{
            total=totalRepository.save(total);
        }
        catch (Exception e){
            logger.warn("The object you wanted to create was not saved succesfully");
            throw new BaluException("Nu merge boss",e);
        }
        return modelMapper.map(total,TotalDTO.class);
    }

    public TotalDTO updateTotal(Integer id,TotalDTO totalDTO) throws BaluException {
        Total existingTotal=totalRepository.findById(id)
                .orElseThrow(() -> new BaluException("Couldn't find the next id:"+ id));
        modelMapper.map(totalDTO,existingTotal);
        existingTotal=totalRepository.save(existingTotal);
        return modelMapper.map(existingTotal,TotalDTO.class);

    }
}
