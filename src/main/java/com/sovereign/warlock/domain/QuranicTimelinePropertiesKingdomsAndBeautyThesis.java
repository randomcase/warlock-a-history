package com.sovereign.warlock.domain;

import java.util.List;

/**
 * Multi-Volume Collegiate & Canonical Synthesis of:
 * - Volume I (Portal #58): Canonical Qur'anic Timeline of Islamic Expansion — Mapping Qur'anic Surahs and Ayahs
 *   to Prophetic History and 14 Hijri Centuries of Global Civilizational Expansion.
 * - Volume II (Portal #59): Canonical Islamic Properties (Al-Amwal wa Al-Aradi: Milk Allah, 'Ushr, Kharaj, Fay',
 *   Waqf, Ihya' Al-Mawat, Hima/Harim & Private Ownership), Countries (Al-Buldan) & Kingdoms (Al-Mamalik) Across
 *   the 7 Classical Climes (Al-Aqalim As-Sab'ah).
 * - Volume III (Portal #60): The Beauty of Islam (Jamal Al-Islam — Sahih Muslim 91 & Qur'an 12:18, 15:85, 16:6,
 *   24:35, 39:23, 50:6, 67:3) & The 8-Chapter Collegiate Universal Thesis Essay (Ar-Risalah Al-Jami'iyyah Al-'Alamiyyah).
 */
public final class QuranicTimelinePropertiesKingdomsAndBeautyThesis {

    private QuranicTimelinePropertiesKingdomsAndBeautyThesis() {
    }

    /**
     * Volume I Record: Represents one of the 10 canonical epochs of the Qur'anic Timeline of Revelation & Expansion.
     */
    public record QuranicExpansionTimelineEpoch(
            int epochIndex,
            String epochCode,
            String chronologicalEraAndHijriSpan,
            String titleAndGeographicHorizon,
            String anchoringQuranicSurahsAndAyahs,
            String historicalExpansionAndCivilizationalEvents,
            String constitutionalAndPropertyTransformation,
            String universalLessonForHumanity,
            String hexAccentColor
    ) {
    }

    /**
     * Volume II Record A: Represents one of the 7 canonical categories of property and land tenure in Islamic law
     * (Fiqh Al-Amwal wa Al-Aradi).
     */
    public record CanonicalPropertyAndLandCategory(
            int categoryIndex,
            String categoryCode,
            String arabicAndEnglishTitle,
            String primaryQuranicAndHadithBasis,
            String legalDefinitionAndTenureRules,
            String fiscalRateAndPublicRevenueDestination,
            String historicalImplementationInKingdoms,
            String comparativeEconomicSignificance,
            String hexColor
    ) {
    }

    /**
     * Volume II Record B: Represents one of the 7 classical climes/realms of Islamic Countries (Al-Buldan) and
     * Kingdoms (Al-Mamalik) as documented by Al-Muqaddasi, Al-Idrisi, and Yaqut Al-Hamawi.
     */
    public record CountriesAndKingdomsClime(
            int climeIndex,
            String climeCode,
            String classicalNameAndModernCountries,
            String majorKingdomsSultanatesAndDynasties,
            String signatureCitiesAndArchitecturalJewels,
            String signaturePropertyWaqfAndEconomicEngines,
            String canonicalGeographersAndPrimarySources,
            String hexColor
    ) {
    }

    /**
     * Volume III Record A: Represents one of the 7 canonical dimensions of the Beauty of Islam (Jamal Al-Islam).
     */
    public record BeautyOfIslamDimension(
            int dimensionIndex,
            String dimensionCode,
            String arabicAndEnglishTitle,
            String quranicAndPropheticAestheticAnchor,
            String philosophicalAndTheologicalEssence,
            String livedCivilizationalAndArtisticExpression,
            String universalHumanResonance,
            String hexColor
    ) {
    }

    /**
     * Volume III Record B: Represents one of the 8 chapters of the Collegiate Universal Thesis Essay.
     */
    public record CollegiateThesisChapter(
            int chapterNumber,
            String chapterCode,
            String chapterTitle,
            String epigraphAndCanonicalCitation,
            String thesisProposition,
            String paragraphOneHistoricalAndScripturalFoundation,
            String paragraphTwoInstitutionalAndLegalAnalysis,
            String paragraphThreeComparativeUniversalSynthesis,
            String seminarDiscussionAndResearchPrompt
    ) {
    }

