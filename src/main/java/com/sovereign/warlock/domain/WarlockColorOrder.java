package com.sovereign.warlock.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * The 7 Pre-Prophetic Abrahamic Warlock Colors, strictly ordered 1 through 7.
 * Integrates optical wavelength, 24-bit TrueColor RGB bit-shifting,
 * Active-Low Reverse Binary inversion, and Spring Boot profile binding.
 */
public enum WarlockColorOrder {

    ORDER_1_WHITE_FIRE(
            1,
            "warlock-1-white",
            "Parchment White Fire (Esh Levanah)",
            "#F8F5E6",
            248, 245, 230,
            390,
            "OMEGA_0_EIN_SOF_AL_AZAL"
    ),
    ORDER_2_BLACK_FIRE(
            2,
            "warlock-2-black",
            "Ascetic Qedar Black Fire (Esh Shechorah)",
            "#141416",
            20, 20, 22,
            405,
            "OMEGA_1_FIRST_INSCRIPTION_50000_YEARS"
    ),
    ORDER_3_TEKHELET_SAPPHIRE(
            3,
            "warlock-3-sapphire",
            "Tekhelet Throne Sapphire (Livnat Ha-Sapir)",
            "#0F2C59",
            15, 44, 89,
            465,
            "OMEGA_2_MERKABAH_AND_PARGOD"
    ),
    ORDER_4_HASHMAL_GOLD(
            4,
            "warlock-4-gold",
            "Smokeless Hashmal Electrum Gold (Hashmal)",
            "#D4AF37",
            212, 175, 55,
            580,
            "OMEGA_4_YAWM_AL_ALAST_OATH"
    ),
    ORDER_5_GEVURAH_CRIMSON(
            5,
            "warlock-5-crimson",
            "Gevurah Covenant Crimson (Esh Ritzpah)",
            "#8B0000",
            139, 0, 0,
            650,
            "OMEGA_2_SERAPHIC_ALTAR_OF_FIRE"
    ),
    ORDER_6_GOETIC_BRASS(
            6,
            "warlock-6-brass",
            "Burnished Goetic Brass (Nechoshet Qalal)",
            "#B87333",
            184, 115, 51,
            605,
            "OMEGA_3_EVEN_HASHETIYAH_AND_OMEGA_5_MARIJ"
    ),
    ORDER_7_EMERALD_TWILIGHT(
            7,
            "warlock-7-emerald",
            "Emerald Shamir Twilight (Bein HaShemashot)",
            "#006B54",
            0, 107, 84,
            520,
            "OMEGA_6_SIXTH_TWILIGHT_BEIN_HASHEMASHOT"
    );

    public static final Comparator<WarlockColorOrder> BY_COLOR_ORDER_7 =
            Comparator.comparingInt(WarlockColorOrder::orderIndex);

    public static final Comparator<WarlockColorOrder> BY_WAVELENGTH_NM =
            Comparator.comparingInt(WarlockColorOrder::wavelengthNm)
                    .thenComparingInt(WarlockColorOrder::orderIndex);

    public static final Comparator<WarlockColorOrder> BY_LUMINANCE_DESC =
            Comparator.comparingDouble(WarlockColorOrder::relativeLuminance).reversed()
                    .thenComparingInt(WarlockColorOrder::orderIndex);

    private final int orderIndex;
    private final String profileId;
    private final String colorName;
    private final String hexCode;
    private final int red;
    private final int green;
    private final int blue;
    private final int wavelengthNm;
    private final String prePropheticStratum;

    WarlockColorOrder(
            int orderIndex,
            String profileId,
            String colorName,
            String hexCode,
            int red,
            int green,
            int blue,
            int wavelengthNm,
            String prePropheticStratum) {
        this.orderIndex = orderIndex;
        this.profileId = profileId;
        this.colorName = colorName;
        this.hexCode = hexCode;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.wavelengthNm = wavelengthNm;
        this.prePropheticStratum = prePropheticStratum;
    }

    public int orderIndex() {
        return orderIndex;
    }

    public String profileId() {
        return profileId;
    }

    public String colorName() {
        return colorName;
    }

    public String hexCode() {
        return hexCode;
    }

    public int red() {
        return red;
    }

    public int green() {
        return green;
    }

    public int blue() {
        return blue;
    }

    public int wavelengthNm() {
        return wavelengthNm;
    }

    public String prePropheticStratum() {
        return prePropheticStratum;
    }

    /**
     * 24-bit TrueColor packed integer: (R << 16) | (G << 8) | B.
     */
    public int rgb24() {
        return ((red & 0xFF) << 16) | ((green & 0xFF) << 8) | (blue & 0xFF);
    }

    /**
     * Active-Low Reverse Binary 24-bit mask (~rgb24 & 0xFFFFFF).
     */
    public int activeLow24() {
        return (~rgb24()) & 0xFFFFFF;
    }

    /**
     * ITU-R BT.709 relative optical luminance in [0.0, 255.0].
     */
    public double relativeLuminance() {
        return (0.2126 * red) + (0.7152 * green) + (0.0722 * blue);
    }

    public static Optional<WarlockColorOrder> fromProfileId(String profileId) {
        return Arrays.stream(values())
                .filter(c -> c.profileId.equalsIgnoreCase(profileId))
                .findFirst();
    }

    public static Optional<WarlockColorOrder> fromOrderIndex(int index) {
        return Arrays.stream(values())
                .filter(c -> c.orderIndex == index)
                .findFirst();
    }

    public static List<WarlockColorOrder> orderedBySevenColors() {
        return Arrays.stream(values())
                .sorted(BY_COLOR_ORDER_7)
                .toList();
    }
}
