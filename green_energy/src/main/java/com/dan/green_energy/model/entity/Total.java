package com.dan.green_energy.model.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "total")
public class Total {
    @Id
    @Column(name="referenced_year")
    private int referencedYear;

    @Column(name = "totalProd")
    private int totalProd;

    @Column(name="totalConsum")
    private int totalConsum;



}
