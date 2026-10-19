package com.sovereign.warlock.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Canonical Islamic Wrongdoer Archetype (Az-Zalimun / الظالمون) Warlock Profiles (Zalim 1..7 | Global Orders 8..14).
 *
 * Anchored in Qur'an 2:124:
 *   "Wa idh ibtala Ibrahima Rabbuhu bi-kalimatin fa-atammahunna; qala inni ja'iluka li-n-nasi Imaman;
 *    qala wa min dhurriyyati? Qala: La yanalu 'ahdi az-zalimin (My Covenant does not include the Wrongdoers)."
 *
 * Models the 7 Canonical Islamic Principles of:
 *   1) Disorder & Corruption (Al-Fasad fi Al-Ard — Qur'an 2:11-12, 2:205, 30:41)
 *   2) Gross Immodesty & Naked Sanctuary Desecration (Al-Fahishah wa At-Tabarruj — Qur'an 7:28, 7:33, 8:35)
 *   3) Tyrannical Counter-Hegemony Against Abraham (Al-Baghy wa Al-Istikbar Al-Namrudi — Qur'an 2:258, 21:68-69)
 *   4) Sectarian Sedition & Fracturing the Abrahamic Ummah (Al-Fitnah wa Tafriqat Ad-Din — Qur'an 6:159, 42:13)
 *   5) Deification of Caprice & Fabricating Religious Taboos (Ittiba' Al-Hawa wa Al-Iftira' — Qur'an 6:140-144, 25:43)
 *   6) Sorcerous Idolatry & Azar's Temple-Guild Hegemony (Al-Jibt wa At-Taghut wa Asnam Azar — Qur'an 4:51, 6:74, 21:52-58)
 *   7) Supreme Wrongdoing & The Counter-Sanctuary on a Crumbling Cliff (Az-Zulm Al-Akbar wa Masjid Ad-Dirar — Qur'an 2:124, 9:107-109, 31:13)
 */
public final class WrongdoerArchetypeOrder {

    private WrongdoerArchetypeOrder() {
    }

    public enum ZalimPrincipleCategory {
        DISORDER_CORRUPTION_OF_EARTH("Disorder & Ecological/Ritual Corruption (Al-Fasad)"),
        IMMODESTY_DESECRATION_OF_SANCTUARY("Gross Immodesty & Naked Circumambulation (Al-Fahishah wa At-Tabarruj)"),
        TYRANNICAL_HEGEMONY_AGAINST_ABRAHAM("Tyrannical Counter-Hegemony Against Abraham (Al-Baghy Al-Namrudi)"),
        SCHISMATIC_SEDITION_AGAINST_UMMAH("Sectarian Schism & Fracturing of Millat Ibrahim (Al-Fitnah wa At-Tafriqah)"),
        CAPRICIOUS_LAW_FABRICATION("Deification of Caprice & Fabricated Taboos (Ittiba' Al-Hawa wa Al-Iftira')"),
        SORCEROUS_IDOL_HEGEMONY("Sorcerous Idolatry & Azar's Temple Oligarchy (Al-Jibt wa At-Taghut)"),
        COVENANT_EXCLUSION_AND_COUNTER_SANCTUARY("Supreme Wrongdoing & The Counter-Sanctuary (Az-Zulm wa Masjid Ad-Dirar)");

        private final String displayTitle;

        ZalimPrincipleCategory(String displayTitle) {
            this.displayTitle = displayTitle;
        }

        public String displayTitle() {
            return displayTitle;
        }
    }

    @ConfigurationProperties(prefix = "zalim")
    public record ZalimProfileProperties(
            int zalimIndex,
            String profileId,
            String arabicPrinciple,
            String hexCode,
            int rgbRed,
            int rgbGreen,
            int rgbBlue,
            String warlockName,
            String arabicArchetypeTitle,
            String quranicAnchor,
            String abrahamicChallenge,
            String wrongdoerCategory,
            double rawEntropyBits,
            double uncorrectedCp,
            double uncorrectedSigma,
            double correctedCp,
            String prioryContainmentCell
    ) {
        public ZalimProfileProperties {
            if (zalimIndex < 1 || zalimIndex > 7) {
                throw new IllegalArgumentException("zalimIndex must be in [1..7], got: " + zalimIndex);
            }
            Objects.requireNonNull(profileId, "profileId must not be null");
            Objects.requireNonNull(arabicPrinciple, "arabicPrinciple must not be null");
            Objects.requireNonNull(hexCode, "hexCode must not be null");
            Objects.requireNonNull(warlockName, "warlockName must not be null");
        }
    }

    public record WrongdoerWarlockProfile(
            int zalimIndex,
            int globalOrderIndex,
            String profileId,
            String htmlFileName,
            String warlockName,
            String arabicArchetypeTitle,
            String arabicTermAndRoot,
            String englishPrincipleTitle,
            ZalimPrincipleCategory category,
            String hexCode,
            int rgb24,
            int activeLow24,
            String quranicAnchor,
            String challengeToAbrahamicHegemony,
            String disorderAndImmodestyMechanism,
            String abrahamicRefutationAndPrioryQuarantine,
            String prioryContainmentCell,
            double rawEntropyBits,
            double uncorrectedCp,
            double uncorrectedSigma,
            SpcControlMatrix.SpcState uncorrectedSpcState,
            double correctedCp,
            SpcControlMatrix.SpcState correctedSpcState,
            double resolvedEntropyBits
    ) {
        public WrongdoerWarlockProfile {
            if (zalimIndex < 1 || zalimIndex > 7) {
                throw new IllegalArgumentException("zalimIndex must be in [1..7]");
            }
            if (Math.abs(resolvedEntropyBits) > 1e-9) {
                throw new IllegalArgumentException("Sigma -1n Priory quarantine must collapse resolvedEntropyBits to 0.0");
            }
        }
    }

    public static final Comparator<WrongdoerWarlockProfile> BY_ZALIM_INDEX =
            Comparator.comparingInt(WrongdoerWarlockProfile::zalimIndex);

    public static final Comparator<WrongdoerWarlockProfile> BY_RAW_ENTROPY_DESC =
            Comparator.comparingDouble(WrongdoerWarlockProfile::rawEntropyBits).reversed();

    private static final List<WrongdoerWarlockProfile> CANONICAL_ZALIM_PROFILES = List.of(
            new WrongdoerWarlockProfile(
                    1, 8,
                    "zalim-1-fasad",
                    "zalim-1-fasad.html",
                    "Mufsid Al-Ard",
                    "Ra's Al-Mufsidin (Architect of Entropic Ruin)",
                    "الْفَسَادُ فِي الْأَرْضِ — Root: ف-س-د (f-s-d: to rot, disorder, unbalance, corrupt)",
                    "Al-Fasad fi Al-Ard — Systemic Disorder & Ecological/Ritual Corruption",
                    ZalimPrincipleCategory.DISORDER_CORRUPTION_OF_EARTH,
                    "#4A1C1C",
                    0x4A1C1C,
                    (~0x4A1C1C) & 0xFFFFFF,
                    "Qur'an 2:11-12 ('When it is said to them: Do not cause Fasad on the earth, they say: We are only reformers [Innama nahnu muslihun]'), Qur'an 2:205 ('He strives throughout the land to cause Fasad therein and destroy crops and progeny [al-harth wa an-nasl]'), Qur'an 30:41.",
                    "When Prophet Ibrahim built the Ka'bah and prayed: 'My Lord, make this a Secure Sanctuary [Baladan Aminan] and provide its people with fruits' (Qur'an 2:126, 14:35), the Fasad Warlock sought to invert the Abrahamic sanctuary of peace into a theater of predatory extraction, severing kinship ties (qati'at al-arham, Qur'an 47:22) and destabilizing the sacred truce months (Al-Ashhur Al-Hurum) so no unified moral order under Abraham could endure.",
                    "Operates through the Inversion of Reform (Talbis Al-Islah): disguising systemic entropy, usurious exploitation, and the destruction of agriculture and lineage (al-harth wa an-nasl) beneath the rhetoric of 'progress and esoteric illumination,' pushing the social capability index down to C_p = 0.88 (State S2 Critical Failure).",
                    "Quarantined in Priory Ward I (The Mizan Equilibrium Lock, Qur'an 55:7-9: 'He raised the heaven and set up the Balance [Al-Mizan] so that you do not transgress within the Balance'). Sigma -1n strips the false 'muslihun' mask and collapses H_raw = 0.780 bits to H_resolved = 0.000 bits.",
                    "Quarantine Ward I: The Mizan Equilibrium Lock (Qur'an 55:7-9)",
                    0.780, 0.88, 2.85, SpcControlMatrix.SpcState.S2_CRITICAL,
                    1.44, SpcControlMatrix.SpcState.S0_OPTIMAL, 0.000
            ),
            new WrongdoerWarlockProfile(
                    2, 9,
                    "zalim-2-fahishah",
                    "zalim-2-fahishah.html",
                    "Da'i Al-Fahishah",
                    "Khadim At-Tabarruj Al-Jahili (Herald of Unclothed Transgression)",
                    "الْفَاحِشَةُ وَالتَّبَرُّجُ — Root: ف-ح-ش (f-h-sh: gross immodesty, indecency) & ب-ر-ج (b-r-j: ostentatious display)",
                    "Al-Fahishah wa At-Tabarruj — Gross Immodesty & Naked Desecration of the Sanctuary",
                    ZalimPrincipleCategory.IMMODESTY_DESECRATION_OF_SANCTUARY,
                    "#9E1B32",
                    0x9E1B32,
                    (~0x9E1B32) & 0xFFFFFF,
                    "Qur'an 7:26-28 ('O Children of Adam, We have bestowed upon you clothing to cover your shame, and the Garment of Taqwa — that is best... And when they commit a Fahishah [indecency], they say: We found our fathers doing it, and Allah commanded us to do it. Say: Indeed, Allah never commands Al-Fahishah!'), Qur'an 7:33, Qur'an 8:35, Qur'an 24:19, Qur'an 33:33.",
                    "Directly attacked the liturgical heart of Abraham's Sanctuary (Al-Bayt Al-Haram) during the Jahiliyyah era by instituting the Hums monopoly and the rite of Naked Circumambulation (Tawaf al-'Urah): forcing pilgrims who refused to rent garments from the Quraishi oligarchy to circle Abraham's Ka'bah stark naked while whistling and clapping (muka'an wa tasdiyatan, Qur'an 8:35). By equating nudity and exhibitionism with 'ancestral piety,' this archetype sought to humiliate pilgrims and subvert Abraham's dignified rites (Manasik Ibrahim, Qur'an 2:128).",
                    "Propagates both open and secret indecency (ma zahara minha wa ma batana, Qur'an 7:33) and desires that immodesty spread among the believers (yuhubbuna an tashi'a al-fahishatu fi alladhina amanu, Qur'an 24:19). Dissolves the boundary of Haya' (sacred modesty), inducing high-variance moral drift (sigma = 3.05, H_raw = 0.810 bits).",
                    "Quarantined in Priory Ward II (Cloister of Libas At-Taqwa, Qur'an 7:26 & Qur'an 9:28, alongside the Prophetic Proclamation of Year 9 AH: 'No idolater shall perform Hajj after this year, and no naked person shall circumambulate the House'). Sigma -1n restores the Garment of Taqwa and collapses H_raw = 0.810 bits to 0.000.",
                    "Quarantine Ward II: Cloister of Libas At-Taqwa & Modesty Seal (Qur'an 7:26-28)",
                    0.810, 0.84, 3.05, SpcControlMatrix.SpcState.S2_CRITICAL,
                    1.43, SpcControlMatrix.SpcState.S0_OPTIMAL, 0.000
            ),
            new WrongdoerWarlockProfile(
                    3, 10,
                    "zalim-3-baghy",
                    "zalim-3-baghy.html",
                    "Jabbar Al-Namrud",
                    "Taghut Babil (The Nimrodic Usurper Against Abraham)",
                    "الْبَغْيُ وَالِاسْتِكْبَارُ — Root: ب-غ-ي (b-gh-y: tyrannical insolence, transgression) & ك-ب-ر (k-b-r: arrogance)",
                    "Al-Baghy wa Al-Istikbar — Tyrannical Insolence & Nimrodic Counter-Hegemony Against Abraham",
                    ZalimPrincipleCategory.TYRANNICAL_HEGEMONY_AGAINST_ABRAHAM,
                    "#3B0944",
                    0x3B0944,
                    (~0x3B0944) & 0xFFFFFF,
                    "Qur'an 2:258 ('Have you not considered the one who disputed with Abraham about his Lord because Allah had given him kingship? When Abraham said: My Lord is He who gives life and causes death, he said: I give life and cause death. Abraham said: Indeed, Allah brings the sun from the East, so bring it from the West! Then the disbeliever was confounded — and Allah guides not the Zalimin'), Qur'an 21:68-69, Qur'an 7:33.",
                    "Embodies the supreme political-religious hegemon that attempted to crush Abraham's mission before it could take root. Claiming divine prerogative over life and death ('Ana uhyi wa umit') through arbitrary execution and pardon, the Nimrodic Warlock mobilized the state priesthood and built the colossal Furnace (Al-Jahim, Qur'an 21:68: 'Burn him and support your gods!') to annihilate Abraham physically and ideologically.",
                    "Weaponizes state coercion, self-deification (Rububiyyah claim), and tyrannical aggression without right (Al-Baghy bi-ghayri al-haqq, Qur'an 7:33, 42:42) to suppress prophetic truth, driving systemic variance to sigma = 3.25 and H_raw = 0.845 bits.",
                    "Quarantined in Priory Ward III (The Western Horizon Solar Proof & Cool-Fire Vault). By Abraham's cosmic proof (Qur'an 2:258) and the divine command 'O Fire, be coolness and safety upon Abraham!' (Ya naru kuni bardan wa salaman 'ala Ibrahim, Qur'an 21:69), the tyrant's thermal weapon is inverted and H_raw = 0.845 bits collapses to 0.000.",
                    "Quarantine Ward III: The Western Horizon Solar Proof & Cool-Fire Vault (Qur'an 2:258, 21:69)",
                    0.845, 0.79, 3.25, SpcControlMatrix.SpcState.S2_CRITICAL,
                    1.42, SpcControlMatrix.SpcState.S0_OPTIMAL, 0.000
            ),
            new WrongdoerWarlockProfile(
                    4, 11,
                    "zalim-4-fitnah",
                    "zalim-4-fitnah.html",
                    "Nafikh Al-Fitnah",
                    "Mufarriq Al-Millah (Bellows-Blower of Sectarian Fracture)",
                    "الْفِتْنَةُ وَتَفْرِقَةُ الدِّينِ — Root: ف-ت-ن (f-t-n: trial, sedition, persecution) & ف-ر-ق (f-r-q: to split, divide into sects)",
                    "Al-Fitnah wa Tafriqat Ad-Din — Sectarian Schism, Sedition & Fracturing the Abrahamic Hegemony",
                    ZalimPrincipleCategory.SCHISMATIC_SEDITION_AGAINST_UMMAH,
                    "#8C4A08",
                    0x8C4A08,
                    (~0x8C4A08) & 0xFFFFFF,
                    "Qur'an 42:13 ('He has ordained for you of religion what He enjoined upon Noah and that which We have revealed to you and what We enjoined upon Abraham, Moses, and Jesus — to establish the religion and not be divided therein [wa la tatafarraqu fihi]'), Qur'an 6:159 ('Indeed, those who have divided their religion and become sects [shiya'an] — you are not with them in anything'), Qur'an 30:30-32, Qur'an 2:191 ('Al-Fitnah is worse than slaughter').",
                    "When Abraham established the Hanifiyyah as the unifying spiritual foundation of the monotheistic Ummah ('Millata abikum Ibrahim — Huwa sammakumu al-Muslimin', Qur'an 22:78), the Fitnah Warlock worked to prevent any unified religious hegemony under Abraham by injecting partisan zealotry (Hamiyyat Al-Jahiliyyah, Qur'an 48:26) and mutual excommunication ('The Jews say the Christians have nothing to stand on, and the Christians say the Jews have nothing to stand on', Qur'an 2:113, whereas Qur'an 3:67 declares: 'Abraham was neither a Jew nor a Christian, but he was a Hanif Muslim').",
                    "Splits the single covenant rope (Habl-Allah) into isolated, self-worshipping factions ('kullu hizbin bima ladayhim farihun' — each faction rejoicing in its own fragment, Qur'an 30:32), generating severe schismatic entropy (H_raw = 0.875 bits, sigma = 3.40).",
                    "Quarantined in Priory Ward IV (The Habl-Allah Unification Clamp, Qur'an 3:103 & 42:13). Re-anchors all covenant branches to the undivided Hanifiyyah of Ibrahim via 0n Beta zero-drift grounding, collapsing H_raw = 0.875 bits to 0.000.",
                    "Quarantine Ward IV: The Habl-Allah Unification Clamp (Qur'an 3:103, 42:13)",
                    0.875, 0.76, 3.40, SpcControlMatrix.SpcState.S2_CRITICAL,
                    1.41, SpcControlMatrix.SpcState.S0_OPTIMAL, 0.000
            ),
            new WrongdoerWarlockProfile(
                    5, 12,
                    "zalim-5-hawa",
                    "zalim-5-hawa.html",
                    "'Abid Al-Hawa",
                    "Muftari Al-Kadhib (Idolater of Sovereign Caprice & Fabricated Law)",
                    "اتِّبَاعُ الْهَوَى وَالِافْتِرَاءُ — Root: ه-و-ي (h-w-y: falling, capricious lust) & ف-ر-ي (f-r-y: forging lies against Allah)",
                    "Ittiba' Al-Hawa wa Al-Iftira' — Deification of Caprice & Fabricating Counterfeit Sacred Law",
                    ZalimPrincipleCategory.CAPRICIOUS_LAW_FABRICATION,
                    "#7A5901",
                    0x7A5901,
                    (~0x7A5901) & 0xFFFFFF,
                    "Qur'an 45:23 / 25:43 ('Have you seen he who takes his own desire [Hawa] as his god?'), Qur'an 6:140-144 ('Who then is more of a wrongdoer [azlamu] than one who invents a lie against Allah to mislead people without knowledge? Indeed, Allah guides not the wrongdoer people [al-qawm az-zalimin]'), Qur'an 7:33 ('...and that you say about Allah that which you do not know').",
                    "Historical adversary of Millat Ibrahim (personified in Amr ibn Luhayy and the Jahiliyyah law-forgers) who corrupted Abraham's pure monotheistic code by fabricating sacred exemptions and arbitrary livestock/ritual taboos (Bahirah, Sa'ibah, Wasilah, and Ham, Qur'an 5:103; and postponing the sacred months, An-Nasi'u ziyadatun fi al-kufr, Qur'an 9:37) to serve the economic and military caprice (Hawa) of the ruling elite.",
                    "Substitutes divine revelation (Al-Wahy) with arbitrary human appetite (Al-Hawa) and forged legal decrees (Al-Iftira' 'ala Allah), turning religion into a manipulable instrument of self-interest (H_raw = 0.905 bits, C_p = 0.73).",
                    "Quarantined in Priory Ward V (The Criterion Filter of Verified Knowledge, Qur'an 6:144 & 17:36). Purges every unrevealed fabrication (Iftira') and calendar manipulation (Nasi'), restoring H_resolved = 0.000 bits.",
                    "Quarantine Ward V: The Criterion Filter of Verified Knowledge (Qur'an 6:144, 17:36)",
                    0.905, 0.73, 3.55, SpcControlMatrix.SpcState.S2_CRITICAL,
                    1.40, SpcControlMatrix.SpcState.S0_OPTIMAL, 0.000
            ),
            new WrongdoerWarlockProfile(
                    6, 13,
                    "zalim-6-jibt",
                    "zalim-6-jibt.html",
                    "Kahin Al-Jibt",
                    "Sadin Asnam Azar (High Carver of Azar's Idol-Syndicate)",
                    "الْجِبْتُ وَالطَّاغُوتُ وَأَصْنَامُ آزَرَ — Root: ج-ب-ت (Al-Jibt: sorcery, superstition, idols) & ط-غ-ي (At-Taghut: false tyrannical deity)",
                    "Al-Jibt wa At-Taghut — Sorcerous Idolatry, Divination Arrows & Azar's Temple Oligarchy",
                    ZalimPrincipleCategory.SORCEROUS_IDOL_HEGEMONY,
                    "#1E4D3B",
                    0x1E4D3B,
                    (~0x1E4D3B) & 0xFFFFFF,
                    "Qur'an 4:51 ('Have you not seen those who were given a portion of the Scripture, who believe in Al-Jibt [sorcery/superstition] and At-Taghut?'), Qur'an 6:74 ('When Abraham said to his father Azar: Do you take idols [asnaman] as gods?'), Qur'an 21:52-58, Qur'an 5:90 ('Intoxicants, gambling, sacrificial stone altars [al-ansab], and divining arrows [al-azlam] are an abomination of Satan's handiwork').",
                    "Represents the entrenched temple-guild of Azar in Ur and the 360 idols later installed inside Abraham's Ka'bah (including Hubal and his divining arrows, Al-Azlam). When Abraham shattered the idols into fragments (fa-ja'alahum judhadhan, Qur'an 21:58) to prove they could neither speak nor defend themselves, this guild fought to preserve its lucrative monopoly of sorcery, oracle-arrows, and stone-worship against Abraham's iconoclastic Tawhid.",
                    "Binds the populace in fear of talismanic curses (Al-Jibt) and subservience to false intermediaries (At-Taghut), pulling consciousness out of the Light (An-Nur) into the Darknesses (Az-Zulumat, Qur'an 2:257) with H_raw = 0.940 bits and sigma = 3.75.",
                    "Quarantined in Priory Ward VI (The Iconoclastic Axe of Khalil-Allah, Qur'an 21:58 & 2:256: 'Whoever disbelieves in At-Taghut and believes in Allah has grasped the Most Trustworthy Handhold [Al-'Urwah Al-Wuthqa] with noellis of breaking'). Collapses H_raw = 0.940 bits to 0.000.",
                    "Quarantine Ward VI: The Iconoclastic Axe of Khalil-Allah (Qur'an 21:58, 2:256)",
                    0.940, 0.70, 3.75, SpcControlMatrix.SpcState.S2_CRITICAL,
                    1.39, SpcControlMatrix.SpcState.S0_OPTIMAL, 0.000
            ),
            new WrongdoerWarlockProfile(
                    7, 14,
                    "zalim-7-zulm",
                    "zalim-7-zulm.html",
                    "Imam Az-Zalimin",
                    "Bani Juruf Al-Har (Arch-Wrongdoer of the Crumbling Cliff & Counter-Sanctuary)",
                    "الظُّلْمُ الْأَكْبَرُ وَمَسْجِدُ الضِّرَارِ — Root: ظ-ل-م (z-l-m: placing a thing outside its rightful place; encroaching darkness)",
                    "Az-Zulm Al-Akbar wa Masjid Ad-Dirar — The Supreme Wrongdoer & Counter-Sanctuary Subversion",
                    ZalimPrincipleCategory.COVENANT_EXCLUSION_AND_COUNTER_SANCTUARY,
                    "#0D0A14",
                    0x0D0A14,
                    (~0x0D0A14) & 0xFFFFFF,
                    "Qur'an 2:124 ('Allah said: Indeed, I am making you [Abraham] an Imam for mankind. Abraham asked: And of my descendants? Allah said: My Covenant does not include the Wrongdoers [La yanalu 'ahdi az-zalimin]'), Qur'an 31:13 ('Inna ash-shirka la-zulmun 'azim'), Qur'an 2:114, Qur'an 9:107-109 ('And those who took a mosque for harm [diraran], disbelief, and division among the believers... Is one who founded his building on Taqwa from Allah better, or one who founded his building on the brink of a crumbling cliff [shafa jurufin harin] so it collapsed with him into the fire of Hell? And Allah guides not the Zalimin').",
                    "The apex Wrongdoer (Az-Zalim) whom Allah explicitly barred from inheriting Abraham's Covenant in Qur'an 2:124, even if claiming genealogical descent from Abraham. Rather than fighting Abraham's Sanctuary solely from the outside, this archetype builds a counterfeit religious institution (Masjid Ad-Dirar) disguised as a house of prayer in order to hollow out the Abrahamic hegemony from within, bar Allah's name from His true sanctuaries (Qur'an 2:114), and replace the Foundation of Taqwa with a hollow precipice of hypocrisy (Nifaq) and Shirk.",
                    "Synthesizes all six preceding corruptions (Fasad, Fahishah, Baghy, Fitnah, Hawa, and Jibt) into an institutionalized Counter-Sanctuary perched on the brink of a crumbling cliff (shafa jurufin harin), pushing raw disorder to the terminal S2/S3 threshold (H_raw = 0.985 bits, C_p = 0.68, sigma = 3.92).",
                    "Quarantined in Priory Ward VII (The Abrahamic Covenant Exclusion Seal, Qur'an 2:124 & 9:108-109: 'Never stand therein! A sanctuary founded upon Taqwa from the first day is worthier that you stand therein'). Sigma -1n and GEMINI.md Dynamic Shunt Attenuation isolate the crumbling cliff and collapse H_raw = 0.985 bits to 0.000.",
                    "Quarantine Ward VII: The Abrahamic Covenant Exclusion Seal (Qur'an 2:124, 9:108-109)",
                    0.985, 0.68, 3.92, SpcControlMatrix.SpcState.S2_CRITICAL,
                    1.38, SpcControlMatrix.SpcState.S0_OPTIMAL, 0.000
            )
    );

    public static List<WrongdoerWarlockProfile> allCanonicalZalimProfiles() {
        return CANONICAL_ZALIM_PROFILES;
    }

    public static WrongdoerWarlockProfile forZalimIndex(int zalimIndex) {
        return CANONICAL_ZALIM_PROFILES.stream()
                .filter(p -> p.zalimIndex() == zalimIndex)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown zalimIndex: " + zalimIndex));
    }

    public static WrongdoerWarlockProfile forProfileId(String profileId) {
        return CANONICAL_ZALIM_PROFILES.stream()
                .filter(p -> p.profileId().equalsIgnoreCase(profileId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown zalim profileId: " + profileId));
    }
}
