package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.IslamThroughAgesReceptionPhilosophyAndScience;
import com.sovereign.warlock.domain.IslamThroughAgesReceptionPhilosophyAndScience.HistoricalReceptionAge;
import com.sovereign.warlock.domain.IslamThroughAgesReceptionPhilosophyAndScience.PhilosophicalConnotationParadigm;
import com.sovereign.warlock.domain.IslamThroughAgesReceptionPhilosophyAndScience.ScientificAllusionAndInstantiation;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Expansive 3-Volume Multi-HTML Generator producing Portals #61, #62, and #63:
 * 1. Portal #61 (Vol. I): {@code islam-through-ages-vol1-reception-history.html}
 *    — Islam Through the Ages & Its Global Civilizational Reception (7 Ages: 610 CE to 21st Century).
 * 2. Portal #62 (Vol. II): {@code islam-through-ages-vol2-philosophical-connotations.html}
 *    — The 7 Philosophical Connotations & Paradigms Instantiated by Islamic Thought.
 * 3. Portal #63 (Vol. III): {@code islam-through-ages-vol3-scientific-discoveries-instantiated.html}
 *    — Scientific Discoveries Alluded to in the Qur'an & Hadith (Al-Isharat Al-Kawniyyah)
 *      That Were Instantiated Through Classical & Modern Empirical Science.
 */
public final class IslamThroughAgesPhilosophyScienceMultiPortalGenerator {

    public static final String VOL1_RECEPTION_FILENAME = "islam-through-ages-vol1-reception-history.html";
    public static final String VOL2_PHILOSOPHY_FILENAME = "islam-through-ages-vol2-philosophical-connotations.html";
    public static final String VOL3_SCIENCE_FILENAME = "islam-through-ages-vol3-scientific-discoveries-instantiated.html";

    private IslamThroughAgesPhilosophyScienceMultiPortalGenerator() {
    }

    public static List<Path> generateAllThreeVolumes(Path outputDir) throws IOException {
        Files.createDirectories(outputDir);
        Path vol1 = outputDir.resolve(VOL1_RECEPTION_FILENAME);
        Path vol2 = outputDir.resolve(VOL2_PHILOSOPHY_FILENAME);
        Path vol3 = outputDir.resolve(VOL3_SCIENCE_FILENAME);

        Files.writeString(vol1, buildVol1ReceptionHtml(), StandardCharsets.UTF_8);
        Files.writeString(vol2, buildVol2PhilosophyHtml(), StandardCharsets.UTF_8);
        Files.writeString(vol3, buildVol3ScienceInstantiatedHtml(), StandardCharsets.UTF_8);

        return List.of(vol1, vol2, vol3);
    }

    private static String buildSuiteRibbon(int activeVol) {
        String c1 = (activeVol == 1) ? "suite-tab active" : "suite-tab";
        String c2 = (activeVol == 2) ? "suite-tab active" : "suite-tab";
        String c3 = (activeVol == 3) ? "suite-tab active" : "suite-tab";
        return """
                <div class="suite-ribbon">
                  <div class="suite-title">EXPANSIVE MULTI-HTML SUITE: ISLAM THROUGH THE AGES — RECEPTION, PHILOSOPHY &amp; SCIENTIFIC INSTANTIATION</div>
                  <div class="suite-tabs">
                    <a class="%s" href="%s">
                      <span class="tab-kicker">VOLUME I • PORTAL #61</span>
                      <span class="tab-label">Islam Through the Ages &amp; Global Civilizational Reception (7 Ages)</span>
                    </a>
                    <a class="%s" href="%s">
                      <span class="tab-kicker">VOLUME II • PORTAL #62</span>
                      <span class="tab-label">The 7 Philosophical Connotations &amp; Metaphysical Paradigms</span>
                    </a>
                    <a class="%s" href="%s">
                      <span class="tab-kicker">VOLUME III • PORTAL #63</span>
                      <span class="tab-label">Qur'anic &amp; Prophetic Scientific Allusions Instantiated Through Science</span>
                    </a>
                  </div>
                </div>
                """.formatted(
                c1, VOL1_RECEPTION_FILENAME,
                c2, VOL2_PHILOSOPHY_FILENAME,
                c3, VOL3_SCIENCE_FILENAME
        );
    }

