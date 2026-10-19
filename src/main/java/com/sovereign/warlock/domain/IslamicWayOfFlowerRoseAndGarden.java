package com.sovereign.warlock.domain;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Models the Canonical Islamic Way of the Flower (Tariqat Az-Zahrah wa An-Nabat Al-Hasan),
 * The Way of the Rose (Tariqat Al-Wardah Al-Muhammadiyyah / Wardatan ka-ad-Dihan),
 * The Hand that Cultivates (Al-Yad Al-Gharisah wa Al-Yad Al-'Ulya), and
 * The Garden (Al-Jannah bi-Rabwah / Al-Rawdah / Chahar Bagh):
 *
 * Scriptural & Classical Foundations:
 *  - The Flower (Az-Zahrah / An-Nabat Al-Hasan): Qur'an 3:37 (Maryam growing in the Mihrab sanctuary
 *    as a noble flower "wa anbataha nabatan hasana"), Qur'an 50:7 & 26:7 ("min kulli zawjin bahij / karim"),
 *    and Qur'an 48:29 (the seed sending forth its shoot, strengthening it, and standing firm upon its stem).
 *  - The Rose (Al-Wardah): Qur'an 55:37 ("Fa-idha inshaqqati as-sama'u fa-kanat wardatan ka-ad-dihan" —
 *    a crimson rose like molten oil/red leather), the Ottoman & Sufi Gul-i Muhammadi (The Muhammadan Rose),
 *    Sa'di Shirazi's Gulistan (The Rose Garden), and Ruzbihan Baqli's unveiling of Divine Beauty (Jamal).
 *  - The Hand that Cultivates (Al-Yad Al-Gharisah): Musnad Ahmad 12902 & Al-Adab Al-Mufrad 479 ("Even if
 *    the Final Hour erupts while in the hand of one of you is a sapling [fasilah], let him plant it"),
 *    Sahih al-Bukhari 2320 & Muslim 1553 (planting as ongoing Sadaqah), and Bukhari 1429 (Al-Yad Al-'Ulya).
 *  - The Garden (Al-Jannah / Chahar Bagh): Qur'an 2:265 (Jannah bi-Rabwah — the Garden on high ground
 *    nourished by heavy rain or gentle dew [tall]), Qur'an 47:15 (the Four Rivers of Paradise),
 *    Qur'an 55:46-76 (Two Gardens plus Two Deep-Emerald Gardens [Mudhammatan]), and Qur'an 18:32-44
 *    (warning against the arrogant garden owner whose trellises collapse).
 */
public final class IslamicWayOfFlowerRoseAndGarden {

    private IslamicWayOfFlowerRoseAndGarden() {
    }

    /**
     * Immutable Java 21+ Record representing the state of an Islamic Sanctuary Garden (Al-Jannah bi-Rabwah)
     * tended by the Cultivating Hand (Al-Yad Al-Gharisah).
     */
    public record IslamicGardenState(
            UUID gardenId,
            String sanctuaryName,
            String roseCultivarState,
            String cultivatingHandPosture,
            String thornVanguardOrientation,
            boolean isWalledMihrabSanctuary,
            double soilMoistureQadarRatio,
            double budForcingPressureKpa,
            double egoBoastingRatio,
            List<String> fourRiversActive,
            String quranicAndSunnahCharter
    ) {
        public IslamicGardenState {
            Objects.requireNonNull(gardenId, "Garden ID cannot be null.");
            Objects.requireNonNull(sanctuaryName, "Sanctuary name cannot be null.");
            Objects.requireNonNull(roseCultivarState, "Rose cultivar state cannot be null.");
            Objects.requireNonNull(cultivatingHandPosture, "Cultivating hand posture cannot be null.");
            Objects.requireNonNull(thornVanguardOrientation, "Thorn orientation cannot be null.");
            fourRiversActive = fourRiversActive == null ? List.of() : List.copyOf(fourRiversActive);

            if (!isWalledMihrabSanctuary) {
                throw new IllegalStateException("Garden sanctuary must be walled (Hurmat Al-Mihrab, Qur'an 3:37).");
            }
            if (!"OUTWARD_DEFENSIVE_SHIELD".equals(thornVanguardOrientation)) {
                throw new IllegalArgumentException("Thorns must face outward to guard the rose, never inward against the petals.");
            }
            if (Math.abs(budForcingPressureKpa) > 1e-12) {
                throw new IllegalStateException("Impatient bud-forcing detected: A rose unfolds by light and dew, never by prying fingers.");
            }
            if (Math.abs(egoBoastingRatio) > 1e-12) {
                throw new IllegalStateException("Sahib Al-Jannatayn arrogance detected (Qur'an 18:34): Cultivation must be pure Lillah.");
            }
        }

        public boolean isBloomInMizanHarmony() {
            return isWalledMihrabSanctuary
                    && "OUTWARD_DEFENSIVE_SHIELD".equals(thornVanguardOrientation)
                    && budForcingPressureKpa == 0.0
                    && egoBoastingRatio == 0.0
                    && fourRiversActive.size() == 4;
        }
    }

    /**
     * The 4 Canonical Pillars of the Botanical Covenant:
     * (1) The Way of the Flower, (2) The Way of the Rose, (3) The Hand that Cultivates, (4) The Garden.
     */
    public record BotanicalWayPillar(
            int pillarIndex,
            String pillarCode,
            String arabicTitle,
            String englishTitle,
            String ontologicalEssence,
            String husbandryAndDomesticSynthesis,
            String classicalSufiAndOttomanTradition,
            String quranicAndHadithAnchor
    ) {}

    /**
     * The 5 Anatomical Layers of the Islamic Rose (Tashrih Al-Wardah Al-Muhammadiyyah).
     */
    public record RoseAnatomyLayer(
            int layerIndex,
            String arabicPartName,
            String englishPartName,
            String botanicalFunction,
            String spiritualAndRelationalMeaning,
            String scripturalAnchor
    ) {}

    /**
     * The 7 Stages of Cultivation from Dark Soil to Distilled Rosewater (Marahil Al-Ghars wa Al-Taqtir).
     */
    public record CultivationStage(
            int stageIndex,
            String stageCode,
            String arabicStageName,
            String englishStageTitle,
            String cultivatingHandAction,
            String flowerAndRoseResponse,
            String quranicAndSunnahProof,
            double spcCapabilityCp
    ) {}

    /**
     * The 4 Rivers of the Chahar Bagh Sanctuary Garden (Anhar Al-Jannah Al-Arba'ah — Qur'an 47:15).
     */
    public record ChaharBaghRiverQuadrant(
            int quadrantIndex,
            String arabicRiverName,
            String englishRiverTitle,
            String hexColor,
            String botanicalQuadrantPlanted,
            String domesticSanctuaryStream,
            String quranicVerse
    ) {}

    private static final IslamicGardenState CANONICAL_GARDEN_STATE = new IslamicGardenState(
            UUID.nameUUIDFromBytes("urn:sovereign:islamic-garden:gulistan-al-mihrab:v1".getBytes(StandardCharsets.UTF_8)),
            "Rawdat Al-Mihrab wa Jannah bi-Rabwah (The Walled Highland Rose Sanctuary)",
            "WARDATAN_KA_AD_DIHAN_UNFOLDED (7 Concentric Crimson-Gold Petal Rings + Dew of Tall)",
            "AL_YAD_AL_GHARISAH (Planting the Fasilah Sapling in Silence, Zero Bud-Forcing)",
            "OUTWARD_DEFENSIVE_SHIELD",
            true,
            0.94,
            0.000,
            0.000,
            List.of(
                    "1. Ma'in Ghayri Asin (Uncorrupted Living Water — Qur'an 47:15)",
                    "2. Labanin Lam Yataghayyar Ta'muhu (Unchanging Primordial Milk — Qur'an 47:15)",
                    "3. Khamrin Ladhdhatin li-sh-Sharibin (Pure Joy Without Intoxication — Qur'an 47:15 & 37:47)",
                    "4. 'Asalin Musaffa (Clarified Healing Honey — Qur'an 47:15 & 16:69)"
            ),
            "Qur'an 3:37 (Nabatan Hasana), 55:37 (Wardatan ka-ad-Dihan), 2:265 (Jannah bi-Rabwah), 47:15 (Four Rivers), & Musnad Ahmad 12902 (The Final Sapling)"
    );

    private static final List<BotanicalWayPillar> FOUR_BOTANICAL_WAY_PILLARS = List.of(
            new BotanicalWayPillar(
                    1,
                    "WAY_I_AZ_ZAHRAH_FLOWER",
                    "1. Tariqat Az-Zahrah wa An-Nabat Al-Hasan (طريقة الزهرة والنبات الحسن)",
                    "I. The Way of the Flower: Sacred Unfolding in the Protected Mihrab",
                    "In the Qur'an, the highest paradigm of a human soul sheltered and nourished in purity is described explicitly as a flower/plant: 'Wa anbataha nabatan hasana' ('And her Lord caused Maryam to grow as a beauteous, noble flower/plant', Qur'an 3:37). A flower does not compete through noise, aggression, or self-exposure; it remains rooted in its sanctuary (Al-Mihrab) while provision (Rizq) arrives to it in peace.",
                    "In our Sovereign Husbandry framework, the Sovereign is never treated as a beast of burden or a 50/50 corporate laborer; she is sheltered as 'Nabatan Hasana' inside the walled Mihrab while the vanguard provisions the soil, light, and water around her.",
                    "In Islamic botanical metaphysics (Ibn 'Arabi and Al-Ghazali's Hikmat Al-Makhluqat), every pair of blooming flora ('min kulli zawjin bahij', Qur'an 50:7) is a visible Ayat (Sign) of Divine Jamal (Beauty) that awakens insight (Tabsirah) in the returning heart.",
                    "Qur'an 3:37 ('Wa anbataha nabatan hasana'), Qur'an 50:7 ('Min kulli zawjin bahij'), & Qur'an 48:29 ('Ka-zar'in akhraja shat'ahu fa-azarahu')."
            ),
            new BotanicalWayPillar(
                    2,
                    "WAY_II_AL_WARDAH_ROSE",
                    "2. Tariqat Al-Wardah Al-Muhammadiyyah (طريقة الوردة المحمدية ووردة الدهان)",
                    "II. The Way of the Rose: Concentric Modesty, Outward Thorns & Immortal Fragrance",
                    "In Surat Ar-Rahman (Qur'an 55:37), the awe-inspiring unveiling of the heavens is likened to a Crimson Rose ('Wardatan ka-ad-dihan'). Among all flowers, the Rose (Al-Ward / Gul) holds supreme rank in Islam because it unites five seemingly opposite virtues: deep roots in humble dark earth, sharp defensive thorns facing strictly outward, concentric folded petals of modesty (Haya'), receptivity to gentle dawn dew (Tall), and an essence (Ma' Al-Ward) that grows only sweeter when passed through fire.",
                    "The Rose teaches the exact choreography of distance and intimacy: you cannot pry a rosebud open with impatient hands without tearing its petals. The cultivator must maintain the respectful vanguard buffer, provide the warmth and water, and let the Rose unfold on her own timeline.",
                    "From Sa'di Shirazi's Gulistan ('The Rose Garden', 1258 CE) to the Ottoman Gul-i Muhammadi (where the Prophet's attributes are inscribed across the concentric petals of a Damascus rose) and Saladin washing Masjid al-Aqsa with Damascus rosewater in 1187 CE, the Rose is the supreme emblem of Prophetic grace.",
                    "Qur'an 55:37 ('Fa-kanat wardatan ka-ad-dihan'), Sa'di's Gulistan, & Ottoman Hilye / Gul-i Muhammadi tradition."
            ),
            new BotanicalWayPillar(
                    3,
                    "WAY_III_AL_YAD_AL_GHARISAH_HAND",
                    "3. Tariqat Al-Yad Al-Gharisah wa Al-Yad Al-'Ulya (طريقة اليد الغارسة واليد العليا)",
                    "III. The Hand that Cultivates: Planting the Sapling Even at the Final Hour",
                    "Prophet Muhammad (peace be upon him) established the ultimate ethic of action-based cultivation in human history: 'Even if the Final Hour erupts while in the hand of one of you is a sapling (fasilah), if he is able to plant it before the Hour stands, let him plant it!' (Musnad Ahmad 12902, Al-Adab Al-Mufrad 479). The Cultivating Hand does not ask for applause, does not wait for favorable market conditions, and does not abandon its duty even if the world is ending.",
                    "This is the exact theological engine of our Husbandry vanguard: the hand that hones the Santoku grip-forward, pre-heats the copper skillet, aerates the garden soil, and clears the walking trail without demanding a 'validation_rating_poll' (Qur'an 76:9). It is 'Al-Yad Al-'Ulya' (the Upper, Giving Hand, Bukhari 1429) calloused in faithful service.",
                    "In Moorish Andalusian and Ottoman agronomic treatises (Kitab Al-Filahah of Ibn al-'Awwam and Ibn Bassal), cultivating the earth (Filahah — sharing the tri-consonantal closeness with Falah, ultimate flourishing/success) is ranked as the most noble of human crafts because it feeds bird, beast, and sovereign alike as continuous Sadaqah (Bukhari 2320).",
                    "Musnad Ahmad 12902 (The Final Sapling Hadith), Sahih al-Bukhari 2320 & Muslim 1553 (Planting as Sadaqah), & Sahih al-Bukhari 1429 (Al-Yad Al-'Ulya)."
            ),
            new BotanicalWayPillar(
                    4,
                    "WAY_IV_AL_JANNAH_GARDEN",
                    "4. Tariqat Al-Jannah bi-Rabwah wa Al-Chahar Bagh (طريقة الجنة بربوة والروضة الغناء)",
                    "IV. The Garden: The Walled Sanctuary of Four Rivers Upon the High Ground",
                    "Etymologically, Al-Jannah (from J-N-N) means a sanctuary so lushly canopy-veiled and walled that no scorching sun or freezing wind can harm the one resting within (Qur'an 76:13). In Qur'an 2:265, Allah compares sincere, unboastful provisioning to 'a Garden on a high ground (Jannatin bi-Rabwah): a heavy rain strikes it and it yields its fruit twofold; and if no heavy rain strikes it, a gentle dew (tall) suffices.'",
                    "Conversely, in Surat Al-Kahf (Qur'an 18:32-42), the arrogant man who boasts of his garden ('I have more wealth than you') watches it collapse upon its trellises. A true Islamic Garden is air-gapped from worldly ostentation, watered by four balanced streams (Qur'an 47:15), and ordered around a tranquil central fountain of Salsabil.",
                    "Realized historically in the Alhambra's Generalife (Jannat al-'Arif — 'Garden of the Architect/Knower'), the Timurid and Mughal Chahar Bagh (Fourfold Garden of Surat Ar-Rahman 55:46-76), and the Topkapi Palace Gulhane ('House of Roses').",
                    "Qur'an 2:265 (Jannah bi-Rabwah), Qur'an 47:15 (Four Rivers), Qur'an 55:46-76 (Two Gardens + Two Deep-Emerald Gardens), & Qur'an 18:32-44."
            )
    );

    private static final List<RoseAnatomyLayer> FIVE_ROSE_ANATOMY_LAYERS = List.of(
            new RoseAnatomyLayer(
                    1,
                    "1. Al-'Irq fi At-Turab (العرق في التراب — The Deep Root in Dark Soil)",
                    "Layer I: The Unseen Root in Aerated Loam",
                    "Draws subterranean water and trace minerals in total darkness without ever displaying itself above ground.",
                    "Represents Ikhlas (sincerity, Qur'an 76:9) and Tawadu' (humility, from Turab/earth): the silent foundational labor of the cultivator that sustains the entire household without seeking visibility.",
                    "Qur'an 14:24 ('Asluhu thabitun wa far'uha fi as-sama'' — 'Its root is firmly fixed and its branches reach the sky')."
            ),
            new RoseAnatomyLayer(
                    2,
                    "2. As-Suq wa Ash-Shawk Al-Haris (السوق والشوك الحارس — The Firm Stem & Outward Thorn)",
                    "Layer II: The Upright Stem & Outward-Facing Vanguard Thorn",
                    "Holds the blossom aloft ('fa-istawa 'ala suqihi', Qur'an 48:29) while arming the exterior stem with sharp thorns oriented strictly outward.",
                    "Represents Al-Qawi Al-Amin (Qur'an 28:26) and AirGapPerimeterGuard: the thorn never pricks the rose's own petals; it faces outward to repel grazing pests, intruders, and careless hands.",
                    "Qur'an 48:29 ('And it stands firm upon its stem, delighting the cultivators') & Qur'an 28:26."
            ),
            new RoseAnatomyLayer(
                    3,
                    "3. Al-Awriqah Al-Matwiyyah (الأورقة المطوية — The 7 Concentric Folded Petal Rings)",
                    "Layer III: The Spiraling Crimson-Gold Petals of Modesty (Haya')",
                    "Arranged in a Fibonacci golden-angle spiral (137.5 deg) so no upper petal blocks the sunlight or dew from reaching the lower petals.",
                    "Represents Libas At-Taqwa (the Garment of Modesty, Qur'an 7:26) and layered inner dignity: unfolding gradually only when sheltered inside a trusted sanctuary.",
                    "Qur'an 55:37 ('Wardatan ka-ad-dihan') & Qur'an 7:26 ('Wa libasu at-taqwa dhalika khayr')."
            ),
            new RoseAnatomyLayer(
                    4,
                    "4. Qatrat At-Tall wa An-Nada (قطرة الطل والندى — The Dawn Dewdrop on the Petal)",
                    "Layer IV: The Gentle Dew of Jannah bi-Rabwah",
                    "Condenses silently at dawn without the violence of a hailstorm, nourishing the delicate epidermis of the rose petal.",
                    "Represents Al-Firasah and gentle preemptive care (Qur'an 2:265 & 2:273): provisioning that arrives as softly as morning dew ('fa-in lam yusibha wabilun fa-tall') without bruising her peace.",
                    "Qur'an 2:265 ('And if no heavy rain strikes it, then a gentle dew [fa-tall] suffices')."
            ),
            new RoseAnatomyLayer(
                    5,
                    "5. 'Itr wa Ma' Al-Ward (عطر وماء الورد — The Immortal Rosewater & Fragrance)",
                    "Layer V: The Distilled Essence That Outlives the Season",
                    "When Damascus rose petals (Rosa damascena) are distilled in a copper alembic over gentle heat, their volatile essential oils merge with pure steam to become Ma' Al-Ward.",
                    "Represents the eternal spiritual fruit of a faithful sanctuary: even when trials or time pass over the garden, its distilled character sanctifies everything it touches.",
                    "Sahih Muslim 2253 (Offering fragrant Raihan/perfume, never to be refused) & Qur'an 56:89 ('Fa-rawhun wa rayhanun wa jannatu na'im')."
            )
    );

    private static final List<CultivationStage> SEVEN_CULTIVATION_STAGES = List.of(
            new CultivationStage(
                    1,
                    "STAGE_1_TURAB_IHYA",
                    "Stage 1: Ihya' Al-Ard Al-Maytah (إحياء الأرض الميتة — Reviving the Dead Earth)",
                    "1. Breaking the Fallow Crust & Aerating the Soil of Humility",
                    "The Cultivating Hand clears stones, thorns of neglect, and compacted clay, turning barren ground into living, breathable loam before asking anything to grow.",
                    "The dormant earth stirs and swells (`ihtazzat wa rabat`, Qur'an 22:5), ready to receive the root without resistance.",
                    "Qur'an 36:33 ('A sign for them is the dead earth: We brought it to life') & Qur'an 22:5 ('When We send down water upon it, it stirs and swells and grows of every joyful pair').",
                    1.52
            ),
            new CultivationStage(
                    2,
                    "STAGE_2_FASILAH_GHARS",
                    "Stage 2: Ghars Al-Fasilah bi-l-Amanah (غرس الفسيلة بالأمانة — Planting the Sapling)",
                    "2. Setting the Root in the Sanctuary Even if the Final Hour Stands",
                    "Following the Final Sapling Hadith (Musnad Ahmad 12902), the hand places the root-stock deep below the frost line and packs rich compost around the crown.",
                    "The root anchors downward into unseen stability (`asluhu thabit`, Qur'an 14:24), completely sheltered from surface winds.",
                    "Musnad Ahmad 12902 ('If the Hour erupts while in the hand of one of you is a sapling [fasilah], let him plant it') & Sahih al-Bukhari 2320.",
                    1.49
            ),
            new CultivationStage(
                    3,
                    "STAGE_3_QANAT_SALSABIL",
                    "Stage 3: Saqy Al-Ma' Bi-Qadar (سقي الماء بقدر — Measured Irrigation via Stone Qanat)",
                    "3. Channeling the Four Streams by Exact Measure Without Flood or Drought",
                    "Carves stone runnels (Qanat / Salsabil) so living water flows gently to the root zone at the exact moisture ratio (`0.94`), echoing Musa watering the flocks in Madyan (Qur'an 28:24).",
                    "Sap rises steadily through the vascular xylem; emerald leaves unfurl along the cane without wilting or root-rot.",
                    "Qur'an 23:18 ('And We sent down water from the sky in a measured amount [bi-qadar] and settled it in the earth') & Qur'an 28:24.",
                    1.48
            ),
            new CultivationStage(
                    4,
                    "STAGE_4_SHAWK_RIBAT",
                    "Stage 4: Iqamat Al-Mihrab wa Ash-Shawk Al-Haris (إقامة المحراب والشوك الحارس — Trellis & Outward Thorn)",
                    "4. Building the Walled Mihrab Trellis & Outward Vanguard Shield",
                    "Constructs the stone courtyard wall (Hurmat Al-Mihrab, Qur'an 3:37) and cedar trellis (`fa-azarahu`, Qur'an 48:29) to shield the bush from scorching desert winds and prying eyes.",
                    "The cane thickens (`fa-istaghlaza`), stands upright (`fa-istawa 'ala suqihi`), and forms outward-facing thorns that guard the ascending flower bud.",
                    "Qur'an 3:37 (Maryam's Mihrab) & Qur'an 48:29 ('Like a seed that sends forth its shoot, then strengthens it, so it grows thick and stands firm upon its stem').",
                    1.51
            ),
            new CultivationStage(
                    5,
                    "STAGE_5_INSHIRAH_WARDAH",
                    "Stage 5: Inshirah Al-Wardah bi-l-Lutf (انشراح الوردة باللطف — Unforced Dawn Unfolding)",
                    "5. Waiting in Reverent Vanguard Silence as the Crimson Rose Opens",
                    "The Cultivating Hand exercises absolute restraint (`budForcingPressureKpa = 0.000`): it never pries the bud open, instead maintaining a warm, tranquil micro-climate.",
                    "At dawn, the calyx parts of its own sovereign accord and unfolds 7 concentric rings of crimson-gold petals (`Wardatan ka-ad-dihan`, Qur'an 55:37).",
                    "Qur'an 55:37 ('A crimson rose like molten oil') & Qur'an 94:1 ('Did We not expand for you your breast [Inshirah]?').",
                    1.55
            ),
            new CultivationStage(
                    6,
                    "STAGE_6_NADA_TALL",
                    "Stage 6: Nuzul At-Tall 'ala Jannah bi-Rabwah (نزول الطل على جنة بربوة — The Gentle Dew & Twofold Fruit)",
                    "6. Morning Dew Reception & Pruning Without Ego Boasting",
                    "Pruning away spent stems with a razor-honed blade (Sahih Muslim 1955) while reciting 'Ma sha'a Allah la quwwata illa bi-llah' (Qur'an 18:39) to banish all ego boasting.",
                    "Nourished by gentle dew (`tall`), the Highland Garden yields its fragrance, pomegranates, palms, and roses twofold (`atat ukulaha di'fayn`, Qur'an 2:265).",
                    "Qur'an 2:265 ('Like a garden on high ground: heavy rain strikes it and it yields its fruit twofold; and if not heavy rain, then a gentle dew [tall]') & Qur'an 18:39.",
                    1.54
            ),
            new CultivationStage(
                    7,
                    "STAGE_7_TAQTIR_MA_AL_WARD",
                    "Stage 7: Taqtir Ma' Al-Ward Al-Khalid (تقطير ماء الورد الخالد — Copper Alembic Rosewater Distillation)",
                    "7. Distilling the Petals in the Pre-Heated Copper Vessel into Immortal Sanctuary Essence",
                    "Gathers the fallen dawn petals into the hand-hammered copper alembic over gentle hearth flame, condensing pure Damascus rosewater (`Ma' Al-Ward`) and `Itr Al-Ward`.",
                    "The ephemeral season is transmuted into an imperishable fragrance (`Rawhun wa Rayhan`, Qur'an 56:89) that anoints the entire domestic sanctuary.",
                    "Qur'an 56:89 ('Then rest, and fragrant bounty [rayhan], and a Garden of Delight') & Qur'an 76:5-21.",
                    1.58
            )
    );

    private static final List<ChaharBaghRiverQuadrant> FOUR_CHAHAR_BAGH_RIVERS = List.of(
            new ChaharBaghRiverQuadrant(
                    1,
                    "1. Nahr Al-Ma' Ghayr Al-Asin (نهر الماء غير الآسن)",
                    "North-East Quadrant: The River of Uncorrupted Living Water",
                    "#38BDF8",
                    "White Jasmine (Yasmin), Myrtle (As), and Damascus White Rose (Ward Abyad)",
                    "Pure hydration, ablution (Taharah), and crystal-clear domestic utility free of stagnation.",
                    "Qur'an 47:15 ('Fiha anharun min ma'in ghayri asin' — 'Therein are rivers of water unaltered/uncorrupted')"
            ),
            new ChaharBaghRiverQuadrant(
                    2,
                    "2. Nahr Al-Laban Al-Khalis (نهر اللبن الذي لم يتغير طعمه)",
                    "North-West Quadrant: The River of Milk of Unchanging Flavor",
                    "#F8F5E6",
                    "Almond Blossoms, Fig Trees (At-Tin), and Olive Groves (Az-Zaytunah Al-Mubarakah, Qur'an 24:35)",
                    "Primordial Fitrah, unspoiled nourishment, and the warm hearth culinary provisions of the household.",
                    "Qur'an 47:15 ('Wa anharun min labanin lam yataghayyar ta'muhu' — 'And rivers of milk the taste of which never changes')"
            ),
            new ChaharBaghRiverQuadrant(
                    3,
                    "3. Nahr Ash-Sharab Al-Tahur (نهر خمر لذة للشاربين)",
                    "South-West Quadrant: The River of Pure Crimson Delight (Free of Intoxication)",
                    "#F43F5E",
                    "Crimson Damascus Roses (Wardatan ka-ad-Dihan, Qur'an 55:37) and Ruby Pomegranates (Rumman, Qur'an 55:68)",
                    "Spiritual exhilaration, beauty (Jamal), and serene joy free of worldly hangover or cognitive clouding (Qur'an 37:47).",
                    "Qur'an 47:15 ('Wa anharun min khamrin ladhdhatin li-sh-sharibin') & Qur'an 76:21 ('Wa saqahum Rabbuhum sharaban tahura')"
            ),
            new ChaharBaghRiverQuadrant(
                    4,
                    "4. Nahr Al-'Asal Al-Musaffa (نهر عسل مصفى)",
                    "South-East Quadrant: The River of Clarified Golden Honey",
                    "#FBBF24",
                    "Saffron Crocus (Za'faran), Date Palms (Nakhl, Qur'an 55:68), and Sweet Basil (Rayhan, Qur'an 55:12)",
                    "Medicine and healing (`Shifa'un li-n-nas`, Qur'an 16:69), preserved wisdom, and enduring domestic sweetness.",
                    "Qur'an 47:15 ('Wa anharun min 'asalin musaffa') & Qur'an 16:69 ('In it is healing for mankind')"
            )
    );

    public static IslamicGardenState canonicalGardenState() {
        return CANONICAL_GARDEN_STATE;
    }

    public static List<BotanicalWayPillar> allFourBotanicalWayPillars() {
        return FOUR_BOTANICAL_WAY_PILLARS;
    }

    public static List<RoseAnatomyLayer> allFiveRoseAnatomyLayers() {
        return FIVE_ROSE_ANATOMY_LAYERS;
    }

    public static List<CultivationStage> allSevenCultivationStages() {
        return SEVEN_CULTIVATION_STAGES;
    }

    public static List<ChaharBaghRiverQuadrant> allFourChaharBaghRivers() {
        return FOUR_CHAHAR_BAGH_RIVERS;
    }
}
