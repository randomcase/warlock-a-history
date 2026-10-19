package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.WarlockFormationDissolutionAndSequester;
import com.sovereign.warlock.domain.WarlockFormationDissolutionAndSequester.FormationDissolutionPhase;
import com.sovereign.warlock.domain.WarlockFormationDissolutionAndSequester.InterWorldSequester;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HexFormat;
import java.util.List;

/**
 * Generates:
 *  1) warlock-formation-dissolution-jafar-aladdin.html:
 *     The Islamic Chronicle & Interactive 3D Simulation of Warlock Formation (At-Takwin Al-Istidraji — Ja'far)
 *     and Warlock Dissolution (Al-Inhilal fi Al-Qumqum — 'Ala' ad-Din & The Solomonic Brazen Lamp).
 *  2) sequester-between-worlds.html:
 *     The 7 Inter-World Sequesters (Al-Hijr Al-Mahjur / Sur Al-Hadid / Radm Dhi Al-Qarnayn)
 *     separating the 7 Worlds of Hegemon from the 7 Worlds of Disorder.
 */
public final class WarlockSequesterPortalGenerator {

    public List<WarlockHtmlPortalService.GeneratedHtmlArtifact> generateFormationDissolutionAndSequesters(Path outputDir) {
        try {
            Files.createDirectories(outputDir);
            List<WarlockHtmlPortalService.GeneratedHtmlArtifact> list = new ArrayList<>();

            String fdHtml = renderFormationAndDissolutionHtml();
            Path fdPath = outputDir.resolve("warlock-formation-dissolution-jafar-aladdin.html");
            Files.writeString(fdPath, fdHtml, StandardCharsets.UTF_8);
            list.add(new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                    "warlock-formation-dissolution-jafar-aladdin.html",
                    fdPath,
                    Files.size(fdPath),
                    sha256(fdHtml),
                    "Warlock Formation (Ja'far / Istidraj) & Warlock Dissolution ('Ala' ad-Din / Qumqum Lamp) in Islam"
            ));

            String seqHtml = renderInterWorldSequesterHtml();
            Path seqPath = outputDir.resolve("sequester-between-worlds.html");
            Files.writeString(seqPath, seqHtml, StandardCharsets.UTF_8);
            list.add(new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                    "sequester-between-worlds.html",
                    seqPath,
                    Files.size(seqPath),
                    sha256(seqHtml),
                    "The 7 Inter-World Sequesters (Al-Hijr Al-Mahjur & Sur Al-Hadid) Between Hegemon and Disorder"
            ));

