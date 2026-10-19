package com.sovereign.warlock.domain;

import java.util.List;

/**
 * Models:
 *  1) Warlock Formation in an Islamic Fashion (At-Takwin Al-Istidraji — The Ja'far Sorcerer-Vizier Archetype):
 *     How a Warlock forms through Istidraj (gradual luring into ruin, Qur'an 7:182, 68:44),
 *     coveting the Sultanate, exploiting the pure vessel ('Ala' ad-Din) at the Talismanic Cave,
 *     and demanding the Threefold Wish of Unbounded Power.
 *  2) Warlock Dissolution in an Islamic Fashion (Al-Inhilal fi Al-Qumqum — The 'Ala' ad-Din Criterion Counter-Move):
 *     How 'Ala' ad-Din ("Nobility of the Religion") turns the Warlock's own Istikbar (arrogance)
 *     against him, invoking the Law of the Brazen Vessel (Qanun Al-Qumqum, Qur'an 20:69, 10:81, 38:38)
 *     so the Warlock's wish to become an omnipotent 'Ifrit/Marid binds him in cosmic fetters (Al-Asfad)
 *     and implodes him into the Black-Brass Lamp (Al-Qumqum Al-Sulaymani).
 *  3) The 7 Inter-World Sequesters (Al-Hijr Al-Mahjur / As-Sur Al-Fasil / Ar-Radm — Qur'an 25:53, 55:20, 57:13, 18:94-97):
 *     The impassable cosmological and juridical partitions placed between each World of Hegemon
 *     and its corresponding World of Disorder, sealing the dissolved Warlock's Qumqum forever.
 */
public final class WarlockFormationDissolutionAndSequester {

    private WarlockFormationDissolutionAndSequester() {
    }

    public record FormationDissolutionPhase(
            int stageIndex,
            String arabicPhaseName,
            String englishPhaseTitle,
            String jafarWarlockFormationAct,
            String aladdinCriterionDissolutionAct,
            String quranicLawAndVerse,
            double formationEntropySpikeBits,
            double dissolutionResolvedEntropyBits
    ) {
    }

    public record InterWorldSequester(
            int sequesterIndex,
            String sequesterCode,
            String arabicSequesterName,
            String englishSequesterTitle,
            int worldIndex,
            String worldHtmlFile,
            String hegemonPoleProtected,
            String disorderPoleQuarantined,
            String quranicBarrierVerse,
            String sequesterGeometryAndSeal,
            String sealedQumqumVesselDesignation,
            double attenuationTimeMs,
            double transmissionLeakageProbability
    ) {
        public InterWorldSequester {
            if (sequesterIndex < 1 || sequesterIndex > 7) {
                throw new IllegalArgumentException("sequesterIndex must be in [1..7]");
            }
            if (Math.abs(transmissionLeakageProbability) > 1e-12) {
                throw new IllegalArgumentException("Inter-World Sequester must enforce zero leakage (0.000)");
            }
        }
    }