    private static final List<QuranicExpansionTimelineEpoch> TEN_QURANIC_TIMELINE_EPOCHS = List.of(
            new QuranicExpansionTimelineEpoch(
                    1,
                    "EPOCH-01-ALAST-IBRAHIMIC-FOUNDATION",
                    "Pre-Temporal Covenant -> c. 2000 BCE (Al-Mīthāq & Millat Ibrāhīm)",
                    "1. The Primordial & Abrahamitic Horizon: From the Covenant of Alast to the Raising of the Ka'bah in Bakka",
                    "Qur'an 7:172 (Covenant of Alast), Qur'an 2:124–129 (Abraham & Ishmael raising the foundations of Al-Bayt Al-Ḥarām), Qur'an 3:96 ('Indeed, the first House established for mankind is that at Bakkah, blessed and a guidance for the worlds'), & Qur'an 22:26–27 (Universal Call to Hajj).",
                    "Before any imperial border existed, the Qur'an anchors Islamic history in cosmic ontology (7:172) and Abraham's sanctification of Mecca as a demilitarized, universal sanctuary (Ḥaram Āmin, Qur'an 28:57 & 29:67). Every prophet from Noah to Moses and Jesus belongs to this single monotheistic tree.",
                    "Establishes the foundational property principle of Islam: the Sacred Sanctuary (Al-Masjid Al-Ḥarām) belongs to no tribe or king as private exclusionary property, but is an open trust for both the resident and the traveler ('sawā'an al-'ākifu fīhi wa al-bād', Qur'an 22:25).",
                    "Human history is not a blind Darwinian struggle of nations, but a purposeful moral trust (Amānah, Qur'an 33:72) anchored in sacred sanctuary.",
                    "#10B981"
            ),
            new QuranicExpansionTimelineEpoch(
                    2,
                    "EPOCH-02-MECCAN-DAWAH-ABYSSINIA",
                    "610–622 CE (13 BH – 1 AH) • Mecca, Aṭ-Ṭā'if & First Hijrah to the Kingdom of Aksum (Abyssinia)",
                    "2. The Meccan Revelation Epoch: Spiritual Interiority, Moral Revolution & The Abyssinian Asylum",
                    "Qur'an 96:1–5 (First revelation: 'Iqra''), Qur'an 73:1–8 & 74:1–7, Qur'an 19:1–36 (Surah Maryam recited before King Ashama An-Najāshī), Qur'an 30:1–5 (Surah Ar-Rūm prophesying Byzantine victory within 3–9 years), & Qur'an 90:11–16 (Freeing slaves and feeding the orphan).",
                    "During 13 years in Mecca, no military campaign or state taxation existed. Instead, Meccan Surahs dismantled idolatrous oligarchy, female infanticide (81:8–9), and commercial fraud (83:1–3), while dispatching persecuted believers across the Red Sea in 615 CE to the righteous Christian king An-Najāshī of Abyssinia—Islam's first trans-continental diplomatic bridge.",
                    "Meccan property ethics focused on voluntary emancipatory charity: spending one's private wealth to free enslaved human beings (Fakk Raqabah, Qur'an 90:13) and honoring the rightful share (Ḥaqq Ma'lūm, Qur'an 70:24–25) of the beggar and the destitute.",
                    "True civilizational expansion begins inside the human conscience, intellect, and character long before it manifests in territorial governance.",
                    "#D4AF37"
            ),
            new QuranicExpansionTimelineEpoch(
                    3,
                    "EPOCH-03-MEDINAN-COVENANT-BADR-HUDAYBIYYAH",
                    "622–632 CE (1–11 AH) • Al-Madīnah Al-Munawwarah, Badr, Al-Ḥudaybiyyah, Khaybar, Makkah & Tabūk",
                    "3. The Medinan Prophetic Commonwealth: Constitutional Pluralism, the Peace of Ḥudaybiyyah & Opening of Arabia",
                    "Qur'an 2:256 ('No compulsion in religion'), Qur'an 8:1–41 (Surah Al-Anfāl on Badr), Qur'an 33:9–27 (Surah Al-Aḥzāb on the Trench), Qur'an 48:1–29 (Surah Al-Fatḥ calling the Truce of Ḥudaybiyyah the 'Clear Victory'), Qur'an 9:60 (8 categories of Zakat), Qur'an 110:1–3 (Surah An-Naṣr), & Qur'an 5:3 (Perfection of the Dīn at 'Arafāt).",
                    "The Hijrah (622 CE) instantiated the Constitution of Medina (Ṣaḥīfat Al-Madīnah), the Brotherhood (Mu'ākhāh) pairing landless Meccan refugees with Medinan landowners, the defensive victories of Badr (2 AH) and the Trench (5 AH), the diplomatic breakthrough of Al-Ḥudaybiyyah (6 AH) which doubled the Muslim population in two years, the bloodless Opening of Mecca (8 AH) with general amnesty, and the diplomatic letters to Heraclius, Khosrow, Muqawqis, and Negus.",
                    "Codified the entire canonical framework of Islamic property: the prohibition of usury (Ribā, Qur'an 2:275–279), mandatory written debt contracts (Āyat Ad-Dayn, Qur'an 2:282), fixed female and male inheritance shares (Qur'an 4:7–12), the first agricultural Waqf orchards of 'Umar in Khaybar and 'Uthmān's Well of Rūmah, and the 8 public welfare heads of Zakat (Qur'an 9:60).",
                    "Demonstrates that peace treaties (Ḥudaybiyyah), general amnesty (Mecca), and debt/usury abolition are more powerful engines of expansion than vengeance.",
                    "#38BDF8"
            ),
            new QuranicExpansionTimelineEpoch(
                    4,
                    "EPOCH-04-RASHIDUN-FUTUHAT-KHARAJ-COVENANT",
                    "632–661 CE (11–40 AH) • Levant (Damascus/Jerusalem), Iraq (Kufa/Basra), Egypt (Fustat), Persia & Khorasan",
                    "4. The Rāshidūn Futūḥāt Epoch: The Qur'anic Fay' Equity Law (59:7–10) & The Jerusalem Covenant",
                    "Qur'an 24:55 (Promise of Istikhlāf), Qur'an 42:38 ('Their affair is conducted by consultation [Shūrā] among themselves'), & Qur'an 59:7–10 ('So that wealth may not become a perpetual circuit solely among the rich among you').",
                    "Under Abū Bakr, 'Umar, 'Uthmān, and 'Alī, the young Medinan commonwealth simultaneously defeated the Byzantine and Sasanian empires at Yarmūk (15 AH / 636 CE), Al-Qādisiyyah (15 AH), and Nahāwand (21 AH), while 'Umar entered Jerusalem on foot in 15 AH (637 CE), guaranteeing the churches, crosses, and properties of Christians and re-opening Jerusalem to Jewish residency.",
                    "'Umar ibn Al-Khaṭṭāb convened the Companions in Medina to establish the landmark constitutional property ruling of Islamic history: citing Qur'an 59:7–10, he refused to divide the fertile lands of Iraq, Syria, and Egypt as private war booty among soldiers. Instead, he left the land in the hands of its indigenous Christian, Jewish, and Zoroastrian peasant owners as Arḍ Al-Kharāj (covenanted public trust land), whose fair land-tax funded canals, bridges, and stipends ('Aṭā') for all citizens and future generations.",
                    "Prevented feudal serfdom in the Islamic world by keeping agrarian land with indigenous cultivators while dedicating state revenue to public infrastructure.",
                    "#A855F7"
            ),
            new QuranicExpansionTimelineEpoch(
                    5,
                    "EPOCH-05-UMAYYAD-TRANSCONTINENTAL-HORIZON",
                    "661–750 CE (41–132 AH) • From the Atlantic (Lisbon/Cordoba) across North Africa & Damascus to Samarkand & Sindh",
                    "5. The Umayyad Trans-Continental Horizon: Atlantic-to-Indus Integration, Monetary Sovereignty & 'Umar II's Fiscal Reform",
                    "Qur'an 49:13 ('O mankind, We created you from a male and a female and made you peoples and tribes that you may know one another'), Qur'an 22:41 ('Those who, if We establish them in the land, establish prayer, give Zakat, enjoin what is right...').",
                    "Connected three continents into a single common market without internal customs barriers from the Pyrenees and Morocco to the Indus River (Muḥammad ibn Al-Qāsim's 711 CE Charter of Al-Rūr granting Buddhist and Hindu temples full dhimmī status) and Transoxiana (Samarqand/Bukhara).",
                    "Caliph 'Abd al-Malik established monetary sovereignty in 77 AH (696 CE) by minting the pure epigraphic gold Dinar (4.25g) and silver Dirham (2.97g) inscribed with Surah Al-Ikhlāṣ (Qur'an 112). Caliph 'Umar ibn 'Abd al-'Azīz (717–720 CE) abolished discriminatory taxes on new converts, returned confiscated royal estates to the public Bayt Al-Māl, and funded universal debt relief and marriage endowments.",
                    "A sound, non-inflated commodity currency paired with equal fiscal rights for all converts catalyzed centuries of trans-continental prosperity.",
                    "#F43F5E"
            ),
            new QuranicExpansionTimelineEpoch(
                    6,
                    "EPOCH-06-ABBASID-ANDALUSIAN-GOLDEN-SYNTHESIS",
                    "750–1258 CE (132–656 AH) • Baghdad, Cordoba, Cairo, Kairouan, Fez, Nishapur, Bukhara & Samarkand",
                    "6. The Abbasid & Andalusian Golden Synthesis: Waqf Civil Society, The Agricultural Revolution & Scientific Cosmopolitanism",
                    "Qur'an 96:1–5, Qur'an 20:114 ('My Lord, increase me in knowledge'), Qur'an 6:99 & 16:10–11 (Botanical diversity & irrigation), & Qur'an 2:261 (Parable of the grain multiplying 700-fold).",
                    "For five centuries, Islamic cities—Baghdad, Cordoba, Cairo, Fez, Bukhara, Nishapur—were the largest, most literate, street-lit metropolises on earth. Scholars codified the 4 Sunni Madhhabs, 6 Hadith collections, algebra, optics, clinical hospitals (Bīmāristāns), and universities (Al-Qarawiyyīn 859 CE, Al-Azhar 970 CE, Niẓāmiyyah 1065 CE).",
                    "Triggered the 'Islamic Green / Agricultural Revolution': through the law of Iḥyā' Al-Mawāt (anyone who irrigates dead land becomes its legal owner) and low 'Ushr/Kharāj rates, Muslim agronomists (Ibn Baṣṣāl, Ibn Al-'Awwām) diffused citrus, sugarcane, rice, cotton, paper, and hydraulic norias/qanats from China and India across Iraq, Egypt, Sicily, and Al-Andalus—while perpetual Waqf deeds made schools and hospitals financially independent of kings.",
                    "Demonstrated how secure property rights for land-revivers and tax-exempt Waqf endowments can sustain centuries of free education and healthcare.",
                    "#F59E0B"
            ),
            new QuranicExpansionTimelineEpoch(
                    7,
                    "EPOCH-07-SULTANIC-SHIELDS-AND-MONGOL-CONVERSION",
                    "1000–1450 CE (400–850 AH) • Anatolia, Levant, Egypt, Kipchak Steppe, Ilkhanid Persia, Mali & Delhi",
                    "7. The Age of Sultanates & The Miracle of Converting the Conquerors: Seljuks, Ayyubids, Mamluks, Mali & The Mongol Embrace",
                    "Qur'an 47:38 (Divine replacement with new defenders), Qur'an 8:60–61 (Preparedness paired with readiness for peace), & Qur'an 41:34 ('Repel evil with that which is better; and thereupon the one between whom and you was enmity will become as though he were a devoted friend').",
                    "When Crusaders invaded the Levant and Mongols razed Baghdad (1258 CE), Sunni Sultanates—Seljuks, Ayyubids (Ṣalāḥ ad-Dīn), and Mamluks (Quṭuz & Baybars)—defended the heartland while West African kingdoms (Ghana, Mali under Mansa Musa, Songhai) and the Delhi Sultanate flourished. Most remarkably, all three western Mongol Khanates (Golden Horde under Berke/Öz Beg, Ilkhanate under Ghazan Khan 1295, and Chagatai/Timurids) voluntarily converted to Islam.",
                    "Developed the Iqṭā' (non-hereditary military-administrative revenue assignment, regulated by Niẓām al-Mulk so soldiers could only collect the legal tax without owning the peasants or their land) alongside massive urban Waqf complexes (Külliyes and Khanqahs) in Cairo, Damascus, Tabriz, and Samarkand.",
                    "Proved that Islam's spiritual and legal beauty could absorb and civilize even the most devastating military conquerors in world history.",
                    "#22D3EE"
            ),
            new QuranicExpansionTimelineEpoch(
                    8,
                    "EPOCH-08-INDIAN-OCEAN-NUSANTARA-SWAHILI-SILK-ROADS",
                    "1200–1700 CE (600–1110 AH) • Indonesia, Malaysia, Brunei, Maldives, Swahili Coast, Bengal & Hui China",
                    "8. The Peaceful Oceanic & Caravan Expansion: Merchant Mīzān & Sufi Grace Across Nusantara, East Africa & China",
                    "Qur'an 16:14 & 45:12 ('It is Allah who subjected to you the sea so that ships may sail upon it by His command and that you may seek of His bounty'), Qur'an 17:35 ('Give full measure when you measure, and weigh with an even balance'), & Qur'an 16:125.",
                    "Without a single Middle Eastern army ever crossing the Bay of Bengal or the Mozambique Channel, Islam became the majority faith of the Malay-Indonesian Archipelago (Samudera Pasai, Malacca, Aceh, Demak, Mataram—today ~285M Muslims) and the Swahili Coast (Kilwa, Mombasa, Zanzibar, Comoros), while building vibrant communities in Bengal and China.",
                    "Introduced Islamic maritime commercial law (Qirāḍ / Muḍārabah venture partnerships where profit is shared and catastrophic sea-loss is not compounded by usury), port Waqf guest-houses, and Sultanic harbor codes (Undang-Undang Laut Melaka) that protected foreign merchants of every religion.",
                    "Confirmed that the largest demographic expansion of Islam in history occurred peacefully through ethical commerce, equitable contracts, and spiritual beauty.",
                    "#EC4899"
            ),
            new QuranicExpansionTimelineEpoch(
                    9,
                    "EPOCH-09-THREE-GUNPOWDER-EMPIRES-AND-COLONIAL-TRIAL",
                    "1453–1924 CE (857–1342 AH) • Ottoman Istanbul, Safavid Isfahan, Mughal Agra/Delhi & Sokoto West Africa",
                    "9. The Early Modern Imperial Zenith & The Colonial Shock: Tapu Tahrir, Fatawa 'Alamgiriyyah & Anti-Colonial Ribāṭ",
                    "Qur'an 3:140 ('And these days We alternate them among mankind'), Qur'an 3:26, & Qur'an 2:155 ('And We will surely test you with something of fear and hunger and a loss of wealth and lives and fruits, but give glad tidings to the patient').",
                    "At their 16th–17th century peak, the Ottoman Sultanate-Caliphate, Safavid Iran, and Mughal India governed from Budapest and Algiers to Dhaka and Aceh. Later, between 1757 and 1920, European colonial powers occupied nearly 90% of Muslim lands, dismantling traditional Waqf properties—yet scholars and Sufi orders ('Abd al-Qādir al-Jazā'irī, Imām Shāmil, 'Umar al-Mukhtār, Diponegoro, NU/Muhammadiyah) preserved the Ummah's moral autonomy.",
                    "Codified the most sophisticated land registries of the pre-modern world: the Ottoman Tapu Tahrir Defterleri (distinguishing Mīrī state-trust arable land, Mülk private urban/orchard property, and Vakıf endowments, later synthesized in the 1869–1876 Mecelle) and Mughal India's Zabt revenue system and Fatāwā 'Ālamgīriyyah.",
                    "Even when colonial regimes confiscated state treasuries, the family ethic and decentralized scholarship kept Islamic civilization intact for postcolonial rebirth.",
                    "#8B5CF6"
            ),
            new QuranicExpansionTimelineEpoch(
                    10,
                    "EPOCH-10-CONTEMPORARY-GLOBAL-UMMAH-AND-RENEWAL",
                    "1924 CE – 21st Century (1342–1448+ AH) • 57 OIC Sovereign States & Global Communities Across All 6 Inhabited Continents",
                    "10. The Universal Contemporary Horizon: 2 Billion Believers, Islamic Finance Revival, Green Waqf & The Promise of Iḥsān",
                    "Qur'an 41:53 ('We will show them Our signs in the horizons [Al-Āfāq] and within themselves until it becomes clear to them that it is the Truth'), Qur'an 15:9, & Sahih Muslim 2889 / 145.",
                    "Following decolonization, 57 Muslim-majority nations emerged alongside thriving indigenous and diaspora Muslim communities across Europe, North and South America, Sub-Saharan Africa, East Asia, and Oceania—growing from ~300 million in 1924 to ~2.0 billion today (~25% of humanity).",
                    "Revitalized canonical property institutions for the modern era: a $4+ trillion global Islamic finance and Sukuk ecosystem (replacing interest-bearing debt with asset-backed Muḍārabah, Mushārakah, and Ijārah), Cash Waqf and Green Waqf Sukuk (funding renewable energy, clean water, and sanitation in Indonesia, Malaysia, and the Gulf), and digital Qur'anic scholarship.",
                    "Completes the circle from Cave Ḥirā' to a planetary spiritual family bearing witness to Tawḥīd, 'Adl (justice), and Jamāl (beauty).",
                    "#10B981"
            )
    );

