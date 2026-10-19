package com.sovereign.warlock.domain;

import java.util.List;

/**
 * Canonical Domain Model for Portal #64:
 * Boating, Piracy, Mercantilism, Currency, Maps, Astrolabes, Compasses &
 * The Omani and Yemeni Coasting Islamic Caliphates, Imamates, and Sultanates.
 */
public final class IslamicMaritimeBoatingPiracyMercantilismAndOmanYemen {

    private IslamicMaritimeBoatingPiracyMercantilismAndOmanYemen() {
    }

    public record MaritimeVesselProfile(
            int vesselIndex,
            String arabicName,
            String englishTitle,
            String oceanBasinAndOrigin,
            String hullAndRiggingEngineering,
            String cargoAndNavalRole,
            String historicalAnchor,
            String hexAccent
    ) {
    }

    public record PiracyAndMaritimeLawCase(
            int caseIndex,
            String eraAndDate,
            String title,
            String arabicLegalOrHistoricalCategory,
            String theaterAndPorts,
            String canonicalRulingAndNavalResponse,
            String primarySourceProof,
            String hexAccent
    ) {
    }

    public record MercantilismAndCurrencyInstrument(
            int instrumentIndex,
            String category,
            String arabicTermAndEtymology,
            String englishEquivalent,
            String weightOrFinancialMechanism,
            String maritimeTradeCirculation,
            String historicalAndQuranicProof,
            String hexAccent
    ) {
    }

    public record CartographyAstrolabeCompassMilestone(
            int milestoneIndex,
            String instrumentOrAtlasClass,
            String scholarOrNavigator,
            String dateAndCenter,
            String arabicWorkOrDeviceName,
            String mathematicalAndOpticalPrinciple,
            String globalNavigationalImpact,
            String hexAccent
    ) {
    }

    public record StarCompassPortNode(
            int nodeIndex,
            String portName,
            String arabicName,
            String coastingZone,
            String starRhumbName,
            double kamalIsbaAltitude,
            double modernLatitudeDeg,
            String monsoonWindRegime,
            String primaryCommoditiesAndCoinage,
            String hexAccent
    ) {
    }

    public record OmaniYemeniCoastingPolity(
            int polityIndex,
            String regionAxis,
            String dynastyOrImamateName,
            String dateSpan,
            String capitalAndCoastingPorts,
            String caliphalRelationshipAndSovereignty,
            String navalFleetsNavigationAndTrade,
            String architecturalAndScientificLegacy,
            String hexAccent
    ) {
    }

    public static List<MaritimeVesselProfile> canonicalVesselProfiles() {
        return List.of(
                new MaritimeVesselProfile(
                        1,
                        "Al-Khayṭīyah / Sufun Al-Ṣīn (السفن الخيطية / سفن الصين)",
                        "Abbasid & Omani Sewn-Plank 'China Dhow' (Belitung Type)",
                        "Oman (Sohar, Muscat), Siraf, Basrah & Yemeni Aden -> Malabar, Malacca & Canton (Khānfū)",
                        "Built of Malabar teak (Sāj) planks stitched edge-to-edge with coconut coir cordage (Qanbar) over wadding and waterproofed with shark/whale liver oil (Duhn Al-Qirsh) and lime pitch (Nūrah)—using ZERO iron nails so hulls flex over Red Sea coral reefs (Shi'āb Marjāniyyah) and heavy monsoon swells without splitting or rusting.",
                        "Carried 60,000+ Changsha ceramics, gold/silver ingots, Omani frankincense, Basran cobalt-blue glazed jars, and pearls across the 10,000 km Sohar-to-Canton ocean highway.",
                        "Qur'an 55:24 ('And to Him belong the ships with raised sails in the sea like mountains') • Belitung Shipwreck (c. 830 CE) & Akhbār Al-Ṣīn wa Al-Hind (851 CE)",
                        "#10B981"
                ),
                new MaritimeVesselProfile(
                        2,
                        "Al-Sambūq Al-Yamanī (السمبوق اليمني)",
                        "The Yemeni & Red Sea Sambuk (Lateen-Rigged Reef Coaster)",
                        "Yemen (Aden, Al-Mukhā/Mocha, Al-Shiḥr, Hodeidah), Hijaz (Jeddah) & Horn of Africa (Zeila, Massawa)",
                        "Features a curved, scimitar-like stempost (low draft forward) and a high, squared overhanging transom stern, rigged with two massive triangular Lateen (or settee) sails capable of tacking within 50 degrees of the fierce Red Sea northerly winds (Al-Shimāl).",
                        "Premier coaster of the Red Sea coffee (Mocha Qahwah), spice, and Hajj pilgrim routes, threading treacherous coral archipelagos (Farasān and Dahlak).",
                        "Rasulid Mulakhkhaṣ Al-Fiṭan (1411 CE, Aden) & Ibn Mājid's Kitāb Al-Fawā'id (1490 CE)",
                        "#F59E0B"
                ),
                new MaritimeVesselProfile(
                        3,
                        "Al-Baghlah & Al-Ghunjah Al-'Umāniyyah (البغلة والغنجة العمانية)",
                        "The Omani Deep-Sea Baghlah & Ghanjah Merchant Galleon",
                        "Muscat, Sur, Sohar, Hormuz, Gujarat (Surat/Calicut) & Swahili Coast (Mombasa, Zanzibar)",
                        "200-to-500-ton deep-sea teak vessels with a high, richly carved quarter-gallery stern with five windows, a curved trefoil stemhead (on the Ghanjah), two or three masts carrying towering lateen/settee yards, and gunports for broadside cannon defense against pirates.",
                        "Backbone of the Ya'rubid and Al Bu Sa'id Omani thalassocracy, transporting Arabian warhorses, dates, copper, cloves, ivory, and Indian textiles across the Arabian Sea.",
                        "Omani Maritime Archives of Sur & Muscat (17th–19th c. CE)",
                        "#D4AF37"
                ),
                new MaritimeVesselProfile(
                        4,
                        "Al-Bādān Al-Musammāh (البدن العماني)",
                        "The Omani Bādān High-Stern Coastal Sprinter",
                        "Coasts of Oman (Al-Bāṭinah, Musandam, Dhofar), Persian Gulf & Makran Coast",
                        "Shallow-draft sewn and pegged double-ended coaster distinguished by a towering vertical sternpost (Finjān) and a rudder controlled by twin rope tackles (Sukkān bi-Al-Ḥibāl) rather than a tiller, allowing rapid beaching on open sandy shores without harbors.",
                        "Rapid coastal cabotage, frankincense transport from Dhofar (Mirbāṭ/Ẓafār), pearl-bank logistics, and naval reconnaissance.",
                        "Ibn Baṭṭūṭah's visit to Qalhāt & Dhofar (1331 CE)",
                        "#38BDF8"
                ),
                new MaritimeVesselProfile(
                        5,
                        "Al-Shīnī wa Al-Ghurbān (الشيني والغربان الحربية)",
                        "Caliphal, Ayyubid, Rasulid & Ottoman War Galleys",
                        "Mediterranean (Dār Al-Ṣinā'ah in Alexandria, Tunis, Acre, Istanbul) & Red Sea (Suez, Jeddah, Aden)",
                        "Oared and lateen-rigged warships (140–180 oars, twin lateen masts, reinforced ramming prow) equipped with marine archers, boarding bridges, and early naval artillery. The Arabic word 'Dār Al-Ṣinā'ah' (House of Naval Manufacturing) directly entered Italian and English as 'Arsenal'!",
                        "Protected the Mediterranean and Red Sea against Crusader/Portuguese raids; Rasulid Sultans of Yemen stationed a permanent Shīnī squadron at Aden to escort Kārimī merchant convoys.",
                        "Battle of the Masts (Dhāt Al-Ṣawārī, 34 AH / 655 CE), Saladin's Red Sea Fleet (1183 CE) & Selman Reis at Jeddah/Aden (1517 CE)",
                        "#F43F5E"
                ),
                new MaritimeVesselProfile(
                        6,
                        "Al-Ḥarrāqah wa Al-Ṭarīdah (الحراقة والطريدة)",
                        "Abbasid/Fatimid Naphtha Fire-Ships & Cavalry Landing Transports",
                        "Tigris-Euphrates, Nile, Mediterranean & Red Sea",
                        "Al-Ḥarrāqah carried pressurized copper siphons (Zarrāqāt Al-Nafṭ) projecting Greek fire / distilled petroleum naphtha coated with sulfur and quicklime (invented/refined by Callinicus and Al-Rāzī/Ḥasan al-Rammāḥ). Al-Ṭarīdah featured watertight stern doors and ramps holding 40 fully saddled horses ready to charge directly onto enemy beaches.",
                        "Amphibious coastal landings, harbor defense, and riverine-oceanic naval projection.",
                        "Ḥasan al-Rammāḥ, Al-Furūsiyyah wa Al-Manāṣib Al-Ḥarbiyyah (c. 1280 CE) & Ibn Khaldūn on Islamic Admirals (Amīr Al-Baḥr -> 'Admiral')",
                        "#A855F7"
                )
        );
    }

