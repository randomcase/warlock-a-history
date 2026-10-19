package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.IslamicInterlockerEggBinder;
import com.sovereign.warlock.domain.IslamicInterlockerEggBinder.WorldEggInterlockNode;
import com.sovereign.warlock.domain.IslamicWorldOfHegemonAndDisorder;
import com.sovereign.warlock.domain.IslamicWorldOfHegemonAndDisorder.WorldPolarityDossier;
import com.sovereign.warlock.domain.WarlockFormationDissolutionAndSequester;
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
 * Generates the 7 Separate Islamic World of Hegemon & Disorder HTML Portals
 * (world-1-mizan-fasad.html .. world-7-taqwa-dirar.html) plus the Master Atlas
 * (worlds-hegemon-disorder.html).
 */
public final class IslamicWorldsGenerator {

    public List<WarlockHtmlPortalService.GeneratedHtmlArtifact> generateAllWorlds(Path outputDir) {
        try {
            Files.createDirectories(outputDir);
            List<WarlockHtmlPortalService.GeneratedHtmlArtifact> artifacts = new ArrayList<>();

            for (WorldPolarityDossier w : IslamicWorldOfHegemonAndDisorder.allSevenWorlds()) {
                String html = renderIndividualWorldHtml(w);
                Path path = outputDir.resolve(w.worldHtmlFile());
                Files.writeString(path, html, StandardCharsets.UTF_8);
                artifacts.add(new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                        w.worldHtmlFile(),
                        path,
                        Files.size(path),
                        sha256(html),
                        "Islamic World #" + w.worldIndex() + ": " + w.arabicWorldName() + " [" + w.englishWorldTitle() + "]"
                ));
            }

            String atlasHtml = renderMasterWorldsAtlasHtml();
            Path atlasPath = outputDir.resolve("worlds-hegemon-disorder.html");
            Files.writeString(atlasPath, atlasHtml, StandardCharsets.UTF_8);
            artifacts.add(new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                    "worlds-hegemon-disorder.html",
                    atlasPath,
                    Files.size(atlasPath),
                    sha256(atlasHtml),
                    "Master Atlas: The 7 Islamic Worlds of Hegemon (Al-Muhaymin / Millat Ibrahim) & Disorder (Al-Fasad / Az-Zalimun)"
            ));

