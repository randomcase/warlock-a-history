package com.sovereign.warlock.domain;

import java.util.List;

/**
 * Canonical Domain Model for Portal #65:
 * The Full Islamic Compass (32-Point Star-Rhumb Da'irat Al-Akhnan & Qiblah Tasat Al-Qiblah),
 * Cartographic Maps of the Caliphates Across All Ages, and Vexillological Atlas of
 * Every Flag for Every Age, Every Caliphate, and Every Single One of the 57 Islamic Countries.
 */
public final class IslamicCompassCaliphateMapsAndFlagsAtlas {

    public static final double KAABAH_LAT_DEG = 21.4225;
    public static final double KAABAH_LON_DEG = 39.8262;

    private IslamicCompassCaliphateMapsAndFlagsAtlas() {
    }

    public record CompassInstrumentLayer(
            int layerIndex,
            String arabicName,
            String englishTitle,
            String inventorAndTreatise,
            String mathematicalFormulaAndGeometry,
            String navigationalAndSacredFunction,
            String hexAccent
    ) {
    }

    public record SiderealCompassRhumb(
            int rhumbIndex,
            double azimuthDeg,
            String cardinalCode,
            String arabicRhumbName,
            String starSystemEnglish,
            String kamalAltitudeIsba,
            String targetCaliphateOrPortAxis,
            String hexAccent
    ) {
    }

    public record CaliphateAgeFlagAndMapDossier(
            int ageIndex,
            String eraCode,
            String caliphateOrEmpireTitle,
            String arabicTitle,
            String chronologicalSpan,
            String flagNameArabicAndEnglish,
            String flagVexillologyAndCalligraphy,
            String svgFlagArchetype,
            String primaryHex,
            String secondaryHex,
            String accentHex,
            String capitalsAndKeyPorts,
            String peakAreaKm2,
            String mapPolygonCoordinatesSvg,
            String historicalAndQuranicAnchor
    ) {
    }

    public record CountryCompassMapAndFlagEntry(
            int countryIndex,
            String isoCode,
            String flagEmoji,
            String countryName,
            String arabicOrNativeName,
            String civilizationalZone,
            String capitalCity,
            double capitalLatDeg,
            double capitalLonDeg,
            double qiblahBearingDeg,
            int distanceToKaabahKm,
            String arabicStarRhumbToMecca,
            String currentFlagSymbolism,
            String flagsAcrossAgesAndCaliphates,
            String primaryFlagHex,
            String secondaryFlagHex,
            String accentFlagHex
    ) {
    }

    public static List<CompassInstrumentLayer> allSixCompassLayers() {
        return List.of(
                new CompassInstrumentLayer(
                        1,
                        "Al-Markaz Al-Qiblī — Ka'bat Allāh Al-Musharrafah (المركز القبلي — الكعبة المشرفة)",
                        "1. Central Qiblah Pivot & Spherical Trigonometry Bearing Engine (21.4225° N, 39.8262° E)",
                        "Al-Bīrūnī (Taḥdīd Nihāyāt Al-Amākin, 1025 CE), Ibn Yūnus & Shams al-Dīn Al-Khalīlī (Damascus Qiblah Tables, 1365 CE)",
                        "tan(θ_Q) = sin(λ_K - λ) / [cos(φ)·tan(φ_K) - sin(φ)·cos(λ_K - λ)], where (φ_K, λ_K) = (21°25'21\" N, 39°49'34\" E). Al-Khalīlī computed 2,880 spherical trigonometry entries accurate to 1–2 arcminutes!",
                        "Anchors every mosque Mihrab, sea voyage, caravan route, and sovereign capital across the earth to the Sacred Sanctuary in Mecca (Qur'an 2:144: 'Turn your face toward Al-Masjid Al-Ḥarām').",
                        "#D4AF37"
                ),
                new CompassInstrumentLayer(
                        2,
                        "Al-Ibrah Al-Maghnāṭīsiyyah wa Al-Samakah (الإبرة المغناطيسية والسمكة — Ṭāsat Al-Qiblah)",
                        "2. Magnetized Blued-Steel Fish Needle & Gimbaled Brass Bowl (Al-Ḥuqqah)",
                        "Rasulid Sultan Al-Ashraf 'Umar II of Yemen (1293 CE), Baylak Al-Qibjāqī (1282 CE) & Aḥmad ibn Mājid (1490 CE)",
                        "Lodestone-rubbed (Ḥajar Al-Maghnāṭīs) hollow iron fish (Samakah) or dry-pivot needle balanced on a hardened bronze pin inside a gimbaled brass box (Bayt Al-Ibrah) correcting for ship roll and magnetic declination.",
                        "Provides instantaneous True/Magnetic North alignment at night, in fog, and during heavy Indian Ocean monsoon cloud cover.",
                        "#38BDF8"
                ),
                new CompassInstrumentLayer(
                        3,
                        "Dā'irat Al-Akhnān — 32-Point Sidereal Star-Compass Rose (دائرة الأخنان الفلكية)",
                        "3. The 32-Rhumb Arabic Celestial Horizon Rose (16 Maṭla' Rising + 16 Maghīb Setting Stars)",
                        "Shihāb al-Dīn Aḥmad ibn Mājid (Kitāb Al-Fawā'id, 1490 CE, Oman) & Sulaymān Al-Mahrī (Al-'Umdah Al-Mahrīyah, 1511 CE, Yemen)",
                        "Divides the 360° horizon into 32 rhumbs (Akhnān) of 11.25° each: North is Al-Jāh (Polaris, 0°), South is Al-Quṭb Al-Suhaylī (Canopus/South Pole, 180°), East is Maṭla' Al-Ṭā'ir (Altair, 90°), West is Maghīb Al-Ṭā'ir (270°).",
                        "Allows open-ocean dead reckoning (Al-Dīrah) and star-azimuth steering from Tangier and Istanbul to Aden, Muscat, Zanzibar, Calicut, and Aceh.",
                        "#10B981"
                ),
                new CompassInstrumentLayer(
                        4,
                        "Ḥalqat Al-Kamāl wa Al-Aṣābi' (حلقة الكمال والأصابع والزام)",
                        "4. Concentric Kamāl Star-Altitude Ring (Measured in Aṣābi' Finger-Widths & Zām Watches)",
                        "Omani, Yemeni & Gujarati Master Navigators (Mu'allimūn Al-Baḥr, 9th–16th c. CE)",
                        "1 Iṣba' (Finger-Width of Polaris above the sea horizon) = 1° 36' 25\" of latitude ≈ 97 nautical miles (8 Zām = 1 Iṣba'; 1 Zām = 3 hours of sailing ≈ 12 nautical miles).",
                        "Converts polar star elevation directly into coastal port latitude along the Red Sea, Persian Gulf, Swahili Coast, and Malabar/Nusantara Rim.",
                        "#F59E0B"
                ),
                new CompassInstrumentLayer(
                        5,
                        "Ṣundūq Al-Qiblah wa Dā'irat Al-Buldān (صندوق القبلة ودائرة البلدان)",
                        "5. Engraved Gazetteer Ring of Caliphate Capitals & 57 Sovereign Islamic Polities",
                        "Ottoman Muwaqqits (Mustafa ibn 'Alī, 1536 CE) & Isfahan Brass Instrument Makers (16th–17th c. CE)",
                        "Concentric brass rings engraved with the names, latitudes (العرض), longitudes (الطول), and exact Qiblah azimuth angles (انحراف القبلة) of 40 to 120 Islamic cities across the 7 Climes.",
                        "Permits any traveler, scholar, or admiral to dial their current capital or port and immediately read both the Qiblah direction and distance to Mecca.",
                        "#A855F7"
                ),
                new CompassInstrumentLayer(
                        6,
                        "Al-'Iḍādah wa Miqyās Al-Ẓill (العضادة ومقياس الظل للمواقيت)",
                        "6. Rotating Brass Sighting Alidade, Equatorial Sundial Gnomon & Prayer-Time Shadow Scale",
                        "Al-Fazārī, Al-Ṣūfī, Maryam Al-Asṭurlābiyyah & Ibn Al-Shāṭir (Damascus, 1371 CE)",
                        "Pivoting diametral sighting rule (Al-'Iḍādah -> 'Alidade') with hinged pinnule sights and cotangent shadow scales (Ẓill Mabsūṭ in 12 digits / Aṣābi' and Ẓill Mankūs in 7 feet / Aqdām).",
                        "Determines solar noon (Zawāl), Dhuhr and 'Asr prayer windows, and celestial altitude on land or aboard ship.",
                        "#F43F5E"
                )
        );
    }

