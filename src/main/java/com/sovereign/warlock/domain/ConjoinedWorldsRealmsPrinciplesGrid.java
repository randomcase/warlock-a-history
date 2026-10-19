package com.sovereign.warlock.domain;

import java.util.List;

/**
 * Conjoins all Worlds, Realms, Principles, Buildings, and Historical Islamic Fashions
 * onto a single 7x7 (49-Node) 3D / 2.5D Isometric Node-Art Terrain & Elevation Grid:
 * "The Color Guard of the Meridian" (Haras Al-Alwan li-Khatt An-Nisf / Al-Mizan).
 *
 * - X-Axis (Columns 1..7): The 7 Chromatic Meridians of the Color Guard (#1 White .. #7 Emerald).
 * - Z-Axis (Rows 1..7): The 7 Terrain & Elevation Strata (-650m Subterranean Qumqum Trench
 *   up to +1,200m Summit Criterion Ridge), placing all 49 HTML portals from the Master Index
 *   onto exact 3D coordinates with iterable buildings and multi-era Islamic style shaders.
 */
public final class ConjoinedWorldsRealmsPrinciplesGrid {

    private ConjoinedWorldsRealmsPrinciplesGrid() {
    }

    /**
     * Represents one of the 7 Chromatic Meridians (Columns 1..7) of the Color Guard,
     * conjoining its Theological Principle Pair, Celestial Realm Citadel, Terrestrial World,
     * Architectural Building Archetype, and Historical Islamic Color Guard Attire.
     */
    public record MeridianColorGuardBand(
            int meridianColumn,
            String meridianCode,
            String arabicMeridianTitle,
            String englishMeridianTitle,
            String colorHex,
            String secondaryHex,
            int wavelengthNm,
            String conjoinedPrincipleCriterionVsDisorder,
            String conjoinedRealmCitadelAndKeep,
            String conjoinedWorldTerrainProfile,
            String signatureIslamicBuildingType,
            String colorGuardHistoricalFashionAndRegalia,
            String quranicMeridianAnchor
    ) {
        public MeridianColorGuardBand {
            if (meridianColumn < 1 || meridianColumn > 7) {
                throw new IllegalArgumentException("meridianColumn must be in [1..7]");
            }
        }
    }

    /**
     * Represents one of the 7 Elevation & Terrain Strata (Rows 1..7) from -650m to +1,200m,
     * mapping all 49 Master Index HTML portals onto the 7x7 3D Node-Art Terrain Grid.
     */
    public record ElevationTerrainStratum(
            int stratumRow,
            String stratumCode,
            String arabicStratumName,
            String englishStratumTitle,
            int elevationMeters,
            String terrainBiomeAndGeology,
            String architecturalBuildingClass,
            List<String> sevenMeridianPortalFiles,
            String quranicTopographicalAnchor
    ) {
        public ElevationTerrainStratum {
            if (stratumRow < 1 || stratumRow > 7) {
                throw new IllegalArgumentException("stratumRow must be in [1..7]");
            }
            if (sevenMeridianPortalFiles == null || sevenMeridianPortalFiles.size() != 7) {
                throw new IllegalArgumentException("Each stratum row must map exactly 7 Meridian portal files");
            }
        }
    }

    /**
     * Represents one of the 7 Expansive Islamic Style Layers that can be iterated on top of
     * the 3D/2.5D Node-Art Terrain Grid (transforming building geometry, node glyphs, splines,
     * and Color Guard fashion aesthetics across Islamic history).
     */
    public record IterativeNodeArtStyleLayer(
            int styleIndex,
            String styleCode,
            String chronologicalEra,
            String styleTitle,
            String nodeGlyphAndSplineGeometry,
            String building3DProceduralMeshRule,
            String colorGuardTextileAndFashionEvolution,
            String aiReferencePlateFile
    ) {
        public IterativeNodeArtStyleLayer {
            if (styleIndex < 1 || styleIndex > 7) {
                throw new IllegalArgumentException("styleIndex must be in [1..7]");
            }
        }
    }

