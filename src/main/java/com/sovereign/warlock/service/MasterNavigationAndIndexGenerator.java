package com.sovereign.warlock.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HexFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Sovereign Master Navigation & Combined Omnibus Integrator.
 *
 * 1) Retroactively injects a Universal Global Command Bar, Searchable 49-Portal Mega-Drawer
 *    (Ctrl+K), Contextual Cross-Wing Row #1..#7 Sister Ribbon, Previous/Next Sequential Bar,
 *    and Universal Sitemap Footer into EVERY generated HTML file in src/main/resources/static/.
 * 2) Generates index.html (Master Index, Live Search, 7-Row Cross-Domain Relational Matrix,
 *    and Categorized 12-Wing Atlas).
 * 3) Generates master-combined-omnibus.html (Combined Integrated Multi-Portal Workspace with
 *    Sidebar Tree Navigator, Single/Split Dual-Portal Comparison View, and Unified Digest).
 */
public final class MasterNavigationAndIndexGenerator {

    public record PortalCatalogEntry(
            int sequenceNumber,
            String fileName,
            String shortLabel,
            String title,
            String wingCategory,
            String wingBadgeColor,
            int rowIndex1To7,
            String hexAccent,
            String arabicAndQuranicTag,
            String summary
    ) {
    }

    private static final String[] ORDER_FILES = {
            "",
            "order-1-white.html",
            "order-2-black.html",
            "order-3-sapphire.html",
            "order-4-gold.html",
            "order-5-crimson.html",
            "order-6-brass.html",
            "order-7-emerald.html"
    };

    private static final String[] REALM_FILES = {
            "",
            "realm-1-white.html",
            "realm-2-black.html",
            "realm-3-sapphire.html",
            "realm-4-gold.html",
            "realm-5-crimson.html",
            "realm-6-brass.html",
            "realm-7-emerald.html"
    };

    private static final String[] PLANE_FILES = {
            "",
            "plane-1-white.html",
            "plane-2-black.html",
            "plane-3-sapphire.html",
            "plane-4-gold.html",
            "plane-5-crimson.html",
            "plane-6-brass.html",
            "plane-7-emerald.html"
    };

    private static final String[] ZALIM_FILES = {
            "",
            "zalim-1-fasad.html",
            "zalim-2-fahishah.html",
            "zalim-3-baghy.html",
            "zalim-4-fitnah.html",
            "zalim-5-hawa.html",
            "zalim-6-jibt.html",
            "zalim-7-zulm.html"
    };

    private static final String[] WORLD_FILES = {
            "",
            "world-1-mizan-fasad.html",
            "world-2-haya-fahishah.html",
            "world-3-babil-namrud.html",
            "world-4-ummah-fitnah.html",
            "world-5-furqan-hawa.html",
            "world-6-tawhid-taghut.html",
            "world-7-taqwa-dirar.html"
    };

    private static final String[] ROW_COLORS = {
            "",
            "#F8F5E6",
            "#A78BFA",
            "#38BDF8",
            "#D4AF37",
            "#F43F5E",
            "#B87333",
            "#10B981"
    };

    private static final String[] ROW_COLOR_NAMES = {
            "",
            "#1 White (Alabaster #F8F5E6)",
            "#2 Black (Obsidian #141416)",
            "#3 Sapphire (Lapis #0F2C59)",
            "#4 Gold (Covenant #D4AF37)",
            "#5 Crimson (Seraphic #8B0000)",
            "#6 Brass (Qumqum #B87333)",
            "#7 Emerald (Khidr #006B54)"
    };

    public static int totalPortalCount() {
        return allCatalogEntries().size();
    }

