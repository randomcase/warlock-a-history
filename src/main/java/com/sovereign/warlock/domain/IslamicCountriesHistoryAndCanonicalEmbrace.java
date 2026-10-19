package com.sovereign.warlock.domain;

import java.util.List;

/**
 * Canonical Synthesis of the History of Islamic Countries (Diyar Al-Islam / The 57 OIC Member States
 * and Historic Muslim Lands Across 7 Civilizational Zones) and How They Canonically Embrace Being Muslim:
 * 1. The 5 Historical Pathways by Which Nations Embraced Islam (Prophetic Delegations, Post-Conquest
 *    Multi-Century Civic Synthesis, Maritime/Caravan Trade, Sufi Awliya' & Anti-Colonial Sovereignty).
 * 2. The 7 Canonical Civilizational Zones of the Islamic World (Arabian Cradle, Fertile Crescent & Nile,
 *    Maghreb & Saharan-Sahelian West, East Africa & Horn, Anatolian-Balkan-Caucasian-Turkic Steppe,
 *    Persianate & South Asian Subcontinent, and Nusantara Maritime Archipelago).
 * 3. The 6 Institutional Pillars of How Islamic Countries Canonically Embody Being Muslim Today.
 */
public final class IslamicCountriesHistoryAndCanonicalEmbrace {

    private IslamicCountriesHistoryAndCanonicalEmbrace() {
    }

    /**
     * Represents one of the 5 Canonical Historical Pathways by which nations and peoples
     * embraced Islam across history.
     */
    public record HistoricalEmbracePathway(
            int pathwayIndex,
            String pathwayCode,
            String pathwayTitle,
            String historicalMechanismAndDemographics,
            String exemplarCountriesAndRegions,
            String canonicalPrincipleAndTextualProof
    ) {
        public HistoricalEmbracePathway {
            if (pathwayIndex < 1 || pathwayIndex > 5) {
                throw new IllegalArgumentException("pathwayIndex must be in [1..5]");
            }
        }
    }

    /**
     * Represents one of the 7 Canonical Civilizational Zones of Islamic Countries (Diyar Al-Islam).
     */
    public record IslamicCivilizationalZone(
            int zoneIndex,
            String zoneCode,
            String zoneTitleAndPopulationShare,
            String sovereignCountriesAndPolities,
            String historicalPathwayOfEmbrace,
            String canonicalMadhhabAndAqidah,
            String howTheyEmbraceBeingMuslimToday,
            String landmarkInstitutionsAndSanctuaries
    ) {
        public IslamicCivilizationalZone {
            if (zoneIndex < 1 || zoneIndex > 7) {
                throw new IllegalArgumentException("zoneIndex must be in [1..7]");
            }
        }
    }

    /**
     * Represents one of the 6 Institutional & Cultural Pillars by which Islamic countries
     * canonically express and live out being Muslim.
     */
    public record InstitutionalEmbracePillar(
            int pillarIndex,
            String pillarCode,
            String arabicAndEnglishTitle,
            String constitutionalAndCivicExpression,
            String crossRegionalExamples,
            String quranicAndSunnahAnchor
    ) {
    }

