package com.dan.green_energy.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "green_energy")
public class GreenEnergy {
    @Id
    @Column(name="ID")
    private int id;

    @ManyToOne
    @JoinColumn(name="main_typeid")
    private MainType mainTypeID;

    @Column(name="consum")
    private int consum;

    @Column(name="prod")
    private int prod;

    @Column(name="county")
    private int county;


}
