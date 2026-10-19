package com.sovereign.warlock.domain;

import java.util.List;

/**
 * Canonical Synthesis of How the Modesty Standard (Al-Haya', Libas At-Taqwa, Ghadd Al-Basar & Fiqh Al-Libas)
 * for Both Men and Women in Islam Changed and Adapted Through the Development of the Western Frontier
 * (Thughur Al-Gharb: Hijaz -> Byzantine Levant/Egypt -> Maghreb/Berber Sahara [The Litham Inversion] ->
 *  Al-Andalus & Sicily -> Mudejar/Morisco Oran Fatwa -> Ottoman Rumelia/Balkans -> Modern Western & Digital Frontier)
 * and Broader Civilizational Expansions.
 */
public final class IslamicModestyWesternFrontierEvolution {

    private IslamicModestyWesternFrontierEvolution() {
    }

    /**
     * Represents one of the 7 Canonical Foundational Principles governing the distinction
     * between the Invariant Core (Ath-Thabit) and the Adaptive Customary Envelope (Al-Mutaghayyir)
     * in Islamic modesty for both men and women.
     */
    public record ModestyFoundationalPrinciple(
            int principleIndex,
            String principleCode,
            String arabicAndEnglishTitle,
            String masculineObligation,
            String feminineObligation,
            String invariantCoreVsAdaptiveCustom,
            String quranicAndHadithProof
    ) {
        public ModestyFoundationalPrinciple {
            if (principleIndex < 1 || principleIndex > 7) {
                throw new IllegalArgumentException("principleIndex must be in [1..7]");
            }
        }
    }

    /**
     * Represents one of the 7 Historical Epochs of Modesty Evolution along the Islamic
     * Western Frontier (Thughur Al-Gharb) and Civilizational Expansions.
     */
    public record WesternFrontierModestyEpoch(
            int epochIndex,
            String epochCode,
            String chronologicalAndFrontierSpan,
            String frontierEncounterAndCulturalChallenge,
            String mensModestyEvolutionAndGarments,
            String womensModestyEvolutionAndGarments,
            String architecturalAndLegalAdaptation,
            String primaryCanonicalSources
    ) {
        public WesternFrontierModestyEpoch {
            if (epochIndex < 1 || epochIndex > 7) {
                throw new IllegalArgumentException("epochIndex must be in [1..7]");
            }
        }
    }

    /**
     * Represents one of the 6 Comparative Regional Vestimentary & Customary ('Urf) Syntheses
     * across Islam's Global Expansions (Hijazi, Levantine, Maghrebi-Andalusian, Ottoman-Balkan,
     * Persianate-South Asian, and Malay-Swahili-Western Modern).
     */
    public record RegionalVestimentarySynthesis(
            int synthesisIndex,
            String regionCode,
            String civilizationalZone,
            String canonicalMasculineAttire,
            String canonicalFeminineAttire,
            String spatialAndSocialModestyNorm,
            String juristicSchoolAndMaxim
    ) {
    }

