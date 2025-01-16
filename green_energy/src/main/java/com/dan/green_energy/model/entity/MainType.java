package com.dan.green_energy.model.entity;

import com.dan.green_energy.enums.GreenEnergySource;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "main_type")
public class MainType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="main_typeid", nullable = false)
    private int mainTypeID;

    @Column(name="main_type", nullable = false)
    private int mainType;


}
