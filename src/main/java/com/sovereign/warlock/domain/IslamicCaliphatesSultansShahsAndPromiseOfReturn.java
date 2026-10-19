package com.sovereign.warlock.domain;

import java.util.List;

/**
 * Canonical Islamic Historical, Theological & Constitutional Atlas of:
 * 1. The 5 Prophetic Political Phases of the Ummah (Hadith of Hudhayfah ibn Al-Yaman, Musnad Ahmad 18406):
 *    Nubuwwah -> Khilafah 'ala Minhaj An-Nubuwwah -> Mulkun 'Add (Biting Hereditary Kingship) ->
 *    Mulkun Jabriyyah (Coercive Rule) -> Return of Khilafah 'ala Minhaj An-Nubuwwah.
 * 2. The 7 Canonical Polities — Caliphates (Al-Khilafah), Sultanates (As-Saltanah), Shahdoms (Ash-Shahanshahiyyah /
 *    Padishah), and Dynasties (Ad-Duwal): How Islam Instantiated Each (Istikhlaf & Tamkin, Qur'an 24:55 & 3:26)
 *    and How/Why Each Was Dissolved (Istibdal, Sunnat Al-Mudawalah & Ibn Khaldun's 4-Generation 'Asabiyyah Law).
 * 3. Where Islam Came From (Al-Mabda': Alast, Millat Ibrahim & Cave of Hira'), Where It Has Gone (Al-Masir:
 *    Surviving Every Fallen Throne in 2 Billion Hearts, Waqf, Qur'an & Sunnah), and The Canonical Promise of
 *    Returning (Wa'd Al-'Awdah: Tuba lil-Ghuraba', Centennial Mujaddidun, Return of Prophetic Stewardship,
 *    Al-Mahdi & Descent of 'Isa ibn Maryam).
 */
public final class IslamicCaliphatesSultansShahsAndPromiseOfReturn {

    private IslamicCaliphatesSultansShahsAndPromiseOfReturn() {
    }

    /**
     * Represents one of the 5 canonical political phases foretold by the Prophet Muhammad (peace be upon him)
     * in the Hadith of Hudhayfah ibn Al-Yaman (Musnad Ahmad 18406, graded Hasan / Sahih).
     */
    public record PropheticGovernancePhase(
            int phaseIndex,
            String phaseCode,
            String arabicAndEnglishTitle,
            String historicalEraAndPolities,
            String hadithAndQuranicText,
            String constitutionalCharacter,
            String transitionTriggerToNextPhase,
            String hexAccentColor
    ) {
    }

    /**
     * Represents one of the 7 great historical forms of Islamic polity (Caliphates, Sultanates, Shahdoms, and Dynasties),
     * detailing how Islam instantiated it and how/why Allah's Sunnah in history dissolved it.
     */
    public record CanonicalPolityEpoch(
            int polityIndex,
            String polityCode,
            String titleAndRulingTitle,
            String chronologicalSpanAndCapitals,
            String majorDynastiesAndRulers,
            String canonicalInstantiationMechanism,
            String civilizationalPinnacleAndLegacy,
            String canonicalDissolutionCauses,
            String quranicAndKhaldunianLawAnchor,
            String hexColor
    ) {
    }

    /**
     * Represents one of the 7 stages answering: Where did Islam come from, where has it gone after its empires dissolved,
     * and what is the canonical promise of its return?
     */
    public record OriginJourneyAndReturnStage(
            int stageIndex,
            String stageCode,
            String arabicAndEnglishStageTitle,
            String temporalAndMetaphysicalHorizon,
            String primaryScripturalAndHadithProofs,
            String theologicalAndHistoricalExegesis,
            String enduringGuaranteeForTheBeliever,
            String hexBadgeColor
    ) {
    }