    private static final List<ModestyFoundationalPrinciple> SEVEN_MODESTY_FOUNDATIONS = List.of(
            new ModestyFoundationalPrinciple(
                    1,
                    "PRINCIPLE_1_LIBAS_AT_TAQWA_THREE_TIERS_OF_DRESS",
                    "1. Libas At-Taqwa (The Garment of God-Consciousness — Qur'an 7:26)",
                    "A man's outward garment is meaningless if his heart, tongue, and eyes betray trust; the Prophet (peace be upon him) was 'more modest than a maiden in her private chamber' (Bukhari 3562).",
                    "A woman's outward garment is an honor-shield and act of worship, never a substitute for inner Taqwa, dignity, and intellectual/spiritual agency.",
                    "INVARIANT: The 3 Qur'anic functions of dress—(1) Wariy as-Saw'at (covering nakedness), (2) Rish (dignified beauty), and (3) Libas At-Taqwa (inner righteousness). ADAPTIVE: The cut, dye, fiber, and regional tailoring.",
                    "Qur'an 7:26, 7:31-32, Sahih al-Bukhari 9 & Bukhari 3562"
            ),
            new ModestyFoundationalPrinciple(
                    2,
                    "PRINCIPLE_2_GHADD_AL_BASAR_MASCULINE_FIRST_DUTY",
                    "2. Ghadd Al-Basar (Symmetric Lowering of the Gaze — Men Addressed First in Qur'an 24:30-31)",
                    "Qur'an 24:30 commands believing MEN FIRST to lower their gaze (Yaghuddu min Absarihim) and guard their chastity before a single word is spoken about women's dress—placing the primary burden of public modesty on male self-mastery.",
                    "Qur'an 24:31 then commands believing WOMEN with the exact same verbs—to lower their gaze and guard their chastity—establishing symmetric moral accountability before addressing the Khimar.",
                    "INVARIANT: Ocular discipline and refusal to objectify others in streets, markets, or digital screens. ADAPTIVE: How mixed civic spaces (markets, courts, universities) are organized.",
                    "Qur'an 24:30-31, Sahih Muslim 2159 (Jarir's hadith on turning away the sudden glance)"
            ),
            new ModestyFoundationalPrinciple(
                    3,
                    "PRINCIPLE_3_MASCULINE_ANTI_ARROGANCE_SILK_GOLD_ISBAL",
                    "3. Masculine Anti-Arrogance Code (Prohibition of Silk, Gold & Isbal Khuyala')",
                    "To prevent Muslim men on imperial frontiers from imitating the effeminate luxury and tyrannical pride of Byzantine and Sasanian emperors, Islam forbade men from wearing pure silk (Harir), gold jewelry, and dragging robes in arrogance (Isbal Khuyala').",
                    "Permitted silk and gold adornment for women (Tirmidhi 1720) as natural feminine beauty, while prohibiting boastful extravagance (Israf) and sensual exhibitionism (Tabarruj) before strangers.",
                    "INVARIANT: Male sobriety, humility, and covering at minimum naval-to-knee + shoulders in prayer + public Muru'ah. ADAPTIVE: Transition from unstitched Izar/Rida' to Syrian Jubbah, Berber Burnous, Ottoman Kaftan, and tailored Western suits.",
                    "Sahih al-Bukhari 5783 (Isbal), Bukhari 5837 & Sunan at-Tirmidhi 1720"
            ),
            new ModestyFoundationalPrinciple(
                    4,
                    "PRINCIPLE_4_FEMININE_JILBAB_KHIMAR_AND_ILLA_MA_ZAHARA",
                    "4. Feminine Dignity & Recognition (Khimar, Jilbab & 'Illa Ma Zahara Minha')",
                    "Men are legally and morally bound to respect women's public presence and never harass, stalk, or exclude them from mosques or civic life ('Do not prevent the female servants of Allah from the mosques of Allah,' Bukhari 900).",
                    "Qur'an 24:31 (drawing the Khimar over the bosom/Juyub) and 33:59 (the outer Jilbab 'so they may be recognized as honorable and not harassed'), with the explicit exception 'except what naturally appears thereof' (illa ma zahara minha).",
                    "INVARIANT: Loose, opaque covering of the body and hair before non-Mahram men. ADAPTIVE: The majority of Hanafi, Maliki, and Shafi'i jurists (following Ibn 'Abbas) ruled that 'what naturally appears' is the face and hands needed for commerce, witness, and work, while regional dress varied from the Andalusian Almalafa to the Bosnian Samija and modern Hijab.",
                    "Qur'an 24:31, 33:59, Sahih al-Bukhari 900 & Sunan Abi Dawud 4104"
            ),
            new ModestyFoundationalPrinciple(
                    5,
                    "PRINCIPLE_5_AL_ADAH_MUHAKKAMAH_CUSTOMARY_GARMENTS",
                    "5. Al-'Adah Muhakkamah (Permissibility of Indigenous Frontier Clothing — Qur'an 7:199)",
                    "Islam never canonized 7th-century Arabian tribal dress as a religious uniform; the Prophet himself wore a Roman/Byzantine cloak (Jubbah Rumiyyah), a Syrian cloak (Jubbah Shamiyyah), and Yemenite Hibrah fabric.",
                    "Whenever Islam entered a new frontier, indigenous women's garments that were opaque and loose were immediately accepted as Shar'i dress without requiring Arabization.",
                    "INVARIANT: Opacity (La Yasiff), looseness (La Yasif), and avoidance of Libas Ash-Shuhrah (garments of vain spectacle). ADAPTIVE: Every frontier's climate-suited wool, linen, cotton, coat, trousers, or cloak.",
                    "Qur'an 7:199 ('Al-'Urf), Sahih al-Bukhari 363 (Jubbah Shamiyyah) & Muslim 274"
            ),
            new ModestyFoundationalPrinciple(
                    6,
                    "PRINCIPLE_6_ISTI_DHAN_ARCHITECTURAL_AND_SPATIAL_PRIVACY",
                    "6. Isti'dhan & Architectural Modesty (Sanctity of Domestic Privacy — Qur'an 24:27-28, 24:58)",
                    "Forbids men from entering any home unannounced, peering through doors/windows (Bukhari 6241), or building structures that overlook a neighbor's private family courtyard (Darar Fahish).",
                    "Guarantees women and families an unmonitored domestic sanctuary (Haram Al-Bayt) where outer wraps are laid aside in total comfort, breeze, and sunlight.",
                    "INVARIANT: Three domestic permission times (Qur'an 24:58) and inviolability of the home. ADAPTIVE: Evolved from Medinan curtain-screens (Hijab) to Andalusian courtyard Riyads, Mashrabiyyah/Celosia wooden lattices, and modern digital privacy.",
                    "Qur'an 24:27-28, 24:58-60 & Sahih al-Bukhari 6241"
            ),
            new ModestyFoundationalPrinciple(
                    7,
                    "PRINCIPLE_7_DARURAH_AND_IKRAH_EMERGENCY_CONCESSIONS",
                    "7. Darurah, Ikrah & Taqiyyah (Medical, Frontier & Persecution Concessions — Qur'an 2:185, 16:106)",
                    "Permits silk for men suffering skin ailments (Bukhari 5839) or against lice/shrapnel on military frontiers, and permits surgical/medical exposure for both sexes.",
                    "Under state persecution (such as the 1504 Oran Fatwa for Spanish Moriscos or modern coercive bans), outward dress concessions are legally excused while inner faith remains whole.",
                    "INVARIANT: Preservation of life, faith, and dignity (Hifz Ad-Din wa An-Nafs). ADAPTIVE: Legal dispensations (Rukhsah) during war, medical treatment, extreme climate, or forced assimilation.",
                    "Qur'an 2:185 ('Allah intends for you ease'), 16:106 & The Oran Fatwa (910 AH / 1504 CE)"
            )
    );

