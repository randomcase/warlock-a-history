package com.sovereign.warlock.domain;

import java.util.List;

/**
 * Canonical Islamic Chronicle of Caravans (Al-'Ir / Rihlat Ash-Shita' wa As-Sayf),
 * Battles for Trade (Saraya wa Ghazawat At-Tijarah), the Founding of Conquest (Ta'sis Al-Fath),
 * and the Recording of Conquest (Tadwin Al-Maghazi, Futuh Al-Buldan & Diwan Al-Jund).
 *
 * Traces the 7-stage historical and theological arc from the Qur'anic Covenant of the
 * Winter and Summer Caravans (Surah Quraysh 106:1-4) through the Red Sea & Najd caravan
 * interceptions (Nakhlah, Badr, Al-Qaradah, Al-'Is) to the Clear Conquest (Fath Makkah,
 * Qur'an 48:1) and the canonical historiographical & fiscal recording of conquest
 * ('Umar's Diwan, Al-Waqidi's Kitab Al-Maghazi, Al-Baladhuri's Futuh Al-Buldan, and
 * Ottoman Tapu Tahrir / Fetihname registers).
 */
public final class IslamicCaravansBattlesAndConquestChronicle {

    private IslamicCaravansBattlesAndConquestChronicle() {
    }

    /**
     * Represents one of the 7 Canonical Stages linking Caravans & Trade Routes to
     * Battles for Trade and the Founding of Conquest (Al-Fath).
     */
    public record CanonicalCaravanAndTradeBattle(
            int stageIndex,
            String stageCode,
            String chronologicalDateHijriAndCe,
            String arabicStageTitle,
            String englishStageTitle,
            String meridianColorHex,
            String caravanRouteAndCommodities,
            String commanderAndBanner,
            String battleForTradeDynamics,
            String foundingOfConquestOutcome,
            String quranicAndSirahAnchor
    ) {
        public CanonicalCaravanAndTradeBattle {
            if (stageIndex < 1 || stageIndex > 7) {
                throw new IllegalArgumentException("stageIndex must be in [1..7]");
            }
        }
    }

    /**
     * Represents one of the 7 Canonical Institutions & Codices for the Recording of Conquest
     * (Tadwin Al-Maghazi wa Al-Futuh wa Diwan Al-Kharaj).
     */
    public record ConquestRecordingCodex(
            int codexIndex,
            String codexCode,
            String eraAndCentury,
            String arabicCodexTitle,
            String englishCodexTitle,
            String chroniclerOrInstitution,
            String recordingMethodologyAndMedium,
            String legalAndFiscalGovernanceRule,
            String quranicAndHistoriographicalProof
    ) {
        public ConquestRecordingCodex {
            if (codexIndex < 1 || codexIndex > 7) {
                throw new IllegalArgumentException("codexIndex must be in [1..7]");
            }
        }
    }