    private static final List<PropheticGovernancePhase> FIVE_PROPHETIC_GOVERNANCE_PHASES = List.of(
            new PropheticGovernancePhase(
                    1,
                    "PHASE-1-AN-NUBUWWAH",
                    "1. Prophethood Among You (تَكُونُ النُّبُوَّةُ فِيكُمْ مَا شَاءَ اللَّهُ أَنْ تَكُونَ — An-Nubuwwah)",
                    "610–632 CE (13 BH – 11 AH) • Mecca & Al-Madīnah Al-Munawwarah",
                    "Musnad Aḥmad 18406: 'Prophethood will remain among you for as long as Allah wills it to remain, then Allah will raise it up when He wills to raise it up.' | Qur'an 3:144 & 33:40 (Khātam An-Nabiyyīn).",
                    "Direct divine revelation (Waḥy), establishing Tawḥīd in Mecca through patient endurance (Ṣabr) and founding the first constitutional Ummah in Medina (Ṣaḥīfat Al-Madīnah) where sovereignty belonged solely to Allah and legislative guidance was living and immediate.",
                    "Completed upon the revelation of Qur'an 5:3 ('Today I have perfected your religion for you') at 'Arafāt and the passing of the Prophet ﷺ in Rabī' al-Awwal 11 AH (June 632 CE).",
                    "#10B981"
            ),
            new PropheticGovernancePhase(
                    2,
                    "PHASE-2-KHILAFAH-RASHIDAH",
                    "2. Caliphate upon the Prophetic Methodology (خِلَافَةٌ عَلَى مِنْهَاجِ النُّبُوَّةِ — Khilāfah 'alā Minhāj An-Nubuwwah)",
                    "632–661 CE (11–40/41 AH — Exactly 30 Lunar Years) • Medina & Kufa",
                    "Musnad Aḥmad 18406 & Sunan Abī Dāwūd 4646 / Tirmidhī 2226 (Safīnah Hadith): 'The Caliphate of Prophethood is thirty years; then Allah will give the kingdom (Al-Mulk) to whomever He wills.'",
                    "Governed by the 4 Rightly Guided Caliphs (Abū Bakr Aṣ-Ṣiddīq, 'Umar Al-Fārūq, 'Uthmān Dhū An-Nūrayn, 'Alī Al-Murtaḍā) and completed by the 6-month caliphate of Al-Ḥasan ibn 'Alī. Marked by Shūrā (consultation), Bay'ah (consensual pledge), ascetic accountability before the public treasury (Bayt Al-Māl), and judicial independence.",
                    "Transitioned after the assassination of 'Uthmān and 'Alī (the First Fitnah) when Al-Ḥasan ibn 'Alī voluntarily abdicated in Rabī' al-Awwal 41 AH ('Ām Al-Jamā'ah, the Year of Unity) to prevent bloodshed, fulfilling Sahih al-Bukhari 2704.",
                    "#D4AF37"
            ),
            new PropheticGovernancePhase(
                    3,
                    "PHASE-3-MULKUN-ADD",
                    "3. Biting Hereditary Kingship (مُلْكًا عَاضًّا — Mulkun 'Āḍḍ: Dynastic Caliphates, Sultanates & Shahdoms)",
                    "661–1924 CE (41–1342 AH — Over 12.5 Centuries) • Damascus, Baghdad, Cordoba, Cairo, Istanbul, Delhi, Isfahan, Samarkand",
                    "Musnad Aḥmad 18406: 'Then there will be biting kingship (Mulkun 'Āḍḍ) for as long as Allah wills it to be, then Allah will raise it up when He wills.' | Ibn Khaldūn, Muqaddimah (Transformation of Khilāfah into Mulk guarded by Sharia).",
                    "Classical scholars (Ibn Taymiyyah, Ibn Khaldūn, Al-Dhahabī, Ibn Ḥajar) explain 'Āḍḍ' ('biting') as rulers gripping hereditary dynastic succession tightly with their teeth, mixing royal coercion ('Aṣabiyyah) with Islamic governance. Yet these Caliphates, Sultanates, and Shahdoms upheld the Sharia courts (Qaḍā'), defended Dār Al-Islām, funded Awqāf/Madrasahs, and enabled Islam's global spread.",
                    "Dissolved progressively through internal dynastic decay (Ibn Khaldūn's 4-generation cycle), European maritime/industrial encirclement (1757–1918), and the final abolition of the Ottoman Caliphate on March 3, 1924 (27 Rajab 1342 AH).",
                    "#38BDF8"
            ),
            new PropheticGovernancePhase(
                    4,
                    "PHASE-4-MULKUN-JABRIYYAH",
                    "4. Coercive / Autocratic Rule (مُلْكًا جَبْرِيَّةً — Mulkun Jabriyyah: Colonial Partition & Secular Autocracy)",
                    "19th/20th Century – Present Transition • Post-Colonial Nation-State Fragmentation",
                    "Musnad Aḥmad 18406: 'Then there will be coercive/tyrannical rule (Mulkun Jabriyyah) for as long as Allah wills it to be, then He will raise it up when He wills to raise it up.' | Sunan Abī Dāwūd 4297 (Hadith of Al-Wahn).",
                    "Characterized by artificial colonial borders (Sykes-Picot, Berlin Conference, colonial partition), dismantling of independent Waqf endowments and Sharia courts, rule by emergency decrees without Shūrā, and spiritual testing where believers hold onto their faith like holding hot embers (Al-Qābiḍ 'alā al-Jamr, Tirmidhī 2260).",
                    "Lifted by Allah's decree when the Ummah cures Al-Wahn (excessive attachment to Dunyā and fear of sacrifice for truth), restores ethical-intellectual excellence, and returns to the Prophetic way.",
                    "#F43F5E"
            ),
            new PropheticGovernancePhase(
                    5,
                    "PHASE-5-RETURN-OF-PROPHETIC-MINHAJ",
                    "5. The Promise of Returning: Caliphate upon the Prophetic Way (ثُمَّ تَكُونُ خِلَافَةً عَلَى مِنْهَاجِ النُّبُوَّةِ)",
                    "The Eschatological & Civilizational Horizon • Renewed Stewardship, Al-Mahdī & 'Īsā ibn Maryam",
                    "Musnad Aḥmad 18406: 'Then there will be a Caliphate upon the Prophetic methodology (Thumma takūnu Khilāfatan 'alā Minhāj An-Nubuwwah). Then he ﷺ remained silent.' | Sahih Muslim 145 (Al-Ghurabā') & Abu Dawud 4282 (Al-Mahdī).",
                    "The canonical promise that history does not end in tyranny or dissolution: Islam returns to the purity of its Prophetic methodology—mercy, justice (Qisṭ wa 'Adl), consultation (Shūrā), and universal human stewardship—culminating in Al-Mahdī and the descent of 'Īsā ibn Maryam (Jesus, peace be upon him).",
                    "Culminates in universal justice filling the earth as it had been filled with oppression, followed ultimately by the final Hour and the return of all dominion to Allah (Qur'an 40:16).",
                    "#F59E0B"
            )
    );

