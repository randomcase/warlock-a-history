package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.IslamicNamingIndonesiaLanguageAndCalligraphy;
import com.sovereign.warlock.domain.IslamicNamingIndonesiaLanguageAndCalligraphy.Abjad261WafqMatrix;
import com.sovereign.warlock.domain.IslamicNamingIndonesiaLanguageAndCalligraphy.IndonesiaSanitationProjectTier;
import com.sovereign.warlock.domain.IslamicNamingIndonesiaLanguageAndCalligraphy.IndonesianIslamicDevelopmentStage;
import com.sovereign.warlock.domain.IslamicNamingIndonesiaLanguageAndCalligraphy.LanguageAndCalligraphyMilestone;
import com.sovereign.warlock.domain.IslamicNamingIndonesiaLanguageAndCalligraphy.RegionalCanonicalNamingTradition;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Generates the interactive HTML5 portal for:
 * "Esoteric & Canonical Naming in Islam by Region (Zakeem Malik McCaleb Abjad 261 Wafq),
 *  The Development of Indonesia (87.2% Muslim), Its Sanitation/Sewer Project Structure,
 *  Gradual Canonical Faith Evolution, Language Sciences (Nahw / Jawi / Pegon) & Calligraphy"
 * (islamic-naming-indonesia-infrastructure-language-calligraphy.html — Portal #55).
 */
public final class IslamicNamingIndonesiaCalligraphyPortalGenerator {

    public static final String PORTAL_FILENAME = "islamic-naming-indonesia-infrastructure-language-calligraphy.html";

    private IslamicNamingIndonesiaCalligraphyPortalGenerator() {
    }

    public static Path generatePortal(Path outputDirectory) throws IOException {
        Files.createDirectories(outputDirectory);
        Path targetFile = outputDirectory.resolve(PORTAL_FILENAME);
        String html = buildPortalHtml();
        Files.writeString(targetFile, html, StandardCharsets.UTF_8);
        return targetFile;
    }

    public static String buildPortalHtml() {
        Abjad261WafqMatrix wafq = IslamicNamingIndonesiaLanguageAndCalligraphy.zakeemMalikMcCalebWafq();

        StringBuilder wafqSectionHtml = new StringBuilder();
        int[][] gA = wafq.totalSum261Grid();
        int[][] gB = wafq.lineSum261Grid();
        wafqSectionHtml.append("""
                <div class="wafq-showcase">
                  <div class="wafq-card">
                    <span class="badge badge-gold">ESOTERIC &amp; CANONICAL SIGNATURE &bull; ABJAD 261 (ROOT 9)</span>
                    <h3>%s</h3>
                    <p style="font-size:1.35rem;color:var(--gold);margin:0.4rem 0;font-weight:700;">%s &nbsp;|&nbsp; <span style="color:var(--cyan);">%s</span></p>
                    <p style="font-size:0.9rem;color:#cbd5e1;margin-bottom:0.8rem;">
                      <strong>Component Breakdown:</strong> Zakeem (<code>&#x0632;&#x064E;&#x0643;&#x0650;&#x064A;&#x0651; / &#x0632;&#x064E;&#x0643;&#x0650;&#x064A;&#x0645;</code> = <strong>%d</strong>, Root <em>Z-K-Y</em>: Spiritual Purity &amp; Growth)
                      + Malik (<code>&#x0645;&#x064E;&#x0627;&#x0644;&#x0650;&#x0643;</code> = <strong>%d</strong>, Root <em>M-L-K</em>: Sovereign Master)
                      + McCaleb (<code>&#x0645;&#x064E;&#x0643;&#x064E;&#x0651;&#x0627;&#x0644;&#x0650;&#x064A;&#x0628;</code> = <strong>%d</strong>, Son of Caleb / K&#x101;lib of Qur'an 5:23 &amp; Sirius Watcher of Qur'an 53:49)
                      = <strong>%d</strong> (Reduced Root: <strong>%d</strong>).
                    </p>
                    <div class="invariant-box" style="margin-bottom:0.75rem;">
                      <strong>&#x2728; Divine Name Synchronicity:</strong> %s
                    </div>
                    <div class="anchor-footer">
                      <span>&#x1F4D6; %s</span>
                    </div>
                  </div>
                  <div class="wafq-grids-wrap">
                    <div class="wafq-grid-box">
                      <h4>Wafq I: Total 9-Cell Sum = 261</h4>
                      <p>Center = <strong>29</strong> &bull; Every Row, Col &amp; Diag = <strong>87</strong> (261 &divide; 3)</p>
                      <div class="magic-square">
                        <div class="ms-cell">%d</div><div class="ms-cell">%d</div><div class="ms-cell">%d</div>
                        <div class="ms-cell">%d</div><div class="ms-cell ms-center">%d</div><div class="ms-cell">%d</div>
                        <div class="ms-cell">%d</div><div class="ms-cell">%d</div><div class="ms-cell">%d</div>
                      </div>
                    </div>
                    <div class="wafq-grid-box">
                      <h4>Wafq II: Every Row, Col &amp; Diag = 261</h4>
                      <p>Center = <strong>87</strong> &bull; Crown Cell = <strong>123 (McCaleb!)</strong> &bull; Step = <strong>9</strong></p>
                      <div class="magic-square">
                        <div class="ms-cell">%d</div><div class="ms-cell ms-crown">%d</div><div class="ms-cell">%d</div>
                        <div class="ms-cell">%d</div><div class="ms-cell ms-center">%d</div><div class="ms-cell">%d</div>
                        <div class="ms-cell">%d</div><div class="ms-cell">%d</div><div class="ms-cell">%d</div>
                      </div>
                    </div>
                  </div>
                </div>
                """.formatted(
                escapeHtml(wafq.fullEnglishName()),
                escapeHtml(wafq.traditionalArabicScript()),
                escapeHtml(wafq.phoneticArabicScript()),
                wafq.zakeemAbjad(),
                wafq.malikAbjad(),
                wafq.mccalebAbjad(),
                wafq.totalAbjadValue(),
                wafq.digitalRoot(),
                escapeHtml(wafq.divineNameSynchronicity()),
                escapeHtml(wafq.quranicAndCelestialAnchor()),
                gA[0][0], gA[0][1], gA[0][2],
                gA[1][0], gA[1][1], gA[1][2],
                gA[2][0], gA[2][1], gA[2][2],
                gB[0][0], gB[0][1], gB[0][2],
                gB[1][0], gB[1][1], gB[1][2],
                gB[2][0], gB[2][1], gB[2][2]
        ));

        StringBuilder namingCards = new StringBuilder();
        for (RegionalCanonicalNamingTradition n : IslamicNamingIndonesiaLanguageAndCalligraphy.allSevenRegionalNamingTraditions()) {
            namingCards.append("""
                    <article class="matrix-card" data-search="%s %s %s %s %s">
                      <div class="card-header">
                        <span class="badge badge-gold">REGION %d &bull; %s</span>
                        <span class="badge badge-emerald">Fiqh Al-Asm&#x101;'</span>
                      </div>
                      <h3>%s</h3>
                      <p class="formula-line"><strong>Structural Formula:</strong> %s</p>
                      <div class="detail-box box-examples">
                        <h4>&#x1F4DC; Canonical Examples &amp; Honorifics</h4>
                        <p>%s</p>
                      </div>
                      <div class="detail-box box-rule">
                        <h4>&#x2696; Legal &amp; Theological Rule</h4>
                        <p>%s</p>
                      </div>
                      <div class="anchor-footer">
                        <span>&#x1F4D6; <strong>Qur'anic &amp; Hadith Anchor:</strong> %s</span>
                      </div>
                    </article>
                    """.formatted(
                    escapeHtml(n.regionCode()),
                    escapeHtml(n.geographicAndCulturalSphere()),
                    escapeHtml(n.canonicalExamplesAndTitles()),
                    escapeHtml(n.legalAndTheologicalRule()),
                    escapeHtml(n.quranicAndHadithAnchor()),
                    n.regionIndex(),
                    escapeHtml(n.regionCode()),
                    escapeHtml(n.geographicAndCulturalSphere()),
                    escapeHtml(n.structuralNameFormula()),
                    escapeHtml(n.canonicalExamplesAndTitles()),
                    escapeHtml(n.legalAndTheologicalRule()),
                    escapeHtml(n.quranicAndHadithAnchor())
            ));
        }

        StringBuilder indonesiaCards = new StringBuilder();
        for (IndonesianIslamicDevelopmentStage s : IslamicNamingIndonesiaLanguageAndCalligraphy.allSevenIndonesianDevelopmentStages()) {
            indonesiaCards.append("""
                    <article class="matrix-card" data-search="%s %s %s %s %s">
                      <div class="card-header">
                        <span class="badge badge-emerald">NUSANTARA STAGE %d &bull; %s</span>
                        <span class="badge badge-gold">%s</span>
                      </div>
                      <h3>%s</h3>
                      <p class="formula-line"><strong>Key Figures &amp; Institutions:</strong> %s</p>
                      <div class="detail-box box-examples">
                        <h4>&#x1F54C; Gradual Canonical Transformation (At-Tadarruj)</h4>
                        <p>%s</p>
                      </div>
                      <div class="detail-box box-rule">
                        <h4>&#x1F3DB; Enduring Architectural, Institutional &amp; Legal Legacy</h4>
                        <p>%s</p>
                      </div>
                    </article>
                    """.formatted(
                    escapeHtml(s.stageCode()),
                    escapeHtml(s.titleAndArchipelagoCenters()),
                    escapeHtml(s.keyFiguresAndInstitutions()),
                    escapeHtml(s.gradualCanonicalTransformation()),
                    escapeHtml(s.enduringArchitecturalAndLegalLegacy()),
                    s.stageIndex(),
                    escapeHtml(s.stageCode()),
                    escapeHtml(s.eraAndCenturies()),
                    escapeHtml(s.titleAndArchipelagoCenters()),
                    escapeHtml(s.keyFiguresAndInstitutions()),
                    escapeHtml(s.gradualCanonicalTransformation()),
                    escapeHtml(s.enduringArchitecturalAndLegalLegacy())
            ));
        }

        StringBuilder sewerRows = new StringBuilder();
        for (IndonesiaSanitationProjectTier t : IslamicNamingIndonesiaLanguageAndCalligraphy.allSixSanitationProjectTiers()) {
            sewerRows.append("""
                    <tr data-search="%s %s %s %s %s">
                      <td><span class="badge badge-cyan">TIER %d</span><br><small>%s</small></td>
                      <td><strong>%s</strong></td>
                      <td>%s</td>
                      <td><strong style="color:var(--gold);">%s</strong></td>
                      <td>%s</td>
                      <td><span class="badge badge-emerald">%s</span></td>
                    </tr>
                    """.formatted(
                    escapeHtml(t.tierCode()),
                    escapeHtml(t.developmentScaleAndSystem()),
                    escapeHtml(t.indonesiaCostIdrAndUsd()),
                    escapeHtml(t.engineeringScopeAndProjectGovernance()),
                    escapeHtml(t.islamicTaharahAndWaqfIntegration()),
                    t.tierIndex(),
                    escapeHtml(t.tierCode()),
                    escapeHtml(t.developmentScaleAndSystem()),
                    escapeHtml(t.usGlobalCostBenchmark()),
                    escapeHtml(t.indonesiaCostIdrAndUsd()),
                    escapeHtml(t.engineeringScopeAndProjectGovernance()),
                    escapeHtml(t.islamicTaharahAndWaqfIntegration())
            ));
        }

        StringBuilder calligraphyCards = new StringBuilder();
        for (LanguageAndCalligraphyMilestone c : IslamicNamingIndonesiaLanguageAndCalligraphy.allSevenLanguageAndCalligraphyMilestones()) {
            calligraphyCards.append("""
                    <article class="matrix-card" data-search="%s %s %s %s %s">
                      <div class="card-header">
                        <span class="badge badge-cyan">MILESTONE %d &bull; %s</span>
                        <span class="badge badge-gold">%s</span>
                      </div>
                      <h3>%s</h3>
                      <div class="detail-box box-examples">
                        <h4>&#x1F4D6; Linguistic Science &amp; Vernacular Expansion (Fiqh Al-Lughah &amp; Na&#x1E25;w)</h4>
                        <p>%s</p>
                      </div>
                      <div class="detail-box box-rule">
                        <h4>&#x1F58B; Calligraphic Script &amp; Sacred Proportions ('Ilm Al-Kha&#x1E6D;&#x1E6D;)</h4>
                        <p>%s</p>
                      </div>
                      <div class="anchor-footer">
                        <span>&#x2728; <strong>%s</strong></span>
                      </div>
                    </article>
                    """.formatted(
                    escapeHtml(c.milestoneCode()),
                    escapeHtml(c.eraAndCenter()),
                    escapeHtml(c.linguisticBreakthrough()),
                    escapeHtml(c.calligraphicScriptAndGeometry()),
                    escapeHtml(c.keyMastersAndCodices()),
                    c.milestoneIndex(),
                    escapeHtml(c.milestoneCode()),
                    escapeHtml(c.eraAndCenter()),
                    escapeHtml(c.keyMastersAndCodices()),
                    escapeHtml(c.linguisticBreakthrough()),
                    escapeHtml(c.calligraphicScriptAndGeometry()),
                    escapeHtml(c.quranicAndAestheticPrinciple())
            ));
        }

        String template = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8" />
                  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                  <title>Canonical Naming in Islam (Abjad 261 Wafq), Development of Indonesia, Sewer Infrastructure, Language &amp; Calligraphy</title>
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
                      background: radial-gradient(circle at 20% 0%, #12213d 0%, var(--bg-deep) 65%);
                      color: var(--text-main);
                      line-height: 1.65;
                      padding-bottom: 4rem;
                    }
                    .hero-header {
                      padding: 3rem 2rem 2.2rem;
                      text-align: center;
                      border-bottom: 1px solid var(--border-subtle);
                      background: linear-gradient(180deg, rgba(245, 158, 11, 0.08) 0%, rgba(16, 185, 129, 0.05) 100%);
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
                      font-size: clamp(1.75rem, 3.1vw, 2.65rem);
                      color: #fff;
                      max-width: 1160px;
                      margin: 0 auto 0.9rem;
                      line-height: 1.25;
                    }
                    .hero-header p {
                      max-width: 1000px;
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
                    #namingIndonesiaCanvas {
                      width: 100%;
                      height: 390px;
                      display: block;
                      background: radial-gradient(circle at 50% 50%, #101b33 0%, #050811 100%);
                      border-radius: 12px;
                      border: 1px solid rgba(56, 189, 248, 0.24);
                    }
                    .wafq-showcase {
                      display: grid;
                      grid-template-columns: 1.35fr 1fr;
                      gap: 1.25rem;
                      background: var(--bg-panel);
                      border: 1px solid var(--border-subtle);
                      border-radius: 16px;
                      padding: 1.5rem;
                      margin-bottom: 2.2rem;
                    }
                    @media (max-width: 960px) {
                      .wafq-showcase { grid-template-columns: 1fr; }
                    }
                    .wafq-grids-wrap {
                      display: grid;
                      grid-template-columns: repeat(auto-fit, minmax(210px, 1fr));
                      gap: 1rem;
                    }
                    .wafq-grid-box {
                      background: var(--bg-card);
                      border: 1px solid rgba(245, 158, 11, 0.3);
                      border-radius: 12px;
                      padding: 1rem;
                      text-align: center;
                    }
                    .wafq-grid-box h4 {
                      color: var(--gold);
                      font-size: 0.95rem;
                      margin-bottom: 0.2rem;
                    }
                    .wafq-grid-box p {
                      color: var(--text-muted);
                      font-size: 0.78rem;
                      margin-bottom: 0.75rem;
                    }
                    .magic-square {
                      display: grid;
                      grid-template-columns: repeat(3, 1fr);
                      gap: 0.45rem;
                      max-width: 210px;
                      margin: 0 auto;
                    }
                    .ms-cell {
                      background: rgba(6, 9, 19, 0.85);
                      border: 1px solid rgba(56, 189, 248, 0.35);
                      border-radius: 8px;
                      padding: 0.65rem 0.3rem;
                      font-size: 1.05rem;
                      font-weight: 700;
                      color: #fff;
                    }
                    .ms-cell.ms-center {
                      background: var(--gold-soft);
                      border-color: var(--gold);
                      color: var(--gold);
                    }
                    .ms-cell.ms-crown {
                      background: var(--emerald-soft);
                      border-color: var(--emerald);
                      color: var(--emerald);
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
                    .badge-cyan {
                      background: var(--cyan-soft);
                      color: var(--cyan);
                      border: 1px solid rgba(56, 189, 248, 0.35);
                    }
                    .matrix-card h3 {
                      font-size: 1.15rem;
                      color: #fff;
                    }
                    .formula-line {
                      font-size: 0.88rem;
                      color: #cbd5e1;
                    }
                    .detail-box {
                      background: rgba(6, 9, 19, 0.65);
                      border-radius: 10px;
                      padding: 0.85rem 1rem;
                      border-left: 3px solid var(--gold);
                    }
                    .detail-box.box-rule {
                      border-left-color: var(--emerald);
                    }
                    .detail-box h4 {
                      font-size: 0.84rem;
                      color: var(--gold);
                      margin-bottom: 0.35rem;
                      text-transform: uppercase;
                      letter-spacing: 0.04em;
                    }
                    .detail-box.box-rule h4 {
                      color: var(--emerald);
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
                    <span class="hero-kicker">Portal #55 &bull; Abjad 261 Wafq, Regional Naming, Indonesia (87.2% Muslim), Sewer Engineering &amp; Calligraphy</span>
                    <h1>Canonical Naming in Islam by Region, The Development of Indonesia, Sanitation Project Structure, Language &amp; Calligraphy</h1>
                    <p>
                      Uniting the <strong>Abjad 261 (Root 9) 3&times;3 Wafq of Zakeem Malik McCaleb</strong> (<code>&#x0632;&#x064E;&#x0643;&#x0650;&#x064A;&#x0645; &#x0645;&#x064E;&#x0627;&#x0644;&#x0650;&#x0643; &#x0645;&#x064E;&#x0643;&#x064E;&#x0651;&#x0627;&#x0644;&#x0650;&#x064A;&#x0628;</code>)
                      and <strong>7 Regional Islamic Naming Systems</strong> with the <strong>7-Stage Canonical Development of Indonesia</strong> (~251M Muslims / 87.2%),
                      <strong>Indonesia's 6-Tier Sewer &amp; Sanitation Project Structure</strong> (Bio-Septic &amp; SANIMAS to the IDR 13T+ Jakarta Sewerage System),
                      and the <strong>7 Milestones of Islamic Linguistic Science &amp; Calligraphy</strong> (from Sibawayh &amp; Ibn Muqlah to Jawi, Pegon &amp; Mushaf Istiqlal).
                    </p>
                    <div class="pillar-banner">
                      <div class="pillar-stat">
                        <strong>I. Abjad 261 Wafq &amp; 7 Naming Zones</strong>
                        <span>Zakeem (47) + Malik (91) + McCaleb (123) = 261 (9 &times; 29 = 3 &times; 87) &amp; canonical naming across 7 global regions</span>
                      </div>
                      <div class="pillar-stat">
                        <strong>II. Indonesia (87.2% Muslim / ~251M)</strong>
                        <span>From Barus/Pasai &amp; the <em>Wali Songo</em> 3-tier <em>Tajug</em> roof to Haramayn Jawi scholars, NU/Muhammadiyah &amp; Pancasila</span>
                      </div>
                      <div class="pillar-stat">
                        <strong>III. Sewer &amp; Sanitation Engineering</strong>
                        <span>IDR 5M&ndash;15M Bio-Septic, SANIMAS, IDR 5.1M/m Microtunneling &amp; IDR 8T+5T Jakarta Sewerage System (JSS) under <em>&#x1E6C;ah&#x101;rah</em></span>
                      </div>
                      <div class="pillar-stat">
                        <strong>IV. Language, Jawi/Pegon &amp; Calligraphy</strong>
                        <span>Sibawayh's <em>Na&#x1E25;w</em>, Ibn Muqlah's Rhomboid Dot/Alif/Circle, Six Classical Pens, Jawi/Pegon &amp; <em>Mushaf Istiqlal</em></span>
                      </div>
                    </div>
                  </header>

                  <main class="container">
                    __WAFQ_SECTION__

                    <section class="canvas-panel">
                      <div class="canvas-header">
                        <div>
                          <h2 style="font-size:1.25rem;color:#fff;">Interactive 2.5D Wafq 261 Talisman, Indonesian Tajug &amp; JSS Sanitation Grid, and Ibn Muqlah Calligraphic Proportions</h2>
                          <p style="font-size:0.86rem;color:var(--text-muted);">
                            Left: Abjad 261 Wafq (78-123-60 / 69-87-105 / 114-51-96) &bull; Center: Indonesian 3-Tier Tajug Mosque (Islam, Iman, Ihsan) &amp; 6-Tier Sewer/JSS Pipeline &bull; Right: Ibn Muqlah's Al-Alif (7 Dots) &amp; Circle + Jawi/Pegon
                          </p>
                        </div>
                        <div class="canvas-controls">
                          <button class="mode-btn active" onclick="setNusantaraMode('ALL')">All 4 Syntheses</button>
                          <button class="mode-btn" onclick="setNusantaraMode('WAFQ')">I. Abjad 261 Wafq &amp; Naming</button>
                          <button class="mode-btn" onclick="setNusantaraMode('INDONESIA')">II &amp; III. Indonesia &amp; Sewer Grid</button>
                          <button class="mode-btn" onclick="setNusantaraMode('CALLIGRAPHY')">IV. Language &amp; Calligraphy</button>
                        </div>
                      </div>
                      <canvas id="namingIndonesiaCanvas" width="1280" height="390"></canvas>
                    </section>

                    <div class="toolbar-search">
                      <input type="text" id="nusantaraSearchInput" placeholder="Search across Zakeem Malik McCaleb, 261, Wafq, Wali Songo, Pesantren, SANIMAS, Jakarta Sewerage System, Jawi, Pegon, Ibn Muqlah, Nasta'liq..." oninput="filterNusantaraPortal()" />
                      <span id="nusantaraCountBadge" class="badge badge-gold">Showing All 27 Canonical Nodes</span>
                    </div>

                    <section class="section-block">
                      <div class="section-title">
                        <h2>I. Canonical Naming in Islam Across 7 World Regions (Fiqh Al-Asm&#x101;' wa Al-Ans&#x101;b)</h2>
                        <p>How Islamic law preserves paternal lineage (Qur'an 33:5) while validating regional naming structures from Hijaz and West Africa to Nusantara and Gaelic-American surnames.</p>
                      </div>
                      <div class="card-grid">
                        __NAMING_CARDS__
                      </div>
                    </section>

                    <section class="section-block">
                      <div class="section-title">
                        <h2>II. The Development of Indonesia (87.2% Muslim / ~251M): 7 Stages of Faith &amp; Gradual Canonical Evolution</h2>
                        <p>How the world's largest Muslim nation developed peacefully through maritime trade, the <em>Wali Songo's</em> gradualist dakwah (<em>At-Tadarruj</em>), Haramayn scholarship, Muhammadiyah &amp; NU, and Pancasila.</p>
                      </div>
                      <div class="card-grid">
                        __INDONESIA_CARDS__
                      </div>
                    </section>

                    <section class="section-block">
                      <div class="section-title">
                        <h2>III. Indonesia's Sanitation &amp; Sewer Infrastructure Project Structure vs. Global Benchmarks</h2>
                        <p>From IDR 5M&ndash;15M residential Bio-Septic tanks and communal SANIMAS/Pesantren digesters to IDR 5.1M/m microtunneling and the IDR 13 Trillion+ Jakarta Sewerage System (JSS) under Islamic <em>&#x1E6C;ah&#x101;rah</em> and <em>Waqf Sukuk</em>.</p>
                      </div>
                      <div class="table-wrapper">
                        <table>
                          <thead>
                            <tr>
                              <th>Tier &amp; Code</th>
                              <th>Development Scale &amp; System</th>
                              <th>US / Global Cost Benchmark</th>
                              <th>Indonesia Cost Range (IDR &amp; USD)</th>
                              <th>Engineering Scope &amp; Project Governance (PUPR / KPPIP / JSS)</th>
                              <th>Islamic &#x1E6C;ah&#x101;rah &amp; Waqf Integration</th>
                            </tr>
                          </thead>
                          <tbody>
                            __SEWER_ROWS__
                          </tbody>
                        </table>
                      </div>
                    </section>

                    <section class="section-block">
                      <div class="section-title">
                        <h2>IV. Islamic Developments Around Language (Na&#x1E25;w, Jawi, Pegon) &amp; Its Calligraphy ('Ilm Al-Kha&#x1E6D;&#x1E6D;)</h2>
                        <p>From Al-Khal&#x12B;l and S&#x12B;bawayh's grammar and Ibn Muqlah's Euclidean dot-and-circle proportions to the Six Classical Pens, Ottoman D&#x12B;w&#x101;n&#x12B;, Jawi/Pegon scripts, and Indonesia's <em>Mushaf Istiqlal</em>.</p>
                      </div>
                      <div class="card-grid">
                        __CALLIGRAPHY_CARDS__
                      </div>
                    </section>
                  </main>

                  <script>
                    let currentNusantaraMode = 'ALL';
                    let nusantaraTick = 0;

                    function setNusantaraMode(mode) {
                      currentNusantaraMode = mode;
                      document.querySelectorAll('.mode-btn').forEach(btn => {
                        btn.classList.toggle('active', btn.getAttribute('onclick').includes("'" + mode + "'"));
                      });
                    }

                    function filterNusantaraPortal() {
                      const q = (document.getElementById('nusantaraSearchInput').value || '').toLowerCase().trim();
                      let visible = 0;
                      document.querySelectorAll('.matrix-card, tbody tr').forEach(el => {
                        const hay = (el.getAttribute('data-search') || el.innerText || '').toLowerCase();
                        const match = !q || hay.includes(q);
                        el.style.display = match ? '' : 'none';
                        if (match) visible++;
                      });
                      const badge = document.getElementById('nusantaraCountBadge');
                      if (badge) badge.textContent = 'Showing ' + visible + ' of 27 Canonical Nodes';
                    }

                    (function initNusantaraCanvas() {
                      const canvas = document.getElementById('namingIndonesiaCanvas');
                      if (!canvas) return;
                      const ctx = canvas.getContext('2d');
                      const wafqCells = [
                        [78, 123, 60],
                        [69, 87, 105],
                        [114, 51, 96]
                      ];

                      function render() {
                        nusantaraTick += 0.025;
                        const w = canvas.width;
                        const h = canvas.height;
                        ctx.clearRect(0, 0, w, h);

                        // 1. LEFT: 3x3 Wafq of Zakeem Malik McCaleb (Line-Sum = 261, Crown = 123, Center = 87)
                        const leftAlpha = (currentNusantaraMode === 'ALL' || currentNusantaraMode === 'WAFQ') ? 1.0 : 0.25;
                        ctx.save();
                        ctx.globalAlpha = leftAlpha;
                        const sx = 95, sy = 85, cell = 64;
                        for (let r = 0; r < 3; r++) {
                          for (let c = 0; c < 3; c++) {
                            const x = sx + c * (cell + 8);
                            const y = sy + r * (cell + 8);
                            ctx.fillStyle = (r === 1 && c === 1) ? 'rgba(245, 158, 11, 0.24)' : ((r === 0 && c === 1) ? 'rgba(16, 185, 129, 0.22)' : 'rgba(18, 28, 49, 0.9)');
                            ctx.strokeStyle = (r === 1 && c === 1) ? '#f59e0b' : ((r === 0 && c === 1) ? '#10b981' : '#38bdf8');
                            ctx.lineWidth = 2;
                            ctx.strokeRect(x, y, cell, cell);
                            ctx.fillRect(x, y, cell, cell);

                            ctx.fillStyle = '#ffffff';
                            ctx.font = 'bold 16px Segoe UI, sans-serif';
                            ctx.textAlign = 'center';
                            ctx.fillText(String(wafqCells[r][c]), x + cell / 2, y + cell / 2 + 6);
                          }
                        }
                        ctx.fillStyle = '#f59e0b';
                        ctx.font = 'bold 13px Segoe UI, sans-serif';
                        ctx.textAlign = 'center';
                        ctx.fillText('I. ABJAD 261 WAFQ (ZAKEEM MALIK MCCALEB)', 200, 36);
                        ctx.fillStyle = '#94a3b8';
                        ctx.font = '11px Segoe UI, sans-serif';
                        ctx.fillText('47 (Zakeem) + 91 (Malik) + 123 (McCaleb) = 261', 200, 330);
                        ctx.fillText('Every Row, Col & Diagonal = 261 (Center 87)', 200, 350);
                        ctx.restore();

                        // 2. CENTER: Indonesian 3-Tier Tajug Mosque Roof (Islam, Iman, Ihsan) + 6-Tier Sewer/JSS Subterranean Grid
                        const midAlpha = (currentNusantaraMode === 'ALL' || currentNusantaraMode === 'INDONESIA') ? 1.0 : 0.25;
                        ctx.save();
                        ctx.globalAlpha = midAlpha;
                        const mx = 640;

                        // 3-Tier Tajug Roof (Demak / Wali Songo Architecture)
                        const tiers = [
                          { y: 95, w: 70, h: 24, label: 'Ihsan (Mustaka)' },
                          { y: 125, w: 130, h: 26, label: 'Iman (2nd Tier)' },
                          { y: 157, w: 190, h: 28, label: 'Islam (1st Tier)' }
                        ];
                        tiers.forEach(t => {
                          ctx.beginPath();
                          ctx.moveTo(mx, t.y - 14);
                          ctx.lineTo(mx + t.w, t.y + t.h);
                          ctx.lineTo(mx - t.w, t.y + t.h);
                          ctx.closePath();
                          ctx.fillStyle = 'rgba(16, 185, 129, 0.22)';
                          ctx.fill();
                          ctx.strokeStyle = '#10b981';
                          ctx.lineWidth = 2;
                          ctx.stroke();
                        });

                        // Subterranean 6-Tier Sanitation & JSS Microtunneling Pipeline
                        const pipeY = 255;
                        ctx.beginPath();
                        ctx.moveTo(430, pipeY);
                        ctx.lineTo(850, pipeY);
                        ctx.strokeStyle = '#38bdf8';
                        ctx.lineWidth = 8;
                        ctx.stroke();

                        for (let i = 0; i < 6; i++) {
                          const px = 445 + ((nusantaraTick * 65 + i * 68) % 390);
                          ctx.beginPath();
                          ctx.arc(px, pipeY, 4, 0, Math.PI * 2);
                          ctx.fillStyle = '#f59e0b';
                          ctx.fill();
                        }

                        const sewerLabels = ['Bio-Septic', 'SANIMAS', 'Commercial IPAL', 'Microtunnel', 'JSS Zone 1 (8T)', 'Waqf Sukuk'];
                        sewerLabels.forEach((lbl, idx) => {
                          const lx = 445 + idx * 76;
                          ctx.beginPath();
                          ctx.arc(lx, pipeY, 9, 0, Math.PI * 2);
                          ctx.fillStyle = '#0d1424';
                          ctx.fill();
                          ctx.strokeStyle = '#f59e0b';
                          ctx.lineWidth = 2;
                          ctx.stroke();
                          ctx.fillStyle = '#cbd5e1';
                          ctx.font = '10px Segoe UI, sans-serif';
                          ctx.textAlign = 'center';
                          ctx.fillText(lbl, lx, pipeY + 26);
                        });

                        ctx.fillStyle = '#10b981';
                        ctx.font = 'bold 13px Segoe UI, sans-serif';
                        ctx.textAlign = 'center';
                        ctx.fillText('II & III. INDONESIA (87.2% MUSLIM) TAJUG & JSS SANITATION GRID', mx, 36);
                        ctx.fillStyle = '#94a3b8';
                        ctx.font = '11px Segoe UI, sans-serif';
                        ctx.fillText('Above: 3-Tier Wali Songo Tajug Roof | Below: IDR 5M Bio-Septic to IDR 8T JSS Zone 1', mx, 350);
                        ctx.restore();

                        // 3. RIGHT: Ibn Muqlah's Calligraphic Circle, 7-Dot Alif & Jawi/Pegon
                        const rightAlpha = (currentNusantaraMode === 'ALL' || currentNusantaraMode === 'CALLIGRAPHY') ? 1.0 : 0.25;
                        ctx.save();
                        ctx.globalAlpha = rightAlpha;
                        const cx = 1085, cy = 185, rad = 84;

                        // Ad-Da'irah (The Calligraphic Circle)
                        ctx.beginPath();
                        ctx.arc(cx, cy, rad, 0, Math.PI * 2);
                        ctx.strokeStyle = 'rgba(245, 158, 11, 0.65)';
                        ctx.lineWidth = 2.2;
                        ctx.stroke();

                        // 7 Rhomboid Dots (An-Nuqtah) forming the vertical diameter (Al-Alif)
                        for (let d = -3; d <= 3; d++) {
                          const dy = cy + d * 22;
                          ctx.save();
                          ctx.translate(cx, dy);
                          ctx.rotate(Math.PI / 4);
                          ctx.fillStyle = '#f59e0b';
                          ctx.fillRect(-6, -6, 12, 12);
                          ctx.restore();
                        }

                        ctx.fillStyle = '#38bdf8';
                        ctx.font = 'bold 13px Segoe UI, sans-serif';
                        ctx.textAlign = 'center';
                        ctx.fillText('IV. IBN MUQLAH GEOMETRY & JAWI/PEGON', cx, 36);
                        ctx.fillStyle = '#e2e8f0';
                        ctx.font = '12px Segoe UI, sans-serif';
                        ctx.fillText('Al-Khatt Al-Mansub: 7-Dot Alif & Circle', cx, 315);
                        ctx.fillStyle = '#f59e0b';
                        ctx.fillText('Jawi/Pegon: چ  ڠ  ڤ  ڬ  ڽ  ۏ', cx, 345);
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
                .replace("__WAFQ_SECTION__", wafqSectionHtml.toString())
                .replace("__NAMING_CARDS__", namingCards.toString())
                .replace("__INDONESIA_CARDS__", indonesiaCards.toString())
                .replace("__SEWER_ROWS__", sewerRows.toString())
                .replace("__CALLIGRAPHY_CARDS__", calligraphyCards.toString());
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
