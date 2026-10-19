package com.sovereign.warlock.domain;

import java.util.List;

/**
 * Canonical Domain Atlas for Portal #68:
 * The Sovereign Single-Castle 2.5D/3D Sprite RPG, Caravan & Port Logistics,
 * Castle Siege, 6-Mode Tactical Wargame, 67-Tome Library & 3.14 Pi Studio Engine.
 *
 * Anchored in the beginning of the Ummah with the 313 at Badr (+ 1 Sovereign Center = 314 = 100 * 3.14),
 * opening in Prophetic Hope, Levity, and Brotherhood (Mu'akhah), where the Good Warlock Devoted to Islam
 * and the Ummah Leader govern from the Single Castle Throne Room, channel Men's Wills from their lived
 * experience & Patronage, collect Suffrage, trade Vinegar, Cotton, Tobacco, Maps & Compasses, engage
 * Rumored Kings from Afar, uncover Syndications, submit the 7 Warlock Realms to Islam, and weigh
 * 11-parameter 1-Profile-1-Character combat models across 12 Polyglot Data Storage Formats.
 */
public final class IslamicSingleCastleRpgCaravanSiegeGameAtlas {

    private IslamicSingleCastleRpgCaravanSiegeGameAtlas() {
    }

    /**
     * 1 Profile = 1 Character: Every parameter is filled out, abstracted, and named for its Archetype,
     * with all 11 Procedural Combat Weighing Vectors quantized to the 3.14 (Pi) Principle.
     */
    public record CharacterArchetypeProfile(
            String profileId,
            String characterName,
            String arabicTitle,
            String archetypeClass,
            String historicalEraStyle,
            String livedExperienceOrigin,
            String willedDispositionAndPatronage,
            String commandsRuleStack,
            String tacticalFunction,
            String spriteAnimationForm,
            double statWeightPi,
            String statBreakdown,
            double armorWeightPi,
            String armorLoadout,
            double weaponWeightPi,
            String weaponLoadout,
            String skillName,
            String skillAbilityName,
            String vfxType,
            String skillTone,
            String skillDefense,
            String canonicalMetricsOfSkill,
            int baseHp,
            int baseAttack,
            int baseDefense,
            int baseRangeTiles,
            double moveSpeedPi
    ) {
    }

    /**
     * Throne Room Department inside the Single Castle (Manual Sovereign Command + Uncapped Idle Engine).
     */
    public record ThroneRoomDepartmentDossier(
            String departmentId,
            String departmentName,
            String arabicTitle,
            String propheticPrecedent,
            String manualDictateControls,
            String suffrageAndPatronageEffect,
            String idleIncrementalPowerFormula,
            String canonicalCombatImpact
    ) {
    }

    /**
     * Granular City/Port Stronghold Duty, Commodity Supply Chain & Trade Skill (Hiraf) Crediting Islam.
     */
    public record CommodityAndStrongholdDutyDossier(
            String commodityId,
            String commodityName,
            String arabicAndEtymologicalRoot,
            String primaryStrongholdAndPorts,
            String extractionAndRefiningChain,
            String tradeSkillGuild,
            String canonicalCreditToIslam,
            String caravanAndCombatUtility,
            double baseBazaarDinarValuePi
    ) {
    }

    /**
     * Rumored King from Afar & Uncovered Syndication Dossier (Diplomacy -> Uncovering Hoarded Suffrage,
     * "Wolves at the Door" Grievances, Priory Discoveries, or Scientific Advancements).
     */
    public record RumoredKingAndSyndicationDossier(
            String kingdomId,
            String rumoredKingName,
            String realmAndCapital,
            String historicalEraAndBanner,
            String initialCuriosityHopeAndGifts,
            String uncoveredSyndicationName,
            String syndicationTrueNatureType,
            String wolvesAtTheDoorGrievanceOrSuffrage,
            String prioryOrScientificDiscoveryUnlocked,
            String peacefulSubmissionOrSiegeOutcome
    ) {
    }

    /**
     * Polyglot Game Data Model Storage Format Descriptor (12 Supported Formats in the 3.14 Studio).
     */
    public record PolyglotStorageFormatDossier(
            String formatId,
            String formatName,
            String fileExtension,
            String structuralParadigm,
            String how11VectorCharacterAndCombatDataIsStored,
            String sampleSnippet
    ) {
    }

