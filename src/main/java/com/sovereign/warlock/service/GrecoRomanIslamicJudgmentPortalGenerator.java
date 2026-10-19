package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.GrecoRomanPantheonIslamicJudgmentAndWholeness;
import com.sovereign.warlock.domain.GrecoRomanPantheonIslamicJudgmentAndWholeness.ErotesLoveJudgmentEntry;
import com.sovereign.warlock.domain.GrecoRomanPantheonIslamicJudgmentAndWholeness.GodhoodHierarchyTier;
import com.sovereign.warlock.domain.GrecoRomanPantheonIslamicJudgmentAndWholeness.MinorSpiritDomainCatalog;
import com.sovereign.warlock.domain.GrecoRomanPantheonIslamicJudgmentAndWholeness.OneiroiDreamJudgmentEntry;
import com.sovereign.warlock.domain.GrecoRomanPantheonIslamicJudgmentAndWholeness.TitanomachyWholenessEntry;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.HexFormat;

/**
 * Generates the static HTML portal {@code greco-roman-gods-titans-daimones-islamic-judgment.html}
 * (Portal #52) presenting the complete Greco-Roman Pantheon (Protogenoi, Titans & Titanomachy,
 * 12 Olympians / Dii Consentes, Roman Numina & Genii, Morpheus & the Oneiroi, the 7 Erotes,
 * and the 5 Domains of Minor Greek Spirits & Daimones) together with their reception,
 * judgment (Al-Furqan), and restoration to wholeness (At-Takmil) by monotheistic Muslims.
 */
public class GrecoRomanIslamicJudgmentPortalGenerator {

