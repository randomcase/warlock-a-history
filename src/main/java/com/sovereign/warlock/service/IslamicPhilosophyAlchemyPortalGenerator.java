package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.IslamicPhilosophyAlchemyTheocraciesAndMessages;
import com.sovereign.warlock.domain.IslamicPhilosophyAlchemyTheocraciesAndMessages.MessageSemanticShiftStage;
import com.sovereign.warlock.domain.IslamicPhilosophyAlchemyTheocraciesAndMessages.PhilosophyAndAlchemyEpoch;
import com.sovereign.warlock.domain.IslamicPhilosophyAlchemyTheocraciesAndMessages.SocraticCritiqueEngagement;
import com.sovereign.warlock.domain.IslamicPhilosophyAlchemyTheocraciesAndMessages.TheocracyAdjustmentProtocol;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Generates the interactive HTML5 portal for:
 * "Philosophy & Alchemy in Islam, Canonical Adjustments to Different Theocracies & Theocrats,
 *  Socratic Critiques (Suqrat Al-Hakim), and How the Meaning of Messages Changed During Expansion"
 * (islamic-philosophy-alchemy-theocracies-socratic-messages.html).
 */
public final class IslamicPhilosophyAlchemyPortalGenerator {

    public static final String PORTAL_FILENAME = "islamic-philosophy-alchemy-theocracies-socratic-messages.html";

    private IslamicPhilosophyAlchemyPortalGenerator() {
    }

    public static Path generatePortal(Path outputDirectory) throws IOException {
        Files.createDirectories(outputDirectory);
        Path targetFile = outputDirectory.resolve(PORTAL_FILENAME);
        String html = buildPortalHtml();
        Files.writeString(targetFile, html, StandardCharsets.UTF_8);
        return targetFile;
    }