    public static List<PiracyAndMaritimeLawCase> canonicalPiracyAndMaritimeLawCases() {
        return List.of(
                new PiracyAndMaritimeLawCase(
                        1,
                        "Qur'anic Archetype • Surah Al-Kahf (18:71 & 18:79)",
                        "Al-Khiḍr & The Pirate-King Who Seized Every Sound Ship by Force (Ghaṣb)",
                        "Taḥrīm Al-Ghaṣb Al-Baḥrī vs. Irtikāb Akhaff Al-Ḍararayn (Lesser of Two Harms)",
                        "Majma' Al-Baḥrayn (Junction of the Two Seas — Red Sea / Gulf of Suez & Bab al-Mandab / Arabian Sea)",
                        "When Moses and Al-Khiḍr boarded the boat of poor working mariners (Masākīn ya'malūna fī al-baḥr), Al-Khiḍr knocked out a plank to make the ship appear defective because 'behind them was a predatory king seizing every sound ship by piratical force (ya'khudhu kulla safīnatin ghaṣbā).' Islamic jurists derived from this verse both the absolute prohibition of piratical seizure (Ghaṣb) and the legal doctrine of inflicting a minor reversible property defect to save an entire vessel from piracy.",
                        "Qur'an 18:71 & 18:79; Sahih al-Bukhari 4725",
                        "#10B981"
                ),
                new PiracyAndMaritimeLawCase(
                        2,
                        "9th–10th Century CE (3rd–4th Century AH) • Córdoba, Qayrawān & Alexandria",
                        "Kitāb Akriyat Al-Sufun: The World's Earliest Codified Islamic Maritime & Anti-Piracy Law",
                        "Fiqh Al-Baḥr, Ta'wīḍ Al-Taghrīq (General Average Jettison) & Qaṭ' Al-Ṭarīq fī Al-Baḥr",
                        "Mediterranean, Red Sea & Indian Ocean Shipping Lanes",
                        "Codified by Maliki jurist Muḥammad ibn 'Umar al-Kinānī al-Andalusī in 'Kitāb Akriyat Al-Sufun wa Al-Nizā' bayna Ahlihā': 1) Sea pirates (Luṣūṣ Al-Baḥr) are legally prosecuted under Qur'an 5:33 (Ḥirābah); 2) If a ship is attacked by pirates or caught in a storm and cargo must be jettisoned to save the ship, ALL merchants on board share the loss proportionally according to the market value of their saved goods (General Average); 3) If pirates capture a ship, freight fees are suspended or prorated by distance sailed.",
                        "Kitāb Akriyat Al-Sufun (ed. Khalilieh); Qur'an 5:33 & 16:14",
                        "#38BDF8"
                ),
                new PiracyAndMaritimeLawCase(
                        3,
                        "807–860 CE (192–246 AH) • First Ibāḍī Imamate of Oman & Socotra",
                        "Imam Ghassān ibn 'Abdullāh's Shadhāt Coast Guard vs. The Bawārij Pirates",
                        "Ḥimāyat Al-Baḥr (Sovereign Sea-Lane Protection) & Bawārij Suppression",
                        "Omani Coast (Sohar, Muscat, Sur), Socotra Island & Mouth of the Indus/Kathiawar",
                        "When piratical fleets known as Al-Bawārij raided merchant dhows sailing between Basrah, Sohar, and India/China, Imam Ghassān ibn 'Abdullāh Al-Yaḥmadī (r. 807–823 CE) constructed the first specialized Omani anti-piracy naval flotilla (Al-Shadhāt)—fast, maneuverable oared-and-sailed interceptors that cleared the Arabian Sea and established permanent Omani naval convoys.",
                        "Al-Sālimī, Tuḥfat Al-A'yān bi-Sīrat Ahl 'Umān; Al-Mas'ūdī, Murūj Al-Dhahab",
                        "#D4AF37"
                ),
                new PiracyAndMaritimeLawCase(
                        4,
                        "1229–1454 CE (626–858 AH) • Rasulid Sultanate of Yemen (Aden & Bab al-Mandab)",
                        "The Rasulid Galley Squadron of Aden (*Shīnī Al-Thaghr*) & Convoy Escort Tax (*Al-Shawānī*)",
                        "Rasulid State Anti-Piracy Convoy System for the Kārimī Spice Fleet",
                        "Port of Aden, Bab al-Mandab, Dahlak Islands, Al-Shiḥr & Malabar Sea Route",
                        "To protect Indian Ocean merchant dhows from piracy at the chokepoint of Bab al-Mandab and the Somali/Dahlak reefs, the Rasulid Sultans of Yemen maintained a permanent squadron of armed war galleys (Al-Shawānī) stationed at Aden, funded by a transparent, fixed convoy-protection tariff recorded in the royal customs ledger Mulakhkhaṣ Al-Fiṭan (1411 CE).",
                        "Mulakhkhaṣ Al-Fiṭan (1411 CE, Aden); Ibn Al-Mujāwir, Tārīkh Al-Mustabṣir",
                        "#F59E0B"
                ),
                new PiracyAndMaritimeLawCase(
                        5,
                        "1498–1698 CE (903–1110 AH) • Aden, Jeddah, Muscat & Mombasa",
                        "Yemeni, Ottoman & Omani Ya'rubid Liberation of the Indian Ocean from Portuguese Cartaz Piracy",
                        "Counter-Blockade Against the Coercive Portuguese Cartaz System",
                        "Aden (1513 Defense), Jeddah (1517 Defense), Muscat (Liberated 1650) & Mombasa Fort Jesus (Liberated 1698)",
                        "When Portuguese fleets entered the Indian Ocean demanding extortionate Cartaz protection passes and burning unarmed pilgrim ships (such as the Mīrī in 1502), Yemeni Tahirid commander Amir Murjān repulsed Albuquerque at the walls of Aden (1513); Ottoman Admiral Selman Reis defeated Lopo Soares at Jeddah (1517); and the Ya'rubid Imams of Oman (Sulṭān ibn Sayf I and Sayf ibn Sulṭān) built Western-gunned multi-decked ocean warships, expelled the Portuguese from Muscat (1650), and liberated Mombasa and Zanzibar (1698) at the request of East African Muslim rulers.",
                        "Qutb al-Dīn al-Nahrawālī, Al-Barq Al-Yamānī; Omani Chronicle of Ibn Ruzayq (Al-Fatḥ Al-Mubīn)",
                        "#F43F5E"
                ),
                new PiracyAndMaritimeLawCase(
                        6,
                        "1516–1786 CE (922–1200 AH) • Algiers, Tunis, Tripoli, Salé & Tangier",
                        "Mediterranean Corsairs (Ta'ifat Al-Ra'īs), Rescue of Andalusian Exiles & The 1786 Moroccan-US Treaty",
                        "Jihād Al-Baḥr (State-Commissioned Privateering) vs. Treaty Safe-Conduct (Amān Al-Sufun)",
                        "Western Mediterranean & Atlantic Coast of Morocco",
                        "Operating under Ottoman and Moroccan state commissions (distinct from lawless piracy), admirals Hayreddin Barbarossa (Kapudan Pasha), Oruç Reis, and Turgut Reis evacuated over 70,000 persecuted Andalusian Muslims and Jews from Spain. Under Islamic international law (Siyar), any nation signing a bilateral treaty of Amān received full maritime immunity—culminating in Sultan Muḥammad III of Morocco being the first monarch on earth to recognize the United States (1777) and signing the 1786 Moroccan-American Treaty of Peace and Friendship guaranteeing safe passage for American merchant ships.",
                        "Kâtip Çelebi, Tuḥfat Al-Kibār fī Asfār Al-Biḥār; 1786 Treaty of Marrakech (signed by Thomas Jefferson & John Adams)",
                        "#A855F7"
                )
        );
    }