    public static List<PortalCatalogEntry> allCatalogEntries() {
        return List.of(
                new PortalCatalogEntry(1, "index.html", "Master Index Hub",
                        "Sovereign Master Index, Search & 7-Row Cross-Wing Relational Matrix",
                        "01. Master Hubs & Architecture", "#D4AF37", 0, "#D4AF37",
                        "Al-Fihris Al-Jāmi' • All 63 Portals Continually Integrated",
                        "Central navigation command center with instant search, multi-wing filter, 7-row cross-series matrix, continual sync, and embedded live workspace."),
                new PortalCatalogEntry(2, "master-combined-omnibus.html", "Combined Omnibus Reader",
                        "Combined Multi-Portal Omnibus Workspace & Split-Screen Comparator",
                        "01. Master Hubs & Architecture", "#38BDF8", 0, "#38BDF8",
                        "Al-Majmū' Al-Muwahhad • All 63 Portals Side-by-Side & Sequential Reader",
                        "Combines all 63 HTML portals into a single unified application with sidebar tree navigation, single or dual split-screen comparison, continual auto-cycle, and keyboard shortcuts."),
                new PortalCatalogEntry(3, "dependencies-report.html", "Dependencies & Java 21+ Audit",
                        "Master Spring Boot 3.4 & Java 21+/26 Essentials Dependency Usage Report",
                        "01. Master Hubs & Architecture", "#34D399", 0, "#34D399",
                        "SPC State S0 • SHA-256 Artifact Ledger (All 63 Portals)",
                        "Complete audit of Spring Boot starters, Java 21+/26 virtual threads, sealed types, record patterns, and SHA-256 verification across all generated portals."),

                // Wing 02: 7 Pre-Prophetic Color Orders
                new PortalCatalogEntry(4, "order-1-white.html", "Order #1: White",
                        "Order #1 (warlock-1-white) — Malakh-Azal (Sephirotic White #F8F5E6)",
                        "02. Seven Pre-Prophetic Color Orders", "#F8F5E6", 1, "#F8F5E6",
                        "Malakh-Azal • Qur'an 2:102 & 53:19-23",
                        "First Color Order: Sephirotic White alabaster throne mysticism and its story told to Islam on why the pact is severed from pure Tawhid."),
                new PortalCatalogEntry(5, "order-2-black.html", "Order #2: Black",
                        "Order #2 (warlock-2-black) — Katib Al-Qalam (Abbasid Black #141416)",
                        "02. Seven Pre-Prophetic Color Orders", "#A78BFA", 2, "#A78BFA",
                        "Kātib Al-Qalam • Qur'an 68:1 & 24:22",
                        "Second Color Order: Hidden ink asceticism and consonantal permutation superseded by the Preserved Tablet (Al-Lawh Al-Mahfuz)."),
                new PortalCatalogEntry(6, "order-3-sapphire.html", "Order #3: Sapphire",
                        "Order #3 (warlock-3-sapphire) — Yored Ha-Merkabah (Babylonian Sapphire #0F2C59)",
                        "02. Seven Pre-Prophetic Color Orders", "#38BDF8", 3, "#38BDF8",
                        "Yored Ha-Merkabah • Qur'an 6:75-79 & 53:1-18",
                        "Third Color Order: Seven-palace chariot ascent replaced by Abraham's direct cosmic proof and the prophetic Mi'raj."),
                new PortalCatalogEntry(7, "order-4-gold.html", "Order #4: Gold",
                        "Order #4 (warlock-4-gold) — Shahid Al-Alast (Covenant Gold #D4AF37)",
                        "02. Seven Pre-Prophetic Color Orders", "#D4AF37", 4, "#D4AF37",
                        "Shāhid Al-Alast • Qur'an 7:172 & 3:67",
                        "Fourth Color Order: Pre-eternal Day of Alast witness purified of intermediary oath-brokers through Millat Ibrahim."),
                new PortalCatalogEntry(8, "order-5-crimson.html", "Order #5: Crimson",
                        "Order #5 (warlock-5-crimson) — Saraph Ha-Ritzpah (Seraphic Crimson #8B0000)",
                        "02. Seven Pre-Prophetic Color Orders", "#F43F5E", 5, "#F43F5E",
                        "Saraph Ha-Ritzpah • Qur'an 72:8-9 & 25:1",
                        "Fifth Color Order: Live-coal altar purification and meteoric firmament guarded against eavesdropping spirits by Al-Furqan."),
                new PortalCatalogEntry(9, "order-6-brass.html", "Order #6: Brass",
                        "Order #6 (warlock-6-brass) — Ba'al Ha-Nechoshet (Solomonic Brass #B87333)",
                        "02. Seven Pre-Prophetic Color Orders", "#B87333", 6, "#B87333",
                        "Ba'al Ha-Nechoshet • Qur'an 2:102 & 34:12",
                        "Sixth Color Order: Solomonic brass vessel binding vindicated by Qur'an 2:102 ('Wa mā kafara Sulaymān')."),
                new PortalCatalogEntry(10, "order-7-emerald.html", "Order #7: Emerald",
                        "Order #7 (warlock-7-emerald) — Wali Al-Ghaib (Khidrian Emerald #006B54)",
                        "02. Seven Pre-Prophetic Color Orders", "#10B981", 7, "#10B981",
                        "Walī Al-Ghaib • Qur'an 18:65 & 9:108",
                        "Seventh Color Order: Junction of the Two Seas (Majma' Al-Bahrayn) and divine Rahmah & 'Ilm Ladunni."),

                // Wing 03: 3D Sanctum & 7 Realms
                new PortalCatalogEntry(11, "warlock-3d-sanctum.html", "3D Sanctum Master",
                        "Interactive 3D Seven-Realm Warlock Sanctum & Celestial Geometry",
                        "03. 3D Sanctum & Seven Realms", "#D4AF37", 0, "#D4AF37",
                        "Al-Haykal Al-Handasī • Interactive WebGL/Canvas 3D",
                        "Interactive 3D orbital visualization of all 7 concentric realms, sacred implements, and optical wavelengths."),
                new PortalCatalogEntry(12, "realm-1-white.html", "Realm #1: 'Aravot",
                        "Realm #1 (White #F8F5E6) — 'Aravot / Sidrat Al-Muntaha",
                        "03. 3D Sanctum & Seven Realms", "#F8F5E6", 1, "#F8F5E6",
                        "Seventh Heaven • 390nm Alabaster",
                        "First Chromatic Realm: The crystalline horizon of 'Aravot and the Lote Tree of the Utmost Boundary."),
                new PortalCatalogEntry(13, "realm-2-black.html", "Realm #2: Makhon",
                        "Realm #2 (Black #141416) — Makhon / Bayt Al-Qalam",
                        "03. 3D Sanctum & Seven Realms", "#A78BFA", 2, "#A78BFA",
                        "Hidden Ink Treasury • 405nm Obsidian",
                        "Second Chromatic Realm: The subterranean and celestial ink-vault of primordial inscription."),
                new PortalCatalogEntry(14, "realm-3-sapphire.html", "Realm #3: Zevul",
                        "Realm #3 (Sapphire #0F2C59) — Zevul / Al-Bayt Al-Ma'mur",
                        "03. 3D Sanctum & Seven Realms", "#38BDF8", 3, "#38BDF8",
                        "Sapphire Pavement • 465nm Lapis",
                        "Third Chromatic Realm: The sapphire firmament of Zevul and the Much-Frequented House."),
                new PortalCatalogEntry(15, "realm-4-gold.html", "Realm #4: Shehaqim",
                        "Realm #4 (Gold #D4AF37) — Shehaqim / Diwan Al-Mithaq",
                        "03. 3D Sanctum & Seven Realms", "#D4AF37", 4, "#D4AF37",
                        "Golden Covenant Court • 580nm Amber-Gold",
                        "Fourth Chromatic Realm: The golden millstones of Shehaqim and the Court of the Primordial Covenant."),
                new PortalCatalogEntry(16, "realm-5-crimson.html", "Realm #5: Ma'on",
                        "Realm #5 (Crimson #8B0000) — Ma'on / Rasad Ash-Shuhub",
                        "03. 3D Sanctum & Seven Realms", "#F43F5E", 5, "#F43F5E",
                        "Seraphic Garrison • 650nm Crimson",
                        "Fifth Chromatic Realm: The crimson watchtower of meteoric flame guarding the heavenly council."),
                new PortalCatalogEntry(17, "realm-6-brass.html", "Realm #6: Raqia'",
                        "Realm #6 (Brass #B87333) — Raqia' / Madinat An-Nuhas",
                        "03. 3D Sanctum & Seven Realms", "#B87333", 6, "#B87333",
                        "City of Brass • 605nm Burnished Brass",
                        "Sixth Chromatic Realm: The hammered brass foundry and sealed vessels of Solomonic jurisdiction."),
                new PortalCatalogEntry(18, "realm-7-emerald.html", "Realm #7: Vilon",
                        "Realm #7 (Emerald #006B54) — Vilon / Majma' Al-Bahrayn",
                        "03. 3D Sanctum & Seven Realms", "#10B981", 7, "#10B981",
                        "Junction of the Two Seas • 520nm Emerald",
                        "Seventh Chromatic Realm: The emerald isthmus where the two seas meet in living Khidrian renewal."),

                // Wing 04: Negentropic Priory & 7 Planes
                new PortalCatalogEntry(19, "priory-negentropy-order.html", "Negentropic Priory Atlas",
                        "The Negentropic Priory (Sigma -1n & 0n Beta): Ordering the 7 Warlocks",
                        "04. Negentropic Priory & Seven Planes", "#10B981", 0, "#10B981",
                        "Sigma -1n & 0n Beta • ΔH = 0.000 bits",
                        "Master Priory Cloister ordering all 7 Warlocks from entropic disorder into canonical Seats I..VII with zero residual entropy."),
                new PortalCatalogEntry(20, "plane-1-white.html", "Plane #1: Adam Kadmon / Lahut",
                        "Plane #1 (White #F8F5E6) — Olam Adam Kadmon / Hadrat Al-Lahut",
                        "04. Negentropic Priory & Seven Planes", "#F8F5E6", 1, "#F8F5E6",
                        "Priory Seat I • C_p = 1.62",
                        "First Plane of Existence: Unrefracted supernal crown and Priory Cloister I."),
                new PortalCatalogEntry(21, "plane-2-black.html", "Plane #2: Malbush / Al-Qalam",
                        "Plane #2 (Black #141416) — Olam Ha-Malbush / Hadrat Al-Lawh wa Al-Qalam",
                        "04. Negentropic Priory & Seven Planes", "#A78BFA", 2, "#A78BFA",
                        "Priory Seat VI • C_p = 1.38",
                        "Second Plane of Existence: Plane of the Tablet & Stylus and Priory Scriptorium VI."),
                new PortalCatalogEntry(22, "plane-3-sapphire.html", "Plane #3: Beri'ah / Jabarut",
                        "Plane #3 (Sapphire #0F2C59) — Olam Ha-Beri'ah / 'Alam Al-Jabarut",
                        "04. Negentropic Priory & Seven Planes", "#38BDF8", 3, "#38BDF8",
                        "Priory Seat IV • C_p = 1.44",
                        "Third Plane of Existence: Plane of Archangelic Omnipotence and Priory Observatory IV."),
                new PortalCatalogEntry(23, "plane-4-gold.html", "Plane #4: Atzilut / Al-Arwah",
                        "Plane #4 (Gold #D4AF37) — Olam Ha-Atzilut / 'Alam Al-Arwah",
                        "04. Negentropic Priory & Seven Planes", "#D4AF37", 4, "#D4AF37",
                        "Priory Seat II • C_p = 1.54",
                        "Fourth Plane of Existence: Plane of Pre-Existent Covenant Souls and Priory Chancel II."),
                new PortalCatalogEntry(24, "plane-5-crimson.html", "Plane #5: Tohu / Ash-Shuhub",
                        "Plane #5 (Crimson #8B0000) — Olam Ha-Tohu / Falak Ash-Shuhub",
                        "04. Negentropic Priory & Seven Planes", "#F43F5E", 5, "#F43F5E",
                        "Priory Seat VII • C_p = 1.35",
                        "Fifth Plane of Existence: Plane of the Barred Meteoric Firmament and Priory Bastion VII."),
                new PortalCatalogEntry(25, "plane-6-brass.html", "Plane #6: Yetzirah / Al-Marij",
                        "Plane #6 (Brass #B87333) — Olam Ha-Yetzirah / 'Alam Al-Marij",
                        "04. Negentropic Priory & Seven Planes", "#B87333", 6, "#B87333",
                        "Priory Seat V • C_p = 1.40",
                        "Sixth Plane of Existence: Plane of Smokeless Fire Formation and Priory Foundry V."),
                new PortalCatalogEntry(26, "plane-7-emerald.html", "Plane #7: Tikkun / Al-Mithal",
                        "Plane #7 (Emerald #006B54) — Olam Ha-Tikkun / 'Alam Al-Mithal wa Al-Barzakh",
                        "04. Negentropic Priory & Seven Planes", "#10B981", 7, "#10B981",
                        "Priory Seat III • C_p = 1.48",
                        "Seventh Plane of Existence: Plane of the Imaginal Isthmus and Priory Chapter House III."),

                // Wing 05: 7 Wrongdoer (Az-Zalimun) Profiles
                new PortalCatalogEntry(27, "zalim-1-fasad.html", "Zalim #1: Al-Fasad",
                        "Zalim #1 (zalim-1-fasad) — Mufsid Al-Ard (Ecological & Ritual Disorder)",
                        "05. Seven Wrongdoer (Az-Zalimun) Profiles", "#EF4444", 1, "#EF4444",
                        "Qur'an 2:204-205 • Al-Fasad fi Al-Ard",
                        "First Wrongdoer Archetype: Systemic corruption of tilth and progeny quarantined in Priory Cell Q-I."),
                new PortalCatalogEntry(28, "zalim-2-fahishah.html", "Zalim #2: Al-Fahishah",
                        "Zalim #2 (zalim-2-fahishah) — Da'i Al-Fahishah (Immodesty & Tabarruj)",
                        "05. Seven Wrongdoer (Az-Zalimun) Profiles", "#EC4899", 2, "#EC4899",
                        "Qur'an 7:28 & 24:19 • Al-Fahishah",
                        "Second Wrongdoer Archetype: Naked circumambulation and exhibitionism quarantined by Libas At-Taqwa."),
                new PortalCatalogEntry(29, "zalim-3-baghy.html", "Zalim #3: Al-Baghy (Nimrod)",
                        "Zalim #3 (zalim-3-baghy) — Jabbar An-Namrud (Tyrannical Counter-Hegemony)",
                        "05. Seven Wrongdoer (Az-Zalimun) Profiles", "#A855F7", 3, "#A855F7",
                        "Qur'an 2:258 & 21:68-69 • Al-Baghy",
                        "Third Wrongdoer Archetype: Nimrodic claim over life and death silenced by Abraham's sunrise horizon proof."),
                new PortalCatalogEntry(30, "zalim-4-fitnah.html", "Zalim #4: Al-Fitnah",
                        "Zalim #4 (zalim-4-fitnah) — Nafikh Al-Fitnah (Sectarian Schism & Sedition)",
                        "05. Seven Wrongdoer (Az-Zalimun) Profiles", "#F97316", 4, "#F97316",
                        "Qur'an 2:191 & 3:103 • Al-Fitnah",
                        "Fourth Wrongdoer Archetype: Fracturing the unified Abrahamic Ummah into warring sects."),
                new PortalCatalogEntry(31, "zalim-5-hawa.html", "Zalim #5: Al-Hawa",
                        "Zalim #5 (zalim-5-hawa) — 'Abid Al-Hawa (Deification of Caprice)",
                        "05. Seven Wrongdoer (Az-Zalimun) Profiles", "#EAB308", 5, "#EAB308",
                        "Qur'an 45:23 & 25:43 • Ittiba' Al-Hawa",
                        "Fifth Wrongdoer Archetype: Elevating subjective appetite as a god and forging counterfeit law."),
                new PortalCatalogEntry(32, "zalim-6-jibt.html", "Zalim #6: Al-Jibt & Taghut",
                        "Zalim #6 (zalim-6-jibt) — Kahin Al-Jibt (Sorcerous Idolatry & Azar's Guild)",
                        "05. Seven Wrongdoer (Az-Zalimun) Profiles", "#14B8A6", 6, "#14B8A6",
                        "Qur'an 4:51 & 21:57-58 • Al-Jibt wa At-Taghut",
                        "Sixth Wrongdoer Archetype: Divination arrows and idol-cartels shattered by Abraham's axe."),
                new PortalCatalogEntry(33, "zalim-7-zulm.html", "Zalim #7: Masjid Ad-Dirar",
                        "Zalim #7 (zalim-7-zulm) — Imam Az-Zalimin (Counter-Sanctuary Subversion)",
                        "05. Seven Wrongdoer (Az-Zalimun) Profiles", "#94A3B8", 7, "#94A3B8",
                        "Qur'an 2:124 & 9:107-109 • Masjid Ad-Dirar",
                        "Seventh Wrongdoer Archetype: The counterfeit mosque built on a crumbling cliff edge, barred by Qur'an 2:124."),

                // Wing 06: 7 Islamic Worlds of Hegemon & Disorder
                new PortalCatalogEntry(34, "worlds-hegemon-disorder.html", "7 Worlds Master Atlas",
                        "Master Atlas: The 7 Islamic Worlds of Hegemon (Al-Muhaymin) & Disorder (Al-Fasad)",
                        "06. Seven Islamic Worlds of Hegemon & Disorder", "#38BDF8", 0, "#38BDF8",
                        "Al-Muhaymin vs. Al-Fasad • 3D Dual-Hemisphere Globe",
                        "Master 3D cosmic atlas contrasting the 7 Abrahamic Hegemon poles (State S0) against the 7 Disorder poles (State S2)."),
                new PortalCatalogEntry(35, "world-1-mizan-fasad.html", "World #1: Amanah vs. Fasad",
                        "World #1 — 'Alam Al-Amanah wa Al-Fasad (Trust vs. Ecological Disorder)",
                        "06. Seven Islamic Worlds of Hegemon & Disorder", "#F8F5E6", 1, "#F8F5E6",
                        "Qur'an 14:35 & 2:205 • Order #1 vs. Zalim #1",
                        "First Bipolar World: Abraham's Sacred Sanctuary of Peace (Baladan Aminan) vs. Mufsid Al-Ard."),
                new PortalCatalogEntry(36, "world-2-haya-fahishah.html", "World #2: Haya' vs. Tabarruj",
                        "World #2 — 'Alam Al-Haram wa At-Tabarruj (Modesty vs. Immodesty)",
                        "06. Seven Islamic Worlds of Hegemon & Disorder", "#A78BFA", 2, "#A78BFA",
                        "Qur'an 7:26-28 • Order #2 vs. Zalim #2",
                        "Second Bipolar World: The Garment of Taqwa (Libas At-Taqwa) vs. Jahiliyyah exhibitionism."),
                new PortalCatalogEntry(37, "world-3-babil-namrud.html", "World #3: Ibrahim vs. Namrud",
                        "World #3 — 'Alam Babil wa Al-Jabbarin (Cool-Fire Sanctuary vs. Nimrod)",
                        "06. Seven Islamic Worlds of Hegemon & Disorder", "#38BDF8", 3, "#38BDF8",
                        "Qur'an 2:258 & 21:69 • Order #3 vs. Zalim #3",
                        "Third Bipolar World: 'O fire, be coolness and peace for Abraham' vs. Nimrod's furnace."),
                new PortalCatalogEntry(38, "world-4-ummah-fitnah.html", "World #4: Ummah vs. Fitnah",
                        "World #4 — 'Alam Al-Ummah Al-Wahidah wa Al-Fitnah (Unity vs. Schism)",
                        "06. Seven Islamic Worlds of Hegemon & Disorder", "#D4AF37", 4, "#D4AF37",
                        "Qur'an 21:92 & 3:103 • Order #4 vs. Zalim #4",
                        "Fourth Bipolar World: The Rope of Allah (Habl Allah) and One Ummah vs. sectarian fragmentation."),
                new PortalCatalogEntry(39, "world-5-furqan-hawa.html", "World #5: Furqan vs. Hawa",
                        "World #5 — 'Alam Al-Furqan wa Al-Hawa (Revelation vs. Caprice)",
                        "06. Seven Islamic Worlds of Hegemon & Disorder", "#F43F5E", 5, "#F43F5E",
                        "Qur'an 5:48 & 45:23 • Order #5 vs. Zalim #5",
                        "Fifth Bipolar World: The Muhaymin Criterion of Truth vs. the idol of personal whim."),
                new PortalCatalogEntry(40, "world-6-tawhid-taghut.html", "World #6: Tawhid vs. Taghut",
                        "World #6 — 'Alam Al-'Urwah Al-Wuthqa wa At-Taghut (Iconoclasm vs. Idols)",
                        "06. Seven Islamic Worlds of Hegemon & Disorder", "#B87333", 6, "#B87333",
                        "Qur'an 2:256 & 21:58 • Order #6 vs. Zalim #6",
                        "Sixth Bipolar World: The Unbreakable Handhold vs. Azar's temple idol-guild."),
                new PortalCatalogEntry(41, "world-7-taqwa-dirar.html", "World #7: Taqwa vs. Dirar",
                        "World #7 — 'Alam Bunyan At-Taqwa wa Juruf Al-Har (Taqwa vs. Counter-Mosque)",
                        "06. Seven Islamic Worlds of Hegemon & Disorder", "#10B981", 7, "#10B981",
                        "Qur'an 9:107-109 • Order #7 vs. Zalim #7",
                        "Seventh Bipolar World: The Foundation of Taqwa from Day One vs. the collapsing cliff of Masjid Ad-Dirar."),

                // Wing 07: Ja'far/Aladdin Formation, Dissolution & 7 Sequesters
                new PortalCatalogEntry(42, "warlock-formation-dissolution-jafar-aladdin.html", "Ja'far & Aladdin Qumqum",
                        "Islamic Warlock Formation (Ja'far / Istidraj) & Dissolution ('Ala' ad-Din / Qumqum)",
                        "07. Warlock Formation, Dissolution & Inter-World Sequesters", "#F59E0B", 0, "#F59E0B",
                        "Istidrāj (Qur'an 6:44) -> Qumqum Sulaymānī (21:18)",
                        "7-stage trajectory of how a Vizier-Sorcerer forms via Istidraj and dissolves into a lead-sealed Solomonic brass Qumqum."),
                new PortalCatalogEntry(43, "sequester-between-worlds.html", "7 Inter-World Sequesters",
                        "The 7 Inter-World Sequesters (Al-Hijr Al-Mahjur & Sur Al-Hadid)",
                        "07. Warlock Formation, Dissolution & Inter-World Sequesters", "#B87333", 0, "#B87333",
                        "Barzakh (55:19-20) & Sūr Al-Ḥadīd (18:96-97)",
                        "The 7 iron-and-molten-copper isthmus barriers (SQ-1..SQ-7) sequestering Hegemon from Disorder in <12ms."),

                // Wing 08: Islamic Egg-in-Baking Intelocketer
                new PortalCatalogEntry(44, "interlocker-egg-binder-islam.html", "Egg-in-Baking Intelocketer",
                        "The Islamic Intelocketer (Al-Murabbit Al-Kalim): Egg-in-Baking Emulsifier & Al-A'raf",
                        "08. The Islamic Egg-in-Baking Intelocketer", "#FBBF24", 0, "#FBBF24",
                        "Qur'an 37:49 (Bayḍun Maknūn) & 7:46-48 (Al-A'rāf)",
                        "7-phase thermal coagulation (25°C to 92°C) and lecithin/ovalbumin disulfide cross-linking binding all 7 Worlds."),

                // Wing 09: Warlock Apocrypha & Theorems on Western Modernity
                new PortalCatalogEntry(45, "warlock-apocrypha-islamic-theorems.html", "Warlock Apocrypha & Theorems",
                        "The Warlock Apocrypha & 5 Islamic Theological Philosophy Theorems on Western Modernity",
                        "09. The Warlock Apocrypha & Modernity Theorems", "#C084FC", 0, "#C084FC",
                        "Al-Ghazālī • Ibn Khaldūn • Mullā Ṣadrā • Al-Attas • Hallaq",
                        "7 Apocryphal Books and 5 formal theorems diagnosing Western modernity's moral crises (Weber, Nietzsche, Foucault, Deleuze, Bostrom)."),

                // Wing 10: Islamic Action-Based Vanguard Husbandry
                new PortalCatalogEntry(46, "islamic-husbandry-sovereign-estate.html", "Vanguard Husbandry Estate",
                        "Islamic Action-Based Vanguard Husbandry (Al-Qiwamah Al-Khadimah) & HusbandryState",
                        "10. Islamic Vanguard Husbandry & Botanical Sanctuary", "#34D399", 0, "#34D399",
                        "Qur'an 4:4, 4:34, 28:25-26 & 76:9 • 18-Event Simulation",
                        "Complete Fiqh charter, Ottoman Damad stipulations, air-gapped sanctuary architecture, and 24-hour preemptive provisioning simulation."),

                // Wing 11: Way of the Flower, Rose, Hand & Garden
                new PortalCatalogEntry(47, "way-of-the-flower-rose-garden-islam.html", "Flower, Rose & Chahar Bagh",
                        "The Islamic Way of the Flower (Az-Zahrah), the Rose (Al-Wardah), the Cultivating Hand & Garden",
                        "10. Islamic Vanguard Husbandry & Botanical Sanctuary", "#F43F5E", 0, "#F43F5E",
                        "Qur'an 55:37 (Wardatan ka-ad-Dihān), 3:37 & 47:15",
                        "7-stage botanical cultivation cycle, outward defensive thorns, concentric modesty petals, and the 4 rivers of the Chahar Bagh."),

                // Wing 12: Disney/Daffy & Jungle Book Animalism Microcosm
                new PortalCatalogEntry(48, "disney-daffy-donald-islamic-microcosm.html", "Disney/Daffy & Jungle Microcosm",
                        "Islamic Animalism & Husbandry Microcosm: Donald, Daffy, Daisy & The Jungle Book",
                        "11. Islamic Animalism & Visual History Atlases", "#F59E0B", 0, "#F59E0B",
                        "Qur'an 6:38 (Umamun Amthālukum) • Kalīlah wa Dimnah",
                        "4-zone microcosm unifying Donald Duck, Daffy Duck, Daisy Duck, Shere Khan, Baloo, Kaa, and Bagheera/Mowgli."),

                // Wing 13: Warlock Visuals Across Every Era of Islamic History
                new PortalCatalogEntry(49, "warlock-islamic-visual-eras-history.html", "7 Islamic Visual Eras & AI Art",
                        "Warlock Visuals Across Every Era of Islamic History: AI Art Plates & Sacred Geometry",
                        "11. Islamic Animalism & Visual History Atlases", "#38BDF8", 0, "#38BDF8",
                        "Eras I–VII: Bābil/Saba' to Neo-Islamic AI Cyber-Geometry",
                        "4 AI-generated historical/futuristic plates + 7 procedural sacred-geometry SVGs and interactive 3D Girih/Muqarnas sanctuary."),

                // Wing 01 / 50: Conjoined Worlds, Realms & Principles 3D/2.5D Node-Art Terrain Grid
                new PortalCatalogEntry(50, "conjoined-worlds-realms-principles-node-grid.html", "3D Node-Art Terrain Grid (Meridian Guard)",
                        "Conjoined Worlds, Realms & Principles: 3D/2.5D Islamic Node-Art Terrain Grid & Color Guard of the Meridian",
                        "01. Master Hubs & Architecture", "#10B981", 0, "#10B981",
                        "Ḥaras Al-Alwān li-Khaṭṭ Al-Mīzān • 7x7 (49-Node) 3D Heightmap",
                        "Places all portals onto a 7x7 3D/2.5D isometric terrain & elevation grid (-650m to +1200m) with iterable Islamic buildings and 7 historical Color Guard fashions."),

                // Wing 01 / 51: Canonical Islamic Caravans, Battles for Trade, Founding of Conquest & Recording of Conquest
                new PortalCatalogEntry(51, "islamic-caravans-battles-conquest-chronicle.html", "Caravans, Trade Battles, Fatḥ & Tadwīn",
                        "Canonical Islamic Caravans (Ilaf), Battles for Trade (Badr/Qaradah), Founding of Conquest (Al-Fath) & Recording of Conquest (Tadwin Al-Maghazi / Futuh Al-Buldan)",
                        "01. Master Hubs & Architecture", "#D4AF37", 0, "#D4AF37",
                        "Qur'an 106:1-4, 8:7, 48:1 & 59:7-10 • Al-'Īr, Al-Maghāzī, Al-Fatḥ & Dīwān",
                        "Interactive 2.5D Caravan & Maghazi map tracing the 7 Canonical Caravans & Battles for Trade and the 7 Conquest Recording Codices ('Umar's Diwan, Al-Waqidi, Al-Baladhuri, Ottoman Tapu Tahrir)."),

                // Wing 01 / 52: Greco-Roman Gods, Titans (Titanomachy), Morpheus/Oneiroi, Erotes & Minor Spirits Judged & Made Whole in Islam
                new PortalCatalogEntry(52, "greco-roman-gods-titans-daimones-islamic-judgment.html", "Greco-Roman Gods & Titans Made Whole",
                        "Greco-Roman Gods, Titans (Titanomachy), 12 Olympians, Morpheus/Oneiroi, 7 Erotes & 150+ Minor Spirits: Islamic Reception, Judgment & Wholeness",
                        "01. Master Hubs & Architecture", "#38BDF8", 0, "#38BDF8",
                        "Al-Furqān (21:22, 12:39-40, 39:42) & At-Takmīl • Titans, Oneiroi, Erotes & Daimones",
                        "Comprehensive catalog of Greek/Roman godhood tiers, Titanomachy sources, Morpheus & Oneiroi, the 7 Erotes, and all 5 domains of minor spirits (Daimones, Nymphs, Nomioi, Chthonic, Domestic) with their Islamic judgment and restoration to wholeness."),

                // Wing 01 / 53: Philosophy & Alchemy in Islam, Canonical Adjustments to Theocracies & Theocrats, Socratic Critiques & Evolution of Message Meaning
                new PortalCatalogEntry(53, "islamic-philosophy-alchemy-theocracies-socratic-messages.html", "Philosophy, Alchemy, Theocracies & Socrates",
                        "Philosophy & Alchemy in Islam: Canonical Adjustment to 7 Theocracies & Theocrats, 5 Socratic Critiques & 7 Stages of Message Meaning Shift",
                        "01. Master Hubs & Architecture", "#F59E0B", 0, "#F59E0B",
                        "Al-Falsafah, Al-Kīmiyā' (55:7-9), Lā Kahanūta (9:31), Suqrāṭ & Lafẓ Maḥfūẓ (15:9)",
                        "7 Epochs of Islamic Philosophy & Alchemy (Jabir, Kindi, Razi, Sina, Ghazali, Rushd, Sadra), 7 Theocracy Covenants (Mecca, Abyssinia, Jerusalem, Persia, Harran, Sind), 5 Socratic Critiques, and 7 Stages of Semantic Expansion (Ash-Shafi'i Qadim/Jadid & 4-Tier Ta'wil)."),

                // Wing 10 / 54: How the Modesty Standard for Men & Women in Islam Changed Across the Western Frontier & Expansions
                new PortalCatalogEntry(54, "islamic-modesty-evolution-western-frontier-men-women.html", "Men & Women Modesty: Western Frontier",
                        "How the Modesty Standard (Al-Haya' & Libas At-Taqwa) for Men & Women Changed Across the Western Frontier & Expansions",
                        "10. Islamic Vanguard Husbandry & Botanical Sanctuary", "#10B981", 0, "#10B981",
                        "Qur'an 7:26, 24:30-31, 33:59 & 7:199 ('Urf) • Hijaz, Maghreb Lithām, Al-Andalus, Oran 1504 & Modern West",
                        "Traces the 7 Foundational Modesty Principles, the 7 Epochs of the Western Frontier (including the Almoravid male Litham inversion, Cordoban Celosias, the 1504 Oran Fatwa, Ottoman 1829 suits, and digital Ghadd Al-Basar), and 6 regional sartorial zones."),

                // Wing 01 / 55: Canonical Naming in Islam by Region (Abjad 261 Wafq), Development of Indonesia, Sanitation/Sewer Project Structure, Language & Calligraphy
                new PortalCatalogEntry(55, "islamic-naming-indonesia-infrastructure-language-calligraphy.html", "Naming (261 Wafq), Indonesia, Sewer & Calligraphy",
                        "Canonical Naming in Islam by Region (Zakeem Malik McCaleb Abjad 261 Wafq), Development of Indonesia (87.2% Muslim), Sewer Project Structure, Language & Calligraphy",
                        "01. Master Hubs & Architecture", "#F59E0B", 0, "#F59E0B",
                        "Abjad 261 Wafq (9×29) • Nusantara (87.2% Muslim) • JSS Sewer Grid • Jawi/Pegon & Ibn Muqlah",
                        "Unites the 3x3 Wafq of Zakeem Malik McCaleb (Abjad 261) and 7 regional naming systems with Indonesia's 7-stage Islamic development, 6-tier sanitation/sewer project structure (Bio-Septic to IDR 13T+ JSS), and 7 language/calligraphy milestones."),

                // Wing 01 / 56: The History of Islamic Countries (57 OIC Nations Across 7 Civilizational Zones) & How They Canonically Embrace Being Muslim
                new PortalCatalogEntry(56, "islamic-countries-history-canonical-embrace-atlas.html", "History of Islamic Countries & Canonical Embrace",
                        "The History of Islamic Countries (57 OIC Nations Across 7 Civilizational Zones) & How They Canonically Embrace Being Muslim",
                        "01. Master Hubs & Architecture", "#10B981", 0, "#10B981",
                        "Diyār Al-Islām • 5 Pathways of Embrace (2:256) • 7 Civilizational Zones & 6 Institutional Pillars",
                        "Maps the 5 historical pathways by which nations embraced Islam, all 7 civilizational zones (Arabia, Levant/Nile, Maghreb/West Africa, Horn/Swahili, Anatolia/Balkans/Steppe, Persia/South Asia, Nusantara), and the 6 institutional pillars of living Islam."),

                // Wing 01 / 57: The Caliphates, the Sultans, the Shahs & the Dynasties Instantiated & Dissolved by Islam — Origin, Journey & Promise of Returning
                new PortalCatalogEntry(57, "islamic-caliphates-sultans-shahs-dynasties-return.html", "Caliphates, Sultans, Shahs & Promise of Return",
                        "The Caliphates, the Sultans, the Shahs & the Dynasties Instantiated & Dissolved by Islam: Origin, Journey & The Promise of Returning",
                        "01. Master Hubs & Architecture", "#D4AF37", 0, "#D4AF37",
                        "Qur'an 3:26, 24:55 & 15:9 • Musnad Aḥmad 18406 • Sahih Muslim 145 • Ibn Khaldūn's 4-Gen Law",
                        "Complete canonical synthesis of the 5 Prophetic Political Phases, the 7 Polities (Rāshidūn, Umayyads, Abbasids, Maghreb/Africa, Sunni Sultanates, Ottomans, Persian/Mughal Shahs), why Islam survived every fallen throne, and the Promise of Return."),

                // Wing 01 / 58: Collegiate Multi-HTML Suite Vol. I — Canonical Qur'anic Timeline of Islamic Expansion
                new PortalCatalogEntry(58, "quranic-timeline-expansion-vol1-chronology.html", "Vol. I: Qur'anic Timeline of Expansion",
                        "Collegiate Multi-HTML Suite Vol. I: Canonical Qur'anic Timeline of Islamic Expansion Across 10 Epochs",
                        "01. Master Hubs & Architecture", "#10B981", 0, "#10B981",
                        "Qur'an 7:172, 2:127, 48:1, 59:7-10 & 41:53 • 10 Canonical Epochs",
                        "Volume I of the 3-part Collegiate Multi-HTML Thesis Suite: maps specific Qur'anic Surahs and Āyāt to Prophetic history and 14 Hijri centuries of global civilizational expansion."),

                // Wing 01 / 59: Collegiate Multi-HTML Suite Vol. II — Canonical Islamic Properties, Countries & Kingdoms Across the 7 Climes
                new PortalCatalogEntry(59, "quranic-timeline-expansion-vol2-properties-kingdoms.html", "Vol. II: Islamic Properties, Countries & Kingdoms",
                        "Collegiate Multi-HTML Suite Vol. II: Canonical Islamic Properties (Waqf, Kharāj, 'Ushr, Ḥimā, Mawāt), Countries & Kingdoms",
                        "01. Master Hubs & Architecture", "#38BDF8", 0, "#38BDF8",
                        "Qur'an 7:128, 59:7 & 4:7-12 • Fiqh Al-Amwāl & Al-Aqālīm As-Sab'ah",
                        "Volume II of the 3-part Collegiate Multi-HTML Thesis Suite: complete legal-economic treatise on the 7 canonical property categories and the 7 classical climes of Muslim countries and kingdoms."),

                // Wing 01 / 60: Collegiate Multi-HTML Suite Vol. III — The Beauty of Islam (Jamāl Al-Islām) & 8-Chapter Collegiate Universal Thesis Essay
                new PortalCatalogEntry(60, "quranic-timeline-expansion-vol3-beauty-collegiate-thesis.html", "Vol. III: Beauty of Islam & Collegiate Thesis",
                        "Collegiate Multi-HTML Suite Vol. III: The 7 Dimensions of the Beauty of Islam & 8-Chapter Collegiate Universal Thesis Monograph",
                        "01. Master Hubs & Architecture", "#F43F5E", 0, "#F43F5E",
                        "Sahih Muslim 91 & 8 • Qur'an 12:18, 15:85, 16:90, 24:35, 39:23 & 50:6",
                        "Volume III of the 3-part Collegiate Multi-HTML Thesis Suite: explores the 7 dimensions of Jamāl Al-Islām and presents the full 8-chapter Collegiate Universal Thesis Essay."),

                // Wing 01 / 61: Expansive Multi-HTML Suite Vol. I — Islam Through the Ages & Global Civilizational Reception
                new PortalCatalogEntry(61, "islam-through-ages-vol1-reception-history.html", "Ages Vol. I: Islam & Global Reception",
                        "Expansive Multi-HTML Suite Vol. I: Islam Through the Ages & Its Global Civilizational Reception Across 7 Historical Ages",
                        "01. Master Hubs & Architecture", "#10B981", 0, "#10B981",
                        "Qur'an 19:1-36, 39:18 & 41:53 • Aksum, Baghdad, Toledo, Maragheh, Oxford, Weimar & Modern Labs",
                        "Traces the 7 Ages of Islam and its cross-civilizational reception from 615 CE Abyssinia through Latin Scholasticism (Aquinas/Bacon), Copernicus, Locke/Goethe/Jefferson, and modern Nobel laboratories."),

                // Wing 01 / 62: Expansive Multi-HTML Suite Vol. II — The 7 Philosophical Connotations & Metaphysical Paradigms of Islam
                new PortalCatalogEntry(62, "islam-through-ages-vol2-philosophical-connotations.html", "Ages Vol. II: Philosophical Connotations",
                        "Expansive Multi-HTML Suite Vol. II: The 7 Philosophical Connotations & Paradigms Instantiated by Islamic Thought",
                        "01. Master Hubs & Architecture", "#A855F7", 0, "#A855F7",
                        "Wājib Al-Wujūd • Floating Man • Sunnat Allāh • Faṣl Al-Maqāl • Al-I'tibār • 4D Motion • 'Ilm Al-'Umrān",
                        "Synthesizes the 7 foundational philosophical paradigms of Ibn Sīnā, Al-Ghazālī, Ibn Rushd, Ibn Ṭufayl, Ibn Al-Haytham, Mullā Ṣadrā, Ibn Khaldūn, and Ash-Shāṭibī."),

                // Wing 01 / 63: Expansive Multi-HTML Suite Vol. III — Qur'anic & Prophetic Scientific Allusions Instantiated Through Science
                new PortalCatalogEntry(63, "islam-through-ages-vol3-scientific-discoveries-instantiated.html", "Ages Vol. III: Scientific Discoveries Instantiated",
                        "Expansive Multi-HTML Suite Vol. III: Scientific Discoveries Alluded to in the Qur'an & Hadith Instantiated Through Science",
                        "01. Master Hubs & Architecture", "#38BDF8", 0, "#38BDF8",
                        "Qur'an 21:30, 51:47, 24:35, 23:12-14, 55:19-20, 78:7 & 57:25 (Supernova Iron Z=26)",
                        "Maps 7 scientific domains where Qur'anic and Prophetic allusions catalyzed classical Islamic laboratory breakthroughs (Ibn Al-Haytham, Ibn Sahl, Ibn Al-Nafīs, Al-Khwārizmī, Al-Khāzinī) and modern empirical verification."),

                // Wing 01 / 64: Boating, Piracy, Mercantilism, Currency, Maps, Astrolabes, Compasses & Omani/Yemeni Coasting Caliphates
                new PortalCatalogEntry(64, "islamic-maritime-boating-piracy-mercantilism-currency-maps-astrolabes-oman-yemen.html", "Maritime: Boating, Piracy, Currency, Astrolabe & Oman/Yemen",
                        "Boating, Piracy, Mercantilism, Currency, Maps, Astrolabes, Compasses & The Omani and Yemeni Coasting Caliphates & Sultanates",
                        "01. Master Hubs & Architecture", "#D4AF37", 0, "#D4AF37",
                        "Qur'an 16:14, 55:24 & 18:71/79 • Sewn Dhows, Akriyat Al-Sufun, Qirāḍ/Ṣakk, Dīnār/Lārīn, Kamāl, 32-Star Compass, Oman & Yemen",
                        "Comprehensive atlas of Islamic naval engineering, piracy & maritime law, venture mercantilism, gold/silver currency, Al-Idrīsī/Piri Reis maps, astrolabes, the Kamāl, Ibn Mājid's 32-point star compass, and Omani/Yemeni maritime polities.")
        );
    }

