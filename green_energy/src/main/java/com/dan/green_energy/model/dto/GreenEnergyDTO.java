package com.dan.green_energy.model.dto;

import com.dan.green_energy.enums.RomanianCounty;
import com.dan.green_energy.model.entity.MainType;
import lombok.Data;

import java.io.Serializable;

@Data
public class GreenEnergyDTO implements Serializable {

    private int id;

    private MainType mainTypeID;

    private int consum;

    private int prod;

    private RomanianCounty county;
}