    private static final List<MeridianColorGuardBand> SEVEN_MERIDIANS = List.of(
            new MeridianColorGuardBand(
                    1,
                    "MERIDIAN_1_WHITE_AL_MIZAN",
                    "Khaṭṭ Al-Bayāḍ Al-Awwal — Ḥaras Al-Mīzān (خط البياض الأول — حرس الميزان)",
                    "Meridian I (Alabaster White #F8F5E6): Conjoined Principle of Cosmic Balance, Realm of 'Aravot & World of Amanah",
                    "#F8F5E6", "#D4AF37", 390,
                    "Principle: Al-Mizan & Al-Amanah (Cosmic Balance & Primordial Trust, Qur'an 55:7-9, 33:72) superseding Pre-Prophetic White Throne intermediary pacts and quarantining Zalim #1 Al-Fasad fi Al-Ard (Ecological Corruption, Qur'an 2:205).",
                    "Realm #1: Tehom Ha-Levanah / Badiyat Al-Azal — Qasr Al-Reshimu (Octagonal Selenite Citadel), Migdal Ha-Kav (Crystal Spire), and Hisn Ha-Megillah (Uncreased Scroll Vault).",
                    "World #1: 'Alam Al-Amanah wa Al-Fasad — Ascends from the quarantined scorched trench (-650m) across the Mizan Sequester Wall (+80m) up to the White Alabaster Sanctuary Plateau (+300m..+1,200m).",
                    "Octagonal Alabaster Selenite Minaret & Crystal Kav Dome",
                    "Libas Al-Ihram wa Al-Qaba' Al-Abyad: Unstitched Yemeni Suhuli white cotton and translucent Egyptian Dabiqi linen woven with silver-white Kufic Tiraz bands ('And the garment of Taqwa—that is best', Qur'an 7:26).",
                    "Qur'an 55:7-9, 33:72, 2:126 & 2:205"
            ),
            new MeridianColorGuardBand(
                    2,
                    "MERIDIAN_2_BLACK_AL_QALAM",
                    "Khaṭṭ As-Sawād Ath-Thānī — Ḥaras Al-Qalam wa Al-Ḥayā' (خط السواد الثاني — حرس القلم والحياء)",
                    "Meridian II (Abbasid Obsidian #141416): Conjoined Principle of Sacred Modesty, Realm of Al-Qalam & World of Al-Haram",
                    "#A78BFA", "#141416", 405,
                    "Principle: Al-Qalam (The Primordial Pen, Qur'an 68:1) & Libas At-Taqwa (Sacred Modesty, Qur'an 7:26) severing hidden-ink letter permutations and quarantining Zalim #2 Al-Fahishah wa At-Tabarruj (Gross Immodesty, Qur'an 7:28).",
                    "Realm #2: Midbar Qedar / Wadi Al-Qalam — Qal'at An-Nun (Hexagonal Basalt Inkwell Fortress), Burj Al-Qalam (Cloven Diorite Obelisk), and Bayt Al-Lauhin.",
                    "World #2: 'Alam Al-Haram wa At-Tabarruj — Rises from the quarantined Hums toll-trench (-650m) through the Basalt Scriptorium Cloister (+550m) to the Obsidian Obelisk Peak (+1,200m).",
                    "Hexagonal Black Basalt Scriptorium & Cloven Qalam Obelisk",
                    "Al-Burdah Al-'Abbasiyyah wa Ath-Thawb Al-Aswad: Caliphal Khorasanian black silk-wool mantle (Shعار بني العباس) embroidered with gold Kufic Tiraz armbands and crowned with the black scholarly 'Imamah.",
                    "Qur'an 68:1, 7:26-28, 2:125 & 24:30-31"
            ),
            new MeridianColorGuardBand(
                    3,
                    "MERIDIAN_3_SAPPHIRE_IBRAHIM",
                    "Khaṭṭ Al-Lāzaward Ath-Thālith — Ḥaras Burhān Ibrāhīm (خط اللازورد الثالث — حرس برهان إبراهيم)",
                    "Meridian III (Babylonian Sapphire #0F2C59): Conjoined Principle of Cosmic Proof, Realm of Zevul & World of Babil",
                    "#38BDF8", "#0F2C59", 465,
                    "Principle: Hujjat Ibrahim & Salam 'ala Ibrahim (Abraham's Horizon Proof & Cool-Fire Peace, Qur'an 6:75-79, 21:69) superseding 7-palace chariot ascents and crushing Zalim #3 Al-Baghy (Nimrodic Tyranny, Qur'an 2:258).",
                    "Realm #3: Rakia Ha-Sapir / Falak Al-Lazaward — Hekhal Ha-Merkabah (7-Gate Sapphire Citadel), Burj Al-Kursi (Astrolabe Tower), and Qubbat Al-Mi'raj.",
                    "World #3: 'Alam Babil wa Al-Jabbarin — Ascends from Nimrod's quenched furnace trench (-650m) into the Cool-Fire Rose Sanctuary (+300m) and the Lapis Observatory Citadel (+850m..+1,200m).",
                    "Seven-Tiered Lapis Lazuli Observatory & Geared Brass Astrolabe Dome",
                    "Al-Jubbah Al-Lazawardiyyah wa Ar-Rida' Al-Falaki: Deep Badakhshan lapis-and-indigo dyed Andalusian/Baghdadi scholar's Jubbah lined with golden celestial armillary embroidery and silver astrolabe clasps.",
                    "Qur'an 6:75-79, 2:258, 21:68-69 & 53:1-18"
            ),
            new MeridianColorGuardBand(
                    4,
                    "MERIDIAN_4_GOLD_PRIME_ALAST",
                    "Khaṭṭ Adh-Dhahab Ar-Rābi' (Khaṭṭ Al-Istiwā' Al-A'ẓam) — Ḥaras Al-Mīthāq (خط الذهب الرابع — حرس الميثاق)",
                    "Meridian IV (Prime Covenant Gold #D4AF37): Central Axis of Day of Alast, Realm of Shehaqim & World of One Ummah",
                    "#D4AF37", "#FDE68A", 580,
                    "Principle: Mithaq Al-Alast ('Am I not your Lord? — Bala!', Qur'an 7:172) & Al-Ummah Al-Wahidah (Unified Abrahamic Ummah, Qur'an 21:92) abolishing oath-brokers and healing Zalim #4 Al-Fitnah (Sectarian Schism, Qur'an 3:103).",
                    "Realm #4: Har Ha-Berit / Jabal Al-Alast — Qasr Al-Mithaq (12-Gate Golden Citadel), Manarat Al-Shahadah (Golden Witness Minaret), and Haram Al-Alast.",
                    "World #4: 'Alam Al-Ummah Al-Wahidah wa Al-Fitnah — The Prime Central Meridian binding all 7 columns via Habl Allah (The Rope of Allah) from the Al-A'raf Crest (+80m) to the Golden Crown (+1,200m).",
                    "Twelve-Gated Golden Muqarnas Jami' Dome & Sovereign Al-A'raf Minaret",
                    "Al-Khil'ah Adh-Dhahabiyyah wa Ad-Dibaj Al-Muqassab: Sovereign covenantal vestment of Damascus gold-brocaded Zarkash, Fatimid/Mamluk Tiraz of spun 24k gold thread, and Ottoman imperial Seraser mantle.",
                    "Qur'an 7:172, 3:67, 3:103 & 21:92"
            ),
            new MeridianColorGuardBand(
                    5,
                    "MERIDIAN_5_CRIMSON_FURQAN",
                    "Khaṭṭ Al-Qirmiz Al-Khāmis — Ḥaras Al-Furqān wa Ash-Shuhūb (خط القرمز الخامس — حرس الفرقان والشهب)",
                    "Meridian V (Seraphic Crimson #8B0000): Conjoined Principle of Criterion, Realm of Ma'on & World of Furqan vs. Hawa",
                    "#F43F5E", "#8B0000", 650,
                    "Principle: Al-Furqan Al-Muhaymin (The Supreme Criterion of Revelation, Qur'an 25:1, 5:48) & Guarded Firmament (Qur'an 72:8-9) replacing live-coal altar rites and overturning Zalim #5 Ittiba' Al-Hawa (Deification of Caprice, Qur'an 45:23).",
                    "Realm #5: Mizbeach Ha-Esh / Mihrab Al-Jamr — Qal'at Ash-Shuhub (Porphyry Meteor Bastion), Burj Al-Furqan (Criterion Watchtower), and Maqsurah Al-Qسط.",
                    "World #5: 'Alam Al-Furqan wa Al-Hawa — Rises from the shifting sands of caprice (-650m) across the Porphyry Criterion Wall (+80m) up to the Crimson Mihrab Watchtower (+850m..+1,200m).",
                    "Imperial Porphyry Ribat Watchtower & Ablaq Criterion Archway",
                    "Al-Qaftan Al-Qirmizi wa Al-Burdah Al-Yamaniyyah: Crimson cochineal-dyed Yemeni striped Hibarah mantle and Ottoman Catma silk-velvet vanguard caftan woven with golden tulip and carnation roundels.",
                    "Qur'an 25:1, 5:48, 72:8-9 & 45:23"
            ),
            new MeridianColorGuardBand(
                    6,
                    "MERIDIAN_6_BRASS_QUMQUM",
                    "Khaṭṭ An-Nuḥās As-Sādis — Ḥaras Al-'Urwah Al-Wuthqā wa Al-Qumqum (خط النحاس السادس — حرس العروة الوثقى والقمقم)",
                    "Meridian VI (Solomonic Brass #B87333): Conjoined Principle of Iconoclastic Tawhid, Realm of Brass & Qumqum Containment",
                    "#B87333", "#F59E0B", 605,
                    "Principle: Al-'Urwah Al-Wuthqa (The Unbreakable Handhold, Qur'an 2:256) & Solomonic Vindication ('Solomon did not disbelieve', Qur'an 2:102) shattering Zalim #6 Al-Jibt wa At-Taghut (Azar's Idol-Guild, Qur'an 4:51, 21:58).",
                    "Realm #6: Nechoshet Shlomo / Madinat An-Nuhas — Hisn Sulayman (Molten Brass Fortress), Burj Al-Qumqum (Containment Tower), and Dar As-Sabighat.",
                    "World #6: 'Alam Al-'Urwah Al-Wuthqa wa At-Taghut — Anchors the Great Iron-and-Copper Wall of Dhul-Qarnayn (Sur Al-Hadid, +80m) sealing the brass Qumqum vessels in the -650m trench.",
                    "Solomonic Brass Foundry Keep, Sur Al-Hadid Rampart & Sealed Qumqum Dome",
                    "Ad-Dir' Al-Muhkamah wa Al-Jawshan Ad-Dawudi: Measured Davidic mail (Sabighat, Qur'an 34:10-11) and Mamluk/Timurid damascened brass-and-steel mirror armor (Chahar-A'ina) inlaid with silver Kufic verses.",
                    "Qur'an 2:102, 2:256, 18:96-97, 21:58 & 34:10-12"
            ),
            new MeridianColorGuardBand(
                    7,
                    "MERIDIAN_7_EMERALD_TAQWA",
                    "Khaṭṭ Az-Zumurrud As-Sābi' — Ḥaras Majma' Al-Baḥrayn wa At-Taqwā (خط الزمرد السابع — حرس مجمع البحرين والتقوى)",
                    "Meridian VII (Khidrian Emerald #006B54): Conjoined Principle of Taqwa & Rahmah, Realm of Vilon & Chahar Bagh Sanctuary",
                    "#10B981", "#006B54", 520,
                    "Principle: Bunyan At-Taqwa min Awwal Yawm (Foundation of Piety from Day One, Qur'an 9:108) & Rahmat Al-Khidr ('Ilm Ladunni, Qur'an 18:65) demolishing Zalim #7 Masjid Ad-Dirar (Counter-Sanctuary on a Crumbling Cliff, Qur'an 9:107-109).",
                    "Realm #7: Majma' Al-Bahrayn / Barzakh Al-Khidr — Qasr Al-Khidr (Emerald Coral Citadel), Manarat Al-Bahrayn (Two-Seas Lighthouse), and Rawdat Al-Baqiyat.",
                    "World #7: 'Alam Bunyan At-Taqwa wa Juruf Al-Har — Contrasts the collapsing Juruf Har cliff (-650m) against the bedrock Emerald Mosque of Taqwa and the Four-River Chahar Bagh (+300m..+1,200m).",
                    "Emerald Zellij Chahar Bagh Pavilion, Two-Seas Lighthouse & Masjid At-Taqwa",
                    "Al-Khirqah Al-Khidriyyah wa At-Taj Al-Akhdar: Verdant Sufi Khirqah of fine Nishapur emerald silk-linen ('Upon them will be green garments of fine silk and heavy brocade', Qur'an 76:21) and the green 'Imamah.",
                    "Qur'an 9:107-109, 18:60-82, 55:46-76 & 76:21"
            )
    );