    private static final List<CanonicalPolityEpoch> SEVEN_CANONICAL_POLITY_EPOCHS = List.of(
            new CanonicalPolityEpoch(
                    1,
                    "POLITY-1-RASHIDUN-CALIPHATE",
                    "1. The Rightly Guided Caliphate (الخِلَافَةُ الرَّاشِدَةُ — Al-Khilāfah Ar-Rāshidah | Title: Khalīfat Rasūlillāh & Amīr Al-Mu'minīn)",
                    "11–40/41 AH (632–661 CE — 30 Lunar Years) • Capitals: Al-Madīnah Al-Munawwarah & Al-Kūfah",
                    "Abū Bakr Aṣ-Ṣiddīq (632–634), 'Umar ibn Al-Khaṭṭāb (634–644), 'Uthmān ibn 'Affān (644–656), 'Alī ibn Abī Ṭālib (656–661), and Al-Ḥasan ibn 'Alī (661 CE / 6 months).",
                    "Instantiated at Saqīfat Banī Sā'idah and the Mosque of Medina through Shūrā (deliberative consultation of the Muhājirūn and Anṣār) and public Bay'ah (contractual pledge of allegiance conditioned on obedience to Allah and His Messenger). Grounded in Qur'an 24:55 (Promise of Istikhlāf) and Abū Bakr's inaugural address: 'Obey me so long as I obey Allah and His Messenger; if I disobey them, you owe me no obedience.'",
                    "Unified the Arabian Peninsula, compiled the canonical Muṣḥaf of the Qur'an, established the Dīwān welfare registry, separated the judiciary (Qaḍā') from executive governors, and opened the Levant, Egypt, Iraq, and Persia under strict covenants of religious freedom (Covenant of 'Umar in Jerusalem).",
                    "Dissolved as a non-hereditary electoral model when rapid imperial expansion brought volatile tribal factions into garrison cities, culminating in the assassination of 'Uthmān (35 AH), the Battles of the Camel and Ṣiffīn, the Khārijite assassination of 'Alī (40 AH), and Al-Ḥasan's noble abdication in 41 AH to save the Ummah from mutual annihilation.",
                    "Qur'an 24:55 (Istikhlāf Covenant), Sunan Abī Dāwūd 4646 (30-Year Caliphate), & Sahih al-Bukhari 2704 ('This son of mine [Al-Ḥasan] is a Sayyid, and perhaps Allah will reconcile through him two great factions of Muslims').",
                    "#10B981"
            ),
            new CanonicalPolityEpoch(
                    2,
                    "POLITY-2-UMAYYAD-CALIPHATE",
                    "2. The Umayyad Caliphate of Damascus & Cordoba (الخِلَافَةُ الأُمَوِيَّةُ — Al-Khilāfah Al-Umawiyyah | Title: Khalīfah & Amīr Al-Mu'minīn)",
                    "41–132 AH (661–750 CE) in Damascus; 138–422 AH (756–1031 CE) in Cordoba (Al-Andalus)",
                    "Sufyānid & Marwānid Branches: Mu'āwiyah ibn Abī Sufyān, 'Abd al-Malik ibn Marwān, Al-Walīd I, the righteous 'Umar ibn 'Abd al-'Azīz ('Umar II, 717–720 CE), Hishām ibn 'Abd al-Malik, and in Al-Andalus 'Abd ar-Raḥmān I (Ad-Dākhil) and 'Abd ar-Raḥmān III (An-Nāṣir).",
                    "Instantiated in 41 AH ('Ām Al-Jamā'ah) when Mu'āwiyah received the pledge of unity to end civil war, transforming the capital to Damascus. In 756 CE, the surviving prince 'Abd ar-Raḥmān Ad-Dākhil escaped the Abbasid revolution to instantiate the Umayyad Emirate/Caliphate of Cordoba.",
                    "Created the largest unified state in the ancient world—stretching from Narbonne and Lisbon in the West to Samarkand and Sindh in the East; minted the epigraphic Islamic gold Dinar (77 AH), Arabicized the administrative Dīwāns, built the Dome of the Rock and Umayyad Mosque of Damascus, and turned Cordoba into Europe's beacon of science and philosophy.",
                    "Dissolved in Damascus (132 AH / 750 CE) because late Umayyad governors (excluding 'Umar ibn 'Abd al-'Azīz) maintained Arab tribal supremacism ('Aṣabiyyah Qabaliyyah, Qays vs. Kalb feuds) and continued taxing non-Arab Muslim converts (Mawālī) with the Jizyah, violating Qur'an 49:13 and fueling the Khurasani-Abbasid revolution. In Cordoba (1031 CE), the 'Āmirid chamberlain dictatorship gutted caliphal legitimacy, fracturing Spain into 30+ warring Taifa kingdoms (Mulūk Aṭ-Ṭawā'if).",
                    "Qur'an 49:13 ('Indeed the most noble of you in the sight of Allah is the most righteous of you') & Qur'an 8:46 ('And do not dispute lest you falter and your strength [Rīḥukum] depart').",
                    "#D4AF37"
            ),
            new CanonicalPolityEpoch(
                    3,
                    "POLITY-3-ABBASID-CALIPHATE",
                    "3. The Abbasid Caliphate of Baghdad & Cairo (الخِلَافَةُ العَبَّاسِيَّةُ — Al-Khilāfah Al-'Abbāsiyyah | Title: Khalīfah & Imām)",
                    "132–656 AH (750–1258 CE) in Baghdad/Samarra; 659–923 AH (1261–1517 CE) Ceremonial Caliphate in Mamluk Cairo",
                    "As-Saffāḥ, Al-Manṣūr (Founder of Baghdad, 762 CE), Hārūn ar-Rashīd, Al-Ma'mūn, Al-Mu'taṣim, Al-Mutawakkil, Al-Qādir, An-Nāṣir li-Dīnillāh, Al-Musta'ṣim (last in Baghdad, d. 1258), and Al-Mutawakkil III (last in Cairo, 1517).",
                    "Instantiated under the banner of 'Ar-Riḍā min Āl Muḥammad' (pleasing leadership from the Prophet's Hashemite family, descending from his uncle Al-'Abbās), uniting Arabs, Persians, Turks, Arameans, and Berbers as equal citizens of a cosmopolitan Islamic commonwealth.",
                    "Five centuries of unmatched intellectual, legal, and scientific synthesis: canonization of the 4 Sunni Madhhabs (Abū Ḥanīfah, Mālik, Ash-Shāfi'ī, Aḥmad), the 6 Hadith collections (Bukhārī, Muslim, etc.), Bayt Al-Ḥikmah (Al-Khwārizmī's algebra, Ibn Al-Haytham's optics, Al-Rāzī's hospitals), paper mills, and global Indian Ocean/Silk Road commerce.",
                    "Dissolved politically in steps: first, reliance on slave-soldier Praetorian guards (Ghilmān/Mamlūks in Samarra) and Buyid/Seljuk warlords reduced the Caliph to a symbolic figurehead by the 10th century; finally, in 656 AH (Feb 1258 CE), Caliph Al-Musta'ṣim's neglect of the army and sectarian ministerial betrayal allowed Hulegu Khan's Mongols to sack Baghdad. Yet Mamluk Sultan Baybars re-instantiated the Abbasid line in Cairo (1261–1517 CE), and within two generations the Mongol Khanates themselves converted to Islam.",
                    "Qur'an 3:140 ('And these days We alternate them among mankind [Tilka al-ayyāmu nudāwiluhā bayna an-nās]') & Al-Māwardī's Al-Aḥkām As-Sulṭāniyyah (Imārat Al-Istīlā' — constitutionalizing autonomous regional emirates under caliphal recognition).",
                    "#38BDF8"
            ),
            new CanonicalPolityEpoch(
                    4,
                    "POLITY-4-MAGHREBI-AFRICAN-DYNASTIES",
                    "4. The Maghrebi & West African Dynasties & Sultanates (الدُّوَلُ وَالسَّلْطَنَاتُ المَغْرِبِيَّةُ وَالإِفْرِيقِيَّةُ | Titles: Amīr Al-Muslimīn, Khalīfah, Mansā, Askia & Amīr Al-Mu'minīn)",
                    "789 CE – Present ('Alawite Morocco) • Fez, Marrakesh, Kairouan, Cairo, Timbuktu, Gao, Birni Gazargamu & Sokoto",
                    "Idrisids, Aghlabids, Fatimids (Shi'i Counter-Caliphate 909–1171), Almoravids (Yūsuf ibn Tāshfīn), Almohads ('Abd al-Mu'min, Ya'qūb Al-Manṣūr), Marinids, Saadians, 'Alawites; and in West Africa: Mali (Mansā Mūsā), Songhai (Askia Muḥammad), Kanem-Bornu (Mai Idrīs Alooma) & Sokoto Caliphate ('Uthmān dan Fodio).",
                    "Instantiated repeatedly from the desert and mountain frontiers via spiritual reform movements (Ribāṭs, Sufi Zāwiyahs, and scholarly Jihād of the Pen and Sword) that united Sanhaja/Masmuda Amazigh or Fulani/Mandinka tribes under strict Maliki/Sunni jurisprudence to overthrow corrupt, over-taxing urban rulers.",
                    "Preserved Al-Andalus for two extra centuries (Battle of Zallāqah 1086), founded the world's oldest continuously operating university (Al-Qarawiyyīn in Fez, 859 CE) and Al-Azhar (970 CE), and turned Timbuktu's Sankore Mosque into a scholarly metropolis of 700,000+ manuscripts.",
                    "Rose and dissolved in textbook fulfillment of Ibn Khaldūn's Canonical 4-Generation Cycle (observed directly in Fez, Tlemcen, Tunis, and Granada): Generation 1 (austere desert founder with fierce 'Aṣabiyyah) -> Generation 2 (centralizing monarch replacing tribal allies with mercenaries) -> Generation 3 (luxury-loving urban imitator raising non-canonical taxes/Mukūs) -> Generation 4 (decadent squanderer overthrown by a fresh frontier reform movement or European colonial artillery).",
                    "Ibn Khaldūn, Al-Muqaddimah (Book III: 'On Dynasties, Royal Authority, the Caliphate, and the 4-Generation Lifespan of States — approx. 120 years') & Qur'an 17:16 (When affluent elites corrupt a city, its decree comes to pass).",
                    "#A855F7"
            ),
            new CanonicalPolityEpoch(
                    5,
                    "POLITY-5-SUNNI-SULTANATES",
                    "5. The Great Sunni Sultanates (السَّلْطَنَاتُ السُّنِّيَّةُ الكُبْرَى — As-Salṭanāt As-Sunniyyah | Title: As-Sulṭān, Malik & Susuhunan)",
                    "977–1857+ CE • Nishapur, Isfahan, Konya, Damascus, Cairo, Delhi, Aceh, Malacca & Demak",
                    "Ghaznavids (Maḥmūd of Ghazni), Great Seljuks (Tughril Beg, Alp Arslan, Malik-Shāh & Vizier Niẓām al-Mulk), Zengids & Ayyubids (Nūr ad-Dīn & Ṣalāḥ ad-Dīn Al-Ayyūbī), Mamluk Sultanate (Quṭuz, Baybars, Qalāwūn, Qāytbāy), Delhi Sultanates (Mamluk, Khalji, Tughlaq, Lodi), and Nusantara Maritime Sultanates (Samudera Pasai, Malacca, Aceh, Demak, Mataram, Banten).",
                    "Instantiated when the Abbasid Caliph could no longer field armies; Islamic jurists (Al-Māwardī, Al-Juwaynī, Al-Ghazālī, Ibn Jamā'ah) canonized the office of the 'Sulṭān' (from Qur'anic 'Sulṭān' = authorized power/proof). The Sultan received a diploma of investiture (Taqlīd) from the Caliph in exchange for upholding Sharia courts, funding Madrasahs (Niẓāmiyyah), and waging defensive Ribāṭ.",
                    "Saved the Islamic heartlands from two existential annihilation threats simultaneously: crushing the Byzantine imperial army at Manzikert (1071 CE), liberating Jerusalem from the Crusaders at Ḥiṭṭīn (1187 CE), and shattering the undefeated Mongol army at 'Ayn Jālūt (1260 CE), while peacefully anchoring Islam across India and the Indonesian-Malay archipelago.",
                    "Dissolved when military caste succession lacked stable constitutional rules (Seljuk appanage fragmentation; Mamluk factional coups in Cairo), when traditional chivalric cavalry refused to adopt modern gunpowder field artillery (Mamluk defeat at Marj Dābiq 1516 and Raydāniyyah 1517), or when European armed charter companies (Portuguese 1511 in Malacca; Dutch VOC in Java) monopolized oceanic chokepoints.",
                    "Imām Al-Ghazālī, Iḥyā' 'Ulūm Ad-Dīn: 'Religion (Ad-Dīn) and Sultanic Power (As-Sulṭān) are twins; Religion is the foundation and the Sultan is the guard—what has no foundation collapses, and what has no guard is lost.'",
                    "#F43F5E"
            ),
            new CanonicalPolityEpoch(
                    6,
                    "POLITY-6-OTTOMAN-CALIPHATE-SULTANATE",
                    "6. The Ottoman Sultanate & Caliphate (الدَّوْلَةُ العَلِيَّةُ العُثْمَانِيَّةُ — Ad-Dawlah Al-'Uthmāniyyah | Titles: Sulṭān, Khān, Pādishāh, Khalīfat Rasūlillāh & Khādim Al-Ḥaramayn)",
                    "699–1342 AH (1299–1922/1924 CE — 625 Years) • Capitals: Söğüt, Bursa, Edirne & Kostantiniyye / Istanbul",
                    "Osman I (Ghāzī), Orhan, Murad I, Mehmed II Al-Fātiḥ (Conqueror of Constantinople, 1453), Selim I Yavuz (1517 unification of Levant, Egypt & Hijaz), Suleiman the Magnificent (Al-Qānūnī, 1520–1566), Abdulhamid II (1876–1909), and the last Caliph Abdulmejid II (deposed March 3, 1924).",
                    "Instantiated as a small frontier Anatolian Ghāzī principality (Beylik) bound by Shaykh Edebali's spiritual counsel to Osman I ('Innsānı yaşat ki devlet yaşasın' — 'Let human beings live and flourish so that the state may live'). Unified Sultanate and Caliphate in 1517 CE when Selim I assumed stewardship of Mecca and Medina as Khādim Al-Ḥaramayn Ash-Sharīfayn (Servant of the Two Holy Sanctuaries).",
                    "Longest-lived dynastic state in Islamic history (625 years), uniting Southeastern Europe, Anatolia, the Fertile Crescent, Hejaz, Egypt, and North Africa; fulfilled the Prophetic Hadith of Constantinople (Musnad Aḥmad 18957), harmonized Hanafi Sharia with administrative law (Qānūn), protected Jewish and Christian communities via the Millet system, and built Sinan's architectural masterpieces.",
                    "Dissolved over two centuries due to: (1) Loss of the scientific/industrial revolution and oceanic trade routes; (2) Capitulations and sovereign debt bondage to European banks (Ottoman Public Debt Administration, 1881); (3) Replacement of Islamic Ummah solidarity with imported European ethno-nationalism (Balkan, Turkish CUP, and Arab nationalisms); and (4) Entry into WWI, followed by the Grand National Assembly abolishing the Sultanate (Nov 1, 1922) and the Caliphate (March 3, 1924).",
                    "Qur'an 3:26 ('O Allah, Owner of Sovereignty [Mālik Al-Mulk], You give sovereignty to whom You will and You strip sovereignty from whom You will') & Musnad Aḥmad 18957 ('Constantinople will surely be opened; how blessed is its commander, and how blessed is that army').",
                    "#F59E0B"
            ),
            new CanonicalPolityEpoch(
                    7,
                    "POLITY-7-PERSIANATE-MUGHAL-SHAHS",
                    "7. The Shahs & Pādishāhs of the Persianate & Indo-Islamic Realms (الشَّاهَاتُ وَالبَادِشَاهَاتُ — Ash-Shāhanshāhiyyah & Mughal Bādshāhī | Titles: Shāh, Pādishāh, Khāqān & Zillullāh)",
                    "1077–1979 CE (Iran/Central Asia) & 1526–1857 CE (Mughal India) • Samarkand, Herat, Tabriz, Isfahan, Tehran, Agra, Delhi & Lahore",
                    "Khwarazmshahs, Converted Mongol Ilkhanids (Ghazan Khan), Timurids (Timur, Shāh Rukh, Ulugh Beg), Safavid & Qajar Shahs of Iran (Shāh Ismā'īl, Shāh 'Abbās I), and the Great Mughal Pādishāhs of Hindustan (Babur, Humayun, Akbar, Jahangir, Shah Jahan, Aurangzeb 'Ālamgīr, and the last Mughal Bahadur Shah Zafar, deposed 1857).",
                    "Instantiated by Islamizing the ancient Indo-Iranian royal title 'Shāh' (King) and 'Pādishāh' (Master King). While Islam strictly forbade the polytheistic arrogance of calling any mortal 'King of Kings' in rivalry with Allah (Sahih al-Bukhari 6205: 'Akhna' al-asmā' 'inda Allāh rajulun tasammā Malik al-Amlāk'), Persianate and Mughal rulers legitimately held the title Shāh/Bādshāh as subordinate temporal trustees under divine law—codified in Aurangzeb's 30-volume Fatāwā 'Ālamgīriyyah.",
                    "Generated roughly 25% of global GDP in 1700 CE (Mughal India under Aurangzeb); built the Registan of Samarkand, Ulugh Beg's astronomical observatory, Naqsh-e Jahan in Isfahan, the Badshahi Mosque of Lahore, and the Red Fort/Taj Mahal of Agra; synthesized Persian poetry, Hikmat philosophy (Mullā Ṣadrā, Shāh Walīullāh Dehlawī), and continental agrarian administration.",
                    "Dissolved when court luxury and fratricidal wars of succession drained the imperial treasury after Aurangzeb (1707), enabling Nādir Shāh's sack of Delhi (1739) and the British East India Company's corporate-military takeover (Battle of Plassey 1757 to the 1857 uprising and exile of Bahadur Shah Zafar to Rangoon). In Iran, the Qajar/Pahlavi Shahdoms dissolved beneath Anglo-Russian imperial concessions and the 1906/1979 revolutions.",
                    "Qur'an 47:38 ('And if you turn away, He will replace you with another people [Yastabdil qawman ghayrakum], then they will not be like you') & Shāh Walīullāh Dehlawī's Ḥujjat Allāh Al-Bālighah (diagnosing fiscal over-taxation of peasants and court luxury as the death-knell of empires).",
                    "#22D3EE"
            )
    );