    public static List<SiderealCompassRhumb> sixteenPrincipalStarRhumbs() {
        return List.of(
                new SiderealCompassRhumb(1, 0.0, "N", "Al-Jāh (القطب الشمالي / الجاه)", "Polaris (Alpha Ursae Minoris)", "11.0 Iṣba' at Muscat", "Constantinople, Bukhara, Kazan & Damascus Axis", "#FDE68A"),
                new SiderealCompassRhumb(2, 22.5, "NNE", "Maṭla' Al-Na'sh (مطلع النعش)", "Rising of the Plough / Ursa Major", "10.5 Iṣba' at Hormuz", "Baghdad, Tabriz, Samarkand & Tashkent Axis", "#38BDF8"),
                new SiderealCompassRhumb(3, 45.0, "NE", "Maṭla' Al-'Ayyūq (مطلع العيوق)", "Rising of Capella (Alpha Aurigae)", "10.25 Iṣba' at Sur/Qalhāt", "Isfahan, Nishapur, Herat, Kabul & Kashgar Axis", "#10B981"),
                new SiderealCompassRhumb(4, 67.5, "ENE", "Maṭla' Al-Thurayyā (مطلع الثريا)", "Rising of the Pleiades (Seven Sisters)", "9.5 Iṣba' at Daybul/Sindh", "Lahore, Delhi, Multan, Dhaka & Canton Axis", "#F59E0B"),
                new SiderealCompassRhumb(5, 90.0, "E", "Maṭla' Al-Ṭā'ir (مطلع النسر الطائر)", "Rising of Altair (Alpha Aquilae — Due East)", "4.5 Iṣba' at Calicut", "Sohar, Muscat, Calicut (Malabar), Malacca & Brunei Axis", "#D4AF37"),
                new SiderealCompassRhumb(6, 112.5, "ESE", "Maṭla' Al-Tīr / Al-Shi'rā (مطلع التير / الشعرى)", "Rising of Sirius (Alpha Canis Majoris)", "2.0 Iṣba' at Aceh", "Maldives, Aceh (Sumatra), Demak (Java) & Makassar Axis", "#A855F7"),
                new SiderealCompassRhumb(7, 135.0, "SE", "Maṭla' Al-'Aqrab (مطلع العقرب)", "Rising of Scorpio / Antares (Al-Iklīl)", "7.75 Iṣba' at Dhofar", "Dhofar (Salalah), Socotra & Indian Ocean Gyre", "#F43F5E"),
                new SiderealCompassRhumb(8, 157.5, "SSE", "Maṭla' Al-Suhayl (مطلع سهيل)", "Rising of Canopus (Alpha Carinae)", "5.0 Iṣba' at Aden", "Aden, Al-Shiḥr, Mukallā & Bab al-Mandab Axis", "#EC4899"),
                new SiderealCompassRhumb(9, 180.0, "S", "Al-Quṭb Al-Suhaylī (القطب السهيلي / الجنوب)", "South Celestial Pole & Southern Cross", "1.0 Iṣba' at Zanzibar", "Mogadishu, Mombasa, Zanzibar, Kilwa & Comoros Axis", "#10B981"),
                new SiderealCompassRhumb(10, 202.5, "SSW", "Maghīb Al-Suhayl (مغيب سهيل)", "Setting of Canopus", "5.5 Iṣba' at Mocha", "Al-Mukhā (Mocha), Zeila, Djibouti, Harar & Asmara Axis", "#38BDF8"),
                new SiderealCompassRhumb(11, 225.0, "SW", "Maghīb Al-'Aqrab (مغيب العقرب)", "Setting of Scorpio / Antares", "6.0 Iṣba' at Massawa", "Sennar, Khartoum, N'Djamena & Lake Chad Axis", "#F59E0B"),
                new SiderealCompassRhumb(12, 247.5, "WSW", "Maghīb Al-Tīr (مغيب التير)", "Setting of Sirius", "7.0 Iṣba' at Suakin", "Sokoto, Kano, Agadez, Gao, Timbuktu & Dakar Axis", "#D4AF37"),
                new SiderealCompassRhumb(13, 270.0, "W", "Maghīb Al-Ṭā'ir (مغيب النسر الطائر)", "Setting of Altair (Due West)", "8.5 Iṣba' at Jeddah", "Jeddah, Aidhab, Bilād Al-Sūdān & Atlantic Mauritania Axis", "#A855F7"),
                new SiderealCompassRhumb(14, 292.5, "WNW", "Maghīb Al-Thurayyā (مغيب الثريا)", "Setting of the Pleiades", "11.5 Iṣba' at Fustat", "Cairo, Alexandria, Tripoli, Kairouan, Tunis, Algiers, Fez & Marrakesh Axis", "#F43F5E"),
                new SiderealCompassRhumb(15, 315.0, "NW", "Maghīb Al-'Ayyūq (مغيب العيوق)", "Setting of Capella", "12.5 Iṣba' at Córdoba", "Córdoba, Seville, Granada, Toledo, Sarajevo & Tirana Axis", "#34D399"),
                new SiderealCompassRhumb(16, 337.5, "NNW", "Maghīb Al-Na'sh (مغيب النعش)", "Setting of Ursa Major", "12.0 Iṣba' at Jerusalem", "Medina, Jerusalem (Al-Quds), Damascus, Aleppo & Edirne Axis", "#60A5FA")
        );
    }

