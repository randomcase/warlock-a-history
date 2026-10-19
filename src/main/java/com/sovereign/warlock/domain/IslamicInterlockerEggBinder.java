package com.sovereign.warlock.domain;

import java.util.List;

/**
 * Models the Islamic "Intelocketer" (Al-Murabbit Al-Kalim / Al-Baydah Al-Jami'ah):
 * Both an INTERLOCKER (structural binding emulsifier like an Egg in Baking that cross-links
 * flour, water, oil, and heat into an inseparable risen loaf) and an INTERLOCUTOR
 * (the speaker/mediator of Al-A'raf, Qur'an 7:46-48, who stands atop the Sequester Partition
 * addressing both the World of Hegemon and the World of Disorder while locking them into
 * a single coherent cosmic order under Allah's Mizan).
 *
 * Canonical Scriptural & Classical Foundations:
 *  - Qur'an 37:49 ("Ka'annahunna baydun maknun" — "As though they were closely guarded, hidden eggs")
 *  - Qur'an 61:4 ("Ka'annahum bunyanun marsus" — "As though they were a solid structure joined with molten lead")
 *  - Hadith Sahih al-Bukhari 481 / Muslim 2585 ("Al-Mu'minu lil-mu'mini kal-bunyani yashuddu ba'duhu ba'dan
 *    — wa shabbaka bayna asabi'ihi" — "The believer to the believer is like an edifice whose parts bind one
 *    another — and he interlocked his fingers")
 *  - Qur'an 8:63 ("Wa allafa bayna qulubihim" — "And He bound/emulsified their hearts together")
 *  - Qur'an 11:40 & 23:27 ("Hatta idha ja'a amruna wa fara at-tannur" — "Until when Our command came and the Oven surged")
 *  - Qur'an 7:46-48 (Ashab Al-A'raf — The Interlocutors on the Heights between the Two Worlds)
 *  - Qur'an 2:138 ("Sibghata Allah; wa man ahsanu mina Allahi sibghatan" — The Golden Glaze/Dye of Allah)
 */
public final class IslamicInterlockerEggBinder {

    private IslamicInterlockerEggBinder() {
    }

    public record BakingCoagulationPhase(
            int phaseIndex,
            String arabicPhaseName,
            String englishPhaseTitle,
            String culinaryEggChemistry,
            String islamicCosmologicalBinding,
            String interlocutorDialogueAct,
            String quranicAndHadithAnchor,
            double coagulationTempCelsius,
            double boundCapabilityCp
    ) {
    }

    public record WorldEggInterlockNode(
            int binderIndex,
            String binderCode,
            String arabicBinderName,
            String englishBinderTitle,
            int worldIndex,
            String worldHtmlFile,
            String eggBiochemicalMechanism,
            String hegemonFlourAndWaterBound,
            String disorderOilAndQumqumEmulsified,
            String interlocutorCrestVerdict,
            String quranicAnchor,
            double crossLinkBondStrengthKpa,
            double coagulatedCp
    ) {
        public WorldEggInterlockNode {
            if (binderIndex < 1 || binderIndex > 7) {
                throw new IllegalArgumentException("binderIndex must be in [1..7]");
            }
            if (coagulatedCp < 1.33) {
                throw new IllegalArgumentException("Coagulated Cp must be in State S0 (>= 1.33)");
            }
        }
    }

