package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.IslamicDisneyAnimalismMicrocosm;
import com.sovereign.warlock.domain.IslamicDisneyAnimalismMicrocosm.AnimalismMicrocosmState;
import com.sovereign.warlock.domain.IslamicDisneyAnimalismMicrocosm.CharacterizedAnimalArchetype;
import com.sovereign.warlock.domain.IslamicDisneyAnimalismMicrocosm.MicrocosmDistrictCharter;
import com.sovereign.warlock.domain.IslamicDisneyAnimalismMicrocosm.MicrocosmExpansionVector;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

/**
 * Generates disney-daffy-donald-islamic-microcosm.html:
 * The Disney / Warner Bros. / Jungle Book Microcosm ("Two Beaks, One Beach",
 * "The Bayou & The Bazaar", and the 4 Next-Phase Systemic Expansions) governed by
 * Canonical Islamic Animalism ('Ilm Al-Hayawan Al-Islami / Umamun Amthalukum — Qur'an 6:38)
 * and Action-Based Sovereign Husbandry Principles.
 */
public final class IslamicDisneyMicrocosmPortalGenerator {

    public WarlockHtmlPortalService.GeneratedHtmlArtifact generateDisneyMicrocosmPortal(Path outputDir) {
        try {
            Files.createDirectories(outputDir);
            String html = renderMicrocosmHtml();
            Path path = outputDir.resolve("disney-daffy-donald-islamic-microcosm.html");
            Files.writeString(path, html, StandardCharsets.UTF_8);
            return new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                    "disney-daffy-donald-islamic-microcosm.html",
                    path,
                    Files.size(path),
                    sha256(html),
                    "Islamic Animalism & Husbandry Microcosm: Donald, Daffy, Daisy & The Jungle Book (Umamun Amthalukum — Qur'an 6:38)"
            );
        } catch (IOException e) {
            throw new IllegalStateException("Failed generating Disney/Daffy/Jungle Book Islamic Microcosm HTML portal", e);
        }
    }

    private String renderMicrocosmHtml() {
        AnimalismMicrocosmState ms = IslamicDisneyAnimalismMicrocosm.canonicalMicrocosmState();

        StringBuilder archetypeCards = new StringBuilder();
        for (CharacterizedAnimalArchetype a : IslamicDisneyAnimalismMicrocosm.allSevenCharacterizedArchetypes()) {
            archetypeCards.append(String.format("""
                    <div class="pillar-card">
                      <div class="badge-row">
                        <span class="badge" style="color:#FDE68A;">%s</span>
                        <span class="badge" style="color:#38BDF8;">%s</span>
                      </div>
                      <h3>%s</h3>
                      <p style="font-size:0.84rem;color:#C084FC;margin-bottom:0.75rem;">
                        <strong>Soul-Stratum &amp; Classical Fable Parallel:</strong> %s
                      </p>
                      <div class="grid-3">
                        <div class="sub-box toon-box">
                          <div class="box-title" style="color:#38BDF8;">I. Microcosm Role &amp; Animation Physics</div>
                          <p>%s</p>
                        </div>
                        <div class="sub-box husb-box">
                          <div class="box-title" style="color:#34D399;">II. Islamic Animalism &amp; Husbandry Governance System</div>
                          <p>%s</p>
                        </div>
                        <div class="sub-box fiqh-box">
                          <div class="box-title" style="color:#FDE68A;">III. Qur'anic, Hadith &amp; Classical Anchor</div>
                          <p>%s</p>
                        </div>
                      </div>
                    </div>
                    """,
                    escape(a.archetypeCode()),
                    escape(a.islamicAnimalismTitle()),
                    escape(a.characterNameAndStudio()),
                    escape(a.soulStratumAndFableParallel()),
                    escape(a.microcosmRoleAndAnimationPhysics()),
                    escape(a.husbandryAndFiqhGovernanceRule()),
                    escape(a.quranicAndHadithProof())
            ));
        }

        StringBuilder districtRows = new StringBuilder();
        for (MicrocosmDistrictCharter d : IslamicDisneyAnimalismMicrocosm.allFourMicrocosmDistricts()) {
            districtRows.append(String.format("""
                    <tr>
                      <td>
                        <strong style="color:#38BDF8;">%s</strong><br>
                        <span style="font-size:0.81rem;color:#FDE68A;">%s</span><br>
                        <code style="font-size:0.75rem;color:#94A3B8;">%s</code>
                      </td>
                      <td style="font-size:0.83rem;color:#CBD5E1;">%s</td>
                      <td style="font-size:0.83rem;color:#A7F3D0;">%s</td>
                      <td style="font-size:0.81rem;color:#E9D5FF;">%s</td>
                    </tr>
                    """,
                    escape(d.districtName()),
                    escape(d.arabicCosmologicalName()),
                    escape(d.districtCode()),
                    escape(d.visualAndAnimationPhysics()),
                    escape(d.islamicHusbandryLawEnforced()),
                    escape(d.scripturalAnchor())
            ));
        }

        StringBuilder vectorRows = new StringBuilder();
        for (MicrocosmExpansionVector v : IslamicDisneyAnimalismMicrocosm.allFourExpansionVectors()) {
            vectorRows.append(String.format("""
                    <tr>
                      <td>
                        <strong style="color:#FDE68A;">%s</strong><br>
                        <span style="font-size:0.81rem;color:#34D399;">%s</span><br>
                        <code style="font-size:0.75rem;color:#38BDF8;">%s</code>
                      </td>
                      <td style="font-size:0.83rem;color:#FCA5A5;">%s</td>
                      <td style="font-size:0.83rem;color:#A5F3FC;">%s</td>
                      <td style="font-size:0.82rem;color:#A7F3D0;">%s</td>
                    </tr>
                    """,
                    escape(v.vectorName()),
                    escape(v.arabicSystemicTitle()),
                    escape(v.vectorCode()),
                    escape(v.cartoonCatalystAndConflict()),
                    escape(v.islamicHusbandryAndEconomicSystem()),
                    escape(v.resolutionMechanismAndProof())
            ));
        }

        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Islamic Animalism &amp; Husbandry Microcosm | Donald, Daffy, Daisy &amp; The Jungle Book</title>
  <style>
    :root {
      --bg-deep: #060810;
      --bg-card: #101524;
      --text-main: #ECEFF4;
      --text-muted: #94A3B8;
      --border: rgba(255,255,255,0.12);
    }
    * { box-sizing: border-box; margin: 0; padding: 0; }
    body {
      background:
        radial-gradient(circle at top left, rgba(56, 189, 248, 0.15), transparent 50%%),
        radial-gradient(circle at top right, rgba(251, 191, 36, 0.14), var(--bg-deep) 68%%);
      color: var(--text-main);
      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
      line-height: 1.65;
      padding-bottom: 4rem;
    }
    header {
      background: rgba(6, 8, 16, 0.95);
      border-bottom: 2px solid #38BDF8;
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
      border-color: #38BDF8;
      background: rgba(56, 189, 248, 0.16);
    }
    main {
      max-width: 1480px;
      margin: 1.8rem auto;
      padding: 0 1.5rem;
    }
    .hero {
      background: linear-gradient(135deg, #101524 0%%, #0F2942 50%%, #192B1E 100%%);
      border: 1px solid var(--border);
      border-left: 6px solid #38BDF8;
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
      background: #04060B;
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
      background: rgba(6, 8, 16, 0.88);
      border: 1px solid var(--border);
      border-left: 4px solid #38BDF8;
      border-radius: 10px;
      padding: 0.85rem 1.1rem;
      max-width: 580px;
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
      background: rgba(6, 8, 16, 0.88);
      border: 1px solid var(--border);
      border-radius: 10px;
      padding: 0.6rem;
    }
    .mode-btn {
      background: #101524;
      color: #CBD5E1;
      border: 1px solid var(--border);
      border-radius: 6px;
      padding: 0.4rem 0.8rem;
      font-size: 0.78rem;
      font-weight: 600;
      cursor: pointer;
    }
    .mode-btn.active, .mode-btn:hover {
      border-color: #38BDF8;
      color: #FFF;
      background: rgba(56, 189, 248, 0.22);
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
      border-top: 3px solid #38BDF8;
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
      border-left: 5px solid #38BDF8;
      border-radius: 12px;
      padding: 1.45rem;
      margin-bottom: 1.3rem;
    }
    .pillar-card h3 {
      font-size: 1.15rem;
      color: #FDE68A;
      margin-bottom: 0.4rem;
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
    .toon-box { border-top: 3px solid #38BDF8; }
    .husb-box { border-top: 3px solid #34D399; }
    .fiqh-box { border-top: 3px solid #FDE68A; }
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
      <a class="nav-pill active" href="disney-daffy-donald-islamic-microcosm.html">Disney/Daffy Islamic Animalism Microcosm</a>
      <a class="nav-pill" href="way-of-the-flower-rose-garden-islam.html">Way of the Flower, Rose &amp; Garden</a>
      <a class="nav-pill" href="islamic-husbandry-sovereign-estate.html">Islamic Husbandry (Al-Qiwamah)</a>
      <a class="nav-pill" href="warlock-apocrypha-islamic-theorems.html">Warlock Apocrypha &amp; Theorems</a>
      <a class="nav-pill" href="interlocker-egg-binder-islam.html">Islamic Intelocketer (Egg Binder)</a>
      <a class="nav-pill" href="worlds-hegemon-disorder.html">7 Islamic Worlds</a>
      <a class="nav-pill" href="priory-negentropy-order.html">Negentropic Priory</a>
      <a class="nav-pill" href="order-1-white.html">Order #1..#7</a>
      <a class="nav-pill" href="dependencies-report.html">Dependencies Report</a>
    </nav>
  </header>

  <main>
    <section class="hero">
      <div class="badge-row">
        <span class="badge" style="color:#38BDF8;">UMAMUN AMTHALUKUM: ANIMAL COMMUNITIES LIKE YOU (QUR'AN 6:38)</span>
        <span class="badge" style="color:#FDE68A;">KALILAH WA DIMNAH &amp; MANTIQ AT-TAYR ARCHETYPES</span>
        <span class="badge" style="color:#34D399;">HISBAH BAZAAR, AL-HIMA JUNGLE RESERVE &amp; AL-MA'UN SUBURBS</span>
        <span class="badge" style="color:#FDA4AF;">SKETCHLANDS 'ALAM AL-MITHAL &amp; GOLDEN EGG QUEST</span>
      </div>
      <h1>The Disney, Daffy &amp; Jungle Book Microcosm Governed by Islamic Animalism (<em>Umamun Amthalukum</em>) &amp; Sovereign Husbandry Principles</h1>
      <p style="color:#CBD5E1;font-size:0.95rem;">
        Synthesizing the Qur'anic doctrine that all bird and animal species form conscious moral communities
        (<strong>Qur'an 6:38: <em>"Umamun amthalukum"</em></strong> &amp; <strong>27:16: <em>"Mantiq At-Tayr"</em></strong>)
        with classical Islamic animal-fable systems (<strong>Ibn al-Muqaffa''s <em>Kalilah wa Dimnah</em></strong>,
        <strong>'Attar's <em>Conference of the Birds</em></strong>, <strong>Ikhwan as-Safa''s <em>Epistle of the Animals</em></strong>,
        and <strong>Ibn Tufayl's <em>Hayy ibn Yaqzan</em></strong>) to govern the <strong>7 Characterized Beings</strong>
        (Daisy, Donald, Daffy, Shere Khan, Baloo &amp; King Louie, Kaa, and Bagheera &amp; Mowgli) across the
        <strong>4 Districts</strong> and <strong>4 Systemic Expansion Vectors</strong>.
      </p>
    </section>

    <section class="canvas-box">
      <canvas id="microCanvas"></canvas>
      <div class="hud-top">
        <div id="hudMode" style="font-family:Consolas,monospace;font-size:0.75rem;color:#38BDF8;">MODE 1: "TWO BEAKS, ONE BEACH" &amp; DAISY'S SILK-AND-COIN HISBAH BAZAAR</div>
        <div id="hudTitle" style="font-size:1rem;font-weight:700;margin:0.2rem 0;">Disney Marina (24-fps Itqan) | Boardwalk Piano Sulh | Warner Screwball Quarantine</div>
        <div id="hudDesc" style="font-size:0.8rem;color:#CBD5E1;">Left Cyan: Donald's symmetric 24-fps Marina. Right Purple/Amber: Daffy's Theater of Ego &amp; quarantined ACME crates. Center Gold: Daisy's Hisbah Bazaar &amp; Dueling Piano Sulh Lounge.</div>
      </div>
      <div class="mode-bar">
        <button class="mode-btn active" onclick="setMode(1, this)">1. Two Beaks, One Beach &amp; Daisy's Hisbah Bazaar (Qur'an 83:1-3)</button>
        <button class="mode-btn" onclick="setMode(2, this)">2. Deep Jungle Al-Hima vs. Scrooge/ACME Corporate Bulldozers (Qur'an 6:38 &amp; 30:41)</button>
        <button class="mode-btn" onclick="setMode(3, this)">3. Ink &amp; Paint Transit, Al-Ma'un Suburbs &amp; Unfinished Sketchlands ('Alam Al-Mithal)</button>
      </div>
    </section>

    <div class="code-grid">
      <div class="code-card">
        <h2 style="font-size:1.1rem;color:#38BDF8;margin-bottom:0.65rem;">Immutable Java 21+ Record: <code>AnimalismMicrocosmState</code></h2>
        <pre>public record AnimalismMicrocosmState(
    UUID microcosmId,
    String microcosmTitle,
    boolean duelingPianoSulhActive,
    boolean bazaarHisbahAuditActive,
    boolean jungleHimaProtectedFromBulldozers,
    boolean suburbanMaunToolEscrowLocked,
    double donaldMonorailFrameRateFps,
    double bagheeraVanguardBufferMeters,
    int acmeFraudCratesQuarantined,
    String quranicAnimalismCharter
) {
    public AnimalismMicrocosmState {
        if (!duelingPianoSulhActive)
            throw new IllegalStateException("Boardwalk requires Sulh treaty.");
        if (!bazaarHisbahAuditActive)
            throw new IllegalStateException("Bazaar requires Hisbah Mizan audit.");
        if (!jungleHimaProtectedFromBulldozers)
            throw new IllegalStateException("Jungle Hima must block bulldozers.");
        if (!suburbanMaunToolEscrowLocked)
            throw new IllegalStateException("Suburbs require Al-Ma'un tool escrow.");
    }
}</pre>
      </div>

      <div class="code-card" style="border-top-color:#34D399;">
        <h2 style="font-size:1.1rem;color:#34D399;margin-bottom:0.65rem;">Live Verified <code>AnimalismMicrocosmState</code> Telemetry</h2>
        <table>
          <tr><th>Microcosm UUID</th><td><code>%s</code></td></tr>
          <tr><th>Microcosm Designation</th><td><strong style="color:#FDE68A;">%s</strong></td></tr>
          <tr><th>Dueling Piano Sulh Treaty (Qur'an 4:128)</th><td><code style="color:#34D399;">duelingPianoSulhActive = %s</code></td></tr>
          <tr><th>Daisy's Bazaar Hisbah Audit (Qur'an 83:1-3)</th><td><code style="color:#38BDF8;">bazaarHisbahAuditActive = %s (%d ACME Crates Impounded)</code></td></tr>
          <tr><th>Deep Jungle Al-Hima Sanctuary (Qur'an 6:38)</th><td><code style="color:#34D399;">jungleHimaProtectedFromBulldozers = %s</code></td></tr>
          <tr><th>Suburban Al-Ma'un Tool Escrow (Qur'an 107:7)</th><td><code style="color:#FDE68A;">suburbanMaunToolEscrowLocked = %s</code></td></tr>
          <tr><th>Monorail FPS &amp; Bagheera Vanguard Buffer</th><td><code>Donald Monorail: %.1f fps | Bagheera Vanguard: %.2fm</code></td></tr>
          <tr><th><code>isMicrocosmInMizanEquilibrium()</code></th><td><strong style="color:#34D399;">%s (VERIFIED PASS)</strong></td></tr>
        </table>
      </div>
    </div>

    <h2 style="font-size:1.35rem;margin-bottom:1rem;color:#38BDF8;">
      The 7 Characterized Archetypal Beings Governed by Islamic Animalism &amp; Husbandry Principles
    </h2>
    %s

    <section class="table-card" style="border-top:3px solid #38BDF8;">
      <h2 style="font-size:1.3rem;margin-bottom:0.9rem;color:#38BDF8;">
        The 4 Microcosm Districts: From "Two Beaks, One Beach" to "The Bayou &amp; The Bazaar"
      </h2>
      <table>
        <thead>
          <tr>
            <th style="width:24%%;">District &amp; Arabic Cosmological Name</th>
            <th style="width:25%%;">Visual &amp; Animation Physics</th>
            <th style="width:29%%;">Islamic Husbandry &amp; Hisbah Law Enforced</th>
            <th style="width:22%%;">Scriptural Proof</th>
          </tr>
        </thead>
        <tbody>
          %s
        </tbody>
      </table>
    </section>

    <section class="table-card" style="border-top:3px solid #34D399;">
      <h2 style="font-size:1.3rem;margin-bottom:0.9rem;color:#34D399;">
        The 4 Next-Phase Systemic Expansion Vectors: Transit, Corporate Takeover, Suburbs &amp; Sketchlands
      </h2>
      <table>
        <thead>
          <tr>
            <th style="width:23%%;">Expansion Vector &amp; Arabic Title</th>
            <th style="width:24%%;">Cartoon Catalyst &amp; Systemic Conflict</th>
            <th style="width:26%%;">Islamic Husbandry &amp; Economic Diagnosis</th>
            <th style="width:27%%;">Constitutional Resolution Mechanism</th>
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
    const canvas = document.getElementById('microCanvas');
    const ctx = canvas.getContext('2d');
    let yaw = 0.38, pitch = 0.40, zoom = 1.0, dragging = false, lx = 0, ly = 0;

    function setMode(m, btn) {
      mode = m;
      document.querySelectorAll('.mode-btn').forEach(b => b.classList.remove('active'));
      btn.classList.add('active');
      const hm = document.getElementById('hudMode');
      const ht = document.getElementById('hudTitle');
      const hd = document.getElementById('hudDesc');
      if (m === 1) {
        hm.textContent = "MODE 1: 'TWO BEAKS, ONE BEACH' & DAISY'S SILK-AND-COIN HISBAH BAZAAR";
        hm.style.color = "#38BDF8";
        ht.textContent = "Disney Marina (24-fps Itqan) | Boardwalk Piano Sulh | Warner Screwball Quarantine";
        hd.textContent = "Left Cyan: Donald's symmetric 24-fps Marina. Right Purple/Amber: Daffy's Theater of Ego & quarantined ACME crates. Center Gold: Daisy's Hisbah Bazaar & Dueling Piano Sulh Lounge.";
      } else if (m === 2) {
        hm.textContent = "MODE 2: DEEP JUNGLE AL-HIMA VS. SCROOGE/ACME CORPORATE BULLDOZERS (QUR'AN 6:38 & 30:41)";
        hm.style.color = "#34D399";
        ht.textContent = "Shere Khan's Terraced Ruins | Baloo's Canopy | Bagheera's 1.85m Vanguard Shield";
        hd.textContent = "Emerald Pyramid & Canopy: The protected Jungle Hima sanctuary. Outer Red Bulldozer Vectors: Scrooge's Kanz & ACME's Fasad blocked at the Hima boundary.";
      } else {
        hm.textContent = "MODE 3: INK & PAINT TRANSIT, AL-MA'UN SUBURBS & UNFINISHED SKETCHLANDS ('ALAM AL-MITHAL)";
        hm.style.color = "#FDE68A";
        ht.textContent = "Donald's Monorail | Daffy's Toon Trolley | Suburban Fence | Wireframe Golden Egg";
        hd.textContent = "Cyan Elevated Arc: Donald's 24-fps Monorail. Amber Wave: Daffy's Trolley loop. Center Wireframe Octahedron: The Unfinished Sketchlands cradling the Golden Egg (Al-Baydah Al-Maknunah).";
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
      if (!dragging) yaw += 0.0032;

      if (mode === 1) {
        // Left: Disney Marina & Multiplane Symmetry (-130 to -35)
        for (let z = -90; z <= 90; z += 45) {
          line3D([-140, -40, z], [-40, -40, z], cx, cy, zoom, "#38BDF8", 1.8, 0.85);
          line3D([-90, -40, z], [-90, 45, z], cx, cy, zoom, "#38BDF8", 1.6, 0.8);
        }
        // Center: Boardwalk Dueling Piano Lounge & Daisy's Silk-and-Coin Bazaar
        for (let i = 0; i < 12; i++) {
          const a1 = (i / 12) * Math.PI * 2, a2 = ((i + 1) / 12) * Math.PI * 2;
          line3D([Math.cos(a1) * 34, -40, Math.sin(a1) * 34], [Math.cos(a2) * 34, -40, Math.sin(a2) * 34], cx, cy, zoom, "#FDE68A", 2.4, 0.95);
          line3D([Math.cos(a1) * 34, 30, Math.sin(a1) * 34], [Math.cos(a2) * 34, 30, Math.sin(a2) * 34], cx, cy, zoom, "#34D399", 2.2, 0.9);
        }
        // Right: Warner Screwball District (tilted/elastic geometry + quarantined ACME crates)
        for (let k = 0; k < 5; k++) {
          const wob = Math.sin(t * 3 + k) * 14;
          line3D([45 + k * 22, -40, -70 + wob], [45 + k * 22, 40 + wob, 70], cx, cy, zoom, "#C084FC", 1.8, 0.85);
        }
      } else if (mode === 2) {
        // Deep Jungle Al-Hima Sanctuary (Shere Khan's Terraced Ruins + Canopy + Hima Shield)
        for (let tier = 0; tier < 4; tier++) {
          const s = 95 - tier * 20;
          const y = -55 + tier * 28;
          line3D([-s, y, -s], [s, y, -s], cx, cy, zoom, "#34D399", 2.1, 0.9);
          line3D([s, y, -s], [s, y, s], cx, cy, zoom, "#34D399", 2.1, 0.9);
          line3D([s, y, s], [-s, y, s], cx, cy, zoom, "#34D399", 2.1, 0.9);
          line3D([-s, y, s], [-s, y, -s], cx, cy, zoom, "#34D399", 2.1, 0.9);
        }
        // Outer Corporate Bulldozer Vectors repelled at the Hima perimeter
        for (let b = 0; b < 8; b++) {
          const ang = (b / 8) * Math.PI * 2 + t * 0.5;
          const r1 = 165, r2 = 125;
          line3D([Math.cos(ang) * r1, -30, Math.sin(ang) * r1], [Math.cos(ang) * r2, -30, Math.sin(ang) * r2], cx, cy, zoom, "#EF4444", 2.4, 0.85);
        }
      } else {
        // Mode 3: Ink & Paint Transit Line + Unfinished Sketchlands Golden Egg
        for (let i = 0; i < 24; i++) {
          const a1 = (i / 24) * Math.PI * 2, a2 = ((i + 1) / 24) * Math.PI * 2;
          // Donald's Sleek Elevated Monorail Ring
          line3D([Math.cos(a1) * 145, 25, Math.sin(a1) * 145], [Math.cos(a2) * 145, 25, Math.sin(a2) * 145], cx, cy, zoom, "#38BDF8", 2.5, 0.95);
          // Daffy's Bouncing Rubber-Hose Trolley Ring
          const y1 = -35 + Math.sin(a1 * 6 + t * 4) * 14;
          const y2 = -35 + Math.sin(a2 * 6 + t * 4) * 14;
          line3D([Math.cos(a1) * 115, y1, Math.sin(a1) * 115], [Math.cos(a2) * 115, y2, Math.sin(a2) * 115], cx, cy, zoom, "#F59E0B", 2.0, 0.88);
        }
        // Center: Wireframe Golden Egg (Al-Baydah Al-Maknunah) in the Unfinished Sketchlands
        for (let j = 0; j < 12; j++) {
          const a1 = (j / 12) * Math.PI * 2, a2 = ((j + 1) / 12) * Math.PI * 2;
          line3D([0, 65, 0], [Math.cos(a1) * 42, 0, Math.sin(a1) * 42], cx, cy, zoom, "#FDE68A", 1.7, 0.9);
          line3D([0, -65, 0], [Math.cos(a1) * 42, 0, Math.sin(a1) * 42], cx, cy, zoom, "#FDE68A", 1.7, 0.9);
          line3D([Math.cos(a1) * 42, 0, Math.sin(a1) * 42], [Math.cos(a2) * 42, 0, Math.sin(a2) * 42], cx, cy, zoom, "#FDE68A", 1.7, 0.9);
        }
      }

      requestAnimationFrame(loop);
    }
    requestAnimationFrame(loop);
  </script>
</body>
</html>
""".formatted(
                ms.microcosmId(),
                escape(ms.microcosmTitle()),
                ms.duelingPianoSulhActive(),
                ms.bazaarHisbahAuditActive(),
                ms.acmeFraudCratesQuarantined(),
                ms.jungleHimaProtectedFromBulldozers(),
                ms.suburbanMaunToolEscrowLocked(),
                ms.donaldMonorailFrameRateFps(),
                ms.bagheeraVanguardBufferMeters(),
                ms.isMicrocosmInMizanEquilibrium(),
                archetypeCards.toString(),
                districtRows.toString(),
                vectorRows.toString()
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
