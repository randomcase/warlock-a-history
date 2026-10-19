package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.IslamicInterlockerEggBinder;
import com.sovereign.warlock.domain.IslamicInterlockerEggBinder.BakingCoagulationPhase;
import com.sovereign.warlock.domain.IslamicInterlockerEggBinder.WorldEggInterlockNode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

/**
 * Generates interlocker-egg-binder-islam.html:
 * The Islamic Intelocketer (Al-Murabbit Al-Kalim & Al-Baydah Al-Jami'ah) —
 * Binding the 7 Worlds of Hegemon, 7 Sequesters, and 7 Sealed Qumqums like an Egg in Baking.
 */
public final class IslamicInterlockerPortalGenerator {

    public WarlockHtmlPortalService.GeneratedHtmlArtifact generateInterlockerPortal(Path outputDir) {
        try {
            Files.createDirectories(outputDir);
            String html = renderInterlockerHtml();
            Path path = outputDir.resolve("interlocker-egg-binder-islam.html");
            Files.writeString(path, html, StandardCharsets.UTF_8);
            return new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                    "interlocker-egg-binder-islam.html",
                    path,
                    Files.size(path),
                    sha256(html),
                    "The Islamic Intelocketer (Al-Murabbit Al-Kalim): Egg-in-Baking Emulsifier, Disulfide Lattice & Al-A'raf Interlocutor"
            );
        } catch (IOException e) {
            throw new IllegalStateException("Failed generating Islamic Intelocketer Egg-Binder HTML portal", e);
        }
    }

    private String renderInterlockerHtml() {
        StringBuilder phaseCards = new StringBuilder();
        for (BakingCoagulationPhase p : IslamicInterlockerEggBinder.allSevenBakingPhases()) {
            phaseCards.append(String.format("""
                    <div class="phase-card">
                      <div class="badge-row">
                        <span class="badge" style="color:#FDE68A;">%s</span>
                        <span class="badge" style="color:#38BDF8;">Oven Temp: %.1f &deg;C</span>
                        <span class="badge" style="color:#34D399;">Bound Capability: Cp = %.2f (State S0)</span>
                      </div>
                      <h3>%s</h3>
                      <p style="font-size:0.86rem;color:#FDE68A;margin-bottom:0.85rem;">
                        <strong>Qur'anic &amp; Prophetic Anchor:</strong> %s
                      </p>
                      <div class="grid-3">
                        <div class="sub-box egg-box">
                          <div class="box-title" style="color:#FBBF24;">I. Culinary Egg-in-Baking Chemistry</div>
                          <p>%s</p>
                        </div>
                        <div class="sub-box bind-box">
                          <div class="box-title" style="color:#34D399;">II. Islamic Cosmological Interlocking (At-Ta'lif wa Al-Bunyan)</div>
                          <p>%s</p>
                        </div>
                        <div class="sub-box kalim-box">
                          <div class="box-title" style="color:#A78BFA;">III. Interlocutor Address on the Crest (Khitab Al-A'raf)</div>
                          <p>%s</p>
                        </div>
                      </div>
                    </div>
                    """,
                    escape(p.arabicPhaseName()),
                    p.coagulationTempCelsius(),
                    p.boundCapabilityCp(),
                    escape(p.englishPhaseTitle()),
                    escape(p.quranicAndHadithAnchor()),
                    escape(p.culinaryEggChemistry()),
                    escape(p.islamicCosmologicalBinding()),
                    escape(p.interlocutorDialogueAct())
            ));
        }

        StringBuilder binderRows = new StringBuilder();
        for (WorldEggInterlockNode b : IslamicInterlockerEggBinder.allSevenWorldEggBinders()) {
            binderRows.append(String.format("""
                    <tr>
                      <td>
                        <strong style="color:#FDE68A;">%s</strong><br>
                        <span style="font-size:0.82rem;color:#E2E8F0;">%s</span><br>
                        <span style="font-size:0.78rem;color:#94A3B8;">%s</span><br>
                        <a href="%s" style="color:#38BDF8;font-size:0.78rem;">&rarr; View World #%d Portal</a>
                      </td>
                      <td style="font-size:0.83rem;color:#FDE68A;">
                        %s<br><br>
                        <span style="color:#34D399;font-family:Consolas,monospace;">Bond: %.1f kPa | Cp = %.2f (S0)</span>
                      </td>
                      <td style="font-size:0.83rem;color:#A7F3D0;">%s</td>
                      <td style="font-size:0.83rem;color:#FCA5A5;">%s</td>
                      <td style="font-size:0.82rem;color:#E9D5FF;">
                        <strong>%s</strong><br><br>
                        <span style="color:#CBD5E1;">%s</span>
                      </td>
                    </tr>
                    """,
                    escape(b.binderCode()),
                    escape(b.arabicBinderName()),
                    escape(b.englishBinderTitle()),
                    b.worldHtmlFile(), b.worldIndex(),
                    escape(b.eggBiochemicalMechanism()),
                    b.crossLinkBondStrengthKpa(), b.coagulatedCp(),
                    escape(b.hegemonFlourAndWaterBound()),
                    escape(b.disorderOilAndQumqumEmulsified()),
                    escape(b.interlocutorCrestVerdict()),
                    escape(b.quranicAnchor())
            ));
        }

        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>The Islamic Intelocketer (Al-Murabbit Al-Kalim) | Egg-in-Baking Cosmic Binder &amp; Al-A'raf Interlocutor</title>
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
      background: radial-gradient(circle at top center, rgba(251, 191, 36, 0.14), var(--bg-deep) 65%%);
      color: var(--text-main);
      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
      line-height: 1.65;
      padding-bottom: 4rem;
    }
    header {
      background: rgba(5, 7, 12, 0.95);
      border-bottom: 2px solid #FBBF24;
      padding: 0.9rem 1.5rem;
      position: sticky;
      top: 0;
      z-index: 10;
    }
    .nav-bar {
      display: flex;
      flex-wrap: wrap;
      gap: 0.45rem;
      max-width: 1420px;
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
      border-color: #FBBF24;
      background: rgba(251, 191, 36, 0.15);
    }
    main { max-width: 1420px; margin: 1.8rem auto; padding: 0 1.5rem; }
    .hero {
      background: linear-gradient(135deg, #0F1420 0%%, #271C19 50%%, #0F172A 100%%);
      border: 1px solid var(--border);
      border-left: 6px solid #FBBF24;
      border-right: 6px solid #34D399;
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
      border-left: 4px solid #FBBF24;
      padding: 0.75rem 1rem;
      border-radius: 8px;
      max-width: 490px;
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
      border-color: #FBBF24;
      color: #FDE68A;
      background: rgba(251, 191, 36, 0.16);
    }
    .phase-card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-radius: 12px;
      padding: 1.45rem;
      margin-bottom: 1.15rem;
    }
    .phase-card h3 { font-size: 1.18rem; margin-bottom: 0.35rem; color: #FFF; }
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
    .egg-box { border-left: 4px solid #FBBF24; }
    .bind-box { border-left: 4px solid #34D399; }
    .kalim-box { border-left: 4px solid #A78BFA; }
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
      margin-top: 1.8rem;
    }
    table { width: 100%%; border-collapse: collapse; font-size: 0.86rem; }
    th, td {
      text-align: left;
      padding: 0.85rem 0.65rem;
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
      <a class="nav-pill active" href="interlocker-egg-binder-islam.html">Islamic Intelocketer (Egg Binder)</a>
      <a class="nav-pill" href="warlock-apocrypha-islamic-theorems.html" style="border-color:#C084FC;color:#E9D5FF;">Warlock Apocrypha &amp; Theorems</a>
      <a class="nav-pill" href="warlock-formation-dissolution-jafar-aladdin.html">Ja'far &amp; Aladdin (Qumqum)</a>
      <a class="nav-pill" href="sequester-between-worlds.html">7 Inter-World Sequesters</a>
      <a class="nav-pill" href="worlds-hegemon-disorder.html">Master 7-Worlds Atlas</a>
      <a class="nav-pill" href="order-1-white.html">7 Hegemon Orders</a>
      <a class="nav-pill" href="zalim-1-fasad.html">7 Wrongdoers (Zalim)</a>
      <a class="nav-pill" href="priory-negentropy-order.html" style="margin-left:auto;color:#34D399;">Negentropic Priory</a>
    </nav>
  </header>
  <main>
    <section class="hero">
      <div class="badge-row">
        <span class="badge" style="color:#FBBF24;">AL-MURABBIT AL-KALIM (THE INTELOCKETER)</span>
        <span class="badge" style="color:#34D399;">AL-BAYDAH AL-MAKNUNAH (QUR'AN 37:49 — GUARDED EGG)</span>
        <span class="badge" style="color:#38BDF8;">BUNYAN MARSUS &amp; TASHBIK AL-ASABI' (QUR'AN 61:4 / BUKHARI 481)</span>
        <span class="badge" style="color:#E9D5FF;">ASHAB AL-A'RAF INTERLOCUTOR (QUR'AN 7:46)</span>
        <span class="badge" style="color:#FDE68A;">AT-TANNUR &amp; SIBGHAT ALLAH (QUR'AN 11:40, 2:138)</span>
      </div>
      <h1>The Islamic Intelocketer (<em>Al-Murabbit Al-Kalim</em>): Binding the Worlds Like an Egg in Baking</h1>
      <p style="color:#CBD5E1;font-size:0.95rem;">
        In baking, dry flour (earth), pure water, and volatile oil naturally repel one another and crumble unless bound by an
        <strong>Egg (<em>Al-Baydah</em>)</strong>: its <strong>Golden Yolk Lecithin (<em>Al-Muhh</em>)</strong> emulsifies immiscible water and oil
        (<strong>Qur'an 8:63, <em>Ta'lif</em></strong>), its <strong>White Albumen (<em>Al-Bayad</em>)</strong> cross-links in the surging oven
        (<strong><em>At-Tannur</em>, Qur'an 11:40</strong>) into an interlocked structural edifice (<strong><em>Bunyan Marsus</em>, Qur'an 61:4 &amp; Hadith Bukhari 481</strong>),
        and its <strong>Interlocutor Voice on the Crest (<em>Ashab Al-A'raf</em>, Qur'an 7:46-48)</strong> addresses both the 7 Worlds of Hegemon and the
        7 Sequestered Qumqums of Disorder while glazing the entire cosmos with <strong><em>Sibghat Allah</em> (Qur'an 2:138)</strong>.
      </p>
    </section>

    <section class="canvas-box">
      <canvas id="eggCanvas"></canvas>
      <div class="hud-top">
        <div id="hudMode" style="font-family:Consolas,monospace;font-size:0.75rem;color:#FBBF24;">MODE 1: THE COSMIC EGG EMULSION (AL-BAYDAH AL-MAKNUNAH &amp; LECITHIN)</div>
        <div id="hudTitle" style="font-size:1rem;font-weight:700;margin:0.2rem 0;">Yolk Lecithin Micelles + Albumen Web + Chalaza Axis</div>
        <div id="hudDesc" style="font-size:0.8rem;color:#CBD5E1;">Amphiphilic yolk bridges bind the 7 Hegemon Orders (Green) and lock the 7 Brass Qumqums (Red/Gold) inside the Guarded Egg (Qur'an 37:49, 8:63).</div>
      </div>
      <div class="mode-bar">
        <button class="mode-btn active" onclick="setMode(1, this)">1. Cosmic Egg Emulsion (Al-Baydah &amp; Lecithin)</button>
        <button class="mode-btn" onclick="setMode(2, this)">2. Interlocked Lattice (Tashbik Al-Asabi' &amp; Al-A'raf)</button>
        <button class="mode-btn" onclick="setMode(3, this)">3. Surging Oven &amp; Golden Glaze (At-Tannur &amp; Sibghat Allah)</button>
      </div>
    </section>

    <h2 style="font-size:1.35rem;margin-bottom:1rem;color:#FDE68A;">
      The 7 Culinary-Theological Phases of the Islamic Egg-Binder (Marahil Al-'Ajn wa At-Tannur)
    </h2>
    %s

    <section class="table-card">
      <h2 style="font-size:1.3rem;margin-bottom:0.9rem;color:#34D399;">
        The 7 World-Binding Egg-Interlock Nodes (BINDER_B1 .. BINDER_B7 Across All 7 Islamic Worlds)
      </h2>
      <table>
        <thead>
          <tr>
            <th style="width:19%%;">Egg-Binder Node &amp; World</th>
            <th style="width:19%%;">Egg Biochemical Mechanism</th>
            <th style="width:20%%;">Hegemon Flour &amp; Water Bound (State S0)</th>
            <th style="width:20%%;">Disorder Oil &amp; Qumqum Emulsified</th>
            <th style="width:22%%;">Interlocutor Verdict (Al-A'raf) &amp; Qur'anic Proof</th>
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
    const canvas = document.getElementById('eggCanvas');
    const ctx = canvas.getContext('2d');
    let yaw = 0.4, pitch = 0.3, zoom = 1.0, dragging = false, lx = 0, ly = 0;

    function setMode(m, btn) {
      mode = m;
      document.querySelectorAll('.mode-btn').forEach(b => b.classList.remove('active'));
      btn.classList.add('active');
      const hm = document.getElementById('hudMode');
      const ht = document.getElementById('hudTitle');
      const hd = document.getElementById('hudDesc');
      if (m === 1) {
        hm.textContent = "MODE 1: THE COSMIC EGG EMULSION (AL-BAYDAH AL-MAKNUNAH & LECITHIN)";
        hm.style.color = "#FBBF24";
        ht.textContent = "Yolk Lecithin Micelles + Albumen Web + Chalaza Axis";
        hd.textContent = "Amphiphilic yolk bridges bind the 7 Hegemon Orders (Green) and lock the 7 Brass Qumqums (Red/Gold) inside the Guarded Egg (Qur'an 37:49, 8:63).";
      } else if (m === 2) {
        hm.textContent = "MODE 2: INTERLOCKED LATTICE (TASHBIK AL-ASABI' & ASHAB AL-A'RAF)";
        hm.style.color = "#34D399";
        ht.textContent = "Disulfide Gluten-Albumen Edifice + Al-A'raf Interlocutor";
        hd.textContent = "The 7 Worlds are woven like interlocked fingers (Bukhari 481, Qur'an 61:4) while the Interlocutor on the Crest (Qur'an 7:46) addresses both hemispheres.";
      } else {
        hm.textContent = "MODE 3: SURGING OVEN & GOLDEN GLAZE (AT-TANNUR & SIBGHAT ALLAH)";
        hm.style.color = "#38BDF8";
        ht.textContent = "Thermal Coagulation (84 °C) + Golden Maillard Crust (165 °C)";
        hd.textContent = "The Oven of Decree (Qur'an 11:40) sets the 7-Tiered Loaf permanently and glazes it with Sibghat Allah (Qur'an 2:138) at Cp = 1.58, H = 0.000 bits.";
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
      pitch = Math.max(-0.2, Math.min(1.15, pitch + (e.clientY - ly) * 0.006));
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

    function line3D(a, b, cx, cy, sc, col, w = 1.4, al = 0.85) {
      const p1 = proj(a[0],a[1],a[2],cx,cy,sc), p2 = proj(b[0],b[1],b[2],cx,cy,sc);
      if (!p1 || !p2) return;
      ctx.save(); ctx.globalAlpha = al; ctx.strokeStyle = col; ctx.lineWidth = w;
      ctx.beginPath(); ctx.moveTo(p1.sx, p1.sy); ctx.lineTo(p2.sx, p2.sy); ctx.stroke(); ctx.restore();
    }

    function loop(now) {
      const t = now * 0.001;
      if (!dragging) yaw += 0.003;
      const w = canvas.width / window.devicePixelRatio, h = canvas.height / window.devicePixelRatio;
      ctx.clearRect(0, 0, w, h);
      const cx = w * 0.5, cy = h * 0.54;

      if (mode === 1) {
        // MODE 1: 3D Cosmic Egg (Al-Baydah Al-Maknunah) + Yolk + Chalaza + 7 Amphiphilic Bridges
        const lat = 12, lon = 14;
        for (let i = 0; i < lat; i++) {
          const v1 = (i / lat) * Math.PI, v2 = ((i + 1) / lat) * Math.PI;
          const y1 = Math.cos(v1) * 145, y2 = Math.cos(v2) * 145;
          // Egg ovoid profile (slightly narrower at top apex)
          const r1 = Math.sin(v1) * 112 * (1 - 0.14 * Math.cos(v1));
          const r2 = Math.sin(v2) * 112 * (1 - 0.14 * Math.cos(v2));
          for (let j = 0; j < lon; j++) {
            const u1 = (j / lon) * Math.PI * 2, u2 = ((j + 1) / lon) * Math.PI * 2;
            line3D([Math.cos(u1)*r1, y1, Math.sin(u1)*r1], [Math.cos(u2)*r1, y1, Math.sin(u2)*r1], cx, cy, zoom, "#F8F5E6", 1.1, 0.42);
            line3D([Math.cos(u1)*r1, y1, Math.sin(u1)*r1], [Math.cos(u1)*r2, y2, Math.sin(u1)*r2], cx, cy, zoom, "#38BDF8", 1.0, 0.35);
          }
        }
        // Central Golden Yolk (Al-Muhh)
        for (let j = 0; j < 12; j++) {
          const u1 = (j / 12) * Math.PI * 2, u2 = ((j + 1) / 12) * Math.PI * 2;
          line3D([Math.cos(u1)*46, 0, Math.sin(u1)*46], [Math.cos(u2)*46, 0, Math.sin(u2)*46], cx, cy, zoom, "#FBBF24", 2.4, 0.95);
          line3D([Math.cos(u1)*46, 0, Math.sin(u1)*46], [0, 46, 0], cx, cy, zoom, "#F59E0B", 1.5, 0.85);
          line3D([Math.cos(u1)*46, 0, Math.sin(u1)*46], [0, -46, 0], cx, cy, zoom, "#F59E0B", 1.5, 0.85);
        }
        // Twisted Chalaza Cords (Top & Bottom Axial Tethers)
        for (let k = 0; k < 16; k++) {
          const yA = 46 + k * 6, yB = 46 + (k + 1) * 6;
          const aA = k * 0.7 + t * 2, aB = (k + 1) * 0.7 + t * 2;
          line3D([Math.cos(aA)*10, yA, Math.sin(aA)*10], [Math.cos(aB)*10, yB, Math.sin(aB)*10], cx, cy, zoom, "#FDE68A", 2.0, 0.9);
          line3D([Math.cos(-aA)*10, -yA, Math.sin(-aA)*10], [Math.cos(-aB)*10, -yB, Math.sin(-aB)*10], cx, cy, zoom, "#FDE68A", 2.0, 0.9);
        }
        // 7 Amphiphilic Lecithin Bridges linking 7 Hegemon Nodes (outer albumen) to 7 Sealed Qumqums (inner yolk boundary)
        for (let wIdx = 0; wIdx < 7; wIdx++) {
          const ang = (wIdx / 7) * Math.PI * 2 + t * 0.35;
          const hx = Math.cos(ang) * 95, hz = Math.sin(ang) * 95, hy = (wIdx - 3) * 28;
          const qx = Math.cos(ang) * 44, qz = Math.sin(ang) * 44, qy = (wIdx - 3) * 10;
          line3D([hx, hy, hz], [qx, qy, qz], cx, cy, zoom, "#34D399", 2.1, 0.92);
          line3D([qx, qy, qz], [0, 0, 0], cx, cy, zoom, "#EF4444", 1.5, 0.8);
        }
      } else if (mode === 2) {
        // MODE 2: Finger-Interlocked Gluten-Albumen Lattice (Tashbik Al-Asabi') + Al-A'raf Interlocutor
        for (let i = -3; i <= 3; i++) {
          const y = i * 32;
          for (let j = -3; j <= 3; j++) {
            const z = j * 34;
            // Interlocking chevron weave between Left (Hegemon, Green) and Right (Quarantined Disorder, Gold/Red)
            line3D([-170, y, z], [0, y + 14 * ((i + j) %% 2), z], cx, cy, zoom, "#34D399", 1.7, 0.85);
            line3D([170, y, z], [0, y + 14 * ((i + j) %% 2), z], cx, cy, zoom, "#FBBF24", 1.7, 0.85);
          }
        }
        // Central Crest Wall of Al-A'raf (Qur'an 7:46) & Interlocutor Spire
        for (let z = -110; z <= 110; z += 36) {
          line3D([0, -110, z], [0, 110, z], cx, cy, zoom, "#A78BFA", 2.3, 0.95);
        }
        // Interlocutor Crown atop Al-A'raf emitting dialogue waves to both sides
        const rWave = 25 + (t * 35) %% 110;
        for (let s = 0; s < 16; s++) {
          const a1 = (s / 16) * Math.PI * 2, a2 = ((s + 1) / 16) * Math.PI * 2;
          line3D([Math.cos(a1)*rWave, 115, Math.sin(a1)*rWave], [Math.cos(a2)*rWave, 115, Math.sin(a2)*rWave], cx, cy, zoom, "#FDE68A", 1.8, 0.85);
        }
      } else {
        // MODE 3: Surging Oven (At-Tannur) & 7-Tiered Risen Loaf with Golden Sibghat Allah Glaze
        for (let tier = 0; tier < 7; tier++) {
          const y = -95 + tier * 28;
          const r = 125 - tier * 6;
          const col = (tier === 6) ? "#FBBF24" : "#34D399";
          for (let s = 0; s < 14; s++) {
            const a1 = (s / 14) * Math.PI * 2, a2 = ((s + 1) / 14) * Math.PI * 2;
            line3D([Math.cos(a1)*r, y, Math.sin(a1)*r], [Math.cos(a2)*r, y, Math.sin(a2)*r], cx, cy, zoom, col, 1.9, 0.9);
            if (tier < 6) {
              line3D([Math.cos(a1)*r, y, Math.sin(a1)*r], [Math.cos(a2)*(r-6), y+28, Math.sin(a2)*(r-6)], cx, cy, zoom, "#FDE68A", 1.2, 0.65);
            }
          }
        }
        // Golden Maillard Dome Crown (Sibghat Allah, Qur'an 2:138)
        for (let s = 0; s < 14; s++) {
          const a1 = (s / 14) * Math.PI * 2;
          line3D([Math.cos(a1)*89, 73, Math.sin(a1)*89], [0, 130, 0], cx, cy, zoom, "#FBBF24", 2.2, 0.95);
        }
      }

      requestAnimationFrame(loop);
    }
    requestAnimationFrame(loop);
  </script>
</body>
</html>
""".formatted(phaseCards.toString(), binderRows.toString());
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
