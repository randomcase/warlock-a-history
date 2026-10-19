package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.WarlockIslamicHistoricalVisualEras;
import com.sovereign.warlock.domain.WarlockIslamicHistoricalVisualEras.IslamicVisualEraDossier;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

/**
 * Generates warlock-islamic-visual-eras-history.html:
 * Interactive 7-Era AI & Procedural Islamic Visual Art Gallery chronicling the Warlock
 * Sanctum, Qumqum Containment, Negentropic Priory, and Rose Sanctuary across every era
 * of Islamic art and architectural history (Era I Pre-Prophetic Babil through Era VII
 * Sovereign Neo-Islamic AI Cyber-Geometry).
 */
public final class WarlockIslamicVisualErasPortalGenerator {

    public WarlockHtmlPortalService.GeneratedHtmlArtifact generateVisualErasPortal(Path outputDir) {
        try {
            Files.createDirectories(outputDir);
            String html = renderVisualErasHtml();
            Path path = outputDir.resolve("warlock-islamic-visual-eras-history.html");
            Files.writeString(path, html, StandardCharsets.UTF_8);
            return new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                    "warlock-islamic-visual-eras-history.html",
                    path,
                    Files.size(path),
                    sha256(html),
                    "Warlock Visuals Across Every Era of Islamic Art History (Era I Babil/Saba to Era VII Neo-Islamic AI Cyber-Geometry)"
            );
        } catch (IOException e) {
            throw new IllegalStateException("Failed generating Warlock Islamic Visual Eras HTML portal", e);
        }
    }

    private String renderVisualErasHtml() {
        StringBuilder eraCards = new StringBuilder();
        for (IslamicVisualEraDossier e : WarlockIslamicHistoricalVisualEras.allSevenIslamicVisualEras()) {
            String c0 = e.hexPalette().get(0);
            String c1 = e.hexPalette().get(1);
            String c2 = e.hexPalette().get(2);
            String c3 = e.hexPalette().get(3);

            StringBuilder swatches = new StringBuilder();
            for (String hex : e.hexPalette()) {
                swatches.append(String.format(
                        "<span class=\"swatch-pill\"><span class=\"swatch-dot\" style=\"background:%s;\"></span><code>%s</code></span>",
                        hex, hex
                ));
            }

            String svgPlate = buildEraSvgArtPlate(e.eraIndex(), e.starPolygonFold(), c0, c1, c2, c3, e.arabicEraTitle());

            eraCards.append(String.format("""
                    <div class="era-card" style="border-left-color:%s;">
                      <div class="era-grid">
                        <div class="svg-plate-wrap">
                          %s
                          <div class="swatch-bar">%s</div>
                        </div>
                        <div class="era-content">
                          <div class="badge-row">
                            <span class="badge" style="color:#FDE68A;">%s</span>
                            <span class="badge" style="color:#38BDF8;">%s</span>
                            <span class="badge" style="color:#34D399;">%d-FOLD SACRED GEOMETRY (%s)</span>
                          </div>
                          <h3>%s</h3>
                          <p style="font-size:0.86rem;color:#C084FC;margin-bottom:0.7rem;">
                            <strong>%s</strong> | <strong>Centers:</strong> %s
                          </p>
                          <div class="detail-grid">
                            <div class="sub-box">
                              <div class="box-title" style="color:#FDE68A;">I. Historical Pigments &amp; Geometric/Calligraphic Grammar</div>
                              <p><strong>Pigments:</strong> %s</p>
                              <p style="margin-top:0.35rem;"><strong>Grammar:</strong> %s</p>
                            </div>
                            <div class="sub-box">
                              <div class="box-title" style="color:#34D399;">II. Warlock Visual Subject &amp; Qur'anic Anchor</div>
                              <p>%s</p>
                              <p style="margin-top:0.35rem;color:#A5F3FC;"><strong>Anchor:</strong> %s</p>
                            </div>
                          </div>
                          <div class="prompt-box">
                            <div class="box-title" style="color:#FDA4AF;">III. Canonical AI Generative Visual Prompt Specification</div>
                            <code>%s</code>
                          </div>
                        </div>
                      </div>
                    </div>
                    """,
                    c1,
                    svgPlate,
                    swatches.toString(),
                    escape(e.eraCode()),
                    escape(e.chronologicalSpan()),
                    e.starPolygonFold(),
                    escape(e.svgSacredGeometryPatternType()),
                    escape(e.englishEraTitle()),
                    escape(e.arabicEraTitle()),
                    escape(e.historicalDynastyAndCenters()),
                    escape(e.canonicalPigmentsAndPalette()),
                    escape(e.geometricAndCalligraphicGrammar()),
                    escape(e.warlockVisualCompositionSubject()),
                    escape(e.quranicAndAestheticAnchor()),
                    escape(e.aiGenerativePromptSpecification())
            ));
        }

        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Warlock Visuals Across Every Era of Islamic History | AI &amp; Sacred Geometry Atlas</title>
  <style>
    :root {
      --bg-deep: #05070D;
      --bg-card: #0F1422;
      --text-main: #ECEFF4;
      --text-muted: #94A3B8;
      --border: rgba(255,255,255,0.12);
    }
    * { box-sizing: border-box; margin: 0; padding: 0; }
    body {
      background:
        radial-gradient(circle at top left, rgba(212, 175, 55, 0.16), transparent 50%%),
        radial-gradient(circle at top right, rgba(56, 189, 248, 0.14), var(--bg-deep) 68%%);
      color: var(--text-main);
      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
      line-height: 1.65;
      padding-bottom: 4rem;
    }
    header {
      background: rgba(5, 7, 13, 0.95);
      border-bottom: 2px solid #D4AF37;
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
      border-color: #D4AF37;
      background: rgba(212, 175, 55, 0.18);
    }
    main {
      max-width: 1480px;
      margin: 1.8rem auto;
      padding: 0 1.5rem;
    }
    .hero {
      background: linear-gradient(135deg, #0F1422 0%%, #1F1730 50%%, #0E2722 100%%);
      border: 1px solid var(--border);
      border-left: 6px solid #D4AF37;
      border-radius: 14px;
      padding: 1.9rem;
      margin-bottom: 1.8rem;
    }
    .badge-row {
      display: flex;
      flex-wrap: wrap;
      gap: 0.45rem;
      margin-bottom: 0.65rem;
    }
    .badge {
      font-family: 'Consolas', monospace;
      font-size: 0.74rem;
      padding: 0.2rem 0.55rem;
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
      height: 520px;
      margin-bottom: 2rem;
      overflow: hidden;
    }
    canvas { width: 100%%; height: 100%%; display: block; cursor: grab; }
    .hud-top {
      position: absolute;
      top: 1rem;
      left: 1rem;
      background: rgba(5, 7, 13, 0.88);
      border: 1px solid var(--border);
      border-left: 4px solid #D4AF37;
      border-radius: 10px;
      padding: 0.85rem 1.1rem;
      max-width: 600px;
      pointer-events: none;
    }
    .mode-bar {
      position: absolute;
      bottom: 1rem;
      left: 1rem;
      right: 1rem;
      display: flex;
      flex-wrap: wrap;
      gap: 0.45rem;
      background: rgba(5, 7, 13, 0.9);
      border: 1px solid var(--border);
      border-radius: 10px;
      padding: 0.55rem;
    }
    .mode-btn {
      background: #0F1422;
      color: #CBD5E1;
      border: 1px solid var(--border);
      border-radius: 6px;
      padding: 0.38rem 0.7rem;
      font-size: 0.75rem;
      font-weight: 600;
      cursor: pointer;
    }
    .mode-btn.active, .mode-btn:hover {
      border-color: #D4AF37;
      color: #FFF;
      background: rgba(212, 175, 55, 0.25);
    }
    .era-card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-left: 6px solid #D4AF37;
      border-radius: 14px;
      padding: 1.4rem;
      margin-bottom: 1.5rem;
    }
    .era-grid {
      display: grid;
      grid-template-columns: 320px 1fr;
      gap: 1.4rem;
      align-items: start;
    }
    @media (max-width: 960px) {
      .era-grid { grid-template-columns: 1fr; }
    }
    .svg-plate-wrap {
      background: #070A12;
      border: 1px solid var(--border);
      border-radius: 10px;
      padding: 0.75rem;
      text-align: center;
    }
    .swatch-bar {
      display: flex;
      flex-wrap: wrap;
      gap: 0.35rem;
      justify-content: center;
      margin-top: 0.6rem;
    }
    .swatch-pill {
      display: inline-flex;
      align-items: center;
      gap: 0.3rem;
      background: rgba(255,255,255,0.05);
      border: 1px solid var(--border);
      border-radius: 999px;
      padding: 0.15rem 0.5rem;
      font-size: 0.72rem;
    }
    .swatch-dot {
      width: 10px;
      height: 10px;
      border-radius: 50%%;
      display: inline-block;
    }
    .era-content h3 {
      font-size: 1.2rem;
      color: #FDE68A;
      margin-bottom: 0.35rem;
    }
    .detail-grid {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(290px, 1fr));
      gap: 0.85rem;
      margin-bottom: 0.85rem;
    }
    .sub-box {
      background: rgba(255,255,255,0.03);
      border: 1px solid var(--border);
      border-radius: 8px;
      padding: 0.85rem;
      font-size: 0.84rem;
    }
    .prompt-box {
      background: #070A12;
      border: 1px solid rgba(244, 63, 94, 0.35);
      border-radius: 8px;
      padding: 0.85rem;
      font-size: 0.8rem;
    }
    .box-title {
      font-size: 0.73rem;
      font-weight: 700;
      text-transform: uppercase;
      letter-spacing: 0.05em;
      margin-bottom: 0.35rem;
    }
    code {
      font-family: 'Consolas', monospace;
      color: #A5F3FC;
    }
    .ai-gallery-grid {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(310px, 1fr));
      gap: 1.25rem;
      margin-bottom: 2.2rem;
    }
    .ai-plate-card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-top: 4px solid #D4AF37;
      border-radius: 12px;
      overflow: hidden;
      display: flex;
      flex-direction: column;
    }
    .ai-plate-card img {
      width: 100%%;
      height: 270px;
      object-fit: cover;
      border-bottom: 1px solid var(--border);
    }
    .ai-plate-body {
      padding: 1rem 1.15rem;
      font-size: 0.84rem;
    }
    .ai-plate-body h3 {
      font-size: 1.02rem;
      color: #FDE68A;
      margin-bottom: 0.35rem;
    }
  </style>