            return List.copyOf(list);
        } catch (IOException e) {
            throw new IllegalStateException("Failed generating Formation/Dissolution and Sequester HTML portals", e);
        }
    }

    private String renderFormationAndDissolutionHtml() {
        StringBuilder stageCards = new StringBuilder();
        for (FormationDissolutionPhase s : WarlockFormationDissolutionAndSequester.allFormationDissolutionStages()) {
            stageCards.append(String.format("""
                    <div class="stage-card">
                      <div class="stage-header">
                        <span class="badge">%s</span>
                        <span class="badge" style="color:#FCA5A5;">Formation Spike: H = %.3f bits</span>
                        <span class="badge" style="color:#34D399;">Dissolution Seal: H = %.3f bits</span>
                      </div>
                      <h2>%s</h2>
                      <div class="grid-2">
                        <div class="sub-box" style="border-left:4px solid #EF4444;">
                          <h3 style="color:#FCA5A5;">Ja'far Archetype — Warlock Formation (At-Takwin Al-Istidraji)</h3>
                          <p>%s</p>
                        </div>
                        <div class="sub-box" style="border-left:4px solid #34D399;">
                          <h3 style="color:#34D399;">'Ala' ad-Din Archetype — Warlock Dissolution (Al-Inhilal fi Al-Qumqum)</h3>
                          <p>%s</p>
                        </div>
                      </div>
                      <div class="verse-bar">
                        <strong>Qur'anic Criterion Law:</strong> %s
                      </div>
                    </div>
                    """,
                    escape(s.arabicPhaseName()),
                    s.formationEntropySpikeBits(),
                    s.dissolutionResolvedEntropyBits(),
                    escape(s.englishPhaseTitle()),
                    escape(s.jafarWarlockFormationAct()),
                    escape(s.aladdinCriterionDissolutionAct()),
                    escape(s.quranicLawAndVerse())
            ));
        }

        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Warlock Formation (Ja'far) &amp; Warlock Dissolution ('Ala' ad-Din &amp; The Qumqum Lamp) in Islam</title>
  <style>
    :root {
      --bg-deep: #06050B;
      --bg-card: #12101D;
      --text-main: #ECEFF4;
      --text-muted: #94A3B8;
      --border: rgba(255,255,255,0.12);
    }
    * { box-sizing: border-box; margin: 0; padding: 0; }
    body {
      background: var(--bg-deep);
      color: var(--text-main);
      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
      line-height: 1.65;
      padding-bottom: 4rem;
    }
    header {
      background: rgba(6, 5, 11, 0.95);
      border-bottom: 2px solid #FDE68A;
      padding: 0.9rem 1.5rem;
      position: sticky;
      top: 0;
      z-index: 10;
    }
    .nav-bar {
      display: flex;
      flex-wrap: wrap;
      gap: 0.45rem;
      max-width: 1380px;
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
      border-color: #FDE68A;
      background: rgba(253, 230, 138, 0.14);
    }
    main { max-width: 1380px; margin: 1.8rem auto; padding: 0 1.5rem; }
    .hero {
      background: linear-gradient(135deg, #12101D 0%%, #261224 100%%);
      border: 1px solid var(--border);
      border-left: 6px solid #EF4444;
      border-right: 6px solid #34D399;
      border-radius: 14px;
      padding: 1.75rem 2rem;
      margin-bottom: 1.5rem;
    }
    h1 { font-size: 1.95rem; margin-bottom: 0.4rem; }
    .mode-bar {
      display: flex;
      flex-wrap: wrap;
      gap: 0.5rem;
      align-items: center;
      margin-bottom: 1rem;
      background: var(--bg-card);
      padding: 0.85rem 1.2rem;
      border-radius: 10px;
      border: 1px solid var(--border);
    }
    .mode-btn {
      padding: 0.45rem 0.95rem;
      border-radius: 7px;
      background: #1B182B;
      color: #CBD5E1;
      border: 1px solid var(--border);
      font-size: 0.82rem;
      font-weight: 600;
      cursor: pointer;
    }
    .mode-btn.active, .mode-btn:hover {
      border-color: #FDE68A;
      color: #FFF;
      background: rgba(253, 230, 138, 0.18);
    }
    .canvas-box {
      position: relative;
      height: 440px;
      background: #030307;
      border: 1px solid var(--border);
      border-radius: 14px;
      overflow: hidden;
      margin-bottom: 1.75rem;
    }
    canvas { width: 100%%; height: 100%%; display: block; cursor: grab; }
    .hud {
      position: absolute;
      top: 12px;
      left: 14px;
      background: rgba(6, 5, 11, 0.88);
      border: 1px solid var(--border);
      border-left: 3px solid #FDE68A;
      padding: 0.7rem 1rem;
      border-radius: 8px;
      max-width: 520px;
      pointer-events: none;
    }
    .stage-card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-radius: 12px;
      padding: 1.5rem;
      margin-bottom: 1.25rem;
    }
    .stage-header { display: flex; flex-wrap: wrap; gap: 0.5rem; margin-bottom: 0.6rem; }
    .badge {
      font-family: Consolas, monospace;
      font-size: 0.75rem;
      padding: 0.2rem 0.6rem;
      border-radius: 5px;
      background: rgba(255,255,255,0.07);
      border: 1px solid var(--border);
    }
    .stage-card h2 { font-size: 1.25rem; color: #FDE68A; margin-bottom: 0.85rem; }
    .grid-2 {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(390px, 1fr));
      gap: 1.1rem;
      margin-bottom: 0.9rem;
    }
    .sub-box {
      background: rgba(255,255,255,0.03);
      padding: 1rem 1.15rem;
      border-radius: 8px;
    }
    .sub-box h3 { font-size: 0.92rem; text-transform: uppercase; margin-bottom: 0.45rem; }
    .sub-box p { font-size: 0.92rem; color: #CBD5E1; }
    .verse-bar {
      background: #080710;
      border: 1px solid var(--border);
      border-radius: 7px;
      padding: 0.7rem 1rem;
      font-size: 0.86rem;
      color: #A5F3FC;
    }
  </style>
</head>
<body>
  <header>
    <nav class="nav-bar">
      <a class="nav-pill active" href="warlock-formation-dissolution-jafar-aladdin.html">Formation &amp; Dissolution (Ja'far / 'Ala' ad-Din)</a>
      <a class="nav-pill" href="sequester-between-worlds.html" style="border-color:#34D399;color:#34D399;">7 Inter-World Sequesters</a>
      <a class="nav-pill" href="worlds-hegemon-disorder.html" style="border-color:#C084FC;color:#E9D5FF;">7 Islamic Worlds</a>
      <a class="nav-pill" href="zalim-1-fasad.html" style="border-color:#EF4444;color:#FCA5A5;">7 Wrongdoers (Zalim)</a>
      <a class="nav-pill" href="priory-negentropy-order.html">Negentropic Priory</a>
      <a class="nav-pill" href="order-1-white.html" style="margin-left:auto;color:#38BDF8;">7 Color Orders</a>
    </nav>
  </header>
  <main>
    <section class="hero">
      <h1>Warlock Formation (At-Takwin) &amp; Warlock Dissolution (Al-Inhilal) in Islam: The Ja'far &amp; 'Ala' ad-Din Paradigm</h1>
      <p style="color:#CBD5E1;font-size:0.96rem;">
        In classical Islamic theology and the <em>Alf Laylah wa-Laylah</em> archetype of <strong>Ja'far (The Covetous Sorcerer-Vizier)</strong>
        and <strong>'Ala' ad-Din (&ldquo;Nobility/Elevation of the Religion&rdquo;)</strong>, a Warlock is <strong>formed</strong> through
        <em>Istidraj</em> (gradual luring into ruin via coercive pact-making, Qur'an 7:182, 72:6) and <strong>dissolved</strong> when his own
        insatiable <em>Istikbar</em> (arrogance) tricks him into wishing for cosmic <em>'Ifrit / Marid</em> omnipotence — binding him in
        <strong>Solomonic Fetters (Al-Asfad, Qur'an 38:38)</strong> and imploding him into the <strong>Black-Brass Lamp (Al-Qumqum)</strong>.
      </p>
    </section>

    <div class="mode-bar">
      <span style="font-size:0.8rem;font-weight:700;text-transform:uppercase;color:#FDE68A;">3D Simulation Phase:</span>
      <button class="mode-btn" id="btn-FORMATION" onclick="setMode('FORMATION')">1. Warlock Formation (Ja'far's Serpent Staff &amp; Marid Vortex)</button>
      <button class="mode-btn active" id="btn-DISSOLUTION" onclick="setMode('DISSOLUTION')">2. Warlock Dissolution ('Ala' ad-Din's Trap &amp; Implosion into the Qumqum Lamp)</button>
      <button class="mode-btn" id="btn-SEQUESTER" onclick="setMode('SEQUESTER')">3. Inter-World Sequester (Sealing the Qumqum Behind Al-Hijr Al-Mahjur)</button>
    </div>

    <section class="canvas-box">
      <canvas id="fdCanvas"></canvas>
      <div class="hud">
        <div id="hud-tag" style="font-family:Consolas,monospace;font-size:0.75rem;color:#FDE68A;">PHASE II: WARLOCK DISSOLUTION IN THE QUMQUM LAMP</div>
        <div id="hud-title" style="font-size:1.02rem;font-weight:700;margin:0.15rem 0;">Muqarranina fi Al-Asfad (Bound in Brass Fetters, Qur'an 38:38)</div>
        <div id="hud-desc" style="font-size:0.8rem;color:#CBD5E1;">Ja'far's colossal crimson Marid form is shackled by cosmic law and sucked spiraling into the Black-Brass Solomonic Lamp held by 'Ala' ad-Din.</div>
      </div>
    </section>

    %s
  </main>

  <script>
    let mode = 'DISSOLUTION';
    const canvas = document.getElementById('fdCanvas');
    const ctx = canvas.getContext('2d');
    let yaw = 0.35, pitch = 0.32, zoom = 1.0, dragging = false, lx = 0, ly = 0;

    function setMode(m) {
      mode = m;
      ['FORMATION','DISSOLUTION','SEQUESTER'].forEach(k => {
        document.getElementById('btn-' + k).classList.toggle('active', k === m);
      });
      if (m === 'FORMATION') {
        document.getElementById('hud-tag').textContent = 'PHASE I: WARLOCK FORMATION (AT-TAKWIN AL-ISTIDRAJI)';
        document.getElementById('hud-title').textContent = "Ja'far's Threefold Ascent: Sultanate -> Serpent Staff -> Unbounded Marid";
        document.getElementById('hud-desc').textContent = 'Swirling crimson smokeless fire (Marij min Nar) and the Cobra Staff expand outward as H_raw spikes to 0.985 bits.';
      } else if (m === 'DISSOLUTION') {
        document.getElementById('hud-tag').textContent = 'PHASE II: WARLOCK DISSOLUTION (AL-INHILAL FI AL-QUMQUM)';
        document.getElementById('hud-title').textContent = "'Ala' ad-Din's Criterion Mirror & Implosion into the Black-Brass Lamp";
        document.getElementById('hud-desc').textContent = "Brass manacles (Al-Asfad, Qur'an 38:38) lock onto the Marid's wrists as his vortex is sucked downward into the narrow Qumqum spout (H -> 0.000).";
      } else {
        document.getElementById('hud-tag').textContent = 'PHASE III: INTER-WORLD SEQUESTER (AL-HIJR AL-MAHJUR / SUR AL-HADID)';
        document.getElementById('hud-title').textContent = 'Quarantined Beyond the Barrier Between Worlds (Qur\\'an 25:53, 57:13)';
        document.getElementById('hud-desc').textContent = 'The sealed Black-Brass Lamp is locked behind the impenetrable Sequester Wall separating the World of Disorder from Abraham\\'s Sanctuary.';
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
      pitch = Math.max(-0.1, Math.min(1.15, pitch + (e.clientY - ly) * 0.006));
      lx = e.clientX; ly = e.clientY;
    });

    function proj(x, y, z, cx, cy, sc) {
      const cyw = Math.cos(yaw), syw = Math.sin(yaw);
      const x1 = x * cyw - z * syw, z1 = x * syw + z * cyw;
      const cp = Math.cos(pitch), sp = Math.sin(pitch);
      const y2 = y * cp - z1 * sp, z2 = y * sp + z1 * cp;
      const dist = 620 + z2;
      if (dist < 40) return null;
      const p = (490 / dist) * sc;
      return { sx: cx + x1 * p, sy: cy - y2 * p };
    }

    function line3D(a, b, cx, cy, sc, col, w = 1.3, al = 0.85) {
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
      const cx = w * 0.5, cy = h * 0.56;

      // Draw the Black-Brass Solomonic Lamp (Al-Qumqum) at the base (y = -85 .. -45)
      for (let i = 0; i < 16; i++) {
        const a1 = (i/16)*Math.PI*2, a2 = ((i+1)/16)*Math.PI*2;
        line3D([Math.cos(a1)*42, -85, Math.sin(a1)*42], [Math.cos(a2)*42, -85, Math.sin(a2)*42], cx, cy, zoom, "#D4AF37", 1.7, 0.9);
        line3D([Math.cos(a1)*26, -52, Math.sin(a1)*26], [Math.cos(a2)*26, -52, Math.sin(a2)*26], cx, cy, zoom, "#B87333", 1.6, 0.9);
        line3D([Math.cos(a1)*42, -85, Math.sin(a1)*42], [Math.cos(a1)*26, -52, Math.sin(a1)*26], cx, cy, zoom, "#B87333", 1.1, 0.65);
      }
      // Lamp Spout extending to x = +68, y = -42
      line3D([26, -58, 0], [68, -42, 0], cx, cy, zoom, "#FDE68A", 2.4, 0.95);

      if (mode === 'FORMATION') {
        // Expanding Crimson Marid Vortex & Cobra Serpent Staff rising upward
        for (let l = 0; l < 18; l++) {
          const y1 = -40 + l * 10;
          const y2 = y1 + 10;
          const r1 = 20 + l * 7.5;
          const r2 = 20 + (l+1) * 7.5;
          const a1 = l * 0.65 + t * 2.2;
          const a2 = (l+1) * 0.65 + t * 2.2;
          line3D([Math.cos(a1)*r1, y1, Math.sin(a1)*r1], [Math.cos(a2)*r2, y2, Math.sin(a2)*r2], cx, cy, zoom, "#EF4444", 2.1, 0.9);
          line3D([-Math.cos(a1)*r1, y1, -Math.sin(a1)*r1], [-Math.cos(a2)*r2, y2, -Math.sin(a2)*r2], cx, cy, zoom, "#A855F7", 1.7, 0.8);
        }
      } else if (mode === 'DISSOLUTION') {
        // Imploding Funnel sucked down into the Lamp Spout (x = 68, y = -42) + Brass Manacles (Al-Asfad)
        const collapse = 0.55 + 0.35 * Math.sin(t * 2.0);
        for (let l = 0; l < 16; l++) {
          const frac = l / 16.0;
          const y = -42 + frac * 165 * collapse;
          const r = (12 + frac * 115) * collapse;
          const a1 = l * 0.8 - t * 3.0;
          const a2 = (l+1) * 0.8 - t * 3.0;
          const ox = 68 * (1 - frac);
          line3D([ox + Math.cos(a1)*r, y, Math.sin(a1)*r], [ox + Math.cos(a2)*r, y + 8, Math.sin(a2)*r], cx, cy, zoom, "#EF4444", 1.9, 0.9);
        }
        // Brass Fetters (Al-Asfad) clamping the vortex
        for (let i = 0; i < 12; i++) {
          const a1 = (i/12)*Math.PI*2, a2 = ((i+1)/12)*Math.PI*2;
          line3D([Math.cos(a1)*75, 45, Math.sin(a1)*75], [Math.cos(a2)*75, 45, Math.sin(a2)*75], cx, cy, zoom, "#FDE68A", 2.4, 0.95);
        }
      } else {
        // SEQUESTER MODE: Impenetrable Inter-World Sequester Wall (Sur Al-Hadid / Al-Hijr Al-Mahjur) at x = 0
        for (let g = -160; g <= 160; g += 32) {
          line3D([0, -110, g], [0, 130, g], cx, cy, zoom, "#34D399", 1.8, 0.85);
          line3D([0, g*0.7, -160], [0, g*0.7, 160], cx, cy, zoom, "#34D399", 1.4, 0.7);
        }
        // Left Side (x = -130): Abrahamic Sanctuary Protected
        for (let i = 0; i < 8; i++) {
          const a1 = (i/8)*Math.PI*2, a2 = ((i+1)/8)*Math.PI*2;
          line3D([-130+Math.cos(a1)*65, -50, Math.sin(a1)*65], [-130+Math.cos(a2)*65, -50, Math.sin(a2)*65], cx, cy, zoom, "#38BDF8", 1.7, 0.9);
          line3D([-130+Math.cos(a1)*65, 50, Math.sin(a1)*65], [-130, 105, 0], cx, cy, zoom, "#38BDF8", 1.4, 0.85);
        }
      }

      requestAnimationFrame(loop);
    }
    requestAnimationFrame(loop);
  </script>
</body>
</html>
""".formatted(stageCards.toString());
    }

    private String renderInterWorldSequesterHtml() {
        StringBuilder rows = new StringBuilder();
        for (InterWorldSequester s : WarlockFormationDissolutionAndSequester.allInterWorldSequesters()) {
            rows.append(String.format("""
                    <tr>
                      <td>
                        <strong style="color:#34D399;font-size:0.95rem;">Sequester #%d: %s</strong><br>
                        <code>%s</code><br>
                        <a href="%s" style="color:#38BDF8;font-size:0.8rem;">Inspect World #%d</a>
                      </td>
                      <td>
                        <strong style="color:#FDE68A;">%s</strong><br>
                        <span style="font-size:0.82rem;color:#CBD5E1;">%s</span>
                      </td>
                      <td>
                        <span style="color:#A7F3D0;font-weight:600;">Protected Hegemon:</span> %s<br><br>
                        <span style="color:#FCA5A5;font-weight:600;">Quarantined Disorder:</span> %s
                      </td>
                      <td style="font-size:0.83rem;color:#E2E8F0;">%s</td>
                      <td>
                        <strong style="color:#FDE68A;">%s</strong><br>
                        <code style="color:#34D399;">Attenuation: %.1f ms | Leakage: %.3f</code>
                      </td>
                    </tr>
                    """,
                    s.sequesterIndex(), escape(s.arabicSequesterName()), escape(s.sequesterCode()),
                    s.worldHtmlFile(), s.worldIndex(),
                    escape(s.englishSequesterTitle()), escape(s.sequesterGeometryAndSeal()),
                    escape(s.hegemonPoleProtected()), escape(s.disorderPoleQuarantined()),
                    escape(s.quranicBarrierVerse()),
                    escape(s.sealedQumqumVesselDesignation()), s.attenuationTimeMs(), s.transmissionLeakageProbability()
            ));
        }

        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>The 7 Inter-World Sequesters (Al-Hijr Al-Mahjur &amp; Sur Al-Hadid) | Separating Hegemon &amp; Disorder</title>
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
      background: var(--bg-deep);
      color: var(--text-main);
      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
      line-height: 1.6;
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
      max-width: 1400px;
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
      background: rgba(52, 211, 153, 0.14);
    }
    main { max-width: 1400px; margin: 1.8rem auto; padding: 0 1.5rem; }
    .hero {
      background: linear-gradient(135deg, #0F1420 0%%, #064E3B 100%%);
      border: 1px solid var(--border);
      border-left: 6px solid #34D399;
      border-radius: 14px;
      padding: 1.75rem 2rem;
      margin-bottom: 1.5rem;
    }
    h1 { font-size: 1.95rem; margin-bottom: 0.4rem; }
    .table-card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-radius: 12px;
      padding: 1.4rem;
      overflow-x: auto;
    }
    table { width: 100%%; border-collapse: collapse; font-size: 0.87rem; }
    th, td {
      text-align: left;
      padding: 0.8rem 0.6rem;
      border-bottom: 1px solid rgba(255,255,255,0.08);
      vertical-align: top;
    }
    th {
      color: var(--text-muted);
      font-size: 0.75rem;
      text-transform: uppercase;
      letter-spacing: 0.05em;
    }
    code { font-family: Consolas, monospace; color: #A5F3FC; }
  </style>
</head>
<body>
  <header>
    <nav class="nav-bar">
      <a class="nav-pill active" href="sequester-between-worlds.html">7 Inter-World Sequesters</a>
      <a class="nav-pill" href="warlock-formation-dissolution-jafar-aladdin.html" style="border-color:#FDE68A;color:#FDE68A;">Formation &amp; Dissolution (Ja'far / 'Ala' ad-Din)</a>
      <a class="nav-pill" href="worlds-hegemon-disorder.html" style="border-color:#C084FC;color:#E9D5FF;">Master 7-Worlds Atlas</a>
      <a class="nav-pill" href="priory-negentropy-order.html">Negentropic Priory</a>
      <a class="nav-pill" href="zalim-1-fasad.html" style="border-color:#EF4444;color:#FCA5A5;">7 Wrongdoers (Zalim)</a>
      <a class="nav-pill" href="dependencies-report.html" style="margin-left:auto;color:#38BDF8;">Dependencies</a>
    </nav>
  </header>
  <main>
    <section class="hero">
      <h1>The 7 Inter-World Sequesters (Al-Hijr Al-Mahjur &amp; Sur Al-Hadid): Partitioning Hegemon from Disorder</h1>
      <p style="color:#CBD5E1;font-size:0.96rem;">
        Anchored in <strong>Qur'an 25:53</strong> (<em>&ldquo;Wa ja'ala baynahuma barzakhan wa hijran mahjura&rdquo;</em> — an inviolable Sequester),
        <strong>Qur'an 57:13</strong> (<em>&ldquo;Fa-duriba baynahum bi-surin lahu bab: batinuhu fihi ar-rahmatu wa zahiruhu min qibalihi al-'adhab&rdquo;</em>),
        and <strong>Qur'an 18:94-97</strong> (<em>Radm Dhi Al-Qarnayn</em>), each Inter-World Sequester stands between the
        Abrahamic World of Hegemon and the Wrongdoer World of Disorder, sealing the dissolved Warlock's <strong>Qumqum Lamp</strong>
        with <code>0.000</code> cross-world leakage.
      </p>
    </section>

    <section class="table-card">
      <table>
        <thead>
          <tr>
            <th style="width:18%%;">Sequester Code &amp; World</th>
            <th style="width:22%%;">Architecture &amp; Barrier Geometry</th>
            <th style="width:22%%;">Separated Poles (Hegemon vs. Disorder)</th>
            <th style="width:22%%;">Qur'anic Barrier Criterion</th>
            <th style="width:16%%;">Sealed Qumqum Vessel</th>
          </tr>
        </thead>
        <tbody>
          %s
        </tbody>
      </table>
    </section>
  </main>
</body>
</html>
""".formatted(rows.toString());
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
