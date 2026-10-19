package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.QuranicTimelinePropertiesKingdomsAndBeautyThesis;
import com.sovereign.warlock.domain.QuranicTimelinePropertiesKingdomsAndBeautyThesis.BeautyOfIslamDimension;
import com.sovereign.warlock.domain.QuranicTimelinePropertiesKingdomsAndBeautyThesis.CanonicalPropertyAndLandCategory;
import com.sovereign.warlock.domain.QuranicTimelinePropertiesKingdomsAndBeautyThesis.CollegiateThesisChapter;
import com.sovereign.warlock.domain.QuranicTimelinePropertiesKingdomsAndBeautyThesis.CountriesAndKingdomsClime;
import com.sovereign.warlock.domain.QuranicTimelinePropertiesKingdomsAndBeautyThesis.QuranicExpansionTimelineEpoch;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Expansive Multi-HTML Collegiate Suite Generator producing 3 interlinked static HTML portals:
 * 1. Portal #58 (Volume I): {@code quranic-timeline-expansion-vol1-chronology.html}
 *    — Canonical Qur'anic Timeline of Revelation & 14-Century Civilizational Expansion (10 Epochs).
 * 2. Portal #59 (Volume II): {@code quranic-timeline-expansion-vol2-properties-kingdoms.html}
 *    — Canonical Islamic Properties (Milk Allah, 'Ushr, Kharaj, Waqf, Mawat, Hima, Mirath),
 *      Countries (Al-Buldan) & Kingdoms (Al-Mamalik) Across the 7 Classical Climes.
 * 3. Portal #60 (Volume III): {@code quranic-timeline-expansion-vol3-beauty-collegiate-thesis.html}
 *    — The 7 Dimensions of the Beauty of Islam (Jamal Al-Islam) & The 8-Chapter Collegiate
 *      Universal Thesis Essay (Ar-Risalah Al-Jami'iyyah Al-'Alamiyyah).
 */
public final class QuranicTimelinePropertiesBeautyMultiPortalGenerator {

    public static final String VOL1_TIMELINE_FILENAME = "quranic-timeline-expansion-vol1-chronology.html";
    public static final String VOL2_PROPERTIES_KINGDOMS_FILENAME = "quranic-timeline-expansion-vol2-properties-kingdoms.html";
    public static final String VOL3_BEAUTY_THESIS_FILENAME = "quranic-timeline-expansion-vol3-beauty-collegiate-thesis.html";

    private QuranicTimelinePropertiesBeautyMultiPortalGenerator() {
    }

    public static List<Path> generateAllThreeVolumes(Path outputDir) throws IOException {
        Files.createDirectories(outputDir);
        Path vol1 = outputDir.resolve(VOL1_TIMELINE_FILENAME);
        Path vol2 = outputDir.resolve(VOL2_PROPERTIES_KINGDOMS_FILENAME);
        Path vol3 = outputDir.resolve(VOL3_BEAUTY_THESIS_FILENAME);

        Files.writeString(vol1, buildVol1TimelineHtml(), StandardCharsets.UTF_8);
        Files.writeString(vol2, buildVol2PropertiesAndKingdomsHtml(), StandardCharsets.UTF_8);
        Files.writeString(vol3, buildVol3BeautyAndCollegiateThesisHtml(), StandardCharsets.UTF_8);

        return List.of(vol1, vol2, vol3);
    }

    private static String buildMultiVolumeRibbon(int activeVolume) {
        String v1Class = (activeVolume == 1) ? "vol-tab active" : "vol-tab";
        String v2Class = (activeVolume == 2) ? "vol-tab active" : "vol-tab";
        String v3Class = (activeVolume == 3) ? "vol-tab active" : "vol-tab";
        return """
                <div class="multi-vol-ribbon">
                  <div class="ribbon-label">COLLEGIATE MULTI-HTML THESIS SUITE (3 VOLUMES):</div>
                  <div class="vol-tabs">
                    <a class="%s" href="%s">
                      <span class="vol-num">VOL. I (#58)</span>
                      <span class="vol-name">Canonical Qur'anic Timeline of Expansion (10 Epochs)</span>
                    </a>
                    <a class="%s" href="%s">
                      <span class="vol-num">VOL. II (#59)</span>
                      <span class="vol-name">Islamic Properties (Waqf/Kharāj/'Ushr), Countries &amp; Kingdoms (7 Climes)</span>
                    </a>
                    <a class="%s" href="%s">
                      <span class="vol-num">VOL. III (#60)</span>
                      <span class="vol-name">The Beauty of Islam &amp; 8-Chapter Collegiate Universal Thesis Essay</span>
                    </a>
                  </div>
                </div>
                """.formatted(
                v1Class, VOL1_TIMELINE_FILENAME,
                v2Class, VOL2_PROPERTIES_KINGDOMS_FILENAME,
                v3Class, VOL3_BEAUTY_THESIS_FILENAME
        );
    }

    private static String sharedStyles() {
        return """
                :root {
                  --bg-deep: #060911;
                  --bg-card: #0F1626;
                  --bg-card-alt: #162038;
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
                  background: radial-gradient(circle at 18% 0%, #132544 0%, var(--bg-deep) 68%);
                  color: var(--text-main);
                  line-height: 1.72;
                  padding-bottom: 5rem;
                }
                .container {
                  max-width: 1420px;
                  margin: 0 auto;
                  padding: 1.8rem 1.5rem;
                }
                .multi-vol-ribbon {
                  background: linear-gradient(90deg, #0D1525 0%, #16243E 50%, #0D1525 100%);
                  border: 1px solid var(--gold);
                  border-radius: 14px;
                  padding: 1.1rem 1.4rem;
                  margin-bottom: 1.8rem;
                  box-shadow: 0 12px 32px rgba(0,0,0,0.45);
                }
                .ribbon-label {
                  font-family: 'Consolas', monospace;
                  font-size: 0.78rem;
                  font-weight: 700;
                  color: #FDE68A;
                  letter-spacing: 0.08em;
                  margin-bottom: 0.65rem;
                }
                .vol-tabs {
                  display: grid;
                  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
                  gap: 0.75rem;
                }
                .vol-tab {
                  display: flex;
                  flex-direction: column;
                  padding: 0.8rem 1.05rem;
                  border-radius: 10px;
                  background: rgba(255,255,255,0.03);
                  border: 1px solid rgba(255,255,255,0.12);
                  text-decoration: none;
                  color: var(--text-main);
                  transition: all 0.18s ease;
                }
                .vol-tab:hover, .vol-tab.active {
                  background: rgba(212, 175, 55, 0.18);
                  border-color: var(--gold);
                  box-shadow: 0 0 18px rgba(212, 175, 55, 0.22);
                }
                .vol-num {
                  font-family: 'Consolas', monospace;
                  font-size: 0.76rem;
                  font-weight: 700;
                  color: var(--gold);
                }
                .vol-name {
                  font-size: 0.94rem;
                  font-weight: 600;
                  color: #FFF;
                  margin-top: 0.15rem;
                }
                .hero {
                  background: linear-gradient(135deg, rgba(15, 22, 38, 0.96) 0%, rgba(16, 185, 129, 0.14) 52%, rgba(212, 175, 55, 0.16) 100%);
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
                  font-size: 2.2rem;
                  color: #FFF;
                  line-height: 1.24;
                  margin-bottom: 0.55rem;
                }
                .arabic-sub {
                  font-size: 1.32rem;
                  color: #FDE68A;
                  margin-bottom: 0.95rem;
                  font-weight: 600;
                }
                .epigraph-banner {
                  background: rgba(6, 9, 17, 0.84);
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
                  height: 410px;
                  background: #050811;
                  border-radius: 10px;
                  border: 1px solid rgba(255,255,255,0.08);
                  display: block;
                }
                .section-heading {
                  font-size: 1.58rem;
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
                  padding: 1.6rem;
                  margin-bottom: 1.35rem;
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
                  font-size: 1.28rem;
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
                  grid-template-columns: repeat(auto-fit, minmax(320px, 1fr));
                  gap: 1.1rem;
                  margin-top: 0.8rem;
                }
                .sub-panel {
                  background: rgba(255,255,255,0.03);
                  border: 1px solid rgba(255,255,255,0.08);
                  border-radius: 10px;
                  padding: 1rem;
                }
                .sub-panel h4 {
                  color: #34D399;
                  font-size: 0.96rem;
                  margin-bottom: 0.4rem;
                }
                .thesis-chapter {
                  background: linear-gradient(180deg, #0F172A 0%, #0B1120 100%);
                  border: 1px solid var(--border-gold);
                  border-left: 6px solid var(--gold);
                  border-radius: 14px;
                  padding: 2rem;
                  margin-bottom: 1.75rem;
                }
                .thesis-chapter h3 {
                  font-size: 1.45rem;
                  color: #FDE68A;
                  margin-bottom: 0.65rem;
                }
                .thesis-prop {
                  background: rgba(16, 185, 129, 0.1);
                  border: 1px solid rgba(16, 185, 129, 0.35);
                  border-radius: 9px;
                  padding: 0.85rem 1.15rem;
                  margin: 0.85rem 0 1.15rem 0;
                  color: #A7F3D0;
                  font-weight: 600;
                }
                .thesis-chapter p {
                  margin-bottom: 1.05rem;
                  text-align: justify;
                  font-size: 1.03rem;
                  color: #E2E8F0;
                }
                .seminar-box {
                  background: rgba(56, 189, 248, 0.09);
                  border-left: 3px solid #38BDF8;
                  padding: 0.8rem 1.1rem;
                  border-radius: 0 8px 8px 0;
                  font-size: 0.93rem;
                  color: #BAE6FD;
                }
                """;
    }

    private static String buildVol1TimelineHtml() {
        StringBuilder epochsHtml = new StringBuilder();
        for (QuranicExpansionTimelineEpoch e : QuranicTimelinePropertiesKingdomsAndBeautyThesis.allTenQuranicTimelineEpochs()) {
            epochsHtml.append("""
                    <div class="card" data-epoch="%d" style="border-left: 5px solid %s;">
                      <div class="card-top">
                        <span class="badge" style="background:%s22;color:%s;border:1px solid %s66;">EPOCH #%d • %s</span>
                        <span class="era-tag">%s</span>
                      </div>
                      <h3>%s</h3>
                      <div class="scripture-box"><strong>Anchoring Qur'anic Surahs &amp; Āyāt:</strong> %s</div>
                      <div class="grid-2">
                        <div class="sub-panel">
                          <h4>✦ Historical Expansion &amp; Civilizational Horizon</h4>
                          <p>%s</p>
                        </div>
                        <div class="sub-panel">
                          <h4 style="color:#FDE68A;">⚖ Constitutional &amp; Property Transformation</h4>
                          <p>%s</p>
                          <p style="margin-top:0.55rem;color:#93C5FD;"><strong>Universal Lesson:</strong> %s</p>
                        </div>
                      </div>
                    </div>
                    """.formatted(
                    e.epochIndex(),
                    e.hexAccentColor(),
                    e.hexAccentColor(), e.hexAccentColor(), e.hexAccentColor(),
                    e.epochIndex(), escapeHtml(e.epochCode()),
                    escapeHtml(e.chronologicalEraAndHijriSpan()),
                    escapeHtml(e.titleAndGeographicHorizon()),
                    escapeHtml(e.anchoringQuranicSurahsAndAyahs()),
                    escapeHtml(e.historicalExpansionAndCivilizationalEvents()),
                    escapeHtml(e.constitutionalAndPropertyTransformation()),
                    escapeHtml(e.universalLessonForHumanity())
            ));
        }

        String template = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <title>Vol. I (#58): Canonical Qur'anic Timeline of Islamic Expansion | Multi-HTML Collegiate Suite</title>
                  <style>__STYLES__</style>
                </head>
                <body>
                  <div class="container">
                    __RIBBON__
                    <section class="hero">
                      <div class="badge-row">
                        <span class="badge" style="background:rgba(212,175,55,0.2);color:#FDE68A;border:1px solid #D4AF37;">PORTAL #58 • COLLEGIATE SUITE VOLUME I OF III</span>
                        <span class="badge" style="background:rgba(16,185,129,0.2);color:#6EE7B7;border:1px solid #10B981;">10 CANONICAL QUR'ANIC EXPANSION EPOCHS</span>
                        <span class="badge" style="background:rgba(56,189,248,0.2);color:#7DD3FC;border:1px solid #38BDF8;">AL-MĪTHĀQ (7:172) TO 2 BILLION SOULS (41:53)</span>
                      </div>
                      <h1>Volume I: The Canonical Qur'anic Timeline of Islamic Expansion — Revelation, Covenants &amp; Civilizational Horizons</h1>
                      <div class="arabic-sub">المُجَلَّدُ الأَوَّلُ: التَّارِيخُ القُرْآنِيُّ لِلْفُتُوحِ وَالِامتِدَادِ الحَضَارِيِّ عبر العُصُورِ العَشَرَةِ</div>
                      <p style="color:#CBD5E1;font-size:1.03rem;">
                        This first volume of the three-part Collegiate Multi-HTML Suite maps the <strong>10 Canonical Epochs of the Qur'anic Timeline</strong>:
                        showing how specific Surahs and Āyāt—from the Primordial Covenant of <em>Alast</em> (<strong>Qur'an 7:172</strong>) and Abraham's raising
                        of the Ka'bah (<strong>2:127</strong>), through the Meccan revelations (<strong>96:1–5, 19:1–36, 30:1–5</strong>) and the Medinan
                        charter of <em>Al-Fatḥ</em> (<strong>48:1, 59:7–10, 110:1–3</strong>)—guided fourteen centuries of global expansion across seven civilizational zones.
                      </p>
                      <div class="epigraph-banner">
                        <strong>Foundational Qur'anic Horizon (Qur'an 41:53 &amp; 48:1):</strong><br>
                        <em>«سَنُرِيهِمْ آيَاتِنَا فِي الْآفَاقِ وَفِي أَنفُسِهِمْ حَتَّىٰ يَتَبَيَّنَ لَهُمْ أَنَّهُ الْحَقُّ»</em> —
                        "We will show them Our signs in the horizons (<em>Al-Āfāq</em>) and within themselves until it becomes clear to them that it is the Truth."
                      </div>
                    </section>

                    <div class="canvas-box">
                      <h2 style="color:var(--gold);margin-bottom:0.35rem;">Interactive Qur'anic Chronology &amp; Civilizational Expansion Horizon (Epochs 1–10)</h2>
                      <p style="color:var(--text-muted);font-size:0.9rem;margin-bottom:0.85rem;">
                        Click any epoch button below to highlight its Qur'anic revelation anchor, territorial-demographic reach, and property/institutional breakthrough.
                      </p>
                      <div class="controls-row">
                        <button class="btn active" onclick="selectEpoch(0, this)">All 10 Epochs</button>
                        <button class="btn" onclick="selectEpoch(1, this)">1. Alast &amp; Ibrāhīm</button>
                        <button class="btn" onclick="selectEpoch(2, this)">2. Mecca &amp; Abyssinia</button>
                        <button class="btn" onclick="selectEpoch(3, this)">3. Medina &amp; Ḥudaybiyyah</button>
                        <button class="btn" onclick="selectEpoch(4, this)">4. Rāshidūn Kharāj</button>
                        <button class="btn" onclick="selectEpoch(5, this)">5. Umayyad Atlantic–Indus</button>
                        <button class="btn" onclick="selectEpoch(6, this)">6. Abbasid/Andalusian Waqf</button>
                        <button class="btn" onclick="selectEpoch(7, this)">7. Sultanates &amp; Mongols</button>
                        <button class="btn" onclick="selectEpoch(8, this)">8. Nusantara &amp; Swahili</button>
                        <button class="btn" onclick="selectEpoch(9, this)">9. Gunpowder Empires</button>
                        <button class="btn" onclick="selectEpoch(10, this)">10. Global 2B+ Ummah</button>
                      </div>
                      <canvas id="timelineCanvas" width="1340" height="410"></canvas>
                    </div>

                    <div class="section-heading">
                      <span>The 10 Canonical Epochs of the Qur'anic Timeline of Expansion</span>
                      <a class="btn" href="__VOL2_FILE__" style="text-decoration:none;">Proceed to Volume II: Properties, Countries &amp; Kingdoms →</a>
                    </div>
                    <div>
                      __EPOCHS_HTML__
                    </div>
                  </div>
                  <script>
                    let activeEpoch = 0;
                    function selectEpoch(idx, btn) {
                      activeEpoch = idx;
                      document.querySelectorAll('.controls-row .btn').forEach(b => b.classList.remove('active'));
                      if (btn) btn.classList.add('active');
                      drawTimeline();
                    }
                    function drawTimeline() {
                      const c = document.getElementById('timelineCanvas');
                      if (!c) return;
                      const ctx = c.getContext('2d');
                      const W = c.width, H = c.height;
                      ctx.clearRect(0, 0, W, H);

                      const nodes = [
                        { id: 1, x: 85,  y: 320, label: '1. Alast/Ibrāhīm', surah: 'Q 7:172, 2:127', color: '#10B981' },
                        { id: 2, x: 210, y: 290, label: '2. Mecca (610)', surah: 'Q 96:1, 19:1, 30:1', color: '#D4AF37' },
                        { id: 3, x: 335, y: 255, label: '3. Medina (622)', surah: 'Q 48:1, 2:256, 5:3', color: '#38BDF8' },
                        { id: 4, x: 460, y: 220, label: '4. Rāshidūn (632)', surah: 'Q 24:55, 59:7-10', color: '#A855F7' },
                        { id: 5, x: 585, y: 190, label: '5. Umayyad (661)', surah: 'Q 49:13, 112:1', color: '#F43F5E' },
                        { id: 6, x: 710, y: 155, label: '6. Abbasid/Waqf', surah: 'Q 20:114, 2:261', color: '#F59E0B' },
                        { id: 7, x: 835, y: 140, label: '7. Sultanates/Mongols', surah: 'Q 47:38, 41:34', color: '#22D3EE' },
                        { id: 8, x: 960, y: 115, label: '8. Nusantara/Oceans', surah: 'Q 16:14, 17:35', color: '#EC4899' },
                        { id: 9, x: 1085, y: 95, label: '9. 3 Empires (1453)', surah: 'Q 3:140, 3:26', color: '#8B5CF6' },
                        { id: 10, x: 1225, y: 68, label: '10. 2B+ Ummah', surah: 'Q 41:53, 15:9', color: '#10B981' }
                      ];

                      // Grid lines
                      ctx.strokeStyle = 'rgba(212,175,55,0.1)';
                      for (let y = 60; y < H - 40; y += 65) {
                        ctx.beginPath(); ctx.moveTo(40, y); ctx.lineTo(W - 40, y); ctx.stroke();
                      }

                      // Connect spline
                      ctx.beginPath();
                      nodes.forEach((n, i) => {
                        if (i === 0) ctx.moveTo(n.x, n.y);
                        else ctx.lineTo(n.x, n.y);
                      });
                      ctx.strokeStyle = '#D4AF37';
                      ctx.lineWidth = 3.5;
                      ctx.stroke();

                      nodes.forEach(n => {
                        const focused = (activeEpoch === 0 || activeEpoch === n.id);
                        ctx.save();
                        ctx.globalAlpha = focused ? 1.0 : 0.25;
                        ctx.fillStyle = n.color;
                        ctx.beginPath();
                        ctx.arc(n.x, n.y, (activeEpoch === n.id) ? 14 : 9, 0, Math.PI * 2);
                        ctx.fill();
                        ctx.strokeStyle = '#FFF';
                        ctx.lineWidth = 2;
                        ctx.stroke();

                        ctx.fillStyle = '#FFF';
                        ctx.font = 'bold 11px Segoe UI, sans-serif';
                        ctx.fillText(n.label, n.x - 42, n.y - 16);
                        ctx.fillStyle = '#FDE68A';
                        ctx.font = '10px Consolas, monospace';
                        ctx.fillText(n.surah, n.x - 42, n.y + 24);
                        ctx.restore();
                      });
                    }
                    window.addEventListener('DOMContentLoaded', drawTimeline);
                  </script>
                </body>
                </html>
                """;

        return template
                .replace("__STYLES__", sharedStyles())
                .replace("__RIBBON__", buildMultiVolumeRibbon(1))
                .replace("__VOL2_FILE__", VOL2_PROPERTIES_KINGDOMS_FILENAME)
                .replace("__EPOCHS_HTML__", epochsHtml.toString());
    }

    private static String buildVol2PropertiesAndKingdomsHtml() {
        StringBuilder propsHtml = new StringBuilder();
        for (CanonicalPropertyAndLandCategory p : QuranicTimelinePropertiesKingdomsAndBeautyThesis.allSevenCanonicalPropertyCategories()) {
            propsHtml.append("""
                    <div class="card" style="border-left: 5px solid %s;">
                      <div class="card-top">
                        <span class="badge" style="background:%s22;color:%s;border:1px solid %s66;">PROPERTY CATEGORY #%d • %s</span>
                        <span class="era-tag">FIQH AL-AMWĀL WA AL-ARĀḌĪ</span>
                      </div>
                      <h3>%s</h3>
                      <div class="scripture-box"><strong>Primary Qur'anic &amp; Hadith Proof:</strong> %s</div>
                      <div class="grid-2">
                        <div class="sub-panel">
                          <h4>✦ Legal Definition, Tenure &amp; Fiscal Rate</h4>
                          <p>%s</p>
                          <p style="margin-top:0.55rem;"><strong>Fiscal Assessment &amp; Revenue Destination:</strong> %s</p>
                        </div>
                        <div class="sub-panel">
                          <h4 style="color:#FDE68A;">🏛 Historical Kingdoms &amp; Comparative Economic Significance</h4>
                          <p>%s</p>
                          <p style="margin-top:0.55rem;color:#93C5FD;"><strong>Comparative Insight:</strong> %s</p>
                        </div>
                      </div>
                    </div>
                    """.formatted(
                    p.hexColor(),
                    p.hexColor(), p.hexColor(), p.hexColor(),
                    p.categoryIndex(), escapeHtml(p.categoryCode()),
                    escapeHtml(p.arabicAndEnglishTitle()),
                    escapeHtml(p.primaryQuranicAndHadithBasis()),
                    escapeHtml(p.legalDefinitionAndTenureRules()),
                    escapeHtml(p.fiscalRateAndPublicRevenueDestination()),
                    escapeHtml(p.historicalImplementationInKingdoms()),
                    escapeHtml(p.comparativeEconomicSignificance())
            ));
        }

        StringBuilder climesHtml = new StringBuilder();
        for (CountriesAndKingdomsClime c : QuranicTimelinePropertiesKingdomsAndBeautyThesis.allSevenCountriesAndKingdomsClimes()) {
            climesHtml.append("""
                    <div class="card" style="border-left: 5px solid %s;">
                      <div class="card-top">
                        <span class="badge" style="background:%s22;color:%s;border:1px solid %s66;">CLIME #%d • %s</span>
                        <span class="era-tag">AL-AQĀLĪM AS-SAB'AH • COUNTRIES &amp; KINGDOMS</span>
                      </div>
                      <h3>%s</h3>
                      <p style="margin-bottom:0.65rem;"><strong>Major Kingdoms, Sultanates &amp; Dynasties:</strong> %s</p>
                      <div class="grid-2">
                        <div class="sub-panel">
                          <h4>🕌 Signature Cities &amp; Architectural Jewels</h4>
                          <p>%s</p>
                        </div>
                        <div class="sub-panel">
                          <h4 style="color:#FDE68A;">📜 Signature Property, Waqf &amp; Geographic Sources</h4>
                          <p>%s</p>
                          <p style="margin-top:0.5rem;color:#A5F3FC;"><strong>Primary Geographers:</strong> <em>%s</em></p>
                        </div>
                      </div>
                    </div>
                    """.formatted(
                    c.hexColor(),
                    c.hexColor(), c.hexColor(), c.hexColor(),
                    c.climeIndex(), escapeHtml(c.climeCode()),
                    escapeHtml(c.classicalNameAndModernCountries()),
                    escapeHtml(c.majorKingdomsSultanatesAndDynasties()),
                    escapeHtml(c.signatureCitiesAndArchitecturalJewels()),
                    escapeHtml(c.signaturePropertyWaqfAndEconomicEngines()),
                    escapeHtml(c.canonicalGeographersAndPrimarySources())
            ));
        }

        String template = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <title>Vol. II (#59): Canonical Islamic Properties, Countries &amp; Kingdoms | Multi-HTML Collegiate Suite</title>
                  <style>__STYLES__</style>
                </head>
                <body>
                  <div class="container">
                    __RIBBON__
                    <section class="hero">
                      <div class="badge-row">
                        <span class="badge" style="background:rgba(212,175,55,0.2);color:#FDE68A;border:1px solid #D4AF37;">PORTAL #59 • COLLEGIATE SUITE VOLUME II OF III</span>
                        <span class="badge" style="background:rgba(16,185,129,0.2);color:#6EE7B7;border:1px solid #10B981;">7 PROPERTY &amp; LAND TENURE CATEGORIES</span>
                        <span class="badge" style="background:rgba(56,189,248,0.2);color:#7DD3FC;border:1px solid #38BDF8;">7 CLIMES OF COUNTRIES (AL-BULDĀN) &amp; KINGDOMS (AL-MAMĀLIK)</span>
                      </div>
                      <h1>Volume II: Canonical Islamic Properties (Waqf, Kharāj, 'Ushr, Fay', Ḥimā &amp; Mawāt), Countries &amp; Kingdoms Across the 7 Climes</h1>
                      <div class="arabic-sub">المُجَلَّدُ الثَّانِي: فِقْهُ الأَمْوَالِ وَالأَرَاضِي وَمُعْجَمُ البُلْدَانِ وَالمَمَالِكِ فِي الأَقَالِيمِ السَّبْعَةِ</div>
                      <p style="color:#CBD5E1;font-size:1.03rem;">
                        This second volume of the Collegiate Multi-HTML Suite explores how Islamic civilization structured
                        <strong>property, land tenure, public commons, and perpetual Waqf endowments</strong> under <strong>Qur'an 7:128, 59:7–10, and 4:7–12</strong>,
                        and maps the <strong>Countries (<em>Al-Buldān</em>) and Kingdoms (<em>Al-Mamālik</em>)</strong> across all <strong>7 Classical Climes</strong>
                        documented by Al-Muqaddasī, Al-Idrīsī, and Yāqūt Al-Ḥamawī.
                      </p>
                      <div class="epigraph-banner">
                        <strong>The Canonical Property Principle (Qur'an 7:128 &amp; 59:7):</strong><br>
                        <em>«إِنَّ الْأَرْضَ لِلَّهِ يُورِثُهَا مَن يَشَاءُ مِنْ عِبَادِهِ»</em> — "Indeed, the earth belongs to Allah; He causes to inherit it whom He wills of His servants." |
                        <em>«كَيْ لَا يَكُونَ دُولَةً بَيْنَ الْأَغْنِيَاءِ مِنكُمْ»</em> — "So that wealth may not become a perpetual circuit solely among the rich among you."
                      </div>
                    </section>

                    <div class="canvas-box">
                      <h2 style="color:var(--gold);margin-bottom:0.35rem;">Interactive Canonical Property &amp; 7-Clime Kingdoms Visualizer</h2>
                      <p style="color:var(--text-muted);font-size:0.9rem;margin-bottom:0.85rem;">
                        Switch between the <strong>7 Property &amp; Land Tenure Architecture Diagram</strong> and the <strong>7 Classical Climes of Countries &amp; Kingdoms Atlas</strong>.
                      </p>
                      <div class="controls-row">
                        <button class="btn active" onclick="drawPropMode(1, this)">View I: 7 Canonical Property &amp; Waqf Pillars</button>
                        <button class="btn" onclick="drawPropMode(2, this)">View II: 7 Climes of Countries &amp; Kingdoms (Al-Idrīsī / Al-Muqaddasī)</button>
                      </div>
                      <canvas id="propCanvas" width="1340" height="410"></canvas>
                    </div>

                    <div class="section-heading">
                      <span>Part I. The 7 Canonical Categories of Property &amp; Land Tenure in Islam (Fiqh Al-Amwāl)</span>
                      <a class="btn" href="__VOL3_FILE__" style="text-decoration:none;">Proceed to Volume III: Beauty of Islam &amp; Collegiate Thesis →</a>
                    </div>
                    <div>
                      __PROPS_HTML__
                    </div>

                    <div class="section-heading">
                      <span>Part II. Countries (Al-Buldān) &amp; Kingdoms (Al-Mamālik) Across the 7 Classical Climes</span>
                      <a class="btn" href="__VOL1_FILE__" style="text-decoration:none;">← Return to Volume I: Qur'anic Timeline</a>
                    </div>
                    <div>
                      __CLIMES_HTML__
                    </div>
                  </div>
                  <script>
                    let propMode = 1;
                    function drawPropMode(m, btn) {
                      propMode = m;
                      document.querySelectorAll('.controls-row .btn').forEach(b => b.classList.remove('active'));
                      if (btn) btn.classList.add('active');
                      renderPropCanvas();
                    }
                    function renderPropCanvas() {
                      const c = document.getElementById('propCanvas');
                      if (!c) return;
                      const ctx = c.getContext('2d');
                      const W = c.width, H = c.height;
                      ctx.clearRect(0, 0, W, H);

                      if (propMode === 1) {
                        // Crown banner: Milk Allah (Qur'an 7:128)
                        ctx.fillStyle = 'rgba(212, 175, 55, 0.16)';
                        ctx.strokeStyle = '#D4AF37';
                        ctx.lineWidth = 2;
                        ctx.beginPath();
                        ctx.roundRect(360, 22, 620, 56, 10);
                        ctx.fill(); ctx.stroke();
                        ctx.fillStyle = '#FDE68A';
                        ctx.font = 'bold 14px Segoe UI, sans-serif';
                        ctx.fillText('1. MILK ALLĀH WA AL-ISTIKHLĀF (Qur\\'an 7:128 & 57:7 — Divine Ownership & Human Trusteeship)', 385, 55);

                        const cols = [
                          { title: '2. Arḍ Al-\\'Ushr', sub: '10% Rain / 5% Irrigated', desc: 'Private Freehold Zakat', color: '#10B981', x: 55 },
                          { title: '3. Arḍ Al-Kharāj', sub: 'Qur\\'an 59:7-10 Trust', desc: 'Peasant Usufruct + Public Revenue', color: '#38BDF8', x: 265 },
                          { title: '4. Al-Waqf (Ḥubs)', sub: 'Inalienable 3rd Sector', desc: 'Universities, Hospitals, Water', color: '#A855F7', x: 475 },
                          { title: '5. Iḥyā\\' Al-Mawāt', sub: 'Reviving Dead Land', desc: 'Irrigation Creates Private Title', color: '#F43F5E', x: 685 },
                          { title: '6. Ḥimā & 3 Commons', sub: 'Water, Pasture, Fire', desc: 'Ecological Buffer & Reserves', color: '#F59E0B', x: 895 },
                          { title: '7. Milk Khāṣṣ & Mīrāth', sub: 'Qur\\'an 4:7-12 Shares', desc: 'Women & Men Freehold Rights', color: '#22D3EE', x: 1105 }
                        ];

                        cols.forEach(p => {
                          ctx.strokeStyle = 'rgba(212,175,55,0.35)';
                          ctx.beginPath();
                          ctx.moveTo(670, 78);
                          ctx.lineTo(p.x + 90, 145);
                          ctx.stroke();

                          ctx.fillStyle = 'rgba(15, 22, 38, 0.92)';
                          ctx.strokeStyle = p.color;
                          ctx.lineWidth = 2;
                          ctx.beginPath();
                          ctx.roundRect(p.x, 145, 190, 215, 10);
                          ctx.fill(); ctx.stroke();

                          ctx.fillStyle = p.color;
                          ctx.font = 'bold 13px Segoe UI, sans-serif';
                          ctx.fillText(p.title, p.x + 14, 180);
                          ctx.fillStyle = '#FDE68A';
                          ctx.font = '11px Consolas, monospace';
                          ctx.fillText(p.sub, p.x + 14, 210);
                          ctx.fillStyle = '#CBD5E1';
                          ctx.font = '11px Segoe UI, sans-serif';
                          ctx.fillText(p.desc, p.x + 14, 245);
                        });
                      } else {
                        const climes = [
                          { name: 'I. Jazīrat Al-\\'Arab', cities: 'Mecca, Medina, Sana\\'a, Muscat', x: 110, y: 210, color: '#10B981' },
                          { name: 'II. Shām, \\'Irāq & Miṣr', cities: 'Jerusalem, Damascus, Baghdad, Cairo', x: 300, y: 145, color: '#D4AF37' },
                          { name: 'III. Maghrib, Andalus & Sūdān', cities: 'Cordoba, Fez, Timbuktu, Sokoto', x: 490, y: 255, color: '#38BDF8' },
                          { name: 'IV. Rūm, Balkans & Qawqāz', cities: 'Istanbul, Edirne, Sarajevo, Baku', x: 680, y: 115, color: '#A855F7' },
                          { name: 'V. Fāris & Mā Warā\\' An-Nahr', cities: 'Samarkand, Bukhara, Isfahan, Herat', x: 860, y: 175, color: '#F43F5E' },
                          { name: 'VI. Al-Hind, Sind & Bangāl', cities: 'Lahore, Delhi, Agra, Sonargaon', x: 1040, y: 245, color: '#F59E0B' },
                          { name: 'VII. Nusantara & Zanj Rim', cities: 'Aceh, Demak, Malacca, Kilwa, Zanzibar', x: 1210, y: 315, color: '#22D3EE' }
                        ];
                        ctx.strokeStyle = 'rgba(212,175,55,0.28)';
                        ctx.lineWidth = 2;
                        ctx.beginPath();
                        climes.forEach((cl, i) => {
                          if (i === 0) ctx.moveTo(cl.x, cl.y);
                          else ctx.lineTo(cl.x, cl.y);
                        });
                        ctx.stroke();

                        climes.forEach(cl => {
                          ctx.fillStyle = cl.color;
                          ctx.beginPath();
                          ctx.arc(cl.x, cl.y, 14, 0, Math.PI * 2);
                          ctx.fill();
                          ctx.fillStyle = '#FFF';
                          ctx.font = 'bold 12px Segoe UI, sans-serif';
                          ctx.fillText(cl.name, cl.x - 70, cl.y - 22);
                          ctx.fillStyle = '#A5F3FC';
                          ctx.font = '10px Consolas, monospace';
                          ctx.fillText(cl.cities, cl.x - 70, cl.y + 30);
                        });
                      }
                    }
                    window.addEventListener('DOMContentLoaded', renderPropCanvas);
                  </script>
                </body>
                </html>
                """;

        return template
                .replace("__STYLES__", sharedStyles())
                .replace("__RIBBON__", buildMultiVolumeRibbon(2))
                .replace("__VOL1_FILE__", VOL1_TIMELINE_FILENAME)
                .replace("__VOL3_FILE__", VOL3_BEAUTY_THESIS_FILENAME)
                .replace("__PROPS_HTML__", propsHtml.toString())
                .replace("__CLIMES_HTML__", climesHtml.toString());
    }

    private static String buildVol3BeautyAndCollegiateThesisHtml() {
        StringBuilder beautyHtml = new StringBuilder();
        for (BeautyOfIslamDimension b : QuranicTimelinePropertiesKingdomsAndBeautyThesis.allSevenBeautyOfIslamDimensions()) {
            beautyHtml.append("""
                    <div class="card" style="border-left: 5px solid %s;">
                      <div class="card-top">
                        <span class="badge" style="background:%s22;color:%s;border:1px solid %s66;">BEAUTY DIMENSION #%d • %s</span>
                        <span class="era-tag">JAMĀL AL-ISLĀM WA AL-IḤSĀN</span>
                      </div>
                      <h3>%s</h3>
                      <div class="scripture-box"><strong>Qur'anic &amp; Prophetic Aesthetic Anchor:</strong> %s</div>
                      <div class="grid-2">
                        <div class="sub-panel">
                          <h4>✦ Philosophical &amp; Theological Essence</h4>
                          <p>%s</p>
                        </div>
                        <div class="sub-panel">
                          <h4 style="color:#FDE68A;">🌹 Lived Civilizational Expression &amp; Universal Resonance</h4>
                          <p>%s</p>
                          <p style="margin-top:0.55rem;color:#A7F3D0;"><strong>Universal Human Resonance:</strong> %s</p>
                        </div>
                      </div>
                    </div>
                    """.formatted(
                    b.hexColor(),
                    b.hexColor(), b.hexColor(), b.hexColor(),
                    b.dimensionIndex(), escapeHtml(b.dimensionCode()),
                    escapeHtml(b.arabicAndEnglishTitle()),
                    escapeHtml(b.quranicAndPropheticAestheticAnchor()),
                    escapeHtml(b.philosophicalAndTheologicalEssence()),
                    escapeHtml(b.livedCivilizationalAndArtisticExpression()),
                    escapeHtml(b.universalHumanResonance())
            ));
        }

        StringBuilder chaptersHtml = new StringBuilder();
        for (CollegiateThesisChapter ch : QuranicTimelinePropertiesKingdomsAndBeautyThesis.allEightCollegiateThesisChapters()) {
            chaptersHtml.append("""
                    <article class="thesis-chapter" id="chapter-%d">
                      <div class="card-top">
                        <span class="badge" style="background:rgba(212,175,55,0.2);color:#FDE68A;border:1px solid #D4AF37;">COLLEGIATE MONOGRAPH • CHAPTER %d OF 8 (%s)</span>
                        <span class="era-tag">UNIVERSAL COLLEGIATE THESIS</span>
                      </div>
                      <h3>%s</h3>
                      <div class="scripture-box">%s</div>
                      <div class="thesis-prop">%s</div>
                      <p>%s</p>
                      <p>%s</p>
                      <p>%s</p>
                      <div class="seminar-box"><strong>Collegiate Seminar &amp; Research Inquiry:</strong> %s</div>
                    </article>
                    """.formatted(
                    ch.chapterNumber(),
                    ch.chapterNumber(), escapeHtml(ch.chapterCode()),
                    escapeHtml(ch.chapterTitle()),
                    escapeHtml(ch.epigraphAndCanonicalCitation()),
                    escapeHtml(ch.thesisProposition()),
                    escapeHtml(ch.paragraphOneHistoricalAndScripturalFoundation()),
                    escapeHtml(ch.paragraphTwoInstitutionalAndLegalAnalysis()),
                    escapeHtml(ch.paragraphThreeComparativeUniversalSynthesis()),
                    escapeHtml(ch.seminarDiscussionAndResearchPrompt())
            ));
        }

        String template = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <title>Vol. III (#60): The Beauty of Islam &amp; 8-Chapter Collegiate Universal Thesis | Multi-HTML Suite</title>
                  <style>__STYLES__</style>
                </head>
                <body>
                  <div class="container">
                    __RIBBON__
                    <section class="hero">
                      <div class="badge-row">
                        <span class="badge" style="background:rgba(212,175,55,0.2);color:#FDE68A;border:1px solid #D4AF37;">PORTAL #60 • COLLEGIATE SUITE VOLUME III OF III</span>
                        <span class="badge" style="background:rgba(16,185,129,0.2);color:#6EE7B7;border:1px solid #10B981;">SAHIH MUSLIM 91: ALLAH IS BEAUTIFUL &amp; LOVES BEAUTY</span>
                        <span class="badge" style="background:rgba(244,63,94,0.2);color:#FDA4AF;border:1px solid #F43F5E;">8-CHAPTER COLLEGIATE UNIVERSAL THESIS MONOGRAPH</span>
                      </div>
                      <h1>Volume III: The Beauty of Islam (Jamāl Al-Islām) &amp; The Collegiate Universal Thesis Essay on Expansion, Properties, Kingdoms &amp; Iḥsān</h1>
                      <div class="arabic-sub">المُجَلَّدُ الثَّالِثُ: جَمَالُ الإِسْلَامِ وَالإِحْسَانِ وَالرِّسَالَةُ الجَامِعِيَّةُ العَالَمِيَّةُ الفَاحِصَةُ</div>
                      <p style="color:#CBD5E1;font-size:1.03rem;">
                        This crowning third volume of the Collegiate Multi-HTML Suite presents the <strong>7 Canonical Dimensions of the Beauty of Islam (<em>Jamāl Al-Islām</em>)</strong>
                        together with a complete, <strong>8-Chapter Collegiate Universal Thesis Monograph</strong> synthesizing how Qur'anic temporality,
                        fiduciary property law (<em>Waqf, Kharāj, 'Ushr, Mawāt, Ḥimā</em>), cultural pluralism across 70+ countries, and sacred aesthetics
                        form a single coherent paradigm for universal human understanding.
                      </p>
                      <div class="epigraph-banner">
                        <strong>The Supreme Aesthetic Hadith (Sahih Muslim 91 &amp; Qur'an 16:90):</strong><br>
                        <em>«إِنَّ اللَّهَ جَمِيلٌ يُحِبُّ الْجَمَالَ»</em> — "Indeed, Allah is Beautiful and He loves beauty." |
                        <em>«إِنَّ اللَّهَ يَأْمُرُ بِالْعَدْلِ وَالْإِحْسَانِ»</em> — "Indeed, Allah commands Justice (<em>Al-'Adl</em>) and Beauty/Excellence (<em>Al-Iḥsān</em>)."
                      </div>
                    </section>

                    <div class="canvas-box">
                      <h2 style="color:var(--gold);margin-bottom:0.35rem;">Interactive Sacred Geometry &amp; 7-Fold Beauty of Islam (Al-Jamāl wa Al-Mīzān) Rosette</h2>
                      <p style="color:var(--text-muted);font-size:0.9rem;margin-bottom:0.85rem;">
                        Explore how the 7 Dimensions of Islamic Beauty radiate from <em>Tawḥīd</em> (Unity in Multiplicity) alongside direct jump-links to all 8 Collegiate Thesis Chapters.
                      </p>
                      <div class="controls-row">
                        <a class="btn" href="#chapter-1" style="text-decoration:none;">Ch. I: Thesis &amp; Ontology</a>
                        <a class="btn" href="#chapter-2" style="text-decoration:none;">Ch. II: Qur'anic Timeline</a>
                        <a class="btn" href="#chapter-3" style="text-decoration:none;">Ch. III: Property Law</a>
                        <a class="btn" href="#chapter-4" style="text-decoration:none;">Ch. IV: Waqf Civil Society</a>
                        <a class="btn" href="#chapter-5" style="text-decoration:none;">Ch. V: 7 Climes &amp; Kingdoms</a>
                        <a class="btn" href="#chapter-6" style="text-decoration:none;">Ch. VI: Sacred Aesthetics</a>
                        <a class="btn" href="#chapter-7" style="text-decoration:none;">Ch. VII: Crisis &amp; Tajdīd</a>
                        <a class="btn" href="#chapter-8" style="text-decoration:none;">Ch. VIII: Universal Conclusion</a>
                      </div>
                      <canvas id="beautyCanvas" width="1340" height="410"></canvas>
                    </div>

                    <div class="section-heading">
                      <span>Part I. The 7 Canonical Dimensions of the Beauty of Islam (Jamāl Al-Islām)</span>
                      <a class="btn" href="__VOL2_FILE__" style="text-decoration:none;">← Return to Volume II: Properties &amp; Kingdoms</a>
                    </div>
                    <div>
                      __BEAUTY_HTML__
                    </div>

                    <div class="section-heading">
                      <span>Part II. The Collegiate Universal Thesis Monograph (8 Chapters)</span>
                      <a class="btn" href="__VOL1_FILE__" style="text-decoration:none;">← Return to Volume I: Qur'anic Timeline</a>
                    </div>
                    <div>
                      __CHAPTERS_HTML__
                    </div>
                  </div>
                  <script>
                    function drawBeautyCanvas() {
                      const c = document.getElementById('beautyCanvas');
                      if (!c) return;
                      const ctx = c.getContext('2d');
                      const W = c.width, H = c.height;
                      ctx.clearRect(0, 0, W, H);

                      const cx = 310, cy = H / 2;
                      // Draw 12-fold Islamic geometric star rosette on the left
                      for (let ring = 145; ring >= 45; ring -= 32) {
                        ctx.strokeStyle = (ring === 145) ? '#D4AF37' : 'rgba(56, 189, 248, 0.45)';
                        ctx.lineWidth = 1.8;
                        ctx.beginPath();
                        for (let i = 0; i < 24; i++) {
                          const angle = (i * Math.PI) / 12;
                          const r = (i % 2 === 0) ? ring : ring * 0.62;
                          const x = cx + r * Math.cos(angle);
                          const y = cy + r * Math.sin(angle);
                          if (i === 0) ctx.moveTo(x, y);
                          else ctx.lineTo(x, y);
                        }
                        ctx.closePath();
                        ctx.stroke();
                      }
                      ctx.fillStyle = '#FDE68A';
                      ctx.font = 'bold 12px Segoe UI, sans-serif';
                      ctx.fillText('TAWḤĪD & IḤSĀN', cx - 48, cy + 4);

                      // Draw the 7 Dimensions on the right connected to the rosette center
                      const dims = [
                        { label: '1. Jamāl At-Tawḥīd & Al-Asmā\\' Al-Ḥusnā (99 Names of Beauty & Mercy)', color: '#10B981', y: 48 },
                        { label: '2. Jamāl Al-Qur\\'ān (Aḥsana Al-Ḥadīth 39:23 — Acoustic & Calligraphic Symphony)', color: '#D4AF37', y: 98 },
                        { label: '3. Jamāl Al-Iḥsān (Sahih Muslim 8 — Worshipping Allah as Though You See Him)', color: '#38BDF8', y: 148 },
                        { label: '4. Jamāl Al-Akhlāq (Ṣabr Jamīl 12:18, Ṣafḥ Jamīl 15:85, Hijr Jamīl 73:10)', color: '#A855F7', y: 198 },
                        { label: '5. Jamāl Al-\\'Umrān (Girih Geometry, Muqarnas Light & Chahār Bāgh Courtyards)', color: '#F43F5E', y: 248 },
                        { label: '6. Jamāl Al-\\'Adl wa At-Takāful (Qur\\'an 16:90 — Waqf, Zakat & Zero Usury)', color: '#F59E0B', y: 298 },
                        { label: '7. Jamāl Al-Kawn (Qur\\'an 50:6 & 67:3 — Scientific Wonder & Ecological Stewardship)', color: '#22D3EE', y: 348 }
                      ];

                      dims.forEach(d => {
                        ctx.strokeStyle = 'rgba(212,175,55,0.28)';
                        ctx.beginPath();
                        ctx.moveTo(cx + 145, cy);
                        ctx.lineTo(540, d.y + 12);
                        ctx.stroke();

                        ctx.fillStyle = 'rgba(15, 22, 38, 0.94)';
                        ctx.strokeStyle = d.color;
                        ctx.lineWidth = 2;
                        ctx.beginPath();
                        ctx.roundRect(540, d.y - 10, 750, 38, 8);
                        ctx.fill(); ctx.stroke();

                        ctx.fillStyle = d.color;
                        ctx.font = 'bold 12px Segoe UI, sans-serif';
                        ctx.fillText(d.label, 558, d.y + 14);
                      });
                    }
                    window.addEventListener('DOMContentLoaded', drawBeautyCanvas);
                  </script>
                </body>
                </html>
                """;

        return template
                .replace("__STYLES__", sharedStyles())
                .replace("__RIBBON__", buildMultiVolumeRibbon(3))
                .replace("__VOL1_FILE__", VOL1_TIMELINE_FILENAME)
                .replace("__VOL2_FILE__", VOL2_PROPERTIES_KINGDOMS_FILENAME)
                .replace("__BEAUTY_HTML__", beautyHtml.toString())
                .replace("__CHAPTERS_HTML__", chaptersHtml.toString());
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
