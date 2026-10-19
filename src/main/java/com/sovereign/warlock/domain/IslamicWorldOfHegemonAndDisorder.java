package com.sovereign.warlock.domain;

import java.util.List;

/**
 * Models the 7 Canonical Islamic Worlds ('Awalim / Dur) of Hegemon (Al-Haymanah / Imamat Ibrahim)
 * and Disorder (Al-Fasad / Al-Jahiliyyah / Az-Zulm).
 *
 * Each World pairs:
 *  - The Hegemon Pole (Al-Muhaymin / Millat Ibrahim, Qur'an 5:48, 2:124, 59:23), anchored in Order #1..#7
 *  - The Disorder Pole (Dar Al-Fasad wa Az-Zalimun), anchored in Wrongdoer Archetype Zalim #1..#7 (Orders #8..#14)
 *  - The Qur'anic Historical Law (Sunnat Allah fi Al-Umam) & Priory Sigma -1n / 0n Beta Criterion Resolution.
 */
public final class IslamicWorldOfHegemonAndDisorder {

    private IslamicWorldOfHegemonAndDisorder() {
    }

    public record WorldPolarityDossier(
            int worldIndex,
            String worldCode,
            String worldHtmlFile,
            String arabicWorldName,
            String englishWorldTitle,
            String quranicCriterionAxis,
            // Hegemon Pole (Al-Muhaymin / Imamat Ibrahim)
            int hegemonOrderIndex,
            String hegemonProfileId,
            String hegemonPoleTitle,
            String hegemonArchitectureAndLaw,
            String hegemonColorHex,
            double hegemonCp,
            // Disorder Pole (Az-Zalimun / Counter-Hegemon)
            int disorderZalimIndex,
            String disorderProfileId,
            String disorderWarlockName,
            String disorderPoleTitle,
            String disorderArchitectureAndRuin,
            String disorderColorHex,
            double disorderUncorrectedCp,
            double disorderRawEntropyBits,
            // Sunnat Allah & Priory Resolution
            String sunnatAllahHistoricalTrajectory,
            String prioryMizanResolution,
            double resolvedEntropyBits
    ) {
        public WorldPolarityDossier {
            if (worldIndex < 1 || worldIndex > 7) {
                throw new IllegalArgumentException("worldIndex must be in [1..7]");
            }
            if (Math.abs(resolvedEntropyBits) > 1e-9) {
                throw new IllegalArgumentException("Resolved entropy must be 0.000 bits under Sigma -1n");
            }
        }
    }

