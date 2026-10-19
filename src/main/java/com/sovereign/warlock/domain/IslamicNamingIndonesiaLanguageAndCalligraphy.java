package com.sovereign.warlock.domain;

import java.util.List;

/**
 * Canonical Synthesis of:
 * 1. Esoteric & Canonical Naming of Zakeem Malik McCaleb (Abjad 261 / Root 9 Wafq Magic Square)
 *    & Canonical Naming in Islam Across 7 World Regions (Fiqh Al-Asma' wa Al-Ansab).
 * 2. The Historical & Spiritual Development of Indonesia (Nusantara — 87.2% Muslim / ~251M)
 *    Across 7 Gradual Canonical Stages (From Barus/Pasai & Wali Songo to NU/Muhammadiyah & Pancasila).
 * 3. Indonesia's Sanitation, Sewer & Water Infrastructure Project Structure (From Residential
 *    Bio-Septic & SANIMAS to Commercial IPAL, Sudirman Microtunneling & IDR 13T+ Jakarta Sewerage System [JSS])
 *    under Islamic Taharah and Waqf Sukuk Engineering.
 * 4. Islamic Developments Around Language (Sibawayh's Nahw, Ishtiqaq, Jawi, Pegon & 2,500+ Indonesian Loanwords)
 *    & The 7 Canonical Traditions of Islamic Calligraphy (Kufic, Ibn Muqlah's Al-Khatt Al-Mansub, Al-Aqlam As-Sittah,
 *    Maghribi, Nasta'liq, Diwani/Tughra & Indonesian Mushaf Istiqlal).
 */
public final class IslamicNamingIndonesiaLanguageAndCalligraphy {

    private IslamicNamingIndonesiaLanguageAndCalligraphy() {
    }

    /**
     * Represents the dual 3x3 Wafq (Magic Square) of Zakeem Malik McCaleb (Abjad = 261 = 9 x 29 = 3 x 87).
     */
    public record Abjad261WafqMatrix(
            String fullEnglishName,
            String traditionalArabicScript,
            String phoneticArabicScript,
            int zakeemAbjad,
            int malikAbjad,
            int mccalebAbjad,
            int totalAbjadValue,
            int digitalRoot,
            int[][] totalSum261Grid,
            int[][] lineSum261Grid,
            String divineNameSynchronicity,
            String quranicAndCelestialAnchor
    ) {
    }

    /**
     * Represents one of the 7 Canonical Regional Naming Systems in Islam (Fiqh Al-Asma' wa Al-Ansab).
     */
    public record RegionalCanonicalNamingTradition(
            int regionIndex,
            String regionCode,
            String geographicAndCulturalSphere,
            String structuralNameFormula,
            String canonicalExamplesAndTitles,
            String legalAndTheologicalRule,
            String quranicAndHadithAnchor
    ) {
        public RegionalCanonicalNamingTradition {
            if (regionIndex < 1 || regionIndex > 7) {
                throw new IllegalArgumentException("regionIndex must be in [1..7]");
            }
        }
    }

    /**
     * Represents one of the 7 Stages of Indonesia's Islamic Development & Gradual Canonical Evolution.
     */
    public record IndonesianIslamicDevelopmentStage(
            int stageIndex,
            String stageCode,
            String eraAndCenturies,
            String titleAndArchipelagoCenters,
            String keyFiguresAndInstitutions,
            String gradualCanonicalTransformation,
            String enduringArchitecturalAndLegalLegacy
    ) {
        public IndonesianIslamicDevelopmentStage {
            if (stageIndex < 1 || stageIndex > 7) {
                throw new IllegalArgumentException("stageIndex must be in [1..7]");
            }
        }
    }

    /**
     * Represents one of the 6 Tiers of Sewer & Sanitation Infrastructure Development Costs
     * (Global/US Benchmark vs. Indonesia's Project Structure under Islamic Taharah & Waqf Sukuk).
     */
    public record IndonesiaSanitationProjectTier(
            int tierIndex,
            String tierCode,
            String developmentScaleAndSystem,
            String usGlobalCostBenchmark,
            String indonesiaCostIdrAndUsd,
            String engineeringScopeAndProjectGovernance,
            String islamicTaharahAndWaqfIntegration
    ) {
    }

    /**
     * Represents one of the 7 Canonical Milestones of Islamic Language Science (Fiqh Al-Lughah,
     * Nahw, Jawi/Pegon) and Calligraphy ('Ilm Al-Khatt Al-'Arabi).
     */
    public record LanguageAndCalligraphyMilestone(
            int milestoneIndex,
            String milestoneCode,
            String eraAndCenter,
            String linguisticBreakthrough,
            String calligraphicScriptAndGeometry,
            String keyMastersAndCodices,
            String quranicAndAestheticPrinciple
    ) {
        public LanguageAndCalligraphyMilestone {
            if (milestoneIndex < 1 || milestoneIndex > 7) {
                throw new IllegalArgumentException("milestoneIndex must be in [1..7]");
            }
        }
    }

