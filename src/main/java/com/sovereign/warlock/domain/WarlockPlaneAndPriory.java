package com.sovereign.warlock.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Defines:
 *  1) The 7 Cosmological & Chromatic Bit-Planes (P_1 .. P_7) that each of the 7 Warlock Realms inhabits.
 *  2) The Negentropic Priory (governed by Sigma -1n, 0n Beta, and GEMINI.md Tensor T) that orders
 *     each Warlock from Entropic Disorder into Absolute Resolution (H = 0.00).
 */
public final class WarlockPlaneAndPriory {

    private WarlockPlaneAndPriory() {
    }

    /**
     * The Plane of Existence inhabited by a specific Warlock Realm.
     */
    public record PlaneOfExistence(
            int orderIndex,
            String profileId,
            String planeHtmlFile,
            String inhabitedRealmFile,
            String inhabitedRealmName,
            String planeCode,
            String kabbalisticOlam,
            String sufiHadrahOrAlam,
            String englishPlaneTitle,
            String chromaticBitPlane,
            String dimensionalMetric,
            String planeSubstrateAndLaw,
            String entropicHazardOfPlane
    ) {
        public PlaneOfExistence {
            Objects.requireNonNull(profileId);
            Objects.requireNonNull(planeHtmlFile);
            Objects.requireNonNull(inhabitedRealmFile);
            Objects.requireNonNull(inhabitedRealmName);
            Objects.requireNonNull(planeCode);
            Objects.requireNonNull(kabbalisticOlam);
            Objects.requireNonNull(sufiHadrahOrAlam);
            Objects.requireNonNull(englishPlaneTitle);
            Objects.requireNonNull(chromaticBitPlane);
            Objects.requireNonNull(dimensionalMetric);
            Objects.requireNonNull(planeSubstrateAndLaw);
            Objects.requireNonNull(entropicHazardOfPlane);
        }
    }

    /**
     * The Priory Assignment that orders each Warlock out of Entropic Disorder
     * via Sigma -1n (H_{t+1} = max(0.0, H_raw - 1.0)) and 0n Beta (Delta H = 0.00).
     */
    public record PrioryRuleAssignment(
            int prioryCanonicalSeat,
            String prioryRomanNumeral,
            int colorOrderIndex,
            String profileId,
            String warlockName,
            String hexCode,
            String prioryTitle,
            String prioryCloisterCell,
            double processCapabilityCp,
            double varianceSigma,
            double rawShannonEntropyBits,
            double sigmaMinusOneCollapseDelta,
            double resolvedEntropyBits,
            double zeroNBetaDriftDelta,
            String entropicDisorderSource,
            String prioryOrderingDiscipline
    ) {
        public PrioryRuleAssignment {
            Objects.requireNonNull(prioryRomanNumeral);
            Objects.requireNonNull(profileId);
            Objects.requireNonNull(warlockName);
            Objects.requireNonNull(hexCode);
            Objects.requireNonNull(prioryTitle);
            Objects.requireNonNull(prioryCloisterCell);
            Objects.requireNonNull(entropicDisorderSource);
            Objects.requireNonNull(prioryOrderingDiscipline);
        }
    }

    public static final Comparator<PrioryRuleAssignment> BY_PRIORY_SEAT_ASC =
            Comparator.comparingInt(PrioryRuleAssignment::prioryCanonicalSeat);

    public static final Comparator<PrioryRuleAssignment> BY_RAW_ENTROPY_DESC =
            Comparator.comparingDouble(PrioryRuleAssignment::rawShannonEntropyBits).reversed()
                    .thenComparingInt(PrioryRuleAssignment::colorOrderIndex);

    public static final Comparator<PrioryRuleAssignment> BY_COLOR_ORDER_7 =
            Comparator.comparingInt(PrioryRuleAssignment::colorOrderIndex);

