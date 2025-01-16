package com.dan.green_energy.enums;

public enum RomanianCounty {
    ALBA(1),
    ARAD(2),
    ARGES(3),
    BACAU(4),
    BIHOR(5),
    BISTRITA_NASAUD(6),
    BOTOSANI(7),
    BRASOV(8),
    BRAILA(9),
    BUZAU(10),
    CARAS_SEVERIN(11),
    CALARASI(12),
    CLUJ(13),
    CONSTANTA(14),
    COVASNA(15),
    DAMBOVITA(16),
    DOLJ(17),
    GALATI(18),
    GIURGIU(19),
    GORJ(20),
    HARGHITA(21),
    HUNEDOARA(22),
    IALOMITA(23),
    IASI(24),
    ILFOV(25),
    MARAMURES(26),
    MEHEDINTI(27),
    MURES(28),
    NEAMT(29),
    OLT(30),
    PRAHOVA(31),
    SALAJ(32),
    SATU_MARE(33),
    SIBIU(34),
    SUCEAVA(35),
    TELEORMAN(36),
    TIMIS(37),
    TULCEA(38),
    VASLUI(39),
    VALCEA(40),
    VRANCEA(41),
    BUCHAREST(42);

    private final int value;

    RomanianCounty(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RomanianCounty fromValue(int value) {
        for (RomanianCounty source : RomanianCounty.values()) {
            if (source.getValue() == value) {
                return source;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
