package com.dan.green_energy.enums;

public enum GreenEnergySource {
    HYDROCURRENT(1),
    WINDCURRENT(2),
    SOLARPOWER(3),
    GEOTHERMAL(4),
    BIOMASS(5),
    WAVEPOWER(6),
    TIDALPOWER(7);


    private final int value;

    GreenEnergySource(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static GreenEnergySource fromValue(int value) {
        for (GreenEnergySource source : GreenEnergySource.values()) {
            if (source.getValue() == value) {
                return source;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