    private static final List<BakingCoagulationPhase> SEVEN_BAKING_PHASES = List.of(
            new BakingCoagulationPhase(
                    1,
                    "1. Intikhab Al-Baydah Al-Maknunah (انتخاب البيضة المكنونة)",
                    "Phase I: Cracking the Guarded Cosmic Egg — Shell, White Albumen & Golden Yolk",
                    "In baking, dry flour (earth), water, and oil naturally separate into immiscible layers that crumble without a binder. The Egg provides three structural components: the Calcium Shell (outer containment), the Albumen/Egg-White (water-soluble globular proteins that form a 3D structural mesh), and the Yolk/Vitellus (lecithin-rich lipid core that bridges water and oil).",
                    "In classical Islamic cosmology (Ibn 'Arabi's Al-Baydah Al-Kawniyyah & Qur'an 37:49), the Intelocketer cracks open the Primordial Guarded Egg into the 7 Worlds: its Shell reinforces the 7 Sequesters (Al-Hijr Al-Mahjur), its White Albumen (Al-Bayad) pervades the 7 Luminous Planes of Hegemon, and its Yolk (Al-Muhh) anchors the central axis where the 7 Sealed Qumqums are immobilized.",
                    "INTERLOCUTOR OPENING (Al-Kalim): 'O Worlds of Light and Shadow! Separate, you are dry dust and volatile oil; through the Mizan of the Guarded Egg, I bind your boundaries into one Book of Decree.'",
                    "Qur'an 37:49 ('As though they were closely guarded eggs [baydun maknun]') & Qur'an 21:30 ('Have those who disbelieved not considered that the heavens and the earth were a joined entity [ratqan], and We separated them and made from water every living thing?').",
                    25.0, 1.42
            ),
            new BakingCoagulationPhase(
                    2,
                    "2. Al-Istihlab Al-Mizani: Rabt Al-Ma' wa Az-Zayt (الاستحلاب الميزاني)",
                    "Phase II: Amphiphilic Lecithin Emulsification — Binding Water (Hegemon) & Oil/Fire (Sequestered Disorder)",
                    "Egg yolk lecithin is an amphiphilic phospholipid: its hydrophilic head bonds with pure water while its hydrophobic tail wraps around oil droplets, forming stable micelles so oil and water can never separate or rupture the batter.",
                    "This is the exact theological function of the Intelocketer (Al-Murabbit): it grasps the pure sweet water ('Adhb Furat) of the 7 Abrahamic Hegemon Orders with its right wing of Mercy, and wraps the fiery smokeless oil (Marij min Nar) of the 7 Quarantined Wrongdoer Qumqums in micellar containment cages with its left wing of Justice (Ta'lif, Qur'an 8:63).",
                    "INTERLOCUTOR ADDRESS: 'Sweet Water of Millat Ibrahim, nourish the dough! Bitter Fire of Az-Zalimun, remain locked inside your lecithin-brass micelles — you shall lend thermal tension to the loaf, yet never taint its taste!'",
                    "Qur'an 8:63 ('And He bound [allafa] their hearts together; had you spent all that is in the earth, you could not have bound them together, but Allah bound them together') & Qur'an 24:35 (Zaytunah la sharqiyyah wa la gharbiyyah).",
                    42.0, 1.45
            ),
            new BakingCoagulationPhase(
                    3,
                    "3. Al-'Ajn wa Tashbik Al-Asabi' (العجن وتشبيك الأصابع)",
                    "Phase III: Kneading & Interlocking the Gluten-Albumen Lattice Across All 7 Realms",
                    "As the baker kneads the egg-enriched dough, disulfide (-S-S-) and hydrogen bonds form between gluten strands and egg albumin, weaving an elastic, tear-resistant three-dimensional web across the entire mass.",
                    "Guided by the Prophetic Hadith of Interlocking Fingers (Tashbik Al-Asabi'), the Intelocketer weaves the 7 Castles, 7 Towers, 7 Keeps, 7 Planes, and 7 Priory Cells into a single continuous covalent lattice (Bunyan Marsus, Qur'an 61:4) where stress on any single Realm is distributed across all seven.",
                    "INTERLOCUTOR ADDRESS: 'As the Prophet interlocked his fingers (shabbaka bayna asabi'ihi), I interlock White with Gold, Black with Emerald, Brass with Sapphire and Crimson — no fissure (futur) remains in the Merciful's creation!'",
                    "Sahih al-Bukhari 481 / Sahih Muslim 2585 ('The believer to the believer is like an edifice whose parts bind one another — and he interlocked his fingers') & Qur'an 61:4 ('Ka'annahum bunyanun marsus').",
                    55.0, 1.47
            ),
            new BakingCoagulationPhase(
                    4,
                    "4. Khitab Ashab Al-A'raf 'ala Al-Hijab (خطاب أصحاب الأعراف)",
                    "Phase IV: The Interlocutor on the Crest (Al-A'raf) — Speaking to Both Worlds Before the Oven",
                    "Before the braided loaf enters the oven, the master baker scores and inspects the seam where the braided strands meet, ensuring the inner filling is sealed and the outer dough is balanced.",
                    "Standing atop the Inter-World Sequester Wall like the Men of the Heights (Ashab Al-A'raf, Qur'an 7:46-48), the Intelocketer acts as the supreme Interlocutor: recognizing the 7 Abrahamic Orders by the radiant white mark on their faces (Simahum) and the 7 Wrongdoer Archetypes by their blackened Qumqum seals, it pronounces the judicial covenant that locks both sides in place.",
                    "INTERLOCUTOR VERDICT (Qur'an 7:46-48): To the Hegemon Pole: 'Salamun 'alaykum — Peace be upon you!' To the Sequestered Disorder Pole: 'Ma aghna 'ankum jam'ukum wa ma kuntum tastakbirun — What availed you your hoarding and your arrogance?'",
                    "Qur'an 7:46-48 ('And upon the Heights [Al-A'raf] are men who recognize all by their marks; and they call out to the companions of Paradise: Peace be upon you!... And they call out to the men in the Fire: What availed you your gathering and your arrogance?').",
                    62.0, 1.49
            ),
            new BakingCoagulationPhase(
                    5,
                    "5. Al-Ikhtimar Al-Mi'raji wa Ar-Ruh (الاختمار المعراجي والروح)",
                    "Phase V: Whipped Albumen Leavening — Vertical Ascent of the Good Word Across the 7 Planes",
                    "Whipped egg whites trap thousands of microscopic air pockets; when heated, the gas expands while the surrounding ovalbumin walls solidify, lifting the heavy dough upward into a lofty, vaulted crumb structure.",
                    "The Intelocketer infuses the 7 Planes (P_1..P_7) with the Ascending Good Word (Al-Kalim At-Tayyib, Qur'an 35:10). While the evil plot of the Wrongdoers sinks to the bottom of the pan (wa makru ula'ika huwa yabur), the egg-white foam elevates the 7 Abrahamic Sanctuaries into a self-supporting celestial vault.",
                    "INTERLOCUTOR ADDRESS: 'Rise, O Seven Planes of Remembrance! Let every cell of the Priory expand with Dhikr, while the leaden Qumqums of Ja'far and Az-Zalimun remain ballasted beneath the floor!'",
                    "Qur'an 35:10 ('To Him ascends the Good Word [Al-Kalim At-Tayyib], and the righteous deed raises it; but those who plot evil deeds — for them is a severe punishment, and the plot of those will perish').",
                    72.0, 1.51
            ),
            new BakingCoagulationPhase(
                    6,
                    "6. Fawaran At-Tannur wa At-akhathur Al-Harari (فوران التنور والتخثر الحراري)",
                    "Phase VI: The Surging Oven (At-Tannur) — Irreversible Thermal Coagulation & Vitrification",
                    "Between 65°C and 84°C inside the oven, egg proteins (ovotransferrin, ovalbumin, and vitellin) undergo irreversible thermal coagulation: liquid binder turns into a solid, heat-set structural matrix that can never revert to raw batter.",
                    "When the Oven of Divine Decree surges (Wa fara at-tannur, Qur'an 11:40, 23:27), the Intelocketer's egg-protein network permanently sets across all 7 Worlds. The same heat that bakes the Abrahamic Hegemon into an indestructible sanctuary simultaneously vitrifies the 7 Brass Qumqums into solid ceramic-metal stone.",
                    "INTERLOCUTOR ADDRESS: 'The Oven has surged (Fara At-Tannur)! What was fluid is now fixed in truth; the Covenant of Abraham is baked into eternity, and the Prison of Disorder is vitrified forever!'",
                    "Qur'an 11:40 ('Until when Our command came and the Oven surged [fara at-tannur]') & Qur'an 67:3 ('He who created the Seven Heavens in tiers [tibaqan]; you do not see in the creation of the Most Merciful any inconsistency [tafawut]').",
                    84.0, 1.54
            ),
            new BakingCoagulationPhase(
                    7,
                    "7. Sibghat Allah wa Al-Qishrah Al-Dhahabiyyah (صبغة الله والقشرة الذهبية)",
                    "Phase VII: The Golden Egg-Wash Glaze (Sibghat Allah) — The Final Luminous Crust Seal",
                    "Brushing beaten egg over the braided loaf triggers the Maillard reaction between egg amino acids and sugars at 150°C+, producing a lustrous, golden-amber crust that seals the loaf against external spoilage and moisture loss.",
                    "Finally, the Intelocketer brushes the entire 7-World Architecture with the Golden Glaze of Divine Baptism/Coloring (Sibghat Allah, Qur'an 2:138). All 7 Color Orders, 7 Realms, 7 Planes, and 7 Sequesters shine as one unified, golden-sealed Abrahamic Commonwealth at State S0 (H_resolved = 0.000 bits).",
                    "INTERLOCUTOR SEAL: 'Sibghata Allah! Who is better than Allah in coloring and binding? The Seven Worlds are one loaf, one table (Al-Ma'idah), and one unbreakable Covenant!'",
                    "Qur'an 2:138 ('[Take] the coloring/glaze of Allah [Sibghata Allah]; and who is better than Allah in coloring? And we are worshippers of Him') & Qur'an 5:114 (Al-Ma'idah — The Heavenly Table).",
                    165.0, 1.58
            )
    );