    public static List<CharacterArchetypeProfile> allTwelveArchetypeCharacterProfiles() {
        return List.of(
                new CharacterArchetypeProfile(
                        "CHAR-001-GOOD-WARLOCK",
                        "Al-Ḥakīm Zakeem Al-Muwaḥḥid (The Good Warlock Devoted to Islam)",
                        "الحكيم المسلم الموحّد • صاحب القمقم والبيان",
                        "Good Warlock / Sovereign Covenant Warden",
                        "All 16 Eras (Morphing from Hijazi Burdah to Abbasid Indigo-Gold & Futuristic Muqarnas)",
                        "Severed the ancient occult pact at the Foundation; surrendered every faculty of Al-Kīmiyā', 3.14 geometry, and Solomonic wisdom exclusively to Allāh alongside the 313 at Badr.",
                        "Will: Infinite Negentropic Order & Uncapped Barakah Gathering • Patronage: Supreme Patron of the 67-Tome Castle Library & All 7 Guild Houses",
                        "ORBIT(Single_Castle, r=3.14) -> BOLSTER(All_Allies, aura=3.14x) -> HEAL(Lowest_HP_Unit, threshold=62.8%) -> SEAL_QUMQUM(Nearest_Warlock_Zalim, until_hp_depleted)",
                        "Sovereign Field Conductor, Uncapped Idle Power Generator, Miasma Purifier & Solomonic Brass Qumqum Sealer",
                        "Floating_314_Pi_Levitation (Hovering 3D Sprite with Rotating Golden Kufic Halo + Combat Staff/Qumqum Cast)",
                        9.42,
                        "Quwwah: 3.14π | Sur'ah: 3.14π | 'Aql: 9.42π | Ṣabr: 6.28π | Taqwā: 9.42π | 'Aṣabiyyah: 9.42π",
                        1.57,
                        "Emerald-Gold Muqarnas Khirqah & Inscribed Brass Chestplate of Tawḥīd (Weight: 1.57π, Miasma Nullification: 94.2%)",
                        3.14,
                        "Solomonic Brass Qumqum of Negentropic Severance & Astrolabe Staff of Al-Khwārizmī (Weight: 3.14π)",
                        "Negentropic Tawḥīd Alchemy & 67-Tome Illumination",
                        "Solomonic Qumqum Beam & Golden 3.14 Barakah Sparkle Nova",
                        "SPARKLES_AND_MISSILES",
                        "Sakīnah & Haybah (Radiant Prophetic Calm, Hope & Sovereign Majesty)",
                        "Ṭahārah Absolute Purity Dome & Active-Low 0x00 Pact Nullification",
                        "Itqān: 9.42π | Iḥsān: 9.42π | Thabāt: 9.42π | Canon: Badr 313 Anchor + 7-Realm Foundation Severance",
                        942, 157, 125, 6, 3.14
                ),
                new CharacterArchetypeProfile(
                        "CHAR-002-BADR-313-VANGUARD",
                        "Ḥamzah Al-Badrī (313 Core Muslim Vanguard Champion)",
                        "فارس بدر من الثلاثمائة وثلاثة عشر",
                        "Muslims (Core 313 Mu'minūn & Mubārazah Vanguard)",
                        "Era I–II: Prophetic Madīnah & Rāshidūn Futūḥāt (White 'Imāmah &Hijāzī Mail)",
                        "Endured the Meccan boycott and Hijrah exile; paired in Mu'ākhāh brotherhood at Madīnah where shared dates, vinegar, and laughter forged unbreakable resolve.",
                        "Will: Steadfast Defense of the Weak & Duelist Valor • Patronage: Mentors Newly Converted Caravan Stragglers",
                        "DEFEND(Caravan_Center, r=3.14) -> INTERCEPT(Nearest_Attacker_To_Healer) -> ATTACK(Enemy_Champion, mode=MUBARAZAH_UNTIL_HP_DEPLETED) -> HOLD(Castle_Gate)",
                        "Frontline Melee Anchor, Mubārazah Single-Combat Duelist & Morale Pillar of the 313",
                        "Walking_8Dir_Stride + Combat_Dual_Sayf_Crescent_Slash (Empowered Golden Aura at <50% HP)",
                        6.28,
                        "Quwwah: 6.28π | Sur'ah: 4.71π | 'Aql: 3.14π | Ṣabr: 9.42π | Taqwā: 9.42π | 'Aṣabiyyah: 9.42π",
                        3.14,
                        "Double-Linked Hijāzī Chainmail (Dir' Mudhā'afah) & White Badr Ostrich-Plume Crest (Weight: 3.14π)",
                        2.51,
                        "Twin Damascus Fūlādh Sabers (Sayf Al-Furqān) & Round Leather Daraqah Shield (Weight: 2.51π)",
                        "Mubārazah Champion Mastery & Anṣār Shield Wall",
                        "Crescent Damascus Sword Swipe (314° Cleave Arc + Golden Barakah Sparkles)",
                        "SWORD_SWIPE",
                        "Ḥamāsah & Bashāshah (Fearless Lion Valor Tempered with Hopeful Brotherhood)",
                        "Active Damascus Saber Parry & Unbreakable Ṣabr Stance (+62.8% Melee Mitigation)",
                        "Itqān: 6.28π | Iḥsān: 9.42π | Thabāt: 9.42π | Canon: Wells of Badr (624 CE / 2 AH) Opening Duel",
                        785, 138, 110, 1, 3.14
                ),
                new CharacterArchetypeProfile(
                        "CHAR-003-MAMLUK-LANCER",
                        "Baybars Al-Bunduqdārī (Elite Mamlūk Heavy Cavalry Lancer)",
                        "فارس المماليك المدرّع • كاسر التتار والصليبيين",
                        "Cavalry (Armored Mamālīk & Mutaharrikah Mobile Guard)",
                        "Era IV–VI: Ayyūbid/Mamlūk Citadel & Gunpowder Vanguard (Gilded Lamellar & Barded Warhorse)",
                        "Rose from a former steppe captive through the rigorous Furūsiyyah barracks of Cairo into a sovereign protector of the Ummah and rescuer of besieged citadels.",
                        "Will: Relentless A* Flanking Pursuit & Citadel Relief • Patronage: Endows Bīmāristāns & Waqf Horse Studs",
                        "PURSUE_A_STAR(Target=Enemy_Ranged_Or_Sorcerer, speed=6.28) -> ATTACK(Nearest_To_Caravan_Flank, until_hp_depleted) -> ORBIT(Besieged_Castle, r=6.28) -> BOLSTER(Militia)",
                        "High-Velocity A* Flanking Shock Cavalry, Feigned-Retreat (Karr wa Farr) Ambush Breaker & Pursuer",
                        "Mounted_Mamluk_Gallop_3D + Couching_Lance_Shockwave_Charge + Empowered_Golden_Steed_Aura",
                        6.28,
                        "Quwwah: 7.85π | Sur'ah: 6.28π | 'Aql: 4.71π | Ṣabr: 6.28π | Taqwā: 6.28π | 'Aṣabiyyah: 7.85π",
                        4.71,
                        "Crimson-Gold Jawshan Scale Mail & Full Steel Warhorse Chamfron Barding (Weight: 4.71π)",
                        3.14,
                        "Couched Khorasan Ash Lance (Rumḥ), Curved Kilij Saber & Bunduq Crossbow (Weight: 3.14π)",
                        "Furūsiyyah Heavy Charge & Karr wa Farr Tactical Encirclement",
                        "Thunderous Empowered Mamlūk Cavalry Charge (Line Trample + Sword Swipe Finisher)",
                        "CAVALRY_CHARGE",
                        "Haybah & Ḥamāsah (Thundering Sovereign Shock & Disciplined Chivalry)",
                        "Angled Barding Deflection & High-Speed Karr wa Farr Disengagement",
                        "Itqān: 7.85π | Iḥsān: 6.28π | Thabāt: 7.85π | Canon: 'Ayn Jālūt (1260 CE) & Ḥiṭṭīn (1187 CE)",
                        848, 163, 122, 2, 6.28
                ),
                new CharacterArchetypeProfile(
                        "CHAR-004-BIMARISTAN-HEALER",
                        "Rufaydah & Ibn Sīnā Al-Ṭabīb (Support Bīmāristān Field Healer)",
                        "طبيب البيمارستان الميداني • حامل الخلّ والماء والشفاء",
                        "Supports (Physicians, Water-Bearers & Rearguard Straggler Saviors)",
                        "Era I–V: Prophetic Field Tent of Rufaydah to Baghdad & Cairo Bīmāristān Guilds",
                        "Trained in clinical observation, sterile vinegar/alcohol wound washing, cotton gauze dressing, and compassionate care for the exhausted at the end of the caravan.",
                        "Will: Zero Stragglers Left Behind & Total Plague Prevention • Patronage: Sponsored by Waqf Medical Endowments",
                        "HEAL(Unit_Y_Lowest_HP, threshold=75.0%) -> DEFEND(Unit_XX_Caravan_Straggler, r=3.14) -> PURIFY(Poison_Cloud_Tile) -> ATTACK_NEAREST_TO(Unit_YY_Healee, until_hp_depleted)",
                        "Autonomous Rule-Driven Support Healer, Straggler Rescuer, Tahārah Hygiene Booster & Poison Neutralizer",
                        "Walking_8Dir_Stride + Floating_Emerald_Sparkle_Cast (Throws Vinegar-Rosewater Restorative Ampoules)",
                        4.71,
                        "Quwwah: 2.51π | Sur'ah: 4.71π | 'Aql: 9.42π | Ṣabr: 6.28π | Taqwā: 7.85π | 'Aṣabiyyah: 6.28π",
                        1.25,
                        "Sterile White Quṭn (Cotton) Tabard, Cordoban Medicine Satchel & Silver Astrolabe Pendant (Weight: 1.25π)",
                        0.94,
                        "Al-Zahrāwī Surgical Kit, Antiseptic Khall (Vinegar) & Crimson Rosewater Sprayer (Weight: 0.94π)",
                        "Ṭibb Al-Bīmāristān Triaging & Antiseptic Vinegar-Cotton Wound Restoration",
                        "Emerald Barakah Sparkle Heal Chain & Purifying Vinegar-Rosewater Mist",
                        "SPARKLES_AND_VINEGAR_MIST",
                        "Raḥmah & Sakīnah (Merciful Healing Levity, Warmth & Prophetic Compassion)",
                        "Ṭahārah Antiseptic Aura (Nullifies Poison Clouds & Restores +31.4 HP/tick to nearby allies)",
                        "Itqān: 9.42π | Iḥsān: 9.42π | Thabāt: 6.28π | Canon: Tent of Rufaydah al-Aslamiyyah & Al-Manṣūrī Bīmāristān",
                        565, 78, 88, 5, 3.77
                ),
                new CharacterArchetypeProfile(
                        "CHAR-005-INBIQ-ALCHEMIST",
                        "Jābir Al-Kīmiyā'ī (Alchemical Inbīq, Vinegar-Acid & Nafṭ Master)",
                        "عالم الكيمياء والإنبيق • مكرّر حامض الخلّ والنفط",
                        "Supports / Siege Specialist (Alchemical Distiller & Counter-Miasma Artificer)",
                        "Era III–VI: 'Abbāsid Kūfah/Baghdad Al-Kīmiyā' Lab to Mamlūk/Ottoman Arsenal",
                        "Mastered quantitative balance (Ilm al-Mīzān) and distillation in the Castle Alembic (Al-Inbīq), turning harvested vinegar into concentrated acid and crude seepage into Greek-fire Nafṭ.",
                        "Will: Scientific Discovery for the Ummah & Occult Demystification • Patronage: Head of the House of Alchemists",
                        "BOLSTER(Weapon_Damascus_Steel, buff=3.14) -> ATTACK(Clustered_Enemy_Formation, vfx=POISON_ACID_OR_NAFT_MISSILE) -> PURIFY(Syndication_Miasma) -> DEFEND(Castle_Lab)",
                        "AoE Alchemical Missile Artillerist, Vinegar-Acid Armor Dissolver & Brass Qumqum Seal Crafter",
                        "Walking_8Dir_Stride + Combat_Flask_Hurl_Arc (Glowing Alembic & Drifting Alchemical Cloud Emitter)",
                        4.71,
                        "Quwwah: 3.14π | Sur'ah: 3.77π | 'Aql: 9.42π | Ṣabr: 4.71π | Taqwā: 6.28π | 'Aṣabiyyah: 4.71π",
                        1.88,
                        "Fireproof Treated Cotton & Burnished Brass Apron over Lapis Scholar Robe (Weight: 1.88π)",
                        1.57,
                        "Pressurized Brass Nafṭ Siphon, Distilled Vinegar-Acid Ampoules & Mini-Qumqum Grenades (Weight: 1.57π)",
                        "Ilm Al-Mīzān Quantitative Alchemy & Alembics",
                        "Alchemical Nafṭ Missile Volley & Corrosive Vinegar-Acid Cloud",
                        "MISSILES_AND_CLOUDS",
                        "Ḥikmah (Measured Empirical Precision & Piercing Analytical Clarity)",
                        "Alkali-Vinegar Neutralizing Vapor Screen (Blocks Incoming Projectiles & Occult Hexes)",
                        "Itqān: 9.42π | Iḥsān: 7.85π | Thabāt: 6.28π | Canon: Jābir ibn Ḥayyān & Al-Rāzī Alembic Treatises",
                        596, 144, 84, 5, 3.14
                ),
                new CharacterArchetypeProfile(
                        "CHAR-006-QAWS-SNIPER",
                        "Sa'd Al-Rāmī (Composite Bow Sniper & Janissary Tüfekçi Marksman)",
                        "الرامي المتقن • حامي الثغور والجبل",
                        "Ranged (Archers, Crossbowmen & Elevation Overwatch Snipers)",
                        "Era I–VI: Mount Uḥud Archers' Hill to Mamlūk Crossbowmen & Ottoman Kemankeş/Tüfekçi",
                        "Veteran of the mountain passes who learned the sacred discipline of holding high ground and never abandoning the post until the Commander gives the word.",
                        "Will: Absolute Overwatch Discipline & Long-Range Interception • Patronage: Guild of Bowyers & Fletchers",
                        "HOLD(High_Elevation_Tile) -> ATTACK(Enemy_Approaching_Ally_YY, range=7, until_hp_depleted) -> DEFEND(Caravan_Flank) -> SKIRMISH_KITE(Min_Dist=3.14)",
                        "Long-Range Elevation Sniper, Anti-Sorcerer Marksman & Caravan Ambush Overwatch",
                        "Walking_8Dir_Stride + Kneeling_Thumb_Draw_Arrow_Volley (Fires Multi-Arrow Parabolic Showers)",
                        4.71,
                        "Quwwah: 4.71π | Sur'ah: 6.28π | 'Aql: 6.28π | Ṣabr: 6.28π | Taqwā: 6.28π | 'Aṣabiyyah: 6.28π",
                        1.57,
                        "Brigandine Leather-over-Cotton Vest, Brass Bracer & Ivory Thumb-Ring (Weight: 1.57π)",
                        1.25,
                        "Reflex Laminated Horn-Sinew Composite Bow (Qaws 'Arabī) & 60 Damascus Bodkin Arrows (Weight: 1.25π)",
                        "Sixty-Three-Cubit Thumb-Draw & Elevation Ballistics",
                        "Rain of 314 Bodkin Arrows (High-Arcing Volley + Piercing Criticals)",
                        "ARROWS",
                        "Sakīnah & Itqān (Breath-Controlled Stillness & Unerring Focus)",
                        "Karr wa Farr Skirmish Footwork & Crenellation Cover Bonus (+47.1% Ranged Evasion)",
                        "Itqān: 9.42π | Iḥsān: 7.85π | Thabāt: 7.85π | Canon: Sa'd ibn Abī Waqqāṣ ('Shoot, may my father and mother be your ransom!')",
                        534, 150, 75, 7, 4.08
                ),
                new CharacterArchetypeProfile(
                        "CHAR-007-MANJANIQ-SAPPER",
                        "Salmān & Orban Al-Manjanīqī (Siege Engineer, Trench Builder & Cannoneer)",
                        "مهندس الخندق والمنجنيق والمدافع السلطانية",
                        "Siege (Sappers, Trench Engineers, Trebuchet Crews & Bombard Cannoneers)",
                        "Era I–VI: Battle of the Trench (Al-Khandaq 627 CE) to Mamlūk Counterweight Manjanīq & 1453 Şahi Bombard",
                        "Brought foreign Persian engineering wisdom to Madīnah ('Salmān is one of us, Ahl al-Bayt'), digging the defensive Trench while the Prophet ﷺ broke the spark-flashing rock with glad tidings of Persia, Syria, and Yemen.",
                        "Will: Ingenious Fortification & Unstoppable Wall Breaching • Patronage: House of Siege Engineers & Foundrymen",
                        "BOLSTER(Castle_Walls_And_Towers) -> ATTACK(Enemy_Castle_Gate_Or_Tower, vfx=SIEGE_MISSILE, until_hp_depleted) -> HOLD(Trench_Line) -> DEFEND(Cannons)",
                        "Castle Siege Wall-Breacher, Tower Defense Constructor & Long-Range Bombardier",
                        "Walking_8Dir_Stride + Siege_Manjaniq_And_Bombard_Fire_Cycle (Massive Stone/Cannonball Missiles & Shockwaves)",
                        6.28,
                        "Quwwah: 6.28π | Sur'ah: 2.51π | 'Aql: 7.85π | Ṣabr: 7.85π | Taqwā: 6.28π | 'Aṣabiyyah: 6.28π",
                        3.77,
                        "Sapper's Heavy Iron Helmet, Padded Cotton Gambeson & Soaked Vinegar-Hide Fire Mantle (Weight: 3.77π)",
                        9.42,
                        "Counterweight Manjanīq Al-Maghribī, Sapper Pickaxe & Cast-Bronze Şahi Bombard (Weight: 9.42π)",
                        "Handasat Al-Ḥiṣār (Siege Mechanics, Mining & Ballistic Trajectory Math)",
                        "314-Pound Bombard & Trebuchet Barrage (Shatters Walls + AoE Ground Tremor)",
                        "MISSILES",
                        "Ḥikmah & Thabāt (Methodical Engineering Genius & Earth-Shaking Resolve)",
                        "Khandaq Trench Fortification & Vinegar-Soaked Hide Mantlet (-62.8% Siege/Fire Damage Taken)",
                        "Itqān: 9.42π | Iḥsān: 7.85π | Thabāt: 9.42π | Canon: Al-Khandaq (627 CE), Acre (1291 CE) & Constantinople (1453 CE)",
                        722, 188, 116, 8, 2.20
                ),
                new CharacterArchetypeProfile(
                        "CHAR-008-RIBAT-MILITIA",
                        "Al-Murābiṭ Al-Anṣārī (Ribāṭ Frontier Militia & Straggler Guardian)",
                        "المرابط الحارس للثغور ومؤخرة القافلة",
                        "Militia (Ribāṭ Garrison Infantry, Spear Wall & Caravan Rearguard)",
                        "Era I–VII: Medina Oasis Watchmen to Andalusian/Maghribī Ribāṭ Monks & Aḥdāth Town Guards",
                        "Common working artisan and farmer who volunteers nights at the frontier Ribāṭ so that caravan families, weary elders, and stragglers at the end of the caravan arrive safely home.",
                        "Will: Civic Suffrage, Neighborhood Solidarity & Rearguard Protection • Patronage: Guild of Artisans & Waqf Watchtowers",
                        "DEFEND(Caravan_Rearguard_Stragglers, r=3.14) -> GUARD_INTERCEPT(Healer_And_Merchant) -> ATTACK_NEAREST_TO(Protected_Ally_YY, until_hp_depleted) -> HOLD(Ribat_Tower)",
                        "Steadfast Spear-Wall Phalanx, Caravan Straggler Shield & Tower Defense Garrison",
                        "Walking_8Dir_Stride + Grounded_Spear_And_Shield_Phalanx_Thrust",
                        4.71,
                        "Quwwah: 4.71π | Sur'ah: 3.14π | 'Aql: 3.77π | Ṣabr: 9.42π | Taqwā: 7.85π | 'Aṣabiyyah: 7.85π",
                        3.14,
                        "Quilted Quṭn (Cotton) Kazaghand, Iron Nasal Helm & TallTāriqah Shield (Weight: 3.14π)",
                        2.20,
                        "Long Ash Pike (Rumḥ Ṭawīl), Broad Flanged Mace (Dabbūs) & Horn Signal (Weight: 2.20π)",
                        "Ribāṭ Vigilance & Anti-Cavalry Spear Brace",
                        "Interlocking Shield-Wall Bash & Rearguard Intercept Cleave",
                        "SWORD_SWIPE_AND_SPARKLES",
                        "Ṣabr & Amānah (Patient Civic Duty, Trustworthiness & Brotherhood)",
                        "Phalanx Interlock (+31.4% Defense per adjacent Militia/Muslim unit)",
                        "Itqān: 6.28π | Iḥsān: 7.85π | Thabāt: 9.42π | Canon: Frontier Ribāṭs of Monastir, Rabat, Córdoba & Alexandria",
                        754, 106, 135, 1, 2.82
                ),
                new CharacterArchetypeProfile(
                        "CHAR-009-CARAVAN-EXPLORER",
                        "Ibn Baṭṭūṭah & 'Abd al-Raḥmān Al-Tājir (Auxiliary Caravan Master, Explorer & Diplomat)",
                        "أمير القافلة والرحّالة والتاجر الأمين",
                        "Auxiliary (Caravan Masters, Map/Compass Traders, Explorers & Diplomatic Envoys)",
                        "Era I–VII: Quraishī/Medinan Suq Patron to Trans-Saharan, Silk Road & Aceh Caravan Amīr",
                        "Arrived in Madīnah with nothing, asked only 'Show me the market (Sūq)', and through spotless honesty, vinegar/cotton/horse arbitrage, and Suftajah banking built a fortune endowed entirely to the Ummah.",
                        "Will: Peaceful Market Expansion, Diplomatic Conversion & Uncovering Syndications • Patronage: Sponsors 700-Camel Charity Caravans",
                        "TRADE(Nearest_Bazaar_Or_Port_Faire) -> ORBIT(Neutral_Caravan, diplomatic_dawah=true) -> UNCOVER(Syndication_Node) -> BOLSTER(Castle_Treasury_Dinars)",
                        "Caravan Logistics Commander, Map/Compass Appraiser, Diplomatic Envoy to Rumored Kings & Syndication Uncoverer",
                        "Walking_8Dir_Camel_Caravan_Stride + Floating_Golden_Compass_And_Scroll_Projection",
                        4.71,
                        "Quwwah: 3.14π | Sur'ah: 5.34π | 'Aql: 9.42π | Ṣabr: 6.28π | Taqwā: 7.85π | 'Aṣabiyyah: 7.85π",
                        1.25,
                        "Indigo Tuareg/Maghribī Lithām Veil, Gold-Embroidered Ṭirāz Silk-Cotton Mantle (Weight: 1.25π)",
                        0.94,
                        "32-Point Brass Qiblah Compass, Al-Idrīsī World Map Scroll, Suftajah Ledger & Damascus Khanjar (Weight: 0.94π)",
                        "Fiqh Al-Tijārah (Honest Arbitrage, A* Oasis Pathfinding & Diplomatic Da'wah)",
                        "Treaty of Sulḥ & Caravan Absorption Decree (Converts Neutral/Exhausted Squads + Gold Sparkles)",
                        "SPARKLES",
                        "Bashāshah & Amānah (Radiant Hospitality, Trustworthy Dealings & Diplomatic Wit)",
                        "Amān Safe-Conduct Standard & Camel Wagon Barricade Ring",
                        "Itqān: 9.42π | Iḥsān: 9.42π | Thabāt: 6.28π | Canon: 'Abd al-Raḥmān ibn 'Awf, Ibn Baṭṭūṭah (120,000 km) & Hadhrami Traders",
                        628, 94, 94, 4, 5.34
                ),
                new CharacterArchetypeProfile(
                        "CHAR-010-OMANI-MARINER",
                        "Aḥmad ibn Mājid Al-Mu'allim (Auxiliary Omani/Yemeni Monsoon Navigator & Port Admiral)",
                        "أسد البحر ومعلم الملاحة الفلكية وموانئ عمان واليمن",
                        "Auxiliary / Ranged Naval (Monsoon Dhow Captains, Compass Navigators & Port Faire Masters)",
                        "Era III–VII: Sohar/Aden China-Trade Dhows to Ya'rubid Omani Gun-Flotillas (Muscat–Zanzibar)",
                        "Raised on the decks of stitched coconut-coir Sanbūq dhows between Muscat, Aden, Malabar, and Malacca, reading the 32 star-rhumbs and Kamāl finger-widths across the Indian Ocean.",
                        "Will: Open Sea Trade, Anti-Piracy Justice & Connecting Distant Kings • Patronage: House of Mariners & Port Faires",
                        "TRADE(Port_Faire_Node) -> ORBIT(Coastal_Sea_Lane, r=6.28) -> ATTACK(Pirate_Or_Syndicate_Fleet, vfx=BROADSIDES_AND_ARROWS) -> BOLSTER(Vinegar_Cotton_Tobacco_Cargo)",
                        "Maritime Monsoon Logistics Master, Port Faire Arbitrageur & Coastal Broadside Support",
                        "Walking_8Dir_Dhow_Captain_Stride + Combat_Swivel_Cannon_And_Khanjar_Slash",
                        5.34,
                        "Quwwah: 4.71π | Sur'ah: 6.28π | 'Aql: 7.85π | Ṣabr: 6.28π | Taqwā: 6.28π | 'Aṣabiyyah: 6.28π",
                        1.88,
                        "Omani Sa'īdī Turban, Salt-Resistant Yemeni Cotton Tunic & Silver-Woven Belt (Weight: 1.88π)",
                        2.51,
                        "Carved Rhino-Horn Omani Khanjar, Kamāl Star-Board & Dhow Bronze Swivel Culverin (Weight: 2.51π)",
                        "'Ilm Al-Baḥr (Sidereal 32-Rhumb Navigation & Monsoon Wind Mastery)",
                        "Monsoon Broadside Salvo & 32-Point Compass Precision Buff",
                        "MISSILES_AND_SPARKLES",
                        "Ḥikmah & Ḥamāsah (Seasoned Maritime Poise & Fearless Storm Mastery)",
                        "Weather-Gauge Tack & vinegar-washed scurvy-free hull hygiene",
                        "Itqān: 9.42π | Iḥsān: 7.85π | Thabāt: 7.85π | Canon: Aḥmad ibn Mājid (Kitāb al-Fawā'id 1490 CE) & Imām Sultān bin Sayf",
                        659, 132, 98, 6, 5.02
                ),
                new CharacterArchetypeProfile(
                        "CHAR-011-SYNDICATION-SORCERER",
                        "Kāhin Al-Jibt (Oppositional Warlock Syndication Sorcerer & Miasma Weaver)",
                        "كاهن الجبت والاحتكار • ناشر السموم والفرقة",
                        "Oppositional Syndication / Corrupt Warlock Cabal (Convertible or Sealable in Brass Qumqum)",
                        "All Eras: Shadowy Oligarchic Usury Cartels & The 7 Unsevered Chromatic Warlock Sanctums",
                        "Hoarded insular faction power and occult illusions to exploit frightened townsfolk with Ribā debt and fear of 'wolves at the door'—until confronted by Prophetic truth and Al-Kīmiyā' science.",
                        "Will: Insular Syndicate Control (Until Uncovered & Redeemed or Sealed in Brass Qumqum)",
                        "ORBIT(Syndication_Stronghold, r=3.14) -> ATTACK(Caravan_Stragglers, vfx=POISON_CLOUD) -> HOLD(Corrupt_Sanctum) -> YIELD_WHEN_UNCOVERED(Convert_Or_Qumqum_Seal)",
                        "Oppositional Ranged Hexer, Poison/Miasma Cloud Emitter & Guard of Uncovered Priory/Scientific Secrets",
                        "Floating_Dark_Miasma_Hover + Combat_Poison_Cloud_And_Shadow_Missile_Cast",
                        4.71,
                        "Quwwah: 3.14π | Sur'ah: 4.08π | 'Aql: 6.28π | Ṣabr: 3.14π | Taqwā: 0.00π (Pre-Redemption) | 'Aṣabiyyah: 3.14π",
                        1.57,
                        "Tarnished Mercury-Brocatelle Cloak & Lead Amulet Harness (Weight: 1.57π)",
                        1.88,
                        "Sulfur-Arsenic Fume Censer & Forged Debt Ledger Staff (Weight: 1.88π)",
                        "Sihr Al-Takhayyul (Illusion Craft & Hoarded Syndicate Monopoly)",
                        "Drifting Purple-Green Poison Miasma Cloud & Shadow Bolt",
                        "POISON_CLOUD_AND_MISSILES",
                        "wahm (Fear-Mongering Mirage — Shattered by Sakīnah & Vinegar/Rosewater Purification)",
                        "Mirage Veil (Dissolved immediately by Good Warlock Qumqum Beam or Diplomatic Uncovering)",
                        "Itqān: 4.71π | Iḥsān: 0.00π | Thabāt: 3.14π | Canon: Sūrah Ṭā-Hā 20:69–70 (Magicians who bowed in faith upon seeing truth)",
                        520, 128, 72, 5, 3.14
                ),
                new CharacterArchetypeProfile(
                        "CHAR-012-IMPERIAL-CATAPHRACT",
                        "Marzubān & Strategos (Oppositional Empire Frontier Commander / Prospective Convert)",
                        "مرزبان الإمبراطوريات المجاورة • محاور رسائل النبي ﷺ",
                        "Oppositional Empire Garrison / Rumored King's Envoy Guard",
                        "Era I–VI: Byzantine/Sassanid Cataphracts, Visigothic Counts & Frontier Castellans",
                        "Tasked with guarding old imperial borders against 'wolves at the door' while secretly marveling at the discipline, prayer, and justice of the incoming Muslim caravans.",
                        "Will: Testing the Muslims' Resolve via Sieges, Brawls & Envoys—Ready to Sign Sulḥ or Embrace Islam",
                        "HOLD(Imperial_Fortress_Gate) -> ATTACK(Vanguard_Approaching_Citadel, until_hp_depleted) -> OFFER_MEDIATION_OR_CAPITULATION(When_Castle_Order_And_Justice_High)",
                        "Heavy Castle Garrison Defender, Mubārazah Challenger & Diplomatic Capitulation Signatory",
                        "Mounted_Or_Foot_Heavy_Stride + Heavy_Broadsword_Swipe_And_Javelin_Cast",
                        5.65,
                        "Quwwah: 6.28π | Sur'ah: 3.77π | 'Aql: 5.34π | Ṣabr: 6.28π | Taqwā: 3.14π | 'Aṣabiyyah: 5.34π",
                        4.40,
                        "Imperial Clibanarius Scale Cuirass, Purple Cloak & Plumed Spangenhelm (Weight: 4.40π)",
                        3.14,
                        "Heavy Imperial Spatha/Kontos Lance & Weighted Plumbata Darts (Weight: 3.14π)",
                        "Imperial Castrametation & Frontier Siege Defense",
                        "Heavy Broadsword Cleave Swipe & Garrison Volley",
                        "SWORD_SWIPE_AND_ARROWS",
                        "Haybah (Imperial Formalism Yielding to Islamic 'Adl & Peace)",
                        "Testudo Shield Lock & Fortress Bastion Cover",
                        "Itqān: 6.28π | Iḥsān: 4.71π | Thabāt: 6.28π | Canon: Hurmuzān, George (Jarjah) at Yarmūk & Count Theodemir (Tudmīr) in Spain",
                        760, 134, 118, 2, 3.14
                )
        );
    }