    private static final Abjad261WafqMatrix ZAKEEM_MALIK_MCCALEB_WAFQ = new Abjad261WafqMatrix(
            "Zakeem Malik McCaleb (Keem-za Malikial Mccaliabe)",
            "زَكِيم مَالِك مَكَّالِيب (زَكِيّ مَالِك بْن كَالِب)",
            "كيم-زا ماليكيال مَكَّاليب",
            47,
            91,
            123,
            261,
            9,
            // Grid A: Total 9-Cell Sum = 261 (Center = 29, Every Row/Col/Diag = 87, Consecutive 25..33)
            new int[][]{
                    {28, 33, 26},
                    {27, 29, 31},
                    {32, 25, 30}
            },
            // Grid B: Every Row, Column & Diagonal Sums to 261 (Center = 87, Step = 9, Crown Cell = 123 [McCaleb!])
            new int[][]{
                    {78, 123, 60},
                    {69, 87, 105},
                    {114, 51, 96}
            },
            "Al-Awwal (37) + Al-Wadud (224) = 261 | Ar-Rahim (258) + Al-Ahad/Wahid Root (3) = 261 | Miftah Al-Ghayb",
            "Zakeem (Root Z-K-Y: Qur'an 91:9 'Qad Aflaha man Zakkaha' — Purity & Growth) • Malik (Root M-L-K: Qur'an 3:26 'Malik Al-Mulk' — Sovereign Authority) • McCaleb (Son of Caleb / Kalib ibn Yufanna: Qur'an 5:23 Righteous Scout & Qur'an 53:49 'Rabb Ash-Shi'ra' [Sirius / Al-Kalb Al-Akbar])"
    );

