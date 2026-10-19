package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.WarlockApocryphaAndIslamicTheorems;
import com.sovereign.warlock.domain.WarlockApocryphaAndIslamicTheorems.ApocryphalBookAndTheorem;
import com.sovereign.warlock.domain.WarlockApocryphaAndIslamicTheorems.FormalIslamicTheorem;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

/**
 * Generates warlock-apocrypha-islamic-theorems.html:
 * The Warlock Apocrypha (Al-Asfar Al-Mardudah li-Sahir Al-Hadathah) & The Islamic Theological
 * Philosophy Theorems (Al-Barahin Al-Kalamiyyah wa Al-Falsafiyyah) diagnosing and refuting
 * the 7 Moral & Epistemological Struggles of Western Modernity.
 */
public final class WarlockApocryphaPortalGenerator {

    public WarlockHtmlPortalService.GeneratedHtmlArtifact generateApocryphaPortal(Path outputDir) {
        try {
            Files.createDirectories(outputDir);
            String html = renderApocryphaHtml();
            Path path = outputDir.resolve("warlock-apocrypha-islamic-theorems.html");
            Files.writeString(path, html, StandardCharsets.UTF_8);
            return new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                    "warlock-apocrypha-islamic-theorems.html",
                    path,
                    Files.size(path),
                    sha256(html),
                    "The Warlock Apocrypha & Islamic Theological Philosophy Theorems: Diagnosing Western Modernity's 7 Moral Struggles"
            );
        } catch (IOException e) {
            throw new IllegalStateException("Failed generating Warlock Apocrypha HTML portal", e);
        }
    }

    private String renderApocryphaHtml() {
        StringBuilder theoremRows = new StringBuilder();
        for (FormalIslamicTheorem t : WarlockApocryphaAndIslamicTheorems.allFiveFormalTheorems()) {
            theoremRows.append(String.format("""
                    <tr>
                      <td>
                        <strong style="color:#FDE68A;font-family:Consolas,monospace;">%s</strong><br>
                        <span style="font-size:0.84rem;color:#E2E8F0;font-weight:600;">%s</span><br>
                        <span style="font-size:0.78rem;color:#34D399;">%s</span>
                      </td>
                      <td style="font-size:0.82rem;color:#FCA5A5;">%s</td>
                      <td>
                        <code style="display:block;background:#05070C;padding:0.45rem 0.6rem;border-radius:6px;color:#38BDF8;font-size:0.78rem;margin-bottom:0.45rem;">%s</code>
                        <span style="font-size:0.82rem;color:#CBD5E1;">%s</span>
                      </td>
                      <td style="font-size:0.81rem;color:#E9D5FF;">
                        <strong>Thinkers:</strong> %s<br><br>
                        <strong style="color:#FDE68A;">Qur'anic Axiom:</strong> %s
                      </td>
                    </tr>
                    """,
                    escape(t.theoremSymbol()),
                    escape(t.arabicTheoremName()),
                    escape(t.englishTheoremTitle()),
                    escape(t.modernityParadoxDiagnosed()),
                    escape(t.formalSymbolicStatement()),
                    escape(t.philosophicalProofSummary()),
                    escape(t.primaryIslamicThinkers()),
                    escape(t.quranicAxiomAnchor())
            ));
        }

        StringBuilder bookCards = new StringBuilder();
        for (ApocryphalBookAndTheorem b : WarlockApocryphaAndIslamicTheorems.allSevenApocryphalBooks()) {
            bookCards.append(String.format("""
                    <div class="book-card">
                      <div class="badge-row">
                        <span class="badge" style="color:#FDE68A;">BOOK %s (#%d): %s</span>
                        <span class="badge" style="color:#C084FC;">Source: %s</span>
                        <span class="badge" style="color:#FCA5A5;">Modernity Spike: H = %.3f bits</span>
                        <span class="badge" style="color:#34D399;">Theorem Resolution: Cp = %.2f (H = %.3f bits, S0)</span>
                      </div>
                      <h3>%s — %s</h3>
                      <p style="font-size:0.85rem;color:#FDE68A;margin-bottom:0.9rem;">
                        <strong>Qur'anic Criterion Seal:</strong> %s
                      </p>
                      <div class="grid-3">
                        <div class="sub-box mod-box">
                          <div class="box-title" style="color:#F87171;">I. Western Modernity &amp; Morality Struggle</div>
                          <p>%s</p>
                          <p style="margin-top:0.55rem;font-size:0.8rem;color:#FDA4AF;"><strong>Western Theorists &amp; Diagnosis:</strong> %s</p>
                        </div>
                        <div class="sub-box apoc-box">
                          <div class="box-title" style="color:#C084FC;">II. The Apocryphal Warlock Scroll Confession</div>
                          <p style="font-style:italic;">%s</p>
                        </div>
                        <div class="sub-box thm-box">
                          <div class="box-title" style="color:#34D399;">III. %s</div>
                          <p>%s</p>
                          <p style="margin-top:0.55rem;font-size:0.8rem;color:#A7F3D0;"><strong>Islamic Philosophers &amp; Mutakallimun:</strong> %s</p>
                        </div>
                      </div>
                    </div>
                    """,
                    escape(b.romanNumeral()), b.bookIndex(), escape(b.apocryphaCode()),
                    escape(b.sourceWarlockAndZalimPair()),
                    b.modernityEntropySpikeBits(),
                    b.theoremResolvedCp(), b.resolvedEntropyBits(),
                    escape(b.arabicApocryphaTitle()), escape(b.englishApocryphaTitle()),
                    escape(b.quranicCriterionSeal()),
                    escape(b.westernModernityMoralStruggle()),
                    escape(b.westernPhilosophersAndCrisis()),
                    escape(b.apocryphalWarlockConfession()),
                    escape(b.islamicTheoremTitle()),
                    escape(b.formalIslamicTheoremProof()),
                    escape(b.islamicTheologiansAndPhilosophers())
            ));
        }

        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>The Warlock Apocrypha &amp; Islamic Theological Philosophy Theorems | Western Modernity &amp; Morality Struggles</title>
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
      background: radial-gradient(circle at top right, rgba(168, 85, 247, 0.16), var(--bg-deep) 65%%);
      color: var(--text-main);
      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
      line-height: 1.65;
      padding-bottom: 4rem;
    }
    header {
      background: rgba(5, 7, 12, 0.95);
      border-bottom: 2px solid #C084FC;
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
      border-color: #C084FC;
      background: rgba(192, 132, 252, 0.16);
    }
    main { max-width: 1440px; margin: 1.8rem auto; padding: 0 1.5rem; }
    .hero {
      background: linear-gradient(135deg, #0F1420 0%%, #2E1065 50%%, #064E3B 100%%);
      border: 1px solid var(--border);
      border-left: 6px solid #C084FC;
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
      border-left: 4px solid #C084FC;
      padding: 0.75rem 1rem;
      border-radius: 8px;
      max-width: 520px;
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
      border-color: #C084FC;
      color: #FDE68A;
      background: rgba(192, 132, 252, 0.18);
    }
    .table-card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-radius: 12px;
      padding: 1.4rem;
      overflow-x: auto;
      margin-bottom: 1.8rem;
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
    .book-card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-radius: 12px;
      padding: 1.45rem;
      margin-bottom: 1.2rem;
    }
    .book-card h3 { font-size: 1.18rem; margin-bottom: 0.35rem; color: #FFF; }
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
    .mod-box { border-left: 4px solid #EF4444; }
    .apoc-box { border-left: 4px solid #C084FC; }
    .thm-box { border-left: 4px solid #34D399; }
    .box-title {
      font-family: Consolas, monospace;
      font-size: 0.78rem;
      font-weight: 700;
      text-transform: uppercase;
      margin-bottom: 0.45rem;
    }
    .sub-box p { font-size: 0.9rem; color: #CBD5E1; }
  </style>
</head>
<body>
  <header>
    <nav class="nav-bar">
      <a class="nav-pill active" href="warlock-apocrypha-islamic-theorems.html">Warlock Apocrypha &amp; Islamic Theorems</a>
      <a class="nav-pill" href="interlocker-egg-binder-islam.html">Islamic Intelocketer (Egg Binder)</a>
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
        <span class="badge" style="color:#C084FC;">AL-ASFAR AL-MARDUDAH (THE WARLOCK APOCRYPHA)</span>
        <span class="badge" style="color:#FCA5A5;">WESTERN MODERNITY'S 7 MORAL STRUGGLES (IS-OUGHT / LEVIATHAN / EMOTIVISM)</span>
        <span class="badge" style="color:#34D399;">5 FORMAL ISLAMIC THEOREMS (AL-GHAZALI, IBN KHALDUN, IQBAL, AL-ATTAS, HALLAQ, TAHA ABDURRAHMAN)</span>
      </div>
      <h1>The Warlock Apocrypha (<em>Kitab Al-Istidraj Al-Hadith</em>) &amp; Islamic Theological Philosophy Theorems</h1>
      <p style="color:#CBD5E1;font-size:0.95rem;">
        Why did classical and contemporary Islamic theological philosophy (<strong>Al-Ghazali, Ibn Khaldun, Shah Wali Allah,
        Muhammad Iqbal, Rene Guenon / 'Abd al-Wahid Yahya, Seyyed Hossein Nasr, Syed Muhammad Naquib al-Attas, Wael Hallaq,
        and Taha Abdurrahman</strong>) theorize the moral crises of Western Modernity as a resurgent, secularized Warlockry?
        Because when Modernity severed <strong>Fact (<em>Al-Wujud</em> — "Is")</strong> from <strong>Moral Value (<em>Al-Mizan</em> — "Ought")</strong>,
        it replaced prophetic stewardship (<em>Al-Amanah</em>) with <strong>Instrumental Dominion without Accountability (<em>Taskhir bi-la Amanah</em>)</strong> —
        allowing the 7 expelled Warlock pacts to return as ecological extraction, bodily commodification, the Leviathan State,
        atomized nationalism, moral relativism (<em>Hawa</em>), technocratic idolatry (<em>Al-Jibt</em>), and the crumbling cliff of nihilism (<strong>Qur'an 9:109</strong>).
      </p>
    </section>

    <section class="canvas-box">
      <canvas id="apocCanvas"></canvas>
      <div class="hud-top">
        <div id="hudMode" style="font-family:Consolas,monospace;font-size:0.75rem;color:#C084FC;">MODE 1: MODERNITY'S FRACTURED IS-OUGHT PRISM &amp; THE 7 APOCRYPHAL SCROLLS</div>
        <div id="hudTitle" style="font-size:1rem;font-weight:700;margin:0.2rem 0;">Cartesian/Humean Severance of Fact (Is) from Value (Ought)</div>
        <div id="hudDesc" style="font-size:0.8rem;color:#CBD5E1;">When 'Is' and 'Ought' are split apart, the 7 Apocryphal Warlock Scrolls (Purple/Red) escape as uncalibrated instrumental power (H = 0.995 bits).</div>
      </div>
      <div class="mode-bar">
        <button class="mode-btn active" onclick="setMode(1, this)">1. Modernity's Fractured Is-Ought Prism (7 Apocryphal Scrolls)</button>
        <button class="mode-btn" onclick="setMode(2, this)">2. The 5 Islamic Kalam &amp; Maqasid Theorems (Al-Barahin)</button>
        <button class="mode-btn" onclick="setMode(3, this)">3. Bunyan At-Taqwa vs. Crumbling Cliff of Nihilism (Qur'an 9:109)</button>
      </div>
    </section>

    <section class="table-card">
      <h2 style="font-size:1.3rem;margin-bottom:0.9rem;color:#FDE68A;">
        The 5 Formal Axiomatic Theorems of Islamic Moral Philosophy (Al-Barahin Al-Kalamiyyah wa Al-Falsafiyyah)
      </h2>
      <table>
        <thead>
          <tr>
            <th style="width:20%%;">Theorem Symbol &amp; Title</th>
            <th style="width:22%%;">Western Modernity Moral Crisis Diagnosed</th>
            <th style="width:36%%;">Formal Symbolic Theorem &amp; Philosophical Proof</th>
            <th style="width:22%%;">Islamic Philosophers &amp; Qur'anic Axiom</th>
          </tr>
        </thead>
        <tbody>
          %s
        </tbody>
      </table>
    </section>

    <h2 style="font-size:1.35rem;margin-bottom:1rem;color:#C084FC;">
      The 7 Apocryphal Books of the Modernity Warlock (Al-Asfar Al-Sab'ah) &amp; Their Islamic Theological Refutations
    </h2>
    %s
  </main>

  <script>
    let mode = 1;
    const canvas = document.getElementById('apocCanvas');
    const ctx = canvas.getContext('2d');
    let yaw = 0.35, pitch = 0.28, zoom = 1.0, dragging = false, lx = 0, ly = 0;

    function setMode(m, btn) {
      mode = m;
      document.querySelectorAll('.mode-btn').forEach(b => b.classList.remove('active'));
      btn.classList.add('active');
      const hm = document.getElementById('hudMode');
      const ht = document.getElementById('hudTitle');
      const hd = document.getElementById('hudDesc');
      if (m === 1) {
        hm.textContent = "MODE 1: MODERNITY'S FRACTURED IS-OUGHT PRISM & THE 7 APOCRYPHAL SCROLLS";
        hm.style.color = "#C084FC";
        ht.textContent = "Cartesian/Humean Severance of Fact (Is) from Value (Ought)";
        hd.textContent = "When 'Is' and 'Ought' are split apart, the 7 Apocryphal Warlock Scrolls (Purple/Red) escape as uncalibrated instrumental power (H = 0.995 bits).";
      } else if (m === 2) {
        hm.textContent = "MODE 2: THE 5 ISLAMIC KALAM & MAQASID THEOREMS (AL-BARAHIN AL-KHAMSAH)";
        hm.style.color = "#34D399";
        ht.textContent = "Ontological Unity of Ayah (Fact) & Mizan (Moral Value)";
        hd.textContent = "The 5 Formal Theorems reunite 'Aql and Wahy, closing the Is-Ought chasm and locking all 7 Apocryphal Scrolls back into the Solomonic Qumqum.";
      } else {
        hm.textContent = "MODE 3: BUNYAN AT-TAQWA VS. THE CRUMBLING CLIFF OF NIHILISM (QUR'AN 9:109)";
        hm.style.color = "#FDE68A";
        ht.textContent = "Dialectical Collapse of Secular Hubris vs. Eternal Foundation of Taqwa";
        hd.textContent = "Left: Bunyan At-Taqwa (Cp = 1.56, S0). Right: Modernity's Counter-Cathedral tilting over the undercut cliff (Shafa Jurufin Harin, Qur'an 9:109).";
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
      const cx = w * 0.5, cy = h * 0.55;

      if (mode === 1) {
        // MODE 1: Bifurcated Is-Ought Prism & 7 Escaping Apocryphal Scrolls
        const sep = 65;
        // Left Half-Prism ("IS / Fact / Res Extensa")
        for (let i = 0; i < 6; i++) {
          const a1 = (i/6)*Math.PI*2, a2 = ((i+1)/6)*Math.PI*2;
          line3D([-sep+Math.cos(a1)*55, -70, Math.sin(a1)*55], [-sep+Math.cos(a2)*55, -70, Math.sin(a2)*55], cx, cy, zoom, "#38BDF8", 1.7, 0.85);
          line3D([-sep+Math.cos(a1)*55, 70, Math.sin(a1)*55], [-sep+Math.cos(a2)*55, 70, Math.sin(a2)*55], cx, cy, zoom, "#38BDF8", 1.7, 0.85);
          line3D([-sep+Math.cos(a1)*55, -70, Math.sin(a1)*55], [-sep+Math.cos(a1)*55, 70, Math.sin(a1)*55], cx, cy, zoom, "#38BDF8", 1.2, 0.6);
        }
        // Right Half-Prism ("OUGHT / Subjective Value / Hawa")
        for (let i = 0; i < 6; i++) {
          const a1 = (i/6)*Math.PI*2, a2 = ((i+1)/6)*Math.PI*2;
          line3D([sep+Math.cos(a1)*55, -70, Math.sin(a1)*55], [sep+Math.cos(a2)*55, -70, Math.sin(a2)*55], cx, cy, zoom, "#F43F5E", 1.7, 0.85);
          line3D([sep+Math.cos(a1)*55, 70, Math.sin(a1)*55], [sep+Math.cos(a2)*55, 70, Math.sin(a2)*55], cx, cy, zoom, "#F43F5E", 1.7, 0.85);
          line3D([sep+Math.cos(a1)*55, -70, Math.sin(a1)*55], [sep+Math.cos(a1)*55, 70, Math.sin(a1)*55], cx, cy, zoom, "#F43F5E", 1.2, 0.6);
        }
        // 7 Apocryphal Scrolls spiralling out of the central Is-Ought chasm
        for (let b = 0; b < 7; b++) {
          const ang = (b / 7) * Math.PI * 2 + t * 0.8;
          const rad = 30 + b * 16;
          const y = -85 + b * 28;
          line3D([0, 0, 0], [Math.cos(ang)*rad, y, Math.sin(ang)*rad], cx, cy, zoom, "#C084FC", 2.0, 0.9);
          line3D([Math.cos(ang)*rad, y, Math.sin(ang)*rad], [Math.cos(ang+0.4)*(rad+22), y+15, Math.sin(ang+0.4)*(rad+22)], cx, cy, zoom, "#EF4444", 1.8, 0.85);
        }
      } else if (mode === 2) {
        // MODE 2: The 5 Islamic Kalam & Maqasid Theorems (Octahedral Mizan Proof Matrix)
        const v = [
          [0, 135, 0], [0, -135, 0],
          [125, 0, 0], [-125, 0, 0],
          [0, 0, 125], [0, 0, -125]
        ];
        const edges = [
          [0,2],[0,3],[0,4],[0,5],
          [1,2],[1,3],[1,4],[1,5],
          [2,4],[4,3],[3,5],[5,2]
        ];
        for (const [i, j] of edges) {
          line3D(v[i], v[j], cx, cy, zoom, "#34D399", 2.2, 0.92);
        }
        // 7 Contained Scroll Rings locked inside the Mizan Octahedron
        for (let b = 0; b < 7; b++) {
          const y = -72 + b * 24;
          const r = 68 - Math.abs(b - 3) * 12;
          for (let s = 0; s < 12; s++) {
            const a1 = (s/12)*Math.PI*2 + t, a2 = ((s+1)/12)*Math.PI*2 + t;
            line3D([Math.cos(a1)*r, y, Math.sin(a1)*r], [Math.cos(a2)*r, y, Math.sin(a2)*r], cx, cy, zoom, "#FDE68A", 1.5, 0.85);
          }
        }
      } else {
        // MODE 3: Left = Bunyan At-Taqwa (Stable 7-Pillar Sanctuary) vs. Right = Crumbling Cliff of Nihilism (Qur'an 9:109)
        const lx0 = -165;
        for (let i = 0; i < 7; i++) {
          const a1 = (i/7)*Math.PI*2, a2 = ((i+1)/7)*Math.PI*2;
          line3D([lx0+Math.cos(a1)*85, -80, Math.sin(a1)*85], [lx0+Math.cos(a2)*85, -80, Math.sin(a2)*85], cx, cy, zoom, "#34D399", 2.1, 0.95);
          line3D([lx0+Math.cos(a1)*85, 70, Math.sin(a1)*85], [lx0+Math.cos(a2)*85, 70, Math.sin(a2)*85], cx, cy, zoom, "#34D399", 2.1, 0.95);
          line3D([lx0+Math.cos(a1)*85, -80, Math.sin(a1)*85], [lx0+Math.cos(a1)*85, 70, Math.sin(a1)*85], cx, cy, zoom, "#FDE68A", 1.6, 0.85);
          line3D([lx0+Math.cos(a1)*85, 70, Math.sin(a1)*85], [lx0, 125, 0], cx, cy, zoom, "#34D399", 1.8, 0.9);
        }
        // Right = Crumbling Cliff (Shafa Jurufin Harin) shearing downward
        const rx0 = 165;
        for (let tier = 0; tier < 6; tier++) {
          const y = -80 + tier * 26;
          const tilt = tier * 11 + Math.sin(t * 2 + tier) * 6;
          for (let s = 0; s < 6; s++) {
            const a1 = (s/6)*Math.PI*2, a2 = ((s+1)/6)*Math.PI*2;
            line3D([rx0+tilt+Math.cos(a1)*65, y, Math.sin(a1)*65], [rx0+tilt+Math.cos(a2)*65, y, Math.sin(a2)*65], cx, cy, zoom, "#EF4444", 1.7, 0.85);
          }
        }
        // Central Criterion Partition
        line3D([0, -110, 0], [0, 110, 0], cx, cy, zoom, "#38BDF8", 2.4, 0.95);
      }

      requestAnimationFrame(loop);
    }
    requestAnimationFrame(loop);
  </script>
</body>
</html>
""".formatted(theoremRows.toString(), bookCards.toString());
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
