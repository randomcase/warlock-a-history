package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.IslamicCaravansBattlesAndConquestChronicle;
import com.sovereign.warlock.domain.IslamicCaravansBattlesAndConquestChronicle.CanonicalCaravanAndTradeBattle;
import com.sovereign.warlock.domain.IslamicCaravansBattlesAndConquestChronicle.ConquestRecordingCodex;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.HexFormat;
import java.util.List;

/**
 * Generates the static HTML portal {@code islamic-caravans-battles-conquest-chronicle.html}
 * presenting the Canonical Islamic Caravans (Al-'Ir / Rihlat Ash-Shita' wa As-Sayf),
 * Battles for Trade (Saraya wa Ghazawat At-Tijarah), Founding of Conquest (Ta'sis Al-Fath),
 * and Recording of Conquest (Tadwin Al-Maghazi, Futuh Al-Buldan & Diwan Al-Jund).
 */
public class IslamicCaravansAndConquestPortalGenerator {

    public WarlockHtmlPortalService.GeneratedHtmlArtifact generateCaravansAndConquestPortal(Path outputDir)
            throws IOException {
        Files.createDirectories(outputDir);
        String html = renderCaravansAndConquestHtml();
        String fileName = "islamic-caravans-battles-conquest-chronicle.html";
        Path file = outputDir.resolve(fileName);
        Files.writeString(file, html, StandardCharsets.UTF_8);
        return new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                fileName,
                file,
                Files.size(file),
                sha256(html),
                "Canonical Islamic Caravans (Ilaf), Battles for Trade (Badr/Qaradah), Founding of Conquest (Fath) & Recording of Conquest (Tadwin Al-Maghazi / Futuh Al-Buldan)"
        );
    }

    private String renderCaravansAndConquestHtml() {
        List<CanonicalCaravanAndTradeBattle> stages =
                IslamicCaravansBattlesAndConquestChronicle.allSevenCaravansAndTradeBattles();
        List<ConquestRecordingCodex> codices =
                IslamicCaravansBattlesAndConquestChronicle.allSevenConquestRecordingCodices();

        StringBuilder stageCardsHtml = new StringBuilder();
        StringBuilder stageTableRowsHtml = new StringBuilder();
        for (CanonicalCaravanAndTradeBattle s : stages) {
            stageCardsHtml.append(String.format("""
                    <article class="stage-card" style="border-top: 4px solid %s;">
                      <div class="stage-head">
                        <span class="stage-badge" style="background:%s;color:#080B11;">STAGE #%d • %s</span>
                        <span class="stage-date">%s</span>
                      </div>
                      <h3>%s</h3>
                      <div class="arabic-sub">%s</div>
                      <div class="field-grid">
                        <div class="field-box">
                          <span class="lbl">Caravan Route &amp; Commodities (Al-'Īr / Al-Biḍā'ah)</span>
                          <p>%s</p>
                        </div>
                        <div class="field-box">
                          <span class="lbl">Commanders &amp; Standards (Al-Liwā' wa Ar-Rāyah)</span>
                          <p>%s</p>
                        </div>
                        <div class="field-box">
                          <span class="lbl">Battle for Trade Dynamics (Sarāyā wa Ghazawāt At-Tijārah)</span>
                          <p>%s</p>
                        </div>
                        <div class="field-box highlight">
                          <span class="lbl">Founding of Conquest Outcome (Ta'sīs Al-Fatḥ)</span>
                          <p>%s</p>
                        </div>
                      </div>
                      <div class="quran-footer">
                        <strong>Qur'anic &amp; Sīrah Proof:</strong> %s
                      </div>
                    </article>
                    """,
                    s.meridianColorHex(),
                    s.meridianColorHex(), s.stageIndex(), escape(s.stageCode()),
                    escape(s.chronologicalDateHijriAndCe()),
                    escape(s.englishStageTitle()),
                    escape(s.arabicStageTitle()),
                    escape(s.caravanRouteAndCommodities()),
                    escape(s.commanderAndBanner()),
                    escape(s.battleForTradeDynamics()),
                    escape(s.foundingOfConquestOutcome()),
                    escape(s.quranicAndSirahAnchor())
            ));

            stageTableRowsHtml.append(String.format("""
                    <tr>
                      <td><strong style="color:%s;">#%d</strong><br><span class="mono-sm">%s</span></td>
                      <td><strong>%s</strong><br><span class="arabic-inline">%s</span><br><span class="mono-sm">%s</span></td>
                      <td>%s</td>
                      <td>%s</td>
                      <td>%s</td>
                      <td><span class="cite-pill">%s</span></td>
                    </tr>
                    """,
                    s.meridianColorHex(), s.stageIndex(), escape(s.stageCode()),
                    escape(s.englishStageTitle()), escape(s.arabicStageTitle()), escape(s.chronologicalDateHijriAndCe()),
                    escape(s.caravanRouteAndCommodities()),
                    escape(s.battleForTradeDynamics()),
                    escape(s.foundingOfConquestOutcome()),
                    escape(s.quranicAndSirahAnchor())
            ));
        }

        StringBuilder codexCardsHtml = new StringBuilder();
        StringBuilder codexTableRowsHtml = new StringBuilder();
        String[] codexColors = {"#F8F5E6", "#D4AF37", "#38BDF8", "#A78BFA", "#10B981", "#B87333", "#F43F5E"};
        for (ConquestRecordingCodex c : codices) {
            String color = codexColors[(c.codexIndex() - 1) % codexColors.length];
            codexCardsHtml.append(String.format("""
                    <article class="codex-card" style="border-left: 4px solid %s;">
                      <div class="stage-head">
                        <span class="stage-badge" style="background:%s;color:#080B11;">CODEX #%d • %s</span>
                        <span class="stage-date">%s</span>
                      </div>
                      <h3>%s</h3>
                      <div class="arabic-sub">%s</div>
                      <p class="chronicler-line"><strong>Chronicler / Chancery Institution:</strong> %s</p>
                      <div class="field-grid">
                        <div class="field-box">
                          <span class="lbl">Recording Methodology, Archival Medium &amp; Topography</span>
                          <p>%s</p>
                        </div>
                        <div class="field-box highlight">
                          <span class="lbl">Constitutional, Fiscal &amp; Legal Governance Rule (Ṣulḥ vs. 'Anwah / Waqf)</span>
                          <p>%s</p>
                        </div>
                      </div>
                      <div class="quran-footer">
                        <strong>Canonical Source &amp; Proof:</strong> %s
                      </div>
                    </article>
                    """,
                    color,
                    color, c.codexIndex(), escape(c.codexCode()),
                    escape(c.eraAndCentury()),
                    escape(c.englishCodexTitle()),
                    escape(c.arabicCodexTitle()),
                    escape(c.chroniclerOrInstitution()),
                    escape(c.recordingMethodologyAndMedium()),
                    escape(c.legalAndFiscalGovernanceRule()),
                    escape(c.quranicAndHistoriographicalProof())
            ));

            codexTableRowsHtml.append(String.format("""
                    <tr>
                      <td><strong style="color:%s;">Codex #%d</strong><br><span class="mono-sm">%s</span></td>
                      <td><strong>%s</strong><br><span class="arabic-inline">%s</span><br><span class="mono-sm">%s</span></td>
                      <td>%s</td>
                      <td>%s</td>
                      <td>%s</td>
                      <td><span class="cite-pill">%s</span></td>
                    </tr>
                    """,
                    color, c.codexIndex(), escape(c.codexCode()),
                    escape(c.englishCodexTitle()), escape(c.arabicCodexTitle()), escape(c.eraAndCentury()),
                    escape(c.chroniclerOrInstitution()),
                    escape(c.recordingMethodologyAndMedium()),
                    escape(c.legalAndFiscalGovernanceRule()),
                    escape(c.quranicAndHistoriographicalProof())
            ));
        }

        String template = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <title>Canonical Islamic Caravans, Battles for Trade, Founding of Conquest &amp; Recording of Conquest</title>
                  <style>
                    :root {
                      --bg-deep: #070A10;
                      --bg-panel: #0F1521;
                      --bg-card: #141C2B;
                      --gold: #D4AF37;
                      --emerald: #10B981;
                      --sapphire: #38BDF8;
                      --crimson: #F43F5E;
                      --brass: #B87333;
                      --text-main: #F1F5F9;
                      --text-muted: #94A3B8;
                      --border: rgba(212, 175, 55, 0.24);
                    }
                    * { box-sizing: border-box; margin: 0; padding: 0; }
                    body {
                      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
                      background: radial-gradient(circle at 20% 0%, rgba(212,175,55,0.14), transparent 45%),
                                  radial-gradient(circle at 85% 15%, rgba(16,185,129,0.12), transparent 45%),
                                  var(--bg-deep);
                      color: var(--text-main);
                      line-height: 1.65;
                      padding-bottom: 5rem;
                    }
                    .hero {
                      max-width: 1380px;
                      margin: 0 auto;
                      padding: 2.5rem 2rem 1.8rem;
                      border-bottom: 1px solid var(--border);
                    }
                    .eyebrow {
                      display: inline-flex;
                      align-items: center;
                      gap: 0.5rem;
                      padding: 0.3rem 0.85rem;
                      border-radius: 999px;
                      background: rgba(212,175,55,0.14);
                      border: 1px solid var(--gold);
                      color: #FDE68A;
                      font-size: 0.78rem;
                      font-weight: 700;
                      letter-spacing: 0.08em;
                      text-transform: uppercase;
                      margin-bottom: 0.9rem;
                    }
                    h1 {
                      font-size: clamp(1.85rem, 3.2vw, 2.75rem);
                      color: #FFF;
                      line-height: 1.2;
                      margin-bottom: 0.6rem;
                    }
                    .arabic-hero {
                      font-size: 1.35rem;
                      color: var(--gold);
                      font-family: 'Traditional Arabic', 'Amiri', serif;
                      margin-bottom: 1rem;
                    }
                    .lead {
                      color: #CBD5E1;
                      max-width: 1080px;
                      font-size: 1.02rem;
                      margin-bottom: 1.4rem;
                    }
                    .pillar-strip {
                      display: grid;
                      grid-template-columns: repeat(auto-fit, minmax(260px, 1fr));
                      gap: 1rem;
                      margin-top: 1.2rem;
                    }
                    .pillar-box {
                      background: rgba(15, 21, 33, 0.88);
                      border: 1px solid var(--border);
                      border-radius: 12px;
                      padding: 1rem 1.15rem;
                    }
                    .pillar-box h4 {
                      color: #FDE68A;
                      font-size: 0.92rem;
                      margin-bottom: 0.35rem;
                    }
                    .pillar-box p {
                      color: var(--text-muted);
                      font-size: 0.84rem;
                    }
                    .container {
                      max-width: 1380px;
                      margin: 0 auto;
                      padding: 2rem;
                    }
                    .section-title {
                      display: flex;
                      flex-wrap: wrap;
                      justify-content: space-between;
                      align-items: flex-end;
                      gap: 1rem;
                      margin: 2.2rem 0 1.25rem;
                      padding-bottom: 0.65rem;
                      border-bottom: 2px solid var(--border);
                    }
                    .section-title h2 {
                      font-size: 1.5rem;
                      color: #FFF;
                    }
                    .section-title span {
                      font-size: 0.85rem;
                      color: var(--gold);
                      font-family: monospace;
                    }
                    /* Interactive 2.5D Caravan & Battle Map */
                    .map-shell {
                      display: grid;
                      grid-template-columns: 1fr 390px;
                      gap: 1.25rem;
                      background: var(--bg-panel);
                      border: 1px solid var(--border);
                      border-radius: 16px;
                      padding: 1.25rem;
                      box-shadow: 0 20px 45px rgba(0,0,0,0.55);
                    }
                    @media (max-width: 1080px) {
                      .map-shell { grid-template-columns: 1fr; }
                    }
                    .canvas-wrap {
                      position: relative;
                      background: #06090F;
                      border: 1px solid rgba(255,255,255,0.12);
                      border-radius: 12px;
                      overflow: hidden;
                    }
                    #caravanConquestCanvas {
                      width: 100%;
                      height: 560px;
                      display: block;
                      cursor: grab;
                    }
                    #caravanConquestCanvas:active { cursor: grabbing; }
                    .canvas-toolbar {
                      display: flex;
                      flex-wrap: wrap;
                      gap: 0.45rem;
                      padding: 0.75rem;
                      background: rgba(10, 14, 23, 0.92);
                      border-bottom: 1px solid rgba(255,255,255,0.08);
                    }
                    .mode-btn {
                      padding: 0.38rem 0.75rem;
                      border-radius: 8px;
                      border: 1px solid rgba(212,175,55,0.35);
                      background: rgba(20, 28, 43, 0.9);
                      color: #E2E8F0;
                      font-size: 0.76rem;
                      font-weight: 600;
                      cursor: pointer;
                      transition: all 0.16s ease;
                    }
                    .mode-btn:hover, .mode-btn.active {
                      background: var(--gold);
                      color: #070A10;
                      border-color: #FFF;
                    }
                    .hud-panel {
                      background: var(--bg-card);
                      border: 1px solid rgba(255,255,255,0.1);
                      border-radius: 12px;
                      padding: 1.15rem;
                      display: flex;
                      flex-direction: column;
                      gap: 0.75rem;
                    }
                    .hud-tag {
                      display: inline-block;
                      padding: 0.22rem 0.6rem;
                      border-radius: 6px;
                      font-size: 0.72rem;
                      font-weight: 700;
                      background: rgba(212,175,55,0.2);
                      color: #FDE68A;
                      width: fit-content;
                    }
                    .hud-title {
                      font-size: 1.15rem;
                      color: #FFF;
                      font-weight: 700;
                    }
                    .hud-arabic {
                      font-size: 1.05rem;
                      color: var(--gold);
                      font-family: 'Traditional Arabic', serif;
                    }
                    .hud-box {
                      background: rgba(7, 10, 16, 0.65);
                      border: 1px solid rgba(255,255,255,0.08);
                      border-radius: 8px;
                      padding: 0.65rem 0.8rem;
                      font-size: 0.82rem;
                    }
                    .hud-box strong {
                      display: block;
                      color: #93C5FD;
                      font-size: 0.73rem;
                      text-transform: uppercase;
                      letter-spacing: 0.05em;
                      margin-bottom: 0.2rem;
                    }
                    .cards-grid {
                      display: grid;
                      grid-template-columns: repeat(auto-fit, minmax(560px, 1fr));
                      gap: 1.25rem;
                    }
                    @media (max-width: 700px) {
                      .cards-grid { grid-template-columns: 1fr; }
                    }
                    .stage-card, .codex-card {
                      background: var(--bg-card);
                      border: 1px solid rgba(255,255,255,0.1);
                      border-radius: 14px;
                      padding: 1.35rem;
                      display: flex;
                      flex-direction: column;
                      gap: 0.75rem;
                    }
                    .stage-head {
                      display: flex;
                      justify-content: space-between;
                      align-items: center;
                      flex-wrap: wrap;
                      gap: 0.5rem;
                    }
                    .stage-badge {
                      padding: 0.25rem 0.65rem;
                      border-radius: 6px;
                      font-size: 0.73rem;
                      font-weight: 800;
                      letter-spacing: 0.04em;
                    }
                    .stage-date {
                      font-size: 0.78rem;
                      color: #94A3B8;
                      font-family: monospace;
                    }
                    .stage-card h3, .codex-card h3 {
                      font-size: 1.15rem;
                      color: #FFF;
                    }
                    .arabic-sub {
                      color: var(--gold);
                      font-size: 1.05rem;
                      font-family: 'Traditional Arabic', serif;
                    }
                    .chronicler-line {
                      font-size: 0.85rem;
                      color: #A7F3D0;
                    }
                    .field-grid {
                      display: grid;
                      grid-template-columns: 1fr 1fr;
                      gap: 0.75rem;
                    }
                    @media (max-width: 640px) {
                      .field-grid { grid-template-columns: 1fr; }
                    }
                    .field-box {
                      background: rgba(8, 11, 18, 0.7);
                      border: 1px solid rgba(255,255,255,0.08);
                      border-radius: 8px;
                      padding: 0.75rem;
                    }
                    .field-box.highlight {
                      border-color: rgba(16, 185, 129, 0.4);
                      background: rgba(16, 185, 129, 0.07);
                    }
                    .field-box .lbl {
                      display: block;
                      font-size: 0.72rem;
                      font-weight: 700;
                      text-transform: uppercase;
                      color: #FDE68A;
                      margin-bottom: 0.3rem;
                      letter-spacing: 0.04em;
                    }
                    .field-box p {
                      font-size: 0.84rem;
                      color: #E2E8F0;
                    }
                    .quran-footer {
                      margin-top: auto;
                      padding-top: 0.6rem;
                      border-top: 1px dashed rgba(255,255,255,0.14);
                      font-size: 0.8rem;
                      color: #93C5FD;
                    }
                    .table-wrap {
                      overflow-x: auto;
                      background: var(--bg-panel);
                      border: 1px solid var(--border);
                      border-radius: 14px;
                      margin-top: 1rem;
                    }
                    table {
                      width: 100%;
                      border-collapse: collapse;
                      font-size: 0.83rem;
                    }
                    th, td {
                      padding: 0.85rem 0.9rem;
                      text-align: left;
                      border-bottom: 1px solid rgba(255,255,255,0.08);
                      vertical-align: top;
                    }
                    th {
                      background: rgba(212, 175, 55, 0.14);
                      color: #FDE68A;
                      font-size: 0.75rem;
                      text-transform: uppercase;
                      letter-spacing: 0.05em;
                    }
                    tr:hover td {
                      background: rgba(255,255,255,0.025);
                    }
                    .mono-sm {
                      font-family: monospace;
                      font-size: 0.72rem;
                      color: #94A3B8;
                    }
                    .arabic-inline {
                      color: var(--gold);
                      font-family: 'Traditional Arabic', serif;
                      font-size: 0.95rem;
                    }
                    .cite-pill {
                      display: inline-block;
                      padding: 0.2rem 0.5rem;
                      border-radius: 6px;
                      background: rgba(56, 189, 248, 0.12);
                      border: 1px solid rgba(56, 189, 248, 0.35);
                      color: #7DD3FC;
                      font-size: 0.74rem;
                    }
                  </style>
                </head>
                <body>
                  <section class="hero">
                    <div class="eyebrow">Portal #51 • Al-'Īr, Al-Maghāzī, Al-Fatḥ &amp; At-Tadwīn</div>
                    <h1>Canonical Islamic Caravans, Battles for Trade, Founding of Conquest &amp; Recording of Conquest</h1>
                    <div class="arabic-hero">القوافل القرآنية (رحلة الشتاء والصيف) • سرايا وغزوات التجارة • تأسيس الفتح المبين • تدوين المغازي وفتوح البلدان وديوان الخراج</div>
                    <p class="lead">
                      In canonical Islamic history and jurisprudence, <strong>Conquest (<em>Al-Fatḥ</em> — "The Opening")</strong> did not emerge from arbitrary territorial ambition.
                      It followed a strict, four-stage theological, economic, and historiographical progression rooted in the Qur'an and Prophetic <em>Sīrah</em>:
                      from the <strong>Winter and Summer Caravans of Quraysh (<em>Surah Quraysh</em> 106:1–4)</strong>, through the <strong>Battles for Trade (<em>Nakhlah, Badr's Al-'Īr vs. An-Nafīr, and Al-Qaradah</em>)</strong>
                      that reclaimed confiscated <em>Muhājirūn</em> wealth and broke Meccan oligarchic blockades, to the <strong>Founding of Conquest (<em>Ṣulḥ Al-Ḥudaybiyyah, Fatḥ Makkah, Tabūk's Aylah Charter, and the Ribāṭ-Caravanserai Commonwealth</em>)</strong>,
                      culminating in the <strong>Canonical Recording of Conquest (<em>Tadwīn Al-Maghāzī, 'Umar's Dīwān Al-Jund &amp; Sawād Waqf Survey, Al-Wāqidī, Al-Balādhurī's Futūḥ Al-Buldān, and Ottoman Tapu Tahrir Defters</em>)</strong>.
                    </p>
                    <div class="pillar-strip">
                      <div class="pillar-box">
                        <h4>1. Canonical Caravans (Al-'Īr &amp; Īlāf)</h4>
                        <p>Hāshim's <em>Īlāf</em> safe-conduct treaties (Qur'an 106:1–4) linked Yemen's winter frankincense/spice route to Syria's summer grain/olive-oil route—until Quraysh forfeited their covenant by expelling the believers and weaponizing caravan capital.</p>
                      </div>
                      <div class="pillar-box">
                        <h4>2. Battles for Trade (Al-'Īr vs. An-Nafīr)</h4>
                        <p>Medina projected sovereignty across the Red Sea coast (<em>Sarāyā</em> &amp; <em>Nakhlah</em>, Qur'an 2:217), met Abu Sufyan's 1,000-camel caravan and Abu Jahl's army at <em>Badr</em> (Qur'an 8:7), and sealed the Iraqi silver route at <em>Al-Qaradah</em>.</p>
                      </div>
                      <div class="pillar-box">
                        <h4>3. Founding of Conquest (Ta'sīs Al-Fatḥ)</h4>
                        <p><em>Al-Ḥudaybiyyah</em> (Qur'an 48:1) and <em>Fatḥ Makkah</em> replaced pagan toll-extortion and <em>Ribā</em> with bloodless amnesty (<em>At-Ṭulaqā'</em>), while <em>Tabūk</em>'s Aylah treaty guaranteed safe-conduct for ships at sea and caravans on land.</p>
                      </div>
                      <div class="pillar-box">
                        <h4>4. Recording of Conquest (At-Tadwīn &amp; Dīwān)</h4>
                        <p>Prophetic silver-sealed leather charters, Caliph 'Umar's 36M-<em>Jarīb</em> <em>Sawād Waqf</em> cadastre (Qur'an 59:7–10), Al-Wāqidī's field topography, and Al-Balādhurī's <em>Ṣulḥan</em> vs. <em>'Anwatan</em> constitutional ledger.</p>
                      </div>
                    </div>
                  </section>

                  <main class="container">
                    <div class="section-title">
                      <h2>I. Interactive 2.5D Caravan Trade Arteries, Battle Interceptions &amp; Tadwīn Chancery Map</h2>
                      <span>CLICK ANY NODE OR FILTER LAYER • ANIMATE WINTER/SUMMER CARAVANS &amp; MEDINAN VECTORS</span>
                    </div>

                    <div class="map-shell">
                      <div class="canvas-wrap">
                        <div class="canvas-toolbar">
                          <button class="mode-btn active" onclick="setCaravanFilter('all', this)">All 7 Stages &amp; Routes</button>
                          <button class="mode-btn" onclick="setCaravanFilter('ilaf', this)">Stage I–II: Īlāf &amp; Red Sea Sarāyā</button>
                          <button class="mode-btn" onclick="setCaravanFilter('badr', this)">Stage III–IV: Badr ('Īr vs Nafīr) &amp; Al-Qaradah Silver</button>
                          <button class="mode-btn" onclick="setCaravanFilter('fath', this)">Stage V–VII: Fatḥ Makkah, Tabūk &amp; Ribāṭ Network</button>
                          <button class="mode-btn" onclick="setCaravanFilter('tadwin', this)">Tadwīn Layer: 7 Recording Codices &amp; Dīwān Hubs</button>
                        </div>
                        <canvas id="caravanConquestCanvas" width="920" height="560"></canvas>
                      </div>
                      <aside class="hud-panel" id="caravanHud">
                        <span class="hud-tag" id="hudTag">STAGE #3 • YAWM AL-FURQĀN (17 RAMADAN 2 AH)</span>
                        <div class="hud-title" id="hudTitle">Wells of Badr: The Great Caravan (Al-'Īr) vs. The War-Host (An-Nafīr)</div>
                        <div class="hud-arabic" id="hudArabic">يوم الفرقان ببدر: العير والنفير (سورة الأنفال ٨:٧)</div>
                        <div class="hud-box">
                          <strong>Caravan Route &amp; Cargo</strong>
                          <span id="hudCargo">Abu Sufyan's 1,000-camel Gaza-to-Mecca joint-stock caravan carrying 50,000 gold Dinars along the Red Sea coastal artery.</span>
                        </div>
                        <div class="hud-box">
                          <strong>Battle for Trade &amp; Strategic Interception</strong>
                          <span id="hudBattle">313 believers marched from Medina; Abu Sufyan diverted the caravan along the coastal salt-flats while Abu Jahl's 950 armored warriors were defeated at the water-wells of Badr.</span>
                        </div>
                        <div class="hud-box">
                          <strong>Founding &amp; Recording of Conquest (Al-Fatḥ &amp; Tadwīn)</strong>
                          <span id="hudRecording">Qur'an 8:7 &amp; 8:41 established the sovereign Fifth (Khums) and the precedence of Ahl Badr as the #1 tier in Caliph 'Umar's Diwan Al-Jund.</span>
                        </div>
                        <div class="hud-box">
                          <strong>Cross-Linked Sovereign Portals</strong>
                          <span id="hudLinks">
                            <a href="conjoined-worlds-realms-principles-node-grid.html" style="color:#34D399;">3D Meridian Node Grid</a> •
                            <a href="order-3-sapphire.html" style="color:#38BDF8;">Order #3 Sapphire</a> •
                            <a href="world-5-furqan-hawa.html" style="color:#F43F5E;">World #5 Al-Furqan</a>
                          </span>
                        </div>
                      </aside>
                    </div>

                    <div class="section-title">
                      <h2>II. The 7 Canonical Caravans &amp; Battles for Trade Leading to the Founding of Conquest</h2>
                      <span>SURAH QURAYSH (106:1–4) → NAKHLAH (2:217) → BADR (8:7) → AL-QARADAH → FATḤ MAKKAH (48:1) → TABŪK → RIBĀṬ</span>
                    </div>
                    <div class="cards-grid">
                      __STAGE_CARDS__
                    </div>

                    <div class="section-title">
                      <h2>III. Master Comparative Matrix: Caravans, Trade Battles &amp; Founding of Conquest</h2>
                      <span>COMPLETE 7-STAGE TELEMETRY</span>
                    </div>
                    <div class="table-wrap">
                      <table>
                        <thead>
                          <tr>
                            <th>Stage</th>
                            <th>Title &amp; Chronology</th>
                            <th>Caravan Route &amp; Commodities</th>
                            <th>Battle for Trade Dynamics</th>
                            <th>Founding of Conquest Outcome</th>
                            <th>Qur'anic &amp; Sīrah Anchor</th>
                          </tr>
                        </thead>
                        <tbody>
                          __STAGE_TABLE_ROWS__
                        </tbody>
                      </table>
                    </div>

                    <div class="section-title">
                      <h2>IV. The 7 Canonical Codices &amp; Institutions for the Recording of Conquest (Tadwīn Al-Maghāzī wa Al-Futūḥ)</h2>
                      <span>PROPHETIC SILVER SEAL → 'UMAR'S DĪWĀN &amp; SAWĀD WAQF → SĪRAH/MAGHĀZĪ → WĀQIDĪ → BALĀDHURĪ → MASĀLIK/SIKKA → TAPU TAHRIR</span>
                    </div>
                    <div class="cards-grid">
                      __CODEX_CARDS__
                    </div>

                    <div class="section-title">
                      <h2>V. Cadastral &amp; Historiographical Ledger of Conquest Recording (At-Tadwīn)</h2>
                      <span>CONSTITUTIONAL DISTINCTION BETWEEN ṢULḤAN (TREATY) &amp; 'ANWATAN (FORCE) + PUBLIC WAQF IMMOBILIZATION</span>
                    </div>
                    <div class="table-wrap">
                      <table>
                        <thead>
                          <tr>
                            <th>Codex</th>
                            <th>Title &amp; Era</th>
                            <th>Chronicler / Chancery</th>
                            <th>Archival Medium &amp; Survey Methodology</th>
                            <th>Constitutional &amp; Fiscal Governance Rule</th>
                            <th>Primary Proof</th>
                          </tr>
                        </thead>
                        <tbody>
                          __CODEX_TABLE_ROWS__
                        </tbody>
                      </table>
                    </div>
                  </main>

                  <script>
                    const MAP_NODES = [
                      {
                        id: "SANAA_YEMEN", x: 520, y: 495, color: "#F8F5E6", group: "ilaf",
                        tag: "STAGE #1 • WINTER CARAVAN TERMINUS (RIḤLAT ASH-SHITĀ')",
                        title: "Ṣan'ā' & Aden (Yemen / Saba'): The Southern Winter Spice & Incense Hub",
                        arabic: "رحلة الشتاء إلى اليمن: مأرب وصنعاء وعدن (إيلاف قريش ١٠٦:١-٤)",
                        cargo: "Frankincense (Luban), myrrh, Yemeni leather (Adim), Suhuli white cotton textiles, Indian Ocean spices, and Abyssinian gold dust.",
                        battle: "Hashim ibn 'Abd Manaf secured the Ilaf safe-conduct treaty with the Himyarite/Abyssinian rulers so Quraysh caravans travelled unmolested.",
                        recording: "Later recorded as the first provincial fiscal treaty in Medina's chancery (Mu'adh ibn Jabal & the leather/textile Jizyah/Zakat scrolls of Yemen)."
                      },
                      {
                        id: "MAKKAH_HARAM", x: 430, y: 365, color: "#F43F5E", group: "fath",
                        tag: "STAGE #1 & #5 • UMM AL-QURĀ & FATḤ MAKKAH (RAMADAN 8 AH)",
                        title: "Makkah Al-Mukarramah: Sanctuary of Abraham & The Clear Conquest (Al-Fatḥ Al-Mubīn)",
                        arabic: "مكة المكرمة: البيت الحرام والفتح المبين (سورة الفتح ٤٨:١، التوبة ٩:٢٨)",
                        cargo: "Central clearinghouse joining the Winter Yemeni caravan to the Summer Syrian caravan; purified in 8 AH of pagan idol-tolls and Riba.",
                        battle: "After Quraysh broke the Hudaybiyyah truce, the Prophet ﷺ entered Mecca from four cardinal directions with 10,000 troops in a bloodless conquest.",
                        recording: "Proclaimed 'Antum at-Tulaqa'' (general amnesty) and abolished pre-Islamic usury in the Khutbat al-Fath, recorded in Bukhari and Muslim."
                      },
                      {
                        id: "NAKHLAH_PASS", x: 455, y: 340, color: "#A78BFA", group: "ilaf",
                        tag: "STAGE #2 • SARIYYAT NAKHLAH (RAJAB 2 AH / 624 CE)",
                        title: "Wādī Nakhlah: First Caravan Prize & Revelation of Qur'an 2:217",
                        arabic: "سرية بطن نخلة: أول غنيمة وخمس في الإسلام (البقرة ٢:٢١٧)",
                        cargo: "Quraysh caravan from Ta'if carrying raisins, tanned leather hides, and merchandise led by 'Amr ibn al-Hadrami.",
                        battle: "'Abdullah ibn Jahsh's 8-12 Muhajirun scouts intercepted the caravan on the last day of Rajab, seizing the caravan and bringing it to Medina.",
                        recording: "Qur'an 2:217 ruled that expelling believers from Al-Masjid Al-Haram is graver than Quraysh's pretext; here the first 1/5 Khums division was recorded."
                      },
                      {
                        id: "HUDAYBIYYAH", x: 405, y: 360, color: "#F43F5E", group: "fath",
                        tag: "STAGE #5 & CODEX #1 • ṢULḤ AL-ḤUDAYBIYYAH (6 AH / 628 CE)",
                        title: "Al-Ḥudaybiyyah: The Trade-Road Peace Treaty Naming Peace 'The Clear Conquest'",
                        arabic: "صلح الحديبية وبيعة الرضوان: إِنَّا فَتَحْنَا لَكَ فَتْحًا مُبِينًا (٤٨:١)",
                        cargo: "Reopened all Hijazi trade roads to safe passage between Medina, Mecca, and allied tribes for 10 years.",
                        battle: "1,400 Companions pledged Bay'at Ar-Ridwan under the tree; Quraysh envoy Suhayl ibn 'Amr signed the truce recognizing Medina as an equal sovereign.",
                        recording: "Written by 'Ali ibn Abi Talib in duplicate leather scrolls and sealed with the Prophet's three-line silver ring ('Muhammad / Rasul / Allah')."
                      },
                      {
                        id: "MADINAH_DIWAN", x: 405, y: 270, color: "#10B981", group: "tadwin",
                        tag: "CHANCERY CAPITAL • CODEX #1, #2, #3 & #4 (1–207 AH)",
                        title: "Al-Madīnah Al-Munawwarah: Prophetic Chancery, 'Umar's Dīwān & Maghāzī Archive",
                        arabic: "المدينة المنورة: دار الهجرة وصحيفة المدينة وديوان عمر وتدوين المغازي",
                        cargo: "Sovereign sanctuary governing the Red Sea & Najd trade corridors; grain imports via Jar port and Yamamah.",
                        battle: "Base of all 27 Ghazawat and 38+ Saraya; defended at Uhud and Al-Khandaq (the Trench).",
                        recording: "Seat of Sahifat Al-Madinah, Caliph 'Umar's Diwan Al-Jund (15-20 AH), 'Urwah ibn az-Zubayr, Az-Zuhri, Ibn Ishaq, and Al-Waqidi's empirical Maghazi surveys."
                      },
                      {
                        id: "BADR_WELLS", x: 365, y: 285, color: "#38BDF8", group: "badr",
                        tag: "STAGE #3 • YAWM AL-FURQĀN (17 RAMADAN 2 AH / 624 CE)",
                        title: "Wells of Badr: The Great Syrian Caravan (Al-'Īr) vs. The Meccan War-Host (An-Nafīr)",
                        arabic: "بدر الكبرى: يوم الفرقان بين العير والنفير (سورة الأنفال ٨:٧، ٨:٤١)",
                        cargo: "Abu Sufyan's 1,000-camel Syrian caravan carrying 50,000 gold Dinars of Meccan joint-stock capital.",
                        battle: "Medina's 313 believers seized the Badr water-wells; while the caravan escaped along the coast, Abu Jahl's 950-man oligarchic army was decisively shattered.",
                        recording: "Qur'an 8:41 codified the distribution of spoils, captives were ransomed by teaching Medinan children to read and write, and Ahl Badr headed 'Umar's Diwan."
                      },
                      {
                        id: "AL_IS_COAST", x: 355, y: 235, color: "#A78BFA", group: "badr",
                        tag: "STAGE #2 & #4 • SARIYYAT AL-'ĪṢ & SĪF AL-BAḤR (1–6 AH)",
                        title: "Al-'Īṣ & Red Sea Coast: Western Caravan Bottleneck & Final Blockade",
                        arabic: "العيس وسيف البحر: ممر القوافل الساحلي إلى الشام",
                        cargo: "Syrian silver and olive-oil caravans passing between Yanbu', Al-'Is, and Wadi al-Qura.",
                        battle: "Early patrols of Hamzah and 'Ubaydah projected Medinan presence here; in Jumada I, 6 AH, Zayd ibn Harithah captured Abu al-'As's Syrian silver caravan at Al-'Is.",
                        recording: "The caravan property was returned intact to Abu al-'As upon his embrace of Islam, proving Islamic caravan interception was legal restitution, not brigandage."
                      },
                      {
                        id: "AL_QARADAH_NAJD", x: 505, y: 265, color: "#D4AF37", group: "badr",
                        tag: "STAGE #4 • SARIYYAT AL-QARADAH (JUMADA II, 3 AH / Nov 624 CE)",
                        title: "Al-Qaradah (Najd Water-Spring): Interception of the Eastern Iraqi Silver Caravan",
                        arabic: "سرية القردة بنجد: اعتراض قافلة فضة قريش على طريق العراق",
                        cargo: "Safwan ibn Umayyah's caravan carrying 100,000 Dirhams of silver vessels, ingots, and bullion via the eastern Najd desert bypass.",
                        battle: "When Badr closed the Red Sea route, Quraysh tried the Iraqi route guided by Furat ibn Hayyan; Zayd ibn Harithah ambushed and captured the entire silver caravan.",
                        recording: "Recorded by Al-Waqidi (1/197) and Bukhari (4023): sealed Quraysh's last trade bypass and brought guide Furat ibn Hayyan into Islam."
                      },
                      {
                        id: "KHAYBAR_OASIS", x: 400, y: 215, color: "#F43F5E", group: "fath",
                        tag: "STAGE #5 & CODEX #1 • FATḤ KHAYBAR & FADAK (MUHARRAM 7 AH)",
                        title: "Khaybar & Wādī Al-Qurā: Agricultural Muzāra'ah Sharecropping Charter",
                        arabic: "خيبر ووادي القرى: عقد المساقاة والمزارعة النبوي",
                        cargo: "Northern Hijaz date-palm and grain oases along the Syrian trade road.",
                        battle: "Opened in 7 AH after the confederates of Al-Ahzab were neutralized, securing the northern trade road.",
                        recording: "Established the canonical Musaqat/Muzara'ah contract (50% harvest share) audited annually by 'Abdullah ibn Rawahah's just appraisal."
                      },
                      {
                        id: "TABUK_AYLAH", x: 325, y: 155, color: "#B87333", group: "fath",
                        tag: "STAGE #6 & CODEX #1 • GHAZWAT TABŪK & TREATY OF AYLAH (9 AH / 630 CE)",
                        title: "Tabūk & Port of Aylah (Aqaba): Charter of Safe-Conduct on Land and Sea",
                        arabic: "تبوك وأيلة: كتاب الأمان النبوي للسفن في البحر والسيارة في البر",
                        cargo: "Maritime Red Sea shipping at Aylah and Nabataean/Syrian olive-oil and grain caravans.",
                        battle: "The Prophet ﷺ marched with 30,000 companions to Tabuk; Byzantine frontier towns (Aylah, Adhruh, Jarba, Maqna, Dumat al-Jandal) entered peaceful Sulh treaties.",
                        recording: "The Treaty of Aylah ('Safe-conduct for their ships at sea and their caravans on land') became the constitutional template recorded in Al-Baladhuri's Futuh Al-Buldan."
                      },
                      {
                        id: "GAZA_DAMASCUS_SHAM", x: 330, y: 85, color: "#10B981", group: "tadwin",
                        tag: "STAGE #1, #6 & CODEX #5–#7 • GAZA, BUSRA, DAMASCUS & ISTANBUL",
                        title: "Gaza, Busra & Damascus (Ash-Shām): Summer Caravan Terminus, Gold Dinar Mint & Ottoman Defterhane",
                        arabic: "غزة وبصرى ودمشق: رحلة الصيف، دار ضرب الدينار الذهبي، ودفاتر الطابو",
                        cargo: "Mediterranean olive oil, Hauran wheat, Syrian glass, silk brocades, and Caliph 'Abd al-Malik's 4.25g epigraphic Gold Dinars.",
                        battle: "Hashim's tomb at Gaza anchored the Summer Caravan; opened in 13-15 AH (Ajnadayn, Damascus Sulh treaty, Yarmuk) under Khalid and Abu 'Ubaydah.",
                        recording: "Damascus minted the first purely epigraphic Islamic Gold Dinar (77 AH / 696 CE); later Ottoman Tapu Tahrir and Matrakci Nasuh's 2.5D miniatures mapped every Sultan Han caravanserai."
                      },
                      {
                        id: "SAWAD_BAGHDAD_IRAQ", x: 565, y: 125, color: "#D4AF37", group: "tadwin",
                        tag: "STAGE #6–#7 & CODEX #2–#6 • SAWĀD AL-'IRĀQ, KŪFAH, BASRA & BAGHDAD",
                        title: "Arḍ As-Sawād & Baghdad: 36-Million-Jarīb Waqf Cadastre, Futūḥ Al-Buldān & Darb Zubaydah",
                        arabic: "سواد العراق وبغداد: مسح عمر بن الخطاب (٣٦ مليون جريب وقفاً) وفتوح البلدان للبلاذري",
                        cargo: "Mesopotamian grain, textiles, paper (Kaghad), Persian Gulf pearl/spice maritime trade via Basra, and Darb Zubaydah pilgrim/merchant caravans.",
                        battle: "Opened under Sa'd ibn Abi Waqqas (Al-Qadisiyyah & Al-Mada'in, 15-16 AH) and connected to Central Asian Silk Road (Merv, Bukhara, Samarkand).",
                        recording: "Caliph 'Umar surveyed 36,000,000 Jarib as perpetual public Waqf (Qur'an 59:7-10); Al-Baladhuri composed Futuh Al-Buldan and Ibn Khordadbeh mapped Al-Masalik in Baghdad."
                      }
                    ];

                    const ROUTES = [
                      { from: "MAKKAH_HARAM", to: "SANAA_YEMEN", color: "#F8F5E6", label: "Winter Caravan (Riḥlat Ash-Shitā')", group: "ilaf", dashed: false },
                      { from: "MAKKAH_HARAM", to: "NAKHLAH_PASS", color: "#A78BFA", label: "Ta'if / Nakhlah Route", group: "ilaf", dashed: false },
                      { from: "MAKKAH_HARAM", to: "HUDAYBIYYAH", color: "#F43F5E", label: "Ḥudaybiyyah / Fatḥ Corridor", group: "fath", dashed: false },
                      { from: "MAKKAH_HARAM", to: "BADR_WELLS", color: "#38BDF8", label: "Coastal Caravan Artery (Al-'Īr)", group: "badr", dashed: false },
                      { from: "BADR_WELLS", to: "AL_IS_COAST", color: "#38BDF8", label: "Red Sea Trade Route", group: "badr", dashed: false },
                      { from: "AL_IS_COAST", to: "TABUK_AYLAH", color: "#B87333", label: "Summer Caravan to Aylah", group: "fath", dashed: false },
                      { from: "TABUK_AYLAH", to: "GAZA_DAMASCUS_SHAM", color: "#10B981", label: "Summer Caravan (Riḥlat Aṣ-Ṣayf)", group: "ilaf", dashed: false },
                      { from: "MAKKAH_HARAM", to: "AL_QARADAH_NAJD", color: "#D4AF37", label: "Eastern Iraqi Silver Bypass", group: "badr", dashed: true },
                      { from: "AL_QARADAH_NAJD", to: "SAWAD_BAGHDAD_IRAQ", color: "#D4AF37", label: "Najd–Sawād Silver & Darb Zubaydah", group: "tadwin", dashed: true },
                      { from: "MADINAH_DIWAN", to: "BADR_WELLS", color: "#38BDF8", label: "Badr Interception Vector (2 AH)", group: "badr", dashed: false },
                      { from: "MADINAH_DIWAN", to: "AL_IS_COAST", color: "#A78BFA", label: "Al-'Īṣ Patrol Vector", group: "badr", dashed: false },
                      { from: "MADINAH_DIWAN", to: "AL_QARADAH_NAJD", color: "#D4AF37", label: "Zayd's Al-Qaradah Vector (3 AH)", group: "badr", dashed: false },
                      { from: "MADINAH_DIWAN", to: "MAKKAH_HARAM", color: "#F43F5E", label: "Hijrah & Fatḥ Makkah Axis (8 AH)", group: "fath", dashed: false },
                      { from: "MADINAH_DIWAN", to: "KHAYBAR_OASIS", color: "#F43F5E", label: "Khaybar Vector (7 AH)", group: "fath", dashed: false },
                      { from: "KHAYBAR_OASIS", to: "TABUK_AYLAH", color: "#B87333", label: "Tabūk Expedition Axis (9 AH)", group: "fath", dashed: false },
                      { from: "GAZA_DAMASCUS_SHAM", to: "SAWAD_BAGHDAD_IRAQ", color: "#10B981", label: "Fertile Crescent Ribāṭ / Barīd Highway", group: "tadwin", dashed: false }
                    ];

                    let activeFilter = 'all';
                    let selectedNode = MAP_NODES[5]; // Default to Badr
                    let animTick = 0;

                    function setCaravanFilter(filter, btn) {
                      activeFilter = filter;
                      document.querySelectorAll('.mode-btn').forEach(b => b.classList.remove('active'));
                      if (btn) btn.classList.add('active');
                    }

                    function updateHud(node) {
                      selectedNode = node;
                      document.getElementById('hudTag').textContent = node.tag;
                      document.getElementById('hudTag').style.color = node.color;
                      document.getElementById('hudTitle').textContent = node.title;
                      document.getElementById('hudArabic').textContent = node.arabic;
                      document.getElementById('hudCargo').textContent = node.cargo;
                      document.getElementById('hudBattle').textContent = node.battle;
                      document.getElementById('hudRecording').textContent = node.recording;
                    }

                    const canvas = document.getElementById('caravanConquestCanvas');
                    const ctx = canvas.getContext('2d');

                    canvas.addEventListener('click', (e) => {
                      const rect = canvas.getBoundingClientRect();
                      const scaleX = canvas.width / rect.width;
                      const scaleY = canvas.height / rect.height;
                      const mx = (e.clientX - rect.left) * scaleX;
                      const my = (e.clientY - rect.top) * scaleY;
                      for (const n of MAP_NODES) {
                        const dx = mx - n.x;
                        const dy = my - n.y;
                        if (Math.sqrt(dx * dx + dy * dy) <= 18) {
                          updateHud(n);
                          break;
                        }
                      }
                    });

                    function drawMap() {
                      animTick += 0.008;
                      ctx.clearRect(0, 0, canvas.width, canvas.height);

                      // Subtle isometric coordinate grid
                      ctx.strokeStyle = 'rgba(212, 175, 55, 0.07)';
                      ctx.lineWidth = 1;
                      for (let x = 0; x < canvas.width; x += 45) {
                        ctx.beginPath();
                        ctx.moveTo(x, 0);
                        ctx.lineTo(x, canvas.height);
                        ctx.stroke();
                      }
                      for (let y = 0; y < canvas.height; y += 45) {
                        ctx.beginPath();
                        ctx.moveTo(0, y);
                        ctx.lineTo(canvas.width, y);
                        ctx.stroke();
                      }

                      // Draw Red Sea (Bahr Al-Qulzum) & Persian Gulf water contours
                      ctx.fillStyle = 'rgba(14, 116, 144, 0.22)';
                      ctx.strokeStyle = 'rgba(56, 189, 248, 0.35)';
                      ctx.lineWidth = 1.5;
                      ctx.beginPath();
                      ctx.moveTo(230, 140);
                      ctx.lineTo(315, 155);
                      ctx.lineTo(345, 290);
                      ctx.lineTo(415, 440);
                      ctx.lineTo(460, 535);
                      ctx.lineTo(335, 545);
                      ctx.lineTo(220, 320);
                      ctx.closePath();
                      ctx.fill();
                      ctx.stroke();

                      ctx.fillStyle = 'rgba(56, 189, 248, 0.45)';
                      ctx.font = 'italic 12px Georgia, serif';
                      ctx.fillText('Baḥr Al-Qulzum (Red Sea)', 235, 360);

                      // Persian Gulf
                      ctx.fillStyle = 'rgba(14, 116, 144, 0.20)';
                      ctx.beginPath();
                      ctx.moveTo(615, 165);
                      ctx.lineTo(750, 255);
                      ctx.lineTo(790, 320);
                      ctx.lineTo(680, 340);
                      ctx.lineTo(590, 210);
                      ctx.closePath();
                      ctx.fill();
                      ctx.stroke();
                      ctx.fillStyle = 'rgba(56, 189, 248, 0.45)';
                      ctx.fillText('Al-Khalīj / Sea of Basra', 645, 285);

                      // Draw Routes & Animated Caravan Packets
                      const nodeMap = {};
                      MAP_NODES.forEach(n => nodeMap[n.id] = n);

                      ROUTES.forEach((r, idx) => {
                        const n1 = nodeMap[r.from];
                        const n2 = nodeMap[r.to];
                        const visible = (activeFilter === 'all' || activeFilter === r.group);
                        ctx.save();
                        ctx.strokeStyle = r.color;
                        ctx.globalAlpha = visible ? 0.82 : 0.16;
                        ctx.lineWidth = visible ? 2.6 : 1.2;
                        if (r.dashed) ctx.setLineDash([6, 5]);
                        ctx.beginPath();
                        ctx.moveTo(n1.x, n1.y);
                        ctx.lineTo(n2.x, n2.y);
                        ctx.stroke();

                        if (visible) {
                          const t = (animTick + idx * 0.17) % 1;
                          const cx = n1.x + (n2.x - n1.x) * t;
                          const cy = n1.y + (n2.y - n1.y) * t;
                          ctx.fillStyle = '#FFF';
                          ctx.shadowColor = r.color;
                          ctx.shadowBlur = 10;
                          ctx.beginPath();
                          ctx.arc(cx, cy, 4.2, 0, Math.PI * 2);
                          ctx.fill();
                        }
                        ctx.restore();
                      });

                      // Draw Nodes
                      MAP_NODES.forEach(n => {
                        const visible = (activeFilter === 'all' || activeFilter === n.group || n.id === 'MADINAH_DIWAN' || n.id === 'MAKKAH_HARAM');
                        const isSelected = (selectedNode && selectedNode.id === n.id);
                        ctx.save();
                        ctx.globalAlpha = visible ? 1.0 : 0.28;

                        if (isSelected) {
                          ctx.strokeStyle = '#FFF';
                          ctx.lineWidth = 2.5;
                          ctx.beginPath();
                          ctx.arc(n.x, n.y, 17 + Math.sin(animTick * 8) * 2.5, 0, Math.PI * 2);
                          ctx.stroke();
                        }

                        ctx.fillStyle = '#0B101B';
                        ctx.strokeStyle = n.color;
                        ctx.lineWidth = 3;
                        ctx.beginPath();
                        ctx.arc(n.x, n.y, 11, 0, Math.PI * 2);
                        ctx.fill();
                        ctx.stroke();

                        ctx.fillStyle = n.color;
                        ctx.beginPath();
                        ctx.arc(n.x, n.y, 4.5, 0, Math.PI * 2);
                        ctx.fill();

                        ctx.fillStyle = '#F8FAFC';
                        ctx.font = 'bold 11.5px Segoe UI, sans-serif';
                        ctx.fillText(n.title.split(':')[0], n.x + 15, n.y + 4);
                        ctx.restore();
                      });

                      // Compass / Legend overlay
                      ctx.fillStyle = 'rgba(15, 21, 33, 0.88)';
                      ctx.strokeStyle = 'rgba(212, 175, 55, 0.35)';
                      ctx.lineWidth = 1;
                      ctx.fillRect(16, 16, 255, 92);
                      ctx.strokeRect(16, 16, 255, 92);
                      ctx.fillStyle = '#FDE68A';
                      ctx.font = 'bold 11px monospace';
                      ctx.fillText('2.5D CARAVAN & MAGHĀZĪ ATLAS', 28, 36);
                      ctx.fillStyle = '#CBD5E1';
                      ctx.font = '11px Segoe UI, sans-serif';
                      ctx.fillText('• Click any station to inspect Tadwīn record', 28, 56);
                      ctx.fillText('• Solid lines: Coastal & Syrian/Yemeni Ilāf', 28, 74);
                      ctx.fillText('• Dashed lines: Najd–Iraqi Silver Bypass', 28, 92);

                      requestAnimationFrame(drawMap);
                    }
                    drawMap();
                  </script>
                </body>
                </html>
                """;

        return template
                .replace("__STAGE_CARDS__", stageCardsHtml.toString())
                .replace("__STAGE_TABLE_ROWS__", stageTableRowsHtml.toString())
                .replace("__CODEX_CARDS__", codexCardsHtml.toString())
                .replace("__CODEX_TABLE_ROWS__", codexTableRowsHtml.toString());
    }

    private static String escape(String text) {
        if (text == null) {
            return "";
        }
        return text
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }

    private static String sha256(String content) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return HexFormat.of().formatHex(md.digest(content.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            throw new IllegalStateException("SHA-256 unavailable", e);
        }
    }
}
