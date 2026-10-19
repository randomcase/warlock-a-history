package com.sovereign.warlock.domain;

import java.util.List;

/**
 * Canonical Synthesis of:
 * 1. Philosophy (Al-Falsafah wa Al-Hikmah) & Alchemy (Al-Kimiya' At-Tajribiyyah wa Kimiya' As-Sa'adah) in Islam.
 * 2. How Islam Canonically Adjusted to 7 Different Theocracies & Theocrats (Meccan Sadanah, Abyssinian Negus,
 *    Byzantine Caesaropapism, Sasanian Magian Mobads, Clerical Ahbar/Ruhban, Harranian Sabians, Sind/Hind Brahmans).
 * 3. How Islam Engaged, Answered, and Institutionalized 5 Socratic Critiques (Euthyphro Dilemma, Socratic Elenchus
 *    against Taqlid, Epistemic Humility, Critique of Sophistry, and the Barahimah/Razi Critique of Prophecy).
 * 4. How the Meaning of Messages Changed & Expanded Across 7 Historical/Linguistic Stages While the Qur'anic Text
 *    Remained Invariant (Lafz Mahfuz vs. Ittisa' Ad-Dalalah, Ash-Shafi'i's Qadim/Jadid, and 4-Tier Hermeneutics).
 */
public final class IslamicPhilosophyAlchemyTheocraciesAndMessages {

    private IslamicPhilosophyAlchemyTheocraciesAndMessages() {
    }

    /**
     * Represents one of the 7 Canonical Epochs of Islamic Philosophy (Falsafah/Hikmah)
     * and Alchemy (Al-Kimiya' — both laboratory chemistry and spiritual Kimiya-yi Sa'adat).
     */
    public record PhilosophyAndAlchemyEpoch(
            int epochIndex,
            String epochCode,
            String chronologicalSpan,
            String titleAndSchool,
            String keyMastersAndWorks,
            String philosophicalBreakthrough,
            String alchemicalAndScientificTransmutation,
            String quranicAndCanonicalAnchor
    ) {
        public PhilosophyAndAlchemyEpoch {
            if (epochIndex < 1 || epochIndex > 7) {
                throw new IllegalArgumentException("epochIndex must be in [1..7]");
            }
        }
    }

    /**
     * Represents one of the 7 Canonical Adjustments of Islam to Different Theocracies and Theocrats.
     */
    public record TheocracyAdjustmentProtocol(
            int protocolIndex,
            String protocolCode,
            String theocracyAndTheocratClass,
            String historicalEncounterAndRegion,
            String critiqueOfTheocraticDistortion,
            String canonicalIslamicAdjustmentAndCharter,
            String quranicAndLegalProof
    ) {
        public TheocracyAdjustmentProtocol {
            if (protocolIndex < 1 || protocolIndex > 7) {
                throw new IllegalArgumentException("protocolIndex must be in [1..7]");
            }
        }
    }

    /**
     * Represents one of the 5 Socratic Critiques (Suqrat Al-Hakim) and how Islamic Kalam,
     * Falsafah, and Usul Al-Fiqh engaged, answered, and institutionalized it.
     */
    public record SocraticCritiqueEngagement(
            int critiqueIndex,
            String critiqueCode,
            String classicalSocraticCritique,
            String islamicReceptionOfSocrates,
            String canonicalIslamicResolution,
            String institutionalAndMethodologicalLegacy,
            String quranicAndTextualProof
    ) {
    }

    /**
     * Represents one of the 7 Canonical Stages of How the Meaning and Reception of Messages
     * Changed During Islamic Expansion while the Qur'anic Text Remained Invariant.
     */
    public record MessageSemanticShiftStage(
            int stageIndex,
            String stageCode,
            String expansionPhaseAndLinguisticSphere,
            String coreVocabularyAndConceptShifts,
            String hermeneuticAndLegalMechanism,
            String historicalExampleOfMeaningShift,
            String quranicAndUsuliAnchor
    ) {
        public MessageSemanticShiftStage {
            if (stageIndex < 1 || stageIndex > 7) {
                throw new IllegalArgumentException("stageIndex must be in [1..7]");
            }
        }
    }