    private static final List<CanonicalPropertyAndLandCategory> SEVEN_CANONICAL_PROPERTY_CATEGORIES = List.of(
            new CanonicalPropertyAndLandCategory(
                    1,
                    "PROP-1-MILK-ALLAH-ISTIKHLAF",
                    "1. Ultimate Divine Ownership & Human Trusteeship (مِلْكُ اللَّهِ وَالاسْتِخْلَافُ — Milk Allāh wa Al-Istikhlāf)",
                    "Qur'an 7:128 ('Indeed, the earth belongs to Allah; He causes to inherit it whom He wills of His servants'), Qur'an 24:33 ('And give them from the wealth of Allah [Māl Allāh] which He has given you'), & Qur'an 57:7 ('Spend from that of which He has made you trustees [Mustakhlafīna fīhi]').",
                    "The foundational axiom of all Islamic property law: absolute ontological ownership (Al-Milk Al-Ḥaqīqī) of all land, minerals, water, and wealth belongs solely to Allah. Human beings—whether individuals, families, or kingdoms—hold derivative, fiduciary ownership (Milk Majāzī / Amānah) conditioned on lawful acquisition, productive use, zero harm (Lā Ḍarar wa Lā Ḍirār), and fulfillment of social rights.",
                    "Every form of property carries a spiritual and social covenant: hoarding idle wealth (Kanz, Qur'an 9:34), squandering resources in wasteful luxury (Isrāf wa Tabdhīr, Qur'an 17:26–27), or acquiring wealth through fraud and usury (Bāṭil wa Ribā, Qur'an 2:188, 2:275) is canonically unlawful.",
                    "prevented both Roman-style absolute owner despotism (ius abutendi—the right to destroy one's property) and totalitarian state communism across 1,400 years of Islamic jurisprudence.",
                    "Harmonizes robust private property incentives with ecological and social fiduciary responsibility.",
                    "#10B981"
            ),
            new CanonicalPropertyAndLandCategory(
                    2,
                    "PROP-2-ARD-AL-USHR",
                    "2. Tithe Land of Believers & Revived Estates (أَرْضُ العُشْرِ — Arḍ Al-'Ushr: Private Freehold Agricultural Property)",
                    "Qur'an 6:141 ('Eat of its fruit when it yields and give its due [Ḥaqqahu] on the day of its harvest'), Qur'an 2:267, & Sahih al-Bukhari 1483 ('On that which is watered by the sky and springs, a tenth ['Ushr = 10%]; and on that watered by irrigation camels/machinery, half of a tenth [Niṣf Al-'Ushr = 5%]').",
                    "Full private freehold agricultural land (Milk Tāmm) owned by Muslims, including: (a) lands whose inhabitants voluntarily embraced Islam (such as Medina, Yemen, Bahrain, Oman, Indonesia, Malaysia, and West Africa); and (b) barren lands revived (Iḥyā' Al-Mawāt) and irrigated by Muslim cultivators.",
                    "Assessed solely on actual harvested output (never on land value during drought or crop failure!): 10% ('Ushr) if rain-fed or naturally flooded, and only 5% (Niṣf Al-'Ushr) if the farmer invested capital and labor in artificial irrigation—distributed strictly to the 8 local Zakat categories (Qur'an 9:60).",
                    "Applied across the Arabian Peninsula, Nusantara (Indonesia/Malaysia), and newly irrigated estates in Al-Andalus and Khorasan, incentivizing farmers to build irrigation canals since doing so cut their tax rate in half (from 10% to 5%).",
                    "A supply-side agricultural tax that rewards capital investment in irrigation and automatically drops to zero during famine or drought.",
                    "#D4AF37"
            ),
            new CanonicalPropertyAndLandCategory(
                    3,
                    "PROP-3-ARD-AL-KHARAJ-FAY",
                    "3. Covenanted State-Trust Land (أَرْضُ الخَرَاجِ وَالفَيْءِ — Arḍ Al-Kharāj / Ottoman Arḍ Mīrī)",
                    "Qur'an 59:7–10 (Surah Al-Ḥashr: 'So that wealth may not become a circuit solely among the rich among you... And those who come after them'), & Caliph 'Umar ibn Al-Khaṭṭāb's historic Shūrā decision (Kitāb Al-Kharāj by Chief Justice Abū Yūsuf).",
                    "Arable lands in regions opened by treaty or military victory (such as the Sawād of Iraq, Syria, and the Nile Delta of Egypt). Under 'Umar's canonical ruling based on Qur'an 59:7–10, the underlying title (Raqabah) is held in perpetual trust for the entire Ummah, while permanent, inheritable usufruct possession (Taṣarruf) remains with the peasant cultivators (Muslim or non-Muslim alike).",
                    "Subject to Kharāj—an equitable annual land assessment (either proportional Kharāj Muqāsamah, e.g., 1/5 to 1/3 of harvest, or fixed Kharāj Waẓīfah scaled to soil fertility and crop type, remitted if floods or drought destroyed the crop). Proceeds go to the general Bayt Al-Māl for roads, irrigation canals, bridges, judicial salaries, and frontier defense.",
                    "Codified in Abū Yūsuf's Kitāb Al-Kharāj (written for Caliph Hārūn ar-Rashīd) and evolved into the Ottoman Mīrī land system (Tapu Tahrir), ensuring peasants could never be turned into European-style feudal serfs bound to a lord's manor.",
                    "Anticipated modern Georgist/public-trust land economics by over a millennium while guaranteeing hereditary security of tenure for working farmers.",
                    "#38BDF8"
            ),
            new CanonicalPropertyAndLandCategory(
                    4,
                    "PROP-4-AL-WAQF",
                    "4. Inalienable Perpetual Endowments (الوَقْفُ الخَيْرِيُّ وَالذُّرِّيُّ — Al-Waqf / Al-Ḥubs: The Third Sector of Civilization)",
                    "Qur'an 3:92 ('You will never attain righteousness until you spend from that which you love'), Sahih al-Bukhari 2737 & Sahih Muslim 1632 ('Umar's endowment of Thamgh in Khaybar: 'If you wish, immobilize its principal [Ḥabbasta aṣlahā] and give its fruits in charity—it shall neither be sold, nor gifted, nor inherited'), & Sahih Muslim 1631 (Ṣadaqah Jāriyah).",
                    "A voluntary, irrevocable legal act by which a property owner removes an income-producing asset (commercial bazaars, caravanserais, orchards, mills, bathhouses, apartments, or cash/Sukuk) from market circulation forever, dedicating its net revenue in perpetuity to a specified righteous purpose governed by the founder's charter (Shurūṭ Al-Wāqif, which jurists declared 'as binding as the text of the Lawgiver').",
                    "100% tax-exempt and legally immune from royal confiscation. Historically, by the 18th century, between one-third and one-half of all productive urban real estate and prime agricultural land in the Ottoman, Mamluk, Moroccan, and Mughal realms was held in Waqf.",
                    "Funded virtually the entire civil society of classical Islam without state taxes: Al-Qarawiyyīn, Al-Azhar, Niẓāmiyyah, and Süleymaniye universities (with free tuition, dormitories, and student stipends), Bīmāristān hospitals (treating rich and poor, Muslim and non-Muslim for free), public libraries, aqueducts (Sabils), bridges, orphanages, dowries for poor brides, and even endowments in Damascus and Fez for feeding stray cats and aging pack-animals.",
                    "The direct historical inspiration for the early Oxford and Cambridge college endowment statutes (such as Merton College, 1264 CE).",
                    "#A855F7"
            ),
            new CanonicalPropertyAndLandCategory(
                    5,
                    "PROP-5-IHYA-AL-MAWAT",
                    "5. Revival of Dead / Uncultivated Land (إِحْيَاءُ المَوَاتِ — Iḥyā' Al-Mawāt: Labor & Ecological Regeneration as Title)",
                    "Qur'an 36:33 ('And a sign for them is the dead earth: We brought it to life and brought forth from it grain...'), & Sunan Abī Dāwūd 3073 / Sunan at-Tirmidhī 1378 / Sahih al-Bukhari (Mu'allaq): 'Whoever revives dead land (Man aḥyā arḍan maytatan fahiya lahu), it belongs to him; and there is no right for the unjust sweat/encroachment ('Irq Ẓālim).'",
                    "Any unowned, barren, desert, marsh, or neglected land (Mawāt) outside the buffer zone of existing towns can be claimed by any person (Muslim or Dhimmī citizen according to major jurists) who invests actual labor to bring it to life—by digging a well or qanat canal, draining swamps, clearing stones, planting trees, or fencing and ploughing it.",
                    "If a person merely fences off land (Taḥjīr) to speculate on its price without cultivating it within three years, Caliph 'Umar's canonical rule strips their claim and grants it to someone who will actually work and green the land ('Laysa li-muḥtajir ḥaqq ba'da thalāth sinīn').",
                    "Drove the massive reclamation of desert and marshland in Abbasid Iraq, Khorasan, Valencia/Granada, and the Bengal Delta (where Sufi pioneers cleared jungle and built mosque-villages across modern Bangladesh).",
                    "Eliminates land-hoarding speculation while directly rewarding ecological restoration and food production with full private ownership.",
                    "#F43F5E"
            ),
            new CanonicalPropertyAndLandCategory(
                    6,
                    "PROP-6-AL-HIMA-HARIM-COMMONS",
                    "6. Ecological Sanctuaries, Buffer Zones & The Three Public Commons (الحِمَى وَالحَرِيمُ وَالمُشَاعُ — Al-Ḥimā, Al-Ḥarīm & Public Resources)",
                    "Sunan Abī Dāwūd 3477 & Musnad Aḥmad 23082: 'Muslims are partners in three things: water (Al-Mā'), pasture/forests (Al-Kalā'), and fire/energy (An-Nār).' | Sahih al-Bukhari 2370 ('There is no private reserve [Lā Ḥimā] except for Allah and His Messenger'—i.e., for public conservation and welfare).",
                    "Divides natural and environmental resources into: (1) Al-Mushā' (vital rivers, aquifers, pastures, and public energy/minerals which Malikis and other jurists hold belong to the public treasury and cannot be monopolized to gouge the public); (2) Al-Ḥarīm (mandatory protective buffer zones around wells, springs, rivers, and villages where building is forbidden to prevent water pollution or depletion); and (3) Al-Ḥimā (protected biodiversity and grazing reserves where tree-cutting or hunting is restricted).",
                    "Zero private toll on natural river water; public mineral royalties (Rikāz / Ma'ādin, assessed at Khums = 20% or Zakat) flow into Bayt Al-Māl for public infrastructure and social welfare.",
                    "The Prophet ﷺ established the Ḥimā of An-Naqī' near Medina as a protected conservation zone, and preserved the Harams of Mecca and Medina where native trees cannot be cut and wildlife cannot be hunted—the world's oldest continuously enforced environmental conservation zones.",
                    "Provides a 1,400-year-old canonical legal framework for modern watershed protection, anti-monopoly utility regulation, and national conservation parks.",
                    "#F59E0B"
            ),
            new CanonicalPropertyAndLandCategory(
                    7,
                    "PROP-7-MILK-FARDI-MIRATH",
                    "7. Inviolable Private Property, Ethical Contracts & Fixed Qur'anic Inheritance (المِلْكُ الفَرْدِيُّ المَعْصُومُ وَالمِيرَاثُ — Al-Milk Al-Khāṣṣ & 'Ilm Al-Farā'iḍ)",
                    "Qur'an 2:188 ('Do not consume one another's wealth unjustly'), Qur'an 4:29 ('Except by trade conducted through mutual consent ['an tarāḍin minkum]'), Qur'an 4:7–12 (Fixed inheritance shares for women and men), Sahih al-Bukhari 67 ('Your blood, your properties, and your honors are sacred'), & Sahih Muslim 141 ('Whoever is killed defending his property is a martyr [Shahīd]').",
                    "Every adult man and woman possesses full, independent legal personality (Dhimma Māliyyah Mustaqillah) to own, buy, sell, invest, and endow private property. A married Muslim woman retains 100% of her maiden name, her dowry (Mahr, Qur'an 4:4), her earnings, and her real estate without her husband having any legal claim over a single coin unless she gifts it voluntarily.",
                    "Subject to 2.5% annual Zakat on liquid savings/gold/trade inventory held above the Niṣāb threshold for one lunar year, and upon death, distributed across the family via Qur'an 4:7–12 ('Ilm Al-Farā'iḍ—which inspired Al-Khwārizmī to write the first book of Algebra to calculate inheritance fractions!).",
                    "Prevented primogeniture (where only the eldest son inherits everything, creating aristocratic oligarchies in feudal Europe) by automatically circulating capital across sons, daughters, wives, mothers, and fathers in every generation.",
                    "Granted women full independent property and contract rights in 622 CE—more than 1,200 years before the British Married Women's Property Act of 1882.",
                    "#22D3EE"
            )
    );

