package com.sovereign.warlock.domain;

import java.util.List;

/**
 * The Warlock Apocrypha (Al-Asfar Al-Mardudah li-Sahir Al-Hadathah) & The Islamic Theological
 * Philosophy Theorems (Al-Barahin Al-Kalamiyyah wa Al-Falsafiyyah):
 *
 * Models how the 7 Pre-Prophetic Warlock Orders and 7 Wrongdoer (Az-Zalimun) Archetypes,
 * once expelled from the Foundation of Islam and sealed inside the Qumqum Lamps,
 * re-manifested in the epistemological and moral struggles of Western Modernity —
 * and how classical and contemporary Islamic theological philosophy (Al-Ghazali, Ibn Khaldun,
 * Ibn Taymiyyah, Shah Wali Allah, Muhammad Iqbal, Rene Guenon / 'Abd al-Wahid Yahya,
 * Seyyed Hossein Nasr, Syed Muhammad Naquib al-Attas, Wael Hallaq, and Taha Abdurrahman)
 * formulated rigorous theorems to diagnose, refute, and re-bind each Apocryphal Scroll.
 */
public final class WarlockApocryphaAndIslamicTheorems {

    private WarlockApocryphaAndIslamicTheorems() {
    }

    public record FormalIslamicTheorem(
            String theoremSymbol,
            String arabicTheoremName,
            String englishTheoremTitle,
            String modernityParadoxDiagnosed,
            String formalSymbolicStatement,
            String philosophicalProofSummary,
            String primaryIslamicThinkers,
            String quranicAxiomAnchor
    ) {
    }

    public record ApocryphalBookAndTheorem(
            int bookIndex,
            String romanNumeral,
            String apocryphaCode,
            String arabicApocryphaTitle,
            String englishApocryphaTitle,
            String sourceWarlockAndZalimPair,
            String westernModernityMoralStruggle,
            String westernPhilosophersAndCrisis,
            String apocryphalWarlockConfession,
            String islamicTheoremTitle,
            String islamicTheologiansAndPhilosophers,
            String formalIslamicTheoremProof,
            String quranicCriterionSeal,
            double modernityEntropySpikeBits,
            double theoremResolvedCp,
            double resolvedEntropyBits
    ) {
        public ApocryphalBookAndTheorem {
            if (bookIndex < 1 || bookIndex > 7) {
                throw new IllegalArgumentException("bookIndex must be in [1..7]");
            }
            if (theoremResolvedCp < 1.33) {
                throw new IllegalArgumentException("theoremResolvedCp must be in State S0 (>= 1.33)");
            }
        }
    }