    private static final List<WesternFrontierModestyEpoch> SEVEN_WESTERN_FRONTIER_EPOCHS = List.of(
            new WesternFrontierModestyEpoch(
                    1,
                    "FRONTIER_1_HIJAZI_BASELINE_LIBERATION_FROM_JAHILIYYAH",
                    "Epoch I: The Hijazi Baseline (Mecca & Medina, 1–11 AH / 610–632 CE)",
                    "Pre-Islamic Quraysh forced non-Meccan pilgrims to circumambulate the Ka'bah stark naked unless they rented Hums clothes (Muslim 3028), while elites dragged robes in tribal pride (Isbal) and practiced Tabarruj.",
                    "Men wore the unstitched Izar (lower wrap) and Rida' (upper mantle), the sewn Qamis (tunic), and on frontier marches the tight-sleeved Syrian cloak (Jubbah Shamiyyah, Bukhari 363). Men were commanded to lower their gaze first (24:30), raise hems above the ankles against pride, and renounce gold and silk.",
                    "Women transitioned from open-necked Jahiliyyah wraps to the Khimar (covering hair, neck, and bosom, 24:31) and outer Jilbab (33:59) as a badge of free, honorable status—while praying in the mosque, trading in the market (Ash-Shifa' bint 'Abdillah as market inspector), and tending wounded soldiers on battlefields.",
                    "Replaced Jahiliyyah forced ritual nudity with universal clothed dignity at the Ka'bah (Qur'an 7:31: 'Take your adornment at every masjid') and instituted domestic Isti'dhan (24:27).",
                    "Qur'an 7:26-32, 24:30-31, 33:59, Sahih al-Bukhari 363, 372 & Sahih Muslim 3028"
            ),
            new WesternFrontierModestyEpoch(
                    2,
                    "FRONTIER_2_BYZANTINE_LEVANT_AND_EGYPT_THUGHUR",
                    "Epoch II: The First Western Frontier — Byzantine Syria (Bilad Ash-Sham) & Egypt (12–132 AH / 633–750 CE)",
                    "Muslim armies entered Greco-Roman cities featuring two cultural extremes: (1) Byzantine imperial silk-and-gold aristocratic pageantry and noblewomen's Gynaeceum seclusion, and (2) Roman public bathhouses (Thermae / Hammamat) where bathing had been completely nude.",
                    "Caliph 'Umar ibn al-Khattab entered Jerusalem in a patched tunic, rebuking commanders in Damascus who imitated Byzantine silk pomp, while approving practical frontier garments for cold/wet climates: tailored trousers (Sarawil), wool Jubbahs, and leather boots (Khuffayn). In Roman bathhouses, jurists mandated the male waist-wrap (Mi'zar).",
                    "While urban prosperity in Damascus and Fustat led elite families to adopt stricter courtyard seclusion, early Syrian and Egyptian jurists (Al-Awza'i, Al-Layth ibn Sa'd, and Ash-Shafi'i in Cairo) maintained that a woman's face and hands remain uncovered in prayer and civic transactions.",
                    "Islamized the Greco-Roman Thermae into the canonical Islamic Hammam: abolishing communal nudity via mandatory Mi'zar wraps and strict gender scheduling/partitioning (Sunan at-Tirmidhi 2801).",
                    "Sunan at-Tirmidhi 2801, Abu Dawud 4011, Al-Baladhuri & Ash-Shafi'i's Kitab Al-Umm"
            ),
            new WesternFrontierModestyEpoch(
                    3,
                    "FRONTIER_3_MAGHREB_BERBER_SAHARA_LITHAM_INVERSION",
                    "Epoch III: The Maghreb, Berber North Africa & Saharan Frontier — The Litham Gender Inversion (50–540 AH / 670–1147 CE)",
                    "Expanding across Tunisia, the Atlas Mountains, and the Western Sahara to the Atlantic Ocean, Islam integrated the Amazigh (Berber) confederations—including the Sanhaja Almoravids (Al-Murabitun / 'Al-Mulaththamun', 'The Veiled Men').",
                    "THE GREAT FRONTIER INVERSION: Among the Sanhaja Almoravid men who ruled from Senegal to Spain, it was the MEN who wore the full face-veil (Al-Litham / Tagelmust) covering everything below the eyes at all times, because exposing a man's mouth was deemed shameful in their desert custom, alongside the hooded wool Burnous and Djellaba.",
                    "Conversely, Amazigh and Almoravid women—such as Zaynab an-Nafzawiyyah (co-founder of Marrakesh)—customarily went with their faces uncovered while wearing loose draped woolen Ha'iks, participating openly in governance and scholarship until the later Almohad reaction under Ibn Tumart.",
                    "Maliki jurists (Abu 'Imran al-Fasi, Qadi 'Iyad) ruled that although men covering their faces in prayer is normally disliked, the Almoravid male Litham was valid under indigenous desert custom ('Urf), demonstrating Islam's remarkable flexibility toward frontier dress.",
                    "Qadi 'Iyad's Tartib Al-Madarik, Ibn Khaldun's Kitab Al-'Ibar & Al-Marrakushi's Al-Mu'jib"
            ),
            new WesternFrontierModestyEpoch(
                    4,
                    "FRONTIER_4_AL_ANDALUS_AND_SICILY_URBAN_REFINEMENT",
                    "Epoch IV: Al-Andalus (Iberian Peninsula) & Sicily — Cordoban Refinement, Celosias & 170+ Female Scholars (92–897 AH / 711–1492 CE)",
                    "On the European Western Frontier (Cordoba, Seville, Granada, Palermo), Muslims lived in high-density multi-religious cities alongside Christians and Jews, requiring clear civic, spatial, and market modesty ordinances.",
                    "In 9th-century Cordoba, Ziryab instituted a refined seasonal dress code for men: crisp white linen Aljubbas (Jubbahs) from spring to autumn, quilted cloaks and furs in winter, clean hygiene, and short hair. Meanwhile, Hisbah manuals (Ibn 'Abdun of Seville) policed MEN'S behavior—banning men from loitering near women's riverside laundry zones or church doors.",
                    "Andalusian women wore the graceful white or indigo linen Al-Malhafah (Spanish: Almalafa) and Qina' head-wrap, while enjoying extraordinary intellectual prominence: over 170 documented female scholars, mathematicians, and physicians (such as Lubna of Cordoba and Hafsah bint al-Hajj), with Ibn Rushd (Averroes) championing women's full intellectual and civic capacity.",
                    "Perfected Architectural Modesty: the inward-facing Riyad courtyard garden and carved wooden Mashrabiyyah (Spanish: Celosia) window screens allowed women to see the street and enjoy sunlight and breeze without being seen.",
                    "Ibn 'Abdun's Risalah fi Al-Qada' wa Al-Hisbah, Ibn Rushd's Commentary on Plato's Republic & Al-Maqqari's Nafh At-Tib"
            ),
            new WesternFrontierModestyEpoch(
                    5,
                    "FRONTIER_5_MUDEJAR_MORISCO_ORAN_FATWA_UNDER_COERCION",
                    "Epoch V: The Mudejar & Morisco Iberian Frontier — Modesty Under Coercion & The 1504 Oran Fatwa (897–1018 AH / 1492–1609 CE)",
                    "Following the fall of Granada (1492 CE), Spanish royal Pragmatica decrees outlawed the Arabic language, demolished Islamic bathhouses (Hammams), banned the women's Almalafa wrap, and ordered Morisco house doors kept open to strip away Islamic privacy.",
                    "Morisco men were forced to abandon turbans and Aljubbas for Castilian hats, doublets, and hose under threat of the Inquisition.",
                    "Morisco women were legally forbidden from wearing the Almalafa veil; yet ironically, Christian Spanish women adopted the Moorish veil as the iconic Spanish 'Tapada' (covering the face except one eye with the Manto in Seville, Madrid, and Lima) and the lace Mantilla.",
                    "THE ORAN FATWA (910 AH / 1504 CE): Mufti Ahmad ibn Abi Jum'ah al-Maghrawi ruled that under coercion (Ikrah, Qur'an 16:106), Morisco men and women were fully excused for wearing Christian Castilian dress and omitting outward rituals, because inward Libas At-Taqwa in the heart supersedes external fabric when life and survival are threatened.",
                    "Qur'an 16:106, The Oran Fatwa of Ahmad ibn Abi Jum'ah (1504 CE) & L.P. Harvey's Muslims in Spain"
            ),
            new WesternFrontierModestyEpoch(
                    6,
                    "FRONTIER_6_OTTOMAN_RUMELIA_BALKANS_AND_TANZIMAT",
                    "Epoch VI: The Ottoman European Frontier (Rumelia, Bosnia, Balkans) & 19th-Century Dress Reforms (750–1342 AH / 1350–1924 CE)",
                    "Expanding into Southeastern and Central Europe (Istanbul, Sarajevo, Mostar, Belgrade), Islam adapted to cold Alpine-Balkan winters, rural mountain agrarian work, and 19th-century European industrial modernity.",
                    "In 1826–1829, Sultan Mahmud II replaced the traditional Ottoman Kaftan, Şalvar, and status turbans of state officials with the Fez (Tarbush), tailored Stambouline frock-coat, and trousers. Ottoman Hanafi jurists approved this shift, establishing dark, sober tailored suits and trousers as canonical masculine modesty in the West.",
                    "Urban Ottoman women wore the tailored long-sleeved coat (Ferace) and light Yaşmak veil, while Bosnian and Balkan rural Muslim women wore billowy embroidered trousers (Dimije) and headscarves (Šamija)—enabling full mobility in mountain farming while preserving Hijab.",
                    "The Ottoman Mecelle (Articles 1201–1202) codified visual modesty into civil property law: any new window or terrace overlooking a neighbor's family courtyard was ruled a 'Grave Harm' (Darar Fahish) and legally blocked.",
                    "Ottoman Mecelle-i Ahkam-i 'Adliyye (Arts. 1201–1202) & 1829 Ottoman Clothing Regulations (Nizamname)"
            ),
            new WesternFrontierModestyEpoch(
                    7,
                    "FRONTIER_7_MODERN_WESTERN_DIASPORA_AND_DIGITAL_FRONTIER",
                    "Epoch VII: The Modern Western Diaspora (Europe & Americas) & The 21st-Century Digital Frontier",
                    "Muslims living as citizens across Western Europe and North America navigate secular legal systems, hyper-commercialized fast fashion, and algorithmic social media exhibitionism.",
                    "Following Muhammad 'Abduh's Transvaal Fatwa (1903) and contemporary Fiqh Al-Aqalliyyat (Al-Qaradawi, Bin Bayyah), Western tailored suits, shirts, and trousers are universally recognized as valid masculine Libas Al-'Urf. The decisive modern frontier test for men is DIGITAL Ghadd Al-Basar (lowering the gaze online, 24:30), rejecting gym/wealth exhibitionism (digital Isbal), and practicing protective chivalry without hypocrisy.",
                    "For women in the West, the Hijab shifted from passive village custom to a conscious, self-chosen assertion of spiritual identity, intellectual dignity, and refusal of commercial objectification—expressed through tailored coats, professional attire, and athletic Hijabs, while guarding against fast-fashion commodification.",
                    "Re-anchoring modesty in its symmetric Qur'anic root (Qur'an 7:26 & 24:30-31): outward dress is a dignified boundary, while inward Taqwa, ocular discipline, and mutual respect between men and women form the true sanctuary.",
                    "Qur'an 7:26, 24:30-31, Transvaal Fatwa (1903 CE) & Contemporary Fiqh Al-Aqalliyyat"
            )
    );