    private static String sharedStyles() {
        return """
                :root {
                  --bg-deep: #060912;
                  --bg-card: #0F1626;
                  --bg-card-alt: #16213A;
                  --gold: #D4AF37;
                  --emerald: #10B981;
                  --cyan: #38BDF8;
                  --rose: #F43F5E;
                  --purple: #A855F7;
                  --text-main: #F1F5F9;
                  --text-muted: #94A3B8;
                  --border-gold: rgba(212, 175, 55, 0.28);
                }
                * { box-sizing: border-box; margin: 0; padding: 0; }
                body {
                  font-family: 'Segoe UI', system-ui, -apple-system, Georgia, serif;
                  background: radial-gradient(circle at 22% 0%, #14274A 0%, var(--bg-deep) 68%);
                  color: var(--text-main);
                  line-height: 1.72;
                  padding-bottom: 5rem;
                }
                .container {
                  max-width: 1420px;
                  margin: 0 auto;
                  padding: 1.8rem 1.5rem;
                }
                .suite-ribbon {
                  background: linear-gradient(90deg, #0C1424 0%, #172746 50%, #0C1424 100%);
                  border: 1px solid var(--gold);
                  border-radius: 14px;
                  padding: 1.15rem 1.4rem;
                  margin-bottom: 1.8rem;
                  box-shadow: 0 12px 32px rgba(0,0,0,0.45);
                }
                .suite-title {
                  font-family: 'Consolas', monospace;
                  font-size: 0.78rem;
                  font-weight: 700;
                  color: #FDE68A;
                  letter-spacing: 0.07em;
                  margin-bottom: 0.65rem;
                }
                .suite-tabs {
                  display: grid;
                  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
                  gap: 0.75rem;
                }
                .suite-tab {
                  display: flex;
                  flex-direction: column;
                  padding: 0.85rem 1.05rem;
                  border-radius: 10px;
                  background: rgba(255,255,255,0.03);
                  border: 1px solid rgba(255,255,255,0.12);
                  text-decoration: none;
                  color: var(--text-main);
                  transition: all 0.18s ease;
                }
                .suite-tab:hover, .suite-tab.active {
                  background: rgba(212, 175, 55, 0.18);
                  border-color: var(--gold);
                  box-shadow: 0 0 18px rgba(212, 175, 55, 0.24);
                }
                .tab-kicker {
                  font-family: 'Consolas', monospace;
                  font-size: 0.75rem;
                  font-weight: 700;
                  color: var(--gold);
                }
                .tab-label {
                  font-size: 0.94rem;
                  font-weight: 600;
                  color: #FFF;
                  margin-top: 0.15rem;
                }
                .hero {
                  background: linear-gradient(135deg, rgba(15, 22, 38, 0.96) 0%, rgba(56, 189, 248, 0.13) 50%, rgba(212, 175, 55, 0.16) 100%);
                  border: 1px solid var(--gold);
                  border-left: 8px solid var(--gold);
                  border-radius: 16px;
                  padding: 2.3rem;
                  margin-bottom: 2rem;
                  box-shadow: 0 20px 50px rgba(0,0,0,0.55);
                }
                .badge-row {
                  display: flex;
                  flex-wrap: wrap;
                  gap: 0.5rem;
                  margin-bottom: 0.9rem;
                }
                .badge {
                  font-family: 'Consolas', monospace;
                  font-size: 0.75rem;
                  font-weight: 700;
                  padding: 0.26rem 0.7rem;
                  border-radius: 999px;
                }
                h1 {
                  font-size: 2.18rem;
                  color: #FFF;
                  line-height: 1.24;
                  margin-bottom: 0.55rem;
                }
                .arabic-sub {
                  font-size: 1.3rem;
                  color: #FDE68A;
                  margin-bottom: 0.95rem;
                  font-weight: 600;
                }
                .epigraph-banner {
                  background: rgba(6, 9, 18, 0.85);
                  border: 1px solid var(--border-gold);
                  border-left: 4px solid var(--emerald);
                  border-radius: 10px;
                  padding: 1.1rem 1.35rem;
                  margin-top: 1.15rem;
                  font-size: 0.97rem;
                  color: #E2E8F0;
                }
                .canvas-box {
                  background: var(--bg-card);
                  border: 1px solid var(--border-gold);
                  border-radius: 14px;
                  padding: 1.45rem;
                  margin-bottom: 2rem;
                }
                .controls-row {
                  display: flex;
                  flex-wrap: wrap;
                  gap: 0.55rem;
                  margin-bottom: 0.95rem;
                  align-items: center;
                }
                .btn {
                  background: var(--bg-card-alt);
                  color: var(--text-main);
                  border: 1px solid var(--border-gold);
                  padding: 0.45rem 0.9rem;
                  border-radius: 8px;
                  cursor: pointer;
                  font-size: 0.82rem;
                  font-weight: 600;
                }
                .btn:hover, .btn.active {
                  background: rgba(212, 175, 55, 0.24);
                  border-color: var(--gold);
                  color: #FFF;
                }
                canvas {
                  width: 100%;
                  height: 420px;
                  background: #050811;
                  border-radius: 10px;
                  border: 1px solid rgba(255,255,255,0.08);
                  display: block;
                }
                .section-heading {
                  font-size: 1.56rem;
                  color: var(--gold);
                  margin: 2.3rem 0 0.6rem 0;
                  border-bottom: 2px solid var(--border-gold);
                  padding-bottom: 0.45rem;
                  display: flex;
                  justify-content: space-between;
                  align-items: center;
                  flex-wrap: wrap;
                }
                .card {
                  background: var(--bg-card);
                  border: 1px solid rgba(255,255,255,0.1);
                  border-radius: 13px;
                  padding: 1.65rem;
                  margin-bottom: 1.4rem;
                  box-shadow: 0 10px 28px rgba(0,0,0,0.35);
                }
                .card-top {
                  display: flex;
                  justify-content: space-between;
                  align-items: center;
                  flex-wrap: wrap;
                  gap: 0.5rem;
                  margin-bottom: 0.7rem;
                }
                .era-tag {
                  font-family: 'Consolas', monospace;
                  font-size: 0.78rem;
                  color: #A5F3FC;
                  background: rgba(56, 189, 248, 0.12);
                  padding: 0.22rem 0.65rem;
                  border-radius: 6px;
                }
                .card h3 {
                  font-size: 1.3rem;
                  color: #FFF;
                  margin-bottom: 0.7rem;
                }
                .scripture-box {
                  background: rgba(212, 175, 55, 0.08);
                  border-left: 3px solid var(--gold);
                  padding: 0.75rem 1rem;
                  border-radius: 0 8px 8px 0;
                  margin-bottom: 0.85rem;
                  color: #FDE68A;
                  font-size: 0.94rem;
                }
                .grid-2 {
                  display: grid;
                  grid-template-columns: repeat(auto-fit, minmax(330px, 1fr));
                  gap: 1.15rem;
                  margin-top: 0.8rem;
                }
                .sub-panel {
                  background: rgba(255,255,255,0.03);
                  border: 1px solid rgba(255,255,255,0.08);
                  border-radius: 10px;
                  padding: 1.05rem;
                }
                .sub-panel h4 {
                  color: #34D399;
                  font-size: 0.97rem;
                  margin-bottom: 0.45rem;
                }
                .artifact-footer {
                  margin-top: 0.85rem;
                  padding-top: 0.65rem;
                  border-top: 1px dashed rgba(255,255,255,0.14);
                  font-size: 0.9rem;
                  color: #93C5FD;
                }
                """;
    }