    public static List<MercantilismAndCurrencyInstrument> canonicalMercantilismAndCurrencyInstruments() {
        return List.of(
                new MercantilismAndCurrencyInstrument(
                        1,
                        "1. Caliphal Gold & Silver Monetary Standard",
                        "Al-Dīnār Al-Dhahabī & Al-Dirham Al-Fiḍḍī (الدينار الذهبي والدرهم الفضي — Ratio 7:10)",
                        "Caliph 'Abd al-Malik's Epigraphic Gold Dinar (4.25g) & Silver Dirham (2.97g)",
                        "Instituted in 77 AH (696–697 CE): 1 Mithqāl Gold Dīnār = 4.25 grams of 97%+ pure 24k gold (= weight of 72 grains of barley); 1 Silver Dirham = 2.975 grams of pure silver (exact 7:10 weight ratio where 10 Dirhams = 7 Mithqāls). Zero human portraits; stamped with Surah Al-Ikhlāṣ (112:1–4) and Surah At-Tawbah (9:33).",
                        "Served for 500+ years as the 'Dollar of the Middle Ages' from Córdoba and London to Aden, Sohar, Malabar, and Canton. In 774 CE, Anglo-Saxon King Offa of Mercia minted his famous English gold 'Mancus' as a direct replica of Caliph Al-Manṣūr's 157 AH Abbasid Dīnār, complete with the Arabic Shahādah!",
                        "Qur'an 3:75 (Qintār & Dīnār), 12:20 (Darāhim Ma'dūdah), 18:19 (Wariqikum); Al-Maqrīzī, Shudhūr Al-'Uqūd fī Dhikr Al-Nuqūd",
                        "#D4AF37"
                ),
                new MercantilismAndCurrencyInstrument(
                        2,
                        "2. Maritime Venture-Capital Partnership",
                        "Al-Qirāḍ / Al-Muḍārabah Al-Baḥriyyah (القراض / المضاربة البحرية -> Latin 'Commenda')",
                        "Risk-Sharing Sea-Venture Partnership (Origin of the European Commenda)",
                        "Capital investor (Rabb Al-Māl) entrusts gold Dīnārs or trade goods to a traveling shipmaster/merchant (Al-Muḍārib). Upon safe return from Yemen, Oman, India, or East Africa, net profits are divided by pre-agreed percentage (e.g., 50/50 or 2/3–1/3). If the ship is lost to storm or piracy without negligence, financial loss falls 100% on capital—the sailor only loses his labor and is never enslaved by interest-bearing debt (Ribā).",
                        "Enabled small and medium mariners in Aden, Sohar, Siraf, Fustat, and Qayrawān to finance trans-oceanic voyages; copied verbatim by 11th-century Amalfi, Pisa, Genoa, and Venice as the 'Commenda' contract that launched Italian Renaissance capitalism.",
                        "Qur'an 2:275, 62:10, 73:20 ('And others traveling through the land seeking the bounty of Allah'); Muwaṭṭa' Imām Mālik (Kitāb Al-Qirāḍ)",
                        "#10B981"
                ),
                new MercantilismAndCurrencyInstrument(
                        3,
                        "3. Paper Banking, Checks & Letters of Credit",
                        "Al-Ṣakk (الصك -> 'Check/Cheque'), Al-Suftajah (السفتجة) & Al-Ḥawālah (الحوالة)",
                        "Long-Distance Bills of Exchange, Checks & Debt-Transfer Clearing",
                        "To avoid carrying heavy chests of gold and silver across pirate-infested straits, a merchant deposited funds with a banker (Ṣarrāf / Jahbadh) in Basrah or Cairo and received a sealed paper Suftajah or Ṣakk redeemable in Aden, Muscat, Samarkand, or Quanzhou.",
                        "Nāṣir-i Khusraw (1050 CE) recorded that in Basrah and Aden, all maritime wholesale transactions were conducted by written paper checks (Khaṭṭ-i Ṣarrāf), never physical cash!",
                        "Qur'an 2:282 (The Verse of Recording Debt — Āyat Al-Mudāyanah); Sahih al-Bukhari 2287 (Ḥawālah)",
                        "#38BDF8"
                ),
                new MercantilismAndCurrencyInstrument(
                        4,
                        "4. Red Sea & Indian Ocean Merchant Syndicate",
                        "Tujjār Al-Kārim (تجار الكارم — The Kārimī Spice & Maritime Banking Guild)",
                        "Trans-Oceanic Merchant Consortium of Aden, Zabīd, Jeddah & Cairo (11th–15th c. CE)",
                        "Family-networked merchant houses (such as the Banū Kuwayk, Banū Al-Kharrūbī, and Banū Al-Maḥallī) operating multi-ship convoys (Al-Kārim) between Malabar/Calicut, Rasulid Aden, Jeddah, and Mamluk Cairo/Alexandria, with their own private armed escorts, warehouses, and international banking desks.",
                        "Controlled the global pepper, cinnamon, clove, ginger, porcelain, and silk trade before 1500 CE while endowing Waqf schools, hospitals, and mosques from Yemen to Cairo.",
                        "Al-Qalqashandī, Ṣubḥ Al-A'shā; Ibn Ḥajar Al-'Asqalānī, Inbā' Al-Ghumr",
                        "#F59E0B"
                ),
                new MercantilismAndCurrencyInstrument(
                        5,
                        "5. Bonded Maritime Entrepôts & Free-Trade Customs",
                        "Al-Funduq (الفندق -> Venetian 'Fondaco'), Al-Wakālah & Al-Furḍah (الفرضة)",
                        "Waterfront Bonded Warehouses, Merchant Consulates & Transparent Customs Ledgers",
                        "Islamic maritime mercantilism rejected monopolistic hoarding (Iḥtikār) in favor of high-volume, low-tariff entrepôt trade ('Ushūr: 2.5% for Muslims, 5% for Dhimmīs, 10% for foreign treaty merchants, often lowered by Omani/Yemeni rulers to 3–5% to attract global shipping). Foreign merchants (Jewish Cairo Geniza traders, Hindu Banians, Chinese, Venetians) lived in self-governing Funduqs with their own courts and places of worship.",
                        "Instantiated in Aden's Furḍah (documented in the 1411 CE Mulakhkhaṣ Al-Fiṭan), Muscat, Hormuz, Sohar, Alexandria, and Malacca.",
                        "Sahih Muslim 1605 ('No one hoards [yaḥtakiru] except a wrongdoer'); Cairo Geniza India Book Documents (ed. S. D. Goitein)",
                        "#A855F7"
                ),
                new MercantilismAndCurrencyInstrument(
                        6,
                        "6. Omani, Yemeni & Indian Ocean Regional Trade Currencies",
                        "Dirham Al-Rasūlī, Al-Lārīn Al-Hurmuzī (اللارين), Riyāl Faransī & Baysah 'Umāniyyah (البيسة)",
                        "Rasulid Silver Dirhams, Hormuzi Twisted-Silver Larins, Maria Theresa Thalers & Omani/Zanzibari Coinage",
                        "1) Rasulid Yemeni Dirhams (minted at Aden, Zabīd, Ta'izz with zodiacal/heraldic emblems); 2) Hormuzi & Omani 'Lārīn' (pure silver wire bent into a twin-pronged fish-hook/hairpin shape stamped with Arabic inscriptions, prized across the Persian Gulf, Oman, Maldives, and Ceylon); 3) The 1780 silver Maria Theresa Thaler ('Riyāl Faransī' / 'Abū Nuqṭah', 28.06g, 83.3% silver) and Omani Sultanate 'Riyāl Sa'īdī / Barghashī' & copper 'Baysah' circulating across Yemen, Oman, and East Africa.",
                        "Unified coastal pricing of Mocha coffee, Dhofari frankincense, Omani dates, Gulf pearls, and Zanzibari cloves.",
                        "Numismatic Collections of the National Museum of Oman (Muscat) & Aden Museum",
                        "#F43F5E"
                )
        );
    }