    private static final List<CanonicalCaravanAndTradeBattle> SEVEN_CARAVANS_AND_TRADE_BATTLES = List.of(
            new CanonicalCaravanAndTradeBattle(
                    1,
                    "CARAVAN_1_ILAF_QURAYSH_WINTER_SUMMER",
                    "Pre-Hijrah – 1 AH (c. 480–622 CE)",
                    "Īlāf Quraysh: Riḥlat Ash-Shitā'i wa Aṣ-Ṣayf (إيلاف قريش: رحلة الشتاء والصيف)",
                    "Stage I: The Covenant of the Winter & Summer Caravans vs. Oligarchic Confiscation",
                    "#F8F5E6",
                    "Southern Winter Route (Yemen / Saba' & Abyssinia: frankincense, myrrh, Yemeni leather, Suhuli textiles, gold dust) and Northern Summer Route (Gaza, Busra & Damascus in Ash-Sham: olive oil, wheat, Byzantine silk, weaponry).",
                    "Hashim ibn 'Abd Manaf (Founder of the Ilaf Safe-Conduct Charters) -> Later usurped by Abu Sufyan & Abu Jahl",
                    "Under the Ilaf treaties, Quraysh enjoyed safe passage across Arabia because they were custodians of Abraham's Sanctuary (Al-Haram). Yet when they persecuted the believers and confiscated the homes and capital of the Muhajirun (Qur'an 59:8), they weaponized the Syrian trade caravan (Al-'Ir) to finance war against Tawhid.",
                    "Establishes the theological-economic law of Surah Quraysh (106:1-4): commercial security and caravan prosperity are contingent upon worshipping the Lord of the House ('Fal-ya'budu Rabba hadha al-Bayt'), forfeiting oligarchic immunity when turned into Zulm.",
                    "Qur'an 106:1-4 (Surah Quraysh), Qur'an 59:8 &Qur'an 28:57"
            ),
            new CanonicalCaravanAndTradeBattle(
                    2,
                    "CARAVAN_2_SARAYA_RED_SEA_AND_NAKHLAH",
                    "Ramadan 1 AH – Rajab 2 AH (623–624 CE)",
                    "Sarāyā الساحل وسرية نخلة (Interception of the Coastal Red Sea & Nakhlah Caravans)",
                    "Stage II: The Early Caravan Interceptions (Sif Al-Bahr, Rabigh, Al-Kharrar, Buwat, Al-'Ushayrah & Nakhlah)",
                    "#A78BFA",
                    "The Western Red Sea Coastal Artery (Tariq As-Sahil via Al-'Is, Yanbu', Waddan, and Badr) & the Ta'if-to-Mecca inland caravan carrying raisins, tanned hides, wine-skins, and silver bullion.",
                    "Hamzah ibn 'Abd al-Muttalib (White Banner / Liwa' Abyad), 'Ubaydah ibn al-Harith, Sa'd ibn Abi Waqqas, and 'Abdullah ibn Jahsh (at Nakhlah)",
                    "Seven reconnaissance and interception expeditions projected Medinan jurisdiction across the Red Sea trade bottleneck and forged non-aggression pacts with Banu Damrah and Banu Mudlij. At Nakhlah (Rajab 2 AH), 'Abdullah ibn Jahsh captured the Quraysh trade caravan led by 'Amr ibn al-Hadrami—the first caravan prize taken in Islam.",
                    "Qur'an 2:217 was revealed over the Nakhlah caravan, establishing that Quraysh's economic expulsion of believers from Al-Masjid Al-Haram and Fitnah are graver before Allah than their hypocritical appeal to sacred-month trade immunity.",
                    "Qur'an 2:217, Qur'an 22:39-40 (Permission to Fight the Wronged) & Al-Waqidi's Maghazi 1/10-19"
            ),
            new CanonicalCaravanAndTradeBattle(
                    3,
                    "CARAVAN_3_BADR_AL_IR_VS_AN_NAFIR",
                    "17 Ramadan 2 AH (13 March 624 CE)",
                    "Yawm Al-Furqān: Al-'Īr wa An-Nafīr bi-Badr (يوم الفرقان: العير والنفير ببدر)",
                    "Stage III: The Great Syrian Caravan (Al-'Ir) vs. The Meccan War-Host (An-Nafir) at the Wells of Badr",
                    "#38BDF8",
                    "Abu Sufyan's Great Gaza-to-Mecca Joint-Stock Caravan (Al-'Ir Al-Kubra): 1,000 camels carrying 50,000 gold Mithqal/Dinars of merchandise owned by every Meccan clan.",
                    "Prophet Muhammad ﷺ with Al-'Uqab Black Standard (borne by 'Ali ibn Abi Talib) and White Banner (borne by Mus'ab ibn 'Umayr) — 313 believers",
                    "Seeking restitution for confiscated Muhajirun property, Medina marched to intercept Abu Sufyan's 1,000-camel caravan at the caravan-station of Badr. Abu Sufyan diverted the caravan along the coastal salt-flats while Abu Jahl marched north with 950 armored warriors (An-Nafir) to crush Medina forever.",
                    "As Qur'an 8:7 declares, the believers desired the unarmed trade caravan ('ghayr dhat ash-shawkah'), but Allah ordained the clash with the armed hegemon to 'establish the Truth by His Words.' By seizing the strategic water-wells of Badr, Medina shattered the Meccan oligarchy and founded sovereign Islamic statehood.",
                    "Qur'an 8:7, 8:41-42 (Surah Al-Anfal), Qur'an 3:123 & Ibn Hisham 1/606-640"
            ),
            new CanonicalCaravanAndTradeBattle(
                    4,
                    "CARAVAN_4_AL_QARADAH_IRAQI_SILVER_ROUTE",
                    "Jumada II, 3 AH – Jumada I, 6 AH (624–627 CE)",
                    "Sariyyat Al-Qaradah wa Al-'Īṣ (سرية القردة والعيس: قطع طريق الفضة العراقي)",
                    "Stage IV: The Najd-Iraqi Silver Caravan Interception at Al-Qaradah & The Final Blockade at Al-'Is",
                    "#D4AF37",
                    "The Eastern Najd-to-Mesopotamia Desert Bypass (Al-Qaradah water-spring): Safwan ibn Umayyah's caravan laden with 100,000 dirhams of silver ingots, goblets, and bullion; followed by Abu al-'As ibn ar-Rabi's 170-man Syrian silver caravan at Al-'Is (6 AH).",
                    "Zayd ibn Harithah (Commander at Al-Qaradah with 100 horsemen & at Al-'Is with 170 riders)",
                    "Because Badr rendered the Western Red Sea route impassable, Quraysh attempted to reroute their winter/summer trade eastward through Najd toward Iraq, hiring the guide Furat ibn Hayyan. Zayd ibn Harithah ambushed the caravan at Al-Qaradah, capturing the entire 100,000-dirham silver cargo and its guide (who embraced Islam).",
                    "Sealed both the Eastern Iraqi silver corridor and the Western coastal corridor. When Abu al-'As's caravan was captured at Al-'Is (and magnanimously returned to him upon his entry into Islam), Quraysh realized their commercial lifeline existed solely at Medina's mercy—directly compelling the truce of Al-Hudaybiyyah.",
                    "Sahih al-Bukhari 4023, Al-Waqidi 1/197-199 (Sariyyat Al-Qaradah) & Ibn Sa'd Tabaqat 2/36"
            ),
            new CanonicalCaravanAndTradeBattle(
                    5,
                    "CARAVAN_5_HUDAYBIYYAH_KHAYBAR_FATH_MAKKAH",
                    "Dhu al-Qa'dah 6 AH – Ramadan 8 AH (628–630 CE)",
                    "Al-Fatḥ Al-Mubīn: Min Ṣulḥ Al-Ḥudaybiyyah ilā Fatḥ Makkah (الفتح المبين: من الحديبية إلى فتح مكة)",
                    "Stage V: From the Trade-Road Truce of Al-Hudaybiyyah to the Founding of Conquest (Fath Makkah)",
                    "#F43F5E",
                    "Reopened Pan-Arabian Caravan Networks (Hijaz, Najd, Yamamah grain supply of Thumamah ibn Uthal, and the fertile date-palm oases of Khaybar, Fadak, and Wadi al-Qura).",
                    "Prophet Muhammad ﷺ leading 1,400 Pledge-Companions of Ar-Ridwan (6 AH) -> 10,000 Vanguard Troops at Fath Makkah (8 AH)",
                    "Al-Hudaybiyyah (Qur'an 48:1) transformed former caravan battlegrounds into safe corridors of open preaching and commerce, while Thumamah ibn Uthal's Yamamah wheat embargo demonstrated Islamic sovereignty over Arabian food supply. When Quraysh violated the treaty against Banu Khuza'ah, the 10,000-strong army entered Mecca from four cardinal directions.",
                    "Founded the supreme archetype of Islamic Conquest (Al-Fath): bloodless liberation of Abraham's Sanctuary, general amnesty ('Go, for you are the freed ones — Antum at-Tulaqa''), abolition of usury (Riba) and pagan toll-extortion, and divine replacement of idol-trade revenue (Qur'an 9:28).",
                    "Qur'an 48:1, 48:18-27 (Surah Al-Fath), Qur'an 9:28, Qur'an 110:1-3 (Surah An-Nasr) & Bukhari 4372 (Thumamah's Grain Caravan)"
            ),
            new CanonicalCaravanAndTradeBattle(
                    6,
                    "CARAVAN_6_TABUK_AND_FUTUHAT_SILK_SPICE_ROADS",
                    "Rajab 9 AH – 96 AH (630–715 CE)",
                    "Ghazwat Tabūk wa Al-Futūḥāt Al-Kubrā (غزوة تبوك والفتوحات الكبرى لطرق الحرير والتوابل)",
                    "Stage VI: Frontier Trade Treaties of Tabuk & The Great Conquests (Syria, Iraq, Egypt & Silk Road)",
                    "#B87333",
                    "The Red Sea Port of Aylah (Aqaba), the Nabataean/Syrian Olive-Oil & Grain Caravans, the Persian Gulf Maritime Ports (Al-Ubullah / Basra), the Nile Grain Fleet ('Amr ibn al-'As's Khalij Amir al-Mu'minin canal), and the Sogdian Silk Road (Merv, Bukhara, Samarkand).",
                    "Prophet Muhammad ﷺ (at Tabuk, 30,000 strong) -> Khalid ibn al-Walid, Abu 'Ubaydah ibn al-Jarrah, Sa'd ibn Abi Waqqas, 'Amr ibn al-'As & Qutaybah ibn Muslim",
                    "At Tabuk (9 AH), the Prophet ﷺ signed the foundational trade-and-protection charters (Sulh) with John ibn Ru'bah of Aylah (guaranteeing safety for their ships at sea and their caravans on land: 'li-sufunihim wa sayyaratihim fi al-barr wa al-bahr'). This charter became the exact template for the Rashidun and Umayyad Futuhat from Damascus and Alexandria to Samarkand.",
                    "Unified the Indian Ocean spice routes, Red Sea/Mediterranean ports, and Central Asian Silk Road into a single customs-integrated commonwealth, reopening Trajan's Canal between the Nile and the Red Sea (642 CE) to ship Egyptian grain caravans directly to Hijaz in 20 days.",
                    "Qur'an 9:29-30, Treaty of Aylah (Ibn Hisham 2/525: 'Safe-Conduct on Land and Sea') & Al-Baladhuri's Futuh Al-Buldan"
            ),
            new CanonicalCaravanAndTradeBattle(
                    7,
                    "CARAVAN_7_RIBAT_CARAVANSERAI_HISBAH_COMMONWEALTH",
                    "2nd – 13th Century AH (750–1900 CE)",
                    "Shabakat Ar-Ribāṭ wa Al-Khānāt wa السكة الإسلامية (شبكة الرباط والخانات والسكة)",
                    "Stage VII: The Ribat-Caravanserai Network, Monetary Sikka Standardization & Maritime Aman",
                    "#10B981",
                    "Trans-Eurasian & Saharan Caravan Arteries: Seljuk/Ottoman Sultan Han caravanserais spaced every 30 km (1 Marhalah / day's journey), Darb Zubaydah water-cistern stations from Baghdad to Mecca, and Trans-Saharan gold-and-salt caravans (Sijilmasa to Timbuktu).",
                    "Caliph 'Abd al-Malik (696 CE Epigraphic Gold Dinar Reform), Seljuk/Ottoman Waqf Endowers, and Muhtasib Market Inspectors",
                    "Conquest was consolidated not by pillage, but by building fortified Caravanserais (Khan / Kervansaray) funded by perpetual Waqf endowments—providing every merchant caravan (Muslim or Dhimmi/Musta'min) 3 days of free lodging, veterinary care, mosque, bathhouse, and armed escort against highway brigandage (Hirabah, Qur'an 5:33).",
                    "Transformed military frontier forts (Ribat) into permanent hubs of global commerce, scholarship, and Sufi hospitality, governed by standardized epigraphic Gold Dinars (4.25g) and Silver Dirhams (2.97g) inscribed with Surah Al-Ikhlas.",
                    "Qur'an 5:33, Qur'an 9:6 (Aman / Safe-Conduct for Envoy & Merchant), Ibn Khaldun's Muqaddimah & Ottoman Vakfiye Charters"
            )
    );

