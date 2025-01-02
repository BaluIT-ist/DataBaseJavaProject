package com.dan.green_energy.model.entity.id;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class TotalGreenEnergyID implements Serializable {
    private int greenEnergyID;
    private int referencedYearID;
}
