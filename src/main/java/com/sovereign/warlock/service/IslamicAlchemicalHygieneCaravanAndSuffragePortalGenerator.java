package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.IslamicAlchemicalHygieneCaravanAndSuffrageAtlas;
import com.sovereign.warlock.domain.IslamicAlchemicalHygieneCaravanAndSuffrageAtlas.AlchemicalHygieneApparatus;
import com.sovereign.warlock.domain.IslamicAlchemicalHygieneCaravanAndSuffrageAtlas.CaliphateGovernanceOrgan;
import com.sovereign.warlock.domain.IslamicAlchemicalHygieneCaravanAndSuffrageAtlas.GenderSuffrageAndAgencyMilestone;
import com.sovereign.warlock.domain.IslamicAlchemicalHygieneCaravanAndSuffrageAtlas.HomogeneityAndInsularGovernancePillar;
import com.sovereign.warlock.domain.IslamicAlchemicalHygieneCaravanAndSuffrageAtlas.IslamicManAndCaravanArchetype;
import com.sovereign.warlock.domain.IslamicAlchemicalHygieneCaravanAndSuffrageAtlas.IslamicSuffragePillarAndCause;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.List;

/**
 * Generates Portal #66:
 * Alchemical Wares, Douching & Hygiene, Homosexuality & Homogeneous Self-Governing Structures,
 * The Seven Archetypes of the Islamic Man & The Caravan Through Antiquity,
 * Caliphate Constitutional Organization, and Islamic Suffrage (Al-Shura, Al-Bay'ah,
 * Al-Mujadilah & Wilayat Al-Mazalim Across Common, Royal, Young, Old & Gender Causes).
 */
public final class IslamicAlchemicalHygieneCaravanAndSuffragePortalGenerator {

    public static final String PORTAL_FILENAME =
            "islamic-alchemical-hygiene-caravan-governance-and-suffrage-thesis.html";

    public WarlockHtmlPortalService.GeneratedHtmlArtifact generatePortal(Path outputDir) throws IOException {
        Files.createDirectories(outputDir);
        String html = renderHtml();
        Path target = outputDir.resolve(PORTAL_FILENAME);
        Files.writeString(target, html, StandardCharsets.UTF_8);
        return new WarlockHtmlPortalService.GeneratedHtmlArtifact(
                PORTAL_FILENAME,
                target,
                Files.size(target),
                sha256(html),
                "Alchemical Wares, Douching & Hygiene, Homosexuality/Homogeneity/Insular Self-Governance, The 7 Caravan & Islamic Man Archetypes, Caliphate Organization & Islamic Suffrage (Al-Shura, Al-Bay'ah, Al-Mujadilah Across Common, Royal, Young, Old & Gender Causes)"
        );
    }