    private static final List<RegionalVestimentarySynthesis> SIX_REGIONAL_SYNTHESES = List.of(
            new RegionalVestimentarySynthesis(
                    1,
                    "ZONE_1_HIJAZ_AND_ARABIAN_PENINSULA",
                    "Hijaz, Yemen & Arabian Peninsula",
                    "Qamis / Thawb (loose ankle-length tunic), Bisht / 'Aba'ah (outer cloak), Ghutrah / 'Imamah (headcloth/turban), and unstitched White Ihram during Hajj.",
                    "Loose 'Abayah, Khimar / Shaylah headscarf, and optional Niqab in conservative tribal custom.",
                    "High solar reflectance, maximal airflow in desert heat, and total erasure of class hierarchy during the White Ihram of Hajj.",
                    "Hanbali / Shafi'i / Maliki baseline; Hadith of the Qamis (Tirmidhi 1762)"
            ),
            new RegionalVestimentarySynthesis(
                    2,
                    "ZONE_2_MAGHREB_AND_AL_ANDALUS",
                    "Maghreb (Morocco, Algeria, Tunisia), Sahara & Historical Al-Andalus",
                    "Djellaba (hooded wool/cotton robe), Burnous / Selham (heavy hooded cloak), Jabador tunic-and-trousers, and the historical Sanhaja male Litham face-veil.",
                    "Ha'ik / Almalafa (draped white or indigo wrap), Kaftan / Takchita for festive gatherings, and tailored hooded Djellaba.",
                    "Inward-facing Riyad courtyard architecture + carved Mashrabiyyah / Celosia window screens protecting family privacy.",
                    "Maliki School: Customary desert and urban garments ('Urf) validated under Qur'an 7:199"
            ),
            new RegionalVestimentarySynthesis(
                    3,
                    "ZONE_3_OTTOMAN_ANATOLIA_AND_BALKANS",
                    "Anatolia, Bosnia, Albania & Ottoman Rumelia",
                    "Historically Kaftan, Cepken, Şalvar trousers, and Sarık turban; from 1829 onward, the Fez and tailored wool frock-coat/suit and trousers.",
                    "Urban Ferace (tailored long overcoat) and Yaşmak; rural Balkan Dimije (loose billowy trousers), Entari, and Šamija headscarf.",
                    "Strict neighborhood visual-privacy law (Mecelle Arts. 1201–1202) combined with high female mobility in Balkan mountain agriculture.",
                    "Hanafi School: Istihsan (Juristic Preference) & Al-'Adah Muhakkamah"
            ),
            new RegionalVestimentarySynthesis(
                    4,
                    "ZONE_4_PERSIANATE_CENTRAL_AND_SOUTH_ASIA",
                    "Iran, Khorasan, Transoxiana (Uzbekistan) & Indian Subcontinent",
                    "Qaba' coat, Chapan quilted robe (Central Asia), and Shalwar Kameez / Sherwani (loose tunic over drawstring trousers, originally adopted from horsemen).",
                    "Chador (full semicircular cloak) or Manteau/Rusari in Iran; Shalwar Kameez with Dupatta / Chadar scarf across South Asia.",
                    "Chahar Bagh walled gardens, Hasht-Bihisht pavilions, and Jali perforated stone screens (Mughal architecture).",
                    "Hanafi / Shafi'i / Ja'fari traditions: Horsemen's trousers (Sarawil) praised for maximal coverage"
            ),
            new RegionalVestimentarySynthesis(
                    5,
                    "ZONE_5_SWAHILI_WEST_AFRICA_AND_MALAY_ARCHIPELAGO",
                    "West Africa (Hausa/Fulani/Wolof), Swahili Coast & Malay-Indonesian Archipelago",
                    "West African Babban Riga / Grand Boubou; Swahili Kanzu and Kofia; Malay-Indonesian Baju Melayu, Sarong, Batik shirt, and Songkok/Peci.",
                    "West African Boubou and wrapper with head-tie; Swahili Buibui and Kangas; Malay-Indonesian Baju Kurung, Kebaya Labuh, and Tudung/Jilbab.",
                    "Tropical humidity adaptation using breathable cottons/batiks and elevated timber house verandas (Serambi) separating public reception from family rooms.",
                    "Shafi'i (East Africa & Southeast Asia) and Maliki (West Africa) integration of indigenous textiles"
            ),
            new RegionalVestimentarySynthesis(
                    6,
                    "ZONE_6_MODERN_EUROPE_AMERICAS_AND_DIGITAL_SPHERE",
                    "Western Europe, North America & Global Digital Frontier",
                    "Tailored trousers, dress shirts, blazers/suits, coats, and loose athletic wear; coupled with digital lowering of the gaze (Ghadd Al-Basar) and dignified speech.",
                    "Tailored long coats, trench coats, loose trousers/maxi skirts, breathable woven/jersey Hijabs, and high-performance modest sportswear.",
                    "Replacement of physical courtyard walls with conscious personal boundaries, professional ethics, and digital/social-media modesty.",
                    "Fiqh Al-Aqalliyyat & Maqasid Ash-Shari'ah (Qur'an 7:26 & 24:30-31)"
            )
    );

    public static List<ModestyFoundationalPrinciple> allSevenModestyFoundations() {
        return SEVEN_MODESTY_FOUNDATIONS;
    }

    public static List<WesternFrontierModestyEpoch> allSevenWesternFrontierEpochs() {
        return SEVEN_WESTERN_FRONTIER_EPOCHS;
    }

    public static List<RegionalVestimentarySynthesis> allSixRegionalSyntheses() {
        return SIX_REGIONAL_SYNTHESES;
    }
}