    public static List<CaliphateAgeFlagAndMapDossier> allFourteenCaliphateAgesMapsAndFlags() {
        return List.of(
                new CaliphateAgeFlagAndMapDossier(
                        1,
                        "AGE-I • 622–632 CE (1–11 AH)",
                        "1. The Prophetic Commonwealth of Medina & Opening of Mecca",
                        "Al-Dawlah Al-Nabawiyyah fī Al-Madīnah Al-Munawwarah (الدولة النبوية في المدينة المنورة)",
                        "622–632 CE (1–11 AH)",
                        "Rāyat Al-'Uqāb (راية العقاب السوداء — The Black Eagle Standard) & Al-Liwā' Al-Abyaḍ (اللواء الأبيض — The White Banner)",
                        "Authenticated in Sunan Abī Dāwūd 2591, Sunan Al-Tirmidhī 1681, and Musnad Aḥmad: The Prophet's military battle-standard (Al-Rāyah) was named Al-'Uqāb ('The Eagle'), woven of black wool (Namirah), while his sovereign state banner (Al-Liwā') was pure white cloth, inscribed with 'Lā ilāha illā Allāh Muḥammadun Rasūlullāh'.",
                        "PROPHETIC_UQAB",
                        "#111827",
                        "#F8FAFC",
                        "#D4AF37",
                        "Al-Madīnah Al-Munawwarah, Makkah Al-Mukarramah, Ṭā'if, Yanbu', Tabūk, Sana'a (Yemen), Sohar (Oman) & Bahrain",
                        "3,000,000 km² (Entire Arabian Peninsula, Yemen & Oman)",
                        "430,210 475,205 510,235 520,275 480,305 445,295 425,245",
                        "Qur'an 48:1–3, 110:1–3 • Sunan Abī Dāwūd 2591 & Tirmidhī 1681 ('The Rayah of the Messenger of Allah ﷺ was black, and his Liwa was white')"
                ),
                new CaliphateAgeFlagAndMapDossier(
                        2,
                        "AGE-II • 632–661 CE (11–40 AH)",
                        "2. The Rightly Guided Caliphate (Al-Khilāfah Al-Rāshidah)",
                        "Al-Khilāfah Al-Rāshidah — Abū Bakr, 'Umar, 'Uthmān, 'Alī & Al-Ḥasan (الخلافة الراشدة)",
                        "632–661 CE (11–40 AH)",
                        "Rāyat Al-'Uqāb & The Tri-Standard of Medina, Kūfah & Damascus (راية العقاب والألوية الراشدة)",
                        "Retained the Prophetic Black Rāyah (Al-'Uqāb) and White Liwā', alongside crimson/emerald-bordered companion standards carried at Yarmūk (636 CE), Al-Qādisiyyah (636 CE), Jerusalem (637 CE), Alexandria (641 CE), and Cyprus (649 CE).",
                        "RASHIDUN_STANDARD",
                        "#065F46",
                        "#111827",
                        "#D4AF37",
                        "Medina (632–656 CE), Kūfah (656–661 CE), Mecca, Jerusalem, Damascus, Fustat (Cairo), Basrah, Aden, Sohar, Nishapur",
                        "6,400,000 km² (From Tripoli in Libya to Khorasan/Oxus, and from Caucasus to Yemen & Oman)",
                        "330,195 405,165 535,165 565,215 520,295 445,298 395,235 330,215",
                        "Qur'an 24:55 (Āyat Al-Istikhlāf) • Covenant of 'Umar in Jerusalem (15 AH / 637 CE)"
                ),
                new CaliphateAgeFlagAndMapDossier(
                        3,
                        "AGE-III • 661–750 CE & 756–1031 CE",
                        "3. The Umayyad Caliphate of Damascus & Caliphate of Córdoba",
                        "Al-Khilāfah Al-Umawiyyah fī Dimashq wa Qurṭubah (الخلافة الأموية في دمشق وقرطبة)",
                        "661–750 CE (Damascus) & 756–1031 CE (Córdoba, Al-Andalus)",
                        "Al-Rāyah Al-Bayḍā' Al-Umawiyyah (الراية البيضاء الأموية — The Pure White Banner of Badr)",
                        "Adopted Pure White (Al-Bayāḍ) in honor of the Prophet's White Liwā' at the Battle of Badr, embroidered in gold Kufic script with the Shahādah and Surah Al-Ṣaff (61:13: 'Naṣrun min Allāhi wa fatḥun qarīb'). Represented the first of the 4 canonical Pan-Arab colors ('White are our deeds').",
                        "UMAYYAD_WHITE",
                        "#F8FAFC",
                        "#D4AF37",
                        "#0F172A",
                        "Damascus, Córdoba, Seville, Kairouan, Fustat, Jerusalem, Mecca, Medina, Basrah, Sohar, Aden, Samarkand, Multan (Sindh)",
                        "11,100,000 km² (Largest contiguous territory in classical history: Atlantic Lisbon & Narbonne to the Indus & Fergana Valley)",
                        "180,155 245,140 330,190 420,160 585,155 615,225 520,295 445,295 380,235 205,215",
                        "Caliph 'Abd al-Malik's 77 AH Epigraphic Gold Dīnār • Great Mosque of Damascus (715 CE) & Mezquita of Córdoba (784 CE)"
                ),
                new CaliphateAgeFlagAndMapDossier(
                        4,
                        "AGE-IV • 750–1258 CE & 1261–1517 CE",
                        "4. The Abbasid Caliphate of Baghdad, Samarra & Cairo",
                        "Al-Khilāfah Al-'Abbāsiyyah — Dār Al-Salām Baghdād (الخلافة العباسية)",
                        "750–1258 CE (Baghdad/Samarra) & 1261–1517 CE (Cairo)",
                        "Al-Rāyah Al-Sawdā' Al-'Abbāsiyyah / Al-Ẓill (الراية السوداء العباسية — Black Silk Banner with Gold Kufic)",
                        "Adopted deep Obsidian Black (Al-Sawād) directly reviving the Prophet's Black Eagle standard (Al-'Uqāb) and mourning the martyrs of Banū Hāshim, with golden Abbasid Kufic Tirāz embroidery reading 'Muḥammadun Rasūlullāh' and 'Al-Khilāfah Al-'Abbāsiyyah'. Origin of the black stripe in modern Arab flags.",
                        "ABBASID_BLACK",
                        "#090D16",
                        "#D4AF37",
                        "#F8FAFC",
                        "Baghdad (Madīnat Al-Salām), Samarra, Kūfah, Raqqah, Basrah, Sohar, Aden, Mecca, Medina, Cairo, Nishapur, Merv, Bukhara",
                        "10,000,000 km² (From Ifriqiyah/Tunisia across Egypt, Levant, Arabia, Iraq, Persia, and Transoxiana to Sindh)",
                        "265,190 415,160 580,155 605,220 520,295 445,295 390,235 265,215",
                        "Bayt Al-Ḥikmah (830 CE) • Al-Ma'mūn's World Map • Belitung Sewn Dhow to Tang China"
                ),
                new CaliphateAgeFlagAndMapDossier(
                        5,
                        "AGE-V • 789–1171 CE (172–567 AH)",
                        "5. The Idrisid Kingdom of Fez & Fatimid Caliphate of Cairo",
                        "Al-Dawlah Al-Idrīsiyyah wa Al-Khilāfah Al-Fāṭimiyyah (الخلافة الفاطمية والأدارسة)",
                        "789–974 CE (Idrisids of Fez) & 909–1171 CE (Fatimids of Mahdia & Cairo)",
                        "Al-Liwā' Al-Akhḍar Al-Fāṭimī (اللواء الأخضر — The Emerald Green Standard of Ahl al-Bayt)",
                        "Woven in luminous Emerald Green (Al-Khuḍrah — symbol of the Prophet's green cloak/Burdah and the gardens of Paradise in Qur'an 18:31 & 76:21), bordered with golden Fatimid Floriated Kufic Tirāz bands. Origin of the green color in Pan-Arab and Islamic vexillology.",
                        "FATIMID_GREEN",
                        "#047857",
                        "#D4AF37",
                        "#ECFDF5",
                        "Al-Qāhirah (Cairo, founded 969 CE), Al-Mahdiyyah, Kairouan, Fez, Palermo (Sicily), Jerusalem, Jeddah, Mecca, Jiblah/Aden (Sulayhid Yemen)",
                        "4,100,000 km² (Morocco & Tunisia across Sicily, Egypt, Levant, Hijaz, and Sulayhid Yemen)",
                        "195,190 295,170 355,190 435,185 455,285 385,245 200,220",
                        "Founding of Al-Qarawiyyīn (Fez, 859 CE) & Al-Azhar University (Cairo, 970 CE) • Ibn Al-Haytham's Kitāb Al-Manāẓir (1021 CE)"
                ),
                new CaliphateAgeFlagAndMapDossier(
                        6,
                        "AGE-VI • 1037–1308 CE (429–707 AH)",
                        "6. The Great Seljuk Empire & Seljuk Sultanate of Rūm",
                        "Al-Dawlah Al-Saljūqiyyah Al-Kubrā wa Salājiqat Al-Rūm (الدولة السلجوقية العظمى)",
                        "1037–1194 CE (Great Seljuk) & 1077–1308 CE (Sultanate of Rūm in Anatolia)",
                        "Rāyat Al-Bāz Al-Saljūqī (راية النسر السلجوقي المزدوج والقوس — Turquoise Double-Headed Eagle & Bow Tamgha)",
                        "A celestial Turquoise-Azure banner (Fayrūzī) bearing the crowned Double-Headed Falcon/Eagle looking East and West flanked by the Oghuz Kinik tribal Bow-and-Arrow Tamgha, signifying dual guardianship over the Eastern and Western horizons under the Abbasid Caliph's spiritual investiture.",
                        "SELJUK_EAGLE",
                        "#0284C7",
                        "#FDE68A",
                        "#0F172A",
                        "Nishapur, Rayy, Isfahan, Merv, Baghdad, Konya (Iconium), Sivas, Antalya, Sinop, Damascus, Jerusalem",
                        "3,900,000 km² (From Aegean Anatolia and Syria across Iraq, Iran, Khwarazm, and Transoxiana to the Hindu Kush)",
                        "365,145 435,140 570,150 565,215 445,215 365,175",
                        "Niẓāmiyyah Madrasahs of Niẓām al-Mulk & Imam Al-Ghazālī • 'Umar Khayyām's Jalālī Solar Calendar (1079 CE)"
                ),
                new CaliphateAgeFlagAndMapDossier(
                        7,
                        "AGE-VII • 1040–1492 CE (431–897 AH)",
                        "7. The Almoravid, Almohad, Marinid & Nasrid Granada Caliphates/Sultanates",
                        "Al-Murābiṭūn, Al-Muwaḥḥidūn, Banū Marīn wa Banū Al-Aḥmar fī Gharnāṭah (المرابطون والموحدون وغرناطة)",
                        "1040–1147 (Almoravids), 1121–1269 (Almohads), 1244–1465 (Marinids), 1230–1492 (Nasrid Granada)",
                        "Al-'Alam Al-Manṣūrī (العلم المنصوري الموحدي والمريني) & Rāyat 'Wa Lā Ghāliba Illā Allāh'",
                        "A rich Crimson Silk Banner featuring a central woven Gold-and-Black 8-fold geometric chessboard medallion surrounded by the 8-pointed Rub' Al-Ḥizb star and golden Kufic Qur'anic borders (preserved today in the Monastery of Las Huelgas, 1212 CE), paired with the Nasrid Alhambra motto: 'Wa Lā Ghāliba Illā Allāh' ('There is no victor except Allah').",
                        "ALMOHAD_MARINID_GRANADA",
                        "#991B1B",
                        "#D4AF37",
                        "#111827",
                        "Marrakesh, Fez, Rabat, Seville, Córdoba, Granada (Alhambra), Tlemcen, Tunis, Ceuta, Sijilmasa & Timbuktu Corridor",
                        "2,300,000 km² (Southern Iberia/Al-Andalus, Morocco, Algeria, Tunisia, Mauritania & Saharan Gold Routes)",
                        "175,155 235,150 295,180 285,235 170,255",
                        "Ibn Rushd (Averroes), Ibn Ṭufayl, Al-Idrīsī & Ibn Khaldūn • Koutoubia (Marrakesh), Giralda (Seville) & The Alhambra"
                ),
                new CaliphateAgeFlagAndMapDossier(
                        8,
                        "AGE-VIII • 1171–1260 CE (567–658 AH)",
                        "8. The Ayyubid Sultanate of Ṣalāḥ al-Dīn (Saladin)",
                        "Al-Dawlah Al-Ayyūbiyyah — Ṣalāḥ al-Dīn Yūsuf ibn Ayyūb (الدولة الأيوبية)",
                        "1171–1260 CE (567–658 AH)",
                        "Al-Rāyah Al-Ṣafrā' wa Al-'Uqāb Al-Ṣalāḥī (الراية الصفراء وعقاب صلاح الدين — Saffron-Gold Banner & Eagle)",
                        "Saffron-Gold (Al-Ṣafār) royal silk flag emblazoned with the Crimson-and-Black Eagle of Saladin (Al-Nisr Al-Ṣalāḥī, carved on the western wall of the Cairo Citadel in 1176 CE), which today serves as the sovereign coat of arms of Egypt, Iraq, Palestine, and Yemen.",
                        "AYYUBID_EAGLE",
                        "#EAB308",
                        "#991B1B",
                        "#111827",
                        "Cairo (Citadel of the Mountain), Damascus, Jerusalem (Al-Quds, liberated 1187 CE), Aleppo, Diyarbakir, Mecca, Medina, Zabīd & Aden",
                        "2,700,000 km² (Egypt, Nubia, Palestine, Syria, Upper Mesopotamia, Hijaz & Yemen)",
                        "345,190 425,170 455,210 465,285 385,260",
                        "Liberation of Jerusalem (1187 CE) with complete chivalric amnesty • Ibn Al-Nafīs's Discovery of Pulmonary Circulation (1242 CE)"
                ),
                new CaliphateAgeFlagAndMapDossier(
                        9,
                        "AGE-IX • 1250–1517 CE (648–923 AH)",
                        "9. The Mamluk Sultanate of Cairo, Levant & Hijaz",
                        "Al-Salṭanah Al-Mamlūkiyyah fī Al-Qāhirah wa Al-Shām (السلطنة المملوكية)",
                        "1250–1517 CE (648–923 AH)",
                        "Al-'Iṣābah Al-Sulṭāniyyah Al-Mamlūkiyyah (العصابة السلطانية الصفراء — Swallow-Tailed Yellow Silk Banner with Heraldic Rank)",
                        "Illustrated on the 1339 Dulcert and 1375 Catalan Portolan Atlases: a golden-yellow swallow-tailed silk standard bearing the Sultan's circular heraldic blazon (Rank — chalice, pen-box, or lion of Baybars) and Thuluth calligraphy ('Al-Sulṭān Al-Malik Al-Nāṣir').",
                        "MAMLUK_SULTANI",
                        "#F59E0B",
                        "#78350F",
                        "#F8FAFC",
                        "Cairo, Alexandria, Damietta, Jerusalem, Damascus, Aleppo, Tripoli, Mecca, Medina, Jeddah & Suakin",
                        "2,100,000 km² (Egypt, Levant, Southeastern Anatolia, Hijaz & Red Sea Coast)",
                        "355,195 425,170 445,215 450,275 385,255",
                        "Victory at 'Ayn Jālūt (1260 CE) saving Islamic & Mediterranean civilization • Re-enthronement of the Abbasid Caliphate in Cairo (1261 CE)"
                ),
                new CaliphateAgeFlagAndMapDossier(
                        10,
                        "AGE-X • 1229–1517 CE & 1597–1962 CE",
                        "10. The Yemeni Rasulid Maritime Sultanate & Qasimid/Mutawakkilite Imamate",
                        "Al-Dawlah Al-Rasūliyyah wa Al-Imāmah Al-Qāsimiyyah fī Al-Yaman (الدولة الرسولية والإمامة اليمنية)",
                        "1229–1454 CE (Rasulid), 1454–1517 CE (Tahirid) & 1597–1962 CE (Qasimid Imamate)",
                        "Rāyat Al-Wardah Al-Rasūliyyah (راية الوردة الرسولية الخماسية) & Rāyat Sayf Dhū Al-Faqār wa Al-Kawākib Al-Khamsah",
                        "1) The Rasulid Flag: a Crimson field charged with a five-petaled White-and-Gold Rose (Al-Wardah Al-Rasūliyyah, stamped on Rasulid palace glass, brass astrolabes, and Aden customs seals); 2) The Yemeni Imamate Flag: a Crimson field bearing the white sword of Justice flanked by 5 five-pointed stars representing the 5 geographic provinces of Yemen and the 5 Pillars of Islam.",
                        "YEMEN_RASULID_ROSE",
                        "#B91C1C",
                        "#F8FAFC",
                        "#D4AF37",
                        "Ta'izz, Zabīd, Sana'a, Aden (Thaghr 'Adan), Al-Mukhā (Mocha), Al-Shiḥr, Mukallā, Tarīm & Socotra",
                        "750,000 km² + Red Sea & Indian Ocean Hadhrami Maritime Network",
                        "440,265 490,260 495,295 445,300",
                        "Sultan Al-Ashraf 'Umar II's 1293 CE Magnetic Compass Treatise • 1411 CE Aden Customs Ledger (Mulakhkhaṣ Al-Fiṭan)"
                ),
                new CaliphateAgeFlagAndMapDossier(
                        11,
                        "AGE-XI • 750–Present (Ya'rubid 1624–1744 & Al Bu Sa'id 1744–Present)",
                        "11. The Omani Ibāḍī Imamates, Ya'rubid Naval Empire & Al Bu Sa'id Sultanate of Muscat & Zanzibar",
                        "Imāmat 'Umān, Dawlat Al-Ya'āribah wa Salṭanat Masqaṭ wa Zinjibār (إمامة وسلطنة عُمان وزنجبار)",
                        "750–1624 (Early Imamates/Nabhani), 1624–1744 (Ya'rubid), 1744–Present (Al Bu Sa'id)",
                        "Al-Rāyah Al-'Umāniyyah Al-Ḥamrā' wa Al-Khanjar Al-Sa'īdī (الراية العمانية الحمراء وشعار الخنجر والسيفين)",
                        "Deep Sovereign Crimson Banner (Al-Rāyah Al-Ḥamrā' — flown on Omani Baghlahs and frigates from Muscat and Hormuz to Mombasa, Zanzibar, and New York Harbor in 1840), combined with the White Imamate field, Green fertility band of Jabal Akhdar, and the golden national emblem of two crossed curved swords (Sayfān) beneath the ceremonial Omani dagger (Al-Khanjar) and belt.",
                        "OMAN_KHANJAR_EMPIRE",
                        "#DC2626",
                        "#F8FAFC",
                        "#15803D",
                        "Muscat, Sohar, Sur, Nizwa, Rustaq, Qalhāt, Hormuz, Gwadar (Balochistan), Mogadishu, Mombasa (Fort Jesus), Zanzibar & Kilwa",
                        "1,200,000 km² (Oman, Makran Coast & East African Swahili Rim from Mogadishu to Cape Delgado)",
                        "490,235 535,235 535,275 470,335 445,395 430,340 485,265",
                        "Aḥmad ibn Mājid's 32-Point Star Compass (1490 CE) • Ya'rubid Liberation of Muscat (1650) & Mombasa (1698) • 1840 Voyage of Al-Sulṭānah to NYC"
                ),
                new CaliphateAgeFlagAndMapDossier(
                        12,
                        "AGE-XII • 1299–1924 CE (699–1342 AH)",
                        "12. The Ottoman Sultanate & Caliphate (Al-Dawlah Al-'Uthmāniyyah)",
                        "Al-Khilāfah Al-'Uthmāniyyah — Devlet-i Aliyye-i Osmâniyye (الخلافة العثمانية)",
                        "1299–1924 CE (Caliphate seat 1517–1924 CE)",
                        "Al-Sanjāq Al-Sharīf, Rāyat Dhū Al-Faqār wa Al-Ahillah Al-Thalāthah & Ay-Yıldız (السنجق الشريف والأهلة الثلاثة)",
                        "1) Classical Imperial & Naval Standard (15th–18th c., flown by Hayreddin Barbarossa & Piri Reis): Crimson silk field featuring an Emerald-Green oval charged with Three Golden Crescents (symbolizing Ottoman sovereignty over 3 continents: Europe, Asia, and Africa) and the twin-bladed sword Zülfikar; 2) The 1844 Tanzimat Imperial Flag (Ay-Yıldız): Crimson field with the White Crescent and 8-pointed/5-pointed Star.",
                        "OTTOMAN_CALIPHATE",
                        "#B91C1C",
                        "#047857",
                        "#FDE68A",
                        "Istanbul (Qusṭanṭīniyyah, opened 1453 CE), Bursa, Edirne, Sarajevo, Budapest, Cairo, Jerusalem, Damascus, Baghdad, Mecca, Medina, Aden, Algiers, Tunis, Tripoli",
                        "5,200,000 km² (Southeast Europe/Balkans, Crimea, Anatolia, Levant, Mesopotamia, Hijaz, Yemen, Egypt & North Africa)",
                        "235,175 315,130 415,135 465,175 465,280 375,245 235,205",
                        "Piri Reis's 1513 World Map & Kitāb-ı Baḥriye • Sinan's Süleymaniye & Selimiye Mosques • 407-Year Custodianship of the Two Holy Mosques"
                ),
                new CaliphateAgeFlagAndMapDossier(
                        13,
                        "AGE-XIII • 1370–1736 CE (771–1148 AH)",
                        "13. The Timurid Renaissance Empire & Safavid Persianate Shahdom",
                        "Al-Dawlah Al-Tīmūriyyah fī Samarqand wa Al-Dawlah Al-Ṣafawiyyah fī Iṣfahān (الدولة التيمورية والصفوية)",
                        "1370–1507 CE (Timurid Samarkand & Herat) & 1501–1736 CE (Safavid Tabriz & Isfahan)",
                        "Rāyat Al-Ḥalaqāt Al-Thalāth (راية تيمور الثلاثية) & 'Alam Shīr-o-Khorshīd (علم الأسد والشمس الأخضر)",
                        "1) Timurid Standard (recorded on the 1375 Catalan Atlas): Three golden rings/orbs arranged in an equilateral triangle (symbolizing the 3 climes) on a deep lapis/black field; 2) Safavid Standard: Emerald-green silk banner bearing the Golden Radiant Sun rising behind a couchant Lion (Shīr-o-Khorshīd, astronomical symbol of the Sun in the zodiacal house of Leo).",
                        "TIMURID_SAFAVID",
                        "#065F46",
                        "#D4AF37",
                        "#1E3A8A",
                        "Samarkand, Bukhara, Herat, Balkh, Tabriz, Qazvin, Isfahan (Naqsh-e Jahan), Shiraz & Mashhad",
                        "4,400,000 km² (Timurid) / 2,900,000 km² (Safavid Iran, Caucasus & Khorasan)",
                        "435,150 565,140 580,215 455,215",
                        "Ulugh Beg's Samarkand Observatory (1420 CE, measuring the sidereal year to within 58 seconds!) • Mullā Ṣadrā's Substantial Motion"
                ),
                new CaliphateAgeFlagAndMapDossier(
                        14,
                        "AGE-XIV • 1206–1903+ CE (Delhi, Mughal Empire & Maritime Nusantara Sultanates)",
                        "14. The Delhi & Mughal Empires of South Asia & The Sultanates of Aceh, Malacca & Nusantara",
                        "Salṭanat Al-Hind Al-Mughūliyyah wa Salṭanāt Ātshīh wa Malāqā (سلطنة المغول في الهند وسلطنات أتشيه ونوسانتارا)",
                        "1206–1526 (Delhi), 1526–1857 (Mughal Empire), 1267–1903 (Samudera Pasai, Malacca, Aceh, Demak, Mataram)",
                        "Al-'Alam Al-Mughūlī Al-Akhḍar (العلم المغولي الأخضر) & 'Alam Peudeuëng Al-Ātshīhī (علم سيف أتشيه والهلال)",
                        "1) Mughal Imperial 'Alam: Triangular Moss-Green silk banner bordered in gold brocade bearing the Golden Radiant Sun and Lion; 2) Sultanate of Aceh ('Serambi Mekkah' / Veranda of Mecca): Crimson flag charged with a White Crescent, 5-pointed Star, and a horizontal unsheathed White Sword (Alam Peudeuëng, directly inspired by Aceh's 1560s naval alliance with Ottoman Sultan Süleyman the Magnificent!).",
                        "MUGHAL_ACEH_NUSANTARA",
                        "#15803D",
                        "#B91C1C",
                        "#FDE68A",
                        "Delhi, Agra, Lahore, Dhaka, Multan, Surat • Banda Aceh, Malacca, Demak, Banten, Makassar, Brunei & Sulu",
                        "4,000,000 km² (Mughal Subcontinent, ~25% of World GDP in 1700 CE) + 3,000,000 km² Maritime Nusantara Archipelago",
                        "555,180 650,185 755,280 795,335 685,335 585,250",
                        "Fatāwā 'Ālamgīriyyah • Taj Mahal & Badshahi Mosque • Peaceful Merchant & Wali Songo Islamization of Indonesia & Malaysia"
                )
        );
    }