    public static List<CartographyAstrolabeCompassMilestone> canonicalCartographyAstrolabeCompassMilestones() {
        return List.of(
                new CartographyAstrolabeCompassMilestone(
                        1,
                        "1. Geodesy & Open-Ocean World Map",
                        "Caliph Al-Ma'mūn's 70 Geographers & Al-Khwārizmī",
                        "c. 830 CE (215 AH) • Baghdad & Plain of Sinjār",
                        "Al-Ṣūrah Al-Ma'mūniyyah & Kitāb Ṣūrat Al-Arḍ (Book of the Configuration of the Earth)",
                        "Measured 1 degree of terrestrial latitude on the flat desert of Sinjār using astrolabes and Surveying cords (56.67 Arabic miles = 111.8 km, within 0.6% of modern satellite geodesy!). Corrected 2,400 coordinates from Ptolemy's Geography and overturned Ptolemy's false dogma that the Indian Ocean was a landlocked lake, proving it is an open ocean connected to the Pacific and Atlantic.",
                        "Established mathematical latitude/longitude coordinate tables (Zīj) for every port from Tangier to Canton.",
                        "#38BDF8"
                ),
                new CartographyAstrolabeCompassMilestone(
                        2,
                        "2. Silver Planisphere & 70-Map World Atlas",
                        "Al-Sharīf Al-Idrīsī (1100–1165 CE, Ceuta / Córdoba / Palermo)",
                        "1154 CE (548 AH) • Palermo, Sicily",
                        "Nuzhat Al-Mushtāq fī Ikhtirāq Al-Āfāq (Tabula Rogeriana) & The 300-lb Silver Disk",
                        "Divided the inhabited hemisphere into 7 latitudinal climes (Al-Aqālīm Al-Sab'ah) × 10 longitudinal sections = 70 detailed regional maps (oriented with South at the top), synthesizing merchant itineraries, maritime soundings, and astronomical coordinates from Spain and West Africa across the Red Sea, Yemen (Aden/Shihr), Oman (Sohar/Qalhat), India, Nusantara, and Korea (Al-Sīlā).",
                        "Remained the most accurate world atlas on earth for over three centuries.",
                        "#D4AF37"
                ),
                new CartographyAstrolabeCompassMilestone(
                        3,
                        "3. Ottoman Portolan Atlases & Atlantic/Red Sea Cartography",
                        "Admiral Piri Reis (Ḥājjī Muḥyī al-Dīn Pīrī, c. 1465–1553 CE) & Seydi Ali Reis",
                        "1513, 1521/1525 & 1554 CE • Gallipoli, Cairo, Suez, Aden & Muscat",
                        "1513 Piri Reis World Map, Kitāb-ı Baḥriye (Book of Navigation, 210+ portolan charts) & Kitāb Al-Muḥīṭ",
                        "Used multi-center wind-rose rhumb networks (Loxodromes) to chart every harbor, reef, freshwater spring, anchorage depth, and wind pattern in the Mediterranean and Aegean (Kitāb-ı Baḥriye), while his 1513 world map on gazelle skin synthesized 20 Arabic, Portuguese, and Columbian charts showing South America and the Atlantic. In 1554, Ottoman Admiral Seydi Ali Reis compiled 'Al-Muḥīṭ' in Gujarat, translating Omani/Yemeni navigator Ibn Mājid's Indian Ocean star-compass science into Ottoman Turkish.",
                        "Bridged Mediterranean portolan cartography with Omani-Yemeni Indian Ocean celestial navigation.",
                        "#F43F5E"
                ),
                new CartographyAstrolabeCompassMilestone(
                        4,
                        "4. The Planispheric & Universal Astrolabe",
                        "Al-Fazārī, Al-Ṣūfī (903–986 CE), Maryam Al-Asṭurlābiyyah & Al-Zarqālī (1029–1087 CE)",
                        "8th–11th Centuries CE • Baghdad, Shiraz, Aleppo & Toledo",
                        "Al-Asṭurlāb Al-Musaṭṭaḥ & Al-Ṣafīḥah Al-Zarqāliyyah (The Universal Saphaea)",
                        "Uses stereographic projection to map the 3D celestial sphere (the skeletal 'Ankabūt / Rete with flame-shaped star pointers) onto flat brass altitude/azimuth plates (Ṣafā'iḥ / Tympans) for specific latitudes, with a sighting rule (Al-'Iḍādah -> English 'Alidade') on the back. Al-Zarqālī in Toledo invented the Universal Astrolabe (Al-Ṣafīḥah) using the equinoctial points as projection poles so mariners and travelers could use a SINGLE plate at any latitude on earth!",
                        "Gave international astronomy over 200 Arabic star names (Aldebaran, Altair, Vega, Rigel, Betelgeuse, Deneb, Fomalhaut) and directly birthed the European Mariner's Astrolabe and Quadrant.",
                        "#10B981"
                ),
                new CartographyAstrolabeCompassMilestone(
                        5,
                        "5. The Omani & Yemeni Mariner's Kamāl (Al-Lawḥ wa Al-Khayṭ)",
                        "Arab Indian Ocean Navigators (Mu'allimūn — Ibn Mājid & Sulaymān Al-Mahrī)",
                        "9th–16th Centuries CE • Sohar, Muscat, Qalhāt, Aden, Al-Shiḥr & Malindi",
                        "Al-Kamāl / Khashabāt Al-Qiyās (The Celestial Latitude Tablet & Knotted Cord)",
                        "Because a heavy brass astrolabe pendulums wildly on a pitching ship deck, Omani and Yemeni navigators engineered the Kamāl: a 2×1 inch rectangular horn or teakwood tablet threaded with a silk cord tied with calibrated knots representing specific ports. Holding a knot between the teeth with string taut, the navigator aligned the lower edge of the wood with the sea horizon and the upper edge with Polaris (Al-Jāh) or the Little Bear guards (Al-Farqadān), measuring altitude in 'Aṣābi'' (finger-widths, 1 Iṣba' = 1° 36' 25\" ≈ 97 nautical miles of latitude!).",
                        "Demonstrated to Vasco da Gama at Malindi in 1498 CE; directly inspired the European Mariner's Cross-Staff (Balestilha) and Backstaff.",
                        "#F59E0B"
                ),
                new CartographyAstrolabeCompassMilestone(
                        6,
                        "6. The Dry-Pivot Magnetic Compass & 32-Point Sidereal Wind Rose",
                        "Sultan Al-Ashraf 'Umar II of Yemen (1293 CE) & Omani Navigator Aḥmad ibn Mājid (1490 CE)",
                        "1242–1490 CE • Aden/Ta'izz (Yemen), Julfar/Sohar (Oman) & Red Sea",
                        "Bayt Al-Ibrah / Al-Ḥuqqah & Dā'irat Al-Akhnān (The 32-Rhumb Star Compass Rose)",
                        "While early mariners floated a magnetized iron fish (Samakah) in water (documented by Baylak Al-Qibjāqī, 1242/1282 CE), Rasulid Yemeni Sultan Al-Ashraf 'Umar II wrote the earliest scientific treatise on the dry-pivot compass box (Ṭāsat Al-Qiblah, 1293 CE). Omani master navigator Shihāb al-Dīn Aḥmad ibn Mājid ('The Lion of the Sea', b. Julfar/Oman, c. 1421 CE) housed the magnetic needle inside a gimbaled brass box (Al-Ḥuqqah) beneath the 32-Point Sidereal Compass Rose (Al-Akhnān), where each 11.25° rhumb is named after the rising (Maṭla') and setting (Maghīb) of 15 fixed equatorial/northern/southern stars plus Polaris (Al-Jāh) and Canopus/South Pole (Al-Quṭb Al-Suhaylī).",
                        "Enabled precision open-ocean dead reckoning (Al-Dīrah) and latitude sailing (Al-Majrā) across 4,000+ miles of featureless ocean during the monsoon.",
                        "#A855F7"
                )
        );
    }

