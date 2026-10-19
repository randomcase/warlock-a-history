package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.WarlockColorOrder;
import com.sovereign.warlock.domain.WarlockIslamChronicle;
import com.sovereign.warlock.domain.WarlockRealm;

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
 *  1) 7 Separate Sovereign Realm HTML Portals (realm-1-white.html .. realm-7-emerald.html),
 *     each with bespoke 3D perspective geometry for that Order's specific Realm, Castle, Tower, and Keep.
 *  2) The Master 3D Sanctum Synthesis Portal (warlock-3d-sanctum.html).
 */
public final class Warlock3dSanctumGenerator {

    public List<WarlockHtmlPortalService.GeneratedHtmlArtifact> generateAllRealmPortals(
            Path outputDir,
            List<WarlockCovenantEngine.InvocationTelemetry> telemetries) {
        try {
            Files.createDirectories(outputDir);
            List<WarlockHtmlPortalService.GeneratedHtmlArtifact> list = new ArrayList<>();

            for (WarlockCovenantEngine.InvocationTelemetry t : telemetries) {
                WarlockRealm realm = WarlockRealm.forOrderIndex(t.orderIndex());
                String realmHtml = renderIndividualRealmHtml(t, realm);
                Path realmPath = outputDir.resolve(realm.realmHtmlFile());
                Files.writeString(realmPath, realmHtml, StandardCharsets.UTF_8);
                list.add(new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                        realm.realmHtmlFile(),
                        realmPath,
                        Files.size(realmPath),
                        sha256(realmHtml),
                        "Realm #" + t.orderIndex() + ": " + realm.realmNameHebrew() + " / " + realm.realmNameArabic()
                                + " (" + realm.englishTitle() + ")"
                ));
            }

            list.add(generate3dSanctumHtml(outputDir));
            return List.copyOf(list);
        } catch (IOException e) {
            throw new IllegalStateException("Failed generating Realm HTML portals", e);
        }
    }

    public WarlockHtmlPortalService.GeneratedHtmlArtifact generate3dSanctumHtml(Path outputDir) {
        try {
            Files.createDirectories(outputDir);
            String html = build3dRenderHtml();
            Path target = outputDir.resolve("warlock-3d-sanctum.html");
            Files.writeString(target, html, StandardCharsets.UTF_8);
            return new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                    "warlock-3d-sanctum.html",
                    target,
                    Files.size(target),
                    sha256(html),
                    "Interactive 3D Render: Warlock in His Realm, Castle, Tower & Keep (7 Color Orders)"
            );
        } catch (IOException e) {
            throw new IllegalStateException("Failed to generate 3D sanctum HTML", e);
        }
    }

    private String renderIndividualRealmHtml(
            WarlockCovenantEngine.InvocationTelemetry t,
            WarlockRealm r) {
        String activeLowHex = String.format("#%06X", t.activeLow24());
        String strokeHex = (t.orderIndex() == 2) ? "#A78BFA"
                : (t.orderIndex() == 3 ? "#38BDF8"
                : (t.orderIndex() == 5 ? "#EF4444"
                : (t.orderIndex() == 7 ? "#10B981" : t.hexCode())));
        WarlockIslamChronicle ch = WarlockIslamChronicle.forOrderIndex(t.orderIndex());

        StringBuilder realmNav = new StringBuilder();
        for (WarlockColorOrder co : WarlockColorOrder.orderedBySevenColors()) {
            WarlockRealm rm = WarlockRealm.forOrderIndex(co.orderIndex());
            String cls = (co.orderIndex() == t.orderIndex()) ? "nav-pill active" : "nav-pill";
            realmNav.append(String.format(
                    "<a class=\"%s\" href=\"%s\"><span class=\"dot\" style=\"background:%s\"></span>Realm #%d: %s</a>%n",
                    cls, rm.realmHtmlFile(), co.hexCode(), co.orderIndex(), escape(rm.realmNameHebrew())
            ));
        }
        String planeFile = "plane-" + t.profileId().substring("warlock-".length()) + ".html";
        realmNav.append(String.format(
                "<a class=\"nav-pill\" href=\"%s\" style=\"border-color:#A5F3FC;color:#A5F3FC;\">Inhabited Plane P%d</a>",
                planeFile, t.orderIndex()
        ));
        realmNav.append("<a class=\"nav-pill\" href=\"priory-negentropy-order.html\" style=\"border-color:#34D399;color:#34D399;\">Negentropic Priory</a>");
        realmNav.append(String.format(
                "<a class=\"nav-pill\" href=\"%s\" style=\"border-color:#D4AF37;color:#FDE68A;\">Order #%d Dossier</a>",
                ch.htmlFileName(), t.orderIndex()
        ));
        realmNav.append("<a class=\"nav-pill\" href=\"warlock-3d-sanctum.html\">Master 3D Sanctum</a>");
        realmNav.append("<a class=\"nav-pill\" href=\"dependencies-report.html\" style=\"margin-left:auto;color:#38BDF8;\">Dependencies</a>");

        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Realm #%d: %s (%s) | %s</title>
  <style>
    :root {
      --realm-hex: %s;
      --realm-stroke: %s;
      --active-low: %s;
      --bg-deep: #07090F;
      --bg-card: #111622;
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
      background: rgba(9, 12, 19, 0.95);
      border-bottom: 2px solid var(--realm-stroke);
      padding: 0.9rem 1.5rem;
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
      border-color: var(--realm-stroke);
      background: rgba(255,255,255,0.08);
    }
    .dot {
      width: 9px;
      height: 9px;
      border-radius: 50%%;
      display: inline-block;
      border: 1px solid rgba(255,255,255,0.5);
    }
    main {
      max-width: 1360px;
      margin: 1.8rem auto;
      padding: 0 1.5rem;
    }
    .realm-hero {
      background: linear-gradient(135deg, #111622 0%%, #192236 100%%);
      border: 1px solid var(--border);
      border-left: 6px solid var(--realm-stroke);
      border-radius: 14px;
      padding: 1.6rem 2rem;
      margin-bottom: 1.5rem;
    }
    .badge-row {
      display: flex;
      flex-wrap: wrap;
      gap: 0.5rem;
      margin-bottom: 0.7rem;
    }
    .badge {
      font-family: Consolas, monospace;
      font-size: 0.76rem;
      padding: 0.2rem 0.6rem;
      border-radius: 5px;
      background: rgba(255,255,255,0.07);
      border: 1px solid var(--border);
    }
    h1 { font-size: 1.95rem; margin-bottom: 0.25rem; }
    .sub { color: var(--text-muted); font-size: 0.98rem; }
    .viewport-card {
      background: #05070B;
      border: 1px solid var(--border);
      border-radius: 14px;
      overflow: hidden;
      margin-bottom: 1.75rem;
    }
    .vp-toolbar {
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
      align-items: center;
      padding: 0.75rem 1.2rem;
      background: #0D121C;
      border-bottom: 1px solid var(--border);
      gap: 0.5rem;
    }
    .mode-btn {
      padding: 0.4rem 0.85rem;
      border-radius: 7px;
      background: #151C2C;
      color: #CBD5E1;
      border: 1px solid var(--border);
      font-size: 0.8rem;
      font-weight: 600;
      cursor: pointer;
    }
    .mode-btn.active, .mode-btn:hover {
      border-color: var(--realm-stroke);
      color: #FFF;
      background: rgba(255,255,255,0.1);
    }
    .canvas-wrap {
      position: relative;
      height: 460px;
      width: 100%%;
    }
    canvas { width: 100%%; height: 100%%; display: block; cursor: grab; }
    canvas:active { cursor: grabbing; }
    .hud-box {
      position: absolute;
      top: 12px;
      left: 14px;
      background: rgba(7, 9, 15, 0.82);
      border: 1px solid var(--border);
      border-left: 3px solid var(--realm-stroke);
      padding: 0.65rem 0.95rem;
      border-radius: 8px;
      max-width: 420px;
      pointer-events: none;
    }
    .grid-2 {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(380px, 1fr));
      gap: 1.25rem;
      margin-bottom: 1.5rem;
    }
    .grid-3 {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(320px, 1fr));
      gap: 1.25rem;
    }
    .card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-radius: 12px;
      padding: 1.4rem;
    }
    .card h2 {
      font-size: 1.02rem;
      text-transform: uppercase;
      letter-spacing: 0.05em;
      color: var(--realm-stroke);
      margin-bottom: 0.75rem;
      border-bottom: 1px solid var(--border);
      padding-bottom: 0.45rem;
    }
    .card p { font-size: 0.94rem; color: #CBD5E1; }
  </style>
</head>
<body>
  <header>
    <nav class="nav-bar">
      %s
    </nav>
  </header>
  <main>
    <section class="realm-hero">
      <div class="badge-row">
        <span class="badge">SOVEREIGN REALM #%d OF 7</span>
        <span class="badge">%s</span>
        <span class="badge">RULER: %s (%s)</span>
        <span class="badge">HEX: %s | ACTIVE-LOW: %s</span>
        <span class="badge">GEOMETRY: %s</span>
      </div>
      <h1>%s / %s — %s</h1>
      <div class="sub">
        <strong>Cosmological Stratum:</strong> <code>%s</code> &nbsp;|&nbsp;
        <strong>Zero-Iron Construction Law:</strong> %s
      </div>
    </section>

    <section class="viewport-card">
      <div class="vp-toolbar">
        <div style="display:flex;gap:0.4rem;flex-wrap:wrap;">
          <button class="mode-btn active" id="m-REALM" onclick="setMode('REALM')">1. Sovereign Realm (%s)</button>
          <button class="mode-btn" id="m-CASTLE" onclick="setMode('CASTLE')">2. Castle (%s)</button>
          <button class="mode-btn" id="m-TOWER" onclick="setMode('TOWER')">3. Tower (%s)</button>
          <button class="mode-btn" id="m-KEEP" onclick="setMode('KEEP')">4. Keep (%s)</button>
        </div>
        <div style="font-family:Consolas,monospace;font-size:0.78rem;color:#94A3B8;">
          Drag to Orbit 3D | Scroll to Zoom | Order #%d Bespoke Geometry
        </div>
      </div>
      <div class="canvas-wrap">
        <canvas id="realmCanvas"></canvas>
        <div class="hud-box">
          <div style="font-family:Consolas,monospace;font-size:0.74rem;color:#FDE68A;" id="hud-mode">REALM TOPOGRAPHY // ORDER #%d</div>
          <div style="font-size:1.02rem;font-weight:700;margin:0.15rem 0;" id="hud-name">%s — %s</div>
          <div style="font-size:0.8rem;color:#CBD5E1;" id="hud-detail">%s</div>
        </div>
      </div>
    </section>

    <div class="grid-2">
      <div class="card">
        <h2>Horizon &amp; Firmament Atmosphere</h2>
        <p>%s</p>
      </div>
      <div class="card">
        <h2>Ground Topography &amp; Spatial Matrix</h2>
        <p>%s</p>
      </div>
    </div>

    <div class="grid-3">
      <div class="card">
        <h2>II. His Castle: %s</h2>
        <p>%s</p>
      </div>
      <div class="card">
        <h2>III. His Tower: %s</h2>
        <p>%s</p>
      </div>
      <div class="card">
        <h2>IV. His Keep: %s</h2>
        <p>%s</p>
      </div>
    </div>
  </main>

  <script>
    const ORDER_INDEX = %d;
    const STROKE_COLOR = "%s";
    const HEX_COLOR = "%s";
    const MODE_INFO = {
      REALM: ["REALM TOPOGRAPHY // ORDER #" + ORDER_INDEX, "%s — %s", "%s"],
      CASTLE: ["CITADEL ARCHITECTURE // ZERO IRON LAW", "%s", "%s"],
      TOWER: ["OBSERVATORY SPIRE // HEIKHALOT AXIS", "%s", "%s"],
      KEEP: ["INNERMOST SANCTUM VAULT // FOUNDATION SEAL", "%s", "%s"]
    };

    let mode = 'REALM';
    let yaw = 0.48, pitch = 0.35, zoom = 1.0;
    let dragging = false, lx = 0, ly = 0;

    const canvas = document.getElementById('realmCanvas');
    const ctx = canvas.getContext('2d');

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
    canvas.addEventListener('wheel', e => {
      e.preventDefault();
      zoom = Math.max(0.55, Math.min(2.0, zoom - e.deltaY * 0.001));
    }, { passive: false });

    function setMode(m) {
      mode = m;
      ['REALM','CASTLE','TOWER','KEEP'].forEach(k => {
        document.getElementById('m-' + k).classList.toggle('active', k === m);
      });
      document.getElementById('hud-mode').textContent = MODE_INFO[m][0];
      document.getElementById('hud-name').textContent = MODE_INFO[m][1];
      document.getElementById('hud-detail').textContent = MODE_INFO[m][2];
    }

    function proj(x, y, z, cx, cy, sc) {
      const cyw = Math.cos(yaw), syw = Math.sin(yaw);
      const x1 = x * cyw - z * syw, z1 = x * syw + z * cyw;
      const cp = Math.cos(pitch), sp = Math.sin(pitch);
      const y2 = y * cp - z1 * sp, z2 = y * sp + z1 * cp;
      const dist = 600 + z2;
      if (dist < 40) return null;
      const p = (500 / dist) * sc;
      return { sx: cx + x1 * p, sy: cy - y2 * p, s: p };
    }

    function line3D(a, b, cx, cy, sc, col, w = 1.3, al = 0.85) {
      const p1 = proj(a[0],a[1],a[2],cx,cy,sc), p2 = proj(b[0],b[1],b[2],cx,cy,sc);
      if (!p1 || !p2) return;
      ctx.save(); ctx.globalAlpha = al; ctx.strokeStyle = col; ctx.lineWidth = w;
      ctx.beginPath(); ctx.moveTo(p1.sx, p1.sy); ctx.lineTo(p2.sx, p2.sy); ctx.stroke(); ctx.restore();
    }

    function poly3D(pts, cx, cy, sc, fill, stroke, w = 1.15, al = 0.9) {
      const pr = [];
      for (const pt of pts) { const p = proj(pt[0],pt[1],pt[2],cx,cy,sc); if (!p) return; pr.push(p); }
      ctx.save(); ctx.globalAlpha = al; ctx.beginPath();
      ctx.moveTo(pr[0].sx, pr[0].sy);
      for (let i = 1; i < pr.length; i++) ctx.lineTo(pr[i].sx, pr[i].sy);
      ctx.closePath();
      if (fill) { ctx.fillStyle = fill; ctx.fill(); }
      if (stroke) { ctx.strokeStyle = stroke; ctx.lineWidth = w; ctx.stroke(); }
      ctx.restore();
    }

    function box3D(bx, by, bz, wx, wy, wz, cx, cy, sc, fill, stroke) {
      const x0 = bx-wx/2, x1 = bx+wx/2, y0 = by, y1 = by+wy, z0 = bz-wz/2, z1 = bz+wz/2;
      const faces = [
        [[x0,y0,z1],[x1,y0,z1],[x1,y1,z1],[x0,y1,z1]],
        [[x0,y0,z0],[x1,y0,z0],[x1,y1,z0],[x0,y1,z0]],
        [[x0,y0,z0],[x0,y0,z1],[x0,y1,z1],[x0,y1,z0]],
        [[x1,y0,z0],[x1,y0,z1],[x1,y1,z1],[x1,y1,z0]],
        [[x0,y1,z0],[x1,y1,z0],[x1,y1,z1],[x0,y1,z1]]
      ];
      for (const f of faces) poly3D(f, cx, cy, sc, fill, stroke, 1.1, 0.88);
    }

    function hexSeal(y, rad, cx, cy, sc, col, rot) {
      for (let t = 0; t < 2; t++) {
        const pts = [];
        for (let i = 0; i < 3; i++) {
          const a = rot + (t * Math.PI / 3) + (i * 2 * Math.PI / 3);
          pts.push([Math.cos(a)*rad, y, Math.sin(a)*rad]);
        }
        poly3D(pts, cx, cy, sc, null, col, 1.6, 0.88);
      }
    }

    function drawWarlock(wx, wy, wz, cx, cy, sc, t) {
      const by = wy + Math.sin(t * 2.0) * 4;
      hexSeal(wy + 1, 48, cx, cy, sc, STROKE_COLOR, t * 0.5);
      const wings = [[54, 66, 30], [40, 78, 12], [26, 52, -20]];
      for (let p = 0; p < 3; p++) {
        const [yo, sp, h] = wings[p];
        for (const s of [-1, 1]) {
          poly3D([
            [wx+s*5, by+yo, wz],
            [wx+s*sp*0.55, by+yo+h*0.6, wz-16],
            [wx+s*sp, by+yo+h, wz-22],
            [wx+s*sp*0.45, by+yo-10, wz-8]
          ], cx, cy, sc, "rgba(212,175,55,0.18)", STROKE_COLOR, 1.35, 0.9);
        }
      }
      box3D(wx, by, wz, 24, 54, 20, cx, cy, sc, "rgba(15,28,55,0.92)", STROKE_COLOR);
      box3D(wx, by + 34, wz + 11, 14, 14, 2, cx, cy, sc, "rgba(212,175,55,0.9)", "#FFF");
      line3D([wx+20, by-4, wz+8], [wx+20, by+84, wz+8], cx, cy, sc, "#FDE68A", 2.2, 0.95);
    }

    // Bespoke 3D Realm Geometry per Order (1..7)
    function drawBespokeRealm(cx, cy, sc, t) {
      if (ORDER_INDEX === 1) {
        // Order 1: Spherical Tzimtzum Void & Vertical Ray of Kav + 12 Alabaster Stelae
        line3D([0, -180, 0], [0, 220, 0], cx, cy, sc, "#FFF", 3.2, 0.95);
        for (let lat = -2; lat <= 2; lat++) {
          const r = Math.cos(lat * 0.5) * 140;
          const y = Math.sin(lat * 0.5) * 140 + 20;
          for (let i = 0; i < 24; i++) {
            const a1 = (i/24)*Math.PI*2 + t*0.3, a2 = ((i+1)/24)*Math.PI*2 + t*0.3;
            line3D([Math.cos(a1)*r, y, Math.sin(a1)*r], [Math.cos(a2)*r, y, Math.sin(a2)*r], cx, cy, sc, "#F8F5E6", 1.2, 0.55);
          }
        }
        for (let s = 0; s < 12; s++) {
          const a = (s/12)*Math.PI*2;
          box3D(Math.cos(a)*195, -45, Math.sin(a)*195, 16, 110, 16, cx, cy, sc, "rgba(248,245,230,0.22)", "#F8F5E6");
        }
      } else if (ORDER_INDEX === 2) {
        // Order 2: 231 Parabolic Consonantal Gates & Cloven Obsidian Obelisk over Awfaq Grid
        for (let i = -220; i <= 220; i += 44) {
          line3D([i, -45, -220], [i, -45, 220], cx, cy, sc, "rgba(167,139,250,0.3)", 1);
          line3D([-220, -45, i], [220, -45, i], cx, cy, sc, "rgba(167,139,250,0.3)", 1);
        }
        for (let g = 0; g < 11; g++) {
          const a = (g/11)*Math.PI;
          for (let seg = 0; seg < 16; seg++) {
            const t1 = (seg/16)*Math.PI, t2 = ((seg+1)/16)*Math.PI;
            const r1 = Math.cos(t1)*195, y1 = -45 + Math.sin(t1)*175;
            const r2 = Math.cos(t2)*195, y2 = -45 + Math.sin(t2)*175;
            line3D([Math.cos(a)*r1, y1, Math.sin(a)*r1], [Math.cos(a)*r2, y2, Math.sin(a)*r2], cx, cy, sc, "#A78BFA", 1.4, 0.7);
          }
        }
      } else if (ORDER_INDEX === 3) {
        // Order 3: 7 Concentric Sapphire Amphitheaters & Interlocking Ophanim Eye-Wheels
        for (let ring = 1; ring <= 7; ring++) {
          const r = ring * 30;
          const y = -45 - ring * 6;
          for (let i = 0; i < 20; i++) {
            const a1 = (i/20)*Math.PI*2, a2 = ((i+1)/20)*Math.PI*2;
            line3D([Math.cos(a1)*r, y, Math.sin(a1)*r], [Math.cos(a2)*r, y, Math.sin(a2)*r], cx, cy, sc, "#38BDF8", 1.3, 0.75);
          }
        }
        for (let w = 0; w < 3; w++) {
          const r = 135 + w * 28;
          for (let i = 0; i < 24; i++) {
            const a1 = (i/24)*Math.PI*2 + t*(w%%2? -0.6:0.6), a2 = ((i+1)/24)*Math.PI*2 + t*(w%%2? -0.6:0.6);
            line3D([Math.cos(a1)*r, 35+Math.sin(a1)*r*0.45, Math.sin(a1)*r],
                   [Math.cos(a2)*r, 35+Math.sin(a2)*r*0.45, Math.sin(a2)*r], cx, cy, sc, w===1 ? "#FDE68A" : "#38BDF8", 1.6, 0.8);
          }
        }
      } else if (ORDER_INDEX === 4) {
        // Order 4: 3 Concentric Rings of 24 Electrum Gold Pillars (72 Names of Yawm Al-Alast)
        for (let ring = 0; ring < 3; ring++) {
          const r = 105 + ring * 48;
          const h = 95 - ring * 18;
          for (let p = 0; p < 24; p++) {
            const a = (p/24)*Math.PI*2 + ring * 0.1;
            const px = Math.cos(a)*r, pz = Math.sin(a)*r;
            line3D([px, -45, pz], [px, -45 + h, pz], cx, cy, sc, "#D4AF37", 2.0, 0.82);
          }
        }
        hexSeal(85, 145, cx, cy, sc, "#FDE68A", t * 0.25);
      } else if (ORDER_INDEX === 5) {
        // Order 5: Crimson Altar Caldera & Barred Firmament of Piercing Shihab Meteors
        for (let i = 0; i < 6; i++) {
          const a = (i/6)*Math.PI*2;
          box3D(Math.cos(a)*175, -45, Math.sin(a)*175, 28, 125, 28, cx, cy, sc, "rgba(139,0,0,0.45)", "#EF4444");
          line3D([Math.cos(a)*175, 80, Math.sin(a)*175], [0, 155, 0], cx, cy, sc, "#F87171", 1.6, 0.85);
        }
        for (let m = 0; m < 12; m++) {
          const a = (m/12)*Math.PI*2 - t * 1.1;
          const r1 = 210, r2 = 155;
          line3D([Math.cos(a)*r1, 130, Math.sin(a)*r1], [Math.cos(a+0.25)*r2, 75, Math.sin(a+0.25)*r2], cx, cy, sc, "#FCA5A5", 2.2, 0.9);
        }
      } else if (ORDER_INDEX === 6) {
        // Order 6: The Brazen Sea on 12 Oxen Base & 72 Sunken Brass Containment Silos
        hexSeal(-45, 200, cx, cy, sc, "#D97706", -t * 0.2);
        for (let ring = 0; ring < 3; ring++) {
          const r = 95 + ring * 45;
          for (let s = 0; s < 24; s++) {
            const a = (s/24)*Math.PI*2;
            box3D(Math.cos(a)*r, -45, Math.sin(a)*r, 8, 18, 8, cx, cy, sc, "rgba(184,115,51,0.88)", "#FDE68A");
          }
        }
      } else {
        // Order 7: Confluence of the Two Seas (Majma' al-Bahrayn) & Spiral Emerald Lighthouse
        for (let x = -220; x <= 220; x += 28) {
          const wave1 = Math.sin(x * 0.04 + t * 2) * 14;
          const wave2 = Math.cos(x * 0.04 - t * 2) * 14;
          line3D([x, -45 + wave1, -180], [x, -45, -35], cx, cy, sc, "#10B981", 1.3, 0.65);
          line3D([x, -45 + wave2, 180], [x, -45, 35], cx, cy, sc, "#38BDF8", 1.3, 0.65);
        }
        box3D(0, -45, 0, 440, 8, 65, cx, cy, sc, "rgba(0,107,84,0.65)", "#10B981");
        for (let sp = 0; sp < 40; sp++) {
          const a1 = sp * 0.35 + t, a2 = (sp + 1) * 0.35 + t;
          const r1 = 85 - sp * 1.6, r2 = 85 - (sp + 1) * 1.6;
          line3D([Math.cos(a1)*r1, -35 + sp*4.2, Math.sin(a1)*r1],
                 [Math.cos(a2)*r2, -35 + (sp+1)*4.2, Math.sin(a2)*r2], cx, cy, sc, "#6EE7B7", 1.8, 0.85);
        }
      }
      drawWarlock(0, -35, 0, cx, cy, sc, t);
    }

    function drawCastle(cx, cy, sc, t) {
      hexSeal(-42, 130, cx, cy, sc, "#D4AF37", -t * 0.2);
      const sp = 165;
      box3D(0, -44, -sp, 300, 62, 20, cx, cy, sc, "rgba(18,22,34,0.92)", STROKE_COLOR);
      box3D(-sp, -44, 0, 20, 62, 300, cx, cy, sc, "rgba(18,22,34,0.92)", STROKE_COLOR);
      box3D(sp, -44, 0, 20, 62, 300, cx, cy, sc, "rgba(18,22,34,0.92)", STROKE_COLOR);
      for (const [bx, bz] of [[-sp,-sp],[sp,-sp],[sp,sp],[-sp,sp]]) {
        box3D(bx, -44, bz, 46, 108, 46, cx, cy, sc, "rgba(24,28,42,0.95)", "#D4AF37");
      }
      drawWarlock(0, -24, -15, cx, cy, sc, t);
    }

    function drawTower(cx, cy, sc, t) {
      for (let tr = 0; tr < 7; tr++) {
        const yb = -115 + tr * 25, r = 135 - tr * 14;
        box3D(0, yb, 0, r * 1.4, 23, r * 1.4, cx, cy, sc, "rgba(17,24,39,0.92)", tr %% 2 === 0 ? STROKE_COLOR : "#D4AF37");
      }
      drawWarlock(0, 65, 0, cx, cy, sc, t);
    }

    function drawKeep(cx, cy, sc, t) {
      hexSeal(-46, 155, cx, cy, sc, STROKE_COLOR, t * 0.2);
      for (let i = 0; i < 8; i++) {
        const a = (i/8)*Math.PI*2;
        box3D(Math.cos(a)*165, -46, Math.sin(a)*165, 18, 170, 18, cx, cy, sc, "rgba(22,26,38,0.92)", "#B87333");
        line3D([Math.cos(a)*165, 124, Math.sin(a)*165], [0, 165, 0], cx, cy, sc, STROKE_COLOR, 1.4, 0.7);
      }
      box3D(0, -46, 0, 62, 20, 62, cx, cy, sc, "rgba(15,44,89,0.92)", STROKE_COLOR);
      drawWarlock(0, -24, 0, cx, cy, sc, t);
    }

    function animate(now) {
      const t = now * 0.001;
      if (!dragging) yaw += 0.003;
      const w = canvas.width / window.devicePixelRatio, h = canvas.height / window.devicePixelRatio;
      ctx.clearRect(0, 0, w, h);

      if (mode === 'REALM') drawBespokeRealm(w*0.5, h*0.56, zoom, t);
      else if (mode === 'CASTLE') drawCastle(w*0.5, h*0.56, zoom, t);
      else if (mode === 'TOWER') drawTower(w*0.5, h*0.56, zoom, t);
      else drawKeep(w*0.5, h*0.58, zoom, t);

      requestAnimationFrame(animate);
    }
    requestAnimationFrame(animate);
  </script>
</body>
</html>
""".formatted(
                t.orderIndex(), escape(r.realmNameHebrew()), escape(r.realmNameArabic()), escape(r.englishTitle()),
                t.hexCode(), strokeHex, activeLowHex,
                realmNav.toString(),
                t.orderIndex(), escape(r.realmCode()), escape(t.warlockName()), escape(t.profileId()),
                t.hexCode(), activeLowHex, escape(r.geometricSignature3D()),
                escape(r.realmNameHebrew()), escape(r.realmNameArabic()), escape(r.englishTitle()),
                escape(r.cosmologicalStratum()), escape(r.zeroIronMaterials()),
                escape(r.realmNameHebrew()), escape(r.castleName()), escape(r.towerName()), escape(r.keepName()),
                t.orderIndex(),
                t.orderIndex(),
                escape(r.realmNameHebrew()), escape(r.englishTitle()),
                escape(r.groundTopography()),
                escape(r.horizonAtmosphere()),
                escape(r.groundTopography()),
                escape(r.castleName()), escape(r.castleArchitecture()),
                escape(r.towerName()), escape(r.towerArchitecture()),
                escape(r.keepName()), escape(r.keepArchitecture()),
                t.orderIndex(),
                strokeHex,
                t.hexCode(),
                escape(r.realmNameHebrew()), escape(r.englishTitle()), escape(r.groundTopography()),
                escape(r.castleName()), escape(r.castleArchitecture()),
                escape(r.towerName()), escape(r.towerArchitecture()),
                escape(r.keepName()), escape(r.keepArchitecture())
        );
    }

    public static String build3dRenderHtml() {
        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>3D Render: The Abrahamic Warlock — 7 Sovereign Realms, Castles, Towers &amp; Keeps</title>
  <script src="https://www.gstatic.com/antigravity/web/dev/tailwindcss.min.js"></script>
  <style>
    * { box-sizing: border-box; user-select: none; }
    body {
      margin: 0;
      background: #07090E;
      color: #ECEFF4;
      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
      overflow-x: hidden;
    }
    .top-nav {
      display: flex;
      flex-wrap: wrap;
      gap: 0.4rem;
      align-items: center;
      padding: 0.75rem 1.25rem;
      background: rgba(11, 14, 22, 0.95);
      border-bottom: 1px solid rgba(255,255,255,0.12);
    }
    .nav-link {
      font-size: 0.75rem;
      font-weight: 600;
      padding: 0.3rem 0.65rem;
      border-radius: 999px;
      background: #131824;
      color: #9AA5B8;
      border: 1px solid rgba(255,255,255,0.1);
      text-decoration: none;
      display: inline-flex;
      align-items: center;
      gap: 0.35rem;
    }
    .nav-link:hover, .nav-link.active {
      color: #FFF;
      border-color: #D4AF37;
      background: rgba(212, 175, 55, 0.14);
    }
    .dot {
      width: 9px;
      height: 9px;
      border-radius: 50%;
      display: inline-block;
      border: 1px solid rgba(255,255,255,0.5);
    }
    .control-btn {
      padding: 0.45rem 0.85rem;
      border-radius: 8px;
      font-size: 0.8rem;
      font-weight: 600;
      background: #141A29;
      color: #CBD5E1;
      border: 1px solid rgba(255,255,255,0.12);
      cursor: pointer;
    }
    .control-btn:hover { border-color: #D4AF37; color: #FFF; }
    .control-btn.active {
      background: linear-gradient(135deg, rgba(212,175,55,0.28), rgba(15,44,89,0.55));
      border-color: #D4AF37;
      color: #FFF;
    }
    #canvas-container {
      position: relative;
      width: 100%;
      height: 540px;
      background: #05070B;
      border-bottom: 1px solid rgba(255,255,255,0.12);
      overflow: hidden;
    }
    canvas { display: block; width: 100%; height: 100%; cursor: grab; }
    canvas:active { cursor: grabbing; }
    .hud-overlay {
      position: absolute;
      top: 14px;
      left: 16px;
      background: rgba(9, 12, 18, 0.86);
      border: 1px solid rgba(255,255,255,0.14);
      border-left: 4px solid var(--hud-accent, #D4AF37);
      border-radius: 10px;
      padding: 0.85rem 1.1rem;
      max-width: 420px;
      pointer-events: none;
    }
    .hud-right {
      position: absolute;
      top: 14px;
      right: 16px;
      background: rgba(9, 12, 18, 0.86);
      border: 1px solid rgba(255,255,255,0.14);
      border-radius: 10px;
      padding: 0.75rem 1rem;
      font-family: 'Consolas', monospace;
      font-size: 0.76rem;
      color: #A5F3FC;
      pointer-events: none;
    }
  </style>
</head>
<body>
  <nav class="top-nav">
    <a class="nav-link" href="realm-1-white.html"><span class="dot" style="background:#F8F5E6"></span>Realm #1</a>
    <a class="nav-link" href="realm-2-black.html"><span class="dot" style="background:#141416"></span>Realm #2</a>
    <a class="nav-link" href="realm-3-sapphire.html"><span class="dot" style="background:#0F2C59"></span>Realm #3</a>
    <a class="nav-link" href="realm-4-gold.html"><span class="dot" style="background:#D4AF37"></span>Realm #4</a>
    <a class="nav-link" href="realm-5-crimson.html"><span class="dot" style="background:#8B0000"></span>Realm #5</a>
    <a class="nav-link" href="realm-6-brass.html"><span class="dot" style="background:#B87333"></span>Realm #6</a>
    <a class="nav-link" href="realm-7-emerald.html"><span class="dot" style="background:#006B54"></span>Realm #7</a>
    <a class="nav-link active" href="warlock-3d-sanctum.html">Master 3D Sanctum</a>
    <a class="nav-link" href="dependencies-report.html" style="margin-left:auto;color:#38BDF8;border-color:#38BDF8;">Dependencies Report</a>
  </nav>

  <div style="display:flex;flex-wrap:wrap;gap:0.75rem;justify-content:space-between;align-items:center;padding:0.85rem 1.25rem;background:#0D111A;border-bottom:1px solid rgba(255,255,255,0.1);">
    <div style="display:flex;flex-wrap:wrap;gap:0.4rem;align-items:center;">
      <span style="font-size:0.76rem;text-transform:uppercase;letter-spacing:0.06em;color:#94A3B8;margin-right:0.3rem;font-weight:700;">3D Sanctum Domain:</span>
      <button class="control-btn active" data-scene="REALM" onclick="setScene('REALM')">1. In His Realm</button>
      <button class="control-btn" data-scene="CASTLE" onclick="setScene('CASTLE')">2. In His Castle</button>
      <button class="control-btn" data-scene="TOWER" onclick="setScene('TOWER')">3. In His Tower</button>
      <button class="control-btn" data-scene="KEEP" onclick="setScene('KEEP')">4. In His Keep</button>
      <button class="control-btn" data-scene="QUAD" onclick="setScene('QUAD')">5. Quad-Split (All 4)</button>
    </div>

    <div style="display:flex;flex-wrap:wrap;gap:0.35rem;align-items:center;">
      <span style="font-size:0.76rem;text-transform:uppercase;letter-spacing:0.06em;color:#94A3B8;margin-right:0.3rem;font-weight:700;">7 Sovereign Realms:</span>
      <button class="control-btn active" data-order="0" onclick="setOrder(0)"><span class="dot" style="background:#F8F5E6"></span> #1 Tehom Ha-Levanah</button>
      <button class="control-btn" data-order="1" onclick="setOrder(1)"><span class="dot" style="background:#141416"></span> #2 Wadi Al-Qalam</button>
      <button class="control-btn" data-order="2" onclick="setOrder(2)"><span class="dot" style="background:#0F2C59"></span> #3 Livnat Ha-Sapir</button>
      <button class="control-btn" data-order="3" onclick="setOrder(3)"><span class="dot" style="background:#D4AF37"></span> #4 Sahra' Al-Mithaq</button>
      <button class="control-btn" data-order="4" onclick="setOrder(4)"><span class="dot" style="background:#8B0000"></span> #5 Ufq Al-Shihab</button>
      <button class="control-btn" data-order="5" onclick="setOrder(5)"><span class="dot" style="background:#B87333"></span> #6 Yam Ha-Nechoshet</button>
      <button class="control-btn" data-order="6" onclick="setOrder(6)"><span class="dot" style="background:#006B54"></span> #7 Barzakh Al-Khidr</button>
    </div>
  </div>

  <div id="canvas-container">
    <canvas id="render3d"></canvas>
    <div class="hud-overlay" id="hud-overlay">
      <div style="font-size:0.75rem;font-family:Consolas,monospace;color:#FDE68A;margin-bottom:0.2rem;" id="hud-tag">REALM #1 // OMEGA_0_EIN_SOF_AL_AZAL</div>
      <div style="font-size:1.15rem;font-weight:700;color:#FFF;margin-bottom:0.3rem;" id="hud-title">Tehom Ha-Levanah / Badiyat Al-Azal (White-Fire Vacuum)</div>
      <div style="font-size:0.82rem;color:#CBD5E1;line-height:1.45;" id="hud-desc">
        Spherical 30-cubit Tzimtzum contraction void pierced by a vertical beam of Kav light and surrounded by twelve monolithic alabaster stelae.
      </div>
    </div>
    <div class="hud-right">
      <div>ACTIVE ORDER : <span id="tel-order" style="color:#FFF;">#1 Malakh-Azal (warlock-1-white)</span></div>
      <div>REALM PORTAL : <a id="tel-link" href="realm-1-white.html" style="color:#FDE68A;pointer-events:auto;">Open realm-1-white.html</a></div>
      <div>CHROMA HEX   : <span id="tel-hex">#F8F5E6</span> | ACT-LOW: <span id="tel-actlow">0x070A19</span></div>
      <div>SPC STATE    : <span style="color:#34D399;">S0 OPTIMAL (Zero Iron Law)</span></div>
    </div>
  </div>

  <script>
    const ORDERS = [
      { id: 1, profile: "warlock-1-white", name: "Malakh-Azal", realm: "Tehom Ha-Levanah / Badiyat Al-Azal", desc: "Spherical 30-cubit Tzimtzum contraction void pierced by a vertical beam of Kav light and 12 alabaster stelae.", file: "realm-1-white.html", color: "#F8F5E6", actLow: "0x070A19" },
      { id: 2, profile: "warlock-2-black", name: "Katib Al-Qalam", realm: "Midbar Qedar / Wadi Al-Qalam", desc: "Infinite black basalt Awfaq grid spanned by the 231 parabolic Consonantal Gates of Sefer Yetzirah.", file: "realm-2-black.html", color: "#A78BFA", actLow: "0xEBEBE9" },
      { id: 3, profile: "warlock-3-sapphire", name: "Yored Ha-Merkabah", realm: "Livnat Ha-Sapir / Falak Al-'Arsh", desc: "Seven concentric Tekhelet sapphire amphitheaters orbited by interlocking gyroscopic Ophanim eye-wheels.", file: "realm-3-sapphire.html", color: "#38BDF8", actLow: "0xF0D3A6" },
      { id: 4, profile: "warlock-4-gold", name: "Shahid Al-Alast", realm: "Heikhal Ha-Hashmal / Sahra' Al-Mithaq", desc: "Three concentric rings of 24 electrum gold pillars (72 Triplets) resonating in the Still, Small Voice.", file: "realm-4-gold.html", color: "#D4AF37", actLow: "0x2B50C8" },
      { id: 5, profile: "warlock-5-crimson", name: "Saraph Ha-Ritzpah", realm: "Har Ha-Mizbe'ach / Ufq Al-Shihab", desc: "Six-bastioned red porphyry altar caldera beneath a barred sky of piercing crimson Shihab meteors.", file: "realm-5-crimson.html", color: "#EF4444", actLow: "0x74FFFF" },
      { id: 6, profile: "warlock-6-brass", name: "Ba'al Ha-Nechoshet", realm: "Yam Ha-Nechoshet / Jabal Qaf Al-Marij", desc: "Colossal Brazen Sea capping the mouths of Tehom, surrounded by 72 sunken brass containment silos.", file: "realm-6-brass.html", color: "#D97706", actLow: "0x478CCC" },
      { id: 7, profile: "warlock-7-emerald", name: "Wali Al-Ghaib", realm: "Bein Ha-Shemashot / Barzakh Al-Khidr", desc: "Emerald isthmus at the Confluence of the Two Seas (Majma' al-Bahrayn) crowned by a spiral Shamir lighthouse.", file: "realm-7-emerald.html", color: "#10B981", actLow: "0xFF94AB" }
    ];

    let currentScene = 'REALM';
    let currentOrderIdx = 0;
    let camYaw = 0.45, camPitch = 0.34, camZoom = 1.0;
    let isDragging = false, lastX = 0, lastY = 0;

    const canvas = document.getElementById('render3d');
    const ctx = canvas.getContext('2d');

    function resize() {
      const r = canvas.parentElement.getBoundingClientRect();
      canvas.width = r.width * window.devicePixelRatio;
      canvas.height = r.height * window.devicePixelRatio;
      ctx.setTransform(window.devicePixelRatio, 0, 0, window.devicePixelRatio, 0, 0);
    }
    window.addEventListener('resize', resize);
    resize();

    canvas.addEventListener('mousedown', e => { isDragging = true; lastX = e.clientX; lastY = e.clientY; });
    window.addEventListener('mouseup', () => isDragging = false);
    window.addEventListener('mousemove', e => {
      if (!isDragging) return;
      camYaw += (e.clientX - lastX) * 0.008;
      camPitch = Math.max(-0.1, Math.min(1.2, camPitch + (e.clientY - lastY) * 0.006));
      lastX = e.clientX; lastY = e.clientY;
    });
    canvas.addEventListener('wheel', e => {
      e.preventDefault();
      camZoom = Math.max(0.55, Math.min(2.0, camZoom - e.deltaY * 0.001));
    }, { passive: false });

    function updateHud() {
      const o = ORDERS[currentOrderIdx];
      document.getElementById('hud-tag').textContent = `REALM #${o.id} OF 7 // DOMAIN: ${currentScene}`;
      document.getElementById('hud-title').textContent = o.realm;
      document.getElementById('hud-desc').textContent = o.desc;
      document.getElementById('tel-order').textContent = `#${o.id} ${o.name} (${o.profile})`;
      document.getElementById('tel-hex').textContent = o.color;
      document.getElementById('tel-actlow').textContent = o.actLow;
      const link = document.getElementById('tel-link');
      link.href = o.file;
      link.textContent = "Open " + o.file;
      document.getElementById('hud-overlay').style.setProperty('--hud-accent', o.color);
    }

    function setScene(s) {
      currentScene = s;
      document.querySelectorAll('[data-scene]').forEach(b => b.classList.toggle('active', b.getAttribute('data-scene') === s));
      updateHud();
    }

    function setOrder(idx) {
      currentOrderIdx = idx;
      document.querySelectorAll('[data-order]').forEach(b => b.classList.toggle('active', parseInt(b.getAttribute('data-order')) === idx));
      updateHud();
    }

    function proj(x, y, z, cx, cy, sc) {
      const cyw = Math.cos(camYaw), syw = Math.sin(camYaw);
      const x1 = x * cyw - z * syw, z1 = x * syw + z * cyw;
      const cp = Math.cos(camPitch), sp = Math.sin(camPitch);
      const y2 = y * cp - z1 * sp, z2 = y * sp + z1 * cp;
      const dist = 600 + z2;
      if (dist < 40) return null;
      const p = (500 / dist) * sc;
      return { sx: cx + x1 * p, sy: cy - y2 * p, s: p };
    }

    function line3D(a, b, cx, cy, sc, col, w = 1.3, al = 0.85) {
      const p1 = proj(a[0],a[1],a[2],cx,cy,sc), p2 = proj(b[0],b[1],b[2],cx,cy,sc);
      if (!p1 || !p2) return;
      ctx.save(); ctx.globalAlpha = al; ctx.strokeStyle = col; ctx.lineWidth = w;
      ctx.beginPath(); ctx.moveTo(p1.sx, p1.sy); ctx.lineTo(p2.sx, p2.sy); ctx.stroke(); ctx.restore();
    }

    function poly3D(pts, cx, cy, sc, fill, stroke, w = 1.15, al = 0.9) {
      const pr = [];
      for (const pt of pts) { const p = proj(pt[0],pt[1],pt[2],cx,cy,sc); if (!p) return; pr.push(p); }
      ctx.save(); ctx.globalAlpha = al; ctx.beginPath();
      ctx.moveTo(pr[0].sx, pr[0].sy);
      for (let i = 1; i < pr.length; i++) ctx.lineTo(pr[i].sx, pr[i].sy);
      ctx.closePath();
      if (fill) { ctx.fillStyle = fill; ctx.fill(); }
      if (stroke) { ctx.strokeStyle = stroke; ctx.lineWidth = w; ctx.stroke(); }
      ctx.restore();
    }

    function box3D(bx, by, bz, wx, wy, wz, cx, cy, sc, fill, stroke) {
      const x0 = bx-wx/2, x1 = bx+wx/2, y0 = by, y1 = by+wy, z0 = bz-wz/2, z1 = bz+wz/2;
      const faces = [
        [[x0,y0,z1],[x1,y0,z1],[x1,y1,z1],[x0,y1,z1]],
        [[x0,y0,z0],[x1,y0,z0],[x1,y1,z0],[x0,y1,z0]],
        [[x0,y0,z0],[x0,y0,z1],[x0,y1,z1],[x0,y1,z0]],
        [[x1,y0,z0],[x1,y0,z1],[x1,y1,z1],[x1,y1,z0]],
        [[x0,y1,z0],[x1,y1,z0],[x1,y1,z1],[x0,y1,z1]]
      ];
      for (const f of faces) poly3D(f, cx, cy, sc, fill, stroke, 1.1, 0.88);
    }

    function hexSeal(y, rad, cx, cy, sc, col, rot) {
      for (let t = 0; t < 2; t++) {
        const pts = [];
        for (let i = 0; i < 3; i++) {
          const a = rot + (t * Math.PI / 3) + (i * 2 * Math.PI / 3);
          pts.push([Math.cos(a)*rad, y, Math.sin(a)*rad]);
        }
        poly3D(pts, cx, cy, sc, null, col, 1.6, 0.88);
      }
    }

    function drawWarlock(wx, wy, wz, cx, cy, sc, col, t) {
      const by = wy + Math.sin(t * 2.0) * 4;
      hexSeal(wy + 1, 48, cx, cy, sc, col, t * 0.5);
      const wings = [[54, 66, 30], [40, 78, 12], [26, 52, -20]];
      for (let p = 0; p < 3; p++) {
        const [yo, sp, h] = wings[p];
        for (const s of [-1, 1]) {
          poly3D([
            [wx+s*5, by+yo, wz],
            [wx+s*sp*0.55, by+yo+h*0.6, wz-16],
            [wx+s*sp, by+yo+h, wz-22],
            [wx+s*sp*0.45, by+yo-10, wz-8]
          ], cx, cy, sc, "rgba(212,175,55,0.18)", col, 1.35, 0.9);
        }
      }
      box3D(wx, by, wz, 24, 54, 20, cx, cy, sc, "rgba(15,28,55,0.92)", col);
      box3D(wx, by + 34, wz + 11, 14, 14, 2, cx, cy, sc, "rgba(212,175,55,0.9)", "#FFF");
      line3D([wx+20, by-4, wz+8], [wx+20, by+84, wz+8], cx, cy, sc, "#FDE68A", 2.2, 0.95);
    }

    function renderOrderRealm(cx, cy, sc, o, t) {
      const id = o.id;
      if (id === 1) {
        line3D([0, -180, 0], [0, 220, 0], cx, cy, sc, "#FFF", 3.2, 0.95);
        for (let lat = -2; lat <= 2; lat++) {
          const r = Math.cos(lat * 0.5) * 140, y = Math.sin(lat * 0.5) * 140 + 20;
          for (let i = 0; i < 24; i++) {
            const a1 = (i/24)*Math.PI*2 + t*0.3, a2 = ((i+1)/24)*Math.PI*2 + t*0.3;
            line3D([Math.cos(a1)*r, y, Math.sin(a1)*r], [Math.cos(a2)*r, y, Math.sin(a2)*r], cx, cy, sc, "#F8F5E6", 1.2, 0.55);
          }
        }
        for (let s = 0; s < 12; s++) {
          const a = (s/12)*Math.PI*2;
          box3D(Math.cos(a)*195, -45, Math.sin(a)*195, 16, 110, 16, cx, cy, sc, "rgba(248,245,230,0.22)", "#F8F5E6");
        }
      } else if (id === 2) {
        for (let i = -200; i <= 200; i += 40) {
          line3D([i, -45, -200], [i, -45, 200], cx, cy, sc, "rgba(167,139,250,0.28)", 1);
          line3D([-200, -45, i], [200, -45, i], cx, cy, sc, "rgba(167,139,250,0.28)", 1);
        }
        for (let g = 0; g < 11; g++) {
          const a = (g/11)*Math.PI;
          for (let seg = 0; seg < 14; seg++) {
            const t1 = (seg/14)*Math.PI, t2 = ((seg+1)/14)*Math.PI;
            line3D([Math.cos(a)*Math.cos(t1)*185, -45+Math.sin(t1)*165, Math.sin(a)*Math.cos(t1)*185],
                   [Math.cos(a)*Math.cos(t2)*185, -45+Math.sin(t2)*165, Math.sin(a)*Math.cos(t2)*185], cx, cy, sc, "#A78BFA", 1.4, 0.7);
          }
        }
      } else if (id === 3) {
        for (let ring = 1; ring <= 7; ring++) {
          const r = ring * 28, y = -45 - ring * 5;
          for (let i = 0; i < 20; i++) {
            const a1 = (i/20)*Math.PI*2, a2 = ((i+1)/20)*Math.PI*2;
            line3D([Math.cos(a1)*r, y, Math.sin(a1)*r], [Math.cos(a2)*r, y, Math.sin(a2)*r], cx, cy, sc, "#38BDF8", 1.3, 0.75);
          }
        }
        for (let w = 0; w < 2; w++) {
          const r = 135 + w * 32;
          for (let i = 0; i < 24; i++) {
            const a1 = (i/24)*Math.PI*2 + t*(w?-0.6:0.6), a2 = ((i+1)/24)*Math.PI*2 + t*(w?-0.6:0.6);
            line3D([Math.cos(a1)*r, 35+Math.sin(a1)*r*0.4, Math.sin(a1)*r],
                   [Math.cos(a2)*r, 35+Math.sin(a2)*r*0.4, Math.sin(a2)*r], cx, cy, sc, w ? "#FDE68A" : "#38BDF8", 1.6, 0.8);
          }
        }
      } else if (id === 4) {
        for (let ring = 0; ring < 3; ring++) {
          const r = 100 + ring * 45, h = 90 - ring * 16;
          for (let p = 0; p < 24; p++) {
            const a = (p/24)*Math.PI*2 + ring * 0.1;
            line3D([Math.cos(a)*r, -45, Math.sin(a)*r], [Math.cos(a)*r, -45 + h, Math.sin(a)*r], cx, cy, sc, "#D4AF37", 2.0, 0.82);
          }
        }
        hexSeal(80, 140, cx, cy, sc, "#FDE68A", t * 0.25);
      } else if (id === 5) {
        for (let i = 0; i < 6; i++) {
          const a = (i/6)*Math.PI*2;
          box3D(Math.cos(a)*165, -45, Math.sin(a)*165, 26, 120, 26, cx, cy, sc, "rgba(139,0,0,0.45)", "#EF4444");
          line3D([Math.cos(a)*165, 75, Math.sin(a)*165], [0, 150, 0], cx, cy, sc, "#F87171", 1.5, 0.85);
        }
        for (let m = 0; m < 10; m++) {
          const a = (m/10)*Math.PI*2 - t * 1.1;
          line3D([Math.cos(a)*200, 125, Math.sin(a)*200], [Math.cos(a+0.25)*145, 70, Math.sin(a+0.25)*145], cx, cy, sc, "#FCA5A5", 2.1, 0.9);
        }
      } else if (id === 6) {
        hexSeal(-45, 190, cx, cy, sc, "#D97706", -t * 0.2);
        for (let ring = 0; ring < 3; ring++) {
          const r = 90 + ring * 42;
          for (let s = 0; s < 24; s++) {
            const a = (s/24)*Math.PI*2;
            box3D(Math.cos(a)*r, -45, Math.sin(a)*r, 8, 18, 8, cx, cy, sc, "rgba(184,115,51,0.88)", "#FDE68A");
          }
        }
      } else {
        for (let x = -200; x <= 200; x += 28) {
          line3D([x, -45 + Math.sin(x*0.04+t*2)*12, -170], [x, -45, -35], cx, cy, sc, "#10B981", 1.3, 0.65);
          line3D([x, -45 + Math.cos(x*0.04-t*2)*12, 170], [x, -45, 35], cx, cy, sc, "#38BDF8", 1.3, 0.65);
        }
        box3D(0, -45, 0, 400, 8, 60, cx, cy, sc, "rgba(0,107,84,0.65)", "#10B981");
      }
      drawWarlock(0, -35, 0, cx, cy, sc, o.color, t);
    }

    function renderCastle(cx, cy, sc, o, t) {
      hexSeal(-42, 130, cx, cy, sc, "#D4AF37", -t * 0.2);
      const sp = 165;
      box3D(0, -44, -sp, 300, 62, 20, cx, cy, sc, "rgba(18,22,34,0.92)", o.color);
      box3D(-sp, -44, 0, 20, 62, 300, cx, cy, sc, "rgba(18,22,34,0.92)", o.color);
      box3D(sp, -44, 0, 20, 62, 300, cx, cy, sc, "rgba(18,22,34,0.92)", o.color);
      for (const [bx, bz] of [[-sp,-sp],[sp,-sp],[sp,sp],[-sp,sp]]) {
        box3D(bx, -44, bz, 46, 108, 46, cx, cy, sc, "rgba(24,28,42,0.95)", "#D4AF37");
      }
      drawWarlock(0, -24, -15, cx, cy, sc, o.color, t);
    }

    function renderTower(cx, cy, sc, o, t) {
      for (let tr = 0; tr < 7; tr++) {
        const yb = -115 + tr * 25, r = 135 - tr * 14;
        box3D(0, yb, 0, r * 1.4, 23, r * 1.4, cx, cy, sc, "rgba(17,24,39,0.92)", tr % 2 === 0 ? o.color : "#D4AF37");
      }
      drawWarlock(0, 65, 0, cx, cy, sc, o.color, t);
    }

    function renderKeep(cx, cy, sc, o, t) {
      hexSeal(-46, 155, cx, cy, sc, o.color, t * 0.2);
      for (let i = 0; i < 8; i++) {
        const a = (i/8)*Math.PI*2;
        box3D(Math.cos(a)*165, -46, Math.sin(a)*165, 18, 170, 18, cx, cy, sc, "rgba(22,26,38,0.92)", "#B87333");
        line3D([Math.cos(a)*165, 124, Math.sin(a)*165], [0, 165, 0], cx, cy, sc, o.color, 1.4, 0.7);
      }
      box3D(0, -46, 0, 62, 20, 62, cx, cy, sc, "rgba(15,44,89,0.92)", o.color);
      drawWarlock(0, -24, 0, cx, cy, sc, o.color, t);
    }

    function animate(now) {
      const t = now * 0.001;
      if (!isDragging) camYaw += 0.003;
      const w = canvas.width / window.devicePixelRatio, h = canvas.height / window.devicePixelRatio;
      ctx.clearRect(0, 0, w, h);
      const o = ORDERS[currentOrderIdx];

      if (currentScene === 'REALM') renderOrderRealm(w*0.5, h*0.56, camZoom, o, t);
      else if (currentScene === 'CASTLE') renderCastle(w*0.5, h*0.56, camZoom, o, t);
      else if (currentScene === 'TOWER') renderTower(w*0.5, h*0.56, camZoom, o, t);
      else if (currentScene === 'KEEP') renderKeep(w*0.5, h*0.58, camZoom, o, t);
      else {
        const qw = w*0.5, qh = h*0.5;
        ctx.strokeStyle = "rgba(255,255,255,0.14)";
        ctx.beginPath(); ctx.moveTo(qw,0); ctx.lineTo(qw,h); ctx.moveTo(0,qh); ctx.lineTo(w,qh); ctx.stroke();
        renderOrderRealm(qw*0.5, qh*0.56, camZoom*0.52, o, t);
        renderCastle(qw*1.5, qh*0.58, camZoom*0.52, o, t);
        renderTower(qw*0.5, qh*1.58, camZoom*0.50, o, t);
        renderKeep(qw*1.5, qh*1.60, camZoom*0.52, o, t);
      }
      requestAnimationFrame(animate);
    }
    requestAnimationFrame(animate);
  </script>
</body>
</html>
""";
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
