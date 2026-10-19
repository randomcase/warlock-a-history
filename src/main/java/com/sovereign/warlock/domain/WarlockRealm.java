package com.sovereign.warlock.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Immutable Domain Specification of the 7 Sovereign Pre-Prophetic Warlock Realms,
 * ordered strictly by Color (1..7).
 * Each Warlock Order governs its own distinct Realm, Castle, Tower, and Keep.
 */
public record WarlockRealm(
        int orderIndex,
        String profileId,
        String realmHtmlFile,
        String realmCode,
        String realmNameHebrew,
        String realmNameArabic,
        String englishTitle,
        String cosmologicalStratum,
        String horizonAtmosphere,
        String groundTopography,
        String zeroIronMaterials,
        String castleName,
        String castleArchitecture,
        String towerName,
        String towerArchitecture,
        String keepName,
        String keepArchitecture,
        String geometricSignature3D
) {
    public WarlockRealm {
        Objects.requireNonNull(profileId);
        Objects.requireNonNull(realmHtmlFile);
        Objects.requireNonNull(realmCode);
        Objects.requireNonNull(realmNameHebrew);
        Objects.requireNonNull(realmNameArabic);
        Objects.requireNonNull(englishTitle);
        Objects.requireNonNull(cosmologicalStratum);
        Objects.requireNonNull(horizonAtmosphere);
        Objects.requireNonNull(groundTopography);
        Objects.requireNonNull(zeroIronMaterials);
        Objects.requireNonNull(castleName);
        Objects.requireNonNull(castleArchitecture);
        Objects.requireNonNull(towerName);
        Objects.requireNonNull(towerArchitecture);
        Objects.requireNonNull(keepName);
        Objects.requireNonNull(keepArchitecture);
        Objects.requireNonNull(geometricSignature3D);
    }

    private static final List<WarlockRealm> ALL_REALMS = List.of(
            new WarlockRealm(
                    1,
                    "warlock-1-white",
                    "realm-1-white.html",
                    "REALM_1_WHITE_VOID",
                    "Tehom Ha-Levanah",
                    "Badiyat Al-Azal",
                    "The White-Fire Vacuum of Pre-Eternity",
                    "OMEGA_0_EIN_SOF_AL_AZAL",
                    "Acoustic-less spherical horizon of unconditioned Parchment-White Radiance (#F8F5E6) pierced by a single vertical ray of Kav light.",
                    "A 30-cubit spherical Tzimtzum contraction void suspended over crystalline white selenite plates and twelve monolithic alabaster stelae.",
                    "Uncreased White Gazelle Parchment, Translucent Selenite, Pure Quartz & Electrum Filigree",
                    "Qasr Al-Reshimu (Citadel of the Primordial Residue)",
                    "Concentric octagonal walls of translucent white selenite that refract uncreated light without casting shadows.",
                    "Migdal Ha-Kav (Spire of the Primordial Ray)",
                    "A monolithic needle of pure white crystal channeling the vertical beam of Kav from the upper horizon into the Void.",
                    "Hisn Ha-Megillah (Vault of the Uncreased Scroll)",
                    "A silent spherical inner chamber where the Scroll of Pre-Eternity burns in white fire without consuming its parchment.",
                    "SPHERICAL_TZIMTZUM_VOID_AND_KAV_BEAM"
            ),
            new WarlockRealm(
                    2,
                    "warlock-2-black",
                    "realm-2-black.html",
                    "REALM_2_BLACK_QALAM",
                    "Midbar Qedar Ha-Shachor",
                    "Wadi Al-Qalam",
                    "The Obsidian Desert of the 231 Consonantal Gates",
                    "OMEGA_1_FIRST_INSCRIPTION_50000_YEARS",
                    "A starless vault of flowing obsidian ink (#141416) where living Kufic and paleo-Aramaic root consonants trace parabolic arcs.",
                    "An infinite desert plain of black volcanic basalt sand arranged in concentric Awfaq (Abjad magic squares) intersected by 231 stone arches.",
                    "Unhewn Black Desert Basalt, Qedar Goat-Hair Textiles, Petrified Reed & Meteoric Bronze",
                    "Qal'at Al-Nun (Fortress of the Primordial Inkwell)",
                    "Hexagonal black basalt curtain walls incised with the 22 Foundation Letters and bound with lead-free bronze clasps.",
                    "Burj Al-Qalam (Obelisk of the Split Stylus)",
                    "A towering cloven obelisk of black diorite down whose central fissure flows luminous Black Fire upon White Fire.",
                    "Beit Sefer Yetzirah (Scriptorium of the 231 Gates)",
                    "Twenty-two radial vaults housing the rotating stone wheels of consonantal permutation.",
                    "PARABOLIC_231_GATES_AND_OBSIDIAN_OBELISK"
            ),
            new WarlockRealm(
                    3,
                    "warlock-3-sapphire",
                    "realm-3-sapphire.html",
                    "REALM_3_SAPPHIRE_MERKABAH",
                    "Livnat Ha-Sapir",
                    "Falak Al-'Arsh",
                    "The Sapphire Pavement of the Seven Heikhalot Palaces",
                    "OMEGA_2_MERKABAH_AND_PARGOD",
                    "Veiled above by the shimmering Cosmic Curtain (Ha-Pargod) weaving all generations, orbited by interlocking gyroscopic Ophanim eye-wheels.",
                    "Seven concentric amphitheaters of deep-sea Tekhelet Sapphire (#0F2C59) suspended over four rivers of fire, hail, snow, and lightning.",
                    "Lapis Lazuli, Tekhelet-Dyed Linen, Cut Sapphire Slabs & Burnished Electrum",
                    "Heikhalot Ha-Shomrim (Citadel of the Threshold Gatekeepers)",
                    "Seven nested sapphire gatehouses sealed with the cryptographic names required to pass Suriel, Sandalphon, and Metatron.",
                    "Burj Al-Merkabah (Spire of the Chariot Descent)",
                    "A seven-tiered double-helical ziggurat of sapphire crystal surrounded by counter-rotating Ophanim armillary rings.",
                    "Hisn Ha-Pargod (Sanctum of the Throne-Curtain)",
                    "The innermost circular sapphire rotunda directly beneath the footstool of the Chariot where the four Hayyot faces converge.",
                    "SEVEN_CONCENTRIC_SAPPHIRE_PALACES_AND_OPHANIM_RINGS"
            ),
            new WarlockRealm(
                    4,
                    "warlock-4-gold",
                    "realm-4-gold.html",
                    "REALM_4_GOLD_ALAST",
                    "Heikhal Ha-Hashmal",
                    "Sahra' Al-Mithaq",
                    "The Electrum Plain of the Pre-Temporal Oath (Yawm Al-Alast)",
                    "OMEGA_4_YAWM_AL_ALAST_OATH",
                    "A luminous dome of smokeless Hashmal amber-gold (#D4AF37) resonating with the eternal echo of 'Alastu bi-Rabbikum?'",
                    "A vast geometric amphitheater where 72 monolithic pillars of electrum gold stand in three concentric rings of 24.",
                    "Meteoric Electrum (Hashmal), Twelve Primordial Choshen Gemstones, Pure Gold & White Linen",
                    "Qasr Al-Shahid (Citadel of the Pre-Temporal Witness)",
                    "A twelve-gated golden fortress whose ramparts mirror the twelve uncut stones of the Choshen breastplate.",
                    "Manarat Qol Demamah (Belfry of the Still Small Voice)",
                    "A harmonic golden resonator spire that strips away all thunder and wind, leaving only pin-drop ontological silence.",
                    "Otzar Ha-Neshamot (Treasury Vault of Pre-Existent Souls)",
                    "A domed electrum sanctum housing 72 resonant chambers, each tuned to one triplet of the Shem HaMephorash.",
                    "SEVENTY_TWO_ELECTRUM_PILLARS_AND_CHOSHEN_DOME"
            ),
            new WarlockRealm(
                    5,
                    "warlock-5-crimson",
                    "realm-5-crimson.html",
                    "REALM_5_CRIMSON_RITZPAH",
                    "Har Ha-Mizbe'ach",
                    "Ufq Al-Shihab",
                    "The Crimson Altar-Caldera & The Barred Sky of Flaming Meteors",
                    "OMEGA_2_SERAPHIC_ALTAR_OF_FIRE",
                    "A tempestuous upper firmament patrolled by stern angelic guards and streaked with piercing crimson Shihab meteors (#8B0000).",
                    "A terraced volcanic caldera of red porphyry and glowing altar-coals (Ritzpah) bridged by six-winged Seraphic causeways.",
                    "Imperial Red Porphyry, Glowing Cedar Coals, Burnished Bronze Tongs & Ruby Glass",
                    "Metzudat Ha-Gevurah (Redoubt of Severe Judgment)",
                    "Six-bastioned crimson porphyry fortress flanked by colossal bronze censers pouring pillars of smoke and judgment fire.",
                    "Burj Al-Shihab (Watchtower of the Barred Firmament)",
                    "A six-sided crimson spire crowned with rotating Seraphic wings that project lances of altar-fire across the horizon.",
                    "Beit Madei-Esh (Sanctuary of the First Tongs & Live Coal)",
                    "The horned inner altar vault where the undying pre-temporal ember (Ritzpah) rests upon a bed of unhewn stone.",
                    "SIX_WINGED_CALDERA_AND_SHIHAB_METEOR_LATTICE"
            ),
            new WarlockRealm(
                    6,
                    "warlock-6-brass",
                    "realm-6-brass.html",
                    "REALM_6_BRASS_TEHOM",
                    "Yam Ha-Nechoshet",
                    "Jabal Qaf Al-Marij",
                    "The Brazen Sea & The 72 Containment Vaults of Smokeless Fire",
                    "OMEGA_3_EVEN_HASHETIYAH_AND_OMEGA_5_MARIJ",
                    "A cavernous subterranean-celestial dome of hammered Damascene brass (#B87333) lit by green-gold ribbons of bound smokeless fire.",
                    "A colossal circular Brazen Sea resting upon twelve bronze oxen directly capping the mouths of the Primordial Abyss (Tehom).",
                    "Hammered Damascene Brass, Stamped Lead Stoppers, Foundation Basalt & Red Za'faran Ink",
                    "Qasr Sulayman Al-Qadim (The Proto-Solomonic Brass Citadel)",
                    "Interlocking brazen plates fitted silently without a single iron nail, engraved with octagonal binding geometry.",
                    "Burj Al-Khatam (Spire of the Great Foundation Signet)",
                    "An octagonal brass tower projecting a downward-and-upward Hexagram containment beam into the Abyss.",
                    "Hisn Even HaShetiyah (Keep of the Foundation Stone & 72 Amphorae)",
                    "The central subterranean vault where 72 lead-stoppered brass vessels ring the monolithic Foundation Stone.",
                    "BRAZEN_SEA_AND_72_CONTAINMENT_SILOS"
            ),
            new WarlockRealm(
                    7,
                    "warlock-7-emerald",
                    "realm-7-emerald.html",
                    "REALM_7_EMERALD_TWILIGHT",
                    "Bein Ha-Shemashot",
                    "Barzakh Majma' Al-Bahrayn",
                    "The Emerald Isthmus of the Sixth Twilight & The Unseen Realm",
                    "OMEGA_6_SIXTH_TWILIGHT_BEIN_HASHEMASHOT",
                    "Suspended in perpetual Sixth Twilight (#006B54) where neither sun nor moon rises, lit by emerald Shamir bioluminescence.",
                    "A narrow crystalline isthmus at the Confluence of the Two Seas (Majma' al-Bahrayn) bordered by petrified olive and Sinai acacia groves.",
                    "Green Malachite, Shamir Light-Crystal, Mount Sinai Acacia Wood & Barley-Lead Cases",
                    "Ribat Al-Ghaib (Cloister-Fortress of the Unseen)",
                    "Unhewn malachite and green basalt walls cleaved silently by the Shamir, veiled from mortal sight inside 'Alam al-Ghaib.",
                    "Manarat Al-Bahrayn (Lighthouse Spire of the Two Seas)",
                    "A spiral emerald-and-acacia minaret standing at the exact junction where the Sea of Time meets the Sea of Pre-Eternity.",
                    "Hisn Ha-Shamir (Reliquary Keep of the Silent Stone-Cleaver)",
                    "A lead-and-barley-lined inner vault housing the radiant Shamir crystal and the 99-bead olive Misbahah of the Unseen.",
                    "CONFLUENCE_OF_TWO_SEAS_AND_EMERALD_SPIRAL_MINARET"
            )
    );

    private static final Map<Integer, WarlockRealm> BY_ORDER = ALL_REALMS.stream()
            .collect(Collectors.toUnmodifiableMap(WarlockRealm::orderIndex, Function.identity()));

    public static List<WarlockRealm> allOrderedBySeven() {
        return ALL_REALMS;
    }

    public static WarlockRealm forOrderIndex(int orderIndex) {
        WarlockRealm r = BY_ORDER.get(orderIndex);
        if (r == null) {
            throw new IllegalArgumentException("No WarlockRealm for orderIndex: " + orderIndex);
        }
        return r;
    }
}
