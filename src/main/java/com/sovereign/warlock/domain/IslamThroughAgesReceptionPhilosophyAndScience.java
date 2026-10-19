package com.sovereign.warlock.domain;

import java.util.List;

/**
 * Expansive 3-Volume Canonical Domain Model of:
 * - Volume I (Portal #61): Islam Through the Ages & Its Global Civilizational Reception (7 Ages from 610 CE
 *   Late Antiquity through Latin Scholasticism, the Renaissance/Copernican reception, the Enlightenment,
 *   and the 21st-Century Global Horizon).
 * - Volume II (Portal #62): The Philosophical Connotations of Islam Through the Ages (7 Foundational Paradigms:
 *   Modal Ontology [Wajib Al-Wujud], The Floating Man [Ar-Rajul Al-Mu'allaq], Causal Regularity & Epistemic
 *   Humility [Sunnat Allah], Harmony of Reason & Revelation [Fasl Al-Maqal], Experimental Empiricism
 *   [Al-I'tibar], Substantial Motion [Al-Harakah Al-Jawhariyyah], and Philosophy of History & Law
 *   ['Ilm Al-'Umran & Maqasid Ash-Shari'ah]).
 * - Volume III (Portal #63): Scientific Discoveries Alluded to in the Qur'an & Hadith (Al-Isharat Al-Kawniyyah)
 *   That Were Instantiated Through Science — Tracing both Classical Islamic Scientific Instantiation
 *   and Modern Empirical Verification Across 7 Scientific Disciplines.
 */
public final class IslamThroughAgesReceptionPhilosophyAndScience {

    private IslamThroughAgesReceptionPhilosophyAndScience() {
    }

    /**
     * Volume I Record: Represents one of the 7 Ages of Islam and its reception across world civilizations.
     */
    public record HistoricalReceptionAge(
            int ageIndex,
            String ageCode,
            String chronologicalSpanAndCenters,
            String titleAndCivilizationalScope,
            String primaryQuranicAndCanonicalAnchors,
            String internalIslamicEvolution,
            String crossCivilizationalReceptionAndInterlocutors,
            String enduringIntellectualArtifacts,
            String hexColor
    ) {
    }

    /**
     * Volume II Record: Represents one of the 7 canonical philosophical connotations and paradigms instantiated by Islam.
     */
    public record PhilosophicalConnotationParadigm(
            int paradigmIndex,
            String paradigmCode,
            String arabicAndEnglishTitle,
            String chiefPhilosophersAndTreatises,
            String quranicOntologicalAndEpistemicRoot,
            String formalPhilosophicalFormulation,
            String receptionByWesternAndGlobalPhilosophy,
            String contemporaryPhilosophicalSignificance,
            String hexColor
    ) {
    }

    /**
     * Volume III Record: Represents one of the 7 scientific domains where Qur'anic and Prophetic allusions
     * (Ayat Kawniyyah) were instantiated through experimental and mathematical science.
     */
    public record ScientificAllusionAndInstantiation(
            int domainIndex,
            String domainCode,
            String scientificDisciplineAndTitle,
            String quranicAndPropheticAllusions,
            String philologicalAndExegeticalPrecision,
            String classicalIslamicScientificInstantiation,
            String modernEmpiricalVerificationAndSynthesis,
            String signatureInstrumentsAndTreatises,
            String hexColor
    ) {
    }

