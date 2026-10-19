package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.IslamicConquestMovementsPinnaclesAndRecessionsAtlas;
import com.sovereign.warlock.domain.IslamicConquestMovementsPinnaclesAndRecessionsAtlas.CanonicalMuslimMovementDossier;
import com.sovereign.warlock.domain.IslamicConquestMovementsPinnaclesAndRecessionsAtlas.ChronologicalEraSimulationState;
import com.sovereign.warlock.domain.IslamicConquestMovementsPinnaclesAndRecessionsAtlas.DirectionalCompassMovementAxis;
import com.sovereign.warlock.domain.IslamicConquestMovementsPinnaclesAndRecessionsAtlas.PinnacleAndRecessionPairDossier;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.List;

/**
 * Generates Portal #67 (islamic-conquest-caliphates-movements-pinnacles-and-recessions-interactive.html):
 * AI-Powered Interactive Chronological Simulator of Every Era of Islamic Conquest, Caliphate,
 * Canonical Muslim Movement (East, West, North & South), Civilizational Pinnacles, and Recessions
 * & Rebirths As They Happen (610 CE – 2026 CE), featuring 5 Interactive AI & Procedural Engines:
 *   1) 16-Era As-They-Happen Map, Caravan/Monsoon Route Animator & 12 Battle Telemetry Beacons
 *   2) Ibn Khaldun 6-Slider Civilizational Pinnacle vs. Recession Radar Engine (Sunnat Al-Tadawul)
 *   3) 8-Scenario Interactive Historical Turning-Point Wargame & Decision Simulator
 *   4) Interactive Caravan (Qafilah) & Monsoon Dhow (Sanbuq) Expedition Planner across N/S/E/W
 *   5) AI Majlis Al-Hikmah Multi-Scholar Interactive Inquiry & Synthesis Console
 */
public final class IslamicConquestMovementsPinnaclesAndRecessionsPortalGenerator {

    public static final String PORTAL_FILE_NAME =
            "islamic-conquest-caliphates-movements-pinnacles-and-recessions-interactive.html";

