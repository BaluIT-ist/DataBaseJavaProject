package com.dan.green_energy.model.dto;

import com.dan.green_energy.enums.GreenEnergySource;
import lombok.Builder;
import lombok.Data;

@Data
public class MainTypeDTO {
    private GreenEnergySource mainType;
    private Integer mainTypeID;
}