    public List<WarlockHtmlPortalService.GeneratedHtmlArtifact> integrateAllPortalsAndGenerateMasterIndex(
            Path outputDir,
            List<WarlockHtmlPortalService.GeneratedHtmlArtifact> existingArtifacts) {
        try {
            Files.createDirectories(outputDir);
            List<PortalCatalogEntry> catalog = allCatalogEntries();

            // 1. Generate index.html and master-combined-omnibus.html first
            Path indexPath = outputDir.resolve("index.html");
            Files.writeString(indexPath, renderMasterIndexHtml(catalog), StandardCharsets.UTF_8);

            Path omnibusPath = outputDir.resolve("master-combined-omnibus.html");
            Files.writeString(omnibusPath, renderCombinedOmnibusHtml(catalog), StandardCharsets.UTF_8);

            // 2. Retroactively inject Universal Top Navigation, Mega-Drawer, Row #1..#7 Sister Ribbon,
            //    and Sitemap Footer into ALL 49 HTML files so every page links to every other page
            Map<String, PortalCatalogEntry> byFile = new LinkedHashMap<>();
            for (PortalCatalogEntry entry : catalog) {
                byFile.put(entry.fileName(), entry);
            }

            for (int i = 0; i < catalog.size(); i++) {
                PortalCatalogEntry current = catalog.get(i);
                PortalCatalogEntry prev = catalog.get((i - 1 + catalog.size()) % catalog.size());
                PortalCatalogEntry next = catalog.get((i + 1) % catalog.size());
                Path file = outputDir.resolve(current.fileName());
                if (Files.exists(file)) {
                    String rawHtml = Files.readString(file, StandardCharsets.UTF_8);
                    String upgradedHtml = injectUniversalNavigationChrome(rawHtml, current, prev, next, catalog);
                    Files.writeString(file, upgradedHtml, StandardCharsets.UTF_8);
                }
            }

            // 3. Recompute updated sizes and SHA-256 hashes for all artifacts + add the 2 new Master Portals
            List<WarlockHtmlPortalService.GeneratedHtmlArtifact> finalArtifacts = new ArrayList<>();
            int totalPortals = catalog.size();

            String indexFinal = Files.readString(indexPath, StandardCharsets.UTF_8);
            finalArtifacts.add(new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                    "index.html",
                    indexPath,
                    Files.size(indexPath),
                    sha256(indexFinal),
                    "Sovereign Master Index, Live Search, Multi-Wing Sitemap & 7-Row Cross-Domain Relational Matrix (All " + totalPortals + " Portals Continually Synced)"
            ));

            String omnibusFinal = Files.readString(omnibusPath, StandardCharsets.UTF_8);
            finalArtifacts.add(new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                    "master-combined-omnibus.html",
                    omnibusPath,
                    Files.size(omnibusPath),
                    sha256(omnibusFinal),
                    "Combined Multi-Portal Omnibus Workspace: Sidebar Tree Navigator, Split-Screen Dual Comparator & Continual Reader (All " + totalPortals + " Portals)"
            ));

