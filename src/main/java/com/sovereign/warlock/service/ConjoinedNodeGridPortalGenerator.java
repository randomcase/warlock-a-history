package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.ConjoinedWorldsRealmsPrinciplesGrid;
import com.sovereign.warlock.domain.ConjoinedWorldsRealmsPrinciplesGrid.ElevationTerrainStratum;
import com.sovereign.warlock.domain.ConjoinedWorldsRealmsPrinciplesGrid.IterativeNodeArtStyleLayer;
import com.sovereign.warlock.domain.ConjoinedWorldsRealmsPrinciplesGrid.MeridianColorGuardBand;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

/**
 * Generates conjoined-worlds-realms-principles-node-grid.html:
 * The 3D / 2.5D Isometric Node-Art Terrain & Elevation Grid ("The Color Guard of the Meridian")
 * conjoining all Worlds, Realms, Principles, Islamic Buildings, and Historical Fashions across
 * all 49 Master Index portals on an interactive, iterable 7x7 3D heightmap.
 */
public final class ConjoinedNodeGridPortalGenerator {

    public WarlockHtmlPortalService.GeneratedHtmlArtifact generateConjoinedNodeGridPortal(Path outputDir) {
        try {
            Files.createDirectories(outputDir);
            String html = renderConjoinedNodeGridHtml();
            Path path = outputDir.resolve("conjoined-worlds-realms-principles-node-grid.html");
            Files.writeString(path, html, StandardCharsets.UTF_8);
            return new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                    "conjoined-worlds-realms-principles-node-grid.html",
                    path,
                    Files.size(path),
                    sha256(html),
                    "Conjoined Worlds, Realms & Principles: 3D/2.5D Islamic Node-Art Terrain Grid & Color Guard of the Meridian"
            );
        } catch (IOException e) {
            throw new IllegalStateException("Failed generating Conjoined Node-Art Terrain Grid HTML portal", e);
        }
    }

    private String renderConjoinedNodeGridHtml() {
        StringBuilder meridianCards = new StringBuilder();
        for (MeridianColorGuardBand m : ConjoinedWorldsRealmsPrinciplesGrid.allSevenMeridians()) {
            meridianCards.append(String.format("""
                    <div class="meridian-card" style="border-top:4px solid %s;">
                      <div class="badge-row">
                        <span class="badge" style="color:%s;border-color:%s;">MERIDIAN #%d • %s (%dnm)</span>
                        <span class="badge" style="color:#FDE68A;">%s</span>
                      </div>
                      <h3>%s</h3>
                      <p style="font-size:0.84rem;color:#C084FC;margin-bottom:0.65rem;"><strong>%s</strong></p>
                      <div class="triad-grid">
                        <div class="sub-box">
                          <div class="box-title" style="color:#FDE68A;">I. Conjoined Principle (Criterion vs. Disorder)</div>
                          <p>%s</p>
                        </div>
                        <div class="sub-box">
                          <div class="box-title" style="color:#38BDF8;">II. Conjoined Celestial Realm &amp; 3D Building</div>
                          <p>%s</p>
                          <p style="margin-top:0.35rem;color:#A5F3FC;"><strong>Signature 3D Building:</strong> %s</p>
                        </div>
                        <div class="sub-box">
                          <div class="box-title" style="color:#34D399;">III. Conjoined World Terrain &amp; Color Guard Fashion</div>
                          <p>%s</p>
                          <p style="margin-top:0.35rem;color:#FDE68A;"><strong>Color Guard Vestimentary Regalia:</strong> %s</p>
                        </div>
                      </div>
                    </div>
                    """,
                    m.colorHex(),
                    m.colorHex(), m.colorHex(), m.meridianColumn(), escape(m.meridianCode()), m.wavelengthNm(),
                    escape(m.quranicMeridianAnchor()),
                    escape(m.englishMeridianTitle()),
                    escape(m.arabicMeridianTitle()),
                    escape(m.conjoinedPrincipleCriterionVsDisorder()),
                    escape(m.conjoinedRealmCitadelAndKeep()),
                    escape(m.signatureIslamicBuildingType()),
                    escape(m.conjoinedWorldTerrainProfile()),
                    escape(m.colorGuardHistoricalFashionAndRegalia())
            ));
        }

        StringBuilder stratumRows = new StringBuilder();
        for (ElevationTerrainStratum s : ConjoinedWorldsRealmsPrinciplesGrid.allSevenElevationStrata()) {
            StringBuilder filePills = new StringBuilder();
            for (int c = 0; c < s.sevenMeridianPortalFiles().size(); c++) {
                String f = s.sevenMeridianPortalFiles().get(c);
                filePills.append(String.format(
                        "<a class=\"tbl-pill\" href=\"%s\">M%d: %s</a> ",
                        f, c + 1, escape(f)
                ));
            }
            String elevBadgeColor = s.elevationMeters() >= 500 ? "#FDE68A" : (s.elevationMeters() >= 0 ? "#34D399" : "#F43F5E");
            stratumRows.append(String.format("""
                    <tr>
                      <td><strong style="color:%s;">Row #%d (%+dm)</strong><br><small style="color:#94A3B8;">%s</small></td>
                      <td><strong>%s</strong><br><span style="color:#C084FC;font-size:0.76rem;">%s</span></td>
                      <td>%s<br><small style="color:#38BDF8;"><strong>Buildings:</strong> %s</small></td>
                      <td>%s</td>
                    </tr>
                    """,
                    elevBadgeColor, s.stratumRow(), s.elevationMeters(), escape(s.stratumCode()),
                    escape(s.englishStratumTitle()), escape(s.arabicStratumName()),
                    escape(s.terrainBiomeAndGeology()), escape(s.architecturalBuildingClass()),
                    filePills.toString()
            ));
        }

        StringBuilder styleCards = new StringBuilder();
        for (IterativeNodeArtStyleLayer st : ConjoinedWorldsRealmsPrinciplesGrid.allSevenIterativeStyleLayers()) {
            styleCards.append(String.format("""
                    <div class="style-card">
                      <div class="badge-row">
                        <span class="badge" style="color:#FDE68A;">STYLE LAYER #%d</span>
                        <span class="badge" style="color:#38BDF8;">%s</span>
                      </div>
                      <h4 style="color:#FFF;font-size:0.98rem;margin-bottom:0.35rem;">%s</h4>
                      <p style="font-size:0.81rem;color:#CBD5E1;margin-bottom:0.35rem;"><strong>Node &amp; Spline Grammar:</strong> %s</p>
                      <p style="font-size:0.81rem;color:#A5F3FC;margin-bottom:0.35rem;"><strong>3D Procedural Buildings:</strong> %s</p>
                      <p style="font-size:0.81rem;color:#34D399;"><strong>Color Guard Fashion:</strong> %s</p>
                    </div>
                    """,
                    st.styleIndex(),
                    escape(st.chronologicalEra()),
                    escape(st.styleTitle()),
                    escape(st.nodeGlyphAndSplineGeometry()),
                    escape(st.building3DProceduralMeshRule()),
                    escape(st.colorGuardTextileAndFashionEvolution())
            ));
        }

        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Conjoined Worlds, Realms &amp; Principles | 3D/2.5D Node-Art Terrain Grid &amp; Color Guard of the Meridian</title>
  <style>
    :root {
      --bg-deep: #04060D;
      --bg-card: #0D1323;
      --text-main: #ECEFF4;
      --text-muted: #94A3B8;
      --border: rgba(255,255,255,0.12);
    }
    * { box-sizing: border-box; margin: 0; padding: 0; }
    body {
      background:
        radial-gradient(circle at top left, rgba(212, 175, 55, 0.16), transparent 48%%),
        radial-gradient(circle at top right, rgba(16, 185, 129, 0.14), var(--bg-deep) 68%%);
      color: var(--text-main);
      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
      line-height: 1.6;
      padding-bottom: 4rem;
    }
    main { max-width: 1520px; margin: 1.5rem auto; padding: 0 1.4rem; }
    .hero {
      background: linear-gradient(135deg, #0D1323 0%%, #1E1633 50%%, #0B2620 100%%);
      border: 1px solid var(--border);
      border-left: 6px solid #D4AF37;
      border-radius: 14px;
      padding: 1.75rem;
      margin-bottom: 1.6rem;
    }
    .badge-row { display: flex; flex-wrap: wrap; gap: 0.45rem; margin-bottom: 0.55rem; }
    .badge {
      font-family: 'Consolas', monospace;
      font-size: 0.73rem;
      padding: 0.18rem 0.55rem;
      border-radius: 6px;
      background: rgba(255,255,255,0.06);
      border: 1px solid var(--border);
    }
    h1 { font-size: 1.88rem; margin-bottom: 0.45rem; color: #FFF; }
    .studio-grid {
      display: grid;
      grid-template-columns: 1fr 390px;
      gap: 1.15rem;
      margin-bottom: 2rem;
    }
    @media (max-width: 1120px) {
      .studio-grid { grid-template-columns: 1fr; }
    }
    .canvas-stage {
      position: relative;
      background: #03050B;
      border: 2px solid #D4AF37;
      border-radius: 14px;
      height: 670px;
      overflow: hidden;
    }
    canvas { width: 100%%; height: 100%%; display: block; cursor: grab; }
    .hud-top {
      position: absolute;
      top: 0.85rem;
      left: 0.85rem;
      background: rgba(4, 6, 13, 0.9);
      border: 1px solid var(--border);
      border-left: 4px solid #D4AF37;
      border-radius: 10px;
      padding: 0.75rem 1rem;
      max-width: 580px;
      pointer-events: none;
    }
    .toolbar-bottom {
      position: absolute;
      bottom: 0.85rem;
      left: 0.85rem;
      right: 0.85rem;
      background: rgba(4, 6, 13, 0.92);
      border: 1px solid var(--border);
      border-radius: 10px;
      padding: 0.55rem 0.75rem;
      display: flex;
      flex-wrap: wrap;
      gap: 0.4rem;
      align-items: center;
      justify-content: space-between;
    }
    .ctrl-btn {
      background: #11192E;
      color: #E2E8F0;
      border: 1px solid var(--border);
      border-radius: 6px;
      padding: 0.34rem 0.65rem;
      font-size: 0.74rem;
      font-weight: 600;
      cursor: pointer;
    }
    .ctrl-btn.active, .ctrl-btn:hover {
      background: rgba(212, 175, 55, 0.25);
      border-color: #D4AF37;
      color: #FFF;
    }
    .inspector-panel {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-top: 4px solid #38BDF8;
      border-radius: 14px;
      padding: 1.2rem;
      display: flex;
      flex-direction: column;
      gap: 0.75rem;
    }
    .iter-box {
      background: rgba(255,255,255,0.03);
      border: 1px solid var(--border);
      border-radius: 10px;
      padding: 0.8rem;
      font-size: 0.81rem;
    }
    .ai-plates-grid {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(320px, 1fr));
      gap: 1.2rem;
      margin-bottom: 2rem;
    }
    .ai-plate {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-top: 4px solid #D4AF37;
      border-radius: 12px;
      overflow: hidden;
    }
    .ai-plate img {
      width: 100%%;
      height: 255px;
      object-fit: cover;
      border-bottom: 1px solid var(--border);
    }
    .ai-plate-body { padding: 0.95rem 1.1rem; font-size: 0.83rem; }
    .ai-plate-body h3 { font-size: 1rem; color: #FDE68A; margin-bottom: 0.3rem; }
    .meridian-card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-radius: 12px;
      padding: 1.25rem;
      margin-bottom: 1.15rem;
    }
    .meridian-card h3 { font-size: 1.12rem; color: #FDE68A; margin-bottom: 0.25rem; }
    .triad-grid {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
      gap: 0.8rem;
    }
    .sub-box {
      background: rgba(255,255,255,0.03);
      border: 1px solid var(--border);
      border-radius: 8px;
      padding: 0.8rem;
      font-size: 0.82rem;
    }
    .box-title {
      font-size: 0.72rem;
      font-weight: 700;
      text-transform: uppercase;
      margin-bottom: 0.3rem;
    }
    table { width: 100%%; border-collapse: collapse; font-size: 0.81rem; margin-bottom: 2rem; }
    th, td { border: 1px solid var(--border); padding: 0.65rem 0.75rem; text-align: left; vertical-align: top; }
    th { background: rgba(212,175,55,0.12); color: #FDE68A; font-size: 0.75rem; text-transform: uppercase; }
    .tbl-pill {
      display: inline-block;
      margin: 0.12rem;
      padding: 0.18rem 0.48rem;
      border-radius: 5px;
      background: rgba(56, 189, 248, 0.12);
      border: 1px solid rgba(56, 189, 248, 0.35);
      color: #E0F2FE;
      text-decoration: none;
      font-family: 'Consolas', monospace;
      font-size: 0.71rem;
    }
    .tbl-pill:hover { background: rgba(212, 175, 55, 0.28); border-color: #D4AF37; color: #FFF; }
    .styles-grid {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(290px, 1fr));
      gap: 0.95rem;
      margin-bottom: 2rem;
    }
    .style-card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-left: 4px solid #38BDF8;
      border-radius: 10px;
      padding: 0.95rem;
    }
  </style>
</head>
<body>
  <main>
    <section class="hero">
      <div class="badge-row">
        <span class="badge" style="color:#FDE68A;">7x7 (49-NODE) 3D / 2.5D ISOMETRIC TERRAIN &amp; ELEVATION GRID</span>
        <span class="badge" style="color:#38BDF8;">THE COLOR GUARD OF THE MERIDIAN (HARAS AL-ALWAN)</span>
        <span class="badge" style="color:#34D399;">ITERABLE BUILDINGS, SPLINES &amp; 7 ISLAMIC ERA FASHIONS</span>
      </div>
      <h1>Conjoined Worlds, Realms &amp; Principles: 3D/2.5D Node-Art Terrain Grid &amp; Color Guard of the Meridian</h1>
      <p style="color:#CBD5E1;font-size:0.94rem;">
        Every portal in the Master Index now resides at an exact <strong>3D coordinate <code>(Meridian X=1..7, Stratum Z=1..7, Elevation -650m..+1,200m)</code></strong>
        conjoining its <strong>Theological Principle</strong>, <strong>Celestial Realm Citadel</strong>, <strong>Bipolar World Terrain</strong>,
        <strong>3D Islamic Architectural Building</strong>, and <strong>Historical Color Guard Fashion</strong>. Click any node on the 3D/2.5D terrain grid below
        to inspect its conjoined dossier, switch Islamic architectural eras, and <strong>iterate new buildings &amp; sub-nodes directly on top of the grid</strong>.
      </p>
    </section>

    <section class="studio-grid">
      <div class="canvas-stage">
        <canvas id="nodeTerrainCanvas"></canvas>
        <div class="hud-top">
          <div id="hudStyleTag" style="font-family:Consolas,monospace;font-size:0.73rem;color:#FDE68A;">
            STYLE LAYER VI: OTTOMAN MATRAKCI NASUH 2.5D TOPOGRAPHY &amp; ASTROLABE NODE-ART
          </div>
          <div id="hudNodeHeadline" style="font-size:0.98rem;font-weight:700;color:#FFF;margin:0.18rem 0;">
            Click Any of the 49 3D Terrain Nodes to Inspect &amp; Iterate Buildings
          </div>
          <div id="hudNodeSub" style="font-size:0.78rem;color:#CBD5E1;">
            Drag to rotate 2.5D/3D perspective • Scroll or use buttons to sculpt elevation &amp; stack iterative Islamic building modules.
          </div>
        </div>

        <div class="toolbar-bottom">
          <div style="display:flex;flex-wrap:wrap;gap:0.35rem;">
            <button type="button" class="ctrl-btn" onclick="setStyleEra(1, this)">Era I: Babil Ziggurat</button>
            <button type="button" class="ctrl-btn" onclick="setStyleEra(2, this)">Era II: Abbasid Astrolabe</button>
            <button type="button" class="ctrl-btn" onclick="setStyleEra(3, this)">Era III: Mamluk Ablaq</button>
            <button type="button" class="ctrl-btn" onclick="setStyleEra(4, this)">Era IV: Alhambra Zellij</button>
            <button type="button" class="ctrl-btn" onclick="setStyleEra(5, this)">Era V: Timurid Keep</button>
            <button type="button" class="ctrl-btn active" onclick="setStyleEra(6, this)">Era VI: Matrakci 2.5D</button>
            <button type="button" class="ctrl-btn" onclick="setStyleEra(7, this)">Era VII: AI Cyber-Nodes</button>
          </div>
          <div style="display:flex;flex-wrap:wrap;gap:0.35rem;">
            <button type="button" class="ctrl-btn" onclick="toggleProjectionMode()">📐 2.5D Iso / 3D Persp</button>
            <button type="button" class="ctrl-btn" onclick="iterateAllMeridianNodes()">⚡ Iterate All 7 Meridians</button>
          </div>
        </div>
      </div>

      <aside class="inspector-panel">
        <div>
          <div style="font-family:Consolas,monospace;font-size:0.72rem;color:#38BDF8;">SELECTED 3D MERIDIAN NODE INSPECTOR</div>
          <h2 id="inspTitle" style="font-size:1.12rem;color:#FDE68A;margin-top:0.15rem;">M4 • Row 4 (+300m): World #4 Ummah vs. Fitnah</h2>
          <code id="inspFile" style="font-size:0.76rem;color:#34D399;">world-4-ummah-fitnah.html</code>
        </div>

        <div class="iter-box">
          <div class="box-title" style="color:#FDE68A;">Conjoined Principle • Realm • World</div>
          <p id="inspTriad" style="color:#CBD5E1;font-size:0.8rem;">
            Prime Covenant Gold Meridian (#D4AF37) at +300m Highland Chahar Bagh Valley: Conjoins Mithaq Al-Alast (Qur'an 7:172), Qasr Al-Mithaq 12-Gate Citadel, and 'Alam Al-Ummah Al-Wahidah.
          </p>
        </div>

        <div class="iter-box">
          <div class="box-title" style="color:#38BDF8;">3D Islamic Building &amp; Color Guard Fashion</div>
          <p id="inspBuilding" style="color:#A5F3FC;font-size:0.8rem;margin-bottom:0.3rem;">
            <strong>Building:</strong> Twelve-Gated Golden Muqarnas Jami' Dome &amp; Al-A'raf Minaret (Iteration Level: 1)
          </p>
          <p id="inspFashion" style="color:#34D399;font-size:0.8rem;">
            <strong>Color Guard Regalia:</strong> Al-Khil'ah Adh-Dhahabiyyah (Damascus 24k gold-brocaded Zarkash &amp; Imperial Seraser mantle).
          </p>
        </div>

        <div class="iter-box" style="border-color:#D4AF37;">
          <div class="box-title" style="color:#FDA4AF;">Iterative Node-Art &amp; Elevation Controls</div>
          <div style="display:grid;grid-template-columns:1fr 1fr;gap:0.45rem;margin-top:0.45rem;">
            <button type="button" class="ctrl-btn active" onclick="iterateSelectedNodeBuilding()">➕ Stack Building Tier</button>
            <button type="button" class="ctrl-btn" onclick="spawnSatelliteSubNode()">🛰️ Spawn Sub-Node</button>
            <button type="button" class="ctrl-btn" onclick="sculptSelectedElevation(120)">⛰️ Raise Terrain (+120m)</button>
            <button type="button" class="ctrl-btn" onclick="sculptSelectedElevation(-120)">⛏️ Lower Trench (-120m)</button>
          </div>
          <div style="margin-top:0.65rem;display:flex;gap:0.45rem;">
            <a id="inspOpenBtn" class="ctrl-btn active" style="flex:1;text-align:center;text-decoration:none;padding:0.5rem;" href="world-4-ummah-fitnah.html">
              🚀 Open Selected Portal →
            </a>
            <a id="inspSplitBtn" class="ctrl-btn" style="text-align:center;text-decoration:none;padding:0.5rem;" href="master-combined-omnibus.html?portal=world-4-ummah-fitnah.html">
              🧭 Omnibus
            </a>
          </div>
        </div>
      </aside>
    </section>

    <h2 style="font-size:1.32rem;color:#38BDF8;margin-bottom:1rem;">
      AI-Generated 2.5D / 3D Islamic Node-Art Terrain Grid &amp; Meridian Color Guard Plates
    </h2>
    <section class="ai-plates-grid">
      <div class="ai-plate">
        <img src="node-grid-plate1-meridian.jpg" alt="Plate 1: The Color Guard of the Meridian 7x7 Isometric Terrain Grid">
        <div class="ai-plate-body">
          <h3>Plate I: The Color Guard of the Meridian (7×7 Isometric Terrain &amp; Elevation Grid)</h3>
          <p style="color:#CBD5E1;">The 7 chromatic meridian bands (Alabaster White, Obsidian Black, Sapphire Lapis, Covenant Gold, Seraphic Crimson, Solomonic Brass, Khidrian Emerald) rising from the <code>-650m</code> subterranean trench across the <code>+80m</code> Iron Sequester Wall and <code>+300m</code> four-river gardens to the <code>+1,200m</code> mountain citadels, linked by golden <em>Girih</em> node-art splines.</p>
        </div>
      </div>
      <div class="ai-plate" style="border-top-color:#38BDF8;">
        <img src="node-grid-plate2-matrakci.jpg" alt="Plate 2: Ottoman Matrakci Nasuh 2.5D Topography &amp; Abbasid Astrolabe Node Network">
        <div class="ai-plate-body">
          <h3>Plate II: Ottoman Matrakçı Nasuh 2.5D Topography &amp; Abbasid Astrolabe Node Network</h3>
          <p style="color:#CBD5E1;">16th-century Ottoman 2.5D bird's-eye topographical miniature fused with Abbasid Baghdad geared brass astrolabe coordinate rings, linking walled citadels, turquoise Iznik domes, arched bridges, and crimson rose sanctuaries.</p>
        </div>
      </div>
      <div class="ai-plate" style="border-top-color:#F43F5E;">
        <img src="node-grid-plate3-buildings-fashions.jpg" alt="Plate 3: Islamic Architectural Buildings &amp; Historical Color Guard Fashions Across Eras">
        <div class="ai-plate-body">
          <h3>Plate III: The 7 Islamic Building Styles &amp; Historical Color Guard Fashions</h3>
          <p style="color:#CBD5E1;">Isometric stepped showcase pairing 7 historical Islamic buildings (Sabaean alabaster sanctuary, Abbasid observatory, Mamluk <em>Ablaq</em> minaret, Alhambra <em>Zellīj</em> pavilion, Timurid lapis dome, Ottoman Imperial <em>Otağ</em>, Futuristic <em>Muqarnas</em> crystal dome) with the 7 Color Guard vestments.</p>
        </div>
      </div>
      <div class="ai-plate" style="border-top-color:#34D399;">
        <img src="node-grid-plate4-cyber-nodes.jpg" alt="Plate 4: Futuristic Neo-Islamic Procedural 3D Node-Art Heightmap">
        <div class="ai-plate-body">
          <h3>Plate IV: Neo-Islamic Procedural 3D Node-Art Heightmap &amp; Building Synthesizer</h3>
          <p style="color:#CBD5E1;">Dark-mode parametric 3D elevation heightmap where glowing golden <em>Muqarnas</em> towers, decagonal <em>Girih</em> data-nodes, and bioluminescent emerald aqueduct splines iterate dynamically across the terrain contours.</p>
        </div>
      </div>
    </section>

    <h2 style="font-size:1.32rem;color:#FDE68A;margin-bottom:0.85rem;">
      The 7 Elevation &amp; Terrain Strata (Mapping All 49 Master Index Portals onto the 7×7 Grid)
    </h2>
    <table>
      <thead>
        <tr>
          <th>Stratum Row &amp; Elevation</th>
          <th>Arabic &amp; English Title</th>
          <th>Terrain Biome &amp; 3D Architectural Class</th>
          <th>7 Meridian Portal Nodes (Columns M1..M7)</th>
        </tr>
      </thead>
      <tbody>
        %s
      </tbody>
    </table>

    <h2 style="font-size:1.32rem;color:#34D399;margin-bottom:0.85rem;">
      The 7 Expansive Islamic Style Layers for Iterative Node-Art &amp; Building Evolution
    </h2>
    <section class="styles-grid">
      %s
    </section>

    <h2 style="font-size:1.32rem;color:#FDE68A;margin-bottom:0.85rem;">
      The 7 Chromatic Meridians of the Color Guard (Conjoined Principle + Realm + World + Building + Fashion)
    </h2>
    %s
  </main>

  <script>
    const canvas = document.getElementById('nodeTerrainCanvas');
    const ctx = canvas.getContext('2d');

    const MERIDIANS = [
      { col: 1, name: "M1 White (Al-Mizan)", hex: "#F8F5E6", sec: "#D4AF37", building: "Octagonal Selenite Minaret & Crystal Dome", fashion: "Libas Al-Ihram & White Dabiqi Tiraz Linen", triad: "Principle: Al-Mizan & Al-Amanah (55:7-9) | Realm: 'Aravot / Qasr Al-Reshimu | World: Amanah vs. Fasad" },
      { col: 2, name: "M2 Black (Al-Qalam)", hex: "#A78BFA", sec: "#141416", building: "Hexagonal Basalt Scriptorium & Cloven Obelisk", fashion: "Abbasid Black Burdah & Gold Kufic Tiraz", triad: "Principle: Al-Qalam & Libas At-Taqwa (68:1, 7:26) | Realm: Wadi Al-Qalam | World: Haya' vs. Tabarruj" },
      { col: 3, name: "M3 Sapphire (Ibrahim)", hex: "#38BDF8", sec: "#0F2C59", building: "7-Tiered Lapis Observatory & Astrolabe Dome", fashion: "Badakhshan Lapis Jubbah & Celestial Embroidery", triad: "Principle: Hujjat Ibrahim & Cool-Fire Peace (21:69) | Realm: Falak Al-Lazaward | World: Ibrahim vs. Namrud" },
      { col: 4, name: "M4 Gold (Prime Alast)", hex: "#D4AF37", sec: "#FDE68A", building: "12-Gated Golden Muqarnas Jami' & Al-A'raf Spire", fashion: "Damascus 24k Gold-Brocaded Zarkash & Seraser", triad: "Principle: Mithaq Al-Alast & One Ummah (7:172) | Realm: Jabal Al-Alast | World: Ummah vs. Fitnah" },
      { col: 5, name: "M5 Crimson (Al-Furqan)", hex: "#F43F5E", sec: "#8B0000", building: "Imperial Porphyry Ribat Watchtower & Ablaq Arch", fashion: "Crimson Yemeni Hibarah & Ottoman Catma Velvet", triad: "Principle: Al-Furqan Criterion (25:1) | Realm: Mihrab Al-Jamr | World: Furqan vs. Hawa" },
      { col: 6, name: "M6 Brass (Al-Qumqum)", hex: "#B87333", sec: "#F59E0B", building: "Solomonic Brass Foundry Keep & Sur Al-Hadid Wall", fashion: "Measured Davidic Sabighat Mail & Damascened Brass", triad: "Principle: Al-'Urwah Al-Wuthqa & Qumqum (2:102) | Realm: Madinat An-Nuhas | World: Tawhid vs. Taghut" },
      { col: 7, name: "M7 Emerald (At-Taqwa)", hex: "#10B981", sec: "#006B54", building: "Emerald Zellij Chahar Bagh Pavilion & Lighthouse", fashion: "Verdant Sufi Khirqah & Nishapur Emerald Brocade", triad: "Principle: Bunyan At-Taqwa & Rahmat Al-Khidr (9:108, 18:65) | Realm: Majma' Al-Bahrayn | World: Taqwa vs. Dirar" }
    ];

    const STRATA = [
      { row: 1, elev: -650, label: "Row 1 (-650m): Quarantined Zalim Trench", files: ["zalim-1-fasad.html","zalim-2-fahishah.html","zalim-3-baghy.html","zalim-4-fitnah.html","zalim-5-hawa.html","zalim-6-jibt.html","zalim-7-zulm.html"] },
      { row: 2, elev: -150, label: "Row 2 (-150m): Husbandry, Gulistan & Cultural Basin", files: ["warlock-formation-dissolution-jafar-aladdin.html","warlock-apocrypha-islamic-theorems.html","islamic-husbandry-sovereign-estate.html","way-of-the-flower-rose-garden-islam.html","disney-daffy-donald-islamic-microcosm.html","warlock-islamic-visual-eras-history.html","dependencies-report.html"] },
      { row: 3, elev: 80,   label: "Row 3 (+80m): Al-A'raf Ridge, Master Hubs & Sequesters", files: ["index.html","master-combined-omnibus.html","warlock-3d-sanctum.html","priory-negentropy-order.html","worlds-hegemon-disorder.html","sequester-between-worlds.html","interlocker-egg-binder-islam.html"] },
      { row: 4, elev: 300,  label: "Row 4 (+300m): Highland Hegemon Chahar Bagh Worlds", files: ["world-1-mizan-fasad.html","world-2-haya-fahishah.html","world-3-babil-namrud.html","world-4-ummah-fitnah.html","world-5-furqan-hawa.html","world-6-tawhid-taghut.html","world-7-taqwa-dirar.html"] },
      { row: 5, elev: 550,  label: "Row 5 (+550m): Existential Planes & Priory Cloisters", files: ["plane-1-white.html","plane-2-black.html","plane-3-sapphire.html","plane-4-gold.html","plane-5-crimson.html","plane-6-brass.html","plane-7-emerald.html"] },
      { row: 6, elev: 850,  label: "Row 6 (+850m): Celestial Realm Castles & Keeps", files: ["realm-1-white.html","realm-2-black.html","realm-3-sapphire.html","realm-4-gold.html","realm-5-crimson.html","realm-6-brass.html","realm-7-emerald.html"] },
      { row: 7, elev: 1200, label: "Row 7 (+1200m): Summit Color Orders & Principles", files: ["order-1-white.html","order-2-black.html","order-3-sapphire.html","order-4-gold.html","order-5-crimson.html","order-6-brass.html","order-7-emerald.html"] }
    ];

    const STYLE_META = {
      1: { tag: "STYLE LAYER I: BABIL & SABA' STEPPED ZIGGURAT & ALABASTER MONOLITH NODES", fold: 8 },
      2: { tag: "STYLE LAYER II: ABBASID BAGHDAD ASTROLABE & AL-IDRISI BRASS SPLINE NETWORK", fold: 10 },
      3: { tag: "STYLE LAYER III: MAMLUK CAIRO ABLAQ CITADELS & MUQARNAS STALACTITE VAULTS", fold: 12 },
      4: { tag: "STYLE LAYER IV: ANDALUSIAN ALHAMBRA 16-FOLD ZELLIJ & CHAHAR BAGH CHANNELS", fold: 16 },
      5: { tag: "STYLE LAYER V: TIMURID & SAFAVID 7-TIERED ISOMETRIC MINIATURE KEEPS", fold: 7 },
      6: { tag: "STYLE LAYER VI: OTTOMAN MATRAKCI NASUH 2.5D TOPOGRAPHY & IZNIK/KAFTAN GUARD", fold: 9 },
      7: { tag: "STYLE LAYER VII: NEO-ISLAMIC AI PROCEDURAL QUASICRYSTAL & FARADAY HEIGHTMAP", fold: 10 }
    };

    // Build 49 interactive 3D/2.5D nodes
    const nodes = [];
    for (let r = 0; r < 7; r++) {
      for (let c = 0; c < 7; c++) {
        const m = MERIDIANS[c];
        const s = STRATA[r];
        nodes.push({
          rowIdx: r,
          colIdx: c,
          meridian: m,
          stratum: s,
          elevMeters: s.elev + (c === 3 ? 65 : 0),
          buildingTiers: (r >= 5 ? 3 : (r >= 3 ? 2 : 1)),
          satellites: (r === 6 || c === 3) ? 2 : 1,
          file: s.files[c],
          screenX: 0,
          screenY: 0
        });
      }
    }

    let selectedNode = nodes[3 * 7 + 3]; // Center Prime Gold Meridian Row 4
    let currentStyle = 6;
    let isometric25D = true;
    let yaw = -0.62, pitch = 0.58, dragging = false, lx = 0, ly = 0;

    function resize() {
      canvas.width = canvas.clientWidth * window.devicePixelRatio;
      canvas.height = canvas.clientHeight * window.devicePixelRatio;
    }
    window.addEventListener('resize', resize);
    resize();

    canvas.addEventListener('mousedown', e => {
      dragging = true; lx = e.clientX; ly = e.clientY;
    });
    window.addEventListener('mouseup', () => dragging = false);
    canvas.addEventListener('mousemove', e => {
      if (!dragging) return;
      yaw += (e.clientX - lx) * 0.0065;
      pitch = Math.max(0.22, Math.min(1.15, pitch + (e.clientY - ly) * 0.0065));
      lx = e.clientX; ly = e.clientY;
    });

    canvas.addEventListener('click', e => {
      const rect = canvas.getBoundingClientRect();
      const mx = (e.clientX - rect.left) * window.devicePixelRatio;
      const my = (e.clientY - rect.top) * window.devicePixelRatio;
      let best = null, bestDist = 38 * window.devicePixelRatio;
      for (const n of nodes) {
        const d = Math.hypot(n.screenX - mx, n.screenY - my);
        if (d < bestDist) { bestDist = d; best = n; }
      }
      if (best) {
        selectedNode = best;
        updateInspector();
      }
    });

    function setStyleEra(era, btn) {
      currentStyle = era;
      document.querySelectorAll('.toolbar-bottom .ctrl-btn').forEach(b => {
        if (b.textContent.startsWith('Era ')) b.classList.remove('active');
      });
      if (btn) btn.classList.add('active');
      document.getElementById('hudStyleTag').textContent = STYLE_META[era].tag;
    }

    function toggleProjectionMode() {
      isometric25D = !isometric25D;
    }

    function iterateSelectedNodeBuilding() {
      if (!selectedNode) return;
      selectedNode.buildingTiers = (selectedNode.buildingTiers %% 6) + 1;
      updateInspector();
    }

    function spawnSatelliteSubNode() {
      if (!selectedNode) return;
      selectedNode.satellites = (selectedNode.satellites %% 5) + 1;
      updateInspector();
    }

    function sculptSelectedElevation(delta) {
      if (!selectedNode) return;
      selectedNode.elevMeters = Math.max(-900, Math.min(1650, selectedNode.elevMeters + delta));
      updateInspector();
    }

    function iterateAllMeridianNodes() {
      for (const n of nodes) {
        n.buildingTiers = Math.min(6, n.buildingTiers + 1);
        n.satellites = Math.min(5, n.satellites + 1);
      }
      updateInspector();
    }

    function updateInspector() {
      const n = selectedNode;
      document.getElementById('inspTitle').textContent =
        `M${n.colIdx + 1} (${n.meridian.name}) • Row ${n.rowIdx + 1} (${n.elevMeters >= 0 ? '+' : ''}${n.elevMeters}m)`;
      document.getElementById('inspFile').textContent = n.file;
      document.getElementById('inspTriad').textContent =
        `${n.stratum.label} — ${n.meridian.triad}`;
      document.getElementById('inspBuilding').innerHTML =
        `<strong>Building:</strong> ${n.meridian.building} (Iterative Tiers: <code>${n.buildingTiers}</code> | Sub-Nodes: <code>${n.satellites}</code>)`;
      document.getElementById('inspFashion').innerHTML =
        `<strong>Color Guard Regalia:</strong> ${n.meridian.fashion}`;
      document.getElementById('inspOpenBtn').href = n.file;
      document.getElementById('inspSplitBtn').href = 'master-combined-omnibus.html?portal=' + n.file;
      document.getElementById('hudNodeHeadline').textContent =
        `Selected Node [M${n.colIdx + 1}, R${n.rowIdx + 1}]: ${n.file} (${n.elevMeters >= 0 ? '+' : ''}${n.elevMeters}m)`;
    }

    function project3D(x, y, z, cx, cy) {
      const cyw = Math.cos(yaw), syw = Math.sin(yaw);
      const x1 = x * cyw - z * syw;
      const z1 = x * syw + z * cyw;
      const cp = Math.cos(pitch), sp = Math.sin(pitch);
      const y2 = y * cp - z1 * sp;
      const z2 = y * sp + z1 * cp;
      const scale = Math.min(canvas.width, canvas.height) / 720;
      if (isometric25D) {
        return [cx + x1 * scale * 0.92, cy - y2 * scale * 0.92, z2];
      }
      const fov = 780 / (780 + z2);
      return [cx + x1 * scale * fov, cy - y2 * scale * fov, z2];
    }

    function getNodeWorldCoords(n) {
      const gx = (n.colIdx - 3) * 76;
      const gz = (3 - n.rowIdx) * 68;
      const gy = (n.elevMeters / 12.5);
      return [gx, gy, gz];
    }

    function drawLine3D(p1, p2, cx, cy, color, width, alpha, dash) {
      const a = project3D(p1[0], p1[1], p1[2], cx, cy);
      const b = project3D(p2[0], p2[1], p2[2], cx, cy);
      ctx.save();
      ctx.strokeStyle = color;
      ctx.lineWidth = width;
      ctx.globalAlpha = alpha;
      if (dash) ctx.setLineDash(dash);
      ctx.beginPath();
      ctx.moveTo(a[0], a[1]);
      ctx.lineTo(b[0], b[1]);
      ctx.stroke();
      ctx.restore();
    }

    function renderLoop(ts) {
      const t = ts * 0.001;
      ctx.clearRect(0, 0, canvas.width, canvas.height);
      const cx = canvas.width * 0.5;
      const cy = canvas.height * 0.54;

      if (!dragging) yaw += 0.0012;

      // 1. Draw 3D Terrain & Elevation Grid Splines (Meridian Columns & Stratum Contours)
      for (let r = 0; r < 7; r++) {
        for (let c = 0; c < 7; c++) {
          const n = nodes[r * 7 + c];
          const p = getNodeWorldCoords(n);
          // Connect along Meridian (South -> North elevation climb)
          if (r < 6) {
            const nUp = nodes[(r + 1) * 7 + c];
            const pUp = getNodeWorldCoords(nUp);
            drawLine3D(p, pUp, cx, cy, n.meridian.hex, 2.2, 0.72);
          }
          // Connect along Stratum Contour (West -> East across the 7 Meridians)
          if (c < 6) {
            const nRight = nodes[r * 7 + (c + 1)];
            const pRight = getNodeWorldCoords(nRight);
            const contourColor = r === 3 ? "#38BDF8" : (r === 2 ? "#D4AF37" : "rgba(255,255,255,0.32)");
            drawLine3D(p, pRight, cx, cy, contourColor, r === 3 ? 2.6 : 1.4, 0.65);
          }
          // Drop vertical elevation pillar to datum plane (-70)
          drawLine3D(p, [p[0], -62, p[2]], cx, cy, n.meridian.hex, 0.9, 0.24, [3, 3]);
        }
      }

      // 2. Render each of the 49 Nodes with its 3D Islamic Building Stack & Star-Node Glyph
      const fold = STYLE_META[currentStyle].fold;
      for (const n of nodes) {
        const p = getNodeWorldCoords(n);
        const scr = project3D(p[0], p[1], p[2], cx, cy);
        n.screenX = scr[0];
        n.screenY = scr[1];

        const isSel = (n === selectedNode);
        const baseR = (isSel ? 15 : 10.5) * window.devicePixelRatio;

        // Draw N-Fold Islamic Girih Star Node-Art Ring at terrain coordinate
        ctx.save();
        ctx.translate(scr[0], scr[1]);
        ctx.strokeStyle = isSel ? "#FFFFFF" : n.meridian.hex;
        ctx.fillStyle = isSel ? "rgba(212, 175, 55, 0.38)" : "rgba(5, 8, 17, 0.88)";
        ctx.lineWidth = isSel ? 2.6 : 1.6;
        ctx.beginPath();
        for (let i = 0; i < fold * 2; i++) {
          const rad = (i %% 2 === 0) ? baseR : baseR * 0.56;
          const ang = (i * Math.PI) / fold + t * 0.35;
          const sx = Math.cos(ang) * rad;
          const sy = Math.sin(ang) * rad * 0.65;
          if (i === 0) ctx.moveTo(sx, sy); else ctx.lineTo(sx, sy);
        }
        ctx.closePath();
        ctx.fill();
        ctx.stroke();
        ctx.restore();

        // Draw Iterative 3D Islamic Building Tiers (Stepped Keep + Dome + Minaret Spire) on top of Node
        const tiers = n.buildingTiers;
        for (let tr = 0; tr < tiers; tr++) {
          const yBot = p[1] + tr * 13;
          const yTop = yBot + 12;
          const bw = Math.max(5, 13 - tr * 2);
          const bBot = project3D(p[0], yBot, p[2], cx, cy);
          const bTop = project3D(p[0], yTop, p[2], cx, cy);

          ctx.save();
          ctx.strokeStyle = isSel ? "#FDE68A" : n.meridian.hex;
          ctx.fillStyle = n.meridian.sec;
          ctx.globalAlpha = 0.88;
          ctx.lineWidth = 1.5;
          const wPx = bw * window.devicePixelRatio;
          const hPx = Math.max(6, bBot[1] - bTop[1]);
          ctx.fillRect(bTop[0] - wPx * 0.5, bTop[1], wPx, hPx);
          ctx.strokeRect(bTop[0] - wPx * 0.5, bTop[1], wPx, hPx);
          ctx.restore();
        }

        // Draw Islamic Dome & Hilal Finial at top of Building Stack
        const spireBase = project3D(p[0], p[1] + tiers * 13, p[2], cx, cy);
        const spireApex = project3D(p[0], p[1] + tiers * 13 + 16, p[2], cx, cy);
        ctx.save();
        ctx.fillStyle = n.meridian.hex;
        ctx.beginPath();
        ctx.arc(spireBase[0], spireBase[1], 5.5 * window.devicePixelRatio, Math.PI, 0);
        ctx.fill();
        ctx.strokeStyle = "#FDE68A";
        ctx.lineWidth = 1.6;
        ctx.beginPath();
        ctx.moveTo(spireBase[0], spireBase[1] - 5 * window.devicePixelRatio);
        ctx.lineTo(spireApex[0], spireApex[1]);
        ctx.stroke();
        ctx.restore();

        // Draw Orbiting Iterative Sub-Nodes around the Node
        for (let sat = 0; sat < n.satellites; sat++) {
          const ang = t * 1.4 + sat * ((Math.PI * 2) / n.satellites) + n.colIdx;
          const sx = p[0] + Math.cos(ang) * 24;
          const sz = p[2] + Math.sin(ang) * 24;
          const sy = p[1] + 10 + sat * 5;
          const sProj = project3D(sx, sy, sz, cx, cy);
          drawLine3D([p[0], p[1] + 8, p[2]], [sx, sy, sz], cx, cy, "#34D399", 1.0, 0.65);
          ctx.save();
          ctx.fillStyle = "#34D399";
          ctx.beginPath();
          ctx.arc(sProj[0], sProj[1], 3.2 * window.devicePixelRatio, 0, Math.PI * 2);
          ctx.fill();
          ctx.restore();
        }

        // Label selected or summit/prime nodes
        if (isSel || n.rowIdx === 6 || n.colIdx === 3) {
          ctx.save();
          ctx.fillStyle = isSel ? "#FDE68A" : "#E2E8F0";
          ctx.font = `${isSel ? 'bold 11px' : '10px'} Consolas, monospace`;
          ctx.textAlign = "center";
          ctx.fillText(`M${n.colIdx + 1}:R${n.rowIdx + 1} (${n.elevMeters >= 0 ? '+' : ''}${n.elevMeters}m)`, scr[0], scr[1] + 20 * window.devicePixelRatio);
          ctx.restore();
        }
      }

      requestAnimationFrame(renderLoop);
    }

    updateInspector();
    requestAnimationFrame(renderLoop);
  </script>
</body>
</html>
""".formatted(
                stratumRows.toString(),
                styleCards.toString(),
                meridianCards.toString()
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