    private static final List<PhilosophyAndAlchemyEpoch> SEVEN_PHILOSOPHY_AND_ALCHEMY_EPOCHS = List.of(
            new PhilosophyAndAlchemyEpoch(
                    1,
                    "EPOCH_1_JABIR_AND_KINDI_MIZAN_INCEPTION",
                    "85–260 AH (704–873 CE) — Umayyad Damascus to Abbasid Kufah & Baghdad",
                    "Epoch I: Jabir ibn Hayyan's Science of the Balance ('Ilm Al-Mizan) & Al-Kindi's First Philosophy",
                    "Khalid ibn Yazid (d. 704 CE), Imam Ja'far as-Sadiq (d. 765 CE), Jabir ibn Hayyan / Geber (d. c. 815 CE, Kitab Al-Sab'in & Kitab Al-Mizan), and Ya'qub ibn Ishaq al-Kindi (d. 873 CE, Fi Al-Falsafah Al-Ula).",
                    "Al-Kindi harmonized Greek philosophy with Qur'anic creation ex nihilo (Ibda'), declaring that truth must be welcomed from every nation and demonstrating the finitude of cosmic time and body.",
                    "Jabir ibn Hayyan stripped Hellenistic alchemy of pagan planetary fatalism and rebuilt it on the Qur'anic Balance (Al-Mizan, 55:7-9): every substance is governed by quantitative mathematical ratios (1:3:5:8 = 17). Invented the Alembic (Al-Inbiq), mineral acids (nitric, hydrochloric, sulfuric, aqua regia), and quantitative laboratory distillation (Taqtir).",
                    "Qur'an 55:7-9 (Al-Mizan), 57:25 & Al-Kindi's On First Philosophy"
            ),
            new PhilosophyAndAlchemyEpoch(
                    2,
                    "EPOCH_2_RAZI_AND_FARABI_EXPERIMENT_VIRTUOUS_CITY",
                    "250–339 AH (865–950 CE) — Rayy, Baghdad, Damascus & Aleppo",
                    "Epoch II: Ar-Razi's Experimental Chemistry (Sirr Al-Asrar) & Al-Farabi's Virtuous City (Al-Madinah Al-Fadilah)",
                    "Abu Bakr Muhammad ibn Zakariyya ar-Razi / Rhazes (d. 925 CE, Kitab Al-Asrar & As-Sirah Al-Falsafiyyah) and Abu Nasr al-Farabi / Alpharabius (d. 950 CE, Al-Mu'allim Ath-Thani, Ara' Ahl Al-Madinah Al-Fadilah).",
                    "Al-Farabi classified all sciences (Ihsa' Al-'Ulum) and solved the relation between Philosophy and Revelation: the Philosopher-King and the Prophet-Lawgiver receive the same truth from the Active Intellect (Al-'Aql Al-Fa''al / Jibril)—philosophy through demonstrative concepts, prophecy through both intellect and universal symbolic imagination.",
                    "Ar-Razi completed the transition from mystical alchemy to systematic laboratory chemistry: classified substances strictly into mineral, vegetable, and animal; cataloged over 20 precise laboratory apparatuses (beakers, cucurbits, water-baths, filters); and rejected unverified occult claims in favor of repeatable clinical and chemical trials.",
                    "Qur'an 2:269 (Al-Hikmah), Al-Farabi's Virtuous City & Ar-Razi's Sirr Al-Asrar"
            ),
            new PhilosophyAndAlchemyEpoch(
                    3,
                    "EPOCH_3_IBN_SINA_AND_BIRUNI_ONTOLOGY_CRITIQUE",
                    "370–440 AH (980–1048 CE) — Bukhara, Khwarazm, Hamadan, Isfahan & Ghazna",
                    "Epoch III: Ibn Sina's Necessary Existent (Wajib Al-Wujud) & The Critique of Metallic Transmutation",
                    "Ibn Sina / Avicenna (d. 1037 CE, Ash-Shifa', Al-Isharat wa At-Tanbihat), Abu Rayhan al-Biruni (d. 1048 CE, Kitab Al-Jamahir fi Ma'rifat Al-Jawahir), and Ibn al-Haytham (d. 1040 CE).",
                    "Ibn Sina revolutionized global metaphysics by distinguishing Essence (Mahiyyah) from Existence (Wujud), proving that the universe is contingent (Mumkin Al-Wujud) and continuously sustained by the One Necessary Existent (Wajib Al-Wujud).",
                    "In the mineralogical section of Ash-Shifa' (De Congelatione et Conglutinatione Lapidum), Ibn Sina and Al-Biruni subjected alchemical gold-making to scientific critique: artisans can dye or alloy metals, but true specific differences (Fusul) of elements are created by Allah alone—Simultaneously, Ibn Sina perfected steam distillation of essential rose oils (Attar).",
                    "Qur'an 28:88 ('Everything will perish except His Face'), Ibn Sina's Ash-Shifa' & Al-Biruni's Mineralogy"
            ),
            new PhilosophyAndAlchemyEpoch(
                    4,
                    "EPOCH_4_GHAZALI_TAHAFUT_AND_KIMIYA_YI_SAADAT",
                    "450–505 AH (1058–1111 CE) — Nishapur, Baghdad & Tus",
                    "Epoch IV: Al-Ghazali's Critique of the Philosophers (Tahafut) & The Alchemy of Happiness (Kimiya-yi Sa'adat)",
                    "Abu Hamid al-Ghazali (d. 1111 CE, Tahafut Al-Falasifah, Al-Qistas Al-Mustaqim, Ihya' 'Ulum Ad-Din, and Kimiya-yi Sa'adat).",
                    "Al-Ghazali mastered Peripatetic philosophy (Maqasid Al-Falasifah), dismantled 20 unproved metaphysical claims (such as denying bodily resurrection or Allah's knowledge of particulars), replaced mechanical necessary causation with Ash'ari occasionalism, and naturalized Aristotelian syllogistic logic into Islamic jurisprudence (Usul Al-Fiqh).",
                    "Transmuted alchemy itself into 'Kimiya-yi Sa'adat' (The Alchemy of Happiness): just as material alchemists seek an elixir to purge copper of rust and turn it into pure gold, the divine Alchemy of Revelation places the human soul in the crucible of Mujahadah to transmute beastly and demonic traits into angelic character and knowledge of Allah (Ma'rifah).",
                    "Qur'an 91:9 ('He has succeeded who purifies it'), Al-Ghazali's Kimiya-yi Sa'adat & Al-Munqidh min Ad-Dalal"
            ),
            new PhilosophyAndAlchemyEpoch(
                    5,
                    "EPOCH_5_IBN_RUSHD_AND_IBN_TUFAIL_ANDALUSIAN_BURHAN",
                    "500–595 AH (1106–1198 CE) — Cordoba, Seville, Marrakesh & Granada",
                    "Epoch V: Ibn Rushd's Harmony of Religion & Philosophy (Fasl Al-Maqal) & Ibn Tufayl's Hayy ibn Yaqzan",
                    "Ibn Bajjah / Avempace (d. 1138 CE), Ibn Tufayl (d. 1185 CE, Hayy ibn Yaqzan), and Ibn Rushd / Averroes (d. 1198 CE, Qadi of Cordoba, Fasl Al-Maqal & Tahafut At-Tahafut).",
                    "As Grand Qadi and philosopher, Ibn Rushd issued a formal legal Fatwa in Fasl Al-Maqal proving that the Qur'an commands rational demonstration (I'tibar & Burhan, Qur'an 59:2, 7:185): 'Truth does not contradict truth (Al-Haqqu la yudaddu al-Haqq), but rather accords with it and bears witness to it.' Philosophy and Shari'ah are 'milk-sisters' (Ukhta ar-Rada'ah).",
                    "Ibn Tufayl's philosophical narrative Hayy ibn Yaqzan demonstrated how an infant raised by a gazelle on an equatorial island ascends through empirical observation, anatomical dissection, and astronomical contemplation to pure monotheism—harmonizing natural science, philosophy, and mystical intuition.",
                    "Qur'an 59:2 ('Fa-'tabiru ya uli al-absar'), 7:185 & Ibn Rushd's Fasl Al-Maqal"
            ),
            new PhilosophyAndAlchemyEpoch(
                    6,
                    "EPOCH_6_SUHRAWARDI_AND_IBN_ARABI_ISHRAQ_RED_SULFUR",
                    "549–638 AH (1154–1240 CE) — Aleppo, Konya, Damascus & Cairo",
                    "Epoch VI: Suhrawardi's Philosophy of Illumination (Hikmat Al-Ishraq) & Ibn 'Arabi's Red Sulfur (Al-Kibrit Al-Ahmar)",
                    "Shihab ad-Din as-Suhrawardi (d. 1191 CE, Hikmat Al-Ishraq), Muhyi ad-Din ibn 'Arabi (d. 1240 CE, Al-Futuhat Al-Makkiyyah & Fusus Al-Hikam), and Aidamur al-Jildaki (d. 1342 CE, Nihayat At-Talab).",
                    "Suhrawardi replaced Aristotelian hylomorphism with an ontology of pure Light (Nur Al-Anwar, Qur'an 24:35) and Knowledge by Presence ('Ilm Huduri), uniting the wisdom of ancient Persian sages (Khosrowaniyyun), Greek sages (Plato/Empedocles/Pythagoras), and Islamic Sufism.",
                    "Ibn 'Arabi codified 'Al-Kibrit Al-Ahmar' (The Red Sulfur — the rarest alchemical philosopher's stone) as the station of the Perfect Human (Al-Insan Al-Kamil) whose heart reflects all Divine Names in equilibrium, while Al-Jildaki in Mamluk Cairo compiled the encyclopedic summation of Islamic experimental and symbolic chemistry.",
                    "Qur'an 24:35 (Ayat An-Nur), Suhrawardi's Hikmat Al-Ishraq & Ibn 'Arabi's Al-Kibrit Al-Ahmar"
            ),
            new PhilosophyAndAlchemyEpoch(
                    7,
                    "EPOCH_7_IBN_KHALDUN_AND_MULLA_SADRA_TRANSCENDENT_SYNTHESIS",
                    "732–1050 AH (1332–1640 CE) — Tunis, Cairo, Shiraz & Isfahan",
                    "Epoch VII: Ibn Khaldun's Monetary Critique of Alchemy & Mulla Sadra's Transcendent Theosophy (Al-Hikmah Al-Muta'aliyah)",
                    "Ibn Khaldun (d. 1406 CE, Al-Muqaddimah), Nasir ad-Din at-Tusi (d. 1274 CE), and Sadr ad-Din ash-Shirazi / Mulla Sadra (d. 1640 CE, Al-Asfar Al-Arba'ah).",
                    "Mulla Sadra achieved the grand synthesis of all four Islamic intellectual streams—Qur'anic Revelation, Peripatetic Demonstration (Burhan), Illuminationist Intuition (Ishraq), and Sufi Gnosis ('Irfan)—establishing Primacy of Existence (Asalat Al-Wujud) and Substantial Motion (Al-Harakah Al-Jawhariyyah), proving that the entire cosmos is in continuous dynamic evolution toward its Creator.",
                    "Ibn Khaldun (Muqaddimah, Ch. VI.27-28) delivered the definitive economic and sociological verdict on material alchemy: Allah guarded gold and silver as stable measures of human labor and trade; counterfeit alchemical gold corrupts the currency (Sikka), whereas the true alchemy is Substantial Motion—the real ontological transformation of the soul through knowledge and righteous action.",
                    "Qur'an 50:15 (Renewed Creation), Mulla Sadra's Al-Asfar Al-Arba'ah & Ibn Khaldun's Muqaddimah"
            )
    );

