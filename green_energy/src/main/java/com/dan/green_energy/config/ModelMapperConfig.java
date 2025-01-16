package com.dan.green_energy.config;

import com.dan.green_energy.enums.GreenEnergySource;
import com.dan.green_energy.model.dto.MainTypeDTO;
import com.dan.green_energy.model.entity.MainType;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {

        return  new ModelMapper();
    }
}
