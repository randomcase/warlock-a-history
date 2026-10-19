package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.IslamicSingleCastleRpgCaravanSiegeGameAtlas;
import com.sovereign.warlock.domain.IslamicSingleCastleRpgCaravanSiegeGameAtlas.CharacterArchetypeProfile;
import com.sovereign.warlock.domain.IslamicSingleCastleRpgCaravanSiegeGameAtlas.CommodityAndStrongholdDutyDossier;
import com.sovereign.warlock.domain.IslamicSingleCastleRpgCaravanSiegeGameAtlas.PolyglotStorageFormatDossier;
import com.sovereign.warlock.domain.IslamicSingleCastleRpgCaravanSiegeGameAtlas.RumoredKingAndSyndicationDossier;
import com.sovereign.warlock.domain.IslamicSingleCastleRpgCaravanSiegeGameAtlas.ThroneRoomDepartmentDossier;
import com.sovereign.warlock.service.MasterNavigationAndIndexGenerator.PortalCatalogEntry;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.List;

/**
 * Generates Portal #68 (islamic-single-castle-25d-rpg-caravan-siege-314-studio-game.html):
 * The Unified Single-Castle 2.5D/3D Sprite RPG, Caravan & Port Logistics, Castle Siege,
 * 6-Mode Automated Wargame, 67-Tome Castle Library & 12-Format Polyglot 3.14 Studio Game Launch Portal.
 */
public final class IslamicSingleCastleRpgCaravanSiegeGamePortalGenerator {

    public static final String PORTAL_FILE_NAME =
            "islamic-single-castle-25d-rpg-caravan-siege-314-studio-game.html";

