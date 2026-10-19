package com.sovereign.warlock.domain;

/**
 * The Four Esoteric Abrahamic Pillars synthesized into the Pre-Prophetic Warlock Pact.
 */
public enum MysticalPillar {

    PROPHETIC_APOCALYPTIC_COVENANT(
            "Prophetic & Apocalyptic Covenant",
            "Seraphim of the Burning Coal, Ophanim Wheels & Seven-Sealed Scroll",
            "Altar of Fire before the Pargod"
    ),
    SUFI_ESOTERIC_DESERT_ASCETICISM(
            "Sufi & Esoteric Desert Asceticism",
            "Unseen Realm ('Alam al-Ghaib), Al-Qalam, Awfaq Geometry & Sacred Dhikr",
            "Yawm Al-Alast & The Preserved Tablet"
    ),
    MERKABAH_KABBALISTIC_MYSTICISM(
            "Merkabah & Kabbalistic Mysticism",
            "Seven Heikhalot Chariot Ascent, Sefirot, 22 Foundation Letters & 72 Names",
            "Ein Sof, Tzimtzum & Livnat Ha-Sapir"
    ),
    SOLOMONIC_GOETIC_BINDING(
            "Solomonic & Goetic Binding",
            "Proto-Seal of the Foundation Stone, Zero-Iron Law & 72 Brass Vessels",
            "Sealing of Tehom & Pre-Adamic Smokeless Fire (Marijin min Nar)"
    );

    private final String title;
    private final String esotericInstruments;
    private final String prePropheticAnchor;

    MysticalPillar(String title, String esotericInstruments, String prePropheticAnchor) {
        this.title = title;
        this.esotericInstruments = esotericInstruments;
        this.prePropheticAnchor = prePropheticAnchor;
    }

    public String title() {
        return title;
    }

    public String esotericInstruments() {
        return esotericInstruments;
    }

    public String prePropheticAnchor() {
        return prePropheticAnchor;
    }
}
