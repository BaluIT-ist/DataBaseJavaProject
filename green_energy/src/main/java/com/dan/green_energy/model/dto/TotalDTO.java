package com.dan.green_energy.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TotalDTO implements Serializable {
    private Integer totalProd;

    private Integer totalConsum;

    private Integer referencedYear;
}
