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
 * & Rebirths As They Happen (610 CE – 2026 CE).
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
                    "Portal #67: AI-Generated & Interactive Chronological Simulator of Every Era of Islamic Conquest, Caliphate, Canonical Muslim Movement (East, West, North & South), Pinnacles, and Recessions As They Happen"
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
  <title>Portal #67: Interactive Islamic Conquest, Caliphates, Canonical Movements (N/S/E/W), Pinnacles &amp; Recessions Simulator</title>
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
      margin-bottom: 1.8rem;
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
    .hero p { color: #CBD5E1; font-size: 0.96rem; max-width: 1200px; }
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
      height: 235px;
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
    .btn-ctrl:hover {
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
  </style>
</head>
<body>
  <main class="container">
    <header class="hero">
      <div class="hero-kicker">PORTAL #67 • AI-GENERATED &amp; LIVE INTERACTIVE CONQUEST, CALIPHATE, N/S/E/W MOVEMENT, PINNACLE &amp; RECESSION SIMULATOR</div>
      <h1>Every Era of Islamic Conquest, Caliphates, Canonical Movements (East, West, North &amp; South), Pinnacles &amp; Recessions — As They Happen</h1>
      <div class="hero-arabic">تفاعل حي لعصور الفتوحات والخلافة والحركات الإسلامية في المشرق والمغرب والشمال والجنوب: الذروة والانحسار والانبعاث (610 – 2026 م)</div>
      <p>
        An interactive, real-time historical simulation across <strong>16 Canonical Eras (610 CE – 2026 CE)</strong> tracking every <strong>Caliphate, Sultanate, Imamate, and Shahdom</strong>,
        every <strong>Canonical Muslim Movement</strong> (Prophetic <em>Hijrah</em>, <em>Futūḥāt/Amṣār</em>, <em>Fiqh/Ḥadīth</em> Schools, <em>Bayt Al-Ḥikmah</em> Science, <em>Ribāṭ</em> Frontier Defense,
        Global Sufi <em>Ṭarīqahs</em>, Omani/Yemeni/Hadhrami Maritime Guilds, <em>Waqf</em> Endowments, Sokoto/Anti-Colonial Renewal, and the 57-Nation OIC Resurgence) across
        <strong>East, West, North, and South</strong> — illuminating every <strong>Pinnacle (<em>Al-Awj</em>)</strong> and every <strong>Recession &amp; Rebirth (<em>Al-Inḥisār wa Al-Inbi'āth</em>)</strong> as they unfold.
      </p>
    </header>

    <h2 class="sec-title">I. AI-Generated Museum Plates: Four Compass Directions, Pinnacles, Recessions &amp; Canonical Movements</h2>
    <p class="sec-lead">
      Four museum-grade AI historical and cartographic plates visualizing the four cardinal vectors of Islamic expansion, the great imperial pinnacles, the miraculous rebirths after recessions, and the canonical non-dynastic movements.
    </p>
    <section class="plates-grid">
      <article class="plate-card">
        <img src="/images/conquest_plate_1_four_directions_map.jpg" alt="Plate 1: The Four-Compass-Direction Islamic Expansion & Movement Atlas">
        <div class="plate-body">
          <h3>Plate I: The Four-Compass-Direction Atlas (North, South, East &amp; West)</h3>
          <p>Radiating from Mecca and Medina: <strong>West</strong> to Córdoba, Marrakesh &amp; Timbuktu/Sokoto; <strong>East</strong> to Baghdad, Samarkand, Delhi &amp; Aceh/Malacca; <strong>North</strong> to Damascus, Istanbul, Kazan &amp; Vienna; <strong>South</strong> to Yemen, Oman, Zanzibar &amp; Kilwa.</p>
        </div>
      </article>
      <article class="plate-card">
        <img src="/images/conquest_plate_2_pinnacles_apogee.jpg" alt="Plate 2: The Great Pinnacles of the Caliphates & Gunpowder Empires">
        <div class="plate-body">
          <h3>Plate II: The Great Pinnacles (<em>Al-Awj wa Al-Dhurwah</em>)</h3>
          <p>The 750 CE Umayyad-Abbasid Atlantic-to-Indus zenith, the 9th–11th c. scientific apogee of Baghdad/Córdoba/Cairo, the 1453 Conquest of Constantinople, and the 16th–17th c. Ottoman-Safavid-Mughal-Omani-Acehnese simultaneous pinnacle.</p>
        </div>
      </article>
      <article class="plate-card">
        <img src="/images/conquest_plate_3_recessions_rebirths.jpg" alt="Plate 3: The Great Recessions & Miraculous Rebirths">
        <div class="plate-body">
          <h3>Plate III: The Great Recessions &amp; Rebirths (<em>Al-Inḥisār wa Al-Inbi'āth</em>)</h3>
          <p>The 1258 Mongol siege of Baghdad answered within 24 months by 1260 <em>'Ayn Jālūt</em> and the conversion of three Mongol Khanates to Islam; and the 1492 Fall of Granada answered by Ottoman naval rescue, Omani liberation of the Indian Ocean, and Nusantara's rise.</p>
        </div>
      </article>
      <article class="plate-card">
        <img src="/images/conquest_plate_4_canonical_movements.jpg" alt="Plate 4: Canonical Muslim Movements Through Time">
        <div class="plate-body">
          <h3>Plate IV: Canonical Muslim Movements Beyond Dynasties</h3>
          <p>How Islam expanded even when empires receded: the Prophetic <em>Hijrah</em>, coastal <em>Ribāṭ</em> citadels, <em>Waqf</em> universities, global Sufi <em>Ṭarīqahs</em>, Omani/Hadhrami monsoon dhows, and the 57-nation sovereign resurgence.</p>
        </div>
      </article>
    </section>

    <h2 class="sec-title">II. Live Interactive "As-They-Happen" Chronological Conquest, Movement, Pinnacle &amp; Recession Simulator (610 – 2026 CE)</h2>
    <p class="sec-lead">
      Press <strong>▶ Play History As It Happens</strong>, drag the <strong>16-Era Timeline Scrubber</strong>, or click any era button or wave-chart node below to watch the borders, <strong>East/West/North/South directional arrows</strong>, <strong>Pinnacles</strong>, and <strong>Recessions/Rebirths</strong> update live.
    </p>

    <section class="sim-stage" id="liveConquestSimulator">
      <div class="sim-toolbar">
        <div style="display:flex;gap:0.45rem;flex-wrap:wrap;align-items:center;">
          <button type="button" class="btn-ctrl" onclick="stepSimEra(-1)">⏮ Prev Era</button>
          <button type="button" id="simAutoPlayBtn" class="btn-ctrl" style="background:linear-gradient(135deg,#059669,#047857);color:#FFF;" onclick="toggleSimAutoPlay()">▶ Play History As It Happens</button>
          <button type="button" class="btn-ctrl" onclick="stepSimEra(1)">Next Era ⏭</button>
          <button type="button" class="btn-ctrl" onclick="showAllSimErasOverlay()">🌍 Show All 16 Eras Overlay</button>
        </div>
        <div style="display:flex;align-items:center;gap:0.65rem;flex:1;min-width:250px;">
          <span style="font-size:0.75rem;color:#FDE68A;font-family:Consolas,monospace;white-space:nowrap;">SCRUB HISTORY:</span>
          <input id="simEraSlider" type="range" min="1" max="16" value="1" step="1" style="flex:1;accent-color:#D4AF37;cursor:pointer;" oninput="selectSimEra(parseInt(this.value,10), false)">
          <span id="simSliderBadge" style="font-family:Consolas,monospace;font-size:0.78rem;color:#34D399;font-weight:700;min-width:110px;text-align:right;">ERA #01 / 16</span>
        </div>
        <div style="display:flex;gap:0.4rem;flex-wrap:wrap;">
          <button type="button" class="btn-ctrl" style="border-color:#10B981;color:#34D399;" onclick="selectSimEra(3, false)" title="711-750 CE Umayyad 11.1M km² Peak">🌟 750 Pinnacle</button>
          <button type="button" class="btn-ctrl" style="border-color:#F43F5E;color:#FDA4AF;" onclick="selectSimEra(8, false)" title="1258 Baghdad Recession & 1260 'Ayn Jalut Rebirth">🌊 1258/1260 Rebirth</button>
          <button type="button" class="btn-ctrl" style="border-color:#D4AF37;color:#FDE68A;" onclick="selectSimEra(12, false)" title="1605-1707 Ottoman/Safavid/Mughal/Omani Peak">🌟 1680 Pinnacle</button>
          <button type="button" class="btn-ctrl" style="border-color:#EF4444;color:#FCA5A5;" onclick="selectSimEra(14, false)" title="1857-1924 Colonial Recession & Nahdah">🌊 1920 Recession</button>
          <button type="button" class="btn-ctrl" style="border-color:#38BDF8;color:#38BDF8;" onclick="selectSimEra(16, false)" title="1991-2026 57 Nations & 2.0B Ummah">🌟 2026 Pinnacle</button>
        </div>
      </div>

      <div class="era-pills-bar">
        %s
      </div>

      <div class="sim-split">
        <!-- Left Column: Interactive SVG World Map + Pinnacle/Recession Wave Curve -->
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

              <!-- Live Dynamic N / S / E / W Vectors for Active Era -->
              <g id="simActiveVectorsLayer">
                <line id="vecEastLine" x1="459" y1="242" x2="495" y2="225" stroke="#10B981" stroke-width="3" stroke-dasharray="6,3" marker-end="url(#simArrowEast)"/>
                <line id="vecWestLine" x1="459" y1="242" x2="425" y2="225" stroke="#FDE68A" stroke-width="3" stroke-dasharray="6,3" marker-end="url(#simArrowWest)"/>
                <line id="vecNorthLine" x1="459" y1="242" x2="442" y2="198" stroke="#38BDF8" stroke-width="3" stroke-dasharray="6,3" marker-end="url(#simArrowNorth)"/>
                <line id="vecSouthLine" x1="459" y1="242" x2="475" y2="288" stroke="#F43F5E" stroke-width="3" stroke-dasharray="6,3" marker-end="url(#simArrowSouth)"/>
              </g>

              <!-- Key Historical Pinnacle & Recession Landmarks (Clickable) -->
              <g font-size="8.5" font-weight="700" style="cursor:pointer;">
                <g transform="translate(459,242)" onclick="selectSimEra(1, false)">
                  <circle cx="0" cy="0" r="11" fill="rgba(212,175,55,0.28)"/>
                  <rect x="-4" y="-4" width="8" height="8" fill="#090D16" stroke="#FDE68A" stroke-width="1.8"/>
                  <text x="0" y="-10" text-anchor="middle" fill="#FDE68A">🕋 MAKKAH / MADINAH (610–632)</text>
                </g>
                <g transform="translate(192,155)" onclick="selectSimEra(3, false)">
                  <circle cx="0" cy="0" r="4.5" fill="#F8FAFC" stroke="#D4AF37" stroke-width="1.5"/>
                  <text x="0" y="-8" text-anchor="middle" fill="#FDE68A">CÓRDOBA / GRANADA (711–1492)</text>
                </g>
                <g transform="translate(215,275)" onclick="selectSimEra(9, false)">
                  <circle cx="0" cy="0" r="4.5" fill="#D4AF37" stroke="#FFF" stroke-width="1.2"/>
                  <text x="0" y="13" text-anchor="middle" fill="#FDE68A">TIMBUKTU / SOKOTO (1324 / 1804)</text>
                </g>
                <g transform="translate(395,212)" onclick="selectSimEra(8, false)">
                  <circle cx="0" cy="0" r="4.5" fill="#10B981" stroke="#FFF" stroke-width="1.2"/>
                  <text x="-8" y="13" text-anchor="middle" fill="#34D399">CAIRO &amp; 'AYN JĀLŪT (969 / 1260)</text>
                </g>
                <g transform="translate(382,148)" onclick="selectSimEra(10, false)">
                  <circle cx="0" cy="0" r="5" fill="#DC2626" stroke="#FDE68A" stroke-width="1.5"/>
                  <text x="0" y="-8" text-anchor="middle" fill="#FCA5A5">ISTANBUL / KONSTANTINIYYE (1453)</text>
                </g>
                <g transform="translate(485,105)" onclick="selectSimEra(8, false)">
                  <circle cx="0" cy="0" r="4.5" fill="#38BDF8" stroke="#FFF" stroke-width="1.2"/>
                  <text x="0" y="-8" text-anchor="middle" fill="#38BDF8">VOLGA BULGARIA / GOLDEN HORDE (922 / 1257)</text>
                </g>
                <g transform="translate(478,190)" onclick="selectSimEra(4, false)">
                  <circle cx="0" cy="0" r="5" fill="#D4AF37" stroke="#FFF" stroke-width="1.5"/>
                  <text x="0" y="-8" text-anchor="middle" fill="#FDE68A">BAGHDAD (762 PINNACLE / 1258 SIEGE)</text>
                </g>
                <g transform="translate(572,162)" onclick="selectSimEra(9, false)">
                  <circle cx="0" cy="0" r="4.5" fill="#38BDF8" stroke="#FFF" stroke-width="1.2"/>
                  <text x="0" y="-8" text-anchor="middle" fill="#38BDF8">SAMARKAND &amp; BUKHARA (710 / 1400)</text>
                </g>
                <g transform="translate(645,222)" onclick="selectSimEra(12, false)">
                  <circle cx="0" cy="0" r="4.5" fill="#10B981" stroke="#FFF" stroke-width="1.2"/>
                  <text x="0" y="-8" text-anchor="middle" fill="#34D399">DELHI &amp; AGRA (1206 / 1650)</text>
                </g>
                <g transform="translate(502,265)" onclick="selectSimEra(12, false)">
                  <circle cx="0" cy="0" r="4.5" fill="#F97316" stroke="#FFF" stroke-width="1.2"/>
                  <text x="22" y="4" text-anchor="start" fill="#FDBA74">OMAN &amp; YEMEN (630 / 1650)</text>
                </g>
                <g transform="translate(455,392)" onclick="selectSimEra(13, false)">
                  <circle cx="0" cy="0" r="4.5" fill="#F43F5E" stroke="#FFF" stroke-width="1.2"/>
                  <text x="0" y="13" text-anchor="middle" fill="#FDA4AF">ZANZIBAR &amp; KILWA (957 / 1840)</text>
                </g>
                <g transform="translate(765,318)" onclick="selectSimEra(10, false)">
                  <circle cx="0" cy="0" r="5" fill="#38BDF8" stroke="#FDE68A" stroke-width="1.4"/>
                  <text x="0" y="14" text-anchor="middle" fill="#38BDF8">ACEH, MALACCA &amp; JAVA (1267–PRESENT)</text>
                </g>
              </g>
            </svg>
          </div>

          <!-- Interactive Pinnacle vs. Recession Wave Graph Across All 16 Eras -->
          <div style="margin-top:0.85rem;background:#060B18;border:1px solid rgba(212,175,55,0.35);border-radius:12px;padding:0.75rem 0.9rem;">
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

    <h2 class="sec-title">III. The Four Cardinal Compass Vectors of Islamic History: East, West, North &amp; South</h2>
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

    <h2 class="sec-title">IV. The 10 Canonical Muslim Movements (How Islam Governed, Expanded &amp; Regenerated Beyond Dynasties)</h2>
    <p class="sec-lead">
      Caliphates and dynasties rose and dissolved, yet Islam itself never receded from the hearts of its peoples because it was carried by <strong>10 Canonical Movements</strong> operating from the grassroots to the global horizon.
    </p>
    <input id="movementSearchInput" class="search-inp" type="text" placeholder="Search the 10 Canonical Movements (e.g., Hijrah, Futuhat, Amsar, Fiqh, Hadith, Bayt Al-Hikmah, Ribat, Sufi, Qadiriyyah, Naqshbandiyyah, Omani Dhow, Waqf, Sokoto, Nahdah)..." oninput="filterMovementCards()">
    <div class="grid-2" id="movementsGrid">
      %s
    </div>

    <h2 class="sec-title">V. The 8 Great Pinnacle, Recession &amp; Miraculous Rebirth Cycles (<em>Sunnat Al-Tadāwul</em> — Qur'an 3:140)</h2>
    <p class="sec-lead">
      In canonical Islamic historiography, every political or territorial recession (<em>Inḥisār</em>) immediately triggered a spiritual, intellectual, or geographic rebirth (<em>Inbi'āth</em>) along another compass vector.
    </p>
    <div class="grid-2">
      %s
    </div>

    <h2 class="sec-title">VI. Complete 16-Era Master Chronological Matrix (Click Any Row to Launch in the Interactive Simulator)</h2>
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

  <script>
    const SIM_ERAS = [
      %s
    ];
    let currentSimStep = 1;
    let simAutoPlayInterval = null;

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
        }, 2400);
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
  </script>
</body>
</html>
""".formatted(
                eraButtonsHtml.toString(),
                eraPolygonsSvg.toString(),
                wavePointsSvg.toString(),
                waveNodesSvg.toString(),
                axesHtml.toString(),
                movementsHtml.toString(),
                cyclesHtml.toString(),
                eraTableRowsHtml.toString(),
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