    private static final List<ConquestRecordingCodex> SEVEN_CONQUEST_RECORDING_CODICES = List.of(
            new ConquestRecordingCodex(
                    1,
                    "CODEX_1_SAHIFAT_MADINAH_AND_SULH_CHARTERS",
                    "1–10 AH (622–632 CE) — Prophetic Chancery of Medina",
                    "Ṣaḥīfat Al-Madīnah wa Kutub Al-Amān wa Aṣ-Ṣulḥ (صحيفة المدينة وكتب الأمان والصلح)",
                    "Codex I: The Prophetic Treaty Scrolls, Safe-Conduct Charters & Silver Seal Ring",
                    "Scribes of the Prophet ﷺ (Kuttab Al-Wahy wa Al-Rasail): 'Ali ibn Abi Talib, Zayd ibn Thabit, Mu'awiyah ibn Abi Sufyan, and Ubayy ibn Ka'b",
                    "Written on tanned leather (Adim) and parchment, authenticated with the Prophet's three-line silver signet ring ('Muhammad / Rasul / Allah', Bukhari 5872). Every caravan truce (Hudaybiyyah) and frontier conquest charter (Khaybar, Aylah, Najran, Bahrain) was recorded in duplicate—one copy held by the local community, one archived in Medina.",
                    "Bound all future Muslim rulers to honor the exact tax ceilings, religious autonomy, and caravan safe-conducts ('la yuhdath 'alayhim hadath') stipulated in the original Prophetic treaty scroll.",
                    "Qur'an 2:282 (Al-Mudayanah: 'Write it down in justice'), Sahih al-Bukhari 3179 & Abu 'Ubayd's Kitab Al-Amwal"
            ),
            new ConquestRecordingCodex(
                    2,
                    "CODEX_2_DIWAN_UMAR_JUND_AND_KHARAJ",
                    "15–20 AH (636–641 CE) — Caliphate of 'Umar ibn al-Khattab",
                    "Tadwīn الديوان: دِيوان الجُند وديوان الخَراج (تدوين الدواوين في عهد عمر بن الخطاب)",
                    "Codex II: 'Umar's Supreme State Register (Diwan Al-Jund) & The Sawad Cadastral Survey",
                    "Caliph 'Umar ibn al-Khattab with genealogists 'Aqil ibn Abi Talib, Makhramah ibn Nawfal, Jubayr ibn Mut'im, and surveyor 'Uthman ibn Hunayf",
                    "Comprehensive state census and land-survey (Misahah) recording every companion by precedence (Sabiqah: Ahl Badr first, then Hudaybiyyah, then Qadisiyyah/Yarmuk) and surveying the 36,000,000 Jarib of conquered Iraqi alluvial farmland (Arḍ As-Sawād) by crop type and irrigation access.",
                    "Refused to divide conquered lands as private feudal booty among soldiers; instead, citing Qur'an 59:7-10 ('And those who come after them...'), 'Umar immobilized conquered land as perpetual public Waqf for all future generations, paying soldiers fixed stipends ('Ata') from the Diwan.",
                    "Qur'an 59:7-10 (Surah Al-Hashr), Abu Yusuf's Kitab Al-Kharaj 24-45 & Al-Mawardi's Al-Ahkam As-Sultaniyyah"
            ),
            new ConquestRecordingCodex(
                    3,
                    "CODEX_3_MAGHAZI_SIRAH_URWAH_ZUHRI_IBN_ISHAQ",
                    "60–218 AH (680–833 CE) — Medinan & Baghdadi Maghazi School",
                    "Tadwīn المغازي والسير: عروة والزهري وابن إسحاق وابن هشام",
                    "Codex III: The Canonical Maghazi Chronicles (Recording Every Caravan, Banner & Participant)",
                    "'Urwah ibn az-Zubayr (d. 94 AH), Ibn Shihab az-Zuhri (d. 124 AH), Muhammad ibn Ishaq (d. 151 AH), and 'Abd al-Malik ibn Hisham (d. 218 AH)",
                    "Isnad-verified oral and written transmission compiled into multi-volume codices on Khurasani paper (Kaghad). Records the exact chronology, lunar dates, banners (Al-Liwa' vs. Ar-Rayah), watchwords ('Ya Mansur Amit!'), camel counts, martyr rosters, and revealed Qur'anic verses for all 27 Ghazawat and 38+ Saraya.",
                    "Framed Islamic military history not as royal boasting, but as sacred legal precedent (Sunnah) governing rules of engagement, protection of non-combatants, prisoner ransom (as at Badr via teaching literacy), and treaty fidelity.",
                    "Qur'an 3:123, 8:41, 9:100 & Ibn Hisham's As-Sirah An-Nabawiyyah"
            ),
            new ConquestRecordingCodex(
                    4,
                    "CODEX_4_WAQIDI_KITAB_AL_MAGHAZI_TOPOGRAPHY",
                    "130–207 AH (747–823 CE) — Empirical Topographical Archive",
                    "Kitāb المغازي للواقدي والطبقات الكبرى لابن سعد",
                    "Codex IV: Al-Waqidi's Topographical Field-Ledger & Ibn Sa'd's Biographical Tabaqat",
                    "Muhammad ibn 'Umar al-Waqidi (d. 207 AH) & his scribe Muhammad ibn Sa'd (d. 230 AH, Kitab At-Tabaqat Al-Kubra)",
                    "Al-Waqidi personally visited every caravan watering-hole, mountain pass, and battlefield in the Hijaz to measure distances in miles (Mil), interview descendants holding family treaty parchments, and cross-tabulate every caravan interception against the seasonal agricultural calendar.",
                    "Established empirical historical geography and prosopography (Ilm Ar-Rijal), ensuring that every participant's name, lineage, weapon, and station on the battlefield grid was permanently preserved.",
                    "Al-Waqidi's Kitab Al-Maghazi (3 vols.) & Ibn Sa'd's Tabaqat (8 vols.)"
            ),
            new ConquestRecordingCodex(
                    5,
                    "CODEX_5_BALADHURI_FUTUH_AL_BULDAN",
                    "200–279 AH (815–892 CE) — Abbasid Imperial Chancery Synthesis",
                    "Futūḥ البُلدان للبلاذري (فتوح البلدان وتصنيف الصلح والعنوة)",
                    "Codex V: Al-Baladhuri's 'Futuh Al-Buldan' — The Master Legal & Geographic Atlas of Conquest",
                    "Ahmad ibn Yahya al-Baladhuri (d. 279 AH / 892 CE), together with Ibn 'Abd al-Hakam (Futuh Misr) and Khalifah ibn Khayyat",
                    "Organized geographically province-by-province (Arabia, Syria, Cyprus, Armenia, Egypt, Maghrib, Andalusia, Iraq, Persia, Khorasan, Sind), recording how every single town and fortress was opened—whether Sulhan (by negotiated peace treaty) or 'Anwatan (by force)—along with appendix chapters on the Arabic script, Diwan translation, and coinage.",
                    "Served as the binding constitutional reference for Qadis and Viziers across the Abbasid Empire: a city opened Sulhan could never have its treaty tax arbitrarily raised or its churches/synagogues confiscated.",
                    "Al-Baladhuri's Futuh Al-Buldan (Brill ed., pp. 1-480) & Yahya ibn Adam's Kitab Al-Kharaj"
            ),
            new ConquestRecordingCodex(
                    6,
                    "CODEX_6_MASALIK_GEOGRAPHY_AND_SIKKA_NUMISMATICS",
                    "3rd–6th Century AH (850–1160 CE) — Postal, Caravan & Mint Archives",
                    "Kutub المسالك والممالك وسجلات دار الضرب والسكة",
                    "Codex VI: Al-Masalik wa Al-Mamalik (Caravan Itinerary Atlases) & Epigraphic Sikka Mint Ledgers",
                    "Ibn Khordadbeh (Postmaster General), Al-Istakhri, Ibn Hawqal, Al-Muqaddasi, and Ash-Sharif al-Idrisi (Nuzhat Al-Mushtaq)",
                    "Mapped every caravan stage (Marhalah), postal relay station (Barid), water cistern, customs toll, regional commodity specialty, and mint-city (Dar Ad-Darb) stamping the year and city of conquest directly onto gold Dinars and silver Dirhams.",
                    "Made every Islamic coin an indestructible bronze/silver/gold historical record of sovereignty (Sikka & Khutbah), while Al-Masalik manuals provided merchants and administrators exact topological coordinates across the known world.",
                    "Ibn Khordadbeh's Kitab Al-Masalik wa Al-Mamalik & Al-Idrisi's Tabula Rogeriana (1154 CE)"
            ),
            new ConquestRecordingCodex(
                    7,
                    "CODEX_7_OTTOMAN_FETIHNAME_AND_TAPU_TAHRIR",
                    "8th–13th Century AH (1300–1900 CE) — Ottoman Defterhane & Nakkashane",
                    "Fetihnâme-i Hümâyûn ve Tapu Tahrir Defterleri (الفتحنامة العثمانية ودفاتر الطابو التحرير)",
                    "Codex VII: Ottoman Imperial Fetihnâme Proclamations, Tapu Tahrir Cadastral Defters & Matrakçı Miniatures",
                    "Reisü'l-Küttab (Grand Chancery), Defter-i Hakani (Imperial Registry), and Matrakçı Nasuh (Beyan-i Menazil-i Sefer-i 'Irakeyn, 1537 CE)",
                    "Immediately upon a conquest, Ottoman scribes conducted an exhaustive household-by-household and parcel-by-parcel survey (Tapu Tahrir Defteri) in Siyaqat cryptographic script, recording every village, caravanserai, market toll (Bac-i Bazar), and Kanunname charter, while Matrakçı Nasuh painted every caravan/campaign stage in 2.5D isometric elevation.",
                    "Institutionalized the Pax Ottomanica ('Adalet Dairesi — Circle of Justice): no tax could be levied without a written Kanunname entry in the Defterhane, and every trade route was endowed with Waqf caravanserais.",
                    "Ottoman Tapu Tahrir Defterleri (Başbakanlık Archives) & Matrakçı Nasuh's Menazilname (Istanbul Univ. Library T. 5964)"
            )
    );

    public static List<CanonicalCaravanAndTradeBattle> allSevenCaravansAndTradeBattles() {
        return SEVEN_CARAVANS_AND_TRADE_BATTLES;
    }

    public static List<ConquestRecordingCodex> allSevenConquestRecordingCodices() {
        return SEVEN_CONQUEST_RECORDING_CODICES;
    }
}
