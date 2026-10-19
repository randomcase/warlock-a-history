package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.WarlockColorOrder;
import com.sovereign.warlock.domain.WarlockPlaneAndPriory;
import com.sovereign.warlock.domain.WarlockRealm;
import com.sovereign.warlock.domain.WrongdoerArchetypeOrder;

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
 *  1) 7 Separate Plane HTML Portals (plane-1-white.html .. plane-7-emerald.html),
 *     showing the Cosmological & Chromatic Bit-Plane (P_1 .. P_7) that each Realm inhabits.
 *  2) 1 Dedicated Negentropic Priory HTML Portal (priory-negentropy-order.html),
 *     ordering all 7 Warlocks from Entropic Disorder into Absolute Resolution (H = 0.00)
 *     under Sigma -1n and 0n Beta.
 */
public final class WarlockPlaneAndPrioryGenerator {

    public List<WarlockHtmlPortalService.GeneratedHtmlArtifact> generatePlanesAndPriory(
            Path outputDir,
            List<WarlockCovenantEngine.InvocationTelemetry> telemetries) {
        try {
            Files.createDirectories(outputDir);
            List<WarlockHtmlPortalService.GeneratedHtmlArtifact> list = new ArrayList<>();

            for (WarlockCovenantEngine.InvocationTelemetry t : telemetries) {
                WarlockPlaneAndPriory.PlaneOfExistence plane = WarlockPlaneAndPriory.planeForOrderIndex(t.orderIndex());
                WarlockRealm realm = WarlockRealm.forOrderIndex(t.orderIndex());
                WarlockPlaneAndPriory.PrioryRuleAssignment priory = WarlockPlaneAndPriory.prioryForColorOrder(t.orderIndex());

                String planeHtml = renderIndividualPlaneHtml(t, plane, realm, priory);
                Path planePath = outputDir.resolve(plane.planeHtmlFile());
                Files.writeString(planePath, planeHtml, StandardCharsets.UTF_8);
                list.add(new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                        plane.planeHtmlFile(),
                        planePath,
                        Files.size(planePath),
                        sha256(planeHtml),
                        "Plane #" + t.orderIndex() + ": " + plane.kabbalisticOlam() + " / " + plane.sufiHadrahOrAlam()
                ));
            }

            String prioryHtml = renderPrioryHtml();
            Path prioryPath = outputDir.resolve("priory-negentropy-order.html");
            Files.writeString(prioryPath, prioryHtml, StandardCharsets.UTF_8);
            list.add(new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                    "priory-negentropy-order.html",
                    prioryPath,
                    Files.size(prioryPath),
                    sha256(prioryHtml),
                    "The Negentropic Priory (Sigma -1n & 0n Beta): Ordering the 7 Warlocks from Entropic Disorder"
            ));