    private static String buildVol1ReceptionHtml() {
        StringBuilder agesHtml = new StringBuilder();
        for (HistoricalReceptionAge a : IslamThroughAgesReceptionPhilosophyAndScience.allSevenHistoricalReceptionAges()) {
            agesHtml.append("""
                    <div class="card" style="border-left: 5px solid %s;">
                      <div class="card-top">
                        <span class="badge" style="background:%s22;color:%s;border:1px solid %s66;">AGE #%d OF 7 • %s</span>
                        <span class="era-tag">%s</span>
                      </div>
                      <h3>%s</h3>
                      <div class="scripture-box"><strong>Primary Qur'anic &amp; Canonical Anchors:</strong> %s</div>
                      <div class="grid-2">
                        <div class="sub-panel">
                          <h4>✦ Internal Islamic Evolution &amp; Institutions</h4>
                          <p>%s</p>
                        </div>
                        <div class="sub-panel">
                          <h4 style="color:#FDE68A;">🌍 Cross-Civilizational Reception &amp; Interlocutors</h4>
                          <p>%s</p>
                        </div>
                      </div>
                      <div class="artifact-footer"><strong>Enduring Intellectual Artifacts &amp; Texts:</strong> %s</div>
                    </div>
                    """.formatted(
                    a.hexColor(),
                    a.hexColor(), a.hexColor(), a.hexColor(),
                    a.ageIndex(), escapeHtml(a.ageCode()),
                    escapeHtml(a.chronologicalSpanAndCenters()),
                    escapeHtml(a.titleAndCivilizationalScope()),
                    escapeHtml(a.primaryQuranicAndCanonicalAnchors()),
                    escapeHtml(a.internalIslamicEvolution()),
                    escapeHtml(a.crossCivilizationalReceptionAndInterlocutors()),
                    escapeHtml(a.enduringIntellectualArtifacts())
            ));
        }

        String template = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <title>Vol. I (#61): Islam Through the Ages &amp; Global Civilizational Reception | Multi-HTML Suite</title>
                  <style>__STYLES__</style>
                </head>
                <body>
                  <div class="container">
                    __RIBBON__
                    <section class="hero">
                      <div class="badge-row">
                        <span class="badge" style="background:rgba(212,175,55,0.2);color:#FDE68A;border:1px solid #D4AF37;">PORTAL #61 • VOLUME I OF III</span>
                        <span class="badge" style="background:rgba(16,185,129,0.2);color:#6EE7B7;border:1px solid #10B981;">7 AGES OF ISLAM &amp; CROSS-CIVILIZATIONAL RECEPTION</span>
                        <span class="badge" style="background:rgba(56,189,248,0.2);color:#7DD3FC;border:1px solid #38BDF8;">AKSUM • BAGHDAD • TOLEDO • MARAGHEH • OXFORD • WEIMAR • MODERN LABS</span>
                      </div>
                      <h1>Volume I: Islam Through the Ages &amp; Its Reception Across World Civilizations (610 CE – 21st Century)</h1>
                      <div class="arabic-sub">المُجَلَّدُ الأَوَّلُ: الإِسْلَامُ عَبْرَ العُصُورِ وَالتَّلَقِّي الحَضَارِيُّ العَالَمِيُّ فِي الشرقِ وَالغَرْبِ</div>
                      <p style="color:#CBD5E1;font-size:1.03rem;">
                        How did Islam unfold across fourteen centuries, and how was its spiritual, philosophical, and scientific light
                        received by Abyssinian Christians, Syriac/Jewish scholars, Indian and Persian astronomers, medieval Latin Scholasticism
                        (Aquinas, Roger Bacon, Dante), Renaissance astronomers (Copernicus), Enlightenment thinkers (Locke, Leibniz, Goethe, Jefferson),
                        and the modern global academy? This first volume traces all <strong>7 Ages of Islamic Reception</strong>.
                      </p>
                      <div class="epigraph-banner">
                        <strong>The Canonical Ethic of Open Intellectual Reception (Qur'an 39:18 &amp; 2:269):</strong><br>
                        <em>«الَّذِينَ يَسْتَمِعُونَ الْقَوْلَ فَيَتَّبِعُونَ أَحْسَنَهُ ۚ أُولَٰئِكَ الَّذِينَ هَدَاهُمُ اللَّهُ وَأُولَٰئِكَ هُمْ أُولُو الْأَلْبَابِ»</em> —
                        "Those who listen to speech and follow the best of it—those are the ones Allah has guided, and those are people of understanding."
                      </div>
                    </section>

                    <div class="canvas-box">
                      <h2 style="color:var(--gold);margin-bottom:0.35rem;">Interactive Cross-Civilizational Reception &amp; Knowledge Transmission Bridge (7 Ages)</h2>
                      <p style="color:var(--text-muted);font-size:0.9rem;margin-bottom:0.85rem;">
                        Select any of the 7 Historical Ages to inspect how Islamic centers of learning received, transformed, and transmitted knowledge across Africa, Asia, Europe, and the Americas.
                      </p>
                      <div class="controls-row">
                        <button class="btn active" onclick="setAge(0, this)">All 7 Ages</button>
                        <button class="btn" onclick="setAge(1, this)">Age I: Late Antiquity (610–750)</button>
                        <button class="btn" onclick="setAge(2, this)">Age II: Baghdad/Córdoba Synthesis (750–1050)</button>
                        <button class="btn" onclick="setAge(3, this)">Age III: Latin Scholastic Reception (1050–1350)</button>
                        <button class="btn" onclick="setAge(4, this)">Age IV: Ming China &amp; Copernicus (1250–1600)</button>
                        <button class="btn" onclick="setAge(5, this)">Age V: Locke, Goethe &amp; Jefferson (1600–1850)</button>
                        <button class="btn" onclick="setAge(6, this)">Age VI: Iqbāl, Izutsu &amp; Malcolm X (1850–1970)</button>
                        <button class="btn" onclick="setAge(7, this)">Age VII: Nobel &amp; Digital Era (1970–Present)</button>
                      </div>
                      <canvas id="receptionCanvas" width="1340" height="420"></canvas>
                    </div>

                    <div class="section-heading">
                      <span>The 7 Ages of Islam &amp; Its Global Civilizational Reception</span>
                      <a class="btn" href="__VOL2_FILE__" style="text-decoration:none;">Proceed to Volume II: Philosophical Connotations →</a>
                    </div>
                    <div>
                      __AGES_HTML__
                    </div>
                  </div>
                  <script>
                    let selectedAge = 0;
                    function setAge(idx, btn) {
                      selectedAge = idx;
                      document.querySelectorAll('.controls-row .btn').forEach(b => b.classList.remove('active'));
                      if (btn) btn.classList.add('active');
                      drawReceptionCanvas();
                    }
                    function drawReceptionCanvas() {
                      const c = document.getElementById('receptionCanvas');
                      if (!c) return;
                      const ctx = c.getContext('2d');
                      const W = c.width, H = c.height;
                      ctx.clearRect(0, 0, W, H);

                      const ages = [
                        { id: 1, x: 105, y: 205, title: 'Age I (610–750)', hub: 'Mecca, Medina, Jerusalem', rec: 'Aksum (Negus), Syriac & Jewish Covenants', color: '#10B981' },
                        { id: 2, x: 290, y: 120, title: 'Age II (750–1050)', hub: 'Baghdad, Córdoba, Bukhara', rec: 'Greek, Sanskrit & Persian Texts Synthesized', color: '#D4AF37' },
                        { id: 3, x: 475, y: 280, title: 'Age III (1050–1350)', hub: 'Toledo, Palermo, Salerno', rec: 'Aquinas, Roger Bacon, Dante, Fibonacci', color: '#38BDF8' },
                        { id: 4, x: 660, y: 125, title: 'Age IV (1250–1600)', hub: 'Maragheh, Samarkand, Malacca', rec: 'Mongol Embrace, Zheng He, Copernicus (1543)', color: '#A855F7' },
                        { id: 5, x: 845, y: 275, title: 'Age V (1600–1850)', hub: 'Isfahan, Istanbul, Oxford', rec: 'Ḥayy ibn Yaqẓān → Locke, Goethe, Jefferson', color: '#F43F5E' },
                        { id: 6, x: 1030, y: 135, title: 'Age VI (1850–1970)', hub: 'Cairo, Lahore, Tokyo', rec: 'Iqbāl, Massignon, Izutsu, Asad, Malcolm X', color: '#F59E0B' },
                        { id: 7, x: 1215, y: 215, title: 'Age VII (1970–Now)', hub: 'Global Universities & Labs', rec: 'Salam, Zewail, Sancar, Bawendi & Sezgin', color: '#22D3EE' }
                      ];

                      ctx.strokeStyle = 'rgba(212,175,55,0.28)';
                      ctx.lineWidth = 3;
                      ctx.beginPath();
                      ages.forEach((a, i) => {
                        if (i === 0) ctx.moveTo(a.x, a.y);
                        else ctx.lineTo(a.x, a.y);
                      });
                      ctx.stroke();

                      ages.forEach(a => {
                        const active = (selectedAge === 0 || selectedAge === a.id);
                        ctx.save();
                        ctx.globalAlpha = active ? 1.0 : 0.22;
                        ctx.fillStyle = 'rgba(15, 22, 38, 0.95)';
                        ctx.strokeStyle = a.color;
                        ctx.lineWidth = (selectedAge === a.id) ? 3.5 : 2;
                        ctx.beginPath();
                        ctx.roundRect(a.x - 82, a.y - 52, 168, 105, 10);
                        ctx.fill(); ctx.stroke();

                        ctx.fillStyle = a.color;
                        ctx.font = 'bold 12px Segoe UI, sans-serif';
                        ctx.fillText(a.title, a.x - 70, a.y - 28);
                        ctx.fillStyle = '#FDE68A';
                        ctx.font = '10px Consolas, monospace';
                        ctx.fillText(a.hub, a.x - 70, a.y - 6);
                        ctx.fillStyle = '#E2E8F0';
                        ctx.font = '10px Segoe UI, sans-serif';
                        ctx.fillText(a.rec.substring(0, 26), a.x - 70, a.y + 18);
                        ctx.fillText(a.rec.substring(26), a.x - 70, a.y + 34);
                        ctx.restore();
                      });
                    }
                    window.addEventListener('DOMContentLoaded', drawReceptionCanvas);
                  </script>
                </body>
                </html>
                """;

        return template
                .replace("__STYLES__", sharedStyles())
                .replace("__RIBBON__", buildSuiteRibbon(1))
                .replace("__VOL2_FILE__", VOL2_PHILOSOPHY_FILENAME)
                .replace("__AGES_HTML__", agesHtml.toString());
    }

    private static String buildVol2PhilosophyHtml() {
        StringBuilder paradigmsHtml = new StringBuilder();
        for (PhilosophicalConnotationParadigm p : IslamThroughAgesReceptionPhilosophyAndScience.allSevenPhilosophicalConnotationParadigms()) {
            paradigmsHtml.append("""
                    <div class="card" style="border-left: 5px solid %s;">
                      <div class="card-top">
                        <span class="badge" style="background:%s22;color:%s;border:1px solid %s66;">PARADIGM #%d OF 7 • %s</span>
                        <span class="era-tag">FALSAFAH • KALĀM • ḤIKMAH • 'UMRĀN</span>
                      </div>
                      <h3>%s</h3>
                      <p style="margin-bottom:0.65rem;color:#CBD5E1;"><strong>Chief Philosophers &amp; Canonical Treatises:</strong> %s</p>
                      <div class="scripture-box"><strong>Qur'anic Ontological &amp; Epistemic Root:</strong> %s</div>
                      <div class="grid-2">
                        <div class="sub-panel">
                          <h4>✦ Formal Philosophical Formulation</h4>
                          <p>%s</p>
                        </div>
                        <div class="sub-panel">
                          <h4 style="color:#FDE68A;">🏛 Reception by Western &amp; Global Philosophy</h4>
                          <p>%s</p>
                        </div>
                      </div>
                      <div class="artifact-footer"><strong>Contemporary Philosophical &amp; Scientific Significance:</strong> %s</div>
                    </div>
                    """.formatted(
                    p.hexColor(),
                    p.hexColor(), p.hexColor(), p.hexColor(),
                    p.paradigmIndex(), escapeHtml(p.paradigmCode()),
                    escapeHtml(p.arabicAndEnglishTitle()),
                    escapeHtml(p.chiefPhilosophersAndTreatises()),
                    escapeHtml(p.quranicOntologicalAndEpistemicRoot()),
                    escapeHtml(p.formalPhilosophicalFormulation()),
                    escapeHtml(p.receptionByWesternAndGlobalPhilosophy()),
                    escapeHtml(p.contemporaryPhilosophicalSignificance())
            ));
        }

        String template = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <title>Vol. II (#62): The Philosophical Connotations of Islam Through the Ages | Multi-HTML Suite</title>
                  <style>__STYLES__</style>
                </head>
                <body>
                  <div class="container">
                    __RIBBON__
                    <section class="hero">
                      <div class="badge-row">
                        <span class="badge" style="background:rgba(212,175,55,0.2);color:#FDE68A;border:1px solid #D4AF37;">PORTAL #62 • VOLUME II OF III</span>
                        <span class="badge" style="background:rgba(16,185,129,0.2);color:#6EE7B7;border:1px solid #10B981;">7 PHILOSOPHICAL CONNOTATIONS &amp; PARADIGMS</span>
                        <span class="badge" style="background:rgba(168,85,247,0.2);color:#E9D5FF;border:1px solid #A855F7;">IBN SĪNĀ • AL-GHAZĀLĪ • IBN RUSHD • IBN AL-HAYTHAM • MULLĀ ṢADRĀ • IBN KHALDŪN</span>
                      </div>
                      <h1>Volume II: The Philosophical Connotations of Islam Through the Ages — Ontology, Epistemology, Causality &amp; Space-Time</h1>
                      <div class="arabic-sub">المُجَلَّدُ الثَّانِي: الدَّلَالَاتُ الفَلْسَفِيَّةُ وَالمَعْرِفِيَّةُ فِي الحَضَارَةِ الإِسْلَامِيَّةِ وَأَثَرُهَا الكَوْنِيُّ</div>
                      <p style="color:#CBD5E1;font-size:1.03rem;">
                        Far from being mere "transmitters" of Greek antiquity, Muslim philosophers, theologians (<em>Mutakallimūn</em>), and
                        philosopher-scientists originated <strong>seven revolutionary philosophical paradigms</strong>—from Ibn Sīnā's Modal Ontology
                        (<em>Wājib Al-Wujūd</em>) and Floating Man thought experiment (600 years before Descartes), to Al-Ghazālī's critique of blind causal
                        necessity (650 years before Hume), Ibn Rushd's harmony of demonstrative reason and revelation, Ibn Al-Haytham's experimental
                        empiricism (<em>Al-I'tibār</em>), Mullā Ṣadrā's substantial motion (4D space-time flux), and Ibn Khaldūn's empirical sociology (<em>'Ilm Al-'Umrān</em>).
                      </p>
                      <div class="epigraph-banner">
                        <strong>Ibn Rushd's Canonical Theorem of Unified Truth (Faṣl Al-Maqāl &amp; Qur'an 59:2):</strong><br>
                        <em>«فَإِنَّ الْحَقَّ لَا يُضَادُّ الْحَقَّ بَلْ يُوَافِقُهُ وَيَشْهَدُ لَهُ»</em> —
                        "For truth does not contradict truth; rather, it agrees with it and bears witness to it."
                      </div>
                    </section>

                    <div class="canvas-box">
                      <h2 style="color:var(--gold);margin-bottom:0.35rem;">Interactive East-to-West Philosophical Genealogy &amp; Connotation Map</h2>
                      <p style="color:var(--text-muted);font-size:0.9rem;margin-bottom:0.85rem;">
                        Visualize how Qur'anic ontological verses catalyzed the 7 Islamic Philosophical Paradigms and how each shaped medieval and modern Western philosophy.
                      </p>
                      <canvas id="philCanvas" width="1340" height="420"></canvas>
                    </div>

                    <div class="section-heading">
                      <span>The 7 Foundational Philosophical Connotations of Islam</span>
                      <a class="btn" href="__VOL3_FILE__" style="text-decoration:none;">Proceed to Volume III: Scientific Discoveries Instantiated →</a>
                    </div>
                    <div>
                      __PARADIGMS_HTML__
                    </div>
                  </div>
                  <script>
                    function drawPhilCanvas() {
                      const c = document.getElementById('philCanvas');
                      if (!c) return;
                      const ctx = c.getContext('2d');
                      const W = c.width, H = c.height;
                      ctx.clearRect(0, 0, W, H);

                      const rows = [
                        { q: 'Qur\\'an 28:88 & 112:2', isl: '1. Ibn Sīnā: Wājib vs. Mumkin Al-Wujūd', west: 'Aquinas (3rd Way), Maimonides, Leibniz', color: '#10B981', y: 42 },
                        { q: 'Qur\\'an 15:29 & 17:85', isl: '2. Ibn Sīnā: The Floating Man (Self-Awareness)', west: 'Descartes (Cogito, 600 yrs later), Husserl', color: '#D4AF37', y: 96 },
                        { q: 'Qur\\'an 35:43 (Sunnat Allāh)', isl: '3. Al-Ghazālī: Critique of Necessary Causation', west: 'Malebranche, Hume (Constant Conjunction), Quantum Law', color: '#38BDF8', y: 150 },
                        { q: 'Qur\\'an 59:2 & 3:190', isl: '4. Ibn Rushd & Ibn Ṭufayl: Reason = Revelation', west: 'Latin Averroism, John Locke (Tabula Rasa)', color: '#A855F7', y: 204 },
                        { q: 'Qur\\'an 17:36 & 2:111', isl: '5. Ibn Al-Haytham: Al-I\\'tibār & Ash-Shukūk', west: 'Roger Bacon, Kepler, Galileo (Scientific Method)', color: '#F43F5E', y: 258 },
                        { q: 'Qur\\'an 27:88 & 50:15', isl: '6. Mullā Ṣadrā: Substantial Motion (4D Time)', west: 'Bergson, Whitehead (Process), Relativistic Space-Time', color: '#F59E0B', y: 312 },
                        { q: 'Qur\\'an 13:11 & 21:107', isl: '7. Ibn Khaldūn & Shāṭibī: \\'Umrān & Maqāṣid', west: 'Modern Sociology, Laffer Curve, Bioethics', color: '#22D3EE', y: 366 }
                      ];

                      rows.forEach(r => {
                        // Left box: Qur'anic Root
                        ctx.fillStyle = 'rgba(16, 185, 129, 0.12)';
                        ctx.strokeStyle = r.color;
                        ctx.lineWidth = 1.6;
                        ctx.beginPath(); ctx.roundRect(35, r.y - 16, 260, 40, 8); ctx.fill(); ctx.stroke();
                        ctx.fillStyle = '#FDE68A';
                        ctx.font = 'bold 11px Consolas, monospace';
                        ctx.fillText(r.q, 50, r.y + 8);

                        // Arrow 1
                        ctx.strokeStyle = r.color;
                        ctx.beginPath(); ctx.moveTo(295, r.y + 4); ctx.lineTo(355, r.y + 4); ctx.stroke();

                        // Center box: Islamic Philosophical Paradigm
                        ctx.fillStyle = 'rgba(15, 22, 38, 0.95)';
                        ctx.beginPath(); ctx.roundRect(355, r.y - 16, 450, 40, 8); ctx.fill(); ctx.stroke();
                        ctx.fillStyle = r.color;
                        ctx.font = 'bold 12px Segoe UI, sans-serif';
                        ctx.fillText(r.isl, 372, r.y + 8);

                        // Arrow 2
                        ctx.beginPath(); ctx.moveTo(805, r.y + 4); ctx.lineTo(865, r.y + 4); ctx.stroke();

                        // Right box: Global Reception
                        ctx.fillStyle = 'rgba(56, 189, 248, 0.1)';
                        ctx.beginPath(); ctx.roundRect(865, r.y - 16, 440, 40, 8); ctx.fill(); ctx.stroke();
                        ctx.fillStyle = '#E2E8F0';
                        ctx.font = '11px Segoe UI, sans-serif';
                        ctx.fillText('→ ' + r.west, 882, r.y + 8);
                      });
                    }
                    window.addEventListener('DOMContentLoaded', drawPhilCanvas);
                  </script>
                </body>
                </html>
                """;

        return template
                .replace("__STYLES__", sharedStyles())
                .replace("__RIBBON__", buildSuiteRibbon(2))
                .replace("__VOL3_FILE__", VOL3_SCIENCE_FILENAME)
                .replace("__PARADIGMS_HTML__", paradigmsHtml.toString());
    }

    private static String buildVol3ScienceInstantiatedHtml() {
        StringBuilder scienceHtml = new StringBuilder();
        for (ScientificAllusionAndInstantiation s : IslamThroughAgesReceptionPhilosophyAndScience.allSevenScientificAllusionsAndInstantiations()) {
            scienceHtml.append("""
                    <div class="card" style="border-left: 5px solid %s;">
                      <div class="card-top">
                        <span class="badge" style="background:%s22;color:%s;border:1px solid %s66;">SCIENTIFIC DOMAIN #%d OF 7 • %s</span>
                        <span class="era-tag">AL-ĀYĀT AL-KAWNIYYAH → SCIENTIFIC INSTANTIATION</span>
                      </div>
                      <h3>%s</h3>
                      <div class="scripture-box"><strong>Qur'anic &amp; Prophetic Allusions (Āyāt &amp; Hadith):</strong> %s</div>
                      <p style="margin-bottom:0.8rem;color:#E2E8F0;"><strong>Philological &amp; Exegetical Precision:</strong> %s</p>
                      <div class="grid-2">
                        <div class="sub-panel">
                          <h4>🔬 Classical Islamic Scientific Instantiation (8th–16th c.)</h4>
                          <p>%s</p>
                        </div>
                        <div class="sub-panel">
                          <h4 style="color:#FDE68A;">🔭 Modern Empirical Verification &amp; Synthesis (19th–21st c.)</h4>
                          <p>%s</p>
                        </div>
                      </div>
                      <div class="artifact-footer"><strong>Signature Scientific Instruments, Manuscripts &amp; Treatises:</strong> %s</div>
                    </div>
                    """.formatted(
                    s.hexColor(),
                    s.hexColor(), s.hexColor(), s.hexColor(),
                    s.domainIndex(), escapeHtml(s.domainCode()),
                    escapeHtml(s.scientificDisciplineAndTitle()),
                    escapeHtml(s.quranicAndPropheticAllusions()),
                    escapeHtml(s.philologicalAndExegeticalPrecision()),
                    escapeHtml(s.classicalIslamicScientificInstantiation()),
                    escapeHtml(s.modernEmpiricalVerificationAndSynthesis()),
                    escapeHtml(s.signatureInstrumentsAndTreatises())
            ));
        }

        String template = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <title>Vol. III (#63): Qur'anic Scientific Allusions Instantiated Through Science | Multi-HTML Suite</title>
                  <style>__STYLES__</style>
                </head>
                <body>
                  <div class="container">
                    __RIBBON__
                    <section class="hero">
                      <div class="badge-row">
                        <span class="badge" style="background:rgba(212,175,55,0.2);color:#FDE68A;border:1px solid #D4AF37;">PORTAL #63 • VOLUME III OF III</span>
                        <span class="badge" style="background:rgba(16,185,129,0.2);color:#6EE7B7;border:1px solid #10B981;">7 SCIENTIFIC DOMAINS OF KAWNĪ ĀYĀT &amp; EMPIRICAL INSTANTIATION</span>
                        <span class="badge" style="background:rgba(56,189,248,0.2);color:#7DD3FC;border:1px solid #38BDF8;">COSMOLOGY • OPTICS • EMBRYOLOGY • MEDICINE • OCEANOGRAPHY • ALGORITHMS • SUPERNOVA IRON (Z=26)</span>
                      </div>
                      <h1>Volume III: Scientific Discoveries Alluded to in the Qur'an &amp; Hadith That Were Instantiated Through Science</h1>
                      <div class="arabic-sub">المُجَلَّدُ الثَّالِثُ: الإِشَارَاتُ الكَوْنِيَّةُ وَالعِلْمِيَّةُ فِي القُرْآنِ وَالسُّنَّةِ وَتَحْقِيقُهَا التَّجْرِيبِيُّ عبر التَّارِيخِ</div>
                      <p style="color:#CBD5E1;font-size:1.03rem;">
                        The Qur'an contains over <strong>750 verses (<em>Āyāt Kawnīyah</em>)</strong> pointing human reason to investigate the physical cosmos—from
                        primordial cosmic expansion (<strong>51:47, 21:30, 41:11</strong>) and the physics of light (<strong>10:5, 24:35, 24:40</strong>), to staged human
                        embryology (<strong>23:12–14, 76:2</strong>), the hydrological cycle and deep ocean internal waves/barriers (<strong>23:18, 24:40, 55:19–20</strong>),
                        mountain roots (<strong>78:7</strong>), mathematical measure (<strong>54:49</strong>), and iron "sent down" from the sky (<strong>Surah Al-Ḥadīd 57:25</strong>).
                        This volume demonstrates how these allusions first <strong>instantiated the experimental scientific method in classical Islamic civilization</strong>
                        and were subsequently <strong>verified by modern empirical science</strong>.
                      </p>
                      <div class="epigraph-banner">
                        <strong>The Qur'anic Mandate of Empirical Discovery (Qur'an 21:30, 51:47 &amp; 57:25):</strong><br>
                        <em>«أَوَلَمْ يَرَ الَّذِينَ كَفَرُوا أَنَّ السَّمَاوَاتِ وَالْأَرْضَ كَانَتَا رَتْقًا فَفَتَقْنَاهُمَا ۖ وَجَعَلْنَا مِنَ الْمَاءِ كُلَّ شَيْءٍ حَيٍّ»</em> —
                        "Have those who disbelieved not considered that the heavens and the earth were a joined entity (<em>Ratqan</em>), and We separated them (<em>Fa-fataqnāhumā</em>), and We made from water every living thing?" (21:30) |
                        <em>«وَالسَّمَاءَ بَنَيْنَاهَا بِأَيْدٍ وَإِنَّا لَمُوسِعُونَ»</em> — "And the heaven We constructed with strength, and indeed We are expanding it." (51:47)
                      </div>
                    </section>

                    <div class="canvas-box">
                      <h2 style="color:var(--gold);margin-bottom:0.35rem;">Interactive Scientific Instantiation Laboratory: 7 Domains of Qur'anic Āyāt &amp; Empirical Physics</h2>
                      <p style="color:var(--text-muted);font-size:0.9rem;margin-bottom:0.85rem;">
                        Click any scientific domain below to inspect its interactive diagram comparing the Qur'anic allusion, the classical Islamic laboratory breakthrough, and modern empirical physics.
                      </p>
                      <div class="controls-row">
                        <button class="btn active" onclick="setSciMode(1, this)">1. Cosmology (21:30, 51:47)</button>
                        <button class="btn" onclick="setSciMode(2, this)">2. Optics &amp; Camera Obscura (24:35)</button>
                        <button class="btn" onclick="setSciMode(3, this)">3. Embryology (23:12–14, 76:2)</button>
                        <button class="btn" onclick="setSciMode(4, this)">4. Pulmonary Circulation (Ibn Al-Nafīs)</button>
                        <button class="btn" onclick="setSciMode(5, this)">5. Ocean Barzakh &amp; Mountain Awtād (55:19, 78:7)</button>
                        <button class="btn" onclick="setSciMode(6, this)">6. Algebra, Algorithms &amp; Crypto (54:49)</button>
                        <button class="btn" onclick="setSciMode(7, this)">7. Supernova Iron Z=26 (Surah 57:25)</button>
                      </div>
                      <canvas id="sciCanvas" width="1340" height="420"></canvas>
                    </div>

                    <div class="section-heading">
                      <span>The 7 Domains of Qur'anic &amp; Prophetic Scientific Allusions Instantiated Through Science</span>
                      <a class="btn" href="__VOL1_FILE__" style="text-decoration:none;">← Return to Volume I: Islam Through the Ages</a>
                    </div>
                    <div>
                      __SCIENCE_HTML__
                    </div>
                  </div>
                  <script>
                    let sciMode = 1;
                    function setSciMode(m, btn) {
                      sciMode = m;
                      document.querySelectorAll('.controls-row .btn').forEach(b => b.classList.remove('active'));
                      if (btn) btn.classList.add('active');
                      drawSciCanvas();
                    }
                    function drawSciCanvas() {
                      const c = document.getElementById('sciCanvas');
                      if (!c) return;
                      const ctx = c.getContext('2d');
                      const W = c.width, H = c.height;
                      ctx.clearRect(0, 0, W, H);

                      // Header banner inside canvas
                      const headers = {
                        1: 'DOMAIN 1: COSMOLOGY — Ratq/Fatq (21:30), Dukhān (41:11) & Expanding Cosmos (51:47) → Al-Ṣūfī (964 CE) & Hubble Expansion',
                        2: 'DOMAIN 2: OPTICS — Ḍiyā\\' vs. Nūr (10:5) & Light Verse (24:35) → Ibn Sahl Refraction Law (984 CE) & Ibn Al-Haytham Camera Obscura',
                        3: 'DOMAIN 3: EMBRYOLOGY — Nuṭfah Amshāj (76:2), \\'Alaqah & Muḍghah (23:12–14) → Ibn Al-Quff / Ibn Al-Nafīs & Modern Staged Organogenesis',
                        4: 'DOMAIN 4: MEDICINE — "Every Disease Has a Cure" (Bukhari 5678) → Al-Rāzī Clinical Trial, Al-Zahrāwī Surgery & Ibn Al-Nafīs Pulmonary Circulation (1242 CE)',
                        5: 'DOMAIN 5: EARTH & OCEANS — Halocline Barzakh (55:19–20), Internal Waves (24:40) & Mountain Awtād Roots (78:7) → Al-Karajī & Isostasy',
                        6: 'DOMAIN 6: MATHEMATICS & CYBERNETICS — Exact Measure (54:49) & Farā\\'iḍ (4:7–12) → Al-Khwārizmī Algebra/Algorithms, Al-Kindī Crypto & Al-Jazarī Automata',
                        7: 'DOMAIN 7: METALLURGY & ASTROPHYSICS — Surah Al-Ḥadīd (Chapter 57, Verse 25): "We Sent Down Iron" → Abjad Ḥadīd = 26 = Atomic Number Fe (Supernova Nucleosynthesis)'
                      };

                      ctx.fillStyle = '#FDE68A';
                      ctx.font = 'bold 14px Segoe UI, sans-serif';
                      ctx.fillText(headers[sciMode], 45, 38);

                      if (sciMode === 1) {
                        //Expanding cone of universe from Ratq to Galaxies
                        ctx.strokeStyle = '#10B981';
                        ctx.lineWidth = 2.5;
                        ctx.beginPath();
                        ctx.moveTo(90, 220);
                        ctx.quadraticCurveTo(450, 70, 1220, 55);
                        ctx.moveTo(90, 220);
                        ctx.quadraticCurveTo(450, 370, 1220, 385);
                        ctx.stroke();

                        const stages = [
                          { x: 110, r: 16, label: '1. Ratq (21:30)', sub: 'Primordial Singularity', color: '#F43F5E' },
                          { x: 320, r: 45, label: '2. Fatq & Dukhān (41:11)', sub: 'Hot Opaque Cosmic Plasma', color: '#F59E0B' },
                          { x: 650, r: 85, label: '3. Al-Ṣūfī (964 CE) & Al-Ṭūsī', sub: 'Andromeda Galaxy & Ṭūsī Couple', color: '#38BDF8' },
                          { x: 1050, r: 125, label: '4. Wa Innā la-Mūsi\\'ūn (51:47)', sub: 'Hubble Metric Expansion (v = H₀d)', color: '#10B981' }
                        ];
                        stages.forEach(s => {
                          ctx.strokeStyle = s.color;
                          ctx.beginPath();
                          ctx.ellipse(s.x, 220, 26, s.r, 0, 0, Math.PI * 2);
                          ctx.stroke();
                          ctx.fillStyle = '#FFF';
                          ctx.font = 'bold 12px Segoe UI, sans-serif';
                          ctx.fillText(s.label, s.x - 65, 220 - s.r - 12);
                          ctx.fillStyle = '#94A3B8';
                          ctx.font = '11px Consolas, monospace';
                          ctx.fillText(s.sub, s.x - 65, 220 + s.r + 18);
                        });
                      } else if (sciMode === 2) {
                        // Camera Obscura & Ibn Sahl Refraction
                        ctx.strokeStyle = '#D4AF37';
                        ctx.lineWidth = 2;
                        ctx.strokeRect(480, 90, 420, 260);
                        ctx.fillStyle = '#FDE68A';
                        ctx.fillText('Ibn Al-Haytham\\'s Al-Bayt Al-Muẓlim (Camera Obscura, 1021 CE)', 505, 118);

                        // Candle / Object on left
                        ctx.fillStyle = '#10B981';
                        ctx.fillRect(180, 140, 24, 150);
                        ctx.fillStyle = '#F43F5E';
                        ctx.beginPath(); ctx.arc(192, 125, 16, 0, Math.PI * 2); ctx.fill();
                        ctx.fillStyle = '#FFF';
                        ctx.fillText('Illuminated Object', 140, 320);

                        // Pinhole rays crossing straight
                        ctx.strokeStyle = '#38BDF8';
                        ctx.beginPath();
                        ctx.moveTo(192, 125); ctx.lineTo(880, 310);
                        ctx.moveTo(192, 290); ctx.lineTo(880, 145);
                        ctx.stroke();
                        ctx.fillStyle = '#A5F3FC';
                        ctx.fillText('Pinhole Aperture + Ibn Sahl Law: sin(θ₁)/sin(θ₂) = n₂/n₁ (984 CE)', 495, 378);
                      } else {
                        // Universal 3-column Scientific Instantiation Matrix for modes 3..7
                        const boxes = [
                          { title: 'I. QUR\\'ANIC / HADITH ALLUSION', desc: 'Revealed Āyah & Arabic Root Precision (610–632 CE)', x: 65, color: '#10B981' },
                          { title: 'II. CLASSICAL ISLAMIC LAB SCIENCE', desc: 'Experimental I\\'tibār, Instruments & Codices (800–1500 CE)', x: 495, color: '#D4AF37' },
                          { title: 'III. MODERN EMPIRICAL VERIFICATION', desc: 'Microscopy, Tomography, Astrophysics & Computing', x: 925, color: '#38BDF8' }
                        ];
                        boxes.forEach((b, i) => {
                          ctx.fillStyle = 'rgba(15, 22, 38, 0.95)';
                          ctx.strokeStyle = b.color;
                          ctx.lineWidth = 2.5;
                          ctx.beginPath();
                          ctx.roundRect(b.x, 110, 355, 230, 12);
                          ctx.fill(); ctx.stroke();
                          ctx.fillStyle = b.color;
                          ctx.font = 'bold 14px Segoe UI, sans-serif';
                          ctx.fillText(b.title, b.x + 22, 155);
                          ctx.fillStyle = '#E2E8F0';
                          ctx.font = '12px Segoe UI, sans-serif';
                          ctx.fillText(b.desc, b.x + 22, 195);
                          ctx.fillStyle = '#FDE68A';
                          ctx.font = '11px Consolas, monospace';
                          ctx.fillText('Domain #' + sciMode + ' Instantiated & Verified', b.x + 22, 245);
                          if (i < 2) {
                            ctx.strokeStyle = '#D4AF37';
                            ctx.beginPath();
                            ctx.moveTo(b.x + 355, 225);
                            ctx.lineTo(b.x + 430, 225);
                            ctx.stroke();
                          }
                        });
                      }
                    }
                    window.addEventListener('DOMContentLoaded', drawSciCanvas);
                  </script>
                </body>
                </html>
                """;

        return template
                .replace("__STYLES__", sharedStyles())
                .replace("__RIBBON__", buildSuiteRibbon(3))
                .replace("__VOL1_FILE__", VOL1_RECEPTION_FILENAME)
                .replace("__SCIENCE_HTML__", scienceHtml.toString());
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