    private static final List<CountriesAndKingdomsClime> SEVEN_COUNTRIES_AND_KINGDOMS_CLIMES = List.of(
            new CountriesAndKingdomsClime(
                    1,
                    "CLIME-1-JAZIRAT-AL-ARAB",
                    "1. Iqlīm Jazīrat Al-'Arab: The Sacred Cradle & Maritime Kingdoms of Arabia (Saudi Arabia, Yemen, Oman, UAE, Qatar, Bahrain, Kuwait)",
                    "Prophetic Commonwealth of Medina, Rāshidūn Heartland, Rasulid & Tahirid Kingdoms of Yemen (Zabid/Ta'izz/Sana'a), Ya'rubid & Al-Busaidi Imamate/Sultanate of Oman, Sharifate of Mecca, and Modern Gulf States.",
                    "Al-Masjid Al-Ḥarām (Mecca), Al-Masjid An-Nabawī (Medina), Old Walled City of Sana'a, Shibam Hadramawt ('Manhattan of the Desert'), Nizwa Fort (Oman), and Zubaydah's 1,500-km Pilgrim Water Route (Darb Zubaydah).",
                    "Pure 'Ushr land (never subject to Kharāj); home to the Prophet's seven charitable orchards of Medina, 'Uthmān's Well of Rūmah, Queen Arwā's Waqf schools in Yemen, Oman's UNESCO Aflāj underground irrigation channels (shared by precise water-clock time-shares), and modern Sovereign Wealth & Haramayn Waqf Towers.",
                    "Al-Hamdānī's Ṣifat Jazīrat Al-'Arab, Al-Muqaddasī's Aḥsan At-Taqāsīm, and Yāqūt Al-Ḥamawī's Mu'jam Al-Buldān.",
                    "#10B981"
            ),
            new CountriesAndKingdomsClime(
                    2,
                    "CLIME-2-SHAM-IRAQ-MISR",
                    "2. Iqlīm Ash-Shām, Al-'Irāq wa Miṣr: The Fertile Crescent & Nile Kingdoms (Syria, Palestine, Jordan, Lebanon, Iraq, Egypt, Sudan)",
                    "Umayyad Caliphate of Damascus, Abbasid Caliphate of Baghdad, Tulunid/Fatimid/Ayyubid/Mamluk Sultanates of Cairo & Damascus, Hamdanids of Aleppo, and Funj Sultanate of Sennar (Sudan).",
                    "Al-Masjid Al-Aqṣā & Dome of the Rock (Jerusalem), Umayyad Mosque & Bīmāristān Nūrī (Damascus), Round City & Mustanṣiriyyah Madrasah (Baghdad), Al-Azhar & Sultan Qalāwūn Complex (Cairo), and Citadel of Aleppo.",
                    "Model heartland of 'Umar's Arḍ Al-Kharāj covenant, the Nile Nilometer (Miqyās An-Nīl) on Roda Island (determining fair harvest assessment), and the Mamluk/Ayyubid Waqf endowments that funded free hospitals, universities, and Jerusalem's soup kitchens (Takiyyat Khāṣṣakī Sulṭān, operating since 1552 CE).",
                    "Al-Balādhurī's Futūḥ Al-Buldān, Abū Yūsuf's Kitāb Al-Kharāj, Al-Maqrīzī's Al-Khiṭaṭ (Egypt), and Ibn 'Asākir's Tārīkh Dimashq.",
                    "#D4AF37"
            ),
            new CountriesAndKingdomsClime(
                    3,
                    "CLIME-3-MAGHREB-ANDALUS-SUDAN",
                    "3. Iqlīm Al-Maghrib, Al-Andalus wa Bilād As-Sūdān: Western Islamdom & West African Gold Kingdoms (Morocco, Algeria, Tunisia, Libya, Mauritania, Spain/Portugal, Mali, Songhai, Senegal, Niger, Nigeria)",
                    "Umayyad Caliphate of Cordoba, Idrisid/Almoravid/Almohad/Marinid/Saadian/'Alawite Kingdoms of Morocco, Hafsids of Tunis, Zayyanids of Tlemcen, Empire of Mali (Mansa Musa), Songhai Empire (Askia Muhammad), Kanem-Bornu, and Sokoto Caliphate ('Uthmān dan Fodio).",
                    "Great Mosque of Cordoba & Alhambra of Granada, Al-Qarawiyyīn in Fez, Kutubiyya in Marrakesh, Great Mosque of Kairouan, Sankore & Djinguereber Mosques of Timbuktu, and Great Mosque of Djenné.",
                    "Renowned for the Andalusian hydraulic Tribunal de las Aguas (Valencia's water court inherited from Islamic irrigation law), Moroccan Habous (Awqāf) ministries preserving entire historic medinas, and West African Wangara gold-salt trade networks governed by Maliki contract law.",
                    "Al-Idrīsī's Nuzhat Al-Mushtāq (Tabula Rogeriana, 1154 CE), Ibn Khaldūn's Kitāb Al-'Ibar, Al-Bakrī's المسالك والممالك, and As-Sa'dī's Tārīkh As-Sūdān.",
                    "#38BDF8"
            ),
            new CountriesAndKingdomsClime(
                    4,
                    "CLIME-4-RUM-BALKANS-CAUCASUS",
                    "4. Iqlīm Ar-Rūm, Al-Balqān wa Al-Qawqāz: Anatolian, Balkan & Caucasian Realms (Türkiye, Bosnia, Albania, Kosovo, Azerbaijan, Dagestan, Chechnya, Crimea)",
                    "Sultanate of Rūm (Seljuks of Konya), Beyliks of Anatolia, Ottoman Empire (Ad-Dawlah Al-'Uthmāniyyah), Crimean Khanate, Shirvanshahs of Baku, and Caucasian Imamate.",
                    "Süleymaniye & Sultanahmet Mosques (Istanbul), Selimiye Mosque in Edirne (Mimar Sinan), Alaeddin Mosque & Mevlana Complex (Konya), Gazi Husrev-beg Complex & Stari Most Bridge (Mostar/Sarajevo, Bosnia), and Palace of the Shirvanshahs (Baku).",
                    "Perfected the Ottoman Külliye (an integrated urban Waqf ecosystem combining mosque, medical college, hospital, library, astronomical clock-room, caravanserai, public bath, and Imaret free kitchen), Cash Waqf (Vakıf Para) micro-credit, and the Tapu Tahrir Mīrī land code.",
                    "Evliya Çelebi's 10-volume Seyahatnâme, Kâtib Çelebi's Cihannümâ, and the Ottoman Tapu Tahrir & Mecelle-i Ahkâm-ı Adliyye.",
                    "#A855F7"
            ),
            new CountriesAndKingdomsClime(
                    5,
                    "CLIME-5-FARIS-MA-WARA-AN-NAHR",
                    "5. Iqlīm Fāris, Khurāsān wa Mā Warā' An-Nahr: Persianate & Central Asian Silk Road Kingdoms (Iran, Uzbekistan, Kazakhstan, Turkmenistan, Tajikistan, Kyrgyzstan, Afghanistan)",
                    "Samanids of Bukhara, Ghaznavids, Great Seljuks, Khwarazmshahs, Converted Golden Horde & Ilkhanate, Timurid Empire (Samarkand & Herat), Khanates of Bukhara/Khiva/Kokand, and Safavid/Qajar Kingdoms of Iran.",
                    "Registan Square, Shah-i-Zinda & Ulugh Beg Observatory (Samarkand), Po-i-Kalyan Ensemble (Bukhara), Gawhar Shad Mosque (Mashhad/Herat), Minaret of Jam (Afghanistan), and Naqsh-e Jahan Square / Shah Mosque (Isfahan).",
                    "Engineered the subterranean Qanāt (Kārīz) water-channel property network stretching thousands of kilometers across arid plateaus (protected by strict Ḥarīm buffer laws) and Silk Road Ribāṭ/Caravanserai Waqf endowments spaced one day's caravan journey apart.",
                    "Al-Iṣṭakhrī's Al-Masālik wa Al-Mamālik, Ibn Ḥawqal's Ṣūrat Al-Arḍ, Al-Bīrūnī's Al-Qānūn Al-Mas'ūdī, and Niẓām al-Mulk's Siyāsatnāmah.",
                    "#F43F5E"
            ),
            new CountriesAndKingdomsClime(
                    6,
                    "CLIME-6-AL-HIND-WA-AS-SIND",
                    "6. Iqlīm Al-Hind, As-Sind wa Al-Bangāl: South Asian Sultanates & Mughal Badshahi (Pakistan, India, Bangladesh, Maldives)",
                    "Habbarid Emirate of Sindh, Delhi Sultanates (Mamluk, Khalji, Tughlaq, Sayyid, Lodi), Bengal Sultanate (Shāhī Bangālah), Deccan Sultanates (Bahmani, Golconda, Bijapur), Mysore (Tipu Sultan), Mughal Empire (1526–1857), and Maldivian Islamic Sultanate (since 1153 CE).",
                    "Badshahi Mosque & Shalimar Gardens (Lahore), Shah Jahan Mosque (Thatta), Qutb Minar, Jama Masjid & Red Fort (Delhi), Taj Mahal (Agra), Sixty Dome Mosque of Bagerhat (Bangladesh), Gol Gumbaz (Bijapur), and Hukuru Miskiy Coral Mosque (Maldives).",
                    "Synthesized Hanafi Kharāj/Ushr jurisprudence in the 30-volume Fatāwā 'Ālamgīriyyah, Todar Mal's Zabt agrarian survey, Madad-i-Ma'āsh tax-free scholarly endowments, and the Sufi-led Iḥyā' Al-Mawāt clearing and rice-cultivation of the East Bengal river delta.",
                    "Al-Bīrūnī's Kitāb Al-Hind, Abu'l-Fazl's Ā'īn-i Akbarī, Ferishta's Tārīkh-i Firishta, and Shāh Walīullāh's Ḥujjat Allāh Al-Bālighah.",
                    "#F59E0B"
            ),
            new CountriesAndKingdomsClime(
                    7,
                    "CLIME-7-NUSANTARA-SWAHILI-OCEANIC",
                    "7. Iqlīm Al-Jāwah (Nusantara) wa Bilād Az-Zanj: Maritime Archipelago & Indian Ocean Rim (Indonesia, Malaysia, Brunei, Southern Thailand/Philippines, Somalia, Djibouti, Comoros, Zanzibar/Swahili Coast)",
                    "Sultanates of Samudera Pasai, Malacca, Aceh Darussalam, Demak, Banten, Mataram, Yogyakarta, Ternate/Tidore, Gowa-Tallo, Johor, Kedah, Brunei Darussalam; and in East Africa: Sultanates of Adal/Ifat (Zeila/Harar), Mogadishu, Kilwa, Pate, Comoros & Zanzibar.",
                    "Masjid Agung Demak & Menara Kudus (Java), Baiturrahman Grand Mosque (Aceh), Istiqlal Mosque (Jakarta), Sultan Omar Ali Saifuddien Mosque (Brunei), Old Stone Town & Kilwa Kisiwani (Tanzania), and the 82 Mosques of Walled Harar.",
                    "Pioneered maritime Muḍārabah trade law, Javanese Perdikan / Tanah Wakaf tax-exempt Pesantren villages, Minangkabau Adat-Syarak matrilineal ancestral trust harmony ('Adat basandi Syarak, Syarak basandi Kitabullah'), and modern Sovereign Green & Cash Waqf Sukuk.",
                    "Ibn Baṭṭūṭah's Riḥlah (visiting Mogadishu, Kilwa, Maldives & Sumatra), Aḥmad ibn Mājid's Kitāb Al-Fawā'id (Indian Ocean navigation), Bustān As-Salāṭīn (Aceh), and Sejarah Melayu.",
                    "#22D3EE"
            )
    );

