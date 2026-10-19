package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.IslamicCaliphatesSultansShahsAndPromiseOfReturn;
import com.sovereign.warlock.domain.IslamicCaliphatesSultansShahsAndPromiseOfReturn.CanonicalPolityEpoch;
import com.sovereign.warlock.domain.IslamicCaliphatesSultansShahsAndPromiseOfReturn.OriginJourneyAndReturnStage;
import com.sovereign.warlock.domain.IslamicCaliphatesSultansShahsAndPromiseOfReturn.PropheticGovernancePhase;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Generates the standalone interactive HTML portal:
 * {@code islamic-caliphates-sultans-shahs-dynasties-return.html} (Portal #57).
 *
 * Covers:
 * 1. The 5 Prophetic Political Phases of the Ummah (Musnad Ahmad 18406 & Sunan Abi Dawud 4646).
 * 2. The 7 Canonical Polities — Caliphates, Sultanates, Shahdoms & Dynasties: How Islam Instantiated Each
 *    (Istikhlaf & Tamkin) and How/Why Each Was Dissolved (Istibdal, Sunnat Al-Mudawalah & Ibn Khaldun's 4-Generation Cycle).
 * 3. Where Islam Came From (Alast, Millat Ibrahim, Hira'), Where It Has Gone When Empires Dissolved
 *    (The Unbroken Ark of Qur'an, Sunnah, Waqf & 2 Billion Hearts), and The Canonical Promise of Returning
 *    (Tuba lil-Ghuraba', Centennial Mujaddidun, Return of Prophetic Stewardship, Al-Mahdi & Descent of 'Isa ibn Maryam).
 */
public final class IslamicCaliphatesSultansReturnPortalGenerator {

    public static final String PORTAL_FILENAME = "islamic-caliphates-sultans-shahs-dynasties-return.html";

    private IslamicCaliphatesSultansReturnPortalGenerator() {
    }

    public static Path generatePortal(Path outputDir) throws IOException {
        Files.createDirectories(outputDir);
        Path target = outputDir.resolve(PORTAL_FILENAME);
        String html = buildHtml();
        Files.writeString(target, html, StandardCharsets.UTF_8);
        return target;
    }

    private static String buildHtml() {
        StringBuilder phasesHtml = new StringBuilder();
        for (PropheticGovernancePhase p : IslamicCaliphatesSultansShahsAndPromiseOfReturn.allFivePropheticGovernancePhases()) {
            phasesHtml.append("""
                    <div class="phase-card" style="border-top: 4px solid %s;">
                      <div class="card-header">
                        <span class="badge" style="background:%s22;color:%s;border:1px solid %s66;">PHASE #%d • %s</span>
                        <span class="era-pill">%s</span>
                      </div>
                      <h3>%s</h3>
                      <div class="hadith-box"><strong>Scriptural &amp; Prophetic Proof:</strong> %s</div>
                      <p><strong>Constitutional Character:</strong> %s</p>
                      <p class="transition-note"><strong>Historical Transition Trigger:</strong> %s</p>
                    </div>
                    """.formatted(
                    p.hexAccentColor(),
                    p.hexAccentColor(), p.hexAccentColor(), p.hexAccentColor(),
                    p.phaseIndex(), escapeHtml(p.phaseCode()),
                    escapeHtml(p.historicalEraAndPolities()),
                    escapeHtml(p.arabicAndEnglishTitle()),
                    escapeHtml(p.hadithAndQuranicText()),
                    escapeHtml(p.constitutionalCharacter()),
                    escapeHtml(p.transitionTriggerToNextPhase())
            ));
        }

        StringBuilder politiesHtml = new StringBuilder();
        for (CanonicalPolityEpoch e : IslamicCaliphatesSultansShahsAndPromiseOfReturn.allSevenCanonicalPolityEpochs()) {
            politiesHtml.append("""
                    <div class="polity-card" data-polity="%d" style="border-left: 5px solid %s;">
                      <div class="card-header">
                        <span class="badge" style="background:%s22;color:%s;border:1px solid %s66;">POLITY #%d • %s</span>
                        <span class="era-pill">%s</span>
                      </div>
                      <h3>%s</h3>
                      <div class="rulers-line"><strong>Key Dynasties, Caliphs, Sultans &amp; Shahs:</strong> %s</div>
                      <div class="dual-columns">
                        <div class="instantiated-box">
                          <h4>✦ How Islam Instantiated It (Al-Istikhlāf &amp; At-Tamkīn)</h4>
                          <p>%s</p>
                          <p style="margin-top:0.55rem;"><strong>Civilizational Pinnacle &amp; Legacy:</strong> %s</p>
                        </div>
                        <div class="dissolved-box">
                          <h4>⚔ How &amp; Why It Was Dissolved (Al-Istibdāl &amp; Sunnat Al-Mudāwalah)</h4>
                          <p>%s</p>
                          <p style="margin-top:0.55rem;"><strong>Canonical &amp; Khaldūnian Law Anchor:</strong> <em>%s</em></p>
                        </div>
                      </div>
                    </div>
                    """.formatted(
                    e.polityIndex(),
                    e.hexColor(),
                    e.hexColor(), e.hexColor(), e.hexColor(),
                    e.polityIndex(), escapeHtml(e.polityCode()),
                    escapeHtml(e.chronologicalSpanAndCapitals()),
                    escapeHtml(e.titleAndRulingTitle()),
                    escapeHtml(e.majorDynastiesAndRulers()),
                    escapeHtml(e.canonicalInstantiationMechanism()),
                    escapeHtml(e.civilizationalPinnacleAndLegacy()),
                    escapeHtml(e.canonicalDissolutionCauses()),
                    escapeHtml(e.quranicAndKhaldunianLawAnchor())
            ));
        }

        StringBuilder stagesHtml = new StringBuilder();
        for (OriginJourneyAndReturnStage s : IslamicCaliphatesSultansShahsAndPromiseOfReturn.allSevenOriginJourneyAndReturnStages()) {
            stagesHtml.append("""
                    <div class="stage-card" style="border-left: 5px solid %s;">
                      <div class="card-header">
                        <span class="badge" style="background:%s22;color:%s;border:1px solid %s66;">STAGE #%d • %s</span>
                        <span class="era-pill">%s</span>
                      </div>
                      <h3>%s</h3>
                      <div class="hadith-box"><strong>Primary Qur'anic &amp; Hadith Proofs:</strong> %s</div>
                      <p>%s</p>
                      <div class="guarantee-box"><strong>Enduring Guarantee for the Believer:</strong> %s</div>
                    </div>
                    """.formatted(
                    s.hexBadgeColor(),
                    s.hexBadgeColor(), s.hexBadgeColor(), s.hexBadgeColor(),
                    s.stageIndex(), escapeHtml(s.stageCode()),
                    escapeHtml(s.temporalAndMetaphysicalHorizon()),
                    escapeHtml(s.arabicAndEnglishStageTitle()),
                    escapeHtml(s.primaryScripturalAndHadithProofs()),
                    escapeHtml(s.theologicalAndHistoricalExegesis()),
                    escapeHtml(s.enduringGuaranteeForTheBeliever())
            ));
        }

        String template = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <title>Caliphates, Sultans, Shahs &amp; Dynasties Instantiated &amp; Dissolved by Islam | Origin, Journey &amp; Promise of Return</title>
                  <style>
                    :root {
                      --bg-deep: #070A12;
                      --bg-card: #101624;
                      --bg-card-alt: #161F33;
                      --gold: #D4AF37;
                      --emerald: #10B981;
                      --cyan: #38BDF8;
                      --rose: #F43F5E;
                      --purple: #A855F7;
                      --text-main: #F1F5F9;
                      --text-muted: #94A3B8;
                      --border-subtle: rgba(212, 175, 55, 0.22);
                    }
                    * { box-sizing: border-box; margin: 0; padding: 0; }
                    body {
                      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
                      background: radial-gradient(circle at 20% 0%, #13233F 0%, var(--bg-deep) 65%);
                      color: var(--text-main);
                      line-height: 1.68;
                      padding-bottom: 5rem;
                    }
                    .container {
                      max-width: 1400px;
                      margin: 0 auto;
                      padding: 2rem 1.5rem;
                    }
                    .hero {
                      background: linear-gradient(135deg, rgba(16, 22, 36, 0.96) 0%, rgba(16, 185, 129, 0.14) 55%, rgba(212, 175, 55, 0.16) 100%);
                      border: 1px solid var(--gold);
                      border-left: 8px solid var(--gold);
                      border-radius: 16px;
                      padding: 2.4rem;
                      margin-bottom: 2.2rem;
                      box-shadow: 0 20px 50px rgba(0,0,0,0.55);
                    }
                    .hero-badges {
                      display: flex;
                      flex-wrap: wrap;
                      gap: 0.55rem;
                      margin-bottom: 1rem;
                    }
                    .badge {
                      font-family: 'Consolas', monospace;
                      font-size: 0.76rem;
                      font-weight: 700;
                      padding: 0.28rem 0.7rem;
                      border-radius: 999px;
                      letter-spacing: 0.04em;
                    }
                    .hero h1 {
                      font-size: 2.25rem;
                      color: #FFF;
                      margin-bottom: 0.65rem;
                      line-height: 1.22;
                    }
                    .hero-arabic {
                      font-size: 1.35rem;
                      color: #FDE68A;
                      margin-bottom: 1rem;
                      font-weight: 600;
                    }
                    .quran-banner {
                      background: rgba(7, 10, 18, 0.82);
                      border: 1px solid rgba(212, 175, 55, 0.4);
                      border-left: 4px solid var(--emerald);
                      border-radius: 10px;
                      padding: 1.15rem 1.4rem;
                      margin-top: 1.2rem;
                      font-size: 0.98rem;
                      color: #E2E8F0;
                    }
                    .section-title {
                      font-size: 1.6rem;
                      color: var(--gold);
                      margin: 2.5rem 0 0.6rem 0;
                      border-bottom: 2px solid var(--border-subtle);
                      padding-bottom: 0.5rem;
                      display: flex;
                      align-items: center;
                      justify-content: space-between;
                      flex-wrap: wrap;
                      gap: 0.5rem;
                    }
                    .section-subtitle {
                      color: var(--text-muted);
                      margin-bottom: 1.5rem;
                      font-size: 1rem;
                    }
                    .canvas-panel {
                      background: var(--bg-card);
                      border: 1px solid var(--border-subtle);
                      border-radius: 14px;
                      padding: 1.5rem;
                      margin-bottom: 2.2rem;
                    }
                    .canvas-controls {
                      display: flex;
                      flex-wrap: wrap;
                      gap: 0.6rem;
                      margin-bottom: 1rem;
                      align-items: center;
                    }
                    .btn {
                      background: var(--bg-card-alt);
                      color: var(--text-main);
                      border: 1px solid var(--border-subtle);
                      padding: 0.48rem 0.95rem;
                      border-radius: 8px;
                      cursor: pointer;
                      font-size: 0.84rem;
                      font-weight: 600;
                      transition: all 0.18s ease;
                    }
                    .btn:hover, .btn.active {
                      background: rgba(212, 175, 55, 0.22);
                      border-color: var(--gold);
                      color: #FFF;
                    }
                    canvas {
                      width: 100%;
                      height: 430px;
                      background: #060911;
                      border-radius: 10px;
                      border: 1px solid rgba(255,255,255,0.08);
                      display: block;
                    }
                    .phases-grid {
                      display: grid;
                      grid-template-columns: repeat(auto-fit, minmax(380px, 1fr));
                      gap: 1.35rem;
                      margin-bottom: 2.2rem;
                    }
                    .phase-card, .polity-card, .stage-card {
                      background: var(--bg-card);
                      border: 1px solid rgba(255,255,255,0.1);
                      border-radius: 13px;
                      padding: 1.55rem;
                      box-shadow: 0 10px 28px rgba(0,0,0,0.35);
                    }
                    .polity-card, .stage-card {
                      margin-bottom: 1.35rem;
                    }
                    .card-header {
                      display: flex;
                      justify-content: space-between;
                      align-items: center;
                      flex-wrap: wrap;
                      gap: 0.5rem;
                      margin-bottom: 0.75rem;
                    }
                    .era-pill {
                      font-family: 'Consolas', monospace;
                      font-size: 0.78rem;
                      color: #A5F3FC;
                      background: rgba(56, 189, 248, 0.1);
                      padding: 0.22rem 0.6rem;
                      border-radius: 6px;
                    }
                    h3 {
                      font-size: 1.26rem;
                      color: #FFF;
                      margin-bottom: 0.75rem;
                    }
                    .hadith-box {
                      background: rgba(212, 175, 55, 0.08);
                      border-left: 3px solid var(--gold);
                      padding: 0.75rem 1rem;
                      border-radius: 0 8px 8px 0;
                      margin-bottom: 0.85rem;
                      font-size: 0.93rem;
                      color: #FDE68A;
                    }
                    .rulers-line {
                      background: rgba(255,255,255,0.04);
                      padding: 0.65rem 0.95rem;
                      border-radius: 8px;
                      margin-bottom: 1rem;
                      font-size: 0.92rem;
                      color: #CBD5E1;
                    }
                    .dual-columns {
                      display: grid;
                      grid-template-columns: repeat(auto-fit, minmax(320px, 1fr));
                      gap: 1.15rem;
                    }
                    .instantiated-box {
                      background: rgba(16, 185, 129, 0.07);
                      border: 1px solid rgba(16, 185, 129, 0.3);
                      border-radius: 10px;
                      padding: 1.1rem;
                    }
                    .instantiated-box h4 {
                      color: #34D399;
                      margin-bottom: 0.5rem;
                      font-size: 1rem;
                    }
                    .dissolved-box {
                      background: rgba(244, 63, 94, 0.07);
                      border: 1px solid rgba(244, 63, 94, 0.3);
                      border-radius: 10px;
                      padding: 1.1rem;
                    }
                    .dissolved-box h4 {
                      color: #FB7185;
                      margin-bottom: 0.5rem;
                      font-size: 1rem;
                    }
                    .transition-note {
                      margin-top: 0.7rem;
                      padding-top: 0.65rem;
                      border-top: 1px dashed rgba(255,255,255,0.12);
                      font-size: 0.9rem;
                      color: #93C5FD;
                    }
                    .guarantee-box {
                      margin-top: 0.85rem;
                      background: rgba(16, 185, 129, 0.1);
                      border-left: 3px solid #10B981;
                      padding: 0.7rem 1rem;
                      border-radius: 0 8px 8px 0;
                      color: #A7F3D0;
                      font-size: 0.94rem;
                    }
                    .khaldun-grid {
                      display: grid;
                      grid-template-columns: repeat(auto-fit, minmax(260px, 1fr));
                      gap: 1rem;
                      margin: 1.25rem 0 2rem 0;
                    }
                    .khaldun-step {
                      background: var(--bg-card-alt);
                      border: 1px solid var(--border-subtle);
                      border-radius: 10px;
                      padding: 1.15rem;
                    }
                    .khaldun-step h4 {
                      color: var(--gold);
                      margin-bottom: 0.4rem;
                    }
                    .summary-table-wrap {
                      overflow-x: auto;
                      background: var(--bg-card);
                      border: 1px solid var(--border-subtle);
                      border-radius: 12px;
                      padding: 1.25rem;
                      margin-top: 1.5rem;
                    }
                    table {
                      width: 100%;
                      border-collapse: collapse;
                      font-size: 0.88rem;
                    }
                    th, td {
                      text-align: left;
                      padding: 0.75rem 0.65rem;
                      border-bottom: 1px solid rgba(255,255,255,0.08);
                      vertical-align: top;
                    }
                    th {
                      color: var(--gold);
                      font-size: 0.78rem;
                      text-transform: uppercase;
                      letter-spacing: 0.05em;
                    }
                  </style>
                </head>
                <body>
                  <div class="container">
                    <section class="hero">
                      <div class="hero-badges">
                        <span class="badge" style="background:rgba(212,175,55,0.2);color:#FDE68A;border:1px solid #D4AF37;">PORTAL #57 • SOVEREIGN HISTORICAL &amp; ESCHATOLOGICAL ATLAS</span>
                        <span class="badge" style="background:rgba(16,185,129,0.2);color:#6EE7B7;border:1px solid #10B981;">QUR'AN 3:26 • 24:55 • 47:38 • 15:9</span>
                        <span class="badge" style="background:rgba(56,189,248,0.2);color:#7DD3FC;border:1px solid #38BDF8;">MUSNAD AḤMAD 18406 • SAHIH MUSLIM 145</span>
                        <span class="badge" style="background:rgba(244,63,94,0.2);color:#FDA4AF;border:1px solid #F43F5E;">IBN KHALDŪN 4-GENERATION 'AṢABIYYAH LAW</span>
                      </div>
                      <h1>The Caliphates, the Sultans, the Shahs &amp; the Dynasties: Instantiated &amp; Dissolved by Islam — Where This Religion Came From, Where It Has Gone &amp; The Promise of Returning</h1>
                      <div class="hero-arabic">الخِلَافَاتُ وَالسَّلْطَنَاتُ وَالشَّاهَاتُ وَالدُّوَلُ: سُنَّةُ الاسْتِخْلَافِ وَالاسْتِبْدَالِ، مِنْ أَيْنَ بَدَأَ الإِسْلَامُ وَإِلَى أَيْنَ وَصَلَ وَوَعْدُ العَوْدَةِ عَلَى مِنْهَاجِ النُّبُوَّةِ</div>
                      <p style="color:#CBD5E1;font-size:1.03rem;">
                        In canonical Islamic theology and historiography, <strong>Islam is never identical to any mortal dynasty</strong>.
                        Empires, Caliphates (<em>Al-Khilāfah</em>), Sultanates (<em>As-Salṭanah</em>), and Shahdoms (<em>Ash-Shāhanshāhiyyah / Pādishāhī</em>)
                        are <strong>instantiated by Islam</strong> when a community upholds <em>Tawḥīd</em>, <em>'Adl</em> (justice), <em>Shūrā</em> (consultation),
                        and <em>'Amal Ṣāliḥ</em> (righteous stewardship, <strong>Qur'an 24:55</strong>)—and they are <strong>dissolved by Allah's Sunnah in history</strong>
                        (<em>Sunnat Al-Istibdāl wa Al-Mudāwalah</em>, <strong>Qur'an 3:26, 3:140, 47:38</strong>) when rulers slide into hereditary arrogance,
                        tribal factionalism (<em>'Aṣabiyyah</em>), fiscal oppression (<em>Mukūs</em>), and heedlessness (<em>Al-Wahn</em>). Yet when every throne
                        fell, <strong>Islam itself never dissolved</strong>—and the Prophet ﷺ left an explicit, canonical promise of how it began, where it travels,
                        and how it returns.
                      </p>
                      <div class="quran-banner">
                        <strong>The Supreme Qur'anic Law of Sovereignty (Qur'an 3:26):</strong><br>
                        <em>«قُلِ اللَّهُمَّ مَالِكَ الْمُلْكِ تُؤْتِي الْمُلْكَ مَن تَشَاءُ وَتَنزِعُ الْمُلْكَ مِمَّن تَشَاءُ وَتُعِزُّ مَن تَشَاءُ وَتُذِلُّ مَن تَشَاءُ ۖ بِيَدِكَ الْخَيْرُ ۖ إِنَّكَ عَلَىٰ كُلِّ شَيْءٍ قَدِيرٌ»</em><br>
                        "Say: 'O Allah, Owner of Sovereignty (<em>Mālik Al-Mulk</em>), You give sovereignty to whom You will, and You strip sovereignty from whom You will; You honor whom You will, and You humble whom You will. In Your Hand is all good. Indeed, You have power over all things.'"
                      </div>
                    </section>

                    <div class="canvas-panel">
                      <h2 style="color:var(--gold);margin-bottom:0.4rem;">Interactive 2.5D Trajectory: The Rise &amp; Dissolution of Polities vs. The Unbroken Ark of Islam (610 CE – Promise of Return)</h2>
                      <p style="color:var(--text-muted);font-size:0.92rem;margin-bottom:0.9rem;">
                        Explore how individual Caliphates, Sultanates, and Shahdoms rose and dissolved along Ibn Khaldūn's <em>'Aṣabiyyah</em> wave while the
                        <strong>Golden Ark of the Qur'an, Sunnah, Waqf, and Ummah</strong> rose continuously from a single cave in Mecca to 2 Billion souls and the promised return of Prophetic Stewardship.
                      </p>
                      <div class="canvas-controls">
                        <button class="btn active" onclick="setPolityFocus(0, this)">All 7 Polities + Unbroken Ark</button>
                        <button class="btn" onclick="setPolityFocus(1, this)">1. Rāshidūn (632–661)</button>
                        <button class="btn" onclick="setPolityFocus(2, this)">2. Umayyads (661–1031)</button>
                        <button class="btn" onclick="setPolityFocus(3, this)">3. Abbasids (750–1517)</button>
                        <button class="btn" onclick="setPolityFocus(4, this)">4. Maghreb &amp; Africa</button>
                        <button class="btn" onclick="setPolityFocus(5, this)">5. Sunni Sultanates</button>
                        <button class="btn" onclick="setPolityFocus(6, this)">6. Ottomans (1299–1924)</button>
                        <button class="btn" onclick="setPolityFocus(7, this)">7. Persian/Mughal Shahs</button>
                      </div>
                      <canvas id="polityCanvas" width="1320" height="430"></canvas>
                    </div>

                    <h2 class="section-title">
                      <span>I. The 5 Canonical Political Phases of History (Hadith of Ḥudhayfah — Musnad Aḥmad 18406)</span>
                      <span class="badge" style="background:rgba(16,185,129,0.18);color:#6EE7B7;">PROPHETIC TIMELINE OF SOVEREIGNTY</span>
                    </h2>
                    <p class="section-subtitle">
                      Fourteen centuries ago, the Prophet Muhammad ﷺ mapped the entire political trajectory of the Muslim Ummah from his own lifetime through the hereditary dynasties and modern coercive regimes to the promised return of Prophetic stewardship.
                    </p>
                    <div class="phases-grid">
                      __PHASES_CARDS__
                    </div>

                    <h2 class="section-title">
                      <span>II. Ibn Khaldūn's Canonical 4-Generation Law of Dynastic Instantiation &amp; Dissolution</span>
                      <span class="badge" style="background:rgba(212,175,55,0.18);color:#FDE68A;">AL-MUQADDIMAH • CHAPTER III</span>
                    </h2>
                    <p class="section-subtitle">
                      In his <em>Muqaddimah</em> (1377 CE), the supreme Islamic historian and jurist <strong>'Abd ar-Raḥmān Ibn Khaldūn</strong> demonstrated why every dynastic Caliphate, Sultanate, and Shahdom after the Rāshidūn naturally passes through four generations (~120 years) unless renewed by fresh faith and justice:
                    </p>
                    <div class="khaldun-grid">
                      <div class="khaldun-step">
                        <h4>1st Generation: The Frontier Builder (Al-Bānī)</h4>
                        <p>Forged in desert or mountain austerity with high moral cohesion (<em>'Aṣabiyyah</em>) and religious zeal (<em>Ṣibghah Dīniyyah</em>). The ruler shares hardships with the people and obeys the Sharia strictly.</p>
                      </div>
                      <div class="khaldun-step">
                        <h4>2nd Generation: The Royal Consolidator (Al-Mustabidd)</h4>
                        <p>Moves from frontier tents into walled palaces; monopolizes glory, replaces original companions with salaried mercenaries or slave-guards (<em>Mamlūks/Ghilmān</em>), yet retains respect for the founder's discipline.</p>
                      </div>
                      <div class="khaldun-step">
                        <h4>3rd Generation: The Urban Luxury Imitator (Al-Muqallid)</h4>
                        <p>Forgets frontier toughness; immerses in palatial architecture, silk, and courtly pageantry; imposes non-canonical customs taxes (<em>Mukūs</em>) that crush merchants and farmers while military courage fades.</p>
                      </div>
                      <div class="khaldun-step">
                        <h4>4th Generation: The Effete Squanderer (Al-Hādim)</h4>
                        <p>Believes royal privilege is an inherited birthright requiringneither virtue nor effort; despises righteous advisors, fractures into succession civil wars, and is swept away by Allah's law of <em>Istibdāl</em> (replacement).</p>
                      </div>
                    </div>

                    <h2 class="section-title">
                      <span>III. The 7 Canonical Polities: Caliphates, Sultanates, Shahs &amp; Dynasties — Instantiated &amp; Dissolved</span>
                      <span class="badge" style="background:rgba(56,189,248,0.18);color:#7DD3FC;">7 CIVILIZATIONAL POLITY ARCHETYPES</span>
                    </h2>
                    <p class="section-subtitle">
                      How each major Islamic political order—from the 30-year <em>Rāshidūn</em> Caliphate to the Umayyads, Abbasids, Maghrebi/African Dynasties, Sunni Sultanates, Ottoman Caliphate, and Persianate/Mughal Shahdoms—was canonically instantiated and why each dissolved.
                    </p>
                    <div id="politiesContainer">
                      __POLITIES_CARDS__
                    </div>

                    <h2 class="section-title">
                      <span>IV. Where Has This Religion Come From, Where Has It Gone &amp; The Promise of Returning</span>
                      <span class="badge" style="background:rgba(244,63,94,0.18);color:#FDA4AF;">MIN AYNA BADĀ' • ILĀ AYNA WAṢAL • WA'D AL-'AWDAH</span>
                    </h2>
                    <p class="section-subtitle">
                      When the Abbasid Caliphate fell in 1258, when Granada fell in 1492, when Mughal Delhi fell in 1857, and when the Ottoman Caliphate was abolished in 1924, critics assumed Islam itself would dissolve. Here is the canonical 7-stage answer to where Islam came from, where it went when thrones fell, and its promised return.
                    </p>
                    <div>
                      __STAGES_CARDS__
                    </div>

                    <div class="summary-table-wrap">
                      <h3 style="color:var(--gold);margin-bottom:0.8rem;">Master Comparative Ledger: Titles of Sovereignty in Islamic History</h3>
                      <table>
                        <thead>
                          <tr>
                            <th>Sovereign Title</th>
                            <th>Arabic / Persian Etymology</th>
                            <th>Canonical Meaning &amp; Constitutional Basis</th>
                            <th>Historical Bearers</th>
                            <th>Why It Dissolved While Islam Remained</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td><strong>Khalīfah / Amīr Al-Mu'minīn</strong></td>
                            <td>خَلِيفَة / أَمِيرُ المُؤْمِنِين</td>
                            <td>Successor to the Messenger of Allah ﷺ in guarding the Dīn and administering worldly justice (Qur'an 2:30, 24:55).</td>
                            <td>4 Rāshidūn + Al-Ḥasan (632–661), Umayyads (661–750 / Cordoba 929–1031), Abbasids (750–1517), Ottomans (1517–1924), Sokoto (1804–1903).</td>
                            <td>Transitioned from Shūrā to dynastic succession (Mulk 'Āḍḍ), then dissolved under internal fragmentation and modern nation-state partition (1924).</td>
                          </tr>
                          <tr>
                            <td><strong>As-Sulṭān</strong></td>
                            <td>السُّلْطَان (Proof / Authorized Power)</td>
                            <td>Temporal military-executive custodian who defends Dār Al-Islām and enforces Sharia rulings in symbiosis with the 'Ulamā' (Al-Māwardī &amp; Al-Ghazālī).</td>
                            <td>Ghaznavids, Great Seljuks, Ayyubids (Ṣalāḥ ad-Dīn), Mamluks, Delhi Sultanates, Ottomans, Morocco, Aceh/Malacca/Mataram/Brunei.</td>
                            <td>Military succession crises and European maritime/industrial dominance ended most Sultanates, though Sultanates endure in Brunei, Oman, and Malaysian states.</td>
                          </tr>
                          <tr>
                            <td><strong>Shāh / Pādishāh / Bādshāh</strong></td>
                            <td>شَاه / بَادِشَاه (Persianate Monarch)</td>
                            <td>Pre-Islamic Indo-Iranian royal title Islamized as a temporal ruler subordinate to divine law (forbidding the polytheistic claim 'King of Kings' in rivalry with Allah, Bukhari 6205).</td>
                            <td>Khwarazmshahs, Timurids, Safavid/Qajar Shahs of Iran, Mughal Bādshāhs of India (Babur to Aurangzeb &amp; Bahadur Shah Zafar).</td>
                            <td>Dissolved through court extravagance, succession wars, British East India Company colonization (1857), and modern revolutions (1979).</td>
                          </tr>
                          <tr>
                            <td><strong>Al-Ummah &amp; Al-Ghurabā'</strong></td>
                            <td>الأُمَّةُ وَالغُرَبَاءُ</td>
                            <td>The indestructible community of believers, scholars ('Ulamā'), Huffāẓ, families, and Renewers (Mujaddidūn) anchored directly to Allah's Book (Qur'an 15:9).</td>
                            <td>From the first companions in Cave Ḥirā' to ~2.0 Billion Muslims across every continent today, culminating in Al-Mahdī &amp; 'Īsā ibn Maryam.</td>
                            <td><strong>NEVER DISSOLVED:</strong> Protected by Allah's direct covenant (Qur'an 15:9 &amp; Sahih Muslim 145/2889) until the final Hour.</td>
                          </tr>
                        </tbody>
                      </table>
                    </div>
                  </div>

                  <script>
                    let selectedPolity = 0;
                    function setPolityFocus(idx, btn) {
                      selectedPolity = idx;
                      document.querySelectorAll('.canvas-controls .btn').forEach(b => b.classList.remove('active'));
                      if (btn) btn.classList.add('active');
                      drawPolityCanvas();
                    }

                    function drawPolityCanvas() {
                      const canvas = document.getElementById('polityCanvas');
                      if (!canvas) return;
                      const ctx = canvas.getContext('2d');
                      const W = canvas.width;
                      const H = canvas.height;
                      ctx.clearRect(0, 0, W, H);

                      // Background grid
                      ctx.strokeStyle = 'rgba(212, 175, 55, 0.09)';
                      ctx.lineWidth = 1;
                      for (let x = 60; x < W - 30; x += 90) {
                        ctx.beginPath();
                        ctx.moveTo(x, 30);
                        ctx.lineTo(x, H - 45);
                        ctx.stroke();
                      }
                      for (let y = 50; y < H - 40; y += 60) {
                        ctx.beginPath();
                        ctx.moveTo(60, y);
                        ctx.lineTo(W - 30, y);
                        ctx.stroke();
                      }

                      // Time axis labels
                      const years = [
                        { x: 75, label: '610 CE (Ḥirā\\')' },
                        { x: 185, label: '632–661 (Rāshidūn)' },
                        { x: 330, label: '750 (Umayyad/Abbasid)' },
                        { x: 520, label: '1071–1260 (Sultanates)' },
                        { x: 710, label: '1453–1683 (Ottoman/Mughal)' },
                        { x: 930, label: '1924 (Caliphate Dissolved)' },
                        { x: 1155, label: 'Today (2B+) → Promise of Return' }
                      ];
                      ctx.fillStyle = '#94A3B8';
                      ctx.font = '11px Consolas, monospace';
                      years.forEach(t => {
                        ctx.fillText(t.label, t.x - 25, H - 18);
                      });

                      // 1. Draw the Unbroken Golden Ark of Islam (Qur'an, Sunnah, Waqf, Ummah Hearts)
                      ctx.save();
                      ctx.beginPath();
                      ctx.moveTo(70, H - 70);
                      ctx.bezierCurveTo(350, H - 140, 750, 140, W - 45, 52);
                      ctx.strokeStyle = '#D4AF37';
                      ctx.lineWidth = 4;
                      ctx.shadowColor = '#D4AF37';
                      ctx.shadowBlur = 12;
                      ctx.stroke();
                      ctx.restore();

                      ctx.fillStyle = '#FDE68A';
                      ctx.font = 'bold 12px Segoe UI, sans-serif';
                      ctx.fillText('✦ THE UNBROKEN ARK OF ISLAM (Qur\\'an 15:9, Sunnah, Waqf & 2B+ Hearts — Never Dissolved)', 640, 42);

                      // 2. Draw the 7 Polity Rise & Dissolution Arcs (Ibn Khaldun Curves)
                      const arcs = [
                        { id: 1, name: '1. Rāshidūn (632–661)', startX: 130, peakX: 185, endX: 235, peakY: 115, color: '#10B981' },
                        { id: 2, name: '2. Umayyads (661–1031)', startX: 220, peakX: 305, endX: 465, peakY: 145, color: '#D4AF37' },
                        { id: 3, name: '3. Abbasids (750–1258/1517)', startX: 310, peakX: 455, endX: 685, peakY: 105, color: '#38BDF8' },
                        { id: 4, name: '4. Maghreb & African Dynasties', startX: 350, peakX: 560, endX: 860, peakY: 165, color: '#A855F7' },
                        { id: 5, name: '5. Great Sunni Sultanates', startX: 460, peakX: 600, endX: 830, peakY: 130, color: '#F43F5E' },
                        { id: 6, name: '6. Ottoman Caliphate (1299–1924)', startX: 590, peakX: 760, endX: 950, peakY: 95, color: '#F59E0B' },
                        { id: 7, name: '7. Persian & Mughal Shahs (1501–1857)', startX: 660, peakX: 790, endX: 910, peakY: 150, color: '#22D3EE' }
                      ];

                      const baseY = H - 55;
                      arcs.forEach(a => {
                        const isFocused = (selectedPolity === 0 || selectedPolity === a.id);
                        ctx.save();
                        ctx.beginPath();
                        ctx.moveTo(a.startX, baseY);
                        ctx.quadraticCurveTo(a.peakX, a.peakY - 70, a.endX, baseY);
                        ctx.strokeStyle = a.color;
                        ctx.globalAlpha = isFocused ? 0.95 : 0.18;
                        ctx.lineWidth = (selectedPolity === a.id) ? 4 : 2.4;
                        ctx.stroke();

                        // Fill under curve
                        ctx.lineTo(a.startX, baseY);
                        ctx.closePath();
                        ctx.fillStyle = a.color;
                        ctx.globalAlpha = (selectedPolity === a.id) ? 0.22 : (selectedPolity === 0 ? 0.08 : 0.02);
                        ctx.fill();

                        if (isFocused) {
                          ctx.globalAlpha = 1;
                          ctx.fillStyle = a.color;
                          ctx.beginPath();
                          ctx.arc(a.peakX, (baseY + a.peakY - 70) / 2, 5, 0, Math.PI * 2);
                          ctx.fill();
                          ctx.font = 'bold 11px Segoe UI, sans-serif';
                          ctx.fillText(a.name, a.peakX - 55, (baseY + a.peakY - 70) / 2 - 10);
                        }
                        ctx.restore();
                      });

                      // 3. Draw the 5th Phase Promise of Return Beacon on the right
                      ctx.save();
                      const rx = W - 125;
                      const ry = 85;
                      ctx.fillStyle = 'rgba(16, 185, 129, 0.16)';
                      ctx.strokeStyle = '#10B981';
                      ctx.lineWidth = 2;
                      ctx.beginPath();
                      ctx.roundRect(rx - 95, ry, 200, 95, 10);
                      ctx.fill();
                      ctx.stroke();

                      ctx.fillStyle = '#6EE7B7';
                      ctx.font = 'bold 12px Segoe UI, sans-serif';
                      ctx.fillText('PHASE 5: PROMISE OF RETURN', rx - 82, ry + 24);
                      ctx.fillStyle = '#E2E8F0';
                      ctx.font = '11px Segoe UI, sans-serif';
                      ctx.fillText('• Ṭūbā lil-Ghurabā\\' (Muslim 145)', rx - 82, ry + 44);
                      ctx.fillText('• Khilāfah \\'alā Minhāj An-Nubuwwah', rx - 82, ry + 62);
                      ctx.fillText('• Al-Mahdī & \\'Īsā ibn Maryam', rx - 82, ry + 80);
                      ctx.restore();
                    }

                    window.addEventListener('DOMContentLoaded', drawPolityCanvas);
                  </script>
                </body>
                </html>
                """;

        return template
                .replace("__PHASES_CARDS__", phasesHtml.toString())
                .replace("__POLITIES_CARDS__", politiesHtml.toString())
                .replace("__STAGES_CARDS__", stagesHtml.toString());
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