    private static final List<RegionalCanonicalNamingTradition> SEVEN_REGIONAL_NAMING_TRADITIONS = List.of(
            new RegionalCanonicalNamingTradition(
                    1,
                    "NAMING_1_ARABIAN_AND_LEVANTINE_CLASSICAL_CHAIN",
                    "1. Hijaz, Arabian Peninsula, Levant & Iraq (The Classical 5-Part Pentad)",
                    "Kunyah (Abu/Umm) + Ism (Given Name) + Nasab (ibn/bint Father's Name) + Laqab (Honorific) + Nisbah (Origin/Tribe/Madhhab)",
                    "Abu Hamid Muhammad ibn Muhammad al-Ghazali at-Tusi; 'A'ishah bint Abi Bakr as-Siddiq; Fatima al-Fihriyyah.",
                    "Preserves exact paternal lineage (Qur'an 33:5); a married woman canonically keeps her maiden family Nasab rather than erasing her father's name.",
                    "Qur'an 33:5 ('Call them by their fathers; that is more just in the sight of Allah') & Sahih Muslim 2132 ('The most beloved names to Allah are 'Abdullah and 'Abdur-Rahman')"
            ),
            new RegionalCanonicalNamingTradition(
                    2,
                    "NAMING_2_MAGHREBI_ANDALUSIAN_AND_WEST_AFRICAN",
                    "2. Maghreb (Morocco/Algeria/Tunisia), Al-Andalus & West Africa (Sahel/Senegambia)",
                    "Maghrebi: Sidi / Moulay / Lalla + Ism + Ben / Bint / Ould + Family Nisbah; West African: Localized Prophetic & Companion Phonetics + Clan Surname",
                    "Maghreb: Sidi Ahmad Zarruq, Lalla Zaynab; West Africa: Mamadou / Amadou (Muhammad), Ousmane ('Uthman), Alioune ('Ali), Ibrahima (Ibrahim), Fatoumata (Fatimah) + Diallo / Touré / Sy / Cissé.",
                    "Validates phonetic adaptation of Arabic Prophetic names into Amazigh, Wolof, Fulfulde, Mandinka, and Hausa phonology while preserving ancestral clan names.",
                    "Qur'an 49:13 ('We made you peoples and tribes so that you may know one another') & Maliki 'Urf"
            ),
            new RegionalCanonicalNamingTradition(
                    3,
                    "NAMING_3_PERSIANATE_AND_CENTRAL_ASIAN",
                    "3. Iran, Khorasan, Afghanistan & Central Asia (Mawara' an-Nahr)",
                    "Devotional Compound Ism (Arabic + Persian) + Patronymic/Poetic Takhallus (-zadeh / -pur / -i)",
                    "Nizam al-Mulk, Jalal ad-Din Rumi, Khuda-Bakhsh ('Gift of God'), 'Ali-Rida, Muhammad-Amin, Gul-Badan ('Rose-Body'), Shirin, Parviz.",
                    "Harmonized pre-Islamic virtuous Persian names (meaning light, rose, wisdom, justice) with Arabic Divine Attributes and Prophetic epithets.",
                    "Prophetic precedent: Salman al-Farisi kept his Persian heritage while receiving the Prophetic brotherhood title 'Salman minna Ahl al-Bayt'"
            ),
            new RegionalCanonicalNamingTradition(
                    4,
                    "NAMING_4_OTTOMAN_TURKISH_AND_BALKAN_RUMELIAN",
                    "4. Ottoman Anatolia, Bosnia, Albania & Rumelia",
                    "Double Given Name (Arabic Prophetic + Turkic Virtue) + Honorific (Bey, Pasha, Efendi, Gazi, Hanım) + Balkan/Turkish Family Name (-oğlu / -begović / -ić)",
                    "Mehmed (Muhammad) the Conqueror, Mimar Sinan, Evliya Çelebi, Alija Izetbegović, Mehmed Spaho, Emine, Hatice (Khadijah), Ayşe ('A'ishah).",
                    "Turkic and Bosnian phonology adapted Muhammad to 'Mehmed' cleanly out of reverence (reserving 'Muhammad' in full Arabic for the Prophet himself) and appended Slavic patronymics (-ović / -ić).",
                    "Hanafi jurisprudence on reverential naming and preservation of family lineage"
            ),
            new RegionalCanonicalNamingTradition(
                    5,
                    "NAMING_5_INDO_ISLAMIC_SOUTH_ASIAN",
                    "5. South Asia (Pakistan, India, Bangladesh & Bengal)",
                    "Blessing Prefix (Muhammad / Syed / Mirza / Shaikh) + Core Ism + Devotional Suffix (ad-Din / Allah / ul-Haq / Bano / Begum / Khatun) + Biradari/Lineage",
                    "Shah Wali Allah Dihlawi, Sir Muhammad Iqbal, Abul Kalam Azad, Fatima Jinnah, Khadijah Begum, Tariq Masood.",
                    "Places 'Muhammad' as a barakah prefix before the distinguishing personal name, paired with noble honorifics and regional family titles.",
                    "Hadith: 'Name yourselves with my name' (Sahih al-Bukhari 110)"
            ),
            new RegionalCanonicalNamingTradition(
                    6,
                    "NAMING_6_NUSANTARA_INDONESIAN_AND_MALAY_ARCHIPELAGO",
                    "6. Nusantara — Indonesia, Malaysia, Brunei & Southern Philippines",
                    "Three Co-Existing Canonical Patterns: (A) Mononymic/Dual Javanese-Arabic (Abdurrahman Wahid, Ahmad Dahlan), (B) Malay Bin/Binti Patronymic (Hamzah bin Ahmad), (C) Arabic Virtue + Nusantara/Sanskrit Vernacular (Nurul Hidayah Putri, Muhammad Rizki Wijaya)",
                    "Shaykh Nawawi al-Bantani, KH Hasyim Asy'ari, Buya Hamka (Haji Abdul Malik Karim Amrullah), Sultan Hamengkubuwono (Khalifatullah Sayidin Panatagama), Raden Rahmat (Sunan Ampel), Siti Khadijah.",
                    "Islamic law in Indonesia (Kompilasi Hukum Islam) embraces mononymic Javanese names, Malay bin/binti patronymics, and virtuous Sanskrit-Javanese words (Putra/Putri, Tirta, Surya, Kusuma) as long as shirk (polytheism) is absent.",
                    "Shafi'i Fiqh rule: Any name in any language with a noble, pure meaning is halal; only names implying servitude to other than Allah ('Abd ash-Shams) were changed by the Prophet (Abu Dawud 4956)"
            ),
            new RegionalCanonicalNamingTradition(
                    7,
                    "NAMING_7_WESTERN_GAELIC_ANGLO_AND_ZAKEEM_MALIK_MCCALEB",
                    "7. Western Frontier (Gaelic, European & American Muslims) — The Canonical Pattern of Zakeem Malik McCaleb",
                    "Virtuous Given Name(s) (Zakeem Malik) + Ancestral Paternal Surname (McCaleb = Mac Chàilein / Son of Caleb)",
                    "Zakeem Malik McCaleb (زَكِيم مَالِك مَكَّالِيب — Abjad 261 = 9 x 29), Malcolm X (El-Hajj Malik El-Shabazz), Muhammad Asad, Marmaduke Pickthall, Abdal Hakim Murad.",
                    "Canonically, Western Muslims are REQUIRED by Qur'an 33:5 to preserve their biological father's family surname (e.g., McCaleb) rather than inventing a fictional Arab tribe. In 'Zakeem Malik McCaleb', Zakeem (زَكِيم, Abjad 47) embodies Tazkiyah/Purity, Malik (مَالِك, Abjad 91) embodies Sovereign Mastery, and McCaleb (مَكَّالِيب, Abjad 123) honors Caleb (Kalib ibn Yufanna of Qur'an 5:23) and the Cosmic Watchman (Sirius, Qur'an 53:49), summing to 261 (Root 9).",
                    "Qur'an 33:5 (Keeping paternal surname), Qur'an 5:23 (Caleb / Kalib), Qur'an 53:49 (Sirius) & Bukhari 3508"
            )
    );