    private static final List<HistoricalReceptionAge> SEVEN_HISTORICAL_RECEPTION_AGES = List.of(
            new HistoricalReceptionAge(
                    1,
                    "AGE-1-LATE-ANTIQUE-RECEPTION",
                    "Age I: 610–750 CE (13 BH – 132 AH) • Mecca, Medina, Aksum, Jerusalem, Damascus, Kufa & Córdoba",
                    "1. The Prophetic & Late Antique Reception: Abyssinian Sanctuary, Eastern Christian/Jewish Covenants & The End of Sasanian/Byzantine Monopoly",
                    "Qur'an 19:1–36 (Surah Maryam in Aksum), Qur'an 5:82–83 (Tears of the Abyssinian Christians recognizing the Truth), Qur'an 29:46, & Qur'an 3:64 (Call to a Common Word — Kalimatun Sawā').",
                    "Islam emerged in the Hejaz and rapidly expanded from the Atlantic to the Indus, transitioning from the oral prophetic community of Medina to the trans-continental Rashidun and Umayyad commonwealths while codifying the Muṣḥaf, Arabic grammar, and early jurisprudence.",
                    "Received first in 615 CE by the Christian Negus (Ashama ibn Abjar) of Abyssinia, who wept upon hearing Surah Maryam and drew a line in the sand declaring that Jesus and Muhammad came from the same niche of light. In the Levant, Egypt, and Iraq, Monophysite, Nestorian, Coptic, and Jewish communities—long persecuted by Byzantine orthodoxy—frequently welcomed the Covenant of 'Umar (637 CE) for restoring religious autonomy, lower taxation (Jizyah vs. Byzantine exactions), and Jewish access to Jerusalem after 500 years of Roman banishment.",
                    "Ṣaḥīfat Al-Madīnah (622 CE), Letters of the Prophet ﷺ to Heraclius, Khosrow & Negus, the Covenant of 'Umar in Jerusalem (637 CE), the Dome of the Rock inscriptions (691 CE), and John of Damascus's early theological dialogues in the Umayyad court.",
                    "#10B981"
            ),
            new HistoricalReceptionAge(
                    2,
                    "AGE-2-TRANSLATION-COSMOPOLITAN-SYNTHESIS",
                    "Age II: 750–1050 CE (132–442 AH) • Baghdad, Córdoba, Cairo, Kairouan, Rayy, Nishapur & Bukhara",
                    "2. The Abbasid & Andalusian Cosmopolitan Reception: Receiving, Critiquing & Transcending Greek, Sanskrit & Persian Learning",
                    "Qur'an 39:18 ('Those who listen to speech and follow the best of it'), Qur'an 49:13, & Prophetic maxim: 'Wisdom is the lost property of the believer.'",
                    "Through the Graeco-Arabic and Indo-Arabic Translation Movement in Baghdad (Bayt Al-Ḥikmah) and Umayyad Córdoba, Islamic civilization actively received, translated, corrected, and synthesized the entire scientific and philosophical heritage of Greece (Aristotle, Plato, Euclid, Ptolemy, Galen), India (Brahmagupta's Siddhānta, decimal numerals, Ayurvedic pharmacology), and Persia.",
                    "Rather than passively copying antiquity, Muslim polymaths (Al-Kindī, Al-Khwārizmī, Al-Fārābī, Al-Rāzī, Al-Bīrūnī, Ibn Sīnā, Ibn Al-Haytham) subjected Greek and Indian theories to rigorous empirical testing (I'tibār). In Córdoba, Jewish philosophy and Hebrew grammar experienced their Golden Age (Hasdai ibn Shaprut, Solomon ibn Gabirol, Bahya ibn Paquda, and later Maimonides) writing in Judeo-Arabic within the Islamic intellectual framework.",
                    "Al-Khwārizmī's Kitāb Al-Jabr, Al-Kindī's First Philosophy, Al-Bīrūnī's Kitāb Al-Hind (the first objective comparative study of Indian religion and science in world history, 1030 CE), Ibn Sīnā's Kitāb Ash-Shifā', and Ibn Al-Haytham's Kitāb Al-Manāẓir.",
                    "#D4AF37"
            ),
            new HistoricalReceptionAge(
                    3,
                    "AGE-3-LATIN-SCHOLASTIC-RECEPTION",
                    "Age III: 1050–1350 CE (442–750 AH) • Toledo, Palermo, Salerno, Montpellier, Paris, Oxford & Padua",
                    "3. The Medieval European Scholastic Reception: How Arabic Science & Philosophy Awakened the Latin West",
                    "Qur'an 2:269 ('He gives wisdom [Al-Ḥikmah] to whom He wills, and whoever has been given wisdom has certainly been given much good') & Qur'an 16:125.",
                    "While the Islamic heartlands navigated the Crusades and the Mongol invasions via the Seljuk, Ayyubid, and Mamluk Sultanates—developing the Madrasah network (Niẓāmiyyah, Mustanṣiriyyah), post-Avicennian Kalām (Al-Ghazālī, Fakhr al-Dīn al-Rāzī), and Sufi metaphysics (Ibn 'Arabī, Rūmī)—Andalusian and Sicilian borderlands became the conduit of knowledge to Christian Europe.",
                    "At the Toledo School of Translators (Gerard of Cremona, Adelard of Bath, Michael Scot) and the Norman-Sicilian court of Roger II and Frederick II in Palermo, hundreds of Arabic texts were translated into Latin. Adelard of Bath declared that from his Arab masters he learned 'to be led by reason rather than the halter of authority.' St. Thomas Aquinas cited Ibn Sīnā (Avicenna) and Ibn Rushd (Averroes, whom Dante called 'he who made the Great Commentary') hundreds of times in the Summa Theologiae; Roger Bacon founded his optics on Ibn Al-Haytham (Alhazen); and Fibonacci (1202 CE) introduced Hindu-Arabic numerals to Europe from Bejaïa, Algeria.",
                    "Latin translations of Avicenna's Canon Medicinae (standard in European medical faculties until the 17th century), Averroes's Grand Commentaries on Aristotle, Alhazen's Perspectiva (Opticae Thesaurus), and Al-Idrīsī's Tabula Rogeriana (1154 CE).",
                    "#38BDF8"
            ),
            new HistoricalReceptionAge(
                    4,
                    "AGE-4-AFRO-EURASIAN-RENAISSANCE-RECEPTION",
                    "Age IV: 1250–1600 CE (648–1008 AH) • Maragheh, Samarkand, Istanbul, Timbuktu, Malacca, Ming China & Renaissance Italy",
                    "4. The Afro-Eurasian & Renaissance Reception: Mongol Conversion, Chinese Hui Astronomy & The Copernican Mathematical Bridge",
                    "Qur'an 41:34 (Transforming former enemies into devoted friends), Qur'an 30:22 (Signs in the diversity of tongues and colors), & Qur'an 55:5 (The sun and moon by precise calculation).",
                    "After the 1258 fall of Baghdad, Islam achieved an astonishing triple reception: (1) Converting the Mongol Ilkhanate, Golden Horde, and Chagatai Khanates; (2) Expanding peacefully across West Africa (Mali/Songhai) and the Indonesian-Malay Archipelago; and (3) Establishing the Maragheh (1259 CE), Samarkand (1420 CE), and Istanbul (1577 CE) astronomical observatories.",
                    "In Ming China, Muslim astronomers (Jamāl al-Dīn) directed the Imperial Astronomical Bureau in Beijing while Admiral Zheng He (Ma He, a Yunnanese Muslim) led the 7 Ming treasure-fleet voyages (1405–1433). Simultaneously, in Renaissance Europe, Nicolaus Copernicus's De Revolutionibus (1543) utilized the exact mathematical theorems invented by Naṣīr al-Dīn al-Ṭūsī (the Ṭūsī Couple, 1247 CE), Mu'ayyad al-Dīn al-'Urḍī ('Urḍī's Lemma), and Ibn al-Shāṭir of Damascus (1375 CE) to eliminate Ptolemaic equants, while Paduan anatomists (Realdo Colombo, 1559) echoed Ibn al-Nafīs's pulmonary circulation.",
                    "Al-Ṭūsī's Tadhkirah fī 'Ilm Al-Hay'ah, Ibn al-Shāṭir's Nihāyat As-Sūl, Ulugh Beg's Zīj-i Sulṭānī (1437 CE star catalog), Timbuktu's Sankore astronomical manuscripts, and Copernicus's Commentariolus / De Revolutionibus.",
                    "#A855F7"
            ),
            new HistoricalReceptionAge(
                    5,
                    "AGE-5-ENLIGHTENMENT-ROMANTIC-RECEPTION",
                    "Age V: 1600–1850 CE (1008–1266 AH) • Isfahan, Istanbul, Delhi, Oxford, London, Weimar & Monticello",
                    "5. The Early Modern & Enlightenment Reception: Ḥayy ibn Yaqẓān, Locke, Leibniz, Goethe & Constitutional Religious Freedom",
                    "Qur'an 2:256 ('No compulsion in religion'), Qur'an 2:115 ('To Allah belong the East and the West; wheresoever you turn, there is the Face of Allah'), & Qur'an 3:190.",
                    "While the Safavid School of Isfahan (Mullā Ṣadrā, Mir Damad), Ottoman polymaths (Kâtib Çelebi, Hezârfen), and Indian reformers (Aḥmad Sirhindī, Shāh Walīullāh Dehlawī) synthesized philosophy, mysticism, and law, European Enlightenment thinkers turned to Islamic philosophical texts for models of natural reason and religious toleration.",
                    "In 1671, Edward Pococke published the Arabic-Latin edition of Ibn Ṭufayl's 12th-century philosophical novel Ḥayy ibn Yaqẓān (Philosophus Autodidactus) at Oxford, followed by Simon Ockley's 1708 English translation. As historian Samar Attar and G.A. Russell proved, Ḥayy ibn Yaqẓān directly inspired John Locke's empirical tabula rasa (Essay Concerning Human Understanding, 1690), Daniel Defoe's Robinson Crusoe (1719), and Quaker/Enlightenment natural theology. In 1734, George Sale's English translation of the Qur'an was purchased by Thomas Jefferson (1765), shaping his defense of universal religious freedom for Muslims, Jews, and Christians alike; while Johann Wolfgang von Goethe composed his West-östlicher Divan (1819), declaring: 'If Islam means submission to God, in Islam we all live and die.'",
                    "Ibn Ṭufayl's Ḥayy ibn Yaqẓān (Oxford 1671), Mullā Ṣadrā's Al-Asfār Al-Arba'ah, Lady Mary Wortley Montagu's 1717 introduction of Ottoman variolation (smallpox inoculation) to England, Thomas Jefferson's 1734 Sale Qur'an (now in the Library of Congress), and Goethe's West-östlicher Divan.",
                    "#F43F5E"
            ),
            new HistoricalReceptionAge(
                    6,
                    "AGE-6-MODERNIST-EXISTENTIAL-RECEPTION",
                    "Age VI: 1850–1970 CE (1266–1390 AH) • Cairo, Lahore, Istanbul, Paris, Cambridge, Tokyo & New York",
                    "6. The Modernist, Anti-Colonial & Comparative Reception: Iqbāl, Massignon, Izutsu, Toynbee & Malcolm X",
                    "Qur'an 13:11 ('Allah does not change the condition of a people until they change what is within themselves'), Qur'an 29:69, & Qur'an 55:29 ('Every day He is bringing about a matter').",
                    "Confronting European industrial dominance and colonial occupation, Muslim thinkers—Jamāl al-Dīn al-Afghānī, Muḥammad 'Abduh, Rashīd Riḍā, Said Nursî, Muḥammad Iqbāl, Malek Bennabi, and Fazlur Rahman—reconnected Islamic theology with modern physics, constitutionalism, and educational reform.",
                    "In the 20th century, Western and Asian scholars moved beyond colonial Orientalism toward profound philosophical engagement: Sir Muḥammad Iqbāl's Reconstruction of Religious Thought in Islam (1930) engaged Einstein's relativity, Whitehead, and Bergson through the Qur'anic concept of dynamic time; Toshihiko Izutsu in Japan pioneered semantic-structural analysis of the Qur'an; Louis Massignon and Henry Corbin introduced Sufi metaphysics to French phenomenology; Leopold Weiss (Muhammad Asad) authored The Road to Mecca and The Message of the Qur'an; and Arnold Toynbee praised Islam's erasure of race consciousness—vividly embodied in Malcolm X's 1964 Hajj letter.",
                    "Muḥammad Iqbāl's Reconstruction of Religious Thought in Islam (1930), Said Nursî's Risale-i Nur, Toshihiko Izutsu's God and Man in the Koran (1964), Muhammad Asad's The Message of the Qur'an, and Marshall Hodgson's 3-volume The Venture of Islam.",
                    "#F59E0B"
            ),
            new HistoricalReceptionAge(
                    7,
                    "AGE-7-CONTEMPORARY-SCIENTIFIC-DIGITAL-HORIZON",
                    "Age VII: 1970 CE – 21st Century (1390–1448+ AH) • Global Academy, Nobel Laboratories, Silicon Valley, Jakarta, Riyadh & Istanbul",
                    "7. The 21st-Century Scientific, Historiographical & Planetary Reception: Reclaiming the Lost Canon & Cosmic Āyāt",
                    "Qur'an 41:53 ('We will show them Our signs in the horizons and within themselves until it becomes clear to them that it is the Truth'), Qur'an 96:1–5, & Qur'an 67:3–4.",
                    "In the late 20th and 21st centuries, two parallel movements converged: (1) Historians of science (Fuad Sezgin's 17-volume Geschichte des arabischen Schrifttums, Roshdi Rashed's multi-volume studies of Arabic mathematics and optics, George Saliba, A.I. Sabra, David King, and Jim Al-Khalili) reconstructed thousands of Arabic manuscripts, proving that the 'Scientific Revolution' was a global continuum heavily built upon classical Islamic science; and (2) Muslim Nobel Laureates—Abdus Salam (Electroweak Unification, 1979, who quoted Qur'an 67:3–4 in his Nobel banquet speech), Ahmed Zewail (Femtochemistry, 1999), Aziz Sancar (DNA Repair, 2015), and Moungi Bawendi (Quantum Dots, 2023)—demonstrated living harmony between Qur'anic wonder and frontier discovery.",
                    "Simultaneously, contemporary philosophers and ethicists (Seyyed Hossein Nasr, Syed Muhammad Naquib al-Attas, Taha Abdurrahman, Wael Hallaq, Abdal Hakim Murad) have articulated Islamic responses to the ecological crisis, AI ethics, bioethics (where Islamic embryology and Maqāṣid Ash-Sharī'ah guide stem-cell and organ-transplant law), and interest-free sustainable finance.",
                    "Fuat Sezgin's Frankfurt Museum of Arabic-Islamic Science Instruments, Roshdi Rashed's Encyclopedia of the History of Arabic Science, Abdus Salam's 1979 Nobel Lecture on Symmetry, and the UNESCO International Year of Light (2015) celebrating the 1,000th anniversary of Ibn Al-Haytham's Kitāb Al-Manāẓir.",
                    "#22D3EE"
            )
    );