    public static List<ThroneRoomDepartmentDossier> allSixThroneRoomDepartments() {
        return List.of(
                new ThroneRoomDepartmentDossier(
                        "DEPT-01-CAFETERIA",
                        "1. Lunch, Cafeteria & Prophetic Simāṭ Hospitality (Dār Al-Ḍiyāfah & Maṭbakh)",
                        "دار الضيافة وسماط القلعة • الخلّ والثريد والصوم",
                        "The Prophet ﷺ shared simple, blessed meals with the 313 and the Ahl al-Ṣuffah in radiant warmth and levity, praising vinegar ('Ni'ma al-idām al-khall' — 'What a blessed condiment is vinegar!'), dates, barley, olive oil, and Tharīd, while instituting voluntary and Ramadan fasting (Ṣawm) to build self-mastery.",
                        "Dictate Daily Lunch & Cafeteria Menu: (A) Blessed Vinegar (Khall), Olive Oil & Barley Bread (+31.4% Tahārah Gut Immunity & Poison Resistance), (B) Sovereign Tharīd & Honey Feast (+62.8% Stamina & Rearguard Morale), (C) Caravan Sawīq & Date Travel Rations (+31.4% Caravan March Speed), (D) Sunnah Suḥūr & Ifṭār Fasting Schedule (+3.14x Spiritual Focus & Good Warlock Barakah Rate).",
                        "Eliminates hunger grievances ('wolves at the door') among the Poor and Newly Arrived; binds Royals and Commoners at one table in Prophetic Brotherhood (Mu'ākhāh).",
                        "+(Active_Population × 0.314 × Meal_Quality_Pi) Barakah & Stamina/sec",
                        "Directly buffs unit Max HP, Stamina regeneration, Poison Cloud immunity, and prevents Caravan stragglers from falling behind during multi-day marches."
                ),
                new ThroneRoomDepartmentDossier(
                        "DEPT-02-BARRACKS",
                        "2. Barracks, Muster Yards & Manual 6-Mode Combat Command (Dīwān Al-Jund)",
                        "ديوان الجند والمعسكر • قيادة المعارك الستّ",
                        "From the muster of the 313 at Badr (with 2 horses and 70 camels shared in turns) to 'Umar's Dīwān al-Jund payroll stipends ('Aṭā') and the Mamlūk Furūsiyyah hippodromes.",
                        "Manually Dictate & Launch: (1) RPG Hero & Party Expedition, (2) Ribāṭ & Oasis Tower Defense (TD), (3) Field Team Deathmatch (TDM), (4) Mubārazah Champion Brawl, (5) Caravan Escort & Counter-Ambush, (6) Multi-Ring Castle Siege. Edit unit A* pathing, 3.14 stat weights, and Gambit rules ('unit X heals Y, defends xX, attacks nearest yY until HP depleted').",
                        "Channels fierce warrior wills (like Khālid and Ḥamzah) and foreign engineering experience (like Salmān al-Fārisī) into disciplined, non-oppressive chivalry.",
                        "+(Garrison_Count × 3.14 × Training_Tier) Military Readiness & Citadel Security/sec",
                        "Determines squad size, Initiative order, A* pursuit velocity, formation cohesion, and Tower Defense emplacement slots."
                ),
                new ThroneRoomDepartmentDossier(
                        "DEPT-03-SCIENCES",
                        "3. Sciences, Al-Kīmiyā' Lab & Engineering Academy (Bayt Al-Ḥikmah)",
                        "بيت الحكمة ودار الكيمياء والهندسة • مبدأ ٣.١٤",
                        "Rooted in the Qur'anic imperative to reflect on the Āyāt Kawniyyah (Cosmic Signs) and the Prophetic saying 'Seek knowledge', blossoming into Al-Khwārizmī's algebra, Al-Kāshī's 16-decimal π (3.1415926535897932), Jābir's alembic chemistry, and Al-Zahrāwī's surgery.",
                        "Dictate Scientific Focus: (A) 3.14 Pi Circular Geometry & Astrolabe Compasses (+31.4% A* Pathing & Ranged Accuracy), (B) Al-Inbīq Vinegar-Acid & Nafṭ Distillation (+31.4% Alchemical Missile & Purifying Cloud Power), (C) Damascus Fūlādh Crucible Metallurgy (+31.4% Sword Swipe & Armor Weight Efficiency), (D) Qanāt Hydraulics, Cotton Looms & Sewer Sanitation (+62.8% Population Growth & Disease Immunity).",
                        "Transforms uncovered Syndication secrets into public scientific advancements that elevate every artisan guild and farmer in the Ummah.",
                        "+(Illuminated_Tomes_67 × 3.14 × Lab_Slider_Pi) 'Ilm Science & Tech Multiplier/sec",
                        "Unlocks contemporary Era visual/weapon upgrades (Traction Trebuchet -> Counterweight Manjanīq -> Ottoman Şahi Bombard) and empowers unit weapons."
                ),
                new ThroneRoomDepartmentDossier(
                        "DEPT-04-RELIGIOSITY",
                        "4. Religiosity, Prophetic Order, Suffrage & Patronage Court (Al-Masjid & Al-Shūrā)",
                        "المسجد الجامع ومجلس الشورى والمظالم والمؤاخاة",
                        "The Prophet Muhammad ﷺ established the Mosque of Madīnah as the heart of prayer (Ṣalāh), joy, consultation (Shūrā), brotherhood (Mu'ākhāh), diplomatic audiences with foreign kings, and immediate redress of grievances (Maẓālim).",
                        "Dictate Moral & Civic Order: (A) Collect Suffrage Petitions (resolve Common, Royal, Poor, Youth, Elder & Caravan Straggler causes), (B) Pair Patrons & Newcomers in Mu'ākhāh Brotherhood, (C) Proclaim 'Aslim Taslam — Peace & Surrender to God' Epistles to Surrounding Empires, (D) Enforce Ṭahārah Hygiene & Anti-Ribā Hisbah Market Justice.",
                        "Converts insular 'hoarded suffrage' syndications and exhausted敌 caravans into joyful, loyal members of the Ummah through lived justice ('Adl).",
                        "+(Suffrage_Consent_Pct × Patronage_Bonds × 3.14) Spiritual Hegemony & Conversion Aura/sec",
                        "Grants Golden Empowered Tawḥīd Auras in combat, increases post-battle Caravan Conversion/Absorption rates, and powers the Good Warlock's Qumqum seals."
                ),
                new ThroneRoomDepartmentDossier(
                        "DEPT-05-GUILD-BAZAAR-BANK",
                        "5. Guild Houses, Bayt al-Māl Banking, Bazaar & Port Faires (Al-Sūq wa Al-Bandar)",
                        "بيوت الأصناف وبيت المال وسوق القوافل والموانئ",
                        "Establishing the tax-free prophetic market of Madīnah, expanding into the gold Dīnār / silver Dirham monetary standard, Suftajah promissory notes, Waqf perpetual trusts, and Omani/Yemeni monsoon port faires.",
                        "Dictate Economic & Caravan Dispatch: (A) Harvest & Trade Vinegar, Cotton, Tobacco/Coffee, Damascus Steel, Maps & 32-Point Compasses, (B) Underwrite Caravans via Muḍārabah & Suftajah Banking, (C) Delegate Merchants, Healers, Alchemists, Sappers, Cannoneers, Snipers, Militia, Mamlūks, Explorers & Warriors into Caravan Formations, (D) Trade or Absorb AI Procedural Caravans.",
                        "Provides honest livelihood for every trade skill (Ḥirfah), funds Waqf hospitals and libraries, and starves corrupt Ribā syndications.",
                        "+(Active_Caravans × Port_Faires × 3.14) Gold Dīnārs, Silver Dirhams & Commodity Flow/sec",
                        "Finances Castle fortifications, Tower Defense emplacements, elite Mamlūk cavalry barding, and diplomatic gifts to Rumored Kings from Afar."
                ),
                new ThroneRoomDepartmentDossier(
                        "DEPT-06-CASTLE-LIBRARY-67",
                        "6. The Grand Castle Library of All 67 Abstracted Knowledge Bases (Khizānat Al-Kutub)",
                        "خزانة الكتب السلطانية • تجريد البوابات السبع والستين",
                        "Synthesizing the prophetic preservation of revelation with the great libraries of Baghdad (Bayt al-Ḥikmah), Córdoba (400,000 volumes of Al-Ḥakam II), Cairo (Dār al-'Ilm), and Timbuktu (Sankore).",
                        "Inspect, Read & Activate Any of the 67 Knowledge Base Tomes inside the Single Castle: Each Tome abstracts one of the 67 HTML Portals into (1) a Canonical Story & Parable, (2) a Prudential Islamic Statecraft Rule, (3) an Injectable Combat/Economy Data Cartridge, and (4) a Permanent 3.14x Incremental Multiplier for the Good Warlock.",
                        "Preserves the collective memory, suffrage lessons, alchemical formulas, and historical pinnacles/recessions of the entire civilization in one living sanctuary.",
                        "+(Studied_Tomes_Count × 3.14²) Omniscient Wisdom & Global All-Stat Multiplier/sec",
                        "Allows 1-click injection of any of the 67 Portals' realms, Warlock orders, commodities, or historical battles directly into the 2.5D Tactical Grid."
                )
        );
    }

