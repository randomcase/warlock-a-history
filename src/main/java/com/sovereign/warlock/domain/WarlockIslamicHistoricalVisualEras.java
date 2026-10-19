package com.sovereign.warlock.domain;

import java.util.List;

/**
 * Chronicles and specifies the 7 Historical Eras of Islamic Visual Art, Illumination,
 * Miniature Painting, Architectural Geometry, and AI Cyber-Geometric Synthesis depicting
 * the 7 Warlock Orders, the Negentropic Priory, Ja'far's Qumqum Dissolution, and the
 * Walled Rose Sanctuary across history:
 *
 *  - Era I   (Pre-610 CE)   : Pre-Prophetic Babil, Sabaean Musnad & Late-Antique Lapis Reliefs
 *  - Era II  (661–1050 CE)  : Umayyad Gold Mosaic & Abbasid Baghdad Bayt al-Hikmah Manuscript Style
 *  - Era III (969–1517 CE)  : Fatimid, Ayyubid & Mamluk Cairo Ablaq, Muqarnas & Enameled Mishkat Style
 *  - Era IV  (711–1492 CE)  : Andalusian & Maghrebi Alhambra Zellij, Sebka & Generalife Chahar Bagh Style
 *  - Era V   (1370–1722 CE) : Timurid & Safavid Persian Miniature Painting (Behzad / Tabriz / Isfahan)
 *  - Era VI  (1453–1922 CE) : Classical Ottoman Imperial Nakkashane, Matrakci Nasuh & Iznik Gul-i Muhammadi Style
 *  - Era VII (21st Century) : Sovereign Neo-Islamic AI Cyber-Geometric & Parametric Fractal Synthesis
 */
public final class WarlockIslamicHistoricalVisualEras {

    private WarlockIslamicHistoricalVisualEras() {
    }

    public record IslamicVisualEraDossier(
            int eraIndex,
            String eraCode,
            String chronologicalSpan,
            String arabicEraTitle,
            String englishEraTitle,
            String historicalDynastyAndCenters,
            String canonicalPigmentsAndPalette,
            List<String> hexPalette,
            String geometricAndCalligraphicGrammar,
            String warlockVisualCompositionSubject,
            String aiGenerativePromptSpecification,
            String quranicAndAestheticAnchor,
            int starPolygonFold,
            String svgSacredGeometryPatternType
    ) {}