</head>
<body>
  <header>
    <nav class="nav-bar">
      <a class="nav-pill active" href="warlock-islamic-visual-eras-history.html">7 Islamic Visual Eras Atlas</a>
      <a class="nav-pill" href="disney-daffy-donald-islamic-microcosm.html">Disney/Daffy Animalism Microcosm</a>
      <a class="nav-pill" href="way-of-the-flower-rose-garden-islam.html">Way of the Flower, Rose &amp; Garden</a>
      <a class="nav-pill" href="islamic-husbandry-sovereign-estate.html">Islamic Husbandry (Al-Qiwamah)</a>
      <a class="nav-pill" href="warlock-apocrypha-islamic-theorems.html">Warlock Apocrypha &amp; Theorems</a>
      <a class="nav-pill" href="interlocker-egg-binder-islam.html">Islamic Intelocketer (Egg Binder)</a>
      <a class="nav-pill" href="warlock-3d-sanctum.html">3D Sanctum</a>
      <a class="nav-pill" href="order-1-white.html">Order #1..#7</a>
      <a class="nav-pill" href="dependencies-report.html">Dependencies Report</a>
    </nav>
  </header>

  <main>
    <section class="hero">
      <div class="badge-row">
        <span class="badge" style="color:#FDE68A;">ERA I: BABIL &amp; SABA' LAPIS RELIEFS</span>
        <span class="badge" style="color:#38BDF8;">ERA II: ABBASID BAGHDAD GOLD KUFIC &amp; AL-WASITI</span>
        <span class="badge" style="color:#F43F5E;">ERA III–IV: MAMLUK MISHKAT &amp; ALHAMBRA ZELLIJ</span>
        <span class="badge" style="color:#C084FC;">ERA V–VI: PERSIAN MINIATURE &amp; OTTOMAN IZNIK</span>
        <span class="badge" style="color:#34D399;">ERA VII: SOVEREIGN NEO-ISLAMIC AI CYBER-GEOMETRY</span>
      </div>
      <h1>Warlock Visuals Across Every Era of Islamic History: AI &amp; Sacred Geometry Visual Atlas</h1>
      <p style="color:#CBD5E1;font-size:0.95rem;">
        A complete visual and architectural chronicle across <strong>7 Historical Eras of Islamic Aesthetics</strong> —
        tracing the visual representation of the <strong>7 Pre-Prophetic Color Orders</strong>, the
        <strong>Brass <em>Qumqum</em> Containment of Ja'far</strong>, the <strong>Negentropic Priory Keep</strong>,
        and the <strong>Walled Crimson Rose Sanctuary (<em>Gulistan</em>)</strong> from ancient Babylonian lapis reliefs
        and Abbasid Baghdad manuscripts to Mamluk enameled glass, Alhambra <em>Zellij</em>, Timurid/Safavid miniatures,
        Ottoman <em>Nakkashane</em> topography, and 21st-century Sovereign AI Cyber-Geometry.
      </p>
    </section>

    <section class="canvas-box">
      <canvas id="eraCanvas"></canvas>
      <div class="hud-top">
        <div id="hudEra" style="font-family:Consolas,monospace;font-size:0.75rem;color:#FDE68A;">ERA I (PRE-610 CE): BABIL &amp; SABA' LAPIS-LAZULI RELIEF &amp; INVERTED WELL</div>
        <div id="hudTitle" style="font-size:1rem;font-weight:700;margin:0.2rem 0;">8-Pointed Star of Babil | Subterranean Well | Alabaster Musnad Altar</div>
        <div id="hudDesc" style="font-size:0.8rem;color:#CBD5E1;">Kiln-fired Babylonian lapis blue (#0F2C59), Sabaean alabaster (#F8F5E6), and hammered gold (#D4AF37) rendering the Inverted Well of Harut &amp; Marut severed by the Criterion of Qur'an 2:102.</div>
      </div>
      <div class="mode-bar">
        <button class="mode-btn active" onclick="setEra(1, this)">Era I: Babil &amp; Saba' (8-Fold)</button>
        <button class="mode-btn" onclick="setEra(2, this)">Era II: Abbasid Baghdad (10-Fold Kufic)</button>
        <button class="mode-btn" onclick="setEra(3, this)">Era III: Mamluk Mishkat (12-Fold Ablaq)</button>
        <button class="mode-btn" onclick="setEra(4, this)">Era IV: Alhambra Zellij (16-Fold Chahar Bagh)</button>
        <button class="mode-btn" onclick="setEra(5, this)">Era V: Persian Miniature (7-Tiered Keep)</button>
        <button class="mode-btn" onclick="setEra(6, this)">Era VI: Ottoman Iznik (9-Fold Gul-i Muhammadi)</button>
        <button class="mode-btn" onclick="setEra(7, this)">Era VII: Sovereign AI Cyber-Geometry</button>
      </div>
    </section>

    <h2 style="font-size:1.35rem;margin-bottom:1.1rem;color:#38BDF8;">
      AI-Generated Islamic Historical Visual Plates (Eras I–VII)
    </h2>
    <section class="ai-gallery-grid">
      <div class="ai-plate-card">
        <img src="era1-abbasid-qumqum.jpg" alt="Era I &amp; II: Abbasid Baghdad Bayt al-Hikmah Manuscript &amp; Sealed Qumqum">
        <div class="ai-plate-body">
          <h3>Plate I (Eras I–II): Abbasid Baghdad <em>Bayt al-Ḥikmah</em> &amp; Sealed Brass <em>Qumqum</em></h3>
          <p style="color:#CBD5E1;">Illuminated in the style of Yaḥyā ibn Maḥmūd al-Wāsiṭī and the Kairouan <em>Blue Qur'an</em> (chrysography gold Kufic on deep indigo vellum): an ascetic scholar-mystic inside a domed brass observatory with astrolabes, 10-fold star geometry, and the lead-stoppered Solomonic <em>Qumqum</em> vessel.</p>
        </div>
      </div>
      <div class="ai-plate-card" style="border-top-color:#F43F5E;">
        <img src="era2-andalusian-mamluk.jpg" alt="Era III &amp; IV: Mamluk Mishkat Lamp &amp; Andalusian Alhambra Zellij Rose Courtyard">
        <div class="ai-plate-body">
          <h3>Plate II (Eras III–IV): Mamluk <em>Mishkāt</em> Lamp &amp; Alhambra <em>Zellīj</em> Rose Sanctuary</h3>
          <p style="color:#CBD5E1;">Carved stucco <em>Muqarnas</em> vaults and 16-fold Nasrid crystallographic <em>Zellīj</em> tilework framing an enameled Mamluk glass mosque lamp (<em>Āyat an-Nūr</em>, Qur'an 24:35) suspended above a quadripartite <em>Chahār Bāgh</em> reflecting pool and blooming Damascus roses.</p>
        </div>
      </div>
      <div class="ai-plate-card" style="border-top-color:#C084FC;">
        <img src="era3-timurid-priory.jpg" alt="Era V &amp; VI: Timurid/Safavid Persian Miniature &amp; Ottoman Iznik 7-Tiered Priory Tower">
        <div class="ai-plate-body">
          <h3>Plate III (Eras V–VI): Timurid/Safavid Miniature &amp; Ottoman <em>Iznik</em> Priory Keep</h3>
          <p style="color:#CBD5E1;">Rendered in crushed Badakhshan lapis lazuli, 24k burnished gold leaf, turquoise <em>Firuze</em> glazes, and bole-red <em>Saz</em> roses: the 7-tiered Negentropic Priory Tower rising at the Junction of the Two Seas (<em>Majma' al-Baḥrayn</em>, Qur'an 18:60–82).</p>
        </div>
      </div>
      <div class="ai-plate-card" style="border-top-color:#34D399;">
        <img src="era4-neoislamic-cyber.jpg" alt="Era VII: Sovereign Neo-Islamic AI Cyber-Geometric Sanctum">
        <div class="ai-plate-body">
          <h3>Plate IV (Era VII): Sovereign Neo-Islamic AI Cyber-Geometric Sanctum</h3>
          <p style="color:#CBD5E1;">21st-century parametric volumetric <em>Muqarnas</em> fractals, glowing Kufic light-geometry, and a decagonal Penrose-<em>Girih</em> quasicrystal Faraday dome shielding the tranquil emerald garden in State <code>S_0</code> (<code>C_p = 1.98</code>, <code>ΔH = 0.000 bits</code>).</p>
        </div>
      </div>
    </section>

    <h2 style="font-size:1.35rem;margin-bottom:1.1rem;color:#FDE68A;">
      The 7 Historical Eras of Islamic Visual Style &amp; Sacred Geometry Dossiers
    </h2>
    %s
  </main>

  <script>
    let currentEra = 1;
    const canvas = document.getElementById('eraCanvas');
    const ctx = canvas.getContext('2d');
    let yaw = 0.4, pitch = 0.38, zoom = 1.0, dragging = false, lx = 0, ly = 0;

    const eraMeta = {
      1: {
        tag: "ERA I (PRE-610 CE): BABIL & SABA' LAPIS-LAZULI RELIEF & INVERTED WELL",
        title: "8-Pointed Star of Babil | Subterranean Well | Alabaster Musnad Altar",
        desc: "Kiln-fired Babylonian lapis blue (#0F2C59), Sabaean alabaster (#F8F5E6), and hammered gold (#D4AF37) rendering the Inverted Well of Harut & Marut severed by the Criterion of Qur'an 2:102.",
        fold: 8, c1: "#D4AF37", c2: "#38BDF8", c3: "#F8F5E6"
      },
      2: {
        tag: "ERA II (661–1050 CE): ABBASID BAGHDAD BAYT AL-HIKMAH & BLUE QUR'AN KUFIC",
        title: "10-Fold Decagonal Kufic Rosette | Brass Astrolabe | Sealed Qumqum",
        desc: "Chrysography gold ink (#FBBF24) on deep indigo vellum (#0B1938) with verdigris emerald (#006B54) and Al-Wasiti astronomical armillary spheres.",
        fold: 10, c1: "#FBBF24", c2: "#10B981", c3: "#EF4444"
      },
      3: {
        tag: "ERA III (969–1517 CE): MAMLUK CAIRO ABLAQ MASONRY & ENAMELED MISHKAT LAMP",
        title: "12-Pointed Tabaq Najmi | Muqarnas Vault | Ayat An-Nur Mosque Lamp",
        desc: "Alternating crimson (#8B0000), cream (#F8F5E6), and Damascus inlaid brass (#B87333) framing the hanging Mishkat lamp of Qur'an 24:35.",
        fold: 12, c1: "#F8F5E6", c2: "#F43F5E", c3: "#38BDF8"
      },
      4: {
        tag: "ERA IV (711–1492 CE): ANDALUSIAN ALHAMBRA ZELLIJ & GENERALIFE CHAHAR BAGH",
        title: "16-Fold Crystallographic Zellij | 4 Rivers of Qur'an 47:15 | Walled Mihrab",
        desc: "Nasrid emerald-teal (#006B54), ochre (#D97706), ivory (#F8F5E6), and Damascus rose (#F43F5E) in perfect 16-fold rotational symmetry.",
        fold: 16, c1: "#34D399", c2: "#F59E0B", c3: "#F43F5E"
      },
      5: {
        tag: "ERA V (1370–1722 CE): TIMURID & SAFAVID PERSIAN MINIATURE (BEHZAD / TABRIZ)",
        title: "7-Tiered Isometric Keep at Majma' Al-Bahrayn | Burnished Gold Sky",
        desc: "Crushed Badakhshan lapis (#1E40AF), 24k gold leaf (#FACC15), and turquoise (#06B6D4) rendering the 7-story keep between the Two Seas.",
        fold: 7, c1: "#FACC15", c2: "#06B6D4", c3: "#10B981"
      },
      6: {
        tag: "ERA VI (1453–1922 CE): OTTOMAN IMPERIAL NAKKASHANE, MATRAKCI NASUH & IZNIK",
        title: "9-Fold Gul-i Muhammadi | Topographical Keep | Iznik Bole-Red & Cobalt",
        desc: "Iznik coral-red (#E11D48), cobalt (#1D4ED8), and firuze turquoise (#14B8A6) mapping the sovereign estate and concentric Muhammadan Rose.",
        fold: 9, c1: "#FB7185", c2: "#2DD4BF", c3: "#FDE68A"
      },
      7: {
        tag: "ERA VII (21ST CENTURY): SOVEREIGN NEO-ISLAMIC AI CYBER-GEOMETRIC SYNTHESIS",
        title: "10-Fold Penrose-Girih Quasicrystal | Volumetric Muqarnas | Faraday Shield",
        desc: "Bioluminescent emerald (#34D399), Faraday gold (#FDE68A), and cyber-sapphire (#38BDF8) uniting all 46 portals in an air-gapped quasicrystalline dome.",
        fold: 10, c1: "#34D399", c2: "#38BDF8", c3: "#FDE68A"
      }
    };

    function setEra(idx, btn) {
      currentEra = idx;
      document.querySelectorAll('.mode-btn').forEach(b => b.classList.remove('active'));
      btn.classList.add('active');
      const m = eraMeta[idx];
      document.getElementById('hudEra').textContent = m.tag;
      document.getElementById('hudTitle').textContent = m.title;
      document.getElementById('hudDesc').textContent = m.desc;
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
      const fov = 560 / (560 + z2);
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

      const m = eraMeta[currentEra];
      const n = m.fold;
      const tiers = currentEra === 5 ? 7 : 5;

      // Render 3D N-Fold Islamic Star Girih Sanctuary Tower & Muqarnas Dome for the selected Era
      for (let tier = 0; tier < tiers; tier++) {
        const y1 = -110 + tier * 42;
        const y2 = y1 + 38;
        const rOuter = 135 - tier * 16;
        const rInner = rOuter * 0.58;
        for (let i = 0; i < n; i++) {
          const a1 = (i / n) * Math.PI * 2 + tier * 0.15;
          const aMid = ((i + 0.5) / n) * Math.PI * 2 + tier * 0.15;
          const a2 = ((i + 1) / n) * Math.PI * 2 + tier * 0.15;

          const pOuter1 = [Math.cos(a1) * rOuter, y1, Math.sin(a1) * rOuter];
          const pInner = [Math.cos(aMid) * rInner, y1 + 19, Math.sin(aMid) * rInner];
          const pOuter2 = [Math.cos(a2) * rOuter, y1, Math.sin(a2) * rOuter];
          const pTop = [Math.cos(a1) * (rOuter * 0.88), y2, Math.sin(a1) * (rOuter * 0.88)];

          line3D(pOuter1, pInner, cx, cy, zoom, m.c1, 2.0, 0.9);
          line3D(pInner, pOuter2, cx, cy, zoom, m.c1, 2.0, 0.9);
          line3D(pOuter1, pTop, cx, cy, zoom, m.c2, 1.6, 0.82);
        }
      }

      // Crown Spire / Finial (Hilal / Mishkat / Quasicrystal Apex)
      const apexY = -110 + tiers * 42 + 45;
      for (let i = 0; i < n; i++) {
        const a = (i / n) * Math.PI * 2 + t * 0.5;
        line3D([Math.cos(a) * 45, apexY - 45, Math.sin(a) * 45], [0, apexY, 0], cx, cy, zoom, m.c3, 2.1, 0.92);
      }

      requestAnimationFrame(loop);
    }
    requestAnimationFrame(loop);
  </script>
</body>
</html>
""".formatted(eraCards.toString());
    }

    private static String buildEraSvgArtPlate(
            int eraIndex,
            int fold,
            String c0,
            String c1,
            String c2,
            String c3,
            String arabicTitle) {
        StringBuilder starLines = new StringBuilder();
        double cx = 140.0;
        double cy = 125.0;
        double rOuter = 82.0;
        double rInner = 42.0;

        for (int i = 0; i < fold; i++) {
            double a1 = (i * 2.0 * Math.PI) / fold - Math.PI / 2.0;
            double aMid = ((i + 0.5) * 2.0 * Math.PI) / fold - Math.PI / 2.0;
            double a2 = ((i + 1.0) * 2.0 * Math.PI) / fold - Math.PI / 2.0;

            double x1 = cx + Math.cos(a1) * rOuter;
            double y1 = cy + Math.sin(a1) * rOuter;
            double xm = cx + Math.cos(aMid) * rInner;
            double ym = cy + Math.sin(aMid) * rInner;
            double x2 = cx + Math.cos(a2) * rOuter;
            double y2 = cy + Math.sin(a2) * rOuter;

            starLines.append(String.format(
                    "<line x1=\"%.1f\" y1=\"%.1f\" x2=\"%.1f\" y2=\"%.1f\" stroke=\"%s\" stroke-width=\"2.2\" />",
                    x1, y1, xm, ym, c1
            ));
            starLines.append(String.format(
                    "<line x1=\"%.1f\" y1=\"%.1f\" x2=\"%.1f\" y2=\"%.1f\" stroke=\"%s\" stroke-width=\"2.2\" />",
                    xm, ym, x2, y2, c1
            ));
            starLines.append(String.format(
                    "<line x1=\"%.1f\" y1=\"%.1f\" x2=\"%.1f\" y2=\"%.1f\" stroke=\"%s\" stroke-width=\"1.2\" stroke-opacity=\"0.65\" />",
                    cx, cy, x1, y1, c2
            ));
        }

        return String.format("""
                <svg viewBox="0 0 280 260" width="100%%" height="230" xmlns="http://www.w3.org/2000/svg" style="border-radius:8px;border:1px solid rgba(255,255,255,0.15);">
                  <defs>
                    <radialGradient id="bgGrad%d" cx="50%%" cy="48%%" r="65%%">
                      <stop offset="0%%" stop-color="%s" stop-opacity="0.95"/>
                      <stop offset="100%%" stop-color="#05070D" stop-opacity="1"/>
                    </radialGradient>
                  </defs>
                  <rect width="280" height="260" fill="url(#bgGrad%d)"/>
                  <rect x="8" y="8" width="264" height="244" fill="none" stroke="%s" stroke-width="1.5" stroke-opacity="0.7"/>
                  <path d="M 38 242 L 38 115 Q 140 24 242 115 L 242 242" fill="none" stroke="%s" stroke-width="2" stroke-opacity="0.8"/>
                  <circle cx="140" cy="125" r="86" fill="none" stroke="%s" stroke-width="1.2" stroke-dasharray="4 3"/>
                  <circle cx="140" cy="125" r="42" fill="none" stroke="%s" stroke-width="1.4"/>
                  %s
                  <circle cx="140" cy="125" r="9" fill="%s"/>
                  <text x="140" y="232" fill="#FDE68A" font-size="10" font-family="Segoe UI, sans-serif" text-anchor="middle" font-weight="700">ERA %d • %d-FOLD GIRIH SANCTUM</text>
                </svg>
                """,
                eraIndex, c0, eraIndex, c1, c2, c3, c1, starLines.toString(), c1, eraIndex, fold
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