    private static final List<BeautyOfIslamDimension> SEVEN_BEAUTY_OF_ISLAM_DIMENSIONS = List.of(
            new BeautyOfIslamDimension(
                    1,
                    "BEAUTY-1-TAWHID-ASMA-HUSNA",
                    "1. Ontological & Theological Beauty: Allah Is Beautiful and Loves Beauty (جَمَالُ التَّوْحِيدِ وَالأَسْمَاءِ الحُسْنَى)",
                    "Sahih Muslim 91: 'Indeed, Allah is Beautiful and He loves beauty (Inna Allāha Jamīlun yuḥibbu al-jamāl).' | Qur'an 7:180: 'And to Allah belong the Most Beautiful Names (Al-Asmā' Al-Ḥusnā), so call upon Him by them.' | Qur'an 24:35 ('Allah is the Light of the heavens and the earth').",
                    "In Islamic metaphysics (expounded by Al-Ghazālī in Al-Maqṣad Al-Asnā and Kitāb Al-Maḥabbah, Ibn 'Arabī, and Ibn Al-Qayyim in Rawḍat Al-Muḥibbīn), Beauty (Al-Jamāl) is not a superficial cosmetic ornament; it is an essential attribute of the Divine Reality. Allah's Names are divided into Attributes of Majesty (Jalāl) and Attributes of Beauty (Jamāl—Ar-Raḥmān, Ar-Raḥīm, Al-Wadūd [The Loving], Al-Laṭīf [The Subtle/Gentle], As-Salām [Peace], Al-Jamīl [The Beautiful]), and as the Hadith in Sahih al-Bukhari 3194 declares: 'My Mercy prevails over My Wrath.'",
                    "Liberates the human soul from superstitious dread of capricious gods or chaotic nature, anchoring human existence in direct, unmediated intimacy with the All-Merciful Creator.",
                    "For the universal reader, Tawḥīd unifies all reality into a single coherent, meaningful cosmos where truth (Al-Ḥaqq), goodness (Al-Khayr), and beauty (Al-Jamāl) are one.",
                    "#10B981"
            ),
            new BeautyOfIslamDimension(
                    2,
                    "BEAUTY-2-IJAZ-AL-QURAN",
                    "2. Scriptural, Acoustic & Literary Beauty: The Inimitable Symphony of the Qur'an (جَمَالُ القُرْآنِ وَالإِعْجَازِ البَيَانِيِّ)",
                    "Qur'an 39:23 ('Allah has sent down the Most Beautiful Discourse [Aḥsana Al-Ḥadīth], a Book of harmonious, oft-repeated pairs'), Qur'an 17:88, & Qur'an 55:1–4 ('The Most Merciful — taught the Qur'an, created the human being, taught him articulate expression [Al-Bayān]').",
                    "Unlike pure prose or metrical poetry, the Qur'an possesses a unique acoustic and rhetorical architecture (Naẓm, analyzed by Al-Jurjānī in Dalā'il Al-I'jāz and Al-Bāqillānī). Its cadence—governed by the science of Tajwīd (nasalization, elongation, phonetic articulation points)—moves even listeners who do not yet know Arabic to tears (Qur'an 5:83), while its ring-composition (studied in modern times by Raymond Farrin and Michel Cuypers) mirrors the concentric geometry of a rose or star.",
                    "Gave birth to the art of Qur'anic recitation (Tilāwah across the 7/10 canonical Qirā'āt) and the geometric science of Arabic Calligraphy (Kufic, Thuluth, Naskh, Nasta'līq, Maghribī, Diwani), turning the visible word of God into the supreme visual motif of Islamic civilization.",
                    "Demonstrates how revelation addresses both the analytical intellect (through rational signs, Āyāt) and the aesthetic heart (through acoustic harmony).",
                    "#D4AF37"
            ),
            new BeautyOfIslamDimension(
                    3,
                    "BEAUTY-3-MAQAM-AL-IHSAN",
                    "3. Spiritual & Devotional Beauty: Al-Iḥsān — Worshipping Allah as Though You See Him (جَمَالُ الإِحْسَانِ وَالعِبَادَةِ)",
                    "Sahih Muslim 8 / Sahih al-Bukhari 50 (Hadith of Jibrīl): 'What is Al-Iḥsān? He ﷺ said: That you worship Allah as though you see Him; and if you do not see Him, indeed He sees you.' | Qur'an 2:112, 29:45, & 13:28 ('Unquestionably, by the remembrance of Allah do hearts find rest').",
                    "In Arabic etymology, 'Iḥsān' derives from 'Ḥusn' (Beauty and Excellence). Thus the highest station of Islam is literally 'Making Everything Beautiful and Excellent.' The five daily prayers (Ṣalāh) punctuate the day from dawn (Fajr) to starlight ('Ishā'), washing the body in living water (Wuḍū') and aligning millions of human beings in concentric circles around the Ka'bah like planets orbiting a spiritual sun.",
                    "Produces inner tranquility (Sakīnah wa Iṭmi'nān), self-mastery during Ramadan fasting (Ṣawm), and the breathtaking spectacle of the Hajj in Mecca—where monarchs and laborers wear the exact same two unstitched white cloths of Iḥrām, erasing race, class, and caste.",
                    "As Malcolm X (El-Hajj Malik El-Shabazz) testified from Mecca in 1964, the ritual beauty of Islam provides a tangible, lived cure for racism and human alienation.",
                    "#38BDF8"
            ),
            new BeautyOfIslamDimension(
                    4,
                    "BEAUTY-4-MAKARIM-AL-AKHLAQ",
                    "4. Moral & Interpersonal Beauty: Beautiful Patience, Beautiful Forgiveness & Gracious Parting (جَمَالُ الأَخْلَاقِ: الصَّبْرُ الجَمِيلُ وَالصَّفْحُ الجَمِيلُ)",
                    "Qur'an 12:18 & 12:83 ('Fa-ṣabrun jamīl' — 'So beautiful patience!'), Qur'an 15:85 ('Fa-ṣfaḥi aṣ-ṣafḥa al-jamīl' — 'So forgive with a beautiful forgiveness'), Qur'an 73:10 ('Wa-hjurhum hajran jamīlā' — 'And part from them with a beautiful parting'), Qur'an 33:28 (Sarāḥan Jamīlā), & Muwaṭṭa' Mālik / Musnad Aḥmad 8952 ('I was sent only to perfect noble traits of character').",
                    "Remarkably, whenever the Qur'an uses the adjective 'Jamīl' (Beautiful) for human conduct, it applies it to the hardest moments of human friction: (1) Ṣabr Jamīl—patience without bitter complaining when struck by grief; (2) Ṣafḥ Jamīl—forgiveness without reproach or humiliation when wronged; (3) Hijr Jamīl—stepping away from toxic hostility without vulgarity; and (4) Sarāḥ Jamīl—if a marriage must end, releasing one's spouse with generosity and dignity.",
                    "Manifested historically when the Prophet ﷺ entered Mecca victorious in 630 CE and told his former persecutors: 'No blame upon you today; go, for you are free' (Qur'an 12:92); when 'Umar protected Jerusalem's churches in 637 CE; when Ṣalāḥ ad-Dīn ransomed Frankish captives from his own pocket in 1187 CE; and when Emir 'Abd al-Qādir saved thousands of Christians in Damascus in 1860 CE.",
                    "Reveals that in Islam, moral beauty is tested and proven precisely in how one treats the vulnerable, the stranger, and the former adversary.",
                    "#A855F7"
            ),
            new BeautyOfIslamDimension(
                    5,
                    "BEAUTY-5-UMRAN-ARCHITECTURE-GEOMETRY",
                    "5. Architectural, Geometric & Botanical Beauty: Sacred Space as Consolidated Light (جَمَالُ العُمْرَانِ وَالهَنْدَسَةِ وَالرِّيَاضِ)",
                    "Qur'an 24:35–36 ('In houses which Allah has permitted to be raised and that His Name be mentioned therein'), Qur'an 54:49 ('Indeed, We created all things in precise measure/proportion [bi-Qadar]'), & Qur'an 47:15 (The Garden and its Four Rivers).",
                    "Because Islam rejected anthropomorphic idol-statues, Muslim mathematicians, architects, and artisans channeled creative genius into three universal languages of pure beauty: (1) Calligraphic Epigraphy (inscribing divine wisdom onto stone, tile, and parchment); (2) Infinite Geometric Tessellations (Girih stars and Muqarnas honeycombs symbolizing unity in multiplicity); and (3) Biomorphic Arabesque (Islīmī vine scrolls and Chahār Bāgh four-river courtyard gardens).",
                    "Created timeless sanctuaries—the Alhambra of Granada, the Mezquita of Cordoba, the Courtyard of Al-Qarawiyyīn, the Shah Mosque of Isfahan, the Süleymaniye of Istanbul, the Registan of Samarkand, and the Taj Mahal—where flowing water, shaded courtyards, natural cross-ventilation, and acoustic domes turn brick and stone into weightless light.",
                    "Islamic architecture never crushes the human visitor beneath totalitarian monumentality; instead, it wraps the soul in courtyard serenity, courtyard fountains, and contemplative geometry.",
                    "#F43F5E"
            ),
            new BeautyOfIslamDimension(
                    6,
                    "BEAUTY-6-ADL-WA-TAKAFUL",
                    "6. Social, Legal & Economic Beauty: The Symmetry of Justice (Al-Mīzān) & Mutual Care (جَمَالُ العَدْلِ وَالتَّكَافُلِ الاجْتِمَاعِيِّ)",
                    "Qur'an 16:90 ('Indeed, Allah orders justice [Al-'Adl] and beauty/excellence [Al-Iḥsān] and giving to relatives, and forbids immorality, bad conduct, and oppression'), Qur'an 55:7–9 ('And the heaven He raised and set up the Balance [Al-Mīzān]'), & Sahih Muslim 2586 ('The believers in their mutual kindness, compassion, and sympathy are like one body').",
                    "Islam views justice ('Adl) as moral symmetry and beauty (Iḥsān) as generosity beyond strict legal obligation. In law, this produced the 5 Universal Maqāṣid Ash-Sharī'ah (Preservation of Faith, Life, Intellect, Lineage/Family, and Property/Dignity) codified by Al-Ghazālī and Ash-Shāṭibī. In economics, it paired the prohibition of predatory usury (Ribā) with mandatory Zakat, Waqf public goods, and Qard Ḥasan ('Beautiful Loan' without interest, Qur'an 2:245).",
                    "Built cities where a traveler from Morocco (like Ibn Baṭṭūṭah) could journey 73,000 miles to Cairo, Damascus, Mecca, Delhi, the Maldives, Sumatra, and China, finding free lodging in Waqf Zāwiyahs, recognizable legal courts, and brothers and sisters in faith in every land.",
                    "Offers a third way beyond ruthless predatory capitalism and coercive state collectivism: free market enterprise anchored in risk-sharing and perpetual philanthropic endowments.",
                    "#F59E0B"
            ),
            new BeautyOfIslamDimension(
                    7,
                    "BEAUTY-7-COSMIC-ECOLOGICAL-HARMONY",
                    "7. Cosmic, Scientific & Ecological Beauty: Reading the Book of the Universe (جَمَالُ الكَوْنِ وَالعِلْمِ وَالفَلَاحِ البِيئِيِّ)",
                    "Qur'an 50:6 ('Have they not looked at the heaven above them—how We structured it and adorned it [wa zayyannāhā], and it has no rifts?'), Qur'an 16:6 ('And for you in them is beauty [Jamāl] when you bring them in for the evening and when you send them out to pasture'), Qur'an 67:3–4, & Musnad Aḥmad 12902 (Planting a sapling even if the Final Hour arrives).",
                    "In the Qur'an, both a verse of scripture and a phenomenon of nature (a bee, a star, rain, embryology, mountain strata) are called by the exact same word: 'Āyah' (a Sign pointing to the Creator). Therefore, studying astronomy, optics, medicine, botany, and mathematics was never a rebellion against religion in Islam—it was an act of worship (Tafakkur, Qur'an 3:190–191) reading Allah's cosmic artistry.",
                    "Inspired Ibn Al-Haytham to found experimental optics by studying the beauty of light (Kitāb Al-Manāẓir), Al-Bīrūnī to measure the earth's radius to within 1% accuracy, Al-Jazarī to engineer water-clocks, and Muslim physicians to treat mental illness with music, fountain sounds, and rose gardens in Bīmāristāns.",
                    "Heals the modern divorce between science and spirituality by showing that empirical rigor and reverent wonder are twin wings of human understanding.",
                    "#22D3EE"
            )
    );