    private static final List<PlaneOfExistence> ALL_PLANES = List.of(
            new PlaneOfExistence(
                    1,
                    "warlock-1-white",
                    "plane-1-white.html",
                    "realm-1-white.html",
                    "Tehom Ha-Levanah / Badiyat Al-Azal",
                    "PLANE_P1_AKUDIM_AHADIYYAH",
                    "Olam Ha-Akudim (World of Bound Lights)",
                    "Hadrat Al-Ahadiyyah (Plane of Undifferentiated Unity)",
                    "The First Plane of Bound Pre-Temporal Radiance",
                    "Bit-Plane B0 (1-Bit Mono-Chroma Luminance | Active-Low 0x070A19)",
                    "ds^2 = -c^2 dt_Azal^2 + dR_Tzimtzum^2 (Isotropic Contraction Manifold)",
                    "Inhabited by Realm #1 (Tehom Ha-Levanah). A zero-curvature plane of uncreased parchment-white light where all 10 Sefirotic lights are bound inside a single undivided vessel before differentiation.",
                    "Unbounded Vacuum Inflation: Risk of the Tzimtzum void expanding uncontrollably and erasing adjacent spatial coordinates."
            ),
            new PlaneOfExistence(
                    2,
                    "warlock-2-black",
                    "plane-2-black.html",
                    "realm-2-black.html",
                    "Midbar Qedar Ha-Shachor / Wadi Al-Qalam",
                    "PLANE_P2_MALBUSH_LAWH",
                    "Olam Ha-Malbush (World of the Consonantal Garment)",
                    "Hadrat Al-Lawh wa Al-Qalam (Plane of the Tablet & Stylus)",
                    "The Second Plane of the Primordial Letter-Matrix",
                    "Bit-Plane B1 (2-Bit Consonantal Inscription Bus | Active-Low 0xEBEBE9)",
                    "M_231 = (22 x 21) / 2 Discrete Combinatorial Lattice",
                    "Inhabited by Realm #2 (Wadi Al-Qalam). The woven linguistic fabric of pre-eternity where the 231 Gates of Sefer Yetzirah and Abjad Awfaq squares form the structural warp and weft of matter.",
                    "Lexical Permutation Divergence: Risk of a mispronounced root consonant fracturing the 231-Gate syntactic lattice."
            ),
            new PlaneOfExistence(
                    3,
                    "warlock-3-sapphire",
                    "plane-3-sapphire.html",
                    "realm-3-sapphire.html",
                    "Livnat Ha-Sapir / Falak Al-'Arsh",
                    "PLANE_P3_BERIAH_JABARUT",
                    "Olam Ha-Beri'ah (World of the Throne & Creation)",
                    "'Alam Al-Jabarut (Plane of Archangelic Omnipotence)",
                    "The Third Plane of the Sapphire Chariot Horizon",
                    "Bit-Plane B2 (3-Bit Optical Octet Sapphire Channel | Active-Low 0xF0D3A6)",
                    "SO(4) x SO(7) Gyroscopic Ophanim Fiber Bundle",
                    "Inhabited by Realm #3 (Livnat Ha-Sapir). The high archangelic plane suspended directly beneath the Cosmic Curtain (Ha-Pargod), housing the Seven Heikhalot palaces and the four rivers of fire and hail.",
                    "Gyroscopic Heikhalot Desynchronization: Risk of counter-rotating Ophanim rings drifting out of phase across the 7 Palaces."
            ),
            new PlaneOfExistence(
                    4,
                    "warlock-4-gold",
                    "plane-4-gold.html",
                    "realm-4-gold.html",
                    "Heikhal Ha-Hashmal / Sahra' Al-Mithaq",
                    "PLANE_P4_ATZILUT_ARWAH",
                    "Olam Ha-Atzilut (World of Nearness & Hashmal)",
                    "'Alam Al-Arwah (Plane of Pre-Existent Covenant Souls)",
                    "The Fourth Plane of the Pre-Temporal Assembly of Alast",
                    "Bit-Plane B3 (4-Bit Harmonic Nybble Wheel | Active-Low 0x2B50C8)",
                    "H_72 = Direct Sum of 72 Triplet Acoustic Eigenstates",
                    "Inhabited by Realm #4 (Sahra' Al-Mithaq). The luminous amber-gold plane where every soul stood prior to bodily creation and testified 'Bala!'—anchored by the 72 harmonic resonances.",
                    "Harmonic Over-Amplification: Risk of the 72-Triplet acoustic resonance shattering finite vessels unable to bear the voice of Alast."
            ),
            new PlaneOfExistence(
                    5,
                    "warlock-5-crimson",
                    "plane-5-crimson.html",
                    "realm-5-crimson.html",
                    "Har Ha-Mizbe'ach / Ufq Al-Shihab",
                    "PLANE_P5_TOHU_SHUHUB",
                    "Olam Ha-Tohu (World of Primordial Intensity & Gevurah)",
                    "Falak Al-Shuhub (Plane of the Barred Meteoric Firmament)",
                    "The Fifth Plane of Severe Judgment & The Flaming Barrier",
                    "Bit-Plane B4 (High-Intensity Red Attenuation Bus | Active-Low 0x74FFFF)",
                    "Grad(Phi_Din) >= 4.0 Sigma Thermal Shear Boundary",
                    "Inhabited by Realm #5 (Ufq Al-Shihab). The volatile boundary plane of unmitigated Gevurah (Severity) where live altar-coals (Ritzpah) burn and piercing crimson Shihab meteors bar the heavens.",
                    "Shevirat HaKelim (Shattering of the Vessels): Highest entropic hazard—raw Gevurah fire exceeding vessel containment capacity."
            ),
            new PlaneOfExistence(
                    6,
                    "warlock-6-brass",
                    "plane-6-brass.html",
                    "realm-6-brass.html",
                    "Yam Ha-Nechoshet / Jabal Qaf Al-Marij",
                    "PLANE_P6_YETZIRAH_MARIJ",
                    "Olam Ha-Yetzirah (World of Formation & Binding)",
                    "'Alam Al-Marij (Plane of Pre-Adamic Smokeless Fire)",
                    "The Sixth Plane of the Foundation Seal & Brazen Containment",
                    "Bit-Plane B5 (Metallic Impedance Shielding Bus | Active-Low 0x478CCC)",
                    "Z_Brass = Zero-Ferrous Closed Magnetic Torus over Tehom",
                    "Inhabited by Realm #6 (Yam Ha-Nechoshet). The tectonic-astral boundary plane where the Foundation Stone (Even HaShetiyah) plugs the Abyss and the 72 Brass Silos contain the pre-Adamic Jinn.",
                    "Sub-Abyssal Vapor Pressure: Risk of pre-Adamic smokeless fire (Marijin min Nar) eroding the lead stoppers of the 72 vessels."
            ),
            new PlaneOfExistence(
                    7,
                    "warlock-7-emerald",
                    "plane-7-emerald.html",
                    "realm-7-emerald.html",
                    "Bein Ha-Shemashot / Barzakh Majma' Al-Bahrayn",
                    "PLANE_P7_TIKKUN_BARZAKH",
                    "Olam Ha-Tikkun (World of Restoration & Sixth Twilight)",
                    "'Alam Al-Mithal wa Al-Barzakh (Plane of the Imaginal Isthmus)",
                    "The Seventh Plane of the Two Seas & Unseen Equilibrium",
                    "Bit-Plane B6 (24-Bit TrueColor Equilibrium Bus | Active-Low 0xFF94AB)",
                    "Delta_H = 0.00 Iso-Entropic Boundary between Azal and Zaman",
                    "Inhabited by Realm #7 (Barzakh Majma' Al-Bahrayn). The restorative plane of the Sixth Twilight where the Sea of Pre-Eternity and the Sea of Time meet without transgressing their barrier.",
                    "Temporal Phase Leakage: Risk of the twilight isthmus collapsing into linear mortality if the Shamir crystal loses optical parity."
            )
    );

