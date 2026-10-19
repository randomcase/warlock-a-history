package com.sovereign.warlock.domain;

import java.util.List;

/**
 * Canonical Synthesis of the Greco-Roman Pantheon, the Titanomachy, the 12 Olympians (3, 12, 14 Canon),
 * Roman Numina & Apotheosis, Morpheus & the Oneiroi (Somnia), the 7 Erotes, and the Complete 5-Domain
 * Catalog of Minor Greek Deities & Spirits (Daimones, Nymphs, Theoi Nomioi, Chthonic, Household Guardians)
 * — together with how each was received by monotheistic Muslim scholars (Bayt al-Hikmah, Kalam, Falsafah,
 * Ishraqi & Akbarian Sufism, and Qur'anic Tafsir), judged under Al-Furqan, and made whole in Tawhid
 * just as the Titans were made whole.
 */
public final class GrecoRomanPantheonIslamicJudgmentAndWholeness {

    private GrecoRomanPantheonIslamicJudgmentAndWholeness() {
    }

    /**
     * Represents one of the 7 Tiers of Godhood adopted by the Greeks and Romans,
     * its classical structure, how Muslim scholars received and judged it, and how Islam made it whole.
     */
    public record GodhoodHierarchyTier(
            int tierIndex,
            String tierCode,
            String greekAndRomanClassification,
            String classicalNatureAndExamples,
            String islamicHistoricalReception,
            String islamicTheologicalJudgment,
            String howMadeWholeInTawhid,
            String quranicAndHadithAnchor
    ) {
        public GodhoodHierarchyTier {
            if (tierIndex < 1 || tierIndex > 7) {
                throw new IllegalArgumentException("tierIndex must be in [1..7]");
            }
        }
    }

    /**
     * Represents how a specific Titan or Titanomachy motif (Hesiod, Eumelos, Orphics, Thamyris, Apollodorus)
     * was judged and healed ("made whole") in Islamic monotheism.
     */
    public record TitanomachyWholenessEntry(
            int titanIndex,
            String titanOrSourceName,
            String classicalTitanomachyFracture,
            String islamicJudgmentOfTheMyth,
            String howTitanIsMadeWholeInIslam,
            String quranicAndPropheticProof
    ) {
    }

    /**
     * Represents Hypnos/Somnus, Morpheus, Phobetor/Icelus, and Phantasos (The Oneiroi / Somnia)
     * and their exact reception, judgment, and integration into Islamic Dream Science ('Ilm Ta'bir Ar-Ru'ya).
     */
    public record OneiroiDreamJudgmentEntry(
            int dreamIndex,
            String greekAndRomanName,
            String classicalDomainAndEtymology,
            String islamicDreamClassification,
            String howJudgedAndMadeWhole,
            String quranicAndHadithProof
    ) {
    }

    /**
     * Represents one of the 7 Erotes (Winged Love Deities) and how it is judged and made whole
     * within the Islamic architecture of Love (Al-Mahabbah, Al-Mawaddah, Ar-Rahmah & An-Nikah).
     */
    public record ErotesLoveJudgmentEntry(
            int eroteIndex,
            String eroteName,
            String greekAspectAndSymbol,
            String islamicCounterpartStation,
            String judgmentOfUnlawfulExcess,
            String howMadeWholeInIslamicLove,
            String quranicAndHadithProof
    ) {
    }

    /**
     * Represents one of the 5 Major Domains of Minor Greek Deities & Spirits (comprising the hundreds
     * of Daimones, Nymphs, Theoi Nomioi, Chthonic beings, and Domestic/Apotheosized spirits)
     * with exhaustive sub-group listings, Islamic judgment, and restoration to wholeness.
     */
    public record MinorSpiritDomainCatalog(
            int domainIndex,
            String domainCode,
            String domainTitle,
            String colorHex,
            String exhaustiveGreekSpiritRoster,
            String classicalRitualAndRole,
            String islamicReceptionAndJudgment,
            String howMadeWholeInIslam,
            String quranicAndSunnahAnchor
    ) {
    }