            return List.copyOf(artifacts);
        } catch (IOException e) {
            throw new IllegalStateException("Failed generating Islamic Worlds of Hegemon & Disorder HTML portals", e);
        }
    }

    private String renderIndividualWorldHtml(WorldPolarityDossier w) {
        InterWorldSequester seq = WarlockFormationDissolutionAndSequester.sequesterForWorldIndex(w.worldIndex());
        WorldEggInterlockNode egg = IslamicInterlockerEggBinder.binderForWorldIndex(w.worldIndex());
        StringBuilder nav = new StringBuilder();
        for (WorldPolarityDossier item : IslamicWorldOfHegemonAndDisorder.allSevenWorlds()) {
            String cls = (item.worldIndex() == w.worldIndex()) ? "nav-pill active" : "nav-pill";
            nav.append(String.format(
                    "<a class=\"%s\" href=\"%s\"><span class=\"dot\" style=\"background:%s\"></span>World #%d</a>%n",
                    cls, item.worldHtmlFile(), item.hegemonColorHex(), item.worldIndex()
            ));
        }
        String orderSuffix = w.hegemonProfileId().substring("warlock-".length());
        nav.append("<a class=\"nav-pill\" href=\"worlds-hegemon-disorder.html\" style=\"border-color:#FDE68A;color:#FDE68A;\">Master 7-Worlds Atlas</a>");
        nav.append("<a class=\"nav-pill\" href=\"interlocker-egg-binder-islam.html\" style=\"border-color:#FBBF24;color:#FBBF24;\">Islamic Intelocketer (Egg Binder)</a>");
        nav.append("<a class=\"nav-pill\" href=\"sequester-between-worlds.html\" style=\"border-color:#38BDF8;color:#38BDF8;\">Inter-World Sequester</a>");
        nav.append("<a class=\"nav-pill\" href=\"warlock-formation-dissolution-jafar-aladdin.html\" style=\"border-color:#C084FC;color:#E9D5FF;\">Ja'far &amp; Aladdin (Qumqum)</a>");
        nav.append(String.format(
                "<a class=\"nav-pill\" href=\"order-%s.html\" style=\"border-color:#34D399;color:#34D399;\">Hegemon Order #%d</a>",
                orderSuffix, w.hegemonOrderIndex()
        ));
        nav.append(String.format(
                "<a class=\"nav-pill\" href=\"%s.html\" style=\"border-color:#EF4444;color:#FCA5A5;\">Disorder: %s</a>",
                w.disorderProfileId(), w.disorderProfileId()
        ));
        nav.append("<a class=\"nav-pill\" href=\"priory-negentropy-order.html\" style=\"margin-left:auto;color:#38BDF8;\">Negentropic Priory</a>");

        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>World #%d: %s | Hegemon vs. Disorder in Islam</title>
  <style>
    :root {
      --hegemon-col: %s;
      --disorder-col: %s;
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
      line-height: 1.65;
      padding-bottom: 4rem;
    }
    header {
      background: rgba(5, 7, 12, 0.95);
      border-bottom: 2px solid var(--hegemon-col);
      padding: 0.85rem 1.5rem;
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
      padding: 0.35rem 0.7rem;
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
      border-color: var(--hegemon-col);
      background: rgba(255,255,255,0.08);
    }
    .dot {
      width: 9px;
      height: 9px;
      border-radius: 50%%;
      display: inline-block;
      border: 1px solid rgba(255,255,255,0.5);
    }
    main { max-width: 1380px; margin: 1.8rem auto; padding: 0 1.5rem; }
    .hero {
      background: linear-gradient(135deg, #0F1420 0%%, #191B2E 100%%);
      border: 1px solid var(--border);
      border-left: 6px solid var(--hegemon-col);
      border-right: 6px solid var(--disorder-col);
      border-radius: 14px;
      padding: 1.7rem 2rem;
      margin-bottom: 1.5rem;
    }
    .badge-row { display: flex; flex-wrap: wrap; gap: 0.5rem; margin-bottom: 0.7rem; }
    .badge {
      font-family: Consolas, monospace;
      font-size: 0.75rem;
      padding: 0.2rem 0.6rem;
      border-radius: 5px;
      background: rgba(255,255,255,0.07);
      border: 1px solid var(--border);
    }
    h1 { font-size: 1.9rem; margin-bottom: 0.35rem; }
    .canvas-box {
      position: relative;
      height: 430px;
      background: #030509;
      border: 1px solid var(--border);
      border-radius: 14px;
      overflow: hidden;
      margin-bottom: 1.5rem;
    }
    canvas { width: 100%%; height: 100%%; display: block; cursor: grab; }
    .hud-left {
      position: absolute;
      top: 12px;
      left: 14px;
      background: rgba(5, 7, 12, 0.88);
      border: 1px solid var(--border);
      border-left: 3px solid #34D399;
      padding: 0.65rem 0.95rem;
      border-radius: 8px;
      max-width: 420px;
      pointer-events: none;
    }
    .hud-right {
      position: absolute;
      top: 12px;
      right: 14px;
      background: rgba(5, 7, 12, 0.88);
      border: 1px solid var(--border);
      border-right: 3px solid #EF4444;
      padding: 0.65rem 0.95rem;
      border-radius: 8px;
      max-width: 420px;
      text-align: right;
      pointer-events: none;
    }
    .grid-2 {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(410px, 1fr));
      gap: 1.25rem;
      margin-bottom: 1.25rem;
    }
    .card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-radius: 12px;
      padding: 1.45rem;
    }
    .card h2 {
      font-size: 1rem;
      text-transform: uppercase;
      letter-spacing: 0.05em;
      margin-bottom: 0.75rem;
      border-bottom: 1px solid var(--border);
      padding-bottom: 0.45rem;
    }
    .card p { font-size: 0.95rem; color: #CBD5E1; margin-bottom: 0.8rem; }
  </style>
</head>
<body>
  <header>
    <nav class="nav-bar">
      %s
    </nav>
  </header>
  <main>
    <section class="hero">
      <div class="badge-row">
        <span class="badge">ISLAMIC WORLD #%d OF 7 (%s)</span>
        <span class="badge" style="color:#34D399;">HEGEMON POLE: Order #%d (%s | Cp=%.2f, S0)</span>
        <span class="badge" style="color:#FCA5A5;">DISORDER POLE: Zalim #%d (%s | Uncorrected Cp=%.2f, S2)</span>
        <span class="badge" style="color:#FDE68A;">PRIORY MIZAN RESOLUTION: H = 0.000 bits</span>
      </div>
      <h1>%s — %s</h1>
      <p style="color:#FDE68A;font-size:0.95rem;">
        <strong>Qur'anic Criterion Axis:</strong> %s
      </p>
    </section>

    <section class="canvas-box">
      <canvas id="worldCanvas"></canvas>
      <div class="hud-left">
        <div style="font-family:Consolas,monospace;font-size:0.74rem;color:#34D399;">LEFT HEMISPHERE: ABRAHAMIC HEGEMON (AL-MUHAYMIN)</div>
        <div style="font-size:0.95rem;font-weight:700;margin:0.15rem 0;">%s</div>
        <div style="font-size:0.78rem;color:#CBD5E1;">Order #%d (<code>%s</code>) | Cp = %.2f (State S0)</div>
      </div>
      <div class="hud-right">
        <div style="font-family:Consolas,monospace;font-size:0.74rem;color:#FCA5A5;">RIGHT HEMISPHERE: WORLD OF DISORDER (AZ-ZALIMUN)</div>
        <div style="font-size:0.95rem;font-weight:700;margin:0.15rem 0;">%s</div>
        <div style="font-size:0.78rem;color:#CBD5E1;">%s (<code>%s</code>) | H_raw = %.3f bits &rarr; Quarantined 0.000</div>
      </div>
    </section>

    <div class="grid-2">
      <div class="card" style="border-top:4px solid #34D399;">
        <h2 style="color:#34D399;">1. The Hegemon Pole (Al-Muhaymin &amp; Millat Ibrahim)</h2>
        <p><strong>Sanctuary &amp; Sovereign Order:</strong> %s</p>
        <p>%s</p>
      </div>

      <div class="card" style="border-top:4px solid #EF4444;">
        <h2 style="color:#FCA5A5;">2. The Disorder Pole (Dar Al-Fasad &amp; Wrongdoer Archetype)</h2>
        <p><strong>Counter-Sanctuary &amp; Entropic Ruin:</strong> %s (Ruled by <code>%s</code>)</p>
        <p>%s</p>
      </div>
    </div>

    <div class="card" style="border-left:5px solid #FDE68A; margin-bottom:1.25rem;">
      <h2 style="color:#FDE68A;">3. Sunnat Allah Historical Trajectory &amp; Priory Mizan Resolution</h2>
      <p><strong>Historical &amp; Sociological Law (Sunnat Allah fi Al-Umam):</strong> %s</p>
      <p style="color:#A7F3D0;margin-bottom:0;"><strong>Priory Sigma -1n &amp; 0n Beta Criterion Verdict:</strong> %s</p>
    </div>

    <div class="card" style="border-left:5px solid #38BDF8; margin-bottom:1.25rem;">
      <h2 style="color:#38BDF8;">4. Inter-World Sequester (%s): %s — %s</h2>
      <p><strong>Qur'anic Barrier Anchor:</strong> %s</p>
      <p><strong>Barrier Architecture &amp; Gate of Mercy vs. Torment (Qur'an 57:13):</strong> %s</p>
      <p><strong>Sealed Qumqum Lamp &amp; Brass Fetters (Al-Qumqum Al-Sulaymani):</strong> <span style="color:#E9D5FF;">%s</span></p>
      <p style="color:#FDE68A;margin-bottom:0;"><strong>Telemetry Invariant:</strong> <code>%s</code></p>
    </div>

    <div class="card" style="border-left:5px solid #FBBF24;">
      <h2 style="color:#FBBF24;">5. Islamic Egg-in-Baking Intelocketer (%s): %s — %s</h2>
      <p><strong>Egg Biochemical Binding Mechanism:</strong> %s (Cross-Link Strength: <code>%.1f kPa</code> | Bound <code>Cp = %.2f</code>)</p>
      <p><strong>Hegemon Flour &amp; Water Bound:</strong> %s</p>
      <p><strong>Disorder Oil &amp; Qumqum Emulsified:</strong> %s</p>
      <p style="color:#E9D5FF;margin-bottom:0;"><strong>Al-A'raf Interlocutor Verdict (%s):</strong> %s</p>
    </div>
  </main>

  <script>
    const WORLD_INDEX = %d;
    const HEG_COL = "%s";
    const DIS_COL = "%s";
    const canvas = document.getElementById('worldCanvas');
    const ctx = canvas.getContext('2d');
    let yaw = 0.28, pitch = 0.34, zoom = 1.0, dragging = false, lx = 0, ly = 0;

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
      const dist = 680 + z2;
      if (dist < 40) return null;
      const p = (510 / dist) * sc;
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
      if (!dragging) yaw += 0.0025;
      const w = canvas.width / window.devicePixelRatio, h = canvas.height / window.devicePixelRatio;
      ctx.clearRect(0, 0, w, h);
      const cx = w * 0.5, cy = h * 0.56;

      // 1) LEFT HEMISPHERE (x = -175): Abrahamic Hegemon Sanctuary (Bunyan At-Taqwa)
      const hx = -175;
      const sides = 8;
      for (let i = 0; i < sides; i++) {
        const a1 = (i/sides)*Math.PI*2, a2 = ((i+1)/sides)*Math.PI*2;
        const r = 95;
        line3D([hx+Math.cos(a1)*r, -55, Math.sin(a1)*r], [hx+Math.cos(a2)*r, -55, Math.sin(a2)*r], cx, cy, zoom, HEG_COL, 1.8, 0.9);
        line3D([hx+Math.cos(a1)*r, 65, Math.sin(a1)*r], [hx+Math.cos(a2)*r, 65, Math.sin(a2)*r], cx, cy, zoom, HEG_COL, 1.8, 0.9);
        line3D([hx+Math.cos(a1)*r, -55, Math.sin(a1)*r], [hx+Math.cos(a1)*r, 65, Math.sin(a1)*r], cx, cy, zoom, HEG_COL, 1.2, 0.65);
        line3D([hx+Math.cos(a1)*r, 65, Math.sin(a1)*r], [hx, 130, 0], cx, cy, zoom, "#34D399", 1.4, 0.85);
      }

      // 2) RIGHT HEMISPHERE (x = +175): World of Disorder (Shafa Jurufin Harin) + Sealed Qumqum Vessel
      const dx = 175;
      for (let i = 0; i < 6; i++) {
        const a1 = (i/6)*Math.PI*2 + t*0.35, a2 = ((i+1)/6)*Math.PI*2 - t*0.25;
        const r = 72 + (i %% 2)*22;
        line3D([dx+Math.cos(a1)*r, -65, Math.sin(a1)*r], [dx+Math.cos(a2)*(r*0.55), 55, Math.sin(a2)*(r*0.55)], cx, cy, zoom, "#EF4444", 1.7, 0.85);
      }
      // Quarantine Containment Ring & Sealed Qumqum around Disorder Pole
      for (let i = 0; i < 12; i++) {
        const a1 = (i/12)*Math.PI*2, a2 = ((i+1)/12)*Math.PI*2;
        line3D([dx+Math.cos(a1)*110, 0, Math.sin(a1)*110], [dx+Math.cos(a2)*110, 0, Math.sin(a2)*110], cx, cy, zoom, "#FDE68A", 1.5, 0.8);
      }

      // 3) CENTRAL INTER-WORLD SEQUESTER (Al-Hijr Al-Mahjur / As-Sur Al-Fasil at x = 0)
      for (let z = -110; z <= 110; z += 44) {
        line3D([0, -95, z], [0, 95, z], cx, cy, zoom, "#38BDF8", 2.0, 0.9);
      }
      line3D([0, -95, -110], [0, -95, 110], cx, cy, zoom, "#FDE68A", 2.2, 0.95);
      line3D([0, 95, -110], [0, 95, 110], cx, cy, zoom, "#FDE68A", 2.2, 0.95);

      requestAnimationFrame(loop);
    }
    requestAnimationFrame(loop);
  </script>
</body>
</html>
""".formatted(
                w.worldIndex(), escape(w.arabicWorldName()),
                w.hegemonColorHex(), w.disorderColorHex(),
                nav.toString(),
                w.worldIndex(), escape(w.worldCode()),
                w.hegemonOrderIndex(), escape(w.hegemonProfileId()), w.hegemonCp(),
                w.disorderZalimIndex(), escape(w.disorderProfileId()), w.disorderUncorrectedCp(),
                escape(w.arabicWorldName()), escape(w.englishWorldTitle()),
                escape(w.quranicCriterionAxis()),
                escape(w.hegemonPoleTitle()), w.hegemonOrderIndex(), escape(w.hegemonProfileId()), w.hegemonCp(),
                escape(w.disorderPoleTitle()), escape(w.disorderWarlockName()), escape(w.disorderProfileId()), w.disorderRawEntropyBits(),
                escape(w.hegemonPoleTitle()), escape(w.hegemonArchitectureAndLaw()),
                escape(w.disorderPoleTitle()), escape(w.disorderWarlockName()), escape(w.disorderArchitectureAndRuin()),
                escape(w.sunnatAllahHistoricalTrajectory()),
                escape(w.prioryMizanResolution()),
                escape(seq.sequesterCode()), escape(seq.arabicSequesterName()), escape(seq.englishSequesterTitle()),
                escape(seq.quranicBarrierVerse()),
                escape(seq.sequesterGeometryAndSeal()),
                escape(seq.sealedQumqumVesselDesignation()),
                String.format("Attenuation = %.1fms | Leakage = %.3f | H_resolved = 0.000 bits", seq.attenuationTimeMs(), seq.transmissionLeakageProbability()),
                escape(egg.binderCode()), escape(egg.arabicBinderName()), escape(egg.englishBinderTitle()),
                escape(egg.eggBiochemicalMechanism()), egg.crossLinkBondStrengthKpa(), egg.coagulatedCp(),
                escape(egg.hegemonFlourAndWaterBound()),
                escape(egg.disorderOilAndQumqumEmulsified()),
                escape(egg.quranicAnchor()), escape(egg.interlocutorCrestVerdict()),
                w.worldIndex(), w.hegemonColorHex(), w.disorderColorHex()
        );
    }

    private String renderMasterWorldsAtlasHtml() {
        StringBuilder rows = new StringBuilder();
        for (WorldPolarityDossier w : IslamicWorldOfHegemonAndDisorder.allSevenWorlds()) {
            String orderSuffix = w.hegemonProfileId().substring("warlock-".length());
            rows.append(String.format("""
                    <tr>
                      <td>
                        <a href="%s" style="color:#FDE68A;font-weight:700;font-size:0.95rem;">World #%d: %s</a><br>
                        <span style="font-size:0.8rem;color:#94A3B8;">%s</span>
                      </td>
                      <td>
                        <strong style="color:#34D399;">%s</strong><br>
                        <a href="order-%s.html" style="color:#38BDF8;font-size:0.8rem;">Order #%d (%s) | Cp=%.2f (S0)</a><br>
                        <span style="font-size:0.8rem;color:#CBD5E1;">%s</span>
                      </td>
                      <td>
                        <strong style="color:#FCA5A5;">%s</strong><br>
                        <a href="%s.html" style="color:#F43F5E;font-size:0.8rem;">%s (%s) | Uncorrected Cp=%.2f (S2), H_raw=%.3f</a><br>
                        <span style="font-size:0.8rem;color:#CBD5E1;">%s</span>
                      </td>
                      <td style="font-size:0.82rem;color:#E2E8F0;">
                        <strong>Qur'anic Axis:</strong> %s<br><br>
                        <strong style="color:#A7F3D0;">Priory Resolution:</strong> %s
                      </td>
                    </tr>
                    """,
                    w.worldHtmlFile(), w.worldIndex(), escape(w.arabicWorldName()), escape(w.englishWorldTitle()),
                    escape(w.hegemonPoleTitle()), orderSuffix, w.hegemonOrderIndex(), escape(w.hegemonProfileId()), w.hegemonCp(),
                    escape(w.hegemonArchitectureAndLaw()),
                    escape(w.disorderPoleTitle()), w.disorderProfileId(), escape(w.disorderWarlockName()), escape(w.disorderProfileId()),
                    w.disorderUncorrectedCp(), w.disorderRawEntropyBits(), escape(w.disorderArchitectureAndRuin()),
                    escape(w.quranicCriterionAxis()), escape(w.prioryMizanResolution())
            ));
        }

        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Master Atlas: The 7 Islamic Worlds of Hegemon (Al-Muhaymin) &amp; Disorder (Al-Fasad / Az-Zalimun)</title>
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
    .nav-pill:hover, .nav-pill.active {
      color: #FFF;
      border-color: #FDE68A;
      background: rgba(253, 230, 138, 0.12);
    }
    main { max-width: 1400px; margin: 1.8rem auto; padding: 0 1.5rem; }
    .hero {
      background: linear-gradient(135deg, #0F1420 0%%, #1E1B4B 100%%);
      border: 1px solid var(--border);
      border-left: 6px solid #34D399;
      border-right: 6px solid #EF4444;
      border-radius: 14px;
      padding: 1.75rem 2rem;
      margin-bottom: 1.5rem;
    }
    h1 { font-size: 2rem; margin-bottom: 0.45rem; }
    .table-card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-radius: 12px;
      padding: 1.4rem;
      overflow-x: auto;
    }
    table { width: 100%%; border-collapse: collapse; font-size: 0.88rem; }
    th, td {
      text-align: left;
      padding: 0.85rem 0.65rem;
      border-bottom: 1px solid rgba(255,255,255,0.08);
      vertical-align: top;
    }
    th {
      color: var(--text-muted);
      font-size: 0.76rem;
      text-transform: uppercase;
      letter-spacing: 0.05em;
    }
  </style>
</head>
<body>
  <header>
    <nav class="nav-bar">
      <a class="nav-pill active" href="worlds-hegemon-disorder.html">Master 7-Worlds Atlas</a>
      <a class="nav-pill" href="world-1-mizan-fasad.html">World #1: Amanah vs. Fasad</a>
      <a class="nav-pill" href="world-2-haya-fahishah.html">World #2: Haya' vs. Fahishah</a>
      <a class="nav-pill" href="world-3-babil-namrud.html">World #3: Ibrahim vs. Namrud</a>
      <a class="nav-pill" href="world-4-ummah-fitnah.html">World #4: Ummah vs. Fitnah</a>
      <a class="nav-pill" href="world-5-furqan-hawa.html">World #5: Furqan vs. Hawa</a>
      <a class="nav-pill" href="world-6-tawhid-taghut.html">World #6: Tawhid vs. Taghut</a>
      <a class="nav-pill" href="world-7-taqwa-dirar.html">World #7: Taqwa vs. Dirar</a>
      <a class="nav-pill" href="priory-negentropy-order.html" style="margin-left:auto;color:#34D399;">Negentropic Priory</a>
    </nav>
  </header>
  <main>
    <section class="hero">
      <h1>The 7 Canonical Islamic Worlds of Hegemon (Al-Muhaymin) &amp; Disorder (Al-Fasad / Az-Zalimun)</h1>
      <p style="color:#CBD5E1;font-size:0.96rem;">
        Anchored in <strong>Qur'an 5:48</strong> (<em>Al-Kitab Muhayminan 'alayhi</em> — Supreme Criterion Hegemon),
        <strong>Qur'an 2:124</strong> (<em>Imamat Ibrahim &amp; Exclusion of Az-Zalimun</em>), and
        <strong>Qur'an 9:107-109</strong> (<em>Bunyan At-Taqwa vs. Shafa Jurufin Harin</em>), each World pairs the
        Abrahamic Hegemony of Tawhid &amp; Mizan (Orders 1..7) against its corresponding Wrongdoer World of Disorder (Zalim 1..7 / Orders 8..14).
      </p>
    </section>

    <section class="table-card">
      <table>
        <thead>
          <tr>
            <th style="width:18%%;">Islamic World ('Alam)</th>
            <th style="width:27%%;">Hegemon Pole (Al-Muhaymin &amp; Millat Ibrahim)</th>
            <th style="width:27%%;">Disorder Pole (Dar Al-Fasad &amp; Az-Zalimun)</th>
            <th style="width:28%%;">Qur'anic Criterion Axis &amp; Priory Resolution</th>
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
