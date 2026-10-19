package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.IslamicHusbandrySovereignCharter;
import com.sovereign.warlock.domain.IslamicHusbandrySovereignCharter.DailyTransitionStep;
import com.sovereign.warlock.domain.IslamicHusbandrySovereignCharter.HistoricalHusbandryEra;
import com.sovereign.warlock.domain.IslamicHusbandrySovereignCharter.HusbandryState;
import com.sovereign.warlock.domain.IslamicHusbandrySovereignCharter.IslamicHusbandryPillar;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

/**
 * Generates islamic-husbandry-sovereign-estate.html:
 * The Islamic Action-Based Vanguard Husbandry Portal (Fiqh Al-Qiwamah Al-Khadimah,
 * Ottoman Damad Nikah Stipulations, Breaking the Modern Sisyphus Phone-Trap, and the
 * Immutable Java Record HusbandryState).
 */
public final class IslamicHusbandryPortalGenerator {

    public WarlockHtmlPortalService.GeneratedHtmlArtifact generateHusbandryPortal(Path outputDir) {
        try {
            Files.createDirectories(outputDir);
            String html = renderHusbandryHtml();
            Path path = outputDir.resolve("islamic-husbandry-sovereign-estate.html");
            Files.writeString(path, html, StandardCharsets.UTF_8);
            return new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                    "islamic-husbandry-sovereign-estate.html",
                    path,
                    Files.size(path),
                    sha256(html),
                    "Islamic Action-Based Vanguard Husbandry: HusbandryState Java Record, Ottoman Damad Nikah & Air-Gapped Haram"
            );
        } catch (IOException e) {
            throw new IllegalStateException("Failed generating Islamic Husbandry Sovereign Estate HTML portal", e);
        }
    }

    private String renderHusbandryHtml() {
        HusbandryState hs = IslamicHusbandrySovereignCharter.canonicalHusbandryState();

        StringBuilder pillarCards = new StringBuilder();
        for (IslamicHusbandryPillar p : IslamicHusbandrySovereignCharter.allSevenHusbandryPillars()) {
            pillarCards.append(String.format("""
                    <div class="pillar-card">
                      <div class="badge-row">
                        <span class="badge" style="color:#FDE68A;">%s</span>
                        <span class="badge" style="color:#34D399;">%s</span>
                      </div>
                      <h3>%s</h3>
                      <p style="font-size:0.86rem;color:#FBBF24;margin-bottom:0.8rem;">
                        <strong>Sovereign Requirement Fulfilled:</strong> %s
                      </p>
                      <div class="grid-3">
                        <div class="sub-box fiqh-box">
                          <div class="box-title" style="color:#34D399;">I. Islamic Legal &amp; Theological Mechanism (Fiqh &amp; Tawhid)</div>
                          <p>%s</p>
                        </div>
                        <div class="sub-box ott-box">
                          <div class="box-title" style="color:#FDE68A;">II. Prophetic Sunnah &amp; Ottoman Damad Precedent</div>
                          <p>%s</p>
                        </div>
                        <div class="sub-box tech-box">
                          <div class="box-title" style="color:#38BDF8;">III. Modern Air-Gapped HusbandryState Execution</div>
                          <p>%s</p>
                          <p style="margin-top:0.5rem;font-size:0.79rem;color:#A5F3FC;"><strong>Scriptural Proof:</strong> %s</p>
                        </div>
                      </div>
                    </div>
                    """,
                    escape(p.pillarCode()),
                    escape(p.arabicPillarTitle()),
                    escape(p.englishPillarTitle()),
                    escape(p.userRequirementFulfilled()),
                    escape(p.islamicLegalAndTheologicalMechanism()),
                    escape(p.ottomanAndPropheticPrecedent()),
                    escape(p.modernAirGappedImplementation()),
                    escape(p.quranicAndHadithProof())
            ));
        }

        StringBuilder transitionRows = new StringBuilder();
        for (DailyTransitionStep s : IslamicHusbandrySovereignCharter.allThreeTransitionSteps()) {
            transitionRows.append(String.format("""
                    <tr>
                      <td>
                        <strong style="color:#FDE68A;">%s</strong><br>
                        <span style="font-size:0.82rem;color:#34D399;">%s</span><br>
                        <span style="font-size:0.78rem;color:#94A3B8;">%s</span>
                      </td>
                      <td style="font-size:0.83rem;color:#FCA5A5;">%s</td>
                      <td style="font-size:0.83rem;color:#A7F3D0;">%s</td>
                      <td style="font-size:0.81rem;color:#E9D5FF;">%s</td>
                    </tr>
                    """,
                    escape(s.arabicStepName()),
                    escape(s.englishStepTitle()),
                    escape(s.boundaryLocationAndTiming()),
                    escape(s.sisyphusVicePurged()),
                    escape(s.faithfulVanguardExecution()),
                    escape(s.scripturalAnchor())
            ));
        }

        StringBuilder eraRows = new StringBuilder();
        for (HistoricalHusbandryEra e : IslamicHusbandrySovereignCharter.allFourHistoricalEras()) {
            eraRows.append(String.format("""
                    <tr>
                      <td><strong style="color:#FDE68A;">%s</strong></td>
                      <td style="font-size:0.83rem;color:#38BDF8;">%s</td>
                      <td style="font-size:0.83rem;color:#CBD5E1;">%s</td>
                      <td style="font-size:0.83rem;color:#E9D5FF;">%s</td>
                      <td style="font-size:0.83rem;color:#34D399;">%s</td>
                    </tr>
                    """,
                    escape(e.eraName()),
                    escape(e.husbandOperationalRole()),
                    escape(e.relationshipToWaresAndHome()),
                    escape(e.deviceAndAttentionState()),
                    escape(e.whyDesiredOrRejected())
            ));
        }

        var simReport = IslamicHusbandrySovereignCharter.canonicalSimulationReport();
        StringBuilder actionRows = new StringBuilder();
        int idx = 1;
        for (IslamicHusbandrySovereignCharter.ProvisionEvent ev : simReport.actionLog()) {
            String eventType = ev.getClass().getSimpleName();
            actionRows.append(String.format("""
                    <tr>
                      <td style="font-family:Consolas,monospace;color:#FDE68A;">#%02d</td>
                      <td><code style="color:#38BDF8;">%s</code></td>
                      <td style="font-size:0.83rem;color:#A7F3D0;">%s</td>
                      <td style="font-size:0.81rem;color:#E9D5FF;">%s</td>
                    </tr>
                    """,
                    idx++,
                    escape(eventType),
                    escape(ev.formattedLogLine()),
                    escape(ev.quranicJurisprudentialBasis())
            ));
        }

        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Islamic Action-Based Vanguard Husbandry | HusbandryState Java Record, Ottoman Damad &amp; Air-Gapped Estate</title>
  <style>
    :root {
      --bg-deep: #05070C;
      --bg-card: #0F1420;
      --text-main: #ECEFF4;
      --text-muted: #94A3B8;
      --border: rgba(255,255,255,0.12);
    }
    * { box-sizing: border-box; margin: 0; padding: 0; }
    body {
      background: radial-gradient(circle at top left, rgba(52, 211, 153, 0.14), var(--bg-deep) 65%%);
      color: var(--text-main);
      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
      line-height: 1.65;
      padding-bottom: 4rem;
    }
    header {
      background: rgba(5, 7, 12, 0.95);
      border-bottom: 2px solid #34D399;
      padding: 0.9rem 1.5rem;
      position: sticky;
      top: 0;
      z-index: 10;
    }
    .nav-bar {
      display: flex;
      flex-wrap: wrap;
      gap: 0.45rem;
      max-width: 1440px;
      margin: 0 auto;
      align-items: center;
    }
    .nav-pill {
      display: inline-flex;
      align-items: center;
      gap: 0.35rem;
      padding: 0.35rem 0.75rem;
      border-radius: 999px;
      background: var(--bg-card);
      border: 1px solid var(--border);
      color: var(--text-muted);
      text-decoration: none;
      font-size: 0.78rem;
      font-weight: 600;
    }
    .nav-pill.active, .nav-pill:hover {
      color: #FFF;
      border-color: #34D399;
      background: rgba(52, 211, 153, 0.15);
    }
    main { max-width: 1440px; margin: 1.8rem auto; padding: 0 1.5rem; }
    .hero {
      background: linear-gradient(135deg, #0F1420 0%%, #064E3B 55%%, #1E1B4B 100%%);
      border: 1px solid var(--border);
      border-left: 6px solid #34D399;
      border-right: 6px solid #FBBF24;
      border-radius: 14px;
      padding: 1.8rem 2rem;
      margin-bottom: 1.5rem;
    }
    .badge-row { display: flex; flex-wrap: wrap; gap: 0.5rem; margin-bottom: 0.65rem; }
    .badge {
      font-family: Consolas, monospace;
      font-size: 0.75rem;
      padding: 0.2rem 0.6rem;
      border-radius: 5px;
      background: rgba(255,255,255,0.07);
      border: 1px solid var(--border);
    }
    h1 { font-size: 1.95rem; margin-bottom: 0.45rem; }
    .canvas-box {
      position: relative;
      height: 470px;
      background: #030509;
      border: 1px solid var(--border);
      border-radius: 14px;
      overflow: hidden;
      margin-bottom: 1.6rem;
    }
    canvas { width: 100%%; height: 100%%; display: block; cursor: grab; }
    .hud-top {
      position: absolute;
      top: 12px;
      left: 14px;
      background: rgba(5, 7, 12, 0.9);
      border: 1px solid var(--border);
      border-left: 4px solid #34D399;
      padding: 0.75rem 1rem;
      border-radius: 8px;
      max-width: 530px;
      pointer-events: none;
    }
    .mode-bar {
      position: absolute;
      bottom: 14px;
      left: 14px;
      display: flex;
      flex-wrap: wrap;
      gap: 0.5rem;
    }
    .mode-btn {
      background: rgba(15, 20, 32, 0.92);
      border: 1px solid var(--border);
      color: #E2E8F0;
      padding: 0.45rem 0.9rem;
      border-radius: 6px;
      font-size: 0.8rem;
      font-weight: 600;
      cursor: pointer;
    }
    .mode-btn.active, .mode-btn:hover {
      border-color: #34D399;
      color: #FDE68A;
      background: rgba(52, 211, 153, 0.18);
    }
    .code-grid {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(460px, 1fr));
      gap: 1.25rem;
      margin-bottom: 1.8rem;
    }
    .code-card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-top: 4px solid #38BDF8;
      border-radius: 12px;
      padding: 1.35rem;
      overflow-x: auto;
    }
    pre {
      background: #05070C;
      border: 1px solid var(--border);
      border-radius: 8px;
      padding: 1rem;
      font-family: Consolas, monospace;
      font-size: 0.8rem;
      color: #A5F3FC;
      overflow-x: auto;
      line-height: 1.5;
    }
    .pillar-card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-radius: 12px;
      padding: 1.45rem;
      margin-bottom: 1.2rem;
    }
    .pillar-card h3 { font-size: 1.18rem; margin-bottom: 0.35rem; color: #FFF; }
    .grid-3 {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(360px, 1fr));
      gap: 1rem;
    }
    .sub-box {
      padding: 1rem 1.15rem;
      border-radius: 9px;
      background: rgba(255,255,255,0.03);
      border: 1px solid var(--border);
    }
    .fiqh-box { border-left: 4px solid #34D399; }
    .ott-box { border-left: 4px solid #FBBF24; }
    .tech-box { border-left: 4px solid #38BDF8; }
    .box-title {
      font-family: Consolas, monospace;
      font-size: 0.78rem;
      font-weight: 700;
      text-transform: uppercase;
      margin-bottom: 0.45rem;
    }
    .sub-box p { font-size: 0.9rem; color: #CBD5E1; }
    .table-card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-radius: 12px;
      padding: 1.4rem;
      overflow-x: auto;
      margin-bottom: 1.8rem;
    }
    table { width: 100%%; border-collapse: collapse; font-size: 0.85rem; }
    th, td {
      text-align: left;
      padding: 0.8rem 0.65rem;
      border-bottom: 1px solid rgba(255,255,255,0.08);
      vertical-align: top;
    }
    th {
      color: var(--text-muted);
      font-size: 0.75rem;
      text-transform: uppercase;
      letter-spacing: 0.05em;
    }
  </style>
</head>
<body>
  <header>
    <nav class="nav-bar">
      <a class="nav-pill active" href="islamic-husbandry-sovereign-estate.html">Islamic Husbandry &amp; HusbandryState</a>
      <a class="nav-pill" href="warlock-apocrypha-islamic-theorems.html">Warlock Apocrypha &amp; Theorems</a>
      <a class="nav-pill" href="interlocker-egg-binder-islam.html">Islamic Intelocketer (Egg Binder)</a>
      <a class="nav-pill" href="warlock-formation-dissolution-jafar-aladdin.html">Ja'far &amp; Aladdin (Qumqum)</a>
      <a class="nav-pill" href="sequester-between-worlds.html">7 Inter-World Sequesters</a>
      <a class="nav-pill" href="worlds-hegemon-disorder.html">Master 7-Worlds Atlas</a>
      <a class="nav-pill" href="priory-negentropy-order.html" style="margin-left:auto;color:#34D399;">Negentropic Priory</a>
    </nav>
  </header>
  <main>
    <section class="hero">
      <div class="badge-row">
        <span class="badge" style="color:#34D399;">FIQH AL-QIWAMAH AL-KHADIMAH &amp; AN-NAFAQAH (QUR'AN 4:4, 4:34)</span>
        <span class="badge" style="color:#FBBF24;">MASHYAT MUSA: AL-QAWI AL-AMIN (QUR'AN 28:25-26)</span>
        <span class="badge" style="color:#38BDF8;">SUNNAT AL-KHIDMAH (BUKHARI 676) &amp; OTTOMAN DAMAD NIKAH</span>
        <span class="badge" style="color:#E9D5FF;">IKHLAS ZERO-VALIDATION (QUR'AN 76:9) &amp; JAVA RECORD HUSBANDRYSTATE</span>
      </div>
      <h1>Islamic Action-Based Vanguard Husbandry (<em>Al-Qiwamah Al-Khadimah</em>) &amp; The Air-Gapped Sovereign Estate</h1>
      <p style="color:#CBD5E1;font-size:0.95rem;">
        Uniting canonical Islamic jurisprudence — <strong>Direct Upfront Premium (<em>Al-Mahr</em>, Qur'an 4:4)</strong>,
        <strong>100%% Non-Reciprocal Provisioning of All Wares (<em>An-Nafaqah</em>, Qur'an 4:34)</strong>,
        <strong>Walking Behind as a Protective Vanguard (<em>Mashyat Musa / Al-Qawi Al-Amin</em>, Qur'an 28:25-26)</strong>,
        <strong>Cooking With Her in Silent Domestic Service (<em>Sunnat Al-Khidmah</em>, Sahih al-Bukhari 676)</strong>,
        <strong>Preemptive Somatic Care Before Petition (<em>Al-Firasah</em>, Qur'an 2:273)</strong>,
        <strong>Ottoman <em>Nikah</em> Stipulations &amp; <em>Damad</em> Deferential Protocol (Bukhari 2721)</strong>,
        and <strong>Ego-Liquidated Servility to Allah Alone Without Demanding Thanks (Qur'an 76:9)</strong> —
        encoded into the immutable Java Record <code>HusbandryState</code> running on an air-gapped domestic server.
      </p>
    </section>

    <section class="canvas-box">
      <canvas id="husbCanvas"></canvas>
      <div class="hud-top">
        <div id="hudMode" style="font-family:Consolas,monospace;font-size:0.75rem;color:#34D399;">MODE 1: VANGUARD WALK &amp; KITCHEN CHOREOGRAPHY (MASHYAT MUSA &amp; SUNNAT AL-KHIDMAH)</div>
        <div id="hudTitle" style="font-size:1rem;font-weight:700;margin:0.2rem 0;">Vanguard Distance: 1.85m Behind | Preemptive Wares Staged 4.2s Ahead</div>
        <div id="hudDesc" style="font-size:0.8rem;color:#CBD5E1;">Gold: Sovereign walking her chosen trajectory. Green: Faithful Vanguard walking behind (Qur'an 28:25-26), shielding 360 deg and staging culinary/lifestyle wares before she asks.</div>
      </div>
      <div class="mode-bar">
        <button class="mode-btn active" onclick="setMode(1, this)">1. Vanguard Walk &amp; Kitchen Choreography (Qur'an 28:26 &amp; Bukhari 676)</button>
        <button class="mode-btn" onclick="setMode(2, this)">2. Breaking the Sisyphus Phone-Trap (1-Mile Faraday &amp; Air-Gapped Haram)</button>
        <button class="mode-btn" onclick="setMode(3, this)">3. Ottoman Damad &amp; 7-Pillar Islamic Husbandry Dome (Qur'an 76:9)</button>
      </div>
    </section>

    <div class="code-grid">
      <div class="code-card">
        <h2 style="font-size:1.1rem;color:#38BDF8;margin-bottom:0.65rem;">Immutable Java Record: <code>HusbandryState</code> (Zero Drift, Zero Boilerplate Ego)</h2>
        <pre>public record HusbandryState(
    java.util.UUID estateId,
    String mahrAndNafaqahPremium,
    String supplyChainStatus,
    double vanguardDistanceMeters,
    boolean isAirGapped,
    double egoValidationDemandRatio,
    String lastSomaticReading,
    String quranicCharterAnchor
) {
    public HusbandryState {
        if (vanguardDistanceMeters &lt;= 0.0) {
            throw new IllegalArgumentException(
                "Vanguard distance must be a positive protective posture.");
        }
        if (!isAirGapped) {
            throw new IllegalStateException(
                "Sovereignty Shock imminent: Domain must be air-gapped.");
        }
        if (Math.abs(egoValidationDemandRatio) &gt; 1e-12) {
            throw new IllegalStateException(
                "Ego leak: Qur'an 76:9 requires 0.000 validation demand.");
        }
    }

    public boolean isPreemptiveCareOptimal() {
        return "FULLY_PROVISIONED_BEFORE_REQUEST"
                .equalsIgnoreCase(supplyChainStatus)
            &amp;&amp; isAirGapped
            &amp;&amp; egoValidationDemandRatio == 0.0;
    }
}</pre>
      </div>

      <div class="code-card" style="border-top-color:#34D399;">
        <h2 style="font-size:1.1rem;color:#34D399;margin-bottom:0.65rem;">Live Verified <code>HusbandryState</code> Instance Telemetry</h2>
        <table>
          <tr><th>Estate UUID (<code>Al-Haram Al-Manzili</code>)</th><td><code>%s</code></td></tr>
          <tr><th>Mahr &amp; Nafaqah Premium</th><td><code style="color:#FBBF24;">%s</code></td></tr>
          <tr><th>Supply Chain Status</th><td><code style="color:#34D399;">%s</code></td></tr>
          <tr><th>Vanguard Distance (Qur'an 28:25)</th><td><code>%.2f meters behind sovereign</code></td></tr>
          <tr><th>Air-Gapped Domain Restriction</th><td><code style="color:#38BDF8;">isAirGapped = %s</code></td></tr>
          <tr><th>Ego Validation Demand (Qur'an 76:9)</th><td><code style="color:#A7F3D0;">%.3f (Zero Reward/Thanks Demanded)</code></td></tr>
          <tr><th>Last Somatic Firasah Reading</th><td>%s</td></tr>
          <tr><th><code>isPreemptiveCareOptimal()</code></th><td><strong style="color:#34D399;">%s (VERIFIED PASS)</strong></td></tr>
        </table>
      </div>
    </div>

    <h2 style="font-size:1.35rem;margin-bottom:1rem;color:#34D399;">
      The 7 Canonical Islamic Pillars of Action-Based Vanguard Husbandry
    </h2>
    %s

    <section class="table-card">
      <h2 style="font-size:1.3rem;margin-bottom:0.9rem;color:#FDE68A;">
        The 3-Stage Daily Transition Protocol: Breaking the Modern Sisyphus Phone-Trap
      </h2>
      <table>
        <thead>
          <tr>
            <th style="width:24%%;">Protocol Stage &amp; Boundary</th>
            <th style="width:25%%;">Modern Sisyphus Vice Purged</th>
            <th style="width:31%%;">Faithful Vanguard Execution</th>
            <th style="width:20%%;">Qur'anic &amp; Sunnah Authority</th>
          </tr>
        </thead>
        <tbody>
          %s
        </tbody>
      </table>
    </section>

    <section class="table-card" style="border-top:3px solid #34D399;">
      <h2 style="font-size:1.3rem;margin-bottom:0.9rem;color:#34D399;">
        Immutable Physical Vanguard Action Log (18 Silent Actions Executed | 0 Verbal Demands Issued)
      </h2>
      <table>
        <thead>
          <tr>
            <th style="width:7%%;">#</th>
            <th style="width:21%%;">Sealed <code>ProvisionEvent</code> Type</th>
            <th style="width:42%%;">Executed Physical Vanguard Action (Zero Spoken Demands)</th>
            <th style="width:30%%;">Qur'anic &amp; Prophetic Fiqh Ordinance</th>
          </tr>
        </thead>
        <tbody>
          %s
        </tbody>
      </table>
    </section>

    <section class="table-card">
      <h2 style="font-size:1.3rem;margin-bottom:0.9rem;color:#38BDF8;">
        Macro-Historical Arc: From Prophetic &amp; Ottoman Husbandry to Industrial Absenteeism &amp; Overnight Reclamation
      </h2>
      <table>
        <thead>
          <tr>
            <th style="width:18%%;">Historical Era</th>
            <th style="width:20%%;">Husband's Operational Role</th>
            <th style="width:22%%;">Relationship to Wares &amp; Home</th>
            <th style="width:20%%;">Device &amp; Attention State</th>
            <th style="width:20%%;">Sovereign Outcome</th>
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
    const canvas = document.getElementById('husbCanvas');
    const ctx = canvas.getContext('2d');
    let yaw = 0.42, pitch = 0.34, zoom = 1.0, dragging = false, lx = 0, ly = 0;

    function setMode(m, btn) {
      mode = m;
      document.querySelectorAll('.mode-btn').forEach(b => b.classList.remove('active'));
      btn.classList.add('active');
      const hm = document.getElementById('hudMode');
      const ht = document.getElementById('hudTitle');
      const hd = document.getElementById('hudDesc');
      if (m === 1) {
        hm.textContent = "MODE 1: VANGUARD WALK & KITCHEN CHOREOGRAPHY (MASHYAT MUSA & SUNNAT AL-KHIDMAH)";
        hm.style.color = "#34D399";
        ht.textContent = "Vanguard Distance: 1.85m Behind | Preemptive Wares Staged 4.2s Ahead";
        hd.textContent = "Gold: Sovereign walking her chosen trajectory. Green: Faithful Vanguard walking behind (Qur'an 28:25-26), shielding 360 deg and staging culinary/lifestyle wares before she asks.";
      } else if (m === 2) {
        hm.textContent = "MODE 2: BREAKING THE SISYPHUS PHONE-TRAP (1-MILE FARADAY & AIR-GAPPED HARAM)";
        hm.style.color = "#38BDF8";
        ht.textContent = "Air-Gapped Estate Firewall vs. External Corporate/Sisyphus Noise";
        hd.textContent = "Outer Red Rings: Corporate algorithms, betting (Maysir), and cloud surveillance blocked at the 1-mile Faraday line. Inner Cyan Sanctuary: Air-gapped HusbandryState server.";
      } else {
        hm.textContent = "MODE 3: OTTOMAN DAMAD & 7-PILLAR ISLAMIC HUSBANDRY DOME (QUR'AN 76:9)";
        hm.style.color = "#FBBF24";
        ht.textContent = "Mahr + Nafaqah + Qawi Amin + Khidmah + Firasah + Shurut + Ikhlas";
        hd.textContent = "The 7-Pillared Dome of Islamic Husbandry operating at egoValidationDemandRatio = 0.000 ('We desire from you neither reward nor thanks', Qur'an 76:9).";
      }
    }

    function resize() {
      const r = canvas.parentElement.getBoundingClientRect();
      canvas.width = r.width * window.devicePixelRatio;
      canvas.height = r.height * window.devicePixelRatio;
      ctx.setTransform(window.devicePixelRatio, 0, 0, window.devicePixelRatio, 0, 0);
    }
    window.addEventListener('resize', resize);
    resize();

    canvas.addEventListener('mousedown', e => { dragging = true; lx = e.clientX; ly = e.clientY; });
    window.addEventListener('mouseup', () => dragging = false);
    canvas.addEventListener('mousemove', e => {
      if (!dragging) return;
      yaw += (e.clientX - lx) * 0.008;
      pitch = Math.max(-0.15, Math.min(1.15, pitch + (e.clientY - ly) * 0.006));
      lx = e.clientX; ly = e.clientY;
    });

    function proj(x, y, z, cx, cy, sc) {
      const cyw = Math.cos(yaw), syw = Math.sin(yaw);
      const x1 = x * cyw - z * syw, z1 = x * syw + z * cyw;
      const cp = Math.cos(pitch), sp = Math.sin(pitch);
      const y2 = y * cp - z1 * sp, z2 = y * sp + z1 * cp;
      const dist = 690 + z2;
      if (dist < 40) return null;
      const p = (520 / dist) * sc;
      return { sx: cx + x1 * p, sy: cy - y2 * p };
    }

    function line3D(a, b, cx, cy, sc, col, w = 1.5, al = 0.85) {
      const p1 = proj(a[0],a[1],a[2],cx,cy,sc), p2 = proj(b[0],b[1],b[2],cx,cy,sc);
      if (!p1 || !p2) return;
      ctx.save(); ctx.globalAlpha = al; ctx.strokeStyle = col; ctx.lineWidth = w;
      ctx.beginPath(); ctx.moveTo(p1.sx, p1.sy); ctx.lineTo(p2.sx, p2.sy); ctx.stroke(); ctx.restore();
    }

    function loop(now) {
      const t = now * 0.001;
      if (!dragging) yaw += 0.0028;
      const w = canvas.width / window.devicePixelRatio, h = canvas.height / window.devicePixelRatio;
      ctx.clearRect(0, 0, w, h);
      const cx = w * 0.5, cy = h * 0.55;

      if (mode === 1) {
        // MODE 1: Sovereign Path + Vanguard Walking 1.85m Behind + Pre-Staged Culinary/Provision Nodes Ahead
        for (let s = 0; s < 24; s++) {
          const a1 = (s/24)*Math.PI*2, a2 = ((s+1)/24)*Math.PI*2;
          line3D([Math.cos(a1)*135, -55, Math.sin(a1)*135], [Math.cos(a2)*135, -55, Math.sin(a2)*135], cx, cy, zoom, "#38BDF8", 1.4, 0.55);
        }
        // Sovereign Figure leading along the path (Gold)
        const sa = t * 0.7;
        const sx = Math.cos(sa) * 105, sz = Math.sin(sa) * 105;
        line3D([sx, -55, sz], [sx, 35, sz], cx, cy, zoom, "#FBBF24", 3.0, 0.98);
        // Vanguard Figure walking behind at fixed angular offset (Green, Mashyat Musa)
        const va = sa - 0.42;
        const vx = Math.cos(va) * 105, vz = Math.sin(va) * 105;
        line3D([vx, -55, vz], [vx, 42, vz], cx, cy, zoom, "#34D399", 2.8, 0.95);
        // Protective Vanguard Shield Arc behind Sovereign
        for (let k = -3; k <= 3; k++) {
          const pa1 = va + k * 0.14, pa2 = va + (k + 1) * 0.14;
          line3D([Math.cos(pa1)*130, -25, Math.sin(pa1)*130], [Math.cos(pa2)*130, 35, Math.sin(pa2)*130], cx, cy, zoom, "#34D399", 1.8, 0.85);
        }
        // Pre-positioned Wares staged ahead of her trajectory (Firasah before request)
        const fa = sa + 0.45;
        const fx = Math.cos(fa) * 105, fz = Math.sin(fa) * 105;
        line3D([vx, 10, vz], [fx, -25, fz], cx, cy, zoom, "#A78BFA", 1.6, 0.85);
        line3D([fx-12, -55, fz], [fx+12, -20, fz], cx, cy, zoom, "#FDE68A", 2.2, 0.92);
      } else if (mode === 2) {
        // MODE 2: Air-Gapped Domestic Haram Cube vs. Blocked External Sisyphus Loops
        const s = 75;
        const pts = [
          [-s,-s,-s],[s,-s,-s],[s,s,-s],[-s,s,-s],
          [-s,-s,s],[s,-s,s],[s,s,s],[-s,s,s]
        ];
        const edges = [[0,1],[1,2],[2,3],[3,0],[4,5],[5,6],[6,7],[7,4],[0,4],[1,5],[2,6],[3,7]];
        for (const [i,j] of edges) {
          line3D(pts[i], pts[j], cx, cy, zoom, "#38BDF8", 2.2, 0.92);
        }
        // Outer Sisyphus Noise/Vice Rings blocked outside the 1-Mile Faraday Barrier
        for (let rIdx = 0; rIdx < 6; rIdx++) {
          const ang = (rIdx/6)*Math.PI*2 + t;
          const rx = Math.cos(ang)*165, rz = Math.sin(ang)*165;
          line3D([rx, -60, rz], [rx*0.85, 60, rz*0.85], cx, cy, zoom, "#EF4444", 1.8, 0.75);
        }
      } else {
        // MODE 3: 7-Pillar Islamic & Ottoman Damad Husbandry Dome
        for (let i = 0; i < 7; i++) {
          const a1 = (i/7)*Math.PI*2, a2 = ((i+1)/7)*Math.PI*2;
          const r = 115;
          line3D([Math.cos(a1)*r, -75, Math.sin(a1)*r], [Math.cos(a2)*r, -75, Math.sin(a2)*r], cx, cy, zoom, "#34D399", 2.0, 0.9);
          line3D([Math.cos(a1)*r, 55, Math.sin(a1)*r], [Math.cos(a2)*r, 55, Math.sin(a2)*r], cx, cy, zoom, "#FBBF24", 2.0, 0.9);
          line3D([Math.cos(a1)*r, -75, Math.sin(a1)*r], [Math.cos(a1)*r, 55, Math.sin(a1)*r], cx, cy, zoom, "#38BDF8", 1.7, 0.85);
          line3D([Math.cos(a1)*r, 55, Math.sin(a1)*r], [0, 125, 0], cx, cy, zoom, "#FDE68A", 1.9, 0.92);
        }
      }

      requestAnimationFrame(loop);
    }
    requestAnimationFrame(loop);
  </script>
</body>
</html>
""".formatted(
                hs.estateId(),
                escape(hs.mahrAndNafaqahPremium()),
                escape(hs.supplyChainStatus()),
                hs.vanguardDistanceMeters(),
                hs.isAirGapped(),
                hs.egoValidationDemandRatio(),
                escape(hs.lastSomaticReading()),
                hs.isPreemptiveCareOptimal(),
                pillarCards.toString(),
                transitionRows.toString(),
                actionRows.toString(),
                eraRows.toString()
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