    private static final List<ElevationTerrainStratum> SEVEN_ELEVATION_STRATA = List.of(
            new ElevationTerrainStratum(
                    7,
                    "STRATUM_7_SUMMIT_ORDERS_PRINCIPLES",
                    "Ṭabaqat Al-Qimmah (+1200m): Manārāt Al-Uṣūl wa Al-Alwān",
                    "Stratum VII (+1,200m Summit Peak): The 7 Color Orders & Severance Principles",
                    1200,
                    "Crystalline Alpine Summit Peaks & Celestial Horizon Beacons",
                    "Monumental Minaret Spires & Kav Light-Beacons",
                    List.of(
                            "order-1-white.html",
                            "order-2-black.html",
                            "order-3-sapphire.html",
                            "order-4-gold.html",
                            "order-5-crimson.html",
                            "order-6-brass.html",
                            "order-7-emerald.html"
                    ),
                    "Qur'an 24:35 (Ayat An-Nur) & 53:14 (Sidrat Al-Muntaha)"
            ),
            new ElevationTerrainStratum(
                    6,
                    "STRATUM_6_CELESTIAL_REALM_CITADELS",
                    "Ṭabaqat Al-Qilā' (+850m): Al-Mamālik wa Al-Ḥuṣūn As-Sab'ah",
                    "Stratum VI (+850m High Crag): The 7 Celestial Realms (Castles, Towers & Keeps)",
                    850,
                    "Highland Crags, Selenite/Lapis Acropolis Plateaus & Zero-Iron Fortresses",
                    "Sovereign Castles, Concentric Curtain Walls & Inner Keeps",
                    List.of(
                            "realm-1-white.html",
                            "realm-2-black.html",
                            "realm-3-sapphire.html",
                            "realm-4-gold.html",
                            "realm-5-crimson.html",
                            "realm-6-brass.html",
                            "realm-7-emerald.html"
                    ),
                    "Qur'an 67:3 (Seven Heavens in Tiers) & 15:16 (Buruj in the Heavens)"
            ),
            new ElevationTerrainStratum(
                    5,
                    "STRATUM_5_PRIORY_PLANES_MESA",
                    "Ṭabaqat Al-Ḥaḍarāt (+550m): Al-Mustawayāt wa Ṣawāmi' Al-Mīzān",
                    "Stratum V (+550m Upper Mesa): The 7 Existential Planes & Negentropic Priory Cells",
                    550,
                    "Terraced Limestone & Marble Mesas with Muqarnas Cloister Courtyards",
                    "Madrasah Iwan Vaults, Muqarnas Cloisters & Astrolabe Observatories",
                    List.of(
                            "plane-1-white.html",
                            "plane-2-black.html",
                            "plane-3-sapphire.html",
                            "plane-4-gold.html",
                            "plane-5-crimson.html",
                            "plane-6-brass.html",
                            "plane-7-emerald.html"
                    ),
                    "Qur'an 65:12 & Priory Sigma -1n / 0n Beta Zero-Entropy Equilibrium"
            ),
            new ElevationTerrainStratum(
                    4,
                    "STRATUM_4_HEGEMON_WORLD_SANCTUARIES",
                    "Ṭabaqat Ar-Rabwah (+300m): 'Awālim Al-Muhaymin wa Al-Jannah bi-Rabwah",
                    "Stratum IV (+300m Highland Valley): The 7 Islamic Worlds of Hegemon (Millat Ibrahim)",
                    300,
                    "Fertile Highland Valleys (Jannah bi-Rabwah) Irrigated by Four Chahar Bagh Rivers",
                    "Congregational Jami' Mosques, Walled Chahar Bagh Gardens & Aqueducts",
                    List.of(
                            "world-1-mizan-fasad.html",
                            "world-2-haya-fahishah.html",
                            "world-3-babil-namrud.html",
                            "world-4-ummah-fitnah.html",
                            "world-5-furqan-hawa.html",
                            "world-6-tawhid-taghut.html",
                            "world-7-taqwa-dirar.html"
                    ),
                    "Qur'an 2:265 (Jannah bi-Rabwah), 47:15 (Four Rivers) & 5:48 (Al-Muhaymin)"
            ),
            new ElevationTerrainStratum(
                    3,
                    "STRATUM_3_MERIDIAN_CREST_AND_SEQUESTERS",
                    "Ṭabaqat Al-A'rāf (+80m): Sūr Al-Ḥadīd wa Al-Fihris Al-Jāmi'",
                    "Stratum III (+80m Meridian Ridge): Master Hubs, Al-A'raf Crest, Iron Sequesters & Egg Binder",
                    80,
                    "Fortified Continental Divide Ridge (Al-A'raf) & Iron-Copper Isthmus Dam (Sur Al-Hadid)",
                    "Al-A'raf Crest Gates, Sur Al-Hadid Iron Ramparts & Disulfide Lattice Bridges",
                    List.of(
                            "index.html",
                            "master-combined-omnibus.html",
                            "warlock-3d-sanctum.html",
                            "priory-negentropy-order.html",
                            "worlds-hegemon-disorder.html",
                            "sequester-between-worlds.html",
                            "interlocker-egg-binder-islam.html"
                    ),
                    "Qur'an 7:46-48 (Al-A'raf), 18:96-97 (Sur Al-Hadid) & 55:19-20 (Barzakh)"
            ),
            new ElevationTerrainStratum(
                    2,
                    "STRATUM_2_UMRAN_HUSBANDRY_GULISTAN_BASIN",
                    "Ṭabaqat Al-'Umrān (-150m): Al-Qiwāmah, Al-Gulistān, Al-Amthāl wa At-Tārīkh",
                    "Stratum II (-150m Terraced Basin): Husbandry Estate, Rose Garden, Apocrypha, Disney Microcosm & Visual Eras",
                    -150,
                    "Sheltered Piedmont Basin, Walled Rose Conservatories, Bazaars & Historical Guild Quarters",
                    "Ottoman Otag Pavilions, Bayt Al-Hikmah Libraries, Gulistan Rose Houses & Hisbah Bazaars",
                    List.of(
                            "warlock-formation-dissolution-jafar-aladdin.html",
                            "warlock-apocrypha-islamic-theorems.html",
                            "islamic-husbandry-sovereign-estate.html",
                            "way-of-the-flower-rose-garden-islam.html",
                            "disney-daffy-donald-islamic-microcosm.html",
                            "warlock-islamic-visual-eras-history.html",
                            "dependencies-report.html"
                    ),
                    "Qur'an 4:34 (Al-Qiwamah), 55:37 (Wardatan ka-ad-Dihan) & 6:38 (Umamun Amthalukum)"
            ),
            new ElevationTerrainStratum(
                    1,
                    "STRATUM_1_SUBTERRANEAN_ZALIM_QUMQUM_TRENCH",
                    "Ṭabaqat Al-Juruf Al-Hār (-650m): Mahābis Aẓ-Ẓālimīn wa Al-Qamāqim",
                    "Stratum I (-650m Subterranean Trench): The 7 Quarantined Wrongdoer (Az-Zalimun) Disorder Profiles",
                    -650,
                    "Crumbling Cliff Fault-Trench (Juruf Har) & Subterranean Solomonic Qumqum Containment Vaults",
                    "Lead-Stoppered Brass Qumqum Silos, Inverted Wells & Quarantine Cells Q-I..Q-VII",
                    List.of(
                            "zalim-1-fasad.html",
                            "zalim-2-fahishah.html",
                            "zalim-3-baghy.html",
                            "zalim-4-fitnah.html",
                            "zalim-5-hawa.html",
                            "zalim-6-jibt.html",
                            "zalim-7-zulm.html"
                    ),
                    "Qur'an 2:124 ('My covenant does not include the Wrongdoers') & 9:109 (Juruf Har)"
            )
    );