    public static List<CommodityAndStrongholdDutyDossier> allEightCanonicalCommoditiesAndDuties() {
        return List.of(
                new CommodityAndStrongholdDutyDossier(
                        "COMM-01-VINEGAR",
                        "Vinegar Harvesting & Acetic Acid Distillation (Al-Khall & Ḥamḍ Al-Khall)",
                        "الخَلّ وحامض الخلّ • Prophetic Hadith: 'Ni'ma al-idām al-khall' (Sahih Muslim 2052)",
                        "Madīnah Date Groves, Córdoba & Seville Vineyards (Spain), Damascus Orchards, Kūfah Alchemical Labs",
                        "Date & Grape Must -> Aerobic Fermentation in Clay Jars -> Culinary & Medical Vinegar (Khall) -> Jābir ibn Ḥayyān's Al-Inbīq Alembic Fractional Distillation -> Concentrated Acetic Acid (Ḥamḍ Al-Khall) & Lead/Copper Acetate Pigments",
                        "Guild of Vinegar Fermenters & Alembic Chemists (Ṣunnā' Al-Khall wa Al-Kīmiyā')",
                        "Islam canonically elevated vinegar from a humble household condiment blessed by the Prophet ﷺ into the first purified mineral-organic acid solvent in human history (distilled by Jābir ibn Ḥayyān in 8th-century Kūfah), used for sterile Bīmāristān wound irrigation, plague-warding hygiene, quenching heated siege rocks, and cooling caravan water!",
                        "Cafeteria: +31.4% Stamina & Gut Immunity | Combat VFX: Purifying Vinegar-Rosewater Mist (dissolves enemy Poison Clouds & heals allies) | Siege: Acidic mortar-weakener for Sappers.",
                        3.14
                ),
                new CommodityAndStrongholdDutyDossier(
                        "COMM-02-COTTON",
                        "Cotton Agronomy, Spinning & Royal Ṭirāz Weaving (Al-Quṭn -> Algodón -> Cotton)",
                        "القُطْن والطِّراز • Arabic 'Al-Quṭn' gave birth to Spanish 'Algodón', French 'Coton' & English 'Cotton'",
                        "Merv & Bukhara (Khorasan), Egyptian Delta, Valencia & Seville (Al-Andalus/Spain), Zabīd (Yemen), Gujarat/Sindh",
                        "Irrigated Qanāt Cotton Fields -> Mechanical Cotton Ginning (Charkha/Dawlab) -> Combed Yarn -> Ṭirāz State Textile Workshops -> White Iḥrām, Quilted Kazaghand Armor Padding, Lateen Dhow Sails, Rag Paper (Kāghad) & Sterile Surgical Gauze",
                        "Guild of Cotton Agronomists, Spinners & Ṭirāz Weavers (Al-Qaṭṭānūn wa Dār Al-Ṭirāz)",
                        "Islamic agronomists (Ibn Bassāl & Ibn al-'Awwām in Spain) revolutionized cotton cultivation with summer irrigation, introducing cotton agriculture, padded armor, cotton rag-paper for libraries, and lightweight breathable modesty garments across the Mediterranean and Europe!",
                        "Barracks Armor: Quilted Cotton Gambeson reduces Armor Weight by -1.57π while absorbing arrow shock | Library: Produces Rag Paper for the 67 Tomes | Port Faire: High-margin export to Europe & Africa.",
                        6.28
                ),
                new CommodityAndStrongholdDutyDossier(
                        "COMM-03-TOBACCO-BOTANICALS",
                        "Tobacco, Yemeni Coffee & Aromatic Incense Sourcing (Al-Ṭabgh, Al-Qahwah & Al-Lubān)",
                        "التَّبْغ والقَهْوَة واللُّبان • Levantine Latakia, Yenidje, Yemeni Mocha & Dhofari Frankincense",
                        "Mocha & Aden (Yemen), Dhofar & Sohar (Oman), Latakia & Aleppo (Syria), Salonika/Kavala, Aceh (Sumatra)",
                        "Terraced Mountain & Coastal Botanical Estates -> Sun-Curing & Wood-Smoke Fermentation -> Graded Aromatic Leaves, Roasted Mocha Beans & Crystallized Boswellia Resins -> Sealed Port Faire Chests & Caravan Hospices",
                        "Guild of Botanical Curers, Spice Factors & Port Faire Brokers (Tujjār Al-Qahwah wa Al-Ṭabgh wa Al-Ṭīb)",
                        "From ancient Yemeni/Omani frankincense trails and 15th-century Sufi coffee (Qahwah) circles in Zabīd and Mocha to 16th–17th century Ottoman/Safavid botanical agronomy, Muslim port faires mastered the curing, grading, taxation, and global maritime distribution of aromatic leaf, coffee, and incense crops!",
                        "Diplomacy & Port Faires: Premier high-value trade good for Rumored Kings & Caravan arbitrage (+9.42π Dīnār profit) | Cafeteria/Camp: Boosts night-watch alertness & Caravan Overwatch range.",
                        9.42
                ),
                new CommodityAndStrongholdDutyDossier(
                        "COMM-04-DAMASCUS-STEEL",
                        "Damascus Crucible Steel & Furūsiyyah Weapon Smithing (Al-Fūlādh Al-Dimashqī)",
                        "الفُولاذ الدِّمَشْقي والسُّيوف المهنَّدة • Carbon-Nanotube Wootz Crucible Metallurgy",
                        "Damascus (Syria), Toledo (Islamic Spain), Isfahan (Persia), Merv, Lahore",
                        "High-Carbon Iron Ore + Vanadium Trace Elements + Plant Carbon in Sealed Clay Crucibles -> Controlled Slow Cooling & Thermal Cycling -> Watered 'Firind' Damascene Ingots -> Sayf Sabers, Lance Tips, Mail Rings & Bronze-Steel Bombard Barrels",
                        "Guild of Crucible Metallurgists & Bladesmiths (Al-Suyūfiyyūn wa Ṣunnā' Al-Fūlādh)",
                        "Tested by Al-Kindi ('On Swords') and Al-Bīrūnī, Islamic metallurgists perfected ultra-high-carbon crucible steel (transferred to Toledo in Islamic Spain), creating blades that held a razor edge while flexing without shattering!",
                        "Combat VFX: Unlocks Glowing Crescent Damascus Sword Swipes (+31.4% Armor Penetration & Cleave Radius) and Barded Mamlūk Cavalry Lances.",
                        12.56
                ),
                new CommodityAndStrongholdDutyDossier(
                        "COMM-05-MAPS-AND-COMPASSES",
                        "32-Point Brass Qiblah Compasses, Astrolabes & World Maps (Al-بوصلة والإسطرلاب والخرائط)",
                        "دائرة الأخنان وطاسة القبلة والإسطرلاب • Al-Idrīsī, Al-Bīrūnī, Aḥmad ibn Mājid & Pīrī Reis",
                        "Baghdad, Córdoba & Toledo (Spain), Cairo, Damascus, Sohar & Muscat (Oman), Aden & Ta'izz (Yemen), Istanbul",
                        "Cast Brass Alloy -> Precision Degree & Abjad Engraving -> Magnetized Steel Fish Needle + 32 Sidereal Star-Rhumb Petals + Geodesic Qiblah Projection -> Illuminated Vellum World Atlases (Masālik wa Mamālik)",
                        "Guild of Astrolabists, Cartographers & Mu'allim Navigators (Al-Asṭurlābiyyūn wa Al-Jughrāfiyyūn)",
                        "Muslim astronomers and navigators united spherical trigonometry (Law of Sines/Tangent) with magnetic needles and 32-point star roses so that every traveler could simultaneously find the Qiblah for prayer and chart transcontinental caravan and ocean routes!",
                        "Caravan & A* Engine: Reduces A* terrain movement cost by -31.4%, reveals hidden Syndication nodes & Oasis wells on the 2.5D grid, and unlocks Maritime Port Faires.",
                        15.70
                ),
                new CommodityAndStrongholdDutyDossier(
                        "COMM-06-ALCHEMICAL-INBIQ-WARES",
                        "Alchemical Rosewater, Alkali Soap (Ṣābūn), Nafṭ & Brass Qumqums (الإنبيق والصابون والنفط والقمقم)",
                        "ماء الورد وصابون الغار والنفط والقمقم السليماني",
                        "Jur / Shiraz (Persia), Damascus & Aleppo (Syria), Fez (Morocco), Kūfah & Baghdad (Iraq)",
                        "Crimson Damascus Roses + Olive/Laurel Oil + Salsola Alkali Ash + Naphtha Seepage + Hammered Brass -> Steam Distillation & Saponification -> Hard Antiseptic Soap (Al-Ṣābūn), Rosewater Elixirs, Incendiary Nafṭ & Sealed Solomonic Qumqum Vessels",
                        "Guild of Alchemists, Perfumers & Qumqum Braziers (Al-'Aṭṭārūn wa Al-Naqqāshūn)",
                        "Islamic chemists invented hard olive-laurel soap (Al-Ṣābūn -> French Savon), steam-distilled rosewater, waterproof incendiary Nafṭ siphons, and precision brass containment vessels!",
                        "Combat VFX: Powers Alchemical Missiles, Purifying Rosewater Sparkles, and the Good Warlock's Brass Qumqum Containment Seals against the 7 Warlock Realms.",
                        18.84
                ),
                new CommodityAndStrongholdDutyDossier(
                        "COMM-07-CORDOBAN-LEATHER-OLIVE-SUGAR",
                        "Cordoban Gilded Leather (Guadamecil), Olive Oil & Refined Sugar (الأديم القرطبي والزيت والسُّكَّر)",
                        "الأديم القرطبي والزَّيْتون والسُّكَّر • Arabic 'Al-Sukkar' -> Sugar; 'Al-Zayt' -> Spanish Aceite",
                        "Córdoba, Granada & Malaga (Islamic Spain), Kairouan (Tunisia), Khuzestan, Damascus, Sicily",
                        "Al-Andalus Olive Groves & Sugar Cane Mills + Alum-Tanned Goat/Horse Hides -> Silver/Gold-Leaf Embossed Cordoban Leather, Cold-Pressed Blessed Olive Oil & Crystallized Sugar Loaves (Qand -> Candy)",
                        "Guild of Cordoban Tanners, Oil Pressers & Sugar Refiners (Al-Dabbāghūn wa Al-'Aṣṣārūn)",
                        "In Islamic Spain (Al-Andalus), Muslim artisans created 'Cordovan' leather, automated water-powered sugar mills, and hydraulic olive presses that became the gold standard of European luxury and nutrition!",
                        "Barracks & Caravan: Equips ultra-lightweight Cordoban leather saddles/quivers (+31.4% Cavalry & Archer Speed) and high-energy sugar/olive travel rations.",
                        9.42
                ),
                new CommodityAndStrongholdDutyDossier(
                        "COMM-08-QANAT-HYDRAULICS-PAPER",
                        "Qanāt Aqueducts, Noria Waterwheels & Samarkand Rag Paper (القنوات والنواعير وكاغد سمرقند)",
                        "القَنَوات والنَّواعير والكاغَد • Subterranean Gravity Aqueducts, Sewer Sanitation & Paper Mills",
                        "Samarkand, Baghdad, Hama (Syria), Valencia & Granada (Al-Andalus/Spain), Fez, Isfahan, Jakarta/Aceh",
                        "Mountain Aquifer Mother-Well -> Gently Sloped Underground Qanāt Channels + Giant Wooden Noria (Al-Nā'ūrah) Wheels -> Pressurized Hammām Bathhouses, Latrine Sewers, Rose Gardens & Water-Powered Paper Pulp Hammers",
                        "Guild of Hydraulic Engineers & Paper-Makers (Muhandisū Al-Miyah wa Al-Warrāqūn)",
                        "Following the 751 CE Battle of Talas, Muslims combined flax/cotton rag paper-making with Roman-Persian Qanāt and Noria hydraulic engineering—creating clean running water, underground sewage systems, and affordable books from Samarkand to Spain!",
                        "Castle Management: Multiplies Castle Population capacity by 3.14x, eliminates urban disease, and accelerates 67-Tome Library copying.",
                        12.56
                )
        );
    }