    private static final List<TheocracyAdjustmentProtocol> SEVEN_THEOCRACY_ADJUSTMENTS = List.of(
            new TheocracyAdjustmentProtocol(
                    1,
                    "THEOCRACY_1_MECCAN_PAGAN_SADANAH_OLIGARCHY",
                    "1. The Pagan Custodial Oligarchy of Mecca (Sadanat Al-Ka'bah & Dar An-Nadwah)",
                    "Mecca (610–630 CE / 8 AH) — Quraysh clan chiefs ruling through 360 tribal idols and sacred-month trade monopolies.",
                    "Quraysh weaponized Abraham's Sanctuary (Al-Haram) to invent superstitious food taboos (Bahirah, Sa'ibah, Qur'an 5:103), naked circumambulation (7:28), and idol-tolls while persecuting monotheists (8:34).",
                    "At Fath Makkah (8 AH), the Prophet ﷺ shattered all 360 idols ('Truth has come and falsehood has vanished', Qur'an 17:81) and abolished pagan priesthood and Riba, yet preserved the sacred Abrahamic rites of Hajj and returned the physical key of the Ka'bah to 'Uthman ibn Talhah under Qur'an 4:58—transforming a pagan temple-cartel into an egalitarian house of universal Tawhid.",
                    "Qur'an 4:58 (Returning Trusts), 8:34-35, 9:28 & 17:81"
            ),
            new TheocracyAdjustmentProtocol(
                    2,
                    "THEOCRACY_2_ABYSSINIAN_CHRISTIAN_SACRED_MONARCHY",
                    "2. The Christian Monarchical Theocracy of Abyssinia (An-Najashi / Negus Ashamah of Aksum)",
                    "Aksum, Abyssinia (5 BH – 9 AH / 615–630 CE) — First Hijrah of the Companions led by Ja'far ibn Abi Talib.",
                    "While Abyssinian bishops pressed Ja'far on Christology, the Negus ruled with justice and refused Meccan bribes to extradite refugees.",
                    "Islam established the paradigm of peaceful inter-polity asylum and theological candor: Ja'far recited Surah Maryam (19:16-36), affirming 'Isa (Jesus) as Allah's Servant, Messenger, Word, and Spirit without adopting Trinitarian dogma. The Negus wept, drew a line on the ground saying the difference was no wider than that reed, protected the Muslims, and upon his death the Prophet ﷺ prayed Salat Al-Gha'ib for him.",
                    "Qur'an 3:64 (Kalimatin Sawa'), 5:82-85, 19:16-36 & Sahih al-Bukhari 1245 / 3876"
            ),
            new TheocracyAdjustmentProtocol(
                    3,
                    "THEOCRACY_3_BYZANTINE_CAESAROPAPISM_AND_PATRIARCHATES",
                    "3. Imperial Byzantine Caesaropapism (Emperor Heraclius & Patriarch Sophronius of Jerusalem)",
                    "Syria, Palestine & Egypt (7–20 AH / 628–641 CE) — Damascus, Jerusalem (Al-Quds), and Alexandria.",
                    "Byzantine Emperors acted as Caesaropapist theocrats who imposed state Christological creeds by military persecution against Miaphysite Coptic/Syriac Christians and barred Jews from Jerusalem.",
                    "When Caliph 'Umar ibn al-Khattab entered Jerusalem in 15 AH (637 CE), he signed Al-'Uhdah Al-'Umariyyah (The Covenant of 'Umar) with Patriarch Sophronius: guaranteeing inviolable protection for Christian lives, churches, crosses, and liturgical autonomy; refusing to pray inside the Church of the Holy Sepulchre so Muslims would never expropriate it; and inviting 70 Jewish families back to reside in Jerusalem.",
                    "Qur'an 22:40 (Protection of Monasteries, Churches, Synagogues & Mosques), 3:64 & Al-'Uhdah Al-'Umariyyah (At-Tabari 1/2405)"
            ),
            new TheocracyAdjustmentProtocol(
                    4,
                    "THEOCRACY_4_SASANIAN_ZOROASTRIAN_MOBAD_PRIESTHOOD",
                    "4. Sasanian Zoroastrian State-Priesthood (Kisra & The Hereditary Magian Mobadan-Mobad)",
                    "Bahrain, Hajar, Iraq (As-Sawad), Fars & Khorasan (8–31 AH / 630–651 CE).",
                    "Sasanian monarchs claimed divine cosmic radiation (Farr-i Izadi) allied with the Magian fire-priesthood (Mobads), who enforced dualism (Ahura Mazda vs. Ahriman), rigid aristocratic caste walls, and consanguineous royal marriages.",
                    "Guided by Qur'an 22:17 (which lists Al-Majus alongside Jews, Sabians, and Christians as communities between whom Allah will judge on the Day of Resurrection) and the Prophet's Hadith regarding the Magians of Hajar: 'Follow with them the Sunnah of the People of the Book' (Muwatta' 619, Bukhari 3157), Muslim jurists granted Zoroastrians protected Dhimmi status, preserved their fire-temples, and abolished the Sasanian caste hierarchy.",
                    "Qur'an 22:17, Sahih al-Bukhari 3157, Muwatta' Malik 619 & Abu Yusuf's Kitab Al-Kharaj"
            ),
            new TheocracyAdjustmentProtocol(
                    5,
                    "THEOCRACY_5_CLERICAL_AHBAR_AND_RUHBAN_THEOCRATS",
                    "5. Clerical Theocrats Claiming Legislative Sovereignty (Al-Ahbar wa Ar-Ruhban — Rabbis, Priests & Pontiffs)",
                    "Medina, Najran & Universal Islamic Constitutional Law (9 AH / 630 CE onward).",
                    "In Qur'an 9:31 ('They took their scholars and monks as lords besides Allah') and 9:34, Islam diagnosed the root pathology of theocrats: human clerics claiming the power to declare the lawful unlawful, invent binding dogma, forgive sins for money, and devour people's wealth.",
                    "As the Prophet ﷺ explained to 'Adi ibn Hatim (Tirmidhi 3095), obeying a cleric who overrides Divine Law is itself worshipping him. Islam therefore permanently abolished clerical theocracy ('La Kahanuta fi Al-Islam'): every believer stands directly before Allah without an intermediary priest; scholars ('Ulama') are fallible legal researchers bound by explicit textual proof (Dalil); and the Najran Christian delegation was allowed to pray inside the Prophet's Mosque while debating theology peacefully.",
                    "Qur'an 9:31, 9:34, 3:79-80 & Jami' At-Tirmidhi 3095 (Hadith of 'Adi ibn Hatim)"
            ),
            new TheocracyAdjustmentProtocol(
                    6,
                    "THEOCRACY_6_SABIAN_HARRANIAN_HERMETIC_PRIESTHOOD",
                    "6. The Astral-Philosophical Temple Polity of the Sabians of Harran (Sabi'at Harran)",
                    "Harran (Upper Mesopotamia) & Baghdad (215 AH / 830 CE under Caliph Al-Ma'mun to 10th Century CE).",
                    "Harranian philosopher-priests venerated the First Cause alongside planetary temples and claimed Hermes Trismegistus (Prophet Idris) and Agathodaimon (Seth) as their prophets.",
                    "Under Qur'an 2:62 and 5:69 (which explicitly name As-Sabi'un), Abbasid jurists recognized the Harranians as a protected book-holding community. In return, Harranian Sabian mathematicians and astronomers—led by Thabit ibn Qurrah and Al-Battani—worked at the heart of the Baghdad scientific academy, translating Greek mathematics and refining astronomical tables used for prayer times and Qiblah calculation.",
                    "Qur'an 2:62, 5:69, 22:17 & Ibn an-Nadim's Al-Fihrist (Book IX on Harran)"
            ),
            new TheocracyAdjustmentProtocol(
                    7,
                    "THEOCRACY_7_BRAHMANICAL_AND_BUDDHIST_TEMPLE_POLITIES",
                    "7. Brahmanical Hindu & Buddhist Temple Polities of Sind, Multan & Hind (Al-Barahimah wa As-Sumaniyyah)",
                    "Sind, Multan & Northern India (92 AH / 711 CE under Muhammad ibn al-Qasim to Al-Biruni in 1030 CE & Mughal Dara Shikoh).",
                    "Encountered vast temple networks governed by hereditary Brahmin priests and Buddhist monastic Sanghas outside the Mediterranean Abrahamic sphere.",
                    "In 711 CE, Muhammad ibn al-Qasim and the Hanafi/Syrian jurists issued the Charter of Al-Rur (Aror): 'The temples (Al-Budd) of Hind shall be treated exactly like the churches of the Christians, the synagogues of the Jews, and the fire-temples of the Magians' (Al-Baladhuri, Futuh Al-Buldan 439), leaving Brahmin priests their temple endowments. Later, Al-Biruni mastered Sanskrit to write Kitab Ma li-l-Hind, demonstrating with objective scholarly empathy that educated Hindu philosophy affirmed One Transcendent God (Ishvara/Brahman).",
                    "Al-Baladhuri's Futuh Al-Buldan p. 439 (Charter of Al-Rur), Hanafi Fiqh on Ahl Adh-Dhimmah & Al-Biruni's India"
            )
    );