    private static final List<HistoricalEmbracePathway> FIVE_HISTORICAL_PATHWAYS = List.of(
            new HistoricalEmbracePathway(
                    1,
                    "PATHWAY_1_PROPHETIC_DELEGATIONS_AND_COVENANT_LETTERS",
                    "Pathway I: Prophetic Delegations & Covenantal Letters (Wufud Al-'Arab wa Kutub An-Nabi, 1–10 AH / 622–632 CE)",
                    "During the Prophet's own lifetime, entire nations and regions embraced Islam peacefully without a single battle by sending scholarly/tribal delegations (Year of Delegations, 9 AH) or receiving the Prophet's sealed letters.",
                    "Medina (Al-Ansar via the Pledges of 'Aqabah), Yemen (via Mu'adh ibn Jabal & 'Ali ibn Abi Talib), Bahrain/Eastern Arabia ('Abd al-Qays & Mundhir ibn Sawa), and Oman (Kings Jaifar and 'Abd, sons of Al-Julanda).",
                    "Qur'an 110:1-2 ('When the victory of Allah has come and the opening, and you see the people entering into the religion of Allah in multitudes'), Sahih al-Bukhari 4388 ('Faith is Yemeni and wisdom is Yemeni') & Sahih Muslim 2544 (Praise of the people of Oman)"
            ),
            new HistoricalEmbracePathway(
                    2,
                    "PATHWAY_2_POST_CONQUEST_MULTI_CENTURY_CIVIC_SYNTHESIS",
                    "Pathway II: Post-Conquest Gradual Civic & Urban Synthesis (Al-Futuhat wa Al-Amsar, 12–350 AH / 633–960 CE)",
                    "Where early Muslim armies toppled Byzantine and Sasanian imperial regimes, forced conversion was strictly forbidden (Qur'an 2:256). Historical demography (Richard Bulliet, Al-Baladhuri) proves that Egypt, Syria, Iraq, Iran, and North Africa remained majority non-Muslim for 150 to 250 years after the conquest, embracing Islam gradually through the new garrison cities (Amsar), tax relief, egalitarian mosque prayer rows, Qadi court fairness, and Arabic scientific literacy.",
                    "Egypt, Syria, Palestine, Jordan, Iraq, Iran, Uzbekistan/Tajikistan (Transoxiana), Libya, Tunisia, Algeria, Morocco, and historical Al-Andalus.",
                    "Qur'an 2:256 ('There is no compulsion in religion; truth has stood clear from error') & Caliph 'Umar's Covenant of Jerusalem (15 AH)"
            ),
            new HistoricalEmbracePathway(
                    3,
                    "PATHWAY_3_MARITIME_AND_TRANS_SAHARAN_MERCHANT_MIZAN",
                    "Pathway III: Indian Ocean Maritime & Trans-Saharan Caravan Trade (At-Tijarah Al-Aminah, 7th–17th Century CE)",
                    "Across Southeast Asia, East Africa, and West Africa—representing MORE THAN HALF of the world's Muslim population today—not a single Arab, Persian, or Ottoman army ever invaded. Kings, port cities, and populations embraced Islam purely by witnessing the contractual integrity, uncorrupted weights (Al-Mizan), literacy, and daily Wudu'/Salah of Muslim sea-captains and caravan traders.",
                    "Indonesia (~251M Muslims), Malaysia, Brunei, Maldives, Comoros, Somalia, Swahili Coast (Zanzibar/Tanzania/Kenya), Mali, Senegal, Guinea, Gambia, Niger, and Chad.",
                    "Sunan at-Tirmidhi 1209 ('The truthful, trustworthy merchant is with the Prophets, the truthful, and the martyrs') & Qur'an 55:7-9 (Al-Mizan)"
            ),
            new HistoricalEmbracePathway(
                    4,
                    "PATHWAY_4_SUFI_AWLIYA_RIBAT_GUILDS_AND_AGRARIAN_PIONEERS",
                    "Pathway IV: Sufi Awliya', Futuwwah Guilds & Agrarian Frontier Pioneers (10th–18th Century CE)",
                    "Sufi masters and trade-guild brotherhoods traveled into nomadic steppes, mountain valleys, and river deltas: establishing free soup kitchens (Imaret/Langar), clearing jungle deltas for wet-rice agriculture (as in Bengal), composing vernacular devotional poetry in Turkic, Persian, Punjabi, Bengali, and Javanese, and welcoming marginalized castes into universal human brotherhood.",
                    "Bangladesh (~170M Muslims via Shah Jalal & delta pioneers), Pakistan (via Data Ganj Bakhsh Hujwiri, Baba Farid & Baha'uddin Zakariyya), Türkiye & Balkans (Bosnia, Albania, Kosovo), Kazakhstan/Kyrgyzstan (via Ahmad Yasawi), Tatarstan/Volga (922 CE), and Java (via the Wali Songo).",
                    "Qur'an 10:62 ('Unquestionably, the allies [Awliya'] of Allah—there will be no fear concerning them, nor will they grieve') & Qur'an 16:125"
            ),
            new HistoricalEmbracePathway(
                    5,
                    "PATHWAY_5_ANTI_COLONIAL_LIBERATION_AND_MODERN_CONSTITUTIONALISM",
                    "Pathway V: Anti-Colonial Liberation, Educational Revival & Constitutional Nationhood (18th–21st Century CE)",
                    "When European empires colonized the Muslim world, Islam became the unbreakable spine of indigenous dignity, literacy, and liberation—culminating in the independence of 57 OIC sovereign states that synthesized Islamic legal/moral heritage with modern constitutional governance.",
                    "Algeria (Amir 'Abd al-Qadir & 1954–1962 Liberation), Libya ('Umar al-Mukhtar), Caucasus (Imam Shamil), West Africa (Usman dan Fodio & Ahmadu Bamba), Indonesia (Diponegoro, Muhammadiyah/NU & 1945 Resolusi Jihad), and Pakistan (1947 constitutional homeland).",
                    "Qur'an 22:39-40, Qur'an 42:38 ('And their affairs are conducted by mutual consultation [Shura]') & OIC Charter (1969)"
            )
    );