    private static final List<FormalIslamicTheorem> FIVE_FORMAL_ISLAMIC_THEOREMS = List.of(
            new FormalIslamicTheorem(
                    "THEOREM_THETA_1",
                    "Burhan Wahdat Al-Ayah wa Al-Qimah (برهان وحدة الآية والقيمة)",
                    "Theorem Theta-1: The Ontological Unity of 'Is' (Al-Wujud) and 'Ought' (Al-Mizan)",
                    "Refutes David Hume's Is-Ought Guillotine & Max Weber's Disenchantment of Nature (which claim that cosmos/facts are morally neutral matter and therefore open to unlimited extractive domination).",
                    "For all x in Cosmos: Existent(x) <=> Ayah(x) => HasRightInMizan(x). Therefore: Taskhir(x) without Amanah(x) => Fasad(x) [State S2/S3].",
                    "In Islamic ontology, phenomena in nature and scripture share the exact same name: Ayat (Sacred Signs, Qur'an 41:53). Because every created thing is embedded by Divine Wisdom in Al-Mizan (Qur'an 55:7-9), moral value is intrinsic to reality itself. Severing scientific/technical fact from moral stewardship is not 'objectivity' — it is the Warlock's cognitive mutilation of the cosmos.",
                    "Wael Hallaq (Restating Orientalism), Seyyed Hossein Nasr (Man and Nature), Al-Raghib Al-Isfahani (Al-Dhari'ah ila Makarim Al-Shari'ah)",
                    "Qur'an 55:7-9 ('And the heaven He raised and imposed the Balance [Al-Mizan], that you not transgress within the Balance') & Qur'an 30:41."
            ),
            new FormalIslamicTheorem(
                    "THEOREM_THETA_2",
                    "Burhan Fiqh Al-I'timan didd Al-Tamalluk (برهان فقه الائتمان ضد التملك المطلق)",
                    "Theorem Theta-2: The Trusteeship (Amanah) vs. Absolute Proprietorship Theorem",
                    "Refutes John Locke's Self-Ownership Commodification, Cartesian Mind-Body Dualism, and Zygmunt Bauman's Liquid Consumer Hedonism (which reduce the human body and desire to marketable commodities).",
                    "HumanPerson(P) != Commodity(P). Ownership(Allah, P) & Trusteeship(P, Body & Ruh) => Haya'(P) + Karamah(P) == Inviolable.",
                    "Taha Abdurrahman demonstrates that Western modernity rests on 'The Spirit of Possession' (Ruh Al-Tamalluk), treating the body and earth as private property to be exploited or displayed. Islam rests on 'The Spirit of Trusteeship' (Ruh Al-I'timan, Qur'an 33:72), where the body is an inviolable trust honored by Allah (Qur'an 17:70) and protected by Libas At-Taqwa (Qur'an 7:26).",
                    "Taha Abdurrahman (Ruh Al-Hadathah / The Spirit of Modernity; Su'al Al-Akhlaq), Al-Ghazali (Ihya' 'Ulum Ad-Din)",
                    "Qur'an 33:72 ('Indeed, We offered the Trust [Al-Amanah] to the heavens and the earth...') & Qur'an 17:70 ('And We have certainly honored the children of Adam')."
            ),
            new FormalIslamicTheorem(
                    "THEOREM_THETA_3",
                    "Burhan Istihalat Al-Luyathan Al-Siyasi (برهان استحالة اللوياثان السياسي)",
                    "Theorem Theta-3: The Impossibility of the Absolute Moral-Sovereign Leviathan",
                    "Refutes Thomas Hobbes's Leviathan and Carl Schmitt's Political Theology ('Sovereign is he who decides on the exception', elevating the modern nation-state into a mortal god above moral law).",
                    "Sovereignty(Al-Mulk) belongs solely to Al-Muhaymin. Therefore: StatePower(Sultan) subset_of MoralLaw(Shari'ah/Mizan); Sultan != Lawgiver.",
                    "Wael Hallaq proves in 'The Impossible State' that for twelve centuries Islamic governance operated through a constitutional separation of powers: the political executive (Sultan) wielded force, but moral-legal sovereignty belonged to the transcendent Shari'ah interpreted by socially embedded jurists. When modernity fused lawmaking and coercion into the Leviathan state, it resurrected Nimrod's claim ('Ana uhyi wa umit', Qur'an 2:258).",
                    "Wael Hallaq (The Impossible State), Ibn Khaldun (Al-Muqaddimah), Ibn Taymiyyah (Al-Siyasah Al-Shar'iyyah)",
                    "Qur'an 2:258 (Abraham vs. Nimrod), Qur'an 5:48 (Al-Muhaymin), & Qur'an 67:1 ('Blessed is He in whose hand is Dominion [Al-Mulk]')."
            ),
            new FormalIslamicTheorem(
                    "THEOREM_THETA_4",
                    "Burhan Al-Adab wa Ta'sis Al-'Aql 'ala Al-Furqan (برهان الأدب وتأسيس العقل على الفرقان)",
                    "Theorem Theta-4: The Invariant Criterion (Al-Furqan) vs. Emotivist Moral Relativism",
                    "Refutes Post-Enlightenment Moral Relativism, Alasdair MacIntyre's diagnosed 'Emotivism' (After Virtue), and Friedrich Nietzsche's Will to Power (where moral values collapse into subjective Hawa).",
                    "AutonomousCaprice(Hawa) => NonStationary(Morality) => Lim_{t->inf} P_baseline = S3 (Nihilism). Calibration('Aql, Furqan) => Adab => State S0.",
                    "As Al-Ghazali and Syed Muhammad Naquib al-Attas prove, unaided instrumental reason can calculate means, but cannot generate binding moral ends without degenerating into subjective appetite (Ittiba' Al-Hawa, Qur'an 45:23). Only when 'Aql is anchored in the transcendent Criterion (Al-Furqan) does Adab arise — placing every reality in its rightful ontological rank.",
                    "Syed Muhammad Naquib al-Attas (Islam and Secularism; Prolegomena to the Metaphysics of Islam), Al-Ghazali (Al-Mustasfa), Muhammad Iqbal",
                    "Qur'an 45:23 ('Have you seen he who has taken as his god his own desire [Hawa]?') & Qur'an 25:1 ('Blessed is He who sent down the Criterion [Al-Furqan]')."
            ),
            new FormalIslamicTheorem(
                    "THEOREM_THETA_5",
                    "Burhan Bunyan At-Taqwa didd Dialektik Al-Inhiyar (برهان بنيان التقوى ضد ديالكتيك الانهيار)",
                    "Theorem Theta-5: The Civilizational Stability Theorem of Taqwa vs. The Crumbling Cliff",
                    "Refutes the Secular Progress Myth and diagnoses Horkheimer & Adorno's 'Dialectic of Enlightenment' (why a civilization built on pure technical mastery without reverence inevitably implodes into alienation and barbarism).",
                    "Foundation(Civilization) == Hawa + Istikbar => JurufHarin (Undercut Cliff, C_p < 0.67). Foundation(Civilization) == Taqwa + Mizan => BunyanMarsus (C_p >= 1.33, H = 0.000).",
                    "Qur'an 9:108-109 formulates a mathematical law of civilizational durability: an edifice erected on power, spectacle, and division (Masjid Ad-Dirar) is structurally built on an undercut bank (Shafa Jurufin Harin) that shears into the abyss under its own weight, whereas an edifice founded on Taqwa from Day One endures in State S0.",
                    "Shah Wali Allah Al-Dihlawi (Hujjat Allah Al-Balighah), Rene Guenon / 'Abd al-Wahid Yahya (The Crisis of the Modern World; The Reign of Quantity), Malik Bennabi",
                    "Qur'an 9:108-109 ('Then is one who laid his foundation on Taqwa from Allah and His pleasure better — or one who laid his foundation on the edge of a crumbling cliff [shafa jurufin harin]?')."
            )
    );

