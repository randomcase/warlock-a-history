package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.IslamicModestyWesternFrontierEvolution;
import com.sovereign.warlock.domain.IslamicModestyWesternFrontierEvolution.ModestyFoundationalPrinciple;
import com.sovereign.warlock.domain.IslamicModestyWesternFrontierEvolution.RegionalVestimentarySynthesis;
import com.sovereign.warlock.domain.IslamicModestyWesternFrontierEvolution.WesternFrontierModestyEpoch;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Generates the interactive HTML5 portal for:
 * "How the Modesty Standard for Men and Women in Islam Changed Through the Development
 *  of the Western Frontier (Thughur Al-Gharb) and Civilizational Expansions"
 * (islamic-modesty-evolution-western-frontier-men-women.html — Portal #54).
 */
public final class IslamicModestyWesternFrontierPortalGenerator {

    public static final String PORTAL_FILENAME = "islamic-modesty-evolution-western-frontier-men-women.html";

    private IslamicModestyWesternFrontierPortalGenerator() {
    }

    public static Path generatePortal(Path outputDirectory) throws IOException {
        Files.createDirectories(outputDirectory);
        Path targetFile = outputDirectory.resolve(PORTAL_FILENAME);
        String html = buildPortalHtml();
        Files.writeString(targetFile, html, StandardCharsets.UTF_8);
        return targetFile;
    }

    public static String buildPortalHtml() {
        StringBuilder principleCards = new StringBuilder();
        for (ModestyFoundationalPrinciple p : IslamicModestyWesternFrontierEvolution.allSevenModestyFoundations()) {
            principleCards.append("""
                    <article class="modesty-card principle-card" data-search="%s %s %s %s %s">
                      <div class="card-header">
                        <span class="badge badge-gold">PRINCIPLE %d &bull; %s</span>
                        <span class="badge badge-emerald">Ath-Th&#x101;bit wa Al-Mutaghayyir</span>
                      </div>
                      <h3>%s</h3>
                      <div class="split-gender">
                        <div class="gender-box box-men">
                          <h4>&#x1F6E1; Masculine Standard (Ar-Rij&#x101;l)</h4>
                          <p>%s</p>
                        </div>
                        <div class="gender-box box-women">
                          <h4>&#x1F339; Feminine Standard (An-Nis&#x101;')</h4>
                          <p>%s</p>
                        </div>
                      </div>
                      <div class="invariant-box">
                        <strong>&#x2696; Invariant Core vs. Adaptive Custom ('Urf):</strong> %s
                      </div>
                      <div class="anchor-footer">
                        <span>&#x1F4D6; <strong>Qur'anic &amp; Hadith Proof:</strong> %s</span>
                      </div>
                    </article>
                    """.formatted(
                    escapeHtml(p.principleCode()),
                    escapeHtml(p.arabicAndEnglishTitle()),
                    escapeHtml(p.masculineObligation()),
                    escapeHtml(p.feminineObligation()),
                    escapeHtml(p.quranicAndHadithProof()),
                    p.principleIndex(),
                    escapeHtml(p.principleCode()),
                    escapeHtml(p.arabicAndEnglishTitle()),
                    escapeHtml(p.masculineObligation()),
                    escapeHtml(p.feminineObligation()),
                    escapeHtml(p.invariantCoreVsAdaptiveCustom()),
                    escapeHtml(p.quranicAndHadithProof())
            ));
        }

        StringBuilder frontierCards = new StringBuilder();
        for (WesternFrontierModestyEpoch f : IslamicModestyWesternFrontierEvolution.allSevenWesternFrontierEpochs()) {
            frontierCards.append("""
                    <article class="modesty-card frontier-card" data-search="%s %s %s %s %s">
                      <div class="card-header">
                        <span class="badge badge-cyan">WESTERN FRONTIER EPOCH %d &bull; %s</span>
                        <span class="badge badge-gold">Thugh&#x16B;r Al-Gharb</span>
                      </div>
                      <h3>%s</h3>
                      <p class="encounter-line"><strong>&#x1F30D; Frontier Encounter &amp; Cultural Challenge:</strong> %s</p>
                      <div class="split-gender">
                        <div class="gender-box box-men">
                          <h4>&#x1F9D4; Men's Modesty Evolution &amp; Frontier Garments</h4>
                          <p>%s</p>
                        </div>
                        <div class="gender-box box-women">
                          <h4>&#x1F9D5; Women's Modesty Evolution &amp; Frontier Garments</h4>
                          <p>%s</p>
                        </div>
                      </div>
                      <div class="invariant-box">
                        <strong>&#x1F3DB; Architectural, Spatial &amp; Legal Adaptation:</strong> %s
                      </div>
                      <div class="anchor-footer">
                        <span>&#x1F4DC; <strong>Primary Canonical &amp; Historical Sources:</strong> %s</span>
                      </div>
                    </article>
                    """.formatted(
                    escapeHtml(f.epochCode()),
                    escapeHtml(f.chronologicalAndFrontierSpan()),
                    escapeHtml(f.mensModestyEvolutionAndGarments()),
                    escapeHtml(f.womensModestyEvolutionAndGarments()),
                    escapeHtml(f.primaryCanonicalSources()),
                    f.epochIndex(),
                    escapeHtml(f.epochCode()),
                    escapeHtml(f.chronologicalAndFrontierSpan()),
                    escapeHtml(f.frontierEncounterAndCulturalChallenge()),
                    escapeHtml(f.mensModestyEvolutionAndGarments()),
                    escapeHtml(f.womensModestyEvolutionAndGarments()),
                    escapeHtml(f.architecturalAndLegalAdaptation()),
                    escapeHtml(f.primaryCanonicalSources())
            ));
        }

        StringBuilder regionalRows = new StringBuilder();
        for (RegionalVestimentarySynthesis r : IslamicModestyWesternFrontierEvolution.allSixRegionalSyntheses()) {
            regionalRows.append("""
                    <tr data-search="%s %s %s %s %s">
                      <td><span class="badge badge-gold">ZONE %d</span><br><small>%s</small></td>
                      <td><strong>%s</strong></td>
                      <td>%s</td>
                      <td>%s</td>
                      <td>%s</td>
                      <td><span class="badge badge-emerald">%s</span></td>
                    </tr>
                    """.formatted(
                    escapeHtml(r.regionCode()),
                    escapeHtml(r.civilizationalZone()),
                    escapeHtml(r.canonicalMasculineAttire()),
                    escapeHtml(r.canonicalFeminineAttire()),
                    escapeHtml(r.juristicSchoolAndMaxim()),
                    r.synthesisIndex(),
                    escapeHtml(r.regionCode()),
                    escapeHtml(r.civilizationalZone()),
                    escapeHtml(r.canonicalMasculineAttire()),
                    escapeHtml(r.canonicalFeminineAttire()),
                    escapeHtml(r.spatialAndSocialModestyNorm()),
                    escapeHtml(r.juristicSchoolAndMaxim())
            ));
        }

        String template = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8" />
                  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                  <title>Islamic Modesty (Al-&#x1E24;ay&#x101;' &amp; Lib&#x101;s At-Taqw&#x101;) for Men &amp; Women Across the Western Frontier &amp; Expansions</title>
                  <style>
                    :root {
                      --bg-deep: #060913;
                      --bg-panel: #0d1424;
                      --bg-card: #121c31;
                      --gold: #f59e0b;
                      --gold-soft: rgba(245, 158, 11, 0.16);
                      --emerald: #10b981;
                      --emerald-soft: rgba(16, 185, 129, 0.15);
                      --cyan: #38bdf8;
                      --cyan-soft: rgba(56, 189, 248, 0.15);
                      --rose: #f43f5e;
                      --rose-soft: rgba(244, 63, 94, 0.15);
                      --text-main: #f1f5f9;
                      --text-muted: #94a3b8;
                      --border-subtle: rgba(245, 158, 11, 0.28);
                    }
                    * { box-sizing: border-box; margin: 0; padding: 0; }
                    body {
                      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
                      background: radial-gradient(circle at 20% 0%, #13203c 0%, var(--bg-deep) 65%);
                      color: var(--text-main);
                      line-height: 1.65;
                      padding-bottom: 4rem;
                    }
                    .hero-header {
                      padding: 3rem 2rem 2.2rem;
                      text-align: center;
                      border-bottom: 1px solid var(--border-subtle);
                      background: linear-gradient(180deg, rgba(56, 189, 248, 0.08) 0%, rgba(245, 158, 11, 0.05) 100%);
                    }
                    .hero-kicker {
                      display: inline-block;
                      padding: 0.35rem 1rem;
                      border-radius: 999px;
                      background: var(--gold-soft);
                      color: var(--gold);
                      border: 1px solid var(--border-subtle);
                      font-size: 0.8rem;
                      font-weight: 700;
                      letter-spacing: 0.08em;
                      text-transform: uppercase;
                      margin-bottom: 1rem;
                    }
                    .hero-header h1 {
                      font-size: clamp(1.8rem, 3.2vw, 2.7rem);
                      color: #fff;
                      max-width: 1140px;
                      margin: 0 auto 0.9rem;
                      line-height: 1.25;
                    }
                    .hero-header p {
                      max-width: 980px;
                      margin: 0 auto 1.4rem;
                      color: var(--text-muted);
                      font-size: 1.03rem;
                    }
                    .pillar-banner {
                      display: grid;
                      grid-template-columns: repeat(auto-fit, minmax(230px, 1fr));
                      gap: 0.9rem;
                      max-width: 1280px;
                      margin: 1.5rem auto 0;
                    }
                    .pillar-stat {
                      background: rgba(18, 28, 49, 0.88);
                      border: 1px solid var(--border-subtle);
                      border-radius: 12px;
                      padding: 0.95rem 1.1rem;
                      text-align: left;
                    }
                    .pillar-stat strong {
                      display: block;
                      color: var(--gold);
                      font-size: 0.95rem;
                      margin-bottom: 0.25rem;
                    }
                    .pillar-stat span {
                      font-size: 0.85rem;
                      color: var(--text-muted);
                    }
                    .container {
                      max-width: 1360px;
                      margin: 0 auto;
                      padding: 2rem 1.5rem;
                    }
                    .canvas-panel {
                      background: var(--bg-panel);
                      border: 1px solid var(--border-subtle);
                      border-radius: 16px;
                      padding: 1.5rem;
                      margin-bottom: 2.5rem;
                      box-shadow: 0 14px 36px rgba(0, 0, 0, 0.45);
                    }
                    .canvas-header {
                      display: flex;
                      flex-wrap: wrap;
                      justify-content: space-between;
                      align-items: center;
                      gap: 1rem;
                      margin-bottom: 1rem;
                    }
                    .canvas-controls {
                      display: flex;
                      flex-wrap: wrap;
                      gap: 0.5rem;
                    }
                    .mode-btn {
                      background: var(--bg-card);
                      color: var(--text-main);
                      border: 1px solid var(--border-subtle);
                      border-radius: 8px;
                      padding: 0.45rem 0.85rem;
                      font-size: 0.82rem;
                      font-weight: 600;
                      cursor: pointer;
                      transition: all 0.2s ease;
                    }
                    .mode-btn.active, .mode-btn:hover {
                      background: var(--gold);
                      color: #060913;
                      border-color: var(--gold);
                    }
                    #modestyFrontierCanvas {
                      width: 100%;
                      height: 390px;
                      display: block;
                      background: radial-gradient(circle at 50% 50%, #101b33 0%, #050811 100%);
                      border-radius: 12px;
                      border: 1px solid rgba(56, 189, 248, 0.24);
                    }
                    .toolbar-search {
                      display: flex;
                      flex-wrap: wrap;
                      gap: 1rem;
                      align-items: center;
                      justify-content: space-between;
                      background: var(--bg-panel);
                      border: 1px solid var(--border-subtle);
                      padding: 1rem 1.25rem;
                      border-radius: 12px;
                      margin-bottom: 2.2rem;
                    }
                    .toolbar-search input {
                      flex: 1;
                      min-width: 260px;
                      background: var(--bg-deep);
                      color: var(--text-main);
                      border: 1px solid var(--border-subtle);
                      border-radius: 8px;
                      padding: 0.65rem 1rem;
                      font-size: 0.95rem;
                    }
                    .section-block {
                      margin-bottom: 3rem;
                    }
                    .section-title {
                      border-left: 4px solid var(--gold);
                      padding-left: 1rem;
                      margin-bottom: 1.4rem;
                    }
                    .section-title h2 {
                      font-size: 1.55rem;
                      color: #fff;
                    }
                    .section-title p {
                      color: var(--text-muted);
                      font-size: 0.95rem;
                    }
                    .card-grid {
                      display: grid;
                      grid-template-columns: repeat(auto-fit, minmax(390px, 1fr));
                      gap: 1.25rem;
                    }
                    .modesty-card {
                      background: var(--bg-card);
                      border: 1px solid rgba(245, 158, 11, 0.22);
                      border-radius: 14px;
                      padding: 1.35rem;
                      display: flex;
                      flex-direction: column;
                      gap: 0.85rem;
                      transition: transform 0.2s ease, border-color 0.2s ease;
                    }
                    .modesty-card:hover {
                      transform: translateY(-3px);
                      border-color: var(--gold);
                    }
                    .card-header {
                      display: flex;
                      flex-wrap: wrap;
                      gap: 0.5rem;
                      justify-content: space-between;
                      align-items: center;
                    }
                    .badge {
                      display: inline-block;
                      padding: 0.22rem 0.65rem;
                      border-radius: 6px;
                      font-size: 0.74rem;
                      font-weight: 700;
                      letter-spacing: 0.04em;
                    }
                    .badge-gold {
                      background: var(--gold-soft);
                      color: var(--gold);
                      border: 1px solid rgba(245, 158, 11, 0.35);
                    }
                    .badge-emerald {
                      background: var(--emerald-soft);
                      color: var(--emerald);
                      border: 1px solid rgba(16, 185, 129, 0.35);
                    }
                    .badge-cyan {
                      background: var(--cyan-soft);
                      color: var(--cyan);
                      border: 1px solid rgba(56, 189, 248, 0.35);
                    }
                    .modesty-card h3 {
                      font-size: 1.15rem;
                      color: #fff;
                    }
                    .encounter-line {
                      font-size: 0.88rem;
                      color: #cbd5e1;
                    }
                    .split-gender {
                      display: grid;
                      grid-template-columns: 1fr;
                      gap: 0.75rem;
                    }
                    .gender-box {
                      background: rgba(6, 9, 19, 0.65);
                      border-radius: 10px;
                      padding: 0.85rem 1rem;
                      border-left: 3px solid var(--cyan);
                    }
                    .gender-box.box-women {
                      border-left-color: var(--rose);
                    }
                    .gender-box h4 {
                      font-size: 0.84rem;
                      color: var(--cyan);
                      margin-bottom: 0.35rem;
                      text-transform: uppercase;
                      letter-spacing: 0.04em;
                    }
                    .gender-box.box-women h4 {
                      color: var(--rose);
                    }
                    .gender-box p {
                      font-size: 0.88rem;
                      color: #e2e8f0;
                    }
                    .invariant-box {
                      background: rgba(16, 185, 129, 0.09);
                      border: 1px solid rgba(16, 185, 129, 0.28);
                      border-radius: 9px;
                      padding: 0.75rem 0.95rem;
                      font-size: 0.85rem;
                      color: #d1fae5;
                    }
                    .anchor-footer {
                      margin-top: auto;
                      padding-top: 0.65rem;
                      border-top: 1px dashed rgba(148, 163, 184, 0.25);
                      font-size: 0.82rem;
                      color: var(--gold);
                    }
                    .table-wrapper {
                      overflow-x: auto;
                      background: var(--bg-panel);
                      border: 1px solid var(--border-subtle);
                      border-radius: 14px;
                    }
                    table {
                      width: 100%;
                      border-collapse: collapse;
                      min-width: 980px;
                    }
                    th, td {
                      padding: 0.95rem 1rem;
                      text-align: left;
                      border-bottom: 1px solid rgba(148, 163, 184, 0.16);
                      vertical-align: top;
                      font-size: 0.88rem;
                    }
                    th {
                      background: rgba(245, 158, 11, 0.12);
                      color: var(--gold);
                      font-weight: 700;
                      text-transform: uppercase;
                      font-size: 0.78rem;
                      letter-spacing: 0.05em;
                    }
                    tr:hover td {
                      background: rgba(255, 255, 255, 0.02);
                    }
                  </style>
                </head>
                <body>
                  <header class="hero-header">
                    <span class="hero-kicker">Portal #54 &bull; Al-&#x1E24;ay&#x101;', Lib&#x101;s At-Taqw&#x101; &amp; Thugh&#x16B;r Al-Gharb</span>
                    <h1>How the Modesty Standard for Men &amp; Women in Islam Changed Across the Western Frontier &amp; Expansions</h1>
                    <p>
                      Tracing the interplay between the <strong>Invariant Qur'anic Core</strong> (<em>Lib&#x101;s At-Taqw&#x101;</em> 7:26, symmetric lowering of the gaze 24:30&ndash;31,
                      male anti-arrogance &amp; female honor-recognition 33:59) and the <strong>Adaptive Customary Envelope (<em>Lib&#x101;s Al-'Urf</em>, 7:199)</strong>
                      from Hijaz and Byzantine Syria to the Almoravid Saharan <em>Lith&#x101;m</em> Inversion, Cordoban <em>Celos&#x12B;as</em>, the 1504 Oran Fatw&#x101;, Ottoman Rumelia, and the Modern Digital West.
                    </p>
                    <div class="pillar-banner">
                      <div class="pillar-stat">
                        <strong>I. Symmetric Gaze First (24:30&ndash;31)</strong>
                        <span>Men are commanded FIRST to lower their gaze (24:30) and renounce silk, gold, and prideful <em>Isb&#x101;l</em> before women's <em>Khim&#x101;r</em> is addressed (24:31)</span>
                      </div>
                      <div class="pillar-stat">
                        <strong>II. The Saharan <em>Lith&#x101;m</em> Inversion</strong>
                        <span>On the Berber Almoravid frontier, MEN wore the full face-veil (<em>Al-Lith&#x101;m</em>) while women went face-unveiled—validated under Maliki <em>'Urf</em></span>
                      </div>
                      <div class="pillar-stat">
                        <strong>III. Al-Andalus &amp; The 1504 Oran Fatw&#x101;</strong>
                        <span>From Ziry&#x101;b's linen <em>Aljubbas</em>, <em>Almalafas</em> &amp; 170+ female scholars to the Morisco coercion fatw&#x101; where inner <em>Taqw&#x101;</em> superseded banned fabric</span>
                      </div>
                      <div class="pillar-stat">
                        <strong>IV. Ottoman Suits to Digital Frontier</strong>
                        <span>From Mahmud II's 1829 tailored trousers &amp; Bosnian <em>Dimije</em> to modern Western tailored modesty and digital <em>Gha&#x1E0D;&#x1E0D; Al-Ba&#x1E63;ar</em></span>
                      </div>
                    </div>
                  </header>

                  <main class="container">
                    <section class="canvas-panel">
                      <div class="canvas-header">
                        <div>
                          <h2 style="font-size:1.25rem;color:#fff;">Interactive 2.5D Western Frontier Modesty Trajectory, Mashrabiyyah/Celos&#x12B;a Lattice &amp; 'Urf Synthesizer</h2>
                          <p style="font-size:0.86rem;color:var(--text-muted);">
                            Left: 3 Concentric Layers of Dress (7:26) &bull; Center: 7 Western Frontier Nodes (Hijaz &rarr; Levant &rarr; Maghreb Lith&#x101;m &rarr; Al-Andalus &rarr; Oran 1504 &rarr; Rumelia &rarr; Modern West) &bull; Right: Mashrabiyyah Privacy Lattice
                          </p>
                        </div>
                        <div class="canvas-controls">
                          <button class="mode-btn active" onclick="setModestyMode('ALL')">All Modesty Layers</button>
                          <button class="mode-btn" onclick="setModestyMode('MEN')">Masculine Standard (24:30)</button>
                          <button class="mode-btn" onclick="setModestyMode('WOMEN')">Feminine Standard (24:31)</button>
                          <button class="mode-btn" onclick="setModestyMode('FRONTIER')">7 Western Frontier Epochs</button>
                        </div>
                      </div>
                      <canvas id="modestyFrontierCanvas" width="1280" height="390"></canvas>
                    </section>

                    <div class="toolbar-search">
                      <input type="text" id="modestySearchInput" placeholder="Search across Litham, Almoravid, Al-Andalus, Ziryab, Almalafa, Oran Fatwa, Mahmud II, Ferace, Ghadd Al-Basar, Isbal, Shafi'i..." oninput="filterModestyPortal()" />
                      <span id="modestyCountBadge" class="badge badge-gold">Showing All 20 Canonical Modesty Nodes</span>
                    </div>

                    <section class="section-block">
                      <div class="section-title">
                        <h2>I. The 7 Canonical Foundational Principles: Invariant Core (Ath-Th&#x101;bit) vs. Customary Dress (Al-'Urf)</h2>
                        <p>Why Islam commands men first in ocular modesty (Qur'an 24:30), forbids male silk/gold/arrogance, protects female public dignity (33:59), and validates every indigenous frontier garment that is loose and opaque.</p>
                      </div>
                      <div class="card-grid">
                        __PRINCIPLE_CARDS__
                      </div>
                    </section>

                    <section class="section-block">
                      <div class="section-title">
                        <h2>II. The 7 Historical Epochs Along the Islamic Western Frontier (Thugh&#x16B;r Al-Gharb) &amp; Expansions</h2>
                        <p>How men's and women's modesty evolved from 7th-century Medina through Byzantine Syria, Berber North Africa, Moorish Spain, the Morisco Underground, Ottoman Europe, and the 21st-century Western Diaspora.</p>
                      </div>
                      <div class="card-grid">
                        __FRONTIER_CARDS__
                      </div>
                    </section>

                    <section class="section-block">
                      <div class="section-title">
                        <h2>III. Comparative Global Synthesis: 6 Civilizational Zones of Islamic Masculine &amp; Feminine Attire</h2>
                        <p>How one invariant moral standard generated six distinct, climate-adapted sartorial traditions across the Muslim world and the Western frontier.</p>
                      </div>
                      <div class="table-wrapper">
                        <table>
                          <thead>
                            <tr>
                              <th>Zone &amp; Code</th>
                              <th>Civilizational &amp; Frontier Sphere</th>
                              <th>Canonical Masculine Attire (Ar-Rij&#x101;l)</th>
                              <th>Canonical Feminine Attire (An-Nis&#x101;')</th>
                              <th>Spatial, Architectural &amp; Social Modesty Norm</th>
                              <th>Juristic School &amp; Legal Maxim</th>
                            </tr>
                          </thead>
                          <tbody>
                            __REGIONAL_ROWS__
                          </tbody>
                        </table>
                      </div>
                    </section>
                  </main>

                  <script>
                    let currentModestyMode = 'ALL';
                    let modestyTick = 0;

                    function setModestyMode(mode) {
                      currentModestyMode = mode;
                      document.querySelectorAll('.mode-btn').forEach(btn => {
                        btn.classList.toggle('active', btn.getAttribute('onclick').includes("'" + mode + "'"));
                      });
                    }

                    function filterModestyPortal() {
                      const q = (document.getElementById('modestySearchInput').value || '').toLowerCase().trim();
                      let visible = 0;
                      document.querySelectorAll('.modesty-card, tbody tr').forEach(el => {
                        const hay = (el.getAttribute('data-search') || el.innerText || '').toLowerCase();
                        const match = !q || hay.includes(q);
                        el.style.display = match ? '' : 'none';
                        if (match) visible++;
                      });
                      const badge = document.getElementById('modestyCountBadge');
                      if (badge) badge.textContent = 'Showing ' + visible + ' of 20 Canonical Modesty Nodes';
                    }

                    (function initModestyCanvas() {
                      const canvas = document.getElementById('modestyFrontierCanvas');
                      if (!canvas) return;
                      const ctx = canvas.getContext('2d');

                      const frontierNodes = [
                        { x: 350, y: 275, title: '1. Hijaz (610 CE)', sub: 'Izar/Rida & Khimar/Jilbab' },
                        { x: 455, y: 210, title: '2. Levant/Egypt', sub: 'Sarawil & Hammam Mi\\'zar' },
                        { x: 560, y: 265, title: '3. Maghreb Sahara', sub: 'Male Litham Veil Inversion' },
                        { x: 665, y: 155, title: '4. Al-Andalus', sub: 'Aljubba, Almalafa & Celosia' },
                        { x: 770, y: 245, title: '5. Oran Fatwa (1504)', sub: 'Heart Taqwa Under Coercion' },
                        { x: 875, y: 150, title: '6. Ottoman Balkans', sub: '1829 Suits, Ferace & Dimije' },
                        { x: 980, y: 215, title: '7. Modern West', sub: 'Digital Gaze & Conscious Hijab' }
                      ];

                      function render() {
                        modestyTick += 0.025;
                        const w = canvas.width;
                        const h = canvas.height;
                        ctx.clearRect(0, 0, w, h);

                        // 1. LEFT: 3 Concentric Rings of Qur'an 7:26 (Libas At-Taqwa Core -> Haya/Gaze -> Regional 'Urf)
                        const cx = 155, cy = 198;
                        const rings = [
                          { r: 96, color: '#38bdf8', label: "Outer: Libas Al-'Urf (Frontier Cut)" },
                          { r: 64, color: '#10b981', label: 'Middle: Ghadd Al-Basar (24:30-31)' },
                          { r: 32, color: '#f59e0b', label: 'Core: Libas At-Taqwa (7:26)' }
                        ];
                        rings.forEach((ring, idx) => {
                          ctx.beginPath();
                          ctx.arc(cx, cy, ring.r + Math.sin(modestyTick * 2 + idx) * 2, 0, Math.PI * 2);
                          ctx.strokeStyle = ring.color;
                          ctx.lineWidth = idx === 2 ? 3 : 1.8;
                          ctx.stroke();
                        });
                        ctx.fillStyle = '#f59e0b';
                        ctx.font = 'bold 12.5px Segoe UI, sans-serif';
                        ctx.textAlign = 'center';
                        ctx.fillText('I. 3 TIERS OF DRESS (QUR\\'AN 7:26)', cx, 36);
                        ctx.fillStyle = '#94a3b8';
                        ctx.font = '11px Segoe UI, sans-serif';
                        ctx.fillText('Core: Libas At-Taqwa (Invariant)', cx, 338);
                        ctx.fillText("Envelope: Libas Al-'Urf (Adaptive)", cx, 356);

                        // 2. CENTER: 7 Western Frontier Trajectory Nodes (Hijaz -> Modern West)
                        ctx.save();
                        ctx.beginPath();
                        frontierNodes.forEach((n, idx) => {
                          if (idx === 0) ctx.moveTo(n.x, n.y);
                          else ctx.lineTo(n.x, n.y);
                        });
                        ctx.strokeStyle = 'rgba(245, 158, 11, 0.45)';
                        ctx.lineWidth = 2.5;
                        ctx.stroke();

                        frontierNodes.forEach((n, idx) => {
                          const pulse = Math.sin(modestyTick * 2.5 + idx) * 2.5;
                          // Men vector (cyan upper)
                          if (currentModestyMode === 'ALL' || currentModestyMode === 'MEN' || currentModestyMode === 'FRONTIER') {
                            ctx.beginPath();
                            ctx.arc(n.x - 8, n.y - 8, 7 + pulse * 0.3, 0, Math.PI * 2);
                            ctx.fillStyle = '#38bdf8';
                            ctx.fill();
                          }
                          // Women vector (rose lower)
                          if (currentModestyMode === 'ALL' || currentModestyMode === 'WOMEN' || currentModestyMode === 'FRONTIER') {
                            ctx.beginPath();
                            ctx.arc(n.x + 8, n.y + 8, 7 - pulse * 0.3, 0, Math.PI * 2);
                            ctx.fillStyle = '#f43f5e';
                            ctx.fill();
                          }

                          ctx.fillStyle = '#ffffff';
                          ctx.font = 'bold 11.5px Segoe UI, sans-serif';
                          ctx.textAlign = 'center';
                          ctx.fillText(n.title, n.x, n.y - 24);
                          ctx.fillStyle = '#cbd5e1';
                          ctx.font = '10.5px Segoe UI, sans-serif';
                          ctx.fillText(n.sub, n.x, n.y + 30);
                        });

                        ctx.fillStyle = '#38bdf8';
                        ctx.font = 'bold 13px Segoe UI, sans-serif';
                        ctx.textAlign = 'center';
                        ctx.fillText('II. 7 EPOCHS OF THE ISLAMIC WESTERN FRONTIER (THUGHUR AL-GHARB)', 665, 36);
                        ctx.fillStyle = '#94a3b8';
                        ctx.font = '11.5px Segoe UI, sans-serif';
                        ctx.fillText('Cyan Nodes: Masculine Standard (24:30)  |  Rose Nodes: Feminine Standard (24:31 & 33:59)', 665, 356);
                        ctx.restore();

                        // 3. RIGHT: Mashrabiyyah / Celosia Architectural Privacy Lattice
                        const rx = 1145, ry = 195;
                        ctx.save();
                        ctx.strokeStyle = 'rgba(16, 185, 129, 0.45)';
                        ctx.lineWidth = 1.4;
                        for (let gx = rx - 65; gx <= rx + 65; gx += 26) {
                          for (let gy = ry - 85; gy <= ry + 85; gy += 26) {
                            ctx.strokeRect(gx - 10, gy - 10, 20, 20);
                            ctx.beginPath();
                            ctx.moveTo(gx, gy - 10);
                            ctx.lineTo(gx + 10, gy);
                            ctx.lineTo(gx, gy + 10);
                            ctx.lineTo(gx - 10, gy);
                            ctx.closePath();
                            ctx.stroke();
                          }
                        }
                        ctx.fillStyle = '#10b981';
                        ctx.font = 'bold 12.5px Segoe UI, sans-serif';
                        ctx.textAlign = 'center';
                        ctx.fillText('III. MASHRABIYYAH / CELOSIA', rx, 36);
                        ctx.fillStyle = '#94a3b8';
                        ctx.font = '11px Segoe UI, sans-serif';
                        ctx.fillText('Architectural Privacy (24:27)', rx, 338);
                        ctx.fillText('& Digital Gaze Shield', rx, 356);
                        ctx.restore();

                        requestAnimationFrame(render);
                      }
                      render();
                    })();
                  </script>
                </body>
                </html>
                """;

        return template
                .replace("__PRINCIPLE_CARDS__", principleCards.toString())
                .replace("__FRONTIER_CARDS__", frontierCards.toString())
                .replace("__REGIONAL_ROWS__", regionalRows.toString());
    }

    private static String escapeHtml(String input) {
        if (input == null) {
            return "";
        }
        return input
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }
}