    /**
     * The 7 Priory Assignments ordered by Priory Canonical Seat (I..VII),
     * ranking the Warlocks from Lowest Raw Entropic Disorder to Highest Raw Entropic Disorder
     * and applying Sigma -1n (Delta H = -1n -> H = 0.00) and 0n Beta (Delta H = 0.00).
     */
    private static final List<PrioryRuleAssignment> PRIORY_ASSIGNMENTS = List.of(
            new PrioryRuleAssignment(
                    1, "I",
                    1, "warlock-1-white", "Malakh-Azal", "#F8F5E6",
                    "Grand Prior of the Uncreased Silence",
                    "Cloister Cell I: The Selenite Sanctuary of Zero Drift",
                    1.48, 0.42,
                    0.140, -1.0, 0.000, 0.000,
                    "Tzimtzum Vacuum Boundary Fluctuation (0.140 bits raw entropy)",
                    "Maintains baseline feedback gains in State S0; anchors the Priory's central 0n Beta grounding bus."
            ),
            new PrioryRuleAssignment(
                    2, "II",
                    4, "warlock-4-gold", "Shahid Al-Alast", "#D4AF37",
                    "Sub-Prior of the Pre-Temporal Witness",
                    "Cloister Cell II: The Electrum Rotunda of Acoustic Parity",
                    1.46, 0.47,
                    0.185, -1.0, 0.000, 0.000,
                    "72-Triplet Harmonic Over-Resonance (0.185 bits raw entropy)",
                    "Dampens acoustic overtones via Qol Demamah Daqah (Still, Small Voice) to enforce Delta H = 0.00."
            ),
            new PrioryRuleAssignment(
                    3, "III",
                    7, "warlock-7-emerald", "Wali Al-Ghaib", "#006B54",
                    "Prior-Custodian of the Twilight Isthmus",
                    "Cloister Cell III: The Malachite Cell of the Two Seas",
                    1.45, 0.49,
                    0.210, -1.0, 0.000, 0.000,
                    "Barzakh Horizon Phase Refraction (0.210 bits raw entropy)",
                    "Calibrates the Shamir crystal along the 99-bead olive Misbahah cadence to lock tertiary parity."
            ),
            new PrioryRuleAssignment(
                    4, "IV",
                    2, "warlock-2-black", "Katib Al-Qalam", "#141416",
                    "Prior-Archivist of the Sealed Scriptorium",
                    "Cloister Cell IV: The Diorite Vault of the 231 Gates",
                    1.44, 0.51,
                    0.245, -1.0, 0.000, 0.000,
                    "Consonantal Gate Permutation Entropy (0.245 bits raw entropy)",
                    "Applies Awfaq magic-square row/column parity checksums and Sigma -1n lexical stabilization."
            ),
            new PrioryRuleAssignment(
                    5, "V",
                    6, "warlock-6-brass", "Ba'al Ha-Nechoshet", "#B87333",
                    "Prior-Warden of the 72 Brazen Vessels",
                    "Cloister Cell V: The Damascene Bastion of the Foundation Seal",
                    1.42, 0.54,
                    0.290, -1.0, 0.000, 0.000,
                    "Pre-Adamic Smokeless Fire (Marij) Vessel Pressure (0.290 bits raw entropy)",
                    "Enforces the Law of Zero Iron and injects -1.2 sigma_x Structural Offset Bias into the 72 lead stoppers."
            ),
            new PrioryRuleAssignment(
                    6, "VI",
                    3, "warlock-3-sapphire", "Yored Ha-Merkabah", "#0F2C59",
                    "Prior-Navigator of the Seven Heikhalot",
                    "Cloister Cell VI: The Tekhelet Observatory of the Ophanim",
                    1.41, 0.58,
                    0.335, -1.0, 0.000, 0.000,
                    "Heikhalot Gyroscopic Chariot Shear (0.335 bits raw entropy)",
                    "Synchronizes the 7 Palace threshold seals with Sigma -1n active phase-locking across the Pargod veil."
            ),
            new PrioryRuleAssignment(
                    7, "VII",
                    5, "warlock-5-crimson", "Saraph Ha-Ritzpah", "#8B0000",
                    "Prior-Sentinel of the Crimson Watch & Shihab Barrier",
                    "Cloister Cell VII: The Porphyry Containment Vault of Gevurah",
                    1.39, 0.63,
                    0.395, -1.0, 0.000, 0.000,
                    "Olam Ha-Tohu / Gevurah Thermal Surge (0.395 bits raw entropy — Highest Raw Disorder)",
                    "Engages direct Sigma -1n Negentropy Sink (H_{t+1} = max(0, H_t - 1)) and 12ms Dynamic Shunt Attenuation."
            )
    );