    public static String buildPortalHtml() {
        StringBuilder alchemyCards = new StringBuilder();
        for (PhilosophyAndAlchemyEpoch e : IslamicPhilosophyAlchemyTheocraciesAndMessages.allSevenPhilosophyAndAlchemyEpochs()) {
            alchemyCards.append("""
                    <article class="matrix-card alchemy-card" data-search="%s %s %s %s">
                      <div class="card-header">
                        <span class="badge badge-gold">EPOCH %d &bull; %s</span>
                        <span class="badge badge-teal">%s</span>
                      </div>
                      <h3>%s</h3>
                      <p class="masters-line"><strong>Key Masters &amp; Works:</strong> %s</p>
                      <div class="split-detail">
                        <div class="detail-box box-falsafah">
                          <h4>&#x1F3DB; Philosophical Breakthrough (Al-Falsafah wa Al-&#x1E24;ikmah)</h4>
                          <p>%s</p>
                        </div>
                        <div class="detail-box box-kimiya">
                          <h4>&#x2697; Alchemical &amp; Scientific Transmutation (Al-K&#x12B;miy&#x101;')</h4>
                          <p>%s</p>
                        </div>
                      </div>
                      <div class="anchor-footer">
                        <span>&#x1F4D6; <strong>Canonical &amp; Qur'anic Anchor:</strong> %s</span>
                      </div>
                    </article>
                    """.formatted(
                    escapeHtml(e.epochCode()),
                    escapeHtml(e.titleAndSchool()),
                    escapeHtml(e.keyMastersAndWorks()),
                    escapeHtml(e.quranicAndCanonicalAnchor()),
                    e.epochIndex(),
                    escapeHtml(e.epochCode()),
                    escapeHtml(e.chronologicalSpan()),
                    escapeHtml(e.titleAndSchool()),
                    escapeHtml(e.keyMastersAndWorks()),
                    escapeHtml(e.philosophicalBreakthrough()),
                    escapeHtml(e.alchemicalAndScientificTransmutation()),
                    escapeHtml(e.quranicAndCanonicalAnchor())
            ));
        }

        StringBuilder theocracyCards = new StringBuilder();
        for (TheocracyAdjustmentProtocol t : IslamicPhilosophyAlchemyTheocraciesAndMessages.allSevenTheocracyAdjustments()) {
            theocracyCards.append("""
                    <article class="matrix-card theocracy-card" data-search="%s %s %s %s">
                      <div class="card-header">
                        <span class="badge badge-emerald">PROTOCOL %d &bull; %s</span>
                        <span class="badge badge-gold">%s</span>
                      </div>
                      <h3>%s</h3>
                      <div class="split-detail">
                        <div class="detail-box box-critique">
                          <h4>&#x2696; Critique of Theocratic / Priestly Distortion</h4>
                          <p>%s</p>
                        </div>
                        <div class="detail-box box-covenant">
                          <h4>&#x1F4DC; Canonical Islamic Adjustment &amp; Constitutional Charter</h4>
                          <p>%s</p>
                        </div>
                      </div>
                      <div class="anchor-footer">
                        <span>&#x1F54C; <strong>Qur'anic &amp; Legal Proof:</strong> %s</span>
                      </div>
                    </article>
                    """.formatted(
                    escapeHtml(t.protocolCode()),
                    escapeHtml(t.theocracyAndTheocratClass()),
                    escapeHtml(t.historicalEncounterAndRegion()),
                    escapeHtml(t.quranicAndLegalProof()),
                    t.protocolIndex(),
                    escapeHtml(t.protocolCode()),
                    escapeHtml(t.historicalEncounterAndRegion()),
                    escapeHtml(t.theocracyAndTheocratClass()),
                    escapeHtml(t.critiqueOfTheocraticDistortion()),
                    escapeHtml(t.canonicalIslamicAdjustmentAndCharter()),
                    escapeHtml(t.quranicAndLegalProof())
            ));
        }

        StringBuilder socraticCards = new StringBuilder();
        for (SocraticCritiqueEngagement s : IslamicPhilosophyAlchemyTheocraciesAndMessages.allFiveSocraticCritiques()) {
            socraticCards.append("""
                    <article class="matrix-card socratic-card" data-search="%s %s %s %s">
                      <div class="card-header">
                        <span class="badge badge-cyan">SOCRATIC CRITIQUE %d &bull; %s</span>
                        <span class="badge badge-gold">Suqr&#x101;&#x1E6D; Al-&#x1E24;ak&#x12B;m</span>
                      </div>
                      <h3>%s</h3>
                      <p class="masters-line"><strong>Islamic Reception of Socrates:</strong> %s</p>
                      <div class="split-detail">
                        <div class="detail-box box-resolution">
                          <h4>&#x1F4A1; Canonical Islamic Resolution (Kal&#x101;m, Falsafah &amp; U&#x1E63;&#x16B;l)</h4>
                          <p>%s</p>
                        </div>
                        <div class="detail-box box-legacy">
                          <h4>&#x1F3EB; Institutional &amp; Methodological Legacy</h4>
                          <p>%s</p>
                        </div>
                      </div>
                      <div class="anchor-footer">
                        <span>&#x1F4D6; <strong>Qur'anic &amp; Textual Proof:</strong> %s</span>
                      </div>
                    </article>
                    """.formatted(
                    escapeHtml(s.critiqueCode()),
                    escapeHtml(s.classicalSocraticCritique()),
                    escapeHtml(s.islamicReceptionOfSocrates()),
                    escapeHtml(s.quranicAndTextualProof()),
                    s.critiqueIndex(),
                    escapeHtml(s.critiqueCode()),
                    escapeHtml(s.classicalSocraticCritique()),
                    escapeHtml(s.islamicReceptionOfSocrates()),
                    escapeHtml(s.canonicalIslamicResolution()),
                    escapeHtml(s.institutionalAndMethodologicalLegacy()),
                    escapeHtml(s.quranicAndTextualProof())
            ));
        }

        StringBuilder shiftRows = new StringBuilder();
        for (MessageSemanticShiftStage m : IslamicPhilosophyAlchemyTheocraciesAndMessages.allSevenMessageSemanticShifts()) {
            shiftRows.append("""
                    <tr data-search="%s %s %s %s">
                      <td><span class="badge badge-gold">STAGE %d</span><br><small>%s</small></td>
                      <td><strong>%s</strong></td>
                      <td>%s</td>
                      <td>%s</td>
                      <td>%s</td>
                      <td><span class="badge badge-emerald">%s</span></td>
                    </tr>
                    """.formatted(
                    escapeHtml(m.stageCode()),
                    escapeHtml(m.expansionPhaseAndLinguisticSphere()),
                    escapeHtml(m.coreVocabularyAndConceptShifts()),
                    escapeHtml(m.quranicAndUsuliAnchor()),
                    m.stageIndex(),
                    escapeHtml(m.stageCode()),
                    escapeHtml(m.expansionPhaseAndLinguisticSphere()),
                    escapeHtml(m.coreVocabularyAndConceptShifts()),
                    escapeHtml(m.hermeneuticAndLegalMechanism()),
                    escapeHtml(m.historicalExampleOfMeaningShift()),
                    escapeHtml(m.quranicAndUsuliAnchor())
            ));
        }

        String template = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8" />
                  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                  <title>Philosophy, Alchemy &amp; Islam: Theocracies, Socratic Critiques &amp; Semantic Expansion</title>
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
                      --crimson: #f43f5e;
                      --text-main: #f1f5f9;
                      --text-muted: #94a3b8;
                      --border-subtle: rgba(245, 158, 11, 0.28);
                    }
                    * { box-sizing: border-box; margin: 0; padding: 0; }
                    body {
                      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
                      background: radial-gradient(circle at 20% 0%, #111c35 0%, var(--bg-deep) 65%);
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
                      font-size: clamp(1.8rem, 3.3vw, 2.75rem);
                      color: #fff;
                      max-width: 1120px;
                      margin: 0 auto 0.9rem;
                      line-height: 1.25;
                    }
                    .hero-header p {
                      max-width: 960px;
                      margin: 0 auto 1.4rem;
                      color: var(--text-muted);
                      font-size: 1.03rem;
                    }
                    .pillar-banner {
                      display: grid;
                      grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
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
                    #alchemyPhilosophyCanvas {
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
                      grid-template-columns: repeat(auto-fit, minmax(380px, 1fr));
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
                    .badge-teal, .badge-cyan {
                      background: var(--cyan-soft);
                      color: var(--cyan);
                      border: 1px solid rgba(56, 189, 248, 0.35);
                    }
                    .matrix-card h3 {
                      font-size: 1.15rem;
                      color: #fff;
                    }
                    .masters-line {
                      font-size: 0.88rem;
                      color: #cbd5e1;
                    }
                    .split-detail {
                      display: grid;
                      grid-template-columns: 1fr;
                      gap: 0.75rem;
                    }
                    .detail-box {
                      background: rgba(6, 9, 19, 0.65);
                      border-radius: 10px;
                      padding: 0.85rem 1rem;
                      border-left: 3px solid var(--gold);
                    }
                    .detail-box.box-kimiya, .detail-box.box-covenant {
                      border-left-color: var(--emerald);
                    }
                    .detail-box.box-resolution, .detail-box.box-legacy {
                      border-left-color: var(--cyan);
                    }
                    .detail-box h4 {
                      font-size: 0.85rem;
                      color: var(--gold);
                      margin-bottom: 0.35rem;
                      text-transform: uppercase;
                      letter-spacing: 0.04em;
                    }
                    .detail-box.box-kimiya h4, .detail-box.box-covenant h4 {
                      color: var(--emerald);
                    }
                    .detail-box.box-resolution h4, .detail-box.box-legacy h4 {
                      color: var(--cyan);
                    }
                    .detail-box p {
                      font-size: 0.88rem;
                      color: #e2e8f0;
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
                    <span class="hero-kicker">Portal #53 &bull; Al-Falsafah, Al-K&#x12B;miy&#x101;', Theocracies, Suqr&#x101;&#x1E6D; &amp; Semantic Expansion</span>
                    <h1>Philosophy &amp; Alchemy in Islam: Canonical Adjustment to Theocracies, Socratic Critiques &amp; the Evolution of Meaning</h1>
                    <p>
                      How Islamic civilization synthesized demonstrative philosophy (<em>Al-Falsafah wa Al-&#x1E24;ikmah</em>) and quantitative/spiritual alchemy
                      (<em>'Ilm Al-M&#x12B;z&#x101;n</em> &amp; <em>K&#x12B;miy&#x101;-yi Sa'&#x101;dat</em>), dismantled priestly theocracies (<em>L&#x101; Kahan&#x16B;ta f&#x12B; Al-Isl&#x101;m</em>)
                      through constitutional covenants (<em>Dhimmiyyah</em>), answered the 5 Socratic critiques (<em>Suqr&#x101;&#x1E6D; Al-&#x1E24;ak&#x12B;m</em>),
                      and expanded the semantic horizon of its messages across 7 civilizational stages while keeping the Qur'anic text invariant (<em>Laf&#x1E93; Ma&#x1E25;f&#x16B;&#x1E93;</em>).
                    </p>
                    <div class="pillar-banner">
                      <div class="pillar-stat">
                        <strong>I. 7 Philosophy &amp; Alchemy Epochs</strong>
                        <span>From J&#x101;bir ibn &#x1E24;ayy&#x101;n's 1:3:5:8 Alembic Balance &amp; Al-Kind&#x12B; to Al-Ghaz&#x101;l&#x12B;'s <em>K&#x12B;miy&#x101;-yi Sa'&#x101;dat</em> &amp; Mull&#x101; &#x1E62;adr&#x101;'s Substantial Motion</span>
                      </div>
                      <div class="pillar-stat">
                        <strong>II. 7 Theocracy Adjustments</strong>
                        <span>Meccan Sadanah, Abyssinian Negus, Byzantine Patriarch, Sasanian Mobads, A&#x1E25;b&#x101;r/Ruhb&#x101;n, &#x1E24;arr&#x101;nian Sabians &amp; Sind Brahmans (Al-R&#x16B;r 711 CE)</span>
                      </div>
                      <div class="pillar-stat">
                        <strong>III. 5 Socratic Critiques Resolved</strong>
                        <span><em>Euthyphro</em> Moral Ontology, Socratic <em>Elenchus</em> vs. <em>Taql&#x12B;d</em>, Epistemic Humility, Oral <em>Isn&#x101;d</em> vs. <em>Phaedrus</em>, &amp; Eye-and-Sunlight Prophecy Proof</span>
                      </div>
                      <div class="pillar-stat">
                        <strong>IV. 7 Stages of Meaning Shift</strong>
                        <span>Invariant <em>Laf&#x1E93;</em> vs. <em>Ittis&#x101;' Ad-Dal&#x101;lah</em>, <em>Naql Shar'&#x12B;</em>, Graeco-Arabic Calibration, Ash-Sh&#x101;fi'&#x12B;'s <em>Qad&#x12B;m/Jad&#x12B;d</em>, &amp; 4-Tier Interiorization</span>
                      </div>
                    </div>
                  </header>

                  <main class="container">
                    <section class="canvas-panel">
                      <div class="canvas-header">
                        <div>
                          <h2 style="font-size:1.25rem;color:#fff;">Interactive 2.5D Alchemical Alembic (Al-Inb&#x12B;q), Theocratic Covenant &amp; Socratic-Semantic Synthesizer</h2>
                          <p style="font-size:0.86rem;color:var(--text-muted);">
                            Left: J&#x101;bir's Quantitative Balance (1:3:5:8 = 17) &amp; Al-Ghaz&#x101;l&#x12B;'s Heart Alembic &bull; Center: 7 Theocratic Covenants &amp; 5 Socratic Elenchus Vectors &bull; Right: 7 Concentric Rings of Semantic Expansion around the Invariant Qur'anic Core
                          </p>
                        </div>
                        <div class="canvas-controls">
                          <button class="mode-btn active" onclick="setPhilosophyMode('ALL')">All 4 Canonical Matrices</button>
                          <button class="mode-btn" onclick="setPhilosophyMode('ALCHEMY')">I. Alchemy &amp; Falsafah (7)</button>
                          <button class="mode-btn" onclick="setPhilosophyMode('THEOCRACY')">II. Theocracy Covenants (7)</button>
                          <button class="mode-btn" onclick="setPhilosophyMode('SOCRATIC')">III. Socratic Critiques (5)</button>
                          <button class="mode-btn" onclick="setPhilosophyMode('SEMANTIC')">IV. Message Meaning Shifts (7)</button>
                        </div>
                      </div>
                      <canvas id="alchemyPhilosophyCanvas" width="1280" height="390"></canvas>
                    </section>

                    <div class="toolbar-search">
                      <input type="text" id="portalSearchInput" placeholder="Filter across Jabir, Kindi, Razi, Sina, Ghazali, Rushd, Sadra, Negus, Sophronius, Mobad, Barahimah, Euthyro, Shafi'i Qadim/Jadid..." oninput="filterPhilosophyPortal()" />
                      <span id="searchCountBadge" class="badge badge-gold">Showing All 26 Canonical Nodes</span>
                    </div>

                    <section class="section-block" id="section-alchemy">
                      <div class="section-title">
                        <h2>I. Philosophy (Al-Falsafah wa Al-&#x1E24;ikmah) &amp; Alchemy (Al-K&#x12B;miy&#x101;') Across 7 Canonical Epochs</h2>
                        <p>From J&#x101;bir ibn &#x1E24;ayy&#x101;n's laboratory Alembic (<em>Al-Inb&#x12B;q</em>) and quantitative Science of the Balance (<em>'Ilm Al-M&#x12B;z&#x101;n</em>) to Al-Ghaz&#x101;l&#x12B;'s <em>Alchemy of Happiness</em> and Mull&#x101; &#x1E62;adr&#x101;'s Substantial Motion.</p>
                      </div>
                      <div class="card-grid">
                        __ALCHEMY_CARDS__
                      </div>
                    </section>

                    <section class="section-block" id="section-theocracy">
                      <div class="section-title">
                        <h2>II. How Islam Canonically Adjusted to 7 Different Theocracies &amp; Theocrats</h2>
                        <p>Abolishing infallibilist priestly mediation (<em>L&#x101; Kahan&#x16B;ta f&#x12B; Al-Isl&#x101;m</em>, Qur'an 9:31) while granting autonomous judicial, ecclesiastical, and temple covenants from Jerusalem and Persia to Sind.</p>
                      </div>
                      <div class="card-grid">
                        __THEOCRACY_CARDS__
                      </div>
                    </section>

                    <section class="section-block" id="section-socratic">
                      <div class="section-title">
                        <h2>III. How Islam Engaged, Answered &amp; Institutionalized 5 Socratic Critiques (Suqr&#x101;&#x1E6D; Al-&#x1E24;ak&#x12B;m)</h2>
                        <p>Revering Socrates as a monotheist ascetic who defied Athenian idolatry, and resolving the Euthyphro Dilemma, anti-<em>Taql&#x12B;d</em> Elenchus, Epistemic Humility, Oral <em>Isn&#x101;d</em>, and the Necessity of Prophecy.</p>
                      </div>
                      <div class="card-grid">
                        __SOCRATIC_CARDS__
                      </div>
                    </section>

                    <section class="section-block" id="section-semantic">
                      <div class="section-title">
                        <h2>IV. How the Meaning of Messages Changed During Islamic Expansion (7 Canonical Stages)</h2>
                        <p>How an invariant Arabic revelation (<em>Laf&#x1E93; Ma&#x1E25;f&#x16B;&#x1E93;</em>, Qur'an 15:9) generated expanding legal, scientific, spiritual, and vernacular meanings across continents—exemplified by Imam Ash-Sh&#x101;fi'&#x12B;'s transition from Iraq (<em>Al-Qad&#x12B;m</em>) to Egypt (<em>Al-Jad&#x12B;d</em>).</p>
                      </div>
                      <div class="table-wrapper">
                        <table>
                          <thead>
                            <tr>
                              <th>Stage &amp; Code</th>
                              <th>Expansion Phase &amp; Linguistic Sphere</th>
                              <th>Core Vocabulary &amp; Concept Shifts</th>
                              <th>Hermeneutic &amp; Legal Mechanism</th>
                              <th>Historical Proof &amp; Meaning Shift</th>
                              <th>Qur'anic &amp; U&#x1E63;&#x16B;l&#x12B; Anchor</th>
                            </tr>
                          </thead>
                          <tbody>
                            __SHIFT_ROWS__
                          </tbody>
                        </table>
                      </div>
                    </section>
                  </main>

                  <script>
                    let currentPhilosophyMode = 'ALL';
                    let animTick = 0;

                    function setPhilosophyMode(mode) {
                      currentPhilosophyMode = mode;
                      document.querySelectorAll('.mode-btn').forEach(btn => {
                        btn.classList.toggle('active', btn.getAttribute('onclick').includes("'" + mode + "'"));
                      });
                    }

                    function filterPhilosophyPortal() {
                      const q = (document.getElementById('portalSearchInput').value || '').toLowerCase().trim();
                      let visible = 0;
                      document.querySelectorAll('.matrix-card, tbody tr').forEach(el => {
                        const hay = (el.getAttribute('data-search') || el.innerText || '').toLowerCase();
                        const match = !q || hay.includes(q);
                        el.style.display = match ? '' : 'none';
                        if (match) visible++;
                      });
                      const badge = document.getElementById('searchCountBadge');
                      if (badge) badge.textContent = 'Showing ' + visible + ' of 26 Canonical Nodes';
                    }

                    (function initAlchemyCanvas() {
                      const canvas = document.getElementById('alchemyPhilosophyCanvas');
                      if (!canvas) return;
                      const ctx = canvas.getContext('2d');

                      function render() {
                        animTick += 0.025;
                        const w = canvas.width;
                        const h = canvas.height;
                        ctx.clearRect(0, 0, w, h);

                        // Subtle geometric grid
                        ctx.strokeStyle = 'rgba(245, 158, 11, 0.07)';
                        ctx.lineWidth = 1;
                        for (let x = 40; x < w; x += 60) {
                          ctx.beginPath(); ctx.moveTo(x, 0); ctx.lineTo(x, h); ctx.stroke();
                        }
                        for (let y = 40; y < h; y += 60) {
                          ctx.beginPath(); ctx.moveTo(0, y); ctx.lineTo(w, y); ctx.stroke();
                        }

                        // 1. LEFT ZONE: Alchemical Alembic (Al-Inbiq) & 1:3:5:8 Mizan
                        const leftAlpha = (currentPhilosophyMode === 'ALL' || currentPhilosophyMode === 'ALCHEMY') ? 1.0 : 0.25;
                        ctx.save();
                        ctx.globalAlpha = leftAlpha;
                        const ax = 210, ay = 215;

                        //Cucurbit (Qar'ah) flask
                        ctx.beginPath();
                        ctx.arc(ax, ay + 40, 58, 0, Math.PI * 2);
                        ctx.fillStyle = 'rgba(16, 185, 129, 0.14)';
                        ctx.fill();
                        ctx.lineWidth = 2.2;
                        ctx.strokeStyle = '#f59e0b';
                        ctx.stroke();

                        // Rising vapor particles (1:3:5:8 = 17 Balance)
                        for (let i = 0; i < 8; i++) {
                          const py = ay + 55 - ((animTick * 35 + i * 18) % 130);
                          const px = ax + Math.sin(animTick * 2 + i) * 18;
                          ctx.beginPath();
                          ctx.arc(px, py, 3.5, 0, Math.PI * 2);
                          ctx.fillStyle = i % 2 === 0 ? '#f59e0b' : '#10b981';
                          ctx.fill();
                        }

                        // Alembic cap (Inbiq) and delivery spout to receiver (Qabilah)
                        ctx.beginPath();
                        ctx.arc(ax, ay - 52, 30, Math.PI, 0, false);
                        ctx.lineTo(ax + 110, ay + 25);
                        ctx.strokeStyle = '#38bdf8';
                        ctx.lineWidth = 2.5;
                        ctx.stroke();

                        ctx.beginPath();
                        ctx.arc(ax + 118, ay + 45, 26, 0, Math.PI * 2);
                        ctx.fillStyle = 'rgba(245, 158, 11, 0.22)';
                        ctx.fill();
                        ctx.strokeStyle = '#f59e0b';
                        ctx.stroke();

                        ctx.fillStyle = '#f59e0b';
                        ctx.font = 'bold 13px Segoe UI, sans-serif';
                        ctx.textAlign = 'center';
                        ctx.fillText("I. AL-KIMIYA' & FALSAFAH", ax + 35, 34);
                        ctx.fillStyle = '#94a3b8';
                        ctx.font = '11.5px Segoe UI, sans-serif';
                        ctx.fillText("Jabir's Al-Inbiq (1:3:5:8 = 17 Mizan)", ax + 35, 54);
                        ctx.fillText("Al-Ghazali's Kimiya-yi Sa'adat & Sadra", ax + 35, 355);
                        ctx.restore();

                        // 2. CENTER ZONE: 7 Theocracy Covenants & 5 Socratic Critiques
                        const midAlpha = (currentPhilosophyMode === 'ALL' || currentPhilosophyMode === 'THEOCRACY' || currentPhilosophyMode === 'SOCRATIC') ? 1.0 : 0.25;
                        ctx.save();
                        ctx.globalAlpha = midAlpha;
                        const cx = 640, cy = 195;

                        // Outer heptagon of 7 Theocracy Adjustments
                        const theocracies = [
                          '1. Meccan Sadanah (4:58)',
                          '2. Abyssinian Negus',
                          '3. Jerusalem Covenant',
                          '4. Sasanian Mobads',
                          '5. No Priesthood (9:31)',
                          '6. Harran Sabians',
                          '7. Charter of Al-Rur'
                        ];
                        for (let i = 0; i < 7; i++) {
                          const ang = (i * Math.PI * 2) / 7 - Math.PI / 2 + animTick * 0.12;
                          const tx = cx + Math.cos(ang) * 122;
                          const ty = cy + Math.sin(ang) * 112;
                          ctx.beginPath();
                          ctx.moveTo(cx, cy);
                          ctx.lineTo(tx, ty);
                          ctx.strokeStyle = 'rgba(16, 185, 129, 0.28)';
                          ctx.stroke();

                          ctx.beginPath();
                          ctx.arc(tx, ty, 11, 0, Math.PI * 2);
                          ctx.fillStyle = '#10b981';
                          ctx.fill();

                          ctx.fillStyle = '#e2e8f0';
                          ctx.font = '10.5px Segoe UI, sans-serif';
                          ctx.textAlign = 'center';
                          ctx.fillText(theocracies[i], tx, ty - 15);
                        }

                        // Inner pentagram of 5 Socratic Critiques
                        const socratic = ['Euthyphro', 'Anti-Taqlid', 'La Adri', 'Isnad', 'Nur Ala Nur'];
                        for (let i = 0; i < 5; i++) {
                          const ang = (i * Math.PI * 2) / 5 - Math.PI / 2 - animTick * 0.18;
                          const sx = cx + Math.cos(ang) * 54;
                          const sy = cy + Math.sin(ang) * 54;
                          ctx.beginPath();
                          ctx.arc(sx, sy, 7, 0, Math.PI * 2);
                          ctx.fillStyle = '#38bdf8';
                          ctx.fill();
                          ctx.fillStyle = '#38bdf8';
                          ctx.font = '10px Segoe UI, sans-serif';
                          ctx.fillText(socratic[i], sx, sy + 18);
                        }

                        ctx.fillStyle = '#10b981';
                        ctx.font = 'bold 13px Segoe UI, sans-serif';
                        ctx.textAlign = 'center';
                        ctx.fillText('II & III. 7 THEOCRACY COVENANTS & 5 SOCRATIC CRITIQUES', cx, 34);
                        ctx.fillStyle = '#94a3b8';
                        ctx.font = '11.5px Segoe UI, sans-serif';
                        ctx.fillText('La Kahanuta fi Al-Islam (Qur\\'an 9:31) & Suqrat Al-Hakim Dialectic', cx, 355);
                        ctx.restore();

                        // 3. RIGHT ZONE: 7 Concentric Rings of Semantic Expansion around Invariant Lafz
                        const rightAlpha = (currentPhilosophyMode === 'ALL' || currentPhilosophyMode === 'SEMANTIC') ? 1.0 : 0.25;
                        ctx.save();
                        ctx.globalAlpha = rightAlpha;
                        const rx = 1065, ry = 198;

                        for (let r = 7; r >= 1; r--) {
                          const radius = r * 16 + Math.sin(animTick * 2 + r) * 1.5;
                          ctx.beginPath();
                          ctx.arc(rx, ry, radius, 0, Math.PI * 2);
                          ctx.strokeStyle = r === 1 ? '#f59e0b' : (r % 2 === 0 ? 'rgba(56, 189, 248, 0.55)' : 'rgba(16, 185, 129, 0.55)');
                          ctx.lineWidth = r === 1 ? 3 : 1.5;
                          ctx.stroke();
                        }
                        ctx.beginPath();
                        ctx.arc(rx, ry, 11, 0, Math.PI * 2);
                        ctx.fillStyle = '#f59e0b';
                        ctx.fill();

                        ctx.fillStyle = '#38bdf8';
                        ctx.font = 'bold 13px Segoe UI, sans-serif';
                        ctx.textAlign = 'center';
                        ctx.fillText('IV. 7 STAGES OF MESSAGE MEANING EXPANSION', rx, 34);
                        ctx.fillStyle = '#f59e0b';
                        ctx.font = '11px Segoe UI, sans-serif';
                        ctx.fillText('Core: Lafz Mahfuz (15:9) -> Outer: Qadim/Jadid & 4-Tier Ta\\'wil', rx, 355);
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
                .replace("__ALCHEMY_CARDS__", alchemyCards.toString())
                .replace("__THEOCRACY_CARDS__", theocracyCards.toString())
                .replace("__SOCRATIC_CARDS__", socraticCards.toString())
                .replace("__SHIFT_ROWS__", shiftRows.toString());
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