    private static final List<IslamicCivilizationalZone> SEVEN_CIVILIZATIONAL_ZONES = List.of(
            new IslamicCivilizationalZone(
                    1,
                    "ZONE_1_ARABIAN_CRADLE_AND_GULF_SANCTUARY",
                    "Zone I: The Arabian Cradle & Gulf Sanctuary (Jazirat Al-'Arab wa Al-Khalij)",
                    "Saudi Arabia, Yemen, Oman, United Arab Emirates, Qatar, Bahrain, Kuwait",
                    "Direct Prophetic mission in Mecca and Medina (610–632 CE) and peaceful Prophetic delegations (Wufud) from Bahrain, Oman, and Yemen in 8–10 AH.",
                    "Hanbali (Saudi Arabia, Qatar), Maliki (UAE, Bahrain, Kuwait), Shafi'i & Zaydi (Yemen), Ibadi & Sunni (Oman); Salafi/Athari, Ash'ari & Ibadi creedal traditions.",
                    "Custodianship of the Two Holy Mosques (Al-Haramayn Ash-Sharifayn) serving millions of Hajj and 'Umrah pilgrims; constitutional governance grounded in Qur'an and Sunnah; Majlis hospitality; Yemen's unbroken Tarim scholarly Isnad; Oman's maritime tolerance; and global Sovereign Waqf/Humanitarian funds.",
                    "Al-Masjid Al-Haram (Mecca), Al-Masjid An-Nabawi (Medina), Masjid 'Abd al-Qays (Bahrain), Dar al-Mustafa (Tarim, Yemen), and Sultan Qaboos Grand Mosque (Oman)."
            ),
            new IslamicCivilizationalZone(
                    2,
                    "ZONE_2_FERTILE_CRESCENT_LEVANT_IRAQ_AND_NILE",
                    "Zone II: The Fertile Crescent, Levant & Nile Valley (Ash-Sham, Al-'Iraq, Misr wa As-Sudan)",
                    "Egypt (~100M+ Muslims), Iraq, Syria, Palestine, Jordan, Lebanon, Sudan",
                    "Rashidun openings (12–21 AH / 633–642 CE) under 'Umar's covenants protecting Christian and Jewish communities, followed by 200+ years of gradual civic conversion in Kufah, Basrah, Damascus, and Fustat/Cairo; peaceful Nile merchant/Sufi diffusion into Sudan (Funj Sultanate, 1504 CE).",
                    "Shafi'i, Hanafi & Maliki (Egypt); Hanafi, Shafi'i & Ja'fari (Iraq & Lebanon); Hanafi & Shafi'i (Syria, Palestine, Jordan); Maliki (Sudan). Predominantly Ash'ari/Maturidi & Ja'fari.",
                    "Egypt anchors global Sunni learning at Al-Azhar (970 CE) and the world's premier Qur'anic recitation school (Qurra'); Palestine and Jordan guard Al-Masjid Al-Aqsa in Jerusalem; Iraq and Syria preserve the birthplaces of the 4 Madhhabs and Hadith sciences; Sudan maintains thousands of Khalwah wooden-tablet (Lawh) Qur'an schools.",
                    "Al-Masjid Al-Aqsa (Jerusalem), Umayyad Mosque (Damascus), Al-Azhar Mosque & University (Cairo), Imam Abu Hanifah & 'Abd al-Qadir al-Jilani Sanctuaries (Baghdad)."
            ),
            new IslamicCivilizationalZone(
                    3,
                    "ZONE_3_MAGHREB_AND_SAHARAN_SAHELIAN_WEST_AFRICA",
                    "Zone III: The Maghreb & Saharan-Sahelian West Africa (Al-Maghrib wa Gharb Ifriqiya)",
                    "Morocco, Algeria, Tunisia, Libya, Mauritania, Senegal, Mali, Niger, Guinea, Gambia, Sierra Leone, Burkina Faso, Chad, Northern Nigeria (~260M+ Muslims across the zone)",
                    "In North Africa, Amazigh (Berber) peoples embraced Islam from Kairouan (50 AH) and Fez (172 AH); from Morocco and Mauritania (Shinqit), Sanhaja and Juula/Wangara merchants and scholars carried Islam peacefully across the Sahara into Ghana, Mali (Mansa Musa), Songhai, Kanem-Bornu, and Sokoto.",
                    "Unified across the entire zone upon the Canonical Maghrebi Triad: (1) Imam Malik's Fiqh, (2) Imam Al-Ash'ari's 'Aqidah, and (3) Junayd's sober Tasawwuf, reciting the Qur'an in Warsh 'an Nafi' and Qalun.",
                    "Morocco preserves the Commander of the Faithful (Imarat Al-Mu'minin) charter, Habous endowments, and Al-Qarawiyyin (world's oldest university, 859 CE); Mauritania's desert Mahdarah tent-schools produce walking Huffaz of the Qur'an and Mudawwanah; Senegal (Touba/Tivaouane), Mali (Timbuktu), and Nigeria integrate Sufi brotherhoods (Tijaniyyah, Muridiyyah, Qadiriyyah) with civic charity and scholarship.",
                    "Al-Qarawiyyin University (Fez, 859 CE), Az-Zaytunah (Tunis, 737 CE), Great Mosque of Kairouan, Sankore Mosque-University (Timbuktu), and Great Mosque of Touba (Senegal)."
            ),
            new IslamicCivilizationalZone(
                    4,
                    "ZONE_4_HORN_OF_AFRICA_AND_SWAHILI_INDIAN_OCEAN",
                    "Zone IV: The Horn of Africa & Swahili Indian Ocean Coast (Al-Qarn Al-Ifriqi wa Sahil Az-Zanj)",
                    "Somalia, Djibouti, Comoros, Eritrea, Ethiopian Muslim Regions (Harar, Afar, Oromia, Somali), Zanzibar/Tanzania, Coastal Kenya & Northern Mozambique",
                    "First land outside Arabia to welcome Muslim refugees during the First Hijrah to Abyssinia (615 CE / 7 BH), followed by peaceful Red Sea and Indian Ocean maritime trade and Hadrami/Yemeni scholarly migration across Zeila, Mogadishu, Harar, Kilwa, Lamu, Mombasa, and Zanzibar.",
                    "Predominantly Imam Ash-Shafi'i's Fiqh and Ash'ari 'Aqidah (with Hanafi and Maliki communities in Eritrea and Ethiopia).",
                    "Somalia and Djibouti (nearly 100% Sunni Shafi'i) center village and urban life around Dugsi Qur'anic academies, customary Xeer arbitration calibrated by Shari'ah, and oral poetry; Harar ('Madinat Al-Awliya') preserves 82 historic mosques; Comoros and Zanzibar unite Shafi'i scholarship, Mawlid festivals, and Swahili maritime architecture.",
                    "Masjid al-Qiblatayn in Zeila (7th c.), Mosque of Fakhr ad-Din in Mogadishu (1269 CE), Walled City of Harar, Great Mosque of Kilwa, and Stone Town (Zanzibar)."
            ),
            new IslamicCivilizationalZone(
                    5,
                    "ZONE_5_ANATOLIA_BALKANS_CAUCASUS_AND_TURKIC_EURASIA",
                    "Zone V: Anatolia, The Balkans, The Caucasus & Central Asian Turkic-Tajik Heartland",
                    "Türkiye (~85M), Uzbekistan (~36M), Kazakhstan, Azerbaijan, Tajikistan, Turkmenistan, Kyrgyzstan, Bosnia & Herzegovina, Albania, Kosovo, plus Tatarstan, Bashkortostan, Dagestan & Chechnya",
                    "Transoxiana (Bukhara, Samarkand, Khwarazm) became the golden crucible of Hadith and science in the 8th–10th centuries; Volga Bulgaria (Tatarstan) embraced Islam voluntarily via Baghdad embassy in 922 CE (Ibn Fadlan); Karakhanid, Seljuk, and Kipchak Turks embraced Islam via Sufi masters (Ahmad Yasawi) and carried it into Anatolia and the Balkans (Bosnia, Albania, Kosovo).",
                    "Imam Abu Hanifah's Fiqh paired with Imam Abu Mansur al-Maturidi's (of Samarkand) rational-traditional 'Aqidah (plus Shafi'i in Dagestan/Chechnya and Ja'fari/Hanafi in Azerbaijan); Naqshbandi, Mawlawi, Yassawi & Qadiri Tasawwuf.",
                    "Uzbekistan and Tajikistan honor their native sons Imam Al-Bukhari, At-Tirmidhi, Al-Maturidi, Al-Khwarizmi, and Ibn Sina; Türkiye coordinates 90,000+ mosques via the Diyanet, Ramadan Mukabele recitations, and Vakıf foundations; Bosnia & Herzegovina governs religious life through the Rijaset (Islamska Zajednica) and Gazi Husrev-beg Madrasa (operating continuously in Sarajevo since 1537 CE).",
                    "Süleymaniye Mosque (Istanbul), Poi-Kalyan & Registan (Bukhara & Samarkand), Mausoleum of Khoja Ahmad Yasawi (Turkistan), Gazi Husrev-beg Mosque (Sarajevo, 1531 CE), and Qolşärif Mosque (Kazan)."
            ),
            new IslamicCivilizationalZone(
                    6,
                    "ZONE_6_PERSIANATE_PLATEAU_AND_SOUTH_ASIAN_SUBCONTINENT",
                    "Zone VI: The Persianate Plateau & South Asian Subcontinent (Iran, Afghanistan, Pakistan, Bangladesh, India & Maldives — ~680M+ Muslims)",
                    "Pakistan (~235M Muslims), Bangladesh (~170M), India (~200M+ Muslim minority), Iran (~88M), Afghanistan (~40M), Maldives (~100% Muslim)",
                    "Iran and Khorasan embraced Islam gradually (8th–10th c.), producing Sibawayh, the Hadith Six-Book masters, and Persian Sufi poetry; Sindh entered via Muhammad ibn al-Qasim's tolerant Charter of Al-Rur (711 CE); Punjab, Kashmir, and Bengal embraced Islam overwhelmingly through Sufi saints (Data Ganj Bakhsh, Baba Farid, Shah Jalal) and agrarian delta pioneers; Maldives converted peacefully in 1153 CE via Abu al-Barakat al-Barbari.",
                    "Hanafi Fiqh & Maturidi/Ash'ari 'Aqidah (Pakistan, Bangladesh, Afghanistan, India); Shafi'i Fiqh (Maldives & Malabar/Konkan Coast); Twelver Ja'fari Fiqh alongside Sunni Shafi'i/Hanafi regions (Iran).",
                    "Pakistan's 1973 Constitution establishes Islam as the state religion with the Council of Islamic Ideology and Federal Shariat Court; Bangladesh combines vibrant mosque/Madrasah networks and Bishwa Ijtema with delta agriculture; Iran centers life around Ja'fari Hawzah seminaries (Qom/Mashhad) and Persian poetic-architectural splendor; Maldives maintains 100% Muslim coral-stone and Friday mosque citizenship.",
                    "Imam Reza Sanctuary (Mashhad), Friday Mosque of Herat, Badshahi & Faisal Mosques (Lahore & Islamabad), Sixty Dome Mosque (Bagerhat, Bangladesh, 15th c.), and Old Friday Mosque of Malé (1658 CE)."
            ),
            new IslamicCivilizationalZone(
                    7,
                    "ZONE_7_NUSANTARA_MARITIME_SOUTHEAST_ASIA",
                    "Zone VII: The Maritime Nusantara Archipelago (Indonesia, Malaysia, Brunei, Patani & Bangsamoro — ~285M+ Muslims)",
                    "Indonesia (~251M Muslims / 87.2% — World's Largest Muslim Nation), Malaysia (~22M), Brunei Darussalam, plus Southern Thailand (Patani) and Southern Philippines (Bangsamoro)",
                    "Zero military invasions: spread entirely from the 7th to 16th centuries via Arab/Persian/Gujarati maritime merchants, coastal sultanates (Samudera Pasai, Malacca, Aceh 'Serambi Mekkah', Brunei, Demak, Banten, Gowa, Sulu), the Wali Songo's gradualist dakwah (At-Tadarruj), and the Haramayn 'Ashab Al-Jawiyyin' scholarly network.",
                    "Unanimously united upon Imam Ash-Shafi'i's Fiqh, Imam Al-Ash'ari's 'Aqidah, and Imam Al-Ghazali's Tasawwuf.",
                    "Indonesia unites 17,000 islands under Pancasila ('Ketuhanan Yang Maha Esa' — Belief in the One Supreme God), the dual wings of Muhammadiyah (170+ universities, hundreds of hospitals) and Nahdlatul Ulama (36,000+ Pesantrens), Kompilasi Hukum Islam, and Sovereign Green/Waqf Sukuk; Malaysia pioneers global Islamic banking and Tabung Haji; Brunei upholds Melayu Islam Beraja.",
                    "Masjid Agung Demak (1479 CE, 3-tier Tajug roof), Baiturrahman Grand Mosque (Banda Aceh), Istiqlal Mosque (Jakarta), National Mosque of Malaysia (Kuala Lumpur), and Sultan Omar Ali Saifuddien Mosque (Brunei)."
            )
    );

