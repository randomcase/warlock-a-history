package com.sovereign.warlock.domain;

import java.util.List;

/**
 * Canonical domain model for Portal #66:
 * Alchemical Wares, Douching & Hygiene (Fiqh Al-Taharah & Alat Al-Kimiya'),
 * Homosexuality, Homogeneity & Insular Self-Governing Structures,
 * The Seven Archetypes of the Islamic Man & The Caravan Through Antiquity,
 * Caliphate Self-Organization (Al-Ahkam Al-Sultaniyyah), and Islamic Suffrage
 * (Al-Shura, Al-Bay'ah, Al-Mujadilah & Wilayat Al-Mazalim Across Common, Royal,
 * Young, Old & Gender Causes Past and Present).
 */
public final class IslamicAlchemicalHygieneCaravanAndSuffrageAtlas {

    private IslamicAlchemicalHygieneCaravanAndSuffrageAtlas() {
    }

    public record AlchemicalHygieneApparatus(
            int index,
            String arabicName,
            String englishTitle,
            String pioneerScholarsAndTexts,
            String materialAndChemicalComposition,
            String hygienicAndMedicalFunction,
            String fiqhRulingAndScripturalAnchor,
            String colorHex
    ) {
    }

    public record HomogeneityAndInsularGovernancePillar(
            int index,
            String dimensionCategory,
            String arabicTitle,
            String englishTitle,
            String scripturalAndJuristicAnchor,
            String structuralMechanism,
            String historicalAndSocialAnalysis,
            String colorHex
    ) {
    }

    public record IslamicManAndCaravanArchetype(
            int index,
            String archetypeCode,
            String arabicTitle,
            String englishTitle,
            String socialStationAndDailyRhythm,
            String canonicalScripturalAndHadithAnchor,
            String historicalExemplarsAndPhenomenology,
            String colorHex
    ) {
    }

    public record CaliphateGovernanceOrgan(
            int index,
            String arabicTitle,
            String englishTitle,
            String constitutionalTreatiseSource,
            String organizationalJurisdiction,
            String checksAndBalancesMechanism
    ) {
    }

    public record IslamicSuffragePillarAndCause(
            int index,
            String categoryBadge,
            String arabicTerm,
            String englishTitle,
            String quranicAndPropheticFoundation,
            String mechanismOfSuffrageAndVoice,
            String transformingExperienceIntoChange,
            String colorHex
    ) {
    }

    public record GenderSuffrageAndAgencyMilestone(
            int index,
            String eraLabel,
            String protagonistOrMovement,
            String arabicAndScripturalAnchor,
            String livedOrdealOrQuestion,
            String institutionalAndLegalChangeEffected
    ) {
    }

    public static List<AlchemicalHygieneApparatus> allSevenAlchemicalHygieneWares() {
        return List.of(
                new AlchemicalHygieneApparatus(
                        1,
                        "Al-Anbīq wa Al-Qar' wa Al-Qābilah (الأَنْبِيق وَالقَرْع وَالقَابِلَة)",
                        "The Alembic Still-Head, Cucurbit Gourd-Flask & Receiver for Hydro-Distillation",
                        "Jābir ibn Ḥayyān (Geber, 8th c., Kitāb Al-Sab'īn), Abū Bakr Al-Rāzī (Rhazes, Kitāb Al-Asrār, c. 900 CE), and Al-Kindī (Kitāb Kīmiyā' Al-'Iṭr wa Al-Taṣ'īdāt)",
                        "Blown soda-lime glass, glazed ceramic, or tinned Damascus copper with an overhead condensing dome (Anbīq), delivery snout (Mi'zāb), and lower heating gourd (Qar') seated in a water bath (Ḥammām Māriyah) or sand/ash bath.",
                        "Engineered the large-scale steam and hydro-distillation of pure rosewater (Mā' Al-Ward), orange-blossom water (Mā' Al-Zahr), camphor (Kāfūr), and high-proof distilled alcohol (Al-Kuḥūl, used strictly as a clinical antiseptic solvent in Bīmāristān hospitals).",
                        "Anchored in Sahih Muslim 223 ('Cleanliness is half of faith' — Al-Ṭuhūru shaṭru al-īmān). Distilled floral waters classified as Ṭāhir (pure) for perfuming the body, clothing, and mosque sanctuaries.",
                        "#10B981"
                ),
                new AlchemicalHygieneApparatus(
                        2,
                        "Al-Ūthāl wa Al-Būṭaqah (الأُوثَال وَالبُوطَقَة)",
                        "The Aludel Sublimation Vessel, Crucible & Mineral Purification Wares",
                        "Abū Bakr Al-Rāzī (Kitāb Sirr Al-Asrār), Al-Majrīṭī (Rutbat Al-Ḥakīm), and Abū Al-Qāsim Al-Kāshānī",
                        "Refractory clay crucibles (Būṭaqāt), tiered sublimation condensers (Ūthāl / Aludel), and hydrostatic precision balances (Mīzān Al-Ḥikmah of Al-Khāzinī) processing alum (Shabb), vitriol (Zāj), natron, sulfur (Kibrīt), and sal-ammoniac (Nūshādir).",
                        "Produced pharmaceutical-grade astringents, styptic alum crystals for staunching bleeding after shaving or cupping (Ḥijāmah), zinc oxide eye salves (Tūtiyā / Kuḥl) for ophthalmic prophylaxis, and dermatological ointments.",
                        "Fulfilled the Prophetic medical maxim: 'Allah has not sent down any disease without sending down its cure; whoever knows it knows it, and whoever is ignorant of it is ignorant of it' (Sahih Al-Bukhari 5678).",
                        "#F59E0B"
                ),
                new AlchemicalHygieneApparatus(
                        3,
                        "Al-Ṣābūn Al-Ḥalabī wa Al-Nūrah (الصَّابُون الحَلَبِيّ وَالنُّورَة)",
                        "Saponified Hard Olive-Laurel Alkali Soap, Potash (Ushnān) & Depilatory Paste",
                        "Syrian, Levantine & Iraqi Alchemical Guilds (Aleppo, Nablus, Damascus, Baghdad, 8th–12th c.); documented by Al-Muqaddasī and Ibn Al-Ukhuwwah (Ma'ālim Al-Qurbah)",
                        "Saponification of virgin olive oil (Zayt Al-Zaytūn) and aromatic laurel berry oil (Zayt Al-Ghār) reacted with calcined barilla plant soda ash (Al-Qalī -> English 'Alkali') and slaked lime (Kils), alongside Al-Nūrah (quicklime depilatory paste) and Ushnān (alkaline soapwort).",
                        "Created the world's first hard, antiseptic, perfumed toilet soaps exported across the Mediterranean, paired with weekly body hair removal in the Ḥammām to prevent ectoparasites, sweat odor, and skin infections.",
                        "Directly instantiates the Prophetic Sunan Al-Fiṭrah (Sahih Al-Bukhari 5889; Sahih Muslim 257): plucking/shaving axillary and pubic hair (Ḥalq Al-'Ānah) at least once every 40 days.",
                        "#38BDF8"
                ),
                new AlchemicalHygieneApparatus(
                        4,
                        "Al-Ibrīq, Al-Aftābah wa Al-Shattaf (الإِبْرِيق وَالأَفْتَابَة وَالاسْتِنْجَاء)",
                        "The Spouted Brass Ewer & Intimate Water Irrigation (Al-Istinjā')",
                        "Universal across all Islamic lands from Umayyad Damascus & Abbasid Baghdad to Timurid Herat, Ottoman Istanbul, and Mughal Delhi",
                        "Hammered brass or tinned copper ewer (Ibrīq / Aftābah) with a long curved swan-neck spout and lidded reservoir, paired in modern engineering with the pressurized water bidet/Shattaf.",
                        "Provides running, directed water irrigation for mandatory perineal, urethral, and anal washing (Al-Istinjā') with the left hand after every urination or defecation, eliminating fecal-oral contamination and urinary residue.",
                        "Qur'an 9:108 ('In it are men who love to purify themselves; and Allah loves those who purify themselves' — revealed regarding the Ansar of Quba' who combined dry stones with water washing) & Sunan Abi Dawud 44.",
                        "#D4AF37"
                ),
                new AlchemicalHygieneApparatus(
                        5,
                        "Al-Miḥqan, Al-Ḥuqnah wa Al-Zarāqah (المِحْقَن وَالحُقْنَة وَالزَّرَّاقَة)",
                        "Clinical Douching, Vaginal/Uterine Irrigators, Bladder Syringes & Rectal Clysters",
                        "Abū Al-Qāsim Al-Zahrāwī (Albucasis, Kitāb Al-Taṣrīf, Book 30, 1000 CE), Ibn Sīnā (Al-Qānūn fī Al-Ṭibb), and Al-Rāzī (Kitāb Al-Ḥāwī)",
                        "Cast silver, burnished brass, ivory, or porcelain piston-syringes (Zarāqah) and double-channeled cannulas (Miḥqan) fitted with smooth perforated nozzles or oiled leather/bladder bulbs, plus medicated wool pessaries (Farzajah / Ḥamūl).",
                        "Engineered for clinical douching and internal irrigation: (1) gynecological/uterine douching with warm infusions of rosewater, myrtle (Ās), pomegranate rind, chamomile, and alum for postpartum recovery, leukorrhea, or ulcerations; (2) urological bladder irrigation; and (3) therapeutic rectal enemas/clysters (Al-Ḥuqnah). In daily ritual hygiene, nasal douching (Al-Istinshāq) and oral rinsing (Al-Maḍmaḍah) are performed 15 times daily across the 5 prayers, while post-menstrual purification uses a musk-scented cloth (Firṣah Mumatthakhah, Sahih Muslim 332).",
                        "Classical Fiqh extensively debated internal douching/clysters during fasting (Ṣawm): the Majority (Ḥanafī, Mālikī, Shāfi'ī, Ḥanbalī) held that a deep rectal clyster (Ḥuqnah) reaches the body cavity (Jawf) and requires make-up fasting (Qaḍā'), whereas the Zāhirī school (Ibn Ḥazm in Al-Muḥallā) and Shaykh Al-Islām Ibn Taymiyyah ruled that neither rectal enemas, urethral catheters, nor vaginal douching invalidate the fast because they provide neither nutrition nor enter through the digestive tract.",
                        "#F43F5E"
                ),
                new AlchemicalHygieneApparatus(
                        6,
                        "Al-Ḥammām Al-Islāmī wa Al-Ghusl (الحَمَّام الإِسْلَامِيّ وَالغُسْل)",
                        "The Tri-Chambered Hydrological Bathhouse & Full-Body Ritual Ablution",
                        "Umayyad Desert Castles (Qusayr 'Amra, Khirbat Al-Mafjar), Damascus, Fez, Cairo & Istanbul Sinan Bathhouses; medical treatises by Qusṭā ibn Lūqā and Ibn Riḍwān",
                        "Hypocaust underfloor furnace (Qamīm) heating copper cauldrons, feeding pressurized terracotta pipes to wall basins (Jurn) and marble pouring bowls (Ṭāsah) under glass star-oculi domes (Qamariyyāt) across three thermal zones: Barrānī (cold), Wusṭānī (tepid), and Juwwānī (hot steam).",
                        "Crucially redesigned the Roman bath by replacing stagnant communal immersion pools with continuous running water poured from marble basins (because Islamic law forbids bathing in small stagnant pools, Sahih Muslim 283), enabling full-body ritual purification (Ghusl) after marital intimacy (Janābah), menstruation (Ḥayḍ), childbirth (Nifās), and before Friday Jumu'ah prayer.",
                        "Qur'an 5:6 ('And if you are in a state of Janābah, then purify yourselves [fa-ṭṭahharū]') and Qur'an 2:222 ('Indeed, Allah loves those who are constantly repentant and loves those who purify themselves').",
                        "#A855F7"
                ),
                new AlchemicalHygieneApparatus(
                        7,
                        "Al-Qumqum, Al-Mabkharah wa Al-Miswāk (القُمْقُم وَالمَبْخَرَة وَالمِسْوَاك)",
                        "The Rosewater Sprinkler, Agarwood ('Ūd) Censer & Salvadora Persica Tooth-Stick",
                        "Prophetic Sunnah of the Miswāk; Abbasid, Mamluk & Ottoman metalwork guilds (Damascus inlaid brass Qumqum & Mabkharah)",
                        "Silver-inlaid brass teardrop sprinkler (Qumqum), pierced geometric incense burner (Mabkharah) burning agarwood ('Ūd), frankincense (Lubān), and ambergris ('Anbar), and fibrous Salvadora persica root-twigs (Miswāk / Siwāk) rich in natural fluoride, silica, tannins, and antibacterial benzyl isothiocyanate.",
                        "Maintains oral microbiome hygiene before every prayer and social gathering ('Were it not that I might overburden my Ummah, I would have ordered them to use the Siwāk before every prayer,' Sahih Al-Bukhari 887), while rosewater and 'Ūd fumigation sanitize clothing and assembly halls.",
                        "Sahih Muslim 2253 ('Three things from your world have been made beloved to me: women and perfume [al-ṭīb], and the coolness of my eyes has been placed in prayer').",
                        "#14B8A6"
                )
        );
    }