    public WarlockHtmlPortalService.GeneratedHtmlArtifact generatePortal(Path outputDir) {
        try {
            Files.createDirectories(outputDir);
            String html = buildPortalHtml();
            Path filePath = outputDir.resolve(PORTAL_FILE_NAME);
            Files.writeString(filePath, html, StandardCharsets.UTF_8);
            return new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                    PORTAL_FILE_NAME,
                    filePath,
                    Files.size(filePath),
                    sha256(html),
                    "Portal #67: AI-Powered 5-Engine Interactive Simulator of Every Era of Islamic Conquest, Caliphate, Canonical Muslim Movement (East, West, North & South), Pinnacles, Recessions, Wargame Turning Points, Caravan/Dhow Expeditions & Majlis AI Oracle"
            );
        } catch (IOException e) {
            throw new IllegalStateException("Failed generating Portal #67 (" + PORTAL_FILE_NAME + ")", e);
        }
    }

    private String buildPortalHtml() {
        List<ChronologicalEraSimulationState> eras =
                IslamicConquestMovementsPinnaclesAndRecessionsAtlas.allSixteenAsTheyHappenEras();
        List<DirectionalCompassMovementAxis> axes =
                IslamicConquestMovementsPinnaclesAndRecessionsAtlas.allFourDirectionalMovementAxes();
        List<CanonicalMuslimMovementDossier> movements =
                IslamicConquestMovementsPinnaclesAndRecessionsAtlas.allTenCanonicalMuslimMovements();
        List<PinnacleAndRecessionPairDossier> cycles =
                IslamicConquestMovementsPinnaclesAndRecessionsAtlas.allEightPinnacleAndRecessionCycles();

        StringBuilder eraButtonsHtml = new StringBuilder();
        StringBuilder eraPolygonsSvg = new StringBuilder();
        StringBuilder wavePointsSvg = new StringBuilder();
        StringBuilder waveNodesSvg = new StringBuilder();
        StringBuilder eraTableRowsHtml = new StringBuilder();
        StringBuilder jsErasArray = new StringBuilder();

        for (ChronologicalEraSimulationState e : eras) {
            eraButtonsHtml.append(String.format("""
                <button type="button" id="sim-era-btn-%d" class="era-pill-btn%s" onclick="selectSimEra(%d, false)">
                  <span style="color:%s;font-family:Consolas,monospace;font-weight:700;">#%02d</span> %s
                </button>
                """,
                    e.eraStep(),
                    e.eraStep() == 1 ? " active" : "",
                    e.eraStep(),
                    e.hexColor(),
                    e.eraStep(),
                    escape(e.yearRangeCe())
            ));

            String fillHex = e.hexColor().equals("#F8FAFC") ? "#38BDF8" : e.hexColor();
            eraPolygonsSvg.append(String.format("""
                <polygon id="sim-poly-%d" class="sim-era-poly" points="%s"
                         fill="%s" fill-opacity="%s" stroke="%s" stroke-width="%s"
                         style="display:%s;cursor:pointer;transition:all 0.3s ease;"
                         onclick="selectSimEra(%d, false)">
                  <title>%s: %s (%s)</title>
                </polygon>
                """,
                    e.eraStep(),
                    e.svgMapPolygonPoints(),
                    fillHex,
                    e.eraStep() == 1 ? "0.52" : "0.20",
                    e.hexColor(),
                    e.eraStep() == 1 ? "3.5" : "1.8",
                    e.eraStep() == 1 ? "block" : "none",
                    e.eraStep(),
                    escape(e.eraCode()),
                    escape(e.eraHeadline()),
                    escape(e.yearRangeCe())
            ));

            int waveX = 45 + (e.eraStep() - 1) * 56;
            int waveY = 175 - (int) Math.round(Math.min(32.0, e.estimatedTerritoryMillionKm2()) * 4.5);
            if (wavePointsSvg.length() > 0) {
                wavePointsSvg.append(" ");
            }
            wavePointsSvg.append(waveX).append(",").append(waveY);

            waveNodesSvg.append(String.format("""
                <g class="wave-node-group" onclick="selectSimEra(%d, false)" style="cursor:pointer;">
                  <circle id="wave-dot-%d" cx="%d" cy="%d" r="%s" fill="%s" stroke="#FFF" stroke-width="1.5"/>
                  <text x="%d" y="%d" text-anchor="middle" fill="#FDE68A" font-size="8.5" font-family="Consolas,monospace">#%02d</text>
                  <text x="%d" y="198" text-anchor="middle" fill="#94A3B8" font-size="7.5">%s</text>
                  <title>%s (%s) — %.1fM km² — %s</title>
                </g>
                """,
                    e.eraStep(),
                    e.eraStep(),
                    waveX, waveY,
                    e.eraStep() == 1 ? "7" : "4.8",
                    e.hexColor(),
                    waveX, waveY - 10,
                    e.eraStep(),
                    waveX,
                    escape(e.yearRangeCe().replace(" CE", "")),
                    escape(e.eraCode()),
                    escape(e.eraHeadline()),
                    e.estimatedTerritoryMillionKm2(),
                    escape(e.phaseClassification())
            ));

            eraTableRowsHtml.append(String.format("""
                <tr class="click-row" onclick="selectSimEra(%d, true)">
                  <td><span class="pill" style="border-color:%s;color:%s;">#%02d • %s</span></td>
                  <td style="font-family:Consolas,monospace;color:#FDE68A;font-weight:700;">%s<br><small style="color:#94A3B8;">%s</small></td>
                  <td><strong style="color:#FFF;">%s</strong><br><span style="color:#D4AF37;font-size:0.8rem;">%s</span></td>
                  <td><span class="pill" style="border-color:%s;color:#FFF;">%s</span><br><strong style="color:#34D399;font-family:Consolas,monospace;">%.1fM km²</strong></td>
                  <td style="font-size:0.78rem;color:#CBD5E1;">%s</td>
                  <td style="font-size:0.78rem;color:#A7F3D0;">%s</td>
                  <td style="font-size:0.78rem;color:#FDA4AF;">%s</td>
                </tr>
                """,
                    e.eraStep(),
                    e.hexColor(), e.hexColor(), e.eraStep(), escape(e.eraCode()),
                    escape(e.yearRangeCe()), escape(e.hijriRangeAh()),
                    escape(e.eraHeadline()), escape(e.arabicTitle()),
                    e.hexColor(), escape(e.phaseClassification()), e.estimatedTerritoryMillionKm2(),
                    escape(e.canonicalMovementsActive()),
                    escape(e.pinnacleAchievement()),
                    escape(e.recessionAndRebirthDynamic())
            ));

            jsErasArray.append(String.format("""
                {
                  step: %d,
                  code: "%s",
                  ce: "%s",
                  ah: "%s",
                  headline: "%s",
                  arabic: "%s",
                  phase: "%s",
                  area: "%.1f Million km²",
                  momentum: %d,
                  east: "%s",
                  west: "%s",
                  north: "%s",
                  south: "%s",
                  caliphates: "%s",
                  movements: "%s",
                  pinnacle: "%s",
                  recession: "%s",
                  anchor: "%s",
                  eastArrow: "%s",
                  westArrow: "%s",
                  northArrow: "%s",
                  southArrow: "%s",
                  color: "%s"
                },
                """,
                    e.eraStep(),
                    escapeJs(e.eraCode()),
                    escapeJs(e.yearRangeCe()),
                    escapeJs(e.hijriRangeAh()),
                    escapeJs(e.eraHeadline()),
                    escapeJs(e.arabicTitle()),
                    escapeJs(e.phaseClassification()),
                    e.estimatedTerritoryMillionKm2(),
                    e.civilizationalMomentumScore(),
                    escapeJs(e.eastVectorStatus()),
                    escapeJs(e.westVectorStatus()),
                    escapeJs(e.northVectorStatus()),
                    escapeJs(e.southVectorStatus()),
                    escapeJs(e.activeCaliphatesAndDynasties()),
                    escapeJs(e.canonicalMovementsActive()),
                    escapeJs(e.pinnacleAchievement()),
                    escapeJs(e.recessionAndRebirthDynamic()),
                    escapeJs(e.quranicAndHistoricalAnchor()),
                    escapeJs(e.svgEastArrowCoords()),
                    escapeJs(e.svgWestArrowCoords()),
                    escapeJs(e.svgNorthArrowCoords()),
                    escapeJs(e.svgSouthArrowCoords()),
                    escapeJs(e.hexColor())
            ));
        }

        StringBuilder axesHtml = new StringBuilder();
        for (DirectionalCompassMovementAxis ax : axes) {
            axesHtml.append(String.format("""
                <article class="card direction-axis-card" data-dir="%s" style="border-top:4px solid %s;">
                  <div class="badge-row">
                    <span class="pill" style="border-color:%s;color:%s;">COMPASS VECTOR: %s</span>
                    <span class="pill" style="border-color:#D4AF37;color:#FDE68A;">%s</span>
                  </div>
                  <h3>%s</h3>
                  <div class="arabic-sub">%s</div>
                  <div class="sub-box" style="border-left-color:%s;">
                    <strong style="color:#FDE68A;">🗺️ Chronological Conquest &amp; Opening Chain:</strong>
                    <p>%s</p>
                  </div>
                  <div class="sub-box" style="border-left-color:#38BDF8;">
                    <strong style="color:#38BDF8;">🕊️ Canonical Non-Dynastic Movements Along This Vector:</strong>
                    <p>%s</p>
                  </div>
                  <div class="sub-box" style="border-left-color:#10B981;">
                    <strong style="color:#34D399;">🌟 Supreme Directional Pinnacles (Al-Awj):</strong>
                    <p>%s</p>
                  </div>
                  <div class="sub-box" style="border-left-color:#F43F5E;">
                    <strong style="color:#FDA4AF;">🌊 Recessions, Frontier Shifts &amp; Rebirths (Al-Inḥisār wa Al-Inbi'āth):</strong>
                    <p>%s</p>
                  </div>
                  <p style="font-size:0.8rem;color:#94A3B8;margin-top:0.45rem;">
                    <strong style="color:#E2E8F0;">Modern Sovereign Footprint:</strong> %s
                  </p>
                </article>
                """,
                    escape(ax.directionCode()),
                    ax.hexAccent(),
                    ax.hexAccent(), ax.hexAccent(), escape(ax.directionCode()),
                    escape(ax.compassAzimuthSector()),
                    escape(ax.englishDirectionTitle()),
                    escape(ax.arabicDirectionName()),
                    ax.hexAccent(),
                    escape(ax.chronologicalConquestChain()),
                    escape(ax.canonicalNonDynasticMovements()),
                    escape(ax.supremeDirectionalPinnacle()),
                    escape(ax.majorRecessionsAndFrontierShifts()),
                    escape(ax.enduringModernFootprint())
            ));
        }

        StringBuilder movementsHtml = new StringBuilder();
        for (CanonicalMuslimMovementDossier m : movements) {
            movementsHtml.append(String.format("""
                <article class="card movement-card" data-search="%s" style="border-top:4px solid %s;">
                  <div class="badge-row">
                    <span class="pill" style="border-color:%s;color:%s;">%s</span>
                    <span class="pill" style="border-color:#38BDF8;color:#38BDF8;">%s</span>
                  </div>
                  <h3>#%02d. %s</h3>
                  <div class="arabic-sub">%s</div>
                  <p style="font-size:0.8rem;color:#FDE68A;margin-bottom:0.4rem;">
                    <strong>🧭 Directional Reach (N/S/E/W):</strong> %s
                  </p>
                  <p style="font-size:0.82rem;color:#CBD5E1;margin-bottom:0.45rem;">
                    <strong style="color:#38BDF8;">Organizational Engine &amp; Vanguard:</strong> %s
                  </p>
                  <div class="sub-box" style="border-left-color:%s;">
                    <strong style="color:#34D399;">Impact on Pinnacles &amp; Recessions:</strong>
                    <p>%s</p>
                  </div>
                  <p style="font-size:0.78rem;color:#94A3B8;margin-top:0.4rem;">
                    <strong style="color:#D4AF37;">Canonical Qur'anic &amp; Prophetic Foundation:</strong> %s
                  </p>
                </article>
                """,
                    escapeJs((m.englishMovementTitle() + " " + m.arabicMovementName() + " " + m.directionalReachNsew() + " " + m.organizationalEngineAndVanguard() + " " + m.historicalImpactOnPinnaclesAndRecessions()).toLowerCase()),
                    m.hexAccent(),
                    m.hexAccent(), m.hexAccent(), escape(m.movementCode()),
                    escape(m.chronologicalEra()),
                    m.movementIndex(), escape(m.englishMovementTitle()),
                    escape(m.arabicMovementName()),
                    escape(m.directionalReachNsew()),
                    escape(m.organizationalEngineAndVanguard()),
                    m.hexAccent(),
                    escape(m.historicalImpactOnPinnaclesAndRecessions()),
                    escape(m.quranicAndPropheticFoundation())
            ));
        }

        StringBuilder cyclesHtml = new StringBuilder();
        for (PinnacleAndRecessionPairDossier c : cycles) {
            cyclesHtml.append(String.format("""
                <article class="card cycle-card" style="border-top:4px solid %s;">
                  <div class="badge-row">
                    <span class="pill" style="border-color:%s;color:#FDE68A;">%s</span>
                    <span class="pill" style="border-color:#38BDF8;color:#38BDF8;">%s</span>
                  </div>
                  <div class="sub-box" style="border-left:4px solid %s;background:rgba(16,185,129,0.08);">
                    <strong style="color:#34D399;font-size:0.92rem;">🌟 %s</strong>
                    <p style="margin-top:0.25rem;">%s</p>
                  </div>
                  <div class="sub-box" style="border-left:4px solid %s;background:rgba(244,63,94,0.08);">
                    <strong style="color:#FDA4AF;font-size:0.92rem;">🌊 %s</strong>
                    <p style="margin-top:0.25rem;">%s</p>
                  </div>
                  <div class="sub-box" style="border-left:4px solid #D4AF37;background:rgba(212,175,55,0.09);">
                    <strong style="color:#FDE68A;font-size:0.92rem;">⚡ %s</strong>
                    <p style="margin-top:0.25rem;">%s</p>
                  </div>
                </article>
                """,
                    c.hexPinnacle(),
                    c.hexPinnacle(), escape(c.cycleCode()),
                    escape(c.eraDates()),
                    c.hexPinnacle(),
                    escape(c.pinnacleTitle()),
                    escape(c.pinnacleMetricsAndCapitals()),
                    c.hexRecession(),
                    escape(c.recessionCrisisTitle()),
                    escape(c.recessionImpactAndCauses()),
                    escape(c.miraculousRebirthAndCounterVector()),
                    escape(c.quranicLawOfAlternation())
            ));
        }

        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Portal #67: AI Interactive Conquest, Caliphates, N/S/E/W Movements, Pinnacles, Recessions, Wargame &amp; Caravan Simulator</title>
  <style>
    :root {
      --bg-deep: #040711;
      --bg-card: #0B1222;
      --bg-panel: #101A30;
      --gold: #D4AF37;
      --gold-soft: #FDE68A;
      --emerald: #10B981;
      --cyan: #38BDF8;
      --crimson: #F43F5E;
      --text-main: #F8FAFC;
      --text-muted: #94A3B8;
      --border-gold: rgba(212, 175, 55, 0.35);
    }
    * { box-sizing: border-box; margin: 0; padding: 0; }
    body {
      background: radial-gradient(circle at 50%% 0%%, #0F1E38 0%%, #040711 72%%);
      color: var(--text-main);
      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
      line-height: 1.62;
    }
    .container { max-width: 1480px; margin: 0 auto; padding: 1.4rem 1.5rem 4rem; }
    .hero {
      background: linear-gradient(135deg, rgba(16, 26, 48, 0.96), rgba(6, 78, 59, 0.38));
      border: 1px solid var(--gold);
      border-radius: 18px;
      padding: 2.1rem;
      margin-bottom: 1.4rem;
      box-shadow: 0 20px 50px rgba(0,0,0,0.65);
    }
    .hero-kicker {
      display: inline-block;
      font-family: Consolas, monospace;
      font-size: 0.78rem;
      letter-spacing: 0.12em;
      color: var(--gold-soft);
      background: rgba(212, 175, 55, 0.14);
      border: 1px solid var(--gold);
      padding: 0.28rem 0.75rem;
      border-radius: 999px;
      margin-bottom: 0.75rem;
    }
    .hero h1 {
      font-size: clamp(1.65rem, 2.7vw, 2.5rem);
      color: #FFF;
      margin-bottom: 0.45rem;
    }
    .hero-arabic {
      font-size: 1.32rem;
      color: var(--gold-soft);
      margin-bottom: 0.85rem;
      font-weight: 700;
    }
    .hero p { color: #CBD5E1; font-size: 0.96rem; max-width: 1250px; }
    .quick-jump-dock {
      display: flex;
      flex-wrap: wrap;
      gap: 0.55rem;
      background: rgba(8, 16, 32, 0.92);
      border: 1px solid var(--gold);
      border-radius: 12px;
      padding: 0.75rem 1rem;
      margin-bottom: 1.6rem;
      align-items: center;
    }
    .quick-jump-dock a {
      text-decoration: none;
      color: var(--gold-soft);
      background: rgba(212,175,55,0.14);
      border: 1px solid rgba(212,175,55,0.4);
      padding: 0.38rem 0.78rem;
      border-radius: 8px;
      font-size: 0.78rem;
      font-weight: 700;
      transition: all 0.2s;
    }
    .quick-jump-dock a:hover {
      background: var(--gold);
      color: #040711;
    }
    .sec-title {
      font-size: 1.42rem;
      color: var(--gold-soft);
      border-left: 4px solid var(--gold);
      padding-left: 0.85rem;
      margin: 2.2rem 0 0.55rem;
    }
    .sec-lead {
      color: var(--text-muted);
      font-size: 0.92rem;
      margin-bottom: 1.15rem;
    }
    .plates-grid {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(310px, 1fr));
      gap: 1.15rem;
      margin-bottom: 1.8rem;
    }
    .plate-card {
      background: var(--bg-card);
      border: 1px solid var(--border-gold);
      border-radius: 14px;
      overflow: hidden;
      display: flex;
      flex-direction: column;
    }
    .plate-card img {
      width: 100%%;
      height: 225px;
      object-fit: cover;
      border-bottom: 1px solid var(--border-gold);
    }
    .plate-body { padding: 0.95rem 1.05rem; }
    .plate-body h3 { font-size: 0.98rem; color: var(--gold-soft); margin-bottom: 0.35rem; }
    .plate-body p { font-size: 0.82rem; color: #CBD5E1; }

    .sim-stage {
      background: var(--bg-panel);
      border: 1px solid var(--gold);
      border-radius: 16px;
      padding: 1.25rem;
      margin-bottom: 1.8rem;
      box-shadow: 0 12px 36px rgba(0,0,0,0.5);
    }
    .sim-toolbar {
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
      align-items: center;
      gap: 0.75rem;
      background: rgba(4, 7, 17, 0.82);
      border: 1px solid var(--border-gold);
      border-radius: 12px;
      padding: 0.8rem 1rem;
      margin-bottom: 0.85rem;
    }
    .btn-ctrl {
      background: linear-gradient(135deg, rgba(212,175,55,0.22), rgba(16,185,129,0.22));
      color: var(--gold-soft);
      border: 1px solid var(--gold);
      border-radius: 8px;
      padding: 0.44rem 0.85rem;
      font-size: 0.8rem;
      font-weight: 700;
      cursor: pointer;
      transition: all 0.2s ease;
    }
    .btn-ctrl:hover, .btn-ctrl.active-toggle {
      background: var(--gold);
      color: #040711;
    }
    .era-pills-bar {
      display: flex;
      flex-wrap: wrap;
      gap: 0.4rem;
      margin-bottom: 0.9rem;
    }
    .era-pill-btn {
      background: #081020;
      color: #CBD5E1;
      border: 1px solid rgba(212,175,55,0.3);
      padding: 0.36rem 0.68rem;
      border-radius: 8px;
      font-size: 0.75rem;
      cursor: pointer;
      transition: all 0.18s ease;
    }
    .era-pill-btn:hover, .era-pill-btn.active {
      background: rgba(212,175,55,0.24);
      color: #FFF;
      border-color: var(--gold);
      box-shadow: 0 0 12px rgba(212,175,55,0.35);
    }
    .sim-split {
      display: grid;
      grid-template-columns: 1.25fr 1fr;
      gap: 1.15rem;
      align-items: start;
    }
    @media (max-width: 1120px) {
      .sim-split { grid-template-columns: 1fr; }
    }
    .nsew-grid {
      display: grid;
      grid-template-columns: repeat(2, 1fr);
      gap: 0.65rem;
      margin: 0.75rem 0;
    }
    @media (max-width: 680px) {
      .nsew-grid { grid-template-columns: 1fr; }
    }
    .nsew-tile {
      background: rgba(4, 7, 17, 0.76);
      border: 1px solid rgba(255,255,255,0.12);
      border-radius: 10px;
      padding: 0.65rem 0.8rem;
    }
    .nsew-tile strong {
      display: block;
      font-size: 0.78rem;
      font-family: Consolas, monospace;
      margin-bottom: 0.25rem;
    }
    .nsew-tile p {
      font-size: 0.78rem;
      color: #E2E8F0;
      line-height: 1.48;
    }
    .slider-row {
      margin-bottom: 0.75rem;
      background: rgba(4, 7, 17, 0.65);
      border: 1px solid rgba(255,255,255,0.1);
      padding: 0.6rem 0.8rem;
      border-radius: 10px;
    }
    .slider-row label {
      display: flex;
      justify-content: space-between;
      font-size: 0.8rem;
      font-weight: 700;
      color: var(--gold-soft);
      margin-bottom: 0.25rem;
    }
    .slider-row input[type="range"] {
      width: 100%%;
      accent-color: var(--gold);
      cursor: pointer;
    }
    .choice-btn {
      display: block;
      width: 100%%;
      text-align: left;
      background: rgba(4, 8, 20, 0.85);
      border: 1px solid rgba(212, 175, 55, 0.4);
      color: #F8FAFC;
      padding: 0.75rem 0.95rem;
      border-radius: 10px;
      margin-bottom: 0.55rem;
      font-size: 0.84rem;
      cursor: pointer;
      transition: all 0.2s;
    }
    .choice-btn:hover, .choice-btn.selected-choice {
      background: rgba(16, 185, 129, 0.18);
      border-color: #10B981;
      box-shadow: 0 0 14px rgba(16,185,129,0.28);
    }
    .select-box {
      background: #040814;
      border: 1px solid var(--gold);
      color: #FFF;
      padding: 0.5rem 0.75rem;
      border-radius: 8px;
      font-size: 0.84rem;
    }
    .grid-2 {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(440px, 1fr));
      gap: 1.1rem;
    }
    .grid-3 {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(340px, 1fr));
      gap: 1.05rem;
    }
    @media (max-width: 640px) {
      .grid-2, .grid-3 { grid-template-columns: 1fr; }
    }
    .card {
      background: var(--bg-card);
      border: 1px solid rgba(255,255,255,0.1);
      border-radius: 13px;
      padding: 1.1rem;
      display: flex;
      flex-direction: column;
    }
    .card h3 { font-size: 1.04rem; color: #FFF; margin-bottom: 0.2rem; }
    .arabic-sub {
      font-size: 0.92rem;
      color: var(--gold-soft);
      margin-bottom: 0.55rem;
      font-weight: 600;
    }
    .badge-row {
      display: flex;
      flex-wrap: wrap;
      gap: 0.4rem;
      margin-bottom: 0.5rem;
    }
    .pill {
      display: inline-block;
      font-family: Consolas, monospace;
      font-size: 0.7rem;
      padding: 0.16rem 0.52rem;
      border-radius: 999px;
      border: 1px solid var(--gold);
      color: var(--gold-soft);
      background: rgba(212,175,55,0.1);
    }
    .sub-box {
      background: rgba(4, 7, 17, 0.58);
      border-left: 3px solid var(--gold);
      border-radius: 8px;
      padding: 0.55rem 0.75rem;
      margin-bottom: 0.5rem;
      font-size: 0.8rem;
      color: #CBD5E1;
    }
    .search-inp {
      width: 100%%;
      background: #050914;
      border: 1px solid var(--gold);
      color: #FFF;
      padding: 0.65rem 0.95rem;
      border-radius: 9px;
      font-size: 0.88rem;
      margin-bottom: 0.9rem;
    }
    table { width: 100%%; border-collapse: collapse; font-size: 0.8rem; }
    th, td {
      padding: 0.62rem 0.7rem;
      border-bottom: 1px solid rgba(255,255,255,0.08);
      text-align: left;
      vertical-align: top;
    }
    th {
      background: #070D1C;
      color: var(--gold-soft);
      font-family: Consolas, monospace;
      font-size: 0.73rem;
      text-transform: uppercase;
      position: sticky;
      top: 0;
    }
    .click-row { cursor: pointer; transition: background 0.15s; }
    .click-row:hover { background: rgba(212,175,55,0.14); }
    @keyframes dashFlow {
      to { stroke-dashoffset: -36; }
    }
    .flowing-route {
      animation: dashFlow 2.2s linear infinite;
    }
  </style>
</head>
<body>
  <main class="container">
    <header class="hero">
      <div class="hero-kicker">PORTAL #67 • 5-ENGINE AI INTERACTIVE CONQUEST, CALIPHATE, N/S/E/W MOVEMENT, PINNACLE, RECESSION, WARGAME &amp; CARAVAN SIMULATOR</div>
      <h1>AI Interactive Suite: Every Era of Islamic Conquest, Caliphates, Canonical Movements (East, West, North &amp; South), Pinnacles &amp; Recessions — As They Happen</h1>
      <div class="hero-arabic">المختبر التفاعلي الذكي لعصور الفتوحات والخلافة والحركات الإسلامية في الجهات الأربع: الذروة والانحسار والانبعاث (610 – 2026 م)</div>
      <p>
        Experience <strong>5 Live AI &amp; Procedural Interactive Engines</strong> across <strong>16 Canonical Eras (610 CE – 2026 CE)</strong>:
        (1) <strong>The 16-Era "As-They-Happen" Map, Caravan/Monsoon Flow &amp; 12 Battle Beacon Simulator</strong>;
        (2) <strong>The Ibn Khaldūn 6-Slider Civilizational Pinnacle vs. Recession Radar Engine</strong>;
        (3) <strong>The 8-Scenario Historical Turning-Point Wargame &amp; Decision Simulator</strong>;
        (4) <strong>The N/S/E/W Caravan (<em>Qāfilah</em>) &amp; Monsoon Dhow (<em>Sanbūq</em>) Expedition Planner</strong>; and
        (5) <strong>The AI <em>Majlis Al-Ḥikmah</em> Multi-Scholar Inquiry &amp; Synthesis Oracle</strong>.
      </p>
    </header>

    <nav class="quick-jump-dock">
      <strong style="font-size:0.78rem;color:#34D399;font-family:Consolas,monospace;">⚡ JUMP TO INTERACTIVE ENGINE:</strong>
      <a href="#liveConquestSimulator">1. 🌍 16-Era Map &amp; Battle Beacons</a>
      <a href="#ibnKhaldunDialEngine">2. ⚖️ Ibn Khaldūn Pinnacle/Recession Dial</a>
      <a href="#turningPointWargame">3. ⚔️ 8-Scenario Strategic Wargame</a>
      <a href="#caravanMonsoonPlanner">4. 🐪⛵ Caravan &amp; Monsoon Dhow Planner</a>
      <a href="#majlisAiOracle">5. 🧠 AI Majlis Al-Ḥikmah Oracle</a>
      <a href="#eightPlatesShowcase">🎨 8 AI Museum Plates</a>
    </nav>

    <h2 class="sec-title" id="eightPlatesShowcase">I. 8 AI-Generated Museum &amp; Simulation Plates: Four Compass Directions, Pinnacles, Recessions, Tactical Command &amp; Majlis Al-Ḥikmah</h2>
    <p class="sec-lead">
      Eight high-resolution AI plates illustrating the 4 directional vectors, the great caliphal pinnacles, the miraculous rebirths after recessions, the canonical non-dynastic movements, the tactical command table, the caravan-monsoon network, the Ibn Khaldūn dial, and the <em>Majlis Al-Ḥikmah</em> scholarly council.
    </p>
    <section class="plates-grid">
      <article class="plate-card">
        <img src="/images/conquest_plate_1_four_directions_map.jpg" alt="Plate 1: The Four-Compass-Direction Islamic Expansion & Movement Atlas">
        <div class="plate-body">
          <h3>Plate I: Four-Compass-Direction Atlas (N • S • E • W)</h3>
          <p>Radiating from Mecca and Medina: <strong>West</strong> to Córdoba &amp; Timbuktu/Sokoto; <strong>East</strong> to Baghdad, Samarkand, Delhi &amp; Aceh; <strong>North</strong> to Damascus, Istanbul &amp; Kazan; <strong>South</strong> to Yemen, Oman &amp; Zanzibar.</p>
        </div>
      </article>
      <article class="plate-card">
        <img src="/images/conquest_plate_2_pinnacles_apogee.jpg" alt="Plate 2: The Great Pinnacles of the Caliphates & Gunpowder Empires">
        <div class="plate-body">
          <h3>Plate II: The Great Pinnacles (<em>Al-Awj wa Al-Dhurwah</em>)</h3>
          <p>The 750 CE Umayyad-Abbasid zenith, the scientific apogee of Baghdad/Córdoba/Cairo, 1453 Constantinople, and the 16th–17th c. Ottoman-Safavid-Mughal-Omani-Acehnese simultaneous pinnacle.</p>
        </div>
      </article>
      <article class="plate-card">
        <img src="/images/conquest_plate_3_recessions_rebirths.jpg" alt="Plate 3: The Great Recessions & Miraculous Rebirths">
        <div class="plate-body">
          <h3>Plate III: Recessions &amp; Miraculous Rebirths (<em>Al-Inbi'āth</em>)</h3>
          <p>The 1258 Mongol siege of Baghdad answered within 24 months by 1260 <em>'Ayn Jālūt</em> and the conversion of three Mongol Khanates; and 1492 Granada answered by Ottoman, Omani, and Nusantara resurgence.</p>
        </div>
      </article>
      <article class="plate-card">
        <img src="/images/conquest_plate_4_canonical_movements.jpg" alt="Plate 4: Canonical Muslim Movements Through Time">
        <div class="plate-body">
          <h3>Plate IV: Canonical Muslim Movements Beyond Dynasties</h3>
          <p>The Prophetic <em>Hijrah</em>, coastal <em>Ribāṭ</em> citadels, <em>Waqf</em> universities, global Sufi <em>Ṭarīqahs</em>, Omani/Hadhrami monsoon dhows, and the 57-nation sovereign resurgence.</p>
        </div>
      </article>
      <article class="plate-card">
        <img src="/images/ai_sim_plate_1_tactical_conquest_board.jpg" alt="Plate 5: AI Interactive Tactical Command Table & Four-Direction Conquest Board">
        <div class="plate-body">
          <h3>Plate V: AI Tactical Command Table &amp; Frontier Board</h3>
          <p>Royal brass, lapis-lazuli, and cedar strategic command map with glowing N/S/E/W vectors, miniature gilded cavalry, Omani lateen dhows, and <em>Ribāṭ</em> frontier fortresses.</p>
        </div>
      </article>
      <article class="plate-card">
        <img src="/images/ai_sim_plate_2_caravan_monsoon_expedition.jpg" alt="Plate 6: Interactive Caravan & Monsoon Dhow Expedition Simulator">
        <div class="plate-body">
          <h3>Plate VI: Caravan &amp; Monsoon Dhow Expedition Network</h3>
          <p>Isometric Silk Road and Trans-Saharan camel caravans (with domed <em>Khāns</em> and Darb Zubaydah fire-beacons) linked to Red Sea and Indian Ocean monsoon dhow lanes.</p>
        </div>
      </article>
      <article class="plate-card">
        <img src="/images/ai_sim_plate_3_pinnacle_recession_engine.jpg" alt="Plate 7: The Ibn Khaldun Pinnacle & Recession Civilizational Dial Engine">
        <div class="plate-body">
          <h3>Plate VII: Ibn Khaldūn Pinnacle &amp; Recession Dial Engine</h3>
          <p>Mechanical-holographic astrolabe computer balancing Justice (<em>'Adl</em>), Endowment (<em>Waqf</em>), Science (<em>'Ilm</em>), and Consultative Suffrage (<em>Shūrā</em>) across historical cycles.</p>
        </div>
      </article>
      <article class="plate-card">
        <img src="/images/ai_sim_plate_4_majlis_ai_scholar_oracle.jpg" alt="Plate 8: Majlis Al-Hikmah Interactive Council of Islamic Scholars & Navigators">
        <div class="plate-body">
          <h3>Plate VIII: <em>Majlis Al-Ḥikmah</em> Interactive Scholarly Council</h3>
          <p>Al-Khwārizmī (Mathematics), Ibn Khaldūn (History/Cycles), Aḥmad ibn Mājid (32-Point Compass), and Fatima al-Fihri / Nana Asma'u (Waqf &amp; Suffrage) presiding over a live world map.</p>
        </div>
      </article>
    </section>

    <!-- =========================================================================================
         INTERACTIVE ENGINE #1: 16-ERA AS-THEY-HAPPEN MAP, FLOWING CARAVAN/DHOW LANES & BATTLE BEACONS
         ========================================================================================= -->
    <h2 class="sec-title" id="liveConquestSimulator">II. Interactive Engine #1: Live 16-Era "As-They-Happen" Conquest, Caravan/Monsoon Flow &amp; Battle Beacon Simulator (610 – 2026 CE)</h2>
    <p class="sec-lead">
      Press <strong>▶ Play History As It Happens</strong>, adjust playback speed, toggle <strong>Flowing Caravan &amp; Monsoon Dhow Routes</strong>, or click any of the <strong>12 Glowing Battle &amp; Turning-Point Beacons</strong> directly on the map!
    </p>

    <section class="sim-stage">
      <div class="sim-toolbar">
        <div style="display:flex;gap:0.45rem;flex-wrap:wrap;align-items:center;">
          <button type="button" class="btn-ctrl" onclick="stepSimEra(-1)">⏮ Prev Era</button>
          <button type="button" id="simAutoPlayBtn" class="btn-ctrl" style="background:linear-gradient(135deg,#059669,#047857);color:#FFF;" onclick="toggleSimAutoPlay()">▶ Play History As It Happens</button>
          <button type="button" class="btn-ctrl" onclick="stepSimEra(1)">Next Era ⏭</button>
          <select id="simSpeedSelect" class="select-box" onchange="updateSimPlaybackSpeed(this.value)" title="Playback Speed">
            <option value="2400">Speed: 1.0x (2.4s/Era)</option>
            <option value="1200">Speed: 2.0x Fast (1.2s/Era)</option>
            <option value="4000">Speed: 0.6x Deep Study</option>
          </select>
        </div>
        <div style="display:flex;align-items:center;gap:0.65rem;flex:1;min-width:240px;">
          <span style="font-size:0.75rem;color:#FDE68A;font-family:Consolas,monospace;white-space:nowrap;">SCRUB 16 ERAS:</span>
          <input id="simEraSlider" type="range" min="1" max="16" value="1" step="1" style="flex:1;accent-color:#D4AF37;cursor:pointer;" oninput="selectSimEra(parseInt(this.value,10), false)">
          <span id="simSliderBadge" style="font-family:Consolas,monospace;font-size:0.78rem;color:#34D399;font-weight:700;min-width:105px;text-align:right;">ERA #01 / 16</span>
        </div>
        <div style="display:flex;gap:0.4rem;flex-wrap:wrap;">
          <button type="button" class="btn-ctrl" onclick="showAllSimErasOverlay()">🌍 All 16 Polygons</button>
          <button type="button" class="btn-ctrl active-toggle" id="toggleCaravanRoutesBtn" onclick="toggleSvgLayer('simCaravanDhowRoutesLayer', this)">🐪⛵ Caravan &amp; Monsoon Lanes</button>
          <button type="button" class="btn-ctrl active-toggle" id="toggleBattleBeaconsBtn" onclick="toggleSvgLayer('simBattleBeaconsLayer', this)">⚔️ 12 Battle Beacons</button>
        </div>
      </div>

      <div class="era-pills-bar">
        %s
      </div>

      <div class="sim-split">
        <!-- Left Column: Interactive SVG World Map + Battle Inspector + Wave Curve -->
        <div>
          <div style="background:#040814;border:1px solid rgba(212,175,55,0.45);border-radius:12px;overflow:hidden;position:relative;">
            <svg id="simWorldMapSvg" viewBox="0 0 920 440" width="100%%" style="display:block;background:linear-gradient(180deg,#050B1A 0%%,#09152B 55%%,#040914 100%%);">
              <defs>
                <marker id="simArrowEast" viewBox="0 0 10 10" refX="7" refY="5" markerWidth="6.5" markerHeight="6.5" orient="auto-start-reverse">
                  <path d="M 0 1 L 10 5 L 0 9 z" fill="#10B981"/>
                </marker>
                <marker id="simArrowWest" viewBox="0 0 10 10" refX="7" refY="5" markerWidth="6.5" markerHeight="6.5" orient="auto-start-reverse">
                  <path d="M 0 1 L 10 5 L 0 9 z" fill="#FDE68A"/>
                </marker>
                <marker id="simArrowNorth" viewBox="0 0 10 10" refX="7" refY="5" markerWidth="6.5" markerHeight="6.5" orient="auto-start-reverse">
                  <path d="M 0 1 L 10 5 L 0 9 z" fill="#38BDF8"/>
                </marker>
                <marker id="simArrowSouth" viewBox="0 0 10 10" refX="7" refY="5" markerWidth="6.5" markerHeight="6.5" orient="auto-start-reverse">
                  <path d="M 0 1 L 10 5 L 0 9 z" fill="#F43F5E"/>
                </marker>
              </defs>

              <!-- Graticule -->
              <g stroke="rgba(255,255,255,0.06)" stroke-width="1">
                <line x1="0" y1="110" x2="920" y2="110"/>
                <line x1="0" y1="220" x2="920" y2="220"/>
                <line x1="0" y1="305" x2="920" y2="305" stroke="rgba(212,175,55,0.22)" stroke-dasharray="4,4"/>
                <line x1="0" y1="370" x2="920" y2="370"/>
                <line x1="200" y1="0" x2="200" y2="440"/>
                <line x1="350" y1="0" x2="350" y2="440"/>
                <line x1="459" y1="0" x2="459" y2="440" stroke="rgba(212,175,55,0.28)" stroke-dasharray="4,4"/>
                <line x1="600" y1="0" x2="600" y2="440"/>
                <line x1="760" y1="0" x2="760" y2="440"/>
              </g>

              <!-- Continental Landmasses -->
              <g fill="#111C33" stroke="rgba(212,175,55,0.25)" stroke-width="1.2">
                <path d="M 165,185 L 255,170 L 335,190 L 385,195 L 445,280 L 495,285 L 455,375 L 385,425 L 325,425 L 285,335 L 185,295 L 145,235 Z"/>
                <path d="M 172,145 L 225,140 L 265,115 L 355,110 L 425,125 L 395,165 L 315,168 L 230,170 Z"/>
                <path d="M 355,150 L 445,140 L 585,120 L 765,135 L 825,215 L 760,285 L 690,235 L 635,285 L 590,225 L 535,235 L 505,290 L 445,295 L 395,215 Z"/>
                <path d="M 695,295 L 745,335 L 815,345 L 845,325 L 795,290 Z"/>
              </g>

              <!-- Dynamic Era Territorial Polygons -->
              <g id="simPolygonsLayer">
                %s
              </g>

              <!-- Flowing Silk Road / Trans-Saharan Caravan & Indian Ocean Monsoon Dhow Layer -->
              <g id="simCaravanDhowRoutesLayer">
                <!-- Overland Silk Road & Darb Zubaydah Caravans (Gold Flowing Dashed) -->
                <path class="flowing-route" d="M 459,242 L 478,190 L 535,175 L 572,162 L 645,168 L 735,175" fill="none" stroke="#F59E0B" stroke-width="2" stroke-dasharray="6,6" opacity="0.8"/>
                <!-- Overland Trans-Saharan & Maghreb Caravans -->
                <path class="flowing-route" d="M 459,242 L 395,212 L 295,192 L 215,195 L 215,275 L 265,285" fill="none" stroke="#FDE68A" stroke-width="2" stroke-dasharray="6,6" opacity="0.8"/>
                <!-- Northern Volga Fur & Steppe Route -->
                <path class="flowing-route" d="M 478,190 L 482,145 L 485,105" fill="none" stroke="#A78BFA" stroke-width="2" stroke-dasharray="5,5" opacity="0.8"/>
                <!-- Maritime Omani/Yemeni/Karimi Monsoon Dhow Lanes (Cyan Flowing Dashed) -->
                <path class="flowing-route" d="M 395,212 L 452,278 L 502,265 L 455,392" fill="none" stroke="#38BDF8" stroke-width="2.2" stroke-dasharray="7,5" opacity="0.85"/>
                <path class="flowing-route" d="M 502,265 Q 585,275 635,268 Q 705,295 765,318 L 825,245" fill="none" stroke="#38BDF8" stroke-width="2.2" stroke-dasharray="7,5" opacity="0.85"/>
                <!-- Custom Expedition Planner Dynamic Line -->
                <line id="customExpeditionMapLine" x1="459" y1="242" x2="572" y2="162" stroke="#10B981" stroke-width="4" stroke-dasharray="8,4" style="display:none;"/>
              </g>

              <!-- Live Dynamic N / S / E / W Vectors for Active Era -->
              <g id="simActiveVectorsLayer">
                <line id="vecEastLine" x1="459" y1="242" x2="495" y2="225" stroke="#10B981" stroke-width="3" stroke-dasharray="6,3" marker-end="url(#simArrowEast)"/>
                <line id="vecWestLine" x1="459" y1="242" x2="425" y2="225" stroke="#FDE68A" stroke-width="3" stroke-dasharray="6,3" marker-end="url(#simArrowWest)"/>
                <line id="vecNorthLine" x1="459" y1="242" x2="442" y2="198" stroke="#38BDF8" stroke-width="3" stroke-dasharray="6,3" marker-end="url(#simArrowNorth)"/>
                <line id="vecSouthLine" x1="459" y1="242" x2="475" y2="288" stroke="#F43F5E" stroke-width="3" stroke-dasharray="6,3" marker-end="url(#simArrowSouth)"/>
              </g>

              <!-- 12 Clickable Historical Battle, Pinnacle & Rebirth Beacons -->
              <g id="simBattleBeaconsLayer" font-size="8.2" font-weight="700" style="cursor:pointer;">
                <g transform="translate(459,242)" onclick="inspectMapBeacon(0)">
                  <circle cx="0" cy="0" r="11" fill="rgba(212,175,55,0.28)"/>
                  <rect x="-4" y="-4" width="8" height="8" fill="#090D16" stroke="#FDE68A" stroke-width="1.8"/>
                  <text x="0" y="-10" text-anchor="middle" fill="#FDE68A">🕋 MAKKAH &amp; BADR (624 / 630)</text>
                </g>
                <g transform="translate(432,182)" onclick="inspectMapBeacon(1)">
                  <circle cx="0" cy="0" r="5" fill="#10B981" stroke="#FFF" stroke-width="1.4"/>
                  <text x="-8" y="-7" text-anchor="end" fill="#34D399">⚔️ YARMŪK &amp; JERUSALEM (636–637)</text>
                </g>
                <g transform="translate(478,190)" onclick="inspectMapBeacon(2)">
                  <circle cx="0" cy="0" r="5.5" fill="#D4AF37" stroke="#FFF" stroke-width="1.5"/>
                  <text x="8" y="-7" text-anchor="start" fill="#FDE68A">🏛️ QĀDISIYYAH &amp; BAGHDAD (636 / 762 / 1258)</text>
                </g>
                <g transform="translate(192,155)" onclick="inspectMapBeacon(3)">
                  <circle cx="0" cy="0" r="5" fill="#F8FAFC" stroke="#D4AF37" stroke-width="1.5"/>
                  <text x="0" y="-8" text-anchor="middle" fill="#FDE68A">🕌 GIBRALTAR, CÓRDOBA &amp; GRANADA (711–1492)</text>
                </g>
                <g transform="translate(612,158)" onclick="inspectMapBeacon(4)">
                  <circle cx="0" cy="0" r="5" fill="#38BDF8" stroke="#FFF" stroke-width="1.4"/>
                  <text x="0" y="-8" text-anchor="middle" fill="#38BDF8">📜 SAMARKAND &amp; TALAS (710 / 751)</text>
                </g>
                <g transform="translate(485,105)" onclick="inspectMapBeacon(5)">
                  <circle cx="0" cy="0" r="4.8" fill="#A78BFA" stroke="#FFF" stroke-width="1.3"/>
                  <text x="0" y="-8" text-anchor="middle" fill="#C4B5FD">❄️ VOLGA BULGARIA &amp; GOLDEN HORDE (922 / 1257)</text>
                </g>
                <g transform="translate(435,152)" onclick="inspectMapBeacon(6)">
                  <circle cx="0" cy="0" r="5" fill="#38BDF8" stroke="#FDE68A" stroke-width="1.4"/>
                  <text x="0" y="-8" text-anchor="middle" fill="#38BDF8">🏹 MANZIKERT (1071)</text>
                </g>
                <g transform="translate(415,205)" onclick="inspectMapBeacon(7)">
                  <circle cx="0" cy="0" r="5.5" fill="#F43F5E" stroke="#FDE68A" stroke-width="1.5"/>
                  <text x="-8" y="14" text-anchor="middle" fill="#FDA4AF">🛡️ ḤIṬṬĪN (1187) &amp; 'AYN JĀLŪT (1260)</text>
                </g>
                <g transform="translate(382,142)" onclick="inspectMapBeacon(8)">
                  <circle cx="0" cy="0" r="5.5" fill="#DC2626" stroke="#FDE68A" stroke-width="1.6"/>
                  <text x="-6" y="-8" text-anchor="end" fill="#FCA5A5">🏰 CONSTANTINOPLE / ISTANBUL (1453)</text>
                </g>
                <g transform="translate(215,275)" onclick="inspectMapBeacon(9)">
                  <circle cx="0" cy="0" r="5" fill="#D4AF37" stroke="#FFF" stroke-width="1.3"/>
                  <text x="0" y="13" text-anchor="middle" fill="#FDE68A">👑 TIMBUKTU (1324) &amp; SOKOTO (1804)</text>
                </g>
                <g transform="translate(502,265)" onclick="inspectMapBeacon(10)">
                  <circle cx="0" cy="0" r="5" fill="#F97316" stroke="#FFF" stroke-width="1.3"/>
                  <text x="10" y="4" text-anchor="start" fill="#FDBA74">⛵ MUSCAT (1650) &amp; ZANZIBAR (1840)</text>
                </g>
                <g transform="translate(765,318)" onclick="inspectMapBeacon(11)">
                  <circle cx="0" cy="0" r="5.2" fill="#10B981" stroke="#FDE68A" stroke-width="1.4"/>
                  <text x="0" y="14" text-anchor="middle" fill="#34D399">🌺 ACEH, MALACCA &amp; WALI SONGO (1267–1475)</text>
                </g>
              </g>
            </svg>
          </div>

          <!-- Live Map Beacon Tactical Inspector Box -->
          <div id="mapBeaconInspectorBox" style="margin-top:0.75rem;background:linear-gradient(135deg,#091326,#062019);border:1px solid #10B981;border-radius:11px;padding:0.75rem 0.95rem;">
            <div style="display:flex;justify-content:space-between;align-items:center;flex-wrap:wrap;gap:0.4rem;">
              <span id="beaconBadge" class="pill" style="border-color:#10B981;color:#34D399;">⚔️ CLICK ANY MAP BEACON ABOVE TO INSPECT TACTICAL TURNING POINT</span>
              <span id="beaconDirection" class="pill">🧭 COMPASS VECTOR: ALL FOUR DIRECTIONS</span>
            </div>
            <h4 id="beaconTitle" style="color:#FFF;font-size:0.98rem;margin:0.3rem 0 0.15rem;">
              🕋 Makkah, Madinah, Badr (624 CE), Ḥudaybiyyah (628 CE) &amp; Opening of Mecca (630 CE)
            </h4>
            <p id="beaconDesc" style="font-size:0.8rem;color:#CBD5E1;">
              The spiritual and constitutional fulcrum of Islam: from the <em>Ṣaḥīfat Al-Madīnah</em> (622 CE) and Badr to the bloodless Opening of Mecca (630 CE), establishing the zero-origin of the 4 directional expansion vectors.
            </p>
          </div>

          <!-- Interactive Pinnacle vs. Recession Wave Graph Across All 16 Eras -->
          <div style="margin-top:0.75rem;background:#060B18;border:1px solid rgba(212,175,55,0.35);border-radius:12px;padding:0.75rem 0.9rem;">
            <div style="display:flex;justify-content:space-between;align-items:center;flex-wrap:wrap;margin-bottom:0.35rem;">
              <strong style="font-size:0.82rem;color:#FDE68A;">📈 Interactive 1,400-Year Pinnacle &amp; Recession Wave Curve (Click Any Era Node #01–#16):</strong>
              <span style="font-size:0.74rem;color:#94A3B8;font-family:Consolas,monospace;">Sovereign Expanse (M km²) • Sunnat Al-Tadāwul (Qur'an 3:140)</span>
            </div>
            <svg viewBox="0 0 940 210" width="100%%" style="display:block;">
              <line x1="35" y1="35" x2="910" y2="35" stroke="rgba(16,185,129,0.2)" stroke-dasharray="3,3"/>
              <line x1="35" y1="105" x2="910" y2="105" stroke="rgba(212,175,55,0.2)" stroke-dasharray="3,3"/>
              <line x1="35" y1="175" x2="910" y2="175" stroke="rgba(244,63,94,0.25)"/>
              <text x="8" y="38" fill="#34D399" font-size="8" font-family="Consolas,monospace">PINNACLE</text>
              <text x="8" y="175" fill="#FDA4AF" font-size="8" font-family="Consolas,monospace">RECESSION</text>
              <polyline fill="none" stroke="#D4AF37" stroke-width="2.6" points="%s"/>
              %s
            </svg>
          </div>
        </div>

        <!-- Right Column: Live As-They-Happen Era Dossier & N/S/E/W Telemetry -->
        <div style="background:#081020;border:1px solid rgba(212,175,55,0.45);border-radius:14px;padding:1.1rem;">
          <div class="badge-row">
            <span id="simEraCodeBadge" class="pill">ERA-01 • 610–632 CE</span>
            <span id="simEraHijriBadge" class="pill" style="border-color:#38BDF8;color:#38BDF8;">13 BH – 11 AH</span>
            <span id="simEraPhaseBadge" class="pill" style="border-color:#10B981;color:#34D399;">INCEPTION &amp; COVENANT PINNACLE</span>
          </div>
          <h3 id="simEraHeadline" style="font-size:1.18rem;color:#FFF;margin-bottom:0.2rem;">
            Prophetic Revelation, First Abyssinian Hijrah, Medina Covenant &amp; Unification of Arabia
          </h3>
          <div id="simEraArabic" class="arabic-sub">عصر النبوة والهجرة وتوحيد الجزيرة العربية</div>

          <div style="display:grid;grid-template-columns:1fr 1fr;gap:0.65rem;margin-bottom:0.75rem;">
            <div style="background:#040814;border:1px solid rgba(212,175,55,0.3);border-radius:9px;padding:0.55rem 0.75rem;">
              <small style="color:#94A3B8;font-size:0.72rem;display:block;">ESTIMATED SOVEREIGN REACH</small>
              <strong id="simEraArea" style="color:#FDE68A;font-size:1.05rem;font-family:Consolas,monospace;">3.1 Million km²</strong>
            </div>
            <div style="background:#040814;border:1px solid rgba(16,185,129,0.3);border-radius:9px;padding:0.55rem 0.75rem;">
              <small style="color:#94A3B8;font-size:0.72rem;display:block;">CIVILIZATIONAL MOMENTUM</small>
              <strong id="simEraMomentum" style="color:#34D399;font-size:1.05rem;font-family:Consolas,monospace;">92 / 100</strong>
            </div>
          </div>

          <h4 style="font-size:0.84rem;color:#FDE68A;margin-bottom:0.4rem;">
            🧭 Live Four-Compass-Direction Movements As They Happen in This Era:
          </h4>
          <div class="nsew-grid">
            <div class="nsew-tile" style="border-left:3px solid #10B981;">
              <strong style="color:#34D399;">➡ EAST (AL-MASHRIQ)</strong>
              <p id="simEastText">EAST: Delegation of ’Abd al-Qays in Bahrain (Al-Ahsa) and Envoy Al-’Ala’ al-Hadrami embrace Islam peacefully (628–630 CE); Epistle sent to Khosrow II of Persia.</p>
            </div>
            <div class="nsew-tile" style="border-left:3px solid #FDE68A;">
              <strong style="color:#FDE68A;">⬅ WEST (AL-MAGHRIB)</strong>
              <p id="simWestText">WEST: Red Sea corridor secured; Epistle sent to Al-Muqawqis in Egypt; treaty ports of Ayla and Maqna on the Gulf of Aqaba enter covenant.</p>
            </div>
            <div class="nsew-tile" style="border-left:3px solid #38BDF8;">
              <strong style="color:#38BDF8;">⬆ NORTH (AL-SHAMĀL)</strong>
              <p id="simNorthText">NORTH: Expedition of Mu’tah (629 CE) and Tabuk (630 CE) reach the Byzantine Syrian frontier; Epistle sent to Emperor Heraclius.</p>
            </div>
            <div class="nsew-tile" style="border-left:3px solid #F43F5E;">
              <strong style="color:#FDA4AF;">⬇ SOUTH (AL-JANŪB)</strong>
              <p id="simSouthText">SOUTH: First Hijrah to Abyssinia (615 CE) welcomed by Negus Ashamah; peaceful conversion of Yemen (Mu’adh ibn Jabal) and Oman (Julanda Princes of Sohar).</p>
            </div>
          </div>

          <div class="sub-box" style="border-left-color:#38BDF8;">
            <strong style="color:#38BDF8;">👑 Active Caliphates, Sultanates, Imamates &amp; Dynasties:</strong>
            <p id="simCaliphatesText" style="margin-top:0.2rem;">The Prophetic City-State of Al-Madinah Al-Munawwarah (Nubuwwah)</p>
          </div>

          <div class="sub-box" style="border-left-color:#A855F7;">
            <strong style="color:#D8B4FE;">🕊️ Canonical Muslim Movements Active in This Era:</strong>
            <p id="simMovementsText" style="margin-top:0.2rem;">Al-Hijrah (Migration), Al-Mu’akhah (Muhajirun-Ansar Brotherhood), Sahifat Al-Madinah (Constitution), Year of Delegations (’Am Al-Wufud, 9 AH).</p>
          </div>

          <div class="sub-box" style="border-left-color:#10B981;background:rgba(16,185,129,0.09);">
            <strong style="color:#34D399;">🌟 Era Pinnacle (Al-Awj wa Al-Dhurwah):</strong>
            <p id="simPinnacleText" style="margin-top:0.2rem;">PINNACLE: Complete spiritual, legal, and tribal unification of the Arabian Peninsula from Yemen and Oman to Tabuk under the Farewell Sermon (10 AH / 632 CE).</p>
          </div>

          <div class="sub-box" style="border-left-color:#F43F5E;background:rgba(244,63,94,0.09);">
            <strong style="color:#FDA4AF;">🌊 Era Recession &amp; Rebirth Dynamic (Al-Inḥisār wa Al-Inbi'āth):</strong>
            <p id="simRecessionText" style="margin-top:0.2rem;">INITIAL TRIAL &amp; REBIRTH: Meccan persecution and the Siege of the Trench (Khandaq, 627 CE) reversed by the Treaty of Hudaybiyyah (628 CE) and bloodless Opening of Mecca (630 CE).</p>
          </div>

          <div style="font-size:0.78rem;color:#FDE68A;border-top:1px solid rgba(255,255,255,0.1);padding-top:0.45rem;">
            <strong>📖 Canonical Qur'anic &amp; Historical Anchor:</strong>
            <span id="simAnchorText" style="color:#CBD5E1;">Qur’an 110:1–2 (Surat Al-Nasr) &amp; Qur’an 48:1 (Surat Al-Fath): ’Indeed, We have granted you a clear opening.’</span>
          </div>
        </div>
      </div>
    </section>

    <!-- =========================================================================================
         INTERACTIVE ENGINE #2: IBN KHALDUN 6-SLIDER PINNACLE vs. RECESSION RADAR ENGINE
         ========================================================================================= -->
    <h2 class="sec-title" id="ibnKhaldunDialEngine">III. Interactive Engine #2: The Ibn Khaldūn &amp; <em>Sunnat Al-Tadāwul</em> Civilizational Pinnacle vs. Recession Simulator</h2>
    <p class="sec-lead">
      In his <em>Muqaddimah</em> (1377 CE), <strong>Ibn Khaldūn</strong> demonstrated that empires rise to their <strong>Pinnacle (<em>Al-Awj</em>)</strong> or enter <strong>Recession (<em>Al-Inḥisār</em>)</strong> based on measurable institutional pillars—while grassroots <strong>Waqf, Sufi, and Scholarly Movements</strong> trigger <strong>Rebirth (<em>Al-Inbi'āth</em>)</strong> even when a royal court weakens. Drag any of the <strong>6 Governance Sliders</strong> or click a historical preset below to run the AI Neuro-Symbolic Radar!
    </p>

    <section class="sim-stage">
      <div class="era-pills-bar" style="margin-bottom:1rem;">
        <strong style="font-size:0.76rem;color:#FDE68A;align-self:center;margin-right:0.35rem;">LOAD HISTORICAL PRESET:</strong>
        <button type="button" class="era-pill-btn active" onclick="loadKhaldunPreset(96,94,98,95,90,95, '800 CE Abbasid Baghdad & Cordoban Golden Age Pinnacle', this)">🌟 800 CE Golden Age Pinnacle</button>
        <button type="button" class="era-pill-btn" onclick="loadKhaldunPreset(42,35,68,55,38,88, '1090 CE Taifa Fragmentation -> Almoravid Ribat Counter-Wave', this)">🌊 1090 CE Taifa Recession / Ribāṭ</button>
        <button type="button" class="era-pill-btn" onclick="loadKhaldunPreset(38,32,75,48,30,96, '1258 CE Baghdad Siege Crisis -> 1260 Mamluk & Sufi Mongol Conversion Rebirth', this)">⚡ 1258/1260 Baghdad -> 'Ayn Jālūt Rebirth</button>
        <button type="button" class="era-pill-btn" onclick="loadKhaldunPreset(92,90,94,96,95,92, '1560 CE Ottoman-Safavid-Mughal-Aceh Simultaneous Zenith', this)">🌟 1560 CE Gunpowder & Maritime Zenith</button>
        <button type="button" class="era-pill-btn" onclick="loadKhaldunPreset(91,89,93,90,88,96, '1820 CE Sokoto Caliphate (Nana Asma’u) & Omani-Zanzibar Peak', this)">🌍 1820 CE Sokoto &amp; Omani-Zanzibar Peak</button>
        <button type="button" class="era-pill-btn" onclick="loadKhaldunPreset(45,48,82,42,36,94, '1918 CE Colonial State Recession vs. Grassroots Nahdah/Waqf Survival', this)">🌊 1918 CE Colonial Nadir / Civic Survival</button>
      </div>

      <div class="sim-split">
        <!-- Sliders Column -->
        <div>
          <div class="slider-row">
            <label><span>1. ⚖️ Al-'Adl wa Al-Maẓālim (Court Justice &amp; Grievance Redress)</span><span id="valAdl">96 / 100</span></label>
            <input id="slAdl" type="range" min="10" max="100" value="96" oninput="recalcKhaldunEngine()">
          </div>
          <div class="slider-row">
            <label><span>2. 🤝 Al-'Aṣabiyyah wa Al-Shūrā (Social Cohesion &amp; Consultative Suffrage)</span><span id="valShura">94 / 100</span></label>
            <input id="slShura" type="range" min="10" max="100" value="94" oninput="recalcKhaldunEngine()">
          </div>
          <div class="slider-row">
            <label><span>3. 📚 Niẓām Al-Waqf wa Al-'Ilm (Endowed Universities, Hospitals &amp; Science)</span><span id="valWaqf">98 / 100</span></label>
            <input id="slWaqf" type="range" min="10" max="100" value="98" oninput="recalcKhaldunEngine()">
          </div>
          <div class="slider-row">
            <label><span>4. 🪙 Al-Tijārah wa Al-Dīnār (Sound Currency, Low 'Ushr &amp; Caravan/Sea Safety)</span><span id="valTrade">95 / 100</span></label>
            <input id="slTrade" type="range" min="10" max="100" value="95" oninput="recalcKhaldunEngine()">
          </div>
          <div class="slider-row">
            <label><span>5. 🛡️ Al-Ribāṭ wa Al-Futūwwah (Frontier Defense &amp; Chivalric Discipline)</span><span id="valRibat">90 / 100</span></label>
            <input id="slRibat" type="range" min="10" max="100" value="90" oninput="recalcKhaldunEngine()">
          </div>
          <div class="slider-row">
            <label><span>6. 🕊️ Al-Ṭuruq wa Al-Da'wah (Grassroots Sufi, Merchant &amp; Civic Renewal)</span><span id="valSufi">95 / 100</span></label>
            <input id="slSufi" type="range" min="10" max="100" value="95" oninput="recalcKhaldunEngine()">
          </div>
        </div>

        <!-- Radar SVG & AI Diagnostic Output Column -->
        <div style="background:#070E1E;border:1px solid rgba(212,175,55,0.45);border-radius:14px;padding:1.1rem;">
          <div style="display:grid;grid-template-columns:230px 1fr;gap:1rem;align-items:center;">
            <svg viewBox="0 0 240 240" width="100%%" style="max-width:230px;margin:0 auto;display:block;">
              <circle cx="120" cy="120" r="90" fill="rgba(16,26,48,0.7)" stroke="rgba(212,175,55,0.35)" stroke-width="1.2"/>
              <circle cx="120" cy="120" r="60" fill="none" stroke="rgba(212,175,55,0.2)" stroke-dasharray="3,3"/>
              <circle cx="120" cy="120" r="30" fill="none" stroke="rgba(212,175,55,0.2)" stroke-dasharray="3,3"/>
              <line x1="120" y1="30" x2="120" y2="210" stroke="rgba(255,255,255,0.12)"/>
              <line x1="42" y1="75" x2="198" y2="165" stroke="rgba(255,255,255,0.12)"/>
              <line x1="198" y1="75" x2="42" y2="165" stroke="rgba(255,255,255,0.12)"/>
              <polygon id="khaldunRadarPoly" points="120,34 193,78 196,164 120,205 49,160 44,76" fill="rgba(16,185,129,0.35)" stroke="#10B981" stroke-width="2.6"/>
              <text x="120" y="20" text-anchor="middle" fill="#FDE68A" font-size="8.5" font-weight="700">'ADL (JUSTICE)</text>
              <text x="208" y="72" text-anchor="middle" fill="#38BDF8" font-size="8" font-weight="700">SHŪRĀ</text>
              <text x="208" y="176" text-anchor="middle" fill="#34D399" font-size="8" font-weight="700">WAQF/'ILM</text>
              <text x="120" y="226" text-anchor="middle" fill="#F59E0B" font-size="8.5" font-weight="700">TIJĀRAH</text>
              <text x="32" y="176" text-anchor="middle" fill="#FDA4AF" font-size="8" font-weight="700">RIBĀṬ</text>
              <text x="32" y="72" text-anchor="middle" fill="#C4B5FD" font-size="8" font-weight="700">ṬURUQ</text>
            </svg>

            <div>
              <span id="khaldunStatePill" class="pill" style="border-color:#10B981;color:#34D399;">🌟 SUPREME CIVILIZATIONAL PINNACLE (AL-AWJ AL-A'LĀ)</span>
              <h3 id="khaldunPresetTitle" style="color:#FFF;font-size:1.08rem;margin:0.35rem 0 0.2rem;">
                800 CE Abbasid Baghdad &amp; Cordoban Golden Age Pinnacle
              </h3>
              <div style="display:flex;gap:0.65rem;flex-wrap:wrap;margin:0.45rem 0;">
                <div style="background:#040814;padding:0.4rem 0.65rem;border-radius:8px;border:1px solid rgba(212,175,55,0.3);">
                  <small style="color:#94A3B8;font-size:0.68rem;display:block;">STATE SCORE</small>
                  <strong id="khaldunStateScore" style="color:#FDE68A;font-family:Consolas,monospace;">93.2 / 100</strong>
                </div>
                <div style="background:#040814;padding:0.4rem 0.65rem;border-radius:8px;border:1px solid rgba(16,185,129,0.3);">
                  <small style="color:#94A3B8;font-size:0.68rem;display:block;">GRASSROOTS REBIRTH INDEX</small>
                  <strong id="khaldunRebirthScore" style="color:#34D399;font-family:Consolas,monospace;">96.5 / 100</strong>
                </div>
              </div>
              <p id="khaldunDiagnosisText" style="font-size:0.81rem;color:#CBD5E1;">
                <strong>Ibn Khaldūn Diagnostic:</strong> High court justice (<em>'Adl</em>), consultative cohesion (<em>Shūrā</em>), and massive <em>Waqf</em> scientific investment produce simultaneous territorial, economic, and intellectual expansion across all four compass directions.
              </p>
            </div>
          </div>
          <div id="khaldunCounterfactualBox" class="sub-box" style="margin-top:0.75rem;border-left-color:#D4AF37;">
            <strong style="color:#FDE68A;">📜 Historical Circle of Justice (Dā'irat Al-'Adl) &amp; Rebirth Law:</strong>
            <span id="khaldunLawText">When both State Organs ('Adl/Shūrā/Ribāṭ) and Civil Society Organs (Waqf/Tijārah/Ṭuruq) exceed 85, Islamic civilization achieves a multi-century Golden Age Pinnacle.</span>
          </div>
        </div>
      </div>
    </section>

    <!-- =========================================================================================
         INTERACTIVE ENGINE #3: 8-SCENARIO HISTORICAL TURNING-POINT WARGAME & DECISION SIMULATOR
         ========================================================================================= -->
    <h2 class="sec-title" id="turningPointWargame">IV. Interactive Engine #3: Command the 8 Crucial Turning Points of Islamic History (Interactive Decision &amp; Counterfactual Wargame)</h2>
    <p class="sec-lead">
      Step into the council tent at <strong>8 decisive moments of Conquest, Pinnacle, Recession, and Rebirth</strong> across East, West, North, and South. Choose a strategic course of action to see the <strong>Canonical Historical Outcome</strong> vs. counterfactual alternatives!
    </p>

    <section class="sim-stage">
      <div class="era-pills-bar" id="wargameScenarioTabs">
        <button type="button" class="era-pill-btn active" onclick="loadWargameScenario(0, this)">1. 🕊️ 628 CE: Ḥudaybiyyah</button>
        <button type="button" class="era-pill-btn" onclick="loadWargameScenario(1, this)">2. ⚔️ 636 CE: Yarmūk &amp; Qādisiyyah</button>
        <button type="button" class="era-pill-btn" onclick="loadWargameScenario(2, this)">3. 🌊 711 CE: Gibraltar &amp; Sindh</button>
        <button type="button" class="era-pill-btn" onclick="loadWargameScenario(3, this)">4. 🛡️ 1086 CE: Almoravid Zallāqah</button>
        <button type="button" class="era-pill-btn" onclick="loadWargameScenario(4, this)">5. 🕌 1187 CE: Ḥiṭṭīn &amp; Jerusalem</button>
        <button type="button" class="era-pill-btn" onclick="loadWargameScenario(5, this)">6. ⚡ 1260 CE: 'Ayn Jālūt &amp; Berke Khan</button>
        <button type="button" class="era-pill-btn" onclick="loadWargameScenario(6, this)">7. 🏰 1453 CE: Constantinople</button>
        <button type="button" class="era-pill-btn" onclick="loadWargameScenario(7, this)">8. ⛵ 1650 CE: Omani Naval Liberation</button>
      </div>

      <div class="sim-split">
        <div style="background:#081020;border:1px solid rgba(212,175,55,0.4);border-radius:13px;padding:1.1rem;">
          <div class="badge-row">
            <span id="wgVectorBadge" class="pill">🧭 COMPASS VECTOR: CORE HIJAZ -> ALL 4 DIRECTIONS</span>
            <span id="wgDateBadge" class="pill" style="border-color:#38BDF8;color:#38BDF8;">6 AH / 628 CE</span>
          </div>
          <h3 id="wgTitle" style="color:#FFF;font-size:1.14rem;margin-bottom:0.35rem;">
            Scenario #1: The Plains of Al-Ḥudaybiyyah Outside Mecca (628 CE)
          </h3>
          <p id="wgContext" style="font-size:0.84rem;color:#CBD5E1;margin-bottom:0.85rem;">
            You have marched peacefully with 1,400 unarmed pilgrims wearing <em>Iḥrām</em> from Medina to perform <em>'Umrah</em>. Quraysh blocks the road and offers a 10-year truce that requires returning to Medina this year without entering Mecca. Some companions urge immediate battle. What is your command?
          </p>
          <div id="wgChoicesContainer"></div>
        </div>

        <div style="background:#06121E;border:1px solid #10B981;border-radius:13px;padding:1.1rem;">
          <span id="wgOutcomeBadge" class="pill" style="border-color:#10B981;color:#34D399;">SELECT A STRATEGIC COMMAND ON THE LEFT</span>
          <h3 id="wgOutcomeTitle" style="color:#FDE68A;font-size:1.08rem;margin:0.4rem 0 0.35rem;">
            Canonical Decision &amp; Historical Consequence Analysis
          </h3>
          <p id="wgOutcomeBody" style="font-size:0.84rem;color:#E2E8F0;margin-bottom:0.65rem;">
            Click any of the 3 strategic options on the left to evaluate its military, diplomatic, spiritual, and directional impact across Islamic history.
          </p>
          <div class="sub-box" style="border-left-color:#38BDF8;">
            <strong style="color:#38BDF8;">🧭 Directional Impact on N / S / E / W Frontiers:</strong>
            <p id="wgDirectionalEffect" style="margin-top:0.2rem;">The 10-year peace of Ḥudaybiyyah freed the Prophet ﷺ to dispatch diplomatic epistles North (Byzantium), East (Persia &amp; Bahrain), West (Egypt), and South (Abyssinia, Yemen &amp; Oman), doubling the Muslim community in 24 months!</p>
          </div>
        </div>
      </div>
    </section>

    <!-- =========================================================================================
         INTERACTIVE ENGINE #4: CARAVAN (QAFILAH) & MONSOON DHOW (SANBUQ) EXPEDITION PLANNER
         ========================================================================================= -->
    <h2 class="sec-title" id="caravanMonsoonPlanner">V. Interactive Engine #4: N/S/E/W Caravan (<em>Qāfilah</em>) &amp; Monsoon Dhow (<em>Sanbūq</em>) Expedition Planner</h2>
    <p class="sec-lead">
      Plan a canonical overland caravan or Indian Ocean monsoon voyage between any two historical capitals across <strong>North, South, East, and West</strong>. Computes real spherical distance, <em>Marḥalah</em> caravan stages, <em>Kamāl</em> Polaris star altitude (<em>Iṣba'</em>), Qiblah azimuth, and <em>Waqf / Ibn Al-Sabīl</em> provisions!
    </p>

    <section class="sim-stage">
      <div style="display:flex;flex-wrap:wrap;gap:0.75rem;align-items:center;margin-bottom:1rem;background:rgba(4,7,17,0.82);padding:0.85rem 1rem;border-radius:12px;border:1px solid var(--border-gold);">
        <div>
          <label style="font-size:0.74rem;color:#FDE68A;display:block;margin-bottom:0.2rem;">ORIGIN HUB:</label>
          <select id="expOriginSelect" class="select-box" onchange="calculateExpeditionRoute()">
            <option value="0">🕋 Makkah / Madinah (Hijaz Core — 21.4°N, 39.8°E)</option>
            <option value="1">🏛️ Baghdad (Abbasid East — 33.3°N, 44.4°E)</option>
            <option value="2">🕌 Cairo / Fustat (Nile &amp; Red Sea — 30.0°N, 31.2°E)</option>
            <option value="3">⛵ Muscat / Sohar (Omani Coast — 23.6°N, 58.4°E)</option>
            <option value="4">🌹 Aden / Zabīd (Yemeni Gate — 12.8°N, 45.0°E)</option>
            <option value="5">🌿 Fez / Marrakesh (Maghreb West — 31.6°N, -8.0°E)</option>
            <option value="6">🏰 Istanbul / Konstantiniyye (North — 41.0°N, 29.0°E)</option>
          </select>
        </div>
        <div>
          <label style="font-size:0.74rem;color:#34D399;display:block;margin-bottom:0.2rem;">DESTINATION FRONTIER (N / S / E / W):</label>
          <select id="expDestSelect" class="select-box" onchange="calculateExpeditionRoute()">
            <option value="7">📜 Samarkand &amp; Bukhara (EAST Silk Road — 39.7°N, 66.9°E)</option>
            <option value="8">🌺 Aceh &amp; Malacca (EAST Nusantara — 5.5°N, 95.3°E)</option>
            <option value="9">👑 Delhi &amp; Agra (EAST Hind — 28.6°N, 77.2°E)</option>
            <option value="10">🕌 Córdoba &amp; Granada (WEST Al-Andalus — 37.9°N, -4.8°E)</option>
            <option value="11">🌴 Timbuktu &amp; Sokoto (WEST Bilād Al-Sūdān — 16.8°N, -3.0°E)</option>
            <option value="12">❄️ Volga Bulgaria / Kazan (NORTH Steppe — 55.8°N, 49.1°E)</option>
            <option value="13">⛵ Stone Town, Zanzibar &amp; Kilwa (SOUTH Swahili — -6.2°S, 39.2°E)</option>
          </select>
        </div>
        <div>
          <label style="font-size:0.74rem;color:#38BDF8;display:block;margin-bottom:0.2rem;">CONVOY MODE:</label>
          <select id="expModeSelect" class="select-box" onchange="calculateExpeditionRoute()">
            <option value="CARAVAN">🐪 Camel Caravan (Qāfilah • 35 km / Marḥalah day)</option>
            <option value="DHOW">⛵ Monsoon Lateen Dhow (Sanbūq • 165 km / 8 Zām day)</option>
            <option value="BARID">🐎 Caliphal Barīd Postal Relay (190 km / day)</option>
          </select>
        </div>
        <button type="button" class="btn-ctrl" style="align-self:flex-end;padding:0.55rem 1rem;" onclick="calculateExpeditionRoute(true)">🚀 Plot Route on World Map</button>
      </div>

      <div class="grid-3">
        <div class="sub-box" style="border-left:4px solid #D4AF37;margin:0;">
          <strong style="color:#FDE68A;">📏 Geodesic Distance, Stages &amp; Duration</strong>
          <div id="expDistanceReadout" style="font-size:1.1rem;color:#FFF;font-family:Consolas,monospace;font-weight:700;margin:0.25rem 0;">2,985 km • 85 Marḥalah Stages</div>
          <p id="expDurationReadout" style="font-size:0.8rem;color:#CBD5E1;">Estimated Transit: 85 Days by Camel Caravan (with every 7th day rest at a fortified Khān).</p>
        </div>
        <div class="sub-box" style="border-left:4px solid #38BDF8;margin:0;">
          <strong style="color:#38BDF8;">🧭 Kamāl Star Altitude, Rhumb &amp; Qiblah Bearing</strong>
          <div id="expNavReadout" style="font-size:1.05rem;color:#34D399;font-family:Consolas,monospace;font-weight:700;margin:0.25rem 0;">Dest Kamāl: 24.68 Iṣba' • Qiblah: 240.1° SW</div>
          <p id="expStarReadout" style="font-size:0.8rem;color:#CBD5E1;">Guided by <em>Al-Jāh</em> (Polaris) and <em>Maṭla' Al-'Ayyūq</em> (NE Star Rhumb).</p>
        </div>
        <div class="sub-box" style="border-left:4px solid #10B981;margin:0;">
          <strong style="color:#34D399;">🏺 Alchemical Hygiene, Waqf Wells &amp; Caravan Law</strong>
          <p id="expLogisticsReadout" style="font-size:0.8rem;color:#CBD5E1;margin-top:0.2rem;">
            Protected by <em>Amīr Al-Rakb</em> and rear-guard <em>Ṣāḥib Al-Sāqah</em>; carries <em>Ṣābūn Ḥalabī</em>, distilled <em>Mā' Al-Ward</em>, brass <em>Ibrīq</em>, and <em>Suftajah</em> letters of credit; <em>Ibn Al-Sabīl</em> Waqf cisterns every 24 miles.
          </p>
        </div>
      </div>
    </section>

    <!-- =========================================================================================
         INTERACTIVE ENGINE #5: AI MAJLIS AL-HIKMAH MULTI-SCHOLAR INQUIRY & SYNTHESIS ORACLE
         ========================================================================================= -->
    <h2 class="sec-title" id="majlisAiOracle">VI. Interactive Engine #5: The AI <em>Majlis Al-Ḥikmah</em> Multi-Scholar Inquiry &amp; Historical Synthesis Console</h2>
    <p class="sec-lead">
      Ask any question about Islamic conquests, Caliphates, East/West/North/South movements, Pinnacles, Recessions, Navigation, Hygiene, Caravan Governance, or Suffrage — or click one of the <strong>8 Canonical Inquiry Topics</strong> below to receive a synthesized multi-scholar response from <strong>Ibn Khaldūn</strong>, <strong>Aḥmad ibn Mājid</strong>, <strong>Al-Bīrūnī / Al-Khwārizmī</strong>, and <strong>Nana Asma'u / Al-Māwardī</strong>.
    </p>

    <section class="sim-stage">
      <div class="era-pills-bar" style="margin-bottom:0.8rem;">
        <button type="button" class="era-pill-btn active" onclick="askMajlisTopic('MONGOL_REBIRTH')">1. ⚡ Why did 1258 Baghdad lead to Mongol Conversion?</button>
        <button type="button" class="era-pill-btn" onclick="askMajlisTopic('NUSANTARA_EAST')">2. 🌺 How did Islam reach Indonesia &amp; Malaysia peacefully?</button>
        <button type="button" class="era-pill-btn" onclick="askMajlisTopic('ANDALUS_WEST')">3. 🕌 When Granada fell in 1492, where did Western Islam expand?</button>
        <button type="button" class="era-pill-btn" onclick="askMajlisTopic('VOLGA_NORTH')">4. ❄️ How did Islam reach Russia/Volga Bulgaria in 922 CE?</button>
        <button type="button" class="era-pill-btn" onclick="askMajlisTopic('OMAN_SOUTH')">5. ⛵ How did Oman &amp; Yemen defeat the Portuguese in the Indian Ocean?</button>
        <button type="button" class="era-pill-btn" onclick="askMajlisTopic('SUFFRAGE_SHURA')">6. 🗳️ How did Islamic Suffrage (Shūrā, Bay'ah &amp; 58:1) work?</button>
        <button type="button" class="era-pill-btn" onclick="askMajlisTopic('CARAVAN_MAN')">7. 🐪 How did Islam protect the man lost or left behind by the caravan?</button>
        <button type="button" class="era-pill-btn" onclick="askMajlisTopic('PINNACLE_LAW')">8. 📈 What is the Qur'anic law governing Pinnacles &amp; Recessions?</button>
      </div>

      <div style="display:flex;gap:0.6rem;margin-bottom:1rem;flex-wrap:wrap;">
        <input id="majlisCustomInput" class="search-inp" style="flex:1;margin:0;" type="text" placeholder="Type any question for the Majlis Al-Hikmah AI Synthesis Engine (e.g., 'Mongol conversion', 'Oman Zanzibar compass', 'Andalus Granada', 'Sokoto suffrage', 'Caravan hygiene', 'Volga North')..." onkeydown="if(event.key==='Enter') runCustomMajlisQuery()">
        <button type="button" class="btn-ctrl" style="padding:0.6rem 1.15rem;" onclick="runCustomMajlisQuery()">🧠 Consult Majlis Al-Ḥikmah</button>
      </div>

      <div class="grid-2" id="majlisResponseGrid">
        <div class="sub-box" style="border-left:4px solid #D4AF37;margin:0;">
          <strong style="color:#FDE68A;">📜 Imām Ibn Khaldūn (Historian of Pinnacles, Recessions &amp; 'Umrān):</strong>
          <p id="majlisKhaldun" style="margin-top:0.25rem;">When Hulagu sacked Baghdad in 1258 CE, observers thought Islam had ended. Yet within 24 months, Mamluk Cairo halted the Mongols at 'Ayn Jālūt (1260), and Sufi shaykhs and Muslim administrators converted Berke Khan (Golden Horde, 1257) and Ghazan Khan (Ilkhanate, 1295)—turning the nomadic conquerors into the builders of Islamic Samarkand and Tabriz!</p>
        </div>
        <div class="sub-box" style="border-left:4px solid #38BDF8;margin:0;">
          <strong style="color:#38BDF8;">🧭 Shihāb al-Dīn Aḥmad ibn Mājid (Master of the 4 Compass Directions):</strong>
          <p id="majlisMajid" style="margin-top:0.25rem;">While land armies clashed in the North and West, our sewn dhows sailed by the 32-point star compass (Dā'irat Al-Akhnān) and the Kamāl across the Southern and Eastern monsoon lanes—linking Aden, Sohar, and Muscat to Zanzibar, Malabar, Aceh (1267 CE), and Malacca without a single military invasion.</p>
        </div>
        <div class="sub-box" style="border-left:4px solid #10B981;margin:0;">
          <strong style="color:#34D399;">🔬 Al-Bīrūnī &amp; Al-Khwārizmī (Science, Geodesy &amp; Institutional Continuity):</strong>
          <p id="majlisBiruni" style="margin-top:0.25rem;">Because Islamic astronomy, algebra, optics, and clinical medicine were endowed across polycentric Waqf observatories and Bīmāristāns from Córdoba and Cairo to Maragheh and Samarkand, the loss of any single city never extinguished the scientific corpus.</p>
        </div>
        <div class="sub-box" style="border-left:4px solid #F43F5E;margin:0;">
          <strong style="color:#FDA4AF;">⚖️ Nana Asma'u &amp; Al-Māwardī (Governance, Suffrage &amp; Grassroots Rebirth):</strong>
          <p id="majlisAsmau" style="margin-top:0.25rem;">Islam's resilience lies in its self-governing civil fabric: independent Fiqh courts, Waqf schools, Sūrat Al-Mujādilah (58:1) grievance redress, and grassroots movements like the Qādiriyyah and Yan Taru women's literacy network that regenerate the Ummah from below.</p>
        </div>
      </div>
    </section>

    <h2 class="sec-title">VII. The Four Cardinal Compass Vectors of Islamic History: East, West, North &amp; South</h2>
    <p class="sec-lead">
      Filter or compare how Islam moved across all four directions of the compass — through both caliphal conquests and peaceful maritime/Sufi movements — including each direction's supreme pinnacle and how it responded to territorial recessions.
    </p>
    <div class="era-pills-bar" style="margin-bottom:1rem;">
      <button type="button" class="era-pill-btn active" onclick="filterDirectionCards('ALL', this)">🧭 Show All 4 Compass Directions (N • S • E • W)</button>
      <button type="button" class="era-pill-btn" onclick="filterDirectionCards('EAST', this)">➡ EAST (Al-Mashriq: Iraq -> Samarkand -> India -> Nusantara)</button>
      <button type="button" class="era-pill-btn" onclick="filterDirectionCards('WEST', this)">⬅ WEST (Al-Maghrib: Egypt -> Kairouan -> Al-Andalus -> Timbuktu/Sokoto)</button>
      <button type="button" class="era-pill-btn" onclick="filterDirectionCards('NORTH', this)">⬆ NORTH (Al-Shamāl: Damascus -> Volga 922 -> Anatolia -> Istanbul/Vienna)</button>
      <button type="button" class="era-pill-btn" onclick="filterDirectionCards('SOUTH', this)">⬇ SOUTH (Al-Janūb: Abyssinia -> Yemen/Oman -> Zanzibar, Kilwa &amp; Sofala)</button>
    </div>
    <div class="grid-2" id="directionCardsGrid">
      %s
    </div>

    <h2 class="sec-title">VIII. The 10 Canonical Muslim Movements (How Islam Governed, Expanded &amp; Regenerated Beyond Dynasties)</h2>
    <p class="sec-lead">
      Caliphates and dynasties rose and dissolved, yet Islam itself never receded from the hearts of its peoples because it was carried by <strong>10 Canonical Movements</strong> operating from the grassroots to the global horizon.
    </p>
    <input id="movementSearchInput" class="search-inp" type="text" placeholder="Search the 10 Canonical Movements (e.g., Hijrah, Futuhat, Amsar, Fiqh, Hadith, Bayt Al-Hikmah, Ribat, Sufi, Qadiriyyah, Naqshbandiyyah, Omani Dhow, Waqf, Sokoto, Nahdah)..." oninput="filterMovementCards()">
    <div class="grid-2" id="movementsGrid">
      %s
    </div>

    <h2 class="sec-title">IX. The 8 Great Pinnacle, Recession &amp; Miraculous Rebirth Cycles (<em>Sunnat Al-Tadāwul</em> — Qur'an 3:140)</h2>
    <p class="sec-lead">
      In canonical Islamic historiography, every political or territorial recession (<em>Inḥisār</em>) immediately triggered a spiritual, intellectual, or geographic rebirth (<em>Inbi'āth</em>) along another compass vector.
    </p>
    <div class="grid-2">
      %s
    </div>

    <h2 class="sec-title">X. Complete 16-Era Master Chronological Matrix (Click Any Row to Launch in the Interactive Simulator)</h2>
    <div style="overflow-x:auto;border:1px solid var(--border-gold);border-radius:12px;background:var(--bg-card);">
      <table>
        <thead>
          <tr>
            <th>Era Step</th>
            <th>Dates (CE / AH)</th>
            <th>Era Headline &amp; Arabic Title</th>
            <th>Phase &amp; Reach</th>
            <th>Active Canonical Movements</th>
            <th>Supreme Pinnacle (Al-Awj)</th>
            <th>Recession &amp; Rebirth Dynamic</th>
          </tr>
        </thead>
        <tbody>
          %s
        </tbody>
      </table>
    </div>
  </main>
""".formatted(
                eraButtonsHtml.toString(),
                eraPolygonsSvg.toString(),
                wavePointsSvg.toString(),
                waveNodesSvg.toString(),
                axesHtml.toString(),
                movementsHtml.toString(),
                cyclesHtml.toString(),
                eraTableRowsHtml.toString()
        ) + """
  <script>
    const SIM_ERAS = [
      %s
    ];

    const MAP_BEACONS = [
      { badge: "BEACON #01 • 622–630 CE", dir: "🧭 ORIGIN FULCRUM (N • S • E • W)", title: "🕋 Makkah, Madinah, Battle of Badr (624 CE), Ḥudaybiyyah (628 CE) & Opening of Mecca (630 CE)", desc: "The spiritual and constitutional fulcrum of Islam: from the Hijrah and Sahifat Al-Madinah (622 CE) to Badr and the bloodless Opening of Mecca (630 CE), launching diplomatic epistles and movements in all four directions.", era: 1 },
      { badge: "BEACON #02 • 636–637 CE", dir: "⬆ NORTH & WEST OPENING", title: "⚔️ Battle of Yarmūk (636 CE) & Caliph ’Umar’s Assurance in Jerusalem (637 CE)", desc: "Khālid ibn al-Walīd and Abū ’Ubaydah decisively open Bilād al-Shām at Yarmūk; Caliph ’Umar enters Jerusalem on foot and signs Al-’Uhdah Al-’Umariyyah guaranteeing Christian churches and welcoming Jewish families back to Jerusalem.", era: 2 },
      { badge: "BEACON #03 • 636 / 762 / 1258 CE", dir: "➡ EASTERN HEARTLAND", title: "🏛️ Al-Qādisiyyah (636 CE), Round City of Baghdad Pinnacle (762 CE) & 1258 Siege", desc: "Sa’d ibn Abī Waqqāṣ opens Iraq at Al-Qādisiyyah; Al-Manṣūr and Hārūn al-Rashīd make Baghdad the world’s scientific capital (Bayt Al-Ḥikmah); after Hulagu’s 1258 sack, the conquerors themselves convert to Islam by 1295!", era: 4 },
      { badge: "BEACON #04 • 711–1492 CE", dir: "⬅ WESTERN EUROPEAN FRONTIER", title: "🕌 Crossing of Gibraltar (711 CE), Caliphate of Córdoba (929 CE) & Alhambra of Granada (1492 CE)", desc: "Ṭāriq ibn Ziyād crosses Jabal Ṭāriq in 711 CE, initiating 781 years of Andalusian civilization (Mezquita of Córdoba, Al-Zahrāwī’s surgery, Ibn Rushd’s philosophy, and the Alhambra) before the 1492 recession and Ottoman/Moroccan rescue.", era: 3 },
      { badge: "BEACON #05 • 710 / 751 / 1400 CE", dir: "➡ EASTERN SILK ROAD", title: "📜 Samarkand, Bukhara & Battle of Talas (751 CE) -> Timurid Observatory (1420 CE)", desc: "The Battle of Talas (751 CE) brings papermaking from Tang China to Samarkand and Baghdad, sparking the global manuscript revolution; home to Imām Al-Bukhārī, Ibn Sīnā, Bahā’ al-Dīn Naqshband, and Ulugh Beg’s giant astronomical sextant.", era: 4 },
      { badge: "BEACON #06 • 922 / 1257 CE", dir: "⬆ NORTHERN EURASIAN FRONTIER", title: "❄️ Volga Bulgaria Conversion (922 CE) & Islamization of the Golden Horde (1257–1313 CE)", desc: "In 922 CE (66 years before Kievan Rus’ adopted Christianity!), King Almish of Volga Bulgaria (modern Tatarstan/Kazan) embraced Islam with Aḥmad ibn Faḍlān’s Abbasid embassy; in 1257 CE, Berke Khan made the Golden Horde the northern shield of Islam.", era: 8 },
      { badge: "BEACON #07 • 26 AUGUST 1071 CE", dir: "⬆ NORTHERN ANATOLIAN OPENING", title: "🏹 Battle of Manzikert (Malāzgird, 1071 CE) — Opening of Anatolia", desc: "Seljuk Sultan Alp Arslan defeats Emperor Romanos IV Diogenes at Manzikert, transforming Anatolia (Rūm) into a permanent Turkish-Islamic heartland centered at Konya, Bursa, Edirne, and ultimately Istanbul.", era: 6 },
      { badge: "BEACON #08 • 1187 & 1260 CE", dir: "🛡️ TWIN MIRACULOUS REBIRTHS", title: "🛡️ Ṣalāḥ al-Dīn at Ḥiṭṭīn (1187 CE) & Qutuz/Baybars at ’Ayn Jālūt (1260 CE)", desc: "Within the same Levantine corridor, Ṣalāḥ al-Dīn reversed the First Crusade recession at Ḥiṭṭīn (4 July 1187), and 73 years later Mamluk Sultans Qutuz and Baybars shattered Hulagu’s Mongol army at ’Ayn Jālūt (3 September 1260).", era: 8 },
      { badge: "BEACON #09 • 29 MAY 1453 CE", dir: "⬆ NORTHERN IMPERIAL PINNACLE", title: "🏰 Sultan Mehmed II Al-Fātiḥ Opens Constantinople (Kostantiniyye / Istanbul, 1453 CE)", desc: "At age 21, Mehmed II hauls 70 Ottoman ships over greased timber rollers across Galata into the Golden Horn, fulfilling the Prophetic Hadith and establishing Istanbul as the tricontinental seat of the Ottoman Empire.", era: 10 },
      { badge: "BEACON #10 • 1324 & 1804 CE", dir: "⬅ WEST AFRICAN PINNACLE", title: "👑 Mansa Musa’s Timbuktu (1324 CE) & Usman dan Fodio / Nana Asma’u’s Sokoto Caliphate (1804 CE)", desc: "As Iberia receded, West Africa surged: Mansa Musa endowed Sankore University in Timbuktu, and in 1804 Shaykh Usman dan Fodio and his daughter Nana Asma’u (founder of the Yan Taru women’s scholarly movement) built Africa’s largest 19th-century state.", era: 13 },
      { badge: "BEACON #11 • 1650–1856 CE", dir: "⬇ SOUTHERN INDIAN OCEAN REBIRTH", title: "⛵ Omani Ya’rubid Liberation of Muscat (1650) & Mombasa (1698) -> Muscat-Zanzibar Empire", desc: "The Omani Ya’rubid navy expelled the Portuguese from Muscat (1650) and Fort Jesus in Mombasa (1698), and under Sayyid Sa’īd bin Sulṭān (1806–1856) united Muscat and Zanzibar into a Southern Hemisphere maritime superpower.", era: 12 },
      { badge: "BEACON #12 • 1267–PRESENT", dir: "➡ EASTERN MARITIME PINNACLE", title: "🌺 Samudera Pasai in Aceh (1267), Malacca (1400) & The Wali Songo of Java (1475)", desc: "Through Hadhrami, Omani, and Gujarati monsoon merchants and Sufi saints (Wali Songo), the Malay-Indonesian Nusantara archipelago peacefully embraced Islam—becoming the most populous Muslim region on earth today (280+ million).", era: 10 }
    ];

    const WARGAME_SCENARIOS = [
      {
        vec: "🧭 CORE HIJAZ -> ALL 4 DIRECTIONS", date: "6 AH / 628 CE",
        title: "Scenario #1: The Plains of Al-Ḥudaybiyyah Outside Mecca (628 CE)",
        context: "You have marched peacefully with 1,400 unarmed pilgrims in Iḥrām to perform ’Umrah. Quraysh blocks entry and offers a 10-year non-aggression treaty that requires returning to Medina this year and returning Meccan converts without guardian permission. What is your decision?",
        directionalEffect: "The 10-year peace of Ḥudaybiyyah freed the Prophet ﷺ to dispatch diplomatic epistles North (Heraclius), East (Khosrow & Bahrain), West (Al-Muqawqis in Egypt), and South (Negus of Abyssinia, Yemen & Oman) — doubling the Muslim community in 2 years and leading to the bloodless Opening of Mecca in 630 CE!",
        choices: [
          { label: "A. Sign the 10-Year Treaty of Al-Ḥudaybiyyah (Canonical Prophetic Decision)", canonical: true, outcome: "✅ CANONICAL MASTERSTROKE (Qur’an 48:1 — Sūrat Al-Fatḥ): Though outwardly a concession, the 10-year truce allowed free peaceful interaction across Arabia. More people entered Islam in the 2 years after Ḥudaybiyyah than in the previous 18 years combined, culminating in the bloodless Opening of Mecca (630 CE)." },
          { label: "B. Force an immediate battle outside Mecca with only 1,400 lightly armed pilgrims", canonical: false, outcome: "⚠️ COUNTERFACTUAL RISK: Fighting inside the Sacred Sanctuary without siege preparation would have caused heavy casualties on both sides and alienated neutral Arab tribes." },
          { label: "C. Retreat permanently to Medina without signing any treaty or truce", canonical: false, outcome: "⚠️ COUNTERFACTUAL STALEMATE: Without the 10-year truce, northern (Khaybar/Mu’tah) and international diplomatic missions to Egypt, Persia, Yemen, and Oman would have remained blocked by ongoing Meccan raids." }
        ]
      },
      {
        vec: "⬆ NORTH (YARMŪK) & ➡ EAST (QĀDISIYYAH)", date: "13–15 AH / 634–636 CE",
        title: "Scenario #2: Simultaneous Byzantine & Sasanian Superpower Fronts (636 CE)",
        context: "The Rāshidūn Caliphate faces Emperor Heraclius’s massive Byzantine army in Syria (Yarmūk) while Sasanian general Rostam Farrokhzād mobilizes imperial war elephants in Iraq (Al-Qādisiyyah). Khālid ibn al-Walīd is in Iraq while the Syrian corps faces encirclement. How do you coordinate the two fronts?",
        directionalEffect: "Khālid’s legendary 18-day desert march from Iraq to Syria united the northern armies at Yarmūk (August 636), while Sa’d ibn Abī Waqqāṣ defeated the Sasanian elephants at Al-Qādisiyyah (November 636) — opening both the Northern Levant and Eastern Persia simultaneously!",
        choices: [
          { label: "A. Order Khālid ibn al-Walīd across the waterless Syrian Desert to unite the armies at Yarmūk, then reinforce Sa’d ibn Abī Waqqāṣ at Al-Qādisiyyah (Canonical Decision)", canonical: true, outcome: "✅ CANONICAL PINNACLE: Khālid’s 18-day desert crossing stunned the Byzantines at Yarmūk (636 CE), and immediately afterward Syrian reinforcements helped Sa’d triumph at Al-Qādisiyyah — toppling two superpower fronts in a single year!" },
          { label: "B. Abandon the Eastern Iraqi front entirely and pull all forces back to Medina", canonical: false, outcome: "⚠️ COUNTERFACTUAL RECESSION: Leaving the Euphrates undefended would have allowed Sasanian heavy cavalry to strike the Arabian heartland from the East." },
          { label: "C. Fight fragmented local skirmishes in separate city-by-city detachments", canonical: false, outcome: "⚠️ COUNTERFACTUAL DEFEAT: Caliph Abū Bakr and ’Umar specifically forbade fragmented detachments, ordering concentration at Yarmūk and Qādisiyyah with the desert at the Muslims’ backs." }
        ]
      },
      {
        vec: "⬅ WEST (GIBRALTAR 711) & ➡ EAST (SINDH 711)", date: "92 AH / 711 CE",
        title: "Scenario #3: The Simultaneous 711 CE Openings of Al-Andalus (West) & Sindh (East)",
        context: "In the exact same year (711 CE), Ṭāriq ibn Ziyād lands at Gibraltar in the far West while 17-year-old Muḥammad ibn Qāsim marches into Sindh (Indus Valley) in the far East. How do you govern the local Christian, Jewish, Hindu, and Buddhist populations?",
        directionalEffect: "By granting covenantal protection (Dhimmah), religious freedom, and local judicial autonomy in both Córdoba/Toledo and Al-Rūr/Multan, the Umayyad Caliphate reached its 11.1M km² transcontinental pinnacle from Lisbon to the Indus!",
        choices: [
          { label: "A. Establish covenantal protection, religious autonomy (including the Brahmanabad Settlement in Sindh), and fair taxation (Canonical Decision)", canonical: true, outcome: "✅ CANONICAL PINNACLE: In Al-Andalus, oppressed Visigothic towns and Sephardic Jews welcomed Ṭāriq’s forces; in Sindh, Muḥammad ibn Qāsim’s Brahmanabad Covenant accorded Hindus and Buddhists the same protected status as People of the Book, anchoring Islam in both Iberia and South Asia!" },
          { label: "B. Impose forced conversion or expel local administrators", canonical: false, outcome: "⚠️ COUNTERFACTUAL VIOLATION: Directly violates Qur’an 2:256 ('There is no compulsion in religion') and would have caused immediate rebellion across both 5,000-km frontiers." },
          { label: "C. Conduct a brief coastal raid and withdraw back to Tangier and Makran", canonical: false, outcome: "⚠️ COUNTERFACTUAL LOSS: Without permanent urban foundations, neither Cordoban science nor Indo-Islamic civilization would have emerged." }
        ]
      },
      {
        vec: "⬅ WESTERN RIBĀṬ COUNTER-WAVE", date: "479 AH / 1086 CE",
        title: "Scenario #4: The 1085 Fall of Toledo & The Almoravid Ribāṭ Appeal (1086 CE)",
        context: "Al-Andalus has fractured into rival Taifa kingdoms. Alfonso VI captures Toledo in 1085 CE and demands crushing tribute from Seville and Badajoz. The Andalusian scholars and King Al-Mu’tamid appeal to Yūsuf ibn Tāshfīn, leader of the Saharan-Moroccan Almoravid (Al-Murābiṭūn) movement. What do you do?",
        directionalEffect: "Yūsuf ibn Tāshfīn crossed the Strait of Gibraltar, won the decisive Battle of Zallāqah (Sagrajas, 1086 CE), and united Morocco, Senegal/Mauritania, and Al-Andalus — halting the Iberian recession for another 406 years (until 1492)!",
        choices: [
          { label: "A. Cross the Strait of Gibraltar with the Almoravid Ribāṭ army, refuse personal spoils, and unite the Maghreb and Al-Andalus at Zallāqah (Canonical Decision)", canonical: true, outcome: "✅ CANONICAL FRONTIER REBIRTH: At age 79, Yūsuf ibn Tāshfīn crossed the Strait, defeated Alfonso VI at Zallāqah (23 October 1086), distributed all war spoils to local defenders, and preserved Andalusian Islam for four more centuries (allowing Ibn Rushd, Ibn Zuhr, and the Alhambra to flourish)!" },
          { label: "B. Remain in Marrakesh and leave the Iberian Taifa kings to pay tribute", canonical: false, outcome: "⚠️ COUNTERFACTUAL RECESSION: Seville, Córdoba, and Granada would have fallen in the 1090s — four centuries earlier than 1492." },
          { label: "C. Demand half of Al-Andalus’s treasury before sending ships", canonical: false, outcome: "⚠️ COUNTERFACTUAL FRACTURE: Fiscal extortion would have driven the Taifa states into alliances with Castile." }
        ]
      },
      {
        vec: "⬆⬇ LEVANTINE-EGYPTIAN REBIRTH", date: "583 AH / 1187 CE",
        title: "Scenario #5: Ṣalāḥ al-Dīn at the Horns of Ḥiṭṭīn & The Gate of Jerusalem (1187 CE)",
        context: "After uniting Fatimid Egypt and Zangid Syria, Ṣalāḥ al-Dīn cuts the Crusader army off from the springs of Lake Tiberias at the Horns of Ḥiṭṭīn (4 July 1187) and marches to Jerusalem (captured in 1099 with a massacre of its inhabitants). When Balian of Ibelin offers surrender, how do you enter Jerusalem?",
        directionalEffect: "Ṣalāḥ al-Dīn’s chivalric amnesty in October 1187 reversed the 88-year Crusader recession while earning universal moral admiration across East and West, and his brother Turan-Shah simultaneously secured Yemen and the Red Sea!",
        choices: [
          { label: "A. Control the water springs at Ḥiṭṭīn, then grant merciful amnesty, safe conduct, and Christian pilgrimage rights in Jerusalem (Canonical Decision)", canonical: true, outcome: "✅ CANONICAL MORAL & MILITARY PINNACLE: On 2 October 1187 (27 Rajab, anniversary of Al-Isrā’ wa Al-Mi’rāj), Ṣalāḥ al-Dīn entered Jerusalem without a single massacre, paid the ransoms of poor Franks from his own treasury, and restored Al-Aqṣā and the Covenant of ’Umar!" },
          { label: "B. Attack the heavily fortified Crusader castles directly without luring the field army to Ḥiṭṭīn", canonical: false, outcome: "⚠️ COUNTERFACTUAL ATTRITION: Years of siege warfare against Krak des Chevaliers and Tyre would have exhausted the Ayyubid coalition before Third Crusade reinforcements arrived." },
          { label: "C. Retaliate for the 1099 massacre when entering Jerusalem", canonical: false, outcome: "⚠️ COUNTERFACTUAL VIOLATION: Violates Qur’anic ethics of warfare (2:190) and the Prophetic precedent at the Opening of Mecca." }
        ]
      },
      {
        vec: "⚡ SUPREME REBIRTH: CAIRO, SYRIA & GOLDEN HORDE", date: "658 AH / 1260 CE",
        title: "Scenario #6: After the 1258 Fall of Baghdad — The Mongol Ultimatum to Cairo (1260 CE)",
        context: "Hulagu Khan has destroyed Baghdad (1258) and Damascus (1260) and sends envoys demanding Mamluk Cairo’s unconditional surrender. Meanwhile, in the North, Hulagu’s cousin Berke Khan of the Golden Horde has just embraced Islam (1257). What is Sultan Qutuz and Emir Baybars’s strategy?",
        directionalEffect: "By marching proactively to ’Ayn Jālūt in Palestine (3 September 1260) and forging a strategic alliance with the newly Muslim Golden Horde (Berke Khan) in the North, Cairo halted the Mongol recession and triggered the conversion of three Mongol Khanates to Islam!",
        choices: [
          { label: "A. Refuse surrender, march out to ’Ayn Jālūt using Baybars’s feigned-retreat ambush, re-establish the Abbasid Caliphate in Cairo, and ally with Muslim Golden Horde Khan Berke (Canonical Decision)", canonical: true, outcome: "✅ CANONICAL MIRACULOUS REBIRTH: At ’Ayn Jālūt (3 Sept 1260), Qutuz and Baybars crushed Kitbuqa’s army; Berke Khan attacked Hulagu from the North Caucasus, preventing Hulagu from ever returning to the Levant; and by 1295 Hulagu’s own successor Ghazan Khan converted the Ilkhanate to Islam!" },
          { label: "B. Wait passively inside Cairo’s walls for a Mongol siege", canonical: false, outcome: "⚠️ COUNTERFACTUAL DANGER: Every city from Bukhara to Baghdad that waited passively inside its walls was systematically encircled by Mongol siege engineers." },
          { label: "C. Capitulate and pay tribute to Hulagu", canonical: false, outcome: "⚠️ COUNTERFACTUAL EXTINCTION: The last independent Muslim sanctuary in the Eastern Mediterranean and Hijaz would have fallen." }
        ]
      },
      {
        vec: "⬆ NORTHERN IMPERIAL PINNACLE", date: "857 AH / 1453 CE",
        title: "Scenario #7: Sultan Mehmed II Before the Triple Walls of Constantinople (May 1453 CE)",
        context: "For 53 days, Ottoman bombards batter the Theodosian land walls, but a massive iron chain across the Golden Horn blocks the Ottoman navy from entering the northern harbor. Byzantine and Venetian defenders repair the land walls each night. How do you break the stalemate?",
        directionalEffect: "Transporting 70 ships overland across Galata into the Golden Horn opened Constantinople on 29 May 1453 — creating the tricontinental Ottoman capital that linked the Balkans, Black Sea, Anatolia, Levant, Egypt, and Red Sea for 470 years!",
        choices: [
          { label: "A. Construct a greased timber tramway over the hills of Galata to haul 70 Ottoman ships overland behind the Golden Horn chain in a single night (Canonical Decision)", canonical: true, outcome: "✅ CANONICAL ENGINEERING PINNACLE: On the night of 21–22 April 1453, oxen and crews hauled 70 galleys overland into the Golden Horn, stretching the defenders across two fronts and securing the opening of Constantinople on 29 May 1453!" },
          { label: "B. Ram the massive Golden Horn iron boom head-on with wooden ships", canonical: false, outcome: "⚠️ COUNTERFACTUAL FAILURE: Previous fleets had been sunk by Greek fire and cannon while attempting to force the chain directly." },
          { label: "C. Lift the siege before Hungarian or Venetian relief armies arrive", canonical: false, outcome: "⚠️ COUNTERFACTUAL RECESSION: Lifting the siege would have fractured Ottoman authority between Rumelia (Balkans) and Anatolia." }
        ]
      },
      {
        vec: "⬇➡ SOUTHERN & EASTERN OCEAN LIBERATION", date: "1060–1110 AH / 1650–1698 CE",
        title: "Scenario #8: The Omani Ya'rubid Maritime Liberation of Muscat & East Africa (1650–1698 CE)",
        context: "Since 1507, Portuguese fortresses and warships have occupied Muscat, Sohar, Hormuz, and Mombasa (Fort Jesus), taxing and blockading Muslim Indian Ocean trade. Imam Nāṣir ibn Murshid and Imam Sulṭān ibn Sayf I have unified Oman’s interior tribes. What is your maritime strategy?",
        directionalEffect: "By liberating Muscat (1650) and building blue-water square-rigged and lateen warships (such as the 74-gun Al-Falak) to liberate Mombasa (1698), Zanzibar, and Kilwa, Oman reversed 150 years of European naval recession across the entire Western Indian Ocean!",
        choices: [
          { label: "A. Liberate Muscat (1650), construct a modern blue-water Omani fleet combining European cannon decks with Arab star-compass navigation, and sail south to liberate Mombasa and Zanzibar (Canonical Decision)", canonical: true, outcome: "✅ CANONICAL MARITIME REBIRTH: Oman became the first non-European power to defeat a European colonial empire across two continents — liberating Muscat (1650) and Fort Jesus in Mombasa (1698) and establishing the prosperous Muscat-Zanzibar Maritime Empire!" },
          { label: "B. Liberate Muscat’s land walls only and abandon the sea to European fleets", canonical: false, outcome: "⚠️ COUNTERFACTUAL BLOCKADE: Without a blue-water navy, Portuguese fleets from Goa and Mombasa would have immediately re-blockaded Oman’s ports." },
          { label: "C. Restrict Omani ships to short coastal fishing trips", canonical: false, outcome: "⚠️ COUNTERFACTUAL ISOLATION: Would have severed the 1,000-year Swahili-Omani-Yemeni-Nusantara monsoon trade network." }
        ]
      }
    ];

    const EXPEDITION_HUBS = [
      { id: 0, name: "Makkah / Madinah (Hijaz Core)", lat: 21.42, lon: 39.83, svgX: 459, svgY: 242 },
      { id: 1, name: "Baghdad (Abbasid East)", lat: 33.31, lon: 44.36, svgX: 478, svgY: 190 },
      { id: 2, name: "Cairo / Fustat (Nile & Red Sea)", lat: 30.04, lon: 31.24, svgX: 395, svgY: 212 },
      { id: 3, name: "Muscat / Sohar (Omani Coast)", lat: 23.59, lon: 58.38, svgX: 502, svgY: 265 },
      { id: 4, name: "Aden / Zabīd (Yemeni Gate)", lat: 12.79, lon: 45.02, svgX: 472, svgY: 292 },
      { id: 5, name: "Fez / Marrakesh (Maghreb West)", lat: 31.63, lon: -7.98, svgX: 215, svgY: 195 },
      { id: 6, name: "Istanbul / Konstantiniyye (North)", lat: 41.01, lon: 28.98, svgX: 382, svgY: 142 },
      { id: 7, name: "Samarkand & Bukhara (EAST Silk Road)", lat: 39.65, lon: 66.96, svgX: 572, svgY: 162 },
      { id: 8, name: "Aceh & Malacca (EAST Nusantara)", lat: 5.55, lon: 95.32, svgX: 765, svgY: 318 },
      { id: 9, name: "Delhi & Agra (EAST Hind)", lat: 28.61, lon: 77.21, svgX: 645, svgY: 222 },
      { id: 10, name: "Córdoba & Granada (WEST Al-Andalus)", lat: 37.88, lon: -4.78, svgX: 192, svgY: 155 },
      { id: 11, name: "Timbuktu & Sokoto (WEST Bilād Al-Sūdān)", lat: 16.77, lon: -3.01, svgX: 215, svgY: 275 },
      { id: 12, name: "Volga Bulgaria / Kazan (NORTH Steppe)", lat: 55.79, lon: 49.12, svgX: 485, svgY: 105 },
      { id: 13, name: "Stone Town, Zanzibar & Kilwa (SOUTH Swahili)", lat: -6.16, lon: 39.19, svgX: 455, svgY: 392 }
    ];

    const MAJLIS_TOPICS = {
      MONGOL_REBIRTH: {
        khaldun: "When Hulagu sacked Baghdad in 1258 CE, observers thought Islam had ended. Yet within 24 months, Mamluk Cairo halted the Mongols at ’Ayn Jālūt (1260), and Sufi shaykhs and Muslim administrators converted Berke Khan (Golden Horde, 1257) and Ghazan Khan (Ilkhanate, 1295)—turning the nomadic conquerors into the builders of Islamic Samarkand and Tabriz!",
        majid: "While the land heartland of Iraq recovered from the Mongol shock, Indian Ocean maritime lanes from Aden, Hormuz, and Sohar surged: Samudera Pasai in Aceh (1267 CE) became the first documented Muslim sultanate in Sumatra just 9 years after Baghdad’s fall!",
        biruni: "Nasīr al-Dīn al-Ṭūsī preserved over 400,000 manuscripts at the Maragheh Observatory (1259 CE), inventing the Ṭūsī Couple that later appeared in Copernicus’s planetary models and passing the astronomical torch directly to Ibn al-Shāṭir in Damascus and Ulugh Beg in Samarkand.",
        asmau: "Because Islamic law (Fiqh), education (Waqf), and spiritual brotherhoods (Qādiriyyah, Kubrawiyyah, Yasawiyyah) were held by civilian scholars and guilds rather than the palace alone, society absorbed and converted its conquerors from the grassroots up."
      },
      NUSANTARA_EAST: {
        khaldun: "The Eastern Maritime Vector (Nusantara: Indonesia, Malaysia, Brunei, Southern Philippines) proves that Islam’s largest demographic expansion occurred without a single caliphal army ever invading Southeast Asia.",
        majid: "Using the 32-point star compass (Dā’irat Al-Akhnān), the Kamāl sighting tablet, and seasonal monsoon winds (Rīḥ Al-Kaws and Al-Azyab), Omani, Hadhrami, and Gujarati dhows sailed to Aceh, Malacca, and Java with complete regularity.",
        biruni: "Littoral kings in Pasai (1267), Malacca (1400), and Java (Demak, 1475) adopted the Arabic Jawi and Pegon scripts, gold Dinar/Kupang coinage, and Shāfi’ī commercial law, integrating Nusantara into the global scientific and mercantile commonwealth.",
        asmau: "The Wali Songo (Nine Saints of Java) and Hadhrami Bā ’Alawī scholars married into local royal houses, respected local architecture and ethical ’Urf, and established Pesantren boarding schools—making Indonesia the world’s largest Muslim nation today (240+ million)."
      },
      ANDALUS_WEST: {
        khaldun: "Under Sunnat Al-Tadāwul (Qur’an 3:140), the gradual territorial recession in Iberia (from 1085 Toledo to 1492 Granada) was accompanied by a massive southward expansion across the Sahara into Ghana, Mali (Timbuktu/Djenné), Songhai, Bornu, and Hausaland.",
        majid: "In 1492 CE, Ottoman Sultan Bayezid II dispatched Admiral Kemal Reis across the Western Mediterranean to evacuate Andalusian Muslims and Sephardic Jews to North Africa, Istanbul, and Salonika, while Moroccan ports fortified the Atlantic.",
        biruni: "Andalusian science—Al-Zahrāwī’s 30-volume surgical encyclopedia, Al-Zarqālī’s universal astrolabe, Ibn Rushd’s commentaries, and Cordoban paper mills—was translated in Toledo and Salerno, igniting the European Renaissance while also enriching Fez, Tunis, and Timbuktu.",
        asmau: "West African Islam culminated in the Sokoto Caliphate (1804 CE) under Shaykh Usman dan Fodio and his daughter Nana Asma’u, whose Yan Taru movement trained female itinerant teachers (Jaji) to educate women and girls across hundreds of villages!"
      },
      VOLGA_NORTH: {
        khaldun: "The Northern Vector did not wait for the Ottomans: in 922 CE (309 AH), King Almish of Volga Bulgaria (modern Kazan/Tatarstan in Russia) petitioned Abbasid Caliph Al-Muqtadir and publicly embraced Islam—66 years before Kievan Rus’ adopted Christianity in 988 CE!",
        majid: "Northern river-and-steppe caravans linked Baghdad, Khwārazm, and the Caspian Sea up the Volga River to Bulgar and Kazan, trading silver Islamic dirhams (millions of which have been unearthed across Russia and Scandinavia) for northern furs, amber, and honey.",
        biruni: "Ibn Faḍlān’s 922 CE Risālah recorded the extreme northern summer twilight latitudes of the Volga, prompting brilliant Hanafi juristic rulings on how to time the 5 daily prayers and Ramadan fast near the sub-arctic circle.",
        asmau: "Later, the Golden Horde (1257–1502 CE), the Khanates of Kazan and Crimea, the North Caucasian Imamate of Imam Shamil, and the 19th-century Tatar Jadid printing and women’s school movement preserved vibrant Islamic life across Northern Eurasia."
      },
      OMAN_SOUTH: {
        khaldun: "When Vasco da Gama rounded the Cape in 1498 and Portuguese fleets seized Hormuz, Muscat, and Mombasa, Indian Ocean commerce suffered a century-long recession—until the Omani Ya’rubid Imamate unified Oman in 1624.",
        majid: "Imam Nāṣir ibn Murshid and Imam Sulṭān ibn Sayf I liberated Muscat in 1650, built multi-deck cannon warships (including the 74-gun flagship Al-Falak), and sailed 2,500 miles south to liberate Fort Jesus in Mombasa (1698), Pemba, Zanzibar, and Kilwa!",
        biruni: "Yemeni Rasulid Sultan Al-Ashraf ’Umar II (1293 CE) authored the earliest treatise on the magnetic Qiblah/navigation compass bowl (Al-Ṭāsah), and Omani navigator Aḥmad ibn Mājid (1490 CE) perfected celestial latitude sailing across the Southern Hemisphere.",
        asmau: "Under Sayyid Sa’īd bin Sulṭān (1806–1856 CE), the twin-capital Omani Empire of Muscat and Stone Town, Zanzibar became an international commercial power, dispatching Envoy Aḥmad bin Na’mān aboard the ship Al-Sulṭānah to New York in 1840."
      },
      SUFFRAGE_SHURA: {
        khaldun: "In canonical Islamic political theory, sovereignty belongs to God while executive authority is a revocable trust (Amānah) established by public consultation (Al-Shūrā, Qur’an 42:38) and pledged consent (Al-Bay’ah).",
        majid: "Even on a caravan or dhow at sea, Prophetic law mandates that travelers appoint an accountable leader (Amīr Al-Rakb) and consult the crew on safety, route changes, and equitable rationing (Mukhārajah).",
        biruni: "In 644 CE (23 AH), during the selection of the third Caliph, ’Abd al-Raḥmān ibn ’Awf conducted a three-day universal plebiscite in Medina—polling companions, commanders, mothers at their doorsteps, students, and arriving caravans before proclaiming ’Uthmān.",
        asmau: "Islamic suffrage is anchored in Sūrat Al-Mujādilah (Qur’an 58:1): when Khawlah bint Tha’labah protested an unjust pre-Islamic custom to the Prophet ﷺ, Allah revealed from above the seven heavens: 'Allah has certainly heard the speech of the woman who argues with you'—establishing every citizen’s right to turn personal grievance into legal reform!"
      },
      CARAVAN_MAN: {
        khaldun: "The caravan (Al-Qāfilah) was the mobile city of Islamic antiquity, uniting the Royal Patron (endowing Darb Zubaydah wells and Khāns), the Common Merchant, the Poor Pilgrim, and the Stranded Traveler.",
        majid: "For the Man Lost at the Caravan (Ibn Al-Sabīl), Caliph Hārūn al-Rashīd and Queen Zubaydah built fire-lit beacon towers (Manāwir) and mile-markers along the 900-mile desert highway from Kufa to Mecca.",
        biruni: "For the Man at the End of the Caravan (Ṣāḥib Al-Sāqah), Prophetic Sunnah (Sunan Abī Dāwūd 2639) records that the Messenger ﷺ personally walked at the rear of the caravan to urge on weak mounts, carry the exhausted behind him, and pray for them.",
        asmau: "And for the Man Left Behind by the Caravan (Al-Mukhallaf), Qur’an 9:60 allocates 1/8th of state Zakāh to the stranded wayfarer (Ibn Al-Sabīl), while Qur’an 9:118 immortalizes the repentance and restoration of Ka’b ibn Mālik and Abū Dharr."
      },
      PINNACLE_LAW: {
        khaldun: "The master historical equation of Islam is Sunnat Al-Tadāwul in Qur’an 3:140: 'Wa tilka al-ayyāmu nudāwiluhā bayna al-nās' ('And these days We alternate among the people') paired with Qur’an 13:11 ('Allah does not change the condition of a people until they change what is in themselves').",
        majid: "Whenever one compass vector experienced a military recession (such as 1099 Jerusalem, 1258 Baghdad, or 1492 Granada), another compass vector simultaneously ignited a new opening (1071 Anatolia, 1260 ’Ayn Jālūt + Mongol & Aceh conversion, 1453 Constantinople + West Africa & Nusantara).",
        biruni: "Even at the deepest colonial recession (c. 1920 CE, when over 85%% of Muslim lands were colonized), grassroots Waqf universities, printing presses (Al-Nahḍah), and civic movements expanded—leading directly to the independence of all 57 OIC sovereign nations between 1945 and 1991.",
        asmau: "Today, at 2.0 billion believers across 57 sovereign states and every continent on earth, the Ummah stands at its largest demographic and educational reach in history."
      }
    };

    let currentSimStep = 1;
    let simAutoPlayInterval = null;
    let simPlaySpeedMs = 2400;

    function toRad(d) { return d * Math.PI / 180.0; }
    function toDeg(r) { return r * 180.0 / Math.PI; }

    function parseCoords(str) {
      const parts = (str || '459,242,459,242').split(',').map(x => parseFloat(x.trim()));
      return parts.length === 4 ? parts : [459, 242, 459, 242];
    }

    function updateVectorLine(id, coordsStr) {
      const el = document.getElementById(id);
      if (!el) return;
      const [x1, y1, x2, y2] = parseCoords(coordsStr);
      el.setAttribute('x1', x1);
      el.setAttribute('y1', y1);
      el.setAttribute('x2', x2);
      el.setAttribute('y2', y2);
    }

    function selectSimEra(step, scrollToSim) {
      const era = SIM_ERAS.find(e => e.step === step) || SIM_ERAS[0];
      currentSimStep = era.step;

      const slider = document.getElementById('simEraSlider');
      if (slider) slider.value = era.step;
      const badge = document.getElementById('simSliderBadge');
      if (badge) badge.textContent = 'ERA #' + String(era.step).padStart(2, '0') + ' / 16';

      document.querySelectorAll('.era-pill-btn[id^="sim-era-btn-"]').forEach(b => b.classList.remove('active'));
      const activeBtn = document.getElementById('sim-era-btn-' + era.step);
      if (activeBtn) activeBtn.classList.add('active');

      document.querySelectorAll('.sim-era-poly').forEach(p => {
        if (p.id === 'sim-poly-' + era.step) {
          p.style.display = 'block';
          p.setAttribute('fill-opacity', '0.52');
          p.setAttribute('stroke-width', '3.6');
        } else {
          p.style.display = 'none';
        }
      });

      document.querySelectorAll('[id^="wave-dot-"]').forEach(d => {
        if (d.id === 'wave-dot-' + era.step) {
          d.setAttribute('r', '7.5');
          d.setAttribute('stroke-width', '2.5');
        } else {
          d.setAttribute('r', '4.6');
          d.setAttribute('stroke-width', '1.2');
        }
      });

      updateVectorLine('vecEastLine', era.eastArrow);
      updateVectorLine('vecWestLine', era.westArrow);
      updateVectorLine('vecNorthLine', era.northArrow);
      updateVectorLine('vecSouthLine', era.southArrow);

      document.getElementById('simEraCodeBadge').textContent = era.code;
      document.getElementById('simEraHijriBadge').textContent = era.ah;
      const phaseBadge = document.getElementById('simEraPhaseBadge');
      phaseBadge.textContent = era.phase;
      phaseBadge.style.borderColor = era.color;
      phaseBadge.style.color = era.color;

      document.getElementById('simEraHeadline').textContent = era.headline;
      document.getElementById('simEraArabic').textContent = era.arabic;
      document.getElementById('simEraArea').textContent = era.area;
      document.getElementById('simEraMomentum').textContent = era.momentum + ' / 100';

      document.getElementById('simEastText').textContent = era.east;
      document.getElementById('simWestText').textContent = era.west;
      document.getElementById('simNorthText').textContent = era.north;
      document.getElementById('simSouthText').textContent = era.south;

      document.getElementById('simCaliphatesText').textContent = era.caliphates;
      document.getElementById('simMovementsText').textContent = era.movements;
      document.getElementById('simPinnacleText').textContent = era.pinnacle;
      document.getElementById('simRecessionText').textContent = era.recession;
      document.getElementById('simAnchorText').textContent = era.anchor;

      if (scrollToSim) {
        document.getElementById('liveConquestSimulator').scrollIntoView({ behavior: 'smooth', block: 'start' });
      }
    }

    function showAllSimErasOverlay() {
      document.querySelectorAll('.sim-era-poly').forEach(p => {
        p.style.display = 'block';
        p.setAttribute('fill-opacity', '0.16');
        p.setAttribute('stroke-width', '1.6');
      });
      const badge = document.getElementById('simSliderBadge');
      if (badge) badge.textContent = 'ALL 16 ERAS';
    }

    function stepSimEra(delta) {
      let next = currentSimStep + delta;
      if (next > 16) next = 1;
      if (next < 1) next = 16;
      selectSimEra(next, false);
    }

    function toggleSimAutoPlay() {
      const btn = document.getElementById('simAutoPlayBtn');
      if (simAutoPlayInterval) {
        clearInterval(simAutoPlayInterval);
        simAutoPlayInterval = null;
        if (btn) {
          btn.textContent = '▶ Play History As It Happens';
          btn.style.background = 'linear-gradient(135deg,#059669,#047857)';
        }
      } else {
        if (btn) {
          btn.textContent = '⏸ Pause Historical Playback';
          btn.style.background = 'linear-gradient(135deg,#D97706,#B45309)';
        }
        simAutoPlayInterval = setInterval(() => {
          let next = currentSimStep + 1;
          if (next > 16) next = 1;
          selectSimEra(next, false);
        }, simPlaySpeedMs);
      }
    }

    function updateSimPlaybackSpeed(val) {
      simPlaySpeedMs = parseInt(val, 10) || 2400;
      if (simAutoPlayInterval) {
        clearInterval(simAutoPlayInterval);
        simAutoPlayInterval = setInterval(() => {
          let next = currentSimStep + 1;
          if (next > 16) next = 1;
          selectSimEra(next, false);
        }, simPlaySpeedMs);
      }
    }

    function toggleSvgLayer(layerId, btn) {
      const g = document.getElementById(layerId);
      if (!g) return;
      const hidden = (g.style.display === 'none');
      g.style.display = hidden ? 'block' : 'none';
      if (btn) btn.classList.toggle('active-toggle', hidden);
    }

    function inspectMapBeacon(idx) {
      const b = MAP_BEACONS[idx] || MAP_BEACONS[0];
      document.getElementById('beaconBadge').textContent = b.badge;
      document.getElementById('beaconDirection').textContent = b.dir;
      document.getElementById('beaconTitle').textContent = b.title;
      document.getElementById('beaconDesc').textContent = b.desc;
      if (b.era) selectSimEra(b.era, false);
    }

    /* Engine #2: Ibn Khaldun Radar & Civilizational Dial */
    function loadKhaldunPreset(adl, shura, waqf, trade, ribat, sufi, title, btn) {
      if (btn && btn.parentElement) {
        btn.parentElement.querySelectorAll('.era-pill-btn').forEach(b => b.classList.remove('active'));
        btn.classList.add('active');
      }
      document.getElementById('slAdl').value = adl;
      document.getElementById('slShura').value = shura;
      document.getElementById('slWaqf').value = waqf;
      document.getElementById('slTrade').value = trade;
      document.getElementById('slRibat').value = ribat;
      document.getElementById('slSufi').value = sufi;
      document.getElementById('khaldunPresetTitle').textContent = title;
      recalcKhaldunEngine();
    }

    function recalcKhaldunEngine() {
      const adl = parseInt(document.getElementById('slAdl').value, 10);
      const shura = parseInt(document.getElementById('slShura').value, 10);
      const waqf = parseInt(document.getElementById('slWaqf').value, 10);
      const trade = parseInt(document.getElementById('slTrade').value, 10);
      const ribat = parseInt(document.getElementById('slRibat').value, 10);
      const sufi = parseInt(document.getElementById('slSufi').value, 10);

      document.getElementById('valAdl').textContent = adl + ' / 100';
      document.getElementById('valShura').textContent = shura + ' / 100';
      document.getElementById('valWaqf').textContent = waqf + ' / 100';
      document.getElementById('valTrade').textContent = trade + ' / 100';
      document.getElementById('valRibat').textContent = ribat + ' / 100';
      document.getElementById('valSufi').textContent = sufi + ' / 100';

      const vals = [adl, shura, waqf, trade, ribat, sufi];
      const angles = [-90, -30, 30, 90, 150, 210];
      const pts = vals.map((v, i) => {
        const r = (v / 100.0) * 90.0;
        const rad = toRad(angles[i]);
        const x = (120 + r * Math.cos(rad)).toFixed(1);
        const y = (120 + r * Math.sin(rad)).toFixed(1);
        return x + ',' + y;
      }).join(' ');

      const poly = document.getElementById('khaldunRadarPoly');
      if (poly) poly.setAttribute('points', pts);

      const stateScore = ((adl * 0.35 + shura * 0.30 + ribat * 0.20 + trade * 0.15)).toFixed(1);
      const rebirthScore = ((waqf * 0.40 + sufi * 0.40 + trade * 0.20)).toFixed(1);
      document.getElementById('khaldunStateScore').textContent = stateScore + ' / 100';
      document.getElementById('khaldunRebirthScore').textContent = rebirthScore + ' / 100';

      const pill = document.getElementById('khaldunStatePill');
      const diag = document.getElementById('khaldunDiagnosisText');
      const law = document.getElementById('khaldunLawText');

      if (stateScore >= 82 && rebirthScore >= 82) {
        pill.textContent = "🌟 SUPREME CIVILIZATIONAL PINNACLE (AL-AWJ AL-A’LĀ)";
        pill.style.borderColor = "#10B981";
        pill.style.color = "#34D399";
        if (poly) { poly.setAttribute('stroke', '#10B981'); poly.setAttribute('fill', 'rgba(16,185,129,0.35)'); }
        diag.innerHTML = "<strong>Ibn Khaldūn Diagnostic:</strong> High court justice (<em>’Adl</em>), consultative cohesion (<em>Shūrā</em>), and massive <em>Waqf</em> scientific investment produce simultaneous territorial, economic, and intellectual expansion across all four compass directions.";
        law.textContent = "Matches the 750–1000 CE Abbasid/Cordoban Golden Age and 1520–1680 CE Ottoman/Safavid/Mughal/Omani Zenith.";
      } else if (stateScore < 55 && rebirthScore >= 75) {
        pill.textContent = "⚡ DYNASTIC RECESSION -> GRASSROOTS REBIRTH (AL-INBI’ĀTH)";
        pill.style.borderColor = "#F59E0B";
        pill.style.color = "#FDE68A";
        if (poly) { poly.setAttribute('stroke', '#F59E0B'); poly.setAttribute('fill', 'rgba(245,158,11,0.30)'); }
        diag.innerHTML = "<strong>Ibn Khaldūn Diagnostic:</strong> Even though the central palace or frontier army is experiencing a political recession (State Score: " + stateScore + "), the high <em>Waqf</em>, <em>Fiqh</em>, and <em>Sufi/Maritime</em> Rebirth Index (" + rebirthScore + ") regenerates Islam from below and converts new horizons!";
        law.textContent = "Matches 1258–1295 CE (when Sufi orders & Mamluks converted the Mongol Khanates after Baghdad’s fall) and 1880–1945 CE (when Waqf schools & Nahḍah prepared 57-nation independence).";
      } else if (stateScore >= 65) {
        pill.textContent = "🏛️ CONSOLIDATION & REGIONAL FLOURISHING (’UMRĀN)";
        pill.style.borderColor = "#38BDF8";
        pill.style.color = "#38BDF8";
        if (poly) { poly.setAttribute('stroke', '#38BDF8'); poly.setAttribute('fill', 'rgba(56,189,248,0.28)'); }
        diag.innerHTML = "<strong>Ibn Khaldūn Diagnostic:</strong> Balanced regional governance with active caravan and monsoon trade lanes. Strengthening <em>Shūrā</em> and <em>Waqf</em> research will elevate the polity to a full Golden Age Pinnacle.";
        law.textContent = "Ibn Khaldūn’s Circle of Justice: ’The state is sustained by the army, the army by wealth, wealth by prosperous trade, and trade by Justice (’Adl) toward the common people.’";
      } else {
        pill.textContent = "🌊 SEVERE RECESSION WARNING (AL-INḤISĀR — REFORM REQUIRED)";
        pill.style.borderColor = "#F43F5E";
        pill.style.color = "#FDA4AF";
        if (poly) { poly.setAttribute('stroke', '#F43F5E'); poly.setAttribute('fill', 'rgba(244,63,94,0.28)'); }
        diag.innerHTML = "<strong>Ibn Khaldūn Diagnostic:</strong> Low justice (<em>’Adl</em>), consultative exclusion, and weak frontier <em>Ribāṭ</em> invite external invasion and fiscal recession. Immediate renewal (<em>Tajdīd</em>) via <em>Maẓālim</em> courts, <em>Waqf</em> education, and <em>Shūrā</em> is required!";
        law.textContent = "Qur’an 13:11: ’Indeed, Allah will not change the condition of a people until they change what is in themselves.’";
      }
    }

    /* Engine #3: 8-Scenario Turning-Point Wargame */
    let currentWgIdx = 0;
    function loadWargameScenario(idx, btn) {
      currentWgIdx = idx;
      if (btn && btn.parentElement) {
        btn.parentElement.querySelectorAll('.era-pill-btn').forEach(b => b.classList.remove('active'));
        btn.classList.add('active');
      }
      const sc = WARGAME_SCENARIOS[idx] || WARGAME_SCENARIOS[0];
      document.getElementById('wgVectorBadge').textContent = sc.vec;
      document.getElementById('wgDateBadge').textContent = sc.date;
      document.getElementById('wgTitle').textContent = sc.title;
      document.getElementById('wgContext').textContent = sc.context;
      document.getElementById('wgDirectionalEffect').textContent = sc.directionalEffect;

      const container = document.getElementById('wgChoicesContainer');
      container.innerHTML = '';
      sc.choices.forEach((c, cIdx) => {
        const b = document.createElement('button');
        b.type = 'button';
        b.className = 'choice-btn' + (cIdx === 0 ? ' selected-choice' : '');
        b.textContent = c.label;
        b.onclick = () => selectWargameChoice(idx, cIdx, b);
        container.appendChild(b);
      });
      selectWargameChoice(idx, 0, container.firstChild);
    }

    function selectWargameChoice(scIdx, choiceIdx, btnEl) {
      const sc = WARGAME_SCENARIOS[scIdx] || WARGAME_SCENARIOS[0];
      const ch = sc.choices[choiceIdx] || sc.choices[0];
      document.querySelectorAll('#wgChoicesContainer .choice-btn').forEach(b => b.classList.remove('selected-choice'));
      if (btnEl) btnEl.classList.add('selected-choice');

      const badge = document.getElementById('wgOutcomeBadge');
      badge.textContent = ch.canonical ? "🌟 CANONICAL HISTORICAL DECISION VERIFIED" : "⚠️ COUNTERFACTUAL ALTERNATIVE SIMULATION";
      badge.style.borderColor = ch.canonical ? "#10B981" : "#F59E0B";
      badge.style.color = ch.canonical ? "#34D399" : "#FDE68A";

      document.getElementById('wgOutcomeTitle').textContent = ch.label;
      document.getElementById('wgOutcomeBody').textContent = ch.outcome;
    }

    /* Engine #4: Caravan & Monsoon Dhow Expedition Planner */
    function calculateExpeditionRoute(scrollToMap) {
      const origId = parseInt(document.getElementById('expOriginSelect').value, 10) || 0;
      const destId = parseInt(document.getElementById('expDestSelect').value, 10) || 7;
      const mode = document.getElementById('expModeSelect').value || 'CARAVAN';

      const orig = EXPEDITION_HUBS.find(h => h.id === origId) || EXPEDITION_HUBS[0];
      const dest = EXPEDITION_HUBS.find(h => h.id === destId) || EXPEDITION_HUBS[7];

      const R = 6371.0;
      const dLat = toRad(dest.lat - orig.lat);
      const dLon = toRad(dest.lon - orig.lon);
      const a = Math.sin(dLat/2)*Math.sin(dLat/2) + Math.cos(toRad(orig.lat))*Math.cos(toRad(dest.lat))*Math.sin(dLon/2)*Math.sin(dLon/2);
      const gcKm = Math.max(120, Math.round(R * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a))));
      const routeKm = Math.round(gcKm * 1.18); // historical road/sea curvature factor
      const marhalahStages = Math.max(3, Math.round(routeKm / 35.0));

      let days = marhalahStages;
      let modeDesc = "by Camel Caravan (Qāfilah • 35 km/day with fortified Khān stops)";
      if (mode === 'DHOW') {
        days = Math.max(2, Math.round(routeKm / 165.0));
        modeDesc = "by Lateen Monsoon Dhow (Sanbūq • 8 Zām / 165 km per day)";
      } else if (mode === 'BARID') {
        days = Math.max(1, Math.round(routeKm / 190.0));
        modeDesc = "by Caliphal Barīd Postal Relay (fresh horses at every Sikkat Al-Barīd)";
      }

      // Compute Qiblah from Destination back to Mecca (21.4225, 39.8262)
      const phi1 = toRad(dest.lat);
      const phiK = toRad(21.4225);
      const dLonK = toRad(39.8262 - dest.lon);
      const y = Math.sin(dLonK);
      const x = Math.cos(phi1)*Math.tan(phiK) - Math.sin(phi1)*Math.cos(dLonK);
      const qiblahDeg = ((toDeg(Math.atan2(y, x)) + 360.0) %% 360.0).toFixed(1);
      const isba = Math.max(0.8, (Math.abs(dest.lat) / 1.607)).toFixed(2);

      document.getElementById('expDistanceReadout').textContent = routeKm.toLocaleString() + " km • " + marhalahStages + " Marḥalah Stages";
      document.getElementById('expDurationReadout').textContent = "Estimated Transit: " + days + " Days " + modeDesc + " from " + orig.name + " to " + dest.name + ".";
      document.getElementById('expNavReadout').textContent = "Dest Kamāl: " + isba + " Iṣba’ (" + Math.abs(dest.lat).toFixed(1) + "°) • Qiblah: " + qiblahDeg + "°";
      document.getElementById('expStarReadout').textContent = (dest.lat >= 0)
        ? "Northern Celestial Pole: Sighting Al-Jāh (Polaris) at " + isba + " finger-widths above the horizon."
        : "Southern Hemisphere: Sighting Suhayl (Canopus) and Al-Sulbār on the 32-point Dā’irat Al-Akhnān compass.";

      const line = document.getElementById('customExpeditionMapLine');
      if (line) {
        line.setAttribute('x1', orig.svgX);
        line.setAttribute('y1', orig.svgY);
        line.setAttribute('x2', dest.svgX);
        line.setAttribute('y2', dest.svgY);
        line.style.display = 'block';
      }
      if (scrollToMap) {
        document.getElementById('liveConquestSimulator').scrollIntoView({ behavior: 'smooth', block: 'center' });
      }
    }

    /* Engine #5: Majlis Al-Hikmah AI Multi-Scholar Oracle */
    function askMajlisTopic(key) {
      const t = MAJLIS_TOPICS[key] || MAJLIS_TOPICS.MONGOL_REBIRTH;
      document.getElementById('majlisKhaldun').textContent = t.khaldun;
      document.getElementById('majlisMajid').textContent = t.majid;
      document.getElementById('majlisBiruni').textContent = t.biruni;
      document.getElementById('majlisAsmau').textContent = t.asmau;
    }

    function runCustomMajlisQuery() {
      const q = (document.getElementById('majlisCustomInput').value || '').toLowerCase().trim();
      if (!q) {
        askMajlisTopic('MONGOL_REBIRTH');
        return;
      }
      if (q.includes('mongol') || q.includes('baghdad') || q.includes('1258') || q.includes('ayn jalut') || q.includes('mamluk')) {
        askMajlisTopic('MONGOL_REBIRTH');
      } else if (q.includes('indonesia') || q.includes('malaysia') || q.includes('aceh') || q.includes('java') || q.includes('nusantara') || q.includes('east')) {
        askMajlisTopic('NUSANTARA_EAST');
      } else if (q.includes('andalus') || q.includes('cordoba') || q.includes('granada') || q.includes('1492') || q.includes('west') || q.includes('sokoto') || q.includes('timbuktu')) {
        askMajlisTopic('ANDALUS_WEST');
      } else if (q.includes('volga') || q.includes('russia') || q.includes('kazan') || q.includes('north') || q.includes('constantinople') || q.includes('istanbul') || q.includes('922')) {
        askMajlisTopic('VOLGA_NORTH');
      } else if (q.includes('oman') || q.includes('yemen') || q.includes('zanzibar') || q.includes('south') || q.includes('compass') || q.includes('dhow') || q.includes('swahili')) {
        askMajlisTopic('OMAN_SOUTH');
      } else if (q.includes('suffrage') || q.includes('shura') || q.includes('women') || q.includes('gender') || q.includes('vote') || q.includes('mujadilah')) {
        askMajlisTopic('SUFFRAGE_SHURA');
      } else if (q.includes('caravan') || q.includes('hygiene') || q.includes('lost') || q.includes('soap') || q.includes('alchem')) {
        askMajlisTopic('CARAVAN_MAN');
      } else {
        askMajlisTopic('PINNACLE_LAW');
      }
    }

    function filterDirectionCards(dirCode, btn) {
      btn.parentElement.querySelectorAll('.era-pill-btn').forEach(b => b.classList.remove('active'));
      btn.classList.add('active');
      document.querySelectorAll('.direction-axis-card').forEach(card => {
        const d = card.getAttribute('data-dir') || '';
        card.style.display = (dirCode === 'ALL' || d === dirCode) ? 'flex' : 'none';
      });
    }

    function filterMovementCards() {
      const q = (document.getElementById('movementSearchInput').value || '').toLowerCase().trim();
      document.querySelectorAll('.movement-card').forEach(card => {
        const s = card.getAttribute('data-search') || '';
        card.style.display = (!q || s.includes(q)) ? 'flex' : 'none';
      });
    }

    // Initialize interactive engines on load
    window.addEventListener('DOMContentLoaded', () => {
      loadWargameScenario(0);
      calculateExpeditionRoute(false);
      recalcKhaldunEngine();
    });
  </script>
</body>
</html>
""".formatted(
                jsErasArray.toString()
        );
    }

    private static String escape(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }

    private static String escapeJs(String s) {
        if (s == null) return "";
        return escape(s).replace("'", "\u2019");
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