    public static List<StarCompassPortNode> canonicalStarCompassPorts() {
        return List.of(
                new StarCompassPortNode(
                        1,
                        "Muscat & Sohar (Oman)",
                        "Masqaṭ wa Ṣuḥār (مسقط وصحار)",
                        "Omani Heartlands (Gulf of Oman)",
                        "Maṭla' Al-Nisr Al-Ṭā'ir (Rising of Altair — E by N) / Al-Jāh",
                        11.0,
                        23.61,
                        "NE Winter Monsoon (Al-Azyab / Kaws, Nov–Mar) -> S/SW to India & East Africa",
                        "Frankincense, Copper, Dates, Arabian Horses, Pearls • Abbasid Dīnār & Omani Sa'īdī Riyāl",
                        "#D4AF37"
                ),
                new StarCompassPortNode(
                        2,
                        "Sur & Qalhāt (Oman)",
                        "Ṣūr wa Qalhāt (صور وقلهات)",
                        "Eastern Omani Cape (Ra's Al-Ḥadd)",
                        "Maṭla' Al-Simāk (Rising of Arcturus) / Departure Point for India",
                        10.25,
                        22.56,
                        "Gateway Cape where Gulf of Oman meets the open Arabian Sea monsoon swells",
                        "Deep-Sea Baghlah & Ghanjah Shipbuilding, Horses, Indigo • Hormuzi Lārīn & Gold Dīnār",
                        "#10B981"
                ),
                new StarCompassPortNode(
                        3,
                        "Dhofar — Mirbāṭ & Salalah (Southern Oman)",
                        "Ẓafār wa Mirbāṭ (ظفار ومرباط)",
                        "Southern Omani Frankincense Coast",
                        "Maṭla' Al-Iklīl (Rising of Antares/Scorpio)",
                        7.75,
                        17.01,
                        "Summer Khareef Monsoon (Al-Kharīf / Dāmān, May–Sep) cools coastal mountains into emerald mist",
                        "Sacred Royal Frankincense (Al-Lubān Al-Ḥojari), Myrrh, Cavalry • Rasulid & Omani Silver Dirhams",
                        "#34D399"
                ),
                new StarCompassPortNode(
                        4,
                        "Al-Shiḥr & Mukallā (Hadhramaut, Yemen)",
                        "Al-Shiḥr wa Al-Mukallā (الشحر والمكلا)",
                        "Yemeni Hadhrami Coast",
                        "Maṭla' Al-'Aqrab (Rising of Scorpio)",
                        6.75,
                        14.75,
                        "Launchpad of the Hadhrami Bā 'Alawī & Al-Mahrī navigators to Malabar, Aceh, Java & Swahili Rim",
                        "Ambergris ('Anbar), Dragon's Blood Resin, Frankincense, Textiles • Rasulid/Kathiri Coinage",
                        "#38BDF8"
                ),
                new StarCompassPortNode(
                        5,
                        "Aden ('Adan, Southern Yemen)",
                        "Thaghr 'Adan Al-Maḥrūs (ثغر عدن المحروس)",
                        "Yemeni Volcanic Harbor & Gate of Bab al-Mandab",
                        "Maṭla' Al-Ḥimārayn (Rising of Alpha/Beta Centauri)",
                        5.0,
                        12.78,
                        "Dual-Monsoon Hinge where Red Sea winds meet Indian Ocean monsoons (Mulakhkhaṣ Al-Fiṭan)",
                        "Kārimī Spice Clearinghouse, Pepper, Silk, Porcelain, Madder Dye • Rasulid Multi-Dirham & Gold Dīnār",
                        "#F59E0B"
                ),
                new StarCompassPortNode(
                        6,
                        "Al-Mukhā / Mocha & Zabīd (Red Sea Yemen)",
                        "Al-Mukhā wa Zabīd (المخا وزبيد)",
                        "Yemeni Tihāmah Red Sea Coast",
                        "Maghīb Al-Thurayyā (Setting of the Pleiades — WNW)",
                        5.5,
                        13.32,
                        "Red Sea Seasonal Wind Regime (Southerly Azyab in winter, Northerly Shimāl in summer)",
                        "Global Birthplace of Coffee Trade (Al-Qahwah Al-Yamanīyah), Indigo, Manuscripts • Ottoman Sultānī & Silver Riyāl",
                        "#F43F5E"
                ),
                new StarCompassPortNode(
                        7,
                        "Calicut / Kozhikode (Malabar Coast, India)",
                        "Qālīqūṭ / Malībār (قاليقوط — ساحل مليبار)",
                        "Eastern Terminus of the Omani-Yemeni 28-Day Monsoon Crossing",
                        "Maṭla' Al-Jawzā' (Rising of Orion's Belt — Due East)",
                        4.5,
                        11.25,
                        "20-to-28-day direct open-ocean latitude run (Al-Majrā) from Ra's Al-Ḥadd / Aden on the SW Monsoon",
                        "Black Pepper (Al-Filfil), Teak Timber (Sāj for Dhow Hulls), Cardamom, Ginger • Caliphal Gold Dīnār",
                        "#A855F7"
                ),
                new StarCompassPortNode(
                        8,
                        "Zanzibar & Kilwa (Swahili Coast / Omani East Africa)",
                        "Zinjibār wa Kilwah (زنجبار وكلوة)",
                        "Southern Terminus of the Omani Monsoon Corridor (6°–9° S)",
                        "Al-Quṭb Al-Suhaylī & Al-Farqadān (Measured by Canopus / Southern Cross & Beta Ursae Minoris)",
                        1.0,
                        -6.16,
                        "Sail South on the NE Winter Monsoon (Nov–Feb); Return North to Oman/Yemen on the SW Monsoon (Apr–Aug)",
                        "Cloves (Qaranful), Mangrove Poles (Boriti), Gold of Sofala, Ivory • Kilwa Copper Fals & Omani/Zanzibari Riyāl",
                        "#EC4899"
                )
        );
    }