    private static final List<SocraticCritiqueEngagement> FIVE_SOCRATIC_CRITIQUES = List.of(
            new SocraticCritiqueEngagement(
                    1,
                    "SOCRATIC_1_EUTHYPHRO_DILEMMA_MORAL_ONTOLOGY",
                    "1. The Euthyphro Dilemma: 'Is the pious/good loved by the gods because it is good, or is it good because it is loved by the gods?'",
                    "In Plato's Euthyphro, Socrates exposed how polytheistic gods disagree on justice—what Zeus loves, Cronus hates—forcing ethics into a dilemma between autonomous moral realism and arbitrary divine command.",
                    "This exact Socratic question became the centerpiece of Islamic Usul Al-Fiqh and Kalam under the title 'Al-Husn wa Al-Qubh' (Moral Goodness and Badness): Mu'tazilis held the first horn (reason independently knows intrinsic good, and Allah commands it because it is good); Ash'aris held the second horn (Allah's Command defines moral obligation so nothing binds Him externally); while the Maturidi, Ibn Taymiyyan, and Akbarian synthesis proved that in Tawhid the dilemma dissolves: Allah is not a capricious Olympian, nor is Wisdom external to Him—His Will (Iradah) is eternally identical with His Wisdom (Hikmah), Justice ('Adl), and Mercy (Rahmah).",
                    "Produced the doctrine of Maqasid Ash-Shari'ah (Al-Juwayni, Al-Ghazali, Al-'Izz ibn 'Abd as-Salam, Ash-Shatibi): every Divine ruling demonstrably serves five universal rational goods (preserving Faith, Life, Intellect, Lineage, and Property).",
                    "Qur'an 6:115 ('The word of your Lord has been fulfilled in truth and justice'), 16:90 & Ash-Shatibi's Al-Muwafaqat"
            ),
            new SocraticCritiqueEngagement(
                    2,
                    "SOCRATIC_2_ELENCHUS_AGAINST_BLIND_ANCESTRAL_TAQLID",
                    "2. Socratic Elenchus (Dialectical Cross-Examination of Unexamined Ancestral Custom & Civic Idolatry)",
                    "Al-Kindi, Abu Bakr ar-Razi (As-Sirah Al-Falsafiyyah), and Al-Mubashshir ibn Fatik revered Socrates (Suqrat Al-Hakim) as a monotheistic ascetic who questioned Athens' ancestral idols and chose the hemlock cup over Shirk.",
                    "The Qur'an elevates Socratic Elenchus into a supreme prophetic method against Taqlid Al-Aba' (blind imitation of forefathers, Qur'an 2:170, 5:104). In Qur'an 21:52-67 and 6:76-83, Prophet Ibrahim cross-examines his father Azar, the Babylonian star-worshippers, and the temple priests using pure dialectical questioning—leaving the axe on the chief idol so the priests themselves confess: 'You know well that these cannot speak!' (21:65).",
                    "Institutionalized as 'Ilm Al-Jadal wa Adab Al-Bahth wa Al-Munazarah (The Science of Dialectical Disputation), which every Islamic college (Madrasah) taught—and which Western scholastics (Abelard, Aquinas) later adopted from the Islamic world as the Sic et Non disputation method.",
                    "Qur'an 2:111 ('Produce your proof — Hatu Burhanakum'), 2:170, 21:52-67 & 2:258"
            ),
            new SocraticCritiqueEngagement(
                    3,
                    "SOCRATIC_3_EPISTEMIC_HUMILITY_KNOWING_IGNORANCE",
                    "3. Socratic Epistemic Humility (Apology 21d: 'I neither know nor think that I know' — Wisdom Begins by Knowing One's Limits)",
                    "Cited across Islamic wisdom compendia (Hunayn ibn Ishaq's Nawadir Al-Falasifah, Ibn Hindu) as the mark of the true sage versus the arrogant sophist.",
                    "Canonically anchored in Qur'an 17:85 ('And you have not been given of knowledge except a little'), Qur'an 12:76 ('And above every possessor of knowledge is One More Knowing'), and the Angels' confession in Qur'an 2:32 ('Glory be to You; we have no knowledge except what You have taught us').",
                    "Codified as a strict legal duty for every Mufti and Qadi: 'Saying La Adri (I do not know) is half of knowledge' (ash-Sha'bi / Ibn 'Umar). When a man traveled six months from North Africa to Medina to ask Imam Malik 48 questions, Malik answered 32 of them with 'La Adri' (I do not know), telling the questioner: 'Go back and tell them Malik does not know!'",
                    "Qur'an 17:85, 12:76, 2:32 & Ibn 'Abd al-Barr's Jami' Bayan Al-'Ilm"
            ),
            new SocraticCritiqueEngagement(
                    4,
                    "SOCRATIC_4_CRITIQUE_OF_SOPHISTRY_AND_WRITTEN_TEXT",
                    "4. Socratic Critique of Sophistic Rhetoric (Gorgias) & Phaedrus's Warning that Unaccompanied Writing Cannot Defend Itself Without a Living Teacher",
                    "In Plato's Phaedrus (275d-e), Socrates warns that written texts alone, without oral transmission and a living master to clarify them, can be twisted by anyone.",
                    "Islam answered both critiques simultaneously: (1) Against Sophistry (Safsatah), the Qur'an distinguishes Burhan (demonstrative proof), Mau'izah Hasanah (ethical exhortation), and Jadal bi-allati hiya ahsan (gracious dialectic, Qur'an 16:125) from deceptive rhetoric; (2) Addressing Phaedrus's critique of dead writing, Islam never transmitted the Qur'an or Hadith as a solitary unvoiced book—it mandated unbroken living oral chain-transmission (Isnad & Tawatur) heart-to-heart from teacher to student alongside written codices ('Ilm Dirayah wa Riwayah).",
                    "Created the world's most rigorous authentication system: the Isnad and Ijazah (personal oral certification) coupled with Ibn Khaldun's criterion of sociological plausibility.",
                    "Qur'an 16:125 ('Invite to the way of your Lord with wisdom...'), 75:16-19 & Muslim's Introduction to Sahih ('Al-Isnad min Ad-Din')"
            ),
            new SocraticCritiqueEngagement(
                    5,
                    "SOCRATIC_5_SUFFICIENCY_OF_REASON_VS_NECESSITY_OF_PROPHECY",
                    "5. The Radical Socratic/Rationalist Critique of Prophecy (Al-Barahimah & Abu Bakr ar-Razi: 'If Reason Is Given to All Humans, Why Are Prophets Needed?')",
                    "Debated publicly in 10th-century Rayy and Baghdad between the physician-philosopher Abu Bakr Muhammad ibn Zakariyya ar-Razi (Makhariq Al-Anbiya') and the theologian-philosopher Abu Hatim ar-Razi (A'lam An-Nubuwwah), and later answered definitively by Ibn Sina and Al-Ghazali.",
                    "Islamic philosophy and theology answered this critique on Socratic and medical grounds: (1) Human survival requires cooperative society (Tamaddun), which requires universal law freed from egoistic bias (Ibn Sina, Ash-Shifa' X.2); (2) Just as the physical eye possesses sight yet remains blind in the dark until external sunlight shines upon it, human Reason ('Aql) is the eye of the soul while Prophetic Revelation (Wahy) is the Sun (Al-Ghazali, Al-Munqidh); and (3) Even in medicine, one could never discover the exact non-lethal dosages of compound drugs by random trial-and-error without thousands dying—still less can unaided reason discover the exact spiritual dosages of worship (Maqadir Al-'Ibadat) and the unseen realities of the Hereafter.",
                    "Established the complementary twin-light doctrine ('Nurun 'ala Nur', Qur'an 24:35): 'Aql (Reason) is the internal prophet, and Wahy (Revelation) is the external intellect; neither dispenses with the other.",
                    "Qur'an 24:35 ('Light upon Light'), Abu Hatim ar-Razi's A'lam An-Nubuwwah, Ibn Sina's Ash-Shifa' X.2 & Al-Ghazali's Al-Munqidh"
            )
    );

