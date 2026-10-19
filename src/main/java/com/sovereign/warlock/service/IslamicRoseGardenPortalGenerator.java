package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.IslamicWayOfFlowerRoseAndGarden;
import com.sovereign.warlock.domain.IslamicWayOfFlowerRoseAndGarden.BotanicalWayPillar;
import com.sovereign.warlock.domain.IslamicWayOfFlowerRoseAndGarden.ChaharBaghRiverQuadrant;
import com.sovereign.warlock.domain.IslamicWayOfFlowerRoseAndGarden.CultivationStage;
import com.sovereign.warlock.domain.IslamicWayOfFlowerRoseAndGarden.IslamicGardenState;
import com.sovereign.warlock.domain.IslamicWayOfFlowerRoseAndGarden.RoseAnatomyLayer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

/**
 * Generates way-of-the-flower-rose-garden-islam.html:
 * The Canonical Islamic Way of the Flower (Tariqat Az-Zahrah), The Rose (Wardatan ka-ad-Dihan /
 * Gul-i Muhammadi), The Hand that Cultivates (Al-Yad Al-Gharisah), and The Fourfold Garden
 * (Al-Jannah bi-Rabwah & Chahar Bagh).
 */
public final class IslamicRoseGardenPortalGenerator {

    public WarlockHtmlPortalService.GeneratedHtmlArtifact generateRoseGardenPortal(Path outputDir) {
        try {
            Files.createDirectories(outputDir);
            String html = renderRoseGardenHtml();
            Path path = outputDir.resolve("way-of-the-flower-rose-garden-islam.html");
            Files.writeString(path, html, StandardCharsets.UTF_8);
            return new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                    "way-of-the-flower-rose-garden-islam.html",
                    path,
                    Files.size(path),
                    sha256(html),
                    "The Islamic Way of the Flower, the Rose (Wardatan ka-ad-Dihan), the Hand that Cultivates (Al-Yad Al-Gharisah) & the Chahar Bagh Garden"
            );
        } catch (IOException e) {
            throw new IllegalStateException("Failed generating Islamic Way of the Flower, Rose & Garden HTML portal", e);
        }
    }

    private String renderRoseGardenHtml() {
        IslamicGardenState gs = IslamicWayOfFlowerRoseAndGarden.canonicalGardenState();

        StringBuilder wayCards = new StringBuilder();
        for (BotanicalWayPillar p : IslamicWayOfFlowerRoseAndGarden.allFourBotanicalWayPillars()) {
            wayCards.append(String.format("""
                    <div class="pillar-card">
                      <div class="badge-row">
                        <span class="badge" style="color:#FDA4AF;">%s</span>
                        <span class="badge" style="color:#34D399;">%s</span>
                      </div>
                      <h3>%s</h3>
                      <div class="grid-3">
                        <div class="sub-box rose-box">
                          <div class="box-title" style="color:#FDA4AF;">I. Ontological Essence in Qur'an &amp; Sunnah</div>
                          <p>%s</p>
                        </div>
                        <div class="sub-box husb-box">
                          <div class="box-title" style="color:#34D399;">II. Sovereign Husbandry &amp; Domestic Sanctuary Synthesis</div>
                          <p>%s</p>
                        </div>
                        <div class="sub-box sufi-box">
                          <div class="box-title" style="color:#FDE68A;">III. Classical Sufi, Andalusian &amp; Ottoman Tradition</div>
                          <p>%s</p>
                          <p style="margin-top:0.5rem;font-size:0.79rem;color:#A5F3FC;"><strong>Scriptural Proof:</strong> %s</p>
                        </div>
                      </div>
                    </div>
                    """,
                    escape(p.pillarCode()),
                    escape(p.arabicTitle()),
                    escape(p.englishTitle()),
                    escape(p.ontologicalEssence()),
                    escape(p.husbandryAndDomesticSynthesis()),
                    escape(p.classicalSufiAndOttomanTradition()),
                    escape(p.quranicAndHadithAnchor())
            ));
        }

        StringBuilder anatomyRows = new StringBuilder();
        for (RoseAnatomyLayer a : IslamicWayOfFlowerRoseAndGarden.allFiveRoseAnatomyLayers()) {
            anatomyRows.append(String.format("""
                    <tr>
                      <td>
                        <strong style="color:#FDA4AF;">%s</strong><br>
                        <span style="font-size:0.82rem;color:#FDE68A;">%s</span>
                      </td>
                      <td style="font-size:0.83rem;color:#CBD5E1;">%s</td>
                      <td style="font-size:0.83rem;color:#A7F3D0;">%s</td>
                      <td style="font-size:0.81rem;color:#E9D5FF;">%s</td>
                    </tr>
                    """,
                    escape(a.arabicPartName()),
                    escape(a.englishPartName()),
                    escape(a.botanicalFunction()),
                    escape(a.spiritualAndRelationalMeaning()),
                    escape(a.scripturalAnchor())
            ));
        }

        StringBuilder stageRows = new StringBuilder();
        for (CultivationStage s : IslamicWayOfFlowerRoseAndGarden.allSevenCultivationStages()) {
            stageRows.append(String.format("""
                    <tr>
                      <td>
                        <strong style="color:#34D399;">%s</strong><br>
                        <span style="font-size:0.81rem;color:#FDE68A;">%s</span><br>
                        <code style="font-size:0.76rem;color:#38BDF8;">%s | Cp = %.2f</code>
                      </td>
                      <td style="font-size:0.83rem;color:#A7F3D0;">%s</td>
                      <td style="font-size:0.83rem;color:#FDA4AF;">%s</td>
                      <td style="font-size:0.81rem;color:#E9D5FF;">%s</td>
                    </tr>
                    """,
                    escape(s.arabicStageName()),
                    escape(s.englishStageTitle()),
                    escape(s.stageCode()),
                    s.spcCapabilityCp(),
                    escape(s.cultivatingHandAction()),
                    escape(s.flowerAndRoseResponse()),
                    escape(s.quranicAndSunnahProof())
            ));
        }

        StringBuilder riverRows = new StringBuilder();
        for (ChaharBaghRiverQuadrant r : IslamicWayOfFlowerRoseAndGarden.allFourChaharBaghRivers()) {
            riverRows.append(String.format("""
                    <tr>
                      <td>
                        <span style="display:inline-block;width:11px;height:11px;border-radius:50%%;background:%s;margin-right:6px;"></span>
                        <strong style="color:%s;">%s</strong><br>
                        <span style="font-size:0.81rem;color:#CBD5E1;">%s</span>
                      </td>
                      <td style="font-size:0.83rem;color:#FDA4AF;">%s</td>
                      <td style="font-size:0.83rem;color:#A7F3D0;">%s</td>
                      <td style="font-size:0.81rem;color:#FDE68A;">%s</td>
                    </tr>
                    """,
                    r.hexColor(),
                    r.hexColor(),
                    escape(r.arabicRiverName()),
                    escape(r.englishRiverTitle()),
                    escape(r.botanicalQuadrantPlanted()),
                    escape(r.domesticSanctuaryStream()),
                    escape(r.quranicVerse())
            ));
        }

        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>The Islamic Way of the Flower, the Rose, the Cultivating Hand &amp; the Chahar Bagh Garden</title>
  <style>
    :root {
      --bg-deep: #06090E;
      --bg-card: #101622;
      --text-main: #ECEFF4;
      --text-muted: #94A3B8;
      --border: rgba(255,255,255,0.12);
    }
    * { box-sizing: border-box; margin: 0; padding: 0; }
    body {
      background:
        radial-gradient(circle at top right, rgba(244, 63, 94, 0.16), transparent 48%%),
        radial-gradient(circle at top left, rgba(52, 211, 153, 0.14), var(--bg-deep) 68%%);
      color: var(--text-main);
      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
      line-height: 1.65;
      padding-bottom: 4rem;
    }
    header {
      background: rgba(6, 9, 14, 0.95);
      border-bottom: 2px solid #F43F5E;
      padding: 0.9rem 1.5rem;
      position: sticky;
      top: 0;
      z-index: 10;
    }
    .nav-bar {
      display: flex;
      flex-wrap: wrap;
      gap: 0.45rem;
      max-width: 1480px;
      margin: 0 auto;
      align-items: center;
    }
    .nav-pill {
      padding: 0.35rem 0.75rem;
      border-radius: 999px;
      background: var(--bg-card);
      border: 1px solid var(--border);
      color: var(--text-muted);
      text-decoration: none;
      font-size: 0.79rem;
      font-weight: 600;
    }
    .nav-pill.active, .nav-pill:hover {
      color: #FFF;
      border-color: #F43F5E;
      background: rgba(244, 63, 94, 0.16);
    }
    main {
      max-width: 1480px;
      margin: 1.8rem auto;
      padding: 0 1.5rem;
    }
    .hero {
      background: linear-gradient(135deg, #101622 0%%, #2B1222 50%%, #0F2922 100%%);
      border: 1px solid var(--border);
      border-left: 6px solid #F43F5E;
      border-radius: 14px;
      padding: 1.9rem;
      margin-bottom: 1.8rem;
    }
    .badge-row {
      display: flex;
      flex-wrap: wrap;
      gap: 0.45rem;
      margin-bottom: 0.75rem;
    }
    .badge {
      font-family: 'Consolas', monospace;
      font-size: 0.75rem;
      padding: 0.22rem 0.58rem;
      border-radius: 6px;
      background: rgba(255,255,255,0.06);
      border: 1px solid var(--border);
    }
    h1 { font-size: 1.9rem; margin-bottom: 0.55rem; }
    .canvas-box {
      position: relative;
      background: #04060A;
      border: 1px solid var(--border);
      border-radius: 14px;
      height: 500px;
      margin-bottom: 2rem;
      overflow: hidden;
    }
    canvas { width: 100%%; height: 100%%; display: block; cursor: grab; }
    .hud-top {
      position: absolute;
      top: 1rem;
      left: 1rem;
      background: rgba(6, 9, 14, 0.88);
      border: 1px solid var(--border);
      border-left: 4px solid #F43F5E;
      border-radius: 10px;
      padding: 0.85rem 1.1rem;
      max-width: 560px;
      pointer-events: none;
    }
    .mode-bar {
      position: absolute;
      bottom: 1rem;
      left: 1rem;
      right: 1rem;
      display: flex;
      flex-wrap: wrap;
      gap: 0.5rem;
      background: rgba(6, 9, 14, 0.88);
      border: 1px solid var(--border);
      border-radius: 10px;
      padding: 0.6rem;
    }
    .mode-btn {
      background: #101622;
      color: #CBD5E1;
      border: 1px solid var(--border);
      border-radius: 6px;
      padding: 0.4rem 0.8rem;
      font-size: 0.78rem;
      font-weight: 600;
      cursor: pointer;
    }
    .mode-btn.active, .mode-btn:hover {
      border-color: #F43F5E;
      color: #FFF;
      background: rgba(244, 63, 94, 0.22);
    }
    .code-grid {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(460px, 1fr));
      gap: 1.2rem;
      margin-bottom: 2rem;
    }
    .code-card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-top: 3px solid #F43F5E;
      border-radius: 12px;
      padding: 1.4rem;
    }
    pre {
      background: #070A10;
      border: 1px solid var(--border);
      border-radius: 8px;
      padding: 1rem;
      overflow-x: auto;
      font-family: 'Consolas', monospace;
      font-size: 0.8rem;
      color: #A7F3D0;
      line-height: 1.5;
    }
    .pillar-card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-left: 5px solid #F43F5E;
      border-radius: 12px;
      padding: 1.45rem;
      margin-bottom: 1.3rem;
    }
    .pillar-card h3 {
      font-size: 1.15rem;
      color: #FDE68A;
      margin-bottom: 0.7rem;
    }
    .grid-3 {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(310px, 1fr));
      gap: 0.9rem;
    }
    .sub-box {
      background: rgba(255,255,255,0.03);
      border: 1px solid var(--border);
      border-radius: 8px;
      padding: 0.95rem;
      font-size: 0.85rem;
    }
    .rose-box { border-top: 3px solid #F43F5E; }
    .husb-box { border-top: 3px solid #34D399; }
    .sufi-box { border-top: 3px solid #FDE68A; }
    .box-title {
      font-size: 0.75rem;
      font-weight: 700;
      text-transform: uppercase;
      letter-spacing: 0.05em;
      margin-bottom: 0.4rem;
    }
    .table-card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-radius: 14px;
      padding: 1.5rem;
      overflow-x: auto;
      margin-bottom: 2rem;
    }
    table {
      width: 100%%;
      border-collapse: collapse;
      font-size: 0.83rem;
    }
    th, td {
      text-align: left;
      padding: 0.7rem 0.6rem;
      border-bottom: 1px solid rgba(255,255,255,0.07);
      vertical-align: top;
    }
    th {
      color: var(--text-muted);
      font-size: 0.74rem;
      text-transform: uppercase;
      letter-spacing: 0.05em;
    }
    code {
      font-family: 'Consolas', monospace;
      color: #A5F3FC;
    }
  </style>
</head>
<body>
  <header>
    <nav class="nav-bar">
      <a class="nav-pill active" href="way-of-the-flower-rose-garden-islam.html">Way of the Flower, Rose &amp; Garden</a>
      <a class="nav-pill" href="islamic-husbandry-sovereign-estate.html">Islamic Husbandry (Al-Qiwamah)</a>
      <a class="nav-pill" href="warlock-apocrypha-islamic-theorems.html">Warlock Apocrypha &amp; Theorems</a>
      <a class="nav-pill" href="interlocker-egg-binder-islam.html">Islamic Intelocketer (Egg Binder)</a>
      <a class="nav-pill" href="warlock-formation-dissolution-jafar-aladdin.html">Ja'far &amp; Aladdin (Qumqum)</a>
      <a class="nav-pill" href="worlds-hegemon-disorder.html">7 Islamic Worlds</a>
      <a class="nav-pill" href="priory-negentropy-order.html">Negentropic Priory</a>
      <a class="nav-pill" href="order-1-white.html">Order #1..#7</a>
      <a class="nav-pill" href="dependencies-report.html">Dependencies Report</a>
    </nav>
  </header>

  <main>
    <section class="hero">
      <div class="badge-row">
        <span class="badge" style="color:#FDA4AF;">WAY OF THE FLOWER: NABATAN HASANA (QUR'AN 3:37 &amp; 50:7)</span>
        <span class="badge" style="color:#F43F5E;">WAY OF THE ROSE: WARDATAN KA-AD-DIHAN (QUR'AN 55:37 &amp; GUL-I MUHAMMADI)</span>
        <span class="badge" style="color:#34D399;">THE CULTIVATING HAND: AL-YAD AL-GHARISAH (MUSNAD AHMAD 12902)</span>
        <span class="badge" style="color:#FDE68A;">THE GARDEN: JANNAH BI-RABWAH &amp; CHAHAR BAGH (QUR'AN 2:265 &amp; 47:15)</span>
      </div>
      <h1>The Islamic Way of the Flower (<em>Az-Zahrah</em>), the Rose (<em>Al-Wardah</em>), the Hand that Cultivates (<em>Al-Yad Al-Gharisah</em>) &amp; the Garden (<em>Al-Jannah</em>)</h1>
      <p style="color:#CBD5E1;font-size:0.95rem;">
        Uniting the four botanical pillars of Islamic revelation and spiritual chivalry:
        <strong>(1) The Flower (<em>An-Nabat Al-Hasan</em>, Qur'an 3:37)</strong> sheltered in the <em>Mihrab</em> where provision arrives in peace;
        <strong>(2) The Crimson Rose (<em>Wardatan ka-ad-Dihan</em>, Qur'an 55:37 &amp; <em>Gul-i Muhammadi</em>)</strong> whose thorns face strictly outward as a defensive vanguard while its 7 concentric petal rings unfold only to light and gentle dew;
        <strong>(3) The Cultivating Hand (<em>Al-Yad Al-Gharisah</em>, Musnad Ahmad 12902)</strong> that plants the sapling even if the Final Hour erupts, demanding zero ego validation; and
        <strong>(4) The Walled Highland Garden (<em>Jannah bi-Rabwah</em> &amp; <em>Chahar Bagh</em>, Qur'an 2:265 &amp; 47:15)</strong> nourished by the Four Rivers of Paradise.
      </p>
    </section>

    <section class="canvas-box">
      <canvas id="roseCanvas"></canvas>
      <div class="hud-top">
        <div id="hudMode" style="font-family:Consolas,monospace;font-size:0.75rem;color:#FDA4AF;">MODE 1: THE CRIMSON ROSE (WARDATAN KA-AD-DIHAN — QUR'AN 55:37 &amp; GUL-I MUHAMMADI)</div>
        <div id="hudTitle" style="font-size:1rem;font-weight:700;margin:0.2rem 0;">7 Concentric Fibonacci Petal Spirals | Outward Vanguard Thorns | Dew of Tall</div>
        <div id="hudDesc" style="font-size:0.8rem;color:#CBD5E1;">Crimson-Gold: 7 concentric petal layers unfolding without forced pressure (0.000 kPa). Emerald Stem &amp; Cyan Spikes: Outward-facing protective thorns (Al-Qawi Al-Amin). Gold Motes: Dawn dewdrops (Tall, Qur'an 2:265).</div>
      </div>
      <div class="mode-bar">
        <button class="mode-btn active" onclick="setMode(1, this)">1. The Crimson Rose (Wardatan ka-ad-Dihan &amp; Outward Vanguard Thorns)</button>
        <button class="mode-btn" onclick="setMode(2, this)">2. The Hand that Cultivates (Al-Yad Al-Gharisah &amp; The Final Sapling)</button>
        <button class="mode-btn" onclick="setMode(3, this)">3. The Fourfold Garden (Chahar Bagh, 4 Rivers &amp; Walled Mihrab)</button>
      </div>
    </section>

    <div class="code-grid">
      <div class="code-card">
        <h2 style="font-size:1.1rem;color:#FDA4AF;margin-bottom:0.65rem;">Immutable Java 21+ Record: <code>IslamicGardenState</code></h2>
        <pre>public record IslamicGardenState(
    UUID gardenId,
    String sanctuaryName,
    String roseCultivarState,
    String cultivatingHandPosture,
    String thornVanguardOrientation,
    boolean isWalledMihrabSanctuary,
    double soilMoistureQadarRatio,
    double budForcingPressureKpa,
    double egoBoastingRatio,
    List&lt;String&gt; fourRiversActive,
    String quranicAndSunnahCharter
) {
    public IslamicGardenState {
        if (!isWalledMihrabSanctuary) {
            throw new IllegalStateException(
                "Sanctuary must be walled (Hurmat Al-Mihrab, Qur'an 3:37).");
        }
        if (!"OUTWARD_DEFENSIVE_SHIELD".equals(thornVanguardOrientation)) {
            throw new IllegalArgumentException(
                "Thorns must face outward to guard the rose, never inward.");
        }
        if (Math.abs(budForcingPressureKpa) &gt; 1e-12) {
            throw new IllegalStateException(
                "A rose unfolds by light and dew, never by prying fingers.");
        }
        if (Math.abs(egoBoastingRatio) &gt; 1e-12) {
            throw new IllegalStateException(
                "Sahib Al-Jannatayn arrogance forbidden (Qur'an 18:34).");
        }
    }
}</pre>
      </div>

      <div class="code-card" style="border-top-color:#34D399;">
        <h2 style="font-size:1.1rem;color:#34D399;margin-bottom:0.65rem;">Live Verified <code>IslamicGardenState</code> Telemetry</h2>
        <table>
          <tr><th>Garden UUID</th><td><code>%s</code></td></tr>
          <tr><th>Sanctuary Designation</th><td><strong style="color:#FDE68A;">%s</strong></td></tr>
          <tr><th>Rose Cultivar State (Qur'an 55:37)</th><td><code style="color:#FDA4AF;">%s</code></td></tr>
          <tr><th>Cultivating Hand Posture (Ahmad 12902)</th><td><code style="color:#34D399;">%s</code></td></tr>
          <tr><th>Thorn Vanguard Orientation</th><td><code style="color:#38BDF8;">%s</code></td></tr>
          <tr><th>Walled Mihrab Sanctuary (Qur'an 3:37)</th><td><code style="color:#34D399;">isWalledMihrabSanctuary = %s</code></td></tr>
          <tr><th>Soil Moisture Qadar &amp; Bud Forcing</th><td><code>Moisture: %.2f | Bud-Forcing: %.3f kPa | Ego Boast: %.3f</code></td></tr>
          <tr><th><code>isBloomInMizanHarmony()</code></th><td><strong style="color:#34D399;">%s (4/4 RIVERS ACTIVE — PASS)</strong></td></tr>
        </table>
      </div>
    </div>

    <h2 style="font-size:1.35rem;margin-bottom:1rem;color:#FDA4AF;">
      The 4 Canonical Pillars: The Flower, The Rose, The Cultivating Hand &amp; The Garden
    </h2>
    %s

    <section class="table-card" style="border-top:3px solid #F43F5E;">
      <h2 style="font-size:1.3rem;margin-bottom:0.9rem;color:#FDA4AF;">
        The 5 Anatomical Layers of the Islamic Rose (<em>Tashrih Al-Wardah Al-Muhammadiyyah</em>)
      </h2>
      <table>
        <thead>
          <tr>
            <th style="width:24%%;">Rose Layer &amp; Arabic Name</th>
            <th style="width:24%%;">Botanical Function</th>
            <th style="width:30%%;">Spiritual &amp; Relational Husbandry Meaning</th>
            <th style="width:22%%;">Qur'anic &amp; Hadith Anchor</th>
          </tr>
        </thead>
        <tbody>
          %s
        </tbody>
      </table>
    </section>

    <section class="table-card" style="border-top:3px solid #34D399;">
      <h2 style="font-size:1.3rem;margin-bottom:0.9rem;color:#34D399;">
        The 7 Stages of Cultivation: From Reviving Dead Earth to Distilling Immortal Rosewater
      </h2>
      <table>
        <thead>
          <tr>
            <th style="width:23%%;">Cultivation Stage &amp; Capability</th>
            <th style="width:27%%;">Action of the Cultivating Hand (<em>Al-Yad Al-Gharisah</em>)</th>
            <th style="width:26%%;">Response of the Flower &amp; Rose</th>
            <th style="width:24%%;">Qur'anic &amp; Prophetic Proof</th>
          </tr>
        </thead>
        <tbody>
          %s
        </tbody>
      </table>
    </section>

    <section class="table-card" style="border-top:3px solid #38BDF8;">
      <h2 style="font-size:1.3rem;margin-bottom:0.9rem;color:#38BDF8;">
        The Fourfold Islamic Garden (<em>Chahar Bagh</em>): The 4 Rivers of Paradise (Qur'an 47:15)
      </h2>
      <table>
        <thead>
          <tr>
            <th style="width:25%%;">River &amp; Garden Quadrant</th>
            <th style="width:25%%;">Sacred Botanical Flora Planted</th>
            <th style="width:26%%;">Domestic Sanctuary Stream</th>
            <th style="width:24%%;">Qur'anic Verse</th>
          </tr>
        </thead>
        <tbody>
          %s
        </tbody>
      </table>
    </section>
  </main>

  <script>
    let mode = 1;
    const canvas = document.getElementById('roseCanvas');
    const ctx = canvas.getContext('2d');
    let yaw = 0.45, pitch = 0.42, zoom = 1.0, dragging = false, lx = 0, ly = 0;

    function setMode(m, btn) {
      mode = m;
      document.querySelectorAll('.mode-btn').forEach(b => b.classList.remove('active'));
      btn.classList.add('active');
      const hm = document.getElementById('hudMode');
      const ht = document.getElementById('hudTitle');
      const hd = document.getElementById('hudDesc');
      if (m === 1) {
        hm.textContent = "MODE 1: THE CRIMSON ROSE (WARDATAN KA-AD-DIHAN — QUR'AN 55:37 & GUL-I MUHAMMADI)";
        hm.style.color = "#FDA4AF";
        ht.textContent = "7 Concentric Fibonacci Petal Spirals | Outward Vanguard Thorns | Dew of Tall";
        hd.textContent = "Crimson-Gold: 7 concentric petal layers unfolding without forced pressure (0.000 kPa). Emerald Stem & Cyan Spikes: Outward-facing protective thorns (Al-Qawi Al-Amin). Gold Motes: Dawn dewdrops (Tall, Qur'an 2:265).";
      } else if (m === 2) {
        hm.textContent = "MODE 2: THE HAND THAT CULTIVATES (AL-YAD AL-GHARISAH — MUSNAD AHMAD 12902)";
        hm.style.color = "#34D399";
        ht.textContent = "Planting the Fasilah Sapling | Aerated Loam | Copper Alembic Distillation";
        hd.textContent = "Bottom Amber Lattice: Revived dead earth (Ihya' Al-Ard, Qur'an 36:33). Emerald Root & Shoot: The Fasilah sapling standing firm on its stem (Qur'an 48:29). Top Copper-Gold Ring: Alembic rosewater condensation.";
      } else {
        hm.textContent = "MODE 3: THE FOURFOLD ISLAMIC GARDEN (CHAHAR BAGH & JANNAH BI-RABWAH — QUR'AN 47:15)";
        hm.style.color = "#FDE68A";
        ht.textContent = "Walled Mihrab Courtyard | 4 Rivers of Qur'an 47:15 | Central Salsabil Fountain";
        hd.textContent = "Cyan (Water), Ivory (Milk), Crimson (Pure Delight), and Gold (Clarified Honey) channels meeting at the octagonal Salsabil fountain inside the walled Mihrab sanctuary.";
      }
    }

    function resize() {
      canvas.width = canvas.clientWidth * window.devicePixelRatio;
      canvas.height = canvas.clientHeight * window.devicePixelRatio;
    }
    window.addEventListener('resize', resize);
    resize();

    canvas.addEventListener('mousedown', e => { dragging = true; lx = e.clientX; ly = e.clientY; });
    window.addEventListener('mouseup', () => dragging = false);
    window.addEventListener('mousemove', e => {
      if (!dragging) return;
      yaw += (e.clientX - lx) * 0.007;
      pitch = Math.max(-1.2, Math.min(1.2, pitch + (e.clientY - ly) * 0.007));
      lx = e.clientX; ly = e.clientY;
    });

    function proj(x, y, z, cx, cy, sc) {
      const cyw = Math.cos(yaw), syw = Math.sin(yaw);
      const x1 = x * cyw - z * syw;
      const z1 = x * syw + z * cyw;
      const cp = Math.cos(pitch), sp = Math.sin(pitch);
      const y2 = y * cp - z1 * sp;
      const z2 = y * sp + z1 * cp;
      const fov = 540 / (540 + z2);
      return [cx + x1 * sc * fov, cy - y2 * sc * fov];
    }

    function line3D(p1, p2, cx, cy, sc, color, w, alpha) {
      const a = proj(p1[0], p1[1], p1[2], cx, cy, sc);
      const b = proj(p2[0], p2[1], p2[2], cx, cy, sc);
      ctx.save();
      ctx.strokeStyle = color;
      ctx.globalAlpha = alpha;
      ctx.lineWidth = w;
      ctx.beginPath();
      ctx.moveTo(a[0], a[1]);
      ctx.lineTo(b[0], b[1]);
      ctx.stroke();
      ctx.restore();
    }

    function loop(ts) {
      const t = ts * 0.001;
      ctx.clearRect(0, 0, canvas.width, canvas.height);
      const cx = canvas.width / 2, cy = canvas.height / 2;
      if (!dragging) yaw += 0.0035;

      if (mode === 1) {
        // MODE 1: 3D Crimson Damascus Rose (7 concentric petal whorls + stem + outward thorns)
        const bloom = 0.85 + 0.15 * Math.sin(t * 1.4);
        // Stem
        line3D([0, -145, 0], [0, -15, 0], cx, cy, zoom, "#10B981", 3.2, 0.95);
        // Outward-facing thorns along the stem
        for (let th = 0; th < 6; th++) {
          const ty = -125 + th * 18;
          const tang = th * 2.094 + t * 0.4;
          const tx = Math.cos(tang) * 28, tz = Math.sin(tang) * 28;
          line3D([0, ty, 0], [tx, ty + 6, tz], cx, cy, zoom, "#38BDF8", 2.0, 0.9);
        }
        // 7 Concentric Petal Rings using Golden Angle (137.5 deg = 2.39996 rad)
        for (let ring = 1; ring <= 7; ring++) {
          const petalsInRing = 5 + ring * 2;
          const r = ring * 14 * bloom;
          const yBase = -15 + ring * 8;
          const color = ring <= 2 ? "#FDE68A" : (ring <= 5 ? "#F43F5E" : "#FDA4AF");
          for (let p = 0; p < petalsInRing; p++) {
            const a1 = (p / petalsInRing) * Math.PI * 2 + ring * 0.45;
            const a2 = ((p + 0.5) / petalsInRing) * Math.PI * 2 + ring * 0.45;
            const a3 = ((p + 1) / petalsInRing) * Math.PI * 2 + ring * 0.45;
            const p1 = [Math.cos(a1) * r * 0.75, yBase, Math.sin(a1) * r * 0.75];
            const tip = [Math.cos(a2) * r * 1.15, yBase + 18 + ring * 2, Math.sin(a2) * r * 1.15];
            const p3 = [Math.cos(a3) * r * 0.75, yBase, Math.sin(a3) * r * 0.75];
            line3D(p1, tip, cx, cy, zoom, color, 1.8, 0.88);
            line3D(tip, p3, cx, cy, zoom, color, 1.8, 0.88);
          }
        }
        // Gentle Dawn Dewdrops (Tall - Qur'an 2:265)
        for (let d = 0; d < 12; d++) {
          const da = (d / 12) * Math.PI * 2 + t * 0.6;
          const dr = 40 + (d %% 4) * 22;
          const dy = 20 + Math.sin(t * 2 + d) * 14;
          const pt = proj(Math.cos(da) * dr, dy, Math.sin(da) * dr, cx, cy, zoom);
          ctx.fillStyle = "#FDE68A";
          ctx.beginPath();
          ctx.arc(pt[0], pt[1], 3.2, 0, Math.PI * 2);
          ctx.fill();
        }
      } else if (mode === 2) {
        // MODE 2: The Hand that Cultivates (Aerated Soil + Fasilah Sapling + Alembic Dome)
        for (let g = -120; g <= 120; g += 40) {
          line3D([g, -85, -120], [g, -85, 120], cx, cy, zoom, "#B45309", 1.2, 0.6);
          line3D([-120, -85, g], [120, -85, g], cx, cy, zoom, "#B45309", 1.2, 0.6);
        }
        // Deep roots in dark soil (Al-'Irq fi At-Turab)
        for (let r = 0; r < 8; r++) {
          const a = (r / 8) * Math.PI * 2;
          line3D([0, -85, 0], [Math.cos(a) * 65, -135, Math.sin(a) * 65], cx, cy, zoom, "#F59E0B", 1.8, 0.85);
        }
        // Rising Fasilah Sapling & branches
        line3D([0, -85, 0], [0, 55, 0], cx, cy, zoom, "#34D399", 3.4, 0.95);
        for (let b = 0; b < 6; b++) {
          const by = -45 + b * 16;
          const ba = b * 1.3 + t * 0.3;
          line3D([0, by, 0], [Math.cos(ba) * 48, by + 22, Math.sin(ba) * 48], cx, cy, zoom, "#10B981", 2.1, 0.9);
        }
        // Copper Alembic Distillation Crown above
        for (let c = 0; c < 16; c++) {
          const a1 = (c / 16) * Math.PI * 2, a2 = ((c + 1) / 16) * Math.PI * 2;
          line3D([Math.cos(a1) * 75, 95, Math.sin(a1) * 75], [Math.cos(a2) * 75, 95, Math.sin(a2) * 75], cx, cy, zoom, "#F43F5E", 2.0, 0.85);
        }
      } else {
        // MODE 3: The Fourfold Islamic Garden (Chahar Bagh + 4 Rivers of Qur'an 47:15 + Walled Mihrab)
        const w = 150;
        // Outer Walled Mihrab Sanctuary
        line3D([-w, -40, -w], [w, -40, -w], cx, cy, zoom, "#34D399", 2.4, 0.9);
        line3D([w, -40, -w], [w, -40, w], cx, cy, zoom, "#34D399", 2.4, 0.9);
        line3D([w, -40, w], [-w, -40, w], cx, cy, zoom, "#34D399", 2.4, 0.9);
        line3D([-w, -40, w], [-w, -40, -w], cx, cy, zoom, "#34D399", 2.4, 0.9);
        // 4 Rivers of Qur'an 47:15 converging on the central Salsabil octagon
        line3D([0, -40, -w], [0, -40, -25], cx, cy, zoom, "#38BDF8", 4.0, 0.95); // Living Water
        line3D([0, -40, w], [0, -40, 25], cx, cy, zoom, "#F8F5E6", 4.0, 0.95);   // Unchanging Milk
        line3D([-w, -40, 0], [-25, -40, 0], cx, cy, zoom, "#F43F5E", 4.0, 0.95); // Crimson Delight
        line3D([w, -40, 0], [25, -40, 0], cx, cy, zoom, "#FBBF24", 4.0, 0.95);   // Clarified Honey
        // Central Salsabil Octagonal Fountain & Rising Jet
        for (let i = 0; i < 8; i++) {
          const a1 = (i / 8) * Math.PI * 2, a2 = ((i + 1) / 8) * Math.PI * 2;
          line3D([Math.cos(a1) * 28, -40, Math.sin(a1) * 28], [Math.cos(a2) * 28, -40, Math.sin(a2) * 28], cx, cy, zoom, "#FDE68A", 2.2, 0.95);
          line3D([0, 45 + Math.sin(t * 3) * 10, 0], [Math.cos(a1) * 24, -40, Math.sin(a1) * 24], cx, cy, zoom, "#38BDF8", 1.5, 0.8);
        }
      }

      requestAnimationFrame(loop);
    }
    requestAnimationFrame(loop);
  </script>
</body>
</html>
""".formatted(
                gs.gardenId(),
                escape(gs.sanctuaryName()),
                escape(gs.roseCultivarState()),
                escape(gs.cultivatingHandPosture()),
                escape(gs.thornVanguardOrientation()),
                gs.isWalledMihrabSanctuary(),
                gs.soilMoistureQadarRatio(),
                gs.budForcingPressureKpa(),
                gs.egoBoastingRatio(),
                gs.isBloomInMizanHarmony(),
                wayCards.toString(),
                anatomyRows.toString(),
                stageRows.toString(),
                riverRows.toString()
        );
    }

    private static String escape(String s) {
        if (s == null) {
            return "";
        }
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
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