    public static List<OmaniYemeniCoastingPolity> canonicalOmaniYemeniPolities() {
        return List.of(
                new OmaniYemeniCoastingPolity(
                        1,
                        "YEMEN & OMAN IN THE PROPHETIC & RĀSHIDŪN / UMAYYAD / ABBASID CALIPHATES",
                        "1. Peaceful Embrace of Al-Julandā Oman & Badhān Yemen (8 AH / 630 CE – 1050 CE)",
                        "630–1050 CE (8–442 AH)",
                        "Sohar (Ṣuḥār), Daba, Muscat, Qalhāt (Oman) • Sana'a, Aden, Al-Shiḥr, Zabīd (Yemen)",
                        "Both Yemen and Oman embraced Islam PEACEFULLY without military conquest in 628–630 CE (8 AH): Governor Badhān of Yemen accepted the Prophet's letter, followed by Mu'ādh ibn Jabal's mission; in Oman, Kings Jayfar and 'Abd (sons of Al-Julandā) embraced Islam via the Prophet's letter carried by 'Amr ibn al-'Āṣ, earning the Prophetic supplication: 'May Allah have mercy on the people of Al-Ghubayrā' (Oman); they believed in me without having seen me!' Under the Umayyads and Abbasids, Omani Sohar and Yemeni Aden served as the twin maritime lungs of the Caliphate.",
                        "Omani navigator Abū 'Ubaydah 'Abdullāh ibn al-Qāsim (8th c.) sailed 7,000 miles from Sohar to Guangzhou (Canton), establishing the Muslim merchant mosque in Tang China; Al-Maqdisī (985 CE) called Sohar 'the hallway to China, the storehouse of the East and Iraq, and the lifeline of Yemen.'",
                        "Great Mosque of Sana'a (630 CE) & Mosque of Al-Miḍmār (Samā'il, Oman — built by Māzin ibn Ghaḍūbah, first Omani companion).",
                        "#10B981"
                ),
                new OmaniYemeniCoastingPolity(
                        2,
                        "YEMENI FATIMID-SULAYHID & ZURAY'ID MARITIME ENTREPÔT",
                        "2. The Sulayhid Dynasty (Queen Arwā) & Zuray'id Port-Kingdom of Aden",
                        "1047–1173 CE (439–569 AH)",
                        "Jiblah, Sana'a, Aden ('Adan) & Dahlak Archipelago",
                        "Aligned with the Fatimid Caliphate in Cairo, shifting the entire Indian Ocean spice trade away from the Persian Gulf into the Red Sea corridor (Aden -> Aidhab/Jeddah -> Cairo -> Alexandria). Queen Arwā bint Aḥmad al-Ṣulayḥī ('Al-Sayyidah Al-Ḥurrah', r. 1067–1138 CE) ruled Yemen for 71 years as Hujjah and sovereign monarch, fortifying Aden's harbor walls and customs house (Al-Furḍah).",
                        "Cairo Geniza letters (11th–12th c.) document Jewish, Muslim, and Hindu shipowners in Aden operating joint Qirāḍ shipping partnerships under Zuray'id protection, with coast-guard fleets rescuing shipwrecked cargos along Bab al-Mandab.",
                        "Queen Arwā Mosque & Palace at Jiblah, Cisterns of Tawīlah (Ṣahārīj 'Adan) & Sīrah Island Fortress.",
                        "#38BDF8"
                ),
                new OmaniYemeniCoastingPolity(
                        3,
                        "YEMENI RASULID & TAHIRID MARITIME SULTANATES",
                        "3. The Rasulid Sultanate (Banū Rasūl, 1229–1454 CE) & Tahirid Sultanate (1454–1517 CE)",
                        "1229–1517 CE (626–923 AH)",
                        "Ta'izz, Zabīd, Aden, Al-Shiḥr & Al-Mukhā (Mocha)",
                        "Founded by Nūr al-Dīn 'Umar ibn 'Alī ibn Rasūl (originally Ayyubid deputy), the Rasulids received diplomatic investiture from the Abbasid Caliph Al-Mustanṣir in Baghdad while sending embassies to Ming China, Mamluk Egypt, India, and Abyssinia.",
                        "Instituted the world's most sophisticated medieval maritime customs administration (Mulakhkhaṣ Al-Fiṭan, 1411 CE), maintained the Shīnī war-galley fleet at Aden, patronized the Kārimī merchant guild, and in 1513 CE under Tahirid governor Amir Murjān defeated Afonso de Albuquerque's Portuguese armada at the walls of Aden.",
                        "Sultan Al-Ashraf 'Umar II's 1293 CE treatise on the Magnetic Compass & Astrolabe; Ashrafiyyah Madrasah (Ta'izz) & 'Āmiriyyah Madrasah (Radā').",
                        "#F59E0B"
                ),
                new OmaniYemeniCoastingPolity(
                        4,
                        "YEMENI MOCHA COFFEE EMPIRE & HADHRAMI INDIAN OCEAN DIASPORA",
                        "4. Ottoman/Qasimid Mocha Coffee Trade & The Hadhrami Coasting Network",
                        "1450–1850 CE (854–1266 AH)",
                        "Al-Mukhā (Mocha), Hodeidah, Bait al-Faqīh, Al-Shiḥr, Mukallā & Tarīm",
                        "Under Ottoman Eyalet naval protection (from 1538 CE) and the Qasimid Imamate (from 1597 CE), the Red Sea port of Al-Mukhā (Mocha) held a global monopoly on Coffea arabica cultivated on the terraced mountains of Harāz and Yāfi'. Simultaneously, Hadhrami Sayyids (Bā 'Alawī) and mariners (such as Sulaymān Al-Mahrī of Al-Shiḥr) sailed every monsoon across the Indian Ocean.",
                        "Mocha drew silver Spanish pieces-of-eight and Austrian thalers from across the globe, while Hadhrami coasting dhows peacefully Islamized the Comoros, Swahili coast, Malabar (Mappila), and the Malay-Indonesian Archipelago (Wali Songo / Aceh / Pontianak / Siak).",
                        "Sulaymān Al-Mahrī's 'Al-'Umdah Al-Mahrīyah fī Ḍabṭ Al-'Ulūm Al-Baḥrīyah' (1511 CE) & Al-Miḥḍār Library of Tarīm.",
                        "#F43F5E"
                ),
                new OmaniYemeniCoastingPolity(
                        5,
                        "OMANI NABHANI DYNASTY, HORMUZI QALHĀT & AḤMAD IBN MĀJID",
                        "5. The Nabhani Kings, The Merchant Metropolis of Qalhāt & The Golden Age of Navigation",
                        "1154–1624 CE (549–1033 AH)",
                        "Qalhāt, Sohar, Muscat, Julfar (Ra's al-Khaimah), Bahla & Nizwa",
                        "Linking the interior Omani oasis citadels with the coastal emporia of Qalhāt and Julfar, Oman dominated the horse, pearl, and spice trade between the Persian Gulf, India, and Kilwa (East Africa).",
                        "Produced history's greatest ocean navigator: Shihāb al-Dīn Aḥmad ibn Mājid Al-Sa'dī Al-Najdī (b. c. 1421 CE in Julfar, Oman), author of 40 treatises in prose and verse including 'Kitāb Al-Fawā'id fī Uṣūl 'Ilm Al-Baḥr wa Al-Qawā'id' (1490 CE) and 'Ḥāwiyat Al-Ikhtiṣār', codifying the 32-point star compass, Kamāl latitude measurements, monsoon departure calendars (Al-Nayrūz), and coastal pilotage (Al-Rahnāmaj) for the entire Red Sea and Indian Ocean.",
                        "UNESCO World Heritage Port of Qalhāt (Mausoleum of Bībī Maryam), Bahla Fort & Ibn Mājid's 40 Navigational Codices.",
                        "#A855F7"
                ),
                new OmaniYemeniCoastingPolity(
                        6,
                        "OMANI YA'RUBID IMAMATE — NAVAL LIBERATION OF MUSCAT & EAST AFRICA",
                        "6. Dawlat Al-Ya'āribah (The Ya'rubid Imamate of Oman, 1624–1744 CE)",
                        "1624–1744 CE (1033–1157 AH)",
                        "Rustaq, Nizwa, Muscat, Sur, Sohar, Mombasa (Fort Jesus), Pemba & Zanzibar",
                        "Elected at Rustaq in 1624 CE, Imam Nāṣir ibn Murshid unified interior and coastal Oman. His cousin Imam Sulṭān ibn Sayf I (r. 1649–1688 CE) liberated Muscat from 143 years of Portuguese occupation in January 1650 CE and built the first indigenous Indian Ocean blue-water battleship fleet.",
                        "Under Imam Sayf ibn Sulṭān ('Qayd Al-Arḍ', r. 1692–1711 CE), the Omani fleet possessed 28 square-rigged frigates and giant Baghlahs (headed by the 80-gun flagship 'Al-Falak') and 1,700 naval cannons! After a heroic 33-month siege (1696–1698 CE), Omani forces liberated Fort Jesus in Mombasa, expelling the Portuguese from the entire Swahili Coast north of Mozambique.",
                        "Jabrin Castle (1675 CE), Al-Ḥazm Castle, Al-Jalālī & Al-Mīrānī Forts of Muscat, and restoration of 17 Aflāj water systems.",
                        "#D4AF37"
                ),
                new OmaniYemeniCoastingPolity(
                        7,
                        "OMANI AL BU SA'ID MARITIME EMPIRE OF MUSCAT & ZANZIBAR",
                        "7. The Al Bu Sa'id Thalassocracy & Sayyid Sa'īd ibn Sulṭān (1744–1856+ CE)",
                        "1744–1856+ CE (1157–1273+ AH)",
                        "Muscat, Sohar, Sur, Bandar Abbas, Gwadar (Balochistan), Mogadishu, Mombasa, Kilwa & Zanzibar",
                        "Founded by Imam Aḥmad ibn Sa'īd (r. 1744–1783 CE, who sent a 10-ship Omani relief fleet in 1775 to aid Ottoman Basrah) and expanded by Sayyid Sa'īd ibn Sulṭān (r. 1806–1856 CE) into a bi-continental Afro-Arabian maritime empire with twin capitals at Muscat and Zanzibar (Stone Town).",
                        "Commanded a modern navy (including the 74-gun ship-of-the-line 'Liverpool/Imām', the 50-gun 'Shāh 'Ālam', and the corvette 'Al-Sulṭānah') alongside hundreds of merchant dhows. Signed the 1833 Treaty of Amity and Commerce with the United States and in 1840 sailed the Omani ship 'Al-Sulṭānah' under envoy Aḥmad ibn Na'mān all the way to New York Harbor!",
                        "Bait Al-Falaj & Bait Al-'Ajā'ib (Zanzibar), introduction of Swahili-Arabic printing, and global clove/frankincense maritime commerce.",
                        "#EC4899"
                )
        );
    }
}