    private static final List<CollegiateThesisChapter> EIGHT_COLLEGIATE_THESIS_CHAPTERS = List.of(
            new CollegiateThesisChapter(
                    1,
                    "CH-1-ABSTRACT-ONTOLOGY",
                    "Chapter I. Prolegomenon & Thesis Statement: The Ontological Architecture of Islamic Civilization",
                    "«إِنَّ اللَّهَ جَمِيلٌ يُحِبُّ الْجَمَالَ» — 'Indeed, Allah is Beautiful and He loves beauty.' (Sahih Muslim 91) | «وَلِلَّهِ مِيرَاثُ السَّمَاوَاتِ وَالْأَرْضِ» — 'And to Allah belongs the heritage of the heavens and the earth.' (Qur'an 3:180)",
                    "CENTRAL THESIS: The fourteen-century expansion and endurance of Islam across seventy countries and seven civilizational zones cannot be explained by the Weberian reduction of Islam to a 'warrior religion' nor by Eurocentric models of dynastic empire; rather, Islam expanded and endured because it instantiated a self-renewing triad of (1) Scriptural-Temporal Continuity (The Qur'anic Timeline), (2) Equitable Fiduciary Property & Waqf Civil Society (Al-Istikhlāf wa Al-Amwāl), and (3) Aesthetic-Moral Wholeness (Jamāl Al-Islām wa Al-Iḥsān).",
                    "Across modern university curricula, the history of Islamic civilization is frequently fragmented into disconnected disciplinary silos: political historians trace the rise and fall of Caliphates and Sultanates; legal scholars examine Sharia courts; art historians admire the Alhambra or the Taj Mahal; and theologians study the Qur'an in isolation from economic and institutional geography. Yet when examined through its own canonical primary sources—the Qur'an, the Prophetic Sunnah, the legal treatises of Abū Yūsuf, Al-Māwardī, Al-Ghazālī, and Ash-Shāṭibī, the geographical compendia of Al-Muqaddasī and Al-Idrīsī, and the historical sociology of Ibn Khaldūn—Islamic civilization reveals an integrated, organic architecture. At the center of this architecture stands Tawḥīd: the conviction that the One Creator who ordered the cosmos in mathematical proportion (bi-Qadar, Qur'an 54:49) also revealed an ethical criterion (Al-Furqān) to harmonize human society.",
                    "Crucially, Islam distinguishes between the eternal foundation (Ad-Dīn—anchored in the verbatim Qur'an and Prophetic Sunnah) and the contingent political vessel (Ad-Dawlah—whether Caliphate, Sultanate, or Shahdom). As Imām Al-Ghazālī formulated in Iḥyā' 'Ulūm Ad-Dīn, religion is the foundation (Al-Uss) and political power is the guard (Al-Ḥāris). Because the foundation was never owned by a priesthood or a mortal throne, when individual kingdoms dissolved under Ibn Khaldūn's four-generation cycle of dynastic senescence, the civilization's legal, educational, economic, and aesthetic institutions survived intact and frequently converted the very conquerors who had toppled the palace.",
                    "For collegiate and universal understanding, this monograph demonstrates how the Qur'anic timeline of expansion, the canonical jurisprudence of property and land tenure (Fiqh Al-Amwāl), the diversity of Muslim countries and kingdoms across the seven climes, and the seven dimensions of Islamic beauty (Jamāl Al-Islām) operate as a single unified equation of human flourishing.",
                    "Seminar Question 1: How does Al-Ghazālī's distinction between Ad-Dīn (the foundation) and As-Sulṭān (the guard), combined with Wael Hallaq's analysis of Sharia autonomy, explain why Islamic civilization survived the 1258 Mongol destruction of Baghdad while centralized imperial ideologies collapsed with their capitals?"
            ),
            new CollegiateThesisChapter(
                    2,
                    "CH-2-QURANIC-TEMPORALITY-EXPANSION",
                    "Chapter II. The Qur'anic Philosophy of Time & The 23-Year Prophetic Matrix of Expansion",
                    "«وَأَنزَلْنَا إِلَيْكَ الذِّكْرَ لِتُبَيِّنَ لِلنَّاسِ مَا نُزِّلَ إِلَيْهِمْ» — 'And We sent down to you the Reminder that you may make clear to mankind what was sent down to them.' (Qur'an 16:44) | «إِنَّا فَتَحْنَا لَكَ فَتْحًا مُّبِينًا» — 'Indeed, We have given you a clear opening (Fatḥan Mubīnan).' (Qur'an 48:1)",
                    "PROPOSITION II: In the Qur'an, expansion is canonically named 'Al-Fatḥ' ('The Opening'—from the root F-T-Ḥ, to unlock a closed door to light and conscience), never 'imperial subjugation,' and its archetype in Surah Al-Fatḥ (48:1) was not a military siege, but the peaceful Truce of Al-Ḥudaybiyyah.",
                    "A rigorous philological reading of the Qur'anic timeline reveals a profound shift in how human history is conceptualized. First, the Qur'an anchors Muhammad's mission (610–632 CE) within a macro-historical continuum extending back to the Primordial Covenant of Alast (7:172) and Abraham's construction of the Ka'bah (2:127). During the thirteen Meccan years (610–622 CE), while the Muslim community possessed zero military force and zero state territory, the Qur'an accomplished the hardest expansion of all: the expansion of the human moral imagination—abolishing tribal blood-aristocracy, condemning female infanticide (81:8–9), mandating commercial honesty (83:1–3), and sending refugees to Christian Abyssinia (615 CE) where Surah Maryam (19:1–36) established interfaith kinship.",
                    "Second, following the Hijrah to Medina (622 CE), the Qur'anic revelations accompanied the formation of a multi-religious constitutional polity (Ṣaḥīfat Al-Madīnah). When Quraysh waged economic and military war against Medina (Badr in 2 AH, Uḥud in 3 AH, the Trench in 5 AH), the Qur'an legislated strict rules of defensive engagement (2:190: 'Do not transgress limits'). Yet the decisive turning point of the Prophetic timeline came in 6 AH (628 CE) at Al-Ḥudaybiyyah, where the Prophet ﷺ signed a ten-year non-aggression treaty that appeared on the surface to concede to Meccan demands. On the return journey, Surah Al-Fatḥ (48:1) was revealed, naming that peace treaty 'Fatḥan Mubīnan' (a Clear Opening/Victory). As the classical historian Az-Zuhrī recorded, once war ceased and people mingled freely in safety to hear the Qur'an and observe Muslim character, more Arabs entered Islam peacefully in the two years after Ḥudaybiyyah than in the previous nineteen years combined.",
                    "Consequently, when Mecca opened bloodlessly in 8 AH (630 CE) with the Prophet's universal amnesty ('Go, for you are free'), and delegations (Wufūd) arrived from across Arabia through 10 AH (Surah An-Naṣr 110:1–3), the canonical paradigm of Islamic expansion was sealed: military force was solely to remove tyrannical barriers to conscience, whereas conversion itself was governed eternally by Qur'an 2:256 ('There shall be no compulsion in religion').",
                    "Seminar Question 2: Why did the Qur'an designate the Peace Treaty of Al-Ḥudaybiyyah (628 CE)—rather than the Battle of Badr or the conquest of Khaybar—as the supreme 'Clear Opening' (Fatḥan Mubīnan) in Surah Al-Fatḥ 48:1?"
            ),
            new CollegiateThesisChapter(
                    3,
                    "CH-3-FIQH-AL-AMWAL-PROPERTY",
                    "Chapter III. Canonical Islamic Property Law (Fiqh Al-Amwāl): Between Divine Trusteeship, Private Freehold & The Commons",
                    "«لِّلَّهِ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ» — 'To Allah belongs whatever is in the heavens and whatever is in the earth.' (Qur'an 2:284) | «كَيْ لَا يَكُونَ دُولَةً بَيْنَ الْأَغْنِيَاءِ مِنكُمْ» — 'So that wealth may not become a perpetual circuit solely among the rich among you.' (Qur'an 59:7)",
                    "PROPOSITION III: Classical Islamic jurisprudence engineered a four-pillar property regime—combining inviolable private ownership (Milk Khāṣṣ), state-trust agrarian equity (Arḍ Al-Kharāj), ecological commons (Al-Ḥimā wa Al-Mushā'), and productive land revival (Iḥyā' Al-Mawāt)—that prevented both feudal serfdom and speculative land monopoly.",
                    "In comparative legal history, ancient Roman law defined ownership as 'dominium'—the absolute right to use, enjoy, and even abuse or destroy an object (ius utendi, fruendi, et abutendi)—while modern collectivist systems abolished private property in favor of state monopoly. Islamic jurisprudence (Fiqh Al-Mu'āmalāt) charted a distinct third paradigm rooted in Istikhlāf (fiduciary trusteeship, Qur'an 57:7). Because ultimate ownership belongs to Allah (Milk Allāh), human ownership is simultaneously sacred and conditional. It is sacred in that the Prophet ﷺ declared a person's property as inviolable as their blood and honor (Sahih al-Bukhari 67), granted full independent property ownership to women (Qur'an 4:4, 4:7, 4:32), and validated free-market prices determined by supply and demand without arbitrary price-fixing (Sunan Abī Dāwūd 3451).",
                    "At the same time, property in Islam is conditional upon productive stewardship and social circulation (Qur'an 59:7). When Iraq, Syria, and Egypt were opened under the second Caliph 'Umar ibn Al-Khaṭṭāb (r. 634–644 CE), military commanders demanded that the fertile river valleys be partitioned among the soldiers as private estates. 'Umar convened a historic Shūrā assembly in Medina and recited Surah Al-Ḥashr (Qur'an 59:7–10), demonstrating that future generations had a canonical right to the land's bounty. He therefore left the land in the possession of its indigenous Christian, Jewish, and Persian farmers as Arḍ Al-Kharāj, assessing a fair harvest tax that funded public canals, bridges, and universal stipends, while forbidding occupying soldiers from buying peasant land. Simultaneously, through the law of Iḥyā' Al-Mawāt ('Whoever brings dead land to life, it belongs to him,' Tirmidhī 1378), any cultivator who dug an irrigation channel into barren desert acquired full private title ('Ushr land), sparking the medieval Islamic Agricultural Revolution.",
                    "Alongside private freehold ('Ushr) and public-trust land (Kharāj), the Prophet ﷺ established the doctrine of the Three Commons (water, pasture, and fire/energy, Abū Dāwūd 3477) and the ecological conservation zones of Al-Ḥimā and Al-Ḥarīm. Together with fixed Qur'anic inheritance shares ('Ilm Al-Farā'iḍ, Qur'an 4:7–12) that broke up concentrated aristocratic estates in every generation, Islamic property law created a dynamic, anti-monopolistic commercial civilization.",
                    "Seminar Question 3: Compare Caliph 'Umar's institution of Arḍ Al-Kharāj (under Qur'an 59:7–10) and the law of Iḥyā' Al-Mawāt with European medieval feudalism: how did Islamic land tenure preserve peasant freedom and incentivize hydraulic innovation?"
            ),
            new CollegiateThesisChapter(
                    4,
                    "CH-4-WAQF-CIVIL-SOCIETY",
                    "Chapter IV. The Waqf Endowment Revolution: How Inalienable Property Built Universities, Hospitals & Autonomous Civil Society",
                    "«إِنْ شِئْتَ حَبَّسْتَ أَصْلَهَا وَتَصَدَّقْتَ بِهَا» — 'If you wish, immobilize its principal and dedicate its fruits to charity.' (Prophet Muhammad ﷺ to 'Umar ibn Al-Khaṭṭāb, Sahih al-Bukhari 2737 / Sahih Muslim 1632)",
                    "PROPOSITION IV: The institution of Al-Waqf (perpetual charitable endowment) transformed private wealth into an autonomous, ruler-proof 'Third Sector' that financed almost all education, healthcare, scientific research, water infrastructure, and poverty relief across Islamic history.",
                    "When 'Umar ibn Al-Khaṭṭāb acquired a valuable date-palm orchard called Thamgh in Khaybar, he asked the Prophet ﷺ for the best way to use it for Allah. The Prophet ﷺ instructed him: 'Immobilize the principal land (so that it can never be sold, gifted, or inherited) and distribute its harvest to the poor, relatives, the emancipation of slaves, travelers, and guests.' From this single prophetic sentence emerged the legal architecture of the Waqf (plural Awqāf; known as Ḥubs in North Africa and Vakıf in Ottoman lands). Under Islamic law, once a founder (Wāqif)—whether a merchant, a scholar, a queen, or a sultan—registers a Waqf deed (Waqfiyyah) before a Qāḍī, the property passes out of mortal ownership into the implied ownership of Allah for the perpetual benefit of humanity.",
                    "The scale and ingenuity of Waqf properties across the Islamic world astonished foreign travelers. Commercial properties—covered bazaars, olive presses, mills, apartment buildings, bathhouses, and caravanserais—were endowed so that their rental income perpetually funded public goods. Women were among history's greatest Waqf founders: Fāṭimah al-Fihriyyah endowed Al-Qarawiyyīn in Fez (859 CE); Zubaydah bint Ja'far endowed the 1,500-kilometer water wells and reservoirs from Baghdad to Mecca; Zumurrud Khātūn and Dayfah Khātūn endowed madrasahs in Damascus and Aleppo; and Hürrem Sultan (Roxelana) endowed soup kitchens in Istanbul and Jerusalem. Great Bīmāristān hospitals—such as the Mansūrī Hospital in Cairo (1284 CE) and the Nūrī Hospital in Damascus—operated under Waqf charters stipulating that every patient, rich or poor, male or female, Muslim or non-Muslim, receive free medical care, pharmaceuticals, and upon recovery, a new set of clothes and gold coins so they would not have to work immediately.",
                    "As legal historians George Makdisi and Monica Gaudiosi have documented, the 13th-century statutes of Merton College at Oxford (1264 CE) and Peterhouse at Cambridge replicated the exact legal structure of the Islamic Waqf trust brought back from the Levant and Sicily. Even more importantly, because Waqf revenues were independent of the royal treasury, the scholarly class ('Ulamā'), universities, and hospitals retained moral and financial independence even when dynasties rose and fell.",
                    "Seminar Question 4: How did the legal rule that 'the stipulations of the Waqf founder are as binding as the text of the Lawgiver' empower women and private citizens to shape urban infrastructure, education, and healthcare independently of the state?"
            ),
            new CollegiateThesisChapter(
                    5,
                    "CH-5-COUNTRIES-KINGDOMS-SEVEN-CLIMES",
                    "Chapter V. Countries (Al-Buldān) and Kingdoms (Al-Mamālik) Across the Seven Climes: Unity in Cultural Multiplicity",
                    "«وَجَعَلْنَاكُمْ شُعُوبًا وَقَبَائِلَ لِتَعَارَفُوا» — 'And We made you peoples and tribes so that you may know one another.' (Qur'an 49:13) | Al-Muqaddasī, Aḥsan At-Taqāsīm fī Ma'rifat Al-Aqālīm (985 CE)",
                    "PROPOSITION V: As Islam expanded across the seven classical climes—from Córdoba and Timbuktu to Istanbul, Samarkand, Delhi, and the Indonesian archipelago—it never erased indigenous languages, dress, or architecture; instead, through the legal principle of 'Urf (sound custom), it cultivated a polycentric commonwealth of distinct kingdoms united by a shared moral-legal grammar.",
                    "A persistent misconception in popular historiography equates the Islamic world with the arid Middle East. In reality, Arab lands today account for only ~20% of the global Muslim population; over 60% of the world's Muslims live in South and Southeast Asia (Indonesia, Pakistan, India, Bangladesh, Malaysia), and another ~25% live across Sub-Saharan and North Africa. Classical Islamic geographers—such as Al-Iṣṭakhrī, Ibn Ḥawqal, Al-Muqaddasī, Al-Idrīsī (author of the 1154 CE world map Tabula Rogeriana), and Yāqūt Al-Ḥamawī (author of the encyclopedic Mu'jam Al-Buldān)—mapped 'Mamlakat Al-Islām' as a vibrant tapestry of diverse climates, kingdoms, and tongues.",
                    "Consider how each civilizational zone harmonized universal Islamic law with its local genius: (1) In the Maghreb and West Africa, the Almoravid, Almohad, Marinid, Mali (Mansa Musa), Songhai (Askia Muhammad), and Sokoto kingdoms united Amazigh, Arab, Mandinka, Songhai, and Fulani peoples around Maliki jurisprudence and the manuscript libraries of Fez and Timbuktu; (2) In the Persianate and Central Asian Silk Road realms, Samanid, Seljuk, Timurid, and Safavid kingdoms revived New Persian as a second classical language of Islam while turning Samarkand, Bukhara, and Isfahan into capitals of astronomy and philosophy; (3) In Anatolia and the Balkans, the Ottoman Empire governed a multi-ethnic commonwealth across three continents for 625 years via Hanafi law, Qānūn administration, and the pluralistic Millet system; (4) In South Asia, the Delhi Sultanates, Bengal Sultanate, and Mughal Badshahs presided over an agrarian-industrial powerhouse producing a quarter of global GDP in 1700 CE; and (5) In Maritime Nusantara (Indonesia, Malaysia, Brunei) and the Swahili Coast, coastal Sultanates (Pasai, Malacca, Aceh, Demak, Mataram, Kilwa, Zanzibar) embraced Islam peacefully through Indian Ocean trade and Sufi scholarship (the Wali Songo), adapting the 3-tiered Javanese Tajug roof to symbolize Islām, Īmān, and Iḥsān.",
                    "When Ibn Baṭṭūṭah traveled 73,000 miles across forty-four modern countries between 1325 and 1354 CE, he served as a chief judge (Qāḍī) in both Delhi and the Maldives, conversing in Arabic and Persian with scholars in Granada, Timbuktu, Cairo, Constantinople, Samarkand, Bengal, and Sumatra. Never before the modern internet had humanity created such a vast, borderless republic of letters and law.",
                    "Seminar Question 5: How did the legal maxim 'Al-'Ādah Muḥakkamah' (Sound custom is an arbiter in law) enable Nusantara (Indonesia/Malaysia), West Africa, and the Persianate world to become fully orthodox centers of Islamic civilization while preserving their indigenous languages and architectural forms?"
            ),
            new CollegiateThesisChapter(
                    6,
                    "CH-6-AESTHETICS-JAMAL-AL-ISLAM",
                    "Chapter VI. The Aesthetics of Tawḥīd: Why Beauty (Al-Jamāl) Is the Visible Signature of Truth in Islam",
                    "«الَّذِي أَحْسَنَ كُلَّ شَيْءٍ خَلَقَهُ» — 'He Who made beautiful/excellent everything that He created.' (Qur'an 32:7) | «صِبْغَةَ اللَّهِ ۖ وَمَنْ أَحْسَنُ مِنَ اللَّهِ صِبْغَةً» — 'The coloring (Ṣibghah) of Allah; and who is better than Allah in coloring?' (Qur'an 2:138)",
                    "PROPOSITION VI: In Islamic civilization, art and beauty were never segregated into secular museums for elite consumption; guided by the Prophetic Hadith 'Allah is Beautiful and loves beauty' (Sahih Muslim 91), Islamic aesthetics sanctified everyday life—turning script, geometry, water, light, sound, and social etiquette into contemplative reminders of the Infinite.",
                    "Philosophers of Islamic art—including Seyyed Hossein Nasr, Titus Burckhardt, Oleg Grabar, and Gülru Necipoğlu—have long asked what makes an object or building unmistakably 'Islamic' whether it stands in 10th-century Córdoba, 15th-century Samarkand, 16th-century Istanbul, 17th-century Agra, or 18th-century Java. The answer lies in the theology of Tawḥīd and Tanzīh (transcendence). Because the Infinite Creator cannot be captured inside a finite human statue or icon, Islamic art rejected representational idolatry in sacred space and instead developed an aniconic visual language that points beyond the material surface toward cosmic order.",
                    "This visual and auditory language rests on four pillars: (1) Calligraphy ('Ilm Al-Khaṭṭ), which gives visible geometric proportion (Ibn Muqlah's Al-Khaṭṭ Al-Manṣūb) to the revealed syllables of the Qur'an; (2) Geometric Tessellation (Al-Handasah), where radiating 8-, 10-, 12-, and 16-fold star polygons unfold from a single center—visually demonstrating how multiplicity emanates from and returns to Unity; (3) The Arabesque (At-Tawrīq / Islīmī), whose rhythmic, unending spiral vines mirror the living breath of nature; and (4) Acoustic and Spatial Serenity, where Muqarnas stalactite vaults diffuse harsh sunlight into soft radiance (Qur'an 24:35) and courtyard fountains cool the air while masking street noise. Even ordinary utensils—a brass astrolabe, a ceramic bowl from Nishapur, a woven carpet, or a wooden window screen (Mashrabiyyah)—were crafted with the same devotion to Iḥsān as a royal mosque.",
                    "Above all, Islam insists that outward aesthetic beauty must be matched by inward moral beauty (Ḥusn Al-Khuluq). As the Qur'an teaches through its triad of 'Beautiful Patience' (Ṣabr Jamīl, 12:18), 'Beautiful Forgiveness' (Ṣafḥ Jamīl, 15:85), and 'Beautiful Parting' (Hijr Jamīl, 73:10), the ultimate work of art in Islam is a purified human heart that radiates mercy, truthfulness, and grace to all creation.",
                    "Seminar Question 6: How do the three visual elements of the Islamic sanctuary—Calligraphy, Geometric Girih/Muqarnas, and the Chahār Bāgh Courtyard Garden—translate specific Qur'anic verses on Word (96:1–5), Measure (54:49), and Paradise (47:15) into spatial experience?"
            ),
            new CollegiateThesisChapter(
                    7,
                    "CH-7-CRISIS-SURVIVAL-RENEWAL",
                    "Chapter VII. Dissolution of Empires vs. Indestructibility of the Covenant: Ibn Khaldūn, Coloniality & Modern Renewal",
                    "«إِنَّ اللَّهَ لَا يُغَيِّرُ مَا بِقَوْمٍ حَتَّىٰ يُغَيِّرُوا مَا بِأَنفُسِهِمْ» — 'Indeed, Allah does not change the condition of a people until they change what is within themselves.' (Qur'an 13:11) | Sunan Abī Dāwūd 4291 (The Centennial Mujaddid)",
                    "PROPOSITION VII: Whenever Muslim kingdoms succumbed to fiscal tyranny (Mukūs), sectarian partisanship ('Aṣabiyyah), or intellectual stagnation, Allah's historical law (Sunnat Al-Mudāwalah) dissolved the dynasty—yet the decentralized spiritual and legal matrix of Islam repeatedly generated internal renewal (Tajdīd) and outlived every empire.",
                    "No collegiate study of Islamic expansion is complete without confronting the question of political decline and dissolution. Why did Umayyad Córdoba fracture in 1031 CE, Abbasid Baghdad fall in 1258 CE, Mughal Delhi collapse in 1857 CE, and the Ottoman Caliphate dissolve in 1924 CE? Rather than blaming fate, the Qur'an and Islamic historians diagnosed the exact internal mechanisms of civilizational decay. In Qur'an 8:46 ('Do not dispute lest you falter and your strength depart') and 17:16, scripture warns that factionalism and elite moral corruption invite historical replacement (Istibdāl, 47:38). In 1377 CE, Ibn Khaldūn formalized this in his Muqaddimah: dynasties founded on genuine moral solidarity ('Aṣabiyyah) and religious justice gradually grow accustomed to palatial luxury over three to four generations, raise arbitrary non-canonical taxes (Mukūs) that suffocate productive merchants and farmers, and hollow out their own legitimacy from within.",
                    "During the 19th and 20th centuries, this internal exhaustion coincided with European industrial-military colonialism, which partitioned the Muslim world, confiscated historic Waqf endowments to centralize state power, and replaced fluid civilizational frontiers with rigid nation-state borders. Yet precisely here, the structural genius of Islam became unmistakable: despite the abolition of the Caliphate in 1924, the global Muslim population grew nearly sevenfold over the next century (from ~300 million to ~2.0 billion), and independent Muslim nations re-emerged from Morocco to Indonesia.",
                    "Today, contemporary Islamic renewal (Tajdīd, Abū Dāwūd 4291) is reclaiming its canonical foundations for the 21st century: reviving Waqf and Green Sukuk to finance sustainable infrastructure (such as Indonesia's clean water, sanitation, and renewable energy grids), advancing women's scholarship and leadership rooted in prophetic precedent, and articulating a theology of steward-accountability (Amānah) in an age of ecological and technological crisis.",
                    "Seminar Question 7: How does Ibn Khaldūn's Laffer-curve analysis in the Muqaddimah ('At the beginning of a dynasty, taxation yields a large revenue from small assessments; at the end of the dynasty, taxation yields a small revenue from large assessments') align with canonical Islamic limits on state taxation?"
            ),
            new CollegiateThesisChapter(
                    8,
                    "CH-8-UNIVERSAL-CONCLUSION",
                    "Chapter VIII. Universal Conclusion: The Gift and Promise of Islam to the Human Future",
                    "«وَمَا أَرْسَلْنَاكَ إِلَّا رَحْمَةً لِّلْعَالَمِينَ» — 'And We have not sent you, [O Muhammad], except as a mercy to the worlds.' (Qur'an 21:107) | «فَاسْتَبِقُوا الْخَيْرَاتِ» — 'So race one another toward all that is good.' (Qur'an 2:148)",
                    "SYNTHESIS & CONCLUSION: Viewed in its canonical fullness across time, law, geography, and aesthetics, Islam stands not as a parochial Huntingtonian 'clash' bloc, but as a universal Abrahamic covenant of Mercy (Raḥmah), Balance (Mīzān), Fiduciary Justice ('Adl), and Spiritual Beauty (Iḥsān) inviting all humanity to 'race toward the good' (Fastabiqū al-Khayrāt).",
                    "When we step back to behold the entirety of the Qur'anic timeline—from the primordial covenant of souls (7:172) and Abraham's sanctuary in Mecca (2:127), through the Cave of Ḥirā' (96:1–5) and the Medinan Charter, across fourteen centuries of Caliphates, Sultanates, Shahdoms, Waqf universities, Bīmāristān hospitals, Silk Road caravanserais, and Indian Ocean merchant ports—three enduring truths emerge for universal human understanding:",
                    "First, on the plane of Governance and Property: Power and wealth are never absolute ends in themselves; they are temporary trusts (Amānāt) held under the gaze of Mālik Al-Mulk (3:26). A civilization flourishes only so long as it protects the dignity of the weak, prohibits predatory usury, honors private labor and land revival, safeguards the ecological commons of water and earth, and endows perpetual Waqf institutions for knowledge and mercy. Second, on the plane of Pluralism and Geography: Unity does not require cultural uniformity. Across seventy countries and seven climes, Islam proved that a single revealed ethical core can embrace Arab, Persian, Turkic, Amazigh, Malay-Indonesian, South Asian, African, and Western cultures without erasing their languages or artistic souls.",
                    "Third, and finally, on the plane of Beauty and Eschatological Hope: Islam's promise of return (Musnad Aḥmad 18406; Sahih Muslim 145; Sunan Abī Dāwūd 4282) is a promise that human history does not terminate in nihilism, environmental ruin, or tyranny. Anchored in the One Who is Beautiful and loves beauty, the believer is called in every generation to plant the sapling even if the Final Hour is at hand (Musnad Aḥmad 12902), to forgive with beautiful forgiveness (15:85), and to walk gently upon the earth (Qur'an 25:63) until all sovereignty returns to Allah, the Most Merciful of the merciful.",
                    "Seminar Question 8: In light of Qur'an 21:107 ('We sent you only as a mercy to the worlds'), Qur'an 55:7–9 (the cosmic Balance / Al-Mīzān), and the Hadith of planting a tree even at the Final Hour (Musnad Aḥmad 12902), how can the canonical principles of Istikhlāf, Waqf, and Iḥsān address the 21st-century crises of ecological depletion, economic inequality, and spiritual alienation?"
            )
    );

    public static List<QuranicExpansionTimelineEpoch> allTenQuranicTimelineEpochs() {
        return TEN_QURANIC_TIMELINE_EPOCHS;
    }

    public static List<CanonicalPropertyAndLandCategory> allSevenCanonicalPropertyCategories() {
        return SEVEN_CANONICAL_PROPERTY_CATEGORIES;
    }

    public static List<CountriesAndKingdomsClime> allSevenCountriesAndKingdomsClimes() {
        return SEVEN_COUNTRIES_AND_KINGDOMS_CLIMES;
    }

    public static List<BeautyOfIslamDimension> allSevenBeautyOfIslamDimensions() {
        return SEVEN_BEAUTY_OF_ISLAM_DIMENSIONS;
    }

    public static List<CollegiateThesisChapter> allEightCollegiateThesisChapters() {
        return EIGHT_COLLEGIATE_THESIS_CHAPTERS;
    }
}