    private static final List<GodhoodHierarchyTier> SEVEN_GODHOOD_TIERS = List.of(
            new GodhoodHierarchyTier(
                    1,
                    "TIER_1_PROTOGENOI_PRIMORDIALS",
                    "1st Generation: Primordial Deities (Protogenoi — Chaos, Gaia/Terra, Ouranos/Caelus, Nyx, Erebus, Tartarus)",
                    "Self-born elemental fabric of the universe prior to anthropomorphic gods: Chaos (Void), Gaia/Tellus (Earth), Ouranos/Caelus (Sky), Nyx (Night).",
                    "Translated and analyzed by Bayt al-Hikmah cosmologists, Al-Biruni, and Ash-Shahrastani as ancient materialist/naturalist confusions ('Ad-Dahriyyah' & 'At-Tabi'iyyun') that mistook the created macrocosm for uncreated deities.",
                    "Judged under Qur'an 6:76-79 (Abraham's rejection of star, moon, and sun worship) and Qur'an 41:37 ('Do not prostrate to the sun or to the moon, but prostrate to Allah, who created them').",
                    "Made whole by restoring Sky (As-Sama'), Earth (Al-Ard), Night (Al-Layl), and Ocean (Al-Bahr) from warring primordial parents into obedient, praising liturgical creations (Muslimat) that willingly answered Allah: 'We come willingly (Atayna Ta'i'in)' (Qur'an 41:11).",
                    "Qur'an 21:30 (Ratq & Fatq), 41:11, 6:76-79 & 41:37"
            ),
            new GodhoodHierarchyTier(
                    2,
                    "TIER_2_TITANS_AND_TITANOMACHY",
                    "2nd Generation: The Titans & The Titanomachy (Cronus/Saturn, Rhea, Themis, Atlas, Prometheus, Hyperion, Oceanus, Mnemosyne)",
                    "First anthropomorphic cosmic rulers born of Gaia and Ouranos; overthrown by Zeus and the Olympians in the ten-year Titanomachy (Hesiod's Theogony, Eumelos' lost Epic Cycle Titanomachy, Thamyris' Titanomachia, Apollodorus' Bibliotheca, and Orphic Titanic ash myths).",
                    "Studied by Muslim historians and Ishraqi philosophers as the archetypal myth of polytheistic cosmic civil war (Fasad al-Alihah), proving Qur'an 21:22 ('Had there been within the heavens and earth gods besides Allah, both would have been ruined').",
                    "Judged false in its claim of generational parricide, divine castration, and jealous gods torturing benefactors of mankind (Prometheus) or crushing sky-bearers (Atlas) in Tartarus.",
                    "Made whole by healing every Titanic archetype in Tawhid: Time (Cronus/Ad-Dahr) ceases to devour its children and becomes Allah's sacred measure (Bukhari 4826); Atlas becomes the joyous Throne-Bearing Angels (Hamalatu Al-'Arsh, Qur'an 40:7); Prometheus becomes Allah's generous teaching of all Names and gifting of fire/iron to Adam (Qur'an 2:31, 36:80, 57:25); and Themis becomes the Cosmic Scale (Al-Mizan, Qur'an 55:7-9).",
                    "Qur'an 21:22, 23:91 ('Nor was there with Him any god, or each god would have taken what he created'), 40:7 & 2:31"
            ),
            new GodhoodHierarchyTier(
                    3,
                    "TIER_3_OLYMPIANS_DII_CONSENTES_SOTERES",
                    "3rd Generation: The 12 Olympians (Dodekatheon), Roman Dii Consentes, The Big 3 & The 14 Canon (Theoi Soteres)",
                    "The Big 3 Brothers (Zeus/Jupiter, Poseidon/Neptune, Hades/Pluto), the 12 Olympians (6 Gods: Zeus, Poseidon, Ares/Mars, Apollo, Hermes/Mercury, Hephaestus/Vulcan; 6 Goddesses: Hera/Juno, Athena/Minerva, Aphrodite/Venus, Artemis/Diana, Demeter/Ceres, Hestia/Vesta or Dionysus/Bacchus), and the 14 Major Canon.",
                    "Cataloged in detail by Ash-Shahrastani (Al-Milal wa An-Nihal), Al-Mas'udi (Muruj Adh-Dhahab), and Al-Biruni, who noted how the 12 Olympians mirrored the 12 zodiacal signs and planetary spheres.",
                    "Judged under Qur'an 12:39-40 ('Are separate lords better, or Allah, the One, the Prevailing?') and Qur'an 17:42 ('If there had been with Him other gods, as they say, then they would have sought a way to the Owner of the Throne').",
                    "Made whole by reuniting the 12 fragmented departmental sovereignties (sky-rule, sea-rule, wisdom, provision, healing, craftsmanship) back into the 99 Beautiful Names of the One Lord (Al-Asma' Al-Husna: Al-Malik, Al-'Alim, Ar-Razzaq, Al-Bari', Al-Hadi), while recognizing the 12 months/constellations as created astronomical signs (Qur'an 9:36, 15:16).",
                    "Qur'an 12:39-40, 17:42, 59:22-24 (Al-Asma' Al-Husna) & 9:36 (Twelve Months)"
            ),
            new GodhoodHierarchyTier(
                    4,
                    "TIER_4_ROMAN_NUMINA_AND_GENII",
                    "Roman Indigenous Functional Spirits (Numina — Janus, Robigo, Cunina) & Personal Guiding Spirits (Genius / Juno)",
                    "Shapeless, hyper-specialized Roman divine wills inhabiting thresholds and micro-tasks: Janus (doorways/transitions), Robigo (wheat mildew), Cunina (cradles), plus every man's personal Genius and woman's Juno.",
                    "Compared by Muslim jurists and theologians to pre-Islamic household/agricultural talismans and the universal human intuition that every threshold, crop, and soul is under unseen watchfulness.",
                    "Judged as a misdirection of gratitude and refuge toward created micro-causes (Asbab) instead of the Lord of Causes (Musabbib Al-Asbab).",
                    "Made whole through the Prophetic Adhkar of every threshold (Bismillah upon entering/leaving doorways in place of Janus, Abu Dawud 5095), seeking Allah's blessing in crops and infant cradles (replacing Robigo/Cunina), and replacing the pagan Genius with the canonical Guardian Angels (Al-Mu'aqqibat / Hafazah, Qur'an 13:11 & 82:10-12) and the purified Qarin (Muslim 2814).",
                    "Qur'an 13:11 (Al-Mu'aqqibat), 82:10-12 (Kiraman Katibin) & Sahih Muslim 2814"
            ),
            new GodhoodHierarchyTier(
                    5,
                    "TIER_5_CHTHONIC_AND_UNDERWORLD_DEITIES",
                    "Chthonic & Underworld Deities (Hades/Pluto/Dis Pater, Persephone, Hecate, Charon, Erinyes/Furies, Judges Minos/Rhadamanthus/Aeacus, Trophonius)",
                    "Subterranean rulers of the dead, nocturnal witchcraft (Hecate), ferryman of souls (Charon), avengers of blood-guilt and perjury (Erinyes), phantom terrors (Empusa, Lamia, Mormo), and subterranean oracles.",
                    "Dissected by Muslim scholars of comparative religion and Jinnology (Ibn Taymiyyah, Ash-Shibli's Akam Al-Marjan, Al-Jahiz) as a mixture of distorted afterlife memory (Barzakh) and subterranean Jinn/Shayatin masquerading as chthonic oracles.",
                    "Nocturnal blood-sacrifices to chthonic spirits and witchcraft (Hecate) are strictly judged as Shirk and Sihr (Qur'an 2:102, 6:128); mortal kings (Minos, Rhadamanthus, Aeacus) have zero jurisdiction to judge the dead.",
                    "Made whole by restoring sole judgment of the dead to Allah, Master of the Day of Judgment (Maliki Yawm Ad-Din, Qur'an 1:4), replacing Charon and the Erinyes with the canonical Angels of Death and Barzakh Inquiry (Malak Al-Mawt, Munkar & Nakir, Maalik), and replacing blood-feud curses with lawful Qisas and merciful pardon ('Afw, Qur'an 2:178).",
                    "Qur'an 1:4, 32:11 (Angel of Death), 23:100 (Al-Barzakh) & 6:128"
            ),
            new GodhoodHierarchyTier(
                    6,
                    "TIER_6_DAIMONES_ONEIROI_AND_EROTES",
                    "Abstract Personifications (Daimones), Dream Gods (Hypnos, Morpheus, Phobetor, Phantasos) & Love Troupe (The 7 Erotes)",
                    "Personified psychological states, virtues, vices, emotions (Nike, Dike, Aidos, Eris, Phobos, Nemesis, Hygieia), the thousand dream shapes (Oneiroi/Somnia), and the 7 winged love brothers (Eros, Anteros, Himeros, Pothos, Hedylogos, Hymenaeus, Hermaphroditus).",
                    "Intensively studied by Hunayn ibn Ishaq, Al-Kindi, Al-Farabi, Ibn Sina, Al-Ghazali, Ibn Hazm, and Ibn 'Arabi in Islamic psychology ('Ilm An-Nafs), ethics ('Ilm Al-Akhlaq), and dream interpretation ('Ilm Ta'bir Ar-Ru'ya).",
                    "Judged not as independent external gods, but as three distinct realities: (1) Reflections of Allah's Beautiful Names (Dike -> Al-'Adl, Eleos -> Ar-Rahim, Nike -> An-Nasir); (2) Noble Stations of the Heart (Maqamat Al-Qalb: Aidos -> Al-Haya', Pistis -> Al-Iman, Sophrosyne -> Al-'Iffah); and (3) Spiritual Diseases / Whisperings of Shaytan (Eris -> Fitnah, Hybris -> Kibr, Ate -> Ghurur).",
                    "Made whole by integrating every virtue into Prophetic character ('Innama bu'ithtu li-utammima makarim al-akhlaq' — 'I was sent only to perfect noble character'), healing every vice through Tazkiyat An-Nafs, and uniting the 3 Oneiroi and 7 Erotes under Prophetic Dream Science and Sacred Love.",
                    "Qur'an 91:7-10 (Tazkiyat An-Nafs), Bukhari 6985-7017 (Ru'ya) & Musnad Ahmad 8952"
            ),
            new GodhoodHierarchyTier(
                    7,
                    "TIER_7_APOTHEOSIS_DEMIGODS_AND_SYNCRETISM",
                    "Demigods (Hemitheoi), Deified Mortals & Imperial Cults (Apotheosis — Heracles, Asclepius, Divus Julius) & Syncretic Gods (Isis, Mithras, Cybele)",
                    "Mortal heroes or Roman Emperors voted into godhood after death (Heracles, Asclepius, Julius Caesar) and foreign mystery deities absorbed into Greco-Roman state religion.",
                    "Recognized by Ibn Abi Usaybi'ah ('Uyun Al-Anba'), Al-Qifti, and Ibn Kathir as the exact historical mechanism of idol-genesis described in Surah Nuh (71:23), where righteous sages, healers (Asclepius/Asqlibiyus, disciple of Hermes/Idris), and kings were posthumously deified.",
                    "Imperial self-deification (Divus Julius, Nimrod, Pharaoh) is judged as tyrannical Taghut (Qur'an 79:24), while deifying righteous healers and prophets against their will is refuted by Qur'an 3:79-80 and 5:116-117.",
                    "Made whole by rescuing righteous sages and healers (Asclepius, Hermes/Idris, Luqman) from the slander of pagan apotheosis—honoring their medical and ethical wisdom as a gift from Allah, the True Healer (Ash-Shafi, Qur'an 26:80)—and replacing demigod hero-worship with the rank of Awliya' (Friends of Allah) and Shuhada' who remain humble servants ('Abid).",
                    "Qur'an 3:79-80, 71:23, 26:80 ('And when I am ill, it is He who cures me — Ash-Shafi') & Bukhari 4920"
            )
    );

