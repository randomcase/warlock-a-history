package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.IslamicMaritimeBoatingPiracyMercantilismAndOmanYemen;
import com.sovereign.warlock.domain.IslamicMaritimeBoatingPiracyMercantilismAndOmanYemen.CartographyAstrolabeCompassMilestone;
import com.sovereign.warlock.domain.IslamicMaritimeBoatingPiracyMercantilismAndOmanYemen.MaritimeVesselProfile;
import com.sovereign.warlock.domain.IslamicMaritimeBoatingPiracyMercantilismAndOmanYemen.MercantilismAndCurrencyInstrument;
import com.sovereign.warlock.domain.IslamicMaritimeBoatingPiracyMercantilismAndOmanYemen.OmaniYemeniCoastingPolity;
import com.sovereign.warlock.domain.IslamicMaritimeBoatingPiracyMercantilismAndOmanYemen.PiracyAndMaritimeLawCase;
import com.sovereign.warlock.domain.IslamicMaritimeBoatingPiracyMercantilismAndOmanYemen.StarCompassPortNode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.List;

/**
 * Generates Portal #64:
 * islamic-maritime-boating-piracy-mercantilism-currency-maps-astrolabes-oman-yemen.html
 */
public final class IslamicMaritimeOmanYemenPortalGenerator {

    public static final String FILE_NAME =
            "islamic-maritime-boating-piracy-mercantilism-currency-maps-astrolabes-oman-yemen.html";