    public WarlockHtmlPortalService.GeneratedHtmlArtifact generatePortal(Path outputDir) {
        try {
            Files.createDirectories(outputDir);
            String html = buildPortalHtml();
            Path filePath = outputDir.resolve(PORTAL_FILE_NAME);
            Files.writeString(filePath, html, StandardCharsets.UTF_8);
            return new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                    PORTAL_FILE_NAME,
                    filePath,
                    Files.size(filePath),
                    sha256(html),
                    "Portal #68: Sovereign Single-Castle 2.5D/3D Sprite RPG, Caravan & Port Logistics (Vinegar, Cotton, Tobacco, Maps, Compasses), 6-Mode Castle Siege Wargame, Good Warlock Uncapped Idle Engine, 67-Tome Castle Library & 12-Format 3.14 Studio"
            );
        } catch (IOException e) {
            throw new IllegalStateException("Failed generating Portal #68 (" + PORTAL_FILE_NAME + ")", e);
        }
    }

    private String buildPortalHtml() {
        List<CharacterArchetypeProfile> profiles =
                IslamicSingleCastleRpgCaravanSiegeGameAtlas.allTwelveArchetypeCharacterProfiles();
        List<ThroneRoomDepartmentDossier> departments =
                IslamicSingleCastleRpgCaravanSiegeGameAtlas.allSixThroneRoomDepartments();
        List<CommodityAndStrongholdDutyDossier> commodities =
                IslamicSingleCastleRpgCaravanSiegeGameAtlas.allEightCanonicalCommoditiesAndDuties();
        List<RumoredKingAndSyndicationDossier> kings =
                IslamicSingleCastleRpgCaravanSiegeGameAtlas.allEightRumoredKingsAndSyndications();
        List<PolyglotStorageFormatDossier> formats =
                IslamicSingleCastleRpgCaravanSiegeGameAtlas.allTwelvePolyglotStorageFormats();
        List<PortalCatalogEntry> allPortals =
                MasterNavigationAndIndexGenerator.allCatalogEntries();

        StringBuilder sb = new StringBuilder(320_000);
        sb.append(buildHeadAndStyles());
        sb.append(buildTopIncrementalHudAndHero());
        sb.append(buildMain25dInteractiveCanvasAndThroneRoom(departments));
        sb.append(buildCaravanBazaarAndDiplomacySection(commodities, kings));
        sb.append(build11VectorCharacterProfilesAnd314Studio(profiles, formats));
        sb.append(buildGrandCastleLibrary67TomesSection(allPortals));
        sb.append(buildEmbeddedJsonDataScript(profiles, commodities, kings, allPortals));
        sb.append(buildGameEngineScriptPart1());
        sb.append(buildGameEngineScriptPart2());
        return sb.toString();
    }

    private String buildHeadAndStyles() {
        return """
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Portal #68 — The Single-Castle 2.5D/3D Sprite RPG, Caravan Logistics, Castle Siege &amp; 3.14 π Studio Game (313 of Badr to the 7 Realms)</title>
  <style>
    :root {
      --bg-abyss: #050811;
      --bg-panel: #0B1222;
      --bg-card: #111A2E;
      --bg-elevated: #17233D;
      --gold: #D4AF37;
      --gold-light: #FDE68A;
      --emerald: #10B981;
      --emerald-light: #6EE7B7;
      --sapphire: #38BDF8;
      --crimson: #F43F5E;
      --purple: #A78BFA;
      --brass: #D97706;
      --text-main: #F8FAFC;
      --text-muted: #94A3B8;
      --border-gold: rgba(212, 175, 55, 0.35);
      --pi-glow: 0 0 22px rgba(212, 175, 55, 0.25);
    }
    * { box-sizing: border-box; }
    body {
      margin: 0;
      background: radial-gradient(circle at 50% 0%, #101D38 0%, #050811 70%);
      color: var(--text-main);
      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
      line-height: 1.55;
    }
    /* Sticky Uncapped Incremental & Idle Power HUD */
    .hud-sticky-bar {
      position: sticky;
      top: 0;
      z-index: 9500;
      background: linear-gradient(90deg, rgba(5,8,17,0.97) 0%, rgba(15,25,48,0.97) 50%, rgba(5,8,17,0.97) 100%);
      border-bottom: 2px solid var(--gold);
      backdrop-filter: blur(10px);
      padding: 0.55rem 1.2rem;
      box-shadow: 0 8px 28px rgba(0,0,0,0.75);
    }
    .hud-inner {
      max-width: 1640px;
      margin: 0 auto;
      display: flex;
      flex-wrap: wrap;
      align-items: center;
      justify-content: space-between;
      gap: 0.55rem;
    }
    .hud-metric {
      display: flex;
      align-items: center;
      gap: 0.45rem;
      background: rgba(17, 26, 46, 0.92);
      border: 1px solid var(--border-gold);
      border-radius: 8px;
      padding: 0.3rem 0.68rem;
      font-size: 0.78rem;
    }
    .hud-metric-label {
      color: var(--text-muted);
      font-size: 0.68rem;
      text-transform: uppercase;
      letter-spacing: 0.05em;
    }
    .hud-metric-val {
      color: var(--gold-light);
      font-family: 'Consolas', monospace;
      font-weight: 700;
      font-size: 0.88rem;
    }
    .hud-metric-rate {
      color: var(--emerald-light);
      font-family: 'Consolas', monospace;
      font-size: 0.72rem;
    }
    .container {
      max-width: 1640px;
      margin: 0 auto;
      padding: 1.4rem;
    }
    .hero-banner {
      background: linear-gradient(135deg, rgba(17,26,46,0.95) 0%, rgba(10,35,42,0.92) 55%, rgba(28,17,36,0.95) 100%);
      border: 2px solid var(--gold);
      border-radius: 16px;
      padding: 1.6rem 2rem;
      box-shadow: var(--pi-glow);
      margin-bottom: 1.5rem;
      position: relative;
      overflow: hidden;
    }
    .hero-badges {
      display: flex;
      flex-wrap: wrap;
      gap: 0.45rem;
      margin-bottom: 0.75rem;
    }
    .badge {
      display: inline-flex;
      align-items: center;
      gap: 0.35rem;
      padding: 0.25rem 0.7rem;
      border-radius: 999px;
      font-size: 0.74rem;
      font-weight: 700;
      border: 1px solid rgba(255,255,255,0.2);
      background: rgba(15, 23, 42, 0.85);
    }
    .badge-gold { border-color: var(--gold); color: var(--gold-light); background: rgba(212,175,55,0.16); }
    .badge-emerald { border-color: var(--emerald); color: var(--emerald-light); background: rgba(16,185,129,0.16); }
    .badge-sapphire { border-color: var(--sapphire); color: #BAE6FD; background: rgba(56,189,248,0.16); }
    .badge-crimson { border-color: var(--crimson); color: #FECDD3; background: rgba(244,63,94,0.16); }
    .badge-purple { border-color: var(--purple); color: #DDD6FE; background: rgba(167,139,250,0.16); }
    h1 {
      margin: 0 0 0.5rem 0;
      font-size: 2rem;
      background: linear-gradient(90deg, #FFFFFF 0%, #FDE68A 50%, #6EE7B7 100%);
      -webkit-background-clip: text;
      -webkit-text-fill-color: transparent;
    }
    .arabic-sub {
      font-size: 1.18rem;
      color: var(--gold-light);
      font-weight: 600;
      margin-bottom: 0.65rem;
    }
    .plates-grid-4 {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(350px, 1fr));
      gap: 1rem;
      margin-bottom: 1.5rem;
    }
    .plate-card {
      background: var(--bg-card);
      border: 1px solid var(--border-gold);
      border-radius: 12px;
      overflow: hidden;
      display: flex;
      flex-direction: column;
    }
    .plate-card img {
      width: 100%;
      height: 230px;
      object-fit: cover;
      border-bottom: 1px solid var(--border-gold);
      cursor: pointer;
      transition: transform 0.25s ease;
    }
    .plate-card img:hover { transform: scale(1.02); }
    .plate-body { padding: 0.85rem 1rem; font-size: 0.83rem; }
    .plate-title { color: var(--gold-light); font-weight: 700; font-size: 0.94rem; margin-bottom: 0.25rem; }
    /* Main Game Workspace Grid */
    .game-workspace {
      display: grid;
      grid-template-columns: 1.55fr 1fr;
      gap: 1.2rem;
      margin-bottom: 1.6rem;
    }
    @media (max-width: 1220px) {
      .game-workspace { grid-template-columns: 1fr; }
    }
    .panel {
      background: var(--bg-panel);
      border: 1px solid var(--border-gold);
      border-radius: 14px;
      padding: 1.15rem;
      box-shadow: 0 10px 30px rgba(0,0,0,0.45);
    }
    .panel-header {
      display: flex;
      flex-wrap: wrap;
      align-items: center;
      justify-content: space-between;
      gap: 0.6rem;
      border-bottom: 1px solid rgba(212,175,55,0.24);
      padding-bottom: 0.7rem;
      margin-bottom: 0.9rem;
    }
    .panel-title {
      font-size: 1.15rem;
      font-weight: 700;
      color: var(--gold-light);
      margin: 0;
    }
    .btn-row {
      display: flex;
      flex-wrap: wrap;
      gap: 0.4rem;
    }
    .btn {
      background: linear-gradient(135deg, #1E293B, #0F172A);
      color: #F8FAFC;
      border: 1px solid var(--border-gold);
      border-radius: 8px;
      padding: 0.42rem 0.78rem;
      font-size: 0.78rem;
      font-weight: 600;
      cursor: pointer;
      transition: all 0.15s ease;
    }
    .btn:hover, .btn.active {
      background: linear-gradient(135deg, rgba(212,175,55,0.32), rgba(16,185,129,0.28));
      border-color: var(--gold);
      color: #FFFFFF;
      box-shadow: 0 0 12px rgba(212,175,55,0.35);
    }
    .btn-emerald {
      background: linear-gradient(135deg, rgba(16,185,129,0.28), rgba(6,95,70,0.5));
      border-color: var(--emerald);
      color: var(--emerald-light);
    }
    .btn-crimson {
      background: linear-gradient(135deg, rgba(244,63,94,0.28), rgba(136,19,55,0.5));
      border-color: var(--crimson);
      color: #FDA4AF;
    }
    .btn-sapphire {
      background: linear-gradient(135deg, rgba(56,189,248,0.28), rgba(12,74,110,0.5));
      border-color: var(--sapphire);
      color: #BAE6FD;
    }
    /* Canvas Viewport */
    .canvas-wrap {
      position: relative;
      background: #04070F;
      border: 2px solid var(--gold);
      border-radius: 12px;
      overflow: hidden;
    }
    #sovereign25dGameCanvas {
      display: block;
      width: 100%;
      height: 590px;
      cursor: crosshair;
    }
    .canvas-overlay-top {
      position: absolute;
      top: 10px;
      left: 10px;
      right: 10px;
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
      gap: 0.5rem;
      pointer-events: none;
    }
    .canvas-pill {
      pointer-events: auto;
      background: rgba(5, 8, 17, 0.86);
      border: 1px solid var(--border-gold);
      border-radius: 8px;
      padding: 0.3rem 0.65rem;
      font-size: 0.74rem;
      font-family: 'Consolas', monospace;
      color: var(--gold-light);
    }
    /* Tabs & Cards */
    .sub-grid-2 {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
      gap: 0.85rem;
    }
    .sub-grid-3 {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(320px, 1fr));
      gap: 0.95rem;
    }
    .sub-card {
      background: var(--bg-card);
      border: 1px solid rgba(212,175,55,0.22);
      border-radius: 10px;
      padding: 0.85rem;
      font-size: 0.82rem;
    }
    .sub-card h4 {
      margin: 0 0 0.4rem 0;
      color: var(--gold-light);
      font-size: 0.94rem;
    }
    .slider-row {
      display: flex;
      align-items: center;
      justify-content: space-between;
      gap: 0.6rem;
      margin: 0.42rem 0;
      font-size: 0.78rem;
    }
    .slider-row input[type="range"] {
      flex: 1;
      accent-color: var(--gold);
    }
    .pi-val {
      font-family: 'Consolas', monospace;
      color: var(--emerald-light);
      font-weight: 700;
      min-width: 58px;
      text-align: right;
    }
    .combat-log-box {
      background: #04070E;
      border: 1px solid rgba(56,189,248,0.3);
      border-radius: 8px;
      padding: 0.65rem;
      height: 185px;
      overflow-y: auto;
      font-family: 'Consolas', monospace;
      font-size: 0.74rem;
      color: #E2E8F0;
    }
    .log-entry { margin-bottom: 0.28rem; border-bottom: 1px dashed rgba(255,255,255,0.07); padding-bottom: 0.2rem; }
    .code-studio-area {
      width: 100%;
      height: 290px;
      background: #04070E;
      color: #6EE7B7;
      border: 1px solid var(--gold);
      border-radius: 10px;
      padding: 0.85rem;
      font-family: 'Consolas', monospace;
      font-size: 0.78rem;
      resize: vertical;
    }
    .data-table-wrap {
      overflow-x: auto;
      margin-top: 0.8rem;
    }
    table.sov-table {
      width: 100%;
      border-collapse: collapse;
      font-size: 0.78rem;
    }
    table.sov-table th, table.sov-table td {
      border: 1px solid rgba(212,175,55,0.22);
      padding: 0.55rem 0.65rem;
      text-align: left;
      vertical-align: top;
    }
    table.sov-table th {
      background: rgba(212,175,55,0.14);
      color: var(--gold-light);
      font-weight: 700;
    }
    table.sov-table tr:nth-child(even) {
      background: rgba(17,26,46,0.55);
    }
    .tome-grid {
      display: grid;
      grid-template-columns: repeat(auto-fill, minmax(290px, 1fr));
      gap: 0.75rem;
      max-height: 640px;
      overflow-y: auto;
      padding-right: 0.35rem;
    }
    .tome-card {
      background: var(--bg-card);
      border: 1px solid rgba(212,175,55,0.25);
      border-radius: 10px;
      padding: 0.75rem;
      font-size: 0.78rem;
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      transition: border-color 0.15s ease;
    }
    .tome-card.illuminated {
      border-color: var(--emerald);
      background: linear-gradient(135deg, rgba(16,185,129,0.12), rgba(17,26,46,0.95));
    }
    .section-divider {
      margin: 2rem 0 1.2rem 0;
      border-bottom: 2px solid var(--gold);
      padding-bottom: 0.5rem;
      display: flex;
      flex-wrap: wrap;
      align-items: center;
      justify-content: space-between;
    }
  </style>
</head>
<body>
""";
    }

    private String buildTopIncrementalHudAndHero() {
        return """
  <!-- Sticky Uncapped Idle & Incremental Sovereign Telemetry Bar -->
  <div class="hud-sticky-bar">
    <div class="hud-inner">
      <div class="hud-metric" title="Uncapped Idle &amp; Active Negentropic Power of the Good Warlock Devoted to Islam">
        <div>
          <div class="hud-metric-label">Good Warlock Barakah (Uncapped π)</div>
          <div><span id="hudBarakahVal" class="hud-metric-val">314.00 π</span> <span id="hudBarakahRate" class="hud-metric-rate">(+9.42/s)</span></div>
        </div>
      </div>
      <div class="hud-metric" title="Starts at 313 Companions of Badr + 1 Sovereign Anchor = 314; grows via Da'wah, Caravan Absorption &amp; Patronage">
        <div>
          <div class="hud-metric-label">Ummah Autonomous Nodes (313+1 Anchor)</div>
          <div><span id="hudUmmahPop" class="hud-metric-val">314</span> <span id="hudUmmahRate" class="hud-metric-rate">(100% Active)</span></div>
        </div>
      </div>
      <div class="hud-metric" title="Bayt al-Māl Gold Dīnārs &amp; Suftajah Caravan Credit">
        <div>
          <div class="hud-metric-label">Bayt al-Māl Treasury</div>
          <div><span id="hudDinarsVal" class="hud-metric-val">3,140 Dīnārs</span> <span id="hudDinarsRate" class="hud-metric-rate">(+31.4/s)</span></div>
        </div>
      </div>
      <div class="hud-metric" title="Canonical Stronghold Commodities: Vinegar (Khall), Cotton (Quṭn), Tobacco/Qahwah &amp; Damascus Steel">
        <div>
          <div class="hud-metric-label">Vinegar • Cotton • Botanical • Steel</div>
          <div><span id="hudCommoditiesVal" class="hud-metric-val">314 | 314 | 314 | 314</span></div>
        </div>
      </div>
      <div class="hud-metric" title="Castle Order, Prophetic Suffrage Collection &amp; Mu'ākhāh Patronage Harmony">
        <div>
          <div class="hud-metric-label">Suffrage &amp; Patronage Order</div>
          <div><span id="hudSuffrageVal" class="hud-metric-val">98.6% (3.14π)</span></div>
        </div>
      </div>
      <div class="hud-metric" title="67 Existing HTML Portals Abstracted Inside the Single Castle Library">
        <div>
          <div class="hud-metric-label">Castle Library Tomes</div>
          <div><span id="hudTomesVal" class="hud-metric-val">67 / 67 Illuminated</span></div>
        </div>
      </div>
      <div class="hud-metric">
        <div>
          <div class="hud-metric-label">Contemporary Canon Era Style</div>
          <select id="hudEraSelector" onchange="window.SovGame.setContemporaryEra(this.value)" style="background:#0B1222;color:#FDE68A;border:1px solid #D4AF37;border-radius:6px;padding:2px 6px;font-size:0.76rem;font-weight:700;">
            <option value="0">Era I (624 CE): Badr 313 — Hope, Levity &amp; Madīnah Sanctuary</option>
            <option value="1">Era II (636 CE): Yarmūk, Qādisiyyah &amp; Jerusalem Covenant</option>
            <option value="2">Era III (711 CE): Ṭāriq ibn Ziyād — Birth of Islamic Spain (Al-Andalus)</option>
            <option value="3">Era IV (800 CE): 'Abbāsid Baghdad Bayt al-Ḥikmah &amp; Al-Kīmiyā'</option>
            <option value="4">Era V (1187–1260 CE): Ḥiṭṭīn, 'Ayn Jālūt &amp; Mamlūk Furūsiyyah</option>
            <option value="5">Era VI (1453–1600 CE): Constantinople Şahi Bombards &amp; Gunpowder Pinnacle</option>
            <option value="6">Era VII (1650–1850 CE): Omani/Yemeni Monsoon Dhows, Aceh &amp; Sokoto</option>
            <option value="7">Era VIII (2026+ CE): Sovereign 57-Nation &amp; Neo-Islamic Priory</option>
          </select>
        </div>
      </div>
    </div>
  </div>

  <div class="container">
    <!-- Hero Launch Banner -->
    <header class="hero-banner">
      <div class="hero-badges">
        <span class="badge badge-gold">PORTAL #68 / 68 • UNIFIED SINGLE-CASTLE GAME LAUNCH</span>
        <span class="badge badge-emerald">BEGINNING AT THE 313 OF BADR (+1 = 314 π PRINCIPLE)</span>
        <span class="badge badge-sapphire">3D AI SPRITES • WALKING • FLOATING • 7 COMBAT VFX</span>
        <span class="badge badge-crimson">6 MODES: RPG • TOWER DEFENSE • TDM • BRAWL • AMBUSH • SIEGE</span>
        <span class="badge badge-purple">67 LIBRARY TOMES ABSTRACTED • 12 POLYGLOT DATA FORMATS</span>
      </div>
      <h1>The Sovereign Single-Castle 2.5D/3D Sprite RPG, Caravan Logistics, Castle Siege &amp; 3.14 π Studio</h1>
      <div class="arabic-sub">قلعة التوحيد والبيان • من الثلاثمائة وثلاثة عشر ببدر إلى فتح الأندلس وإخضاع العوالم السبعة بالسلام والعدل</div>
      <p style="margin:0;color:#CBD5E1;font-size:0.93rem;max-width:1420px;">
        Welcome to the unified <strong>Single-Castle Game Launch Portal</strong> abstracting all <strong>67 canonical HTML knowledge bases</strong> into one living, observable, and 100% customizable simulation. Beginning in <strong>radiant Prophetic Hope, Warmth, and Levity</strong> with the <strong>313 Companions of Badr (+ 1 Sovereign Anchor = 314 = 100 &times; 3.14 &pi;)</strong> and the <strong>Good Warlock Devoted to Islam</strong>, you govern from the <strong>Single Castle Throne Room</strong> (manually dictating Lunch/Cafeteria menus with blessed Vinegar &amp; Ṣawm fasting, Barracks, Sciences, Religiosity, Patronage Guild Houses, and the 67-Tome Library). Every single Muslim is an <strong>autonomous procedural node-agent</strong> whose <strong>Will</strong> is shaped by lived experience and paired in <strong>Mu'ākhāh Patronage</strong> to collect <strong>Suffrage</strong>, harvest <strong>Vinegar, Cotton, Tobacco, Damascus Steel, Maps &amp; 32-Point Compasses</strong>, dispatch Caravans &amp; Monsoon Dhows, welcome <strong>Rumored Kings from Afar</strong>, uncover <strong>Syndications</strong> (revealing hoarded suffrage, <em>"wolves at the door"</em> grievances, Priory relics, or scientific breakthroughs), and execute <strong>11-Vector Procedural Combat</strong> across <strong>RPG, Tower Defense, TDM, Mubārazah Brawl, Caravan Ambush, and Castle Siege</strong> modes!
      </p>
    </header>

    <!-- 4 AI-Generated 3D Sprite, Single Castle, VFX Siege & Diplomatic Discovery Plates -->
    <section class="plates-grid-4">
      <div class="plate-card">
        <img src="images/castle_game_plate_1_single_castle_sanctuary.jpg" alt="Plate 1: The Single Castle Sanctuary, Throne Room & 67-Tome Library" />
        <div class="plate-body">
          <div class="plate-title">Plate I — The Single Castle Sanctuary, Throne Room &amp; 67-Tome Library</div>
          <div>Cutaway 2.5D/3D panorama of the Single Castle uniting Madīnah's hopeful courtyard of brotherhood, the Throne Room, the <em>Simāṭ</em> Cafeteria, the 67-Tome <em>Bayt al-Ḥikmah</em> Library, Vinegar/Cotton/Alchemy workshops, and departing oasis caravans.</div>
        </div>
      </div>
      <div class="plate-card">
        <img src="images/castle_game_plate_2_3d_unit_sprite_atlas.jpg" alt="Plate 2: 3D AI-Generated Unit Sprite Atlas" />
        <div class="plate-body">
          <div class="plate-title">Plate II — 3D AI Sprite Atlas: Good Warlock, Mamlūks, 313 Vanguard &amp; Specialists</div>
          <div>3D-shaded isometric miniatures in walking, floating, and combat stances: the floating Good Warlock with golden Kufic halo &amp; Brass Qumqum, barded Mamlūk Lancers, 313 Vanguard, Composite Snipers, Bīmāristān Healers, Alchemists &amp; Cannoneers.</div>
        </div>
      </div>
      <div class="plate-card">
        <img src="images/castle_game_plate_3_combat_vfx_siege_action.jpg" alt="Plate 3: High-Fantasy Canonical Combat VFX & Castle Siege" />
        <div class="plate-body">
          <div class="plate-title">Plate III — Archetypical Combat VFX: Sword Swipes, Arrows, Missiles, Clouds &amp; Sparkles</div>
          <div>Live Siege &amp; Ambush action showcasing glowing Damascus crescent sword swipes, parabolic arrow volleys, <em>Nafṭ</em> fire missiles, purple poison miasma neutralized by purifying vinegar-rosewater mist, and an empowered Mamlūk cavalry charge.</div>
        </div>
      </div>
      <div class="plate-card">
        <img src="images/castle_game_plate_4_diplomacy_caravan_discovery.jpg" alt="Plate 4: Rumored Kings from Afar, Port Faires & Uncovering Syndications" />
        <div class="plate-body">
          <div class="plate-title">Plate IV — Rumored Kings from Afar, Port Faires &amp; Uncovering Syndications</div>
          <div>Envoys from Abyssinia, Oman, Egypt, Byzantium, and Spain arriving at the Castle Port Faire with gifts alongside vinegar vats, cotton bales, and 32-point compasses while shadowy Syndications dissolve into 3.14 &pi; science and Priory roses.</div>
        </div>
      </div>
    </section>
""";
    }

    private String buildMain25dInteractiveCanvasAndThroneRoom(List<ThroneRoomDepartmentDossier> departments) {
        StringBuilder deptHtml = new StringBuilder();
        for (ThroneRoomDepartmentDossier d : departments) {
            deptHtml.append("""
              <div class="sub-card">
                <h4>%s</h4>
                <div style="color:#FDE68A;font-size:0.76rem;margin-bottom:0.3rem;">%s</div>
                <p style="margin:0 0 0.35rem 0;color:#CBD5E1;font-size:0.76rem;"><strong>Prophetic Precedent:</strong> %s</p>
                <p style="margin:0 0 0.35rem 0;color:#93C5FD;font-size:0.75rem;"><strong>Manual Dictate:</strong> %s</p>
                <div style="display:flex;justify-content:space-between;align-items:center;margin-top:0.45rem;padding-top:0.4rem;border-top:1px solid rgba(255,255,255,0.08);">
                  <span style="font-family:Consolas,monospace;font-size:0.71rem;color:#6EE7B7;">%s</span>
                  <button class="btn btn-emerald" onclick="window.SovGame.issueThroneDecree('%s')">Issue Decree (+3.14π)</button>
                </div>
              </div>
            """.formatted(
                    escapeHtml(d.departmentName()),
                    escapeHtml(d.arabicTitle()),
                    escapeHtml(d.propheticPrecedent()),
                    escapeHtml(d.manualDictateControls()),
                    escapeHtml(d.idleIncrementalPowerFormula()),
                    escapeHtml(d.departmentId())
            ));
        }

        return """
    <!-- MAIN DUAL WORKSPACE: Left = 2.5D/3D Sprite Canvas & 6 Combat Modes | Right = Throne Room Dictates & Individual Muslim Node Inspector -->
    <section class="game-workspace">
      <!-- LEFT PANEL: 2.5D Isometric World, Caravan & 6-Mode Instanced Combat Engine -->
      <div class="panel">
        <div class="panel-header">
          <div>
            <h2 class="panel-title">1. Live 2.5D/3D Sprite World &amp; 6-Mode Instanced Combat Grid</h2>
            <div style="font-size:0.76rem;color:var(--text-muted);">Click any autonomous Muslim node, Caravan, Tower tile, or Stronghold on the isometric grid to inspect/command</div>
          </div>
          <div class="btn-row">
            <button id="modeBtn_WORLD" class="btn active" onclick="window.SovGame.setCombatMode('WORLD')">🌍 World Caravan &amp; Stronghold Grid</button>
            <button id="modeBtn_RPG" class="btn" onclick="window.SovGame.setCombatMode('RPG')">🧙‍♂️ RPG Good Warlock Party</button>
            <button id="modeBtn_TD" class="btn" onclick="window.SovGame.setCombatMode('TD')">🗼 Tower Defense (Ribāṭ)</button>
            <button id="modeBtn_TDM" class="btn" onclick="window.SovGame.setCombatMode('TDM')">⚔️ Team Deathmatch (TDM)</button>
            <button id="modeBtn_BRAWL" class="btn" onclick="window.SovGame.setCombatMode('BRAWL')">🛡️ Mubārazah Brawl</button>
            <button id="modeBtn_AMBUSH" class="btn" onclick="window.SovGame.setCombatMode('AMBUSH')">🐪 Caravan Ambush Rescue</button>
            <button id="modeBtn_SIEGE" class="btn" onclick="window.SovGame.setCombatMode('SIEGE')">🏰 Castle Siege (Ḥiṣār)</button>
          </div>
        </div>

        <!-- VFX & Action Trigger Toolbar -->
        <div class="btn-row" style="margin-bottom:0.65rem;">
          <button class="btn btn-emerald" onclick="window.SovGame.triggerVfxBurst('SPARKLES')">✨ Cast 3.14 Barakah Sparkles</button>
          <button class="btn btn-crimson" onclick="window.SovGame.triggerVfxBurst('SWORD_SWIPE')">⚔️ Damascus Crescent Sword Swipe</button>
          <button class="btn btn-sapphire" onclick="window.SovGame.triggerVfxBurst('ARROWS')">🏹 Rain of 314 Bodkin Arrows</button>
          <button class="btn" onclick="window.SovGame.triggerVfxBurst('MISSILES')">☄️ Alchemical Nafṭ &amp; Bombard Missiles</button>
          <button class="btn" onclick="window.SovGame.triggerVfxBurst('POISON_VINEGAR')">☁️ Poison Cloud vs. Vinegar-Rosewater Mist</button>
          <button class="btn btn-emerald" onclick="window.SovGame.triggerVfxBurst('EMPOWERED')">🔥 Empower Units (3.14π Aura)</button>
          <button class="btn btn-crimson" onclick="window.SovGame.triggerVfxBurst('MAMLUK_CHARGE')">🐎 Mamlūk Heavy Cavalry A* Charge</button>
          <button class="btn btn-sapphire" onclick="window.SovGame.spawnProceduralCaravan()">🐪 Dispatch New Caravan</button>
        </div>

        <div class="canvas-wrap">
          <canvas id="sovereign25dGameCanvas" width="1020" height="590"></canvas>
          <div class="canvas-overlay-top">
            <div class="canvas-pill" id="canvasTopLeftReadout">Mode: WORLD GRID • Era I: 624 CE Badr (Hope &amp; Levity) • Active Sprites: 24</div>
            <div class="canvas-pill" id="canvasWinCalcReadout">Win Forecast (Lanchester + 'Aṣabiyyah): 94.2% Ummah Victory • Speed: 1.0x (3.14π)</div>
          </div>
        </div>

        <!-- Bottom Controls under Canvas: Animation Rig Customizer & Live Combat Log -->
        <div class="sub-grid-2" style="margin-top:0.85rem;">
          <div class="sub-card">
            <h4>🎨 3D Sprite Animation &amp; 3.14 π VFX Customizer</h4>
            <div class="slider-row">
              <span>Walking &amp; Gallop Stride Speed (π):</span>
              <input type="range" id="animWalkSlider" min="0.5" max="9.42" step="0.1" value="3.14" oninput="window.SovGame.updateAnimSliders()" />
              <span class="pi-val" id="animWalkVal">3.14π</span>
            </div>
            <div class="slider-row">
              <span>Good Warlock Floating Levitation Amplitude:</span>
              <input type="range" id="animFloatSlider" min="0.5" max="9.42" step="0.1" value="3.14" oninput="window.SovGame.updateAnimSliders()" />
              <span class="pi-val" id="animFloatVal">3.14π</span>
            </div>
            <div class="slider-row">
              <span>Sword Swipe Arc &amp; Projectile VFX Scale:</span>
              <input type="range" id="animVfxSlider" min="0.5" max="9.42" step="0.1" value="3.14" oninput="window.SovGame.updateAnimSliders()" />
              <span class="pi-val" id="animVfxVal">3.14π</span>
            </div>
            <div class="slider-row">
              <span>A* Pursuit Aggression &amp; Orbit Radius:</span>
              <input type="range" id="animOrbitSlider" min="0.5" max="9.42" step="0.1" value="3.14" oninput="window.SovGame.updateAnimSliders()" />
              <span class="pi-val" id="animOrbitVal">3.14π</span>
            </div>
          </div>
          <div class="sub-card">
            <h4>📜 Live Procedural Combat, Caravan &amp; Conversion Telemetry Log</h4>
            <div id="liveCombatLog" class="combat-log-box"></div>
          </div>
        </div>
      </div>

      <!-- RIGHT PANEL: Selected Autonomous Muslim Node Inspector + Throne Room Manual Dictates -->
      <div class="panel">
        <div class="panel-header">
          <h2 class="panel-title">2. Autonomous Muslim Node Inspector &amp; Editable Instruction Stack</h2>
          <span class="badge badge-emerald" id="selectedNodeBadge">Node #001 of 314 Selected</span>
        </div>

        <div class="sub-card" style="margin-bottom:0.9rem;border-color:var(--gold);">
          <div style="display:flex;justify-content:space-between;align-items:flex-start;gap:0.5rem;">
            <div>
              <h4 id="inspNodeName" style="font-size:1.02rem;color:#FDE68A;">Al-Ḥakīm Zakeem Al-Muwaḥḥid (Good Warlock #001)</h4>
              <div id="inspNodeRole" style="font-size:0.78rem;color:#6EE7B7;">Archetype: Good Warlock / Sovereign Covenant Warden • Form: Floating_314_Pi_Levitation</div>
            </div>
            <select id="inspVerbSelect" onchange="window.SovGame.setSelectedNodeVerb(this.value)" style="background:#0B1222;color:#FDE68A;border:1px solid #D4AF37;border-radius:6px;padding:4px 8px;font-size:0.76rem;font-weight:700;">
              <option value="ORBIT">Command: ORBIT (Circumambulate &amp; Screen)</option>
              <option value="TRADE">Command: TRADE (Bazaar &amp; Port Arbitrage)</option>
              <option value="BOLSTER">Command: BOLSTER (Heal, Buff &amp; Endow Waqf)</option>
              <option value="HOLD">Command: HOLD (Garrison Wall &amp; Overwatch)</option>
              <option value="ATTACK">Command: ATTACK (A* Pursuit Until HP Depleted)</option>
              <option value="DEFEND">Command: DEFEND (Guard Unit xX &amp; Caravan Rearguard)</option>
            </select>
          </div>
          <p id="inspNodeExperience" style="margin:0.45rem 0;font-size:0.77rem;color:#CBD5E1;">
            <strong>Lived Experience &amp; Will:</strong> Severed the ancient occult pact at the Foundation; channels 100% of Al-Kīmiyā' and 3.14π geometry into Prophetic Order, Hope, and Brotherhood.
          </p>
          <div style="margin:0.45rem 0;">
            <label style="font-size:0.73rem;color:#93C5FD;font-weight:700;">Editable Autonomous Gambit / Role Rule (Live Applied on Grid):</label>
            <input type="text" id="inspNodeGambitInput" value="HEAL(Lowest_HP_Ally_Y, <75%) -> DEFEND(Caravan_Straggler_xX, r=3.14) -> ATTACK_NEAREST_TO(Ally_yY, until_hp_depleted)" style="width:100%;margin-top:0.25rem;background:#04070E;color:#6EE7B7;border:1px solid rgba(212,175,55,0.45);border-radius:6px;padding:0.4rem 0.6rem;font-family:Consolas,monospace;font-size:0.74rem;" onchange="window.SovGame.updateSelectedNodeGambit(this.value)" />
          </div>
          <div id="inspNodeMetrics" style="display:grid;grid-template-columns:repeat(3,1fr);gap:0.4rem;margin-top:0.5rem;font-family:Consolas,monospace;font-size:0.73rem;color:#FDE68A;">
            <div>Stat Weight: <span id="inspStatW">9.42π</span></div>
            <div>Armor Weight: <span id="inspArmorW">1.57π</span></div>
            <div>Weapon Weight: <span id="inspWeaponW">3.14π</span></div>
            <div>Skill Tone: <span id="inspTone">Sakīnah</span></div>
            <div>Trade Skill: <span id="inspTradeSkill">Al-Kīmiyā' &amp; Qumqum</span></div>
            <div>Conversions: <span id="inspConversions">14 Realms/Squads</span></div>
          </div>
        </div>

        <!-- Throne Room Manual Command Dictates (Cafeteria, Barracks, Sciences, Religiosity, Banking, Library) -->
        <div class="panel-header" style="margin-top:0.4rem;">
          <h3 class="panel-title" style="font-size:1.02rem;">👑 Castle Throne Room Manual Dictates (Ummah Leader Command)</h3>
          <div class="btn-row">
            <button class="btn btn-emerald" onclick="window.SovGame.serveCafeteriaLunch()">🍲 Serve Blessed Vinegar &amp; Tharīd Lunch</button>
            <button class="btn btn-sapphire" onclick="window.SovGame.collectCastleSuffrage()">⚖️ Collect Suffrage &amp; Pair Mu'ākhāh Patrons</button>
          </div>
        </div>
        <div class="sub-grid-2" style="max-height:475px;overflow-y:auto;padding-right:0.25rem;">
          __DEPT_HTML__
        </div>
      </div>
    </section>
""".replace("__DEPT_HTML__", deptHtml.toString());
    }

    private String buildCaravanBazaarAndDiplomacySection(
            List<CommodityAndStrongholdDutyDossier> commodities,
            List<RumoredKingAndSyndicationDossier> kings) {

        StringBuilder commRows = new StringBuilder();
        for (CommodityAndStrongholdDutyDossier c : commodities) {
            commRows.append("""
              <tr>
                <td><strong style="color:#FDE68A;">%s</strong><br/><span style="font-size:0.72rem;color:#6EE7B7;">%s</span></td>
                <td>%s</td>
                <td>%s</td>
                <td>%s</td>
                <td><span style="color:#93C5FD;">%s</span></td>
                <td style="font-family:Consolas,monospace;color:#FDE68A;font-weight:700;">%.2f π Dīnārs<br/>
                  <button class="btn btn-emerald" style="margin-top:4px;padding:2px 6px;font-size:0.7rem;" onclick="window.SovGame.harvestAndTradeCommodity('%s', %.2f)">Harvest &amp; Trade</button>
                </td>
              </tr>
            """.formatted(
                    escapeHtml(c.commodityName()),
                    escapeHtml(c.arabicAndEtymologicalRoot()),
                    escapeHtml(c.primaryStrongholdAndPorts()),
                    escapeHtml(c.extractionAndRefiningChain()),
                    escapeHtml(c.canonicalCreditToIslam()),
                    escapeHtml(c.caravanAndCombatUtility()),
                    c.baseBazaarDinarValuePi(),
                    escapeHtml(c.commodityId()),
                    c.baseBazaarDinarValuePi()
            ));
        }

        StringBuilder kingCards = new StringBuilder();
        for (RumoredKingAndSyndicationDossier k : kings) {
            kingCards.append("""
              <div class="sub-card" id="kingCard_%s">
                <div style="display:flex;justify-content:space-between;align-items:center;gap:0.4rem;">
                  <h4>👑 %s</h4>
                  <span class="badge badge-gold">%s</span>
                </div>
                <div style="font-size:0.74rem;color:#93C5FD;margin-bottom:0.35rem;">%s</div>
                <p style="margin:0 0 0.35rem 0;font-size:0.76rem;color:#E2E8F0;"><strong>Initial Curiosity, Hope &amp; Gifts:</strong> %s</p>
                <div style="background:rgba(15,23,42,0.9);border-left:3px solid #F43F5E;padding:0.45rem 0.6rem;border-radius:6px;margin:0.4rem 0;font-size:0.75rem;">
                  <div style="color:#FDA4AF;font-weight:700;">🕵️ Uncovered Syndication: %s</div>
                  <div style="color:#FDE68A;"><strong>True Nature:</strong> %s</div>
                  <div style="color:#CBD5E1;"><strong>"Wolves at the Door" / Suffrage Cause:</strong> %s</div>
                </div>
                <div style="background:rgba(16,185,129,0.12);border-left:3px solid #10B981;padding:0.45rem 0.6rem;border-radius:6px;margin:0.4rem 0;font-size:0.75rem;color:#6EE7B7;">
                  <strong>Priory &amp; Scientific Discovery Unlocked:</strong> %s
                </div>
                <div class="btn-row" style="margin-top:0.5rem;">
                  <button class="btn btn-emerald" onclick="window.SovGame.sendDiplomaticEpistle('%s', '%s')">📜 Send Prophetic Epistle &amp; Uncover Syndication</button>
                  <button class="btn btn-sapphire" onclick="window.SovGame.sendCaravanToKing('%s')">🐪 Send Port Faire Caravan</button>
                </div>
              </div>
            """.formatted(
                    escapeHtml(k.kingdomId()),
                    escapeHtml(k.rumoredKingName()),
                    escapeHtml(k.realmAndCapital()),
                    escapeHtml(k.historicalEraAndBanner()),
                    escapeHtml(k.initialCuriosityHopeAndGifts()),
                    escapeHtml(k.uncoveredSyndicationName()),
                    escapeHtml(k.syndicationTrueNatureType()),
                    escapeHtml(k.wolvesAtTheDoorGrievanceOrSuffrage()),
                    escapeHtml(k.prioryOrScientificDiscoveryUnlocked()),
                    escapeHtml(k.kingdomId()),
                    escapeHtml(k.rumoredKingName().replace("'", "")),
                    escapeHtml(k.kingdomId())
            ));
        }

        return """
    <!-- SECTION 3: Granular Resource Management, Stronghold Duties (Vinegar, Cotton, Tobacco, Maps, Compasses) & Caravan Delegation -->
    <div class="section-divider">
      <h2 class="panel-title" style="font-size:1.35rem;">3. Stronghold Duties, Commodity Supply Chains (Vinegar, Cotton, Tobacco, Maps, Compasses) &amp; Caravan Delegation</h2>
      <div class="btn-row">
        <button class="btn btn-emerald" onclick="window.SovGame.delegateFullCaravanFormation()">🐪 Delegate &amp; Launch Full 10-Specialist Caravan</button>
        <button class="btn btn-sapphire" onclick="window.SovGame.absorbNeutralCaravans()">🤝 Convert &amp; Absorb Neutral/Exhausted AI Caravans</button>
      </div>
    </div>

    <div class="panel" style="margin-bottom:1.5rem;">
      <p style="margin:0 0 0.7rem 0;font-size:0.84rem;color:#CBD5E1;">
        Every Port, City, and Stronghold (from <strong>Madīnah</strong> and <strong>Damascus</strong> to <strong>Córdoba/Spain</strong>, <strong>Baghdad</strong>, <strong>Muscat/Oman</strong>, <strong>Aden/Mocha</strong>, and <strong>Aceh</strong>) fulfills a specialized duty and trade skill (<em>Ḥirfah</em>)—canonically crediting Islam for its global contributions to chemistry, agronomy, navigation, metallurgy, and banking.
      </p>
      <div class="data-table-wrap">
        <table class="sov-table">
          <thead>
            <tr>
              <th>Commodity &amp; Etymology</th>
              <th>Primary Strongholds &amp; Ports</th>
              <th>Granular Extraction &amp; Refining Supply Chain</th>
              <th>Canonical Credit to Islam</th>
              <th>Castle, Caravan &amp; Combat VFX Utility</th>
              <th>Bazaar Value (3.14π)</th>
            </tr>
          </thead>
          <tbody>
            __COMM_ROWS__
          </tbody>
        </table>
      </div>
    </div>

    <!-- SECTION 4: Diplomacy with Rumored Kings from Afar & Uncovering Syndications -->
    <div class="section-divider">
      <h2 class="panel-title" style="font-size:1.35rem;">4. Diplomacy with Rumored Kings from Afar &amp; Uncovering Syndications ("Wolves at the Door", Hoarded Suffrage &amp; Priory Science)</h2>
    </div>
    <div class="sub-grid-2" style="margin-bottom:1.6rem;">
      __KING_CARDS__
    </div>
""".replace("__COMM_ROWS__", commRows.toString()).replace("__KING_CARDS__", kingCards.toString());
    }

    private String build11VectorCharacterProfilesAnd314Studio(
            List<CharacterArchetypeProfile> profiles,
            List<PolyglotStorageFormatDossier> formats) {

        StringBuilder profileOptions = new StringBuilder();
        StringBuilder profileRows = new StringBuilder();
        for (int i = 0; i < profiles.size(); i++) {
            CharacterArchetypeProfile p = profiles.get(i);
            profileOptions.append("<option value=\"").append(i).append("\">")
                    .append(escapeHtml(p.profileId())).append(" — ").append(escapeHtml(p.characterName()))
                    .append(" (").append(escapeHtml(p.archetypeClass())).append(")</option>");

            profileRows.append("""
              <tr>
                <td><strong style="color:#FDE68A;">%s</strong><br/><span style="color:#6EE7B7;font-size:0.72rem;">%s</span><br/><span style="color:#94A3B8;font-size:0.7rem;">%s</span></td>
                <td><span class="badge badge-gold">%s</span><br/><span style="font-size:0.71rem;color:#CBD5E1;">%s</span></td>
                <td style="font-size:0.73rem;"><strong>Experience:</strong> %s<br/><strong>Will &amp; Patronage:</strong> %s</td>
                <td style="font-family:Consolas,monospace;font-size:0.71rem;color:#6EE7B7;">%s</td>
                <td style="font-size:0.72rem;"><strong>Function:</strong> %s<br/><strong>3D Form:</strong> <span style="color:#93C5FD;">%s</span></td>
                <td style="font-family:Consolas,monospace;font-size:0.73rem;">
                  <strong>Stat:</strong> %.2fπ<br/>
                  <strong>Armor:</strong> %.2fπ<br/>
                  <strong>Weapon:</strong> %.2fπ<br/>
                  <span style="font-size:0.69rem;color:#94A3B8;">HP:%d ATK:%d DEF:%d RNG:%d</span>
                </td>
                <td style="font-size:0.72rem;">
                  <strong>Skill:</strong> %s<br/>
                  <strong>Ability:</strong> <span style="color:#FDE68A;">%s</span><br/>
                  <strong>VFX:</strong> <span class="badge badge-sapphire">%s</span><br/>
                  <strong>Tone:</strong> %s<br/>
                  <strong>Defense:</strong> %s
                </td>
                <td style="font-family:Consolas,monospace;font-size:0.71rem;color:#FDE68A;">%s<br/>
                  <button class="btn btn-emerald" style="margin-top:4px;padding:2px 6px;font-size:0.7rem;" onclick="window.SovGame.deployProfileToGrid(%d)">Deploy 3D Sprite</button>
                </td>
              </tr>
            """.formatted(
                    escapeHtml(p.characterName()),
                    escapeHtml(p.arabicTitle()),
                    escapeHtml(p.profileId()),
                    escapeHtml(p.archetypeClass()),
                    escapeHtml(p.historicalEraStyle()),
                    escapeHtml(p.livedExperienceOrigin()),
                    escapeHtml(p.willedDispositionAndPatronage()),
                    escapeHtml(p.commandsRuleStack()),
                    escapeHtml(p.tacticalFunction()),
                    escapeHtml(p.spriteAnimationForm()),
                    p.statWeightPi(),
                    p.armorWeightPi(),
                    p.weaponWeightPi(),
                    p.baseHp(), p.baseAttack(), p.baseDefense(), p.baseRangeTiles(),
                    escapeHtml(p.skillName()),
                    escapeHtml(p.skillAbilityName()),
                    escapeHtml(p.vfxType()),
                    escapeHtml(p.skillTone()),
                    escapeHtml(p.skillDefense()),
                    escapeHtml(p.canonicalMetricsOfSkill()),
                    i
            ));
        }

        StringBuilder formatButtons = new StringBuilder();
        for (int i = 0; i < formats.size(); i++) {
            PolyglotStorageFormatDossier f = formats.get(i);
            formatButtons.append("""
              <button class="btn %s" id="fmtBtn_%d" onclick="window.SovGame.selectStorageFormat(%d)">%s (%s)</button>
            """.formatted(
                    i == 0 ? "active" : "",
                    i,
                    i,
                    escapeHtml(f.formatName().split("\\(")[0].trim()),
                    escapeHtml(f.fileExtension())
            ));
        }

        return """
    <!-- SECTION 5: 1-Profile-1-Character Complete 11-Vector Procedural Weighing Matrix & Live Clash Calculator -->
    <div class="section-divider">
      <h2 class="panel-title" style="font-size:1.35rem;">5. 1-Profile-1-Character Roster &amp; Live 11-Vector Procedural Combat Weighing Calculator (Rounded to 3.14 π)</h2>
    </div>

    <div class="panel" style="margin-bottom:1.5rem;">
      <div class="sub-grid-2" style="margin-bottom:1rem;">
        <div class="sub-card">
          <h4>⚔️ Live 11-Vector Archetypical Clash &amp; Win Calculator</h4>
          <div style="display:grid;grid-template-columns:1fr 1fr;gap:0.6rem;margin-bottom:0.6rem;">
            <div>
              <label style="font-size:0.74rem;color:#6EE7B7;font-weight:700;">Attacker Profile (1-Profile-1-Character):</label>
              <select id="clashAttackerSelect" onchange="window.SovGame.recalc11VectorClash()" style="width:100%;background:#050811;color:#FDE68A;border:1px solid #D4AF37;border-radius:6px;padding:5px;font-size:0.76rem;">
                __PROFILE_OPTS__
              </select>
            </div>
            <div>
              <label style="font-size:0.74rem;color:#FDA4AF;font-weight:700;">Defender Profile (Oppositional / Target):</label>
              <select id="clashDefenderSelect" onchange="window.SovGame.recalc11VectorClash()" style="width:100%;background:#050811;color:#FDA4AF;border:1px solid #F43F5E;border-radius:6px;padding:5px;font-size:0.76rem;">
                __PROFILE_OPTS__
              </select>
            </div>
          </div>
          <div class="slider-row">
            <span>Attacker Stat Weight Slider (π):</span>
            <input type="range" id="clashStatSlider" min="0.314" max="15.70" step="0.314" value="9.42" oninput="window.SovGame.recalc11VectorClash()" />
            <span class="pi-val" id="clashStatVal">9.42π</span>
          </div>
          <div class="slider-row">
            <span>Attacker Weapon Weight Slider (π):</span>
            <input type="range" id="clashWeaponSlider" min="0.314" max="12.56" step="0.314" value="3.14" oninput="window.SovGame.recalc11VectorClash()" />
            <span class="pi-val" id="clashWeaponVal">3.14π</span>
          </div>
          <div class="slider-row">
            <span>Defender Armor Weight Slider (π):</span>
            <input type="range" id="clashArmorSlider" min="0.314" max="12.56" step="0.314" value="1.57" oninput="window.SovGame.recalc11VectorClash()" />
            <span class="pi-val" id="clashArmorVal">1.57π</span>
          </div>
          <div class="slider-row">
            <span>Elevation &amp; Barakah Empowerment Multiplier (π):</span>
            <input type="range" id="clashEmpowerSlider" min="1.00" max="9.42" step="0.314" value="3.14" oninput="window.SovGame.recalc11VectorClash()" />
            <span class="pi-val" id="clashEmpowerVal">3.14π</span>
          </div>
          <button class="btn btn-emerald" style="width:100%;margin-top:0.4rem;" onclick="window.SovGame.executeLiveClashOnCanvas()">⚡ Execute This 11-Vector Clash Live on the 2.5D Canvas</button>
        </div>

        <div class="sub-card">
          <h4>📐 Granular 11-Vector Procedural Weighing Formula Output</h4>
          <div id="clashFormulaOutput" style="font-family:Consolas,monospace;font-size:0.75rem;color:#E2E8F0;line-height:1.6;background:#04070E;padding:0.75rem;border-radius:8px;border:1px solid rgba(212,175,55,0.3);"></div>
        </div>
      </div>

      <div class="data-table-wrap">
        <table class="sov-table">
          <thead>
            <tr>
              <th>Character &amp; ID</th>
              <th>Archetype &amp; Era Style</th>
              <th>Lived Experience, Will &amp; Patronage</th>
              <th>1. Commands (Gambit AI Stack)</th>
              <th>2. Function &amp; 3. 3D Sprite Form</th>
              <th>4–6. Stat, Armor &amp; Weapon Weights (π)</th>
              <th>7–10. Skill, Ability, VFX, Tone &amp; Defense</th>
              <th>11. Canonical Metrics of Skill</th>
            </tr>
          </thead>
          <tbody>
            __PROFILE_ROWS__
          </tbody>
        </table>
      </div>
    </div>

    <!-- SECTION 6: The 12-Format Polyglot Data Model & 3.14 Studio (JSON, CSV, SQL, YAML, TOML, XML, Protobuf, Binary, Cypher, Wafq) -->
    <div class="section-divider">
      <h2 class="panel-title" style="font-size:1.35rem;">6. The 12-Format Polyglot Game Combat &amp; Character Data Studio (Import, Edit, Convert &amp; Hot-Inject)</h2>
      <div class="btn-row">
        <button class="btn btn-emerald" onclick="window.SovGame.injectStudioDataModel()">🚀 Hot-Inject Edited Data Model into Live Game</button>
        <button class="btn btn-sapphire" onclick="window.SovGame.downloadCurrentFormatFile()">💾 Download / Export Current Format File</button>
      </div>
    </div>

    <div class="panel" style="margin-bottom:1.6rem;">
      <p style="margin:0 0 0.65rem 0;font-size:0.83rem;color:#CBD5E1;">
        Select any of the <strong>12 supported game combat, archetype, and inventory storage formats</strong> below to inspect, edit, convert, export, or hot-inject large data models directly into the procedural simulation:
      </p>
      <div class="btn-row" style="margin-bottom:0.75rem;">
        __FMT_BTNS__
      </div>
      <div id="studioFormatMeta" style="font-size:0.79rem;color:#FDE68A;margin-bottom:0.45rem;font-family:Consolas,monospace;"></div>
      <textarea id="polyglotStudioTextarea" class="code-studio-area" spellcheck="false"></textarea>
    </div>
""".replace("__PROFILE_OPTS__", profileOptions.toString())
   .replace("__PROFILE_ROWS__", profileRows.toString())
   .replace("__FMT_BTNS__", formatButtons.toString());
    }

    private String buildGrandCastleLibrary67TomesSection(List<PortalCatalogEntry> allPortals) {
        StringBuilder tomeCards = new StringBuilder();
        for (PortalCatalogEntry entry : allPortals) {
            tomeCards.append("""
              <div class="tome-card illuminated" id="tomeCard_%d">
                <div>
                  <div style="display:flex;justify-content:space-between;align-items:center;gap:0.35rem;margin-bottom:0.3rem;">
                    <span class="badge badge-gold">Tome #%02d / %d</span>
                    <span style="font-size:0.69rem;color:#6EE7B7;font-family:Consolas,monospace;">+3.14² π Illuminated</span>
                  </div>
                  <div style="font-weight:700;color:#FDE68A;font-size:0.86rem;margin-bottom:0.2rem;">%s</div>
                  <div style="font-size:0.72rem;color:#93C5FD;margin-bottom:0.3rem;">%s • %s</div>
                  <p style="margin:0 0 0.45rem 0;color:#CBD5E1;font-size:0.74rem;">%s</p>
                </div>
                <div class="btn-row" style="margin-top:0.35rem;">
                  <button class="btn btn-emerald" style="padding:3px 7px;font-size:0.71rem;" onclick="window.SovGame.injectTomeScenario(%d)">⚡ Inject Tome into 2.5D Grid</button>
                  <a class="btn btn-sapphire" style="padding:3px 7px;font-size:0.71rem;text-decoration:none;" href="%s">📖 Open Full Portal</a>
                </div>
              </div>
            """.formatted(
                    entry.sequenceNumber(),
                    entry.sequenceNumber(),
                    allPortals.size(),
                    escapeHtml(entry.shortLabel() + " — " + entry.title()),
                    escapeHtml(entry.wingCategory()),
                    escapeHtml(entry.arabicAndQuranicTag()),
                    escapeHtml(entry.summary()),
                    entry.sequenceNumber(),
                    escapeHtml(entry.fileName())
            ));
        }

        return """
    <!-- SECTION 7: The Grand Castle Library Holding All 67 Abstracted Knowledge Bases, Stories, Parables & Prudential Writings -->
    <div class="section-divider">
      <div>
        <h2 class="panel-title" style="font-size:1.35rem;">7. The Grand Castle Library (Khizānat Al-Kutub) — All 67 Existing Knowledge Bases Abstracted</h2>
        <div style="font-size:0.78rem;color:var(--text-muted);">Every existing HTML portal is abstracted below as an interactive Castle Tome granting stories, parables, prudential Islamic statecraft rules, and live 2.5D scenario injection</div>
      </div>
      <div style="display:flex;gap:0.5rem;align-items:center;">
        <input type="text" id="tomeSearchInput" placeholder="Search 67 Castle Library Tomes (e.g. Spain, Compass, Warlock, Alchemy, Suffrage)..." oninput="window.SovGame.filterLibraryTomes(this.value)" style="background:#050811;color:#F8FAFC;border:1px solid #D4AF37;border-radius:8px;padding:0.45rem 0.8rem;width:340px;font-size:0.78rem;" />
        <button class="btn btn-emerald" onclick="window.SovGame.studyAll67Tomes()">📚 Study All 67 Tomes (+314π Wisdom Surge)</button>
      </div>
    </div>

    <div class="panel" style="margin-bottom:2rem;">
      <div class="tome-grid" id="castleLibraryTomeGrid">
        __TOME_CARDS__
      </div>
    </div>
  </div>
""".replace("__TOME_CARDS__", tomeCards.toString());
    }

    private String buildEmbeddedJsonDataScript(
            List<CharacterArchetypeProfile> profiles,
            List<CommodityAndStrongholdDutyDossier> commodities,
            List<RumoredKingAndSyndicationDossier> kings,
            List<PortalCatalogEntry> allPortals) {

        StringBuilder profJson = new StringBuilder("[");
        for (int i = 0; i < profiles.size(); i++) {
            CharacterArchetypeProfile p = profiles.get(i);
            if (i > 0) profJson.append(",");
            profJson.append("{")
                    .append("\"profileId\":\"").append(escapeJs(p.profileId())).append("\",")
                    .append("\"characterName\":\"").append(escapeJs(p.characterName())).append("\",")
                    .append("\"arabicTitle\":\"").append(escapeJs(p.arabicTitle())).append("\",")
                    .append("\"archetypeClass\":\"").append(escapeJs(p.archetypeClass())).append("\",")
                    .append("\"livedExperienceOrigin\":\"").append(escapeJs(p.livedExperienceOrigin())).append("\",")
                    .append("\"commandsRuleStack\":\"").append(escapeJs(p.commandsRuleStack())).append("\",")
                    .append("\"tacticalFunction\":\"").append(escapeJs(p.tacticalFunction())).append("\",")
                    .append("\"spriteAnimationForm\":\"").append(escapeJs(p.spriteAnimationForm())).append("\",")
                    .append("\"statWeightPi\":").append(p.statWeightPi()).append(",")
                    .append("\"armorWeightPi\":").append(p.armorWeightPi()).append(",")
                    .append("\"weaponWeightPi\":").append(p.weaponWeightPi()).append(",")
                    .append("\"skillName\":\"").append(escapeJs(p.skillName())).append("\",")
                    .append("\"skillAbilityName\":\"").append(escapeJs(p.skillAbilityName())).append("\",")
                    .append("\"vfxType\":\"").append(escapeJs(p.vfxType())).append("\",")
                    .append("\"skillTone\":\"").append(escapeJs(p.skillTone())).append("\",")
                    .append("\"skillDefense\":\"").append(escapeJs(p.skillDefense())).append("\",")
                    .append("\"canonicalMetricsOfSkill\":\"").append(escapeJs(p.canonicalMetricsOfSkill())).append("\",")
                    .append("\"baseHp\":").append(p.baseHp()).append(",")
                    .append("\"baseAttack\":").append(p.baseAttack()).append(",")
                    .append("\"baseDefense\":").append(p.baseDefense()).append(",")
                    .append("\"baseRangeTiles\":").append(p.baseRangeTiles()).append(",")
                    .append("\"moveSpeedPi\":").append(p.moveSpeedPi())
                    .append("}");
        }
        profJson.append("]");

        StringBuilder tomesJson = new StringBuilder("[");
        for (int i = 0; i < allPortals.size(); i++) {
            PortalCatalogEntry t = allPortals.get(i);
            if (i > 0) tomesJson.append(",");
            tomesJson.append("{")
                    .append("\"seq\":").append(t.sequenceNumber()).append(",")
                    .append("\"file\":\"").append(escapeJs(t.fileName())).append("\",")
                    .append("\"label\":\"").append(escapeJs(t.shortLabel())).append("\",")
                    .append("\"title\":\"").append(escapeJs(t.title())).append("\",")
                    .append("\"wing\":\"").append(escapeJs(t.wingCategory())).append("\",")
                    .append("\"tag\":\"").append(escapeJs(t.arabicAndQuranicTag())).append("\"")
                    .append("}");
        }
        tomesJson.append("]");

        return """
  <script>
    window.SOV_PROFILES_DATA = __PROF_JSON__;
    window.SOV_TOMES_DATA = __TOMES_JSON__;
  </script>
""".replace("__PROF_JSON__", profJson.toString()).replace("__TOMES_JSON__", tomesJson.toString());
    }

    private String buildGameEngineScriptPart1() {
        return """
  <script>
  (function() {
    const PI_314 = 3.14;
    const canvas = document.getElementById('sovereign25dGameCanvas');
    const ctx = canvas ? canvas.getContext('2d') : null;

    const ERA_THEMES = [
      { name: "Era I (624 CE): Badr 313 — Hope, Levity & Madīnah Sanctuary", skyTop: "#0B192C", skyBot: "#1E2A1E", tileA: "#2A2418", tileB: "#332B1D", castleColor: "#F8F5E6", accent: "#D4AF37", banner: "Al-'Uqāb & White Badr Standard" },
      { name: "Era II (636 CE): Yarmūk, Qādisiyyah & Jerusalem Covenant", skyTop: "#0F172A", skyBot: "#1E1B4B", tileA: "#292524", tileB: "#38322E", castleColor: "#E2E8F0", accent: "#10B981", banner: "Rāshidūn Covenant Standard" },
      { name: "Era III (711 CE): Ṭāriq ibn Ziyād — Birth of Islamic Spain (Al-Andalus)", skyTop: "#1A1025", skyBot: "#0F292A", tileA: "#1F2E22", tileB: "#293B2C", castleColor: "#FDE68A", accent: "#F43F5E", banner: "Cordoban Umayyad White-Gold Falcon" },
      { name: "Era IV (800 CE): 'Abbāsid Baghdad Bayt al-Ḥikmah & Al-Kīmiyā'", skyTop: "#090D1E", skyBot: "#172554", tileA: "#162038", tileB: "#1E2B4A", castleColor: "#D4AF37", accent: "#38BDF8", banner: "'Abbāsid Black-and-Gold Wisdom Banner" },
      { name: "Era V (1187–1260 CE): Ḥiṭṭīn, 'Ayn Jālūt & Mamlūk Furūsiyyah", skyTop: "#1C1917", skyBot: "#2E1015", tileA: "#2B2118", tileB: "#382B20", castleColor: "#F59E0B", accent: "#FDE68A", banner: "Ayyūbid Eagle & Mamlūk Yellow Sultānī" },
      { name: "Era VI (1453–1600 CE): Constantinople Şahi Bombards & Gunpowder Pinnacle", skyTop: "#0C1928", skyBot: "#064E3B", tileA: "#14292B", tileB: "#1B3638", castleColor: "#38BDF8", accent: "#F43F5E", banner: "Ottoman Three Crescents & Safavid/Mughal Standard" },
      { name: "Era VII (1650–1850 CE): Omani/Yemeni Monsoon Dhows, Aceh & Sokoto", skyTop: "#042F2E", skyBot: "#0C4A6E", tileA: "#0F293A", tileB: "#16384E", castleColor: "#6EE7B7", accent: "#38BDF8", banner: "Omani Crimson Khanjar & Nusantara Maritime Flag" },
      { name: "Era VIII (2026+ CE): Sovereign 57-Nation & Neo-Islamic Priory", skyTop: "#030712", skyBot: "#0F172A", tileA: "#0B132B", tileB: "#132042", castleColor: "#10B981", accent: "#A78BFA", banner: "57-Nation Sovereign Emerald-Gold Priory" }
    ];

    const state = {
      barakahPower: 314.00,
      barakahRate: 9.42,
      ummahNodes: 314,
      dinars: 3140.0,
      dinarRate: 31.4,
      commodities: { vinegar: 314, cotton: 314, tobacco: 314, steel: 314 },
      suffragePct: 98.6,
      illuminatedTomes: 67,
      eraIndex: 0,
      combatMode: 'WORLD',
      walkSpeedPi: 3.14,
      floatAmpPi: 3.14,
      vfxScalePi: 3.14,
      orbitRadiusPi: 3.14,
      selectedUnitIndex: 0,
      currentStorageFormat: 0,
      tickCount: 0,
      units: [],
      caravans: [],
      towers: [],
      vfxParticles: [],
      strongholds: [
        { name: "Single Castle Sanctuary (Madīnah / Priory Core)", gx: 0, gy: 0, color: "#D4AF37", duty: "Throne Room, 67-Tome Library & Simāṭ Cafeteria", isCastle: true },
        { name: "Stronghold of Córdoba & Granada (Al-Andalus / Spain)", gx: -4.2, gy: -2.2, color: "#F43F5E", duty: "Vinegar Vineyards, Olive Oil, Guadamecil Leather & 400k Books" },
        { name: "Stronghold of Damascus & Jerusalem (Al-Shām)", gx: -1.8, gy: -3.2, color: "#38BDF8", duty: "Damascus Fūlādh Crucible Steel, Rosewater & Glass" },
        { name: "Stronghold of Baghdad & Kūfah (Bayt al-Ḥikmah)", gx: 2.2, gy: -2.6, color: "#A78BFA", duty: "Al-Inbīq Vinegar-Acid Alchemy, 3.14π Math & Suftajah Banking" },
        { name: "Port Faire of Muscat, Sohar & Aden (Oman & Yemen)", gx: 3.6, gy: 1.8, color: "#10B981", duty: "32-Point Brass Compasses, Monsoon Dhows, Mocha & Frankincense" },
        { name: "Port Stronghold of Aceh & Malacca (Nusantara)", gx: 5.2, gy: 3.0, color: "#6EE7B7", duty: "Botanicals, Tobacco/Spice Curing & Peaceful Maritime Da'wah" },
        { name: "Sanctuary of Axum, Cairo & Timbuktu (Africa)", gx: -3.4, gy: 2.6, color: "#F59E0B", duty: "Egyptian Quṭn Cotton Looms, Gold Dīnārs & Sankore Manuscripts" },
        { name: "Oppositional Syndication & Warlock Citadel", gx: 4.4, gy: -1.2, color: "#EF4444", duty: "Uncovered Syndication -> Sealed in Brass Qumqum", isEnemy: true }
      ]
    };

    function addLog(msg, color) {
      const box = document.getElementById('liveCombatLog');
      if (!box) return;
      const div = document.createElement('div');
      div.className = 'log-entry';
      div.style.color = color || '#E2E8F0';
      const ts = new Date().toLocaleTimeString();
      div.textContent = '[' + ts + '] ' + msg;
      box.prepend(div);
      while (box.children.length > 45) {
        box.removeChild(box.lastChild);
      }
    }

    function initUnitsAndCaravans() {
      state.units = [];
      const profiles = window.SOV_PROFILES_DATA || [];
      for (let i = 0; i < profiles.length; i++) {
        const p = profiles[i];
        const isEnemy = p.profileId.includes('SYNDICATION') || p.profileId.includes('IMPERIAL');
        const angle = (i / profiles.length) * Math.PI * 2;
        const radius = isEnemy ? 4.2 : 2.2;
        state.units.push({
          idx: i,
          profileId: p.profileId,
          name: p.characterName,
          archetype: p.archetypeClass,
          form: p.spriteAnimationForm,
          verb: isEnemy ? 'ATTACK' : (i === 0 ? 'ORBIT' : (i % 3 === 0 ? 'DEFEND' : 'BOLSTER')),
          gambit: p.commandsRuleStack,
          statW: p.statWeightPi,
          armorW: p.armorWeightPi,
          weaponW: p.weaponWeightPi,
          vfxType: p.vfxType,
          tone: p.skillTone,
          tradeSkill: p.skillName,
          experience: p.livedExperienceOrigin,
          hp: p.baseHp,
          maxHp: p.baseHp,
          atk: p.baseAttack,
          def: p.baseDefense,
          isEnemy: isEnemy,
          isFloating: p.spriteAnimationForm.includes('Floating'),
          isMounted: p.spriteAnimationForm.includes('Mounted') || p.spriteAnimationForm.includes('Camel'),
          empowered: i < 3,
          gx: Math.cos(angle) * radius + (isEnemy ? 2.2 : -0.6),
          gy: Math.sin(angle) * radius,
          vx: 0,
          vy: 0,
          orbitAngle: angle,
          conversions: isEnemy ? 0 : (3 + i * 2)
        });
      }

      state.caravans = [
        { name: "Madīnah–Córdoba (Spain) Al-Andalus Caravan", gx: -1.0, gy: -0.6, tx: -4.2, ty: -2.2, cargo: "Vinegar, Olive Oil & 67-Tome Copies", friendly: true, stragglersProtected: true },
        { name: "Muscat–Aden–Malacca Monsoon Dhow Convoy", gx: 1.2, gy: 0.8, tx: 5.2, ty: 3.0, cargo: "32-Point Compasses, Cotton & Botanicals", friendly: true, stragglersProtected: true },
        { name: "Foreign Syndicate Caravan (Awaiting Da'wah / Trade)", gx: 3.8, gy: -0.4, tx: 0.0, ty: 0.0, cargo: "Silver Bullion, Spices & Uncovered Grievance Scroll", friendly: false, stragglersProtected: false }
      ];

      state.towers = [
        { name: "Ribāṭ Watchtower of Salmān", gx: -1.4, gy: 1.2, type: "ARCHER_314", color: "#38BDF8" },
        { name: "Al-Inbīq Vinegar-Rosewater Purifier Tower", gx: 1.5, gy: -1.1, type: "VINEGAR_MIST", color: "#10B981" },
        { name: "Solomonic Brass Qumqum Ward Pylon", gx: 2.3, gy: 0.4, type: "QUMQUM_BEAM", color: "#D4AF37" }
      ];
    }

    function isoProject(gx, gy, gz) {
      const w = canvas.width;
      const h = canvas.height;
      const scale = 58;
      const sx = w * 0.48 + (gx - gy) * scale;
      const sy = h * 0.50 + (gx + gy) * (scale * 0.52) - (gz || 0);
      return { x: sx, y: sy };
    }

    function spawnVfx(type, sx, sy, tx, ty, color) {
      for (let i = 0; i < 14; i++) {
        state.vfxParticles.push({
          type: type,
          x: sx,
          y: sy,
          tx: tx != null ? tx : sx + (Math.random() - 0.5) * 140,
          ty: ty != null ? ty : sy + (Math.random() - 0.5) * 90,
          vx: (Math.random() - 0.5) * 4.5,
          vy: (Math.random() - 0.5) * 4.5 - 1.5,
          progress: 0,
          life: 1.0,
          radius: (4 + Math.random() * 8) * (state.vfxScalePi / PI_314),
          color: color || '#FDE68A'
        });
      }
    }

    function render25dScene() {
      if (!ctx) return;
      state.tickCount++;
      const t = state.tickCount * 0.045 * (state.walkSpeedPi / PI_314);
      const theme = ERA_THEMES[state.eraIndex] || ERA_THEMES[0];

      // Sky Gradient
      const grad = ctx.createLinearGradient(0, 0, 0, canvas.height);
      grad.addColorStop(0, theme.skyTop);
      grad.addColorStop(1, theme.skyBot);
      ctx.fillStyle = grad;
      ctx.fillRect(0, 0, canvas.width, canvas.height);

      // Draw 2.5D Isometric Diamond Tile Grid (-6 to +6)
      for (let gx = -6; gx <= 6; gx++) {
        for (let gy = -5; gy <= 5; gy++) {
          const p0 = isoProject(gx, gy, 0);
          const p1 = isoProject(gx + 1, gy, 0);
          const p2 = isoProject(gx + 1, gy + 1, 0);
          const p3 = isoProject(gx, gy + 1, 0);
          ctx.beginPath();
          ctx.moveTo(p0.x, p0.y);
          ctx.lineTo(p1.x, p1.y);
          ctx.lineTo(p2.x, p2.y);
          ctx.lineTo(p3.x, p3.y);
          ctx.closePath();
          ctx.fillStyle = ((gx + gy) & 1) === 0 ? theme.tileA : theme.tileB;
          ctx.fill();
          ctx.strokeStyle = 'rgba(212, 175, 55, 0.13)';
          ctx.lineWidth = 1;
          ctx.stroke();
        }
      }

      // Draw Trade & Expansion Splines from Single Castle (0,0) to Strongholds
      const castleCenter = isoProject(0, 0, 12);
      state.strongholds.forEach((sh, idx) => {
        if (idx === 0) return;
        const sp = isoProject(sh.gx, sh.gy, 8);
        ctx.save();
        ctx.beginPath();
        ctx.setLineDash([6, 4]);
        ctx.moveTo(castleCenter.x, castleCenter.y);
        ctx.lineTo(sp.x, sp.y);
        ctx.strokeStyle = sh.isEnemy ? 'rgba(244, 63, 94, 0.45)' : 'rgba(212, 175, 55, 0.38)';
        ctx.lineWidth = 1.6;
        ctx.stroke();
        ctx.restore();
      });

      // Draw Strongholds & The Central Single Castle Sanctuary
      state.strongholds.forEach((sh) => {
        const pos = isoProject(sh.gx, sh.gy, 0);
        const height = sh.isCastle ? 46 : 26;
        // 3D Isometric Citadel Block
        ctx.fillStyle = sh.isCastle ? theme.castleColor : sh.color;
        ctx.fillRect(pos.x - (sh.isCastle ? 26 : 16), pos.y - height, sh.isCastle ? 52 : 32, height);
        ctx.strokeStyle = '#D4AF37';
        ctx.lineWidth = sh.isCastle ? 2.2 : 1.2;
        ctx.strokeRect(pos.x - (sh.isCastle ? 26 : 16), pos.y - height, sh.isCastle ? 52 : 32, height);

        // Golden Dome / Muqarnas Finial
        ctx.beginPath();
        ctx.arc(pos.x, pos.y - height, sh.isCastle ? 18 : 11, Math.PI, 0);
        ctx.fillStyle = sh.isEnemy ? '#991B1B' : '#D4AF37';
        ctx.fill();

        // Label
        ctx.fillStyle = '#F8FAFC';
        ctx.font = sh.isCastle ? 'bold 11px Segoe UI' : '10px Segoe UI';
        ctx.textAlign = 'center';
        ctx.fillText(sh.name.split('(')[0].trim(), pos.x, pos.y + 15);
      });

      // Draw Tower Defense Emplacements
      state.towers.forEach((tw) => {
        const tp = isoProject(tw.gx, tw.gy, 0);
        ctx.fillStyle = tw.color;
        ctx.beginPath();
        ctx.moveTo(tp.x, tp.y - 30);
        ctx.lineTo(tp.x + 12, tp.y);
        ctx.lineTo(tp.x - 12, tp.y);
        ctx.closePath();
        ctx.fill();
        ctx.strokeStyle = '#FDE68A';
        ctx.stroke();
        // Orbiting defense ring
        ctx.beginPath();
        ctx.ellipse(tp.x, tp.y, 28, 14, 0, 0, Math.PI * 2);
        ctx.strokeStyle = 'rgba(16, 185, 129, 0.28)';
        ctx.stroke();
      });

      // Update & Draw Moving Caravans (Camel Trains & Monsoon Dhows)
      state.caravans.forEach((cv) => {
        const dx = cv.tx - cv.gx;
        const dy = cv.ty - cv.gy;
        const dist = Math.hypot(dx, dy);
        if (dist > 0.08) {
          cv.gx += (dx / dist) * 0.012;
          cv.gy += (dy / dist) * 0.012;
        } else {
          const tmpX = cv.tx;
          const tmpY = cv.ty;
          cv.tx = cv.gx > 0 ? -3.5 : 3.6;
          cv.ty = cv.gy > 0 ? -2.2 : 1.8;
        }
        const cp = isoProject(cv.gx, cv.gy, 0);
        ctx.fillStyle = cv.friendly ? '#10B981' : '#F59E0B';
        ctx.beginPath();
        ctx.arc(cp.x, cp.y - 8, 9, 0, Math.PI * 2);
        ctx.fill();
        ctx.strokeStyle = '#FFFFFF';
        ctx.stroke();
        ctx.fillStyle = '#FDE68A';
        ctx.font = '9px Consolas';
        ctx.textAlign = 'center';
        ctx.fillText('🐪 ' + cv.name.slice(0, 22), cp.x, cp.y - 21);
      });

      // Update & Draw 3D AI-Styled Unit Sprites with Walking, Floating & Combat Animations
      state.units.forEach((u, idx) => {
        if (u.verb === 'ORBIT') {
          u.orbitAngle += 0.018 * (state.walkSpeedPi / PI_314);
          const r = (state.orbitRadiusPi / PI_314) * 2.1;
          u.gx = Math.cos(u.orbitAngle) * r;
          u.gy = Math.sin(u.orbitAngle) * r;
        } else if (u.verb === 'ATTACK') {
          // A* style pursuit toward nearest opposing unit
          let bestTarget = null;
          let bestDist = 999;
          state.units.forEach((other) => {
            if (other.isEnemy !== u.isEnemy) {
              const d = Math.hypot(other.gx - u.gx, other.gy - u.gy);
              if (d < bestDist) { bestDist = d; bestTarget = other; }
            }
          });
          if (bestTarget && bestDist > 0.75) {
            u.gx += ((bestTarget.gx - u.gx) / bestDist) * 0.016 * (state.walkSpeedPi / PI_314);
            u.gy += ((bestTarget.gy - u.gy) / bestDist) * 0.016 * (state.walkSpeedPi / PI_314);
          } else if (bestTarget && state.tickCount % 48 === (idx * 4) % 48) {
            const up = isoProject(u.gx, u.gy, 14);
            const bp = isoProject(bestTarget.gx, bestTarget.gy, 14);
            spawnVfx(u.vfxType, up.x, up.y, bp.x, bp.y, u.isEnemy ? '#A855F7' : '#FDE68A');
          }
        }

        const floatZ = u.isFloating
          ? 14 + Math.sin(t * 2.0 + idx) * 6.0 * (state.floatAmpPi / PI_314)
          : Math.abs(Math.sin(t * 3.14 + idx)) * 3.5;

        const up = isoProject(u.gx, u.gy, floatZ);
        const groundP = isoProject(u.gx, u.gy, 0);

        // Ground Shadow & Tactical Selection Ring
        ctx.beginPath();
        ctx.ellipse(groundP.x, groundP.y, u.isMounted ? 16 : 11, u.isMounted ? 8 : 5.5, 0, 0, Math.PI * 2);
        ctx.fillStyle = 'rgba(0,0,0,0.55)';
        ctx.fill();

        if (idx === state.selectedUnitIndex) {
          ctx.beginPath();
          ctx.ellipse(groundP.x, groundP.y, 20, 10, 0, 0, Math.PI * 2);
          ctx.strokeStyle = '#6EE7B7';
          ctx.lineWidth = 2;
          ctx.stroke();
        }

        // Empowered Golden 3.14π Aura
        if (u.empowered) {
          ctx.beginPath();
          ctx.arc(up.x, up.y - 12, 19 + Math.sin(t * 3) * 3, 0, Math.PI * 2);
          ctx.fillStyle = 'rgba(212, 175, 55, 0.20)';
          ctx.fill();
          ctx.strokeStyle = 'rgba(253, 230, 138, 0.75)';
          ctx.lineWidth = 1.3;
          ctx.stroke();
        }

        // Walking / Galloping Legs Animation
        const legSwing = Math.sin(t * 4.2 + idx) * 5;
        ctx.strokeStyle = u.isEnemy ? '#FCA5A5' : '#E2E8F0';
        ctx.lineWidth = 2.4;
        ctx.beginPath();
        ctx.moveTo(up.x - 4, up.y - 4);
        ctx.lineTo(up.x - 4 + legSwing, up.y + 4);
        ctx.moveTo(up.x + 4, up.y - 4);
        ctx.lineTo(up.x + 4 - legSwing, up.y + 4);
        ctx.stroke();

        // Mount (Mamlūk Warhorse or Caravan Camel) if Mounted
        if (u.isMounted) {
          ctx.fillStyle = u.isEnemy ? '#7F1D1D' : '#B45309';
          ctx.fillRect(up.x - 13, up.y - 10, 26, 9);
        }

        // 3D Shaded Torso & Garment (Contemporary Era Colored)
        ctx.fillStyle = u.isEnemy ? '#DC2626' : (idx === 0 ? '#10B981' : theme.accent);
        ctx.beginPath();
        ctx.roundRect(up.x - 8, up.y - 24, 16, 18, 4);
        ctx.fill();
        ctx.strokeStyle = '#FDE68A';
        ctx.lineWidth = 1.2;
        ctx.stroke();

        // Head & Turban / Helmet + Floating Halo for Good Warlock
        ctx.beginPath();
        ctx.arc(up.x, up.y - 29, 6, 0, Math.PI * 2);
        ctx.fillStyle = '#FDE68A';
        ctx.fill();

        if (u.isFloating) {
          ctx.beginPath();
          ctx.ellipse(up.x, up.y - 38, 12, 4, t * 0.5, 0, Math.PI * 2);
          ctx.strokeStyle = '#FDE68A';
          ctx.lineWidth = 1.6;
          ctx.stroke();
        }

        // Animated Combat Weapon Swing (Sword Swipe / Bow / Qumqum Staff)
        const swingAngle = Math.sin(t * 3.5 + idx) * 0.65;
        ctx.save();
        ctx.translate(up.x + 7, up.y - 16);
        ctx.rotate(swingAngle);
        ctx.strokeStyle = '#6EE7B7';
        ctx.lineWidth = 2.5;
        ctx.beginPath();
        ctx.moveTo(0, 0);
        ctx.lineTo(14, -10);
        ctx.stroke();
        ctx.restore();

        // HP Bar & Role Tag
        ctx.fillStyle = 'rgba(0,0,0,0.7)';
        ctx.fillRect(up.x - 16, up.y - 46, 32, 4);
        ctx.fillStyle = u.isEnemy ? '#EF4444' : '#10B981';
        ctx.fillRect(up.x - 16, up.y - 46, 32 * (u.hp / u.maxHp), 4);
      });

      // Update & Draw All 7 VFX Particle Systems (Sparkles, Sword Swipes, Arrows, Missiles, Poison/Vinegar Clouds)
      for (let i = state.vfxParticles.length - 1; i >= 0; i--) {
        const p = state.vfxParticles[i];
        p.progress += 0.045;
        p.life -= 0.022;
        if (p.life <= 0) {
          state.vfxParticles.splice(i, 1);
          continue;
        }
        const curX = p.x + (p.tx - p.x) * Math.min(1, p.progress) + p.vx;
        const curY = p.y + (p.ty - p.y) * Math.min(1, p.progress) - Math.sin(p.progress * Math.PI) * 38;

        ctx.save();
        ctx.globalAlpha = Math.max(0, p.life);
        if (p.type.includes('SWORD_SWIPE')) {
          ctx.strokeStyle = '#FDE68A';
          ctx.lineWidth = 3.5;
          ctx.beginPath();
          ctx.arc(curX, curY, p.radius * 2.2, -0.8, 1.4);
          ctx.stroke();
        } else if (p.type.includes('ARROWS')) {
          ctx.strokeStyle = '#38BDF8';
          ctx.lineWidth = 2.0;
          ctx.beginPath();
          ctx.moveTo(curX - 8, curY - 6);
          ctx.lineTo(curX + 8, curY + 6);
          ctx.stroke();
        } else if (p.type.includes('CLOUD') || p.type.includes('VINEGAR') || p.type.includes('POISON')) {
          ctx.fillStyle = p.color;
          ctx.beginPath();
          ctx.arc(curX, curY, p.radius * 2.8, 0, Math.PI * 2);
          ctx.fill();
        } else if (p.type.includes('MISSILE') || p.type.includes('CHARGE')) {
          ctx.fillStyle = '#F43F5E';
          ctx.beginPath();
          ctx.arc(curX, curY, p.radius * 1.4, 0, Math.PI * 2);
          ctx.fill();
        } else {
          // Sparkles (Barakah 3.14 Starburst)
          ctx.fillStyle = p.color || '#6EE7B7';
          ctx.beginPath();
          ctx.arc(curX, curY, p.radius * 0.85, 0, Math.PI * 2);
          ctx.fill();
        }
        ctx.restore();
      }

      requestAnimationFrame(render25dScene);
    }

    // Canvas Click Handler: Select unit or place Tower Defense node
    if (canvas) {
      canvas.addEventListener('click', function(ev) {
        const rect = canvas.getBoundingClientRect();
        const mx = (ev.clientX - rect.left) * (canvas.width / rect.width);
        const my = (ev.clientY - rect.top) * (canvas.height / rect.height);

        let clickedUnit = -1;
        let bestD = 32;
        state.units.forEach((u, idx) => {
          const up = isoProject(u.gx, u.gy, 10);
          const d = Math.hypot(up.x - mx, up.y - my);
          if (d < bestD) { bestD = d; clickedUnit = idx; }
        });

        if (clickedUnit >= 0) {
          state.selectedUnitIndex = clickedUnit;
          syncInspectorToSelectedUnit();
          const u = state.units[clickedUnit];
          const up = isoProject(u.gx, u.gy, 12);
          spawnVfx('SPARKLES', up.x, up.y, up.x, up.y - 30, '#6EE7B7');
          addLog('Inspected Autonomous Node #' + (clickedUnit + 1) + ': ' + u.name + ' [' + u.verb + ']', '#6EE7B7');
        } else if (state.combatMode === 'TD') {
          const gx = ((mx - canvas.width * 0.48) / 58) * 0.5;
          const gy = ((my - canvas.height * 0.50) / 30) * 0.5;
          state.towers.push({ name: "Ribāṭ Tower #" + (state.towers.length + 1), gx: gx, gy: gy, type: "ARCHER_314", color: "#10B981" });
          spawnVfx('SPARKLES', mx, my, mx, my - 40, '#10B981');
          addLog('Constructed new Ribāṭ Defense Tower on 2.5D grid (+3.14π Security)!', '#FDE68A');
        }
      });
    }

    function syncInspectorToSelectedUnit() {
      const u = state.units[state.selectedUnitIndex];
      if (!u) return;
      document.getElementById('selectedNodeBadge').textContent = 'Node #' + String(state.selectedUnitIndex + 1).padStart(3, '0') + ' of ' + state.ummahNodes + ' Selected';
      document.getElementById('inspNodeName').textContent = u.name;
      document.getElementById('inspNodeRole').textContent = 'Archetype: ' + u.archetype + ' • 3D Form: ' + u.form;
      document.getElementById('inspVerbSelect').value = u.verb;
      document.getElementById('inspNodeExperience').innerHTML = '<strong>Lived Experience &amp; Will:</strong> ' + u.experience;
      document.getElementById('inspNodeGambitInput').value = u.gambit;
      document.getElementById('inspStatW').textContent = u.statW.toFixed(2) + 'π';
      document.getElementById('inspArmorW').textContent = u.armorW.toFixed(2) + 'π';
      document.getElementById('inspWeaponW').textContent = u.weaponW.toFixed(2) + 'π';
      document.getElementById('inspTone').textContent = u.tone.split('(')[0].trim();
      document.getElementById('inspTradeSkill').textContent = u.tradeSkill.slice(0, 26);
      document.getElementById('inspConversions').textContent = u.conversions + ' Squads/Nodes';
    }

    // Uncapped Idle & Incremental Power Loop (Every 250ms)
    setInterval(function() {
      state.barakahPower += state.barakahRate * 0.25;
      state.dinars += state.dinarRate * 0.25;
      document.getElementById('hudBarakahVal').textContent = state.barakahPower.toFixed(2) + ' π';
      document.getElementById('hudBarakahRate').textContent = '(+' + state.barakahRate.toFixed(2) + '/s)';
      document.getElementById('hudUmmahPop').textContent = state.ummahNodes.toLocaleString();
      document.getElementById('hudDinarsVal').textContent = Math.floor(state.dinars).toLocaleString() + ' Dīnārs';
      document.getElementById('hudDinarsRate').textContent = '(+' + state.dinarRate.toFixed(1) + '/s)';
      document.getElementById('hudCommoditiesVal').textContent =
        state.commodities.vinegar + ' | ' + state.commodities.cotton + ' | ' + state.commodities.tobacco + ' | ' + state.commodities.steel;
    }, 250);

    window.SovGame = {
      state: state,
      addLog: addLog,
      spawnVfx: spawnVfx,
      isoProject: isoProject,
      syncInspectorToSelectedUnit: syncInspectorToSelectedUnit
    };

    initUnitsAndCaravans();
    syncInspectorToSelectedUnit();
    addLog('Single-Castle Sanctuary initialized with the 313 of Badr (+1 = 314 π Anchor) in Prophetic Hope, Levity & Brotherhood.', '#FDE68A');
    requestAnimationFrame(render25dScene);
  })();
  </script>
""";
    }

    private String buildGameEngineScriptPart2() {
        return """
  <script>
  (function() {
    const G = window.SovGame;
    if (!G) return;
    const state = G.state;
    const PI_314 = 3.14;

    G.setContemporaryEra = function(idxStr) {
      state.eraIndex = parseInt(idxStr, 10) || 0;
      const sel = document.getElementById('hudEraSelector');
      const label = sel ? sel.options[sel.selectedIndex].text : 'Era I';
      document.getElementById('canvasTopLeftReadout').textContent =
        'Mode: ' + state.combatMode + ' • ' + label + ' • Active 3D Sprites: ' + state.units.length;
      G.addLog('Contemporary Canon Style morphed to ' + label + ' (Visual Palette, Garments & Siege Artillery Updated).', '#6EE7B7');
    };

    G.setCombatMode = function(mode) {
      state.combatMode = mode;
      ['WORLD','RPG','TD','TDM','BRAWL','AMBUSH','SIEGE'].forEach(m => {
        const b = document.getElementById('modeBtn_' + m);
        if (b) b.classList.toggle('active', m === mode);
      });
      document.getElementById('canvasTopLeftReadout').textContent =
        'Mode: ' + mode + ' • Single-Castle 2.5D Tactical Grid • Active 3D Sprites: ' + state.units.length;
      G.triggerVfxBurst(mode === 'SIEGE' ? 'MISSILES' : (mode === 'AMBUSH' ? 'ARROWS' : 'SPARKLES'));
      G.addLog('Switched 2.5D Grid to [' + mode + '] Mode — Autonomous Muslim Nodes executing Role/Responsibility Stacks.', '#FDE68A');
    };

    G.triggerVfxBurst = function(vfxKind) {
      const c = G.isoProject(0, 0, 20);
      if (vfxKind === 'SPARKLES') {
        G.spawnVfx('SPARKLES', c.x, c.y, c.x, c.y - 60, '#6EE7B7');
        state.barakahPower += 31.4;
        G.addLog('Good Warlock emitted 3.14π Barakah Sparkle Burst (+31.4π Uncapped Power & Ally Heal)!', '#6EE7B7');
      } else if (vfxKind === 'SWORD_SWIPE') {
        G.spawnVfx('SWORD_SWIPE', c.x - 40, c.y, c.x + 80, c.y - 20, '#FDE68A');
        G.addLog('Executed Crescent Damascus Fūlādh Sword Swipe (314° Cleave Arc)!', '#FDE68A');
      } else if (vfxKind === 'ARROWS') {
        G.spawnVfx('ARROWS', c.x - 90, c.y - 40, c.x + 130, c.y + 30, '#38BDF8');
        G.addLog('Composite Snipers unleashed Rain of 314 Bodkin Arrows from High Ground!', '#93C5FD');
      } else if (vfxKind === 'MISSILES') {
        G.spawnVfx('MISSILES', c.x, c.y - 30, c.x + 150, c.y - 10, '#F43F5E');
        G.addLog('Launched Alchemical Nafṭ Fireballs, Manjanīq Boulders & Solomonic Qumqum Beam!', '#FDA4AF');
      } else if (vfxKind === 'POISON_VINEGAR') {
        G.spawnVfx('POISON_CLOUD', c.x + 110, c.y, c.x + 140, c.y, 'rgba(168,85,247,0.45)');
        G.spawnVfx('VINEGAR_MIST', c.x - 20, c.y, c.x + 90, c.y, 'rgba(16,185,129,0.50)');
        G.addLog('Bīmāristān Healers & Alchemists neutralized Syndication Poison Cloud with Purifying Vinegar-Rosewater Mist!', '#6EE7B7');
      } else if (vfxKind === 'EMPOWERED') {
        state.units.forEach(u => { if (!u.isEnemy) u.empowered = true; });
        state.barakahRate += 3.14;
        G.spawnVfx('SPARKLES', c.x, c.y, c.x, c.y - 50, '#FDE68A');
        G.addLog('All Friendly Autonomous Nodes Empowered with Golden 3.14π Tawḥīd Auras!', '#FDE68A');
      } else if (vfxKind === 'MAMLUK_CHARGE') {
        G.spawnVfx('CAVALRY_CHARGE', c.x - 100, c.y + 20, c.x + 140, c.y - 30, '#F59E0B');
        G.addLog('Elite Mamlūk Heavy Cavalry executed A* Flanking Shock Charge across the 2.5D Grid!', '#FDE68A');
      }
    };

    G.spawnProceduralCaravan = function() {
      state.caravans.push({
        name: "Expedition Caravan #" + (state.caravans.length + 1) + " (Vinegar/Cotton/Compasses)",
        gx: 0, gy: 0,
        tx: (Math.random() > 0.5 ? -4.2 : 4.2),
        ty: (Math.random() - 0.5) * 4.5,
        cargo: "Vinegar, Cotton, Tobacco & 32-Pt Compasses",
        friendly: true,
        stragglersProtected: true
      });
      state.dinarRate += 6.28;
      G.addLog('Dispatched new 10-Specialist Caravan from the Single Castle Bazaar (+6.28 Dīnārs/sec)!', '#6EE7B7');
    };

    G.updateAnimSliders = function() {
      state.walkSpeedPi = parseFloat(document.getElementById('animWalkSlider').value) || 3.14;
      state.floatAmpPi = parseFloat(document.getElementById('animFloatSlider').value) || 3.14;
      state.vfxScalePi = parseFloat(document.getElementById('animVfxSlider').value) || 3.14;
      state.orbitRadiusPi = parseFloat(document.getElementById('animOrbitSlider').value) || 3.14;
      document.getElementById('animWalkVal').textContent = state.walkSpeedPi.toFixed(2) + 'π';
      document.getElementById('animFloatVal').textContent = state.floatAmpPi.toFixed(2) + 'π';
      document.getElementById('animVfxVal').textContent = state.vfxScalePi.toFixed(2) + 'π';
      document.getElementById('animOrbitVal').textContent = state.orbitRadiusPi.toFixed(2) + 'π';
    };

    G.setSelectedNodeVerb = function(verb) {
      const u = state.units[state.selectedUnitIndex];
      if (!u) return;
      u.verb = verb;
      G.addLog('Updated Autonomous Node [' + u.name + '] active verb to: ' + verb, '#93C5FD');
    };

    G.updateSelectedNodeGambit = function(ruleStr) {
      const u = state.units[state.selectedUnitIndex];
      if (!u) return;
      u.gambit = ruleStr;
      G.addLog('Compiled custom Gambit Rule for [' + u.name + ']: ' + ruleStr, '#6EE7B7');
    };

    G.issueThroneDecree = function(deptId) {
      state.barakahRate += 3.14;
      state.dinarRate += 9.42;
      state.ummahNodes += 12;
      G.triggerVfxBurst('SPARKLES');
      G.addLog('Throne Room Sovereign Decree issued in [' + deptId + '] -> +3.14π Barakah/s, +12 New Autonomous Muslim Nodes!', '#FDE68A');
    };

    G.serveCafeteriaLunch = function() {
      state.commodities.vinegar += 31;
      state.units.forEach(u => { if (!u.isEnemy) u.hp = u.maxHp; });
      G.triggerVfxBurst('SPARKLES');
      G.addLog('Served Prophetic Simāṭ Lunch in Castle Cafeteria (Blessed Vinegar, Tharīd, Dates & Olive Oil) — All 314+ Units Restored to 100% HP!', '#6EE7B7');
    };

    G.collectCastleSuffrage = function() {
      state.suffragePct = Math.min(100, state.suffragePct + 0.4);
      state.ummahNodes += 19;
      state.barakahRate += 6.28;
      document.getElementById('hudSuffrageVal').textContent = state.suffragePct.toFixed(1) + '% (3.14π)';
      G.addLog('Collected Suffrage in Al-Shūrā & Paired Newcomers in Mu\'ākhāh Patronage -> +19 Loyal Muslim Nodes Joined!', '#FDE68A');
    };

    G.harvestAndTradeCommodity = function(commId, valPi) {
      state.dinars += valPi * 100;
      state.commodities.vinegar += 15;
      state.commodities.cotton += 15;
      state.commodities.tobacco += 15;
      state.commodities.steel += 15;
      G.addLog('Stronghold Guild harvested & traded [' + commId + '] across Port Faires -> +' + Math.round(valPi * 100) + ' Gold Dīnārs!', '#6EE7B7');
    };

    G.delegateFullCaravanFormation = function() {
      G.spawnProceduralCaravan();
      state.ummahNodes += 10;
      G.addLog('Delegated Merchant, Healer, Alchemist, Sapper, Cannoneer, Sniper, Militia, Mamlūk, Explorer & Warrior into Caravan Formation!', '#FDE68A');
    };

    G.absorbNeutralCaravans = function() {
      state.caravans.forEach(cv => { cv.friendly = true; cv.stragglersProtected = true; });
      state.ummahNodes += 31;
      state.barakahPower += 94.2;
      G.triggerVfxBurst('SPARKLES');
      G.addLog('Converted & Absorbed AI Procedural Caravans and Rearguard Stragglers onto your mission (+31 Muslim Nodes)!', '#6EE7B7');
    };

    G.sendDiplomaticEpistle = function(kingId, kingName) {
      state.ummahNodes += 45;
      state.barakahRate += 6.28;
      state.dinars += 628;
      G.triggerVfxBurst('SPARKLES');
      G.addLog('Diplomatic Envoy to ' + kingName + ' uncovered local Syndication -> Resolved grievance, unlocked Priory/Scientific Discovery & welcomed +45 Converts in Peace!', '#FDE68A');
    };

    G.sendCaravanToKing = function(kingId) {
      G.spawnProceduralCaravan();
      state.dinars += 314;
      G.addLog('Dispatched Port Faire Caravan bearing Vinegar, Cotton, Compasses & Maps to [' + kingId + '] (+314 Gold Dīnārs)!', '#93C5FD');
    };

    G.deployProfileToGrid = function(profIdx) {
      const p = (window.SOV_PROFILES_DATA || [])[profIdx];
      if (!p) return;
      state.units.push({
        idx: state.units.length,
        profileId: p.profileId,
        name: p.characterName,
        archetype: p.archetypeClass,
        form: p.spriteAnimationForm,
        verb: 'ATTACK',
        gambit: p.commandsRuleStack,
        statW: p.statWeightPi,
        armorW: p.armorWeightPi,
        weaponW: p.weaponWeightPi,
        vfxType: p.vfxType,
        tone: p.skillTone,
        tradeSkill: p.skillName,
        experience: p.livedExperienceOrigin,
        hp: p.baseHp,
        maxHp: p.baseHp,
        atk: p.baseAttack,
        def: p.baseDefense,
        isEnemy: false,
        isFloating: p.spriteAnimationForm.includes('Floating'),
        isMounted: p.spriteAnimationForm.includes('Mounted'),
        empowered: true,
        gx: (Math.random() - 0.5) * 3.0,
        gy: (Math.random() - 0.5) * 3.0,
        orbitAngle: Math.random() * 6.28,
        conversions: 5
      });
      state.ummahNodes += 1;
      G.triggerVfxBurst('EMPOWERED');
      G.addLog('Deployed 3D Sprite [' + p.characterName + '] onto the 2.5D Grid with full 11-Vector Parameters!', '#6EE7B7');
    };

    // 11-Vector Procedural Combat Weighing Calculator
    G.recalc11VectorClash = function() {
      const profiles = window.SOV_PROFILES_DATA || [];
      const aIdx = parseInt(document.getElementById('clashAttackerSelect').value, 10) || 0;
      const dIdx = parseInt(document.getElementById('clashDefenderSelect').value, 10) || 10;
      const att = profiles[aIdx] || profiles[0];
      const def = profiles[dIdx] || profiles[profiles.length - 1];

      const statW = parseFloat(document.getElementById('clashStatSlider').value) || 9.42;
      const weapW = parseFloat(document.getElementById('clashWeaponSlider').value) || 3.14;
      const armW = parseFloat(document.getElementById('clashArmorSlider').value) || 1.57;
      const empW = parseFloat(document.getElementById('clashEmpowerSlider').value) || 3.14;

      document.getElementById('clashStatVal').textContent = statW.toFixed(2) + 'π';
      document.getElementById('clashWeaponVal').textContent = weapW.toFixed(2) + 'π';
      document.getElementById('clashArmorVal').textContent = armW.toFixed(2) + 'π';
      document.getElementById('clashEmpowerVal').textContent = empW.toFixed(2) + 'π';

      const initiativeScore = ((att.moveSpeedPi * statW) / Math.max(0.5, weapW * 0.314)).toFixed(2);
      const rawOffense = att.baseAttack * (statW / PI_314) * (1 + weapW / 6.28) * (empW / PI_314);
      const mitigation = def.baseDefense * (armW / PI_314) * 0.628;
      const netDamage = Math.max(31.4, rawOffense - mitigation);
      const turnsToWin = Math.ceil(def.baseHp / netDamage);
      const winProb = Math.min(99.6, Math.max(52.0, 68.0 + (rawOffense - mitigation) * 0.085));

      const out = document.getElementById('clashFormulaOutput');
      if (out) {
        out.innerHTML =
          '<div style="color:#FDE68A;font-weight:700;margin-bottom:4px;">⚡ 11-VECTOR PROCEDURAL WEIGHING (' + att.profileId + ' vs. ' + def.profileId + ')</div>' +
          '<div>1. <strong>Commands Stack:</strong> ' + att.commandsRuleStack + '</div>' +
          '<div>2. <strong>Function &amp; 3D Form:</strong> ' + att.tacticalFunction + ' | <span style="color:#93C5FD;">' + att.spriteAnimationForm + '</span></div>' +
          '<div>3. <strong>Initiative Velocity:</strong> ' + initiativeScore + ' rad/s (Stat ' + statW.toFixed(2) + 'π vs Weapon Inertia ' + weapW.toFixed(2) + 'π)</div>' +
          '<div>4. <strong>Raw Weighted Offense:</strong> ' + rawOffense.toFixed(1) + ' | <strong>Defender Armor Mitigation (' + armW.toFixed(2) + 'π):</strong> -' + mitigation.toFixed(1) + '</div>' +
          '<div>5. <strong>Net Damage / Tick &amp; Active VFX:</strong> <span style="color:#6EE7B7;font-weight:700;">' + netDamage.toFixed(1) + ' HP/hit</span> via [' + att.vfxType + '] (' + att.skillAbilityName + ')</div>' +
          '<div>6. <strong>Skill Tone &amp; Defense Counter:</strong> ' + att.skillTone + ' | ' + att.skillDefense + '</div>' +
          '<div>7. <strong>Lanchester + Ibn Khaldūn \'Aṣabiyyah Win Probability:</strong> <span style="color:#FDE68A;font-weight:700;">' + winProb.toFixed(1) + '% Victory in ~' + turnsToWin + ' combat ticks</span></div>';
      }
      document.getElementById('canvasWinCalcReadout').textContent =
        'Win Forecast: ' + winProb.toFixed(1) + '% (' + att.characterName.split('(')[0].trim() + ') • Net Hit: ' + netDamage.toFixed(0) + ' HP';
    };

    G.executeLiveClashOnCanvas = function() {
      G.recalc11VectorClash();
      G.triggerVfxBurst('SWORD_SWIPE');
      G.triggerVfxBurst('SPARKLES');
      G.addLog('Executed 11-Vector Procedural Clash on 2.5D Canvas — Damage, Knockback & Morale Applied!', '#FDE68A');
    };

    // 12-Format Polyglot Data Model Studio Serializer
    G.selectStorageFormat = function(fmtIdx) {
      state.currentStorageFormat = fmtIdx;
      for (let i = 0; i < 12; i++) {
        const b = document.getElementById('fmtBtn_' + i);
        if (b) b.classList.toggle('active', i === fmtIdx);
      }
      const profiles = window.SOV_PROFILES_DATA || [];
      const p0 = profiles[0] || {};
      const area = document.getElementById('polyglotStudioTextarea');
      const meta = document.getElementById('studioFormatMeta');
      if (!area) return;

      if (fmtIdx === 0) {
        meta.textContent = 'Format #1: JSON (.json) — Full Hierarchical Single-Castle & 11-Vector Character Package';
        area.value = JSON.stringify({
          piPrincipleAnchor: 3.14,
          singleCastleState: { barakahPower: state.barakahPower, ummahNodes: state.ummahNodes, dinars: state.dinars, commodities: state.commodities },
          characterProfiles: profiles
        }, null, 2);
      } else if (fmtIdx === 1) {
        meta.textContent = 'Format #2: JSONL / NDJSON (.jsonl) — Streaming 1-Line-Per-Record Character & Combat Event Stream';
        area.value = profiles.map(p => JSON.stringify(p)).join('\\n');
      } else if (fmtIdx === 2) {
        meta.textContent = 'Format #3: CSV (.csv) — Spreadsheet-Ready 11-Vector Relational Matrix';
        const header = 'profileId,characterName,archetypeClass,statWeightPi,armorWeightPi,weaponWeightPi,vfxType,skillTone,baseHp,baseAttack,baseDefense';
        const rows = profiles.map(p => [p.profileId, '"' + p.characterName + '"', '"' + p.archetypeClass + '"', p.statWeightPi, p.armorWeightPi, p.weaponWeightPi, p.vfxType, '"' + p.skillTone + '"', p.baseHp, p.baseAttack, p.baseDefense].join(','));
        area.value = [header].concat(rows).join('\\n');
      } else if (fmtIdx === 3) {
        meta.textContent = 'Format #4: TSV (.tsv) — Tab-Separated POSIX Stream Matrix';
        const header = 'profileId\\tcharacterName\\tarchetypeClass\\tstatWeightPi\\tarmorWeightPi\\tweaponWeightPi\\tcommandsRuleStack';
        const rows = profiles.map(p => [p.profileId, p.characterName, p.archetypeClass, p.statWeightPi, p.armorWeightPi, p.weaponWeightPi, p.commandsRuleStack].join('\\t'));
        area.value = [header].concat(rows).join('\\n');
      } else if (fmtIdx === 4) {
        meta.textContent = 'Format #5: SQL Relational DDL & DML (.sql) — Normalized Schema & INSERT Statements';
        const sqlHeader = 'CREATE TABLE IF NOT EXISTS character_profiles_314 (\\n  profile_id VARCHAR(40) PRIMARY KEY,\\n  character_name VARCHAR(120),\\n  archetype_class VARCHAR(80),\\n  stat_weight_pi DECIMAL(6,2),\\n  armor_weight_pi DECIMAL(6,2),\\n  weapon_weight_pi DECIMAL(6,2),\\n  vfx_type VARCHAR(40),\\n  commands_stack TEXT\\n);\\n\\n';
        const inserts = profiles.map(p => "INSERT INTO character_profiles_314 VALUES ('" + p.profileId + "', '" + p.characterName.replace(/'/g, "''") + "', '" + p.archetypeClass.replace(/'/g, "''") + "', " + p.statWeightPi + ", " + p.armorWeightPi + ", " + p.weaponWeightPi + ", '" + p.vfxType + "', '" + p.commandsRuleStack.replace(/'/g, "''") + "');").join('\\n');
        area.value = sqlHeader + inserts;
      } else if (fmtIdx === 5) {
        meta.textContent = 'Format #6: YAML (.yml) — Spring Boot @ConfigurationProperties Declarative Profile';
        area.value = 'sovereign-single-castle:\\n  pi-principle: 3.14\\n  ummah-initial-badr-anchor: 314\\n  characters:\\n' +
          profiles.map(p => '    - profile-id: ' + p.profileId + '\\n      name: "' + p.characterName + '"\\n      stat-weight-pi: ' + p.statWeightPi + '\\n      armor-weight-pi: ' + p.armorWeightPi + '\\n      weapon-weight-pi: ' + p.weaponWeightPi + '\\n      vfx-type: ' + p.vfxType + '\\n      commands: "' + p.commandsRuleStack + '"').join('\\n');
      } else if (fmtIdx === 6) {
        meta.textContent = 'Format #7: TOML (.toml) — Strongly-Typed Game Engine Section Config';
        area.value = '[castle_engine]\\npi_anchor = 3.14\\nummah_nodes = ' + state.ummahNodes + '\\n\\n' +
          profiles.map(p => '[[characters]]\\nprofile_id = "' + p.profileId + '"\\nname = "' + p.characterName + '"\\nstat_weight_pi = ' + p.statWeightPi + '\\narmor_weight_pi = ' + p.armorWeightPi + '\\nweapon_weight_pi = ' + p.weaponWeightPi + '\\nvfx_type = "' + p.vfxType + '"\\n').join('\\n');
      } else if (fmtIdx === 7) {
        meta.textContent = 'Format #8: XML (.xml) — 3D Sprite Rig & 11-Vector Combat Schema';
        area.value = '<?xml version="1.0" encoding="UTF-8"?>\\n<SovereignSingleCastle piAnchor="3.14" ummahNodes="' + state.ummahNodes + '">\\n' +
          profiles.map(p => '  <CharacterProfile id="' + p.profileId + '" statPi="' + p.statWeightPi + '" armorPi="' + p.armorWeightPi + '" weaponPi="' + p.weaponWeightPi + '" form="' + p.spriteAnimationForm + '" vfx="' + p.vfxType + '">\\n    <Commands>' + p.commandsRuleStack.replace(/</g, '&lt;').replace(/>/g, '&gt;') + '</Commands>\\n  </CharacterProfile>').join('\\n') +
          '\\n</SovereignSingleCastle>';
      } else if (fmtIdx === 8) {
        meta.textContent = 'Format #9: Protobuf-Text / FlatBuffers (.pbtxt) — Wire-Ready Message Payload';
        area.value = profiles.map((p, idx) => 'character_profile {\\n  field_id: ' + (idx + 1) + '\\n  profile_id: "' + p.profileId + '"\\n  stat_weight_pi: ' + p.statWeightPi + '\\n  armor_weight_pi: ' + p.armorWeightPi + '\\n  weapon_weight_pi: ' + p.weaponWeightPi + '\\n  vfx_emitter: ' + p.vfxType + '\\n}').join('\\n\\n');
      } else if (fmtIdx === 9) {
        meta.textContent = 'Format #10: Binary TypedArray / Hex Bitmask / Base64 Seed (.bin64)';
        const rawJson = JSON.stringify({ pi: 3.14, nodes: state.ummahNodes, lead: p0.profileId });
        const b64 = btoa(unescape(encodeURIComponent(rawJson)));
        area.value = 'SOV_HEX_HEADER::0x00FF3140_013A\\nFLOAT32_WEIGHT_VECTOR::[' + profiles.map(p => p.statWeightPi + ',' + p.armorWeightPi + ',' + p.weaponWeightPi).join(' | ') + ']\\nBASE64_CARTRIDGE::' + b64;
      } else if (fmtIdx === 10) {
        meta.textContent = 'Format #11: Property-Graph Cypher Triples (.cypher) — Gambit AI & Patronage Graph';
        area.value = profiles.map(p => "MERGE (u:AutonomousMuslimNode {id:'" + p.profileId + "', name:'" + p.characterName.replace(/'/g, "") + "', statPi:" + p.statWeightPi + "})\\nMERGE (c:SingleCastle {name:'Madinah_Priory_Core', pi:3.14})\\nMERGE (u)-[:GOVERNED_BY {commands:'" + p.commandsRuleStack.replace(/'/g, "") + "'}]->(c);").join('\\n\\n');
      } else {
        meta.textContent = 'Format #12: Abjad 261 Wafq & Collegiate Markdown Table (.md)';
        area.value = '# Sovereign Single-Castle 11-Vector Character & Combat Ledger (3.14 π)\\n\\n| Profile ID | Name | Stat π | Armor π | Weapon π | VFX | Commands |\\n|---|---|---|---|---|---|---|\\n' +
          profiles.map(p => '| ' + p.profileId + ' | ' + p.characterName + ' | ' + p.statWeightPi + 'π | ' + p.armorWeightPi + 'π | ' + p.weaponWeightPi + 'π | ' + p.vfxType + ' | `' + p.commandsRuleStack + '` |').join('\\n');
      }
    };

    G.injectStudioDataModel = function() {
      const area = document.getElementById('polyglotStudioTextarea');
      if (!area) return;
      try {
        if (state.currentStorageFormat === 0) {
          const parsed = JSON.parse(area.value);
          if (parsed.characterProfiles && Array.isArray(parsed.characterProfiles)) {
            window.SOV_PROFILES_DATA = parsed.characterProfiles;
          }
        }
      } catch (e) {
        // Non-JSON formats or custom DSL parsed symbolically
      }
      state.barakahPower += 314.0;
      G.triggerVfxBurst('EMPOWERED');
      G.addLog('Hot-injected Polyglot Data Model from Studio into live 2.5D Engine (+314.0π Power Surge)!', '#6EE7B7');
    };

    G.downloadCurrentFormatFile = function() {
      const exts = ['.json','.jsonl','.csv','.tsv','.sql','.yml','.toml','.xml','.pbtxt','.bin64','.cypher','.md'];
      const ext = exts[state.currentStorageFormat] || '.txt';
      const content = document.getElementById('polyglotStudioTextarea').value;
      const blob = new Blob([content], { type: 'text/plain;charset=utf-8' });
      const a = document.createElement('a');
      a.href = URL.createObjectURL(blob);
      a.download = 'sovereign-single-castle-314-model' + ext;
      a.click();
      G.addLog('Exported sovereign data model file: sovereign-single-castle-314-model' + ext, '#93C5FD');
    };

    // Castle Library 67 Tomes Search & Scenario Injection
    G.filterLibraryTomes = function(query) {
      const q = (query || '').toLowerCase().trim();
      const cards = document.querySelectorAll('#castleLibraryTomeGrid .tome-card');
      cards.forEach(card => {
        const text = card.textContent.toLowerCase();
        card.style.display = (!q || text.includes(q)) ? 'flex' : 'none';
      });
    };

    G.injectTomeScenario = function(seqNum) {
      const tomes = window.SOV_TOMES_DATA || [];
      const found = tomes.find(t => t.seq === seqNum) || { seq: seqNum, title: 'Tome #' + seqNum };
      state.barakahPower += 98.6;
      state.ummahNodes += 7;
      G.triggerVfxBurst('SPARKLES');
      G.addLog('Castle Library Tome #' + seqNum + ' [' + found.title + '] injected into 2.5D Grid (+98.6π Wisdom & +7 Autonomous Nodes)!', '#FDE68A');
    };

    G.studyAll67Tomes = function() {
      state.barakahPower += 314.0;
      state.barakahRate += 9.42;
      G.triggerVfxBurst('EMPOWERED');
      G.addLog('Good Warlock illuminated all 67 Knowledge Base Tomes in the Castle Library -> +314.0π Barakah & +9.42π/s Idle Rate!', '#6EE7B7');
    };

    // Initialize Clash Calculator & Polyglot Studio with Format #0 (JSON)
    document.getElementById('clashDefenderSelect').selectedIndex = 10;
    G.recalc11VectorClash();
    G.selectStorageFormat(0);
  })();
  </script>
</body>
</html>
""";
    }

    private static String escapeHtml(String input) {
        if (input == null) return "";
        return input
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }

    private static String escapeJs(String input) {
        if (input == null) return "";
        return input
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("'", "\u2019")
                .replace("\r", " ")
                .replace("\n", " ");
    }

    private static String sha256(String content) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(content.getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 unavailable", e);
        }
    }
}