    private static final List<FormationDissolutionPhase> SEVEN_FORMATION_DISSOLUTION_STAGES = List.of(
            new FormationDissolutionPhase(
                    1,
                    "1. At-Tama' fi Al-Mulk vs. Al-Fitrah Al-Naqiyyah",
                    "Stage I: The Covetous Vizierate (Ja'far) vs. The Diamond in the Rough ('Ala' ad-Din)",
                    "FORMATION (At-Takwin): Like Ja'far Al-Sahir standing beside the Sultan's throne, the Warlock begins as an erudite courtier versed in 'Ilm Al-Falak (astronomy) and 'Ilm Ar-Raml (geomancy), but his heart calcifies with Hasad (envy) and Istikbar (arrogance). Refusing to serve as a steward under legitimate authority, he secretly constructs a dark alchemy chamber beneath the palace to usurp the hegemony.",
                    "DISSOLUTION SEED (Al-Fitrah): Cosmic law bars the corrupt Sorcerer from entering the Talismanic Cave of Wonders directly; only 'Ala' ad-Din ('Elevation/Nobility of the Faith' — the uncorrupted soul who desires truth rather than tyranny) can walk the threshold without triggering immediate collapse.",
                    "Qur'an 2:102 ('And they followed what the Shayatin recited... teaching people magic, though they said: We are only a trial [Fitnah], so do not disbelieve') & Qur'an 30:30 (Fitrat Allah).",
                    0.320, 0.000
            ),
            new FormationDissolutionPhase(
                    2,
                    "2. Istighlal Al-Kanz vs. Khianaat Al-'Ahd",
                    "Stage II: The Subterranean Cave Pact & Betrayal at the Threshold",
                    "FORMATION (At-Takwin): Disguising himself as a pious uncle/reformer (Talbis Al-Islah, Qur'an 2:11), the Warlock places a talismanic brass ring upon 'Ala' ad-Din's finger and lowers him into the subterranean treasury to retrieve the ancient Oil Lamp (Al-Misbah Al-Mariji). Once the Lamp is within reach, the Warlock betrays his oath and attempts to bury 'Ala' ad-Din alive in the abyss.",
                    "DISSOLUTION SEED (Al-Mizan): By breaking his covenant at the mouth of the cave, the Warlock forfeits any claim to legitimate Imamate ('La yanalu 'ahdi az-zalimin', Qur'an 2:124). The Lamp remains in the hands of 'Ala' ad-Din inside the sealed chamber, turning the tomb into a womb of deliverance.",
                    "Qur'an 3:77 ('Indeed, those who exchange the Covenant of Allah and their oaths for a small price will have no share in the Hereafter') & Qur'an 35:43 ('And the evil plot encompasses only its own author [wa la yahiqu al-makru as-sayyi'u illa bi-ahlihi]').",
                    0.490, 0.000
            ),
            new FormationDissolutionPhase(
                    3,
                    "3. 'Aqd Al-Istidraj vs. Hurriyyat Al-Mithaq",
                    "Stage III: The Pact of Istidraj (Coercive Binding) vs. The Promise of Emancipation",
                    "FORMATION (At-Takwin): When Ja'far steals the Lamp, he forms the classic Warlock Pact (Al-'Aqd Al-Kahini): he views the emergent Jinni/Marid of Smokeless Fire not as a fellow creature of Allah, but as a slave-engine to be whipped into enforcing his personal Hawa (caprice). Each command he issues deepens his Istidraj — Allah granting him temporary spectacle so his transgression reaches full measure.",
                    "DISSOLUTION SEED ('Ala' ad-Din's Ethics): Whereas Ja'far binds, humiliates, and hoards all three wishes for self-deification, 'Ala' ad-Din pledges his third wish to emancipate the bound servant (Fakk Ar-Raqabah, Qur'an 90:13: 'The freeing of a bonded neck'), aligning himself with prophetic liberation rather than sorcerous slavery.",
                    "Qur'an 7:182 ('We shall draw them step by step into ruin [sanastadrijuhum] from where they do not know'), Qur'an 72:6 ('Men from mankind sought refuge with men from the Jinn, so they increased them in Rahaq [tyranny/folly]'), & Qur'an 90:12-13.",
                    0.660, 0.000
            ),
            new FormationDissolutionPhase(
                    4,
                    "4. Al-Muratabah Al-Ula wa Al-Thaniyah: Mulk Al-Baghy wa Sihr Al-Jibt",
                    "Stage IV: The First & Second Wishes — Usurping the Sultanate & Becoming the Supreme Sorcerer",
                    "FORMATION (At-Takwin): In his first ascent, Ja'far commands the Lamp to strip the rightful ruler and crown him Sultan — enacting Al-Baghy (tyrannical usurpation) and Al-Fahishah (humiliating the court in chains). Realizing that political office alone cannot command hearts or match prophetic truth, he demands his second wish: to become the most powerful Sorcerer (Sahir 'Azim) in the world, transforming his vizier's staff into a gigantic rearing serpent.",
                    "DISSOLUTION COUNTER-MOVE (Al-Furqan): Like Pharaoh's sorcerers casting their ropes and staffs to simulate serpents (Qur'an 7:116, 20:66: 'Yukhayyalu ilayhi min sihrihim annaha tas'a'), Ja'far's sorcerous form is exposed by 'Ala' ad-Din as derivative illusion — all his power still flows from the Lamp he does not ontologically command.",
                    "Qur'an 20:69 ('What they have crafted is only the trick of a sorcerer, and the sorcerer will never succeed wherever he comes from') & Qur'an 7:116.",
                    0.830, 0.000
            ),
            new FormationDissolutionPhase(
                    5,
                    "5. Al-Khad'ah Al-Muta'aliyah: 'Al-Marid Aqwa Minka!'",
                    "Stage V: The Apex Temptation — 'Ala' ad-Din's Criterion Mirror ('The Jinni Is Still Greater Than You!')",
                    "FORMATION APEX (At-Tughyan Al-Akbar): Surrounded by swirling red-and-black smokeless fire (Marij min Nar), Ja'far stands on the precipice of total Warlock Formation. Yet his fatal flaw is Istikbar — he cannot bear that any being in existence outranks him.",
                    "DISSOLUTION TRIGGER (Al- الحجة Al-Ibrahimiyyah): Mirroring Abraham's confounding of Nimrod ('Bring the sun from the West!', Qur'an 2:258), 'Ala' ad-Din holds up the mirror of the Warlock's own arrogance: 'You are still only second-best! The Jinni of the Lamp who gave you your power is far greater than you!' Blinded by Ghurur (delusion), Ja'far screams his third and final wish: 'Make me an all-powerful Jinni/Marid!'",
                    "Qur'an 17:16, Qur'an 89:11-14 ('Who transgressed [taghaw] in the lands and multiplied Fasad therein; so your Lord poured upon them a scourge of punishment — indeed, your Lord is ever on the watchtower [la-bi-al-mirsad]').",
                    0.985, 0.000
            ),
            new FormationDissolutionPhase(
                    6,
                    "6. Al-Inhilal wa Al-Asfad: Al-Habs fi Al-Qumqum Al-Sulaymani",
                    "Stage VI: Warlock Dissolution — The Cosmic Fetters & Implosion into the Black-Brass Lamp",
                    "DISSOLUTION OF THE WARLOCK (Al-Inhilal Al-Kulli): As Ja'far swells into a colossal crimson Marid of Smokeless Fire, boasting of his absolute hegemony over the universe, cosmic law snaps shut: in Islamic cosmology, a Jinni of the Lamp is not a sovereign god — he is a prisoner bound to a vessel ('Muqarranina fi al-asfad', Qur'an 38:38). Heavy brass manacles (Al-Aghlal wa Al-Asfad) materialize around Ja'far's wrists, and a black-brass Solomonic Lamp (Al-Qumqum Al-Asfar) forms at his feet.",
                    "THE COLLAPSE OF SHIRK INTO SERVITUDE: 'Ala' ad-Din lifts the newly forged black-brass Lamp as Ja'far's gigantic fire-form is violently stretched, inverted, and sucked spiraling down into the narrow spout ('Phenomenal cosmic power — itty-bitty living space!'). His human autonomy, vizierate, and serpent-sorcery dissolve into zero-entropy containment (H_resolved = 0.000 bits).",
                    "Qur'an 38:38 ('And others bound together in fetters [muqarranina fi al-asfad]'), Qur'an 14:49 ('And you will see the Mujrimin that Day bound together in fetters, their garments of liquid pitch'), & Qur'an 10:81 ('Indeed, Allah will dissolve/nullify it [sayubtiluhu]').",
                    0.985, 0.000
            ),
            new FormationDissolutionPhase(
                    7,
                    "7. Al-Hijr Al-Mahjur wa Fakk Ar-Raqabah: Sealing the Sequester & Restoring the Realm",
                    "Stage VII: Casting the Qumqum Beyond the Inter-World Sequester & Emancipating the Realm",
                    "SEQUESTRATION OF DISORDER: The sealed Black-Brass Lamp containing the dissolved Warlock Ja'far is cast across the Inter-World Sequester (Al-Hijr Al-Mahjur / Sur Al-Hadid, Qur'an 25:53, 57:13) into the Ten-Thousand-Year Quarantine Abyss, where its smokeless fire can never again cross into the Abrahamic Sanctuary.",
                    "RESTORATION OF AL-MIZAN: With the Warlock dissolved and sequestered, 'Ala' ad-Din fulfills his covenant by freeing the good Jinni from the original Lamp, breaking the cycle of coercive pact-making forever and restoring the Kingdom to legitimate, uncoerced peace (State S0 Optimal, C_p >= 1.44).",
                    "Qur'an 25:53 ('And He placed between them a Barzakh and an inviolable Sequester [Hijran Mahjura]'), Qur'an 57:13 ('A wall [Sur] erected between them with a gate: its interior contains Mercy, and its exterior facing them contains Torment'), & Qur'an 17:81 ('Truth has come and Falsehood has vanished; indeed, Falsehood is ever bound to vanish [zahuga]').",
                    0.000, 0.000
            )
    );

