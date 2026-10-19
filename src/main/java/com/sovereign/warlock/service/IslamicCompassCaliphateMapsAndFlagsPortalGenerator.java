package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.IslamicCompassCaliphateMapsAndFlagsAtlas;
import com.sovereign.warlock.domain.IslamicCompassCaliphateMapsAndFlagsAtlas.CaliphateAgeFlagAndMapDossier;
import com.sovereign.warlock.domain.IslamicCompassCaliphateMapsAndFlagsAtlas.CompassInstrumentLayer;
import com.sovereign.warlock.domain.IslamicCompassCaliphateMapsAndFlagsAtlas.CountryCompassMapAndFlagEntry;
import com.sovereign.warlock.domain.IslamicCompassCaliphateMapsAndFlagsAtlas.SiderealCompassRhumb;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.List;

/**
 * Generates Portal #65 (islamic-compass-caliphate-maps-and-flags-every-age-every-country.html):
 * Interactive Full 32-Point Islamic Star & Qiblah Compass, Multi-Age Caliphate Map Explorer,
 * AI-Generated Museum Plates, and Complete Vexillological Atlas of Every Flag for Every Age,
 * Every Caliphate, and Every Single One of the 57 Sovereign Islamic Countries.
 */
public final class IslamicCompassCaliphateMapsAndFlagsPortalGenerator {

