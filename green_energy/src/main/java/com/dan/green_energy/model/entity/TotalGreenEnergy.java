package com.dan.green_energy.model.entity;

import com.dan.green_energy.model.entity.id.TotalGreenEnergyID;
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
@Table(name = "total_green_energy")
public class TotalGreenEnergy {
    @EmbeddedId
    private TotalGreenEnergyID id;

    @ManyToOne
    @MapsId("greenEnergyID")
    @ToString.Exclude
    @JoinColumn(name="green_energy")
    private GreenEnergy greenEnergy;

    @ManyToOne
    @MapsId("referencedYearID")
    @ToString.Exclude
    @JoinColumn(name="referenced_year")
    private Total referencedYear;


}
