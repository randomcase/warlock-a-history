package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.IslamicCountriesHistoryAndCanonicalEmbrace;
import com.sovereign.warlock.domain.IslamicCountriesHistoryAndCanonicalEmbrace.HistoricalEmbracePathway;
import com.sovereign.warlock.domain.IslamicCountriesHistoryAndCanonicalEmbrace.InstitutionalEmbracePillar;
import com.sovereign.warlock.domain.IslamicCountriesHistoryAndCanonicalEmbrace.IslamicCivilizationalZone;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Generates the interactive HTML5 portal for:
 * "The History of Islamic Countries (Diyar Al-Islam / 57 OIC Nations Across 7 Civilizational Zones)
 *  and How They Canonically Embrace Being Muslim"
 * (islamic-countries-history-canonical-embrace-atlas.html — Portal #56).
 */
public final class IslamicCountriesCanonicalEmbracePortalGenerator {

    public static final String PORTAL_FILENAME = "islamic-countries-history-canonical-embrace-atlas.html";

    private IslamicCountriesCanonicalEmbracePortalGenerator() {
    }

    public static Path generatePortal(Path outputDirectory) throws IOException {
        Files.createDirectories(outputDirectory);
        Path targetFile = outputDirectory.resolve(PORTAL_FILENAME);
        String html = buildPortalHtml();
        Files.writeString(targetFile, html, StandardCharsets.UTF_8);
        return targetFile;
    }

    public static String buildPortalHtml() {
        StringBuilder pathwayCards = new StringBuilder();
        for (HistoricalEmbracePathway p : IslamicCountriesHistoryAndCanonicalEmbrace.allFiveHistoricalPathways()) {
            pathwayCards.append("""
                    <article class="matrix-card" data-search="%s %s %s %s">
                      <div class="card-header">
                        <span class="badge badge-gold">PATHWAY %d &bull; %s</span>
                        <span class="badge badge-emerald">L&#x101; Ikr&#x101;ha f&#x12B; Ad-D&#x12B;n (2:256)</span>
                      </div>
                      <h3>%s</h3>
                      <div class="detail-box box-mech">
                        <h4>&#x1F9ED; Historical Mechanism &amp; Multi-Generational Trajectory</h4>
                        <p>%s</p>
                      </div>
                      <div class="detail-box box-countries">
                        <h4>&#x1F30D; Exemplar Countries &amp; Regions</h4>
                        <p>%s</p>
                      </div>
                      <div class="anchor-footer">
                        <span>&#x1F4D6; <strong>Canonical Principle &amp; Proof:</strong> %s</span>
                      </div>
                    </article>
                    """.formatted(
                    escapeHtml(p.pathwayCode()),
                    escapeHtml(p.pathwayTitle()),
                    escapeHtml(p.exemplarCountriesAndRegions()),
                    escapeHtml(p.canonicalPrincipleAndTextualProof()),
                    p.pathwayIndex(),
                    escapeHtml(p.pathwayCode()),
                    escapeHtml(p.pathwayTitle()),
                    escapeHtml(p.historicalMechanismAndDemographics()),
                    escapeHtml(p.exemplarCountriesAndRegions()),
                    escapeHtml(p.canonicalPrincipleAndTextualProof())
            ));
        }

        StringBuilder zoneCards = new StringBuilder();
        for (IslamicCivilizationalZone z : IslamicCountriesHistoryAndCanonicalEmbrace.allSevenCivilizationalZones()) {
            zoneCards.append("""
                    <article class="matrix-card" data-search="%s %s %s %s %s">
                      <div class="card-header">
                        <span class="badge badge-cyan">CIVILIZATIONAL ZONE %d &bull; %s</span>
                        <span class="badge badge-gold">Diy&#x101;r Al-Isl&#x101;m</span>
                      </div>
                      <h3>%s</h3>
                      <p class="countries-line"><strong>&#x1F3F3; Countries &amp; Polities:</strong> %s</p>
                      <div class="detail-box box-mech">
                        <h4>&#x1F54C; Historical Pathway of Embracing Islam</h4>
                        <p>%s</p>
                      </div>
                      <div class="detail-box box-countries">
                        <h4>&#x2696; Canonical Madhhab, 'Aq&#x12B;dah &amp; Spiritual School</h4>
                        <p>%s</p>
                      </div>
                      <div class="invariant-box">
                        <strong>&#x2728; How They Canonically Embrace &amp; Live Being Muslim Today:</strong> %s
                      </div>
                      <div class="anchor-footer">
                        <span>&#x1F3DB; <strong>Landmark Sanctuaries &amp; Universities:</strong> %s</span>
                      </div>
                    </article>
                    """.formatted(
                    escapeHtml(z.zoneCode()),
                    escapeHtml(z.zoneTitleAndPopulationShare()),
                    escapeHtml(z.sovereignCountriesAndPolities()),
                    escapeHtml(z.canonicalMadhhabAndAqidah()),
                    escapeHtml(z.landmarkInstitutionsAndSanctuaries()),
                    z.zoneIndex(),
                    escapeHtml(z.zoneCode()),
                    escapeHtml(z.zoneTitleAndPopulationShare()),
                    escapeHtml(z.sovereignCountriesAndPolities()),
                    escapeHtml(z.historicalPathwayOfEmbrace()),
                    escapeHtml(z.canonicalMadhhabAndAqidah()),
                    escapeHtml(z.howTheyEmbraceBeingMuslimToday()),
                    escapeHtml(z.landmarkInstitutionsAndSanctuaries())
            ));
        }

        StringBuilder pillarRows = new StringBuilder();
        for (InstitutionalEmbracePillar pil : IslamicCountriesHistoryAndCanonicalEmbrace.allSixInstitutionalPillars()) {
            pillarRows.append("""
                    <tr data-search="%s %s %s %s">
                      <td><span class="badge badge-gold">PILLAR %d</span><br><small>%s</small></td>
                      <td><strong>%s</strong></td>
                      <td>%s</td>
                      <td>%s</td>
                      <td><span class="badge badge-emerald">%s</span></td>
                    </tr>
                    """.formatted(
                    escapeHtml(pil.pillarCode()),
                    escapeHtml(pil.arabicAndEnglishTitle()),
                    escapeHtml(pil.crossRegionalExamples()),
                    escapeHtml(pil.quranicAndSunnahAnchor()),
                    pil.pillarIndex(),
                    escapeHtml(pil.pillarCode()),
                    escapeHtml(pil.arabicAndEnglishTitle()),
                    escapeHtml(pil.constitutionalAndCivicExpression()),
                    escapeHtml(pil.crossRegionalExamples()),
                    escapeHtml(pil.quranicAndSunnahAnchor())
            ));
        }

        String template = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8" />
                  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                  <title>The History of Islamic Countries &amp; How They Canonically Embrace Being Muslim</title>
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
                      --text-main: #f1f5f9;
                      --text-muted: #94a3b8;
                      --border-subtle: rgba(245, 158, 11, 0.28);
                    }
                    * { box-sizing: border-box; margin: 0; padding: 0; }
                    body {
                      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
                      background: radial-gradient(circle at 20% 0%, #10213d 0%, var(--bg-deep) 65%);
                      color: var(--text-main);
                      line-height: 1.65;
                      padding-bottom: 4rem;
                    }
                    .hero-header {
                      padding: 3rem 2rem 2.2rem;
                      text-align: center;
                      border-bottom: 1px solid var(--border-subtle);
                      background: linear-gradient(180deg, rgba(16, 185, 129, 0.08) 0%, rgba(245, 158, 11, 0.05) 100%);
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
                      font-size: 1.02rem;
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
                      font-size: 0.84rem;
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
                      margin-bottom: 2.2rem;
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
                    #islamicCountriesCanvas {
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
                      grid-template-columns: repeat(auto-fit, minmax(385px, 1fr));
                      gap: 1.25rem;
                    }
                    .matrix-card {
                      background: var(--bg-card);
                      border: 1px solid rgba(245, 158, 11, 0.22);
                      border-radius: 14px;
                      padding: 1.35rem;
                      display: flex;
                      flex-direction: column;
                      gap: 0.85rem;
                      transition: transform 0.2s ease, border-color 0.2s ease;
                    }
                    .matrix-card:hover {
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
                    .matrix-card h3 {
                      font-size: 1.15rem;
                      color: #fff;
                    }
                    .countries-line {
                      font-size: 0.88rem;
                      color: #cbd5e1;
                    }
                    .detail-box {
                      background: rgba(6, 9, 19, 0.65);
                      border-radius: 10px;
                      padding: 0.85rem 1rem;
                      border-left: 3px solid var(--gold);
                    }
                    .detail-box.box-countries {
                      border-left-color: var(--cyan);
                    }
                    .detail-box h4 {
                      font-size: 0.84rem;
                      color: var(--gold);
                      margin-bottom: 0.35rem;
                      text-transform: uppercase;
                      letter-spacing: 0.04em;
                    }
                    .detail-box.box-countries h4 {
                      color: var(--cyan);
                    }
                    .detail-box p {
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
                    <span class="hero-kicker">Portal #56 &bull; Diy&#x101;r Al-Isl&#x101;m, 57 OIC Nations, 7 Civilizational Zones &amp; Canonical Embrace</span>
                    <h1>The History of Islamic Countries &amp; How They Canonically Embrace Being Muslim</h1>
                    <p>
                      Tracing the <strong>5 Historical Pathways</strong> by which nations embraced Islam (Prophetic Delegations, Multi-Century Civic Synthesis,
                      Maritime/Saharan Trade, Sufi Awliy&#x101;' &amp; Anti-Colonial Sovereignty), the <strong>7 Civilizational Zones of the 57 OIC &amp; Muslim-Majority Lands</strong>
                      (from Morocco, Senegal, Bosnia &amp; Egypt to Türkiye, Uzbekistan, Iran, Pakistan, Bangladesh &amp; Indonesia), and the <strong>6 Institutional Pillars</strong>
                      of living Islam canonically today.
                    </p>
                    <div class="pillar-banner">
                      <div class="pillar-stat">
                        <strong>I. 5 Pathways of Embrace</strong>
                        <span>Over half the Muslim world (Indonesia, Malaysia, West/East Africa, Maldives) had zero invading armies—embracing Islam via honest trade &amp; Sufi Awliy&#x101;'</span>
                      </div>
                      <div class="pillar-stat">
                        <strong>II. 7 Civilizational Zones</strong>
                        <span>Arabian Cradle, Levant/Nile, Maghreb/West Africa, Horn/Swahili, Anatolia/Balkans/Turkic Steppe, Persianate/South Asia &amp; Nusantara</span>
                      </div>
                      <div class="pillar-stat">
                        <strong>III. Madhhab &amp; 'Aq&#x12B;dah Unity</strong>
                        <span>How Hanafi, Maliki, Shafi'i, Hanbali, Ja'fari &amp; Ibadi jurisprudence harmonize with local custom (<em>Al-'&#x100;dah Mu&#x1E25;akkamah</em>, 7:199)</span>
                      </div>
                      <div class="pillar-stat">
                        <strong>IV. 6 Institutional Pillars</strong>
                        <span>Constitutional Law, 5-Daily Adh&#x101;n &amp; Hijri Rhythm, Waqf/Zakat/Sukuk, Unbroken Isn&#x101;d Universities, &#x1E6C;ah&#x101;rah Ecology &amp; Cultural Pluralism</span>
                      </div>
                    </div>
                  </header>

                  <main class="container">
                    <section class="canvas-panel">
                      <div class="canvas-header">
                        <div>
                          <h2 style="font-size:1.25rem;color:#fff;">Interactive 2.5D Afro-Eurasian Qiblah Constellation: 7 Civilizational Zones Converging on Al-Ka'bah</h2>
                          <p style="font-size:0.86rem;color:var(--text-muted);">
                            Center: Mecca &amp; Medina (Al-&#x1E24;aramayn) &bull; 7 Radiating Civilizational Arcs (West Africa/Maghreb, Balkans/Anatolia/Steppe, Levant/Nile, Horn/Swahili, Persia/South Asia, Nusantara)
                          </p>
                        </div>
                        <div class="canvas-controls">
                          <button class="mode-btn active" onclick="setUmmahMode('ALL')">All 7 Civilizational Zones</button>
                          <button class="mode-btn" onclick="setUmmahMode('TRADE')">Maritime &amp; Caravan Trade Zones</button>
                          <button class="mode-btn" onclick="setUmmahMode('MADHHAB')">4 Sunni + Ja'fari/Ibadi Schools</button>
                        </div>
                      </div>
                      <canvas id="islamicCountriesCanvas" width="1280" height="390"></canvas>
                    </section>

                    <div class="toolbar-search">
                      <input type="text" id="ummahSearchInput" placeholder="Search across Indonesia, Pakistan, Bangladesh, Egypt, Morocco, Senegal, Mali, Bosnia, Türkiye, Uzbekistan, Iran, Oman, Yemen, Shafi'i, Maliki, Hanafi..." oninput="filterUmmahPortal()" />
                      <span id="ummahCountBadge" class="badge badge-gold">Showing All 18 Canonical Civilizational Nodes</span>
                    </div>

                    <section class="section-block">
                      <div class="section-title">
                        <h2>I. The 5 Canonical Pathways by Which Nations Embraced Islam Across History</h2>
                        <p>Refuting the myth of forced conversion (Qur'an 2:256): how delegations, multi-century urban synthesis, honest merchant scales, Sufi pioneers, and anti-colonial resilience built the Muslim world.</p>
                      </div>
                      <div class="card-grid">
                        __PATHWAY_CARDS__
                      </div>
                    </section>

                    <section class="section-block">
                      <div class="section-title">
                        <h2>II. The 7 Canonical Civilizational Zones of Islamic Countries (Diy&#x101;r Al-Isl&#x101;m)</h2>
                        <p>Country-by-country historical trajectory, canonical legal/theological schools, and how each region embraces and embodies being Muslim today.</p>
                      </div>
                      <div class="card-grid">
                        __ZONE_CARDS__
                      </div>
                    </section>

                    <section class="section-block">
                      <div class="section-title">
                        <h2>III. The 6 Institutional &amp; Cultural Pillars of How Islamic Countries Embrace Being Muslim</h2>
                        <p>How constitutional law, the 5-daily Adh&#x101;n, Waqf/Zakat/Sukuk economics, unbroken Isn&#x101;d universities, &#x1E6C;ah&#x101;rah urban ecology, and indigenous cultural pluralism unite 1.9+ billion Muslims.</p>
                      </div>
                      <div class="table-wrapper">
                        <table>
                          <thead>
                            <tr>
                              <th>Pillar &amp; Code</th>
                              <th>Arabic &amp; English Institutional Pillar</th>
                              <th>Constitutional, Economic &amp; Civic Expression</th>
                              <th>Cross-Regional National Examples</th>
                              <th>Qur'anic &amp; Prophetic Anchor</th>
                            </tr>
                          </thead>
                          <tbody>
                            __PILLAR_ROWS__
                          </tbody>
                        </table>
                      </div>
                    </section>
                  </main>

                  <script>
                    let currentUmmahMode = 'ALL';
                    let ummahTick = 0;

                    function setUmmahMode(mode) {
                      currentUmmahMode = mode;
                      document.querySelectorAll('.mode-btn').forEach(btn => {
                        btn.classList.toggle('active', btn.getAttribute('onclick').includes("'" + mode + "'"));
                      });
                    }

                    function filterUmmahPortal() {
                      const q = (document.getElementById('ummahSearchInput').value || '').toLowerCase().trim();
                      let visible = 0;
                      document.querySelectorAll('.matrix-card, tbody tr').forEach(el => {
                        const hay = (el.getAttribute('data-search') || el.innerText || '').toLowerCase();
                        const match = !q || hay.includes(q);
                        el.style.display = match ? '' : 'none';
                        if (match) visible++;
                      });
                      const badge = document.getElementById('ummahCountBadge');
                      if (badge) badge.textContent = 'Showing ' + visible + ' of 18 Canonical Civilizational Nodes';
                    }

                    (function initUmmahCanvas() {
                      const canvas = document.getElementById('islamicCountriesCanvas');
                      if (!canvas) return;
                      const ctx = canvas.getContext('2d');

                      const zones = [
                        { x: 540, y: 205, name: 'I. Arabian Cradle (Mecca/Medina/Yemen/Oman)', madhhab: 'Hanbali / Shafi\\'i / Maliki / Ibadi', trade: true },
                        { x: 470, y: 125, name: 'II. Levant, Iraq & Nile (Egypt/Sham/Sudan)', madhhab: 'Shafi\\'i / Hanafi / Maliki', trade: false },
                        { x: 215, y: 185, name: 'III. Maghreb & West Africa (Morocco/Senegal/Mali)', madhhab: 'Maliki • Ash\\'ari • Junayd', trade: true },
                        { x: 465, y: 310, name: 'IV. Horn & Swahili Coast (Somalia/Zanzibar/Comoros)', madhhab: 'Shafi\\'i Maritime', trade: true },
                        { x: 645, y: 85, name: 'V. Anatolia, Balkans & Steppe (Türkiye/Bosnia/Uzbekistan)', madhhab: 'Hanafi • Maturidi', trade: false },
                        { x: 845, y: 165, name: 'VI. Persia & South Asia (Pakistan/Bangladesh/Iran)', madhhab: 'Hanafi / Ja\\'fari / Shafi\\'i', trade: true },
                        { x: 1085, y: 265, name: 'VII. Nusantara (Indonesia 87.2% / Malaysia / Brunei)', madhhab: 'Shafi\\'i • Ash\\'ari • Ghazali', trade: true }
                      ];

                      function render() {
                        ummahTick += 0.025;
                        const w = canvas.width;
                        const h = canvas.height;
                        ctx.clearRect(0, 0, w, h);

                        const kaabaX = 540, kaabaY = 205;

                        // Qiblah arcs from every zone to Mecca
                        zones.forEach((z, idx) => {
                          if (idx === 0) return;
                          ctx.beginPath();
                          ctx.moveTo(z.x, z.y);
                          ctx.quadraticCurveTo((z.x + kaabaX) / 2, Math.min(z.y, kaabaY) - 35, kaabaX, kaabaY);
                          ctx.strokeStyle = z.trade ? 'rgba(16, 185, 129, 0.42)' : 'rgba(56, 189, 248, 0.42)';
                          ctx.lineWidth = 2;
                          ctx.stroke();

                          // Animated Qiblah pulse along curve
                          const t = (ummahTick * 0.45 + idx * 0.15) % 1;
                          const cx = (1 - t) * (1 - t) * z.x + 2 * (1 - t) * t * ((z.x + kaabaX) / 2) + t * t * kaabaX;
                          const cy = (1 - t) * (1 - t) * z.y + 2 * (1 - t) * t * (Math.min(z.y, kaabaY) - 35) + t * t * kaabaY;
                          ctx.beginPath();
                          ctx.arc(cx, cy, 4, 0, Math.PI * 2);
                          ctx.fillStyle = '#f59e0b';
                          ctx.fill();
                        });

                        // Draw Zone Nodes
                        zones.forEach((z, idx) => {
                          const isCenter = idx === 0;
                          ctx.beginPath();
                          ctx.arc(z.x, z.y, isCenter ? 15 : 11, 0, Math.PI * 2);
                          ctx.fillStyle = isCenter ? '#f59e0b' : (z.trade ? '#10b981' : '#38bdf8');
                          ctx.fill();
                          ctx.strokeStyle = '#ffffff';
                          ctx.lineWidth = 1.5;
                          ctx.stroke();

                          ctx.fillStyle = '#ffffff';
                          ctx.font = 'bold 11.5px Segoe UI, sans-serif';
                          ctx.textAlign = 'center';
                          ctx.fillText(z.name, z.x, z.y - 20);

                          ctx.fillStyle = currentUmmahMode === 'MADHHAB' ? '#f59e0b' : '#94a3b8';
                          ctx.font = '10.5px Segoe UI, sans-serif';
                          ctx.fillText(z.madhhab, z.x, z.y + 26);
                        });

                        ctx.fillStyle = '#f59e0b';
                        ctx.font = 'bold 13px Segoe UI, sans-serif';
                        ctx.textAlign = 'center';
                        ctx.fillText('AFRO-EURASIAN QIBLAH CONSTELLATION: 7 CIVILIZATIONAL ZONES CONVERGING ON AL-KA\\'BAH (MECCA)', w / 2, 30);
                        ctx.fillStyle = '#94a3b8';
                        ctx.font = '11px Segoe UI, sans-serif';
                        ctx.fillText('Emerald Arcs: Maritime & Saharan Trade Conversion Zones  |  Cyan Arcs: Post-Conquest Multi-Century Urban & Sufi Synthesis', w / 2, 368);

                        requestAnimationFrame(render);
                      }
                      render();
                    })();
                  </script>
                </body>
                </html>
                """;

        return template
                .replace("__PATHWAY_CARDS__", pathwayCards.toString())
                .replace("__ZONE_CARDS__", zoneCards.toString())
                .replace("__PILLAR_ROWS__", pillarRows.toString());
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