    public static List<HomogeneityAndInsularGovernancePillar> allSevenHomogeneityAndInsularStructures() {
        return List.of(
                new HomogeneityAndInsularGovernancePillar(
                        1,
                        "SEXUALITY, PRIVACY (SATR) & CLASSICAL JURISPRUDENCE VS. ADAB",
                        "Fiqh Al-Satr, Qawm Lūṭ, Al-Mukhannathūn wa Adab Al-Majālis",
                        "Homosexuality, Homosociality, Evidentiary Privacy (Satr) & Gender Variance in Classical Islam",
                        "Qur'an 7:80–81, 26:165–166 & 49:12 ('And do not spy' — Wa lā tajassasū); Hadith of Satr (Sahih Muslim 2590: 'Whoever covers a Muslim in this world, Allah will cover him in this world and the Hereafter')",
                        "Classical Islamic law (Fiqh) strictly prohibited extra-marital sexual acts—including anal sodomy (Liwāṭ) and female-to-female tribadism (Siḥāq)—while simultaneously erecting an almost impenetrable legal wall around the private home (Ḥurmat Al-Masākin): (1) Unacted internal attraction or desire carries zero legal sin or punishment in Islam; (2) Prosecuting any sexual act required four upright eyewitnesses who directly saw the physical act of penetration without committing unlawful spying (Tajassus), rendering state policing of consenting private bedrooms virtually impossible; (3) Abū Ḥanīfah (founder of the Ḥanafī school) classified Liwāṭ under discretionary judicial correction (Ta'zīr) rather than fixed capital Ḥadd, whereas Shāfi'ī, Mālikī, and Ḥanbalī jurists analogized it to Zinā.",
                        "As historians Everett Rowson and Khaled El-Rouayheb document, pre-modern Islamic society did not categorize humans into modern binary 'orientations,' nor did it criminalize homosocial affection or poetic praise of beauty (Ghazal) so long as public modesty and legal bounds were respected. Furthermore, classical Medina and Damascus recognized distinct gender-liminal social groups—such as the Mukhannathūn (effeminate male musicians/courtiers like Ṭuways in early Medina, protected from harm though regulated in domestic access) and the revered Aghawāt (eunuch guardians of the Prophet's Mosque in Medina and the Ka'bah in Mecca).",
                        "#F43F5E"
                ),
                new HomogeneityAndInsularGovernancePillar(
                        2,
                        "LITURGICAL & SPATIAL HOMOGENEITY",
                        "Al-Ṣaff Al-Wāḥid, Al-Qiblah wa Libās Al-Iḥrām",
                        "The Homogeneous Prayer Row (Ṣaff), Universal Qiblah Axis & Unstitched Iḥrām Equality",
                        "Qur'an 2:144 ('Turn your face toward Al-Masjid Al-Ḥarām') & Sahih Muslim 432 ('Straighten your rows, for straightening the row is part of establishing prayer')",
                        "Five times every twenty-four hours, across every time zone on earth, Muslims form perfectly straight, shoulder-to-shoulder, ankle-to-ankle concentric arcs facing a single geodesic focal point (the Ka'bah at 21.4225° N, 39.8262° E). No pew, caste reservation, or royal throne is permitted inside the prayer lines; whoever arrives first stands in the front row, and during the Ḥajj every rich monarch and destitute laborer wears the exact same two unstitched white towels (Iḥrām).",
                        "This physical, bodily choreography generates an unmatched civilizational homogeneity: a traveler from 14th-century Tangier (like Ibn Baṭṭūṭah) could walk into a mosque in Cairo, Damascus, Delhi, Malé, or Quanzhou and immediately step into the exact same Arabic liturgy, posture, and legal fraternity without feeling like a foreigner.",
                        "#10B981"
                ),
                new HomogeneityAndInsularGovernancePillar(
                        3,
                        "TEMPORAL & METABOLIC HOMOGENEITY (FASTING & PRAYER)",
                        "Al-Ṣawm wa Al-Mawāqīt Al-Khams",
                        "Planetary Synchronization of Fasting (Ramadan) & the Five Solar-Horizon Prayer Times",
                        "Qur'an 2:183–187 ('Fasting is prescribed for you... eat and drink until the white thread of dawn becomes distinct to you from the black thread') & Qur'an 4:103",
                        "Fasting (Al-Ṣawm) from true dawn (Fajr) to sunset (Maghrib) during the lunar month of Ramadan synchronizes the entire community's metabolic, culinary, charitable, and nocturnal rhythm. The rich experience the visceral hunger of the poor in their own stomachs; the entire city breaks bread at the exact same second (Ifṭār) and rises together before dawn (Suḥūr).",
                        "Combined with the five daily prayers (Fajr, Ẓuhr, 'Aṣr, Maghrib, 'Ishā'), time in an Islamic society is never an abstract bureaucratic clock—it is a lived astronomical and communal cadence linking personal self-restraint (Taqwā) to collective solidarity.",
                        "#D4AF37"
                ),
                new HomogeneityAndInsularGovernancePillar(
                        4,
                        "ARCHITECTURAL & URBAN HOMOGENEITY",
                        "Binyat Al-Madīnah Al-Islāmiyyah (Jāmi' – Sūq – Ḥammām – Dār)",
                        "The Isomorphic Islamic City Blueprint Across All Seven Climes",
                        "Qur'an 24:36–37 ('In houses which Allah has ordered to be raised... men whom neither commerce nor sale distracts from the remembrance of Allah')",
                        "Every classical Islamic city—whether Fez, Córdoba, Tunis, Cairo, Damascus, Aleppo, Isfahan, Samarkand, or Banda Aceh—organizes itself around the same modular, self-replicating civic DNA: (1) The central Friday Mosque (Al-Jāmi') and Madrasah; (2) Radiating guild bazaars (Al-Sūq) ordered by cleanliness and aroma (perfumers, booksellers, and silk-weavers closest to the mosque; tanners, dyers, and blacksmiths on the periphery); (3) The public bathhouse (Ḥammām), hospital (Bīmāristān), and water fountain (Sabīl); and (4) Residential quarters of inward-looking courtyard houses (Dār) with blank exterior walls minimizing street envy and maximizing interior garden beauty.",
                        "Even when conquerors changed at the citadel (Qal'ah), this homogeneous urban cellular matrix remained intact, allowing neighborhoods to function with uninterrupted civic order.",
                        "#38BDF8"
                ),
                new HomogeneityAndInsularGovernancePillar(
                        5,
                        "INSULAR SELF-GOVERNANCE I: WAQF ENDOWMENTS & THE MAḤALLAH WARD",
                        "Al-Waqf Al-Khayrī wa Niẓām Al-Ḥārah / Al-Maḥallah",
                        "Fiscal Immunity of the Waqf Trust & Self-Governing Urban Neighborhoods",
                        "Sahih Muslim 1631 ('When a human being dies, his deeds end except for three: ongoing charity [Ṣadaqah Jāriyah], beneficial knowledge, or a righteous child who prays for him')",
                        "How did Islamic society govern itself autonomously without relying on state bureaucracy? Through two insular institutions: (1) Al-Waqf, an irrevocable legal trust that permanently removes revenue-producing property (markets, orchards, bathhouses, mills) from state taxation or royal confiscation and dedicates its income forever to schools, hospitals, orphans, water aqueducts, and even stray animals; and (2) The Maḥallah / Ḥārah (walled urban neighborhood ward), governed by its own locally chosen Shaykh Al-Ḥārah, night watchman ('Assās), fire brigade, and communal arbitration council.",
                        "By the 18th century, between one-third and one-half of all arable land and urban real estate in the Ottoman, Mamluk, and Moroccan realms was held in Waqf—meaning education, healthcare, water supply, and poor relief were 100% community-funded and insulated from palace coups.",
                        "#A855F7"
                ),
                new HomogeneityAndInsularGovernancePillar(
                        6,
                        "INSULAR SELF-GOVERNANCE II: AṢNĀF GUILDS, FUTŪWWAH & AKHĪ BROTHERHOODS",
                        "Al-Aṣnāf, Al-Futūwwah wa Al-Ukhuwwah (Akhī)",
                        "Self-Regulating Craft Guilds & Chivalric Artisan Confraternities",
                        "Qur'an 18:13 ('Indeed, they were youths [Fityah] who believed in their Lord, and We increased them in guidance') & Caliph Al-Nāṣir's Futūwwah Charter (c. 1182 CE)",
                        "Every trade in the Islamic city (bakers, weavers, apothecaries, coppersmiths, masons, caravan drivers) formed a self-governing guild (Ṣinf / Ṭā'ifah) fused with the ethical chivalry code of Futūwwah (in Arabic lands) or Akhīlik (in Seljuk/Ottoman Anatolia, famously described by Ibn Baṭṭūṭah). Each guild elected its own Shaykh Al-Ṣinf, tested apprentices before conferring the belt of mastery (Shadd), fixed quality standards, maintained a mutual-aid treasury (Ṣundūq Al-Ta'āwun) for sick or widowed members, and hosted nightly hospitality lodges (Zāwiyah) for strangers.",
                        "When central government collapsed in Anatolia or Syria during Mongol or Crusader invasions, the Akhī and Futūwwah brotherhoods seamlessly stepped in to govern cities, defend walls, and keep markets honest.",
                        "#F59E0B"
                ),
                new HomogeneityAndInsularGovernancePillar(
                        7,
                        "INSULAR SELF-GOVERNANCE III: MADHHAB PLURALISM & DĀR AL-IFTĀ'",
                        "Ta'addud Al-Madhāhib, Al-Iftā' wa Al-Qaḍā' Al-Ahlī",
                        "Decentralized Legal Schools & Autonomous Communal Courts",
                        "Qur'an 16:43 ('So ask the people of knowledge if you do not know') & Qur'an 5:48 ('To each of you We prescribed a law and a method')",
                        "Unlike modern nation-states where the legislature holds a monopoly on lawmaking, classical Islamic law (Sharī'ah / Fiqh) was authored from the bottom up by independent civilian jurists (Fuqahā' and Muftīs) across the four Sunni Madhhabs (Ḥanafī, Mālikī, Shāfi'ī, Ḥanbalī), the Ja'farī and Zaydī schools, and the Ibāḍī school. In Mamluk Cairo and Damascus, four Chief Judges (Qāḍī Al-Quḍāt)—one for each Sunni school—sat simultaneously so citizens could contract marriages, commerce, or inheritance under the school that best resolved their case, while non-Muslim communities (Ahl Al-Dhimmah / Millets) governed their own family and communal law in autonomous rabbinical and ecclesiastical courts.",
                        "This legal polycentrism meant that the Caliph or Sultan was subject to the law rather than its creator; if a ruler attempted to alter canonical Fiqh by decree, the independent 'Ulamā' and guild networks simply refused to validate it.",
                        "#14B8A6"
                )
        );
    }