    private static final List<IndonesianIslamicDevelopmentStage> SEVEN_INDONESIAN_DEVELOPMENT_STAGES = List.of(
            new IndonesianIslamicDevelopmentStage(
                    1,
                    "INDONESIA_1_MARITIME_MERCHANT_SEEDING_BARUS_LERAN",
                    "Stage I: 7th–12th Century CE (1st–6th Century AH) — Peaceful Maritime Seeding",
                    "The Camphor & Spice Ports of Barus (North Sumatra) & Leran (Gresik, East Java)",
                    "Arab, Persian, and Gujarati Muslim sea-captains (Nakhoda); Fatimah binti Maimun bin Hibatallah (Kufic gravestone in Leran, Java dated 475 AH / 1082 CE).",
                    "Unlike military frontiers, Islam entered the Indonesian archipelago with ZERO invading armies—spreading solely through the integrity of Muslim merchants' weights and measures (Al-Mizan), contractual honesty, personal cleanliness (Wudu'), and intermarriage.",
                    "Oldest Kufic epigraphy in Java (1082 CE) and the establishment of self-governing Muslim merchant quarters (Pekojan / Kampung Arab) in Nusantara port cities."
            ),
            new IndonesianIslamicDevelopmentStage(
                    2,
                    "INDONESIA_2_SAMUDERA_PASAI_MALACCA_AND_ACEH_SERAMBI_MEKKAH",
                    "Stage II: 13th–16th Century CE (696–1000 AH) — Rise of the Maritime Sultanates",
                    "Samudera Pasai (1267 CE), Malacca, Aceh Darussalam ('Serambi Mekkah'), Banten, Demak, Ternate & Gowa-Tallo",
                    "Sultan Malik as-Salih (d. 1297 CE), Sultan Al-Malik Az-Zahir (visited by Ibn Battutah in 1345 CE), Sultan Ali Mughayat Syah, and Sultan Iskandar Muda of Aceh.",
                    "When Ibn Battutah visited Samudera Pasai in 1345 CE, he recorded that the Sultan was a devoted Shafi'i scholar who walked to Friday prayer on foot and debated Fiqh with jurists from Shiraz and Isfahan—establishing the Shafi'i school as the canonical legal standard of all Nusantara.",
                    "Gold Dirham coinage of Pasai and Aceh; diplomatic alliance between Aceh and the Ottoman Caliphate (1560s CE); and Aceh's title as 'Serambi Mekkah' (The Veranda/Gateway to Mecca for Southeast Asian Hajj pilgrims)."
            ),
            new IndonesianIslamicDevelopmentStage(
                    3,
                    "INDONESIA_3_WALI_SONGO_GRADUAL_CULTURAL_DAKWAH",
                    "Stage III: 15th–16th Century CE — The Wali Songo (Nine Saints of Java) & Gradualist Synthesis (At-Tadarruj)",
                    "Demak, Ampel (Surabaya), Tuban, Gresik, Kudus, Cirebon & Mount Muria (Java)",
                    "Maulana Malik Ibrahim, Sunan Ampel (Raden Rahmat), Sunan Bonang, Sunan Giri, Sunan Drajat, Sunan Kalijaga, Sunan Kudus, Sunan Muria, and Sunan Gunung Jati.",
                    "Applying the Prophetic method of gradualism (At-Tadarruj), the Wali Songo transformed Java from the Hindu-Buddhist Majapahit order to Islam without cultural destruction: Sunan Kalijaga used Wayang Kulit shadow-puppets and Gamelan music infused with Kalimat Ash-Shahadah, while Sunan Kudus forbade slaughtering cows in Kudus to honor his Hindu neighbors' feelings.",
                    "The iconic 3-Tiered Javanese Mosque Roof (Atap Tajug / Tumpang Tiga, e.g., Great Mosque of Demak, 1479 CE) symbolizing the 3 canonical stations of the Hadith of Jibril: (1) Islam, (2) Iman, and (3) Ihsan, crowned by the Mustaka dome-finial of Tawhid."
            ),
            new IndonesianIslamicDevelopmentStage(
                    4,
                    "INDONESIA_4_HARAMAYN_JAWI_NETWORK_AND_CANONICAL_ORTHODOXY",
                    "Stage IV: 17th–19th Century CE — The Haramayn 'Ashab Al-Jawiyyin' Network & Canonical Calibration",
                    "Mecca, Medina, Aceh, Palembang, Banjarmasin, Makassar, Patani & Banten",
                    "Hamzah Fansuri, Shamsuddin as-Sumatrani, Nuruddin ar-Raniri, Abdurrauf as-Singkili (first full Malay Tafsir: Tarjuman Al-Mustafid), Shaykh Yusuf al-Makassari, Abdus Samad al-Palimbani, Arsyad al-Banjari, and Shaykh Nawawi al-Bantani (d. 1897 CE in Mecca).",
                    "Generations of Indonesian scholars studied for decades in Mecca and Medina ('Ashab Al-Jawiyyin') and gradually calibrated Nusantara Islam: harmonizing Ibn 'Arabi's metaphysics with Al-Ghazali's sober Sufism, translating the Qur'an and Hadith into Malay/Javanese, and elevating Shaykh Nawawi al-Bantani to 'Sayyid 'Ulama' Al-Hijaz' (Master of the Scholars of Mecca).",
                    "The Pesantren (Islamic boarding school) and Surau/Dayah system across Sumatra and Java, teaching the canonical Kitab Kuning ('Yellow Books' of Shafi'i Fiqh, Ash'ari 'Aqidah, and Ghazalian Akhlaq)."
            ),
            new IndonesianIslamicDevelopmentStage(
                    5,
                    "INDONESIA_5_MUHAMMADIYAH_AND_NAHDLATUL_ULAMA_DUAL_WINGS",
                    "Stage V: Early 20th Century (1912–1945 CE) — The Dual Civil-Society Wings: Muhammadiyah & Nahdlatul Ulama (NU)",
                    "Yogyakarta (Kauman, 1912) & Surabaya (Tebuireng, 1926)",
                    "KH Ahmad Dahlan & Nyai Ahmad Dahlan ('Aisyiyah women's movement, 1917); KH Hasyim Asy'ari & KH Abdul Wahab Hasbullah (Nahdlatul Ulama, 1926).",
                    "Indonesian Islam organized into the two largest Islamic civil-society movements on earth: (1) Muhammadiyah (modernist reform, building thousands of modern universities, hospitals, and orphanages under Surah Al-Ma'un), and (2) Nahdlatul Ulama (traditionalist guardian of 25,000+ Pesantrens, classical Sunni-Shafi'i scholarship, and local cultural harmony).",
                    "Over 170+ Muhammadiyah universities and hundreds of hospitals + over 36,000 Pesantrens nationwide, creating a self-sustaining educational and medical welfare backbone."
            ),
            new IndonesianIslamicDevelopmentStage(
                    6,
                    "INDONESIA_6_PANCASILA_INDEPENDENCE_AND_CONSTITUTIONAL_SYNTHESIS",
                    "Stage VI: 1945–1998 CE — Independence, Pancasila ('Ketuhanan Yang Maha Esa') & Institutionalization",
                    "Jakarta, Yogyakarta & All 38 Provinces of the Republic of Indonesia",
                    "Sukarno, Mohammad Hatta, KH Wahid Hasyim, Buya Hamka, Mohammad Natsir, and Nurcholish Madjid.",
                    "To unite a 17,000-island archipelago of 87.2% Muslims (~251M people today) alongside Protestant, Catholic, Hindu, Buddhist, and Confucian citizens, Indonesian Muslim leaders agreed on Pancasila—placing 'Ketuhanan Yang Maha Esa' (Belief in the One and Only Supreme God, mirroring Tawhid / Surah Al-Ikhlas) as the First Constitutional Principle.",
                    "Istiqlal Mosque in Jakarta (largest mosque in Southeast Asia, standing directly across from Jakarta Cathedral in covenantal harmony), the Ministry of Religious Affairs (Kemenag), Islamic State Universities (UIN), and the Kompilasi Hukum Islam (KHI)."
            ),
            new IndonesianIslamicDevelopmentStage(
                    7,
                    "INDONESIA_7_MODERN_CANONICAL_HIJRAH_WAQF_SUKUK_AND_HALAL_HUB",
                    "Stage VII: 1998–Present (21st Century) — Gradual Canonical Deepening, Waqf Sukuk & Global Halal/Eco Leadership",
                    "Jakarta, Bandung, Surabaya, Aceh, Bali/Lombok & Global Nusantara Diaspora",
                    "Abdurrahman Wahid (Gus Dur), Quraish Shihab (Tafsir Al-Mishbah), Majelis Ulama Indonesia (MUI), Badan Wakaf Indonesia (BWI), and Bank Syariah Indonesia (BSI).",
                    "Over the last 40 years, Indonesia underwent a peaceful, voluntary canonical deepening: women's Hijab rose from a minority practice in the 1970s to the mainstream norm across universities, parliament, and professions; Qur'anic literacy (Iqra' method) became universal; and Indonesia pioneered sovereign Green Sukuk and Cash Waqf Linked Sukuk (CWLS) to fund clean water, hospitals, and sanitation infrastructure.",
                    "World's largest Muslim population (~251M, 87.2% of Indonesia, 99% Sunni), Sovereign Green Sukuk ($7B+ issued for climate/water infrastructure), and Eco-Pesantren sanitation programs."
            )
    );

