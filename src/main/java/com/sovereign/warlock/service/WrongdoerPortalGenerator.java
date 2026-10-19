package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.WrongdoerArchetypeOrder;
import com.sovereign.warlock.domain.WrongdoerArchetypeOrder.WrongdoerWarlockProfile;

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
 * Generates the 7 Separate HTML Portals for the Canonical Islamic Wrongdoer (Az-Zalimun)
 * Warlock Profiles (zalim-1-fasad.html .. zalim-7-zulm.html), detailing how each embodies
 * disorder (Fasad), immodesty (Fahishah/Tabarruj), and counter-hegemonic rebellion against
 * Abraham's Covenant ("La yanalu 'ahdi az-zalimin" — Qur'an 2:124), and how the Negentropic
 * Priory quarantines and collapses their raw disorder via Sigma -1n and 0n Beta.
 */
public final class WrongdoerPortalGenerator {

    public List<WarlockHtmlPortalService.GeneratedHtmlArtifact> generateZalimPortals(
            Path outputDir,
            List<WrongdoerWarlockProfile> profiles) {
        try {
            Files.createDirectories(outputDir);
            List<WarlockHtmlPortalService.GeneratedHtmlArtifact> artifacts = new ArrayList<>();
            for (WrongdoerWarlockProfile p : profiles) {
                String html = renderZalimHtml(p);
                Path file = outputDir.resolve(p.htmlFileName());
                Files.writeString(file, html, StandardCharsets.UTF_8);
                artifacts.add(new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                        p.htmlFileName(),
                        file,
                        Files.size(file),
                        sha256(html),
                        "Zalim #" + p.zalimIndex() + " (" + p.profileId() + ") -- " + p.warlockName() + " [" + p.englishPrincipleTitle() + "]"
                ));
            }
            return List.copyOf(artifacts);
        } catch (IOException e) {
            throw new IllegalStateException("Failed generating Zalim HTML portals", e);
        }
    }

    private String renderZalimHtml(WrongdoerWarlockProfile p) {
        String activeLowHex = String.format("#%06X", p.activeLow24());
        String strokeHex = switch (p.zalimIndex()) {
            case 1 -> "#EF4444";
            case 2 -> "#F43F5E";
            case 3 -> "#C084FC";
            case 4 -> "#F59E0B";
            case 5 -> "#EAB308";
            case 6 -> "#34D399";
            default -> "#94A3B8";
        };

        StringBuilder nav = new StringBuilder();
        for (WrongdoerWarlockProfile z : WrongdoerArchetypeOrder.allCanonicalZalimProfiles()) {
            String cls = (z.zalimIndex() == p.zalimIndex()) ? "nav-pill active" : "nav-pill";
            nav.append(String.format(
                    "<a class=\"%s\" href=\"%s\"><span class=\"dot\" style=\"background:%s\"></span>Zalim #%d: %s</a>%n",
                    cls, z.htmlFileName(), z.hexCode(), z.zalimIndex(), z.profileId()
            ));
        }
        nav.append("<a class=\"nav-pill\" href=\"priory-negentropy-order.html\" style=\"border-color:#FDE68A;color:#FDE68A;\">Negentropic Priory</a>");
        nav.append("<a class=\"nav-pill\" href=\"order-1-white.html\" style=\"border-color:#34D399;color:#34D399;\">7 Color Orders</a>");
        nav.append("<a class=\"nav-pill\" href=\"dependencies-report.html\" style=\"margin-left:auto;color:#38BDF8;\">Dependencies</a>");

        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Zalim #%d (%s): %s | Wrongdoer Archetype &amp; Abrahamic Covenant Challenge</title>
  <style>
    :root {
      --zalim-hex: %s;
      --zalim-stroke: %s;
      --active-low: %s;
      --bg-deep: #07060A;
      --bg-card: #12101B;
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
      background: rgba(7, 6, 10, 0.95);
      border-bottom: 2px solid var(--zalim-stroke);
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
      border-color: var(--zalim-stroke);
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
      background: linear-gradient(135deg, #12101B 0%%, #23111E 100%%);
      border: 1px solid var(--border);
      border-left: 6px solid var(--zalim-stroke);
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
      height: 390px;
      background: #040307;
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
      background: rgba(7, 6, 10, 0.88);
      border: 1px solid var(--border);
      border-left: 3px solid var(--zalim-stroke);
      padding: 0.65rem 0.95rem;
      border-radius: 8px;
      max-width: 480px;
      pointer-events: none;
    }
    .grid-2 {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(390px, 1fr));
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
      color: var(--zalim-stroke);
      margin-bottom: 0.75rem;
      border-bottom: 1px solid var(--border);
      padding-bottom: 0.45rem;
    }
    .card p { font-size: 0.95rem; color: #CBD5E1; margin-bottom: 0.8rem; }
    .kv { width: 100%%; border-collapse: collapse; font-size: 0.87rem; }
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
        <span class="badge">WRONGDOER ARCHETYPE (AZ-ZALIMUN) #%d OF 7</span>
        <span class="badge">GLOBAL ORDER #%d</span>
        <span class="badge">@Profile("%s")</span>
        <span class="badge">UNCORRECTED: %s (Cp=%.2f, H_raw=%.3f bits)</span>
        <span class="badge" style="color:#34D399;">PRIORY QUARANTINED: %s (Cp=%.2f, H=0.000)</span>
      </div>
      <h1>%s — %s</h1>
      <p style="color:#FCA5A5;font-size:0.98rem;font-weight:600;margin-bottom:0.35rem;">
        %s
      </p>
      <p style="color:#94A3B8;font-size:0.92rem;">
        <strong>Archetype Title:</strong> %s &nbsp;|&nbsp;
        <strong>Category:</strong> %s &nbsp;|&nbsp;
        <strong>Covenant Verdict (Qur'an 2:124):</strong> <em>&ldquo;Lā yanālu 'ahdī aẓ-ẓālimīn&rdquo; (My Covenant does not include the Wrongdoers)</em>
      </p>
    </section>

    <section class="canvas-box">
      <canvas id="zalimCanvas"></canvas>
      <div class="hud">
        <div style="font-family:Consolas,monospace;font-size:0.74rem;color:#FCA5A5;">3D ENTROPIC FRACTURE &amp; PRIORY QUARANTINE CAGE</div>
        <div style="font-size:1rem;font-weight:700;margin:0.15rem 0;">%s (%s)</div>
        <div style="font-size:0.79rem;color:#CBD5E1;">%s</div>
      </div>
    </section>

    <div class="grid-2">
      <div class="card">
        <h2>1. Challenge to the Abrahamic Hegemony (Millat Ibrahim)</h2>
        <p>%s</p>
        <h2>2. Mechanism of Disorder, Immodesty &amp; Transgression</h2>
        <p>%s</p>
      </div>

      <div class="card">
        <h2>3. Qur'anic Criterion Anchor &amp; Priory Negentropic Quarantine</h2>
        <p style="color:#FDE68A;"><strong>Qur'anic Proof:</strong> %s</p>
        <p style="color:#A7F3D0;"><strong>Priory Quarantine Resolution:</strong> %s</p>
        <table class="kv">
          <tr><th>Spring Boot @Profile</th><td>%s (application-%s.yml)</td></tr>
          <tr><th>Chromatic Hex / Active-Low</th><td>%s / %s</td></tr>
          <tr><th>Uncorrected Disorder</th><td>H_raw = %.3f bits | Cp = %.2f | sigma = %.2f (%s)</td></tr>
          <tr><th>Priory Quarantine Cell</th><td>%s</td></tr>
          <tr><th>Sigma -1n &amp; 0n Beta</th><td>Corrected Cp = %.2f (%s) &rarr; H_resolved = %.3f bits</td></tr>
        </table>
      </div>
    </div>
  </main>

  <script>
    const ZALIM_INDEX = %d;
    const STROKE = "%s";
    const canvas = document.getElementById('zalimCanvas');
    const ctx = canvas.getContext('2d');
    let yaw = 0.45, pitch = 0.35, zoom = 1.0, dragging = false, lx = 0, ly = 0;

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
      pitch = Math.max(-0.1, Math.min(1.2, pitch + (e.clientY - ly) * 0.006));
      lx = e.clientX; ly = e.clientY;
    });

    function proj(x, y, z, cx, cy, sc) {
      const cyw = Math.cos(yaw), syw = Math.sin(yaw);
      const x1 = x * cyw - z * syw, z1 = x * syw + z * cyw;
      const cp = Math.cos(pitch), sp = Math.sin(pitch);
      const y2 = y * cp - z1 * sp, z2 = y * sp + z1 * cp;
      const dist = 560 + z2;
      if (dist < 40) return null;
      const p = (450 / dist) * sc;
      return { sx: cx + x1 * p, sy: cy - y2 * p };
    }

    function line3D(a, b, cx, cy, sc, col, w = 1.2, al = 0.85) {
      const p1 = proj(a[0],a[1],a[2],cx,cy,sc), p2 = proj(b[0],b[1],b[2],cx,cy,sc);
      if (!p1 || !p2) return;
      ctx.save(); ctx.globalAlpha = al; ctx.strokeStyle = col; ctx.lineWidth = w;
      ctx.beginPath(); ctx.moveTo(p1.sx, p1.sy); ctx.lineTo(p2.sx, p2.sy); ctx.stroke(); ctx.restore();
    }

    function loop(now) {
      const t = now * 0.001;
      if (!dragging) yaw += 0.0032;
      const w = canvas.width / window.devicePixelRatio, h = canvas.height / window.devicePixelRatio;
      ctx.clearRect(0, 0, w, h);
      const cx = w * 0.5, cy = h * 0.56;

      // Outer Octagonal Priory Sigma -1n Quarantine Cage (Emerald/Gold Mizan Containment)
      const cageR = 175;
      for (let i = 0; i < 8; i++) {
        const a1 = (i/8)*Math.PI*2, a2 = ((i+1)/8)*Math.PI*2;
        const x1 = Math.cos(a1)*cageR, z1 = Math.sin(a1)*cageR;
        const x2 = Math.cos(a2)*cageR, z2 = Math.sin(a2)*cageR;
        line3D([x1,-90,z1], [x2,-90,z2], cx, cy, zoom, "#34D399", 1.5, 0.75);
        line3D([x1,110,z1], [x2,110,z2], cx, cy, zoom, "#34D399", 1.5, 0.75);
        line3D([x1,-90,z1], [x1,110,z1], cx, cy, zoom, "#34D399", 1.1, 0.5);
      }

      // Inner Fractured Wrongdoer Precipice (Shafa Jurufin Harin) Quarantined Inside
      const shards = 5 + ZALIM_INDEX;
      for (let s = 0; s < shards; s++) {
        const a1 = (s/shards)*Math.PI*2 + t*0.4;
        const a2 = ((s+1)/shards)*Math.PI*2 - t*0.3;
        const r1 = 65 + (s %% 2)*28;
        line3D([Math.cos(a1)*r1, -55, Math.sin(a1)*r1],
               [Math.cos(a2)*(r1*0.6), 75, Math.sin(a2)*(r1*0.6)], cx, cy, zoom, STROKE, 1.9, 0.9);
        line3D([0, -70, 0], [Math.cos(a1)*r1, -55, Math.sin(a1)*r1], cx, cy, zoom, STROKE, 1.2, 0.65);
      }

      // Central 0n Beta Grounding Lance pinning the fracture
      line3D([0, -115, 0], [0, 135, 0], cx, cy, zoom, "#FDE68A", 2.4, 0.95);
      requestAnimationFrame(loop);
    }
    requestAnimationFrame(loop);
  </script>
</body>
</html>
""".formatted(
                p.zalimIndex(), escape(p.profileId()), escape(p.warlockName()),
                p.hexCode(), strokeHex, activeLowHex,
                nav.toString(),
                p.zalimIndex(), p.globalOrderIndex(), escape(p.profileId()),
                p.uncorrectedSpcState().code(), p.uncorrectedCp(), p.rawEntropyBits(),
                p.correctedSpcState().code(), p.correctedCp(),
                escape(p.warlockName()), escape(p.englishPrincipleTitle()),
                escape(p.arabicTermAndRoot()),
                escape(p.arabicArchetypeTitle()), escape(p.category().displayTitle()),
                escape(p.warlockName()), escape(p.profileId()),
                escape(p.prioryContainmentCell()),
                escape(p.challengeToAbrahamicHegemony()),
                escape(p.disorderAndImmodestyMechanism()),
                escape(p.quranicAnchor()),
                escape(p.abrahamicRefutationAndPrioryQuarantine()),
                escape(p.profileId()), escape(p.profileId()),
                p.hexCode(), activeLowHex,
                p.rawEntropyBits(), p.uncorrectedCp(), p.uncorrectedSigma(), p.uncorrectedSpcState().code(),
                escape(p.prioryContainmentCell()),
                p.correctedCp(), p.correctedSpcState().code(), p.resolvedEntropyBits(),
                p.zalimIndex(), strokeHex
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