    private static final List<TitanomachyWholenessEntry> SEVEN_TITANOMACHY_RESTORATIONS = List.of(
            new TitanomachyWholenessEntry(
                    1,
                    "Hesiod's Theogony & The Castration of Ouranos / Overthrow of Cronus",
                    "In Hesiod's Theogony (c. 700 BC), cosmic order begins with violent alienation: Ouranos hates his children and hides them in Gaia's bowels; Cronus castrates his father with a flint sickle; and Zeus wages a 10-year war (Titanomachy) using the Hecatonchires and Cyclopes to hurl the male Titans into Tartarus.",
                    "Islamic theology judges this myth through Qur'an 21:22 and 23:91: polytheism inevitably projects human dynastic usurpation, succession anxiety, and parricide onto the heavens.",
                    "Islam makes the cosmic origin whole through Qur'an 21:30 and 41:11: Heaven and Earth were a single unified seam (Ratq) that Allah parted (Fatq) in wisdom, and when He called Heaven and Earth, both answered in peace: 'We come willingly (Atayna Ta'i'in).' There is zero parricide in creation.",
                    "Qur'an 21:22, 21:30, 23:91 & 41:11"
            ),
            new TitanomachyWholenessEntry(
                    2,
                    "Cronus / Khronos (The Child-Devouring Titan of Time & The Golden Age)",
                    "Fearing a prophecy that his own child would overthrow him, Cronus swallowed Hestia, Demeter, Hera, Hades, and Poseidon at birth until Rhea tricked him with the Omphalos stone and Apollodorus' emetic potion forced him to regurgitate them.",
                    "Judged as the pagan terror of Time (Ad-Dahr) seen as a blind, devouring monster that consumes its own offspring and must be drugged or chained in Tartarus.",
                    "Made whole by the Prophetic Hadith Qudsi (Bukhari 4826): 'Allah said: The son of Adam wrongs Me when he curses Time (Ad-Dahr), for I am Ad-Dahr; in My Hand is the command, and I turn the night and the day.' In Surah Al-'Asr (103:1-3), Time is restored as the blessed treasury in which believers harvest eternal life, and Cronus's 'Golden Age' is fulfilled in the Primordial Covenant of Al-Alast (Qur'an 7:172).",
                    "Sahih al-Bukhari 4826 (Hadith Qudsi on Ad-Dahr), Qur'an 103:1-3 & 45:24"
            ),
            new TitanomachyWholenessEntry(
                    3,
                    "Atlas (The Condemned Titan Crushed Under the Vault of Heaven)",
                    "As punishment for leading the Titans in the Titanomachy, Zeus condemned Atlas to stand forever at the western edge of the earth holding up the crushing weight of the sky (Ouranos) upon his shoulders.",
                    "Judged as a tragic distortion of how the heavens are sustained: in pagan myth, cosmic architecture rests on penal slavery and crushed rebellion.",
                    "Made whole in Qur'an 35:41 ('Indeed, Allah holds the heavens and the earth, lest they cease') and Qur'an 40:7 & 69:17: the Eight Angelic Bearers of the Throne (Hamalatu Al-'Arsh) bear the supernal canopy not in penal agony, but effortless through the power of Dhikr ('La hawla wa la quwwata illa billah'), continuously praying for the forgiveness of believers on earth.",
                    "Qur'an 35:41, 40:7-9 & 69:17 (Hamalatu Al-'Arsh)"
            ),
            new TitanomachyWholenessEntry(
                    4,
                    "Prometheus (The Chained Titan of Forethought, Stolen Fire & Human Craft)",
                    "Because Zeus wished to keep mankind ignorant and fireless, the Titan Prometheus stole fire in a fennel stalk and taught humans metallurgy and arts—for which Zeus chained him to Mount Caucasus where an eagle tore his liver daily.",
                    "Judged as the ultimate indictment of pagan gods: a jealous deity (Zeus) who resents human knowledge and punishes benevolence, forcing humanity to view science and technology as a 'Promethean theft' against heaven.",
                    "Made whole by Qur'an 2:30-34, 36:80, 57:25, and 96:1-5: Allah Himself appointed Adam as Vicegerent (Khalifah), taught Adam ALL the Names directly ('Wa 'allama Adama al-asma'a kullaha'), commanded the angels to bow to him, created fire from the green tree as a gift (Qur'an 36:80), and sent down iron for human civilization (Qur'an 57:25). Forethought (Tadbir) and science are divinely mandated stewardship, never a theft.",
                    "Qur'an 2:30-34, 36:80, 57:25 & 96:1-5"
            ),
            new TitanomachyWholenessEntry(
                    5,
                    "Themis (Titaness of Divine Law) & Mnemosyne (Titaness of Memory)",
                    "Even in Hesiod, Themis (Divine Order) and Mnemosyne (Memory) were elder Titanesses whom Zeus had to marry/absorb to produce the Horae (Eunomia, Dike, Eirene), the Moirai, and the Muses—because raw Olympian thunderbolt force (Kratos/Bia) lacked intrinsic moral law and memory.",
                    "Recognized by Muslim philosophers (and embodied in our @themis-agent & @pantheon-synthesis-guardrail-agent) as the Greeks' admission that power without eternal Law and Memory is illegitimate.",
                    "Made whole in Qur'an 55:7-9 ('And the heaven He raised and imposed the Balance [Al-Mizan]') and Qur'an 85:22 (Al-Lawh Al-Mahfuz — The Preserved Tablet of Cosmic Memory): Divine Power (Al-Qudrah), Divine Law (Al-Mizan / Ash-Shari'ah), and All-Encompassing Memory ('Ilm Allah & Dhikr, Qur'an 20:52 'My Lord neither errs nor forgets') are eternally united in the One Essence.",
                    "Qur'an 55:7-9 (Al-Mizan), 20:52 ('La yadillu Rabbi wa la yansa') & 85:22"
            ),
            new TitanomachyWholenessEntry(
                    6,
                    "Lost Epic Cycle Titanomachy (Eumelos / Arctinus) & Thamyris' Titanomachia",
                    "Surviving fragments in Proclus, Athenaeus, and Pseudo-Plutarch's On Music describe Zeus dancing in triumph, the hundred-handed sea-giant Aegaeon allying with the Titans of the sea, and the blind Thracian bard Thamyris singing of cosmic war.",
                    "Analyzed as fragmentary poetic echoes of ancient deluges and cosmic convulsions where sea-forces and sky-forces contended.",
                    "Made whole in the Qur'anic account of the Great Deluge of Nuh (Qur'an 11:40-44 & 54:11-12), where the fountains of the earth burst forth and the gates of heaven poured water not in a war between sea-giants and sky-gods, but by a single unified Divine Command—until Allah said: 'O earth, swallow your water, and O sky, withhold!' (Qur'an 11:44).",
                    "Qur'an 11:44 (Supreme Eloquence over Sky and Sea) & 54:11-12"
            ),
            new TitanomachyWholenessEntry(
                    7,
                    "The Orphic Titanomachy (Humanity Molded from the Soot & Ashes of Blasted Titans)",
                    "In Orphic mystical literature, the Titans tore apart the infant Dionysus/Zagreus and were blasted to ash by Zeus's thunderbolts; from this Titanic soot mixed with divine blood, humanity was formed—making the human body an inherently polluted, 'Titanic' prison.",
                    "Refuted by Islamic anthropology as a tragic slander against both the human body and the soul's origin.",
                    "Made whole by Qur'an 95:4 ('We have certainly created man in the best of stature — Fi Ahsani Taqvim'), Qur'an 15:28-29 ('When I have proportioned him and breathed into him of My Spirit'), and the Hadith of Fitrah (Bukhari 1358). Human clay is not the ash of rebel Titans; it is honored earth kneaded by Divine Mercy and crowned with the Spirit.",
                    "Qur'an 95:4, 15:28-29, 17:70 ('We have honored the children of Adam') & Bukhari 1358"
            )
    );