    private static final List<InstitutionalEmbracePillar> SIX_INSTITUTIONAL_PILLARS = List.of(
            new InstitutionalEmbracePillar(
                    1,
                    "PILLAR_1_SIYASAH_SHARIYYAH_AND_CONSTITUTIONAL_HARMONY",
                    "1. Constitutional & Judicial Harmonization (As-Siyasah Ash-Shar'iyyah wa Al-Ahwal Ash-Shakhsiyyah)",
                    "Every Muslim-majority country integrates Islamic ethics and family/inheritance/endowment law into its legal system—ranging from direct Shar'i constitutionalism (Saudi Arabia, Brunei) and constitutional Islam clauses (Morocco, Egypt, Jordan, Pakistan, Malaysia) to covenantal monotheistic pluralism (Indonesia's Pancasila & Türkiye/Senegal/Bosnia's autonomous religious directorates).",
                    "Morocco's Mudawwanah, Indonesia's Kompilasi Hukum Islam (KHI) & Religious Courts (Peradilan Agama), Malaysia's Syariah Judiciary, and Jordan/Egypt's Dar Al-Ifta'.",
                    "Qur'an 4:58 ('When you judge between people, judge with justice'), 5:48 & 42:38 (Shura)"
            ),
            new InstitutionalEmbracePillar(
                    2,
                    "PILLAR_2_ADHAN_JUMUAH_AND_SACRED_TEMPORAL_RHYTHM",
                    "2. Acoustic & Temporal Sanctification (Al-Adhan, Salat Al-Jumu'ah & The Hijri Sacred Calendar)",
                    "Across all 57 OIC nations, the public soundscape and civic calendar are synchronized with cosmic worship: the 5 daily calls to prayer (Al-Adhan) rolling from Jakarta to Casablanca, the weekly Friday congregation (Jumu'ah), the month-long fast and night prayers of Ramadan (Tarawih, Iftar tables, Mudik/Bayram homecomings), and the two Eids.",
                    "Indonesian Bedug drum + Adhan; Egyptian and Turkish Maqamat Adhan; Moroccan white Djellaba Friday processions; and universal Eid al-Fitr / Eid al-Adha Qurban meat distribution.",
                    "Qur'an 62:9 (Surah Al-Jumu'ah), 2:183-185 (Ramadan) & 22:27-28 (Hajj & Adha)"
            ),
            new InstitutionalEmbracePillar(
                    3,
                    "PILLAR_3_WAQF_ZAKAT_AND_SOVEREIGN_SUKUK_ECONOMY",
                    "3. Endowed Public Welfare & Ethical Economy (Az-Zakah, Al-Waqf / Habous / Vakıf & Sukuk)",
                    "Muslim nations institutionalize wealth circulation so prosperity never stagnates among the rich (Qur'an 59:7): national Zakat boards, perpetual Waqf endowments funding hospitals, universities, and water/sanitation, and riba-free Islamic Banking and Sovereign Sukuk.",
                    "Malaysia's Tabung Haji ($20B+ pilgrim fund); Indonesia's Badan Amil Zakat Nasional (BAZNAS) & Cash Waqf Linked Sukuk (CWLS); Morocco's Ministry of Habous; and Gulf/Turkish Awqaf.",
                    "Qur'an 59:7 ('So that wealth may not merely circulate among the rich among you'), 2:275 & Sahih Muslim 1631 (Sadaqah Jariyah)"
            ),
            new InstitutionalEmbracePillar(
                    4,
                    "PILLAR_4_ISNAD_SCHOLARSHIP_MADRASAH_AND_PESANTREN",
                    "4. Unbroken Scholarly Transmission & Dual-Wing Education (Al-Isnad, Al-Jami'ah & Pesantren)",
                    "Islamic countries preserve the world's oldest continuously operating universities alongside grassroots Qur'anic schools—ensuring that classical Fiqh, Hadith, grammar, and spirituality are transmitted person-to-person alongside modern medicine and engineering.",
                    "Al-Qarawiyyin in Fez (859 CE), Al-Azhar in Cairo (970 CE), Gazi Husrev-beg in Sarajevo (1537 CE), 36,000+ Indonesian Pesantrens, Mauritanian Mahdarahs, and West African Daaras/Makarantas.",
                    "Qur'an 9:122 ('That they may obtain understanding [Tafaqquh] in the religion') & Sahih al-Bukhari 67"
            ),
            new InstitutionalEmbracePillar(
                    5,
                    "PILLAR_5_TAHARAH_WATER_ARCHITECTURE_AND_DOMESTIC_HARAM",
                    "5. Sacred Urban Ecology, Water Purity & Domestic Sanctuary ('Imarat Al-Masjid wa At-Taharah)",
                    "Cities across the Muslim world are architected around three spatial anchors: (1) the congregational Mosque with its ablution fountains (Mida'ah) and clean water infrastructure, (2) the ethical marketplace (Suq/Pasar) with honest scales, and (3) the private family home (Haram Al-Bayt) protected from overlooking.",
                    "Ottoman Külliye complexes (mosque + hospital + soup kitchen + bathhouse); Moroccan Riyads; Iranian Chahar Bagh & Qanat water channels; and Indonesian Eco-Pesantren sanitation.",
                    "Qur'an 24:36, Sahih Muslim 223 ('Cleanliness [At-Tuhur] is half of faith') & Bukhari 239"
            ),
            new InstitutionalEmbracePillar(
                    6,
                    "PILLAR_6_URF_CULTURAL_PLURALISM_UNDER_ONE_TAWHID",
                    "6. Indigenous Cultural Pluralism Under One Tawhid (Al-'Urf Al-Mahmud — 'Like a Clear Mountain Stream')",
                    "As articulated by the juristic maxim 'Islamic law is like a crystal-clear river that takes on the color of the bedrock over which it flows while remaining pure water': Islam never erased a nation's healthy culture, language, cuisine, or architecture—it purified them of idolatry and injustice while celebrating their diversity as a sign of Allah.",
                    "Javanese Tajug mosques & Batik; Moroccan Zellij & Burnous; Bosnian Sevdalinka & stone bridges; Uzbek turquoise domes & Chapan; Swahili coral mosques; and West African adobe architectures.",
                    "Qur'an 49:13 ('We made you peoples and tribes that you may know one another') & Qur'an 30:22 ('Diversity of your languages and colors')"
            )
    );

    public static List<HistoricalEmbracePathway> allFiveHistoricalPathways() {
        return FIVE_HISTORICAL_PATHWAYS;
    }

    public static List<IslamicCivilizationalZone> allSevenCivilizationalZones() {
        return SEVEN_CIVILIZATIONAL_ZONES;
    }

    public static List<InstitutionalEmbracePillar> allSixInstitutionalPillars() {
        return SIX_INSTITUTIONAL_PILLARS;
    }
}