    private static final List<WorldPolarityDossier> SEVEN_WORLDS = List.of(
            new WorldPolarityDossier(
                    1,
                    "WORLD_1_AMANAH_VS_FASAD",
                    "world-1-mizan-fasad.html",
                    "'Alam Al-Amanah wa Al-Fasad (عالم الأمانة والفساد)",
                    "The First World: The Primordial Trust & Secure Sanctuary vs. Ecological & Ritual Disorder",
                    "Qur'an 33:72 (Al-Amanah), Qur'an 55:7-9 (Al-Mizan), Qur'an 2:126 (Al-Balad Al-Amin) vs. Qur'an 2:11-12, 2:205, 30:41 (Al-Fasad fi Al-Ard)",
                    1, "warlock-1-white",
                    "Dar Al-Amanah wa Al-Balad Al-Amin (Hegemony of the Cosmic Balance)",
                    "Founded upon Prophet Ibrahim's prayer: 'My Lord, make this a Secure Sanctuary [Baladan Aminan]' (Qur'an 2:126) and the Cosmic Balance (Al-Mizan, Qur'an 55:7-9). Governance operates as Khilafah (stewardship) that preserves crops, lineage (al-harth wa an-nasl), and covenantal peace across the sacred months.",
                    "#F8F5E6", 1.52,
                    1, "zalim-1-fasad", "Mufsid Al-Ard",
                    "Dar Al-Fasad wa Talbis Al-Islah (Disorder of Predatory Extraction)",
                    "A blighted landscape of severed aqueducts, scorched orchards, and broken boundary stones where Mufsid Al-Ard destroys agriculture and progeny (Qur'an 2:205) while erecting triumphal arches inscribed with 'Innama nahnu muslihun' ('We are only reformers', Qur'an 2:11).",
                    "#4A1C1C", 0.88, 0.780,
                    "Under Sunnat Allah (Qur'an 30:41: 'Fasad has appeared on land and sea because of what the hands of people have earned'), false hegemonies built on ecological and economic corruption inevitably exhaust their own substrate and collapse into famine and internal fracture.",
                    "Priory Seat I & Ward I enforce the Mizan Equilibrium Lock (Qur'an 55:8-9: 'Do not transgress within the Balance, and establish weight in justice'), collapsing H_raw = 0.780 bits to 0.000.",
                    0.000
            ),
            new WorldPolarityDossier(
                    2,
                    "WORLD_2_HAYA_VS_FAHISHAH",
                    "world-2-haya-fahishah.html",
                    "'Alam Al-Haram wa At-Tabarruj (عالم الحرم والتبرج)",
                    "The Second World: Sanctuary Modesty (Libas At-Taqwa) vs. Jahiliyyah Immodesty & Naked Circumambulation",
                    "Qur'an 7:26-28 (Libas At-Taqwa vs. Al-Fahishah), Qur'an 2:125 (Purification of Abraham's House), Qur'an 8:35 (Muka'an wa Tasdiyatan), Qur'an 24:19",
                    2, "warlock-2-black",
                    "Dar Al-Haya' wa Libas At-Taqwa (Hegemony of Sacred Modesty & Inviolability)",
                    "Anchored in the divine command to Abraham and Ishmael: 'Purify My House for those who circumambulate, stay in retreat, and bow and prostrate' (Qur'an 2:125) and the Garment of Taqwa (Libas At-Taqwa, Qur'an 7:26). Modesty (Haya') guards the dignity of the human vessel and the equality of all pilgrims before Allah.",
                    "#A78BFA", 1.45,
                    2, "zalim-2-fahishah", "Da'i Al-Fahishah",
                    "Suq Al-Fahishah wa Tawaf Al-'Urah (Disorder of Exhibitionism & Sanctuary Commercialization)",
                    "The Jahiliyyah Hums toll-gates where Da'i Al-Fahishah forced non-Quraishi pilgrims to either pay exorbitant garment-rent or circumambulate Abraham's Ka'bah stark naked while whistling and clapping (Qur'an 8:35), justifying gross immodesty as 'ancestral tradition commanded by God' (Qur'an 7:28).",
                    "#9E1B32", 0.84, 0.810,
                    "When a religious hegemon weaponizes immodesty (Fahishah) and commercial humiliation inside the sanctuary, moral cohesion disintegrates (sigma = 3.05). In Year 9 AH (Qur'an 9:28), the Prophetic proclamation permanently abolished naked Tawaf and restored Abraham's dignified Manasik.",
                    "Priory Seat III & Ward II seal the sanctuary perimeter with Libas At-Taqwa (Qur'an 7:26-28), collapsing H_raw = 0.810 bits to 0.000.",
                    0.000
            ),
            new WorldPolarityDossier(
                    3,
                    "WORLD_3_IMAMAH_VS_NAMRUD",
                    "world-3-babil-namrud.html",
                    "'Alam Babil wa Al-Jabbarin (عالم بابل والجبارين)",
                    "The Third World: Abraham's Cosmic Proof & Cool-Fire Sanctuary vs. The Nimrodic Tyranny of Babylon",
                    "Qur'an 2:258 (Abraham vs. the King who claimed Life & Death), Qur'an 21:68-70 (The Furnace made Cool & Safe), Qur'an 14:15 (Every obstinate tyrant [jabbar 'anid] was brought to ruin)",
                    3, "warlock-3-sapphire",
                    "Maqam Ibrahim wa Al-Muhaymin (Hegemony of Prophetic Truth Over Mortal Kingship)",
                    "The Sapphire Observatory of Cosmic Order where Abraham demonstrates that true sovereignty (Al-Mulk) belongs solely to the Lord who brings the sun from the East (Qur'an 2:258), and where the roaring furnace is transformed into a flowering garden of coolness and peace (Bardan wa Salaman, Qur'an 21:69).",
                    "#38BDF8", 1.41,
                    3, "zalim-3-baghy", "Jabbar Al-Namrud",
                    "Sarh Babil wa Al-Jahim Al-Namrudi (Totalitarian Counter-Hegemony of Al-Baghy)",
                    "The stepped ziggurat-citadel and catapult-furnace of Jabbar Al-Namrud, who claimed divine power over life and death ('Ana uhyi wa umit') and sought to incinerate Abraham to prevent the birth of a monotheistic moral order that would dethrone mortal absolutism.",
                    "#C084FC", 0.79, 0.845,
                    "Qur'an 2:258 records the instant intellectual and political collapse of tyrannical hegemony when confronted by cosmic reality: 'Fa-buhita alladhi kafar — wa Allahu la yahdi al-qawma az-zalimin' ('Then the disbeliever was confounded, and Allah guides not the wrongdoers').",
                    "Priory Seat VI & Ward III apply the Western Horizon Solar Proof and Cool-Fire thermal inversion, collapsing H_raw = 0.845 bits to 0.000.",
                    0.000
            ),
            new WorldPolarityDossier(
                    4,
                    "WORLD_4_UMMAH_VS_FITNAH",
                    "world-4-ummah-fitnah.html",
                    "'Alam Al-Ummah Al-Wahidah wa Al-Fitnah (عالم الأمة الواحدة والفتنة)",
                    "The Fourth World: The Unified Abrahamic Ummah vs. Sectarian Schism & Sedition (Al-Fitnah)",
                    "Qur'an 42:13 ('Establish the religion and do not be divided therein'), Qur'an 21:92 ('This Ummah of yours is One Ummah'), Qur'an 3:67, Qur'an 6:159, Qur'an 30:31-32",
                    4, "warlock-4-gold",
                    "Ribat Al-Ummah Al-Wahidah wa Millat Ibrahim (Hegemony of Covenantal Unity)",
                    "The Golden Rotunda of Yawm Al-Alast (Qur'an 7:172) and the undivided Hanifiyyah of Abraham ('Abraham was neither a Jew nor a Christian, but he was a Hanif Muslim', Qur'an 3:67), binding all believers to the single Rope of Allah (Habl-Allah, Qur'an 3:103).",
                    "#D4AF37", 1.47,
                    4, "zalim-4-fitnah", "Nafikh Al-Fitnah",
                    "Mutarak Al-Ahzab wa Tafriqat Ad-Din (Disorder of Sectarian Fragmentation)",
                    "A shattered labyrinth of warring watchtowers where Nafikh Al-Fitnah fans the bellows of Hamiyyat Al-Jahiliyyah (tribal/sectarian arrogance, Qur'an 48:26), splitting the single religion of Abraham into mutually excommunicating sects ('kullu hizbin bima ladayhim farihun', Qur'an 30:32).",
                    "#F59E0B", 0.76, 0.875,
                    "As Qur'an 8:46 warns ('Do not dispute with one another lest you falter and your strength [rihukum] depart') and Ibn Khaldun's Muqaddimah demonstrates, sectarian Fitnah destroys cohesive solidarity ('Asabiyyah) and paralyzes the formation of a just religious hegemony.",
                    "Priory Seat II & Ward IV clamp all fractured splinters back to the single Habl-Allah axis via 0n Beta zero-drift grounding, collapsing H_raw = 0.875 bits to 0.000.",
                    0.000
            ),
            new WorldPolarityDossier(
                    5,
                    "WORLD_5_FURQAN_VS_HAWA",
                    "world-5-furqan-hawa.html",
                    "'Alam Al-Furqan wa Al-Hawa (عالم الفرقان والهوى)",
                    "The Fifth World: The Muhaymin Criterion of Revelation vs. Sovereign Caprice & Forged Sacred Law",
                    "Qur'an 5:48 ('We revealed to you the Book in truth... as a Muhaymin [Supreme Criterion-Hegemon] over it'), Qur'an 45:23 / 25:43 (Hawa as a god), Qur'an 6:140-144, Qur'an 9:36-37 (An-Nasi')",
                    5, "warlock-5-crimson",
                    "Diwan Al-Furqan wa Al-Kitab Al-Muhaymin (Hegemony of Invariant Divine Law)",
                    "The Criterion Citadel where divine law stands above ruler and ruled alike (Qur'an 5:48), protected by the flaming Shihab barrier against forged interpolations (Qur'an 72:8-9) and anchored to the invariant 12-month cosmic calendar ordained by Allah (Qur'an 9:36).",
                    "#EF4444", 1.39,
                    5, "zalim-5-hawa", "'Abid Al-Hawa",
                    "Mahkamat Al-Hawa wa An-Nasi' (Disorder of Fabricated Taboos & Calendar Tampering)",
                    "A shifting mirage-court where 'Abid Al-Hawa enthrones personal desire as a deity (Qur'an 45:23), invents arbitrary livestock exemptions and ritual taboos in Allah's name (Bahirah, Sa'ibah, Wasilah, Qur'an 5:103; 6:144), and manipulates the sacred truce months (An-Nasi', Qur'an 9:37) to legalize predatory raids.",
                    "#EAB308", 0.73, 0.905,
                    "Qur'an 23:71 states the cosmic law: 'Had the Truth followed their capricious desires [ahwa'ahum], the heavens and the earth and whoever is in them would have been ruined [la-fasadata].' Law subordinated to elite caprice inevitably implodes.",
                    "Priory Seat VII & Ward V purge all unrevealed fabrications (Iftira') and lock the cosmic calendar to Qur'an 9:36, collapsing H_raw = 0.905 bits to 0.000.",
                    0.000
            ),
            new WorldPolarityDossier(
                    6,
                    "WORLD_6_TAWHID_VS_TAGHUT",
                    "world-6-tawhid-taghut.html",
                    "'Alam Al-'Urwah Al-Wuthqa wa At-Taghut (عالم العروة الوثقى والطاغوت)",
                    "The Sixth World: Abraham's Iconoclastic Tawhid vs. Azar's Idol-Guild & Sorcerous Taghut",
                    "Qur'an 2:256-257 (Al-'Urwah Al-Wuthqa vs. At-Taghut), Qur'an 4:51 (Al-Jibt wa At-Taghut), Qur'an 6:74, Qur'an 21:52-58 (Abraham Shatters the Idols), Qur'an 2:102",
                    6, "warlock-6-brass",
                    "Hisn Al-'Urwah Al-Wuthqa wa Sulayman Al-Mu'min (Hegemony of Unmediated Monotheism)",
                    "The Fortress of the Most Trustworthy Handhold (Al-'Urwah Al-Wuthqa, Qur'an 2:256) where Abraham's iconoclastic axe shatters every false intermediary (Qur'an 21:58) and Prophet Sulayman's pure kingdom is vindicated against the slanders of sorcery ('Wa ma kafara Sulaymanu', Qur'an 2:102).",
                    "#B87333", 1.42,
                    6, "zalim-6-jibt", "Kahin Al-Jibt",
                    "Haykal Azar wa Kihanat Al-Azlam (Oligarchic Hegemony of Idols & Sorcery)",
                    "The shadowed temple-pantheon of Azar in Ur and the 360 idols and divining arrows (Al-Azlam, Qur'an 5:90) where Kahin Al-Jibt extracts tribute through talismanic fear (Al-Jibt) and ancestral blind imitation ('We found our fathers worshipping them', Qur'an 21:53).",
                    "#34D399", 0.70, 0.940,
                    "Qur'an 29:41 exposes the structural fragility of every Taghut-hegemony: 'The example of those who take protectors other than Allah is like that of the spider who takes a home; and indeed, the frailest of homes is the home of the spider.'",
                    "Priory Seat V & Ward VI wield the Iconoclastic Proof of Khalil-Allah (Qur'an 21:58), severing all Jibt/Taghut bindings and collapsing H_raw = 0.940 bits to 0.000.",
                    0.000
            ),
            new WorldPolarityDossier(
                    7,
                    "WORLD_7_TAQWA_VS_DIRAR",
                    "world-7-taqwa-dirar.html",
                    "'Alam Bunyan At-Taqwa wa Juruf Al-Har (عالم بنيان التقوى وجرف الهار)",
                    "The Seventh World: Abraham's Foundation of Taqwa vs. The Crumbling Cliff of Masjid Ad-Dirar",
                    "Qur'an 2:124 ('La yanalu 'ahdi az-zalimin'), Qur'an 2:127 ('And when Abraham and Ishmael raised the foundations of the House'), Qur'an 9:107-109 (Foundation of Taqwa vs. Masjid Ad-Dirar on a Crumbling Cliff)",
                    7, "warlock-7-emerald",
                    "Al-Qawa'id min Al-Bayt wa Bunyan At-Taqwa (Supreme Hegemony of the Abrahamic Covenant)",
                    "The Eternal Sanctuary whose foundations were raised by Abraham and Ishmael (Qur'an 2:127) and founded upon Taqwa from the very first day (usissa 'ala at-taqwa min awwali yawm, Qur'an 9:108), where the Imamate of Abraham (Qur'an 2:124) unites spiritual purity with unshakeable structural permanence.",
                    "#10B981", 1.44,
                    7, "zalim-7-zulm", "Imam Az-Zalimin",
                    "Masjid Ad-Dirar 'ala Shafa Jurufin Harin (The Counter-Sanctuary on the Crumbling Precipice)",
                    "The counterfeit sanctuary built by Imam Az-Zalimin for harm (diraran), disbelief (kufran), and division among believers (tafriqan bayna al-mu'minin, Qur'an 9:107), cantilevered over an undercut cliff of volcanic ash (shafa jurufin harin, Qur'an 9:109) that is perpetually shearing into the abyss.",
                    "#94A3B8", 0.68, 0.985,
                    "Qur'an 9:109 & 2:124 pronounce the final architectural verdict of history: the Wrongdoers (Az-Zalimun) are forever excluded from Abraham's Covenant, and every counter-hegemony built on hypocrisy and Zulm collapses with its builder into the fire.",
                    "Priory Seat IV & Ward VII enforce the Abrahamic Covenant Exclusion Seal (Qur'an 2:124) and GEMINI.md 12ms Shunt Isolation, collapsing H_raw = 0.985 bits to 0.000.",
                    0.000
            )
    );

    public static List<WorldPolarityDossier> allSevenWorlds() {
        return SEVEN_WORLDS;
    }

    public static WorldPolarityDossier forWorldIndex(int worldIndex) {
        return SEVEN_WORLDS.stream()
                .filter(w -> w.worldIndex() == worldIndex)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown worldIndex: " + worldIndex));
    }
}
