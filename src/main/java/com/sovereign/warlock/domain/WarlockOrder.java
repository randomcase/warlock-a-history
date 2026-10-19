package com.sovereign.warlock.domain;

import com.sovereign.warlock.config.WarlockProfileProperties;
import java.util.Objects;

/**
 * Sealed Hierarchy of the 7 Pre-Prophetic Abrahamic Warlocks ordered by Color (1..7).
 * Uses Java 21+ Sealed Interfaces and Immutable Records.
 */
public sealed interface WarlockOrder
        permits WarlockOrder.WhiteFireWarlock,
                WarlockOrder.BlackFireWarlock,
                WarlockOrder.SapphireMerkabahWarlock,
                WarlockOrder.GoldAlastWarlock,
                WarlockOrder.CrimsonSeraphWarlock,
                WarlockOrder.BrassGoeticWarlock,
                WarlockOrder.EmeraldTwilightWarlock {

    WarlockColorOrder colorOrder();

    WarlockProfileProperties properties();

    MysticalPillar pillar();

    default int orderIndex() {
        return colorOrder().orderIndex();
    }

    default String profileId() {
        return colorOrder().profileId();
    }

    default SpcControlMatrix.SpcState spcState() {
        return SpcControlMatrix.evaluateState(
                properties().processCapabilityCp(),
                properties().varianceSigma()
        );
    }

    /**
     * Order 1: White Fire (#F8F5E6) — Malakh-Azal (Ein Sof / Al-Azal).
     */
    record WhiteFireWarlock(
            WarlockColorOrder colorOrder,
            WarlockProfileProperties properties,
            MysticalPillar pillar,
            int tzimtzumContractionRadiusFeet
    ) implements WarlockOrder {
        public WhiteFireWarlock {
            Objects.requireNonNull(colorOrder);
            Objects.requireNonNull(properties);
            Objects.requireNonNull(pillar);
        }
    }

    /**
     * Order 2: Black Fire (#141416) — Katib Al-Qalam (Al-Qalam / Torah Kedumah).
     */
    record BlackFireWarlock(
            WarlockColorOrder colorOrder,
            WarlockProfileProperties properties,
            MysticalPillar pillar,
            int seferYetzirahGatesCount
    ) implements WarlockOrder {
        public BlackFireWarlock {
            Objects.requireNonNull(colorOrder);
            Objects.requireNonNull(properties);
            Objects.requireNonNull(pillar);
        }
    }

    /**
     * Order 3: Tekhelet Sapphire (#0F2C59) — Yored Ha-Merkabah (Chariot & Pargod).
     */
    record SapphireMerkabahWarlock(
            WarlockColorOrder colorOrder,
            WarlockProfileProperties properties,
            MysticalPillar pillar,
            int celestialPalacesHeikhalot
    ) implements WarlockOrder {
        public SapphireMerkabahWarlock {
            Objects.requireNonNull(colorOrder);
            Objects.requireNonNull(properties);
            Objects.requireNonNull(pillar);
        }
    }

    /**
     * Order 4: Hashmal Electrum Gold (#D4AF37) — Shahid Al-Alast (Yawm Al-Alast).
     */
    record GoldAlastWarlock(
            WarlockColorOrder colorOrder,
            WarlockProfileProperties properties,
            MysticalPillar pillar,
            int shemHaMephorashTriplets
    ) implements WarlockOrder {
        public GoldAlastWarlock {
            Objects.requireNonNull(colorOrder);
            Objects.requireNonNull(properties);
            Objects.requireNonNull(pillar);
        }
    }

    /**
     * Order 5: Gevurah Covenant Crimson (#8B0000) — Saraph Ha-Ritzpah (Seraphic Coal).
     */
    record CrimsonSeraphWarlock(
            WarlockColorOrder colorOrder,
            WarlockProfileProperties properties,
            MysticalPillar pillar,
            int seraphicWingsCount
    ) implements WarlockOrder {
        public CrimsonSeraphWarlock {
            Objects.requireNonNull(colorOrder);
            Objects.requireNonNull(properties);
            Objects.requireNonNull(pillar);
        }
    }

    /**
     * Order 6: Burnished Goetic Brass (#B87333) — Ba'al Ha-Nechoshet (Foundation Stone & Brass Vessel).
     */
    record BrassGoeticWarlock(
            WarlockColorOrder colorOrder,
            WarlockProfileProperties properties,
            MysticalPillar pillar,
            int boundPreAdamicSpiritsCount
    ) implements WarlockOrder {
        public BrassGoeticWarlock {
            Objects.requireNonNull(colorOrder);
            Objects.requireNonNull(properties);
            Objects.requireNonNull(pillar);
        }
    }

    /**
     * Order 7: Emerald Shamir Twilight (#006B54) — Wali Al-Ghaib (Bein HaShemashot & Shamir).
     */
    record EmeraldTwilightWarlock(
            WarlockColorOrder colorOrder,
            WarlockProfileProperties properties,
            MysticalPillar pillar,
            int unseenAttributesDhikrCount
    ) implements WarlockOrder {
        public EmeraldTwilightWarlock {
            Objects.requireNonNull(colorOrder);
            Objects.requireNonNull(properties);
            Objects.requireNonNull(pillar);
        }
    }
}
