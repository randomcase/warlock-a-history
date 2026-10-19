package com.sovereign.warlock.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Immutable Chronicle of the 7 Pre-Prophetic Warlock Orders speaking their testimony
 * to Islam, and the theological & ontological decree explaining why each Warlock Order
 * was WHOLLY REMOVED FROM THE FOUNDATION (Al-Izalah Al-Kulliyyah min Al-Asas).
 */
public record WarlockIslamChronicle(
        int orderIndex,
        String profileId,
        String htmlFileName,
        String storyTitle,
        String arabicEpigraph,
        String storyToldToIslam,
        String whyWhollyRemovedFromFoundation,
        String quranicCriterionAnchor,
        String pureFoundationReplacement
) {
    public WarlockIslamChronicle {
        Objects.requireNonNull(profileId);
        Objects.requireNonNull(htmlFileName);
        Objects.requireNonNull(storyTitle);
        Objects.requireNonNull(arabicEpigraph);
        Objects.requireNonNull(storyToldToIslam);
        Objects.requireNonNull(whyWhollyRemovedFromFoundation);
        Objects.requireNonNull(quranicCriterionAnchor);
        Objects.requireNonNull(pureFoundationReplacement);
    }

    private static final List<WarlockIslamChronicle> ALL_CHRONICLES = List.of(
            new WarlockIslamChronicle(
                    1,
                    "warlock-1-white",
                    "order-1-white.html",
                    "The Testimony of the White Fire: The Claim of Uncreated Contraction (Tzimtzum) vs. Absolute Tawhid",
                    "Kana Allahu wa la shay'a ma'ahu — 'Allah existed, and nothing existed alongside Him.'",
                    "When the Final Revelation descended, Malakh-Azal—First Order of the Parchment White Fire (#F8F5E6)—stepped forth from the memory of Stratum Omega-0. He spoke to Islam: 'Before clay was moistened or the seven firmaments were vaulted, we stood at the First Contraction (Tzimtzum). We claimed that to create the cosmos, the Infinite Light had to withdraw from a circle of Void, leaving behind a primordial residue (Reshimu) and a beam of White Fire (Kav) that a theurgist could capture in uncreased gazelle parchment. By contracting a thirty-foot vacuum of silence, our Order claimed the power to manipulate the uncreated light itself and command reality through a pact with the Void.'",
                    "Islam heard the First Order and wholly removed its doctrine from the Foundation (Al-Asas). In the pure Foundation of Islam, the Creator never 'withdraws,' 'contracts,' or 'vacates' a space for creation to exist inside Him—for spatial contraction (Hulul or Tzimtzum) confuses the Eternal Essence (Al-Dhat) with created space. Nor does any residual 'uncreated light' remain loose in the cosmos for a warlock to trap inside a scroll. Creation is brought into being ex nihilo strictly by the Sovereign Command ('Kun fa-yakun' — 'Be, and it is'), without emanationist intermediaries or theurgic pacts. Thus, the White-Fire Warlock's claim to wield an autonomous fragment of pre-eternal light was wholly excised from the Foundation.",
                    "Surah Al-Ikhlas (112:1-4) & Surah Al-Shura (42:11): 'There is nothing like unto Him (Laysa kamithlihi shay'un), and He is the All-Hearing, the All-Seeing.'",
                    "Pure Unmediated Tawhid al-Rububiyyah: Creation by Direct Divine Will ('Kun') without cosmic contraction, emanationist residue, or warlock scrolls."
            ),
            new WarlockIslamChronicle(
                    2,
                    "warlock-2-black",
                    "order-2-black.html",
                    "The Testimony of the Black Fire: The Scribe of the 231 Gates vs. The Sealed Pen of Decree",
                    "Jaffat al-Aqlam wa rufi'at al-Suhuf — 'The Pens have dried, and the Scrolls have been lifted.'",
                    "Second came Katib Al-Qalam—Order of the Ascetic Qedar Black Fire (#141416)—draped in coarse black goat-hair from Stratum Omega-1, fifty thousand cosmic years before the earth. He spoke to Islam: 'We watched the Primordial Pen (Al-Qalam) split in awe and write the destinies of all things in Black Fire upon White Fire. Our Order memorized the 231 Consonantal Gates (Sefer Yetzirah) and the numerical Abjad squares (Awfaq). We claimed that by rotating two primordial root letters in mid-air and inscribing talismanic grids in desert sand, a Warlock of the Black Fire could rewrite what the Pen had written and compel fate itself to bend.'",
                    "Islam wholly removed the Black-Fire Scribe's letter-theurgy from the Foundation. While Islam affirms that Al-Qalam (The Pen) and Al-Lawh Al-Mahfuz (The Preserved Tablet) were created fifty thousand years before the heavens and the earth, the Preserved Tablet is inviolably beyond the reach of any creature, angel, or warlock. The notion that rotating consonants, numerological Gematria/Hurufiyyah, or talismanic Awfaq squares can mechanically force or rewrite Divine Decree (Al-Qadar) was stripped root-and-branch from the Foundation as an illusion of the ساحر (Sahir). The Ink of Pre-Eternity has dried; no warlock stylus can alter a single letter of the Tablet.",
                    "Surah Al-Qalam (68:1), Surah Al-Buruj (85:21-22) & Sahih Muslim (2653): 'Allah wrote the decrees of creation fifty thousand years before He created the heavens and the earth.'",
                    "Iman bil-Qadar (Belief in Divine Decree) & Sincere Du'a: Only humble supplication to the Lord of the Pen—never talismanic letter-permutation—interacts with destiny."
            ),
            new WarlockIslamChronicle(
                    3,
                    "warlock-3-sapphire",
                    "order-3-sapphire.html",
                    "The Testimony of the Tekhelet Sapphire: The Forced Chariot-Ascent (Yored Merkabah) vs. The Prophetic Mi'raj",
                    "Wa ma minna illa lahu maqamun ma'lum — 'And there is none among us [angels] except that he has a known station.'",
                    "Third approached Yored Ha-Merkabah—Order of the Tekhelet Throne Sapphire (#0F2C59)—his eyes spinning like the sapphire wheels of the Ophanim from Stratum Omega-2. He told his story to Islam: 'Our Order refused to wait upon the earth. Wearing the seven-fold indigo turban and pressing cryptographic seals into our palms, we forced our way downward and upward through the Seven Heikhalot (Celestial Palaces), bribing or compelling the threshold gatekeepers with secret names to gaze upon the Sapphire Pavement (Livnat Ha-Sapir) and the Curtain of the Pargod, seizing the mechanics of the Chariot by theurgic technique.'",
                    "Islam listened and wholly removed the Heikhalot Chariot-Warlock from the Foundation. In the Foundation of Islam, the heavens cannot be stormed, hacked, or ascended through cryptographic seals, magic passwords, or self-induced Merkabah trance. Every angel stands in an unalterable station of worship ('Maqamun Ma'lum' — Qur'an 37:164) and cannot be bribed or bypassed by a mortal theurgist's seal. True ascent (Al-Mi'raj) belongs exclusively to the invited Prophet carried by Divine Grace, never to a warlock storming the palaces by occult force. The entire edifice of Heikhalot gatekeeper-coercion was cast out of the Foundation.",
                    "Surah Al-Saffat (37:164-166) & Surah Al-Isra (17:1): 'Glory be to Him Who took His servant by night... Indeed, we [angels] are those ranged in ranks, and indeed we are those who glorify Him.'",
                    "Al-Sujud (Prostration): Rather than storming the Seven Heavens with cryptographic seals, the servant is closest to his Lord when his forehead touches the earth in prostration."
            ),
            new WarlockIslamChronicle(
                    4,
                    "warlock-4-gold",
                    "order-4-gold.html",
                    "The Testimony of the Hashmal Gold: Weaponizing the Oath of Alast & the 72 Names vs. The Covenant of Fitrah",
                    "Alastu bi-Rabbikum? Qalu: Bala shahidna — 'Am I not your Lord? They said: Yea, we testify!'",
                    "Fourth stood Shahid Al-Alast—Order of the Smokeless Hashmal Electrum Gold (#D4AF37)—wearing the 72-faceted breastplate from Stratum Omega-4. He spoke to Islam: 'I was there on the Day of Alast when all uncreated souls were drawn forth like luminous atoms and testified Bala! Our Order forged the 72 Divided Triplets (Shem HaMephorash) into electrum gold. By intoning the primordial question in the Still, Small Voice (Qol Demamah Daqah), we claimed the authority to weaponize the Pre-Temporal Covenant—forcing men and spirits to their knees by hijacking the memory of their souls and wielding the Great Name (Ism Allah Al-A'zam) as an arcane weapon.'",
                    "Islam wholly removed the Gold Warlock's weaponization of the Pre-Eternal Covenant from the Foundation. In Islam, Yawm Al-Alast (Surah Al-A'raf 7:172) is the universal Covenant of Fitrah (innate monotheistic conscience) between every soul and Allah alone—no priest, hierarch, or warlock was appointed as its enforcer or broker. Furthermore, the Most Great Name (Al-Ism Al-A'zam) is not a 72-triplet cryptographic cipher engraved on an electrum breastplate to compel creation; it is the living reality of Tawhid (*La ilaha illa Huwa Al-Hayy Al-Qayyum*) open to every humble believer without esoteric caste or secret guild.",
                    "Surah Al-A'raf (7:172) & Surah Al-Hashr (59:22-24): 'When your Lord took from the Children of Adam—from their loins—their descendants and made them testify of themselves: Am I not your Lord? They said: Yea, we have testified.'",
                    "Al-Fitrah & The 99 Beautiful Names (Al-Asma' Al-Husna): Open, non-secret invocation ('Call upon Him by the Most Beautiful Names' — Qur'an 7:180) accessible to every soul without a theurgic breastplate."
            ),
            new WarlockIslamChronicle(
                    5,
                    "warlock-5-crimson",
                    "order-5-crimson.html",
                    "The Testimony of the Gevurah Crimson: The Seraphic Coal & The Flaming Meteors (Shihab) that Barred the Sky",
                    "Wa anna lamasna al-sama'a fawajadnaha muli'at harasan shadidan wa shuhuban — 'We sought to touch the heaven and found it filled with stern guards and flaming meteors.'",
                    "Fifth stepped forth Saraph Ha-Ritzpah—Order of the Gevurah Covenant Crimson (#8B0000)—his lips scarred by the live altar-ember (Ritzpah) of Stratum Omega-2. He spoke to Islam: 'For ages before the Prophets, our Order communed with the fiery hierarchies at the threshold of the firmament, drawing down crimson judgment-fire (Gevurah) and listening to the decrees of the high assembly before they reached the earth. With the First Tongs of Twilight (Madei-Esh), we held the burning coal and claimed the right to call down apocalyptic plagues and sevenfold thunders upon our enemies.'",
                    "Islam delivered the most decisive severance of all to the Fifth Order, wholly removing astral pact-mediumship from the Foundation of the world. As recorded in Surah Al-Jinn (72:8-9) and Surah Al-Saffat (37:6-10), at the very moment the Qur'an began to descend, the heavens were permanently locked with stern angelic guards ('Harasan Shadidan') and piercing crimson meteors ('Shihab Thaqib'). Every celestial eavesdropper, astral pact-bearer, and Kahin medium was cut off forever from the High Assembly (Al-Mala' Al-A'la). Judgment (Al-Din) belongs solely to the Master of the Day of Judgment (Maliki Yawm al-Din), never to a crimson warlock wielding a stolen ember.",
                    "Surah Al-Jinn (72:8-9) & Surah Al-Hijr (15:16-18): 'We used to sit there in stations tosteal a hearing, but whoever listens now finds a flaming meteor (Shihab) waiting in ambush for him.'",
                    "The Sealing of the Heavens & Finality of Revelation (Khatm Al-Nubuwwah): The permanent termination of all astral eavesdropping, oracle pacts, and extra-prophetic apocalyptic mediums."
            ),
            new WarlockIslamChronicle(
                    6,
                    "warlock-6-brass",
                    "order-6-brass.html",
                    "The Testimony of the Goetic Brass: 'Wa ma kafara Sulaymanu' — The Exoneration of Solomon & Abolition of the Brass Vessel",
                    "Wa ma kafara Sulaymanu wa lakinna al-shayatina kafaru yu'allimuna al-nasa al-sihr — 'And Solomon did not disbelieve, but the devils disbelieved, teaching people magic.'",
                    "Sixth came Ba'al Ha-Nechoshet—Order of the Burnished Goetic Brass (#B87333)—dragging chains of bronze bound to a lead-stoppered Damascene Brass Amphora from Strata Omega-3 and Omega-5. He confessed to Islam: 'Long before mortal kingship, when the Pre-Adamic Jinn of Smokeless Fire (Marijin min Nar) ruled the earth, our Order forged the Proto-Ring of the Foundation Stone (Even HaShetiyah) and the 72 Brass Vessels. When Solomon later received dominion over the winds and the Jinn, the Goetic fraternities hid their books beneath his throne (Kursi), claiming that Solomon himself was the Supreme Warlock-King and that our brass vessels and hexagram rings were his lawful inheritance!'",
                    "Here Islam struck the very heart of the Goetic tradition, wholly removing it from the Foundation forever. In Surah Al-Baqarah (2:102), Allah explicitly exonerated Prophet Sulayman (peace be upon him) from every warlock legend ever written in the Testament of Solomon or the Goetia: 'And Solomon did not disbelieve, but the devils disbelieved, teaching people magic and that which was sent down at Babylon to the two angels Harut and Marut.' Furthermore, in Surah Sad (38:35), Solomon prayed: 'My Lord, forgive me and grant me a kingdom such as shall not belong to anyone after me (la yanbaghi li-ahadin min ba'di).' That prayer was answered: no mortal after Solomon may lawfully bind, enslave, or enter a pact with the Jinn. And in Surah Saba' (34:14), when Solomon died leaning upon his staff and the wood-worm (Dabbat al-Ard—the demystified Shamir) ate through it, the Jinn realized they did not even know the Unseen! Thus, the Goetic Brass Warlock was wholly stripped of his false Solomonic pedigree and removed from the Foundation.",
                    "Surah Al-Baqarah (2:102), Surah Sad (38:35) & Surah Saba' (34:14): 'Then when We decreed death for him [Solomon], nothing showed them his death except a creature of the earth (worm) eating his staff; so when he fell, it became clear to the Jinn that if they had known the Unseen, they would not have remained in humiliating torment.'",
                    "Prophetic Innocence ('Ismah of Sulayman) & Prohibition of Istikhdham al-Jinn: Complete abolition of Goetic rings, brass vessels, and Jinn-binding pacts (Surah Al-Jinn 72:6)."
            ),
            new WarlockIslamChronicle(
                    7,
                    "warlock-7-emerald",
                    "order-7-emerald.html",
                    "The Testimony of the Emerald Twilight: The Guardians of Al-Ghaib & The Keys that Belong to Allah Alone",
                    "Wa 'indahu mafatihu al-ghaybi la ya'lamuha illa Huwa — 'And with Him are the Keys of the Unseen; none knows them except Him.'",
                    "Seventh and last came Wali Al-Ghaib—Order of the Emerald Shamir Twilight (#006B54)—emerging from Stratum Omega-6, the Sixth Twilight of Creation (Bein HaShemashot). Holding the green light-stone of the Shamir and clicking ninety-nine beads of petrified olive wood, he spoke to Islam: 'At the twilight before the First Sabbath, before Adam's foot touched the dust, ten twilight wonders were formed. Our Order walked unseen through the green veil of 'Alam al-Ghaib, claiming to be the autonomous Pole-Masters (Rijal al-Ghaib) who hold the keys of the Unseen, cleave bedrock without iron, and govern the hidden world from behind the curtain of time.'",
                    "Islam heard the Seventh Order and wholly removed every claim to autonomous mastery over the Unseen from the Foundation. In the Foundation of Islam, the Keys of the Unseen (Mafatihu al-Ghaib — Surah Al-An'am 6:59) belong exclusively to Allah; neither prophet, angel, saint, nor twilight warlock possesses independent knowledge or dominion over Al-Ghaib. Even the righteous servant in Surah Al-Kahf (18:65-82, Al-Khidr) declared explicitly: 'Wa ma fa'altuhu 'an amri — I did not do it of my own accord!'—acting strictly under direct Divine command, never through an autonomous occult order. And the Shamir was stripped of its theurgic mythology in Surah Saba' (34:14), revealed as a humble creature of the earth (Dabbat al-Ard) subject to Allah's decree. Thus, the Seventh Order surrendered its twilight stone, and all seven Warlock pacts were wholly removed from the Foundation.",
                    "Surah Al-An'am (6:59), Surah Al-Naml (27:65) & Surah Al-Kahf (18:82): 'Say: None in the heavens and the earth knows the Unseen except Allah, and they do not perceive when they will be resurrected.'",
                    "Iman bil-Ghaib (Humble Faith in the Unseen — Surah Al-Baqarah 2:3): The Foundation of Islam begins with trusting the Lord of the Unseen without claiming occult ownership of its keys."
            )
    );

    private static final Map<Integer, WarlockIslamChronicle> BY_ORDER = ALL_CHRONICLES.stream()
            .collect(Collectors.toUnmodifiableMap(WarlockIslamChronicle::orderIndex, Function.identity()));

    public static List<WarlockIslamChronicle> allOrderedBySeven() {
        return ALL_CHRONICLES;
    }

    public static WarlockIslamChronicle forOrderIndex(int orderIndex) {
        WarlockIslamChronicle c = BY_ORDER.get(orderIndex);
        if (c == null) {
            throw new IllegalArgumentException("No Islam Chronicle for orderIndex: " + orderIndex);
        }
        return c;
    }
}