    public static final String PORTAL_FILE_NAME =
            "islamic-compass-caliphate-maps-and-flags-every-age-every-country.html";

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
                    "Portal #65: AI-Generated & Interactive Full 32-Point Islamic Qiblah/Star Compass, Cartographic Maps of All 14 Caliphate Ages, and Every Flag for Every Age, Every Caliphate & All 57 Islamic Countries"
            );
        } catch (IOException e) {
            throw new IllegalStateException("Failed generating Portal #65 (" + PORTAL_FILE_NAME + ")", e);
        }
    }

    private String buildPortalHtml() {
        List<CompassInstrumentLayer> layers = IslamicCompassCaliphateMapsAndFlagsAtlas.allSixCompassLayers();
        List<SiderealCompassRhumb> rhumbs = IslamicCompassCaliphateMapsAndFlagsAtlas.sixteenPrincipalStarRhumbs();
        List<CaliphateAgeFlagAndMapDossier> ages = IslamicCompassCaliphateMapsAndFlagsAtlas.allFourteenCaliphateAgesMapsAndFlags();
        List<CountryCompassMapAndFlagEntry> countries = IslamicCompassCaliphateMapsAndFlagsAtlas.allFiftySevenIslamicCountries();

        StringBuilder layersHtml = new StringBuilder();
        for (CompassInstrumentLayer l : layers) {
            layersHtml.append(String.format("""
                <article class="card" style="border-top:4px solid %s;">
                  <div class="badge-row">
                    <span class="pill" style="border-color:%s;color:%s;">COMPASS LAYER #%d</span>
                  </div>
                  <h3>%s</h3>
                  <div class="arabic-sub">%s</div>
                  <p style="font-size:0.82rem;color:#94A3B8;margin-bottom:0.45rem;"><strong>Inventors &amp; Treatises:</strong> %s</p>
                  <div class="math-box"><code>%s</code></div>
                  <p style="font-size:0.84rem;color:#CBD5E1;margin-top:0.45rem;">%s</p>
                </article>
                """,
                    l.hexAccent(), l.hexAccent(), l.hexAccent(), l.layerIndex(),
                    escape(l.englishTitle()), escape(l.arabicName()),
                    escape(l.inventorAndTreatise()), escape(l.mathematicalFormulaAndGeometry()),
                    escape(l.navigationalAndSacredFunction())
            ));
        }

        StringBuilder rhumbsRowsHtml = new StringBuilder();
        for (SiderealCompassRhumb r : rhumbs) {
            rhumbsRowsHtml.append(String.format("""
                <tr class="click-row" onclick="rotateCompassToAzimuth(%.1f, '%s — %s', '%s', '%s')">
                  <td><span class="pill" style="border-color:%s;color:%s;">#%02d (%s)</span></td>
                  <td style="font-family:Consolas,monospace;color:#FDE68A;font-weight:700;">%.1f°</td>
                  <td style="font-weight:700;color:#FFF;">%s</td>
                  <td style="color:#38BDF8;">%s</td>
                  <td style="font-family:Consolas,monospace;color:#34D399;">%s</td>
                  <td>%s</td>
                </tr>
                """,
                    r.azimuthDeg(),
                    escapeAttr(r.cardinalCode()),
                    escapeAttr(r.arabicRhumbName()),
                    escapeAttr(r.starSystemEnglish()),
                    escapeAttr(r.targetCaliphateOrPortAxis()),
                    r.hexAccent(), r.hexAccent(), r.rhumbIndex(), escape(r.cardinalCode()),
                    r.azimuthDeg(),
                    escape(r.arabicRhumbName()),
                    escape(r.starSystemEnglish()),
                    escape(r.kamalAltitudeIsba()),
                    escape(r.targetCaliphateOrPortAxis())
            ));
        }

        StringBuilder mapPolygonsSvg = new StringBuilder();
        StringBuilder ageSelectorBtns = new StringBuilder();
        StringBuilder caliphateFlagCards = new StringBuilder();

        for (CaliphateAgeFlagAndMapDossier a : ages) {
            String svgFlag = renderHistoricalCaliphateFlagSvg(a.svgFlagArchetype(), a.primaryHex(), a.secondaryHex(), a.accentHex());
            mapPolygonsSvg.append(String.format("""
                <polygon id="caliph-poly-%d" class="caliph-poly" points="%s"
                         fill="%s" fill-opacity="0.22" stroke="%s" stroke-width="2.2"
                         onclick="selectCaliphateAge(%d)"
                         style="cursor:pointer;transition:all 0.25s ease;">
                  <title>%s (%s)</title>
                </polygon>
                """,
                    a.ageIndex(),
                    a.mapPolygonCoordinatesSvg(),
                    a.primaryHex().equals("#090D16") || a.primaryHex().equals("#111827") ? a.secondaryHex() : a.primaryHex(),
                    a.accentHex(),
                    a.ageIndex(),
                    escape(a.caliphateOrEmpireTitle()),
                    escape(a.chronologicalSpan())
            ));

            ageSelectorBtns.append(String.format("""
                <button type="button" id="age-btn-%d" class="age-tab-btn" onclick="selectCaliphateAge(%d)">
                  <span style="color:#FDE68A;font-family:Consolas,monospace;">#%02d</span> %s
                </button>
                """,
                    a.ageIndex(), a.ageIndex(), a.ageIndex(), escape(a.caliphateOrEmpireTitle())
            ));

            caliphateFlagCards.append(String.format("""
                <article class="card caliphate-flag-card" id="caliphate-card-%d" style="border-top:4px solid %s;">
                  <div class="badge-row">
                    <span class="pill" style="border-color:%s;color:#FDE68A;">%s</span>
                    <span class="pill" style="border-color:#34D399;color:#34D399;">Peak: %s</span>
                  </div>
                  <h3>%s</h3>
                  <div class="arabic-sub">%s</div>
                  <div class="svg-flag-frame" onclick="selectCaliphateAge(%d)" title="Click to highlight this Caliphate on the Interactive Map">
                    %s
                  </div>
                  <div style="font-size:0.83rem;color:#FDE68A;font-weight:700;margin:0.45rem 0 0.25rem;">
                    🏴 %s
                  </div>
                  <p style="font-size:0.81rem;color:#CBD5E1;margin-bottom:0.5rem;">%s</p>
                  <div style="font-size:0.78rem;color:#94A3B8;border-top:1px solid rgba(255,255,255,0.1);padding-top:0.45rem;">
                    <div><strong style="color:#38BDF8;">Capitals &amp; Ports:</strong> %s</div>
                    <div style="margin-top:0.25rem;"><strong style="color:#34D399;">Canonical &amp; Historical Proof:</strong> %s</div>
                  </div>
                </article>
                """,
                    a.ageIndex(),
                    a.accentHex(),
                    a.accentHex(), escape(a.eraCode()),
                    escape(a.peakAreaKm2()),
                    escape(a.caliphateOrEmpireTitle()),
                    escape(a.arabicTitle()),
                    a.ageIndex(),
                    svgFlag,
                    escape(a.flagNameArabicAndEnglish()),
                    escape(a.flagVexillologyAndCalligraphy()),
                    escape(a.capitalsAndKeyPorts()),
                    escape(a.historicalAndQuranicAnchor())
            ));
        }

        StringBuilder countryCardsHtml = new StringBuilder();
        StringBuilder mapCityDotsSvg = new StringBuilder();
        for (CountryCompassMapAndFlagEntry c : countries) {
            int svgX = lonToMapX(c.capitalLonDeg());
            int svgY = latToMapY(c.capitalLatDeg());
            mapCityDotsSvg.append(String.format("""
                <g class="map-city-node" onclick="focusCountryOnCompassAndMap(%d, %.2f, %.2f, %.1f, %d, '%s', '%s', '%s')" style="cursor:pointer;">
                  <line x1="459" y1="242" x2="%d" y2="%d" stroke="rgba(212,175,55,0.18)" stroke-width="0.9" stroke-dasharray="3,3"/>
                  <circle cx="%d" cy="%d" r="4.2" fill="%s" stroke="#FFF" stroke-width="1.1"/>
                  <title>#%02d %s (%s) — Qiblah: %.1f° (%d km to Mecca)</title>
                </g>
                """,
                    c.countryIndex(), c.capitalLatDeg(), c.capitalLonDeg(), c.qiblahBearingDeg(), c.distanceToKaabahKm(),
                    escapeAttr(c.countryName()), escapeAttr(c.capitalCity()), escapeAttr(c.arabicStarRhumbToMecca()),
                    svgX, svgY, svgX, svgY, c.primaryFlagHex(),
                    c.countryIndex(), escape(c.countryName()), escape(c.capitalCity()), c.qiblahBearingDeg(), c.distanceToKaabahKm()
            ));

            String countrySvgFlag = renderSovereignCountryFlagSvg(c);
            countryCardsHtml.append(String.format("""
                <article class="card country-card" data-zone="%s" data-search="%s" style="border-top:4px solid %s;">
                  <div class="badge-row">
                    <span class="pill" style="border-color:#D4AF37;color:#FDE68A;">#%02d / 57 • %s %s</span>
                    <span class="pill" style="border-color:#38BDF8;color:#38BDF8;">%s</span>
                  </div>
                  <div style="display:flex;align-items:center;gap:0.85rem;margin:0.45rem 0;">
                    <div class="country-flag-box">%s</div>
                    <div>
                      <h3 style="margin:0;font-size:1.03rem;color:#FFF;">%s %s</h3>
                      <div style="font-size:0.78rem;color:#34D399;font-family:Consolas,monospace;">%s</div>
                      <div style="font-size:0.76rem;color:#94A3B8;">Capital: <strong style="color:#E2E8F0;">%s</strong> (%.2f°, %.2f°)</div>
                    </div>
                  </div>
                  <div class="qiblah-readout-strip">
                    <span>🕋 <strong>Qiblah Bearing:</strong> <code>%.1f°</code></span>
                    <span>📏 <strong>To Ka'bah:</strong> <code>%,d km</code></span>
                    <span>⭐ <strong>Star Rhumb:</strong> <code>%s</code></span>
                  </div>
                  <p style="font-size:0.8rem;color:#CBD5E1;margin:0.45rem 0;">
                    <strong style="color:#FDE68A;">Current Flag Vexillology:</strong> %s
                  </p>
                  <div style="font-size:0.77rem;color:#94A3B8;background:rgba(0,0,0,0.28);padding:0.5rem 0.65rem;border-radius:8px;border-left:3px solid %s;margin-bottom:0.55rem;">
                    <strong style="color:#38BDF8;">Flags Across Every Age &amp; Caliphate:</strong><br>%s
                  </div>
                  <button type="button" class="action-btn" onclick="focusCountryOnCompassAndMap(%d, %.2f, %.2f, %.1f, %d, '%s', '%s', '%s')">
                    🧭 Dial Compass &amp; Geodesic Map to %s (%.1f°)
                  </button>
                </article>
                """,
                    escapeAttr(c.civilizationalZone()),
                    escapeAttr((c.countryName() + " " + c.arabicOrNativeName() + " " + c.capitalCity() + " " + c.civilizationalZone() + " " + c.currentFlagSymbolism() + " " + c.flagsAcrossAgesAndCaliphates() + " " + c.isoCode()).toLowerCase()),
                    c.primaryFlagHex(),
                    c.countryIndex(), escape(c.flagEmoji()), escape(c.isoCode()),
                    escape(c.civilizationalZone()),
                    countrySvgFlag,
                    escape(c.flagEmoji()), escape(c.countryName()),
                    escape(c.arabicOrNativeName()),
                    escape(c.capitalCity()), c.capitalLatDeg(), c.capitalLonDeg(),
                    c.qiblahBearingDeg(), c.distanceToKaabahKm(), escape(c.arabicStarRhumbToMecca()),
                    escape(c.currentFlagSymbolism()),
                    c.secondaryFlagHex().equals("#FFFFFF") ? "#D4AF37" : c.secondaryFlagHex(),
                    escape(c.flagsAcrossAgesAndCaliphates()),
                    c.countryIndex(), c.capitalLatDeg(), c.capitalLonDeg(), c.qiblahBearingDeg(), c.distanceToKaabahKm(),
                    escapeAttr(c.countryName()), escapeAttr(c.capitalCity()), escapeAttr(c.arabicStarRhumbToMecca()),
                    escape(c.countryName()), c.qiblahBearingDeg()
            ));
        }

        StringBuilder jsAgesArray = new StringBuilder();
        for (CaliphateAgeFlagAndMapDossier a : ages) {
            jsAgesArray.append(String.format(
                    "{idx:%d,code:\"%s\",title:\"%s\",arabic:\"%s\",span:\"%s\",flag:\"%s\",vex:\"%s\",caps:\"%s\",area:\"%s\"},\n",
                    a.ageIndex(),
                    escapeAttr(a.eraCode()),
                    escapeAttr(a.caliphateOrEmpireTitle()),
                    escapeAttr(a.arabicTitle()),
                    escapeAttr(a.chronologicalSpan()),
                    escapeAttr(a.flagNameArabicAndEnglish()),
                    escapeAttr(a.flagVexillologyAndCalligraphy()),
                    escapeAttr(a.capitalsAndKeyPorts()),
                    escapeAttr(a.peakAreaKm2())
            ));
        }

        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Portal #65: The Islamic Compass, Map of the Caliphates &amp; Every Flag for Every Age, Caliphate &amp; 57 Islamic Countries</title>
  <style>
    :root {
      --bg-deep: #040711;
      --bg-card: #0B1222;
      --bg-panel: #0E172C;
      --gold: #D4AF37;
      --gold-light: #FDE68A;
      --emerald: #10B981;
      --cyan: #38BDF8;
      --crimson: #F43F5E;
      --text-main: #F1F5F9;
      --text-muted: #94A3B8;
      --border: rgba(212, 175, 55, 0.24);
    }
    * { box-sizing: border-box; margin: 0; padding: 0; }
    body {
      background:
        radial-gradient(circle at 15%% 10%%, rgba(212, 175, 55, 0.16), transparent 45%%),
        radial-gradient(circle at 85%% 15%%, rgba(16, 185, 129, 0.14), var(--bg-deep) 65%%);
      color: var(--text-main);
      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
      line-height: 1.6;
      padding-bottom: 4rem;
    }
    main { max-width: 1540px; margin: 1.5rem auto; padding: 0 1.3rem; }
    .hero {
      background: linear-gradient(135deg, #0B1325 0%%, #191332 50%%, #07221D 100%%);
      border: 1px solid var(--gold);
      border-left: 7px solid var(--gold);
      border-radius: 16px;
      padding: 1.9rem;
      margin-bottom: 1.8rem;
      box-shadow: 0 16px 42px rgba(0,0,0,0.65);
    }
    .badge-row { display: flex; flex-wrap: wrap; gap: 0.45rem; margin-bottom: 0.65rem; }
    .pill {
      display: inline-flex;
      align-items: center;
      padding: 0.2rem 0.62rem;
      border-radius: 999px;
      border: 1px solid var(--gold);
      background: rgba(15, 23, 42, 0.85);
      color: var(--gold-light);
      font-family: 'Consolas', monospace;
      font-size: 0.72rem;
      font-weight: 700;
    }
    h1 { font-size: 2.05rem; color: #FFF; margin-bottom: 0.45rem; }
    h2.sec-title {
      font-size: 1.42rem;
      color: var(--gold-light);
      margin: 2.1rem 0 0.5rem;
      padding-bottom: 0.4rem;
      border-bottom: 2px solid var(--border);
    }
    .sec-lead { color: #CBD5E1; font-size: 0.92rem; margin-bottom: 1.15rem; }
    .arabic-banner {
      font-size: 1.22rem;
      color: var(--gold-light);
      background: rgba(212, 175, 55, 0.1);
      border: 1px solid var(--border);
      padding: 0.75rem 1.1rem;
      border-radius: 10px;
      margin: 0.85rem 0;
      text-align: center;
    }
    .grid-2 { display: grid; grid-template-columns: repeat(auto-fit, minmax(460px, 1fr)); gap: 1.25rem; }
    .grid-3 { display: grid; grid-template-columns: repeat(auto-fit, minmax(340px, 1fr)); gap: 1.15rem; }
    .grid-4 { display: grid; grid-template-columns: repeat(auto-fit, minmax(310px, 1fr)); gap: 1.1rem; }
    .card {
      background: var(--bg-card);
      border: 1px solid rgba(255,255,255,0.11);
      border-radius: 13px;
      padding: 1.15rem;
      display: flex;
      flex-direction: column;
      box-shadow: 0 8px 24px rgba(0,0,0,0.45);
    }
    .card h3 { font-size: 1.04rem; color: #FFF; margin-bottom: 0.25rem; }
    .arabic-sub { font-size: 0.82rem; color: #34D399; font-family: 'Consolas', monospace; margin-bottom: 0.5rem; }
    .math-box {
      background: #050812;
      border: 1px solid rgba(56, 189, 248, 0.35);
      border-radius: 8px;
      padding: 0.5rem 0.7rem;
      font-family: 'Consolas', monospace;
      font-size: 0.77rem;
      color: #E0F2FE;
      overflow-x: auto;
    }
    .ai-plate-card {
      background: #070C18;
      border: 1px solid var(--gold);
      border-radius: 14px;
      overflow: hidden;
      display: flex;
      flex-direction: column;
    }
    .ai-plate-card img {
      width: 100%%;
      height: 310px;
      object-fit: cover;
      border-bottom: 1px solid var(--border);
      transition: transform 0.25s ease;
    }
    .ai-plate-card:hover img { transform: scale(1.02); }
    .ai-plate-body { padding: 1rem; }
    .compass-workbench {
      display: grid;
      grid-template-columns: 520px 1fr;
      gap: 1.4rem;
      background: var(--bg-panel);
      border: 1px solid var(--gold);
      border-radius: 16px;
      padding: 1.4rem;
      margin-bottom: 1.6rem;
    }
    @media (max-width: 1080px) {
      .compass-workbench { grid-template-columns: 1fr; }
    }
    .compass-svg-stage {
      background: radial-gradient(circle, #131E38 0%%, #050811 75%%);
      border: 2px solid var(--gold);
      border-radius: 14px;
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
      padding: 1rem;
    }
    .telemetry-grid {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(195px, 1fr));
      gap: 0.7rem;
      margin: 0.85rem 0;
    }
    .telemetry-tile {
      background: #060A15;
      border: 1px solid rgba(212, 175, 55, 0.3);
      border-radius: 10px;
      padding: 0.65rem 0.8rem;
    }
    .telemetry-tile small { display: block; font-size: 0.7rem; color: var(--text-muted); text-transform: uppercase; }
    .telemetry-tile strong { font-family: 'Consolas', monospace; font-size: 1.02rem; color: var(--gold-light); }
    table { width: 100%%; border-collapse: collapse; font-size: 0.8rem; }
    th, td { border: 1px solid rgba(255,255,255,0.1); padding: 0.5rem 0.65rem; text-align: left; }
    th { background: rgba(212, 175, 55, 0.14); color: var(--gold-light); text-transform: uppercase; font-size: 0.72rem; }
    .click-row { cursor: pointer; transition: background 0.15s ease; }
    .click-row:hover { background: rgba(212, 175, 55, 0.18); }
    .map-stage-box {
      background: #060B16;
      border: 2px solid var(--gold);
      border-radius: 16px;
      padding: 1.2rem;
      margin-bottom: 1.6rem;
    }
    .age-tabs-bar {
      display: flex;
      flex-wrap: wrap;
      gap: 0.4rem;
      margin-bottom: 0.9rem;
    }
    .age-tab-btn {
      background: #0D1528;
      border: 1px solid rgba(255,255,255,0.16);
      color: #CBD5E1;
      padding: 0.35rem 0.68rem;
      border-radius: 8px;
      font-size: 0.75rem;
      font-weight: 600;
      cursor: pointer;
    }
    .age-tab-btn:hover, .age-tab-btn.active {
      background: rgba(212, 175, 55, 0.25);
      border-color: var(--gold);
      color: #FFF;
    }
    .svg-flag-frame {
      width: 100%%;
      height: 132px;
      background: #050811;
      border: 1px solid rgba(212, 175, 55, 0.35);
      border-radius: 10px;
      display: flex;
      align-items: center;
      justify-content: center;
      overflow: hidden;
      cursor: pointer;
    }
    .country-flag-box {
      width: 88px;
      height: 58px;
      border-radius: 6px;
      overflow: hidden;
      border: 1px solid rgba(255,255,255,0.28);
      flex-shrink: 0;
      box-shadow: 0 4px 12px rgba(0,0,0,0.45);
    }
    .qiblah-readout-strip {
      display: flex;
      flex-wrap: wrap;
      justify-content: space-between;
      gap: 0.4rem;
      background: #060913;
      border: 1px solid rgba(56, 189, 248, 0.28);
      border-radius: 8px;
      padding: 0.4rem 0.6rem;
      font-size: 0.74rem;
    }
    .qiblah-readout-strip code { color: var(--gold-light); font-weight: 700; }
    .action-btn {
      margin-top: auto;
      background: linear-gradient(135deg, rgba(212,175,55,0.24), rgba(16,185,129,0.2));
      border: 1px solid var(--gold);
      color: var(--gold-light);
      padding: 0.48rem 0.75rem;
      border-radius: 8px;
      font-size: 0.78rem;
      font-weight: 700;
      cursor: pointer;
      transition: all 0.15s ease;
    }
    .action-btn:hover {
      background: rgba(56, 189, 248, 0.28);
      border-color: var(--cyan);
      color: #FFF;
    }
    .filter-bar {
      background: var(--bg-panel);
      border: 1px solid var(--border);
      border-radius: 12px;
      padding: 1rem;
      margin-bottom: 1.2rem;
    }
    .search-inp {
      width: 100%%;
      background: #050811;
      border: 1px solid var(--gold);
      color: #FFF;
      padding: 0.65rem 0.95rem;
      border-radius: 8px;
      font-size: 0.88rem;
      margin-bottom: 0.7rem;
    }
    .four-color-banner {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(240px, 1fr));
      gap: 0.9rem;
      margin: 1rem 0 1.6rem;
    }
    .color-pillar {
      padding: 0.95rem;
      border-radius: 12px;
      border: 1px solid rgba(255,255,255,0.18);
    }
  </style>
</head>
<body>
  <main>
    <section class="hero">
      <div class="badge-row">
        <span class="pill">PORTAL #65 • ISLAMIC COMPASS, CALIPHATE MAPS &amp; VEXILLOLOGY ATLAS</span>
        <span class="pill" style="border-color:#38BDF8;color:#38BDF8;">32-POINT STAR COMPASS &amp; QIBLAH ENGINE</span>
        <span class="pill" style="border-color:#10B981;color:#34D399;">14 CALIPHATE AGES &amp; MAPS</span>
        <span class="pill" style="border-color:#F43F5E;color:#FDA4AF;">ALL 57 ISLAMIC COUNTRY FLAGS ACROSS EVERY AGE</span>
      </div>
      <h1>🧭 The Islamic Compass (<em>Dā'irat Al-Akhnān wa Ṭāsat Al-Qiblah</em>), Cartographic Maps of the Caliphates &amp; Every Flag for Every Age, Caliphate &amp; Country</h1>
      <p style="color:#CBD5E1;font-size:0.95rem;">
        An interactive astronomical, cartographic, and vexillological command center uniting the <strong>32-Point Sidereal &amp; Qiblah Compass</strong>
        (synthesizing <strong>Al-Bīrūnī</strong>, Rasulid Sultan <strong>Al-Ashraf 'Umar II's</strong> 1293 CE <em>Ṭāsat Al-Qiblah</em>, and Omani navigator
        <strong>Aḥmad ibn Mājid's</strong> 1490 CE <em>Al-Ḥuqqah</em>), an interactive <strong>Multi-Age Map of All 14 Caliphates, Sultanates &amp; Shahdoms</strong>,
        <strong>4 AI-Generated Museum Plates</strong>, and a complete <strong>Vexillological Atlas of Every Flag for Every Age, Every Caliphate, and All 57 Sovereign Islamic Countries</strong>.
      </p>
      <div class="arabic-banner">
        ﴿ قَدْ نَرَىٰ تَقَلُّبَ وَجْهِكَ فِي السَّمَاءِ ۖ فَلَنُوَلِّيَنَّكَ قِبْلَةً تَرْضَاهَا ۚ فَوَلِّ وَجْهَكَ شَطْرَ الْمَسْجِدِ الْحَرَامِ ﴾ •
        ﴿ وَهُوَ الَّذِي جَعَلَ لَكُمُ النُّجُومَ لِتَهْتَدُوا بِهَا فِي ظُلُمَاتِ الْبَرِّ وَالْبَحْرِ ﴾
        <div style="font-size:0.82rem;color:#CBD5E1;margin-top:0.25rem;">
          <em>"Turn then your face toward Al-Masjid Al-Ḥarām; and wherever you are, turn your faces toward it"</em> (<strong>Qur'an 2:144</strong>) •
          <em>"And He is the One Who placed for you the stars that you may be guided by them in the darknesses of the land and the sea"</em> (<strong>Qur'an 6:97</strong>)
        </div>
      </div>
    </section>

    <h2 class="sec-title">I. AI-Generated Museum Plates: The Islamic Compass, Map of the Caliphates &amp; Flags Across Every Age</h2>
    <p class="sec-lead">
      Generated via our dedicated AI visual pipeline and archived directly in <code>src/main/resources/static/images/</code> for local and GitHub Pages rendering.
    </p>
    <div class="grid-2">
      <article class="ai-plate-card">
        <a href="images/plate_1_islamic_qiblah_compass.jpg" target="_blank">
          <img src="images/plate_1_islamic_qiblah_compass.jpg" alt="Plate 1: The Full Islamic 32-Point Star and Qiblah Compass">
        </a>
        <div class="ai-plate-body">
          <span class="pill">AI PLATE I • ṬĀSAT AL-QIBLAH WA DĀ'IRAT AL-AKHNĀN</span>
          <h3 style="color:#FFF;margin:0.4rem 0 0.25rem;">1. The Full Islamic 32-Point Sidereal &amp; Qiblah Brass Compass</h3>
          <p style="font-size:0.82rem;color:#CBD5E1;">
            Gilded Damascus brass and lapis-lazuli Islamic compass featuring the central golden Ka'bah pivot, blued-steel magnetic needle,
            32 engraved Arabic star-rhumb petals (<em>Al-Akhnān</em>), concentric <em>Kamāl Iṣba'</em> latitude rings, and city Qiblah gazetteer.
          </p>
        </div>
      </article>

      <article class="ai-plate-card">
        <a href="images/plate_2_islamic_caliphates_map.jpg" target="_blank">
          <img src="images/plate_2_islamic_caliphates_map.jpg" alt="Plate 2: Illuminated Map of the Islamic Caliphates Across All Ages">
        </a>
        <div class="ai-plate-body">
          <span class="pill" style="border-color:#38BDF8;color:#38BDF8;">AI PLATE II • KHARĪṬAT AL-KHILĀFĀT AL-ISLĀMIYYAH</span>
          <h3 style="color:#FFF;margin:0.4rem 0 0.25rem;">2. Illuminated Cartographic Map of the Caliphates Across All Ages</h3>
          <p style="font-size:0.82rem;color:#CBD5E1;">
            Synthesizes Al-Idrīsī's 1154 CE <em>Tabula Rogeriana</em> and Piri Reis's 1525 CE <em>Kitāb-ı Baḥriye</em> across Al-Andalus, Maghreb,
            Cairo, Hijaz, Yemen, Oman, Baghdad, Persia, Transoxiana, Hind, and the Malay-Indonesian Archipelago.
          </p>
        </div>
      </article>

      <article class="ai-plate-card">
        <a href="images/plate_3_caliphates_vexillology_flags.jpg" target="_blank">
          <img src="images/plate_3_caliphates_vexillology_flags.jpg" alt="Plate 3: Historical Flags and Standards of Every Caliphate and Sultanate">
        </a>
        <div class="ai-plate-body">
          <span class="pill" style="border-color:#10B981;color:#34D399;">AI PLATE III • RĀYĀT WA ALWIYAT AL-KHILĀFĀT</span>
          <h3 style="color:#FFF;margin:0.4rem 0 0.25rem;">3. Every Flag &amp; Standard for Every Age &amp; Every Caliphate</h3>
          <p style="font-size:0.82rem;color:#CBD5E1;">
            Chronological museum tapestry from the Prophetic Black Standard (<em>Al-'Uqāb</em>) and White Banner (<em>Al-Liwā'</em>) through the
            Umayyad White, Abbasid Black-and-Gold Kufic, Fatimid Emerald, Almohad/Andalusian Silk, Ayyubid Eagle, Mamluk Sultānī, Yemeni Rasulid Rose,
            Omani Khanjar, Ottoman Three Crescents &amp; Zülfikar, Safavid, and Mughal standards.
          </p>
        </div>
      </article>

      <article class="ai-plate-card">
        <a href="images/plate_4_grand_islamic_atlas_57_flags.jpg" target="_blank">
          <img src="images/plate_4_grand_islamic_atlas_57_flags.jpg" alt="Plate 4: Grand Compass, Map and Flag Atlas of All 57 Islamic Countries">
        </a>
        <div class="ai-plate-body">
          <span class="pill" style="border-color:#F43F5E;color:#FDA4AF;">AI PLATE IV • AṬLAS AL-'ĀLAM AL-ISLĀMĪ (57 COUNTRIES)</span>
          <h3 style="color:#FFF;margin:0.4rem 0 0.25rem;">4. Grand Qiblah Compass, World Map &amp; Flag Atlas of All 57 OIC Nations</h3>
          <p style="font-size:0.82rem;color:#CBD5E1;">
            Panoramic cartographic and vexillological command chart centering on the 32-point Qiblah Compass Rose over Mecca with golden geodesic
            bearings radiating to all 57 Islamic countries framed by their sovereign flags.
          </p>
        </div>
      </article>
    </div>

    <h2 class="sec-title">II. Interactive Full 32-Point Islamic Star &amp; Qiblah Compass Synthesizer (<em>Dā'irat Al-Akhnān wa Ṭāsat Al-Qiblah</em>)</h2>
    <p class="sec-lead">
      Click any <strong>Star Rhumb</strong> in the table, click any <strong>Country Card</strong> below, or enter any <strong>Latitude / Longitude</strong>
      to rotate the blued-steel magnetic needle and golden Qiblah Alidade (<em>Al-'Iḍādah</em>) toward the Ka'bah in Mecca (<code>21.4225° N, 39.8262° E</code>).
    </p>

    <section class="compass-workbench" id="islamicCompassWorkbench">
      <div class="compass-svg-stage">
        <svg id="islamicCompassSvg" viewBox="0 0 500 500" width="100%%" style="max-width:460px;height:auto;">
          <defs>
            <radialGradient id="brassRimGrad" cx="50%%" cy="50%%" r="50%%">
              <stop offset="0%%" stop-color="#1E293B"/>
              <stop offset="72%%" stop-color="#0F172A"/>
              <stop offset="92%%" stop-color="#B45309"/>
              <stop offset="100%%" stop-color="#FDE68A"/>
            </radialGradient>
            <linearGradient id="goldLeaf" x1="0%%" y1="0%%" x2="100%%" y2="100%%">
              <stop offset="0%%" stop-color="#FDE68A"/>
              <stop offset="50%%" stop-color="#D4AF37"/>
              <stop offset="100%%" stop-color="#92400E"/>
            </linearGradient>
          </defs>

          <!-- Outer Brass Suspension Ring (Al-'Urwah & Al-Kursi) -->
          <circle cx="250" cy="24" r="16" fill="none" stroke="url(#goldLeaf)" stroke-width="5"/>
          <path d="M 222,42 Q 250,24 278,42 Z" fill="url(#goldLeaf)"/>

          <!-- Main Brass Mater & Degree/Kamal Rings -->
          <circle cx="250" cy="260" r="218" fill="url(#brassRimGrad)" stroke="url(#goldLeaf)" stroke-width="4"/>
          <circle cx="250" cy="260" r="198" fill="none" stroke="#D4AF37" stroke-width="1.4" stroke-dasharray="3,3"/>
          <circle cx="250" cy="260" r="174" fill="#070C18" stroke="#D4AF37" stroke-width="2"/>
          <circle cx="250" cy="260" r="138" fill="none" stroke="rgba(56,189,248,0.4)" stroke-width="1.2"/>
          <circle cx="250" cy="260" r="98" fill="none" stroke="rgba(16,185,129,0.4)" stroke-width="1.2"/>

          <!-- 32-Point Star Rose Petals -->
          <g transform="translate(250,260)">
            <!-- 16 Minor Rhumb Rays -->
            <g stroke="rgba(212,175,55,0.45)" stroke-width="1.1">
              <line x1="0" y1="-168" x2="0" y2="168" transform="rotate(11.25)"/>
              <line x1="0" y1="-168" x2="0" y2="168" transform="rotate(33.75)"/>
              <line x1="0" y1="-168" x2="0" y2="168" transform="rotate(56.25)"/>
              <line x1="0" y1="-168" x2="0" y2="168" transform="rotate(78.75)"/>
              <line x1="0" y1="-168" x2="0" y2="168" transform="rotate(101.25)"/>
              <line x1="0" y1="-168" x2="0" y2="168" transform="rotate(123.75)"/>
              <line x1="0" y1="-168" x2="0" y2="168" transform="rotate(146.25)"/>
              <line x1="0" y1="-168" x2="0" y2="168" transform="rotate(168.75)"/>
              <line x1="0" y1="-168" x2="0" y2="168" transform="rotate(22.5)"/>
              <line x1="0" y1="-168" x2="0" y2="168" transform="rotate(67.5)"/>
              <line x1="0" y1="-168" x2="0" y2="168" transform="rotate(112.5)"/>
              <line x1="0" y1="-168" x2="0" y2="168" transform="rotate(157.5)"/>
            </g>
            <!-- 8 Principal Star Points -->
            <polygon points="0,-166 16,-45 0,-25 -16,-45" fill="#1E3A8A" stroke="#D4AF37" stroke-width="1.4" transform="rotate(45)"/>
            <polygon points="0,-166 16,-45 0,-25 -16,-45" fill="#1E3A8A" stroke="#D4AF37" stroke-width="1.4" transform="rotate(135)"/>
            <polygon points="0,-166 16,-45 0,-25 -16,-45" fill="#1E3A8A" stroke="#D4AF37" stroke-width="1.4" transform="rotate(225)"/>
            <polygon points="0,-166 16,-45 0,-25 -16,-45" fill="#1E3A8A" stroke="#D4AF37" stroke-width="1.4" transform="rotate(315)"/>
            <polygon points="0,-172 20,-42 0,-18 -20,-42" fill="#047857" stroke="#FDE68A" stroke-width="1.8" transform="rotate(0)"/>
            <polygon points="0,-172 20,-42 0,-18 -20,-42" fill="#B45309" stroke="#FDE68A" stroke-width="1.8" transform="rotate(90)"/>
            <polygon points="0,-172 20,-42 0,-18 -20,-42" fill="#991B1B" stroke="#FDE68A" stroke-width="1.8" transform="rotate(180)"/>
            <polygon points="0,-172 20,-42 0,-18 -20,-42" fill="#6D28D9" stroke="#FDE68A" stroke-width="1.8" transform="rotate(270)"/>
          </g>

          <!-- Cardinal & Star Labels on Rim -->
          <text x="250" y="59" text-anchor="middle" fill="#FDE68A" font-size="11" font-weight="700">0° N • الجاه (Al-Jāh / Polaris)</text>
          <text x="454" y="264" text-anchor="end" fill="#FDE68A" font-size="10" font-weight="700">90° E • الطائر</text>
          <text x="250" y="468" text-anchor="middle" fill="#FDE68A" font-size="11" font-weight="700">180° S • القطب السهيلي (Suhayl)</text>
          <text x="46" y="264" text-anchor="start" fill="#FDE68A" font-size="10" font-weight="700">270° W • مغيب</text>

          <text x="372" y="132" text-anchor="middle" fill="#34D399" font-size="9.5">45° NE العيوق</text>
          <text x="375" y="395" text-anchor="middle" fill="#FDA4AF" font-size="9.5">135° SE العقرب</text>
          <text x="125" y="395" text-anchor="middle" fill="#38BDF8" font-size="9.5">225° SW مغيب العقرب</text>
          <text x="125" y="132" text-anchor="middle" fill="#A78BFA" font-size="9.5">315° NW مغيب العيوق</text>

          <!-- Rotating Qiblah Alidade & Blued-Steel Magnetic Fish Needle -->
          <g id="compassNeedleGroup" transform="translate(250,260) rotate(136.2)" style="transition:transform 0.65s cubic-bezier(0.22, 1, 0.36, 1);">
            <!-- Golden Qiblah Sighting Alidade (Al-'Idadah) -->
            <line x1="0" y1="155" x2="0" y2="-162" stroke="#FDE68A" stroke-width="3" stroke-dasharray="6,3"/>
            <!-- Blued-Steel & Gold Qiblah Pointer Tip -->
            <polygon points="0,-168 13,-95 0,-110 -13,-95" fill="#38BDF8" stroke="#FDE68A" stroke-width="1.6"/>
            <polygon points="0,152 9,95 0,106 -9,95" fill="#D4AF37" stroke="#FFF" stroke-width="1"/>
            <circle cx="0" cy="-130" r="6" fill="#10B981" stroke="#FFF" stroke-width="1.4"/>
          </g>

          <!-- Central Golden Ka'bah Emblem -->
          <g transform="translate(250,260)">
            <circle cx="0" cy="0" r="32" fill="#090D16" stroke="url(#goldLeaf)" stroke-width="3"/>
            <rect x="-15" y="-15" width="30" height="30" rx="3" fill="#0B0F19" stroke="#FDE68A" stroke-width="2"/>
            <line x1="-15" y1="-6" x2="15" y2="-6" stroke="#D4AF37" stroke-width="3.2"/>
            <rect x="2" y="0" width="6" height="11" fill="#D4AF37"/>
          </g>
        </svg>

        <div style="display:flex;gap:0.5rem;flex-wrap:wrap;margin-top:0.65rem;justify-content:center;">
          <input id="customLatInput" type="number" step="0.01" value="30.0444" style="width:110px;background:#050811;border:1px solid #D4AF37;color:#FFF;padding:0.35rem 0.5rem;border-radius:6px;font-size:0.78rem;" title="Latitude (°N)">
          <input id="customLonInput" type="number" step="0.01" value="31.2357" style="width:110px;background:#050811;border:1px solid #D4AF37;color:#FFF;padding:0.35rem 0.5rem;border-radius:6px;font-size:0.78rem;" title="Longitude (°E)">
          <button type="button" class="action-btn" style="margin:0;" onclick="computeCustomCoordinateQiblah()">🧭 Compute Custom Qiblah</button>
        </div>
      </div>

      <div>
        <div class="badge-row">
          <span class="pill" style="border-color:#10B981;color:#34D399;">LIVE SPHERICAL TRIGONOMETRY &amp; STAR-RHUMB ENGINE</span>
        </div>
        <h3 id="compassActiveTargetTitle" style="font-size:1.28rem;color:#FFF;margin-bottom:0.25rem;">
          Cairo (Al-Qāhirah), Egypt — Qiblah Bearing: 136.2° SE
        </h3>
        <p id="compassActiveSub" style="font-size:0.84rem;color:#38BDF8;font-family:Consolas,monospace;margin-bottom:0.6rem;">
          Star Rhumb: Maṭla' Al-'Aqrab (Rising of Scorpio/Antares) • Distance to Ka'bah: 1,285 km
        </p>

        <div class="telemetry-grid">
          <div class="telemetry-tile">
            <small>Qiblah Azimuth (θ_Q)</small>
            <strong id="telAzimuth">136.2° Clockwise</strong>
          </div>
          <div class="telemetry-tile">
            <small>Great-Circle Distance</small>
            <strong id="telDistance">1,285 km (694 NM)</strong>
          </div>
          <div class="telemetry-tile">
            <small>Kamāl Polaris Altitude</small>
            <strong id="telKamal">18.65 Iṣba' (30.04° N)</strong>
          </div>
          <div class="telemetry-tile">
            <small>Arabic Sidereal Rhumb</small>
            <strong id="telRhumb">Maṭla' Al-'Aqrab (SE)</strong>
          </div>
        </div>

        <h4 style="font-size:0.9rem;color:#FDE68A;margin:0.85rem 0 0.45rem;">
          16 Principal Sidereal Star Rhumbs of <em>Dā'irat Al-Akhnān</em> (Click Any Row to Rotate the Compass):
        </h4>
        <div style="max-height:310px;overflow-y:auto;border:1px solid rgba(255,255,255,0.12);border-radius:10px;">
          <table>
            <thead>
              <tr>
                <th>Rhumb</th>
                <th>Azimuth</th>
                <th>Arabic Star Rhumb (Al-Khann)</th>
                <th>Astronomical Star</th>
                <th>Kamāl Benchmark</th>
                <th>Caliphate &amp; Port Horizon</th>
              </tr>
            </thead>
            <tbody>
              %s
            </tbody>
          </table>
        </div>
      </div>
    </section>

    <h3 style="font-size:1.12rem;color:#FDE68A;margin:1.2rem 0 0.7rem;">
      The 6 Canonical Engineering Layers of the Islamic Compass (<em>Ṭāsat Al-Qiblah, Al-Ḥuqqah &amp; Al-Asṭurlāb</em>)
    </h3>
    <div class="grid-3">
      %s
    </div>

    <h2 class="sec-title">III. Interactive Map of the Caliphates Across All 14 Ages &amp; Every Caliphate's Flag</h2>
    <p class="sec-lead">
      Click any of the <strong>14 Caliphate/Empire Tabs</strong> below (or click directly on the map polygons or 57 capital nodes) to highlight that Caliphate's territorial expanse, capitals, and vexillological standard.
    </p>

    <section class="map-stage-box" id="caliphateMapExplorer">
      <div style="display:flex;flex-wrap:wrap;justify-content:space-between;align-items:center;gap:0.75rem;margin-bottom:0.75rem;padding:0.7rem 0.95rem;background:rgba(15,23,42,0.88);border:1px solid rgba(212,175,55,0.45);border-radius:10px;">
        <div style="display:flex;align-items:center;gap:0.45rem;flex-wrap:wrap;">
          <button type="button" class="action-btn" style="margin:0;padding:0.42rem 0.8rem;" onclick="stepCaliphateAge(-1)">⏮ Prev Era</button>
          <button type="button" id="caliphateAutoPlayBtn" class="action-btn" style="margin:0;padding:0.42rem 0.9rem;background:linear-gradient(135deg,#059669,#047857);color:#FFF;" onclick="toggleCaliphateAutoPlay()">▶ Play Eras As They Happen</button>
          <button type="button" class="action-btn" style="margin:0;padding:0.42rem 0.8rem;" onclick="stepCaliphateAge(1)">Next Era ⏭</button>
          <button type="button" class="action-btn" style="margin:0;padding:0.42rem 0.75rem;" onclick="toggleMapVectorsOverlay()">🧭 Toggle N/S/E/W Vectors</button>
        </div>
        <div style="display:flex;align-items:center;gap:0.65rem;flex:1;min-width:250px;">
          <span style="font-size:0.76rem;color:#FDE68A;font-family:Consolas,monospace;white-space:nowrap;">TIMELINE SCRUBBER:</span>
          <input id="caliphateTimelineSlider" type="range" min="0" max="14" value="0" step="1" style="flex:1;accent-color:#D4AF37;cursor:pointer;" oninput="onTimelineSliderInput(this.value)">
          <span id="caliphateSliderReadout" style="font-size:0.78rem;color:#34D399;font-family:Consolas,monospace;font-weight:700;min-width:95px;text-align:right;">ALL 14 AGES</span>
        </div>
        <a href="/islamic-conquest-caliphates-movements-pinnacles-and-recessions-interactive.html" style="font-size:0.76rem;color:#38BDF8;text-decoration:none;border:1px solid #38BDF8;padding:0.35rem 0.7rem;border-radius:6px;font-weight:700;">⚡ Open Full Conquest, N/S/E/W Movements, Pinnacles &amp; Recessions Simulator (#67) →</a>
      </div>

      <div class="age-tabs-bar">
        <button type="button" id="age-btn-0" class="age-tab-btn active" onclick="showAllCaliphatePolygons()">🌍 Show All 14 Caliphates &amp; 57 Capitals</button>
        %s
      </div>

      <div style="background:#040814;border:1px solid rgba(212,175,55,0.4);border-radius:12px;overflow:hidden;position:relative;">
        <svg id="caliphatesWorldMapSvg" viewBox="0 0 920 440" width="100%%" style="display:block;background:linear-gradient(180deg,#050B1A 0%%,#09152B 55%%,#040914 100%%);">
          <defs>
            <marker id="arrowGold" viewBox="0 0 10 10" refX="7" refY="5" markerWidth="6" markerHeight="6" orient="auto-start-reverse">
              <path d="M 0 1 L 10 5 L 0 9 z" fill="#FDE68A"/>
            </marker>
            <marker id="arrowEmerald" viewBox="0 0 10 10" refX="7" refY="5" markerWidth="6" markerHeight="6" orient="auto-start-reverse">
              <path d="M 0 1 L 10 5 L 0 9 z" fill="#10B981"/>
            </marker>
            <marker id="arrowCyan" viewBox="0 0 10 10" refX="7" refY="5" markerWidth="6" markerHeight="6" orient="auto-start-reverse">
              <path d="M 0 1 L 10 5 L 0 9 z" fill="#38BDF8"/>
            </marker>
            <marker id="arrowCrimson" viewBox="0 0 10 10" refX="7" refY="5" markerWidth="6" markerHeight="6" orient="auto-start-reverse">
              <path d="M 0 1 L 10 5 L 0 9 z" fill="#F43F5E"/>
            </marker>
          </defs>
          <!-- Latitude & Longitude Graticule -->
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

          <!-- Stylized Continental Landmasses (Afro-Eurasia & Nusantara) -->
          <g fill="#111C33" stroke="rgba(212,175,55,0.25)" stroke-width="1.2">
            <!-- Africa -->
            <path d="M 165,185 L 255,170 L 335,190 L 385,195 L 445,280 L 495,285 L 455,375 L 385,425 L 325,425 L 285,335 L 185,295 L 145,235 Z"/>
            <!-- Iberia & Europe -->
            <path d="M 172,145 L 225,140 L 265,115 L 355,110 L 425,125 L 395,165 L 315,168 L 230,170 Z"/>
            <!-- Arabia, Levant, Anatolia, Persia, Central & South Asia, SE Asia -->
            <path d="M 355,150 L 445,140 L 585,120 L 765,135 L 825,215 L 760,285 L 690,235 L 635,285 L 590,225 L 535,235 L 505,290 L 445,295 L 395,215 Z"/>
            <!-- Maritime Nusantara (Sumatra, Java, Borneo, Sulawesi) -->
            <path d="M 695,295 L 745,335 L 815,345 L 845,325 L 795,290 Z"/>
          </g>

          <!-- Caliphate Territorial Polygons -->
          <g id="caliphatePolygonsLayer">
            %s
          </g>

          <!-- 4-Direction Canonical Expansion & Movement Vectors (N / S / E / W) -->
          <g id="directionalVectorsLayer" opacity="0.88">
            <!-- WEST Vector: Mecca -> Cairo -> Kairouan -> Cordoba & Timbuktu/Sokoto -->
            <path d="M 459,242 Q 350,200 245,192 T 192,155" fill="none" stroke="#FDE68A" stroke-width="2.2" stroke-dasharray="6,3" marker-end="url(#arrowGold)"/>
            <path d="M 255,195 Q 230,245 215,275" fill="none" stroke="#FDE68A" stroke-width="1.8" stroke-dasharray="4,3" marker-end="url(#arrowGold)"/>
            <text x="295" y="184" fill="#FDE68A" font-size="8.5" font-weight="700">⬅ WEST: MAGHREB, AL-ANDALUS &amp; SOKOTO</text>

            <!-- EAST Vector: Mecca -> Baghdad -> Samarkand -> Delhi -> Aceh/Nusantara -->
            <path d="M 459,242 Q 515,190 568,168 T 640,222 T 758,312" fill="none" stroke="#10B981" stroke-width="2.2" stroke-dasharray="6,3" marker-end="url(#arrowEmerald)"/>
            <text x="585" y="152" fill="#34D399" font-size="8.5" font-weight="700">➡ EAST: KHURASAN, HIND &amp; NUSANTARA</text>

            <!-- NORTH Vector: Mecca -> Damascus -> Istanbul -> Caucasus & Volga Bulgaria (Kazan) -->
            <path d="M 459,242 Q 435,180 392,148 T 485,95" fill="none" stroke="#38BDF8" stroke-width="2.2" stroke-dasharray="6,3" marker-end="url(#arrowCyan)"/>
            <text x="395" y="102" fill="#38BDF8" font-size="8.5" font-weight="700">⬆ NORTH: SHĀM, ANATOLIA, BALKANS &amp; VOLGA</text>

            <!-- SOUTH Vector: Mecca -> Yemen & Oman -> Horn of Africa -> Zanzibar, Kilwa & Sofala -->
            <path d="M 459,242 Q 485,275 502,265 Q 485,330 448,395" fill="none" stroke="#F43F5E" stroke-width="2.2" stroke-dasharray="6,3" marker-end="url(#arrowCrimson)"/>
            <text x="495" y="348" fill="#FDA4AF" font-size="8.5" font-weight="700">⬇ SOUTH: YEMEN, OMAN &amp; SWAHILI COAST</text>
          </g>

          <!-- 57 Islamic Capital Nodes & Geodesic Qiblah Rays to Mecca -->
          <g id="cityNodesLayer">
            %s
          </g>

          <!-- Sacred Ka'bah Beacon at Mecca (459, 242) -->
          <g transform="translate(459,242)">
            <circle cx="0" cy="0" r="14" fill="rgba(212,175,55,0.25)">
              <animate attributeName="r" values="9;18;9" dur="3s" repeatCount="indefinite"/>
            </circle>
            <rect x="-5" y="-5" width="10" height="10" fill="#090D16" stroke="#FDE68A" stroke-width="2"/>
            <text x="0" y="-12" text-anchor="middle" fill="#FDE68A" font-size="10" font-weight="700">🕋 MAKKAH (QIBLAH)</text>
          </g>

          <!-- Key Regional Labels -->
          <text x="195" y="162" fill="#FDE68A" font-size="9.5" font-weight="700">AL-ANDALUS</text>
          <text x="235" y="218" fill="#FDE68A" font-size="10" font-weight="700">AL-MAGHREB</text>
          <text x="245" y="275" fill="#34D399" font-size="9.5" font-weight="700">BILĀD AL-SŪDĀN (MALI/SOKOTO)</text>
          <text x="380" y="165" fill="#FDE68A" font-size="9.5" font-weight="700">ANATOLIA / RŪM</text>
          <text x="478" y="190" fill="#38BDF8" font-size="9.5" font-weight="700">BAGHDAD / IRAQ</text>
          <text x="472" y="295" fill="#F59E0B" font-size="9.5" font-weight="700">YEMEN &amp; OMAN</text>
          <text x="470" y="365" fill="#EC4899" font-size="9.5" font-weight="700">SWAHILI COAST &amp; ZANZIBAR</text>
          <text x="550" y="160" fill="#34D399" font-size="9.5" font-weight="700">SAMARKAND &amp; BUKHARA</text>
          <text x="625" y="235" fill="#FDE68A" font-size="9.5" font-weight="700">HIND / MUGHAL DELHI</text>
          <text x="765" y="325" fill="#38BDF8" font-size="9.5" font-weight="700">NUSANTARA (ACEH / MALACCA / JAVA)</text>
        </svg>
      </div>

      <div id="mapActiveAgeBanner" style="margin-top:0.85rem;background:#091020;border:1px solid var(--gold);border-radius:10px;padding:0.85rem 1.1rem;display:flex;flex-wrap:wrap;justify-content:space-between;align-items:center;gap:0.8rem;">
        <div style="flex:1;min-width:280px;">
          <div style="display:flex;gap:0.45rem;flex-wrap:wrap;align-items:center;">
            <span id="mapBannerCode" class="pill">ALL 14 CALIPHATE AGES ACTIVE</span>
            <span id="mapBannerDirection" class="pill" style="border-color:#38BDF8;color:#38BDF8;">🧭 N • S • E • W OMNI-DIRECTIONAL</span>
            <span id="mapBannerPinnacle" class="pill" style="border-color:#10B981;color:#34D399;">🌟 PINNACLE &amp; REBIRTH CONTINUUM</span>
          </div>
          <h3 id="mapBannerTitle" style="color:#FFF;font-size:1.1rem;margin-top:0.35rem;">
            Pan-Islamic Civilizational Continuum (622 CE – Present • 14 Caliphate/Sultanate Ages &amp; 57 Sovereign Nations)
          </h3>
          <p id="mapBannerDesc" style="font-size:0.82rem;color:#CBD5E1;margin-top:0.2rem;">
            Click any age tab above, drag the Timeline Scrubber, or press <strong>▶ Play Eras As They Happen</strong> to watch every Caliphate expand across North, South, East, and West, reach its Pinnacle, weather historical Recessions, and regenerate.
          </p>
        </div>
      </div>
    </section>

    <h3 style="font-size:1.15rem;color:#FDE68A;margin:1.5rem 0 0.5rem;">
      Why So Many Islamic Flags Share White, Black, Green &amp; Red — The Canonical Verse of Ṣafī al-Dīn al-Ḥillī (1278–1349 CE)
    </h3>
    <p class="sec-lead">
      The four foundational colors of Islamic and Arab vexillology are canonically rooted in the banners of the Prophet ﷺ and the historical Caliphates, immortalized by poet <strong>Ṣafī al-Dīn al-Ḥillī</strong>:
      <em>"Bīḍu ṣanā'i'inā, sūdu waqā'i'inā, khuḍru marābi'inā, ḥumru mawāḍīnā"</em>:
    </p>
    <div class="four-color-banner">
      <div class="color-pillar" style="background:linear-gradient(135deg,#F8FAFC,#E2E8F0);color:#0F172A;">
        <strong>1. Pure White (<em>Al-Bayāḍ</em> — بيض صنائعنا)</strong>
        <p style="font-size:0.8rem;margin-top:0.3rem;">
          <strong>Prophetic <em>Liwā'</em> at Badr &amp; The Umayyad Caliphate (661–750 / Córdoba 756–1031 CE)</strong>: Symbolizes purity of covenant, peace, and beneficent deeds.
        </p>
      </div>
      <div class="color-pillar" style="background:linear-gradient(135deg,#090D16,#1E293B);color:#F8FAFC;border-color:#D4AF37;">
        <strong style="color:#FDE68A;">2. Obsidian Black (<em>Al-Sawād</em> — سود وقائعنا)</strong>
        <p style="font-size:0.8rem;margin-top:0.3rem;">
          <strong>Prophetic <em>Rāyat Al-'Uqāb</em>, Rāshidūn &amp; The Abbasid Caliphate (750–1517 CE)</strong>: Symbolizes sovereign dignity, justice, and the standard of the Messenger ﷺ.
        </p>
      </div>
      <div class="color-pillar" style="background:linear-gradient(135deg,#064E3B,#047857);color:#ECFDF5;">
        <strong style="color:#A7F3D0;">3. Emerald Green (<em>Al-Khuḍrah</em> — خضر مرابعنا)</strong>
        <p style="font-size:0.8rem;margin-top:0.3rem;">
          <strong>Prophetic Cloak, Ahl al-Bayt, Fatimid Caliphate, Sokoto &amp; Saudi/Pakistani Standards</strong>: Symbolizes Paradise gardens (<strong>Qur'an 18:31, 76:21</strong>) and life.
        </p>
      </div>
      <div class="color-pillar" style="background:linear-gradient(135deg,#7F1D1D,#B91C1C);color:#FEF2F2;">
        <strong style="color:#FDE68A;">4. Sovereign Crimson (<em>Al-Ḥumrah</em> — حمر مواضينا)</strong>
        <p style="font-size:0.8rem;margin-top:0.3rem;">
          <strong>Omani Imamates, Yemeni Rasulids, Almohad/Marinid Morocco, Ottoman Caliphate &amp; Aceh</strong>: Symbolizes courage, maritime defense, and sacrifice.
        </p>
      </div>
    </div>

    <h2 class="sec-title">IV. Every Flag for Every Age &amp; Every Caliphate, Sultanate, Imamate &amp; Shahdom (14 Historical SVG Standards)</h2>
    <p class="sec-lead">
      Each historical banner below is rendered as a custom vector SVG reconstructing its authentic textile geometry, heraldic emblems, and Arabic calligraphy. Click any flag to highlight its empire on the map above.
    </p>
    <div class="grid-3">
      %s
    </div>

    <h2 class="sec-title">V. Every Flag for Every Country Across Every Age &amp; Caliphate — All 57 Sovereign OIC Nations</h2>
    <p class="sec-lead">
      Every single one of the <strong>57 Islamic Countries</strong> across all <strong>7 Civilizational Zones</strong>, complete with its current flag,
      full chronological chain of historical Caliphate/Sultanate flags across the ages, exact Qiblah compass bearing (<code>θ_Q°</code>), and one-click compass rotation.
    </p>

    <div class="filter-bar">
      <input id="countrySearchInput" class="search-inp" type="text" placeholder="Search all 57 countries by name, capital, Caliphate flag history (e.g., Umayyad, Abbasid, Ottoman, Rasulid, Omani, Sokoto, Mughal, Aceh), or star rhumb..." oninput="filterCountries()">
      <div class="age-tabs-bar" style="margin-bottom:0;">
        <button type="button" class="age-tab-btn active" onclick="filterCountryZone('ALL', this)">All 57 Countries</button>
        <button type="button" class="age-tab-btn" onclick="filterCountryZone('I. Arabian Peninsula & Gulf', this)">Zone I: Arabian Peninsula &amp; Gulf (7)</button>
        <button type="button" class="age-tab-btn" onclick="filterCountryZone('II. Fertile Crescent & Nile', this)">Zone II: Fertile Crescent &amp; Nile (7)</button>
        <button type="button" class="age-tab-btn" onclick="filterCountryZone('III. Maghreb & West Africa', this)">Zone III: Maghreb &amp; West Africa (14)</button>
        <button type="button" class="age-tab-btn" onclick="filterCountryZone('IV. Horn of Africa & Swahili Rim', this)">Zone IV: Horn of Africa &amp; Swahili/Sub-Saharan (11)</button>
        <button type="button" class="age-tab-btn" onclick="filterCountryZone('V. Anatolia, Balkans & Central Asia', this)">Zone V: Anatolia, Balkans &amp; Central Asia (8)</button>
        <button type="button" class="age-tab-btn" onclick="filterCountryZone('VI. Persianate & South Asia', this)">Zone VI: Persianate &amp; South Asia (5)</button>
        <button type="button" class="age-tab-btn" onclick="filterCountryZone('VII. Maritime Nusantara & Global Rim', this)">Zone VII: Nusantara &amp; Global Rim (5)</button>
      </div>
    </div>

    <div class="grid-3" id="countriesGrid">
      %s
    </div>
  </main>

  <script>
    const KAABAH_LAT = 21.4225;
    const KAABAH_LON = 39.8262;
    const CALIPHATE_AGES = [
      %s
    ];
    const AGE_DYNAMICS = {
      1: { dir: "🧭 Core Hijaz -> N (Mu’tah/Tabuk) • S (Yemen/Oman) • E (Bahrain)", status: "🌟 PROPHETIC INCEPTION PINNACLE (Constitution of Medina & Unified Arabia)" },
      2: { dir: "🧭 N (Damascus/Armenia) • W (Egypt/Tripoli) • E (Ctesiphon/Khorasan) • S (Red Sea)", status: "🌟 RĀSHIDŪN OPENING PINNACLE (Simultaneous Collapse of Sasanian & Byzantine Levant)" },
      3: { dir: "🧭 W (Kairouan -> Córdoba -> Narbonne) • E (Samarkand/Fergana & Indus/Sindh)", status: "🌟 TRANSCONTINENTAL TERRITORIAL PINNACLE (11.1M km² from Atlantic to Indus)" },
      4: { dir: "🧭 E (Baghdad/Merv/Talas) • N (Tarsus/Caucasus) • S (Mecca/Aden/Siraf)", status: "🌟 GOLDEN AGE SCIENTIFIC PINNACLE (Bayt Al-Ḥikmah) -> 1258 Baghdad Siege Recession" },
      5: { dir: "🧭 W & N (Córdoba, Seville, Granada, Fez, Marrakesh, Tlemcen)", status: "🌟 CORDOBAN & ALHAMBRA PINNACLE (929–1031) -> 1085–1492 Reconquista Recession" },
      6: { dir: "🧭 W -> E (Ifriqiyah to Cairo, Hijaz, Yemen & Red Sea Corridor)", status: "🌟 AL-QĀHIRAH & AL-AZHAR PINNACLE (969–1050) -> 1099 Crusader Coastal Recession" },
      7: { dir: "🧭 N & W (Cairo & Damascus uniting to liberate Jerusalem & Yemen)", status: "🌟 1187 ḤIṬṬĪN & JERUSALEM REBIRTH (Reversing the Crusader Recession)" },
      8: { dir: "🧭 N & E (Cairo -> 'Ayn Jālūt -> Syria/Anatolian Frontier & Hijaz)", status: "🌟 1260 'AYN JĀLŪT MIRACULOUS REBIRTH (Halting the Mongol Recession & Saving Cairo)" },
      9: { dir: "🧭 S & E (Ta'izz, Zabīd & Aden governing Red Sea & Monsoon Kārimī Trade)", status: "🌟 RASULID ASTRONOMICAL & MARITIME PINNACLE (Sultan Al-Ashraf Qiblah Compass)" },
      10: { dir: "🧭 S (Muscat & Sohar -> Mombasa, Pemba, Zanzibar, Kilwa & Sofala)", status: "🌟 1650–1856 OMANI MARITIME REBIRTH (Expelling Portuguese & Uniting Muscat-Zanzibar)" },
      11: { dir: "🧭 N & W (1453 Constantinople -> Vienna, Algiers, Cairo, Mecca, Aden)", status: "🌟 TRICONTINENTAL CALIPHATE PINNACLE (1453–1683) -> 1683–1924 Recession" },
      12: { dir: "🧭 N & E (Samarkand, Herat, Tabriz, Isfahan & Shiraz)", status: "🌟 TIMURID RENAISSANCE & SAFAVID ISFAHAN PINNACLE (Naqsh-e Jahan)" },
      13: { dir: "🧭 E & S (Kabul, Lahore, Delhi, Agra, Bengal & Deccan)", status: "🌟 MUGHAL GLOBAL GDP PINNACLE (~25%% World Manufacturing) -> 1757–1857 Colonial Recession" },
      14: { dir: "🧭 W (Timbuktu/Sokoto) • E (Aceh/Malacca/Java) • Global 57 OIC Nations", status: "🌟 GLOBAL SUFI-MERCHANT EXPANSION & MODERN 57-NATION SOVEREIGN RESURGENCE" }
    };
    let currentZoneFilter = 'ALL';
    let currentAgeIndex = 0;
    let caliphateAutoPlayTimer = null;

    function toRad(d) { return d * Math.PI / 180.0; }
    function toDeg(r) { return r * 180.0 / Math.PI; }

    function rotateCompassToAzimuth(azimuthDeg, label, starName, horizonDesc) {
      const needle = document.getElementById('compassNeedleGroup');
      if (needle) {
        needle.setAttribute('transform', 'translate(250,260) rotate(' + azimuthDeg.toFixed(1) + ')');
      }
      document.getElementById('compassActiveTargetTitle').textContent = label + ' — Azimuth: ' + azimuthDeg.toFixed(1) + '°';
      document.getElementById('compassActiveSub').textContent = 'Star Guide: ' + starName + ' • Horizon: ' + horizonDesc;
      document.getElementById('telAzimuth').textContent = azimuthDeg.toFixed(1) + '° Clockwise';
      document.getElementById('telRhumb').textContent = label;
    }

    function computeCustomCoordinateQiblah() {
      const lat = parseFloat(document.getElementById('customLatInput').value || '0');
      const lon = parseFloat(document.getElementById('customLonInput').value || '0');
      const phi1 = toRad(lat);
      const phiK = toRad(KAABAH_LAT);
      const dLon = toRad(KAABAH_LON - lon);

      const y = Math.sin(dLon);
      const x = Math.cos(phi1) * Math.tan(phiK) - Math.sin(phi1) * Math.cos(dLon);
      let brng = (toDeg(Math.atan2(y, x)) + 360.0) %% 360.0;

      const R = 6371.0;
      const dPhi = toRad(KAABAH_LAT - lat);
      const a = Math.sin(dPhi/2)*Math.sin(dPhi/2) + Math.cos(phi1)*Math.cos(phiK)*Math.sin(dLon/2)*Math.sin(dLon/2);
      const distKm = Math.round(R * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)));
      const isba = Math.max(0.5, (Math.abs(lat) / 1.607)).toFixed(2);

      focusCountryOnCompassAndMap(0, lat, lon, brng, distKm, 'Custom Coordinates (' + lat.toFixed(2) + '°, ' + lon.toFixed(2) + '°)', 'User Location', isba + ' Iṣba’');
    }

    function focusCountryOnCompassAndMap(idx, lat, lon, qiblahDeg, distKm, countryName, capital, starRhumb) {
      const needle = document.getElementById('compassNeedleGroup');
      if (needle) {
        needle.setAttribute('transform', 'translate(250,260) rotate(' + qiblahDeg.toFixed(1) + ')');
      }
      const isba = Math.max(0.5, (Math.abs(lat) / 1.607)).toFixed(2);
      document.getElementById('compassActiveTargetTitle').textContent =
        countryName + ' (' + capital + ') — Qiblah Bearing: ' + qiblahDeg.toFixed(1) + '°';
      document.getElementById('compassActiveSub').textContent =
        'Star Rhumb to Mecca: ' + starRhumb + ' • Great-Circle Distance to Ka’bah: ' + distKm.toLocaleString() + ' km';
      document.getElementById('telAzimuth').textContent = qiblahDeg.toFixed(1) + '° Clockwise';
      document.getElementById('telDistance').textContent = distKm.toLocaleString() + ' km';
      document.getElementById('telKamal').textContent = isba + ' Iṣba’ (' + lat.toFixed(2) + '°)';
      document.getElementById('telRhumb').textContent = starRhumb;
      document.getElementById('customLatInput').value = lat;
      document.getElementById('customLonInput').value = lon;
      document.getElementById('islamicCompassWorkbench').scrollIntoView({ behavior: 'smooth', block: 'center' });
    }

    function showAllCaliphatePolygons() {
      currentAgeIndex = 0;
      const slider = document.getElementById('caliphateTimelineSlider');
      if (slider) slider.value = 0;
      const readout = document.getElementById('caliphateSliderReadout');
      if (readout) readout.textContent = 'ALL 14 AGES';

      document.querySelectorAll('.age-tab-btn').forEach(b => b.classList.remove('active'));
      const allBtn = document.getElementById('age-btn-0');
      if (allBtn) allBtn.classList.add('active');
      document.querySelectorAll('.caliph-poly').forEach(p => {
        p.style.display = 'block';
        p.setAttribute('fill-opacity', '0.22');
        p.setAttribute('stroke-width', '2.0');
      });
      document.getElementById('mapBannerCode').textContent = 'ALL 14 CALIPHATE AGES ACTIVE';
      document.getElementById('mapBannerDirection').textContent = '🧭 N • S • E • W OMNI-DIRECTIONAL';
      document.getElementById('mapBannerPinnacle').textContent = '🌟 PINNACLE & REBIRTH CONTINUUM';
      document.getElementById('mapBannerTitle').textContent = 'Pan-Islamic Civilizational Continuum (622 CE – Present • 14 Caliphate/Sultanate Ages & 57 Sovereign Nations)';
      document.getElementById('mapBannerDesc').textContent = 'Showing all 14 overlapping Caliphate domains from Al-Andalus and Morocco to Nusantara.';
    }

    function selectCaliphateAge(ageIdx, skipScroll) {
      if (ageIdx <= 0) {
        showAllCaliphatePolygons();
        return;
      }
      currentAgeIndex = ageIdx;
      const slider = document.getElementById('caliphateTimelineSlider');
      if (slider) slider.value = ageIdx;
      const readout = document.getElementById('caliphateSliderReadout');
      if (readout) readout.textContent = 'AGE #' + String(ageIdx).padStart(2, '0') + ' / 14';

      document.querySelectorAll('.age-tab-btn').forEach(b => b.classList.remove('active'));
      const btn = document.getElementById('age-btn-' + ageIdx);
      if (btn) btn.classList.add('active');

      document.querySelectorAll('.caliph-poly').forEach(p => {
        if (p.id === 'caliph-poly-' + ageIdx) {
          p.style.display = 'block';
          p.setAttribute('fill-opacity', '0.56');
          p.setAttribute('stroke-width', '3.8');
        } else {
          p.style.display = 'none';
        }
      });

      const info = CALIPHATE_AGES.find(x => x.idx === ageIdx);
      const dyn = AGE_DYNAMICS[ageIdx] || { dir: '🧭 N • S • E • W', status: '🌟 HISTORICAL EPOCH' };
      if (info) {
        document.getElementById('mapBannerCode').textContent = info.code + ' • PEAK AREA: ' + info.area;
        document.getElementById('mapBannerDirection').textContent = dyn.dir;
        document.getElementById('mapBannerPinnacle').textContent = dyn.status;
        document.getElementById('mapBannerTitle').textContent = info.title + ' (' + info.span + ') — ' + info.flag;
        document.getElementById('mapBannerDesc').textContent = info.vex + ' | Capitals & Ports: ' + info.caps;
      }
      if (!skipScroll) {
        document.getElementById('caliphateMapExplorer').scrollIntoView({ behavior: 'smooth', block: 'center' });
      }
    }

    function stepCaliphateAge(delta) {
      let next = currentAgeIndex + delta;
      if (next > 14) next = 0;
      if (next < 0) next = 14;
      selectCaliphateAge(next, true);
    }

    function onTimelineSliderInput(val) {
      const idx = parseInt(val, 10) || 0;
      selectCaliphateAge(idx, true);
    }

    function toggleCaliphateAutoPlay() {
      const btn = document.getElementById('caliphateAutoPlayBtn');
      if (caliphateAutoPlayTimer) {
        clearInterval(caliphateAutoPlayTimer);
        caliphateAutoPlayTimer = null;
        if (btn) {
          btn.textContent = '▶ Play Eras As They Happen';
          btn.style.background = 'linear-gradient(135deg,#059669,#047857)';
        }
      } else {
        if (currentAgeIndex === 0) selectCaliphateAge(1, true);
        if (btn) {
          btn.textContent = '⏸ Pause Era Playback';
          btn.style.background = 'linear-gradient(135deg,#D97706,#B45309)';
        }
        caliphateAutoPlayTimer = setInterval(() => {
          let next = currentAgeIndex + 1;
          if (next > 14) next = 1;
          selectCaliphateAge(next, true);
        }, 2400);
      }
    }

    function toggleMapVectorsOverlay() {
      const g = document.getElementById('directionalVectorsLayer');
      if (!g) return;
      g.style.display = (g.style.display === 'none') ? 'block' : 'none';
    }

    function filterCountryZone(zone, btn) {
      currentZoneFilter = zone;
      btn.parentElement.querySelectorAll('.age-tab-btn').forEach(b => b.classList.remove('active'));
      btn.classList.add('active');
      filterCountries();
    }

    function filterCountries() {
      const q = (document.getElementById('countrySearchInput').value || '').toLowerCase().trim();
      document.querySelectorAll('.country-card').forEach(card => {
        const z = card.getAttribute('data-zone') || '';
        const s = card.getAttribute('data-search') || '';
        const zMatch = (currentZoneFilter === 'ALL' || z === currentZoneFilter);
        const sMatch = (!q || s.includes(q));
        card.style.display = (zMatch && sMatch) ? 'flex' : 'none';
      });
    }
  </script>
</body>
</html>
""".formatted(
                rhumbsRowsHtml.toString(),
                layersHtml.toString(),
                ageSelectorBtns.toString(),
                mapPolygonsSvg.toString(),
                mapCityDotsSvg.toString(),
                caliphateFlagCards.toString(),
                countryCardsHtml.toString(),
                jsAgesArray.toString()
        );
    }

    private int lonToMapX(double lonDeg) {
        // Maps [-25..125] longitude onto [145..835] SVG X
        double clamped = Math.max(-25.0, Math.min(125.0, lonDeg));
        return (int) Math.round(145.0 + ((clamped + 25.0) / 150.0) * 690.0);
    }

    private int latToMapY(double latDeg) {
        // Maps [-30..55] latitude onto [415..95] SVG Y
        double clamped = Math.max(-30.0, Math.min(55.0, latDeg));
        return (int) Math.round(415.0 - ((clamped + 30.0) / 85.0) * 320.0);
    }

    private String renderHistoricalCaliphateFlagSvg(String archetype, String c1, String c2, String c3) {
        return switch (archetype) {
            case "PROPHETIC_UQAB" -> """
                <svg viewBox="0 0 240 120" width="100%" height="100%">
                  <rect x="6" y="8" width="108" height="104" fill="#0B0F17" stroke="#D4AF37" stroke-width="2.5"/>
                  <text x="60" y="55" text-anchor="middle" fill="#F8FAFC" font-size="13" font-weight="700">لا إله إلا الله</text>
                  <text x="60" y="75" text-anchor="middle" fill="#D4AF37" font-size="12" font-weight="700">محمد رسول الله</text>
                  <text x="60" y="102" text-anchor="middle" fill="#94A3B8" font-size="8.5">Rāyat Al-'Uqāb (Black)</text>
                  <rect x="126" y="8" width="108" height="104" fill="#F8FAFC" stroke="#D4AF37" stroke-width="2.5"/>
                  <text x="180" y="55" text-anchor="middle" fill="#0F172A" font-size="13" font-weight="700">لا إله إلا الله</text>
                  <text x="180" y="75" text-anchor="middle" fill="#B45309" font-size="12" font-weight="700">محمد رسول الله</text>
                  <text x="180" y="102" text-anchor="middle" fill="#475569" font-size="8.5">Al-Liwā' Al-Abyaḍ (White)</text>
                </svg>""";
            case "RASHIDUN_STANDARD" -> """
                <svg viewBox="0 0 240 120" width="100%" height="100%">
                  <polygon points="10,10 215,10 185,60 215,110 10,110" fill="#065F46" stroke="#D4AF37" stroke-width="3"/>
                  <rect x="18" y="18" width="155" height="84" fill="none" stroke="#FDE68A" stroke-width="1.2" stroke-dasharray="4,2"/>
                  <text x="96" y="56" text-anchor="middle" fill="#FDE68A" font-size="14" font-weight="700">لا إله إلا الله محمد رسول الله</text>
                  <text x="96" y="80" text-anchor="middle" fill="#ECFDF5" font-size="10">الخلافة الراشدة على منهاج النبوة</text>
                </svg>""";
            case "UMAYYAD_WHITE" -> """
                <svg viewBox="0 0 240 120" width="100%" height="100%">
                  <rect x="12" y="10" width="216" height="100" fill="#F8FAFC" stroke="#D4AF37" stroke-width="3.5"/>
                  <rect x="20" y="18" width="200" height="84" fill="none" stroke="#D4AF37" stroke-width="1.5"/>
                  <text x="120" y="56" text-anchor="middle" fill="#B45309" font-size="15" font-weight="700">لا إله إلا الله وحده لا شريك له</text>
                  <text x="120" y="78" text-anchor="middle" fill="#0F172A" font-size="11" font-weight="700">الراية البيضاء الأموية • نصر من الله وفتح قريب</text>
                </svg>""";
            case "ABBASID_BLACK" -> """
                <svg viewBox="0 0 240 120" width="100%" height="100%">
                  <rect x="12" y="10" width="216" height="100" fill="#070A12" stroke="#D4AF37" stroke-width="3.5"/>
                  <line x1="22" y1="24" x2="218" y2="24" stroke="#D4AF37" stroke-width="2"/>
                  <line x1="22" y1="96" x2="218" y2="96" stroke="#D4AF37" stroke-width="2"/>
                  <text x="120" y="58" text-anchor="middle" fill="#FDE68A" font-size="16" font-weight="700">مُحَمَّدٌ رَسُولُ اللَّهِ</text>
                  <text x="120" y="80" text-anchor="middle" fill="#D4AF37" font-size="11">الراية السوداء العباسية • دار السلام بغداد</text>
                </svg>""";
            case "FATIMID_GREEN" -> """
                <svg viewBox="0 0 240 120" width="100%" height="100%">
                  <rect x="12" y="10" width="216" height="100" fill="#047857" stroke="#D4AF37" stroke-width="3.5"/>
                  <circle cx="120" cy="60" r="34" fill="none" stroke="#FDE68A" stroke-width="2"/>
                  <circle cx="120" cy="60" r="24" fill="none" stroke="#FDE68A" stroke-width="1.2"/>
                  <text x="120" y="64" text-anchor="middle" fill="#FDE68A" font-size="12" font-weight="700">اللواء الأخضر</text>
                </svg>""";
            case "SELJUK_EAGLE" -> """
                <svg viewBox="0 0 240 120" width="100%" height="100%">
                  <rect x="12" y="10" width="216" height="100" fill="#0284C7" stroke="#FDE68A" stroke-width="3"/>
                  <path d="M 120,30 L 105,22 L 108,36 L 78,45 L 92,68 L 78,92 L 120,82 L 162,92 L 148,68 L 162,45 L 132,36 L 135,22 Z" fill="#FDE68A" stroke="#0F172A" stroke-width="1.5"/>
                  <path d="M 50,35 Q 35,60 50,85 M 40,60 L 65,60" fill="none" stroke="#FDE68A" stroke-width="2.2"/>
                  <text x="188" y="65" text-anchor="middle" fill="#FDE68A" font-size="10" font-weight="700">سلجوق</text>
                </svg>""";
            case "ALMOHAD_MARINID_GRANADA" -> """
                <svg viewBox="0 0 240 120" width="100%" height="100%">
                  <rect x="12" y="10" width="216" height="100" fill="#991B1B" stroke="#D4AF37" stroke-width="3"/>
                  <rect x="75" y="22" width="90" height="76" fill="#D4AF37" stroke="#FFF" stroke-width="1.5"/>
                  <g fill="#111827">
                    <rect x="85" y="30" width="17" height="15"/><rect x="119" y="30" width="17" height="15"/>
                    <rect x="102" y="45" width="17" height="15"/><rect x="136" y="45" width="17" height="15"/>
                    <rect x="85" y="60" width="17" height="15"/><rect x="119" y="60" width="17" height="15"/>
                    <rect x="102" y="75" width="17" height="15"/><rect x="136" y="75" width="17" height="15"/>
                  </g>
                  <text x="42" y="64" text-anchor="middle" fill="#FDE68A" font-size="9.5" font-weight="700">ولا غالب إلا الله</text>
                </svg>""";
            case "AYYUBID_EAGLE" -> """
                <svg viewBox="0 0 240 120" width="100%" height="100%">
                  <rect x="12" y="10" width="216" height="100" fill="#EAB308" stroke="#78350F" stroke-width="3"/>
                  <path d="M 120,24 L 112,35 L 82,40 L 95,68 L 88,94 L 120,84 L 152,94 L 145,68 L 158,40 L 128,35 Z" fill="#991B1B" stroke="#111827" stroke-width="1.8"/>
                  <text x="120" y="66" text-anchor="middle" fill="#FDE68A" font-size="9.5" font-weight="700">صلاح الدين</text>
                </svg>""";
            case "MAMLUK_SULTANI" -> """
                <svg viewBox="0 0 240 120" width="100%" height="100%">
                  <polygon points="12,12 225,12 182,60 225,108 12,108" fill="#F59E0B" stroke="#78350F" stroke-width="3"/>
                  <circle cx="95" cy="60" r="28" fill="#991B1B" stroke="#FDE68A" stroke-width="2"/>
                  <path d="M 80,52 L 110,52 L 102,66 L 108,76 L 82,76 L 88,66 Z" fill="#FDE68A"/>
                  <text x="95" y="45" text-anchor="middle" fill="#FDE68A" font-size="8" font-weight="700">السلطان الملك الناصر</text>
                </svg>""";
            case "YEMEN_RASULID_ROSE" -> """
                <svg viewBox="0 0 240 120" width="100%" height="100%">
                  <rect x="12" y="10" width="216" height="100" fill="#B91C1C" stroke="#D4AF37" stroke-width="3"/>
                  <g transform="translate(82,60)">
                    <circle cx="0" cy="-16" r="11" fill="#F8FAFC" stroke="#D4AF37" stroke-width="1.5"/>
                    <circle cx="15" cy="-5" r="11" fill="#F8FAFC" stroke="#D4AF37" stroke-width="1.5"/>
                    <circle cx="9" cy="13" r="11" fill="#F8FAFC" stroke="#D4AF37" stroke-width="1.5"/>
                    <circle cx="-9" cy="13" r="11" fill="#F8FAFC" stroke="#D4AF37" stroke-width="1.5"/>
                    <circle cx="-15" cy="-5" r="11" fill="#F8FAFC" stroke="#D4AF37" stroke-width="1.5"/>
                    <circle cx="0" cy="0" r="7" fill="#D4AF37"/>
                  </g>
                  <path d="M 135,64 L 205,60 L 195,55" fill="none" stroke="#F8FAFC" stroke-width="3.2"/>
                  <text x="170" y="42" text-anchor="middle" fill="#FDE68A" font-size="9.5" font-weight="700">الوردة الرسولية</text>
                </svg>""";
            case "OMAN_KHANJAR_EMPIRE" -> """
                <svg viewBox="0 0 240 120" width="100%" height="100%">
                  <rect x="12" y="10" width="216" height="33" fill="#F8FAFC"/>
                  <rect x="12" y="43" width="216" height="34" fill="#DC2626"/>
                  <rect x="12" y="77" width="216" height="33" fill="#15803D"/>
                  <rect x="12" y="10" width="76" height="100" fill="#DC2626"/>
                  <rect x="12" y="10" width="216" height="100" fill="none" stroke="#D4AF37" stroke-width="3"/>
                  <g transform="translate(50,55)" stroke="#FDE68A" stroke-width="2.4" fill="none">
                    <line x1="-18" y1="16" x2="18" y2="-16"/>
                    <line x1="-18" y1="-16" x2="18" y2="16"/>
                    <path d="M 0,-14 L 0,8 Q 8,14 14,6" stroke="#FFF" stroke-width="3"/>
                  </g>
                </svg>""";
            case "OTTOMAN_CALIPHATE" -> """
                <svg viewBox="0 0 240 120" width="100%" height="100%">
                  <rect x="12" y="10" width="216" height="100" fill="#B91C1C" stroke="#D4AF37" stroke-width="3"/>
                  <ellipse cx="95" cy="60" rx="52" ry="34" fill="#047857" stroke="#FDE68A" stroke-width="2"/>
                  <path d="M 72,46 A 11,11 0 1,0 72,68 A 8,8 0 1,1 72,46 Z" fill="#FDE68A"/>
                  <path d="M 98,38 A 11,11 0 1,0 98,60 A 8,8 0 1,1 98,38 Z" fill="#FDE68A"/>
                  <path d="M 98,62 A 11,11 0 1,0 98,84 A 8,8 0 1,1 98,62 Z" fill="#FDE68A"/>
                  <path d="M 162,60 L 208,52 M 162,60 L 208,68 M 155,60 L 166,60" stroke="#FDE68A" stroke-width="3"/>
                </svg>""";
            case "TIMURID_SAFAVID" -> """
                <svg viewBox="0 0 240 120" width="100%" height="100%">
                  <rect x="12" y="10" width="104" height="100" fill="#0F172A" stroke="#D4AF37" stroke-width="2.5"/>
                  <circle cx="64" cy="42" r="10" fill="#D4AF37"/>
                  <circle cx="48" cy="72" r="10" fill="#D4AF37"/>
                  <circle cx="80" cy="72" r="10" fill="#D4AF37"/>
                  <rect x="124" y="10" width="104" height="100" fill="#047857" stroke="#D4AF37" stroke-width="2.5"/>
                  <circle cx="176" cy="48" r="16" fill="#FDE68A"/>
                  <path d="M 154,74 L 198,74 L 192,60 L 160,60 Z" fill="#D4AF37"/>
                </svg>""";
            default -> """
                <svg viewBox="0 0 240 120" width="100%" height="100%">
                  <polygon points="12,12 125,35 12,108" fill="#15803D" stroke="#D4AF37" stroke-width="2.5"/>
                  <circle cx="52" cy="58" r="14" fill="#FDE68A"/>
                  <rect x="132" y="12" width="96" height="96" fill="#B91C1C" stroke="#D4AF37" stroke-width="2.5"/>
                  <path d="M 176,34 A 15,15 0 1,0 176,64 A 11,11 0 1,1 176,34 Z" fill="#FFF"/>
                  <polygon points="186,44 190,54 200,54 192,60 195,70 186,63 177,70 180,60 172,54 182,54" fill="#FFF" transform="scale(0.75) translate(62,12)"/>
                  <line x1="150" y1="84" x2="210" y2="84" stroke="#FFF" stroke-width="3.2"/>
                </svg>""";
        };
    }

    private String renderSovereignCountryFlagSvg(CountryCompassMapAndFlagEntry c) {
        String p = c.primaryFlagHex();
        String s = c.secondaryFlagHex();
        String a = c.accentFlagHex();
        String iso = c.isoCode();
        return String.format("""
            <svg viewBox="0 0 90 60" width="100%%" height="100%%">
              <rect x="0" y="0" width="90" height="20" fill="%s"/>
              <rect x="0" y="20" width="90" height="20" fill="%s"/>
              <rect x="0" y="40" width="90" height="20" fill="%s"/>
              <circle cx="45" cy="30" r="12" fill="rgba(4,7,17,0.72)" stroke="#FDE68A" stroke-width="1.2"/>
              <text x="45" y="34" text-anchor="middle" fill="#FDE68A" font-family="Consolas,monospace" font-size="10" font-weight="700">%s</text>
            </svg>""", p, s, a, escape(iso));
    }

    private static String escape(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }

    private static String escapeAttr(String s) {
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