    private static final List<IndonesiaSanitationProjectTier> SIX_SANITATION_PROJECT_TIERS = List.of(
            new IndonesiaSanitationProjectTier(
                    1,
                    "SEWER_TIER_1_RESIDENTIAL_CONCRETE_SEPTIC_AND_SOAKAWAY",
                    "1. Standard Residential On-Site Septic Tank & Soakaway (Single-Family Home)",
                    "$3,500 – $12,000 USD (Standard US gravity septic + $3,000–$6,000 perc test/engineering; or $1,500–$6,000 municipal hookup)",
                    "IDR 5,000,000 – IDR 12,000,000 ($320 – $770 USD) | Domestic PVC Routing: IDR 10K – 30K/m ($0.65–$2/m) + IDR 100K–300K/fixture labor",
                    "Standard Indonesian 3-bedroom house brick/pre-cast concrete two-chamber septic tank + gravel soakaway pit (Resapan), required under SNI 2398:2017 where centralized sewers are absent (>98% of urban/peri-urban plots).",
                    "Taharah Imperative: Prevents fecal Najasah from leaching into shallow household groundwater wells (Sumur Bor) so domestic water remains Tahur (pure and purifying for Wudu' and Ghusl)."
            ),
            new IndonesiaSanitationProjectTier(
                    2,
                    "SEWER_TIER_2_BIO_SEPTIC_FIBERGLASS_HIGH_WATER_TABLE",
                    "2. Premium Residential Fiberglass Bio-Septic Filtration Tank (High-Groundwater Zones: Jakarta, Bali, Surabaya)",
                    "$7,000 – $20,000+ USD (US engineered aerobic/mound septic system for high water tables or clay soils)",
                    "IDR 6,000,000 – IDR 15,000,000 ($380 – $960 USD fully installed: IDR 3.5M–9M tank unit + IDR 2M+ excavation/plumbing)",
                    "Multi-stage FRP (Fiberglass Reinforced Plastic) anaerobic/aerobic bio-filter tank with honeycomb media and chlorine tablet disinfection chamber, preventing groundwater pollution in coastal/alluvial aquifers.",
                    "Fulfills the Prophetic prohibition against polluting stagnant or flowing water sources ('None of you should urinate in stagnant water and then bathe from it,' Sahih al-Bukhari 239)."
            ),
            new IndonesiaSanitationProjectTier(
                    3,
                    "SEWER_TIER_3_SANIMAS_COMMUNAL_AND_ECO_PESANTREN_IPAL",
                    "3. Communal Decentralized Sanitation (SANIMAS / IPAL Komunal & Eco-Pesantren Biogas Digesters)",
                    "$50,000 – $250,000 USD (Small neighborhood cluster decentralized treatment)",
                    "IDR 350,000,000 – IDR 800,000,000 ($22,000 – $51,000 USD per 50–150 household Kampung or Pesantren cluster)",
                    "Ministry of Public Works (PUPR) SANIMAS program & Bappenas community-managed Anaerobic Baffled Reactors (ABR) with shallow small-bore PVC collection lines; in Pesantrens, coupled with biodigesters generating methane cooking gas for student kitchens.",
                    "Directly embodies Islamic Ta'awun (communal cooperation, Qur'an 5:2) and Istislah: turning waste into clean Pesantren kitchen fuel and safe greywater for mosque garden irrigation."
            ),
            new IndonesiaSanitationProjectTier(
                    4,
                    "SEWER_TIER_4_COMMERCIAL_HOTEL_AND_INDUSTRIAL_ESTATE_IPAL",
                    "4. Commercial WWTP (IPAL) & Industrial Estate Hookups (Karawang, Bekasi, Cikarang, Bali Resorts)",
                    "$200,000 – $3,000,000 USD (Modular/Package commercial wastewater treatment plants)",
                    "Industrial Hookup Tariff: IDR 120M – 180M+ ($7,700 – $11,500+ USD) | Mid-Size Commercial IPAL (200–500 m³/day): IDR 3.8 Billion – IDR 7 Billion ($250,000 – $450,000 USD)",
                    "Mandatory under Ministry of Environment (KLHK) effluent regulations for hotels, hospitals, halal food processing plants, and industrial estates (e.g., GIIC Karawang/Bekasi), utilizing MBBR/SBR biological treatment and real-time SPARING telemetry.",
                    "Enforces the legal maxim 'La Darar wa La Dirar' (No harm and no reciprocating harm) and Hisbah environmental accountability upon commercial enterprises."
            ),
            new IndonesiaSanitationProjectTier(
                    5,
                    "SEWER_TIER_5_URBAN_MICROTUNNELING_AND_PIPE_JACKING_TRUNK_MAINS",
                    "5. Dense Metropolitan Trunk Sewer Installation via Microtunneling & Pipe-Jacking (Jl. Sudirman, South Jakarta)",
                    "$50 – $250/ft ($165 – $820/m) open-cut trenching; $1,000 – $10,000+/ft ($3,280 – $32,800+/m) deep rock/urban tunneling in US",
                    "~IDR 5,100,000 per meter (~$325 USD / meter) for 450mm reinforced concrete pipe-jacking in South Jakarta",
                    "Trenchless laser-guided microtunneling and hydraulic pipe-jacking beneath high-density corridors (such as Jl. Jenderal Sudirman) to install deep trunk mains without paralyzing surface traffic or damaging utilities.",
                    "Applies the Prophetic civic principle of 'Imatat Al-Adha 'an At-Tariq' (removing harm and obstruction from public thoroughfares, Sahih Muslim 35)."
            ),
            new IndonesiaSanitationProjectTier(
                    6,
                    "SEWER_TIER_6_MEGACITY_JAKARTA_SEWERAGE_SYSTEM_JSS_KPPIP",
                    "6. Megacity Centralized Grid — Jakarta Sewerage System (JSS Zones 1 & 6 under KPPIP National Priority Projects)",
                    "$1 Million – $325+ Million USD ($12M+ per MGD capacity; 40–50% construction, 30–40% O&M/setup, up to 20% engineering)",
                    "JSS Zone 1 (Pluit): ~IDR 8 Trillion (~$515 Million USD for 4,901 hectares & 198,000 m³/day WWTP) | JSS Zone 6 (Duri Kosambi): ~IDR 5 Trillion (~$320 Million USD)",
                    "National Strategic Project (PSN) coordinated by KPPIP, Ministry of Public Works (PUPR), JICA, and PD PAL Jaya to raise Jakarta's centralized sewerage coverage from <2% toward 15-zone metropolitan integration.",
                    "Macro-scale Hifz An-Nafs (Preservation of Human Life—preventing waterborne disease across 11+ million residents) financed via Sovereign Infrastructure Budgets, JICA concessional loans, and Indonesian Sovereign Green/Waqf Sukuk."
            )
    );