    private static final List<MessageSemanticShiftStage> SEVEN_MESSAGE_SEMANTIC_SHIFTS = List.of(
            new MessageSemanticShiftStage(
                    1,
                    "SHIFT_1_INVARIANT_LAFZ_VS_EXPANDING_DALALAH",
                    "Stage I: The Foundational Rule — Invariant Arabic Text (Lafz Mahfuz) vs. Expanding Semantic Horizon (Ittisa' Ad-Dalalah)",
                    "Jawami' Al-Kalim (All-Comprehensive Concise Speech), Zahr (Outward Sense) & Batn (Inward Depth), Muhkam (Foundational Anchor) & Mutashabih (Polyvalent Symbol).",
                    "Unlike previous scriptures whose wording changed through translation into Greek, Latin, or Aramaic, the Qur'anic Arabic text was locked verbatim (Qur'an 15:9). Therefore, during expansion, the words never changed; instead, each new era and civilization unlocked deeper latent semantic layers (Istinbat, Qur'an 4:83) already encoded in the trilateral Arabic roots.",
                    "For example, Qur'an 21:30 ('The heavens and earth were a joined entity [Ratqan] and We parted them') was understood by 7th-century desert listeners as rain falling from closed sky to open dry earth, and by 20th/21st-century cosmologists as cosmic expansion—both valid meanings of the root R-T-Q and F-T-Q.",
                    "Qur'an 15:9, 4:83 (Istinbat), 31:27 & Sahih al-Bukhari 2977 ('Bu'ithtu bi-Jawami' Al-Kalim')"
            ),
            new MessageSemanticShiftStage(
                    2,
                    "SHIFT_2_MAKKI_EXISTENTIAL_TO_MADANI_CONSTITUTIONAL",
                    "Stage II: From Meccan Existential Awakening (Al-Makki) to Medinan Constitutional & Fiscal Law (Al-Madani, 1–10 AH)",
                    "Salah (Prayer/Supplication -> 5 Daily Institutional Prayers), Zakah (Moral Purification -> Audited State Wealth Tax with Nisab), Jihad (Inner Spiritual Striving -> Regulated State Defense), Fath (Divine Verdict -> Diplomatic Truce & Bloodless Liberation).",
                    "Known in Usul Al-Fiqh as 'An-Naql Ash-Shar'i' (Transfer of a word from its general linguistic root to a precise legal/institutional definition) and gradual legislation (At-Tadarruj fi At-Tashri').",
                    "In Mecca, 'Atu az-Zakah' meant voluntary charity and soul-cleansing (Qur'an 91:9); after 2 AH in Medina, the same message acquired an exact legal schedule of camels, grain, silver, and state collectors ('Amilun 'alayha, Qur'an 9:60) without losing its inward meaning of purification.",
                    "Qur'an 9:60, 9:103, 73:20 & Ash-Shatibi's Al-Muwafaqat on Makki vs. Madani"
            ),
            new MessageSemanticShiftStage(
                    3,
                    "SHIFT_3_DESERT_PASTORAL_ROOTS_TO_IMPERIAL_URBAN_SCIENCES",
                    "Stage III: From Desert Pastoral Metaphors to Cosmopolitan Urban Sciences (15–150 AH / Damascus, Kufah, Basra, Medina)",
                    "Shari'ah (Path to a desert water-spring -> Constitutional Sacred Law), Fiqh (Simple comprehension -> Systematic Jurisprudence), Sunnah (Beaten camel-track -> Canonical Prophetic Precedent), Mawla (Tribal kinsman/client -> Non-Arab Scholar-Vanguard of Islamic Civilization).",
                    "As millions of urban Syrians, Egyptians, Iraqis, and Persians entered Islam, concrete Bedouin spatial metaphors wereuniversalized into the technical terminology of global law, grammar (Sibawayh), and historiography.",
                    "The word 'Mawla' shifted from a subordinate tribal client to the badge of honor borne by the greatest non-Arab imams of Islam (Al-Hasan al-Basri, Abu Hanifah, Muhammad ibn Ishaq, Al-Bukhari), fulfilling the Farewell Sermon: 'No Arab has superiority over a non-Arab except by Taqwa' (Musnad Ahmad 23489).",
                    "Qur'an 45:18 (Shari'ah), 9:122 (Tafaqquh), 49:13 & Ibn Khaldun's Muqaddimah (Ch. VI.42 on Non-Arab Scholars)"
            ),
            new MessageSemanticShiftStage(
                    4,
                    "SHIFT_4_GRAECO_ARABIC_PHILOSOPHICAL_AND_SCIENTIFIC_CALIBRATION",
                    "Stage IV: The Graeco-Arabic & Persian Scientific Calibration of Meaning (150–450 AH / Baghdad, Cairo & Cordoba)",
                    "'Aql (Camel's knee-hobble -> Theoretical & Practical Intellect / Logos), Jawhar (Persian jewel -> Substance / Atom), 'Arad (Passing cloud -> Philosophical Accident), Hikmah (Prophetic maxim -> Philosophy, Medicine & Physics), Nur (Light -> Ray Optics & Ontological Consciousness).",
                    "Through the translation movement and Kalam-Falsafah synthesis, everyday Arabic words were forged into the highest-precision scientific and metaphysical lexicon on earth—capable of expressing Euclidean geometry, Avicennian modal logic, and Alhazen's experimental optics.",
                    "When a 7th-century Companion heard 'La jawhara illa...' or ''Aql', he thought of pearls and moral restraint; when a 10th-century scholar in Baghdad or Cordoba read the same words in a Tafsir (like Fakhr ad-Din ar-Razi's Mafatih Al-Ghayb), they carried 300 years of atomic physics, logic, and astronomy alongside the original Arabic root.",
                    "Qur'an 2:269, 24:35, Al-Farabi's Kitab Al-Huruf (Book of Letters on Semantic Evolution) & Fakhr ad-Din ar-Razi's Tafsir"
            ),
            new MessageSemanticShiftStage(
                    5,
                    "SHIFT_5_SHAFI_I_QADIM_TO_JADID_GEOGRAPHIC_CONTEXTUALIZATION",
                    "Stage V: Geographic & Customary Contextualization of Legal Meaning (Imam Ash-Shafi'i's Old Iraqi School vs. New Egyptian School)",
                    "'Urf (Local Custom), Maslahah Mursalah (Public Interest), Tahqiq Al-Manat (Verifying the Empirical Context of a Ruling), Taghayyur Al-Fatwa (Evolution of Legal Verdicts Across Time and Place).",
                    "Canonical Islamic jurisprudence established that while the Divine Text (Nass) and Universal Objectives (Maqasid) are immutable, the empirical meaning of a legal message changes when the geographic, economic, or customary reality ('Urf) changes: 'Al-'Adah Muhakkamah' (Custom has legal authority).",
                    "When Imam Ash-Shafi'i moved from Baghdad to Cairo in 199 AH (814 CE), he observed how Egyptian agrarian life, water rights, and social customs differed from Iraq—prompting him to revise dozens of his previous Iraq rulings (Al-Madhhab Al-Qadim) into his New Egyptian School (Al-Madhhab Al-Jadid), proving that fidelity to the message requires adapting its application to local reality.",
                    "Qur'an 7:199 ('Hold to forgiveness, command what is customary [Al-'Urf]'), Ibn Qayyim's I'lam Al-Muwaqqi'in 3/11 & Al-Qarafi's Al-Furuq"
            ),
            new MessageSemanticShiftStage(
                    6,
                    "SHIFT_6_FOUR_TIER_SUFI_AND_ISHRAQI_INTERIORIZATION",
                    "Stage VI: The Four-Tier Interiorization of Meaning ('Ibarah, Isharah, Lata'if, Haqa'iq — From Outward Law to Inward Alchemy)",
                    "Hijrah (Physical migration -> Migrating from sins to Allah, Bukhari 10), Jihad (Battlefield defense -> Mujahadat An-Nafs), Bayt Allah (The stone Ka'bah in Mecca -> The believer's purified heart), Kimiya' (Metallic transmutation -> Spiritual Alchemy of the Soul).",
                    "Once the external frontiers of Islam were secure, scholars and Sufi masters (Al-Qushayri, Al-Ghazali, Ibn 'Arabi, Rumi) emphasized the Prophet's own interiorization of vocabulary: 'The true Muhajir (migrant) is the one who forsakes what Allah has forbidden' (Bukhari 10), and 'The strong man is not the wrestler, but the one who controls himself in anger' (Bukhari 6114).",
                    "As codified by Imam Ja'far as-Sadiq: the Book of Allah contains four simultaneous levels of meaning—'Ibarah (Literal Expression for the general public), Isharah (Allusion for the elite intellects), Lata'if (Subtle Graces for the Awliya'), and Haqa'iq (Ultimate Realities for the Prophets)—none of which cancels the outward Shari'ah.",
                    "Sahih al-Bukhari 10, Bukhari 6114, Al-Ghazali's Ihya' 'Ulum Ad-Din & As-Sulami's Haqa'iq At-Tafsir"
            ),
            new MessageSemanticShiftStage(
                    7,
                    "SHIFT_7_PERSIANATE_TURKIC_AND_MARITIME_VERNACULAR_TRANSCULTURATION",
                    "Stage VII: Trans-Civilizational Vernacularization (Persianate, Turkic, Urdu, Swahili & Malay-Jawi Cosmopolis, 400–1300 AH)",
                    "Namaz / Roza (Persian/Turkic/Urdu for Salah & Sawm), Khuda / Tengri / Pangeran (Vernacular names mapped to Allah's attributes), Gulistan & Meykhaneh (Sufi poetic Rose-Garden and Tavern of Divine Love), Perahu (Malay Sufi ship of the soul).",
                    "As Islam spread peacefully via Silk Road caravanserais and Indian Ocean maritime trade into Persia, Central Asia, India, East Africa, and the Malay Archipelago, the message was transcreated into indigenous poetic and cultural idioms using the Arabic script (Persian, Ottoman, Chagatai, Urdu, Ajami, Jawi).",
                    "Rumi's Persian Mathnawi was hailed as 'the Qur'an in the Pahlavi/Persian tongue'; in Java and Sumatra, the Wali Songo and Hamzah Fansuri explained Ibn 'Arabi's metaphysics of light and ocean waves through Malay maritime imagery and wayang shadow-theater—showing how a single monotheistic message became native to every human tongue (Qur'an 14:4 & 30:22).",
                    "Qur'an 14:4 ('We did not send any messenger except in the language of his people'), 30:22 & Shah Wali Allah's Hujjat Allah Al-Balighah"
            )
    );

    public static List<PhilosophyAndAlchemyEpoch> allSevenPhilosophyAndAlchemyEpochs() {
        return SEVEN_PHILOSOPHY_AND_ALCHEMY_EPOCHS;
    }

    public static List<TheocracyAdjustmentProtocol> allSevenTheocracyAdjustments() {
        return SEVEN_THEOCRACY_ADJUSTMENTS;
    }

    public static List<SocraticCritiqueEngagement> allFiveSocraticCritiques() {
        return FIVE_SOCRATIC_CRITIQUES;
    }

    public static List<MessageSemanticShiftStage> allSevenMessageSemanticShifts() {
        return SEVEN_MESSAGE_SEMANTIC_SHIFTS;
    }
}