    public static List<CountryCompassMapAndFlagEntry> allFiftySevenIslamicCountries() {
        return List.of(
                // ZONE I: ARABIAN CRADLE & GULF SANCTUARY (7 Countries)
                new CountryCompassMapAndFlagEntry(1, "SA", "🇸🇦", "Saudi Arabia", "Al-Mamlakah Al-'Arabiyyah Al-Su'ūdiyyah (المملكة العربية السعودية)", "I. Arabian Peninsula & Gulf", "Riyadh (Mecca & Medina Sanctuary)", 24.7136, 46.6753, 244.6, 790, "Maghīb Al-Tīr (WSW — 247.5°)", "Emerald Green field of Fatimid/Prophetic tradition inscribed in white Thuluth calligraphy with the Shahādah above a horizontal sword pointing toward the hoist (never lowered to half-mast).", "Prophetic Al-'Uqāb & White Liwā' (622) -> Rashidun -> Umayyad White -> Abbasid Black -> Ottoman/Sharifian Crimson -> Green Shahādah Standard", "#006C35", "#FFFFFF", "#D4AF37"),
                new CountryCompassMapAndFlagEntry(2, "YE", "🇾🇪", "Yemen", "Al-Jumhūriyyah Al-Yamaniyyah (الجمهورية اليمنية)", "I. Arabian Peninsula & Gulf", "Sana'a & Aden", 15.3694, 44.1910, 326.5, 815, "Maghīb Al-Na'sh (NNW — 337.5°)", "Horizontal tricolour of Pan-Arab Red (Rasulid/Imamate defense), White (Umayyad/peaceful 630 CE embrace), and Black (Abbasid/Prophetic Al-'Uqāb).", "Prophetic White Liwā' (630) -> Umayyad/Abbasid -> Sulayhid Green -> Rasulid Crimson 5-Petaled Rose (1229) -> Qasimid/Mutawakkilite Red Sword & 5 Stars -> Yemeni Tricolour", "#CE1126", "#FFFFFF", "#000000"),
                new CountryCompassMapAndFlagEntry(3, "OM", "🇴🇲", "Oman", "Salṭanat 'Umān (سلطنة عُمان)", "I. Arabian Peninsula & Gulf", "Muscat", 23.5880, 58.3829, 266.2, 1905, "Maghīb Al-Ṭā'ir (Due West — 270.0°)", "Vertical Sovereign Red hoist stripe bearing the national emblem (crossed curved swords + Khanjar dagger in belt) with horizontal White (Imamate peace), Red (maritime defense), and Green (Jabal Akhdar fertility) bands.", "Prophetic Letter to Al-Julandā (630) -> Ibāḍī White/Red Imamate -> Ya'rubid Crimson Naval Flag (1650) -> Al Bu Sa'id Red Flag of Muscat & Zanzibar -> Modern Tri-Band with Khanjar", "#DB161B", "#FFFFFF", "#008000"),
                new CountryCompassMapAndFlagEntry(4, "AE", "🇦🇪", "United Arab Emirates", "Al-Imārāt Al-'Arabiyyah Al-Muttaḥidah (الإمارات العربية المتحدة)", "I. Arabian Peninsula & Gulf", "Abu Dhabi", 24.4539, 54.3773, 258.0, 1510, "Maghīb Al-Tīr / Al-Ṭā'ir (WSW/W)", "Unites all four Pan-Arab Caliphate colors of Ṣafī al-Dīn al-Ḥillī's verse: Red vertical hoist (coastal maritime heritage) with Green (Fatimid/growth), White (Umayyad/peace), and Black (Abbasid/strength) stripes.", "Early Caliphal Julfar -> Hormuzi/Nabhani -> Qāsimī Red-and-White Pierced Maritime Flag (1820 General Maritime Treaty) -> 1971 Four-Color Union Flag", "#00732F", "#FF0000", "#000000"),
                new CountryCompassMapAndFlagEntry(5, "QA", "🇶🇦", "Qatar", "Dawlat Qaṭar (دولة قطر)", "I. Arabian Peninsula & Gulf", "Doha", 25.2854, 51.5310, 252.3, 1255, "Maghīb Al-Tīr (WSW — 247.5°)", "Unique royal Qatar Maroon (Al-'Annābī — produced from sun-cured purple dye of Khor Al-Adaid shells) separated from a white hoist by a 9-point serrated edge.", "Prophetic/Rashidun Naval Staging -> Umayyad/Abbasid -> Al-Thani Crimson/Purple-Maroon Pierced Maritime Banner (1855/1916)", "#8A1538", "#FFFFFF", "#D4AF37"),
                new CountryCompassMapAndFlagEntry(6, "BH", "🇧🇭", "Bahrain", "Mamlakat Al-Baḥrayn (مملكة البحرين)", "I. Arabian Peninsula & Gulf", "Manama", 26.2285, 50.5860, 246.3, 1210, "Maghīb Al-Tīr (WSW — 247.5°)", "Crimson Red field separated from a White hoist by a 5-point serrated triangle edge explicitly representing the Five Pillars of Islam (Arkān Al-Islām Al-Khamsah).", "Prophetic Letter to Al-Mundhir ibn Sāwā (628 CE) -> Umayyad/Abbasid -> Uyunid/Usfurid/Jabrid -> Al-Khalifa Red-and-White 5-Pillar Serrated Flag", "#CE1126", "#FFFFFF", "#D4AF37"),
                new CountryCompassMapAndFlagEntry(7, "KW", "🇰🇼", "Kuwait", "Dawlat Al-Kuwayt (دولة الكويت)", "I. Arabian Peninsula & Gulf", "Kuwait City", 29.3759, 47.9774, 224.8, 1205, "Maghīb Al-'Aqrab (SW — 225.0°)", "Black trapezoid at the hoist with horizontal Green, White, and Red bands directly embodying Ṣafī al-Dīn al-Ḥillī's four-color Caliphate poem.", "Rashidun Kadhima (636 CE) -> Umayyad/Abbasid -> Al-Sabah Maritime Red Flag (with 'Kuwait' & Shahādah) -> 1961 Four-Color Caliphate Standard", "#007A3D", "#CE1126", "#000000"),

                // ZONE II: FERTILE CRESCENT, LEVANT, IRAQ & NILE (7 Countries)
                new CountryCompassMapAndFlagEntry(8, "EG", "🇪🇬", "Egypt", "Jumhūriyyat Miṣr Al-'Arabiyyah (جمهورية مصر العربية)", "II. Fertile Crescent & Nile", "Cairo (Al-Qāhirah)", 30.0444, 31.2357, 136.2, 1285, "Maṭla' Al-'Aqrab (SE — 135.0°)", "Red, White, and Black horizontal bands charged at the center with the Golden Eagle of Ṣalāḥ al-Dīn (Al-Nisr Al-Ṣalāḥī) holding a scroll inscribed with Egypt's Arabic name.", "Rashidun Fustat (641) -> Umayyad White -> Abbasid Black -> Tulunid/Ikhshidid -> Fatimid Emerald (969) -> Ayyubid Saffron Eagle (1171) -> Mamluk Yellow Sultānī -> Ottoman/Khedivate Green 3-Crescents -> Eagle Tricolour", "#CE1126", "#FFFFFF", "#C09300"),
                new CountryCompassMapAndFlagEntry(9, "IQ", "🇮🇶", "Iraq", "Jumhūriyyat Al-'Irāq (جمهورية العراق)", "II. Fertile Crescent & Nile", "Baghdad", 33.3152, 44.3661, 199.8, 1395, "Maghīb Al-Suhayl (SSW — 202.5°)", "Red, White, and Black horizontal bands inscribed at the center in green Square Kufic calligraphy with the Takbīr: 'Allāhu Akbar' ('Allah is the Greatest').", "Rashidun Capital at Kūfah (656) -> Umayyad -> Abbasid Black Banner of Baghdad (750–1258) -> Ilkhanid/Jalayirid -> Ottoman -> Hashemite 7-Star Flag -> Kufic Takbīr Tricolour", "#CE1126", "#007A3D", "#000000"),
                new CountryCompassMapAndFlagEntry(10, "SY", "🇸🇾", "Syria", "Al-Jumhūriyyah Al-'Arabiyyah Al-Sūriyyah (الجمهورية العربية السورية)", "II. Fertile Crescent & Nile", "Damascus", 33.5138, 36.2765, 164.6, 1385, "Maṭla' Al-Suhayl (SSE — 157.5°)", "Unites the four Caliphate colors (Red, White, Black, and Green stars) honoring Damascus as seat of the Umayyad Caliphate and heart of Bilād Al-Shām.", "Rashidun Opening of Damascus (634) -> Umayyad White Caliphate Banner (661–750) -> Abbasid -> Hamdanid/Zengid -> Ayyubid Eagle -> Mamluk -> Ottoman -> Syrian Four-Color Standard", "#007A3D", "#CE1126", "#000000"),
                new CountryCompassMapAndFlagEntry(11, "PS", "🇵🇸", "Palestine", "Dawlat Filasṭīn — Al-Quds Al-Sharīf (دولة فلسطين — القدس الشريف)", "II. Fertile Crescent & Nile", "Jerusalem (Al-Quds — First Qiblah)", 31.7683, 35.2137, 157.2, 1235, "Maṭla' Al-Suhayl (SSE — 157.5°)", "Crimson triangle at the hoist (Hashemite/Guardianship) over horizontal Black (Abbasid), White (Umayyad), and Green (Fatimid) stripes.", "First Qiblah of Islam -> 'Umar's Jerusalem Covenant (637 CE) -> Umayyad Dome of the Rock & Al-Aqṣā -> Abbasid -> Fatimid -> Ṣalāḥ al-Dīn's Ayyubid Eagle (1187) -> Mamluk -> Ottoman -> Four-Caliphate Standard", "#007A3D", "#CE1126", "#000000"),
                new CountryCompassMapAndFlagEntry(12, "JO", "🇯🇴", "Jordan", "Al-Mamlakah Al-Urdunniyyah Al-Hāshimiyyah (المملكة الأردنية الهاشمية)", "II. Fertile Crescent & Nile", "Amman", 31.9454, 35.9284, 160.6, 1230, "Maṭla' Al-Suhayl (SSE — 157.5°)", "Black (Abbasid), White (Umayyad), and Green (Fatimid) horizontal bands with a Crimson Hashemite chevron charged with a Seven-Pointed White Star representing the 7 verses of Surah Al-Fātiḥah (Al-Sab' Al-Mathānī).", "Prophetic Mu'tah & Yarmūk (636) -> Umayyad Desert Castles -> Abbasid -> Ayyubid Kerak -> Mamluk -> Ottoman -> Hashemite 7-Verse Fātiḥah Star Banner", "#007A3D", "#CE1126", "#000000"),
                new CountryCompassMapAndFlagEntry(13, "LB", "🇱🇧", "Lebanon", "Al-Jumhūriyyah Al-Lubnāniyyah (الجمهورية اللبنانية)", "II. Fertile Crescent & Nile", "Beirut", 33.8938, 35.5018, 161.9, 1445, "Maṭla' Al-Suhayl (SSE — 157.5°)", "Horizontal Red-White-Red bands charged with the immortal Green Cedar of Lebanon (Arz Lubnān).", "Rashidun Tripoli & Sidon -> Umayyad/Abbasid Naval Arsenals -> Fatimid -> Mamluk -> Ottoman/Ma'anid/Shihabid Red-and-White Banner -> Cedar Standard", "#ED1C24", "#00A651", "#FFFFFF"),
                new CountryCompassMapAndFlagEntry(14, "SD", "🇸🇩", "Sudan", "Jumhūriyyat Al-Sūdān (جمهورية السودان)", "II. Fertile Crescent & Nile", "Khartoum", 15.5007, 32.5599, 48.6, 1005, "Maṭla' Al-'Ayyūq (NE — 45.0°)", "Green triangle at the hoist (symbolizing Islam, agriculture, and the Nile) with Red, White, and Black horizontal Caliphate stripes.", "Baqt Treaty of Dongola (652 CE) -> Funj Islamic Sultanate of Sennar (1504–1821) -> Darfur Sultanate -> Mahdist Calligraphic Banner -> Four-Caliphate Standard", "#007229", "#D21034", "#000000"),

                // ZONE III: MAGHREB & SAHARAN-SAHELIAN WEST AFRICA (14 Countries)
                new CountryCompassMapAndFlagEntry(15, "MA", "🇲🇦", "Morocco", "Al-Mamlakah Al-Maghribiyyah (المملكة المغربية)", "III. Maghreb & West Africa", "Rabat (Fez & Marrakesh)", 34.0209, -6.8416, 94.5, 4745, "Maṭla' Al-Ṭā'ir (Due East — 90.0°)", "Deep Alaouite/Marinid Crimson field charged with the Emerald Pentagram Seal of Solomon (Khātam Sulaymān) representing the 5 Pillars of Islam.", "Idrisid White Banner (789) -> Almoravid -> Almohad & Marinid Crimson-and-Gold Rub' Al-Ḥizb Standard (1212) -> Saadian -> Alaouite Red Maritime Flag (1666) & Green Pentagram (1915)", "#C1272D", "#006233", "#D4AF37"),
                new CountryCompassMapAndFlagEntry(16, "DZ", "🇩🇿", "Algeria", "Al-Jumhūriyyah Al-Jazā'iriyyah (الجمهورية الجزائرية)", "III. Maghreb & West Africa", "Algiers", 36.7538, 3.0588, 105.4, 3925, "Maṭla' Al-Jawzā' (E by S — 101.25°)", "Vertical bisect of Emerald Green (Islam/Fatimid-Zayyanid heritage) and Pure White (peace) charged with a Crimson Crescent and Five-Pointed Star.", "Rustamid White -> Fatimid Green -> Zirid/Hammadid -> Almohad/Zayyanid Tlemcen Crescent Banner -> Ottoman Regency of Algiers (Barbarossa Red-Gold-Green) -> Emir Abdelkader's Green-White Standard", "#006233", "#FFFFFF", "#D21034"),
                new CountryCompassMapAndFlagEntry(17, "TN", "🇹🇳", "Tunisia", "Al-Jumhūriyyah Al-Tūnisiyyah (الجمهورية التونسية)", "III. Maghreb & West Africa", "Tunis ( & Kairouan)", 36.8065, 10.1815, 112.9, 3325, "Maṭla' Al-Tīr (ESE — 112.5°)", "Crimson Red field with a central White sun-disk enclosing a Red Crescent and Five-Pointed Star (instituted by Husainid Bey Al-Ḥusayn II in 1827/1831).", "Rashidun/Umayyad Kairouan (670 CE) -> Aghlabid -> Fatimid Green -> Hafsid White/Yellow Crescent Flag -> Ottoman-Husainid Crimson Crescent-Star Standard (1831)", "#E70013", "#FFFFFF", "#D4AF37"),
                new CountryCompassMapAndFlagEntry(18, "LY", "🇱🇾", "Libya", "Dawlat Lībiyā (دولة ليبيا)", "III. Maghreb & West Africa", "Tripoli", 32.8872, 13.1913, 109.1, 2860, "Maṭla' Al-Tīr (ESE — 112.5°)", "Horizontal Red, Black (double-width central band with White Crescent and Star of the Senussi Order), and Green stripes representing Fezzan, Cyrenaica, and Tripolitania.", "Rashidun Opening of Tripoli (643) -> Umayyad/Abbasid -> Fatimid -> Hafsid -> Ottoman Karamanli -> Senussi Black Banner with White Crescent & Star -> 1951/2011 Tri-Region Flag", "#000000", "#239E46", "#E70013"),
                new CountryCompassMapAndFlagEntry(19, "MR", "🇲🇷", "Mauritania", "Al-Jumhūriyyah Al-Islāmiyyah Al-Mūrītāniyyah (الجمهورية الإسلامية الموريتانية)", "III. Maghreb & West Africa", "Nouakchott (Chinguetti)", 18.0735, -15.9582, 76.5, 5810, "Maṭla' Al-Thurayyā (ENE — 78.75°)", "Emerald Green field charged with an upward-pointing Golden Crescent and Five-Pointed Star, framed by upper and lower Crimson bands.", "Cradle of the Almoravid Ribāṭ Movement (1040 CE) -> Chinguetti Saharan Caravan Standard -> Emerald & Gold Islamic Crescent Banner", "#00A95C", "#FFD700", "#D01C1F"),
                new CountryCompassMapAndFlagEntry(20, "ML", "🇲🇱", "Mali", "République du Mali — Bilād Māllī Wa Timbuktū (مالي — تمبكتو)", "III. Maghreb & West Africa", "Bamako (Timbuktu & Djenné)", 12.6392, -8.0029, 72.4, 5175, "Maṭla' Al-Simāk / Al-Thurayyā (ENE)", "Vertical tricolour of Green (fertility/faith), Gold (the legendary gold of Mansa Musa's Mali Empire), and Red.", "Ghana/Wagadu -> Mansa Musa's Imperial Mali Gold-on-Red Standard (1324 Hajj) -> Songhai Empire of Askia Muḥammad -> Massina Caliphate of Hamdullahi -> Green-Gold-Red Standard", "#14B53A", "#FCD116", "#CE1126"),
                new CountryCompassMapAndFlagEntry(21, "SN", "🇸🇳", "Senegal", "République du Sénégal — Al-Sinighāl (السنغال — طوبى)", "III. Maghreb & West Africa", "Dakar ( & Touba)", 14.7167, -17.4677, 73.9, 6045, "Maṭla' Al-Thurayyā (ENE — 78.75°)", "Green, Gold, and Red vertical bands with a central Five-Pointed Green Star symbolizing the 5 Pillars of Islam.", "Takrūr Kingdom (1030s CE, first West African Muslim state) -> Futa Toro Imamate of Abdul Kader Kan (1776) -> Tijāniyyah & Murīdiyyah (Touba) -> Green-Star Standard", "#00853F", "#FDEF42", "#E31B23"),
                new CountryCompassMapAndFlagEntry(22, "NE", "🇳🇪", "Niger", "République du Niger — Al-Nījar (النيجر — أغاديز)", "III. Maghreb & West Africa", "Niamey ( & Agadez Sultanate)", 13.5116, 2.1254, 74.1, 4085, "Maṭla' Al-Thurayyā (ENE — 78.75°)", "Horizontal Orange (Sahara/Ténéré), White (purity/Niger River) with central Solar Disk, and Green (Sahel savannah).", "Kanem-Bornu Sayfawa Dynasty (1085 CE) -> Sultanate of Air / Agadez (1449 CE) -> Sokoto Caliphate Frontier -> Tri-Band Solar Standard", "#E05206", "#FFFFFF", "#0DB02B"),
                new CountryCompassMapAndFlagEntry(23, "NG", "🇳🇬", "Nigeria", "Federal Republic of Nigeria — Khilāfat Sokoto wa Bornu (نيجيريا — خلافة صكتو)", "III. Maghreb & West Africa", "Abuja (Sokoto, Kano & Maiduguri)", 9.0765, 7.3986, 64.9, 3680, "Maṭla' Al-Simāk (ENE — 67.5°)", "Vertical Green-White-Green bands representing fertile stewardship and peace; historically anchored in the Pure Green Banner of the Sokoto Caliphate (1804 CE) and the Kanem-Bornu Empire.", "Kanem-Bornu Sayfawa Dynasty (1085–1846 CE) -> Hausa Emirates of Kano, Katsina & Zaria -> Shaykh 'Uthmān dan Fodio's Emerald Sokoto Caliphate Flag (1804–1903) -> Green-White-Green", "#008751", "#FFFFFF", "#D4AF37"),
                new CountryCompassMapAndFlagEntry(24, "GN", "🇬🇳", "Guinea", "République de Guinée — Ghīniyā / Imāmat Fūtā Jālūn (غينيا — إمامة فوتا جالون)", "III. Maghreb & West Africa", "Conakry (Timbo / Futa Jallon)", 9.6412, -13.5784, 70.6, 5775, "Maṭla' Al-Simāk (ENE — 67.5°)", "Vertical Red, Gold (ancient Bambuk/Bouré goldfields), and Green tricolour.", "Mali Empire Heartland -> Imamate of Futa Jallon (1725–1896 CE, Arabic-script Ajami constitution) -> Samori Touré's Wassoulou Empire -> Red-Gold-Green", "#CE1126", "#FCD116", "#009460"),
                new CountryCompassMapAndFlagEntry(25, "GM", "🇬🇲", "The Gambia", "Republic of The Gambia — Al-Ghāmbiyā (غامبيا)", "III. Maghreb & West Africa", "Banjul", 13.4549, -16.5790, 73.1, 5995, "Maṭla' Al-Simāk / Al-Thurayyā (ENE)", "Red (sun), Blue (Gambia River bordered by White peace stripes), and Green (land/Islamic stewardship).", "Mali Empire Western Province (Kaabu) -> Soninke-Marabout Islamic Reform States (Maba Diakhou Bâ) -> Riverine Tri-Color", "#CE1126", "#0C1C8C", "#3A7728"),
                new CountryCompassMapAndFlagEntry(26, "SL", "🇸🇱", "Sierra Leone", "Republic of Sierra Leone — Sīrālīūn (سيراليون)", "III. Maghreb & West Africa", "Freetown", 8.4657, -13.2317, 69.5, 5785, "Maṭla' Al-Simāk (ENE — 67.5°)", "Horizontal Green (agriculture/mountains), White (unity and justice), and Cobalt Blue (natural harbor of Freetown).", "Fula, Mandinka & Temne Islamic Scholarly Networks from Futa Jallon -> Fourah Bay Arabic-West African Letters -> Green-White-Blue", "#1EB53A", "#FFFFFF", "#0072C6"),
                new CountryCompassMapAndFlagEntry(27, "BF", "🇧🇫", "Burkina Faso", "Burkina Faso — بوركينا فاسو", "III. Maghreb & West Africa", "Ouagadougou ( & Bobo-Dioulasso)", 12.3714, -1.5197, 71.3, 4500, "Maṭla' Al-Simāk (ENE — 67.5°)", "Horizontal Red and Green bands charged with a central Five-Pointed Golden Star.", "Juula/Wangara Merchant & Scholarly Network (Grand Mosque of Bobo-Dioulasso) -> Moro Naba Dulugu's Embrace of Islam (1780s) & Liptako Emirate", "#EF2B2D", "#009E49", "#FCD116"),
                new CountryCompassMapAndFlagEntry(28, "TD", "🇹🇩", "Chad", "Jumhūriyyat Tshād (جمهورية تشاد — كانم وبرنو ووداي)", "III. Maghreb & West Africa", "N'Djamena (Abéché / Wadai)", 12.1348, 15.0557, 65.2, 2825, "Maṭla' Al-Simāk (ENE — 67.5°)", "Vertical Blue (sky/Lake Chad), Gold (sun and desert), and Red tricolour.", "1,000-Year Kanem-Bornu Empire (Mai Humai, 1085 CE), Sultanate of Bagirmi (1522 CE) & Sultanate of Wadai (1635 CE) -> Blue-Gold-Red", "#002664", "#FECB00", "#C60C30"),

                // ZONE IV: HORN OF AFRICA, EAST AFRICA & INDIAN OCEAN RIM (9 Countries)
                new CountryCompassMapAndFlagEntry(29, "SO", "🇸🇴", "Somalia", "Jamhuuriyadda Federaalka Soomaaliya — Al-Ṣūmāl (الصومال)", "IV. Horn of Africa & Swahili Rim", "Mogadishu (Zeila, Berbera & Merca)", 2.0469, 45.3182, 344.4, 2235, "Maghīb Al-Na'sh (NNW — 337.5°)", "Sky-Blue field charged with a Five-Pointed White Star (Xiddigta Shanta Geesood) representing the 5 Somali regions and the 5 Pillars.", "615 CE First Hijrah Sanctuary (Zeila Masjid Al-Qiblatayn) -> Sultanate of Ifat (1285) -> Adal Sultanate of Imam Aḥmad Gragn -> Ajuran & Geledi Sultanates -> Omani Benadir Coast", "#4189DD", "#FFFFFF", "#D4AF37"),
                new CountryCompassMapAndFlagEntry(30, "DJ", "🇩🇯", "Djibouti", "Jumhūriyyat Jībūtī (جمهورية جيبوتي)", "IV. Horn of Africa & Swahili Rim", "Djibouti City ( & Tadjoura)", 11.5721, 43.1456, 342.4, 1150, "Maghīb Al-Na'sh (NNW — 337.5°)", "Light Blue (sea/Issa) and Green (earth/Afar) horizontal bands with a White hoist triangle and Red Star.", "Gate of Bab al-Mandab opposite Yemeni Aden -> Afar Sultanates of Tadjoura & Rahayta -> Adal & Ottoman Zeila Eyalet -> Blue-Green-White Star", "#6AB2E7", "#12AD2B", "#D7141A"),
                new CountryCompassMapAndFlagEntry(31, "KM", "🇰🇲", "Comoros", "Al-Ittiḥād Al-Qamarī — Juzur Al-Qamar (جزر القمر)", "IV. Horn of Africa & Swahili Rim", "Moroni", -11.7172, 43.2473, 354.6, 3695, "Al-Jāh (Due North — 0.0°)", "Green hoist triangle charged with a White Crescent and Four White Stars alongside Yellow, White, Red, and Blue stripes for the 4 islands (Grande Comore, Anjouan, Mohéli, Mayotte).", "Shirazi, Omani & Hadhrami Bā 'Alawī Maritime Sultanates of Ndzuwani & Ngazidja (10th–19th c. CE) -> Green Crescent & Four-Island Banner", "#3D8E33", "#FFC61E", "#CE1126"),
                new CountryCompassMapAndFlagEntry(32, "MZ", "🇲🇿", "Mozambique", "República de Moçambique — Mūzambīq / Sufālah (موزمبيق — سفالة)", "IV. Horn of Africa & Swahili Rim", "Maputo (Ilha de Moçambique & Sofala)", -25.9692, 32.5732, 9.0, 5320, "Al-Jāh / Maṭla' Al-Farqadayn (N by E)", "Green, Black, and Gold bands with a Red hoist triangle and Open Book (education) — historically anchored in the Swahili-Omani Sultanate of Angoche and Mūsā bin Bīk (after whom Mozambique is named!).", "Gold Port of Sofala (described by Al-Mas'ūdī in 916 CE) -> Kilwa & Omani Sultanate of Mūsā bin Bīk (Ilha de Moçambique) -> Sultanate of Angoche", "#007168", "#FCE100", "#D21034"),
                new CountryCompassMapAndFlagEntry(33, "UG", "🇺🇬", "Uganda", "Republic of Uganda — Ūghandā (أوغندا)", "IV. Horn of Africa & Swahili Rim", "Kampala", 0.3476, 32.5825, 19.3, 2480, "Maṭla' Al-Na'sh (NNE — 22.5°)", "Six alternating Black, Yellow, and Red stripes with the Crested Crane at the center.", "1844 Arrival of Omani-Zanzibari Merchant Shaykh Aḥmad bin Ibrāhīm at the Court of Kabaka Suuna II of Buganda -> Kabaka Muteesa I's Embrace of Islam & Ramadan Observance (1860s)", "#000000", "#FCDC04", "#D90000"),
                new CountryCompassMapAndFlagEntry(34, "CI", "🇨🇮", "Côte d'Ivoire", "République de Côte d'Ivoire — Sāḥil Al-'Āj (ساحل العاج — كونغ)", "IV. Horn of Africa & Swahili Rim", "Yamoussoukro (Abidjan & Kong)", 6.8276, -5.2893, 66.8, 5005, "Maṭla' Al-Simāk (ENE — 67.5°)", "Vertical Orange (savannah), White (peace), and Green (forest/hope) tricolour.", "Juula Islamic Empire of Kong (1710–1898 CE, famous for its Sudanese mud-brick mosques and Timbuktu-linked madrasahs) & Bondoukou", "#F77F00", "#FFFFFF", "#009E60"),
                new CountryCompassMapAndFlagEntry(35, "CM", "🇨🇲", "Cameroon", "République du Cameroun — Al-Kāmīrūn / Ādamāwā (الكاميرون — إمارة آداماوا)", "IV. Horn of Africa & Swahili Rim", "Yaoundé (Garoua, Maroua & Foumban)", 3.8480, 11.5021, 57.8, 3550, "Maṭla' Al-Wāqi' (NE by E — 56.25°)", "Vertical Green, Red (with Golden Unity Star), and Yellow bands.", "Kanem-Bornu Mandara Sultanate (1715 CE), Sokoto Emirate of Adamawa (Modibbo Adama, 1809 CE) & Sultan Ibrahim Njoya of the Bamum Kingdom", "#007A5E", "#CE1126", "#FCD116"),
                new CountryCompassMapAndFlagEntry(36, "TG", "🇹🇬", "Togo", "République Togolaise — Tūghū (توغو — سوكودي)", "IV. Horn of Africa & Swahili Rim", "Lomé ( & Sokodé)", 6.1256, 1.2254, 64.2, 4410, "Maṭla' Al-Simāk (ENE — 67.5°)", "Five alternating Green and Yellow horizontal stripes with a Red canton and White Five-Pointed Star.", "Kotokoli / Tem & Hausa Caravan Sultanate of Sokodé (18th c. CE) linking the Gold Coast to Sokoto and Timbuktu", "#006A4E", "#FFCE00", "#D21034"),
                new CountryCompassMapAndFlagEntry(37, "BJ", "🇧🇯", "Benin", "République du Bénin — Bīnīn (بنين — باراكو وبورتو نوفو)", "IV. Horn of Africa & Swahili Rim", "Porto-Novo ( & Parakou)", 6.4969, 2.6289, 63.8, 4260, "Maṭla' Al-Simāk (ENE — 67.5°)", "Vertical Green hoist band with Yellow and Red horizontal bands.", "Borgu / Nikki Wangara Merchant Network, Yoruba-Muslim Porto-Novo & Afro-Brazilian Agudá Returnee Mosques (19th c. CE)", "#008751", "#FCD116", "#E8112D"),
                new CountryCompassMapAndFlagEntry(38, "GA", "🇬🇦", "Gabon", "République Gabonaise — Al-Ghābūn (الغابون)", "IV. Horn of Africa & Swahili Rim", "Libreville", 0.4162, 9.4673, 52.3, 4050, "Maṭla' Al-'Ayyūq / Al-Wāqi' (NE)", "Horizontal Green (equatorial forests), Gold (Equator/sun), and Royal Blue (Atlantic Ocean) stripes.", "West-Central African Hausa/Senegalese Merchant Diffusion & Contemporary Sovereign OIC Membership (since 1974)", "#009E60", "#FCD116", "#3A75C4"),
                new CountryCompassMapAndFlagEntry(39, "GW", "🇬🇼", "Guinea-Bissau", "República da Guiné-Bissau — Ghīniyā Bīsāw (غينيا بيساو)", "IV. Horn of Africa & Swahili Rim", "Bissau ( & Gabú)", 11.8636, -15.5977, 72.1, 5920, "Maṭla' Al-Simāk (ENE — 67.5°)", "Vertical Red hoist with Black Star alongside Yellow and Green horizontal bands.", "Kaabu (Gabú) Mandinka Province of the Mali Empire & Fula Islamic Kingdom of Fuladugu (19th c. CE)", "#CE1126", "#FCD116", "#009E49"),

                // ZONE V: ANATOLIA, BALKANS, CAUCASUS & TURKIC STEPPE (8 Countries)
                new CountryCompassMapAndFlagEntry(40, "TR", "🇹🇷", "Türkiye", "Türkiye Cumhuriyeti — Al-Jumhūriyyah Al-Turkiyyah (تركيا)", "V. Anatolia, Balkans & Central Asia", "Ankara ( & Istanbul)", 39.9334, 32.8597, 160.2, 2145, "Maṭla' Al-Suhayl (SSE — 157.5°)", "Al-Bayraq (Ay-Yıldız): Crimson Red field charged with the White Waxing Crescent (Hilāl) and Five-Pointed Star (Kawkab), directly continuing the 1844 Ottoman Caliphate banner.", "Seljuk Sultanate of Rūm Turquoise Double-Eagle (1077–1308) -> Ottoman Crimson 3-Crescents & Zülfikar (1453) -> 1844 Ottoman Ay-Yıldız -> Republic of Türkiye", "#E30A17", "#FFFFFF", "#D4AF37"),
                new CountryCompassMapAndFlagEntry(41, "AZ", "🇦🇿", "Azerbaijan", "Azərbaycan Respublikası — Ādharbayjān (أذربيجان)", "V. Anatolia, Balkans & Central Asia", "Baku ( & Ganja / Shamakhi)", 40.4093, 49.8671, 207.2, 2270, "Maghīb Al-Suhayl (SSW — 202.5°)", "Horizontal Turkic Sky-Blue, Red (with White Crescent and Eight-Pointed Star — Rub' Al-Ḥizb / 8 Turkic branches), and Islamic Green bands.", "Rashidun/Abbasid Arrān -> Shirvanshah Dynasty (861–1538, Palace of Baku) -> Eldiguzids -> Kara Koyunlu / Ak Koyunlu -> Safavid -> 1918 Blue-Red-Green Crescent Flag", "#00B5E2", "#EF3340", "#509E2F"),
                new CountryCompassMapAndFlagEntry(42, "UZ", "🇺🇿", "Uzbekistan", "Oʻzbekiston Respublikasi — Ūzbakistān / Mā Warā' Al-Nahr (أوزبكستان — سمرقند وبخارى)", "V. Anatolia, Balkans & Central Asia", "Tashkent (Samarkand, Bukhara & Khiva)", 41.2995, 69.2401, 240.8, 3530, "Maghīb Al-Tīr (WSW — 247.5°)", "Timurid Sky-Blue, White (peace/cotton), and Islamic Green bands separated by thin Red fimbriations, with a White Crescent and 12 Stars (12 months/constellations of Ulugh Beg's Zīj).", "Umayyad/Abbasid Transoxiana -> Samanid Golden Age (Al-Bukhārī, Ibn Sīnā, Al-Khwārizmī) -> Karakhanids -> Khwarazmshahs -> Timurid 3-Orb Flag (Samarkand) -> Bukhara/Khiva/Kokand -> Blue-White-Green Crescent", "#0099B5", "#1EB53A", "#FFFFFF"),
                new CountryCompassMapAndFlagEntry(43, "KZ", "🇰🇿", "Kazakhstan", "Qazaqstan Respýblıkasy — Kāzākhistān (كازاخستان — تركستان)", "V. Anatolia, Balkans & Central Asia", "Astana ( & Turkistan / Yasi)", 51.1694, 71.4491, 232.1, 4195, "Maghīb Al-'Aqrab (SW — 225.0°)", "Tengri/Timurid Sky-Blue field charged with a Golden Steppe Eagle beneath a 32-rayed Golden Sun and traditional Kazakh ornamental Koshkar-Muiz hoist border.", "Karakhanid Dynasty -> Islamization of the Golden Horde under Berke Khan (1257) & Öz Beg Khan (1313) -> Mausoleum of Khoja Ahmad Yasawi -> Kazakh Khanate (1465) -> Sky-Blue & Gold", "#00AFCA", "#FEC50C", "#D4AF37"),
                new CountryCompassMapAndFlagEntry(44, "TM", "🇹🇲", "Turkmenistan", "Türkmenistan — Turkmānistān / Marw (تركمانستان — مرو)", "V. Anatolia, Balkans & Central Asia", "Ashgabat ( & Ancient Merv / Konye-Urgench)", 37.9601, 58.3261, 229.6, 2460, "Maghīb Al-'Aqrab (SW — 225.0°)", "Deep Islamic Emerald Green field featuring a vertical Crimson carpet-gül strip (5 traditional Turkmen tribal medallions) alongside a White Waxing Crescent and 5 Five-Pointed Stars.", "Abbasid Capital at Merv (Al-Ma'mūn) -> Birthplace of the Great Seljuk Empire (Tughril Beg & Sultan Sanjar at Merv) -> Khwarazmian Urgench -> Emerald Carpet & Crescent Flag", "#00843D", "#D22630", "#FFFFFF"),
                new CountryCompassMapAndFlagEntry(45, "KG", "🇰🇬", "Kyrgyzstan", "Kyrgyz Respublikasy — Qirghīzistān / Balāsāghūn (قرغيزستان — بلاساغون)", "V. Anatolia, Balkans & Central Asia", "Bishkek ( & Burana / Balasagun, Osh)", 42.8746, 74.5698, 244.7, 4005, "Maghīb Al-Tīr (WSW — 247.5°)", "Crimson Red field charged with a 40-rayed Golden Sun enclosing a stylized Tündük (crown of the Kyrgyz yurt).", "Karakhanid Capital of Balasagun (Burana Tower, 10th c. CE; Yūsuf Khāṣṣ Ḥājib's Kutadgu Bilig, 1069 CE) -> Chagatai/Moghulistan -> Kokand Khanate -> Red-and-Gold Tündük", "#E8112D", "#FFEF00", "#D4AF37"),
                new CountryCompassMapAndFlagEntry(46, "TJ", "🇹🇯", "Tajikistan", "Jumhurii Tojikiston — Ṭājīkistān (طاجيكستان — خجند)", "V. Anatolia, Balkans & Central Asia", "Dushanbe ( & Khujand / Panjakent)", 38.5598, 68.7870, 244.2, 3365, "Maghīb Al-Tīr (WSW — 247.5°)", "Horizontal Red, White (double-width with a Golden Crown and 7 Stars), and Islamic Green stripes.", "Heartland of the Samanid Dynasty (Ismail Samani, 892–907 CE; Rūdakī & Ibn Sīnā) -> Ghurid Empire -> Timurid -> Emirate of Bukhara -> Red-White-Green Crown Standard", "#CC0000", "#FFFFFF", "#006600"),
                new CountryCompassMapAndFlagEntry(47, "AL", "🇦🇱", "Albania", "Republika e Shqipërisë — Albāniyā (ألبانيا)", "V. Anatolia, Balkans & Central Asia", "Tirana (Berat & Gjirokastër)", 41.3275, 19.8187, 134.8, 2865, "Maṭla' Al-'Aqrab (SE — 135.0°)", "Crimson Red field charged with a Black Double-Headed Eagle.", "500 Years of Ottoman Rumelia (30+ Ottoman Grand Viziers of Albanian origin, including the Köprülü Dynasty; Et'hem Bey Mosque of Tirana; Sunni Hanafi & Bektashi heritage)", "#E41E20", "#000000", "#D4AF37"),

                // ZONE VI: PERSIANATE PLATEAU & SOUTH ASIAN SUBCONTINENT (5 Countries)
                new CountryCompassMapAndFlagEntry(48, "IR", "🇮🇷", "Iran", "Jomhūrī-ye Eslāmī-ye Īrān — Īrān / Fāris (إيران — بلاد فارس)", "VI. Persianate & South Asia", "Tehran (Isfahan, Shiraz, Tabriz, Mashhad)", 35.6892, 51.3890, 218.6, 1945, "Maghīb Al-'Aqrab (SW — 225.0°)", "Horizontal Green, White, and Red bands bordered with 22 Square Kufic inscriptions of 'Allāhu Akbar' (11 on top, 11 on bottom) and the central calligraphic emblem of 'Allāh' formed of 4 crescents and a sword.", "Rashidun/Umayyad/Abbasid Persian Synthesis (Salmān Al-Fārisī, Sībawayh, Al-Rāzī, Al-Bīrūnī, Al-Ghazālī) -> Buyid/Seljuk/Ilkhanid/Timurid -> Safavid Lion & Sun -> Kufic Takbīr Standard", "#239F40", "#FFFFFF", "#DA0000"),
                new CountryCompassMapAndFlagEntry(49, "PK", "🇵🇰", "Pakistan", "Islāmī Jumhūriyyah Pākistān (جمهورية باكستان الإسلامية)", "VI. Persianate & South Asia", "Islamabad (Lahore, Karachi & Multan)", 33.6844, 73.0479, 255.8, 3530, "Maghīb Al-Tīr (WSW — 247.5°)", "Parcham-e-Sitāra-o-Hilāl: Deep Islamic Emerald Green field (Muslim majority) with a vertical White hoist band (protection of religious minorities, Charter of Medina) charged with a White Waxing Crescent and Five-Pointed Star.", "711 CE Umayyad Sindh (Muḥammad ibn Al-Qāsim's Charter of Al-Rūr) -> Ghaznavid Lahore -> Ghurid -> Delhi Sultanate -> Mughal Empire Green 'Alam (Badshahi Mosque) -> 1947 Crescent-and-Star Banner", "#01411C", "#FFFFFF", "#D4AF37"),
                new CountryCompassMapAndFlagEntry(50, "BD", "🇧🇩", "Bangladesh", "Gônoprojatontri Bangladesh — Banghlādish (بنغلاديش — البنغال)", "VI. Persianate & South Asia", "Dhaka ( & Sylhet / Sonargaon)", 23.8103, 90.4125, 277.6, 5175, "Maghīb Al-Ṭā'ir / Al-Thurayyā (W by N)", "Lush Emerald-Green field (representing the fertile Bengal Delta and Islamic heritage) charged with a Crimson-Red Solar Disk offset slightly toward the hoist.", "Bakhtiyar Khalji (1204) -> Independent Bengal Sultanate (Ilyas Shahi & Husayn Shahi, 1352–1576; Shāh Jalāl of Sylhet) -> Mughal Subah of Bengal (richest province on earth) -> Emerald & Crimson Sun", "#006A4E", "#F42A41", "#D4AF37"),
                new CountryCompassMapAndFlagEntry(51, "AF", "🇦🇫", "Afghanistan", "Afghānistān — Khurāsān (أفغانستان — هرات وبلخ وغزنة)", "VI. Persianate & South Asia", "Kabul (Herat, Balkh, Ghazni & Kandahar)", 34.5553, 69.2075, 250.8, 3235, "Maghīb Al-Tīr (WSW — 247.5°)", "Historically combines the Shahādah calligraphy ('Lā ilāha illā Allāh Muḥammadun Rasūlullāh') and Mosque/Mihrab/Minbar emblem with White, Black, Red, and Green banners.", "Abbasid Balkh & Herat -> Ghaznavid Empire of Maḥmūd of Ghazni (977–1186) -> Ghurid Empire -> Timurid Renaissance Capital at Herat -> Hotak & Durrani Empire (Aḥmad Shāh Durrānī, 1747)", "#000000", "#D32011", "#007A36"),
                new CountryCompassMapAndFlagEntry(52, "MV", "🇲🇻", "Maldives", "Dhivehi Raajje — Juzur Al-Māldīf (جزر المالديف — المحلديب)", "VI. Persianate & South Asia", "Malé", 4.1755, 73.5093, 301.1, 4125, "Maghīb Al-Thurayyā (WNW — 292.5°)", "Crimson Red border (honoring maritime defenders against Portuguese invasions) framing an Emerald-Green rectangle charged with a vertical White Waxing Crescent.", "1153 CE (548 AH) Voluntary Embrace of Islam under Sultan Muḥammad al-ʿĀdil via Maghrebi scholar Abū al-Barakāt al-Barbarī (visited by Ibn Baṭṭūṭah as Qāḍī in 1343 CE) -> Red-Green Crescent Banner", "#D21034", "#007E3A", "#FFFFFF"),

                // ZONE VII: MARITIME NUSANTARA & LATIN-CARIBBEAN DIASPORA (5 Countries)
                new CountryCompassMapAndFlagEntry(53, "ID", "🇮🇩", "Indonesia", "Republik Indonesia — Indūnīsiyā / Nūsāntārā (إندونيسيا — أرخبيل نوسانتارا)", "VII. Maritime Nusantara & Global Rim", "Jakarta (Aceh, Demak, Yogyakarta, Surabaya)", -6.2088, 106.8456, 295.2, 7920, "Maghīb Al-Thurayyā (WNW — 292.5°)", "Sang Saka Merah Putih (Sacred Red-and-White): Horizontal Crimson Red over Pure White—originating in the 13th-century Nusantara banner and the red-and-white sugar-palm standards carried by Sultan Agung of Mataram, Prince Diponegoro, and the Wali Songo.", "Samudera Pasai (1267 CE) -> Sultanate of Aceh Crimson Alam Peudeuëng (Ottoman alliance) -> Sultanates of Demak, Cirebon, Banten, Mataram, Gowa-Tallo & Ternate -> Sang Saka Merah Putih (World's largest Muslim population: ~251M)", "#FF0000", "#FFFFFF", "#D4AF37"),
                new CountryCompassMapAndFlagEntry(54, "MY", "🇲🇾", "Malaysia", "Malaysia — Mālīziyā / Salṭanat Malāqā (ماليزيا — سلطنة ملقا)", "VII. Maritime Nusantara & Global Rim", "Kuala Lumpur ( & Malacca / Johor / Kedah)", 3.1390, 101.6869, 292.5, 6975, "Maghīb Al-Thurayyā (WNW — 292.5°)", "Jalur Gemilang (Stripes of Glory): 14 alternating Red and White stripes with a Royal Blue canton charged with a Golden Crescent (Islam as official religion) and 14-Pointed Federal Star (Bintang Persekutuan).", "1136 CE Kedah Embrace & Terengganu Inscription Stone (1303 CE) -> Sultanate of Malacca (1400–1511 CE, Parameswara / Iskandar Shah) -> Johor, Perak, Kelantan & Pahang Crescent Banners -> Jalur Gemilang", "#010066", "#FFCC00", "#CC0001"),
                new CountryCompassMapAndFlagEntry(55, "BN", "🇧🇳", "Brunei Darussalam", "Negara Brunei Darussalam — Brūnāy Dār Al-Salām (بروناي دار السلام)", "VII. Maritime Nusantara & Global Rim", "Bandar Seri Begawan", 4.9031, 114.9398, 290.9, 8265, "Maghīb Al-Thurayyā (WNW — 292.5°)", "Royal Yellow field cut by White and Black diagonal parallelograms, charged at the center with the Crimson Panji-Panji Crest featuring an upward-pointing Islamic Crescent inscribed in golden Arabic script: 'Ad-Dā'imūna Al-Muḥsinūna Bi-l-Hudā' ('Always render service with God's guidance') and 'Brunei Darussalam'.", "1368 CE Embrace of Islam by Sultan Muhammad Shah (Awang Alak Betatar) & Sharif Ali (descendant of the Prophet ﷺ from Ta'if who built the first mosque and stone Kota Batu) -> Royal Yellow & Arabic Crescent Crest", "#F7E017", "#CF1126", "#000000"),
                new CountryCompassMapAndFlagEntry(56, "GY", "🇬🇾", "Guyana", "Co-operative Republic of Guyana — Ghuyānā (غويانا)", "VII. Maritime Nusantara & Global Rim", "Georgetown", 6.8013, -58.1551, 68.7, 10545, "Maṭla' Al-Simāk (ENE — 67.5°)", "The Golden Arrowhead: Green field (agriculture/forests) penetrated by a Golden-Yellow arrowhead bordered in White and a Red hoist triangle bordered in Black.", "West African Fulani/Mandinka Muslim Arrival & 1838–1917 South Asian Muslim Scholarly/Masjid Foundation across Demerara and Berbice -> Full OIC Member State (1998)", "#009E49", "#FCD116", "#CE1126"),
                new CountryCompassMapAndFlagEntry(57, "SR", "🇸🇷", "Suriname", "Republiek Suriname — Sūrīnām (سورينام)", "VII. Maritime Nusantara & Global Rim", "Paramaribo", 5.8520, -55.2038, 68.4, 10290, "Maṭla' Al-Simāk (ENE — 67.5°)", "Horizontal Green, White, Red (double-width with Golden Five-Pointed Star), White, and Green bands.", "West African Muslim Heritage + South Asian (Hanafi/Ahle Sunnat) & Indonesian Javanese Muslim Migration (making Suriname the highest-percentage Muslim nation in the Western Hemisphere, holding the largest Mosque-Synagogue neighbor square in Paramaribo! OIC Member since 1996)", "#377E3F", "#B40A2D", "#ECC81D")
        );
    }
}