    private static final List<OriginJourneyAndReturnStage> SEVEN_ORIGIN_JOURNEY_AND_RETURN_STAGES = List.of(
            new OriginJourneyAndReturnStage(
                    1,
                    "STAGE-1-ORIGIN-ALAST-IBRAHIM",
                    "1. Where Islam Came From I: The Primordial Covenant of Alast & Millat Ibrāhīm (المَبْدَأُ الأَوَّلُ: مِيثَاقُ أَلَسْتُ وَمِلَّةُ إِبْرَاهِيمَ)",
                    "Pre-Temporal Realm of Souls ('Ālam Al-Arwāḥ) -> Adam -> Nūḥ -> Ibrāhīm -> Mūsā -> 'Īsā",
                    "Qur'an 7:172 ('Am I not your Lord [Alastu bi-Rabbikum]? They said: Yes, we testify!'), Qur'an 3:19 ('Indeed, the religion in the sight of Allah is Al-Islām'), Qur'an 22:78 ('The religion of your father Abraham; He named you Muslims before'), & Qur'an 42:13.",
                    "Canonically, Islam did not originate as a 7th-century Arabian ethnic religion or a dynastic ideology. In Islamic theology, 'Al-Islām' (willing surrender and peace with the One Creator) is the primordial cosmic state of the heavens and the earth (Qur'an 3:83), the innate human nature (Fiṭrah, Qur'an 30:30) sealed at the Covenant of Alast, and the single unbroken message of every Prophet from Adam, Noah, and Abraham to Moses, David, Solomon, Jesus, and Muhammad (peace be upon them all).",
                    "Because Islam came from Allah prior to all earthly kingdoms, no earthly kingdom's rise or fall can ever create or extinguish the ontological truth of Islam.",
                    "#10B981"
            ),
            new OriginJourneyAndReturnStage(
                    2,
                    "STAGE-2-ORIGIN-HIRA-GHURABA",
                    "2. Where Islam Came From II: The Solitary Cave of Ḥirā' & The First Strangers (غَارُ حِرَاءٍ وَالغُرَبَاءُ الأَوَّلُونَ)",
                    "610–622 CE (Mecca) • Before Any Caliphate, Sultanate, Army, or Treasury Existed",
                    "Qur'an 96:1–5 ('Read in the Name of your Lord who created...'), Sahih Muslim 145 ('Islam began as something strange [Badā'a al-Islāmu gharīban]...'), & Qur'an 8:26 ('And remember when you were few and deemed weak in the land...').",
                    "Historically, the final dispensation of Islam began in utter solitude in a mountain cave above Mecca with a single unlettered Prophet ﷺ, his wife Khadījah bint Khuwaylid, a young cousin ('Alī), a best friend (Abū Bakr), a freed Abyssinian slave (Bilāl), a Roman artisan (Ṣuhayb), a Persian truth-seeker (Salmān), and tortured martyrs (Sumayyah and Yāsir). For thirteen years in Mecca, Islam had zero territory, zero state apparatus, and zero dynastic throne—yet that Meccan period forged the indestructible spiritual core that later toppled both Caesar and Khosrow.",
                    "Whenever Muslims feel politically powerless after the dissolution of empires, the Seerah reminds them that Islam's purest foundation was laid in Mecca before any state existed.",
                    "#D4AF37"
            ),
            new OriginJourneyAndReturnStage(
                    3,
                    "STAGE-3-SURVIVAL-BEYOND-EMPIRES",
                    "3. Where Islam Went When Its Empires Dissolved: The Decentralized Ark of Qur'an, Sunnah, Waqf & Hearts (سَفِينَةُ الحِفْظِ بَعْدَ سُقُوطِ الدُّوَلِ)",
                    "1258 CE (Fall of Baghdad) • 1492 CE (Fall of Granada) • 1857 CE (Fall of Mughal Delhi) • 1924 CE (Abolition of Ottoman Caliphate)",
                    "Qur'an 15:9 ('Indeed, it is We who sent down the Reminder [Adh-Dhikr], and indeed We will be its Guardian'), Qur'an 35:15, & Ibn Khaldūn / Wael Hallaq on the autonomy of the Sharia-Waqf civil society from the political throne.",
                    "Why did Islam not vanish when the Mongols burned Baghdad (1258), when the Reconquista took Cordoba and Granada (1236/1492), when the British deposed the last Mughal Shah (1857), or when the Ottoman Caliphate was abolished (1924)? Because in Islam, the State was always the outer guard (Al-Ḥāris), never the Church or the Vatican. Islam has no priesthood and no infallible monarch. When the palace collapsed, Islam retreated intact into five indestructible vessels: (1) The verbatim Qur'an memorized in millions of human chests (Ḥuffāẓ); (2) The authenticated Prophetic Sunnah & Ijāzah chains; (3) The autonomous scholarly consensus ('Ulamā' & 4 Madhhabs); (4) The community Waqf endowments and Sufi/civic brotherhoods; and (5) The daily 5 prayers (Ṣalāh) and Muslim family home.",
                    "History proves that in 1258 CE, when the Abbasid Caliphate was destroyed by non-Muslim Mongols, Islam without a Caliph conquered the hearts of the Mongol conquerors themselves within forty years (Berke Khan 1257, Ghazan Khan 1295).",
                    "#38BDF8"
            ),
            new OriginJourneyAndReturnStage(
                    4,
                    "STAGE-4-WHERE-IT-HAS-GONE-TODAY",
                    "4. Where Islam Has Gone Today: 2 Billion Souls Across Every Horizon & The Trial of Al-Wahn (المَسِيرُ المُعَاصِرُ: بُلُوغُ مَا بَلَغَ اللَّيْلُ وَالنَّهَارُ)",
                    "20th–21st Century CE • 57 OIC Nations + Global Diaspora in the West, Africa, Asia & Americas (~25% of Humanity)",
                    "Sahih Muslim 2889 ('Allah gathered the earth for me so that I saw its easts and its wests, and my Ummah's dominion will reach all that was gathered for me'), Musnad Aḥmad 16957 ('This affair will reach wherever the night and day reach'), & Sunan Abī Dāwūd 4297 (Hadith of Al-Wahn).",
                    "Where has Islam gone today? Geographically and demographically, it has gone further than any Caliph, Sultan, or Shah ever marched: from ~300 million Muslims in 1924 (when the Ottoman Caliphate ended) to ~2.0 billion Muslims today—one out of every four human beings on earth—with mosques echoing the Adhān from Jakarta, Lagos, Cairo, and Istanbul to London, Paris, Chicago, Tokyo, and Buenos Aires. Yet politically and spiritually, the Prophet ﷺ diagnosed the contemporary paradox in Sunan Abī Dāwūd 4297: 'You will then be many in number, but you will be like the foam of the torrent (Ghuthā' ka-ghuthā' as-sayl)... because of Al-Wahn: love of the worldly life (Ḥubb ad-Dunyā) and hatred of death/sacrifice.'",
                    "The diagnosis of Al-Wahn is also its cure: qualitative spiritual, intellectual, scientific, and moral integrity outweighs mere quantitative numbers or nostalgic slogans.",
                    "#A855F7"
            ),
            new OriginJourneyAndReturnStage(
                    5,
                    "STAGE-5-PROMISE-GHURABA-TAJDID",
                    "5. The Promise of Returning I: Blessed Are the Strangers (Ṭūbā lil-Ghurabā') & The Centennial Renewers (المُجَدِّدُونَ)",
                    "Every Century of Islamic History -> The Modern Renewal of Authentic Knowledge & Character",
                    "Sahih Muslim 145: 'Islam began as something strange (Gharīban) and will return as something strange just as it began, so Ṭūbā (blessedness / a tree in Paradise) is for the Strangers (Al-Ghurabā').' | Sunan at-Tirmidhī 2630: 'Those who rectify (Yuṣliḥūn) what people have corrupted of my Sunnah.' | Sunan Abī Dāwūd 4291: 'Indeed Allah sends for this Ummah at the head of every hundred years one who renews (Yujaddidu) its religion for it.'",
                    "The statement 'Islam will return as something strange' is NOT a prophecy of defeat; as Qāḍī 'Iyāḍ, Imām An-Nawawī, and Ibn Al-Qayyim explain, it means that just as Islam began among a principled minority of sincere Strangers in Mecca and then illuminated the world, whenever materialism and corruption become the global norm, authentic Islam appears 'strange' to the heedless world—and from those righteous Strangers who repair what people corrupted, Islam's renewal (Tajdīd) blazes forth again.",
                    "Unlike previous nations whose scriptures were lost when their kingdoms fell, Allah promised a continuous chain of Centennial Renewers (Mujaddidūn—such as 'Umar ibn 'Abd al-'Azīz, Ash-Shāfi'ī, Al-Ghazālī,Ṣalāḥ ad-Dīn, Ibn Taymiyyah, As-Suyūṭī, Aḥmad Sirhindī, Shāh Walīullāh, and collective scholarly/scientific revivers) until the end of time.",
                    "#F43F5E"
            ),
            new OriginJourneyAndReturnStage(
                    6,
                    "STAGE-6-PROMISE-PROPHETIC-KHILAFAH",
                    "6. The Promise of Returning II: Restoration of Stewardship upon the Prophetic Way (عودة الخلافة على منهاج النبوة)",
                    "Post-Jabriyyah Horizon • The 5th Phase of the Hadith of Ḥudhayfah (Musnad Aḥmad 18406)",
                    "Musnad Aḥmad 18406: 'Then He will lift it [Mulk Jabriyyah] when He wills to lift it; then there will be a Caliphate upon the Prophetic methodology (Thumma takūnu Khilāfatan 'alā Minhāj An-Nubuwwah).' | Qur'an 24:55 ('Allah has promised those among you who believe and do righteous deeds that He will surely grant them succession [Layastakhlifannahum] upon the earth...').",
                    "Notice the exact wording of the Prophetic promise: Islam does NOT return as another biting dynastic kingship (Mulk 'Āḍḍ), nor as a violent Khārijite faction, nor as a narrow ethnic empire. It returns specifically 'alā Minhāj An-Nubuwwah'—upon the Prophetic methodology: rooted in Qur'an 24:55's two non-negotiable prerequisites (Īmān [unshakable faith] + 'Amal Ṣāliḥ [righteous, constructive action, justice, mercy, scientific/economic excellence, and trustworthiness]), replacing fear with peace and servitude to tyrants with pure worship of Allah.",
                    "True Istikhlāf is a divine gift that follows moral and civilizational readiness (Qur'an 13:11: 'Indeed, Allah does not change the condition of a people until they change what is within themselves').",
                    "#F59E0B"
            ),
            new OriginJourneyAndReturnStage(
                    7,
                    "STAGE-7-PROMISE-MAHDI-ISA-MALIK-AL-MULK",
                    "7. The Promise of Returning III: Al-Mahdī, The Descent of 'Īsā ibn Maryam & The Ultimate Return to Allah (المَهْدِيُّ وَنُزُولُ عِيسَى وَمَالِكُ المُلْكِ)",
                    "The Culmination of Terrestrial History -> The Universal Reign of Justice -> The Eternal Hereafter (Al-Ākhirah)",
                    "Sunan Abī Dāwūd 4282: 'Allah will send a man from my family [Al-Mahdī] who will fill the earth with equity and justice (Qisṭan wa 'Adlan) just as it had been filled with oppression and tyranny (Ẓulman wa Jawran).' | Sahih al-Bukhari 2222 & Sahih Muslim 155: 'By Him in Whose Hand is my soul, the son of Mary ('Īsā ibn Maryam) will shortly descend among you as a just arbiter (Ḥakaman Muqsiṭan)...' | Qur'an 40:16 ('Whose is the Sovereignty today? Allah's, the One, the Prevailing!').",
                    "In canonical Sunni eschatology (Mutawātir hadiths recorded by Bukhārī, Muslim, Abū Dāwūd, Tirmidhī, and Ibn Kathīr's An-Nihāyah fī al-Fitan wa al-Malāḥim), the terrestrial arc of Islam culminates in two grand returns that unite the entire Abrahamic prophetic family: (1) Al-Mahdī (Muḥammad ibn 'Abdillāh of the Prophetic household) establishing justice across the earth; and (2) The physical return of the Messiah 'Īsā ibn Maryam (Jesus, peace be upon him), descending at the white minaret east of Damascus, praying behind the Muslim Imam, slaying Al-Masīḥ Ad-Dajjāl (the False Messiah of deception), abolishing warfare, and ushering in an era of such abundance and peace that the lion grazes with the camel and children play safely with serpents—until Allah sends a gentle breeze to take the souls of the believers and all temporal kingdoms dissolve into the eternal sovereignty of Allah (Al-Mālik Al-Wārith).",
                    "Thus Islam's story is a complete sacred circle: from the Primordial Covenant of Alast and Abraham, through Muhammad ﷺ and the 30-year Prophetic Caliphate, across 1,400 years of rising and falling Sultanates and Shahdoms, to the promised return of Prophetic justice and the Messiah 'Īsā ibn Maryam before returning eternally to Allah.",
                    "#22D3EE"
            )
    );

    public static List<PropheticGovernancePhase> allFivePropheticGovernancePhases() {
        return FIVE_PROPHETIC_GOVERNANCE_PHASES;
    }

    public static List<CanonicalPolityEpoch> allSevenCanonicalPolityEpochs() {
        return SEVEN_CANONICAL_POLITY_EPOCHS;
    }

    public static List<OriginJourneyAndReturnStage> allSevenOriginJourneyAndReturnStages() {
        return SEVEN_ORIGIN_JOURNEY_AND_RETURN_STAGES;
    }
}