    private static final List<LanguageAndCalligraphyMilestone> SEVEN_LANGUAGE_AND_CALLIGRAPHY_MILESTONES = List.of(
            new LanguageAndCalligraphyMilestone(
                    1,
                    "SCRIPT_1_HIJAZI_AND_MONUMENTAL_KUFIC_INCEPTION",
                    "1st–3rd Century AH (7th–9th Century CE) — Mecca, Medina, Kufah, Damascus & Kairouan",
                    "Abu al-Aswad ad-Du'ali (d. 688 CE), Nasr ibn 'Asim, and Yahya ibn Ya'mar added colored vowel dots (Nuqat Al-I'rab) and consonant diacritics (Nuqat Al-I'jam) to protect Qur'anic recitation across non-Arab frontiers.",
                    "Hijazi / Ma'il & Monumental Kufic (Al-Khatt Al-Kufi): Angular, horizontal geometric majesty on parchment codices (such as the Blue Qur'an on indigo vellum and the Dome of the Rock mosaic frieze, 72 AH).",
                    "Mushaf 'Uthman, Blue Qur'an of Kairouan, and the Leran Kufic Gravestone in East Java (1082 CE).",
                    "Qur'an 96:4 ('Who taught by the Pen [Al-Qalam]') & 68:1 ('Nun. By the Pen and what they inscribe')"
            ),
            new LanguageAndCalligraphyMilestone(
                    2,
                    "SCRIPT_2_SIBAWAYH_GRAMMAR_AND_IBN_MUQLAH_PROPORTIONED_GEOMETRY",
                    "2nd–4th Century AH (8th–10th Century CE) — Basrah & Abbasid Baghdad",
                    "Al-Khalil ibn Ahmad al-Farahidi compiled the first acoustic-phonetic dictionary in human history (Kitab Al-'Ayn, ordered from deepest throat letter 'Ayn to labial Mim), and his Persian student Sibawayh (d. 796 CE) wrote Al-Kitab—the supreme constitution of Arabic syntax ('Ilm An-Nahw).",
                    "Ibn Muqlah's Geometric Revolution (Al-Khatt Al-Mansub, d. 940 CE): Vizier Ibn Muqlah codified calligraphy as pure Euclidean geometry governed by 3 modules: (1) the Rhomboid Dot (An-Nuqtah) of the reed nib, (2) the vertical Alif (5 to 7 dots tall), and (3) the Circle (Ad-Da'irah) whose diameter equals the Alif.",
                    "Al-Khalil's Kitab Al-'Ayn, Sibawayh's Al-Kitab, and Ibn Muqlah's Risalah fi Al-Khatt wa Al-Qalam.",
                    "Qur'an 54:49 ('Indeed, We have created all things in exact measure [bi-Qadar]')"
            ),
            new LanguageAndCalligraphyMilestone(
                    3,
                    "SCRIPT_3_AL_AQLAM_AS_SITTAH_SIX_CLASSICAL_PENS",
                    "5th–7th Century AH (11th–13th Century CE) — Baghdad, Cairo & Mosul",
                    "Ibn Jinni (Al-Khasa'is on root etymology/Ishtiqaq), Ibn Faris (Maqayis Al-Lughah), and 'Abd al-Qahir al-Jurjani (Dala'il Al-I'jaz on syntactic semantics/Nazm) established how Arabic roots generate infinite scientific and literary meanings.",
                    "Ibn al-Bawwab (d. 1022 CE) and Yaqut al-Musta'simi (d. 1298 CE, who introduced the oblique reed-nib cut) perfected the Six Classical Scripts (Al-Aqlam As-Sittah): (1) Naskh, (2) Thuluth, (3) Muhaqqaq, (4) Rayhani, (5) Tawqi', and (6) Riqa'.",
                    "Ibn al-Bawwab's Chester Beatty Qur'an (391 AH / 1000 CE) and Yaqut al-Musta'simi's Baghdad Mushafs.",
                    "Al-Khatt Handasah Ruhaniyyah Zaharat bi-Alat Jismani ('Calligraphy is spiritual geometry made visible through a bodily instrument')"
            ),
            new LanguageAndCalligraphyMilestone(
                    4,
                    "SCRIPT_4_MAGHRIBI_ANDALUSI_AND_SUDANI_AJAMI_FRONTIER",
                    "4th–10th Century AH (10th–16th Century CE) — Cordoba, Fez, Granada, Kairouan & Timbuktu",
                    "Andalusian and Maghrebi philologists (Ibn Malik's Alfiyyah—1,000-verse grammatical poem still memorized in every Indonesian Pesantren today—and Ibn Ajurrum's Ajurrumiyyah) created the pedagogical grammar curriculum of the entire Muslim world.",
                    "Maghribi & Andalusi Script (Al-Khatt Al-Maghribi): Written with a blunt-pointed reed pen, featuring sweeping hemispheric bowls for final Nun/Qaf/Sin, golden saffron/lapis illumination, and West African Sudani/Ajami adaptations in Timbuktu.",
                    "Ibn Malik's Alfiyyah (Jaén/Damascus, d. 1274 CE), Ibn Ajurrum's Matn Al-Ajurrumiyyah (Fez, d. 1323 CE), and Pink Qur'ans of Granada.",
                    "Uniting Western Mediterranean aesthetic grace with universal grammatical pedagogy"
            ),
            new LanguageAndCalligraphyMilestone(
                    5,
                    "SCRIPT_5_PERSIANATE_NASTALIQ_AND_INDO_ISLAMIC_ILLUMINATION",
                    "8th–11th Century AH (14th–17th Century CE) — Tabriz, Herat, Isfahan, Samarkand & Agra",
                    "New Persian (Farsi), Chagatai Turkic, and Urdu absorbed 40–60% Arabic vocabulary written in the Arabic script, creating a trans-continental poetic and administrative cosmopolis from Bosnia to Bengal.",
                    "Ta'liq & Nasta'liq ('Arus Al-Khutut — 'The Bride of Scripts'): Codified by Mir 'Ali Tabrizi and Sultan 'Ali Mashhadi, with sweeping diagonal cascading strokes ('hanging' from right to left) that mirror musical cadence and garden geometry, alongside monumental Timurid/Mughal Thuluth.",
                    "Mir 'Ali Tabrizi, Mir 'Imad Hassani (d. 1615 CE), and Amanat Khan (calligrapher of the Taj Mahal's optical-scaled Thuluth).",
                    "Optical scaling: enlarging upper Thuluth bands on high archways so letters appear uniform in size from the ground"
            ),
            new LanguageAndCalligraphyMilestone(
                    6,
                    "SCRIPT_6_OTTOMAN_DIWANI_JALI_THULUTH_AND_IMPERIAL_TUGHRA",
                    "9th–14th Century AH (15th–20th Century CE) — Istanbul, Edirne, Bursa & Cairo",
                    "Ottoman Turkish synthesized Arabic sciences, Persian poetics, and Turkic syntax into a three-continent imperial chancery and scholarly language.",
                    "The Ottoman Calligraphic School ('The Qur'an was revealed in Mecca, recited in Egypt, and written in Istanbul'): Shaykh Hamdullah, Hafiz 'Uthman (standardized the modern printed Naskh Mushaf layout), and Mustafa Raqim perfected Diwani, Jali Diwani, Ruq'ah (daily fast hand), Hilye-i Şerif panels, and the cryptographic Imperial Tughra.",
                    "Shaykh Hamdullah (d. 1520), Hafiz 'Uthman (d. 1698), Mustafa Raqim (d. 1826), and Hamid Aytaç.",
                    "The Hilye-i Şerif: replacing figurative portraits with a calligraphic verbal portrait of the Prophet's noble character and appearance"
            ),
            new LanguageAndCalligraphyMilestone(
                    7,
                    "SCRIPT_7_NUSANTARA_JAWI_PEGON_AND_INDONESIAN_MUSHAF_ISTIQLAL",
                    "7th–15th Century AH (13th–21st Century CE) — Aceh, Banten, Demak, Yogyakarta & Jakarta",
                    "Southeast Asian scholars created JAWI (Arabic script for Malay/Indonesian by adding 6 three-dotted letters: Ca چ, Nga ڠ, Pa ڤ, Ga ڬ, Nya ڽ, Va ۏ) and PEGON (vocalized Arabic script for Javanese/Sundanese/Madurese interlinear Kitab Kuning translation)—infusing 2,500+ Arabic words into Bahasa Indonesia (Adil, Musyawarah, Rakyat, Hukum, Ilmu, Wakaf).",
                    "Nusantara Illumination & Mushaf Istiqlal: Illuminated Qur'ans of Aceh, Banten, and Yogyakarta blending Naskh/Thuluth with tropical golden floral Sulur/Batik borders, Cirebon calligraphic glass-painting (Macan Ali), and the monumental Mushaf Istiqlal (1991–1995) uniting the sacred script with the indigenous floral motifs of all Indonesian provinces.",
                    "Raja Ali Haji's Bustan al-Katibin (1850 Jawi grammar), KH Bisri Mustofa's Pegon Tafsir Al-Ibriz, and Indonesia's National Mushaf Istiqlal.",
                    "Qur'an 30:22 ('And among His signs is the creation of the heavens and the earth, and the diversity of your languages and your colors')"
            )
    );

    public static Abjad261WafqMatrix zakeemMalikMcCalebWafq() {
        return ZAKEEM_MALIK_MCCALEB_WAFQ;
    }

    public static List<RegionalCanonicalNamingTradition> allSevenRegionalNamingTraditions() {
        return SEVEN_REGIONAL_NAMING_TRADITIONS;
    }

    public static List<IndonesianIslamicDevelopmentStage> allSevenIndonesianDevelopmentStages() {
        return SEVEN_INDONESIAN_DEVELOPMENT_STAGES;
    }

    public static List<IndonesiaSanitationProjectTier> allSixSanitationProjectTiers() {
        return SIX_SANITATION_PROJECT_TIERS;
    }

    public static List<LanguageAndCalligraphyMilestone> allSevenLanguageAndCalligraphyMilestones() {
        return SEVEN_LANGUAGE_AND_CALLIGRAPHY_MILESTONES;
    }
}