    private static final List<ApocryphalBookAndTheorem> SEVEN_APOCRYPHAL_BOOKS = List.of(
            new ApocryphalBookAndTheorem(
                    1, "I", "APOCRYPHA_BOOK_I_IS_OUGHT",
                    "Sifr Al-Fakak bayna Al-Wujud wa Al-Qimah (سفر الفكاك بين الوجود والقيمة)",
                    "Apocrypha Book I: The Scroll of the Disenchanted Void & The Is-Ought Guillotine",
                    "Order #1 (`Malakh-Azal` / White) + Zalim #1 (`Mufsid Al-Ard` / `zalim-1-fasad`)",
                    "THE MODERNITY MORAL STRUGGLE: The Cartesian-Humean severance of 'Fact' (Is) from 'Moral Value' (Ought) and Max Weber's 'Disenchantment of the World' (Entzauberung). By declaring the physical universe to be dead, value-free matter, Western modernity licensed boundless ecological extraction and industrial devastation while leaving moral philosophy unable to deduce a single binding 'ought' from 'is'.",
                    "Francis Bacon (Novum Organum — 'Torturing nature for her secrets'), Rene Descartes (Res Extensa), David Hume (Is-Ought Dichotomy), Max Weber (Instrumental Rationality).",
                    "APOCRYPHAL WARLOCK CONFESSION: 'When Islam banished our Throne-Theurgy and dammed our Fasad behind Dhu Al-Qarnayn's iron-and-brass wall, we whispered a new spell into the ear of Modernity: Call the cosmos a soulless machine! Strip every mountain, river, and creature of its status as an Ayah (Sacred Sign) of Allah! Once fact is severed from value, man becomes a Promethean Warlock who extracts without Amanah!'",
                    "Islamic Theorem I: Ontological Moral Realism — The Cosmos as Living Ayat & Mizan (Burhan Al-Ayat wa Al-Mizan)",
                    "Seyyed Hossein Nasr (Man and Nature: The Spiritual Crisis of Modern Man), Wael Hallaq (Restating Orientalism), Al-Raghib Al-Isfahani",
                    "PROOF: In Islamic philosophy, the word for a verse of moral revelation (Ayah) and the word for a phenomenon of nature (Ayah) are identical. Nature is never 'value-free dead matter'; every atom glorifies Allah (Qur'an 17:44) and stands within a cosmic Balance (Al-Mizan, Qur'an 55:7-9). Therefore, moral obligation ('Ought') is ontologically built into the structure of existence ('Is'). Any science that treats creation as desacralized plunder violates Al-Amanah (Qur'an 33:72) and mathematically triggers ecological Fasad (Qur'an 30:41).",
                    "Qur'an 55:7-9 ('And the heaven He raised and imposed the Balance, that you not transgress within the Balance'), Qur'an 17:44, & Qur'an 30:41.",
                    0.890, 1.53, 0.000
            ),
            new ApocryphalBookAndTheorem(
                    2, "II", "APOCRYPHA_BOOK_II_LIQUID_BODY",
                    "Sifr Al-Jasad Al-Mufragh wa Suq Al-Raghbah (سفر الجسد المفرغ وسوق الرغبة)",
                    "Apocrypha Book II: The Scroll of Liquid Desire & The Commodification of the Body",
                    "Order #2 (`Katib Al-Qalam` / Black) + Zalim #2 (`Da'i Al-Fahishah` / `zalim-2-fahishah`)",
                    "THE MODERNITY MORAL STRUGGLE: Hyper-Individualistic Hedonism, the Sexual Revolution's commodification of intimacy, and Zygmunt Bauman's 'Liquid Modernity'. Having defined liberty as the removal of all moral boundaries, modern consumer culture turned the human body into a spectacle of display (Tabarruj) and transaction, breeding deep loneliness, family dissolution, and the erosion of human dignity.",
                    "Marquis de Sade, Wilhelm Reich, Zygmunt Bauman (Liquid Love / Liquid Modernity), Guy Debord (The Society of the Spectacle).",
                    "APOCRYPHAL WARLOCK CONFESSION: 'At the pre-Islamic Ka'bah, the Hums oligarchs forced pilgrims to strip off their garments and circumambulate naked unless they rented clothes from Quraysh. In Modernity, we globalized that exact market: we told humanity that Haya' (modesty) is a prison, stripped them of Libas At-Taqwa, and monetized their exposed desires on glowing screens!'",
                    "Islamic Theorem II: The Ethics of Trusteeship & Bodily Inviolability (Burhan Al-I'timan wa Libas At-Taqwa)",
                    "Taha Abdurrahman (Ruh Al-Hadathah / The Spirit of Modernity; Din Al-Haya'), Al-Ghazali (Kitab Kasr Al-Shahwatayn in Ihya')",
                    "PROOF: Taha Abdurrahman proves that modernity's moral crisis stems from replacing Trusteeship (Al-I'timan) with Absolute Self-Proprietorship (Al-Tamalluk), which paradoxically allows the market to buy and sell the self. In Islam, the human body and gaze are a Sacred Trust (Amanah) ennobled by Allah (Qur'an 17:70). Haya' (modesty) and Libas At-Taqwa (Qur'an 7:26) are not 'repression', but the ontological armor that protects the human person from being reduced to a consumer commodity.",
                    "Qur'an 7:26-28 ('O children of Adam, We have bestowed upon you clothing to conceal your shame and as adornment; and the garment of Taqwa — that is best'), Qur'an 17:70, & Qur'an 24:19.",
                    0.910, 1.48, 0.000
            ),
            new ApocryphalBookAndTheorem(
                    3, "III", "APOCRYPHA_BOOK_III_LEVIATHAN",
                    "Sifr Al-Luyathan wa Al-Siyadah Al-Mutlaqah (سفر اللوياثان والسيادة المطلقة)",
                    "Apocrypha Book III: The Scroll of the Mortal God Leviathan & Biopolitical Sovereignty",
                    "Order #3 (`Yored Ha-Merkabah` / Sapphire) + Zalim #3 (`Jabbar Al-Namrud` / `zalim-3-baghy`)",
                    "THE MODERNITY MORAL STRUGGLE: The rise of the totalizing Modern Nation-State (Hobbes's 'Mortal God' Leviathan), Carl Schmitt's 'State of Exception' (where the sovereign stands above the law), and Michel Foucault / Giorgio Agamben's 'Biopolitics' — where the state claims absolute jurisdiction over bare human life, borders, and conscience.",
                    "Thomas Hobbes (Leviathan), Carl Schmitt (Political Theology), Michel Foucault (Biopolitics), Giorgio Agamben (Homo Sacer & State of Exception).",
                    "APOCRYPHAL WARLOCK CONFESSION: 'When Abraham silenced Nimrod's boast — Ana uhyi wa umit (I give life and cause death, Qur'an 2:258) — with the rising of the Sun, we waited millennia to resurrect Nimrod's throne as an impersonal bureaucracy: the Sovereign Leviathan State, which recognizes no Divine Law above its own Reason of State and declares states of exception at will!'",
                    "Islamic Theorem III: Constitutional Supremacy of Transcendent Law Over Executive Force (Burhan Al-Shari'ah Al-Muhayminah didd Al-Luyathan)",
                    "Wael Hallaq (The Impossible State: Islam, Politics, and Modernity's Moral Predicament), Ibn Khaldun (Al-Muqaddimah), Ibn Taymiyyah",
                    "PROOF: Wael Hallaq demonstrates why the modern Leviathan state is structurally incompatible with Islamic moral philosophy: in Islam, the executive ruler (Al-Sultan) never possessed legislative sovereignty. Moral and legal truth resided in the transcendent Shari'ah, expounded by jurists independent of state coercion and funded by civil Waqf endowments. Because Legislative Sovereignty belongs solely to Allah (Al-Muhaymin, Qur'an 5:48), no state or parliament can declare a moral 'State of Exception' above Divine Justice.",
                    "Qur'an 2:258 (Abraham's refutation of Nimrod), Qur'an 5:48 (Al-Muhaymin), & Qur'an 4:58-59 ('Indeed, Allah commands you to render trusts to whom they are due and when you judge between people to judge with justice').",
                    0.925, 1.46, 0.000
            ),
            new ApocryphalBookAndTheorem(
                    4, "IV", "APOCRYPHA_BOOK_IV_ANOMIE_TRIBE",
                    "Sifr Al-ughtirab Al-Fardi wa Al-'Asabiyyah Al-Qawmiyyah (سفر الاغتراب الفردي والعصبية القومية)",
                    "Apocrypha Book IV: The Scroll of Atomized Anomie & Idolatrous Ethno-Nationalism",
                    "Order #4 (`Shahid Al-Alast` / Gold) + Zalim #4 (`Nafikh Al-Fitnah` / `zalim-4-fitnah`)",
                    "THE MODERNITY MORAL STRUGGLE: The double movement of modern alienation: first, industrial modernity shatters extended kinship, neighborhood, and spiritual brotherhood into Emile Durkheim's 'Anomie' (the atomized, lonely individual); second, to fill that unbearable void, modernity herds isolated individuals into fierce ethno-nationalist, racial, or ideological tribes (Asabiyyah).",
                    "Emile Durkheim (Suicide & Anomie), Jean-Jacques Rousseau (General Will), Charles Maurras / Modern Ethno-Nationalism, Hannah Arendt (The Origins of Totalitarianism).",
                    "APOCRYPHAL WARLOCK CONFESSION: 'To make humanity forget their pre-temporal oath on Yawm Al-Alast (Alastu bi-Rabbikum, Qur'an 7:172), we first dissolved every covenantal bond until each man stood alone in existential dread — and then we blew the horn of Nafikh Al-Fitnah, offering him the intoxicating idol of Blood, Race, Flag, and Faction (Kullu hizbin bima ladayhim farihun, Qur'an 30:32)!'",
                    "Islamic Theorem IV: Covenantal Universalism & The Transformation of 'Asabiyyah by Taqwa (Burhan Al-Ta'aruf wa Al-Ummah Al-Wahidah)",
                    "Ibn Khaldun (Al-Muqaddimah), Muhammad Iqbal (The Reconstruction of Religious Thought in Islam; Rumuz-i-Bekhudi), Malik Bennabi",
                    "PROOF: Ibn Khaldun proved sociologically that raw blood/nationalist solidarity ('Asabiyyah) without Prophetic Religion (Sibghat Allah) inevitably degenerates into predatory empire and internal collapse within four generations. Muhammad Iqbal showed that Western nationalism re-tribalized humanity into warring territorial idols, whereas Islam grounds human identity in the primordial Covenant of Alast (Qur'an 7:172) and the universal principle of Qur'an 49:13 — where nations exist for mutual knowledge (Li-ta'arafu) and rank is determined solely by Taqwa.",
                    "Qur'an 49:13 ('O mankind, indeed We have created you from male and female and made you peoples and tribes that you may know one another; indeed, the most noble of you in the sight of Allah is the most righteous of you [atqakum]') & Qur'an 7:172.",
                    0.940, 1.50, 0.000
            ),
            new ApocryphalBookAndTheorem(
                    5, "V", "APOCRYPHA_BOOK_V_EMOTIVISM_HAWA",
                    "Sifr Al-Nisbiyyah Al-Mutlaqah wa Iradat Al-Quwwah (سفر النسبية المطلقة وإرادة القوة)",
                    "Apocrypha Book V: The Scroll of Moral Emotivism, Relativism & The Will to Power",
                    "Order #5 (`Saraph Ha-Ritzpah` / Crimson) + Zalim #5 (`'Abid Al-Hawa` / `zalim-5-hawa`)",
                    "THE MODERNITY MORAL STRUGGLE: What Alasdair MacIntyre diagnosed in 'After Virtue': having rejected teleology and Divine Revelation, the Enlightenment Project attempted to ground morality in pure secular reason (Kantian deontology vs. Utilitarian calculus), failed to reach consensus, and collapsed into Nietzschean 'Will to Power' and Postmodern 'Emotivism' — where moral statements ('This is good/evil') mean nothing more than 'I prefer this' (Ittiba' Al-Hawa).",
                    "Friedrich Nietzsche (Beyond Good and Evil; The Will to Power), A.J. Ayer (Emotivism), Alasdair MacIntyre (After Virtue — diagnosing the catastrophe), Richard Rorty (Contingency, Irony, and Solidarity).",
                    "APOCRYPHAL WARLOCK CONFESSION: 'When the Criterion of Al-Furqan stripped away our forged taboos and calendar-tampering (An-Nasi', Qur'an 9:37), we returned disguised as Postmodern Critique: we whispered that Truth is a social construct, that Objective Good is an illusion, and that every moral law is merely a mask for Will to Power — enthroning 'Abid Al-Hawa (the Worshipper of Caprice, Qur'an 45:23) as sovereign!'",
                    "Islamic Theorem V: The Metaphysics of Adab & The Insufficiency of Uncalibrated Reason (Burhan Al-Adab wa Al-Furqan)",
                    "Syed Muhammad Naquib al-Attas (Islam and Secularism; Prolegomena to the Metaphysics of Islam), Al-Ghazali (Al-Munqidh min Ad-Dalal & Al-Mustasfa), Abu Ishaq Al-Shatibi (Al-Muwafaqat)",
                    "PROOF: Al-Ghazali and Al-Shatibi proved in Usul al-Fiqh that while the human intellect ('Aql) can recognize general utility, it is subject to perspectival bias and passion (Hawa) and therefore cannot autonomously legislate universal moral absolutes without Revelation (Al-Furqan). Syed Muhammad Naquib al-Attas formulates the theorem of Adab: secularization causes the 'Loss of Adab' (displacement of things from their true ontological rank), whereas Revelation calibrates 'Aql to preserve the five universal Maqasid (Faith, Life, Intellect, Lineage, and Property).",
                    "Qur'an 45:23 ('Have you seen he who has taken as his god his own desire [Hawa], and Allah has left him astray despite knowledge?') & Qur'an 5:48 ('So judge between them by what Allah has revealed and do not follow their inclinations [ahwa'ahum]').",
                    0.955, 1.45, 0.000
            ),
            new ApocryphalBookAndTheorem(
                    6, "VI", "APOCRYPHA_BOOK_VI_TECHNOCRATIC_JIBT",
                    "Sifr Al-Jibt Al-Tiqani wa 'Ubudiyyat Al-Alah (سفر الجبت التقني وعبودية الآلة)",
                    "Apocrypha Book VI: The Scroll of Technocratic Idolatry, Algorithmic Oracles & Usurious Fetters",
                    "Order #6 (`Ba'al Ha-Nechoshet` / Brass) + Ja'far & Zalim #6 (`Kahin Al-Jibt` / `zalim-6-jibt`)",
                    "THE MODERNITY MORAL STRUGGLE: Martin Heidegger's 'Gestell' (Technological Enframing), Jacques Ellul's 'Autonomous Technique', Usurious Financialization (Riba), and Algorithmic Determinism. Modern man fashions complex technical, financial, and artificial-oracle systems with his own hands, and then surrenders his moral agency to their predictive outputs — repeating Azar's idol-worship and Ja'far's Lamp-fetishism on a planetary scale.",
                    "Martin Heidegger (The Question Concerning Technology), Jacques Ellul (The Technological Society), Karl Polanyi (The Great Transformation), Byung-Chul Han (Psychopolitics).",
                    "APOCRYPHAL WARLOCK CONFESSION: 'You thought our Divination Arrows (Al-Azlam, Qur'an 5:90), Azar's carved idols (Qur'an 6:74), and Ja'far's Black-Brass Lamp were buried in antiquity! We recast them into algorithmic black boxes and compound-interest ledgers: today modern man consults stochastic oracles just as Quraysh consulted Hubal's arrows, bowing to what his own hands have coded!'",
                    "Islamic Theorem VI: Abraham's Iconoclastic Theorem Against Artifact-Deification (Burhan Al-Khalil: 'A-ta'buduna ma tanhitun?')",
                    "Rene Guenon / 'Abd al-Wahid Yahya (The Reign of Quantity and the Signs of the Times), Muhammad Iqbal (Javid Nama), Seyyed Hossein Nasr",
                    "PROOF: Prophet Abraham established the formal logical refutation of technocratic idolatry in Qur'an 37:95-96: 'Do you worship that which you yourselves carve/construct [ma tanhitun], while Allah created both you and what you make?' Any humanly constructed instrument — whether a bronze statue, a financial derivative, or a computational model — has lower ontological rank than the moral agent (Al-Khalifah) who built it. Elevating an artifact into an autonomous oracle is Al-Jibt wa At-Taghut (Qur'an 4:51), which Tawhid and the Solomonic Seal bind inside the Qumqum of strictly subordinate utility.",
                    "Qur'an 37:95-96 ('He said: Do you worship that which you yourselves carve, while Allah created you and that which you do?'), Qur'an 4:51 (Al-Jibt wa At-Taghut), & Qur'an 2:256 (Al-'Urwah Al-Wuthqa).",
                    0.975, 1.49, 0.000
            ),
            new ApocryphalBookAndTheorem(
                    7, "VII", "APOCRYPHA_BOOK_VII_DIALECTIC_CLIFF",
                    "Sifr Al-Tanwir Al-Muzawwar wa Juruf Al-Inhiyar (سفر التنوير المزور وجرف الانهيار)",
                    "Apocrypha Book VII: The Scroll of Counterfeit Enlightenment & The Crumbling Cliff of Nihilism",
                    "Order #7 (`Wali Al-Ghaib` / Emerald) + Zalim #7 (`Imam Az-Zalimin` / `zalim-7-zulm` — Masjid Ad-Dirar)",
                    "THE MODERNITY MORAL STRUGGLE: Max Horkheimer and Theodor Adorno's 'Dialectic of Enlightenment' and Late-Modern Existential Nihilism: why the secular Enlightenment project, which promised universal human emancipation through the expulsion of transcendent religion, dialectically inverted into total war, mechanized bureaucracy, ecological brinkmanship, and spiritual homelessness.",
                    "Max Horkheimer & Theodor Adorno (Dialectic of Enlightenment), Oswald Spengler (The Decline of the West), Charles Taylor (A Secular Age — 'The Malaise of Modernity').",
                    "APOCRYPHAL WARLOCK CONFESSION: 'When we built Masjid Ad-Dirar (Qur'an 9:107), we swore: In aradna illa al-husna (We intended nothing but good and progress!). Western Secular Modernity is our grandest Masjid Ad-Dirar — a gleaming counter-cathedral of self-deification erected on the edge of a crumbling cliff (Shafa Jurufin Harin, Qur'an 9:109) to rival the Foundation of Abraham!'",
                    "Islamic Theorem VII: The Law of Foundational Taqwa & Civilizational Renewal (Burhan Bunyan At-Taqwa wa Al-Tajdid Al-Ibrahimi)",
                    "Al-Ghazali (Ihya' 'Ulum Ad-Din), Shah Wali Allah Al-Dihlawi (Hujjat Allah Al-Balighah), Taha Abdurrahman, Syed Muhammad Naquib al-Attas",
                    "PROOF: Qur'an 9:108-109 proves that the trajectory of any civilization is determined by its foundational axiom: an edifice founded on self-sufficiency (Istighna', Qur'an 96:6-7) and opposition to Revelation is built on an undercut bank (Shafa Jurufin Harin) whose internal contradictions inevitably cause it to shear into the abyss. True human flourishing requires Bunyan At-Taqwa — re-grounding scientific reason, law, and ethics in reverent accountability to Al-Muhaymin under the Covenant of Abraham (Qur'an 2:124, Cp = 1.56, H_resolved = 0.000 bits).",
                    "Qur'an 9:108-109 ('A mosque founded on Taqwa from the first day is more worthy... Or one who laid his foundation on the edge of a crumbling cliff, so it collapsed with him into the Fire?'), Qur'an 96:6-7, & Qur'an 2:124.",
                    0.995, 1.56, 0.000
            )
    );

    public static List<FormalIslamicTheorem> allFiveFormalTheorems() {
        return FIVE_FORMAL_ISLAMIC_THEOREMS;
    }

    public static List<ApocryphalBookAndTheorem> allSevenApocryphalBooks() {
        return SEVEN_APOCRYPHAL_BOOKS;
    }

    public static ApocryphalBookAndTheorem bookForIndex(int bookIndex) {
        return SEVEN_APOCRYPHAL_BOOKS.stream()
                .filter(b -> b.bookIndex() == bookIndex)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown bookIndex: " + bookIndex));
    }
}