    public static List<IslamicManAndCaravanArchetype> allSevenIslamicManAndCaravanArchetypes() {
        return List.of(
                new IslamicManAndCaravanArchetype(
                        1,
                        "THE COMMON ISLAMIC MAN",
                        "Al-Rajul Al-'Āmmī / Ibn Al-Balad / Ahl Al-Sūq (الرَّجُل العَامِّيّ وَابْن البَلَد)",
                        "The Common Islamic Man: Artisan, Householder, Guildsman & Pillar of the Congregation",
                        "Rises at true dawn (Fajr) for ablution (Wuḍū') and congregational prayer in the neighborhood masjid; opens his shop or workshop in the Sūq with the Bismillāh; earns lawful sustenance (Kasb Ḥalāl) under the ethical eye of his guild and the Muḥtasib; returns home to provide Nafaqah (maintenance, food, clothing, and shelter) for his wife, children, and aging parents; visits the Ḥammām on Thursday evening; and stands dressed in clean white cotton with perfume and Miswāk at the Friday Jumu'ah sermon.",
                        "Sahih Muslim 995 ('The best dinar a man spends is the dinar he spends on his dependents [family]') & Sahih Al-Bukhari 2072 ('Nobody has ever eaten a better meal than that which one has earned by working with one's own hands; the Prophet of Allah, Dāwūd, used to eat from the earnings of his own hands').",
                        "The Common Man is the moral backbone of Al-Sawād Al-A'ẓam (the Great Majority of the Ummah). Without royal titles, he builds the Waqf fountains, sustains the craft guilds, memorizes the Qur'an, and judges rulers by whether bread is affordable, roads are safe, and the Qāḍī's court is fair.",
                        "#10B981"
                ),
                new IslamicManAndCaravanArchetype(
                        2,
                        "THE ROYAL ISLAMIC MAN",
                        "Al-Rajul Al-Malakī / Al-Khalīfah wa Al-Sulṭān (الخَلِيفَة وَالسُّلْطَان وَالمَلِك)",
                        "The Royal Islamic Man: Sovereign Steward Between Imperial Majesty & Eschatological Dread",
                        "Invested with the insignias of sovereignty—the Khuṭbah (Friday sermon invocation), the Sikkah (minting of gold Dīnārs), the Ṭirāz (embroidered robe of honor), and the Maẓālim High Court of Grievances—yet haunted day and night by the Prophetic warning that a ruler who betrays his flock will be barred from the fragrance of Paradise.",
                        "Sahih Al-Bukhari 7138 ('All of you are shepherds, and each of you is responsible for his flock: the Imām [ruler] is a shepherd and is responsible for his flock') & Sahih Muslim 1829 ('There is no servant whom Allah entrusts with subjects and who dies while cheating his subjects, except that Allah forbids Paradise to him').",
                        "Embodied at its zenith by 'Umar ibn Al-Khaṭṭāb (walking the night streets of Medina carrying a sack of flour on his own back for a hungry widow), 'Umar ibn 'Abd Al-'Azīz (Umar II, who returned all royal Umayyad estates to the public treasury Bayt Al-Māl and wept thinking of a single mule stumbling on an unpaved road in Iraq), Nūr Al-Dīn Zangī, Saladin (who died with only 47 silver dirhams and 1 gold dinar left after giving everything to charity), and Ottoman Sultans who kept the dust of campaigns in their turbans to be buried under their cheeks.",
                        "#D4AF37"
                ),
                new IslamicManAndCaravanArchetype(
                        3,
                        "THE POOR ISLAMIC MAN",
                        "Al-Faqīr wa Al-Miskīn / Ahl Al-Ṣuffah (الفَقِير وَالمِسْكِين وَأَهْل الصُّفَّة)",
                        "The Poor Islamic Man: Holder of a Statutory Share in Wealth & Vanguard of Paradise",
                        "Possesses little or no surplus property (below the Niṣāb threshold of 85g of gold), yet is never treated in Islamic law as a social outcast or beggar without rights. Instead, he holds an explicit, divinely legislated property claim (Ḥaqq Ma'lūm) inside the wealth of the rich, disbursed through mandatory Zakāh (2.5% of wealth, 5–10% of harvests), Ṣadaqat Al-Fiṭr before Eid, Kaffārāt (expiatory feedings), and Waqf soup kitchens ('Imārat / Takiyyah).",
                        "Qur'an 70:24–25 ('And those within whose wealth is a known right [ḥaqqun ma'lūm] for the petitioner [al-sā'il] and the deprived [al-maḥrūm]'), Qur'an 9:60 ('Zakāh expenditures are only for the poor [al-fuqarā'] and the needy [al-masākīn]...'), and Sahih Al-Bukhari 6546 ('The poor will enter Paradise five hundred years before the rich').",
                        "Canonized in the Prophetic era by Ahl Al-Ṣuffah—the 70 to 400 destitute Companions (including Abū Hurayrah, Bilāl ibn Rabāḥ, Salmān Al-Fārisī, and Abū Dharr) who lived on the shaded portico of the Prophet's Mosque in Medina, studying revelation day and night, with whom the Prophet ﷺ was commanded by Qur'an 18:28 to sit patiently rather than seeking the company of wealthy aristocrats.",
                        "#38BDF8"
                ),
                new IslamicManAndCaravanArchetype(
                        4,
                        "THE MAN OF THE CARAVAN",
                        "Ibn Al-Qāfilah / Amīr Al-Rakb / Al-Dalīl (ابْن القَافِلَة وَأَمِير الرَّكْب وَالدَّلِيل)",
                        "The Man of the Caravan: Master of the Desert Artery, the Khān & Celestial Navigation",
                        "Marches across the great trans-continental arteries—the Hijazi Spice & Ḥajj Roads (Darb Zubaydah, Darb Al-Ḥājj Al-Shāmī, Darb Al-Ḥājj Al-Miṣrī), the Silk Road (Samarkand–Kashgar–Nishapur), and the Trans-Saharan Gold Routes (Sijilmasa–Taghaza–Timbuktu–Kano)—guided by the desert navigator (Al-Dalīl / Al-Khirrīt) who reads the stars, wind-dunes, and soil scent by night, halting every 30 km (1 Marḥalah) at a fortified Caravanserai (Khān / Ribāṭ).",
                        "Qur'an 106:1–2 ('For the accustomed security of the Quraysh—their accustomed security in the caravan of winter [Yemen] and summer [Syria]') & Sahih Al-Bukhari 2998 ('Travel is a piece of torment [Al-Safaru qiṭ'atun min al-'adhāb]; it prevents one of you from his sleep, food, and drink').",
                        "Governed by strict Prophetic caravan constitutionalism: 'When three people set out on a journey, let them appoint one of their number as their Amīr [leader]' (Sunan Abi Dawud 2608). The Caravan Man carries not only silk, frankincense, gold dust, and paper manuscripts, but also letters of credit (Suftajah), judicial correspondence, and Hajj pilgrims from every corner of the earth.",
                        "#F59E0B"
                ),
                new IslamicManAndCaravanArchetype(
                        5,
                        "THE MAN LOST AT THE CARAVAN",
                        "Al-Ḍāll / Al-Munqaṭi' / Ibn Al-Sabīl (ابْن السَّبِيل وَالضَّالّ فِي الفَلَاة)",
                        "The Man Lost at the Caravan: 'The Son of the Road' (Ibn Al-Sabīl) & Desert Rescue Theology",
                        "Separated from the main column by a blinding sandstorm (Samūm / Habūb), a broken camel tether in the dead of night, or raiders, finding himself stranded in the waterless waste (Al-Falāt / Al-Mafāzah) with his provisions cut off—even if he is a wealthy merchant or scholar back in his distant homeland.",
                        "Qur'an 9:60 (naming Ibn Al-Sabīl—the stranded wayfarer cut off from his resources—as the 8th canonical category of Zakāh recipients), Qur'an 2:177, and Sahih Muslim 2747 ('Allah is more joyful at the repentance of His servant when he turns to Him than one of you who was upon his mount in a waterless desert [ard falāt], and it escaped from him carrying his food and drink, so he despaired of it and lay down under a tree awaiting death—then suddenly he awakens to find his camel standing right before him with its reins!).",
                        "Because of this Qur'anic mandate, Islamic civilization constructed an entire life-saving infrastructure for the Man Lost at the Caravan: fire-lit beacon towers (Al-Manāwir / Al-Mīl) along Darb Zubaydah that burned all night to guide lost stragglers, endowed Waqf cisterns (Sabīl / Birak), and the special Waqf of Ibn Al-Sabīl in Damascus, Cairo, and Fez specifically tasked with clothing, feeding, and financing lost travelers back to their homes.",
                        "#A855F7"
                ),
                new IslamicManAndCaravanArchetype(
                        6,
                        "THE MAN AT THE END OF THE CARAVAN",
                        "Ṣāḥib Al-Sāqah / Al-Ḍa'īf fī Ākhir Al-Qāfilah (صَاحِب السَّاقَة فِي آخِر القَافِلَة)",
                        "The Man at the End of the Caravan: The Exhausted Straggler & the Prophetic Rear-Guard",
                        "Lags at the dusty tail-end of the column (Al-Sāqah / Al-Mu'akhkharah) because his mount is lame, his water-skin is leaking, his feet are blistered, or he is carrying the sick and elderly—the exact position where predatory bandits strike and where ruthless empires abandon the weak.",
                        "Sunan Abi Dawud 2639 & Al-Ḥākim ('The Messenger of Allah ﷺ used to march at the very rear of the caravan [fī ākhiri al-qāfilah] to urge on the weak [yuzjī al-ḍa'īf], carry the straggler behind him on his own saddle [yurdifu], and make supplication for them') & Sahih Al-Bukhari 2902 ('Seek me among your weak ones, for you are only given provision and victory by virtue of your weak ones!').",
                        "Immortalized in the Hadith of Jābir ibn 'Abd Allāh (Sahih Al-Bukhari 2097; Sahih Muslim 715): Jābir was riding a slow, exhausted camel at the very end of the caravan when the Prophet ﷺ caught up to him from the rear, prayed over the camel and tapped it (whereupon it surged ahead to the front of the column), conversed gently with Jābir about his father's debts and his marriage, bought the camel for gold, and upon reaching Medina gave Jābir both the gold price and the camel itself! In the Ottoman and Mamluk Hajj caravans, the Amīr Al-Ḥājj maintained a dedicated rear-guard ambulance corps (Sāqat Al-Maḥmal) with spare camels, physicians, and water-skins specifically so no person at the end of the caravan would ever be abandoned.",
                        "#F43F5E"
                ),
                new IslamicManAndCaravanArchetype(
                        7,
                        "THE MAN LEFT BEHIND BY THE CARAVAN THROUGH ANTIQUITY",
                        "Al-Mukhallaf / Al-Mutakhallif 'an Al-Rakb (المُخَلَّف عَن الرَّكْب عَبْرَ العُصُور)",
                        "The Man Left Behind by the Caravan: Abū Dharr, the Three of Qur'an 9:118 & the Poetic Ruin",
                        "Experiences the ultimate existential solitude of antiquity: watching the dust of the departing caravan vanish over the horizon while remaining behind—either through physical exhaustion of his mount, through moral hesitation followed by piercing remorse, or through ascetic renunciation of the world.",
                        "Qur'an 9:118 ('And [He also forgave] the three who were left behind [wa 'alā al-thalāthati alladhīna khullifū] to the point that the earth closed in on them in spite of its vastness, and their own souls closed in on them, and they realized that there is no refuge from Allah except in Him; then He turned to them so that they might repent! Indeed, Allah is the Accepting of Repentance, the Merciful').",
                        "Three timeless historical archetypes define the Man Left Behind by the Caravan: (1) Abū Dharr Al-Ghifārī on the Tabuk march (630 CE / 9 AH): when his emaciated camel collapsed in the desert, he untied his pack, hoisted it onto his own shoulders, and walked alone on foot in the tracks of the army until the watchers saw a lone silhouette shimmering in the mirage, prompting the Prophet ﷺ to declare: 'Be he Abū Dharr! May Allah have mercy on Abū Dharr—he walks alone, he will die alone, and he will be resurrected alone!' (Ibn Hishām / Al-Ḥākim); (2) Ka'b ibn Mālik, Murārah ibn Al-Rabī', and Hilāl ibn Umayyah, who stayed behind in the shade and ripe dates of Medina without excuse, refused to lie to the Prophet ﷺ upon his return, endured 50 days of penitent solitude until the earth felt constricted around them, and were immortalized forever in Qur'an 9:118 as the paradigm of truth-telling redeeming failure; and (3) The Pre-Islamic & Islamic Poetic Archetype of Wuqūf 'alā Al-Aṭlāl (standing alone at the abandoned camp-traces after the beloved's caravan has departed), transformed by Sufi masters like Ibn 'Arabī and Rūmī into the awakening of the soul that misses the worldly caravan only to find God waiting in the stillness.",
                        "#14B8A6"
                )
        );
    }