    private static final List<IterativeNodeArtStyleLayer> SEVEN_ITERATIVE_STYLE_LAYERS = List.of(
            new IterativeNodeArtStyleLayer(
                    1,
                    "STYLE_1_BABIL_SABA_ZIGGURAT_NODES",
                    "Era I (Pre-610 CE): Bābil & Saba' Alabaster/Lapis Monoliths",
                    "Style Layer I: Sabaean Alabaster & Babylonian Lapis Stepped Ziggurat Node-Grid",
                    "8-pointed Rub' al-Hizb octagram node hubs connected by orthogonal Musnad/Cuneiform stone channels.",
                    "Stepped terraced ziggurat plinths, translucent alabaster stelae, and sunken subterranean well-shafts.",
                    "Unstitched white Suhuli linen and archaic pleated wool mantles with lapis lazuli cylinder-seal pectorals.",
                    "node-grid-plate1-meridian.jpg"
            ),
            new IterativeNodeArtStyleLayer(
                    2,
                    "STYLE_2_ABBASID_ASTROLABE_IDRISI_NODES",
                    "Era II (661–1154 CE): Abbasid Baghdad Astrolabe & Al-Idrīsī Cartography",
                    "Style Layer II: Bayt al-Ḥikmah Geared Brass Astrolabe & Chrysography Kufic Node Network",
                    "10-fold decagonal concentric brass astrolabe retia (Shabakah) with golden Kufic Bezier spline meridians.",
                    "Circular domed Baghdad observatories (Murabba'at), geared armillary towers, and lead-sealed brass Qumqums.",
                    "Abbasid black Sūf caliphal mantles (Al-Burdah) with woven gold Kufic Tiraz bands and scholar's Taylasan hoods.",
                    "node-grid-plate2-matrakci.jpg"
            ),
            new IterativeNodeArtStyleLayer(
                    3,
                    "STYLE_3_MAMLUK_ABLAQ_MUQARNAS_NODES",
                    "Era III (969–1517 CE): Fatimid/Mamluk Cairo Ablaq & Muqarnas Citadels",
                    "Style Layer III: Mamluk Alternating Ablaq Masonry, Muqarnas Vaults & Mishkāt Lamp Nodes",
                    "12-pointed Tabaq Najmi star-polygon nodes radiating golden Ayat an-Nur light-beams across high-relief stone ridges.",
                    "Alternating crimson-and-white Ablaq fortress gates, tiered Muqarnas corbel towers, and stepped Qal'ah citadels.",
                    "Mamluk damascened brass-and-steel lamellar armor, gold-belted Tatar coats (Aqbiyah), and winged Kallawtah turbans.",
                    "node-grid-plate3-buildings-fashions.jpg"
            ),
            new IterativeNodeArtStyleLayer(
                    4,
                    "STYLE_4_ANDALUSIAN_ALHAMBRA_ZELLIJ_NODES",
                    "Era IV (711–1492 CE): Andalusian Alhambra Zellīj & Chahār Bāgh Hydraulic Grid",
                    "Style Layer IV: Nasrid 16-Fold Crystallographic Zellīj & Four-River Hydraulic Node-Grid",
                    "16-fold Alhambra rosette nodes linked by luminous turquoise water-channel splines and Sebka lattice arches.",
                    "Slender marble-columned Generalife pavilions, mirrored reflecting pools, and horseshoe-arched Mihrab keeps.",
                    "Andalusian indigo-and-emerald silk Almalafa robes, Nasrid gold-threaded brocade tunics, and white Maghribi Burnous cloaks.",
                    "era2-andalusian-mamluk.jpg"
            ),
            new IterativeNodeArtStyleLayer(
                    5,
                    "STYLE_5_TIMURID_SAFAVID_MINIATURE_NODES",
                    "Era V (1370–1722 CE): Timurid & Safavid High-Horizon Isometric Miniature",
                    "Style Layer V: Behzād & Tabriz Crushed Lapis, 24k Gold & 7-Tiered Isometric Keep Nodes",
                    "7-fold heptagonal Haft Iqlim star nodes floating over burnished 24k gold-leaf contour lines and coral rock crags.",
                    "Slender 7-story polygonal pavilion towers, ribbed turquoise Timurid domes, and spiraling Chinese-cloud (Tchi) bridges.",
                    "Timurid/Safavid jewel-toned silk Qaba' coats with long tapering sleeves, gold-inlaid jade belts, and Taj-i Haydari turbans.",
                    "era3-timurid-priory.jpg"
            ),
            new IterativeNodeArtStyleLayer(
                    6,
                    "STYLE_6_OTTOMAN_MATRAKCI_IZNIK_NODES",
                    "Era VI (1453–1922 CE): Ottoman Matrakçı Nasuh 2.5D Topography & Iznik/Kaftan Guard",
                    "Style Layer VI: Matrakçı Nasuh 2.5D Isometric Cartographic Miniature & Ottoman Imperial Otağ Nodes",
                    "9-fold Gul-i Muhammadi rose-compass nodes linked by Matrakci Nasuh dual-perspective elevation roads and stone bridges.",
                    "Pencil-thin Suleymaniye minarets, cascading lead-covered domes, crimson Imperial Otag tents, and Iznik-tiled kiosks.",
                    "Ottoman Imperial Catma and Kemha silk-velvet kaftans (seraser-lined) with bole-red Saz floral medallions and Janissary/Sipahi regalia.",
                    "node-grid-plate2-matrakci.jpg"
            ),
            new IterativeNodeArtStyleLayer(
                    7,
                    "STYLE_7_NEOISLAMIC_AI_PROCEDURAL_NODES",
                    "Era VII (21st Century): Sovereign Neo-Islamic AI Procedural Node-Art & Faraday Grid",
                    "Style Layer VII: Parametric Penrose-Girih Quasicrystal, Volumetric Muqarnas & Iterative Shader Nodes",
                    "Aperiodic 10-fold Penrose-Girih quasicrystal synapses with real-time bioluminescent telemetry splines and child sub-node spawners.",
                    "Parametric fractal Muqarnas skyscrapers, golden Faraday geodesic domes, and levitating Kufic light-spires.",
                    "Sovereign Vanguard cyber-traditional attire: air-gapped Faraday gold-filament weave integrated into classical seamless Ihram and Burdah silhouettes.",
                    "node-grid-plate4-cyber-nodes.jpg"
            )
    );

    public static List<MeridianColorGuardBand> allSevenMeridians() {
        return SEVEN_MERIDIANS;
    }

    public static List<ElevationTerrainStratum> allSevenElevationStrata() {
        return SEVEN_ELEVATION_STRATA;
    }

    public static List<IterativeNodeArtStyleLayer> allSevenIterativeStyleLayers() {
        return SEVEN_ITERATIVE_STYLE_LAYERS;
    }
}