    private static final List<IslamicVisualEraDossier> SEVEN_ISLAMIC_VISUAL_ERAS = List.of(
            new IslamicVisualEraDossier(
                    1,
                    "VISUAL_ERA_I_BABIL_SABA_LAPIS",
                    "Pre-610 CE (Pre-Prophetic Antiquity)",
                    "Era I: 'Asr Babil wa Saba' wa Al-Lazaward Al-Qadim (عصر بابل وسبأ واللازورد القديم)",
                    "1. Pre-Prophetic Babil & Sabaean Antiquity: Glazed Lapis-Lazuli Reliefs & Alabaster Altars",
                    "Ancient Babylon (Babil of Harut & Marut), Marib (Saba' of Queen Bilqis), and Nabataean Petra.",
                    "Kiln-fired Babylonian cobalt/lapis glaze, Mesopotamian bitumen black, Sabaean translucent alabaster white, and hammered bronze.",
                    List.of("#0F2C59", "#F8F5E6", "#D4AF37", "#141416"),
                    "Stepped ziggurat crenellations, 8-pointed star of Babylon (Najmat Babil), South Arabian geometric Musnad epigraphy, and concentric astrolabic rings.",
                    "Order #1 (Malakh-Azal) and Order #3 (Yored Ha-Merkabah) standing above the Inverted Well of Babil (Bi'r Babil) as the Criterion of Qur'an 2:102 severs ancient planetary sorcery.",
                    "Museum-grade glazed Babylonian lapis-lazuli brick relief and Sabaean alabaster tablet illustration: an ascetic pre-prophetic sage in parchment-white and sapphire robes beside the subterranean well of Babylon, bronze armillary rings, 8-pointed gold star geometry, dramatic chiaroscuro torchlight.",
                    "Qur'an 2:102 (Harut and Marut in Babil), Qur'an 27:22-44 (The Glass Pavilion of Sulayman & Saba'), & Order #1/#3 Foundation Severance.",
                    8,
                    "BABYLONIAN_EIGHT_POINTED_SHAMash_STAR"
            ),
            new IslamicVisualEraDossier(
                    2,
                    "VISUAL_ERA_II_ABBASID_BAYT_AL_HIKMAH",
                    "661–1050 CE (Umayyad & Early Abbasid Golden Age)",
                    "Era II: 'Asr Bayt Al-Hikmah wa Al-Raqq Al-Azraq (عصر بيت الحكمة والرق الأزرق العباسي)",
                    "2. Umayyad & Abbasid Baghdad Manuscript Style: Gold Kufic on Indigo Vellum & Al-Wasiti Miniatures",
                    "Damascus (Umayyad Great Mosque Mosaics), Kairouan (Blue Qur'an), and Baghdad (Bayt al-Hikmah / Yahya ibn Mahmud al-Wasiti).",
                    "Indigo-dyed parchment (`#0B1938`), Chrysography liquid gold ink (`#FBBF24`), verdigris copper-green (`#006B54`), and vermilion cinnabar (`#DC2626`).",
                    List.of("#0B1938", "#FBBF24", "#006B54", "#DC2626"),
                    "Monumental angular Kufic script without diacritics, Abbasid horseshoe arches, botanical vine scrolls, and scientific treatise diagrams of optics (Ibn al-Haytham) and celestial mechanics.",
                    "Order #2 (Katib Al-Qalam) and Order #6 (Ba'al Ha-Nechoshet) inside an Abbasid Baghdad observatory, sealing the smoky Marid of Ja'far inside a Solomonic brass Qumqum beneath a gold Kufic frieze.",
                    "13th-century Abbasid Baghdad illuminated manuscript page by Al-Wasiti merged with Blue Qur'an gold Kufic on deep indigo vellum: a scholar-guardian in a domed Islamic observatory surrounded by brass astrolabes, optical light rays, and a sealed brass Qumqum vessel, flat gold-leaf background.",
                    "Qur'an 68:1 ('Nun. By the Pen and what they inscribe'), Qur'an 34:12 (Sulayman's molten brass fountain), & Ibn al-Haytham's Kitab Al-Manazir.",
                    10,
                    "ABBASID_DECAGONAL_KUFIC_ROSETTE"
            ),
            new IslamicVisualEraDossier(
                    3,
                    "VISUAL_ERA_III_MAMLUK_ABLAQ_MISHKAT",
                    "969–1517 CE (Fatimid, Ayyubid & Mamluk Cairo & Damascus)",
                    "Era III: 'Asr Al-Mamalik wa المشكاة والربط الحديدي (عصر المماليك والمشكاة والربط)",
                    "3. Mamluk Cairo & Damascus Style: Polychrome Ablaq Masonry, Muqarnas Vaults & Enameled Glass Mishkat",
                    "Cairo (Citadel of Saladin & Sultan Hasan Madrasa), Damascus, and Jerusalem (Al-Quds).",
                    "Mamluk Ablaq crimson-red stone (`#8B0000`), basalt black (`#141416`), limestone cream (`#F8F5E6`), Damascus silver-inlaid brass (`#B87333`), and cobalt enameled glass (`#1D4ED8`).",
                    List.of("#8B0000", "#F8F5E6", "#B87333", "#1D4ED8"),
                    "12-pointed Mamluk star girih medallions (`Tabaq Najmi`), honeycomb Muqarnas stalactite pendentives, Thuluth calligraphic bands, and silver-and-gold inlaid metalwork (`Takfit`).",
                    "The Negentropic Priory Keep and Inter-World Sequester (`Sur Al-Hadid`): a Mamluk vaulted hall where an enameled glass Mishkat lamp (Qur'an 24:35) hangs from chains, casting geometric star-light over the 7 quarantined brass Qumqum vessels.",
                    "Interior of a grand Mamluk Cairo citadel chamber with alternating red-and-white Ablaq stone arches, carved Muqarnas stalactite dome, a glowing enameled glass mosque lamp (Mishkat) with blue and gold Thuluth calligraphy, and ornate Damascus brass vessels on a geometric marble floor.",
                    "Qur'an 24:35 (Ayat An-Nur — The Niche, the Glass like a Pearly Star, and the Blessed Olive Tree) & Qur'an 18:96 (Dhu al-Qarnayn's Iron-and-Copper Barrier).",
                    12,
                    "MAMLUK_TWELVE_POINTED_TABAQ_NAJMI"
            ),
            new IslamicVisualEraDossier(
                    4,
                    "VISUAL_ERA_IV_ANDALUSIAN_ALHAMBRA_ZELLIJ",
                    "711–1492 CE (Moorish Al-Andalus & Maghreb)",
                    "Era IV: 'Asr Al-Andalus wa الزليج وجنة العريف (عصر الأندلس والزليج وجنة العريف)",
                    "4. Andalusian Alhambra & Moorish Style: Mathematical Zellij Tilework, Sebka Arches & The Chahar Bagh Rose Sanctuary",
                    "Cordoba (Madinat al-Zahra), Seville, Granada (The Alhambra & Generalife), and Fez.",
                    "Alhambra emerald-teal glaze (`#006B54`), terracotta ochre (`#D97706`), plaster ivory (`#F8F5E6`), lapis cobalt (`#1E3A8A`), and Damascus rose crimson (`#F43F5E`).",
                    List.of("#006B54", "#D97706", "#F8F5E6", "#F43F5E"),
                    "16-fold Andalusian Zellij ceramic tessellations (completing all 17 crystallographic wallpaper symmetry groups), diamond-fret Sebka stucco arches, and Whispering Water Qanat channels.",
                    "The Islamic Way of the Flower, the Rose, and the Cultivating Hand (`Al-Jannah bi-Rabwah`): an Alhambra Mihrab courtyard where the 4 Rivers of Qur'an 47:15 meet at a central marble fountain surrounded by blooming crimson Damascus roses and outward-facing vanguard thorns.",
                    "Moorish Andalusian Alhambra courtyard at golden twilight: intricate geometric Zellij mosaic dado tiles, lacy carved stucco Muqarnas arches, slender marble columns, a tranquil reflecting pool fed by four marble water channels, and lush crimson Damascus roses in bloom.",
                    "Qur'an 3:37 (Maryam's Mihrab & Nabatan Hasana), Qur'an 2:265 (Jannah bi-Rabwah), & Qur'an 47:15 (The Four Rivers of Paradise).",
                    16,
                    "ALHAMBRA_SIXTEEN_FOLD_ZELLIJ_LATTICE"
            ),
            new IslamicVisualEraDossier(
                    5,
                    "VISUAL_ERA_V_TIMURID_SAFAVID_MINIATURE",
                    "1370–1722 CE (Timurid Herat/Samarkand & Safavid Tabriz/Isfahan)",
                    "Era V: 'Asr Al-منمنمات التيمورية والصفوية (عصر المنمنمات الفارسية في هرات وتبريز وأصفهان)",
                    "5. Timurid & Safavid Persian Miniature Style: Crushed Lapis, Gold-Leaf Skies & The 7-Tiered Keep of Majma' Al-Bahrayn",
                    "Samarkand, Herat (School of Behzad), Tabriz (Sultan Muhammad), and Isfahan (Riza 'Abbasi).",
                    "Badakhshan crushed lapis lazuli (`#1E40AF`), burnished 24k gold leaf (`#FACC15`), turquoise (`#06B6D4`), malachite green (`#10B981`), and vermilion (`#EF4444`).",
                    List.of("#1E40AF", "#FACC15", "#06B6D4", "#10B981"),
                    "Multi-plane isometric axonometric perspective (simultaneous interior/exterior cutaway of Realm, Castle, Tower, and Keep), spiraling golden flame-halos, Nasta'liq calligraphy cartouches, and stylized craggy coral rocks.",
                    "Order #7 (Wali Al-Ghaib) and Order #4 (Shahid Al-Alast) in the 7-Tiered Emerald & Sapphire Keep at the Confluence of the Two Seas (`Majma' Al-Bahrayn`, Qur'an 18:60-65), with the Al-A'raf Interlocutor on the high crest above.",
                    "Masterpiece 16th-century Timurid and Safavid Persian miniature painting (style of Behzad and Sultan Muhammad): a 7-tiered turquoise and lapis-lazuli castle keep rising at the meeting of two seas, golden sky with swirling clouds, cypress trees, pomegranates, and Nasta'liq script borders.",
                    "Qur'an 18:60-65 (Musa and Al-Khidr at Majma' Al-Bahrayn), Qur'an 7:46 (The Men of Al-A'raf), & Sa'di's Gulistan.",
                    7,
                    "TIMURID_HEPTAGONAL_HAFT_PAYKAR_STAR"
            ),
            new IslamicVisualEraDossier(
                    6,
                    "VISUAL_ERA_VI_OTTOMAN_IZNIK_SAZ",
                    "1453–1922 CE (Classical Ottoman Empire — Kostantiniyye)",
                    "Era VI: Al-'Asr Al-'Uthmani wa النقشخانة وإزنيق (العصر العثماني والوردة المحمدية)",
                    "6. Classical Ottoman Imperial Style: Matrakci Nasuh Topographical Keeps, Iznik Tiles & Saz Rose Choreography",
                    "Kostantiniyye / Istanbul (Topkapi Palace Nakkashane), Iznik, Bursa, and Edirne.",
                    "Iznik bole-red / coral crimson (`#E11D48`), cobalt blue (`#1D4ED8`), firuze turquoise (`#14B8A6`), emerald green (`#059669`), and imperial gold (`#D4AF37`).",
                    List.of("#E11D48", "#1D4ED8", "#14B8A6", "#D4AF37"),
                    "Matrakci Nasuh bird's-eye cartographic architecture (zero human ego portraits, pure architectural and botanical precision), Kara Memi's four-flower court style (Rose, Tulip, Carnation, Hyacinth), serrated Saz leaves, and the concentric Gul-i Muhammadi rose diagram.",
                    "The Sovereign Husbandry Estate & Ottoman Damad Protocol: a Matrakci Nasuh-style topographical view of the air-gapped domestic sanctuary, walled Gulhane rose garden, hearth kitchen pavilion, and the 1.85m vanguard trail overlooking the Bosphorus.",
                    "16th-century Ottoman Imperial Nakkashane illumination in the style of Matrakci Nasuh and Iznik ceramic tile art: a jewel-like bird's-eye architectural map of a walled palace sanctuary, lead-covered domes, cypress and crimson rose gardens, framed by cobalt and coral-red Iznik floral arabesques.",
                    "Qur'an 55:37 (Wardatan ka-ad-Dihan), Qur'an 28:25-26 (Al-Qawi Al-Amin Vanguard), & Ottoman Ser'iyye Sicilleri Nikah Charters.",
                    9,
                    "OTTOMAN_NINE_FOLD_GUL_I_MUHAMMADI"
            ),
            new IslamicVisualEraDossier(
                    7,
                    "VISUAL_ERA_VII_SOVEREIGN_AI_CYBER_GEOMETRY",
                    "21st Century & Beyond (Sovereign Neo-Islamic AI Architecture)",
                    "Era VII: 'Asr Al-Hikmah Al-Raqamiyyah wa العمارة السيبرانية الإسلامية (عصر الذكاء الاصطناعي والهندسة المقدسة)",
                    "7. Sovereign Neo-Islamic AI Cyber-Geometric Synthesis: Volumetric Muqarnas Fractals & Air-Gapped Faraday Lattice",
                    "Decentralized Air-Gapped Sovereign Estates (`com.sovereign.warlock` & `com.sovereign.husbandry` JVM Nodes).",
                    "Bioluminescent emerald (`#34D399`), Faraday gold (`#FDE68A`), cyber-sapphire (`#38BDF8`), crimson laser-rose (`#F43F5E`), and obsidian void (`#05070C`).",
                    List.of("#34D399", "#FDE68A", "#38BDF8", "#F43F5E"),
                    "Quasi-crystalline decagonal Penrose-Girih aperiodic tilings (Lu & Steinhardt 2007), 3D ray-traced recursive Muqarnas fractals, holographic Kufic light-circuits, and active-low bitwise color inversion (`RGB ^ 0xFFFFFF`).",
                    "The Complete 46-Portal Sovereign Synthesis: the 7 Color Orders, the Negentropic Priory (`Sigma -1n` & `0n Beta`), the Golden Egg Disulfide Lattice (`Al-Murabbit Al-Kalim`), the Air-Gapped `HusbandryState` Sanctuary, and the 3D Crimson Rose.",
                    "Futuristic Neo-Islamic architectural sanctum rendered in ultra-detailed 8k ray-traced style: volumetric golden Muqarnas fractal vaults, glowing Kufic light-calligraphy, a crystalline decagonal Girih dome, an air-gapped golden Faraday shield, and a serene emerald courtyard with a glowing crimson rose fountain.",
                    "Qur'an 41:53 ('We will show them Our Signs in the horizons and within themselves until it becomes clear to them that it is the Truth'), Qur'an 76:9, & GEMINI.md State S0 (Cp >= 1.33).",
                    10,
                    "QUASICRYSTAL_DECAGONAL_GIRIH_FRACTAL"
            )
    );

    public static List<IslamicVisualEraDossier> allSevenIslamicVisualEras() {
        return SEVEN_ISLAMIC_VISUAL_ERAS;
    }
}