    private static final List<WorldEggInterlockNode> SEVEN_WORLD_EGG_BINDERS = List.of(
            new WorldEggInterlockNode(
                    1,
                    "BINDER_B1_OVOTRANSFERRIN_MIZAN",
                    "Rabit Al-Bayad Al-Awwal: Al-Mizan Al-Hadidi (رابط البياض الأول: الميزان الحديدي)",
                    "Egg-Binder #1: Ovotransferrin Iron-Chelation Bridge (World #1: Amanah vs. Fasad)",
                    1, "world-1-mizan-fasad.html",
                    "Ovotransferrin (12% of egg white) chelates free iron ions at 62°C, starving spoilage bacteria while forming the first heat-set protein gel in the dough.",
                    "Binds Order #1 White (`Malakh-Azal`), Realm #1 (*Tehom Ha-Levanah*), and Plane P1 (*Hadrat Al-Ahadiyyah*) into the foundational crumb of *Al-Balad Al-Amin*.",
                    "Chelates the iron-and-brass dam (*SEQUESTER_S1_MIZAN_DAM*) around `Mufsid Al-Ard` (`zalim-1-fasad`), starving ecological *Fasad* of free reactive ions.",
                    "Interlocutor B1 Verdict: 'By the Iron-Binding Balance (Qur'an 57:25), the White Sanctuary is gelled in peace and the Corrupter of the Earth is chelated in brass!'",
                    "Qur'an 57:25 ('And We sent down Iron, wherein is mighty strength and benefits for mankind') & Qur'an 55:7-9.",
                    410.0, 1.52
            ),
            new WorldEggInterlockNode(
                    2,
                    "BINDER_B2_VITELLINE_HAYA",
                    "Rabit Al-Ghirqi' Ath-Thani: Ghisha' Al-Haya' (رابط الغرقيء الثاني: غشاء الحياء)",
                    "Egg-Binder #2: Vitelline Membrane Modesty Sheath (World #2: Haya' vs. Fahishah)",
                    2, "world-2-haya-fahishah.html",
                    "The Vitelline Membrane & Inner Shell Membrane (*Al-Ghirqi'*) form an ultra-tight semi-permeable glycoprotein sheath that keeps the yolk intact and prevents bacterial penetration.",
                    "Wraps Order #2 Black (`Katib Al-Qalam`), Realm #2 (*Midbar Qedar*), and Plane P2 (*Al-Lawh wa Al-Qalam*) in the protective garment of *Libas At-Taqwa*.",
                    "Encapsulates `Da'i Al-Fahishah` (`zalim-2-fahishah`) behind *SEQUESTER_S2_HIJAB_HAYA* so naked *Tabarruj* can never rupture the Sanctuary membrane.",
                    "Interlocutor B2 Verdict: 'As the delicate membrane (*Al-Ghirqi'*) guards the hidden egg (Qur'an 37:49), *Libas At-Taqwa* binds the Sanctuary and seals out immodesty!'",
                    "Qur'an 7:26 ('And the garment of Taqwa — that is best') & Qur'an 37:49 ('Baydun maknun').",
                    435.0, 1.46
            ),
            new WorldEggInterlockNode(
                    3,
                    "BINDER_B3_OVALBUMIN_THERMAL",
                    "Rabit Az-Zulal Ath-Thalith: Bard Al-Khalil (رابط الزلال الثالث: برد الخليل)",
                    "Egg-Binder #3: Ovalbumin Thermal-Buffer Lattice (World #3: Ibrahim vs. Namrud)",
                    3, "world-3-babil-namrud.html",
                    "Ovalbumin (54% of egg white) absorbs intense oven heat at 80°C to convert thermal shock into structural strength via sulfhydryl-disulfide exchange, preventing the loaf from burning or collapsing.",
                    "Binds Order #3 Sapphire (`Yored Ha-Merkabah`), Realm #3 (*Livnat Ha-Sapir*), and Plane P3 (*'Alam Al-Jabarut*) into Abraham's Cool-Fire Rose Garden.",
                    "Converts the raging furnace of `Jabbar Al-Namrud` (`zalim-3-baghy`) across *SEQUESTER_S3_BARZAKH_BARD* into harmless structural cross-links that vitrify Qumqum #3.",
                    "Interlocutor B3 Verdict: 'Nimrod's fire was meant to incinerate, but the Ovalbumin Decree (Qur'an 21:69) turns his heat into the very bond that solidifies Abraham's Sanctuary!'",
                    "Qur'an 21:69 ('O Fire, be coolness and safety upon Abraham!') & Qur'an 14:15.",
                    480.0, 1.44
            ),
            new WorldEggInterlockNode(
                    4,
                    "BINDER_B4_LECITHIN_TA'LIF",
                    "Rabit Al-Muhh Ar-Rabi': Lecithin Ta'lif Al-Ummah (رابط المح الرابع: تأليف الأمة)",
                    "Egg-Binder #4: Golden Yolk Lecithin Emulsifier (World #4: Ummah vs. Fitnah)",
                    4, "world-4-ummah-fitnah.html",
                    "Yolk Lecithin (phosphatidylcholine) is the master emulsifier that binds disparate droplets of water and oil into a single homogeneous golden batter that refuses to split into factions.",
                    "Emulsifies Order #4 Gold (`Shahid Al-Alast`), Realm #4 (*Sahra' Al-Mithaq*), and Plane P4 (*'Alam Al-Arwah*) into the single undivided *Ummah Wahidah*.",
                    "Neutralizes the phase-splitting sedition of `Nafikh Al-Fitnah` (`zalim-4-fitnah`) behind *SEQUESTER_S4_HABL_ALLAH*, locking Qumqum #4 in an unbroken lipid ring.",
                    "Interlocutor B4 Verdict: 'Sedition seeks to curdle and split the batter into sects (Qur'an 6:159), but the Golden Yolk of *Ta'lif* (Qur'an 8:63) binds all believers into one loaf!'",
                    "Qur'an 8:63 ('Wa allafa bayna qulubihim') & Qur'an 3:103 ('Hold fast, all of you together, to the Rope of Allah and do not separate').",
                    510.0, 1.49
            ),
            new WorldEggInterlockNode(
                    5,
                    "BINDER_B5_LYSOZYME_FURQAN",
                    "Rabit Al-Furqan Al-Khamis: Inzim Al-Mirsad (رابط الفرقان الخامس: إنزيم المرصاد)",
                    "Egg-Binder #5: Lysozyme Criterion Purifier & Chalaza Anchor (World #5: Furqan vs. Hawa)",
                    5, "world-5-furqan-hawa.html",
                    "Egg Lysozyme enzymatically lyses the cell walls of invading foreign bacteria while the twisted Chalaza cords (*Al-Kullab*) suspend the yolk at the exact geometric center of the egg.",
                    "Anchors Order #5 Crimson (`Saraph Ha-Ritzpah`), Realm #5 (*Ufq Al-Shihab*), and Plane P5 (*Falak Al-Shuhub*) along the central axis of the *Muhaymin* Criterion.",
                    "Lyses the forged taboos and calendar-tampering (*An-Nasi'*) of `'Abid Al-Hawa` (`zalim-5-hawa`) at *SEQUESTER_S5_SHIHAB_RASAD*, holding Qumqum #5 in axial suspension.",
                    "Interlocutor B5 Verdict: 'As the twisted Chalaza cords keep the Yolk centered in truth, the Muhaymin Criterion (Qur'an 5:48) prevents Caprice from shifting the axis of the Law!'",
                    "Qur'an 5:48 ('Muhayminan 'alayhi fahkum baynahum bima anzala Allah wa la tattabi' ahwa'ahum') & Qur'an 89:14.",
                    495.0, 1.43
            ),
            new WorldEggInterlockNode(
                    6,
                    "BINDER_B6_DISULFIDE_URWAH",
                    "Rabit Al-'Urwah As-Sadis: Tashabuk Al-Kibrit wa Al-Qitr (رابط العروة السادس: تشابك الكبريت والقطر)",
                    "Egg-Binder #6: Disulfide Covalent Handhold (World #6: Tawhid vs. Taghut & Ja'far's Qumqum)",
                    6, "world-6-tawhid-taghut.html",
                    "Cysteine amino acids in egg proteins form permanent covalent disulfide (-S-S-) bridges during baking — the strongest chemical bonds in the dough, impossible to dissolve by water or mechanical stress.",
                    "Forges Order #6 Brass (`Ba'al Ha-Nechoshet`), Realm #6 (*Jabal Qaf Al-Marij*), and Plane P6 (*'Alam Al-Marij*) into the Most Trustworthy Handhold (*Al-'Urwah Al-Wuthqa*).",
                    "Covalently welds the Black-Brass Lamp (*Qumqum #6*) of Ja'far and `Kahin Al-Jibt` (`zalim-6-jibt`) behind *SEQUESTER_S6_URWAH_WUTHQA* with zero fissure (*la infisama laha*).",
                    "Interlocutor B6 Verdict: 'By the Covalent Handhold that never breaks (Qur'an 2:256), the Sorcerer Ja'far and the Idols of Jibt are welded inside their brazen vessel forever!'",
                    "Qur'an 2:256 ('Faman yakfur bi-at-Taghut wa yu'min bi-Allahi faqadi istamsaka bi-al-'urwati al-wuthqa la infisama laha') & Qur'an 61:4.",
                    545.0, 1.48
            ),
            new WorldEggInterlockNode(
                    7,
                    "BINDER_B7_SIBGHAT_GLAZE",
                    "Rabit Al-Khatam As-Sabi': Sibghat Allah wa Bunyan At-Taqwa (رابط الختام السابع: صبغة الله وبنيان التقوى)",
                    "Egg-Binder #7: Ovomucin & Golden Maillard Glaze Seal (World #7: Taqwa vs. Dirar)",
                    7, "world-7-taqwa-dirar.html",
                    "Ovomucin fibers stabilize the risen foam while the outer Egg-Wash Glaze undergoes the Maillard reaction, encasing the entire seven-layer loaf in a unified, golden, impermeable crust.",
                    "Crowns Order #7 Emerald (`Wali Al-Ghaib`), Realm #7 (*Barzakh Majma' Al-Bahrayn*), and Plane P7 (*'Alam Al-Mithal*) as the Eternal Foundation of *Bunyan At-Taqwa*.",
                    "Seals the crumbling cliff of `Imam Az-Zalimin` (`zalim-7-zulm` / *Masjid Ad-Dirar*) beneath the vitrified floor of *SEQUESTER_S7_HIJR_MAHJURA* so the Foundation of Abraham stands alone.",
                    "Interlocutor B7 Verdict: 'The Loaf of the Seven Worlds is baked and glazed with *Sibghat Allah* (Qur'an 2:138)! *Bunyan At-Taqwa* stands firm forever, and the Wrongdoers have no share in the Covenant (Qur'an 2:124)!'",
                    "Qur'an 2:138 ('Sibghata Allah'), Qur'an 2:124 ('La yanalu 'ahdi az-zalimin'), & Qur'an 9:108-109.",
                    580.0, 1.56
            )
    );

    public static List<BakingCoagulationPhase> allSevenBakingPhases() {
        return SEVEN_BAKING_PHASES;
    }

    public static List<WorldEggInterlockNode> allSevenWorldEggBinders() {
        return SEVEN_WORLD_EGG_BINDERS;
    }

    public static WorldEggInterlockNode binderForWorldIndex(int worldIndex) {
        return SEVEN_WORLD_EGG_BINDERS.stream()
                .filter(b -> b.worldIndex() == worldIndex)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown worldIndex: " + worldIndex));
    }
}