    private static final List<PhilosophicalConnotationParadigm> SEVEN_PHILOSOPHICAL_CONNOTATION_PARADIGMS = List.of(
            new PhilosophicalConnotationParadigm(
                    1,
                    "PHIL-1-MODAL-ONTOLOGY-WAJIB-AL-WUJUD",
                    "1. Modal Ontology: Necessary vs. Contingent Existence (وَاجِبُ الوُجُودِ وَمُمْكِنُ الوُجُودِ — Wājib Al-Wujūd vs. Mumkin Al-Wujūd)",
                    "Al-Fārābī (872–950 CE) & Ibn Sīnā / Avicenna (980–1037 CE) in Kitāb Ash-Shifā' (Al-Ilāhiyyāt) & Al-Ishārāt wa At-Tanbīhāt.",
                    "Qur'an 28:88 ('Everything will perish except His Face'), Qur'an 55:26–27 ('All that is upon it is passing away, and there remains the Face of your Lord, Possessor of Majesty and Honor'), & Qur'an 112:1–2 (Allāhu Aṣ-Ṣamad — The Eternally Self-Sufficient upon Whom all depend).",
                    "Ancient Greek philosophy struggled to explain why the universe exists at all rather than nothing, treating matter as eternal. Ibn Sīnā revolutionized metaphysics by distinguishing Essence (Māhiyyah—what a thing is) from Existence (Wujūd—that a thing is). Every finite entity in the cosmos is merely 'contingent in itself' (Mumkin Al-Wujūd bi-dhātihi): nothing in the definition of a star, a tree, or a human requires it to exist. Because an infinite regress of contingent causes cannot tip the scale from non-existence to existence, the entire contingent cosmos depends at every instant upon a single 'Necessary Existent in Itself' (Wājib Al-Wujūd bi-dhātihi) Whose very essence is to exist: Allah.",
                    "Directly adopted by Maimonides (Guide for the Perplexed), St. Thomas Aquinas (De Ente et Essentia and the Third Way of the Summa Theologiae), Duns Scotus, Spinoza, and Gottfried Wilhelm Leibniz (Principle of Sufficient Reason).",
                    "Provides the most rigorous non-cosmological proof of God: even if the physical universe were temporally boundless or a multiverse, it remains ontologically contingent and requires a Necessary Ground of Being at every moment.",
                    "#10B981"
            ),
            new PhilosophicalConnotationParadigm(
                    2,
                    "PHIL-2-FLOATING-MAN-SELF-CONSCIOUSNESS",
                    "2. Phenomenology of Self-Awareness: The Floating Man Thought Experiment (الرَّجُلُ المُعَلَّقُ فِي الفَضَاءِ — Ar-Rajul Al-Mu'allaq)",
                    "Ibn Sīnā / Avicenna in Kitāb Ash-Shifā' (Kitāb An-Nafs / De Anima, I.1 & V.7) & Al-Ishārāt.",
                    "Qur'an 15:29 & 38:72 ('And when I have proportioned him and breathed into him of My spirit [Rūḥī]'), Qur'an 17:85 ('Say: The Spirit [Ar-Rūḥ] is of the affair of my Lord'), & Qur'an 59:19 ('Do not be like those who forgot Allah, so He made them forget their own selves').",
                    "Six centuries before René Descartes wrote 'Cogito ergo sum' (1637), Ibn Sīnā formulated the 'Floating Man' (or Flying Man) thought experiment: Imagine a human being created all at once in full rational maturity, but veiled from seeing any external object, suspended in empty air where he feels no wind or temperature, and with his limbs separated so they never touch one another. Having zero sensory input and zero memory of a physical body, would he affirm his own existence? Ibn Sīnā proves that he would unhesitatingly affirm that his 'I' (Dhātuhu / Anāniyyatuhu) exists—demonstrating that self-consciousness is primordial, immediate, and non-reducible to physical sensory organs.",
                    "Translated into Latin in 12th-century Toledo as Liber De Anima seu Sextus de Naturalibus, shaping William of Auvergne, Jean de la Rochelle, Roger Bacon, and anticipating Descartes's Meditations on First Philosophy and modern phenomenology (Husserl) and philosophy of mind (Chalmers's 'Hard Problem of Consciousness').",
                    "Refutes reductive eliminative materialism in modern cognitive science and AI philosophy by proving that first-person subjective awareness (Shu'ūr bi-adh-Dhāt) is epistemically prior to third-person physical measurement.",
                    "#D4AF37"
            ),
            new PhilosophicalConnotationParadigm(
                    3,
                    "PHIL-3-CAUSAL-REGULARITY-SUNNAT-ALLAH",
                    "3. Epistemic Humility, Occasionalism & Habitual Cosmic Law (سُنَّةُ اللَّهِ وَنَقْدُ الضَّرُورَةِ الطَّبِيعِيَّةِ — Sunnat Allāh vs. Blind Natural Necessity)",
                    "Abū Ḥāmid Al-Ghazālī (1058–1111 CE) in Tahāfut Al-Falāsifah (17th Discussion on Causality) & Al-Munqidh min Aḍ-Ḍalāl; Fakhr al-Dīn al-Rāzī.",
                    "Qur'an 35:43 ('You will never find in the Sunnah [customary law] of Allah any change, and you will never find in the Sunnah of Allah any alteration'), Qur'an 21:69 ('We said: O fire, be coolness and safety upon Abraham'), & Qur'an 55:29.",
                    "In the 17th Discussion of Tahāfut Al-Falāsifah, Al-Ghazālī dismantled the Aristotelian dogma that physical causes possess autonomous metaphysical necessity (e.g., that fire must burn cotton by blind logical necessity). Using the exact example of fire and cotton, Al-Ghazālī pointed out that empirical observation only shows correlation ('occurs with it' — 'indahu), never autonomous agency ('occurs by it' — bihi). Yet far from destroying science, Al-Ghazālī and Ash'arī/Māturīdī theologians grounded empirical science in 'Sunnat Allāh' / ''Ādat Allāh' (Allah's consistent, mathematical habit in ordering nature): because natural laws are contingent divine ordinances rather than self-evident logical truths discoverable from an armchair, the scientist MUST go out and perform empirical experiments to discover how Allah actually ordered the universe!",
                    "Anticipated Nicolas Malebranche's occasionalism, David Hume's An Enquiry Concerning Human Understanding (1748) on constant conjunction, Immanuel Kant's critique of pure reason, and modern quantum mechanics (where deterministic Newtonian clockwork gives way to probabilistic laws).",
                    "Explains why empirical experimental science flourished in Islam: when nature is de-divinized and freed from Aristotelian logical necessity, only laboratory observation can reveal its laws.",
                    "#38BDF8"
            ),
            new PhilosophicalConnotationParadigm(
                    4,
                    "PHIL-4-HARMONY-REASON-REVELATION",
                    "4. The Unity of Demonstrative Reason & Divine Revelation (فَصْلُ المَقَالِ: الحَقُّ لَا يُضَادُّ الحَقَّ — Faṣl Al-Maqāl & Ḥayy ibn Yaqẓān)",
                    "Ibn Rushd / Averroes (1126–1198 CE) in Faṣl Al-Maqāl & Tahāfut At-Tahāfut; Ibn Ṭufayl (1105–1185 CE) in Ḥayy ibn Yaqẓān.",
                    "Qur'an 59:2 ('So take lessons/infer [Fa-'tabirū], O you who have vision!'), Qur'an 3:190–191 ('Those who remember Allah standing, sitting, and on their sides, and reflect [Yatafakkarūna] upon the creation of the heavens and the earth'), & Qur'an 7:185.",
                    "In Faṣl Al-Maqāl (The Decisive Treatise), the Chief Qāḍī of Córdoba and Seville, Ibn Rushd, issued a formal legal ruling (Fatwā) answering whether philosophical and scientific inquiry is forbidden, merely permitted, or obligatory in Islam. Citing Qur'an 59:2, 3:191, and 7:185, he proved that rational investigation of the universe is canonically obligatory (Wājib bi-ash-Shar'), and formulated his immortal theorem: 'For truth does not contradict truth; rather, it agrees with it and bears witness to it (Fa-inna al-ḥaqqa lā yuḍāddu al-ḥaqqa bal yuwāfiquhu wa yashhadu lahu).' Simultaneously, his mentor Ibn Ṭufayl showed in Ḥayy ibn Yaqẓān that a solitary child raised by a gazelle on an equatorial island, using only empirical observation, anatomy, astronomy, and pure reason, arrives at the exact same Tawḥīd and ethical virtues taught by prophetic revelation.",
                    "Catalyzed the rise of the European university faculties of arts in Paris, Bologna, and Padua (13th–16th centuries), while Ibn Ṭufayl's Ḥayy ibn Yaqẓān shaped the European Enlightenment's confidence in universal human reason.",
                    "Resolves the artificial conflict between science and religion: the Book of Scripture (Al-Kitāb Al-Mastūr) and the Book of the Cosmos (Al-Kitāb Al-Manẓūr) have the same Author and can never truly contradict.",
                    "#A855F7"
            ),
            new PhilosophicalConnotationParadigm(
                    5,
                    "PHIL-5-EXPERIMENTAL-EMPIRICISM-AL-ITIBAR",
                    "5. Philosophy of the Scientific Method: Controlled Experimentation (Al-I'tibār) & Methodological Doubt (Ash-Shukūk)",
                    "Al-Ḥasan Ibn Al-Haytham / Alhazen (965–1040 CE) in Kitāb Al-Manāẓir & Ash-Shukūk 'alā Baṭlamyūs; Al-Bīrūnī (973–1048 CE).",
                    "Qur'an 17:36 ('And do not pursue that of which you have no verified knowledge; indeed, the hearing, the sight, and the intellect—about all those one will be questioned'), Qur'an 2:111 ('Produce your proof [Hātū burhānakum] if you are truthful'), & Qur'an 10:36 ('Conjecture avails nothing against the Truth').",
                    "Prior to the 10th century, Greek science (Euclid, Ptolemy, Aristotle) relied overwhelmingly on deductive geometry and teleological speculation, often ignoring experimental anomalies. Working in Cairo, Ibn Al-Haytham transformed the Arabic Qur'anic term 'I'tibār' (from Qur'an 59:2, meaning 'reflective testing/crossing over from observation to inference') into the technical term for a controlled, repeatable laboratory experiment (what Latin translators rendered as 'experimentum'). He paired this with systematic falsification and peer critique in Ash-Shukūk 'alā Baṭlamyūs (Doubts Concerning Ptolemy), writing that the true scientist must make himself 'an enemy of all that he reads, and attack it from every side' while also suspecting his own biases.",
                    "Directly transmitted to Roger Bacon (Opus Majus, Part V), Witelo, John Pecham, Johannes Kepler (Astronomiae Pars Optica, 1604), and Galileo Galilei—completing the transition from Aristotelian deduction to modern hypothetico-deductive experimental science.",
                    "Establishes that the modern scientific method—hypothesis, mathematical modeling, controlled apparatus testing (Al-I'tibār), and peer falsification (Ash-Shukūk)—was born directly out of the Qur'anic ethic of verified proof (Burhān).",
                    "#F43F5E"
            ),
            new PhilosophicalConnotationParadigm(
                    6,
                    "PHIL-6-SUBSTANTIAL-MOTION-HARAKAH-JAWHARIYYAH",
                    "6. Dynamic Process Metaphysics: Substantial Motion & Time as the 4th Dimension (الحَرَكَةُ الجَوْهَرِيَّةُ — Al-Ḥarakah Al-Jawhariyyah)",
                    "Ṣadr al-Dīn al-Shīrāzī / Mullā Ṣadrā (1571–1640 CE) in Al-Ḥikmah Al-Muta'āliyah fī Al-Asfār Al-Arba'ah.",
                    "Qur'an 27:88 ('And you see the mountains, thinking them rigid/stationary, while they pass away as the passing of clouds'), Qur'an 50:15 ('Rather, they are in confusion over a new creation [Khalqin Jadīd]'), & Qur'an 55:29 ('Every day He is in a new manifestation').",
                    "For two thousand years, Aristotelian physics held that motion (Ḥarakah) only occurs in four superficial accidental categories (place, quantity, quality, position), whereas the underlying substance (Jawhar) of a thing remains static and fixed until destroyed. Grounding his philosophy in Qur'an 27:88 and 50:15, Mullā Ṣadrā proved the doctrine of 'Substantial Motion' (Al-Ḥarakah Al-Jawhariyyah): every physical substance in the universe is in continuous, dynamic evolutionary flux at its very core, constantly renewed at every instant (Tajaddud Al-Amthāl), and Time (Az-Zamān) is not an external container, but the intrinsic fourth dimension measuring the intensity of a substance's existence!",
                    "Anticipated 20th-century Process Philosophy (Alfred North Whitehead's Process and Reality), Henri Bergson's durée, and relativistic four-dimensional space-time where mass-energy and space-time form a single dynamic continuum.",
                    "Bridges classical Islamic metaphysics with quantum field theory and evolutionary cosmology, showing that the universe is not a static dead machine but a continuously unfolding act of creation.",
                    "#F59E0B"
            ),
            new PhilosophicalConnotationParadigm(
                    7,
                    "PHIL-7-ILM-AL-UMRAN-MAQASID",
                    "7. Philosophy of History, Social Cohesion & The Teleology of Law ('Ilm Al-'Umrān & Maqāṣid Ash-Sharī'ah)",
                    "Ibn Khaldūn (1332–1406 CE) in Al-Muqaddimah & Abū Isḥāq Ash-Shāṭibī (d. 1388 CE) in Al-Muwāfaqāt (building on Al-Juwaynī & Al-Ghazālī).",
                    "Qur'an 13:11 ('Indeed, Allah does not change the condition of a people until they change what is within themselves'), Qur'an 21:107 ('We have not sent you except as a mercy to the worlds'), & Qur'an 30:9.",
                    "Two 14th-century North African/Andalusian thinkers revolutionized social philosophy and legal theory simultaneously: (1) In Tunis and Fez, Ibn Khaldūn founded a completely new empirical science—'Ilm Al-'Umrān Al-Basharī (The Science of Human Civilization and Social Organization)—replacing uncritical chronicle-writing with causal laws of climate, division of labor, social solidarity ('Aṣabiyyah), urban luxury decay, and the fiscal Laffer curve; (2) In Granada, Imām Ash-Shāṭibī systematized Maqāṣid Ash-Sharī'ah (The Higher Objectives of Sacred Law), proving that every rule in Islam exists solely to realize human welfare (Maṣlaḥah) across five universal necessities: the protection of Faith (Dīn), Life (Nafs), Intellect ('Aql), Family/Lineage (Nasl), and Property (Māl).",
                    "Arnold Toynbee called Ibn Khaldūn's Muqaddimah 'undoubtedly the greatest work of its kind that has ever yet been created by any mind in any time or place,' while Ronald Reagan and Arthur Laffer cited Ibn Khaldūn's 14th-century taxation theorem as the forerunner of supply-side economics.",
                    "Provides a universal framework for modern public policy, bioethics, and human rights grounded in empirical social science and the 5 universal Maqāṣid.",
                    "#22D3EE"
            )
    );