    private static final List<OneiroiDreamJudgmentEntry> FOUR_ONEIROI_DREAM_ENTRIES = List.of(
            new OneiroiDreamJudgmentEntry(
                    1,
                    "Hypnos / Somnus (God of Sleep) & His Twin Brother Thanatos (Peaceful Death) — Born of Nyx (Hesiod) or Wed to Pasithea",
                    "Oversees physical slumber, rest, and oblivion; twin brother to peaceful Death (Thanatos) and father/brother to the thousand dream-shapes (Oneiroi / Somnia) passing through the Gates of Horn and Ivory.",
                    "An-Nawm (Al-Mawt Al-Asghar — The Minor Death) & Subat (Restorative Slumber)",
                    "Judged and made whole directly by Qur'an 39:42: 'Allah takes the souls at the time of their death, and those that do not die during their sleep. Then He keeps those for which He has decreed death and releases the others for a specified term.' Sleep is not a separate deity (Hypnos), nor is Death (Thanatos); both are the twin operations of Allah gently receiving the human soul (Ruh) every night and returning it at dawn—hence the Prophetic waking prayer: 'Praise be to Allah who gave us life after causing us to die, and to Him is the resurrection' (Bukhari 6312).",
                    "Qur'an 39:42, 78:9 ('And We made your sleep a means for rest — Subatan') & Sahih al-Bukhari 6312"
            ),
            new OneiroiDreamJudgmentEntry(
                    2,
                    "Morpheus (Leader of the Oneiroi — Shapeshifter of Human Forms & Royal Messenger, Ovid's Metamorphoses XI)",
                    "From Greek morphe ('form/shape' -> morphology, morphine). Specialized exclusively in mimicking human beings—their exact walk, face, voice, and garments—to deliver vivid messages to kings and heroes (such as appearing as drowned King Ceyx to Queen Alcyone).",
                    "Type I of the Prophetic Triad: Ar-Ru'ya As-Salihah (The True / Veridical Vision from Allah — 1/46th of Prophecy) & Angelic Tamaththul in 'Alam Al-Mithal",
                    "When Hunayn ibn Ishaq translated Greek dream lore and Muslim sages (Ibn Sirin, Al-Kindi, Ibn Sina, Ibn 'Arabi) judged Morpheus under the Sunnah, they separated false impersonation from true angelic representation: (1) Shaytan is barred by Allah from ever assuming the human form of Prophet Muhammad ﷺ ('Whoever sees me in a dream has truly seen me, for Shaytan cannot impersonate me', Bukhari 6993); (2) Morpheus's domain is made whole as the Angel of Dreams (Malak Ar-Ru'ya) who shapes veridical human symbols in the Imaginal World ('Alam Al-Mithal) to bring glad tidings (Mubashshirat, Qur'an 10:64) and royal wisdom (like the King of Egypt's dream interpreted by Prophet Yusuf in Qur'an 12:43-49).",
                    "Sahih al-Bukhari 6989, 6993, 7017, Qur'an 10:64 (Al-Bushra) & Surah Yusuf 12:4-49"
            ),
            new OneiroiDreamJudgmentEntry(
                    3,
                    "Phobetor / Icelus (The Frightener — Master of Beast Forms, Monsters & Nightmares -> 'Phobia')",
                    "Called Icelus ('Like') by the gods and Phobetor ('The Frightener') by mortals; shapeshifts into terrifying beasts, serpents, birds of prey, and monsters to induce panic and nightmares.",
                    "Type II of the Prophetic Triad: Al-Hulum / Tahwil Ash-Shaytan (The Terrifying Nightmare from Shaytan)",
                    "Judged by the Prophet ﷺ in Sahih al-Bukhari 6995 & 7017 as an empty, powerless intimidation (Tahwil) from Shaytan meant solely to sadden the believer (Qur'an 58:10). Islam strips Phobetor of all divine terror and makes the sleeper whole through the five-step Prophetic shield: (1) spit dryly three times to the left; (2) seek refuge in Allah three times from Shaytan and from the evil of what was seen; (3) turn over onto the other side; (4) stand and pray if desired; and (5) narrate the nightmare to no one—'for then it will never harm him' (Bukhari 6985, Muslim 2261).",
                    "Sahih al-Bukhari 6985, 6995, 7017, Sahih Muslim 2261 & Qur'an 58:10 ('Innama an-najwa min ash-shaytan li-yahzuna alladhina amanu')"
            ),
            new OneiroiDreamJudgmentEntry(
                    4,
                    "Phantasos (Master of Inanimate Forms, Surreal Landscapes, Water, Rocks & Architecture -> 'Fantasy / Phantasm')",
                    "Bypasses living beings to transform into earth, rocks, rivers, trees, garments, and shifting architectural structures in dreams.",
                    "Type III of the Prophetic Triad: Hadith An-Nafs (The Soul's Subconscious Echoes) & Symbolic Landscape Ta'bir in 'Alam Al-Khayal",
                    "Judged and made whole in two precise ways: (1) When inanimate dream-shapes are mere daytime mental residue, they are classified as Hadith An-Nafs (the soul talking to itself), carrying neither legal weight nor anxiety; (2) When they appear in a lucid vision, Islamic Ta'bir (as practiced by the Prophet ﷺ in Bukhari 7006-7009 and codified by Ibn Sirin and Ibn 'Arabi) decodes every inanimate object as a precise spiritual sign: Milk = primordial Fitrah; a flowing River = living knowledge; a long Shirt (Qamis) = one's Din/Taqwa; a firm Pillar/Rope = the Unbreakable Handhold (Al-'Urwah Al-Wuthqa).",
                    "Sahih al-Bukhari 7006 (Cup of Milk = Fitrah), 7008 (Shirt = Religion), 7017 (Three Types of Dreams) & Ibn 'Arabi's Fusus Al-Hikam"
            )
    );