    public static List<CaliphateGovernanceOrgan> allSixCaliphateGovernanceOrgans() {
        return List.of(
                new CaliphateGovernanceOrgan(
                        1,
                        "Al-Imāmah wa 'Aqd Al-Khilāfah (عَقْد الإِمَامَة وَالخِلَافَة)",
                        "The Constitutional Executive Trustee Contract",
                        "Al-Māwardī (Al-Aḥkām Al-Sulṭāniyyah, 1058 CE), Al-Juwaynī (Ghiyāth Al-Umam), and Ibn Khaldūn (Al-Muqaddimah, 1377 CE)",
                        "Defines the Caliphate as a vicarship of Prophetic stewardship 'for the guarding of the religion and the temporal governance of the world' (Ḥirāsat al-dīn wa siyāsat al-dunyā). The Caliph is not an infallible theocrat or divine monarch, but a contracted agent (Wakīl) of the Ummah bound by the first constitutional address of Abū Bakr Al-Ṣiddīq (632 CE): 'Obey me so long as I obey Allah and His Messenger among you; if I disobey Allah and His Messenger, you owe me no obedience!'",
                        "Subject to deposition or correction if he violates the covenant of justice ('Adālah) or abandons the defense and welfare of the public."
                ),
                new CaliphateGovernanceOrgan(
                        2,
                        "Ahl Al-Ḥall wa Al-'Aqd wa Majlis Al-Shūrā (أَهْل الحَلّ وَالعَقْد وَالشُّورَى)",
                        "'Those Who Loosen and Bind' — The Consultative & Electoral Assembly",
                        "Qur'an 42:38 ('And their affair is determined by consultation among themselves') & 'Umar ibn Al-Khaṭṭāb's Six-Member Electoral Shūrā Council (644 CE)",
                        "Composed of the foremost jurists ('Ulamā'), civic leaders (Nuqabā'), tribal/provincial representatives, military commanders, and guild elders who nominate, vet, and contract the head of state and deliberate on war, peace, taxation, and public policy.",
                        "Holds the constitutional authority to bind ('Aqd) and dissolve (Ḥall) executive legitimacy prior to general public ratification (Al-Bay'ah Al-'Āmmah)."
                ),
                new CaliphateGovernanceOrgan(
                        3,
                        "Al-Wizārah wa Al-Dawāwīn (الوِزَارَة وَالدَّوَانِين)",
                        "The Vizierate & Specialized Administrative Ministries (Dīwāns)",
                        "Instituted by 'Umar ibn Al-Khaṭṭāb (638–640 CE) and expanded under the Umayyads, Abbasids, Fatimids, and Ottomans",
                        "Divided by Al-Māwardī into Wizārat Al-Tafwīḍ (plenipotentiary Prime Ministry) and Wizārat Al-Tanfīdh (executive cabinet), overseeing the specialized ministries: Dīwān Al-Bayt Al-Māl (Public Treasury separating Zakāh, Kharāj, Jizyah, and Fay'), Dīwān Al-Jund (Military Stipends & Pensions), Dīwān Al-Rasā'il (Chancery), Dīwān Al-Barīd (Postal & Intelligence Network), and Dīwān Al-Mā' (Hydraulic & Irrigation Board).",
                        "Every Dīwān is audited by Dīwān Al-Zimām / Dīwān Al-Azimmah (the Supreme Audit Bureau established under Caliph Al-Mahdī in 779 CE)."
                ),
                new CaliphateGovernanceOrgan(
                        4,
                        "Al-Qaḍā' wa Qāḍī Al-Quḍāt (القَضَاء وَقَاضِي القُضَاة)",
                        "The Independent Judiciary & Chief Justice of the Realm",
                        "'Umar ibn Al-Khaṭṭāb's Constitutional Letter on Judicial Procedure to Abū Mūsā Al-Ash'arī; Abū Yūsuf (Kitāb Al-Kharāj, first Qāḍī Al-Quḍāt)",
                        "Applies canonical Fiqh across civil, commercial, family, property, and criminal cases. In classical Islamic constitutionalism, the Qāḍī's court is strictly egalitarian: when Caliph 'Alī ibn Abī Ṭālib appeared before Qāḍī Shurayḥ in a dispute with a Jewish citizen over a coat of armor, Qāḍī Shurayḥ ruled in favor of the Jewish citizen because the Caliph had no independent witness beyond his own son and freedman!",
                        "Judges hold tenure independent of provincial governors; judicial rulings remain valid even after the Caliph who appointed the judge dies or is deposed."
                ),
                new CaliphateGovernanceOrgan(
                        5,
                        "Wilāyat Al-Maẓālim wa Dār Al-'Adl (وِلَايَة المَظَالِم وَدَار العَدْل)",
                        "The Supreme Court of Public Grievances Against State Officials",
                        "Prophetic endorsement of Ḥilf Al-Fuḍūl; Abbasid Caliph Al-Muhtadī, Nūr Al-Dīn Zangī's Dār Al-'Adl in Damascus, and Mamluk Cairo's Sultanic Maẓālim sessions",
                        "A specialized high constitutional tribunal possessing coercive power superior to ordinary courts, specifically created so that any commoner, peasant, woman, merchant, or non-Muslim Dhimmi could file a direct petition (Qiṣṣah / Ruq'ah) against a powerful governor, tax collector, general, or royal prince for extortion, land seizure, or abuse of authority.",
                        "Combines the authority of the sovereign with the presence of the Chief Qāḍīs and Muftīs, compelling governors to restore seized property on the spot."
                ),
                new CaliphateGovernanceOrgan(
                        6,
                        "Wilāyat Al-Ḥisbah wa Al-Muḥtasib (وِلَايَة الحِسْبَة وَالمُحْتَسِب)",
                        "The Municipal Ombudsman, Market Regulator & Public Welfare Inspector",
                        "Qur'an 3:104; Al-Shayzarī (Nihāyat Al-Rutbah fī Ṭalab Al-Ḥisbah) and Ibn Al-Ukhuwwah",
                        "Patrols the markets, streets, bathhouses, and workshops daily to verify calibrated brass weights and measures, test milk and bread for adulteration, prevent price-gouging hoarding (Iḥtikār), inspect building safety, enforce municipal hygiene and sewer clearance, and—remarkably—prohibit the overloading or beating of pack animals and the overworking of laborers and apprentices.",
                        "Historically staffed by both men and women (beginning with 'Umar ibn Al-Khaṭṭāb's appointment of Al-Shifā' bint 'Abd Allāh as market inspector of Medina)."
                )
        );
    }