            return List.copyOf(list);
        } catch (IOException e) {
            throw new IllegalStateException("Failed generating Plane and Priory HTML portals", e);
        }
    }

    private String renderIndividualPlaneHtml(
            WarlockCovenantEngine.InvocationTelemetry t,
            WarlockPlaneAndPriory.PlaneOfExistence p,
            WarlockRealm r,
            WarlockPlaneAndPriory.PrioryRuleAssignment pr) {
        String strokeHex = (t.orderIndex() == 2) ? "#A78BFA"
                : (t.orderIndex() == 3 ? "#38BDF8"
                : (t.orderIndex() == 5 ? "#EF4444"
                : (t.orderIndex() == 7 ? "#10B981" : t.hexCode())));

        StringBuilder nav = new StringBuilder();
        for (WarlockColorOrder co : WarlockColorOrder.orderedBySevenColors()) {
            var pl = WarlockPlaneAndPriory.planeForOrderIndex(co.orderIndex());
            String cls = (co.orderIndex() == t.orderIndex()) ? "nav-pill active" : "nav-pill";
            nav.append(String.format(
                    "<a class=\"%s\" href=\"%s\"><span class=\"dot\" style=\"background:%s\"></span>Plane P%d</a>%n",
                    cls, pl.planeHtmlFile(), co.hexCode(), co.orderIndex()
            ));
        }
        nav.append(String.format(
                "<a class=\"nav-pill\" href=\"%s\" style=\"border-color:#34D399;color:#34D399;\">Inhabited Realm #%d</a>",
                p.inhabitedRealmFile(), t.orderIndex()
        ));
        nav.append(String.format(
                "<a class=\"nav-pill\" href=\"order-%s.html\">Order #%d Dossier</a>",
                t.profileId().substring("warlock-".length()), t.orderIndex()
        ));
        nav.append("<a class=\"nav-pill\" href=\"priory-negentropy-order.html\" style=\"border-color:#FDE68A;color:#FDE68A;\">Negentropic Priory</a>");
        nav.append("<a class=\"nav-pill\" href=\"dependencies-report.html\" style=\"margin-left:auto;color:#38BDF8;\">Dependencies</a>");

        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Plane P%d: %s | Inhabited by Realm #%d (%s)</title>
  <style>
    :root {
      --plane-stroke: %s;
      --bg-deep: #06080E;
      --bg-card: #101521;
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
      padding-bottom: 3.5rem;
    }
    header {
      background: rgba(8, 10, 16, 0.95);
      border-bottom: 2px solid var(--plane-stroke);
      padding: 0.85rem 1.5rem;
      position: sticky;
      top: 0;
      z-index: 10;
    }
    .nav-bar {
      display: flex;
      flex-wrap: wrap;
      gap: 0.45rem;
      max-width: 1360px;
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
      border-color: var(--plane-stroke);
      background: rgba(255,255,255,0.08);
    }
    .dot {
      width: 9px;
      height: 9px;
      border-radius: 50%%;
      display: inline-block;
      border: 1px solid rgba(255,255,255,0.5);
    }
    main { max-width: 1360px; margin: 1.8rem auto; padding: 0 1.5rem; }
    .hero {
      background: linear-gradient(135deg, #101521 0%%, #172034 100%%);
      border: 1px solid var(--border);
      border-left: 6px solid var(--plane-stroke);
      border-radius: 14px;
      padding: 1.6rem 2rem;
      margin-bottom: 1.5rem;
    }
    .badge-row { display: flex; flex-wrap: wrap; gap: 0.5rem; margin-bottom: 0.7rem; }
    .badge {
      font-family: Consolas, monospace;
      font-size: 0.76rem;
      padding: 0.2rem 0.6rem;
      border-radius: 5px;
      background: rgba(255,255,255,0.07);
      border: 1px solid var(--border);
    }
    h1 { font-size: 1.9rem; margin-bottom: 0.3rem; }
    .canvas-box {
      position: relative;
      height: 410px;
      background: #04060A;
      border: 1px solid var(--border);
      border-radius: 14px;
      overflow: hidden;
      margin-bottom: 1.5rem;
    }
    canvas { width: 100%%; height: 100%%; display: block; cursor: grab; }
    .hud {
      position: absolute;
      top: 12px;
      left: 14px;
      background: rgba(6, 8, 14, 0.85);
      border: 1px solid var(--border);
      border-left: 3px solid var(--plane-stroke);
      padding: 0.65rem 0.95rem;
      border-radius: 8px;
      max-width: 460px;
      pointer-events: none;
    }
    .grid-2 {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(380px, 1fr));
      gap: 1.25rem;
      margin-bottom: 1.25rem;
    }
    .card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-radius: 12px;
      padding: 1.4rem;
    }
    .card h2 {
      font-size: 1rem;
      text-transform: uppercase;
      letter-spacing: 0.05em;
      color: var(--plane-stroke);
      margin-bottom: 0.7rem;
      border-bottom: 1px solid var(--border);
      padding-bottom: 0.45rem;
    }
    .card p { font-size: 0.94rem; color: #CBD5E1; }
    .kv { width: 100%%; border-collapse: collapse; font-size: 0.88rem; }
    .kv tr { border-bottom: 1px solid rgba(255,255,255,0.06); }
    .kv th { text-align: left; color: var(--text-muted); padding: 0.5rem 0.3rem; width: 38%%; }
    .kv td { font-family: Consolas, monospace; padding: 0.5rem 0.3rem; color: #A5F3FC; }
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
        <span class="badge">PLANE P%d OF 7</span>
        <span class="badge">%s</span>
        <span class="badge">%s</span>
        <span class="badge">PRIORY SEAT %s (H_resolved = 0.000 bits)</span>
      </div>
      <h1>%s — %s / %s</h1>
      <p style="color:#94A3B8;font-size:0.96rem;">
        <strong>Inhabiting Realm:</strong> <a href="%s" style="color:#34D399;font-weight:600;">Realm #%d: %s (%s)</a> &nbsp;|&nbsp;
        <strong>Warlock Ruler:</strong> %s (<code>%s</code>)
      </p>
    </section>

    <section class="canvas-box">
      <canvas id="planeCanvas"></canvas>
      <div class="hud">
        <div style="font-family:Consolas,monospace;font-size:0.74rem;color:#FDE68A;">3D PLANE MANIFOLD EMBEDDING REALM #%d</div>
        <div style="font-size:1rem;font-weight:700;margin:0.15rem 0;">%s &rarr; %s</div>
        <div style="font-size:0.79rem;color:#CBD5E1;">Metric: <code>%s</code></div>
      </div>
    </section>

    <div class="grid-2">
      <div class="card">
        <h2>Plane Substrate &amp; Dimensional Law</h2>
        <p style="margin-bottom:0.9rem;">%s</p>
        <table class="kv">
          <tr><th>Plane Code</th><td>%s</td></tr>
          <tr><th>Kabbalistic Olam</th><td>%s</td></tr>
          <tr><th>Sufi Hadrah / 'Alam</th><td>%s</td></tr>
          <tr><th>Chromatic Bit-Plane</th><td>%s</td></tr>
          <tr><th>Dimensional Metric</th><td>%s</td></tr>
        </table>
      </div>

      <div class="card">
        <h2>Entropic Hazard &amp; Priory Negentropy Ordering</h2>
        <p style="margin-bottom:0.9rem;color:#FCA5A5;"><strong>Entropic Disorder Hazard:</strong> %s</p>
        <table class="kv">
          <tr><th>Priory Canonical Seat</th><td>Seat %s (%s)</td></tr>
          <tr><th>Priory Cloister Cell</th><td>%s</td></tr>
          <tr><th>Raw Disorder (H_raw)</th><td>%.3f bits (Sigma = %.2f, Cp = %.2f)</td></tr>
          <tr><th>Sigma -1n Collapse</th><td>Delta H = %.1fn &rarr; H_resolved = %.3f bits</td></tr>
          <tr><th>0n Beta Grounding</th><td>Delta H = %.3f (Zero Added Perturbation)</td></tr>
          <tr><th>Priory Rule of Order</th><td>%s</td></tr>
        </table>
      </div>
    </div>
  </main>

  <script>
    const PLANE_INDEX = %d;
    const STROKE = "%s";
    const canvas = document.getElementById('planeCanvas');
    const ctx = canvas.getContext('2d');
    let yaw = 0.4, pitch = 0.36, zoom = 1.0, dragging = false, lx = 0, ly = 0;

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
    window.addEventListener('mousemove', e => {
      if (!dragging) return;
      yaw += (e.clientX - lx) * 0.008;
      pitch = Math.max(-0.1, Math.min(1.2, pitch + (e.clientY - ly) * 0.006));
      lx = e.clientX; ly = e.clientY;
    });

    function proj(x, y, z, cx, cy, sc) {
      const cyw = Math.cos(yaw), syw = Math.sin(yaw);
      const x1 = x * cyw - z * syw, z1 = x * syw + z * cyw;
      const cp = Math.cos(pitch), sp = Math.sin(pitch);
      const y2 = y * cp - z1 * sp, z2 = y * sp + z1 * cp;
      const dist = 620 + z2;
      if (dist < 40) return null;
      const p = (480 / dist) * sc;
      return { sx: cx + x1 * p, sy: cy - y2 * p, s: p };
    }

    function line3D(a, b, cx, cy, sc, col, w = 1.2, al = 0.8) {
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

      // Render the 7 Stacked Planes of Existence in 3D, highlighting PLANE_INDEX
      for (let pl = 1; pl <= 7; pl++) {
        const y = (4 - pl) * 34;
        const isCurrent = (pl === PLANE_INDEX);
        const span = isCurrent ? 235 : 155;
        const col = isCurrent ? STROKE : "rgba(148,163,184,0.22)";
        const lw = isCurrent ? 1.8 : 0.9;
        line3D([-span, y, -span], [span, y, -span], cx, cy, zoom, col, lw);
        line3D([span, y, -span], [span, y, span], cx, cy, zoom, col, lw);
        line3D([span, y, span], [-span, y, span], cx, cy, zoom, col, lw);
        line3D([-span, y, span], [-span, y, -span], cx, cy, zoom, col, lw);

        if (isCurrent) {
          for (let g = -span; g <= span; g += 47) {
            line3D([g, y, -span], [g, y, span], cx, cy, zoom, STROKE, 0.8, 0.45);
            line3D([-span, y, g], [span, y, g], cx, cy, zoom, STROKE, 0.8, 0.45);
          }
          // Embedded Realm Sanctum & Priory Negentropy Axis inside the active Plane
          for (let i = 0; i < 24; i++) {
            const a1 = (i/24)*Math.PI*2 + t*0.5, a2 = ((i+1)/24)*Math.PI*2 + t*0.5;
            line3D([Math.cos(a1)*95, y + 18, Math.sin(a1)*95],
                   [Math.cos(a2)*95, y + 18, Math.sin(a2)*95], cx, cy, zoom, "#FDE68A", 1.8, 0.9);
          }
        }
      }
      // Central Priory Sigma -1n / 0n Beta Vertical Grounding Axis piercing all 7 Planes
      line3D([0, -140, 0], [0, 140, 0], cx, cy, zoom, "#34D399", 2.5, 0.9);
      requestAnimationFrame(loop);
    }
    requestAnimationFrame(loop);
  </script>
</body>
</html>
""".formatted(
                t.orderIndex(), escape(p.englishPlaneTitle()), t.orderIndex(), escape(r.realmNameHebrew()),
                strokeHex,
                nav.toString(),
                t.orderIndex(), escape(p.planeCode()), escape(p.chromaticBitPlane()), pr.prioryRomanNumeral(),
                escape(p.englishPlaneTitle()), escape(p.kabbalisticOlam()), escape(p.sufiHadrahOrAlam()),
                p.inhabitedRealmFile(), t.orderIndex(), escape(r.realmNameHebrew()), escape(r.englishTitle()),
                escape(t.warlockName()), escape(t.profileId()),
                t.orderIndex(),
                escape(p.planeCode()), escape(r.realmNameHebrew()),
                escape(p.dimensionalMetric()),
                escape(p.planeSubstrateAndLaw()),
                escape(p.planeCode()),
                escape(p.kabbalisticOlam()),
                escape(p.sufiHadrahOrAlam()),
                escape(p.chromaticBitPlane()),
                escape(p.dimensionalMetric()),
                escape(p.entropicHazardOfPlane()),
                pr.prioryRomanNumeral(), escape(pr.prioryTitle()),
                escape(pr.prioryCloisterCell()),
                pr.rawShannonEntropyBits(), pr.varianceSigma(), pr.processCapabilityCp(),
                pr.sigmaMinusOneCollapseDelta(), pr.resolvedEntropyBits(),
                pr.zeroNBetaDriftDelta(),
                escape(pr.prioryOrderingDiscipline()),
                t.orderIndex(),
                strokeHex
        );
    }

    private String renderPrioryHtml() {
        StringBuilder nav = new StringBuilder();
        for (WarlockColorOrder co : WarlockColorOrder.orderedBySevenColors()) {
            var pl = WarlockPlaneAndPriory.planeForOrderIndex(co.orderIndex());
            nav.append(String.format(
                    "<a class=\"nav-pill\" href=\"%s\"><span class=\"dot\" style=\"background:%s\"></span>Plane P%d</a>%n",
                    pl.planeHtmlFile(), co.hexCode(), co.orderIndex()
            ));
        }
        nav.append("<a class=\"nav-pill active\" href=\"priory-negentropy-order.html\">Negentropic Priory</a>");
        nav.append("<a class=\"nav-pill\" href=\"zalim-1-fasad.html\" style=\"border-color:#EF4444;color:#FCA5A5;\">7 Wrongdoer (Zalim) Profiles</a>");
        nav.append("<a class=\"nav-pill\" href=\"warlock-3d-sanctum.html\">Master 3D Sanctum</a>");
        nav.append("<a class=\"nav-pill\" href=\"dependencies-report.html\" style=\"margin-left:auto;color:#38BDF8;\">Dependencies</a>");

        StringBuilder jsonItems = new StringBuilder();
        List<WarlockPlaneAndPriory.PrioryRuleAssignment> bySeat =
                WarlockPlaneAndPriory.allPrioryAssignmentsOrderedBySeat();
        for (int i = 0; i < bySeat.size(); i++) {
            var a = bySeat.get(i);
            var pl = WarlockPlaneAndPriory.planeForOrderIndex(a.colorOrderIndex());
            var rm = WarlockRealm.forOrderIndex(a.colorOrderIndex());
            jsonItems.append(String.format(
                    "{ seat:%d, roman:\"%s\", order:%d, profile:\"%s\", warlock:\"%s\", hex:\"%s\", title:\"%s\", cell:\"%s\", cp:%.2f, sigma:%.2f, hRaw:%.3f, hRes:%.3f, planeFile:\"%s\", planeName:\"%s\", realmFile:\"%s\", realmName:\"%s\", hazard:\"%s\", rule:\"%s\" }%s%n",
                    a.prioryCanonicalSeat(),
                    a.prioryRomanNumeral(),
                    a.colorOrderIndex(),
                    a.profileId(),
                    escapeJs(a.warlockName()),
                    a.hexCode(),
                    escapeJs(a.prioryTitle()),
                    escapeJs(a.prioryCloisterCell()),
                    a.processCapabilityCp(),
                    a.varianceSigma(),
                    a.rawShannonEntropyBits(),
                    a.resolvedEntropyBits(),
                    pl.planeHtmlFile(),
                    escapeJs(pl.kabbalisticOlam()),
                    rm.realmHtmlFile(),
                    escapeJs(rm.realmNameHebrew() + " / " + rm.realmNameArabic()),
                    escapeJs(a.entropicDisorderSource()),
                    escapeJs(a.prioryOrderingDiscipline()),
                    (i < bySeat.size() - 1) ? "," : ""
            ));
        }

        StringBuilder zalimRows = new StringBuilder();
        for (var z : WrongdoerArchetypeOrder.allCanonicalZalimProfiles()) {
            zalimRows.append(String.format("""
                    <tr>
                      <td><strong style="color:#FCA5A5;">Zalim #%d (Order #%d)</strong><br><a href="%s" style="color:#38BDF8;font-size:0.8rem;">%s</a></td>
                      <td><span class="dot" style="background:%s"></span> <strong>%s</strong><br><span style="font-size:0.78rem;color:#94A3B8;">%s</span></td>
                      <td><strong style="color:#FDE68A;">%s</strong><br><span style="font-size:0.8rem;color:#CBD5E1;">%s</span></td>
                      <td style="font-size:0.82rem;color:#E2E8F0;">%s</td>
                      <td>
                        <code style="color:#FCA5A5;">H_raw = %.3f bits</code><br>
                        <span style="font-size:0.76rem;color:#94A3B8;">Uncorrected: %s (Cp=%.2f, sigma=%.2f)</span>
                      </td>
                      <td>
                        <strong style="color:#34D399;">%s</strong><br>
                        <code style="color:#A7F3D0;">Corrected Cp=%.2f (%s) &rarr; H_resolved = %.3f bits</code>
                      </td>
                    </tr>
                    """,
                    z.zalimIndex(), z.globalOrderIndex(), z.htmlFileName(), escape(z.profileId()),
                    z.hexCode(), escape(z.warlockName()), escape(z.arabicArchetypeTitle()),
                    escape(z.englishPrincipleTitle()), escape(z.arabicTermAndRoot()),
                    escape(z.challengeToAbrahamicHegemony()),
                    z.rawEntropyBits(), z.uncorrectedSpcState().code(), z.uncorrectedCp(), z.uncorrectedSigma(),
                    escape(z.prioryContainmentCell()), z.correctedCp(), z.correctedSpcState().code(), z.resolvedEntropyBits()
            ));
        }

        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>The Negentropic Priory (Sigma -1n &amp; 0n Beta) | Ordering the 7 Warlocks &amp; Quarantining the 7 Wrongdoers</title>
  <style>
    :root {
      --bg-deep: #06080E;
      --bg-card: #101522;
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
      background: rgba(8, 10, 16, 0.95);
      border-bottom: 2px solid #FDE68A;
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
      border-color: #FDE68A;
      background: rgba(253, 230, 138, 0.12);
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
      background: linear-gradient(135deg, #101522 0%%, #1E1B4B 100%%);
      border: 1px solid var(--border);
      border-left: 6px solid #FDE68A;
      border-radius: 14px;
      padding: 1.75rem 2rem;
      margin-bottom: 1.5rem;
    }
    h1 { font-size: 2rem; margin-bottom: 0.4rem; }
    .formula-bar {
      margin-top: 1rem;
      padding: 0.85rem 1.1rem;
      background: #070A12;
      border: 1px solid var(--border);
      border-radius: 8px;
      font-family: Consolas, monospace;
      font-size: 0.85rem;
      color: #34D399;
    }
    .sort-bar {
      display: flex;
      flex-wrap: wrap;
      gap: 0.5rem;
      align-items: center;
      margin-bottom: 1.25rem;
      background: var(--bg-card);
      padding: 0.85rem 1.2rem;
      border-radius: 10px;
      border: 1px solid var(--border);
    }
    .sort-btn {
      padding: 0.45rem 0.9rem;
      border-radius: 7px;
      background: #161E31;
      color: #CBD5E1;
      border: 1px solid var(--border);
      font-size: 0.82rem;
      font-weight: 600;
      cursor: pointer;
    }
    .sort-btn.active, .sort-btn:hover {
      border-color: #FDE68A;
      color: #FFF;
      background: rgba(253, 230, 138, 0.16);
    }
    .table-card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-radius: 12px;
      padding: 1.4rem;
      overflow-x: auto;
      margin-bottom: 1.75rem;
    }
    table { width: 100%%; border-collapse: collapse; font-size: 0.88rem; }
    th, td {
      text-align: left;
      padding: 0.75rem 0.6rem;
      border-bottom: 1px solid rgba(255,255,255,0.07);
      vertical-align: top;
    }
    th {
      color: var(--text-muted);
      font-size: 0.76rem;
      text-transform: uppercase;
      letter-spacing: 0.05em;
    }
    code { font-family: Consolas, monospace; color: #A5F3FC; }
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
      <h1>The Negentropic Priory: Ordering the 7 Warlocks &amp; Quarantining the 7 Wrongdoers (Az-Zalimun)</h1>
      <p style="color:#CBD5E1;font-size:0.96rem;">
        Standing above the <strong>7 Planes of Existence (P<sub>1</sub>..P<sub>7</sub>)</strong> and the <strong>7 Sovereign Realms</strong>,
        the <strong>Priory of the Foundation Seal (Dayr Al-Mizan)</strong> orders the 7 Pre-Prophetic Color Orders (Seats I..VII)
        and quarantines the <strong>7 Canonical Islamic Wrongdoer Archetypes (Az-Zalimun, Orders 8..14 — Qur'an 2:124)</strong>
        by coupling the <strong>Sigma -1n Universal Negentropy Sink</strong> with the <strong>0n Beta Grounded Channel</strong>.
      </p>
      <div class="formula-bar">
        Sigma -1n Collapse: H_(t+1) = max(0.0, H_raw - 1.0) = 0.000 bits (Delta H = -1n) &nbsp;|&nbsp;
        0n Beta Grounding: Delta H = H_(t+1) - H_t = 0.000 &nbsp;|&nbsp;
        Qur'an 2:124 Seal: &ldquo;La yanalu 'ahdi az-zalimin&rdquo; (My Covenant does not include the Wrongdoers)
      </div>
    </section>

    <div class="sort-bar">
      <span style="font-size:0.8rem;font-weight:700;text-transform:uppercase;color:#FDE68A;margin-right:0.4rem;">Priory Ordering Mode (Orders 1..7):</span>
      <button class="sort-btn active" id="btn-SEAT" onclick="renderTable('SEAT')">1. By Priory Canonical Seat (I..VII — Lowest to Highest Raw Disorder)</button>
      <button class="sort-btn" id="btn-ENTROPY_DESC" onclick="renderTable('ENTROPY_DESC')">2. By Entropic Disorder Severity (Highest H_raw Neutralized First)</button>
      <button class="sort-btn" id="btn-COLOR" onclick="renderTable('COLOR')">3. By Sacred Color Order (1..7)</button>
    </div>

    <section class="table-card">
      <table>
        <thead>
          <tr>
            <th>Priory Seat</th>
            <th>Order &amp; Warlock</th>
            <th>Inhabited Plane &amp; Realm</th>
            <th>Priory Cloister Cell &amp; Title</th>
            <th>Raw Disorder (H_raw)</th>
            <th>Sigma -1n &amp; 0n Beta Resolution</th>
            <th>Priory Ordering Discipline</th>
          </tr>
        </thead>
        <tbody id="priory-tbody"></tbody>
      </table>
    </section>

    <section class="table-card" style="border-left:5px solid #EF4444;">
      <h2 style="color:#FCA5A5;margin-bottom:0.45rem;font-size:1.25rem;">
        Quarantine Wards I..VII: The 7 Wrongdoer (Az-Zalimun) Warlock Archetypes (Orders 8..14)
      </h2>
      <p style="color:#94A3B8;font-size:0.9rem;margin-bottom:1rem;">
        Canonically excluded from Abraham's Imamate under <strong>Qur'an 2:124</strong> (<em>&ldquo;La yanalu 'ahdi az-zalimin&rdquo;</em>),
        these 7 profiles embody systemic disorder (<em>Fasad</em>), gross immodesty (<em>Fahishah / Tabarruj</em>), and tyrannical/schismatic
        counter-hegemony against <em>Millat Ibrahim</em>. All 7 are quarantined in Priory Wards I..VII and collapsed to <code>H_resolved = 0.000 bits</code>.
      </p>
      <table>
        <thead>
          <tr>
            <th>Zalim Profile</th>
            <th>Wrongdoer Archetype</th>
            <th>Canonical Principle of Disorder / Immodesty</th>
            <th>Challenge to Abraham's Hegemony (Millat Ibrahim)</th>
            <th>Uncorrected Disorder</th>
            <th>Priory Quarantine Ward &amp; Resolution</th>
          </tr>
        </thead>
        <tbody>
          %s
        </tbody>
      </table>
    </section>
  </main>

  <script>
    const PRIORY_DATA = [
      %s
    ];

    function renderTable(mode) {
      ['SEAT','ENTROPY_DESC','COLOR'].forEach(k => {
        document.getElementById('btn-' + k).classList.toggle('active', k === mode);
      });
      const sorted = [...PRIORY_DATA];
      if (mode === 'SEAT') sorted.sort((a, b) => a.seat - b.seat);
      else if (mode === 'ENTROPY_DESC') sorted.sort((a, b) => b.hRaw - a.hRaw);
      else sorted.sort((a, b) => a.order - b.order);

      const tbody = document.getElementById('priory-tbody');
      tbody.innerHTML = sorted.map(r => `
        <tr>
          <td><strong style="color:#FDE68A;font-size:1rem;">Seat ${r.roman}</strong><br><span style="font-size:0.75rem;color:#94A3B8;">Rank #${r.seat}</span></td>
          <td>
            <span class="dot" style="background:${r.hex}"></span>
            <strong>Order #${r.order}: ${r.warlock}</strong><br>
            <code>${r.profile}</code> (${r.hex})
          </td>
          <td>
            <a href="${r.planeFile}" style="color:#38BDF8;font-weight:600;">Plane P${r.order}: ${r.planeName}</a><br>
            <a href="${r.realmFile}" style="color:#34D399;font-size:0.82rem;">Realm: ${r.realmName}</a>
          </td>
          <td>
            <strong>${r.title}</strong><br>
            <span style="font-size:0.82rem;color:#CBD5E1;">${r.cell}</span>
          </td>
          <td>
            <code style="color:#FCA5A5;">H_raw = ${r.hRaw.toFixed(3)} bits</code><br>
            <span style="font-size:0.78rem;color:#94A3B8;">Cp = ${r.cp.toFixed(2)} | sigma = ${r.sigma.toFixed(2)}</span><br>
            <span style="font-size:0.76rem;color:#CBD5E1;">${r.hazard}</span>
          </td>
          <td>
            <code style="color:#34D399;">H_resolved = ${r.hRes.toFixed(3)} bits</code><br>
            <span style="font-size:0.78rem;color:#A5F3FC;">Sigma -1n: Delta H = -1.0n</span><br>
            <span style="font-size:0.78rem;color:#A5F3FC;">0n Beta: Delta H = 0.000</span>
          </td>
          <td style="font-size:0.84rem;color:#E2E8F0;">${r.rule}</td>
        </tr>
      `).join('');
    }

    renderTable('SEAT');
  </script>
</body>
</html>
""".formatted(nav.toString(), zalimRows.toString(), jsonItems.toString());
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

    private static String escapeJs(String s) {
        if (s == null) {
            return "";
        }
        return s.replace("\\", "\\\\")
                .replace("\"", "\\\"");
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