    private static final List<ScientificAllusionAndInstantiation> SEVEN_SCIENTIFIC_ALLUSIONS_AND_INSTANTIATIONS = List.of(
            new ScientificAllusionAndInstantiation(
                    1,
                    "SCI-1-COSMOLOGY-ASTROPHYSICS",
                    "1. Cosmology & Astrophysics: Primordial Singularity (Ratq/Fatq), Cosmic Smoke (Dukhān) & The Expanding Universe (Mūsi'ūn)",
                    "Qur'an 21:30 ('Have those who disbelieved not considered that the heavens and the earth were a joined entity [Ratqan], and We clove them asunder [Fa-fataqnāhumā]?'), Qur'an 41:11 ('Then He directed Himself to the heaven while it was smoke [Dukhān]...'), Qur'an 51:47 ('And the heaven We constructed with power, and indeed We are expanding it [Wa innā la-mūsi'ūn]'), & Qur'an 21:33 ('Each floating in an orbit [Kullun fī falakin yasbaḥūn]').",
                    "In classical Arabic lexicography (Ibn Manẓūr's Lisān Al-'Arab & Ibn 'Abbās's Tafsīr): 'Ratq' means a fused, sewed-up, undifferentiated mass; 'Fatq' means the violent cleaving and parting of that fused mass; 'Dukhān' (unlike 'Bukhar' = cold water vapor/fog) specifically denotes hot, opaque gas suspended with solid particles; and 'Mūsi'ūn' (active participle of Awsa'a, Form IV of W-S-') means 'continuously expanding / making vaster.'",
                    "Inspired a 900-year astronomical revolution: Al-Battānī (Albatenius, d. 929) measured the solar year to 365 days, 5 hours, 46 minutes, 24 seconds and corrected Ptolemy's solar apogee; 'Abd ar-Raḥmān Al-Ṣūfī (964 CE) recorded the earliest human observation of a galaxy outside the Milky Way—the Andromeda Galaxy ('Al-Laṭkhah As-Saḥābiyyah' / Little Cloud) and the Large Magellanic Cloud in Kitāb Ṣuwar Al-Kawākib; Al-Bīrūnī debated the Earth's rotation on its axis; and the Maragheh/Damascus/Samarkand school (Al-Ṭūsī, Al-'Urḍī, Quṭb al-Dīn al-Shīrāzī, Ibn al-Shāṭir, Ulugh Beg, 'Alī Qūshjī) freed astronomy from Aristotelian natural philosophy and built the exact mathematical models later used by Copernicus.",
                    "In the 20th century, empirical astrophysics instantiated every element of these cosmic Āyāt: Alexander Friedmann, Georges Lemaître (1927), and Edwin Hubble (1929) proved that the universe is expanding (Qur'an 51:47) from a primordial fused state of extreme density (Ratq/Fatq, 21:30), passing through an opaque hot primordial plasma-gas epoch (Dukhān, 41:11) before recombination (verified by Penzias & Wilson's 1965 Cosmic Microwave Background discovery) out of which galaxies condensed.",
                    "Al-Ṣūfī's Book of Fixed Stars (964 CE), the Brass Planispheric Astrolabe & Armillary Sphere, Maragheh & Samarkand Giant Mural Quadrants (40m radius), and Ulugh Beg's Zīj-i Sulṭānī (1437 CE).",
                    "#10B981"
            ),
            new ScientificAllusionAndInstantiation(
                    2,
                    "SCI-2-OPTICS-LIGHT-PHYSICS",
                    "2. Optics, Light Physics & Photogrammetry: Self-Luminous vs. Reflected Light (Ḍiyā' vs. Nūr), Refraction & The Camera Obscura",
                    "Qur'an 10:5 ('It is He who made the sun a shining radiance [Ḍiyā'] and the moon a reflected light [Nūr], and determined for it phases...'), Qur'an 71:16 ('And made the moon therein a light [Nūran] and made the sun a burning lamp [Sirājan]'), Qur'an 24:35 (Refraction and amplification of light inside a crystal-like glass lamp: 'Zujājah ka-annahā kawkabun durriyy'), & Qur'an 24:40 (Attenuation of light in the deep sea).",
                    "Across the entire Qur'an, the Sun is never called 'Nūr'—it is consistently designated 'Ḍiyā'' (intrinsic, heat-generating radiative glow) or 'Sirāj Wahhāj' (a blazing, combustion-like lamp, 78:13), whereas the Moon is designated 'Nūr' / 'Munīr' (cool, reflected illumination)—a distinction absent from earlier Near Eastern cosmologies that treated both as self-luminous lamps.",
                    "Directly catalyzed the golden age of Islamic Optics ('Ilm Al-Manāẓir): (1) In 984 CE in Baghdad, Ibn Sahl wrote Fī Al-Ālāt Al-Muḥriqah (On Burning Mirrors and Lenses), discovering the exact geometric ratio of refraction (what Europe discovered 637 years later as Snell's Law, 1621) to design hyperbolic plano-convex lenses free of spherical aberration; (2) In Cairo (c. 1011–1021 CE), Ibn Al-Haytham (Alhazen) authored the 7-volume Kitāb Al-Manāẓir: using dark-room pinhole experiments ('Al-Bayt Al-Muẓlim'—translated into Latin as 'Camera Obscura,' giving every modern camera its name!), he proved that light travels in straight lines in finite time from every point on an illuminated object into the eye's crystalline lens, founded physiological optics and visual psychology, and solved 'Alhazen's Problem' for spherical mirrors; (3) In 1309 CE, Kamāl al-Dīn al-Fārisī (Tanqīḥ Al-Manāẓir) used a water-filled glass sphere inside a camera obscura to prove that the primary rainbow is caused by one internal reflection and two refractions inside a raindrop.",
                    "Modern spectroscopy and astrophysics confirm that solar radiation ('Sirāj Wahhāj') is powered by thermonuclear fusion whereas lunar light ('Nūr') is reflected solar photons (albedo ~0.12), while fiber-optics, laser physics, and modern digital imaging rest directly on Ibn Sahl's refraction law and Ibn Al-Haytham's camera obscura geometry.",
                    "Ibn Sahl's Hyperbolic Lens Diagrams (984 CE), Ibn Al-Haytham's Camera Obscura (Al-Bayt Al-Muẓlim) & Kitāb Al-Manāẓir (1021 CE), and Al-Fārisī's Tanqīḥ Al-Manāẓir (1309 CE).",
                    "#D4AF37"
            ),
            new ScientificAllusionAndInstantiation(
                    3,
                    "SCI-3-EMBRYOLOGY-GENETICS",
                    "3. Embryology, Organogenesis & Reproductive Biology: Staged Development (Aṭwār), Nuṭfah Amshāj, 'Alaqah & Muḍghah",
                    "Qur'an 71:14 ('While He has created you in stages [Aṭwārā]'), Qur'an 76:2 ('Indeed, We created man from a mingled drop [Nuṭfah Amshāj]'), Qur'an 23:12–14 ('Then We placed him as a drop [Nuṭfah] in a firm lodging [Qarār Makīn]; then We made the drop into a clinging form ['Alaqah], then We made the 'Alaqah into a chewed-like lump [Muḍghah], then We made the Muḍghah into bones ['Iẓāman], and clothed the bones with flesh [Laḥman]...'), Qur'an 39:6 ('Within three darknesses [Ẓulumāt Thalāth]'), & Sahih Muslim 2643 / 2645 (When 42 nights have passed over the Nuṭfah, Allah sends an angel to shape it and create its hearing, sight, skin, flesh, and bones).",
                    "Every Arabic term in Qur'an 23:12–14 and 76:2 carries a precise morphological meaning: (1) 'Nuṭfah Amshāj' means a tiny drop composed of mingled fluids (uniting male and female gametes/chromosomes); (2) 'Qarār Makīn' means a deeply protected muscular anchorage (the uterus); (3) ''Alaqah' carries three simultaneous Arabic meanings—something that clings/implants, a leech-like organism drawing nourishment from host blood, and a microscopic blood-clot; and (4) 'Muḍghah' means a tiny substance bearing teeth-like indentations.",
                    "For over a millennium, Aristotle had taught that the male semen alone provides the 'form' of the embryo while the female menstrual blood is merely passive matter, and early European preformationists (17th–18th c.) believed a miniature fully-formed human ('homunculus') sat inside the sperm or egg. Guided by Qur'an 76:2 ('Nuṭfah Amshāj'), Qur'an 23:12–14, and Prophetic hadiths on male and female fluid contributions, Ibn Sīnā (Al-Qānūn), Ibn Al-Quff (1233–1286 CE, author of Kitāb Al-'Umdah and comprehensive embryological stages), and Ibn Al-Nafīs rejected Aristotelian one-seed dogma and established staged epigenetic embryogenesis.",
                    "With the 20th-century invention of electron microscopy and ultrasound, human embryology verified the exact sequence: (1) Zygote formation from mingled male and female gametes (Nuṭfah Amshāj); (2) Blastocyst implantation clinging into the uterine endometrium and feeding on maternal blood pools while resembling a leech at Days 15–21 ('Alaqah); (3) Somite formation along the neural tube at Days 24–28 creating bead-like indentations resembling teeth-marks on chewed gum (Muḍghah); (4) Cartilaginous/osseous skeleton differentiation ('Iẓām) followed by myoblast muscle wrapping (Laḥm) during Week 6–7 (precisely around the 42nd day of Sahih Muslim 2645!); and (5) Development within the 'three darknesses' (abdominal wall, uterine wall, and amnio-chorionic membrane, Qur'an 39:6).",
                    "Ibn Al-Quff's Kitāb Al-'Umdah fī Ṣinā'at Al-Jirāḥah, Ibn Al-Nafīs's Kitāb Khalq Al-Insān, and Mansūr ibn Ilyās's Tashrīḥ-i Badan-i Insān (1396 CE illustrated anatomical atlas showing gravid uterus and circulatory/nervous systems).",
                    "#38BDF8"
            ),
            new ScientificAllusionAndInstantiation(
                    4,
                    "SCI-4-MEDICINE-CIRCULATION-EPIDEMIOLOGY",
                    "4. Clinical Medicine, Pulmonary Circulation, Surgery & Epidemiology: Every Disease Has a Cure & Epidemic Quarantine",
                    "Sahih al-Bukhari 5678 ('Allah has not sent down any disease except that He has also sent down its cure'), Sahih Muslim 2200 ('For every disease there is a medicine; when the medicine matches the disease, he recovers by the permission of Allah'), Sunan Abī Dāwūd 3855 ('O servants of Allah, seek medical treatment, and do not treat with what is unlawful'), Sahih al-Bukhari 5728 ('If you hear of a plague in a land, do not enter it; and if it breaks out in a land where you are, do not flee from it'), & Qur'an 16:68–69 (Antimicrobial and wound-healing properties of honey).",
                    "Whereas many ancient cultures viewed illness as a demonic curse or divine punishment that made medical research impious, the Prophet's declaration in Sahih al-Bukhari 5678 and Muslim 2200 functioned as an explicit scientific mandate: because Allah created a specific cure for every disease in nature ('known to those who know it, and unknown to those who are ignorant of it,' Musnad Aḥmad 3578), medical research, pharmacology, and hygiene are religious duties!",
                    "This prophetic mandate produced the greatest medical revolution of the pre-modern world: (1) Al-Rāzī (Rhazes, 865–925 CE) founded pediatrics, neuroanatomy, and clinical differential diagnosis (Smallpox vs. Measles), hung fresh meat around Baghdad to select the most hygienic site for its central hospital, and conducted the world's first controlled clinical trial; (2) Al-Zahrāwī (Abulcasis, 936–1013 CE) in Córdoba wrote the 30-volume Kitāb Al-Taṣrīf, inventing over 200 surgical instruments (forceps, tonsil guillotines, cataract needles, bone saws) and discovering that internal sutures made from animal intestines (catgut) naturally dissolve inside the human body; (3) Ibn Sīnā (Avicenna, 980–1037 CE) codified the 7 Rules of Clinical Drug Testing in Book II of Al-Qānūn; (4) In 1242 CE in Damascus/Cairo, Ibn Al-Nafīs (Sharḥ Tashrīḥ Al-Qānūn) refuted Galen's 1,000-year-old theory of invisible pores in the heart's septum and discovered both the Pulmonary Circulation of the Blood and coronary capillary blood supply; and (5) In 1348 CE in Granada, Lisān al-Dīn Ibn Al-Khaṭīb proved empirically that plague spreads via physical contagion on garments, vessels, and contact.",
                    "Modern medicine operates on the exact pillars instantiated in the Islamic Bīmāristāns: departmentalized teaching hospitals with separate wards for fever/infectious disease, surgery, ophthalmology, and mental health; licensing exams (Ibn Abī Uṣaybi'ah records Caliph Al-Muqtadir's 931 CE mandatory medical licensing exam for 860 Baghdad physicians); clinical trials; quarantine epidemiology; and cardiopulmonary physiology.",
                    "Al-Zahrāwī's Illustrated Surgical Instrument Codex (1000 CE), Ibn Al-Nafīs's Autograph Manuscript of Sharḥ Tashrīḥ Al-Qānūn (1242 CE), Al-Rāzī's Kitāb Al-Ḥāwī (23 volumes), and the Waqf Charters of the Nūrī (Damascus 1154) and Manṣūrī (Cairo 1284) Bīmāristāns.",
                    "#A855F7"
            ),
            new ScientificAllusionAndInstantiation(
                    5,
                    "SCI-5-HYDROLOGY-OCEANOGRAPHY-GEOLOGY",
                    "5. Hydrology, Oceanography & Earth Sciences: The Hydrological Cycle, Halocline Barzakh, Internal Waves & Mountain Roots (Awtād)",
                    "Qur'an 23:18 ('And We sent down water from the sky in measured amount and settled it in the earth...'), Qur'an 39:21 ('Allah sends down rain from the sky and makes it flow as springs [Yanābī'] in the earth'), Qur'an 25:53 & 55:19–20 ('He released the two seas, meeting side by side; between them is a barrier [Barzakh] they do not transgress'), Qur'an 24:40 ('Or like darknesses in a deep sea [Baḥrin Lujjiyy] covered by waves, above which are waves, above which are clouds...'), & Qur'an 78:6–7 ('Have We not made the earth a resting expanse, and the mountains as pegs [Awtādā]?').",
                    "Note three remarkable physical descriptions: (1) In antiquity and Europe until Bernard Palissy and Pierre Perrault (1674 CE), philosophers followed Aristotle and Seneca in believing that rainfall was insufficient to feed rivers and that underground caverns sucked up seawater and distilled it inside mountains. Qur'an 23:18 and 39:21 explicitly state that groundwater aquifers and springs originate directly from infiltrated rainwater; (2) Qur'an 25:53 and 55:19–20 describe a physical partition (Barzakh) maintaining distinct salinity and density properties where two seas or estuaries meet; (3) Qur'an 24:40 distinguishes deep internal ocean waves ('waves above which are surface waves') in the aphotic abyssal zone; and (4) Qur'an 78:7 compares mountains to tent-pegs (Awtād), whose main mass is driven deep underground to stabilize the tent.",
                    "Guided by these verses: (1) In 1017 CE, the mathematician and engineer Abū Bakr Al-Karajī wrote Inbāṭ Al-Miyāh Al-Khafiyyah (The Extraction of Hidden Waters), giving the first rigorous scientific exposition of the hydrological cycle, aquifer recharge from rain and snowmelt, soil permeability, and surveying instruments for Qanāt engineering; (2) Al-Bīrūnī (973–1048 CE) explained artesian wells by hydrostatic pressure, calculated the Earth's radius and circumference (to within 1% of modern satellite values) using a mountain peak at Nandana and trigonometric dip angles, and deduced from marine shells in rock strata that the Indo-Gangetic plain was once a prehistoric sea; and (3) Ibn Sīnā in Kitāb Ash-Shifā' (c. 1027 CE) formulated the laws of stratigraphy, superposition of sedimentary layers, and mountain formation via crustal uplift and water erosion.",
                    "Modern earth and ocean sciences have verified: (1) The pycnocline/halocline boundary (Barzakh, e.g., at Bab el-Mandeb and the Strait of Gibraltar, where Mediterranean and Atlantic waters maintain distinct temperature, salinity, and density profiles across a mixing front); (2) Internal gravity waves (discovered in the 20th century oscillating along subsurface density interfaces beneath surface waves in the deep aphotic ocean below 200m, Qur'an 24:40); and (3) Geophysical Isostasy (Airy 1855 / modern seismic tomography), proving that mountains possess deep crustal 'roots' extending 30–70 km down into the mantle like pegs (Awtād, Qur'an 78:7).",
                    "Al-Karajī's Hydrogeological Levelling Instruments (1017 CE), Al-Bīrūnī's Nandana Geodetic Astrolabe Method, and Ibn Sīnā's Mineralogical & Geological Treatise (De Congelatione).",
                    "#F43F5E"
            ),
            new ScientificAllusionAndInstantiation(
                    6,
                    "SCI-6-MATHEMATICS-ALGORITHMS-CYBERNETICS",
                    "6. Mathematics, Algorithms, Cryptography & Cybernetics: Exact Cosmic Measure (bi-Qadar), Al-Jabr, Frequency Analysis & Automata",
                    "Qur'an 54:49 ('Indeed, We created all things according to precise measure [bi-Qadar]'), Qur'an 72:28 ('And He has enumerated all things in number'), Qur'an 10:5 ('That you may know the number of years and the reckoning [Al-Ḥisāb]'), Qur'an 4:7–12 (Algebraic inheritance fractions), & Qur'an 2:144 ('Turn your face toward Al-Masjid Al-Ḥarām' — requiring exact spherical trigonometry from any coordinate on Earth).",
                    "In Islam, mathematics was never an abstract game; it was required directly by canonical worship and law: calculating inheritance shares ('Ilm Al-Farā'iḍ, Qur'an 4:7–12), determining the exact Qiblah azimuth on a curved globe (Qur'an 2:144), and computing twilight angles and lunar visibility for the five daily prayers and Ramadan (Qur'an 10:5).",
                    "This religious necessity generated four foundational disciplines of the modern digital and industrial world: (1) Algebra & Algorithms: In ~820 CE in Baghdad, Muḥammad ibn Mūsā Al-Khwārizmī wrote Al-Kitāb Al-Mukhtaṣar fī Ḥisāb Al-Jabr wa Al-Muqābalah, explicitly stating in his preface that Caliph Al-Ma'mūn asked him to compose a treatise to help people solve 'cases of inheritance, legacies, partition, lawsuits, trade, and surveying.' He systematically reduced linear and quadratic equations to 6 canonical forms—inventing Algebra—while his treatise on Indian numerals gave the world the word 'Algorithm'; (2) Cryptography & Statistics: In ~850 CE, Al-Kindī wrote Risālah fī Istikhrāj Al-Mu'ammā, inventing Frequency Analysis (the foundation of cryptanalysis and information theory) by statistically analyzing the letter frequencies of the Arabic Qur'an; (3) Polynomials, Binomials & Calculus Precursors: Al-Karajī and As-Samaw'al developed polynomial algebra and mathematical induction; Omar Khayyam (1070 CE) solved cubic equations via conic sections; Ibn Al-Haytham summed fourth powers ($\\sum k^4$) to find the volume of a paraboloid (integral calculus precursor); and Jamshīd Al-Kāshī (d. 1429) invented decimal fractions and computed $2\\pi$ to 16 decimal places; (4) Cybernetics & Robotics: The Banū Mūsā brothers (850 CE, Kitāb Al-Ḥiyal) and Badī' al-Zamān Al-Jazarī (1206 CE in Diyarbakır) engineered feedback float-valves, crankshafts, camshafts, and programmable musical/timekeeping automata.",
                    "Every smartphone, computer algorithm, RSA/cryptographic protocol, spherical GPS navigation routine, and internal-combustion crankshaft today operates on the direct mathematical and mechanical lineage of Al-Khwārizmī, Al-Kindī, Al-Bīrūnī, and Al-Jazarī.",
                    "Al-Khwārizmī's Kitāb Al-Jabr (c. 820 CE, Oxford Bodleian MS Hunt 214), Al-Kindī's Cryptanalysis Frequency Table, Al-Kāshī's Miftāḥ Al-Ḥisāb (1427 CE), and Al-Jazarī's Elephant Water Clock & Programmable Castle Automaton (1206 CE).",
                    "#F59E0B"
            ),
            new ScientificAllusionAndInstantiation(
                    7,
                    "SCI-7-CHEMISTRY-METALLURGY-PHYSICS",
                    "7. Chemistry, Extraterrestrial Iron Metallurgy & Precision Physics: Surah Al-Ḥadīd (57:25), Distillation & Mīzān Al-Ḥikmah",
                    "Qur'an 57:25 ('And We sent down iron [Wa anzalnā al-ḥadīd], wherein is mighty strength and benefits for mankind'), Qur'an 34:10–11 (Softening iron and craftinglinked chainmail in exact measure), Qur'an 18:96 ('Bring me blocks of iron... until when he had made it fire, he said: Bring me molten copper [Qiṭran] to pour over it' — bimetal composite metallurgy), & Qur'an 55:7–9 ('And the heaven He raised and set up the Balance [Al-Mīzān]...').",
                    "Look closely at the verb in Surah Al-Ḥadīd (Chapter 57 — the exact numerical middle of the 114 Surahs of the Qur'an), verse 25: 'Wa anzalnā al-ḥadīd' ('And We sent down iron'). Unlike verbs used for plants or minerals extracted from the earth ('akhrajnā'), 'anzalnā' literally means 'sent down from the sky/heavens.' Moreover, the Abjad numerical value of 'Al-Ḥadīd' (ا=1 + ل=30 + ح=8 + د=4 + ي=10 + د=4) is 57 (matching Surah 57!), and the Abjad value of 'Ḥadīd' (ح=8 + د=4 + ي=10 + د=4) is 26—which is the exact atomic number of Iron ($Z = 26$, $^{56}\\text{Fe}$)!",
                    "Historically, these verses inspired Muslim chemists and metallurgists to master experimental materials science: (1) Jābir ibn Ḥayyān (c. 721–815 CE) and Abū Bakr Al-Rāzī (Kitāb Al-Asrār) transformed alchemy into quantitative laboratory Chemistry, classifying substances into mineral, vegetable, and animal, inventing the alembic still (Al-Anbīq), retort, water-bath, and synthesizing mineral acids (sulfuric, nitric, hydrochloric, and aqua regia) and alkalis; (2) Al-Kindī and Al-Bīrūnī wrote detailed treatises on crucible Damascus steel (Fūlādh), describing how Indian wootz ingots were forged at controlled temperatures to produce blades of unmatched strength and wavy 'watered' patterns (Firind); (3) In 1121 CE in Merv, 'Abd ar-Raḥmān Al-Khāzinī authored Kitāb Mīzān Al-Ḥikmah, constructing a hydrostatic balance accurate to 1 part in 60,000, tabulating the exact specific gravities of 50 metals, alloys, gems, and liquids (matching modern laboratory values to within 1%), and demonstrating that gravitational weight varies with distance from the center of the Earth and atmospheric buoyancy.",
                    "In the 20th and 21st centuries, modern astrophysics and nanotechnology unveiled two stunning confirmations: (1) Nuclear astrophysicists (Burbidge, Burbidge, Fowler & Hoyle, 1957) proved that our Sun's core temperature (~15 million K) can never fuse Iron ($Z=26$), which has the highest nuclear binding energy per nucleon; every atom of iron on Earth was literally forged in colossal stars (>8 solar masses) at billions of degrees and 'sent down' (Anzalnā, Qur'an 57:25) via supernova explosions and meteoritic accretion! (2) In 2006, Peter Paufler and Marianne Reibold (Nature, Vol. 444, p. 286) examined a 17th-century Damascus steel blade by high-resolution transmission electron microscopy and discovered carbon nanotubes encapsulating cementite nanowires formed by the exact thermomechanical forging process perfected by classical Muslim metallurgists.",
                    "Jābir's Alembic Still (Al-Anbīq), Al-Rāzī's Laboratory Apparatus Inventory in Kitāb Al-Asrār, Al-Khāzinī's 5-Pan Hydrostatic Mīzān Al-Ḥikmah (1121 CE), and Carbon-Nanotube Damascus Crucible Steel.",
                    "#22D3EE"
            )
    );

    public static List<HistoricalReceptionAge> allSevenHistoricalReceptionAges() {
        return SEVEN_HISTORICAL_RECEPTION_AGES;
    }

    public static List<PhilosophicalConnotationParadigm> allSevenPhilosophicalConnotationParadigms() {
        return SEVEN_PHILOSOPHICAL_CONNOTATION_PARADIGMS;
    }

    public static List<ScientificAllusionAndInstantiation> allSevenScientificAllusionsAndInstantiations() {
        return SEVEN_SCIENTIFIC_ALLUSIONS_AND_INSTANTIATIONS;
    }
}