    private static final Map<Integer, PlaneOfExistence> PLANES_BY_ORDER = ALL_PLANES.stream()
            .collect(Collectors.toUnmodifiableMap(PlaneOfExistence::orderIndex, Function.identity()));

    private static final Map<Integer, PrioryRuleAssignment> PRIORY_BY_COLOR_ORDER = PRIORY_ASSIGNMENTS.stream()
            .collect(Collectors.toUnmodifiableMap(PrioryRuleAssignment::colorOrderIndex, Function.identity()));

    public static List<PlaneOfExistence> allPlanesOrderedByColor() {
        return ALL_PLANES;
    }

    public static PlaneOfExistence planeForOrderIndex(int orderIndex) {
        PlaneOfExistence p = PLANES_BY_ORDER.get(orderIndex);
        if (p == null) {
            throw new IllegalArgumentException("No PlaneOfExistence for orderIndex: " + orderIndex);
        }
        return p;
    }

    public static List<PrioryRuleAssignment> allPrioryAssignmentsOrderedBySeat() {
        return PRIORY_ASSIGNMENTS.stream()
                .sorted(BY_PRIORY_SEAT_ASC)
                .toList();
    }

    public static List<PrioryRuleAssignment> allPrioryAssignmentsOrderedByColor() {
        return PRIORY_ASSIGNMENTS.stream()
                .sorted(BY_COLOR_ORDER_7)
                .toList();
    }

    public static PrioryRuleAssignment prioryForColorOrder(int orderIndex) {
        PrioryRuleAssignment a = PRIORY_BY_COLOR_ORDER.get(orderIndex);
        if (a == null) {
            throw new IllegalArgumentException("No PrioryRuleAssignment for colorOrderIndex: " + orderIndex);
        }
        return a;
    }
}