    public WarlockHtmlPortalService.GeneratedHtmlArtifact generateMaritimeOmanYemenPortal(Path outputDir) {
        try {
            Files.createDirectories(outputDir);
            String html = renderHtml();
            Path target = outputDir.resolve(FILE_NAME);
            Files.writeString(target, html, StandardCharsets.UTF_8);
            return new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                    FILE_NAME,
                    target,
                    Files.size(target),
                    sha256(html),
                    "Portal #64: Islamic Boating (Sewn Dhows & Lateen Sails), Piracy & Maritime Law (Kitab Akriyat Al-Sufun), Mercantilism (Qirad/Sakk/Karimi), Currency (Dinar/Dirham/Larin), Maps (Al-Idrisi/Piri Reis), Astrolabes, Kamal, 32-Point Star Compass & Omani/Yemeni Coasting Caliphates & Sultanates"
            );
        } catch (IOException e) {
            throw new IllegalStateException("Failed generating " + FILE_NAME, e);
        }
    }

    private String renderHtml() {
        List<MaritimeVesselProfile> vessels =
                IslamicMaritimeBoatingPiracyMercantilismAndOmanYemen.canonicalVesselProfiles();
        List<PiracyAndMaritimeLawCase> piracyCases =
                IslamicMaritimeBoatingPiracyMercantilismAndOmanYemen.canonicalPiracyAndMaritimeLawCases();
        List<MercantilismAndCurrencyInstrument> mercantilism =
                IslamicMaritimeBoatingPiracyMercantilismAndOmanYemen.canonicalMercantilismAndCurrencyInstruments();
        List<CartographyAstrolabeCompassMilestone> instruments =
                IslamicMaritimeBoatingPiracyMercantilismAndOmanYemen.canonicalCartographyAstrolabeCompassMilestones();
        List<StarCompassPortNode> ports =
                IslamicMaritimeBoatingPiracyMercantilismAndOmanYemen.canonicalStarCompassPorts();
        List<OmaniYemeniCoastingPolity> polities =
                IslamicMaritimeBoatingPiracyMercantilismAndOmanYemen.canonicalOmaniYemeniPolities();

        StringBuilder portButtons = new StringBuilder();
        StringBuilder portJsArray = new StringBuilder();
        for (int i = 0; i < ports.size(); i++) {
            StarCompassPortNode p = ports.get(i);
            portButtons.append(String.format(
                    "<button type=\"button\" class=\"port-btn %s\" style=\"border-left:4px solid %s;\" onclick=\"selectMaritimePort(%d, this)\">"
                            + "<strong>#%d %s</strong><br><small style=\"color:#38BDF8;\">Kamāl: %.2f Iṣba' (%.2f°)</small></button>",
                    (i == 0 ? "active" : ""),
                    p.hexAccent(),
                    i,
                    p.nodeIndex(),
                    escape(p.portName()),
                    p.kamalIsbaAltitude(),
                    p.modernLatitudeDeg()
            ));
            portJsArray.append(String.format(
                    "{idx:%d,name:\"%s\",ar:\"%s\",zone:\"%s\",rhumb:\"%s\",isba:%.2f,lat:%.2f,wind:\"%s\",trade:\"%s\",color:\"%s\"},\n",
                    p.nodeIndex(),
                    escapeJs(p.portName()),
                    escapeJs(p.arabicName()),
                    escapeJs(p.coastingZone()),
                    escapeJs(p.starRhumbName()),
                    p.kamalIsbaAltitude(),
                    p.modernLatitudeDeg(),
                    escapeJs(p.monsoonWindRegime()),
                    escapeJs(p.primaryCommoditiesAndCoinage()),
                    p.hexAccent()
            ));
        }

        StringBuilder vesselCards = new StringBuilder();
        for (MaritimeVesselProfile v : vessels) {
            vesselCards.append(String.format("""
                <article class="card" style="border-top:4px solid %s;">
                  <div style="display:flex;justify-content:space-between;align-items:center;margin-bottom:0.45rem;">
                    <span class="tag" style="border-color:%s;color:%s;">VESSEL CLASS #%d</span>
                    <code style="font-size:0.75rem;color:#38BDF8;">%s</code>
                  </div>
                  <h3>%s</h3>
                  <div class="sub-ar">%s</div>
                  <div class="kv"><strong> Hull &amp; Lateen/Sewn Engineering:</strong> %s</div>
                  <div class="kv"><strong>📦 Cargo &amp; Naval Role:</strong> %s</div>
                  <div class="kv proof"><strong>📜 Canonical &amp; Archaeological Anchor:</strong> %s</div>
                </article>
                """,
                    v.hexAccent(), v.hexAccent(), v.hexAccent(), v.vesselIndex(),
                    escape(v.oceanBasinAndOrigin()),
                    escape(v.englishTitle()),
                    escape(v.arabicName()),
                    escape(v.hullAndRiggingEngineering()),
                    escape(v.cargoAndNavalRole()),
                    escape(v.historicalAnchor())
            ));
        }

        StringBuilder piracyCards = new StringBuilder();
        for (PiracyAndMaritimeLawCase c : piracyCases) {
            piracyCards.append(String.format("""
                <article class="card" style="border-top:4px solid %s;">
                  <div style="display:flex;justify-content:space-between;align-items:center;margin-bottom:0.45rem;">
                    <span class="tag" style="border-color:%s;color:%s;">MARITIME LAW &amp; ANTI-PIRACY #%d</span>
                    <code style="font-size:0.74rem;color:#FDE68A;">%s</code>
                  </div>
                  <h3>%s</h3>
                  <div class="sub-ar">%s • %s</div>
                  <div class="kv"><strong>⚖️ Canonical Ruling &amp; Naval Action:</strong> %s</div>
                  <div class="kv proof"><strong>📜 Primary Source Proof:</strong> %s</div>
                </article>
                """,
                    c.hexAccent(), c.hexAccent(), c.hexAccent(), c.caseIndex(),
                    escape(c.eraAndDate()),
                    escape(c.title()),
                    escape(c.arabicLegalOrHistoricalCategory()),
                    escape(c.theaterAndPorts()),
                    escape(c.canonicalRulingAndNavalResponse()),
                    escape(c.primarySourceProof())
            ));
        }

        StringBuilder mercantilismCards = new StringBuilder();
        for (MercantilismAndCurrencyInstrument m : mercantilism) {
            mercantilismCards.append(String.format("""
                <article class="card" style="border-top:4px solid %s;">
                  <div style="display:flex;justify-content:space-between;align-items:center;margin-bottom:0.45rem;">
                    <span class="tag" style="border-color:%s;color:%s;">%s</span>
                  </div>
                  <h3>%s</h3>
                  <div class="sub-ar">%s</div>
                  <div class="kv"><strong>🪙 Weight Standard / Financial Mechanism:</strong> %s</div>
                  <div class="kv"><strong>🌊 Maritime Circulation &amp; Global Reception:</strong> %s</div>
                  <div class="kv proof"><strong>📜 Scriptural &amp; Numismatic Proof:</strong> %s</div>
                </article>
                """,
                    m.hexAccent(), m.hexAccent(), m.hexAccent(),
                    escape(m.category()),
                    escape(m.englishEquivalent()),
                    escape(m.arabicTermAndEtymology()),
                    escape(m.weightOrFinancialMechanism()),
                    escape(m.maritimeTradeCirculation()),
                    escape(m.historicalAndQuranicProof())
            ));
        }

        StringBuilder instrumentCards = new StringBuilder();
        for (CartographyAstrolabeCompassMilestone inst : instruments) {
            instrumentCards.append(String.format("""
                <article class="card" style="border-top:4px solid %s;">
                  <div style="display:flex;justify-content:space-between;align-items:center;margin-bottom:0.45rem;">
                    <span class="tag" style="border-color:%s;color:%s;">%s</span>
                    <code style="font-size:0.74rem;color:#34D399;">%s</code>
                  </div>
                  <h3>%s</h3>
                  <div class="sub-ar">%s</div>
                  <div class="kv"><strong>📐 Mathematical, Optical &amp; Magnetic Principle:</strong> %s</div>
                  <div class="kv proof"><strong>🧭 Global Navigational Impact:</strong> %s</div>
                </article>
                """,
                    inst.hexAccent(), inst.hexAccent(), inst.hexAccent(),
                    escape(inst.instrumentOrAtlasClass()),
                    escape(inst.dateAndCenter()),
                    escape(inst.arabicWorkOrDeviceName()),
                    escape(inst.scholarOrNavigator()),
                    escape(inst.mathematicalAndOpticalPrinciple()),
                    escape(inst.globalNavigationalImpact())
            ));
        }

        StringBuilder polityCards = new StringBuilder();
        for (OmaniYemeniCoastingPolity pol : polities) {
            polityCards.append(String.format("""
                <article class="card" style="border-left:5px solid %s;">
                  <div style="display:flex;justify-content:space-between;align-items:center;margin-bottom:0.45rem;">
                    <span class="tag" style="border-color:%s;color:%s;">%s</span>
                    <code style="font-size:0.75rem;color:#FDE68A;">%s</code>
                  </div>
                  <h3>%s</h3>
                  <div class="sub-ar">Ports &amp; Capitals: %s</div>
                  <div class="kv"><strong>🏛️ Caliphal Relationship &amp; Constitutional Sovereignty:</strong> %s</div>
                  <div class="kv"><strong>⛵ Naval Fleets, Navigation &amp; Oceanic Trade:</strong> %s</div>
                  <div class="kv proof"><strong>🕌 Architectural &amp; Scientific Monuments:</strong> %s</div>
                </article>
                """,
                    pol.hexAccent(), pol.hexAccent(), pol.hexAccent(),
                    escape(pol.regionAxis()),
                    escape(pol.dateSpan()),
                    escape(pol.dynastyOrImamateName()),
                    escape(pol.capitalAndCoastingPorts()),
                    escape(pol.caliphalRelationshipAndSovereignty()),
                    escape(pol.navalFleetsNavigationAndTrade()),
                    escape(pol.architecturalAndScientificLegacy())
            ));
        }

        return """
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Boating, Piracy, Mercantilism, Currency, Maps, Astrolabes, Compasses &amp; Omani/Yemeni Coasting Caliphates | Portal #64</title>
  <style>
    :root {
      --bg-deep: #040812;
      --bg-card: #0B1324;
      --bg-alt: #101C35;
      --gold: #D4AF37;
      --cyan: #38BDF8;
      --emerald: #10B981;
      --rose: #F43F5E;
      --text: #ECEFF4;
      --muted: #94A3B8;
      --border: rgba(255,255,255,0.12);
    }
    * { box-sizing: border-box; margin: 0; padding: 0; }
    body {
      background:
        radial-gradient(circle at 12%% 10%%, rgba(56, 189, 248, 0.16), transparent 45%%),
        radial-gradient(circle at 88%% 15%%, rgba(212, 175, 55, 0.15), var(--bg-deep) 65%%);
      color: var(--text);
      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
      line-height: 1.65;
      padding-bottom: 4rem;
    }
    main { max-width: 1520px; margin: 1.6rem auto; padding: 0 1.4rem; }
    .hero {
      background: linear-gradient(135deg, #09152B 0%%, #0F293A 50%%, #1E182B 100%%);
      border: 1px solid var(--border);
      border-left: 6px solid var(--gold);
      border-radius: 16px;
      padding: 2rem;
      margin-bottom: 1.8rem;
      box-shadow: 0 16px 44px rgba(0,0,0,0.55);
    }
    .badge-row { display: flex; flex-wrap: wrap; gap: 0.45rem; margin-bottom: 0.75rem; }
    .tag {
      display: inline-block;
      font-family: 'Consolas', monospace;
      font-size: 0.72rem;
      font-weight: 700;
      padding: 0.18rem 0.55rem;
      border-radius: 6px;
      background: rgba(255,255,255,0.05);
      border: 1px solid var(--gold);
      color: #FDE68A;
    }
    h1 { font-size: 2.05rem; color: #FFF; margin-bottom: 0.55rem; }
    .ayat-box {
      background: rgba(16, 185, 129, 0.09);
      border-left: 4px solid var(--emerald);
      padding: 0.9rem 1.2rem;
      border-radius: 0 10px 10px 0;
      margin: 1rem 0;
      font-size: 0.94rem;
      color: #D1FAE5;
    }
    .workbench {
      background: var(--bg-card);
      border: 2px solid var(--gold);
      border-radius: 16px;
      padding: 1.6rem;
      margin-bottom: 2rem;
    }
    .wb-grid {
      display: grid;
      grid-template-columns: 340px 1fr 390px;
      gap: 1.25rem;
      align-items: start;
      margin-top: 1rem;
    }
    @media (max-width: 1180px) {
      .wb-grid { grid-template-columns: 1fr; }
    }
    .port-list { display: flex; flex-direction: column; gap: 0.45rem; }
    .port-btn {
      background: rgba(255,255,255,0.03);
      border: 1px solid var(--border);
      border-radius: 8px;
      padding: 0.55rem 0.75rem;
      color: var(--text);
      text-align: left;
      cursor: pointer;
      transition: all 0.15s ease;
      font-size: 0.82rem;
    }
    .port-btn:hover, .port-btn.active {
      background: rgba(212, 175, 55, 0.18);
      border-color: var(--gold);
      color: #FFF;
    }
    .compass-stage {
      background: #050914;
      border: 1px solid var(--border);
      border-radius: 12px;
      padding: 1rem;
      text-align: center;
    }
    .telemetry-box {
      background: var(--bg-alt);
      border: 1px solid var(--border);
      border-radius: 12px;
      padding: 1.15rem;
    }
    .sec-title {
      font-size: 1.4rem;
      color: #FDE68A;
      margin: 2.2rem 0 0.85rem 0;
      padding-bottom: 0.4rem;
      border-bottom: 2px solid rgba(212, 175, 55, 0.35);
    }
    .grid-2 {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(430px, 1fr));
      gap: 1.2rem;
    }
    .card {
      background: var(--bg-card);
      border: 1px solid var(--border);
      border-radius: 12px;
      padding: 1.35rem;
      display: flex;
      flex-direction: column;
      gap: 0.55rem;
    }
    .card h3 { font-size: 1.08rem; color: #FFF; }
    .sub-ar {
      font-family: 'Consolas', monospace;
      font-size: 0.8rem;
      color: #FDE68A;
      margin-bottom: 0.2rem;
    }
    .kv { font-size: 0.86rem; color: #CBD5E1; }
    .kv strong { color: #F8FAFC; }
    .kv.proof {
      margin-top: auto;
      padding-top: 0.55rem;
      border-top: 1px dashed rgba(255,255,255,0.12);
      color: #A7F3D0;
      font-size: 0.82rem;
    }
  </style>
</head>
<body>
  <main>
    <section class="hero">
      <div class="badge-row">
        <span class="tag">PORTAL #64 • ISLAMIC MARITIME CIVILIZATION &amp; THALASSOCRACY</span>
        <span class="tag" style="border-color:#38BDF8;color:#38BDF8;">SEWN DHOWS, LATEEN SAILS &amp; FIQH AL-BAḤR</span>
        <span class="tag" style="border-color:#10B981;color:#34D399;">QIRĀḌ (COMMENDA), ṢAKK (CHEQUE) &amp; DĪNĀR/DIRHAM/LĀRĪN</span>
        <span class="tag" style="border-color:#F43F5E;color:#FDA4AF;">ASTROLABE, KAMĀL, 32-STAR COMPASS &amp; OMANI/YEMENI POLITIES</span>
      </div>
      <h1>Boating, Piracy, Mercantilism, Currency, Maps, Astrolabes, Compasses &amp; The Omani and Yemeni Coasting Caliphates</h1>
      <p style="color:#CBD5E1;font-size:0.96rem;">
        A canonical historical, legal, numismatic, and navigational synthesis of how Islam transformed the Mediterranean, Red Sea, Persian Gulf,
        and Indian Ocean into a rule-of-law maritime commonwealth—from stitched-plank <strong>Omani China Dhows (<em>Al-Khayṭīyah</em>)</strong>
        and <strong>Yemeni Red Sea <em>Sambūqs</em></strong> to <strong><em>Kitāb Akriyat Al-Sufun</em></strong> (anti-piracy and General Average jettison law),
        <strong><em>Qirāḍ / Commenda</em></strong> venture capital, <strong>Caliphal Gold <em>Dīnārs</em> &amp; Hormuzi <em>Lārīns</em></strong>,
        <strong>Al-Idrīsī &amp; Piri Reis cartography</strong>, the <strong>Universal Astrolabe &amp; Mariner's <em>Kamāl</em></strong>,
        <strong>Aḥmad ibn Mājid's 32-Point Sidereal Compass Rose (<em>Dā'irat Al-Akhnān</em>)</strong>, and the great
        <strong>Yemeni (Sulayhid, Rasulid, Tahirid, Mocha/Hadhrami)</strong> and <strong>Omani (Al-Julandā, First Imamate, Nabhani, Ya'rubid, Al Bu Sa'id)</strong> maritime states.
      </p>
      <div class="ayat-box">
        <strong>Qur'an 16:14 &amp; 55:24 (The Divine Subjection of the Sea &amp; Mountain-Tall Sails):</strong><br>
        <em>"And it is He who subjected the sea (Sakhkhara al-baḥra) that you may eat from it tender meat and extract from it ornaments which you wear; and you see the ships plowing through it (Wa tarā al-fulka mawākhira fīhi), and that you may seek of His bounty (Wa li-tabtaghū min faḍlihi)..."</em> (Surah An-Naḥl 16:14) •
        <em>"And to Him belong the ships with raised sails (Al-Jawārī al-Munsha'āt) in the sea like mountains (ka-al-a'lām)."</em> (Surah Ar-Raḥmān 55:24)
      </div>
    </section>

    <section class="workbench">
      <div style="display:flex;flex-wrap:wrap;justify-content:space-between;align-items:center;gap:0.8rem;">
        <div>
          <span class="tag">INTERACTIVE CELESTIAL &amp; MONSOON NAVIGATION WORKBENCH</span>
          <h2 style="font-size:1.3rem;color:#FFF;margin-top:0.3rem;">
            Ibn Mājid's 32-Point Star Compass (<em>Dā'irat Al-Akhnān</em>), Astrolabe &amp; Mariner's <em>Kamāl</em> Simulator
          </h2>
        </div>
        <div style="display:flex;align-items:center;gap:0.65rem;">
          <label for="kamalSlider" style="font-family:Consolas,monospace;font-size:0.8rem;color:#FDE68A;">
            Adjust Mariner's Kamāl Knot (Iṣba' Altitude of Polaris):
          </label>
          <input id="kamalSlider" type="range" min="1.0" max="11.5" step="0.25" value="11.0" oninput="onKamalSliderChange(this.value)">
          <span id="kamalReadout" class="tag" style="font-size:0.84rem;">11.00 Iṣba'</span>
        </div>
      </div>

      <div class="wb-grid">
        <div class="port-list">
          <div style="font-family:Consolas,monospace;font-size:0.75rem;color:#FDE68A;margin-bottom:0.2rem;">
            SELECT OMANI, YEMENI OR INDIAN OCEAN PORT:
          </div>
          %s
        </div>

        <div class="compass-stage">
          <svg id="starCompassSvg" viewBox="0 0 460 420" style="width:100%%;max-width:450px;height:auto;">
            <defs>
              <radialGradient id="oceanGlow" cx="50%%" cy="50%%" r="50%%">
                <stop offset="0%%" stop-color="#1E3A5F" stop-opacity="0.55"/>
                <stop offset="100%%" stop-color="#050914" stop-opacity="1"/>
              </radialGradient>
            </defs>
            <rect width="460" height="420" rx="12" fill="url(#oceanGlow)"/>
            <!-- Outer Astrolabe Degree & 32-Rhumb Star Ring -->
            <circle cx="230" cy="210" r="175" fill="none" stroke="#D4AF37" stroke-width="2.5"/>
            <circle cx="230" cy="210" r="145" fill="none" stroke="rgba(56,189,248,0.45)" stroke-width="1.2" stroke-dasharray="4 3"/>
            <circle cx="230" cy="210" r="105" fill="none" stroke="rgba(212,175,55,0.35)" stroke-width="1"/>
            <!-- Cardinal & Monsoon Axes -->
            <line x1="230" y1="25" x2="230" y2="395" stroke="rgba(212,175,55,0.5)" stroke-width="1.5"/>
            <line x1="45" y1="210" x2="415" y2="210" stroke="rgba(212,175,55,0.5)" stroke-width="1.5"/>
            <line x1="100" y1="80" x2="360" y2="340" stroke="rgba(16,185,129,0.45)" stroke-width="1.5" stroke-dasharray="5 4"/>
            <line x1="360" y1="80" x2="100" y2="340" stroke="rgba(244,63,94,0.45)" stroke-width="1.5" stroke-dasharray="5 4"/>

            <!-- Star Labels -->
            <text x="230" y="18" fill="#FDE68A" font-size="11" font-family="Consolas,monospace" text-anchor="middle" font-weight="bold">▲ N: AL-JĀH (POLARIS • 0°)</text>
            <text x="230" y="412" fill="#FDA4AF" font-size="11" font-family="Consolas,monospace" text-anchor="middle" font-weight="bold">▼ S: AL-QUṬB AL-SUHAYLĪ (CANOPUS • 180°)</text>
            <text x="448" y="214" fill="#38BDF8" font-size="10" font-family="Consolas,monospace" text-anchor="end" font-weight="bold">E: MAṬLA' AL-JAWZĀ' ►</text>
            <text x="12" y="214" fill="#34D399" font-size="10" font-family="Consolas,monospace" text-anchor="start" font-weight="bold">◄ W: MAGHĪB</text>
            <text x="368" y="74" fill="#6EE7B7" font-size="9.5" font-family="Consolas,monospace" text-anchor="middle">NE Monsoon (Azyab)</text>
            <text x="95" y="355" fill="#FDE68A" font-size="9.5" font-family="Consolas,monospace" text-anchor="middle">SW Monsoon (Kaws)</text>

            <!-- Rotating Magnetic Needle & Alidade Sight -->
            <g id="compassNeedleGroup" transform="rotate(15, 230, 210)">
              <polygon points="230,52 221,210 239,210" fill="#D4AF37" opacity="0.9"/>
              <polygon points="230,368 221,210 239,210" fill="#38BDF8" opacity="0.75"/>
              <circle cx="230" cy="210" r="11" fill="#0B1324" stroke="#D4AF37" stroke-width="3"/>
            </g>

            <!-- Kamal Horizon & Star Sight Overlay -->
            <rect x="155" y="135" width="150" height="44" rx="4" fill="rgba(212,175,55,0.16)" stroke="#D4AF37" stroke-width="1.5"/>
            <text id="svgKamalLabel" x="230" y="154" fill="#FFF" font-size="11" font-family="Consolas,monospace" text-anchor="middle" font-weight="bold">KAMĀL: 11.00 IṢBA'</text>
            <text id="svgPortLabel" x="230" y="170" fill="#38BDF8" font-size="10" font-family="Consolas,monospace" text-anchor="middle">Muscat &amp; Sohar (23.61° N)</text>
          </svg>
        </div>

        <div class="telemetry-box">
          <div style="font-family:Consolas,monospace;font-size:0.74rem;color:#38BDF8;">LIVE MU'ALLIM CELESTIAL &amp; MONSOON TELEMETRY</div>
          <h3 id="telPortTitle" style="font-size:1.18rem;color:#FDE68A;margin:0.25rem 0;">#1 Muscat &amp; Sohar (Oman)</h3>
          <div id="telPortAr" style="font-family:Consolas,monospace;font-size:0.84rem;color:#34D399;margin-bottom:0.65rem;">Masqaṭ wa Ṣuḥār (مسقط وصحار)</div>
          <div class="kv" style="margin-bottom:0.45rem;"><strong>🌊 Coasting Zone:</strong> <span id="telZone">Omani Heartlands (Gulf of Oman)</span></div>
          <div class="kv" style="margin-bottom:0.45rem;"><strong>⭐ Star Compass Rhumb (Al-Khunn):</strong> <span id="telRhumb">Maṭla' Al-Nisr Al-Ṭā'ir (Rising of Altair — E by N)</span></div>
          <div class="kv" style="margin-bottom:0.45rem;"><strong>📏 Kamāl Altitude &amp; Latitude:</strong> <span id="telKamal" style="color:#FDE68A;font-family:Consolas,monospace;">11.00 Iṣba' → 23.61° Lat</span></div>
          <div class="kv" style="margin-bottom:0.45rem;"><strong>🌬️ Monsoon Sailing Window (Al-Mawsim):</strong> <span id="telWind">NE Winter Monsoon (Al-Azyab / Kaws, Nov–Mar)</span></div>
          <div class="kv"><strong>🪙 Cargoes &amp; Currency Standard:</strong> <span id="telTrade">Frankincense, Copper, Dates, Arabian Horses, Pearls • Abbasid Dīnār &amp; Omani Sa'īdī Riyāl</span></div>
        </div>
      </div>
    </section>

    <h2 class="sec-title">I. Canonical Boating &amp; Naval Architecture (<em>Ṣinā'at Al-Sufun</em>): Sewn Dhows, Lateen Sails &amp; War Galleys</h2>
    <div class="grid-2">
      %s
    </div>

    <h2 class="sec-title">II. Piracy (<em>Al-Ghaṣb</em>), Privateering (<em>Ghazw Al-Baḥr</em>), Islamic Maritime Law (<em>Kitāb Akriyat Al-Sufun</em>) &amp; Anti-Piracy Fleets</h2>
    <div class="grid-2">
      %s
    </div>

    <h2 class="sec-title">III. Islamic Maritime Mercantilism &amp; Global Currency Standards (<em>Dīnār, Dirham, Qirāḍ, Ṣakk, Kārimī &amp; Lārīn</em>)</h2>
    <div class="grid-2">
      %s
    </div>

    <h2 class="sec-title">IV. Maps (<em>Kharā'iṭ</em>), Astrolabes (<em>Al-Asṭurlāb</em>), The Mariner's <em>Kamāl</em> &amp; The 32-Point Magnetic Star Compass</h2>
    <div class="grid-2">
      %s
    </div>

    <h2 class="sec-title">V. The Omani &amp; Yemeni Coasting Caliphates, Imamates &amp; Sultanates (<code>630 CE – 1856+ CE</code>)</h2>
    <div class="grid-2">
      %s
    </div>
  </main>

  <script>
    const MARITIME_PORTS = [
      %s
    ];

    function selectMaritimePort(index, btnEl) {
      const p = MARITIME_PORTS[index] || MARITIME_PORTS[0];
      document.querySelectorAll('.port-btn').forEach((b, i) => {
        b.classList.toggle('active', i === index);
      });
      document.getElementById('telPortTitle').textContent = '#' + p.idx + ' ' + p.name;
      document.getElementById('telPortAr').textContent = p.ar;
      document.getElementById('telZone').textContent = p.zone;
      document.getElementById('telRhumb').textContent = p.rhumb;
      document.getElementById('telKamal').textContent = p.isba.toFixed(2) + " Iṣba' → " + p.lat.toFixed(2) + "° Lat";
      document.getElementById('telWind').textContent = p.wind;
      document.getElementById('telTrade').textContent = p.trade;

      const slider = document.getElementById('kamalSlider');
      if (slider) slider.value = p.isba;
      document.getElementById('kamalReadout').textContent = p.isba.toFixed(2) + " Iṣba'";
      document.getElementById('svgKamalLabel').textContent = "KAMĀL: " + p.isba.toFixed(2) + " IṢBA'";
      document.getElementById('svgPortLabel').textContent = p.name + " (" + p.lat.toFixed(2) + "°)";

      const angle = (index * 42 + 15) %% 360;
      const needle = document.getElementById('compassNeedleGroup');
      if (needle) needle.setAttribute('transform', 'rotate(' + angle + ', 230, 210)');
    }

    function onKamalSliderChange(val) {
      const num = parseFloat(val);
      document.getElementById('kamalReadout').textContent = num.toFixed(2) + " Iṣba'";
      let bestIdx = 0;
      let bestDiff = 999;
      MARITIME_PORTS.forEach((p, idx) => {
        const d = Math.abs(p.isba - num);
        if (d < bestDiff) { bestDiff = d; bestIdx = idx; }
      });
      selectMaritimePort(bestIdx);
    }
  </script>
</body>
</html>
""".formatted(
                portButtons.toString(),
                vesselCards.toString(),
                piracyCards.toString(),
                mercantilismCards.toString(),
                instrumentCards.toString(),
                polityCards.toString(),
                portJsArray.toString()
        );
    }

    private static String escape(String s) {
        if (s == null) {
            return "";
        }
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }

    private static String escapeJs(String s) {
        if (s == null) {
            return "";
        }
        return s.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", " ");
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