    public WarlockHtmlPortalService.GeneratedHtmlArtifact generateGrecoRomanIslamicJudgmentPortal(Path outputDir)
            throws IOException {
        Files.createDirectories(outputDir);
        String html = renderGrecoRomanIslamicJudgmentHtml();
        String fileName = "greco-roman-gods-titans-daimones-islamic-judgment.html";
        Path file = outputDir.resolve(fileName);
        Files.writeString(file, html, StandardCharsets.UTF_8);
        return new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                fileName,
                file,
                Files.size(file),
                sha256(html),
                "Greco-Roman Gods, Titans (Titanomachy), 12 Olympians, Morpheus/Oneiroi, 7 Erotes & Minor Spirits (Daimones/Nymphs): Islamic Reception, Judgment & Wholeness"
        );
    }

    private String renderGrecoRomanIslamicJudgmentHtml() {
        String[] palette = {"#F8F5E6", "#D4AF37", "#38BDF8", "#10B981", "#A78BFA", "#F43F5E", "#B87333"};

        StringBuilder tierCardsHtml = new StringBuilder();
        StringBuilder tierRowsHtml = new StringBuilder();
        for (GodhoodHierarchyTier t : GrecoRomanPantheonIslamicJudgmentAndWholeness.allSevenGodhoodTiers()) {
            String col = palette[(t.tierIndex() - 1) % palette.length];
            tierCardsHtml.append(String.format("""
                    <article class="card-block" style="border-top:4px solid %s;" data-filter-item="%s">
                      <div class="card-meta">
                        <span class="badge" style="background:%s;color:#080B11;">TIER #%d • %s</span>
                      </div>
                      <h3>%s</h3>
                      <div class="grid-2">
                        <div class="sub-box">
                          <span class="lbl">Classical Greco-Roman Nature &amp; Examples</span>
                          <p>%s</p>
                        </div>
                        <div class="sub-box">
                          <span class="lbl">Reception by Muslim Scholars (Bayt al-Ḥikmah, Kalām &amp; Milal)</span>
                          <p>%s</p>
                        </div>
                        <div class="sub-box warn">
                          <span class="lbl">Theological Judgment Under Al-Furqān (Nullifying Shirk)</span>
                          <p>%s</p>
                        </div>
                        <div class="sub-box whole">
                          <span class="lbl">How Made Whole in Tawḥīd (At-Takmīl wa Al-Iṣlāḥ)</span>
                          <p>%s</p>
                        </div>
                      </div>
                      <div class="proof-bar"><strong>Qur'anic &amp; Prophetic Proof:</strong> %s</div>
                    </article>
                    """,
                    col,
                    escape((t.greekAndRomanClassification() + " " + t.classicalNatureAndExamples() + " " + t.howMadeWholeInTawhid()).toLowerCase()),
                    col, t.tierIndex(), escape(t.tierCode()),
                    escape(t.greekAndRomanClassification()),
                    escape(t.classicalNatureAndExamples()),
                    escape(t.islamicHistoricalReception()),
                    escape(t.islamicTheologicalJudgment()),
                    escape(t.howMadeWholeInTawhid()),
                    escape(t.quranicAndHadithAnchor())
            ));

            tierRowsHtml.append(String.format("""
                    <tr>
                      <td><strong style="color:%s;">Tier #%d</strong><br><span class="mono-sm">%s</span></td>
                      <td><strong>%s</strong><br><span class="muted-sm">%s</span></td>
                      <td>%s</td>
                      <td>%s</td>
                      <td>%s</td>
                      <td><span class="cite-chip">%s</span></td>
                    </tr>
                    """,
                    col, t.tierIndex(), escape(t.tierCode()),
                    escape(t.greekAndRomanClassification()), escape(t.classicalNatureAndExamples()),
                    escape(t.islamicHistoricalReception()),
                    escape(t.islamicTheologicalJudgment()),
                    escape(t.howMadeWholeInTawhid()),
                    escape(t.quranicAndHadithAnchor())
            ));
        }

        StringBuilder titanCardsHtml = new StringBuilder();
        StringBuilder titanRowsHtml = new StringBuilder();
        for (TitanomachyWholenessEntry tm : GrecoRomanPantheonIslamicJudgmentAndWholeness.allSevenTitanomachyRestorations()) {
            String col = palette[(tm.titanIndex() - 1) % palette.length];
            titanCardsHtml.append(String.format("""
                    <article class="card-block" style="border-left:4px solid %s;" data-filter-item="%s">
                      <div class="card-meta">
                        <span class="badge" style="background:%s;color:#080B11;">TITANOMACHY RESTORATION #%d</span>
                      </div>
                      <h3>%s</h3>
                      <div class="grid-2">
                        <div class="sub-box warn">
                          <span class="lbl">Classical Titanomachy Fracture (Hesiod, Eumelos, Orpheus, Apollodorus)</span>
                          <p>%s</p>
                        </div>
                        <div class="sub-box">
                          <span class="lbl">Islamic Judgment of the Myth (Al-Furqān)</span>
                          <p>%s</p>
                        </div>
                      </div>
                      <div class="sub-box whole" style="margin-top:0.65rem;">
                        <span class="lbl">How Islam Made the Titan Whole (At-Takmīl fī At-Tawḥīd)</span>
                        <p>%s</p>
                      </div>
                      <div class="proof-bar"><strong>Qur'anic &amp; Hadith Anchor:</strong> %s</div>
                    </article>
                    """,
                    col,
                    escape((tm.titanOrSourceName() + " " + tm.classicalTitanomachyFracture() + " " + tm.howTitanIsMadeWholeInIslam()).toLowerCase()),
                    col, tm.titanIndex(),
                    escape(tm.titanOrSourceName()),
                    escape(tm.classicalTitanomachyFracture()),
                    escape(tm.islamicJudgmentOfTheMyth()),
                    escape(tm.howTitanIsMadeWholeInIslam()),
                    escape(tm.quranicAndPropheticProof())
            ));

            titanRowsHtml.append(String.format("""
                    <tr>
                      <td><strong style="color:%s;">#%d</strong></td>
                      <td><strong>%s</strong></td>
                      <td>%s</td>
                      <td>%s</td>
                      <td>%s</td>
                      <td><span class="cite-chip">%s</span></td>
                    </tr>
                    """,
                    col, tm.titanIndex(),
                    escape(tm.titanOrSourceName()),
                    escape(tm.classicalTitanomachyFracture()),
                    escape(tm.islamicJudgmentOfTheMyth()),
                    escape(tm.howTitanIsMadeWholeInIslam()),
                    escape(tm.quranicAndPropheticProof())
            ));
        }

        StringBuilder oneiroiCardsHtml = new StringBuilder();
        for (OneiroiDreamJudgmentEntry o : GrecoRomanPantheonIslamicJudgmentAndWholeness.allFourOneiroiDreamEntries()) {
            String col = palette[(o.dreamIndex() - 1) % palette.length];
            oneiroiCardsHtml.append(String.format("""
                    <article class="card-block" style="border-top:4px solid %s;" data-filter-item="%s">
                      <div class="card-meta">
                        <span class="badge" style="background:%s;color:#080B11;">ONEIROI / SOMNIA #%d</span>
                      </div>
                      <h3>%s</h3>
                      <p class="station-line"><strong>Canonical Islamic Counterpart:</strong> %s</p>
                      <div class="grid-2">
                        <div class="sub-box">
                          <span class="lbl">Classical Greco-Roman Role &amp; Linguistic Legacy</span>
                          <p>%s</p>
                        </div>
                        <div class="sub-box whole">
                          <span class="lbl">How Judged &amp; Made Whole in Islamic Dream Science ('Ilm Ta'bīr Ar-Ru'yā)</span>
                          <p>%s</p>
                        </div>
                      </div>
                      <div class="proof-bar"><strong>Qur'anic &amp; Prophetic Proof:</strong> %s</div>
                    </article>
                    """,
                    col,
                    escape((o.greekAndRomanName() + " " + o.islamicDreamClassification() + " " + o.howJudgedAndMadeWhole()).toLowerCase()),
                    col, o.dreamIndex(),
                    escape(o.greekAndRomanName()),
                    escape(o.islamicDreamClassification()),
                    escape(o.classicalDomainAndEtymology()),
                    escape(o.howJudgedAndMadeWhole()),
                    escape(o.quranicAndHadithProof())
            ));
        }

        StringBuilder erotesCardsHtml = new StringBuilder();
        StringBuilder erotesRowsHtml = new StringBuilder();
        for (ErotesLoveJudgmentEntry e : GrecoRomanPantheonIslamicJudgmentAndWholeness.allSevenErotesLoveEntries()) {
            String col = palette[(e.eroteIndex() - 1) % palette.length];
            erotesCardsHtml.append(String.format("""
                    <article class="card-block" style="border-left:4px solid %s;" data-filter-item="%s">
                      <div class="card-meta">
                        <span class="badge" style="background:%s;color:#080B11;">EROTE #%d</span>
                      </div>
                      <h3>%s</h3>
                      <p class="station-line"><strong>Islamic Station of Love:</strong> %s</p>
                      <div class="grid-2">
                        <div class="sub-box">
                          <span class="lbl">Classical Greek Aspect &amp; Visual Symbol</span>
                          <p>%s</p>
                        </div>
                        <div class="sub-box warn">
                          <span class="lbl">Judgment of Unlawful Caprice (Al-Hawā)</span>
                          <p>%s</p>
                        </div>
                      </div>
                      <div class="sub-box whole" style="margin-top:0.65rem;">
                        <span class="lbl">How Made Whole in Islamic Love (Al-Maḥabbah, Mawaddah &amp; Nikāḥ)</span>
                        <p>%s</p>
                      </div>
                      <div class="proof-bar"><strong>Qur'anic &amp; Hadith Proof:</strong> %s</div>
                    </article>
                    """,
                    col,
                    escape((e.eroteName() + " " + e.islamicCounterpartStation() + " " + e.howMadeWholeInIslamicLove()).toLowerCase()),
                    col, e.eroteIndex(),
                    escape(e.eroteName()),
                    escape(e.islamicCounterpartStation()),
                    escape(e.greekAspectAndSymbol()),
                    escape(e.judgmentOfUnlawfulExcess()),
                    escape(e.howMadeWholeInIslamicLove()),
                    escape(e.quranicAndHadithProof())
            ));

            erotesRowsHtml.append(String.format("""
                    <tr>
                      <td><strong style="color:%s;">#%d</strong></td>
                      <td><strong>%s</strong></td>
                      <td>%s</td>
                      <td>%s</td>
                      <td>%s</td>
                      <td>%s</td>
                      <td><span class="cite-chip">%s</span></td>
                    </tr>
                    """,
                    col, e.eroteIndex(),
                    escape(e.eroteName()),
                    escape(e.greekAspectAndSymbol()),
                    escape(e.islamicCounterpartStation()),
                    escape(e.judgmentOfUnlawfulExcess()),
                    escape(e.howMadeWholeInIslamicLove()),
                    escape(e.quranicAndHadithProof())
            ));
        }

        StringBuilder minorDomainCardsHtml = new StringBuilder();
        for (MinorSpiritDomainCatalog d : GrecoRomanPantheonIslamicJudgmentAndWholeness.allFiveMinorSpiritDomains()) {
            minorDomainCardsHtml.append(String.format("""
                    <article class="card-block full-span" style="border-top:4px solid %s;" data-filter-item="%s">
                      <div class="card-meta">
                        <span class="badge" style="background:%s;color:#080B11;">MINOR SPIRIT DOMAIN #%d • %s</span>
                      </div>
                      <h3>%s</h3>
                      <div class="sub-box" style="margin-bottom:0.75rem;">
                        <span class="lbl">Exhaustive Classical Greek Roster (Hesiod, Homer, Pausanias, Orphic Hymns &amp; Theoi)</span>
                        <p style="font-size:0.86rem;line-height:1.7;">%s</p>
                      </div>
                      <div class="grid-3">
                        <div class="sub-box">
                          <span class="lbl">Classical Ritual &amp; Cultural Role</span>
                          <p>%s</p>
                        </div>
                        <div class="sub-box warn">
                          <span class="lbl">Islamic Theological Judgment (Al-Furqān)</span>
                          <p>%s</p>
                        </div>
                        <div class="sub-box whole">
                          <span class="lbl">How Made Whole in Islam (At-Takmīl)</span>
                          <p>%s</p>
                        </div>
                      </div>
                      <div class="proof-bar"><strong>Qur'anic &amp; Sunnah Anchor:</strong> %s</div>
                    </article>
                    """,
                    d.colorHex(),
                    escape((d.domainTitle() + " " + d.exhaustiveGreekSpiritRoster() + " " + d.howMadeWholeInIslam()).toLowerCase()),
                    d.colorHex(), d.domainIndex(), escape(d.domainCode()),
                    escape(d.domainTitle()),
                    escape(d.exhaustiveGreekSpiritRoster()),
                    escape(d.classicalRitualAndRole()),
                    escape(d.islamicReceptionAndJudgment()),
                    escape(d.howMadeWholeInIslam()),
                    escape(d.quranicAndSunnahAnchor())
            ));
        }

        String template = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <title>Greco-Roman Gods, Titans, Morpheus/Oneiroi, Erotes &amp; Minor Spirits: Islamic Reception, Judgment &amp; Wholeness</title>
                  <style>
                    :root {
                      --bg-deep: #070A11;
                      --bg-panel: #0E1422;
                      --bg-card: #131B2E;
                      --gold: #D4AF37;
                      --emerald: #10B981;
                      --sapphire: #38BDF8;
                      --crimson: #F43F5E;
                      --text-main: #F1F5F9;
                      --text-muted: #94A3B8;
                      --border: rgba(212, 175, 55, 0.25);
                    }
                    * { box-sizing: border-box; margin: 0; padding: 0; }
                    body {
                      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
                      background: radial-gradient(circle at 15% 5%, rgba(212,175,55,0.14), transparent 45%),
                                  radial-gradient(circle at 85% 10%, rgba(56,189,248,0.12), transparent 45%),
                                  var(--bg-deep);
                      color: var(--text-main);
                      line-height: 1.65;
                      padding-bottom: 5rem;
                    }
                    .hero {
                      max-width: 1400px;
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
                      background: rgba(212,175,55,0.15);
                      border: 1px solid var(--gold);
                      color: #FDE68A;
                      font-size: 0.78rem;
                      font-weight: 700;
                      text-transform: uppercase;
                      letter-spacing: 0.08em;
                      margin-bottom: 0.85rem;
                    }
                    h1 {
                      font-size: clamp(1.85rem, 3.1vw, 2.7rem);
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
                      max-width: 1120px;
                      font-size: 1.01rem;
                      margin-bottom: 1.3rem;
                    }
                    .container {
                      max-width: 1400px;
                      margin: 0 auto;
                      padding: 2rem;
                    }
                    .search-bar-wrap {
                      background: var(--bg-panel);
                      border: 1px solid var(--border);
                      border-radius: 12px;
                      padding: 1rem 1.25rem;
                      margin-bottom: 1.8rem;
                      display: flex;
                      flex-wrap: wrap;
                      gap: 1rem;
                      align-items: center;
                      justify-content: space-between;
                    }
                    .search-input {
                      flex: 1;
                      min-width: 280px;
                      background: #060911;
                      border: 1px solid var(--sapphire);
                      color: #FFF;
                      padding: 0.65rem 1rem;
                      border-radius: 8px;
                      font-size: 0.9rem;
                    }
                    .section-title {
                      display: flex;
                      flex-wrap: wrap;
                      justify-content: space-between;
                      align-items: flex-end;
                      gap: 1rem;
                      margin: 2.3rem 0 1.2rem;
                      padding-bottom: 0.65rem;
                      border-bottom: 2px solid var(--border);
                    }
                    .section-title h2 { font-size: 1.48rem; color: #FFF; }
                    .section-title span { font-size: 0.82rem; color: var(--gold); font-family: monospace; }
                    /* Interactive Mizan Canvas */
                    .sim-shell {
                      display: grid;
                      grid-template-columns: 1fr 400px;
                      gap: 1.25rem;
                      background: var(--bg-panel);
                      border: 1px solid var(--border);
                      border-radius: 16px;
                      padding: 1.25rem;
                    }
                    @media (max-width: 1080px) { .sim-shell { grid-template-columns: 1fr; } }
                    .canvas-box {
                      background: #050810;
                      border: 1px solid rgba(255,255,255,0.12);
                      border-radius: 12px;
                      overflow: hidden;
                    }
                    .toolbar {
                      display: flex;
                      flex-wrap: wrap;
                      gap: 0.45rem;
                      padding: 0.75rem;
                      background: rgba(10,14,24,0.94);
                      border-bottom: 1px solid rgba(255,255,255,0.08);
                    }
                    .tab-btn {
                      padding: 0.38rem 0.75rem;
                      border-radius: 8px;
                      border: 1px solid rgba(212,175,55,0.35);
                      background: rgba(19, 27, 46, 0.9);
                      color: #E2E8F0;
                      font-size: 0.75rem;
                      font-weight: 600;
                      cursor: pointer;
                    }
                    .tab-btn:hover, .tab-btn.active {
                      background: var(--gold);
                      color: #070A11;
                      border-color: #FFF;
                    }
                    #mizanPantheonCanvas {
                      width: 100%;
                      height: 520px;
                      display: block;
                      cursor: pointer;
                    }
                    .hud {
                      background: var(--bg-card);
                      border: 1px solid rgba(255,255,255,0.1);
                      border-radius: 12px;
                      padding: 1.15rem;
                      display: flex;
                      flex-direction: column;
                      gap: 0.75rem;
                    }
                    .hud-badge {
                      display: inline-block;
                      padding: 0.22rem 0.65rem;
                      border-radius: 6px;
                      font-size: 0.72rem;
                      font-weight: 800;
                      background: rgba(212,175,55,0.2);
                      color: #FDE68A;
                      width: fit-content;
                    }
                    .hud-box {
                      background: rgba(7,10,17,0.7);
                      border: 1px solid rgba(255,255,255,0.08);
                      border-radius: 8px;
                      padding: 0.68rem 0.8rem;
                      font-size: 0.82rem;
                    }
                    .hud-box strong {
                      display: block;
                      color: #93C5FD;
                      font-size: 0.72rem;
                      text-transform: uppercase;
                      margin-bottom: 0.2rem;
                    }
                    .cards-grid {
                      display: grid;
                      grid-template-columns: repeat(auto-fit, minmax(560px, 1fr));
                      gap: 1.25rem;
                    }
                    @media (max-width: 680px) { .cards-grid { grid-template-columns: 1fr; } }
                    .card-block {
                      background: var(--bg-card);
                      border: 1px solid rgba(255,255,255,0.1);
                      border-radius: 14px;
                      padding: 1.35rem;
                      display: flex;
                      flex-direction: column;
                      gap: 0.75rem;
                    }
                    .card-block.full-span {
                      grid-column: 1 / -1;
                    }
                    .badge {
                      padding: 0.24rem 0.65rem;
                      border-radius: 6px;
                      font-size: 0.72rem;
                      font-weight: 800;
                      letter-spacing: 0.04em;
                    }
                    .card-block h3 { font-size: 1.15rem; color: #FFF; }
                    .station-line { font-size: 0.86rem; color: #A7F3D0; }
                    .grid-2 {
                      display: grid;
                      grid-template-columns: 1fr 1fr;
                      gap: 0.75rem;
                    }
                    .grid-3 {
                      display: grid;
                      grid-template-columns: repeat(3, 1fr);
                      gap: 0.75rem;
                    }
                    @media (max-width: 860px) {
                      .grid-2, .grid-3 { grid-template-columns: 1fr; }
                    }
                    .sub-box {
                      background: rgba(7, 10, 17, 0.72);
                      border: 1px solid rgba(255,255,255,0.08);
                      border-radius: 8px;
                      padding: 0.75rem;
                    }
                    .sub-box.warn {
                      border-color: rgba(244, 63, 94, 0.38);
                      background: rgba(244, 63, 94, 0.06);
                    }
                    .sub-box.whole {
                      border-color: rgba(16, 185, 129, 0.42);
                      background: rgba(16, 185, 129, 0.08);
                    }
                    .sub-box .lbl {
                      display: block;
                      font-size: 0.71rem;
                      font-weight: 700;
                      text-transform: uppercase;
                      color: #FDE68A;
                      margin-bottom: 0.3rem;
                    }
                    .sub-box p { font-size: 0.84rem; color: #E2E8F0; }
                    .proof-bar {
                      margin-top: auto;
                      padding-top: 0.6rem;
                      border-top: 1px dashed rgba(255,255,255,0.14);
                      font-size: 0.8rem;
                      color: #7DD3FC;
                    }
                    .table-wrap {
                      overflow-x: auto;
                      background: var(--bg-panel);
                      border: 1px solid var(--border);
                      border-radius: 14px;
                      margin-top: 1rem;
                    }
                    table { width: 100%; border-collapse: collapse; font-size: 0.82rem; }
                    th, td {
                      padding: 0.8rem 0.85rem;
                      text-align: left;
                      border-bottom: 1px solid rgba(255,255,255,0.08);
                      vertical-align: top;
                    }
                    th {
                      background: rgba(212, 175, 55, 0.14);
                      color: #FDE68A;
                      font-size: 0.74rem;
                      text-transform: uppercase;
                    }
                    .mono-sm { font-family: monospace; font-size: 0.72rem; color: #94A3B8; }
                    .muted-sm { font-size: 0.76rem; color: #94A3B8; }
                    .cite-chip {
                      display: inline-block;
                      padding: 0.2rem 0.5rem;
                      border-radius: 6px;
                      background: rgba(56,189,248,0.12);
                      border: 1px solid rgba(56,189,248,0.35);
                      color: #7DD3FC;
                      font-size: 0.73rem;
                    }
                  </style>
                </head>
                <body>
                  <section class="hero">
                    <div class="eyebrow">Portal #52 • Comparative Pantheon Judgment &amp; Tawḥīdī Wholeness (Al-Furqān wa At-Takmīl)</div>
                    <h1>Greco-Roman Gods, The Titanomachy, The 12 Olympians, Morpheus &amp; The Oneiroi, The 7 Erotes &amp; All Minor Spirits: How Monotheistic Muslims Received, Judged &amp; Made Them Whole</h1>
                    <div class="arabic-hero">حُكم الفرقان وتكميل الميزان: كيف تلقّى المسلمون الموحّدون آلهة اليونان والرومان والتيتان ومورفيوس والإيروتس والأرواح الصغرى فحكموا عليها وجعلوها كاملة في التوحيد</div>
                    <p class="lead">
                      In Greco-Roman polytheism, the absence of <strong>Tawḥīd (One Uncreated Creator)</strong> fractured reality into warring generations and hundreds of splintered spirits:
                      the <strong>Titanomachy</strong> split Primordials, Titans, and Olympians through parricide and Tartarean chains; human psychology was splintered into <strong>75+ Daimones</strong>;
                      sleep and dreams were split among <strong>Hypnos/Somnus, Morpheus, Phobetor/Icelus, and Phantasos</strong>; love was fractured into the <strong>7 Winged Erotes</strong>;
                      and every spring, tree, wind, and pantry was assigned a local <strong>Nymph, Numen, or Agathos Daimon</strong>.
                      When monotheistic Muslim scholars (<em>Bayt al-Ḥikmah, Al-Kindī, Al-Bīrūnī, Ash-Shahrastānī, Al-Ghazālī, Ibn Ḥazm, As-Suhrawardī, Ibn 'Arabī, and Ibn Qayyim</em>) received this heritage,
                      they judged every tier by the <strong>Criterion of Al-Furqān (Qur'an 21:22 &amp; 12:39–40)</strong>—nullifying false divinity (<em>Shirk</em>) while <strong>making the fragmented archetypes whole just as they made the Titans whole</strong>.
                    </p>
                  </section>

                  <main class="container">
                    <div class="search-bar-wrap">
                      <input type="text" class="search-input" placeholder="Search any deity or spirit (e.g., Morpheus, Phobetor, Phantasos, Eros, Anteros, Pothos, Titanomachy, Atlas, Prometheus, Aidos, Naiads, Pan, Asclepius)..." oninput="filterPantheonCards(this.value)">
                      <span style="font-size:0.82rem;color:#FDE68A;font-family:monospace;">7 GODHOOD TIERS • 7 TITAN RESTORATIONS • 4 ONEIROI • 7 EROTES • 150+ MINOR SPIRITS</span>
                    </div>

                    <div class="section-title">
                      <h2>I. Interactive 2.5D Scale of Al-Mīzān: From Polytheistic Fracture (Titanomachy) to Monotheistic Wholeness (At-Takmīl)</h2>
                      <span>CLICK ANY NODE OR SPHERE TO INSPECT ITS CLASSICAL ROLE, ISLAMIC JUDGMENT &amp; RESTORATION</span>
                    </div>

                    <div class="sim-shell">
                      <div class="canvas-box">
                        <div class="toolbar">
                          <button class="tab-btn active" onclick="setSphereFilter('all', this)">All 5 Spheres</button>
                          <button class="tab-btn" onclick="setSphereFilter('titans', this)">1. Titans &amp; Titanomachy Made Whole</button>
                          <button class="tab-btn" onclick="setSphereFilter('olympians', this)">2. 12 Olympians, Dii Consentes &amp; Numina</button>
                          <button class="tab-btn" onclick="setSphereFilter('oneiroi', this)">3. Morpheus, Phobetor, Phantasos &amp; Hypnos</button>
                          <button class="tab-btn" onclick="setSphereFilter('erotes', this)">4. The 7 Winged Erotes Made Whole</button>
                          <button class="tab-btn" onclick="setSphereFilter('minor', this)">5. Daimones, Nymphs, Nomioi &amp; Household</button>
                        </div>
                        <canvas id="mizanPantheonCanvas" width="920" height="520"></canvas>
                      </div>
                      <aside class="hud">
                        <span class="hud-badge" id="pHudBadge">TITANOMACHY RESTORATION • ATLAS &amp; PROMETHEUS</span>
                        <div style="font-size:1.12rem;font-weight:700;color:#FFF;" id="pHudTitle">Making the Titans Whole: From Tartarean Chains to Angelic Praise &amp; Adamic Stewardship</div>
                        <div class="hud-box">
                          <strong>Classical Greco-Roman Fracture</strong>
                          <span id="pHudClassical">In Hesiod's Theogony, Zeus overthrows his father Cronus, condemns Atlas to bear the crushing sky in torment, and chains Prometheus to Caucasus for giving fire and craft to humanity.</span>
                        </div>
                        <div class="hud-box">
                          <strong>Islamic Theological Judgment (Al-Furqān)</strong>
                          <span id="pHudJudgment">Qur'an 21:22 &amp; 23:91 judge cosmic parricide and divine jealousy as false projections of human tyranny. Allah neither begets nor fears a rival.</span>
                        </div>
                        <div class="hud-box">
                          <strong>How Made Whole in Tawḥīd (At-Takmīl)</strong>
                          <span id="pHudWhole">Atlas is made whole as the 8 Throne-Bearing Angels (Ḥamalatu Al-'Arsh, Qur'an 40:7) who carry the canopy in joyous Tasbīḥ; Prometheus is made whole by Allah willingly teaching Adam all Names (2:31) and gifting fire (36:80) and iron (57:25); Cronus/Time becomes Ad-Dahr in Allah's Hand (Bukhari 4826).</span>
                        </div>
                      </aside>
                    </div>

                    <div class="section-title">
                      <h2>II. How Islam Made the Titans Whole: Healing the 7 Fractures of the Titanomachy</h2>
                      <span>HESIOD'S THEOGONY • EUMELOS' EPIC CYCLE • ORPHIC TITANIC ASHES • THAMYRIS • APOLLODORUS</span>
                    </div>
                    <div class="cards-grid">
                      __TITAN_CARDS__
                    </div>

                    <div class="table-wrap">
                      <table>
                        <thead>
                          <tr>
                            <th>#</th>
                            <th>Titan / Titanomachy Source</th>
                            <th>Classical Fracture &amp; Penal Myth</th>
                            <th>Islamic Judgment (Al-Furqān)</th>
                            <th>How Made Whole in Islam (At-Takmīl)</th>
                            <th>Qur'anic &amp; Prophetic Proof</th>
                          </tr>
                        </thead>
                        <tbody>
                          __TITAN_ROWS__
                        </tbody>
                      </table>
                    </div>

                    <div class="section-title">
                      <h2>III. The 7 Tiers of Greco-Roman Godhood (Protogenoi, Titans, 3/12/14 Olympians, Numina, Chthonic, Daimones &amp; Apotheosis)</h2>
                      <span>INTERPRETATIO ROMANA vs. FURQĀN AL-ASMĀ' AL-ḤUSNĀ WA AL-MALĀ'IKAH</span>
                    </div>
                    <div class="cards-grid">
                      __TIER_CARDS__
                    </div>

                    <div class="table-wrap">
                      <table>
                        <thead>
                          <tr>
                            <th>Tier</th>
                            <th>Greco-Roman Classification &amp; Examples</th>
                            <th>Muslim Scholarly Reception</th>
                            <th>Theological Judgment</th>
                            <th>How Made Whole in Tawḥīd</th>
                            <th>Primary Anchor</th>
                          </tr>
                        </thead>
                        <tbody>
                          __TIER_ROWS__
                        </tbody>
                      </table>
                    </div>

                    <div class="section-title">
                      <h2>IV. Morpheus, Hypnos &amp; His Three Dream-Sons (The Oneiroi / Somnia) in Islamic Dream Science ('Ilm Ta'bīr Ar-Ru'yā)</h2>
                      <span>HYPNOS/SOMNUS (QUR'AN 39:42) • MORPHEUS (RU'YĀ ṢĀLIḤAH) • PHOBETOR/ICELUS (ḤULUM ASH-SHAYṬĀN) • PHANTASOS (ḤADĪTH AN-NAFS &amp; KHAYĀL)</span>
                    </div>
                    <div class="cards-grid">
                      __ONEIROI_CARDS__
                    </div>

                    <div class="section-title">
                      <h2>V. The 7 Winged Erotes Judged &amp; Made Whole in the Islamic Architecture of Love (Al-Maḥabbah, Mawaddah &amp; Nikāḥ)</h2>
                      <span>EROS &amp; PSYCHE • ANTEROS • HIMEROS • POTHOS • HEDYLOGOS • HYMENAEUS • HERMAPHRODITUS</span>
                    </div>
                    <div class="cards-grid">
                      __EROTES_CARDS__
                    </div>

                    <div class="table-wrap">
                      <table>
                        <thead>
                          <tr>
                            <th>#</th>
                            <th>The Erote</th>
                            <th>Classical Aspect &amp; Symbol</th>
                            <th>Islamic Station of Love</th>
                            <th>Judgment of Capricious Excess</th>
                            <th>How Made Whole in Islam</th>
                            <th>Proof</th>
                          </tr>
                        </thead>
                        <tbody>
                          __EROTES_ROWS__
                        </tbody>
                      </table>
                    </div>

                    <div class="section-title">
                      <h2>VI. Complete 5-Domain Catalog of Minor Greek Deities &amp; Spirits (150+ Daimones, Nymphs, Theoi Nomioi, Chthonic &amp; Domestic Guardians)</h2>
                      <span>EVERY EMOTION, SPRING, TREE, WIND, KILN-DAIMON, HERO CULT &amp; HOUSEHOLD SPIRIT JUDGED &amp; MADE WHOLE</span>
                    </div>
                    <div class="cards-grid">
                      __MINOR_DOMAIN_CARDS__
                    </div>
                  </main>

                  <script>
                    function filterPantheonCards(q) {
                      const query = (q || '').toLowerCase().trim();
                      document.querySelectorAll('[data-filter-item]').forEach(el => {
                        const hay = el.getAttribute('data-filter-item') || '';
                        el.style.display = (!query || hay.includes(query)) ? 'flex' : 'none';
                      });
                    }

                    const NODES = [
                      {
                        id: "CRONUS_DAHR", x: 160, y: 120, tx: 760, ty: 120, color: "#F8F5E6", sphere: "titans",
                        badge: "TITAN #1 • CRONUS / KHRONOS → AD-DAHR (TIME)",
                        title: "Cronus (Child-Devouring Time) Made Whole as Ad-Dahr & Surah Al-'Aṣr",
                        classical: "Cronus castrated Ouranos and swallowed his own children until overthrown by Zeus and locked in Tartarus.",
                        judgment: "Judged as the pagan terror of Time (Ad-Dahr) imagined as a blind monster devouring its offspring.",
                        whole: "Made whole by Hadith Qudsi (Bukhari 4826): 'Do not curse Time (Ad-Dahr), for Allah is Ad-Dahr; in My Hand is the command, turning night and day,' and Surah Al-'Asr (103:1-3)."
                      },
                      {
                        id: "ATLAS_ARSH", x: 135, y: 210, tx: 785, ty: 210, color: "#D4AF37", sphere: "titans",
                        badge: "TITAN #2 • ATLAS & PROMETHEUS → ḤAMALATU AL-'ARSH & TA'LĪM AL-ASMĀ'",
                        title: "Atlas & Prometheus Made Whole: Throne-Bearing Angels & Adamic Knowledge",
                        classical: "Atlas is crushed forever under the sky vault as penal punishment; Prometheus is chained and tortured by Zeus for giving fire and craft to humans.",
                        judgment: "Exposes polytheistic tyranny where cosmic stability rests on slavery and gods resent human enlightenment.",
                        whole: "Atlas is made whole as the 8 Throne-Bearing Angels (Qur'an 40:7) who carry the canopy in joyous praise and pray for believers; Prometheus is made whole by Allah willingly teaching Adam all Names (2:31) and gifting fire (36:80) and iron (57:25)."
                      },
                      {
                        id: "THEMIS_MIZAN", x: 175, y: 300, tx: 745, ty: 300, color: "#10B981", sphere: "titans",
                        badge: "TITAN #3 • THEMIS, MNEMOSYNE & ORPHIC ASH → AL-MĪZĀN, AL-LAWḤ & FIṬRAH",
                        title: "Themis, Mnemosyne & Orphic Ashes Made Whole in Al-Mīzān & Aḥsan Taqwīm",
                        classical: "Zeus had to absorb Titanesses Themis (Law) and Mnemosyne (Memory); Orphic myth claimed humans were molded from wicked Titanic ash.",
                        judgment: "Power without intrinsic Law and Memory is defective, and calling the human body 'Titanic soot' slanders creation.",
                        whole: "Themis is made whole in Al-Mīzān (Qur'an 55:7-9); Mnemosyne in Al-Lawḥ Al-Maḥfūẓ (85:22) and Dhikr; and Orphic ash is healed by Qur'an 95:4 ('Created man in the best of stature — Aḥsan Taqwīm')."
                      },
                      {
                        id: "OLYMPIANS_ASMA", x: 245, y: 155, tx: 675, ty: 155, color: "#38BDF8", sphere: "olympians",
                        badge: "PANTHEON • THE 3, 12 & 14 OLYMPIANS / DII CONSENTES → AL-ASMĀ' AL-ḤUSNĀ",
                        title: "The 12 Olympians, Big 3 & Roman Numina Re-Unified in the 99 Divine Names",
                        classical: "Zeus, Poseidon, Hades (Big 3) drew lots to split the universe; 12 Olympians / Dii Consentes and Roman Numina (Janus, Robigo) divided sovereignty into departmental gods.",
                        judgment: "Judged by Yusuf's prison sermon (Qur'an 12:39-40: 'Are separate lords better, or Allah, the One, the Prevailing?') and 21:22.",
                        whole: "All fragmented departmental powers (provision, wisdom, healing, peace, victory) are reunited into the 99 Beautiful Names of Allah (Al-Malik, Al-'Alīm, Ar-Razzāq, Ash-Shāfī, As-Salām), while threshold Numina become Prophetic Bismillah Adhkār."
                      },
                      {
                        id: "MORPHEUS_ONEIROI", x: 230, y: 265, tx: 690, ty: 265, color: "#A78BFA", sphere: "oneiroi",
                        badge: "ONEIROI / SOMNIA • HYPNOS, MORPHEUS, PHOBETOR & PHANTASOS → TA'BĪR AR-RU'YĀ",
                        title: "Morpheus & His Brothers Judged & Made Whole in the Prophetic Dream Triad",
                        classical: "Hypnos/Somnus (Sleep) & Thanatos (Death) sire Morpheus (human shapes), Phobetor/Icelus (beast nightmares), and Phantasos (inanimate landscape shapes).",
                        judgment: "Qur'an 39:42 reveals Allah Himself takes souls at death and during sleep (Al-Mawt Al-Asghar); Bukhari 7017 divides all dreams into exactly three canonical types.",
                        whole: "Morpheus -> Veridical Vision (Ar-Ru'yā Aṣ-Ṣāliḥah, 1/46th of Prophecy & Angelic Tamaththul, where Shaytan can never mimic the Prophet ﷺ, Bukhari 6993); Phobetor -> Nightmare neutralized by 3 dry spits & Isti'ādhah (Bukhari 6985); Phantasos -> Ḥadīth An-Nafs & symbolic landscape Ta'bīr."
                      },
                      {
                        id: "SEVEN_EROTES", x: 215, y: 375, tx: 705, ty: 375, color: "#F43F5E", sphere: "erotes",
                        badge: "THE 7 EROTES • EROS, ANTEROS, HIMEROS, POTHOS, HEDYLOGOS, HYMENAEUS, HERMAPHRODITUS",
                        title: "The 7 Winged Erotes Re-Integrated into Sacred Islamic Love & Nikāḥ",
                        classical: "Seven winged love gods personifying passion (Eros), requited love (Anteros), urgent lust (Himeros), longing (Pothos), sweet-talk (Hedylogos), marriage hymn (Hymenaeus), and union (Hermaphroditus).",
                        judgment: "Capricious arrows of unlawful lust (Zinā/Hawā) are barred, while every authentic dimension of love is sanctified.",
                        whole: "Eros & Psyche -> Mawaddah/Raḥmah (30:21) & An-Nafs Al-Muṭma'innah; Anteros -> Reciprocal love (5:54 & 2:187); Himeros -> Lawful intimacy rewarded as Ṣadaqah (Muslim 1006); Pothos -> Ash-Shawq ilā Liqā' Allāh; Hedylogos -> Kalimah Ṭayyibah; Hymenaeus -> Al-Mīthāq Al-Ghalīẓ (4:21); Hermaphroditus -> Min Nafsin Wāḥidah (4:1)."
                      },
                      {
                        id: "MINOR_SPIRITS_150", x: 165, y: 445, tx: 755, ty: 445, color: "#B87333", sphere: "minor",
                        badge: "150+ MINOR SPIRITS • DAIMONES, NYMPHS, THEOI NOMIOI, CHTHONIC & AGATHOS DAIMON",
                        title: "All 5 Domains of Minor Greek Spirits Judged & Made Whole",
                        classical: "75+ emotional Daimones (Aidos, Dike, Eris, Phobos, Nemesis, Hygieia), Nymphs (Naiads, Dryads, Pleiades), Rustic Nomioi (Pan, Aristaeus, Anemoi), Chthonic (Charon, Erinyes, Lamia), and Domestic (Agathos Daimon, Asclepius).",
                        judgment: "Stripped of idol-sacrifices, tree-cults (Dhāt Anwāṭ), star-rain superstition (Anwā'), and ghoul-terror ('Lā Ghūla').",
                        whole: "Virtue Daimones become the 70+ Branches of Faith (Al-Ḥayā' = Aidos, Bukhari 9); Nymphs are revealed as universal Tasbīḥ of trees/springs (Qur'an 17:44, 55:6) and Mīkā'īl's angels; Aristaeus -> Surah An-Nahl (16:68); Pan's panic -> Muslim 2708 valley refuge; Agathos Daimon -> Bismillah domestic shield (Muslim 2018); Asclepius -> Prophetic medicine under Ash-Shāfī."
                      }
                    ];

                    let currentSphere = 'all';
                    let activeNode = NODES[1];
                    let tick = 0;

                    function setSphereFilter(s, btn) {
                      currentSphere = s;
                      document.querySelectorAll('.tab-btn').forEach(b => b.classList.remove('active'));
                      if (btn) btn.classList.add('active');
                      const match = NODES.find(n => s === 'all' || n.sphere === s);
                      if (match) selectNode(match);
                    }

                    function selectNode(n) {
                      activeNode = n;
                      document.getElementById('pHudBadge').textContent = n.badge;
                      document.getElementById('pHudBadge').style.color = n.color;
                      document.getElementById('pHudTitle').textContent = n.title;
                      document.getElementById('pHudClassical').textContent = n.classical;
                      document.getElementById('pHudJudgment').textContent = n.judgment;
                      document.getElementById('pHudWhole').textContent = n.whole;
                    }

                    const canvas = document.getElementById('mizanPantheonCanvas');
                    const ctx = canvas.getContext('2d');

                    canvas.addEventListener('click', (e) => {
                      const rect = canvas.getBoundingClientRect();
                      const sx = canvas.width / rect.width;
                      const sy = canvas.height / rect.height;
                      const mx = (e.clientX - rect.left) * sx;
                      const my = (e.clientY - rect.top) * sy;
                      for (const n of NODES) {
                        if (Math.hypot(mx - n.x, my - n.y) < 22 || Math.hypot(mx - n.tx, my - n.ty) < 22) {
                          selectNode(n);
                          break;
                        }
                      }
                    });

                    function renderCanvas() {
                      tick += 0.012;
                      ctx.clearRect(0, 0, canvas.width, canvas.height);

                      // Background Grid
                      ctx.strokeStyle = 'rgba(212,175,55,0.06)';
                      ctx.lineWidth = 1;
                      for (let x = 0; x < canvas.width; x += 40) {
                        ctx.beginPath(); ctx.moveTo(x, 0); ctx.lineTo(x, canvas.height); ctx.stroke();
                      }
                      for (let y = 0; y < canvas.height; y += 40) {
                        ctx.beginPath(); ctx.moveTo(0, y); ctx.lineTo(canvas.width, y); ctx.stroke();
                      }

                      // Left Column Header (Fragmented Pantheon / Titanomachy)
                      ctx.fillStyle = '#FDA4AF';
                      ctx.font = 'bold 12px monospace';
                      ctx.fillText('GRECO-ROMAN FRACTURE (SHIRK / TITANOMACHY)', 45, 36);

                      // Center Pillar: Al-Furqan & Al-Mizan Scale
                      const cx = canvas.width / 2;
                      ctx.strokeStyle = '#D4AF37';
                      ctx.lineWidth = 2.5;
                      ctx.beginPath();
                      ctx.moveTo(cx, 55);
                      ctx.lineTo(cx, 485);
                      ctx.stroke();

                      // Balance Beam at Top of Center Pillar
                      ctx.beginPath();
                      ctx.moveTo(cx - 85, 78);
                      ctx.lineTo(cx + 85, 78);
                      ctx.stroke();
                      ctx.fillStyle = '#D4AF37';
                      ctx.beginPath();
                      ctx.arc(cx, 78, 8, 0, Math.PI * 2);
                      ctx.fill();

                      ctx.fillStyle = '#FDE68A';
                      ctx.font = 'bold 12px monospace';
                      ctx.textAlign = 'center';
                      ctx.fillText('AL-FURQĀN & AL-MĪZĀN (THE CRITERION & SCALE)', cx, 36);
                      ctx.fillStyle = '#94A3B8';
                      ctx.font = '11px Segoe UI, sans-serif';
                      ctx.fillText('Judges Shirk • Purifies Archetypes • Makes Whole', cx, 52);

                      // Right Column Header (Tawhidi Wholeness / At-Takmil)
                      ctx.textAlign = 'right';
                      ctx.fillStyle = '#6EE7B7';
                      ctx.font = 'bold 12px monospace';
                      ctx.fillText('ISLAMIC WHOLENESS (TAWḤĪD / AT-TAKMĪL)', canvas.width - 45, 36);
                      ctx.textAlign = 'left';

                      // Draw transformation bridges & nodes
                      NODES.forEach((n, idx) => {
                        const vis = (currentSphere === 'all' || currentSphere === n.sphere);
                        const sel = (activeNode && activeNode.id === n.id);
                        ctx.save();
                        ctx.globalAlpha = vis ? 1.0 : 0.22;

                        // Bridge curve from Left (Fractured) -> Center Mizan -> Right (Made Whole)
                        ctx.strokeStyle = n.color;
                        ctx.lineWidth = sel ? 2.8 : 1.5;
                        ctx.beginPath();
                        ctx.moveTo(n.x, n.y);
                        ctx.quadraticCurveTo(cx, n.y + Math.sin(tick * 2 + idx) * 14, n.tx, n.ty);
                        ctx.stroke();

                        // Animated particle flowing from Left through Mizan to Right
                        if (vis) {
                          const p = (tick * 0.45 + idx * 0.15) % 1;
                          const px = (1 - p) * (1 - p) * n.x + 2 * (1 - p) * p * cx + p * p * n.tx;
                          const py = (1 - p) * (1 - p) * n.y + 2 * (1 - p) * p * (n.y) + p * p * n.ty;
                          ctx.fillStyle = p < 0.5 ? '#FDA4AF' : '#34D399';
                          ctx.shadowColor = n.color;
                          ctx.shadowBlur = 10;
                          ctx.beginPath();
                          ctx.arc(px, py, 4.5, 0, Math.PI * 2);
                          ctx.fill();
                          ctx.shadowBlur = 0;
                        }

                        // Left Node (Fractured Myth)
                        ctx.fillStyle = '#1E1B2E';
                        ctx.strokeStyle = '#F43F5E';
                        ctx.lineWidth = sel ? 3 : 2;
                        ctx.beginPath();
                        ctx.arc(n.x, n.y, 13, 0, Math.PI * 2);
                        ctx.fill();
                        ctx.stroke();

                        ctx.fillStyle = '#F8FAFC';
                        ctx.font = 'bold 11px Segoe UI, sans-serif';
                        ctx.fillText(n.badge.split('•')[1].split('→')[0].trim(), n.x + 18, n.y - 4);
                        ctx.fillStyle = '#FDA4AF';
                        ctx.font = '10px monospace';
                        ctx.fillText('[Fractured Myth]', n.x + 18, n.y + 11);

                        // Right Node (Made Whole in Islam)
                        ctx.fillStyle = '#0D2821';
                        ctx.strokeStyle = '#10B981';
                        ctx.lineWidth = sel ? 3 : 2;
                        ctx.beginPath();
                        ctx.arc(n.tx, n.ty, 14, 0, Math.PI * 2);
                        ctx.fill();
                        ctx.stroke();

                        if (sel) {
                          ctx.strokeStyle = '#FFF';
                          ctx.lineWidth = 2;
                          ctx.beginPath();
                          ctx.arc(n.tx, n.ty, 19 + Math.sin(tick * 6) * 2, 0, Math.PI * 2);
                          ctx.stroke();
                        }

                        const rightLabel = n.badge.includes('→') ? n.badge.split('→')[1].trim() : 'MADE WHOLE IN TAWḤĪD';
                        ctx.textAlign = 'right';
                        ctx.fillStyle = '#ECFDF5';
                        ctx.font = 'bold 11px Segoe UI, sans-serif';
                        ctx.fillText(rightLabel, n.tx - 20, n.ty - 4);
                        ctx.fillStyle = '#6EE7B7';
                        ctx.font = '10px monospace';
                        ctx.fillText('[Judged & Made Whole]', n.tx - 20, n.ty + 11);
                        ctx.textAlign = 'left';

                        ctx.restore();
                      });

                      requestAnimationFrame(renderCanvas);
                    }
                    renderCanvas();
                  </script>
                </body>
                </html>
                """;

        return template
                .replace("__TITAN_CARDS__", titanCardsHtml.toString())
                .replace("__TITAN_ROWS__", titanRowsHtml.toString())
                .replace("__TIER_CARDS__", tierCardsHtml.toString())
                .replace("__TIER_ROWS__", tierRowsHtml.toString())
                .replace("__ONEIROI_CARDS__", oneiroiCardsHtml.toString())
                .replace("__EROTES_CARDS__", erotesCardsHtml.toString())
                .replace("__EROTES_ROWS__", erotesRowsHtml.toString())
                .replace("__MINOR_DOMAIN_CARDS__", minorDomainCardsHtml.toString());
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
