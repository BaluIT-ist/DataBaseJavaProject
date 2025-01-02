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
@Table(name = "main_type")
public class MainType {
    @Id
    @Column(name="mainTypeID")
    private int mainTypeID;

    @Column(name="mainType")
    private int mainType;


}