    private String renderHtml() {
        List<AlchemicalHygieneApparatus> wares =
                IslamicAlchemicalHygieneCaravanAndSuffrageAtlas.allSevenAlchemicalHygieneWares();
        List<HomogeneityAndInsularGovernancePillar> homogeneityPillars =
                IslamicAlchemicalHygieneCaravanAndSuffrageAtlas.allSevenHomogeneityAndInsularStructures();
        List<IslamicManAndCaravanArchetype> caravanArchetypes =
                IslamicAlchemicalHygieneCaravanAndSuffrageAtlas.allSevenIslamicManAndCaravanArchetypes();
        List<CaliphateGovernanceOrgan> caliphateOrgans =
                IslamicAlchemicalHygieneCaravanAndSuffrageAtlas.allSixCaliphateGovernanceOrgans();
        List<IslamicSuffragePillarAndCause> suffrageCauses =
                IslamicAlchemicalHygieneCaravanAndSuffrageAtlas.allNineSuffragePillarsAndCauses();
        List<GenderSuffrageAndAgencyMilestone> genderMilestones =
                IslamicAlchemicalHygieneCaravanAndSuffrageAtlas.allSevenGenderSuffrageMilestones();

        StringBuilder waresCards = new StringBuilder();
        for (AlchemicalHygieneApparatus w : wares) {
            waresCards.append(String.format("""
                    <article class="card-panel" style="border-top: 4px solid %s;">
                      <div class="card-meta">
                        <span class="pill-badge" style="background:%s22;color:%s;border:1px solid %s66;">APPARATUS #%d</span>
                        <span class="arabic-chip">%s</span>
                      </div>
                      <h3>%s</h3>
                      <p class="sub-author"><strong>Pioneers &amp; Treatises:</strong> %s</p>
                      <div class="detail-grid">
                        <div><strong>Material &amp; Alchemical Synthesis:</strong> %s</div>
                        <div><strong>Hygienic, Clinical &amp; Douching Function:</strong> %s</div>
                        <div class="fiqh-box"><strong>Canonical Fiqh &amp; Scriptural Anchor:</strong> %s</div>
                      </div>
                    </article>
                    """,
                    w.colorHex(), w.colorHex(), w.colorHex(), w.colorHex(), w.index(),
                    escape(w.arabicName()),
                    escape(w.englishTitle()),
                    escape(w.pioneerScholarsAndTexts()),
                    escape(w.materialAndChemicalComposition()),
                    escape(w.hygienicAndMedicalFunction()),
                    escape(w.fiqhRulingAndScripturalAnchor())
            ));
        }

        StringBuilder homogeneityCards = new StringBuilder();
        for (HomogeneityAndInsularGovernancePillar p : homogeneityPillars) {
            homogeneityCards.append(String.format("""
                    <article class="card-panel" style="border-left: 5px solid %s;">
                      <div class="card-meta">
                        <span class="pill-badge" style="background:%s22;color:%s;border:1px solid %s66;">#%d • %s</span>
                      </div>
                      <h3>%s <span style="color:#94A3B8;font-size:0.92rem;font-weight:500;">(%s)</span></h3>
                      <p class="sub-author"><strong>Scriptural &amp; Juristic Foundation:</strong> %s</p>
                      <p style="margin-bottom:0.75rem;"><strong>Structural &amp; Legal Mechanism:</strong> %s</p>
                      <p style="color:#CBD5E1;"><strong>Historical &amp; Sociological Reality:</strong> %s</p>
                    </article>
                    """,
                    p.colorHex(), p.colorHex(), p.colorHex(), p.colorHex(), p.index(), escape(p.dimensionCategory()),
                    escape(p.englishTitle()), escape(p.arabicTitle()),
                    escape(p.scripturalAndJuristicAnchor()),
                    escape(p.structuralMechanism()),
                    escape(p.historicalAndSocialAnalysis())
            ));
        }

        StringBuilder caravanCards = new StringBuilder();
        for (IslamicManAndCaravanArchetype a : caravanArchetypes) {
            caravanCards.append(String.format("""
                    <article class="card-panel" style="border-top: 4px solid %s;">
                      <div class="card-meta">
                        <span class="pill-badge" style="background:%s22;color:%s;border:1px solid %s66;">ARCHETYPE #%d • %s</span>
                      </div>
                      <h3>%s</h3>
                      <p class="arabic-chip" style="margin-bottom:0.65rem;display:inline-block;">%s</p>
                      <div class="detail-grid">
                        <div><strong>Social Station &amp; Daily / Desert Rhythm:</strong> %s</div>
                        <div class="fiqh-box"><strong>Qur'anic &amp; Prophetic Sunnah Anchor:</strong> %s</div>
                        <div><strong>Historical Exemplars &amp; Phenomenology Through Antiquity:</strong> %s</div>
                      </div>
                    </article>
                    """,
                    a.colorHex(), a.colorHex(), a.colorHex(), a.colorHex(), a.index(), escape(a.archetypeCode()),
                    escape(a.englishTitle()),
                    escape(a.arabicTitle()),
                    escape(a.socialStationAndDailyRhythm()),
                    escape(a.canonicalScripturalAndHadithAnchor()),
                    escape(a.historicalExemplarsAndPhenomenology())
            ));
        }

        StringBuilder organRows = new StringBuilder();
        for (CaliphateGovernanceOrgan o : caliphateOrgans) {
            organRows.append(String.format("""
                    <tr>
                      <td><strong>#%d</strong></td>
                      <td><strong style="color:#FDE68A;">%s</strong><br><span style="font-size:0.84rem;color:#34D399;">%s</span></td>
                      <td>%s</td>
                      <td>%s</td>
                      <td>%s</td>
                    </tr>
                    """,
                    o.index(),
                    escape(o.englishTitle()),
                    escape(o.arabicTitle()),
                    escape(o.constitutionalTreatiseSource()),
                    escape(o.organizationalJurisdiction()),
                    escape(o.checksAndBalancesMechanism())
            ));
        }

        StringBuilder suffrageCards = new StringBuilder();
        for (IslamicSuffragePillarAndCause s : suffrageCauses) {
            suffrageCards.append(String.format("""
                    <article class="card-panel" style="border-left: 5px solid %s;">
                      <div class="card-meta">
                        <span class="pill-badge" style="background:%s22;color:%s;border:1px solid %s66;">#%d • %s</span>
                      </div>
                      <h3>%s — <span style="color:#FDE68A;">%s</span></h3>
                      <p class="sub-author"><strong>Qur'anic &amp; Prophetic Foundation:</strong> %s</p>
                      <p style="margin-bottom:0.75rem;"><strong>Mechanism of Suffrage, Voice &amp; Representation:</strong> %s</p>
                      <div class="fiqh-box"><strong>Taking What You Go Through &amp; Effecting Change:</strong> %s</div>
                    </article>
                    """,
                    s.colorHex(), s.colorHex(), s.colorHex(), s.colorHex(), s.index(), escape(s.categoryBadge()),
                    escape(s.englishTitle()), escape(s.arabicTerm()),
                    escape(s.quranicAndPropheticFoundation()),
                    escape(s.mechanismOfSuffrageAndVoice()),
                    escape(s.transformingExperienceIntoChange())
            ));
        }

        StringBuilder genderRows = new StringBuilder();
        for (GenderSuffrageAndAgencyMilestone g : genderMilestones) {
            genderRows.append(String.format("""
                    <tr>
                      <td><strong>#%d</strong></td>
                      <td><span class="pill-badge" style="background:rgba(236,72,153,0.16);color:#F472B6;border:1px solid rgba(236,72,153,0.4);">%s</span></td>
                      <td><strong style="color:#FDE68A;">%s</strong></td>
                      <td><code>%s</code></td>
                      <td>%s</td>
                      <td style="color:#A7F3D0;">%s</td>
                    </tr>
                    """,
                    g.index(),
                    escape(g.eraLabel()),
                    escape(g.protagonistOrMovement()),
                    escape(g.arabicAndScripturalAnchor()),
                    escape(g.livedOrdealOrQuestion()),
                    escape(g.institutionalAndLegalChangeEffected())
            ));
        }

        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <title>Portal #66 | Alchemical Wares, Douching &amp; Hygiene, Homogeneity &amp; Insular Governance, The 7 Caravan &amp; Man Archetypes, Caliphate Organization &amp; Islamic Suffrage</title>
                  <style>
                    :root {
                      --bg-deep: #070B12;
                      --bg-card: #0F1624;
                      --bg-card-alt: #151F32;
                      --accent-gold: #D4AF37;
                      --accent-emerald: #10B981;
                      --accent-cyan: #38BDF8;
                      --accent-rose: #F43F5E;
                      --accent-violet: #A855F7;
                      --text-main: #F1F5F9;
                      --text-muted: #94A3B8;
                      --border-subtle: rgba(212, 175, 55, 0.22);
                    }
                    * { box-sizing: border-box; margin: 0; padding: 0; }
                    body {
                      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
                      background: radial-gradient(circle at 20%% 0%%, #112233 0%%, var(--bg-deep) 55%%);
                      color: var(--text-main);
                      line-height: 1.68;
                      padding-bottom: 5rem;
                    }
                    .container {
                      max-width: 1420px;
                      margin: 0 auto;
                      padding: 2rem 1.75rem;
                    }
                    .hero-banner {
                      background: linear-gradient(135deg, rgba(15, 22, 36, 0.96), rgba(16, 185, 129, 0.14), rgba(212, 175, 55, 0.14));
                      border: 1px solid var(--border-subtle);
                      border-left: 6px solid var(--accent-gold);
                      border-radius: 16px;
                      padding: 2.4rem;
                      margin-bottom: 2.5rem;
                      box-shadow: 0 20px 50px rgba(0,0,0,0.45);
                    }
                    .badge-row {
                      display: flex;
                      flex-wrap: wrap;
                      gap: 0.55rem;
                      margin-bottom: 1rem;
                    }
                    .pill-badge {
                      display: inline-block;
                      padding: 0.28rem 0.75rem;
                      border-radius: 999px;
                      font-size: 0.76rem;
                      font-weight: 700;
                      letter-spacing: 0.05em;
                      text-transform: uppercase;
                    }
                    h1 {
                      font-size: 2.25rem;
                      line-height: 1.22;
                      color: #FFF;
                      margin-bottom: 0.85rem;
                    }
                    .hero-lead {
                      font-size: 1.08rem;
                      color: #CBD5E1;
                      max-width: 1180px;
                    }
                    .arabic-banner {
                      margin-top: 1.25rem;
                      padding: 1rem 1.35rem;
                      background: rgba(7, 11, 18, 0.78);
                      border: 1px solid rgba(16, 185, 129, 0.35);
                      border-radius: 10px;
                      font-size: 1.15rem;
                      color: #FDE68A;
                    }
                    .section-block {
                      margin-bottom: 3.2rem;
                    }
                    .section-header {
                      border-bottom: 2px solid var(--border-subtle);
                      padding-bottom: 0.75rem;
                      margin-bottom: 1.5rem;
                    }
                    .section-header h2 {
                      font-size: 1.65rem;
                      color: #FDE68A;
                    }
                    .section-header p {
                      color: var(--text-muted);
                      font-size: 0.98rem;
                      margin-top: 0.3rem;
                    }
                    .cards-grid {
                      display: grid;
                      grid-template-columns: repeat(auto-fit, minmax(390px, 1fr));
                      gap: 1.35rem;
                    }
                    .card-panel {
                      background: var(--bg-card);
                      border: 1px solid rgba(255,255,255,0.09);
                      border-radius: 12px;
                      padding: 1.5rem;
                      display: flex;
                      flex-direction: column;
                      gap: 0.7rem;
                      box-shadow: 0 10px 26px rgba(0,0,0,0.3);
                    }
                    .card-meta {
                      display: flex;
                      justify-content: space-between;
                      align-items: center;
                      flex-wrap: wrap;
                      gap: 0.5rem;
                    }
                    .arabic-chip {
                      font-family: 'Traditional Arabic', 'Amiri', serif;
                      font-size: 1.05rem;
                      color: #FDE68A;
                      background: rgba(212, 175, 55, 0.12);
                      padding: 0.2rem 0.65rem;
                      border-radius: 6px;
                      border: 1px solid rgba(212, 175, 55, 0.3);
                    }
                    .card-panel h3 {
                      font-size: 1.2rem;
                      color: #FFF;
                    }
                    .sub-author {
                      font-size: 0.9rem;
                      color: #38BDF8;
                    }
                    .detail-grid {
                      display: flex;
                      flex-direction: column;
                      gap: 0.65rem;
                      font-size: 0.94rem;
                      color: #E2E8F0;
                    }
                    .fiqh-box {
                      background: rgba(16, 185, 129, 0.09);
                      border-left: 3px solid #10B981;
                      padding: 0.65rem 0.85rem;
                      border-radius: 0 8px 8px 0;
                      font-size: 0.91rem;
                      color: #D1FAE5;
                    }
                    .svg-showcase {
                      background: #090E18;
                      border: 1px solid var(--border-subtle);
                      border-radius: 14px;
                      padding: 1.5rem;
                      margin-bottom: 1.75rem;
                      overflow-x: auto;
                    }
                    .table-wrap {
                      background: var(--bg-card);
                      border: 1px solid rgba(255,255,255,0.1);
                      border-radius: 12px;
                      padding: 1.25rem;
                      overflow-x: auto;
                    }
                    table {
                      width: 100%%;
                      border-collapse: collapse;
                      font-size: 0.92rem;
                    }
                    th, td {
                      padding: 0.85rem 0.75rem;
                      text-align: left;
                      border-bottom: 1px solid rgba(255,255,255,0.08);
                      vertical-align: top;
                    }
                    th {
                      color: #FDE68A;
                      font-size: 0.8rem;
                      text-transform: uppercase;
                      letter-spacing: 0.05em;
                      background: rgba(255,255,255,0.03);
                    }
                    code {
                      font-family: 'Consolas', monospace;
                      color: #7DD3FC;
                      font-size: 0.85rem;
                    }
                  </style>
                </head>
                <body>
                  <div class="container">
                    <section class="hero-banner">
                      <div class="badge-row">
                        <span class="pill-badge" style="background:rgba(212,175,55,0.2);color:#FDE68A;border:1px solid #D4AF37;">PORTAL #66 • COLLEGIATE ANTHROPOLOGY, JURISPRUDENCE &amp; CONSTITUTIONAL THESIS</span>
                        <span class="pill-badge" style="background:rgba(16,185,129,0.2);color:#34D399;border:1px solid #10B981;">ALCHEMICAL WARES, DOUCHING &amp; FIQH AL-ṬAHĀRAH</span>
                        <span class="pill-badge" style="background:rgba(56,189,248,0.2);color:#7DD3FC;border:1px solid #38BDF8;">7 ARCHETYPES OF THE ISLAMIC MAN &amp; THE CARAVAN</span>
                        <span class="pill-badge" style="background:rgba(244,63,94,0.2);color:#FDA4AF;border:1px solid #F43F5E;">ISLAMIC SUFFRAGE: AL-SHŪRĀ, AL-BAY'AH &amp; AL-MUJĀDILAH (58:1)</span>
                      </div>
                      <h1>Alchemical Wares, Douching &amp; Hygiene, Homogeneity &amp; Insular Self-Governance, The Man of the Caravan Through Antiquity, Caliphate Organization &amp; Islamic Suffrage</h1>
                      <p class="hero-lead">
                        An exhaustive canonical and historical synthesis examining: <strong>(I) Alchemical Wares (Ālāt Al-Kīmiyā'), Clinical &amp; Ritual Douching (Al-Istinjā', Al-Ḥuqnah, Al-Zarāqah), and Hygiene (Fiqh Al-Ṭahārah)</strong>;
                        <strong>(II) Homosexuality, Evidentiary Privacy (Satr), Liturgical/Urban Homogeneity, Fasting, Prayer, Community, and Insular Self-Governing Structures (Waqf, Maḥallah, Futūwwah/Akhī Guilds)</strong>;
                        <strong>(III) The Seven Archetypes of the Islamic Man—Common, Royal, Poor, Man of the Caravan, Lost at the Caravan (Ibn Al-Sabīl), At the End of the Caravan (Al-Sāqah), and Left Behind by the Caravan (Qur'an 9:118 &amp; Abū Dharr)</strong>; and
                        <strong>(IV) Caliphate Self-Organization &amp; Naming Islamic Suffrage (Al-Shūrā, Al-Bay'ah, Al-Mujādilah 58:1 &amp; Wilāyat Al-Maẓālim) Across Common, Royal, Young, Old, and Gender Causes Past &amp; Today</strong>.
                      </p>
                      <div class="arabic-banner">
                        ﴿ قَدْ سَمِعَ اللَّهُ قَوْلَ الَّتِي تُجَادِلُكَ فِي زَوْجِهَا وَتَشْتَكِي إِلَى اللَّهِ وَاللَّهُ يَسْمَعُ تَحَاوُرَكُمَا ﴾ (المجادلة ٥٨:١) &nbsp;|&nbsp;
                        ﴿ وَأَمْرُهُمْ شُورَىٰ بَيْنَهُمْ ﴾ (الشورى ٤٢:٣٨) &nbsp;|&nbsp;
                        « الطُّهُورُ شَطْرُ الإِيمَانِ » (صحيح مسلم ٢٢٣)
                      </div>
                    </section>

                    <!-- SECTION I: ALCHEMICAL WARES, DOUCHING & HYGIENE -->
                    <section class="section-block" id="alchemical-hygiene">
                      <div class="section-header">
                        <h2>I. Alchemical Wares (Ālāt Al-Kīmiyā'), Douching / Bodily Irrigation (Al-Istinjā' &amp; Al-Ḥuqnah) &amp; Hygiene (Al-Ṭahārah)</h2>
                        <p>How Jābir ibn Ḥayyān, Al-Rāzī, and Al-Zahrāwī fused laboratory distillation, alkali saponification, and precision surgical irrigation with the Qur'anic theology of bodily purity (Qur'an 2:222 &amp; 9:108).</p>
                      </div>

                      <div class="svg-showcase">
                        <svg viewBox="0 0 1160 250" width="100%%" height="auto" xmlns="http://www.w3.org/2000/svg">
                          <rect width="1160" height="250" rx="12" fill="#0B1322" stroke="#D4AF37" stroke-opacity="0.35"/>
                          <text x="580" y="30" text-anchor="middle" fill="#FDE68A" font-size="15" font-weight="bold">CLASSICAL ISLAMIC ALCHEMICAL, HYGIENIC &amp; CLINICAL IRRIGATION APPARATUS MATRIX</text>
                          <!-- Node 1: Alembic -->
                          <rect x="25" y="52" width="205" height="175" rx="10" fill="#111C30" stroke="#10B981" stroke-width="1.5"/>
                          <circle cx="127" cy="95" r="24" fill="none" stroke="#10B981" stroke-width="2"/>
                          <path d="M 127 71 Q 165 65 185 110" fill="none" stroke="#34D399" stroke-width="2.5"/>
                          <text x="127" y="140" text-anchor="middle" fill="#FFF" font-size="12.5" font-weight="bold">1. Al-Anbīq &amp; Al-Qar'</text>
                          <text x="127" y="160" text-anchor="middle" fill="#94A3B8" font-size="11">Jābir &amp; Al-Rāzī Alembic Still</text>
                          <text x="127" y="178" text-anchor="middle" fill="#34D399" font-size="10.5">Mā' Al-Ward (Rosewater)</text>
                          <text x="127" y="196" text-anchor="middle" fill="#34D399" font-size="10.5">&amp; Clinical Al-Kuḥūl Antiseptic</text>
                          <!-- Node 2: Sabun -->
                          <rect x="250" y="52" width="205" height="175" rx="10" fill="#111C30" stroke="#38BDF8" stroke-width="1.5"/>
                          <rect x="322" y="75" width="60" height="36" rx="6" fill="#38BDF8" fill-opacity="0.2" stroke="#38BDF8" stroke-width="2"/>
                          <text x="352" y="140" text-anchor="middle" fill="#FFF" font-size="12.5" font-weight="bold">2. Al-Ṣābūn &amp; Al-Qalī</text>
                          <text x="352" y="160" text-anchor="middle" fill="#94A3B8" font-size="11">Aleppo/Nablus Alkali Soap</text>
                          <text x="352" y="178" text-anchor="middle" fill="#7DD3FC" font-size="10.5">Olive + Laurel Oil + Soda Ash</text>
                          <text x="352" y="196" text-anchor="middle" fill="#7DD3FC" font-size="10.5">Nūrah Depilatory &amp; Ushnān</text>
                          <!-- Node 3: Ibriq & Istinja -->
                          <rect x="475" y="52" width="210" height="175" rx="10" fill="#111C30" stroke="#D4AF37" stroke-width="1.5"/>
                          <ellipse cx="580" cy="96" rx="22" ry="18" fill="none" stroke="#D4AF37" stroke-width="2"/>
                          <path d="M 602 92 Q 625 75 632 68" fill="none" stroke="#FDE68A" stroke-width="2.5"/>
                          <text x="580" y="140" text-anchor="middle" fill="#FFF" font-size="12.5" font-weight="bold">3. Al-Ibrīq &amp; Al-Istinjā'</text>
                          <text x="580" y="160" text-anchor="middle" fill="#94A3B8" font-size="11">Spouted Brass Ewer / Shattaf</text>
                          <text x="580" y="178" text-anchor="middle" fill="#FDE68A" font-size="10.5">Mandatory Water Cleansing</text>
                          <text x="580" y="196" text-anchor="middle" fill="#FDE68A" font-size="10.5">Qur'an 9:108 &amp; Sunan Al-Fiṭrah</text>
                          <!-- Node 4: Mihqan & Huqnah -->
                          <rect x="705" y="52" width="205" height="175" rx="10" fill="#111C30" stroke="#F43F5E" stroke-width="1.5"/>
                          <line x1="775" y1="92" x2="840" y2="92" stroke="#F43F5E" stroke-width="4"/>
                          <circle cx="770" cy="92" r="10" fill="none" stroke="#FDA4AF" stroke-width="2"/>
                          <text x="807" y="140" text-anchor="middle" fill="#FFF" font-size="12.5" font-weight="bold">4. Al-Miḥqan &amp; Al-Ḥuqnah</text>
                          <text x="807" y="160" text-anchor="middle" fill="#94A3B8" font-size="11">Al-Zahrāwī Silver Cannulas</text>
                          <text x="807" y="178" text-anchor="middle" fill="#FDA4AF" font-size="10.5">Clinical Douching &amp; Clysters</text>
                          <text x="807" y="196" text-anchor="middle" fill="#FDA4AF" font-size="10.5">4-Madhhab vs. Ibn Ḥazm Fast Law</text>
                          <!-- Node 5: Hammam & Ghusl -->
                          <rect x="930" y="52" width="205" height="175" rx="10" fill="#111C30" stroke="#A855F7" stroke-width="1.5"/>
                          <path d="M 1000 108 A 32 32 0 0 1 1064 108 Z" fill="none" stroke="#C084FC" stroke-width="2"/>
                          <text x="1032" y="140" text-anchor="middle" fill="#FFF" font-size="12.5" font-weight="bold">5. Al-Ḥammām &amp; Al-Ghusl</text>
                          <text x="1032" y="160" text-anchor="middle" fill="#94A3B8" font-size="11">3-Zone Running-Water Bath</text>
                          <text x="1032" y="178" text-anchor="middle" fill="#E9D5FF" font-size="10.5">Barrānī • Wusṭānī • Juwwānī</text>
                          <text x="1032" y="196" text-anchor="middle" fill="#E9D5FF" font-size="10.5">Qur'an 5:6 &amp; 2:222 Ablution</text>
                        </svg>
                      </div>

                      <div class="cards-grid">
                        %s
                      </div>
                    </section>

                    <!-- SECTION II: HOMOSEXUALITY, HOMOGENEITY, FASTING, PRAYER, COMMUNITY & INSULAR SELF-GOVERNANCE -->
                    <section class="section-block" id="homogeneity-insular">
                      <div class="section-header">
                        <h2>II. Homosexuality (Fiqh vs. Adab &amp; Satr), Liturgical/Urban Homogeneity, Fasting, Prayer &amp; Insular Self-Governing Structures</h2>
                        <p>Examining classical evidentiary privacy (Satr &amp; Lā Tajassasū), the homogeneous geometry of the Ṣaff prayer row and Ramadan fast, and the bottom-up insular organs (Waqf, Maḥallah, Futūwwah/Akhī Guilds, Madhhab Courts) by which Muslim communities govern themselves.</p>
                      </div>
                      <div class="cards-grid">
                        %s
                      </div>
                    </section>

                    <!-- SECTION III: THE 7 ARCHETYPES OF THE ISLAMIC MAN & THE CARAVAN THROUGH ANTIQUITY -->
                    <section class="section-block" id="caravan-archetypes">
                      <div class="section-header">
                        <h2>III. The Common Man, Royal Man, Poor Man &amp; The Four Stations of the Caravan Through Antiquity</h2>
                        <p>From the artisan of the Sūq, the Caliph trembling over his flock, and the destitute Companion of Ahl Al-Ṣuffah to the Man of the Caravan, Lost at the Caravan (Ibn Al-Sabīl), At the End of the Caravan (Al-Sāqah), and Left Behind by the Caravan (Abū Dharr &amp; Qur'an 9:118).</p>
                      </div>

                      <div class="svg-showcase">
                        <svg viewBox="0 0 1160 220" width="100%%" height="auto" xmlns="http://www.w3.org/2000/svg">
                          <rect width="1160" height="220" rx="12" fill="#0B1322" stroke="#F59E0B" stroke-opacity="0.4"/>
                          <text x="580" y="28" text-anchor="middle" fill="#FDE68A" font-size="14.5" font-weight="bold">SPATIAL &amp; MORAL TOPOLOGY OF THE ISLAMIC CARAVAN THROUGH ANTIQUITY (AL-QĀFILAH WA AL-RAKB)</text>
                          <path d="M 90 125 Q 350 90 600 125 T 1070 115" fill="none" stroke="#D4AF37" stroke-width="3" stroke-dasharray="7 5"/>
                          <!-- Station 1: Left Behind -->
                          <circle cx="115" cy="122" r="18" fill="#14B8A6" fill-opacity="0.25" stroke="#14B8A6" stroke-width="2.5"/>
                          <text x="115" y="126" text-anchor="middle" fill="#FFF" font-size="11" font-weight="bold">#7</text>
                          <text x="115" y="160" text-anchor="middle" fill="#5EEAD4" font-size="11.5" font-weight="bold">Left by the Caravan</text>
                          <text x="115" y="177" text-anchor="middle" fill="#94A3B8" font-size="10">Al-Mukhallaf (Qur'an 9:118)</text>
                          <text x="115" y="192" text-anchor="middle" fill="#94A3B8" font-size="10">&amp; Abū Dharr at Tabuk</text>
                          <!-- Station 2: End of Caravan -->
                          <circle cx="365" cy="108" r="18" fill="#F43F5E" fill-opacity="0.25" stroke="#F43F5E" stroke-width="2.5"/>
                          <text x="365" y="112" text-anchor="middle" fill="#FFF" font-size="11" font-weight="bold">#6</text>
                          <text x="365" y="148" text-anchor="middle" fill="#FDA4AF" font-size="11.5" font-weight="bold">End of the Caravan</text>
                          <text x="365" y="165" text-anchor="middle" fill="#94A3B8" font-size="10">Al-Sāqah (Prophet ﷺ at Rear</text>
                          <text x="365" y="180" text-anchor="middle" fill="#94A3B8" font-size="10">Carrying the Weak &amp; Jābir)</text>
                          <!-- Station 3: Lost at Caravan -->
                          <circle cx="615" cy="58" r="18" fill="#A855F7" fill-opacity="0.25" stroke="#A855F7" stroke-width="2.5"/>
                          <line x1="615" y1="76" x2="615" y2="122" stroke="#A855F7" stroke-width="1.5" stroke-dasharray="3 3"/>
                          <text x="615" y="62" text-anchor="middle" fill="#FFF" font-size="11" font-weight="bold">#5</text>
                          <text x="725" y="55" text-anchor="start" fill="#D8B4FE" font-size="11.5" font-weight="bold">Lost at the Caravan (Ibn Al-Sabīl)</text>
                          <text x="725" y="71" text-anchor="start" fill="#94A3B8" font-size="10">Qur'an 9:60 Zakāh Share &amp; Darb Zubaydah Fire-Towers</text>
                          <!-- Station 4: Man of Caravan -->
                          <circle cx="885" cy="132" r="18" fill="#F59E0B" fill-opacity="0.25" stroke="#F59E0B" stroke-width="2.5"/>
                          <text x="885" y="136" text-anchor="middle" fill="#FFF" font-size="11" font-weight="bold">#4</text>
                          <text x="885" y="170" text-anchor="middle" fill="#FDE68A" font-size="11.5" font-weight="bold">Man of the Caravan</text>
                          <text x="885" y="187" text-anchor="middle" fill="#94A3B8" font-size="10">Amīr Al-Rakb, Dalīl &amp; Khān</text>
                          <!-- Destination: Mecca/Sanctuary -->
                          <rect x="1040" y="96" width="36" height="36" rx="4" fill="#111" stroke="#D4AF37" stroke-width="2.5"/>
                          <text x="1058" y="152" text-anchor="middle" fill="#FDE68A" font-size="11" font-weight="bold">Al-Ka'bah / Khān</text>
                        </svg>
                      </div>

                      <div class="cards-grid">
                        %s
                      </div>
                    </section>

                    <!-- SECTION IV: CALIPHATE ORGANIZATION & ISLAMIC SUFFRAGE -->
                    <section class="section-block" id="caliphate-suffrage">
                      <div class="section-header">
                        <h2>IV. Caliphate Self-Organization (Al-Aḥkām Al-Sulṭāniyyah) &amp; Islamic Suffrage: Naming It &amp; Effecting Change</h2>
                        <p>How Islam organizes and governs itself in the Caliphate stage, and the canonical Qur'anic &amp; Prophetic names for Suffrage (Al-Shūrā, Al-Bay'ah, Al-Mujādilah 58:1 &amp; Wilāyat Al-Maẓālim) across Common, Royal, Young, Old, and Gender Causes.</p>
                      </div>

                      <h3 style="color:#34D399;margin-bottom:0.85rem;font-size:1.25rem;">A. The 6 Constitutional Organs of Caliphate Self-Governance</h3>
                      <div class="table-wrap" style="margin-bottom:2.2rem;">
                        <table>
                          <thead>
                            <tr>
                              <th>#</th>
                              <th>Constitutional Organ &amp; Arabic Name</th>
                              <th>Primary Juristic &amp; Historical Sources</th>
                              <th>Organizational Jurisdiction</th>
                              <th>Constitutional Checks &amp; Accountability</th>
                            </tr>
                          </thead>
                          <tbody>
                            %s
                          </tbody>
                        </table>
                      </div>

                      <h3 style="color:#FDE68A;margin-bottom:0.85rem;font-size:1.25rem;">B. Naming Islamic Suffrage &amp; The 5 Vectors of Causes (Common, Royal, Young, Old &amp; Gender)</h3>
                      <div class="cards-grid" style="margin-bottom:2.4rem;">
                        %s
                      </div>

                      <h3 style="color:#F472B6;margin-bottom:0.85rem;font-size:1.25rem;">C. Gender &amp; Suffrage (Past &amp; Today): Taking What You Go Through &amp; Effecting Constitutional Change</h3>
                      <div class="table-wrap">
                        <table>
                          <thead>
                            <tr>
                              <th>#</th>
                              <th>Historical Era</th>
                              <th>Protagonist / Movement</th>
                              <th>Scriptural / Legal Anchor</th>
                              <th>What They Went Through (Lived Ordeal / Question)</th>
                              <th>Permanent Legal, Scriptural &amp; Institutional Change Effected</th>
                            </tr>
                          </thead>
                          <tbody>
                            %s
                          </tbody>
                        </table>
                      </div>
                    </section>
                  </div>
                </body>
                </html>
                """.formatted(
                waresCards.toString(),
                homogeneityCards.toString(),
                caravanCards.toString(),
                organRows.toString(),
                suffrageCards.toString(),
                genderRows.toString()
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

    private static String sha256(String content) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return HexFormat.of().formatHex(md.digest(content.getBytes(StandardCharsets.UTF_8)));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 unavailable", e);
        }
    }
}
