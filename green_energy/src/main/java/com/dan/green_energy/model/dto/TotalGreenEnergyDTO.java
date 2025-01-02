package com.dan.green_energy.model.dto;

import com.dan.green_energy.model.entity.GreenEnergy;
import com.dan.green_energy.model.entity.Total;
import lombok.Data;

import java.io.Serializable;

@Data
public class TotalGreenEnergyDTO implements Serializable {
    private Integer greenEnergyID;
    private Integer referencedYearID;
    private GreenEnergy greenEnergy;
    private Total referencedYear;

}