    public static List<RumoredKingAndSyndicationDossier> allEightRumoredKingsAndSyndications() {
        return List.of(
                new RumoredKingAndSyndicationDossier(
                        "KING-01-NAJASHI-ABYSSINIA",
                        "Ashama ibn Abjar (The Righteous Najāshī of Abyssinia / Ḥabashah)",
                        "Axum & The Red Sea Coast (Southern Vector)",
                        "Era I (615–630 CE) • Golden Lion & Emerald Sanctuary Banner",
                        "Heard of the persecuted Muslims in Mecca; wept until his beard was wet upon hearing Sūrah Maryam recited by Ja'far ibn Abī Ṭālib, drew a line in the sand declaring 'Not even for a mountain of gold will I surrender you', and sent gifts and safe passage back to the Prophet ﷺ.",
                        "The Red Sea Slave-Raider & Monopoly Syndicate (Al-Qarāṣinah)",
                        "1. 'Wolves at the Door' Grievance + 2. Insular Maritime Suffrage",
                        "Coastal fishermen and islanders were preyed upon by ruthless Red Sea debt-slavers and pirates who cut off grain and vinegar shipments.",
                        "Priory Discovery #1: The Abyssinian Alabaster Sanctuary & Red Sea Kamāl Star-Chart (+3.14x Maritime Trade & Sanctuary Aura).",
                        "Peaceful Embrace & Eternal Brotherhood: The Najāshī embraces Islam in his heart; the Prophet ﷺ prays Salāt al-Ghā'ib for him, and Red Sea ports open permanently to your Dhow Caravans."
                ),
                new RumoredKingAndSyndicationDossier(
                        "KING-02-JULANDA-OMAN",
                        "Jayfar & 'Abd, Sons of Al-Julandā (The Dual Kings of Oman / Mazūn)",
                        "Sohar, Muscat & Nizwā (South-Eastern Indian Ocean Vector)",
                        "Era I (630 CE / 8 AH) • Crimson Banner of Mazūn & Silver Khanjar",
                        "Received Envoy 'Amr ibn al-'Āṣ bearing the Prophetic Epistle sealed with 'Muḥammad Rasūl Allāh'; marveled that the Prophet ﷺ demanded no imperial tribute—only that charity (Zakah) be taken from their rich and returned directly to their own poor!",
                        "The Hormuz Pearl-Tax & Persian Garrison Syndicate",
                        "1. Insular Hoarded Suffrage (Local Mariners Taxed by Foreign Satraps)",
                        "Omani pearl divers, frankincense gatherers, and shipbuilders held their guild councils in secret because foreign customs syndicates confiscated 50% of their catch.",
                        "Scientific Advancement #1: The 32-Point Sidereal Compass Rose (Dā'irat Al-Akhnān) & Stitched Sanbūq Dhow Hulls.",
                        "Voluntary Peaceful Embrace: Oman enters Islam without a single sword drawn, becoming the naval vanguard that sails to Sindh, Zanzibar, Malabar, and Nusantara!"
                ),
                new RumoredKingAndSyndicationDossier(
                        "KING-03-MUQAWQIS-EGYPT",
                        "Al-Muqawqis (Patriarch & Viceroy of Alexandria & Miṣr / Egypt)",
                        "Alexandria, Memphis/Fustat & The Nile Delta (Western Vector)",
                        "Era I–II (628–641 CE) • Sapphire Nile & Coptic Gold Cross Banner",
                        "Read the Prophet's letter with deep respect, placed the parchment in an ivory casket, and sent gifts of levity and honor to Madīnah: fine white Egyptian Quṭn (cotton/linen) garments, honey of Benha, glass goblets, the white mule Duldul, and a court physician (whom the Prophet ﷺ thanked, saying 'We are a people who do not eat until we are hungry, and when we eat, we do not eat to excess!').",
                        "The Byzantine Grain-Monopoly & Inquisition Syndicate",
                        "2. 'Wolves at the Door' Grievance (Heavy Imperial Taxation & Religious Persecution of Native Copts)",
                        "Egyptian fellaheen farmers and Coptic artisans were crushed under imperial grain requisitions and ecclesiastical persecution.",
                        "Scientific Advancement #2: Nile Nilometer (Miqyās al-Nīl) Agronomy, Alexandrian Alembic Glassware & Cotton Textile Looms.",
                        "Treaty of Fustat & Liberation: 'Amr ibn al-'Āṣ guarantees religious freedom, low Kharaj tax, and property safety; Egypt becomes the granary and cotton powerhouse of the Ummah."
                ),
                new RumoredKingAndSyndicationDossier(
                        "KING-04-HERACLIUS-BYZANTIUM",
                        "Heraclius (Qayṣar Al-Rūm / Emperor of Byzantium at Jerusalem & Damascus)",
                        "Damascus, Jerusalem (Al-Quds), Antioch & Constantinople (Northern Vector)",
                        "Era I–VI (628–1453 CE) • Imperial Tyrian Purple & Double-Headed Golden Eagle",
                        "Summoned Abū Sufyān's trade caravan in Jerusalem to question him about the Prophet ﷺ: 'Does he ever lie? Does he break covenants? Do the weak follow him? Does anyone leave his religion out of displeasure?' Upon hearing the answers, Heraclius proclaimed: 'If what you say is true, he will soon possess the ground beneath my two feet!'",
                        "The Ghassānid-Byzantine Frontier Warlord & Warlock Order #3 Cabal",
                        "3. Priory Discovery + 4. Frontier Siege Test (Yarmūk, Jerusalem & Constantinople)",
                        "Imperial border magnates feared losing their military fiefs, while Jerusalem's citizens sought a ruler matching the prophecy of a humble leader arriving in a patched cloak.",
                        "Priory Discovery #2: The Covenant of 'Umar at Jerusalem (Al-Quds) & Damascus Crucible Steel Forges.",
                        "From Yarmūk & Patriarch Sophronius's peaceful handover of Jerusalem's keys to 'Umar (637 CE) all the way to Sultan Mehmed II's 1453 fulfillment of the Prophetic Hadith at Constantinople!"
                ),
                new RumoredKingAndSyndicationDossier(
                        "KING-05-TUDMIR-SPAIN-ANDALUS",
                        "Count Theodemir (Tudmīr of Orihuela) & the Peoples of Hispania (Al-Andalus / Spain)",
                        "Gibraltar, Córdoba, Seville, Toledo, Orihuela & Granada (Far Western Vector)",
                        "Era II–V (711–1492 CE) • Crimson-and-Gold Castle & Emerald Umayyad Falcon Banner",
                        "When Ṭāriq ibn Ziyād crossed the Strait of Gibraltar in 711 CE with 7,000 men and Mūsā ibn Nuṣayr followed, Visigothic nobles like Count Theodemir (Tudmīr) and oppressed Iberian townspeople and Jewish communities discovered that the Muslims offered unheard-of covenantal peace, low taxes, and shared governance.",
                        "The Visigothic Oligarchic Latifundia & Warlock Order #5 Cabal",
                        "1. Insular Hoarded Suffrage + 2. 'Wolves at the Door' Serfdom Grievance + 4. Scientific Synthesis",
                        "Iberian peasants, artisans, and religious minorities suffered under feudal serfdom and forced conversions before the arrival of the Muslim caravans and garrisons.",
                        "Scientific & Priory Discovery #3: The Stronghold of Al-Andalus (Córdoba's 400,000-Book Library, Streetlights, Guadamecil Leather, Vinegar/Olive Estates, Al-Zahrāwī Surgery & Alhambra Zellij).",
                        "The Treaty of Tudmīr (713 CE) & Birth of Islamic Spain: A single expedition transforms Iberia into a 780-year beacon of science, architecture, and Convivencia!"
                ),
                new RumoredKingAndSyndicationDossier(
                        "KING-06-YAZdeGERD-HURMUZAN-PERSIA",
                        "Salmān's Homeland, Hurmuzān of Ahwāz & the Scholars of Persia (Fāris & Khorasan)",
                        "Ctesiphon (Al-Madā'in), Isfahan, Nishapur, Merv & Samarkand (Eastern Vector)",
                        "Era I–III (636–850 CE) • Derafsh Kaviani Gold-Purple Star & Abbasid Black-Gold Standard",
                        "Though Khosrow II tore up the Prophetic letter, Persian seekers of truth like Salmān al-Fārisī, governor Bādhān in Yemen, and later Commander Hurmuzān (who became a trusted advisor in Madīnah after speaking with 'Umar) recognized that Islam abolished caste barriers and honored Persian wisdom.",
                        "The Magian Caste-Tax & Warlock Order #2 Bābil Cabal",
                        "2. 'Wolves at the Door' Rigid Caste Grievance + 4. Scientific Advancement",
                        "Common Persian artisans, farmers, and scholars were barred from social mobility under the rigid four-tier imperial caste system and exhausted by endless dynastic wars.",
                        "Scientific Advancement #4: Subterranean Qanāt Aqueducts, Bīmāristān Teaching Hospitals (Gundeshapur -> Baghdad), Sibawayh's Grammar & Al-Khwārizmī's Algebra.",
                        "From Qādisiyyah (636 CE) to the Persian-Arab synthesis that built Baghdad's Bayt al-Ḥikmah, Bukhara, and Samarkand!"
                ),
                new RumoredKingAndSyndicationDossier(
                        "KING-07-CHERA-PERUMAL-NUSANTARA",
                        "Cheraman Perumal (Tajuddin of Malabar) & Sultan Malik al-Ṣāliḥ of Samudera Pasai (Aceh)",
                        "Cranganore (Kerala), Malacca, Aceh & Java (Far South-Eastern Maritime Vector)",
                        "Era I–VI (629–1600 CE) • Emerald Crescent, Golden Kris & Spice Dhow Banner",
                        "Legend and chronicle record the Chera King of Malabar witnessing the splitting of the moon, journeying toward Arabia to meet the Prophet ﷺ, and sending letters with Malik ibn Dīnār to build the Cheraman Juma Mosque (629 CE)—followed by peaceful Omani/Yemeni/Gujarati merchant dhows bringing Islam to Aceh and Nusantara.",
                        "The Strait Choke-Point Pirate & Tribute Syndicate",
                        "1. Insular Port Suffrage + 3. Priory Botanical Discovery",
                        "Island spice growers and coastal fishermen faced maritime extortion in the Strait of Malacca until Muslim port sultanates established fair 'Ushr customs and maritime law (Undang-Undang Laut Melaka).",
                        "Priory & Scientific Discovery #5: Nusantara Botanical Pharmacopoeia (Clove, Nutmeg, Camphor, Tobacco/Benzoin), Wali Songo Community Pedagogy & Monsoon Hydrography.",
                        "100% Peaceful Maritime & Sufi Embrace: Creates the largest Muslim population zone on Earth without a single invading foreign army!"
                ),
                new RumoredKingAndSyndicationDossier(
                        "KING-08-BERKE-MANSA-SOKOTO",
                        "King Almış of Volga Bulgaria, Berke Khan of the Golden Horde & Mansa Musa / Usman dan Fodio",
                        "Bolgar/Kazan (North) & Timbuktu/Kano/Sokoto (West-South Saharan Vector)",
                        "Era III–VII (922–1804 CE) • Golden Tamga Crescent & White-Green Sokoto Flag",
                        "King Almış wrote to Baghdad in 922 CE requesting scholars, builders, and physicians (Ibn Faḍlān's mission) to help his northern kingdom; in 1260 CE, Mongol Prince Berke Khan embraced Islam after meeting a Sufi caravan in Bukhara and allied with Mamlūk Cairo to save the Ummah after the fall of Baghdad!",
                        "The Steppe Raider & Trans-Saharan Corrupt Tax Syndicate (Warlock Orders #6 & #7)",
                        "2. 'Wolves at the Door' Existential Shock + 3. Negentropic Priory Rebirth",
                        "After the 1258 shock of Baghdad and corrupt Hausa/Steppe warlord taxes, commoners and nomads hungered for moral law, literacy, and safe caravan roads.",
                        "Priory Discovery #6 & #7: The Solomonic Brass Qumqum Containment Vault, Sankore University Manuscripts & Nana Asma'u's Yan Taru Women's Education Network.",
                        "Miraculous Rebirth (Al-Inbi'āth): The conquerors themselves surrender to God in peace, and the 7th Emerald Priory Realm is sealed in righteous equilibrium!"
                )
        );
    }