    public static List<IslamicSuffragePillarAndCause> allNineSuffragePillarsAndCauses() {
        return List.of(
                new IslamicSuffragePillarAndCause(
                        1,
                        "PILLAR I OF ISLAMIC SUFFRAGE: DELIBERATIVE FRANCHISE",
                        "Al-Shūrā (الشُّورَى — Mutual Consultation)",
                        "Constitutional Deliberation & Collective Decision-Making",
                        "Qur'an 42:38 ('And their affair is determined by mutual consultation among themselves' — wa amruhum shūrā baynahum) & Qur'an 3:159 ('So pardon them, ask forgiveness for them, and consult them in the matter' — wa shāwirhum fī al-amr)",
                        "Names the fundamental deliberative right of the community. Remarkably, Qur'an 3:159 was revealed immediately after the Battle of Uḥud (625 CE)—where the Prophet ﷺ had personally favored staying inside Medina, but yielded to the majority vote of the enthusiastically vocal young Companions to march out, and even after that majority vote led to a military setback, God commanded the Prophet ﷺ to keep consulting them!",
                        "Establishes that participatory suffrage (Shūrā) is never revoked because of human error; prior to Badr (Al-Ḥubāb ibn Al-Mundhir changing camp strategy) and the Trench (Salmān Al-Fārisī proposing the Khandaq), ordinary citizens reshaped state strategy through Shūrā.",
                        "#10B981"
                ),
                new IslamicSuffragePillarAndCause(
                        2,
                        "PILLAR II OF ISLAMIC SUFFRAGE: ELECTORAL CONSENT & PLEBISCITE",
                        "Al-Bay'ah wa Al-Ikhtiyār (البَيْعَة وَالاخْتِيَار — Contractual Suffrage)",
                        "Bilateral Electoral Pledge, Universal Polling & Independent Female Suffrage",
                        "Qur'an 48:10, 48:18 (Bay'at Al-Riḍwān) & Qur'an 60:12 ('O Prophet, when the believing women come to you pledging allegiance to you... then accept their pledge' — Bay'at Al-Nisā')",
                        "Derived from Bay' (a bilateral contract of exchange), Al-Bay'ah means that political authority in Islam is never self-originating; it is conferred by the explicit consent and handshake/oath of the governed. Crucially, Qur'an 60:12 instituted independent female political suffrage in 628–630 CE, centuries before modern Western feminism: women gave Bay'ah directly in their own legal capacity, even when their fathers or husbands had not yet accepted Islam.",
                        "Reached its procedural apex in the 644 CE (23 AH) Election of Caliph 'Uthmān ibn 'Affān: as recorded by Al-Ṭabarī and Ibn Kathīr, the electoral commissioner 'Abd Al-Raḥmān ibn 'Awf spent three days and nights conducting a universal plebiscite across Medina—polling the senior Companions, the army commanders, the common artisans, 'even the women in their private quarters' (ḥattā al-nisā' fī khudūrihinna), the students in the schools, and the incoming caravan riders at the city gates!",
                        "#D4AF37"
                ),
                new IslamicSuffragePillarAndCause(
                        3,
                        "PILLAR III OF ISLAMIC SUFFRAGE: TRANSFORMING PAIN INTO LAW",
                        "Al-Tajādul wa Al-Ishtikā' (التَّجَادُل وَالاشْتِكَاء — Sūrat Al-Mujādilah)",
                        "The Canonical Name for Turning What You Go Through Into Systemic Change",
                        "Qur'an 58:1–4 ('Certainly has Allah heard the speech of the woman who argues with you [qawl allatī tujādiluka] concerning her husband and directs her complaint to Allah [wa tashtakī ilā Allāh]. And Allah hears your dialogue; indeed, Allah is Hearing and Seeing')",
                        "If one asks: 'What does the Qur'an name the ability to take the suffering you go through, voice it to authority, and effect permanent legal change?' The canonical Qur'anic name is Al-Mujādilah / Al-Ishtikā' (Principled Contestation & Petition). When Khawlah bint Tha'labah was subjected by her husband Aws ibn Al-Ṣāmit to the pagan Arab custom of Ẓihār (declaring 'You are to me like my mother's back,' which left a wife trapped in lifelong marital limbo with hungry children), she refused to accept silent victimization. She walked straight to Muhammad ﷺ, debated the legal vacuum with him, and raised her complaint to God.",
                        "Her personal anguish immediately triggered the descent of Sūrat Al-Mujādilah (Chapter 58), outlawing the oppressive custom of Ẓihār across all of Islamic law forever and instituting mandatory expiation (freeing a slave, fasting two months, or feeding sixty poor people). Years later, when Caliph 'Umar ibn Al-Khaṭṭāb was riding with his retinue of generals and governors, an elderly Khawlah stopped him in the street and admonished him at length to fear God regarding the poor; when a guard asked 'Umar why he stood in the sun listening to an old woman, 'Umar replied: 'Woe to you! Do you know who this is? This is the woman whose complaint Allah heard from above the seven heavens—so by Allah, if she kept me standing until nightfall, I would only leave for mandatory prayer!'",
                        "#F43F5E"
                ),
                new IslamicSuffragePillarAndCause(
                        4,
                        "PILLAR IV OF ISLAMIC SUFFRAGE: SPEAKING TRUTH TO POWER",
                        "Al-Naṣīḥah wa Ḥilf Al-Fuḍūl (النَّصِيحَة وَحِلْف الفُضُول وَكَلِمَة العَدْل)",
                        "The Civic Franchise of Accountability, Protest Against Tyranny & The League of the Virtuous",
                        "Qur'an 9:71 ('The believing men and believing women are allies of one another; they enjoin what is right and forbid what is wrong'); Sahih Muslim 55 ('Religion is sincere counsel [Al-Dīnu al-naṣīḥah]—to Allah, His Book, His Messenger, the leaders of the Muslims, and their common folk'); Sunan Abi Dawud 4344 ('The greatest Jihad is a word of justice spoken before an unjust ruler')",
                        "Paired with the Prophet's ﷺ lifelong celebration of Ḥilf Al-Fuḍūl (The Pact of the Virtuous)—formed in Mecca after a Yemeni merchant from Zabid was defrauded of his goods by a powerful Qurayshi noble, stood on Mount Abū Qubays crying out his grievance, and compelled the honorable clans to swear that no person, native or stranger, would ever be wronged in Mecca without the league rising as one hand until his right was restored.",
                        "Gives every citizen—male or female, rich or poor—both the constitutional right and the religious duty to audit rulers, strike down unlawful decrees, and mobilize collective civic solidarity.",
                        "#38BDF8"
                ),
                new IslamicSuffragePillarAndCause(
                        5,
                        "CAUSE VECTOR I: THE MOST COMMON CAUSES",
                        "Qaḍāyā Al-'Āmmah (قَضَايَا العَامَّة — Bread, Water, Taxes, Wages & Courts)",
                        "The Everyday Causes of the Common People Across the Caliphates",
                        "Sunan Ibn Majah 2443 ('Give the worker his wages before his sweat dries'); Sunan Abi Dawud 3477 ('Muslims are partners in three things: water, pasture, and fire'); Sahih Muslim 1605 ('Whoever hoards grain to drive up prices is a sinner')",
                        "Throughout Islamic history, when the common people (Al-'Āmmah), artisans, and peasants exercised their suffrage in Friday mosque protests, petitions to Dār Al-Maẓālim, or guild strikes, their Five Most Common Causes were: (1) Bread & Grain Anti-Hoarding (demanding the Muḥtasib open state granaries and punish grain monopolists during drought); (2) Abolition of Non-Canonical Taxes (Al-Mukūs — illegal market tolls and urban octrois condemned by the 'Ulamā'); (3) Public Water & Commons Access (protecting rivers, canals, and Sabīl fountains from private privatization); (4) Prompt Living Wages & Debt Relief; and (5) Removal of Tyrannical Provincial Governors.",
                        "Notably, in Mamluk Cairo, Abbasid Baghdad, and Ottoman Damascus/Istanbul, when bread prices spiked or a governor imposed illegal Mukūs taxes, the commoners marched with the 'Ulamā' holding open Qur'ans to the citadel until the Sultan issued a carved stone decree (Marsūm) on the mosque wall abolishing the tax!",
                        "#F59E0B"
                ),
                new IslamicSuffragePillarAndCause(
                        6,
                        "CAUSE VECTOR II: THE ROYAL CAUSES",
                        "Qaḍāyā Al-Khāṣṣah wa Al-Mulūk (قَضَايَا الخَاصَّة وَالمُلُوك وَالسِّيَاسَة)",
                        "The Causes of Caliphs, Sultans & Viziers: Legitimacy, Frontiers, Sound Coinage & Waqf Monumentality",
                        "Qur'an 4:58 ('Indeed, Allah commands you to render trusts to whom they are due and when you judge between people to judge with justice') & Qur'an 22:41",
                        "The Royal Causes centered on: (1) Constitutional Legitimacy & Succession (securing the Bay'ah of Ahl Al-Ḥall wa Al-'Aqd and the recognition of the Khuṭbah in Mecca and Medina); (2) Defense of the Frontier Marches (Al-Thughūr) and the Security of the Hajj Caravans (Amīr Al-Ḥājj); (3) Monetary Integrity of the Gold Dīnār and Silver Dirham against debasement; (4) Solvency of Bayt Al-Māl to pay the army without oppressing the peasantry (as formulated in the Circle of Justice / Dā'irat Al-'Adl); and (5) Immortalizing the dynasty through grand Waqf complexes (Kuliyyahs, Bīmāristāns, observatories, and libraries).",
                        "A ruler who maintained the Circle of Justice—where no royal power survives without the army, no army without wealth, no wealth without prosperous subjects, and no prosperous subjects without justice—enjoyed enduring legitimacy.",
                        "#A855F7"
                ),
                new IslamicSuffragePillarAndCause(
                        7,
                        "CAUSE VECTOR III: THE YOUNG CAUSES",
                        "Qaḍāyā Al-Shabāb wa Al-Fityān (قَضَايَا الشَّبَاب وَالفِتْيَان)",
                        "The Causes of Youth: Meritocracy, Moral Courage, Marriage Access & Reform Vanguard",
                        "Qur'an 18:13 ('Indeed, they were youths [Fityah] who believed in their Lord, and We increased them in guidance'); Qur'an 21:60 ('We heard a youth [Fatan] mention them who is called Ibrāhīm'); Sahih Al-Bukhari 660 (The Youth Who Grew Up in the Worship of Allah under the Shade of the Throne)",
                        "Rooted in the extraordinary youth of the early Islamic vanguard—where 'Alī ibn Abī Ṭālib accepted Islam as a boy, Al-Arqam opened his house (Dār Al-Arqam) at age 16, Muṣ'ab ibn 'Umayr became Medina's first teacher-ambassador in his twenties, Mu'ādh ibn Jabal was appointed Chief Judge and Governor of Yemen at age 27, and Usāmah ibn Zayd (son of a formerly enslaved father) was appointed by the Prophet ﷺ at age 18 as Supreme Commander over Abū Bakr and 'Umar!",
                        "Across history and today, the Young Causes champion: (1) Meritocracy over aristocratic lineage (enabling an emancipated youth or poor Madrasah student on a Waqf stipend to rise to Chief Judge or Grand Vizier); (2) Facilitating Marriage (Taysīr Al-Nikāḥ) against prohibitive dowry inflation and tribal elitism; (3) Chivalric Futūwwah solidarity against corruption; and (4) Educational, scientific, and employment empowerment.",
                        "#38BDF8"
                ),
                new IslamicSuffragePillarAndCause(
                        8,
                        "CAUSE VECTOR IV: THE OLD CAUSES",
                        "Qaḍāyā Al-Shuyūkh wa Ahl Al-Shaybah (قَضَايَا الشُّيُوخ وَالبِرّ وَالوَقَار)",
                        "The Causes of Elders: Filial Reverence, Statutory Exemptions, Pension Security & Isnād Wisdom",
                        "Qur'an 17:23–24 ('Whether one or both of them reach old age with you, say not to them as much as \"uff,\" and do not repel them, but speak to them a noble word, and lower to them the wing of humility out of mercy'); Sunan Abi Dawud 4843 ('Part of glorifying Allah is honoring the grey-haired Muslim elder')",
                        "The Old Causes institutionalize four pillars of senior dignity: (1) Statutory Legal & Ritual Relief—exempting the frail elder (Al-Shaykh Al-Fānī) from fasting Ramadan (replaced by Fidyah feeding a poor person per day, Qur'an 2:184), permitting seated or lying prayer, and strictly forbidding the harming of elders in warfare; (2) Universal Social Security Pensions—exemplified when Caliph 'Umar ibn Al-Khaṭṭāb saw an elderly blind Jewish beggar in Medina/Damascus, took him by the hand to his own home, and ordered the head of Bayt Al-Māl: 'By Allah, we would not be fair if we ate his tax in his youth and abandoned him in his old age!'—abolishing his Jizyah and granting him a lifelong state pension (Abū Yūsuf, Kitāb Al-Kharāj); (3) Authority of the Isnād (where the oldest living transmitter of Hadith, the Musnid Al-'Aṣr, held the highest scholarly prestige because of his short chain to the Prophet ﷺ); and (4) Family Waqf (Waqf Ahlī) protection against elder abandonment.",
                        "Ensures that aging in Islamic civilization is an ascent in honor, consultative weight (Majlis Al-Shuyūkh), and legal protection rather than economic dispossession.",
                        "#14B8A6"
                ),
                new IslamicSuffragePillarAndCause(
                        9,
                        "CAUSE VECTOR V: GENDER, AGENCY & EFFECTING CHANGE (PAST & TODAY)",
                        "Al-Mar'ah wa Al-Taghyīr Al-Tashrī'ī (المَرْأَة وَالتَّغْيِير التَّشْرِيعِيّ ماضِياً وَحَاضِراً)",
                        "How Gender Impacts Suffrage: From Prophetic Constitutional Precedents to Modern Global Reform",
                        "Qur'an 33:35 (revealed after Umm Salamah's question, explicitly naming Muslim men and Muslim women across 10 moral ranks), Qur'an 58:1 (Khawlah bint Tha'labah), Qur'an 60:12 (Bay'at Al-Nisā'), and Qur'an 4:7 & 4:32",
                        "Demonstrates that in Islam's foundational architecture, women's suffrage was not a passive grant from men, but an active constitutional force whereby women took what they personally endured—marital abuse, forced marriage, inheritance deprivation, dowry caps, or wartime displacement—brought it directly before the Prophet ﷺ, the Caliphs, and the Qāḍī courts, and transformed their lived experience into binding scripture and statutory law.",
                        "Today, this heritage powers formal electoral suffrage across all 57 OIC states, 10+ female Presidents and Prime Ministers in Muslim-majority democracies, female Sharī'ah judges (Qāḍiyāt) and state Muftiyāt, and landmark family-code reforms (such as Morocco's 2004 Mudawwanah and statutory Khul' reforms).",
                        "#EC4899"
                )
        );
    }