            for (WarlockHtmlPortalService.GeneratedHtmlArtifact old : existingArtifacts) {
                Path p = old.filePath();
                if (Files.exists(p)) {
                    String content = Files.readString(p, StandardCharsets.UTF_8);
                    finalArtifacts.add(new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                            old.fileName(),
                            p,
                            Files.size(p),
                            sha256(content),
                            old.description()
                    ));
                } else {
                    finalArtifacts.add(old);
                }
            }

            return List.copyOf(finalArtifacts);
        } catch (IOException e) {
            throw new IllegalStateException("Failed integrating and generating Master HTML Index", e);
        }
    }

    private String stripBetweenMarkers(String html, String startMarker, String endMarker) {
        int s = html.indexOf(startMarker);
        int e = html.indexOf(endMarker);
        if (s >= 0 && e > s) {
            return html.substring(0, s) + html.substring(e + endMarker.length());
        }
        return html;
    }

    private String injectUniversalNavigationChrome(
            String rawHtml,
            PortalCatalogEntry current,
            PortalCatalogEntry prev,
            PortalCatalogEntry next,
            List<PortalCatalogEntry> catalog) {

        String modified = rawHtml;
        // Continually update: strip any previously injected navigation blocks if present
        modified = stripBetweenMarkers(modified, "<!-- SOV_CHROME_CSS_START -->", "<!-- SOV_CHROME_CSS_END -->");
        modified = stripBetweenMarkers(modified, "<!-- SOV_CHROME_TOP_START -->", "<!-- SOV_CHROME_TOP_END -->");
        modified = stripBetweenMarkers(modified, "<!-- SOV_CHROME_FOOTER_START -->", "<!-- SOV_CHROME_FOOTER_END -->");

        if (modified.contains("id=\"sovereign-universal-nav\"")) {
            return modified;
        }

        String cssBlock = "<!-- SOV_CHROME_CSS_START -->\n" + buildUniversalChromeCss() + "\n<!-- SOV_CHROME_CSS_END -->";
        String topBarHtml = "<!-- SOV_CHROME_TOP_START -->\n" + buildUniversalTopBarAndDrawerHtml(current, prev, next, catalog) + "\n<!-- SOV_CHROME_TOP_END -->";
        String bottomFooterHtml = "<!-- SOV_CHROME_FOOTER_START -->\n" + buildUniversalFooterHtml(current, prev, next, catalog) + "\n<!-- SOV_CHROME_FOOTER_END -->";

        int headClose = modified.indexOf("</head>");
        if (headClose >= 0) {
            modified = modified.substring(0, headClose) + cssBlock + "\n</head>" + modified.substring(headClose + 7);
        }

        int bodyOpen = modified.indexOf("<body");
        if (bodyOpen >= 0) {
            int bodyTagEnd = modified.indexOf(">", bodyOpen);
            if (bodyTagEnd >= 0) {
                modified = modified.substring(0, bodyTagEnd + 1) + "\n" + topBarHtml + "\n" + modified.substring(bodyTagEnd + 1);
            }
        }

        int bodyClose = modified.lastIndexOf("</body>");
        if (bodyClose >= 0) {
            modified = modified.substring(0, bodyClose) + "\n" + bottomFooterHtml + "\n</body>" + modified.substring(bodyClose + 7);
        }

        return modified;
    }

    private String buildUniversalChromeCss() {
        return """
  <style id="sovereign-universal-nav-css">
    .sov-global-wrap {
      background: linear-gradient(90deg, #04060C 0%, #0C1324 50%, #04060C 100%);
      border-bottom: 2px solid #D4AF37;
      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
      position: relative;
      z-index: 9999;
      box-shadow: 0 6px 24px rgba(0, 0, 0, 0.65);
    }
    .sov-global-bar {
      max-width: 1560px;
      margin: 0 auto;
      padding: 0.55rem 1.2rem;
      display: flex;
      flex-wrap: wrap;
      align-items: center;
      justify-content: space-between;
      gap: 0.45rem;
    }
    .sov-wing-links {
      display: flex;
      flex-wrap: wrap;
      align-items: center;
      gap: 0.35rem;
    }
    .sov-pill {
      display: inline-flex;
      align-items: center;
      gap: 0.3rem;
      padding: 0.28rem 0.62rem;
      border-radius: 999px;
      background: rgba(15, 23, 42, 0.92);
      border: 1px solid rgba(255, 255, 255, 0.14);
      color: #CBD5E1;
      text-decoration: none;
      font-size: 0.74rem;
      font-weight: 600;
      transition: all 0.15s ease;
      cursor: pointer;
    }
    .sov-pill:hover, .sov-pill.sov-active {
      color: #FFFFFF;
      border-color: #D4AF37;
      background: rgba(212, 175, 55, 0.22);
    }
    .sov-pill-master {
      background: linear-gradient(135deg, rgba(212, 175, 55, 0.28), rgba(16, 185, 129, 0.22));
      border-color: #D4AF37;
      color: #FDE68A;
      font-weight: 700;
    }
    .sov-pill-omnibus {
      background: linear-gradient(135deg, rgba(56, 189, 248, 0.25), rgba(168, 85, 247, 0.22));
      border-color: #38BDF8;
      color: #E0F2FE;
      font-weight: 700;
    }
    .sov-pill-drawer {
      background: #1E293B;
      border-color: #F43F5E;
      color: #FDA4AF;
      font-weight: 700;
    }
    .sov-pill-counter {
      border-color: #D4AF37;
      background: rgba(212, 175, 55, 0.18);
      color: #FDE68A;
      font-family: 'Consolas', monospace;
      font-weight: 700;
    }
    .sov-pill-sync {
      border-color: #10B981;
      background: rgba(16, 185, 129, 0.14);
      color: #6EE7B7;
      font-family: 'Consolas', monospace;
      font-size: 0.71rem;
    }
    .sov-sister-ribbon {
      background: rgba(10, 15, 28, 0.96);
      border-top: 1px solid rgba(255, 255, 255, 0.09);
      padding: 0.45rem 1.2rem;
    }
    .sov-sister-inner {
      max-width: 1560px;
      margin: 0 auto;
      display: flex;
      flex-wrap: wrap;
      align-items: center;
      justify-content: space-between;
      gap: 0.5rem;
      font-size: 0.75rem;
    }
    .sov-sister-group {
      display: flex;
      flex-wrap: wrap;
      align-items: center;
      gap: 0.35rem;
    }
    .sov-sister-label {
      font-family: 'Consolas', monospace;
      color: #FDE68A;
      font-weight: 700;
      margin-right: 0.25rem;
    }
    .sov-modal-backdrop {
      display: none;
      position: fixed;
      inset: 0;
      background: rgba(3, 5, 10, 0.88);
      backdrop-filter: blur(6px);
      z-index: 100000;
      overflow-y: auto;
      padding: 2rem 1.2rem;
    }
    .sov-modal-backdrop.open {
      display: block;
    }
    .sov-modal-box {
      max-width: 1380px;
      margin: 0 auto;
      background: #0B101D;
      border: 2px solid #D4AF37;
      border-radius: 14px;
      padding: 1.4rem;
      box-shadow: 0 20px 60px rgba(0,0,0,0.85);
    }
    .sov-modal-header {
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
      align-items: center;
      gap: 0.8rem;
      margin-bottom: 1rem;
      padding-bottom: 0.8rem;
      border-bottom: 1px solid rgba(255,255,255,0.12);
    }
    .sov-search-input {
      flex: 1;
      min-width: 260px;
      background: #050811;
      border: 1px solid #38BDF8;
      color: #FFFFFF;
      padding: 0.55rem 0.9rem;
      border-radius: 8px;
      font-size: 0.86rem;
    }
    .sov-drawer-grid {
      display: grid;
      grid-template-columns: repeat(auto-fill, minmax(285px, 1fr));
      gap: 0.65rem;
      max-height: 70vh;
      overflow-y: auto;
      padding-right: 0.3rem;
    }
    .sov-drawer-item {
      display: block;
      background: rgba(255,255,255,0.03);
      border: 1px solid rgba(255,255,255,0.1);
      border-left: 4px solid #D4AF37;
      border-radius: 8px;
      padding: 0.55rem 0.75rem;
      text-decoration: none;
      color: #E2E8F0;
      transition: all 0.14s ease;
    }
    .sov-drawer-item:hover, .sov-drawer-item.current {
      background: rgba(212, 175, 55, 0.16);
      border-color: #D4AF37;
      transform: translateY(-1px);
    }
    .sov-footer-wrap {
      max-width: 1480px;
      margin: 3rem auto 1rem auto;
      padding: 1.5rem;
      background: rgba(8, 12, 22, 0.95);
      border: 1px solid rgba(255,255,255,0.12);
      border-top: 3px solid #D4AF37;
      border-radius: 14px;
      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
    }
    .sov-footer-cols {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(230px, 1fr));
      gap: 1rem;
      margin-top: 1rem;
    }
    .sov-footer-cat h4 {
      font-size: 0.78rem;
      color: #FDE68A;
      text-transform: uppercase;
      letter-spacing: 0.04em;
      margin-bottom: 0.45rem;
      border-bottom: 1px solid rgba(255,255,255,0.1);
      padding-bottom: 0.25rem;
    }
    .sov-footer-cat a {
      display: block;
      color: #94A3B8;
      text-decoration: none;
      font-size: 0.76rem;
      padding: 0.14rem 0;
    }
    .sov-footer-cat a:hover, .sov-footer-cat a.active-link {
      color: #38BDF8;
      font-weight: 600;
    }
  </style>""";
    }

    private String buildUniversalTopBarAndDrawerHtml(
            PortalCatalogEntry current,
            PortalCatalogEntry prev,
            PortalCatalogEntry next,
            List<PortalCatalogEntry> catalog) {

        int totalPortals = catalog.size();

        StringBuilder drawerCards = new StringBuilder();
        for (PortalCatalogEntry item : catalog) {
            String currentCls = item.fileName().equals(current.fileName()) ? "sov-drawer-item current" : "sov-drawer-item";
            drawerCards.append(String.format(
                    "<a class=\"%s\" style=\"border-left-color:%s;\" href=\"%s\" data-search=\"%s\">"
                            + "<div style=\"display:flex;justify-content:space-between;font-size:0.7rem;color:#94A3B8;\">"
                            + "<span>#%02d / %02d • %s</span><code style=\"color:#38BDF8;\">%s</code></div>"
                            + "<div style=\"font-weight:700;font-size:0.83rem;color:#F8FAFC;margin:0.15rem 0;\">%s</div>"
                            + "<div style=\"font-size:0.72rem;color:#CBD5E1;\">%s</div>"
                            + "</a>",
                    currentCls,
                    item.hexAccent(),
                    item.fileName(),
                    escapeAttr((item.shortLabel() + " " + item.title() + " " + item.wingCategory() + " " + item.arabicAndQuranicTag() + " " + item.fileName()).toLowerCase()),
                    item.sequenceNumber(),
                    totalPortals,
                    escapeHtml(item.wingCategory()),
                    escapeHtml(item.fileName()),
                    escapeHtml(item.shortLabel()),
                    escapeHtml(item.arabicAndQuranicTag())
            ));
        }

        String sisterRibbon = buildRowSisterRibbonHtml(current);

        return String.format("""
  <div id="sovereign-universal-nav" class="sov-global-wrap" data-portal-seq="%d" data-portal-total="%d">
    <div class="sov-global-bar">
      <div class="sov-wing-links">
        <a class="sov-pill sov-pill-master %s" href="index.html">🏠 Master Index (<span data-sov-total>%d</span>)</a>
        <a class="sov-pill sov-pill-omnibus %s" href="islamic-maritime-boating-piracy-mercantilism-currency-maps-astrolabes-oman-yemen.html">⛵ Maritime, Astrolabe &amp; Oman/Yemen (#64)</a>
        <a class="sov-pill sov-pill-omnibus %s" href="islam-through-ages-vol1-reception-history.html">🔬 Ages, Philosophy &amp; Science (#61–#63)</a>
        <a class="sov-pill sov-pill-omnibus %s" href="quranic-timeline-expansion-vol1-chronology.html">🎓 Collegiate Thesis (#58–#60)</a>
        <a class="sov-pill sov-pill-omnibus %s" href="islamic-caliphates-sultans-shahs-dynasties-return.html">👑 Caliphates &amp; Return (#57)</a>
        <a class="sov-pill sov-pill-omnibus %s" href="islamic-countries-history-canonical-embrace-atlas.html">🌍 57 OIC Countries (#56)</a>
        <a class="sov-pill sov-pill-omnibus %s" href="islamic-naming-indonesia-infrastructure-language-calligraphy.html">🚰 Naming &amp; Sewer (#55)</a>
        <a class="sov-pill sov-pill-omnibus %s" href="islamic-modesty-evolution-western-frontier-men-women.html">🧕 Western Modesty (#54)</a>
        <a class="sov-pill sov-pill-omnibus %s" href="islamic-philosophy-alchemy-theocracies-socratic-messages.html">⚗️ Philosophy &amp; Alchemy (#53)</a>
        <a class="sov-pill sov-pill-omnibus %s" href="greco-roman-gods-titans-daimones-islamic-judgment.html">⚖️ Greco-Roman &amp; Titans (#52)</a>
        <a class="sov-pill sov-pill-omnibus %s" href="islamic-caravans-battles-conquest-chronicle.html">🐪 Caravans &amp; Fatḥ (#51)</a>
        <a class="sov-pill sov-pill-omnibus %s" href="conjoined-worlds-realms-principles-node-grid.html">⛰️ 3D Node-Art Grid (#50)</a>
        <a class="sov-pill sov-pill-omnibus %s" href="master-combined-omnibus.html?portal=%s">🧭 Combined Omnibus View</a>
        <button type="button" class="sov-pill sov-pill-drawer" onclick="toggleSovDrawer()">⚡ All <span data-sov-total>%d</span> Portals (Ctrl+K)</button>
        <a class="sov-pill %s" href="order-1-white.html">🎨 7 Orders</a>
        <a class="sov-pill %s" href="warlock-3d-sanctum.html">🏛️ 3D Sanctum &amp; Realms</a>
        <a class="sov-pill %s" href="priory-negentropy-order.html">📐 Priory &amp; Planes</a>
        <a class="sov-pill %s" href="zalim-1-fasad.html">⚠️ 7 Zalim</a>
        <a class="sov-pill %s" href="worlds-hegemon-disorder.html">🌍 7 Worlds</a>
        <a class="sov-pill %s" href="warlock-formation-dissolution-jafar-aladdin.html">🏺 Ja'far/Aladdin</a>
        <a class="sov-pill %s" href="sequester-between-worlds.html">🧱 7 Sequesters</a>
        <a class="sov-pill %s" href="interlocker-egg-binder-islam.html">🥚 Egg Binder</a>
        <a class="sov-pill %s" href="warlock-apocrypha-islamic-theorems.html">📜 Apocrypha</a>
        <a class="sov-pill %s" href="islamic-husbandry-sovereign-estate.html">🛡️ Husbandry</a>
        <a class="sov-pill %s" href="way-of-the-flower-rose-garden-islam.html">🌹 Rose Garden</a>
        <a class="sov-pill %s" href="disney-daffy-donald-islamic-microcosm.html">🦆 Disney/Daffy</a>
        <a class="sov-pill %s" href="warlock-islamic-visual-eras-history.html">🕌 7 Visual Eras</a>
        <a class="sov-pill %s" href="dependencies-report.html">📦 Dependencies</a>
      </div>
      <div class="sov-wing-links">
        <a class="sov-pill" href="%s" title="%s">← Prev: %s</a>
        <span id="sovPortalCounterBadge" class="sov-pill sov-pill-counter" title="Continually Synchronized Portal Index (#%02d of %02d)">#%02d / %02d</span>
        <button type="button" id="sovContinualCycleBtn" class="sov-pill sov-pill-sync" onclick="toggleSovContinualCycle()" title="Click to toggle Continual Auto-Advance across all %d portals">🔄 Continual Sync: #%02d/%02d</button>
        <a class="sov-pill" href="%s" title="%s">Next: %s →</a>
      </div>
    </div>
    %s
  </div>

  <div id="sovMegaDrawer" class="sov-modal-backdrop" onclick="if(event.target===this)toggleSovDrawer()">
    <div class="sov-modal-box">
      <div class="sov-modal-header">
        <div>
          <div style="font-family:Consolas,monospace;font-size:0.74rem;color:#FDE68A;">SOVEREIGN MASTER ATLAS • ALL <span data-sov-total>%d</span> HTML PORTALS CONTINUALLY INTEGRATED</div>
          <h2 style="font-size:1.25rem;color:#FFF;margin:0.15rem 0;">Instant Portal Switcher &amp; Cross-Wing Navigator (#%02d / %02d)</h2>
        </div>
        <input id="sovDrawerSearch" class="sov-search-input" type="text" placeholder="Type to filter all %d portals by name, Qur'anic verse, philosopher, scientist, color, or file..." oninput="filterSovDrawer(this.value)">
        <div style="display:flex;gap:0.4rem;flex-wrap:wrap;">
          <a class="sov-pill sov-pill-master" href="index.html">Open Master Index (%d)</a>
          <a class="sov-pill sov-pill-omnibus" href="islamic-maritime-boating-piracy-mercantilism-currency-maps-astrolabes-oman-yemen.html">⛵ Maritime &amp; Oman/Yemen (#64)</a>
          <a class="sov-pill sov-pill-omnibus" href="islam-through-ages-vol1-reception-history.html">Ages &amp; Science (#61–#63)</a>
          <a class="sov-pill sov-pill-omnibus" href="quranic-timeline-expansion-vol1-chronology.html">Collegiate Thesis (#58–#60)</a>
          <a class="sov-pill sov-pill-omnibus" href="conjoined-worlds-realms-principles-node-grid.html">3D Node-Art Grid (#50)</a>
          <a class="sov-pill sov-pill-omnibus" href="master-combined-omnibus.html?portal=%s">Open in Split Omnibus</a>
          <button type="button" class="sov-pill" onclick="toggleSovDrawer()">✕ Close (Esc)</button>
        </div>
      </div>
      <div id="sovDrawerGrid" class="sov-drawer-grid">
        %s
      </div>
    </div>
  </div>

  <script>
    const SOVEREIGN_CURRENT_SEQ = %d;
    const SOVEREIGN_TOTAL_PORTALS = %d;
    const SOVEREIGN_NEXT_FILE = "%s";
    let sovContinualTimer = null;

    function syncSovereignPortalCounts() {
      const items = document.querySelectorAll('#sovDrawerGrid .sov-drawer-item');
      const liveTotal = items.length > 0 ? items.length : SOVEREIGN_TOTAL_PORTALS;
      document.querySelectorAll('[data-sov-total]').forEach(el => {
        el.textContent = String(liveTotal);
      });
      const badge = document.getElementById('sovPortalCounterBadge');
      if (badge) {
        badge.textContent = '#' + String(SOVEREIGN_CURRENT_SEQ).padStart(2, '0') + ' / ' + String(liveTotal).padStart(2, '0');
      }
    }

    function toggleSovContinualCycle() {
      const btn = document.getElementById('sovContinualCycleBtn');
      const active = sessionStorage.getItem('sovContinualCycleActive') === '1';
      if (active) {
        sessionStorage.removeItem('sovContinualCycleActive');
        if (sovContinualTimer) { clearTimeout(sovContinualTimer); sovContinualTimer = null; }
        if (btn) btn.textContent = '🔄 Continual Sync: #' + String(SOVEREIGN_CURRENT_SEQ).padStart(2, '0') + '/' + String(SOVEREIGN_TOTAL_PORTALS).padStart(2, '0');
      } else {
        sessionStorage.setItem('sovContinualCycleActive', '1');
        if (btn) btn.textContent = '⏩ Auto-Cycling (6s) → ' + SOVEREIGN_NEXT_FILE;
        sovContinualTimer = setTimeout(() => {
          window.location.href = SOVEREIGN_NEXT_FILE;
        }, 6000);
      }
    }

    function toggleSovDrawer() {
      const el = document.getElementById('sovMegaDrawer');
      if (!el) return;
      el.classList.toggle('open');
      if (el.classList.contains('open')) {
        const inp = document.getElementById('sovDrawerSearch');
        if (inp) { inp.value = ''; filterSovDrawer(''); inp.focus(); }
      }
    }
    function filterSovDrawer(q) {
      const query = (q || '').toLowerCase().trim();
      document.querySelectorAll('#sovDrawerGrid .sov-drawer-item').forEach(el => {
        const hay = el.getAttribute('data-search') || '';
        el.style.display = (!query || hay.includes(query)) ? 'block' : 'none';
      });
    }
    document.addEventListener('keydown', function(e) {
      if ((e.ctrlKey || e.metaKey) && e.key.toLowerCase() === 'k') {
        e.preventDefault();
        toggleSovDrawer();
      } else if (e.key === 'Escape') {
        const el = document.getElementById('sovMegaDrawer');
        if (el && el.classList.contains('open')) el.classList.remove('open');
      }
    });
    document.addEventListener('DOMContentLoaded', function() {
      syncSovereignPortalCounts();
      if (sessionStorage.getItem('sovContinualCycleActive') === '1') {
        const btn = document.getElementById('sovContinualCycleBtn');
        if (btn) btn.textContent = '⏩ Auto-Cycling (6s) → ' + SOVEREIGN_NEXT_FILE;
        sovContinualTimer = setTimeout(() => {
          window.location.href = SOVEREIGN_NEXT_FILE;
        }, 6000);
      }
    });
  </script>""",
                current.sequenceNumber(),
                totalPortals,
                current.fileName().equals("index.html") ? "sov-active" : "",
                totalPortals,
                current.fileName().equals("islamic-maritime-boating-piracy-mercantilism-currency-maps-astrolabes-oman-yemen.html") ? "sov-active" : "",
                current.fileName().startsWith("islam-through-ages-") ? "sov-active" : "",
                current.fileName().startsWith("quranic-timeline-expansion-") ? "sov-active" : "",
                current.fileName().equals("islamic-caliphates-sultans-shahs-dynasties-return.html") ? "sov-active" : "",
                current.fileName().equals("islamic-countries-history-canonical-embrace-atlas.html") ? "sov-active" : "",
                current.fileName().equals("islamic-naming-indonesia-infrastructure-language-calligraphy.html") ? "sov-active" : "",
                current.fileName().equals("islamic-modesty-evolution-western-frontier-men-women.html") ? "sov-active" : "",
                current.fileName().equals("islamic-philosophy-alchemy-theocracies-socratic-messages.html") ? "sov-active" : "",
                current.fileName().equals("greco-roman-gods-titans-daimones-islamic-judgment.html") ? "sov-active" : "",
                current.fileName().equals("islamic-caravans-battles-conquest-chronicle.html") ? "sov-active" : "",
                current.fileName().equals("conjoined-worlds-realms-principles-node-grid.html") ? "sov-active" : "",
                current.fileName().equals("master-combined-omnibus.html") ? "sov-active" : "",
                current.fileName(),
                totalPortals,
                current.fileName().startsWith("order-") ? "sov-active" : "",
                (current.fileName().equals("warlock-3d-sanctum.html") || current.fileName().startsWith("realm-")) ? "sov-active" : "",
                (current.fileName().equals("priory-negentropy-order.html") || current.fileName().startsWith("plane-")) ? "sov-active" : "",
                current.fileName().startsWith("zalim-") ? "sov-active" : "",
                (current.fileName().equals("worlds-hegemon-disorder.html") || current.fileName().startsWith("world-")) ? "sov-active" : "",
                current.fileName().equals("warlock-formation-dissolution-jafar-aladdin.html") ? "sov-active" : "",
                current.fileName().equals("sequester-between-worlds.html") ? "sov-active" : "",
                current.fileName().equals("interlocker-egg-binder-islam.html") ? "sov-active" : "",
                current.fileName().equals("warlock-apocrypha-islamic-theorems.html") ? "sov-active" : "",
                current.fileName().equals("islamic-husbandry-sovereign-estate.html") ? "sov-active" : "",
                current.fileName().equals("way-of-the-flower-rose-garden-islam.html") ? "sov-active" : "",
                current.fileName().equals("disney-daffy-donald-islamic-microcosm.html") ? "sov-active" : "",
                current.fileName().equals("warlock-islamic-visual-eras-history.html") ? "sov-active" : "",
                current.fileName().equals("dependencies-report.html") ? "sov-active" : "",
                prev.fileName(),
                escapeAttr(prev.title()),
                escapeHtml(prev.shortLabel()),
                current.sequenceNumber(),
                totalPortals,
                current.sequenceNumber(),
                totalPortals,
                totalPortals,
                current.sequenceNumber(),
                totalPortals,
                next.fileName(),
                escapeAttr(next.title()),
                escapeHtml(next.shortLabel()),
                sisterRibbon,
                totalPortals,
                current.sequenceNumber(),
                totalPortals,
                totalPortals,
                totalPortals,
                current.fileName(),
                drawerCards.toString(),
                current.sequenceNumber(),
                totalPortals,
                escapeAttr(next.fileName())
        );
    }

    private String buildRowSisterRibbonHtml(PortalCatalogEntry current) {
        int r = current.rowIndex1To7();
        if (r < 1 || r > 7) {
            // Show quick jump to the 7-Row Cross-Domain Relational Matrix for non-indexed hubs
            StringBuilder rowPills = new StringBuilder();
            for (int i = 1; i <= 7; i++) {
                rowPills.append(String.format(
                        "<a class=\"sov-pill\" href=\"%s\"><span style=\"width:8px;height:8px;border-radius:50%%;background:%s;display:inline-block;\"></span>Row #%d: Order/Realm/Plane/Zalim/World</a>",
                        ORDER_FILES[i], ROW_COLORS[i], i
                ));
            }
            return String.format("""
    <div class="sov-sister-ribbon">
      <div class="sov-sister-inner">
        <div class="sov-sister-group">
          <span class="sov-sister-label">7-FOLD SERIES QUICK JUMP:</span>
          %s
        </div>
      </div>
    </div>""", rowPills.toString());
        }

        // For any Row #1..#7 page (order-k, realm-k, plane-k, zalim-k, world-k), render all 5 sister portals of Row #r!
        String orderCls = current.fileName().equals(ORDER_FILES[r]) ? "sov-pill sov-active" : "sov-pill";
        String realmCls = current.fileName().equals(REALM_FILES[r]) ? "sov-pill sov-active" : "sov-pill";
        String planeCls = current.fileName().equals(PLANE_FILES[r]) ? "sov-pill sov-active" : "sov-pill";
        String zalimCls = current.fileName().equals(ZALIM_FILES[r]) ? "sov-pill sov-active" : "sov-pill";
        String worldCls = current.fileName().equals(WORLD_FILES[r]) ? "sov-pill sov-active" : "sov-pill";

        String[] sameSeries = ORDER_FILES;
        if (current.fileName().startsWith("realm-")) {
            sameSeries = REALM_FILES;
        } else if (current.fileName().startsWith("plane-")) {
            sameSeries = PLANE_FILES;
        } else if (current.fileName().startsWith("zalim-")) {
            sameSeries = ZALIM_FILES;
        } else if (current.fileName().startsWith("world-")) {
            sameSeries = WORLD_FILES;
        }

        StringBuilder seriesNumbers = new StringBuilder();
        for (int i = 1; i <= 7; i++) {
            String cls = (i == r) ? "sov-pill sov-active" : "sov-pill";
            seriesNumbers.append(String.format(
                    "<a class=\"%s\" href=\"%s\"><span style=\"width:8px;height:8px;border-radius:50%%;background:%s;display:inline-block;\"></span>#%d</a>",
                    cls, sameSeries[i], ROW_COLORS[i], i
            ));
        }

        return String.format("""
    <div class="sov-sister-ribbon">
      <div class="sov-sister-inner">
        <div class="sov-sister-group">
          <span class="sov-sister-label">CROSS-WING SISTER PORTALS FOR %s:</span>
          <a class="%s" href="%s">🎨 Order #%d</a>
          <a class="%s" href="%s">🏛️ Realm #%d</a>
          <a class="%s" href="%s">📐 Plane #%d</a>
          <a class="%s" href="%s">⚠️ Zalim #%d</a>
          <a class="%s" href="%s">🌍 World #%d</a>
          <a class="sov-pill" href="master-combined-omnibus.html?portal=%s&amp;compare=%s">🔀 Compare Side-by-Side</a>
        </div>
        <div class="sov-sister-group">
          <span class="sov-sister-label">SERIES #1..#7:</span>
          %s
        </div>
      </div>
    </div>""",
                escapeHtml(ROW_COLOR_NAMES[r]),
                orderCls, ORDER_FILES[r], r,
                realmCls, REALM_FILES[r], r,
                planeCls, PLANE_FILES[r], r,
                zalimCls, ZALIM_FILES[r], r,
                worldCls, WORLD_FILES[r], r,
                ORDER_FILES[r], WORLD_FILES[r],
                seriesNumbers.toString()
        );
    }

    private String buildUniversalFooterHtml(
            PortalCatalogEntry current,
            PortalCatalogEntry prev,
            PortalCatalogEntry next,
            List<PortalCatalogEntry> catalog) {

        int totalPortals = catalog.size();
        Map<String, List<PortalCatalogEntry>> byCategory = new LinkedHashMap<>();
        for (PortalCatalogEntry item : catalog) {
            byCategory.computeIfAbsent(item.wingCategory(), k -> new ArrayList<>()).add(item);
        }

        StringBuilder cols = new StringBuilder();
        for (Map.Entry<String, List<PortalCatalogEntry>> entry : byCategory.entrySet()) {
            cols.append("<div class=\"sov-footer-cat\">");
            cols.append("<h4>").append(escapeHtml(entry.getKey())).append("</h4>");
            for (PortalCatalogEntry p : entry.getValue()) {
                String cls = p.fileName().equals(current.fileName()) ? "active-link" : "";
                cols.append(String.format(
                        "<a class=\"%s\" href=\"%s\">#%02d/%02d %s</a>",
                        cls, p.fileName(), p.sequenceNumber(), totalPortals, escapeHtml(p.shortLabel())
                ));
            }
            cols.append("</div>");
        }

        return String.format("""
  <footer class="sov-footer-wrap">
    <div style="display:flex;flex-wrap:wrap;justify-content:space-between;align-items:center;gap:0.8rem;padding-bottom:0.9rem;border-bottom:1px solid rgba(255,255,255,0.12);">
      <div>
        <div style="font-family:Consolas,monospace;font-size:0.74rem;color:#FDE68A;">COMPLETE <span data-sov-total>%d</span>-PORTAL CONTINUALLY UPDATED SITEMAP • CURRENT: #%02d / %02d — %s (%s)</div>
        <div style="font-size:0.84rem;color:#CBD5E1;">Every HTML portal is directly cross-linked and continually synchronized across all %d Architectural Wings and all 7 Chromatic/Theological Rows.</div>
      </div>
      <div style="display:flex;gap:0.45rem;flex-wrap:wrap;">
        <a class="sov-pill" href="%s">← Prev: %s</a>
        <span class="sov-pill sov-pill-counter">#%02d / %02d</span>
        <a class="sov-pill sov-pill-master" href="index.html">🏠 Master Index (%d)</a>
        <a class="sov-pill sov-pill-omnibus" href="master-combined-omnibus.html?portal=%s">🧭 Combined Omnibus</a>
        <a class="sov-pill" href="%s">Next: %s →</a>
      </div>
    </div>
    <div class="sov-footer-cols">
      %s
    </div>
  </footer>""",
                totalPortals,
                current.sequenceNumber(),
                totalPortals,
                escapeHtml(current.shortLabel()),
                escapeHtml(current.fileName()),
                byCategory.size(),
                prev.fileName(),
                escapeHtml(prev.shortLabel()),
                current.sequenceNumber(),
                totalPortals,
                totalPortals,
                current.fileName(),
                next.fileName(),
                escapeHtml(next.shortLabel()),
                cols.toString()
        );
    }

    private String renderMasterIndexHtml(List<PortalCatalogEntry> catalog) {
        int totalPortals = catalog.size();

        // 1. Build the 7-Row Cross-Domain Relational Matrix Table
        StringBuilder matrixRows = new StringBuilder();
        String[] sephirahAndMaqam = {
                "",
                "Keter / Sidrat Al-Muntaha (Qur'an 2:102, 53:14)",
                "Hokhmah / Al-Lawh wa Al-Qalam (Qur'an 68:1, 24:22)",
                "Binah / Al-Bayt Al-Ma'mur (Qur'an 6:75-79)",
                "Hesed / Mithaq Al-Alast (Qur'an 7:172, 3:67)",
                "Gevurah / Falak Ash-Shuhub (Qur'an 72:8-9, 25:1)",
                "Tiferet / Qumqum Sulaymani (Qur'an 2:102, 34:12)",
                "Malkhut / Majma' Al-Bahrayn (Qur'an 18:65, 9:108)"
        };

        for (int r = 1; r <= 7; r++) {
            matrixRows.append(String.format("""
                <tr>
                  <td>
                    <span style="display:inline-flex;align-items:center;gap:0.4rem;font-weight:700;color:%s;">
                      <span style="width:12px;height:12px;border-radius:50%%;background:%s;display:inline-block;border:1px solid #FFF;"></span>
                      Row #%d
                    </span>
                    <div style="font-size:0.72rem;color:#94A3B8;margin-top:0.2rem;">%s</div>
                  </td>
                  <td><a class="tbl-link" href="%s">🎨 %s</a></td>
                  <td><a class="tbl-link" href="%s">🏛️ %s</a></td>
                  <td><a class="tbl-link" href="%s">📐 %s</a></td>
                  <td><a class="tbl-link" style="border-color:rgba(244,63,94,0.4);" href="%s">⚠️ %s</a></td>
                  <td><a class="tbl-link" style="border-color:rgba(56,189,248,0.4);" href="%s">🌍 %s</a></td>
                  <td>
                    <a class="tbl-link" style="background:rgba(212,175,55,0.18);color:#FDE68A;" href="master-combined-omnibus.html?portal=%s&amp;compare=%s">
                      🔀 Split Compare Row #%d
                    </a>
                  </td>
                </tr>
                """,
                    ROW_COLORS[r], ROW_COLORS[r], r,
                    escapeHtml(sephirahAndMaqam[r]),
                    ORDER_FILES[r], ORDER_FILES[r],
                    REALM_FILES[r], REALM_FILES[r],
                    PLANE_FILES[r], PLANE_FILES[r],
                    ZALIM_FILES[r], ZALIM_FILES[r],
                    WORLD_FILES[r], WORLD_FILES[r],
                    ORDER_FILES[r], WORLD_FILES[r], r
            ));
        }

        // 2. Build Category Filter Chips & Portal Cards
        Map<String, List<PortalCatalogEntry>> byCategory = new LinkedHashMap<>();
        for (PortalCatalogEntry entry : catalog) {
            byCategory.computeIfAbsent(entry.wingCategory(), k -> new ArrayList<>()).add(entry);
        }

        StringBuilder filterButtons = new StringBuilder();
        filterButtons.append(String.format(
                "<button class=\"cat-btn active\" onclick=\"filterByWing('ALL', this)\">All Portals (%d)</button>",
                totalPortals
        ));
        for (Map.Entry<String, List<PortalCatalogEntry>> cat : byCategory.entrySet()) {
            filterButtons.append(String.format(
                    "<button class=\"cat-btn\" onclick=\"filterByWing('%s', this)\">%s (%d)</button>",
                    escapeAttr(cat.getKey()),
                    escapeHtml(cat.getKey()),
                    cat.getValue().size()
            ));
        }

        StringBuilder wingSections = new StringBuilder();
        for (Map.Entry<String, List<PortalCatalogEntry>> cat : byCategory.entrySet()) {
            StringBuilder cards = new StringBuilder();
            for (PortalCatalogEntry p : cat.getValue()) {
                cards.append(String.format("""
                    <article class="portal-card" data-wing="%s" data-search="%s" style="border-top:4px solid %s;">
                      <div style="display:flex;justify-content:space-between;align-items:center;margin-bottom:0.4rem;">
                        <span class="seq-badge">#%02d / %02d</span>
                        <code style="font-size:0.73rem;color:#38BDF8;">%s</code>
                      </div>
                      <h3 style="font-size:1.02rem;color:#FDE68A;margin-bottom:0.3rem;">%s</h3>
                      <div style="font-family:Consolas,monospace;font-size:0.73rem;color:#34D399;margin-bottom:0.45rem;">%s</div>
                      <p style="font-size:0.82rem;color:#CBD5E1;flex:1;margin-bottom:0.85rem;">%s</p>
                      <div style="display:flex;flex-wrap:wrap;gap:0.4rem;">
                        <a class="card-btn primary" href="%s">Open Full Portal →</a>
                        <button type="button" class="card-btn" onclick="previewPortalInDock('%s', '%s')">👁️ Quick Preview Here</button>
                        <a class="card-btn" href="master-combined-omnibus.html?portal=%s">🧭 Omnibus View</a>
                      </div>
                    </article>
                    """,
                        escapeAttr(cat.getKey()),
                        escapeAttr((p.fileName() + " " + p.shortLabel() + " " + p.title() + " " + p.wingCategory() + " " + p.arabicAndQuranicTag() + " " + p.summary()).toLowerCase()),
                        p.hexAccent(),
                        p.sequenceNumber(),
                        totalPortals,
                        escapeHtml(p.fileName()),
                        escapeHtml(p.title()),
                        escapeHtml(p.arabicAndQuranicTag()),
                        escapeHtml(p.summary()),
                        p.fileName(),
                        escapeAttr(p.fileName()),
                        escapeAttr(p.title()),
                        p.fileName()
                ));
            }

            wingSections.append(String.format("""
                <section class="wing-section" data-wing-section="%s">
                  <h2 class="wing-heading">%s <span style="font-size:0.85rem;color:#94A3B8;font-weight:400;">(%d Portals)</span></h2>
                  <div class="portal-grid">
                    %s
                  </div>
                </section>
                """,
                    escapeAttr(cat.getKey()),
                    escapeHtml(cat.getKey()),
                    cat.getValue().size(),
                    cards.toString()
            ));
        }

        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Sovereign Master Index &amp; Continually Integrated %d-Portal Navigator | Abrahamic &amp; Islamic Architecture</title>
  <style>
    :root {
      --bg-deep: #05070E;
      --bg-card: #0E1424;
      --text-main: #ECEFF4;
      --text-muted: #94A3B8;
      --border: rgba(255,255,255,0.12);
    }
    * { box-sizing: border-box; margin: 0; padding: 0; }
    body {
      background:
        radial-gradient(circle at top left, rgba(212, 175, 55, 0.16), transparent 48%%),
        radial-gradient(circle at top right, rgba(56, 189, 248, 0.14), var(--bg-deep) 68%%);
      color: var(--text-main);
      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
      line-height: 1.6;
      padding-bottom: 4rem;
    }
    main {
      max-width: 1520px;
      margin: 1.6rem auto;
      padding: 0 1.4rem;
    }
    .hero {
      background: linear-gradient(135deg, #0E1424 0%%, #1C1632 52%%, #0B2520 100%%);
      border: 1px solid var(--border);
      border-left: 6px solid #D4AF37;
      border-radius: 14px;
      padding: 1.8rem;
      margin-bottom: 1.6rem;
    }
    .hero h1 { font-size: 1.95rem; margin-bottom: 0.5rem; color: #FFF; }
    .control-panel {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-radius: 14px;
      padding: 1.25rem;
      margin-bottom: 1.6rem;
    }
    .search-row {
      display: flex;
      flex-wrap: wrap;
      gap: 0.75rem;
      margin-bottom: 0.9rem;
    }
    .master-search {
      flex: 1;
      min-width: 280px;
      background: #060913;
      border: 1px solid #D4AF37;
      color: #FFF;
      padding: 0.7rem 1rem;
      border-radius: 10px;
      font-size: 0.92rem;
    }
    .cat-bar {
      display: flex;
      flex-wrap: wrap;
      gap: 0.4rem;
    }
    .cat-btn {
      background: #080C18;
      color: #CBD5E1;
      border: 1px solid var(--border);
      border-radius: 999px;
      padding: 0.35rem 0.78rem;
      font-size: 0.76rem;
      font-weight: 600;
      cursor: pointer;
    }
    .cat-btn.active, .cat-btn:hover {
      background: rgba(212, 175, 55, 0.22);
      border-color: #D4AF37;
      color: #FFF;
    }
    .preview-dock {
      background: #070A14;
      border: 2px solid #38BDF8;
      border-radius: 14px;
      margin-bottom: 1.8rem;
      overflow: hidden;
    }
    .preview-dock-header {
      background: #0E1528;
      padding: 0.7rem 1.1rem;
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
      align-items: center;
      gap: 0.6rem;
      border-bottom: 1px solid var(--border);
    }
    .preview-iframe {
      width: 100%%;
      height: 620px;
      border: none;
      background: #05070E;
    }
    .matrix-box {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-radius: 14px;
      padding: 1.35rem;
      margin-bottom: 1.8rem;
      overflow-x: auto;
    }
    table {
      width: 100%%;
      border-collapse: collapse;
      font-size: 0.82rem;
    }
    th, td {
      border: 1px solid var(--border);
      padding: 0.65rem 0.75rem;
      text-align: left;
      vertical-align: middle;
    }
    th {
      background: rgba(212, 175, 55, 0.12);
      color: #FDE68A;
      font-size: 0.76rem;
      text-transform: uppercase;
    }
    .tbl-link {
      display: inline-block;
      padding: 0.28rem 0.6rem;
      border-radius: 6px;
      background: rgba(255,255,255,0.04);
      border: 1px solid var(--border);
      color: #E2E8F0;
      text-decoration: none;
      font-family: 'Consolas', monospace;
      font-size: 0.75rem;
    }
    .tbl-link:hover {
      border-color: #D4AF37;
      background: rgba(212, 175, 55, 0.2);
      color: #FFF;
    }
    .wing-section { margin-bottom: 2rem; }
    .wing-heading {
      font-size: 1.28rem;
      color: #FDE68A;
      margin-bottom: 0.9rem;
      padding-bottom: 0.35rem;
      border-bottom: 1px solid var(--border);
    }
    .portal-grid {
      display: grid;
      grid-template-columns: repeat(auto-fill, minmax(330px, 1fr));
      gap: 1.1rem;
    }
    .portal-card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-radius: 12px;
      padding: 1.15rem;
      display: flex;
      flex-direction: column;
      transition: transform 0.15s ease, border-color 0.15s ease;
    }
    .portal-card:hover {
      transform: translateY(-2px);
      border-color: #D4AF37;
    }
    .seq-badge {
      background: rgba(212, 175, 55, 0.18);
      border: 1px solid #D4AF37;
      color: #FDE68A;
      font-family: 'Consolas', monospace;
      font-size: 0.72rem;
      font-weight: 700;
      padding: 0.1rem 0.45rem;
      border-radius: 6px;
    }
    .card-btn {
      padding: 0.35rem 0.7rem;
      border-radius: 7px;
      background: rgba(255,255,255,0.05);
      border: 1px solid var(--border);
      color: #E2E8F0;
      text-decoration: none;
      font-size: 0.75rem;
      font-weight: 600;
      cursor: pointer;
    }
    .card-btn.primary {
      background: rgba(212, 175, 55, 0.22);
      border-color: #D4AF37;
      color: #FDE68A;
    }
    .card-btn:hover {
      background: rgba(56, 189, 248, 0.22);
      border-color: #38BDF8;
      color: #FFF;
    }
  </style>
</head>
<body>
  <main>
    <section class="hero">
      <div style="display:flex;flex-wrap:wrap;gap:0.45rem;margin-bottom:0.6rem;">
        <span class="seq-badge"><span data-sov-total>%d</span> INTEGRATED STATIC HTML PORTALS (CONTINUALLY SYNCED)</span>
        <span class="seq-badge" style="border-color:#38BDF8;color:#38BDF8;">%d ARCHITECTURAL WINGS</span>
        <span class="seq-badge" style="border-color:#34D399;color:#34D399;">7-ROW CROSS-DOMAIN RELATIONAL MATRIX</span>
        <span class="seq-badge" style="border-color:#F43F5E;color:#FDA4AF;">CTRL+K GLOBAL PORTAL SWITCHER ON EVERY PAGE</span>
      </div>
      <h1>Sovereign Master Index &amp; Continually Updated <span data-sov-total>%d</span>-Portal Command Atlas</h1>
      <p style="color:#CBD5E1;font-size:0.95rem;margin-bottom:1rem;">
        Welcome to the central command index uniting all <strong><span data-sov-total>%d</span> HTML portals</strong> across the Pre-Prophetic Color Orders,
        the 3D Sanctum &amp; 7 Realms, the Negentropic Priory &amp; 7 Planes, the 7 Wrongdoer (<em>Aẓ-Ẓālimūn</em>) Profiles,
        the 7 Islamic Worlds of Hegemon &amp; Disorder, Ja'far/Aladdin <em>Qumqum</em> Containment &amp; Inter-World Sequesters,
        the Egg-in-Baking Intelocketer, the Warlock Apocrypha, Action-Based Vanguard Husbandry, the Way of the Flower &amp; Rose Garden,
        the Disney/Daffy Animalism Microcosm, the 7 Historical Eras of Islamic Visual Style, the 3D/2.5D Node-Art Terrain Grid,
        Canonical Caravans &amp; Conquest, Greco-Roman Gods &amp; Titans Made Whole, Philosophy &amp; Alchemy, Western Frontier Modesty,
        Canonical Naming &amp; Sewer Economics, the 57 OIC Countries, Caliphates/Sultans/Shahs &amp; Promise of Return,
        the 3-Volume Collegiate Qur'anic Timeline &amp; Properties Thesis (`#58–#60`), the 3-Volume Suite on
        Islam Through the Ages: Global Reception, Philosophical Connotations &amp; Scientific Discoveries Instantiated (`#61–#63`), and
        <strong>Boating, Piracy, Mercantilism, Currency, Maps, Astrolabes, Compasses &amp; Omani/Yemeni Coasting Caliphates (`#64`)</strong>.
      </p>
      <div style="display:flex;flex-wrap:wrap;gap:0.6rem;">
        <a class="card-btn primary" style="padding:0.55rem 1.1rem;font-size:0.86rem;" href="islamic-maritime-boating-piracy-mercantilism-currency-maps-astrolabes-oman-yemen.html">
          ⛵ Portal #64: Maritime, Piracy, Mercantilism, Currency, Maps, Astrolabes &amp; Oman/Yemen →
        </a>
        <a class="card-btn primary" style="padding:0.55rem 1.1rem;font-size:0.86rem;" href="islam-through-ages-vol1-reception-history.html">
          🌍 Vol. I (#61): Islam Through the Ages &amp; Global Reception →
        </a>
        <a class="card-btn primary" style="padding:0.55rem 1.1rem;font-size:0.86rem;" href="islam-through-ages-vol2-philosophical-connotations.html">
          🧠 Vol. II (#62): 7 Philosophical Connotations →
        </a>
        <a class="card-btn primary" style="padding:0.55rem 1.1rem;font-size:0.86rem;" href="islam-through-ages-vol3-scientific-discoveries-instantiated.html">
          🔬 Vol. III (#63): Scientific Discoveries Instantiated →
        </a>
        <a class="card-btn" style="padding:0.55rem 1.1rem;font-size:0.86rem;" href="quranic-timeline-expansion-vol1-chronology.html">
          🎓 Collegiate Thesis Suite (#58–#60)
        </a>
        <a class="card-btn" style="padding:0.55rem 1.1rem;font-size:0.86rem;" href="islamic-caliphates-sultans-shahs-dynasties-return.html">
          👑 Caliphates, Sultans, Shahs &amp; Return (#57)
        </a>
        <a class="card-btn" style="padding:0.55rem 1.1rem;font-size:0.86rem;" href="conjoined-worlds-realms-principles-node-grid.html">
          ⛰️ 3D/2.5D Node-Art Terrain Grid (#50)
        </a>
        <a class="card-btn" style="padding:0.55rem 1.1rem;font-size:0.86rem;" href="master-combined-omnibus.html">
          🧭 Combined Multi-Portal Omnibus (%d Portals)
        </a>
      </div>
    </section>

    <section class="matrix-box">
      <h2 style="font-size:1.25rem;color:#FDE68A;margin-bottom:0.35rem;">
        I. The 7-Row Cross-Domain Relational Matrix (Orders #1..#7 Integrated Across All 5 Series)
      </h2>
      <p style="font-size:0.84rem;color:#CBD5E1;margin-bottom:0.85rem;">
        Every row <code>#1..#7</code> connects its Color Order, Celestial Realm, Existential Plane, Wrongdoer Counterfeit (<em>Aẓ-Ẓālimūn</em>),
        and Islamic Bipolar World. Click any cell to jump directly, or click <strong>Split Compare</strong> to view both poles side-by-side.
      </p>
      <table>
        <thead>
          <tr>
            <th>Row &amp; Color Axis</th>
            <th>1. Pre-Prophetic Order</th>
            <th>2. Celestial Realm</th>
            <th>3. Plane &amp; Priory Seat</th>
            <th>4. Wrongdoer (Zalim) Profile</th>
            <th>5. Islamic Bipolar World</th>
            <th>Combined Split View</th>
          </tr>
        </thead>
        <tbody>
          %s
        </tbody>
      </table>
    </section>

    <section id="livePreviewDock" class="preview-dock">
      <div class="preview-dock-header">
        <div>
          <span style="font-family:Consolas,monospace;font-size:0.75rem;color:#38BDF8;">LIVE EMBEDDED PORTAL WORKSPACE (CONTINUALLY UPDATED)</span>
          <strong id="dockTitle" style="margin-left:0.6rem;color:#FDE68A;">islamic-maritime-boating-piracy-mercantilism-currency-maps-astrolabes-oman-yemen.html — #64 / %d: Boating, Piracy, Mercantilism, Currency, Maps, Astrolabes, Compasses &amp; Omani/Yemeni Coasting Caliphates</strong>
        </div>
        <div style="display:flex;gap:0.45rem;">
          <a id="dockFullLink" class="card-btn primary" href="islamic-maritime-boating-piracy-mercantilism-currency-maps-astrolabes-oman-yemen.html">Open Standalone Page ↗</a>
          <button type="button" class="card-btn" onclick="toggleDockHeight()">↕ Expand/Collapse Height</button>
        </div>
      </div>
      <iframe id="dockIframe" class="preview-iframe" style="height:740px;" src="islamic-maritime-boating-piracy-mercantilism-currency-maps-astrolabes-oman-yemen.html" title="Embedded Portal Preview"></iframe>
    </section>

    <section class="control-panel">
      <div class="search-row">
        <input id="masterSearchInput" class="master-search" type="text" placeholder="Search all %d HTML portals by title, filename, Qur'anic verse, philosopher, scientist, Arabic root, color hex, or theme..." oninput="applyMasterFilter()">
      </div>
      <div class="cat-bar">
        %s
      </div>
    </section>

    <div id="wingsContainer">
      %s
    </div>
  </main>

  <script>
    let activeWing = 'ALL';
    let dockExpanded = false;

    function filterByWing(wing, btn) {
      activeWing = wing;
      document.querySelectorAll('.cat-btn').forEach(b => b.classList.remove('active'));
      btn.classList.add('active');
      applyMasterFilter();
    }

    function applyMasterFilter() {
      const q = (document.getElementById('masterSearchInput').value || '').toLowerCase().trim();
      document.querySelectorAll('.wing-section').forEach(sec => {
        const wingName = sec.getAttribute('data-wing-section');
        const wingMatch = (activeWing === 'ALL' || activeWing === wingName);
        let visibleCount = 0;
        sec.querySelectorAll('.portal-card').forEach(card => {
          const hay = card.getAttribute('data-search') || '';
          const match = wingMatch && (!q || hay.includes(q));
          card.style.display = match ? 'flex' : 'none';
          if (match) visibleCount++;
        });
        sec.style.display = visibleCount > 0 ? 'block' : 'none';
      });
    }

    function previewPortalInDock(fileName, title) {
      const iframe = document.getElementById('dockIframe');
      const titleEl = document.getElementById('dockTitle');
      const fullLink = document.getElementById('dockFullLink');
      iframe.src = fileName;
      titleEl.textContent = fileName + ' — ' + title;
      fullLink.href = fileName;
      document.getElementById('livePreviewDock').scrollIntoView({ behavior: 'smooth', block: 'start' });
    }

    function toggleDockHeight() {
      dockExpanded = !dockExpanded;
      document.getElementById('dockIframe').style.height = dockExpanded ? '960px' : '620px';
    }
  </script>
</body>
</html>
""".formatted(
                totalPortals,
                totalPortals,
                byCategory.size(),
                totalPortals,
                totalPortals,
                totalPortals,
                matrixRows.toString(),
                totalPortals,
                totalPortals,
                filterButtons.toString(),
                wingSections.toString()
        );
    }

    private String renderCombinedOmnibusHtml(List<PortalCatalogEntry> catalog) {
        int totalPortals = catalog.size();
        Map<String, List<PortalCatalogEntry>> byCategory = new LinkedHashMap<>();
        for (PortalCatalogEntry entry : catalog) {
            byCategory.computeIfAbsent(entry.wingCategory(), k -> new ArrayList<>()).add(entry);
        }

        StringBuilder sidebarGroups = new StringBuilder();
        StringBuilder selectOptions = new StringBuilder();
        StringBuilder jsCatalogArray = new StringBuilder();

        for (Map.Entry<String, List<PortalCatalogEntry>> cat : byCategory.entrySet()) {
            sidebarGroups.append("<div class=\"tree-group\">");
            sidebarGroups.append("<div class=\"tree-cat-title\">").append(escapeHtml(cat.getKey())).append("</div>");
            for (PortalCatalogEntry p : cat.getValue()) {
                sidebarGroups.append(String.format(
                        "<button type=\"button\" class=\"tree-item\" id=\"tree-%d\" data-file=\"%s\" data-search=\"%s\" onclick=\"selectPrimaryPortal('%s')\">"
                                + "<span class=\"tree-seq\" style=\"border-color:%s;\">#%02d/%02d</span>"
                                + "<span class=\"tree-text\"><strong>%s</strong><small>%s</small></span>"
                                + "</button>",
                        p.sequenceNumber(),
                        escapeAttr(p.fileName()),
                        escapeAttr((p.fileName() + " " + p.shortLabel() + " " + p.title() + " " + p.arabicAndQuranicTag()).toLowerCase()),
                        escapeAttr(p.fileName()),
                        p.hexAccent(),
                        p.sequenceNumber(),
                        totalPortals,
                        escapeHtml(p.shortLabel()),
                        escapeHtml(p.fileName())
                ));
                selectOptions.append(String.format(
                        "<option value=\"%s\">#%02d / %02d — %s (%s)</option>",
                        escapeAttr(p.fileName()),
                        p.sequenceNumber(),
                        totalPortals,
                        escapeHtml(p.shortLabel()),
                        escapeHtml(p.fileName())
                ));
                jsCatalogArray.append(String.format(
                        "{seq:%d,file:\"%s\",short:\"%s\",title:\"%s\",tag:\"%s\"},\n",
                        p.sequenceNumber(),
                        escapeAttr(p.fileName()),
                        escapeAttr(p.shortLabel()),
                        escapeAttr(p.title()),
                        escapeAttr(p.arabicAndQuranicTag())
                ));
            }
            sidebarGroups.append("</div>");
        }

        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Combined Multi-Portal Omnibus Workspace | All %d HTML Portals Continually Integrated</title>
  <style>
    :root {
      --bg-deep: #04060C;
      --bg-panel: #0B101E;
      --border: rgba(255,255,255,0.12);
    }
    * { box-sizing: border-box; margin: 0; padding: 0; }
    body {
      background: var(--bg-deep);
      color: #ECEFF4;
      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
    }
    .omnibus-shell {
      display: grid;
      grid-template-columns: 340px 1fr;
      min-height: calc(100vh - 95px);
    }
    @media (max-width: 980px) {
      .omnibus-shell { grid-template-columns: 1fr; }
    }
    .omnibus-sidebar {
      background: var(--bg-panel);
      border-right: 1px solid var(--border);
      display: flex;
      flex-direction: column;
      max-height: calc(100vh - 95px);
      position: sticky;
      top: 0;
    }
    .sidebar-top {
      padding: 0.85rem;
      border-bottom: 1px solid var(--border);
    }
    .sidebar-search {
      width: 100%%;
      background: #050811;
      border: 1px solid #D4AF37;
      color: #FFF;
      padding: 0.5rem 0.75rem;
      border-radius: 8px;
      font-size: 0.82rem;
    }
    .tree-scroll {
      overflow-y: auto;
      padding: 0.65rem;
      flex: 1;
    }
    .tree-group { margin-bottom: 0.9rem; }
    .tree-cat-title {
      font-size: 0.7rem;
      font-weight: 700;
      text-transform: uppercase;
      color: #FDE68A;
      letter-spacing: 0.04em;
      margin-bottom: 0.35rem;
      padding: 0 0.25rem;
    }
    .tree-item {
      width: 100%%;
      display: flex;
      align-items: center;
      gap: 0.5rem;
      background: rgba(255,255,255,0.02);
      border: 1px solid transparent;
      border-radius: 7px;
      padding: 0.4rem 0.55rem;
      color: #CBD5E1;
      text-align: left;
      cursor: pointer;
      margin-bottom: 0.22rem;
    }
    .tree-item:hover, .tree-item.active {
      background: rgba(212, 175, 55, 0.18);
      border-color: #D4AF37;
      color: #FFF;
    }
    .tree-seq {
      font-family: 'Consolas', monospace;
      font-size: 0.68rem;
      border-left: 3px solid #D4AF37;
      padding-left: 0.35rem;
      color: #FDE68A;
      font-weight: 700;
    }
    .tree-text {
      display: flex;
      flex-direction: column;
      overflow: hidden;
    }
    .tree-text strong { font-size: 0.78rem; white-space: nowrap; overflow: hidden; text-overflow: ellipsis; }
    .tree-text small { font-family: 'Consolas', monospace; font-size: 0.67rem; color: #38BDF8; }
    .omnibus-stage {
      display: flex;
      flex-direction: column;
      background: #05070E;
    }
    .stage-toolbar {
      background: #0D1324;
      border-bottom: 1px solid var(--border);
      padding: 0.65rem 1.1rem;
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
      align-items: center;
      gap: 0.6rem;
    }
    .stage-btn {
      background: #162038;
      border: 1px solid var(--border);
      color: #E2E8F0;
      padding: 0.35rem 0.75rem;
      border-radius: 7px;
      font-size: 0.76rem;
      font-weight: 600;
      cursor: pointer;
      text-decoration: none;
    }
    .stage-btn.active, .stage-btn:hover {
      border-color: #D4AF37;
      background: rgba(212, 175, 55, 0.22);
      color: #FFF;
    }
    .stage-select {
      background: #060913;
      border: 1px solid #38BDF8;
      color: #FFF;
      padding: 0.35rem 0.65rem;
      border-radius: 7px;
      font-size: 0.78rem;
    }
    .viewports-grid {
      display: grid;
      grid-template-columns: 1fr;
      flex: 1;
      min-height: 82vh;
    }
    .viewports-grid.split-mode {
      grid-template-columns: 1fr 1fr;
    }
    .pane-wrap {
      display: flex;
      flex-direction: column;
      border-right: 1px solid var(--border);
    }
    .pane-bar {
      background: #080C18;
      padding: 0.4rem 0.85rem;
      font-size: 0.76rem;
      display: flex;
      justify-content: space-between;
      align-items: center;
      border-bottom: 1px solid var(--border);
    }
    .pane-iframe {
      width: 100%%;
      flex: 1;
      min-height: 78vh;
      border: none;
      background: #05070E;
    }
  </style>
</head>
<body>
  <div class="omnibus-shell">
    <aside class="omnibus-sidebar">
      <div class="sidebar-top">
        <div style="font-family:Consolas,monospace;font-size:0.7rem;color:#FDE68A;margin-bottom:0.35rem;">
          COMBINED OMNIBUS NAVIGATOR (<span data-sov-total>%d</span> PORTALS)
        </div>
        <input id="treeSearchInput" class="sidebar-search" type="text" placeholder="Filter all %d portals..." oninput="filterTree(this.value)">
      </div>
      <div id="treeContainer" class="tree-scroll">
        %s
      </div>
    </aside>

    <section class="omnibus-stage">
      <div class="stage-toolbar">
        <div style="display:flex;flex-wrap:wrap;align-items:center;gap:0.45rem;">
          <button type="button" class="stage-btn" onclick="stepPrimary(-1)">◀ Prev Portal</button>
          <select id="primarySelect" class="stage-select" onchange="selectPrimaryPortal(this.value)">
            %s
          </select>
          <button type="button" class="stage-btn" onclick="stepPrimary(1)">Next Portal ▶</button>
          <span id="omnibusLiveBadge" class="stage-btn" style="border-color:#D4AF37;color:#FDE68A;font-family:Consolas,monospace;">#%02d / %02d</span>
          <a id="primaryStandaloneBtn" class="stage-btn" href="islam-through-ages-vol3-scientific-discoveries-instantiated.html">Open Standalone ↗</a>
        </div>

        <div style="display:flex;flex-wrap:wrap;align-items:center;gap:0.45rem;">
          <button type="button" id="omnibusAutoPlayBtn" class="stage-btn" onclick="toggleOmnibusAutoPlay()">🔄 Continual Auto-Play</button>
          <button type="button" id="splitToggleBtn" class="stage-btn" onclick="toggleSplitMode()">🔀 Enable Side-by-Side Split Compare</button>
          <select id="secondarySelect" class="stage-select" style="display:none;" onchange="selectSecondaryPortal(this.value)">
            %s
          </select>
        </div>
      </div>

      <div id="viewportsGrid" class="viewports-grid">
        <div class="pane-wrap">
          <div class="pane-bar">
            <span id="primaryPaneLabel" style="color:#FDE68A;font-weight:700;">Primary Portal</span>
            <code id="primaryPaneFile" style="color:#38BDF8;">islam-through-ages-vol3-scientific-discoveries-instantiated.html</code>
          </div>
          <iframe id="primaryFrame" class="pane-iframe" src="islam-through-ages-vol3-scientific-discoveries-instantiated.html" title="Primary Omnibus Viewport"></iframe>
        </div>

        <div id="secondaryPane" class="pane-wrap" style="display:none;">
          <div class="pane-bar">
            <span id="secondaryPaneLabel" style="color:#34D399;font-weight:700;">Comparison Portal</span>
            <code id="secondaryPaneFile" style="color:#38BDF8;">islam-through-ages-vol2-philosophical-connotations.html</code>
          </div>
          <iframe id="secondaryFrame" class="pane-iframe" src="islam-through-ages-vol2-philosophical-connotations.html" title="Secondary Comparison Viewport"></iframe>
        </div>
      </div>
    </section>
  </div>

  <script>
    const CATALOG = [
      %s
    ];
    let currentIdx = CATALOG.length - 1;
    let splitActive = false;
    let omnibusTimer = null;

    function selectPrimaryPortal(fileName) {
      const idx = CATALOG.findIndex(x => x.file === fileName);
      if (idx >= 0) currentIdx = idx;
      const item = CATALOG[currentIdx];
      document.getElementById('primaryFrame').src = item.file;
      document.getElementById('primarySelect').value = item.file;
      document.getElementById('primaryStandaloneBtn').href = item.file;
      const totalStr = String(CATALOG.length).padStart(2, '0');
      const seqStr = String(item.seq).padStart(2, '0');
      document.getElementById('primaryPaneLabel').textContent = '#' + seqStr + ' / ' + totalStr + ' — ' + item.title;
      document.getElementById('primaryPaneFile').textContent = item.file;
      const liveBadge = document.getElementById('omnibusLiveBadge');
      if (liveBadge) liveBadge.textContent = '#' + seqStr + ' / ' + totalStr;

      document.querySelectorAll('.tree-item').forEach(btn => {
        btn.classList.toggle('active', btn.getAttribute('data-file') === item.file);
      });
    }

    function selectSecondaryPortal(fileName) {
      const item = CATALOG.find(x => x.file === fileName) || CATALOG[0];
      const totalStr = String(CATALOG.length).padStart(2, '0');
      const seqStr = String(item.seq).padStart(2, '0');
      document.getElementById('secondaryFrame').src = item.file;
      document.getElementById('secondarySelect').value = item.file;
      document.getElementById('secondaryPaneLabel').textContent = '#' + seqStr + ' / ' + totalStr + ' — ' + item.title;
      document.getElementById('secondaryPaneFile').textContent = item.file;
    }

    function stepPrimary(delta) {
      currentIdx = (currentIdx + delta + CATALOG.length) %% CATALOG.length;
      selectPrimaryPortal(CATALOG[currentIdx].file);
    }

    function toggleOmnibusAutoPlay() {
      const btn = document.getElementById('omnibusAutoPlayBtn');
      if (omnibusTimer) {
        clearInterval(omnibusTimer);
        omnibusTimer = null;
        btn.classList.remove('active');
        btn.textContent = '🔄 Continual Auto-Play';
      } else {
        btn.classList.add('active');
        btn.textContent = '⏸ Pause Continual Auto-Play';
        omnibusTimer = setInterval(() => stepPrimary(1), 5000);
      }
    }

    function toggleSplitMode(forceState) {
      splitActive = (typeof forceState === 'boolean') ? forceState : !splitActive;
      const grid = document.getElementById('viewportsGrid');
      const secPane = document.getElementById('secondaryPane');
      const secSel = document.getElementById('secondarySelect');
      const btn = document.getElementById('splitToggleBtn');
      grid.classList.toggle('split-mode', splitActive);
      secPane.style.display = splitActive ? 'flex' : 'none';
      secSel.style.display = splitActive ? 'inline-block' : 'none';
      btn.classList.toggle('active', splitActive);
      btn.textContent = splitActive ? '✕ Close Split Compare' : '🔀 Enable Side-by-Side Split Compare';
    }

    function filterTree(q) {
      const query = (q || '').toLowerCase().trim();
      document.querySelectorAll('#treeContainer .tree-item').forEach(btn => {
        const hay = btn.getAttribute('data-search') || '';
        btn.style.display = (!query || hay.includes(query)) ? 'flex' : 'none';
      });
    }

    (function initFromQuery() {
      const params = new URLSearchParams(window.location.search);
      const p = params.get('portal');
      const c = params.get('compare');
      if (p && CATALOG.some(x => x.file === p)) {
        selectPrimaryPortal(p);
      } else {
        selectPrimaryPortal(CATALOG[CATALOG.length - 1].file);
      }
      if (c && CATALOG.some(x => x.file === c)) {
        toggleSplitMode(true);
        selectSecondaryPortal(c);
      }
    })();
  </script>
</body>
</html>
""".formatted(
                totalPortals,
                totalPortals,
                totalPortals,
                sidebarGroups.toString(),
                selectOptions.toString(),
                totalPortals,
                totalPortals,
                selectOptions.toString(),
                jsCatalogArray.toString()
        );
    }

    private static String escapeHtml(String s) {
        if (s == null) {
            return "";
        }
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }

    private static String escapeAttr(String s) {
        return escapeHtml(s).replace("'", "&#39;");
    }

    private static String sha256(String content) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return HexFormat.of().formatHex(md.digest(content.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 unavailable", e);
        }
    }
}