    private static final List<InterWorldSequester> SEVEN_INTER_WORLD_SEQUESTERS = List.of(
            new InterWorldSequester(
                    1,
                    "SEQUESTER_S1_MIZAN_DAM",
                    "Hijr Al-Mizan wa Radm Al-Fasad (حجر الميزان وردم الفساد)",
                    "Sequester #1: The Iron-Copper Dam of Dhu Al-Qarnayn Between Trust & Fasad",
                    1, "world-1-mizan-fasad.html",
                    "Dar Al-Amanah wa Al-Balad Al-Amin (Order #1 White)",
                    "Dar Al-Fasad (`Mufsid Al-Ard` / `zalim-1-fasad`)",
                    "Qur'an 18:94-97 ('Inna Ya'juja wa Ma'juja mufsiduna fi al-ard... Bring me blocks of iron [zubar al-hadid] until when he had leveled between the two cliffs, he said: Pour over it molten copper [qitran]; so they were unable to scale it, nor could they pierce it').",
                    "A bimetalic Iron-and-Molten-Copper Sequester Wall (Radm) spanning the canyon between the Secure Sanctuary and the blighted wastes of Fasad.",
                    "Qumqum #1: Sealed Lead-Copper Vessel of Mufsid Al-Ard",
                    12.0, 0.000
            ),
            new InterWorldSequester(
                    2,
                    "SEQUESTER_S2_HIJAB_TAQWA",
                    "Hijab Libas At-Taqwa wa Tahrim Al-Fahishah (حجاب لباس التقوى وتحريم الفاحشة)",
                    "Sequester #2: The Inviolable Curtain of Modesty & Sanctuary Purification",
                    2, "world-2-haya-fahishah.html",
                    "Dar Al-Haya' wa Libas At-Taqwa (Order #2 Black)",
                    "Suq Al-Fahishah wa Tawaf Al-'Urah (`Da'i Al-Fahishah` / `zalim-2-fahishah`)",
                    "Qur'an 7:26-28 & Qur'an 9:28 ('Indeed, the polytheists are impure, so let them not approach Al-Masjid Al-Haram after this their final year').",
                    "An acoustic and optical Hijab-Membrane around the Haram boundary that nullifies whistling/clapping (muka'an wa tasdiyatan) and bars unclothed exhibitionism.",
                    "Qumqum #2: Sealed Obsidian-Brass Flask of Da'i Al-Fahishah",
                    12.0, 0.000
            ),
            new InterWorldSequester(
                    3,
                    "SEQUESTER_S3_BARD_WA_SALAM",
                    "Barzakh Bardan wa Salaman (برزخ بردا وسلاما)",
                    "Sequester #3: The Cool-Fire Thermal Inversion Partition Against Nimrodic Tyranny",
                    3, "world-3-babil-namrud.html",
                    "Maqam Ibrahim wa Al-Muhaymin (Order #3 Sapphire)",
                    "Sarh Babil wa Al-Jahim (`Jabbar Al-Namrud` / `zalim-3-baghy`)",
                    "Qur'an 21:69-70 ('We said: O Fire, be coolness and safety upon Abraham! And they intended for him a plan, but We made them the greatest losers').",
                    "A phase-inverting thermal Barzakh that drops the 3,000K furnace blast of Nimrod to absolute isothermal equilibrium (Delta T = 0, Delta H = 0.000).",
                    "Qumqum #3: Sealed Sapphire-Bronzed Urn of Jabbar Al-Namrud",
                    12.0, 0.000
            ),
            new InterWorldSequester(
                    4,
                    "SEQUESTER_S4_HABL_ALLAH",
                    "Sur Habl-Allah wa 'Azl Al-Fitnah (سور حبل الله وعزل الفتنة)",
                    "Sequester #4: The Covenant Cord Partition Against Sectarian Schism",
                    4, "world-4-ummah-fitnah.html",
                    "Ribat Al-Ummah Al-Wahidah (Order #4 Gold)",
                    "Mu'tarak Al-Ahzab (`Nafikh Al-Fitnah` / `zalim-4-fitnah`)",
                    "Qur'an 57:13 ('Then a Wall [Sur] will be erected between them with a gate: its interior contains Mercy, and its exterior facing them contains the Torment') & Qur'an 6:159.",
                    "A golden axial Gate-Wall (Sur Al-Hadid) whose interior encloses the unified Millat Ibrahim in mercy and whose exterior seals sectarian Fitnah outside.",
                    "Qumqum #4: Sealed Electrum-Brass Cylinder of Nafikh Al-Fitnah",
                    12.0, 0.000
            ),
            new InterWorldSequester(
                    5,
                    "SEQUESTER_S5_SHIHAB_RASAD",
                    "Hijr Ash-Shuhub wa Al-Mirsad (حجر الشهب والمرصاد)",
                    "Sequester #5: The Meteoric Guard-Screen Against Capricious Law-Forgery",
                    5, "world-5-furqan-hawa.html",
                    "Diwan Al-Furqan wa Al-Kitab Al-Muhaymin (Order #5 Crimson)",
                    "Mahkamat Al-Hawa wa An-Nasi' (`'Abid Al-Hawa` / `zalim-5-hawa`)",
                    "Qur'an 72:8-9 ('And we sought to touch the heaven, but we found it filled with stern guards and flaming meteors [shuhuban]') & Qur'an 89:14 ('Inna Rabbaka la-bi-al-mirsad').",
                    "A high-altitude Shihab plasma cordon that incinerates every forged decree (Iftira') and calendar manipulation (Nasi') before it can touch the Revealed Criterion.",
                    "Qumqum #5: Sealed Porphyry-Brass Lamp of 'Abid Al-Hawa",
                    12.0, 0.000
            ),
            new InterWorldSequester(
                    6,
                    "SEQUESTER_S6_URWAH_WUTHQA",
                    "Fasil Al-'Urwah Al-Wuthqa wa Khatam Sulayman (فاصل العروة الوثقى وخاتم سليمان)",
                    "Sequester #6: The Solomonic Brass Containment Seal Against Jibt & Taghut",
                    6, "world-6-tawhid-taghut.html",
                    "Hisn Al-'Urwah Al-Wuthqa (Order #6 Brass)",
                    "Haykal Azar wa Al-Azlam (`Kahin Al-Jibt` / `zalim-6-jibt`)",
                    "Qur'an 2:256 ('Whoever disbelieves in At-Taghut and believes in Allah has grasped the Most Trustworthy Handhold with no fissure therein') & Qur'an 38:38.",
                    "The original Solomonic Lead-and-Brass Qumqum vault beneath the Foundation Stone that imprisons all sorcerous Jibt and Taghut idols in zero-leakage isolation.",
                    "Qumqum #6: The Black-Brass Lamp of Ja'far & Kahin Al-Jibt",
                    12.0, 0.000
            ),
            new InterWorldSequester(
                    7,
                    "SEQUESTER_S7_HIJR_MAHJURA",
                    "Al-Barzakh Al-A'zam wa Hijran Mahjura (البرزخ الأعظم وحجرا محجورا)",
                    "Sequester #7: The Supreme Isthmus Separating Bunyan At-Taqwa from the Crumbling Cliff",
                    7, "world-7-taqwa-dirar.html",
                    "Al-Qawa'id min Al-Bayt wa Bunyan At-Taqwa (Order #7 Emerald)",
                    "Masjid Ad-Dirar 'ala Shafa Jurufin Harin (`Imam Az-Zalimin` / `zalim-7-zulm`)",
                    "Qur'an 25:53 ('Wa ja'ala baynahuma barzakhan wa hijran mahjura'), Qur'an 55:19-20 ('Baynahuma barzakhun la yabghiyan'), & Qur'an 7:46 ('Wa baynahuma hijab').",
                    "The ultimate cosmic Isthmus (Al-Hijr Al-Mahjur) that permanently severs the crumbling cliff of Masjid Ad-Dirar from the Eternal Foundation of Abraham.",
                    "Qumqum #7: Abyssal Pitch-Brass Sarcophagus of Imam Az-Zalimin",
                    12.0, 0.000
            )
    );

    public static List<FormationDissolutionPhase> allFormationDissolutionStages() {
        return SEVEN_FORMATION_DISSOLUTION_STAGES;
    }

    public static List<InterWorldSequester> allInterWorldSequesters() {
        return SEVEN_INTER_WORLD_SEQUESTERS;
    }

    public static InterWorldSequester sequesterForWorldIndex(int worldIndex) {
        return SEVEN_INTER_WORLD_SEQUESTERS.stream()
                .filter(s -> s.worldIndex() == worldIndex)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown worldIndex: " + worldIndex));
    }
}