    private static final List<ErotesLoveJudgmentEntry> SEVEN_EROTES_LOVE_ENTRIES = List.of(
            new ErotesLoveJudgmentEntry(
                    1,
                    "Eros (Primordial & Winged God of Romantic Passion — Golden & Leaden Arrows; Wed to Psyche)",
                    "Driving force of attraction and procreation; later depicted shooting golden arrows of uncontrollable passion and leaden arrows of revulsion; tested and wed the mortal soul Psyche.",
                    "Al-Mahabbah Al-Asliyyah & Al-Mawaddah wa Ar-Rahmah (Primordial Binding Love & The Ascent of An-Nafs Al-Mutma'innah)",
                    "Judged false in its pagan fatalism—where a blind, mischievous boy shoots capricious arrows to force adulterous or destructive passions (Hawa) and then blames the gods.",
                    "Made whole by recognizing that Love (Al-Mahabbah) is the deliberate cosmic decree of Al-Wadud (The Loving, Qur'an 85:14 & 30:21), while the myth of Eros and Psyche (the Soul purified through trials) is fulfilled in the journey of An-Nafs (from Ammarah to Lawwamah to Mutma'innah, Qur'an 89:27-30) ascending to the supreme love of Allah ('Those who believe are stronger in love for Allah', Qur'an 2:165).",
                    "Qur'an 2:165, 30:21 (Mawaddah wa Rahmah), 85:14 (Al-Ghafur Al-Wadud) & 89:27-30"
            ),
            new ErotesLoveJudgmentEntry(
                    2,
                    "Anteros (God of Requited / Mutual Love & Avenger of Unrequited Coldness)",
                    "Butterfly-winged brother of Eros born so love could grow through reciprocity; punishes those who coldly spurn or exploit sincere affection.",
                    "Al-Mahabbah Al-Mutabadalah & Al-Mu'asharah bi-l-Ma'ruf (Reciprocal Covenant Love & Mutual Garment Equity)",
                    "Stripped of vengeful pagan curses while affirming the moral law that love and marital rights require justice and reciprocity ('Walahunna mithlu alladhi 'alayhinna bi-l-ma'ruf', Qur'an 2:228).",
                    "Made whole at both the Divine and human levels: toward Allah, 'He loves them and they love Him' (Yuhibbuhum wa yuhibbunahu, Qur'an 5:54); between spouses, 'They are a garment for you and you are a garment for them' (Qur'an 2:187), where emotional cruelty or leaving a spouse suspended ('ka-al-mu'allaqah', Qur'an 4:129) is forbidden.",
                    "Qur'an 5:54, 2:187, 2:228 & 4:129"
            ),
            new ErotesLoveJudgmentEntry(
                    3,
                    "Himeros (God of Immediate, Urgent Physical Desire & Impetuous Lust)",
                    "Rose from the sea-foam alongside Aphrodite (Hesiod's Theogony); represents the sudden, burning physical urge for union.",
                    "Ash-Shahwah Al-Mubahah (Sanctified Physical Desire Rewarded as Sadaqah in Nikah)",
                    "When unleashed outside marriage as Zina or visual trespass, it is judged and barred by Qur'an 17:32 ('Do not approach unlawful sexual intercourse') and 24:30-31 (lowering the gaze).",
                    "Unlike ascetic traditions that demonized physical desire itself, Islam makes Himeros whole without suppressing human nature: in Sahih Muslim 1006, the Prophet ﷺ declared: 'In the intimate union of one of you with his spouse there is a charity (Sadaqah)!' Channeling urgent desire into the lawful sanctuary of Nikah transforms raw biological impulse into rewarded worship.",
                    "Sahih Muslim 1006 ('Fi bud'i ahadikum sadaqah'), Qur'an 2:223 & 24:30-32"
            ),
            new ErotesLoveJudgmentEntry(
                    4,
                    "Pothos (God of Yearning, Longing, Ache & Nostalgia for an Absent Beloved)",
                    "Governs the bittersweet ache of missing someone far away or yearning for a beloved beyond immediate reach.",
                    "Ash-Shawq wa Al-Hanin (Sacred Longing for the Divine Meeting & Loyal Remembrance of the Beloved)",
                    "Judged when it degenerates into despairing obsession ('Ishq Muhlik) over forbidden objects that distracts the heart from its Lord.",
                    "Made whole in two luminous forms: (1) Loyal human fidelity across distance and time (as when the Prophet ﷺ cherished Khadijah's memory decades after her passing, Bukhari 3818); and (2) Supreme spiritual longing (Ash-Shawq ila Liqa' Allah), immortalized in the Prophetic supplication: 'I ask You for the delight of gazing upon Your Face and the longing (Ash-Shawq) to meet You' (An-Nasa'i 1305) and Ibn Qayyim's Rawdat Al-Muhibbin.",
                    "Sunan An-Nasa'i 1305, Sahih al-Bukhari 3584 (Hanin Al-Jidh') & 3818 (Fidelity to Khadijah)"
            ),
            new ErotesLoveJudgmentEntry(
                    5,
                    "Hedylogos (God of Sweet-Talk, Flattery, Poetic Courtship & Whispered Praise)",
                    "Personifies smooth words, romantic compliments, and persuasive poetic courtship.",
                    "Al-Kalimah At-Tayyibah, At-Ta'rid fi Al-Khitbah & Husn Al-Kalam (Honorable Courtship & Tender Spousal Speech)",
                    "Deceptive flattery, false promises, and seductive speech toward the unlawful (Khudu' bi-l-Qawl, Qur'an 33:32) are judged as hypocrisy and Gharar.",
                    "Made whole when anchored in truth and honor: Allah explicitly permits honorable, gracious allusions in marriage proposals (Qur'an 2:235), and the Prophet ﷺ taught that tender words of affection spoken to one's spouse, playful conversation, and 'Al-Kalimah At-Tayyibah' (the good, gentle word) are recorded as charity (Bukhari 2989).",
                    "Qur'an 2:235, 14:24 (Kalimah Tayyibah), 33:32 & Sahih al-Bukhari 2989"
            ),
            new ErotesLoveJudgmentEntry(
                    6,
                    "Hymenaeus / Hymen (God of the Marriage Ceremony, Bridal Torch & Wedding Hymn)",
                    "Winged youth carrying the bridal torch and leading the wedding procession song; invoked so marriages would be auspicious.",
                    "Al-Mithaq Al-Ghaliz, Al-Walimah & I'lan An-Nikah bi-d-Daff (The Solemn Covenant, Wedding Feast & Joyful Proclamation)",
                    "Pagan superstitious omens and invocations to Hymen are replaced by invoking Allah's blessing ('Baraka Allahu lakuma wa baraka 'alaykuma wa jama'a baynakuma fi khayr', Abu Dawud 2130).",
                    "Made whole by elevating marriage to 'Al-Mithaq Al-Ghaliz' (The Solemn Covenant, Qur'an 4:21)—the exact term Allah uses for His covenant with the Prophets (Qur'an 33:7)—accompanied by public celebration, the wedding banquet (Walimah), and joyful songs with the Daff drum (Tirmidhi 1089).",
                    "Qur'an 4:21 (Mithaqan Ghalizan), Sunan Abu Dawud 2130 & Jami' At-Tirmidhi 1089"
            ),
            new ErotesLoveJudgmentEntry(
                    7,
                    "Hermaphroditus (God of Androgyny & Physical Merging of Two Lovers into One Body)",
                    "Son of Hermes and Aphrodite fused in the fountain of Salmacis into a single dual-sexed form, symbolizing the erasure of boundary between two lovers.",
                    "Min Nafsin Wahidah & Sakan Az-Zawjayn (Unity of Primordial Origin & Spiritual/Domestic Completeness Without Erasing Polarity)",
                    "Islam judges the literal erasure of male and female polarity or imitating the opposite sex as a distortion of creation's balance (Qur'an 49:13, 3:36, Bukhari 5885).",
                    "Made whole by revealing the true ontological unity behind the symbol: all men and women were created 'from a single soul (Min Nafsin Wahidah), and from it He created its mate' (Qur'an 4:1, 7:189) so that in marriage two complementary halves find total tranquility (Li-yaskuna ilayha, Qur'an 7:189)—one in origin, equal in spiritual dignity, and whole in covenant union.",
                    "Qur'an 4:1, 7:189 ('Khalaqakum min nafsin wahidah'), 30:21 & 49:13"
            )
    );