    public static List<PolyglotStorageFormatDossier> allTwelvePolyglotStorageFormats() {
        return List.of(
                new PolyglotStorageFormatDossier(
                        "FMT-01-JSON",
                        "1. JSON (Hierarchical Game State & 11-Vector Character Package)",
                        ".json",
                        "Nested Document Object Tree",
                        "Stores full Single Castle state, 67 Library Tomes, and 1-Profile-1-Character objects with all 11 procedural combat vectors rounded to 3.14.",
                        "{\"profileId\":\"CHAR-001-GOOD-WARLOCK\",\"statWeightPi\":9.42,\"armorWeightPi\":1.57,\"weaponWeightPi\":3.14,\"commands\":\"ORBIT->BOLSTER->HEAL->SEAL_QUMQUM\"}"
                ),
                new PolyglotStorageFormatDossier(
                        "FMT-02-JSONL",
                        "2. JSONL / NDJSON (Newline-Delimited Streaming Combat & Caravan Event Log)",
                        ".jsonl",
                        "Append-Only Streaming Event Records",
                        "Logs every tick of 11-vector combat weighing, A* path steps, VFX emissions (Sparkles, Arrows, Sword Swipes), and Caravan trades one JSON object per line.",
                        "{\"tick\":314,\"actor\":\"CHAR-003-MAMLUK-LANCER\",\"target\":\"CHAR-011-SYNDICATION-SORCERER\",\"vfx\":\"CAVALRY_CHARGE\",\"dmg\":218,\"winProbPct\":87.4}"
                ),
                new PolyglotStorageFormatDossier(
                        "FMT-03-CSV",
                        "3. CSV (Comma-Separated Relational Matrix for 313+ Units & Commodities)",
                        ".csv",
                        "2D Tabular Spreadsheet Matrix",
                        "Stores every character profile's 27 columns (ID, Name, Archetype, 11 Combat Vectors, HP, Atk, Def, Range, Speed) for instant Excel/Pandas editing.",
                        "profileId,characterName,archetypeClass,statWeightPi,armorWeightPi,weaponWeightPi,skillTone,vfxType\nCHAR-001-GOOD-WARLOCK,Al-Hakim Zakeem,Good Warlock,9.42,1.57,3.14,Sakinah,SPARKLES_AND_MISSILES"
                ),
                new PolyglotStorageFormatDossier(
                        "FMT-04-TSV",
                        "4. TSV (Tab-Separated High-Density Data Table)",
                        ".tsv",
                        "Tab-Delimited POSIX Pipeline Table",
                        "Enables zero-quote POSIX awk/sed/cut processing of unit inventories, Vinegar/Cotton/Tobacco supply chains, and Gambit strings containing commas.",
                        "CHAR-004-BIMARISTAN-HEALER\tRufaydah & Ibn Sina\tSupports\t4.71\t1.25\t0.94\tHEAL(Y)->DEFEND(xX)->ATTACK_NEAREST(yY)"
                ),
                new PolyglotStorageFormatDossier(
                        "FMT-05-SQL",
                        "5. SQL Relational DDL & DML (CREATE TABLE + INSERT INTO Script)",
                        ".sql",
                        "Normalized Relational Database Schema",
                        "Generates executable SQL tables (`character_profiles_314`, `throne_room_dictates`, `commodities_8`, `library_tomes_67`, `combat_clash_ledger`) with primary keys and CHECK(stat_weight_pi >= 0) constraints.",
                        "CREATE TABLE character_profiles_314 (profile_id VARCHAR(32) PRIMARY KEY, stat_weight_pi DECIMAL(6,2), armor_weight_pi DECIMAL(6,2), weapon_weight_pi DECIMAL(6,2), skill_tone VARCHAR(64));"
                ),
                new PolyglotStorageFormatDossier(
                        "FMT-06-YAML",
                        "6. YAML (Spring Boot @ConfigurationProperties Declarative Profile)",
                        ".yml",
                        "Indentation-Scoped Hierarchical Configuration",
                        "Mirrors the repository's `application-warlock-*.yml` files so any character, realm, or combat scenario can be loaded as a Spring Boot profile.",
                        "sovereign-castle:\n  pi-anchor: 3.14\n  good-warlock:\n    stat-weight-pi: 9.42\n    skill-ability: Solomonic Qumqum Beam"
                ),
                new PolyglotStorageFormatDossier(
                        "FMT-07-TOML",
                        "7. TOML (Section-Header Game Engine Config)",
                        ".toml",
                        "Explicit [Table] & Key-Value Config",
                        "Organizes `[throne_room]`, `[[characters]]`, `[[commodities]]`, and `[vfx_studio]` into clean, strongly-typed game configuration blocks.",
                        "[characters.CHAR_002_BADR_313]\narchetype = \"Muslims\"\nstat_weight_pi = 6.28\nweapon_weight_pi = 2.51\nvfx_type = \"SWORD_SWIPE\""
                ),
                new PolyglotStorageFormatDossier(
                        "FMT-08-XML",
                        "8. XML (Typed Schema & 3D Sprite Animation Keyframe Descriptor)",
                        ".xml",
                        "Tag-Validated Document & Rig Tree",
                        "Encodes 11-vector character profiles alongside `<SpriteRig form=\"Floating_314_Pi\" walkFrames=\"8\" combatVfx=\"SPARKLES\"/>` keyframe nodes.",
                        "<CharacterProfile id=\"CHAR-001-GOOD-WARLOCK\" statWeightPi=\"9.42\" armorWeightPi=\"1.57\" weaponWeightPi=\"3.14\"><Skill tone=\"Sakinah\">Solomonic Qumqum Beam</Skill></CharacterProfile>"
                ),
                new PolyglotStorageFormatDossier(
                        "FMT-09-PROTOBUF",
                        "9. Protobuf-Text / FlatBuffers Schema & Message Payload",
                        ".pbtxt",
                        "Strongly-Typed Field-Numbered Wire Schema",
                        "Serializes high-frequency combat state, projectile trajectories, and unit weights into deterministic numbered schema blocks.",
                        "character_profile { id: \"CHAR-003-MAMLUK-LANCER\" stat_weight_pi: 6.28 armor_weight_pi: 4.71 weapon_weight_pi: 3.14 vfx: CAVALRY_CHARGE }"
                ),
                new PolyglotStorageFormatDossier(
                        "FMT-10-BINARY-HEX",
                        "10. Binary TypedArray / Hex Bitmask / Base64 Cartridge Seed",
                        ".bin64",
                        "Compact Float32Array & Active-Low 0x00 Hex Stream",
                        "Packs all 3.14 sliders, unit coordinates, and 11 combat weights into a compact hexadecimal/Base64 byte cartridge for instant URL/clipboard sharing.",
                        "SOV314::0x00FF3140::4048F5C3_3FC8F5C3_4048F5C3::BASE64_CARTRIDGE_PAYLOAD"
                ),
                new PolyglotStorageFormatDossier(
                        "FMT-11-CYPHER-GRAPH",
                        "11. Property-Graph Cypher Triples & Gambit AI Rule Graph",
                        ".cypher",
                        "Directed Labeled Property Graph (Nodes & Edges)",
                        "Models Patronage (`Mu'akhah`), Gambit AI targeting (`(Healer)-[:HEALS]->(Vanguard)`), Caravan routes, and Diplomatic Syndication uncovering as graph edges.",
                        "CREATE (x:Unit {id:'CHAR-004'})-[:HEALS {threshold:0.75, piWeight:3.14}]->(y:Unit {id:'CHAR-002'}), (x)-[:DEFENDS]->(s:Straggler)"
                ),
                new PolyglotStorageFormatDossier(
                        "FMT-12-WAFQ-MARKDOWN",
                        "12. Abjad 261 Wafq Matrix & Collegiate Markdown Ledger",
                        ".md",
                        "Human-Readable Collegiate Markdown Table & Abjad Seal",
                        "Exports a complete publication-ready Markdown specification of all characters, Throne Room dictates, combat math, and SHA-256 / Abjad 261 verification.",
                        "| Profile ID | Archetype | Stat π | Armor π | Weapon π | Skill Ability | VFX |\n|---|---|---|---|---|---|---|\n| CHAR-001 | Good Warlock | 9.42π | 1.57π | 3.14π | Qumqum Beam | SPARKLES |"
                )
        );
    }
}