    public static List<GenderSuffrageAndAgencyMilestone> allSevenGenderSuffrageMilestones() {
        return List.of(
                new GenderSuffrageAndAgencyMilestone(
                        1,
                        "622–632 CE (Medinan Revelation — Sūrat Al-Mujādilah 58:1–4)",
                        "Khawlah bint Tha'labah (خَوْلَة بِنْت ثَعْلَبَة)",
                        "Qur'an 58:1 ('Certainly has Allah heard the speech of the woman who argues with you concerning her husband and directs her complaint to Allah')",
                        "Subjected by her elderly husband Aws ibn Al-Ṣāmit to the pre-Islamic pagan formula of Ẓihār ('You are to me like my mother's back'), which trapped a woman in perpetual limbo—forbidden to her husband yet never freed to remarry, while her children faced starvation.",
                        "Refused to accept the status quo; argued her case directly before the Prophet ﷺ and pleaded to God, resulting in the immediate revelation of Sūrat Al-Mujādilah (Chapter 58), permanently abolishing pagan Ẓihār across the entire Muslim world and establishing the supreme Qur'anic precedent that a single woman's lived grievance can overturn centuries of patriarchal custom."
                ),
                new GenderSuffrageAndAgencyMilestone(
                        2,
                        "626–628 CE (Medina — Sūrat Al-Aḥzāb 33:35 & Sūrat Āl 'Imrān 3:195)",
                        "Umm Salamah Hind bint Abī Umayyah & Asmā' bint 'Umays (أُمّ سَلَمَة وَأَسْمَاء بِنْت عُمَيْس)",
                        "Qur'an 33:35 ('Indeed, the Muslim men and Muslim women, the believing men and believing women, the obedient men and obedient women, the truthful men and truthful women...') & Qur'an 3:195 ('Never will I allow to be lost the work of any worker among you, whether male or female; you are of one another')",
                        "Questioned why the Qur'anic revelations up to that moment frequently used the default Arabic masculine plural (Al-Muslimūn) when women were enduring the exact same persecutions, migrations (Hijrah to Abyssinia and Medina), and sacrifices as men.",
                        "Prompted the descent of Qur'an 33:35—which explicitly pairs the feminine plural beside the masculine plural ten consecutive times in a single verse—and Qur'an 3:195, forever enshriningontological, spiritual, and moral parity in the text of the Qur'an."
                ),
                new GenderSuffrageAndAgencyMilestone(
                        3,
                        "625–631 CE (Medina — Precedent of Autonomous Marriage Consent & Inheritance)",
                        "Al-Khansā' bint Khidām & The Young Woman of Medina (الخَنْسَاء بِنْت خِدَام وَالفَتَاة البِكْر)",
                        "Sunan Ibn Majah 1874, Sahih Al-Bukhari 5138 & Qur'an 4:7 (Revealed after the widow of Sa'd ibn Al-Rabī' petitioned on behalf of her two orphaned daughters)",
                        "A young woman came to the Prophet ﷺ to report that her father had married her off to his nephew without her consent to elevate his own social standing; similarly, the widow of the martyr Sa'd ibn Al-Rabī' came to the Prophet ﷺ when her husband's brother seized the entire estate under pagan custom because Sa'd left only daughters.",
                        "In the marriage suit, the Prophet ﷺ immediately granted the young woman the right to annul the marriage; once she won the ruling, she declared: 'I now validate what my father did, Settle it—I only did this so that women would know that fathers have no authority over their daughters' affairs!' In the inheritance suit, Qur'an 4:7 and 4:11 were revealed, granting women and daughters fixed, unalterable statutory inheritance shares 1,200 years before the British Married Women's Property Act of 1882."
                ),
                new GenderSuffrageAndAgencyMilestone(
                        4,
                        "c. 636–644 CE (Caliphate of 'Umar ibn Al-Khaṭṭāb — Medina & Mecca)",
                        "The Woman of Medina in the Mosque & Al-Shifā' bint 'Abd Allāh (المرأة المُعْتَرِضَة وَالشِّفَاء بِنْت عَبْد اللَّه)",
                        "Qur'an 4:20 ('And if you have given one of them a heap of gold [Qinṭār], take nothing back from it'); Musannaf 'Abd Al-Razzāq 10420; Ibn Sa'd (Al-Ṭabaqāt)",
                        "When Caliph 'Umar ibn Al-Khaṭṭāb stood on the pulpit of the Prophet's Mosque and proposed placing a statutory ceiling on women's marriage dowries (Mahr), a woman rose from the back rows of the mosque and publicly challenged the Caliph's constitutional authority by reciting Qur'an 4:20 ('You have no right to restrict what Allah has granted us!').",
                        "Caliph 'Umar immediately withdrew his decree on the spot, proclaiming before the entire congregation: 'A woman is right, and 'Umar is wrong!' (Aṣābat imra'atun wa akhṭa'a 'Umar). Furthermore, 'Umar appointed the literate physician-scholar Al-Shifā' bint 'Abd Allāh as public Market Inspector (Muḥtasibah / Wāliyat Al-Sūq) of Medina and Samrā' bint Nuhayk in Mecca."
                ),
                new GenderSuffrageAndAgencyMilestone(
                        5,
                        "802–859 CE (Abbasid Hijaz & Idrisid Fez — Civil Engineering & University Waqf)",
                        "Zubaydah bint Ja'far (802 CE) & Fāṭimah Al-Fihriyyah (859 CE) (زُبَيْدَة بِنْت جَعْفَر وَفَاطِمَة الفِهْرِيَّة)",
                        "Ibn Khallikān (Wafayāt Al-A'yān) & Ibn Abī Zar' (Rawḍ Al-Qirṭās)",
                        "Zubaydah personally witnessed the agonizing thirst of pilgrims and the poor in Mecca and along the desert caravan trail; when her chief engineers warned that blasting aqueducts through solid granite mountains and building 54 reservoirs across 1,500 km from Kufa to Mecca would cost a fortune, she replied: 'Carry it out, even if every single stroke of the pickaxe costs a gold Dīnār!' Half a century later in Fez, Fāṭimah Al-Fihriyyah fasted continuously while supervising the construction of Al-Qarawiyyīn from her own lawful inheritance.",
                        "Transformed personal empathy and female financial autonomy into the two greatest public works of classical Islamic civilization: the 1,500 km Darb Zubaydah hydraulic system and the world's oldest continuously operating degree-granting university (Al-Qarawiyyīn, 859 CE)."
                ),
                new GenderSuffrageAndAgencyMilestone(
                        6,
                        "12th–19th Centuries (Damascus, Cairo, Fez & Istanbul — Sharī'ah Court Sijillāt & Hadith Chairs)",
                        "Shuhdah Al-Kātibah ('Pride of Women', d. 1178), 'Ā'ishah Al-Bā'ūniyyah (d. 1517), Nana Asma'u of Sokoto (d. 1864) & Litigants of the Qāḍī Courts",
                        "Documented in biographical dictionaries (Al-Sakhāwī's Kitāb Al-Nisā' with 1,075 female scholars; Ibn Ḥajar studied under 53 female Hadith masters) and Ottoman/Mamluk court registers (Sijillāt)",
                        "Women across the classical Sultanates faced domestic disputes, property encroachment, or distance from formal schooling (as in rural West Africa under the Sokoto Caliphate).",
                        "In Damascus, Baghdad, and Cairo, female Muḥaddithāt held public chairs in the Umayyad and Al-Azhar mosques issuing signed Ijāzahs to male and female scholars alike; in West Africa, Nana Asma'u organized the Yan Taru network of traveling women teachers educating tens of thousands of rural women in Arabic, Hausa, and Fulfulde; and across Ottoman/Mamluk courts, women personally argued their own lawsuits and inserted binding marriage contract stipulations (Shurūṭ—such as forbidding the husband from taking a second wife or relocating her without consent)."
                ),
                new GenderSuffrageAndAgencyMilestone(
                        7,
                        "1918–Present (Modern Constitutional Suffrage, Heads of State & Legal Reform Across the 57 OIC Nations)",
                        "First Muslim-World Universal Suffrage in Azerbaijan (1918) & Türkiye (1930/1934) to 10+ Female Heads of State & Contemporary Female Qāḍīs",
                        "Modern Constitutional Charters, Morocco's 2004 Mudawwanah, Egypt's 2000 Khul' Law, and OIC Women's Development Organization (WDO)",
                        "Confronted colonial disruption, post-colonial authoritarianism, patriarchal custom masquerading as religion, and barriers to ballot access and judicial office.",
                        "The Azerbaijan Democratic Republic granted women full voting suffrage in 1918 (ahead of the United States in 1920 and the UK in 1928), followed by Türkiye (1930/1934), Indonesia (1945), Pakistan (1947), and Syria (1949). Muslim-majority nations have elected over ten female Presidents and Prime Ministers—including Benazir Bhutto (Pakistan, 1988), Khaleda Zia & Sheikh Hasina (Bangladesh, 1991/1996), Tansu Çiller (Türkiye, 1993), Megawati Sukarnoputri (Indonesia, 2001), Mame Madior Boye (Senegal, 2001), Cissé Mariam Kaïdama Sidibé (Mali, 2011), Atifete Jahjaga & Vjosa Osmani (Kosovo), and Samia Suluhu Hassan (Tanzania)—while female Islamic judges (Qāḍiyāt) and state Muftiyāt adjudicate in Indonesia, Malaysia, Morocco, Tunisia, Palestine, Egypt, and Pakistan."
                )
        );
    }
}