    private static final List<MinorSpiritDomainCatalog> FIVE_MINOR_SPIRIT_DOMAINS = List.of(
            new MinorSpiritDomainCatalog(
                    1,
                    "DOMAIN_1_DAIMONES_PERSONIFICATIONS",
                    "Domain I: Abstract Personifications & Emotional Spirits (The 75+ Classical Daimones)",
                    "#D4AF37",
                    "Achos / Algos / Penthos / Oizys (Grief, Pain, Misery), Adephagia (Gluttony), Adikia (Injustice), Aidos (Modesty/Shame), Alala (War Cry), Alastor (Blood-Feud Vengeance), Aletheia (Truth), Alke & Ioke (Battle-Courage & Pursuit), Amechania / Aporia (Helplessness/Perplexity), Anaideia (Shamelessness), Ananke (Cosmic Necessity), Apate (Deceit), Arae (Curses), Arete (Virtue/Excellence), Ate (Delusion/Ruin), Bia & Kratos (Force & Power), Deimos & Phobos (Terror & Dread), Dike (Justice), Dolos (Guile), Dysnomia (Lawlessness), Eirene (Peace), Eleos (Mercy), Elpis (Hope), Epiphron (Prudence), Eris (Discord), Erotes (Eros, Anteros, Himeros, Pothos, Hedylogos, Hermaphroditus, Hymenaeus), Eucleia (Good Repute), Eunomia (Good Order), Eupheme (Auspicious Speech), Charites/Graces (Euphrosyne, Aglaea, Thalia), Euthenia (Abundance), Gelos (Laughter), Geras (Old Age), Harmonia (Harmony), Hebe (Youth), Hedone (Pleasure), Homados/Kydoimos (Battle Din), Homonoia (Civic Concord), Horkos (Sacred Oath), Hormes (Eager Impulse), Hybris (Insolent Pride), Asclepiades (Hygieia, Panacea, Iaso, Aceso), Hypnos (Sleep), Kakia (Vice), Kalokagathia (Nobility), Keres (Violent Death), Koalemos (Foolishness), Lethe (Oblivion), Limos (Famine), Litai (Repentant Prayers), Lyssa (Mad Rage), Machai (Combat), Maniae (Madness), Moirai (Clotho, Lachesis, Atropos), Momus (Mockery/Blame), Oneiroi (Morpheus, Phobetor, Phantasos), Nemesis (Retribution), Nike (Victory), Peitho (Persuasion), Penia (Poverty), Pheme (Rumor), Philophrosyne (Hospitality), Philotes (Affection), Phrike (Shuddering Horror), Pistis (Faith/Trust), Ploutos (Wealth), Poine (Penalty), Ponos (Hard Toil), Pseudologoi (Lies), Sophrosyne (Temperance), Soter & Soteria (Safety/Deliverance), Thanatos (Death), Thrasos (Rash Boldness), Tyche (Fortune), Zelos (Zeal/Envy).",
                    "Treated internal emotions, virtues, vices, and fates as autonomous external spirits requiring altars (such as the Altar of Eleos/Mercy or Aidos/Modesty in Athens) or apotropaic appeasement.",
                    "Muslim philosophers (Al-Kindi, Miskawayh's Tahdhib Al-Akhlaq, Al-Ghazali's Ihya') and theologians judged the Daimones through a strict three-way Furqan: (1) Cosmic/Sovereign attributes (Ananke, Moirai, Tyche, Nike, Nemesis, Dike, Eleos, Eirene, Ploutos, Soter) belong solely to Allah's Qadar and Asma' Husna; (2) Luminous virtues (Aidos, Aletheia, Arete, Elpis, Epiphron, Litai, Philophrosyne, Pistis, Sophrosyne) are stations of the heart (Maqamat Al-Qalb) and branches of Iman; (3) Destructive vices and terrors (Adikia, Anaideia, Apate, Ate, Dolos, Dysnomia, Eris, Hybris, Kakia, Lyssa, Momus, Pseudologoi) are diseases of the ego (Amrad Al-Qulub) and whisperings of Shaytan (Waswasah).",
                    "Made whole by liberating humanity from superstitious fatalism (Tyche/Moirai -> Divine Qadar), enshrining every noble Daimon inside the Prophetic Hadith of the 70+ Branches of Faith ('Modesty [Al-Haya' = Aidos] is a branch of faith', Bukhari 9), repairing Ate's ruin through the Litai of Tawbah and Istighfar (Qur'an 39:53), and curing Achos/Algos/Geras/Penia through the Prophetic refuge prayer against grief, incapacity, cowardice, and crushing debt (Bukhari 6369).",
                    "Qur'an 91:7-10, Sahih al-Bukhari 9 (Branches of Faith & Al-Haya'), Bukhari 6369 (Refuge from Grief/Incapacity) & Miskawayh's Tahdhib Al-Akhlaq"
            ),
            new MinorSpiritDomainCatalog(
                    2,
                    "DOMAIN_2_NYMPHS_NATURE_SPIRITS",
                    "Domain II: Nature Spirits — Nymphs of Springs, Trees, Mountains, Seas, Underworld & Stars",
                    "#38BDF8",
                    "Naiads (Freshwater: Crinaeae [fountains/wells], Eleionomae [marshes], Limnades [lakes], Pegaeae [bubbling springs], Potameides [rivers]); Dryads & Hamadryads (Tree Spirits: Meliae [ash trees], Daphnaiai [laurel], Epimelides/Maliades [apple/fruit trees & highland flocks], Caryatids [walnut/hazel]); Oreads & Grottos (Echo & Corycian Nymphs of Parnassus); Marine Nymphs (3,000 Oceanids [Styx, Metis, Doris, Electra, Eurynome] & 50 Nereids [Thetis, Amphitrite, Galatea]); Underworld Nymphs (Lampades [Hecate's torch-bearers], Avernales); Sky & Celestial Nymphs (Aurae [breezes], Hesperides [evening twilight & Golden Apples], Hyades [rain-stars], 7 Pleiades / Al-Thurayya [Maia, Electra, Taygete, Alcyone, Celaeno, Sterope, Merope], Nephelae [clouds]).",
                    "Rural worshippers offered milk, honey, and olive oil at springs, trees, and caves, believing each tree (Hamadryad) or well (Naiad) housed a semi-divine female spirit.",
                    "Judged under Tawhid: offering sacrifices or prayers to trees (like the pre-Islamic tree Dhat Anwat, Tirmidhi 2180) or springs is forbidden as Shirk, and claiming stars (Hyades/Pleiades/Anwa') independently cause rain is refuted in the Hadith of Zaid ibn Khalid (Bukhari 846: 'Whoever says we were given rain by the grace of Allah is a believer in Me and a disbeliever in the stars').",
                    "Made whole by revealing what the Greeks intuited but misnamed: (1) Every spring, tree, mountain, cloud, and star DOES possess living spiritual consciousness and glorifies Allah ('The seven heavens and the earth and whatever is in them exalt Him, and there is not a thing except that it exalts Allah by His praise', Qur'an 17:44; 'And the stars and the trees prostrate', Qur'an 55:6); (2) Every raindrop and leaf is tended by appointed Angels of Nature (Mikal's retinue); and (3) Cutting down fruit trees wantonly or polluting water springs is prohibited by Prophetic environmental law (Hima) out of reverence for their Creator.",
                    "Qur'an 17:44 (Universal Tasbih of All Things), 55:6 ('Wan-najmu wash-shajaru yasjudan'), 22:18 & Sahih al-Bukhari 846"
            ),
            new MinorSpiritDomainCatalog(
                    3,
                    "DOMAIN_3_THEOI_NOMIOI_RUSTIC_AGRARIAN",
                    "Domain III: Rustic, Wilderness & Agrarian Deities (Theoi Nomioi, Potamoi, Anemoi & Artisan Spirits)",
                    "#10B981",
                    "Aristaeus (Beekeeping, olive cultivation, cheese-making, herding), Pan (Goat-legged god of shepherds, wilderness & sudden 'panic'), Priapus (Orchard & garden fertility), Sileni & Satyrs (Woodland wildness & wine-pressing, Silenus), 3,000 Potamoi (Bull-horned river gods: Achelous, Alpheus, Scamander, Peneus), Anemoi (Wind Gods: Boreas [North], Zephyrus [West], Notus [South], Eurus [East], Anemoi Thuellai [storm winds], Aura [breeze], Khione [snow]), Astraea (Star-maiden of justice/innocence who fled earth), Curetes & Corybantes (Shield-clashing mountain guardians), Dactyls & Telchines (Metallurgy & weather sorcery), Daimones Keramikoi (5 kiln-cracking spirits: Syntribos, Smaragos, Asbetos, Sabaktes, Omodamos).",
                    "Invoked by shepherds, beekeepers, sailors, potters, and smiths to ward off wilderness panic, kiln-cracking, and storms, and to bless hives, flocks, and rivers.",
                    "Judged by stripping away satyric intoxication (Silenus/Dionysus), phallic idol-wards (Priapus), and river sacrifices (such as the pre-Islamic Egyptian custom of throwing a maiden or offering into the Nile, abolished by 'Amr ibn al-'As and Caliph 'Umar's letter to the Nile).",
                    "Made whole across every rustic craft: (1) Aristaeus's beekeeping is crowned by Surah An-Nahl (16:68-69), where Allah Himself inspires (Awha) the bee directly, and by the blessed Olive Tree (Qur'an 24:35); (2) Pan's wilderness 'panic' is neutralized by the Prophetic prayer when stopping in any wild valley: 'A'udhu bi-kalimati Allahi at-tammati min sharri ma khalaq' ('I seek refuge in the perfect words of Allah from the evil of what He created', Muslim 2708); (3) The Anemoi winds are honored through the Prophetic Hadith: 'Do not curse the wind, for it is from the breath of Allah's mercy, bringing mercy and punishment; rather ask Allah for its good' (Abu Dawud 5097); (4) The Potamoi rivers are commanded by Allah (like Caliph 'Umar's letter to the Nile: 'If you flow by Allah's command, we ask Allah the One to make you flow'); and (5) Astraea's virgin justice is restored in Al-Mizan.",
                    "Qur'an 16:68-69 (Surah An-Nahl), 30:46 (The Winds as Glad Tidings), Sahih Muslim 2708 & Sunan Abu Dawud 5097"
            ),
            new MinorSpiritDomainCatalog(
                    4,
                    "DOMAIN_4_CHTHONIC_UNDERWORLD_LESSER",
                    "Domain IV: Underworld & Chthonic Lesser Deities (Tartarus, Ferryman, Avengers & Subterranean Oracles)",
                    "#A78BFA",
                    "Charon (Ferryman of Acheron & Styx), Melinoë (Bringer of nightmares & ghosts), Empusa, Mormo & Lamia (Shapeshifting phantom terrors & child-frightening daimones), Erinyes / Furies / Eumenides (Alecto, Megaera, Tisiphone — avengers of murder & filial perjury), Minos, Rhadamanthus & Aeacus (Deified mortal kings judging the dead), Menoetes (Hades' herdsman), Ascalaphus (Underworld orchard-informer turned into a screech owl), Trophonius & Amphiaraus (Subterranean chthonic hero-oracles).",
                    "Pacified with nocturnal black-animal blood sacrifices poured into trenches (Bothroi), coins placed in corpses' mouths for Charon, and terrifying descents into Trophonius's subterranean oracle pit.",
                    "Judged decisively: (1) No coin (obolus) can bribe the crossing of death ('The Day when neither wealth nor sons will avail, except one who comes to Allah with a sound heart', Qur'an 26:88-89); (2) Female shape-shifting ghouls (Empusa/Lamia = Arabic Ghul) are declared powerless by the Prophet ﷺ ('La Ghula' — 'There is no overpowering Ghul', Muslim 2222, negated immediately by Adhan and Ayat Al-Kursi); (3) Subterranean oracle-pits (Trophonius) are exposed as Jinn eavesdroppers (Kahanah) cut off by the Qur'an (72:8-9); and (4) Ascalaphus's screech-owl omen is abolished ('La Hamah' — 'There is no death-owl omen in Islam', Bukhari 5757).",
                    "Made whole by replacing chthonic terror with the luminous justice of Al-Akhirah: filial piety to parents (Birr Al-Walidayn, Qur'an 17:23-24) and lawful Qisas/Diyah (Qur'an 2:178) replace the blood-crazed Erinyes; righteous deeds (Sadaqah Jariyah, beneficial knowledge, and a righteous child's prayer, Muslim 1631) replace Charon's coin as the true provision across the Barzakh; and Allah alone—not Minos or Rhadamanthus—judges between souls with zero wrong ('La zulma al-yawm', Qur'an 40:17).",
                    "Qur'an 26:88-89, 40:17, Sahih al-Bukhari 5757 ('La 'Adwa wa la Tiyarah wa la Hamah') & Sahih Muslim 2222 ('La Ghula')"
            ),
            new MinorSpiritDomainCatalog(
                    5,
                    "DOMAIN_5_DOMESTIC_GUARDIANS_AND_APOTHEOSIS",
                    "Domain V: Household Guardians, Healers & Deified Mortals (Agathos Daimon, Asclepius, Psyche & Golden-Age Watchers)",
                    "#F43F5E",
                    "Agathos Daimon ('Good Spirit' of household health & abundance), Kakodaimones (Malevolent household spirits), Zeus Ktesios & Zeus Herkeios (Pantry jar & courtyard boundary guardians), Eileithyia (Spirit of childbirth labor pains), Asclepius (Mortal son of Apollo deified as god of medicine), Psyche (Mortal soul granted immortality), Britomartis/Dictynna (Net-inventor nymph), Ino/Leucothea & Palaemon (Deified sea-rescuers of drowning sailors), Daimones Khryseoi & Argyreoi (Immortalized spirits of the Golden & Silver Ages watching human justice on earth).",
                    "Honored with daily domestic wine libations (Agathos Daimon), wool-wrapped pantry jars (Ktesios), incubation sleep in Asclepieia healing temples, and prayers by sailors in storms to Leucothea.",
                    "Judged by Qur'an 10:22-23 & 29:65 (which explicitly describes sailors at sea calling upon Allah alone in sincere monotheism when waves engulf them, exposing the futility of sea-idols like Leucothea/Palaemon) and by stripping Asclepius of pagan deification while preserving his medical science.",
                    "Made whole inside the Muslim household and clinic: (1) The home and pantry (Agathos Daimon / Ktesios) are guarded by saying 'Bismillah' upon entering the door and over food, whereupon Shaytan says to his cohort: 'You have no lodging and no dinner here tonight' (Sahih Muslim 2018), and by reciting Surah Al-Baqarah; (2) Eileithyia's childbirth care is fulfilled in Allah's tender relief given to Maryam beneath the palm tree (Qur'an 19:23-26); (3) Asclepius (Asqlibiyus in Ibn Abi Usaybi'ah's medical history) is honored as a righteous sage practicing the Prophetic law 'For every disease Allah has sent down a cure' (Bukhari 5678) under Ash-Shafi; and (4) Hesiod's Daimones Khryseoi (invisible watchers of justice) are made whole as the Kiraman Katibin (Noble Recording Angels, Qur'an 82:10-12) and the itinerant Angels of Dhikr (Bukhari 6408).",
                    "Sahih Muslim 2018 (Guarding the Home & Pantry), Sahih al-Bukhari 5678 (Medical Cure), Qur'an 10:22, 19:23-26 & 82:10-12"
            )
    );

    public static List<GodhoodHierarchyTier> allSevenGodhoodTiers() {
        return SEVEN_GODHOOD_TIERS;
    }

    public static List<TitanomachyWholenessEntry> allSevenTitanomachyRestorations() {
        return SEVEN_TITANOMACHY_RESTORATIONS;
    }

    public static List<OneiroiDreamJudgmentEntry> allFourOneiroiDreamEntries() {
        return FOUR_ONEIROI_DREAM_ENTRIES;
    }

    public static List<ErotesLoveJudgmentEntry> allSevenErotesLoveEntries() {
        return SEVEN_EROTES_LOVE_ENTRIES;
    }

    public static List<MinorSpiritDomainCatalog> allFiveMinorSpiritDomains() {
        return FIVE_MINOR_SPIRIT_DOMAINS;
    }
}
