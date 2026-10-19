package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.PactOutcome;
import com.sovereign.warlock.domain.SpcControlMatrix;
import com.sovereign.warlock.domain.WarlockColorOrder;
import com.sovereign.warlock.domain.WarlockIslamChronicle;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HexFormat;
import java.util.List;

/**
 * Spring Boot Static HTML Portal & Dependency Report Generator.
 * Generates:
 *  1) 7 separate HTML files (one for each Warlock Order 1..7 ordered by Color),
 *     containing its Spring Boot @Profile telemetry and its complete story told to Islam
 *     explaining why the Warlock Pact is wholly removed from the Foundation.
 *  2) 1 separate HTML report (dependencies-report.html) auditing all Maven/Spring Boot
 *     and Java 21+/26 Standard Library dependencies and their exact usage across all 7 Orders.
 */
public final class WarlockHtmlPortalService {

    public record GeneratedHtmlArtifact(
            String fileName,
            Path filePath,
            long byteSize,
            String sha256Hash,
            String description
    ) {
    }

    public record DependencyDescriptor(
            String category,
            String coordinateOrModule,
            String versionOrRuntime,
            String scope,
            String classesAndAnnotationsUsed,
            String usageAcrossSevenOrders
    ) {
    }

    private static final List<DependencyDescriptor> SPRING_BOOT_DEPENDENCIES = List.of(
            new DependencyDescriptor(
                    "Spring Boot Core",
                    "org.springframework.boot:spring-boot-starter",
                    "3.4.3",
                    "compile",
                    "@SpringBootApplication, @Configuration, @Bean, @Profile, @ConfigurationProperties",
                    "Binds each of the 7 YAML profiles (application-warlock-1-white.yml .. 7-emerald.yml) to immutable Java records and activates @Profile-scoped WarlockOrder beans."
            ),
            new DependencyDescriptor(
                    "Spring Boot Web MVC",
                    "org.springframework.boot:spring-boot-starter-web",
                    "3.4.3",
                    "compile",
                    "Static Resource Handler (classpath:/static/), Embedded HTTP Portal Serving",
                    "Serves the 7 separate Order HTML portals (order-1-white.html .. order-7-emerald.html) and dependencies-report.html over HTTP."
            ),
            new DependencyDescriptor(
                    "Spring Boot Thymeleaf",
                    "org.springframework.boot:spring-boot-starter-thymeleaf",
                    "3.4.3",
                    "compile",
                    "HTML5 Template Rendering & Chromatic Data Binding",
                    "Binds 24-bit RGB hex codes, Active-Low masks, SPC C_p telemetry, and the 7 Islam Foundation Severance Chronicles into validated HTML5 views."
            ),
            new DependencyDescriptor(
                    "Spring Boot Validation",
                    "org.springframework.boot:spring-boot-starter-validation",
                    "3.4.3",
                    "compile",
                    "Compact Record Constructor Invariant Checks (orderIndex 1..7, RGB 0..255)",
                    "Enforces boundary integrity across all 7 WarlockProfileProperties records at startup before any @Bean is registered."
            ),
            new DependencyDescriptor(
                    "Spring Boot Actuator",
                    "org.springframework.boot:spring-boot-starter-actuator",
                    "3.4.3",
                    "compile",
                    "SpcControlMatrix Health & Process Capability (C_p >= 1.33) Telemetry",
                    "Monitors GEMINI.md State S0 equilibrium and verifies Transformation Tensor conservation (sum_j T_ij == 0) across all 7 active profiles."
            ),
            new DependencyDescriptor(
                    "Spring Config Processor",
                    "org.springframework.boot:spring-boot-configuration-processor",
                    "3.4.3",
                    "optional / annotationProcessor",
                    "Compile-time metadata generation for warlock.* YAML prefix",
                    "Generates IDE & compiler schema validation for the 19 properties inside each of the 7 application-warlock-*.yml files."
            ),
            new DependencyDescriptor(
                    "Spring Boot Test",
                    "org.springframework.boot:spring-boot-starter-test",
                    "3.4.3",
                    "test",
                    "@ActiveProfiles Verification, Exhaustive Switch & Virtual Thread Assertions",
                    "Verifies deterministic Color Order (1..7) sorting, SHA-256 seal reproducibility, and Foundation Severance chronicle completeness."
            )
    );

    private static final List<DependencyDescriptor> JAVA_ESSENTIALS_DEPENDENCIES = List.of(
            new DependencyDescriptor(
                    "Java Language Core",
                    "java.base / Sealed Classes & Records (JEP 409 / JEP 395)",
                    "Java 21+ / 26.0.1",
                    "JDK Standard",
                    "WarlockOrder (sealed interface + 7 records), PactOutcome<T>, WarlockProfileProperties, WarlockIslamChronicle",
                    "Models the 7 Color Warlock Orders as an closed algebraic sum type with immutable data carriers and zero mutable state."
            ),
            new DependencyDescriptor(
                    "Java Pattern Matching",
                    "java.base / Record Patterns & Switch Expressions (JEP 440 / JEP 441)",
                    "Java 21+ / 26.0.1",
                    "JDK Standard",
                    "WarlockCovenantEngine.synthesizeTheurgicFormula(WarlockOrder)",
                    "Performs compiler-verified exhaustive deconstruction across all 7 WarlockOrder record subtypes without a default branch."
            ),
            new DependencyDescriptor(
                    "Java Virtual Threads",
                    "java.base / java.util.concurrent (JEP 444)",
                    "Java 21+ / 26.0.1",
                    "JDK Standard",
                    "Executors.newVirtualThreadPerTaskExecutor(), Callable, Future",
                    "Executes all 7 Warlock profile invocations concurrently on lightweight virtual threads while returning outcomes in strict Color Order 1..7."
            ),
            new DependencyDescriptor(
                    "Java Functional & Streams",
                    "java.base / java.util.stream & java.util.Comparator",
                    "Java 21+ / 26.0.1",
                    "JDK Standard",
                    "Stream, Collectors.groupingBy, Comparator.comparingInt, Optional, Function",
                    "Orders the 7 Warlocks by Color Index (BY_COLOR_ORDER_7), Wavelength (BY_WAVELENGTH_NM), and Luminance (BY_LUMINANCE_DESC), and groups by MysticalPillar."
            ),
            new DependencyDescriptor(
                    "Java NIO File System",
                    "java.base / java.nio.file & java.nio.charset",
                    "Java 21+ / 26.0.1",
                    "JDK Standard",
                    "Path, Files.readAllLines, Files.writeString, StandardCharsets.UTF_8",
                    "Loads the 7 Spring Boot YAML profile configurations and writes the 7 separate Order HTML files + Dependency Report HTML to src/main/resources/static/."
            ),
            new DependencyDescriptor(
                    "Java Cryptography",
                    "java.base / java.security & java.util.HexFormat",
                    "Java 21+ / 26.0.1",
                    "JDK Standard",
                    "MessageDigest.getInstance(\"SHA-256\"), HexFormat.of().formatHex()",
                    "Computes cryptographic SHA-256 seals for every Warlock invocation and every generated HTML file."
            ),
            new DependencyDescriptor(
                    "Java Reflection & Metadata",
                    "java.base / java.lang.annotation & java.lang.reflect",
                    "Java 21+ / 26.0.1",
                    "JDK Standard",
                    "@Profile, @Bean, @Configuration, Method.isAnnotationPresent, Method.invoke",
                    "Introspects SevenWarlockProfileConfig at runtime to activate only the @Bean methods matching --spring.profiles.active."
            )
    );

    public List<GeneratedHtmlArtifact> generateAllPortalsAndDependencyReport(
            Path outputDir,
            List<PactOutcome<WarlockCovenantEngine.InvocationTelemetry>> outcomes) {
        try {
            Files.createDirectories(outputDir);
            List<GeneratedHtmlArtifact> artifacts = new ArrayList<>();
            List<WarlockCovenantEngine.InvocationTelemetry> telemetries = new ArrayList<>();

            for (PactOutcome<WarlockCovenantEngine.InvocationTelemetry> outcome : outcomes) {
                if (outcome instanceof PactOutcome.CovenantSealed<WarlockCovenantEngine.InvocationTelemetry> sealed) {
                    var telemetry = sealed.payload();
                    telemetries.add(telemetry);
                    WarlockIslamChronicle chronicle = WarlockIslamChronicle.forOrderIndex(telemetry.orderIndex());
                    String htmlContent = renderOrderHtml(telemetry, sealed.sha256Seal(), chronicle);
                    Path targetFile = outputDir.resolve(chronicle.htmlFileName());
                    Files.writeString(targetFile, htmlContent, StandardCharsets.UTF_8);
                    artifacts.add(new GeneratedHtmlArtifact(
                            chronicle.htmlFileName(),
                            targetFile,
                            Files.size(targetFile),
                            sha256(htmlContent),
                            "Order #" + telemetry.orderIndex() + " (" + telemetry.profileId() + ") -- " + telemetry.warlockName()
                    ));
                }
            }

            String depHtml = renderDependencyReportHtml(artifacts, outcomes);
            Path depFile = outputDir.resolve("dependencies-report.html");
            Files.writeString(depFile, depHtml, StandardCharsets.UTF_8);
            artifacts.add(new GeneratedHtmlArtifact(
                    "dependencies-report.html",
                    depFile,
                    Files.size(depFile),
                    sha256(depHtml),
                    "Master Spring Boot & Java 21+/26 Essentials Dependency Usage Report"
            ));

            Warlock3dSanctumGenerator sanctum3dGenerator = new Warlock3dSanctumGenerator();
            artifacts.addAll(sanctum3dGenerator.generateAllRealmPortals(outputDir, telemetries));

            WarlockPlaneAndPrioryGenerator planeAndPrioryGenerator = new WarlockPlaneAndPrioryGenerator();
            artifacts.addAll(planeAndPrioryGenerator.generatePlanesAndPriory(outputDir, telemetries));

            WrongdoerPortalGenerator wrongdoerPortalGenerator = new WrongdoerPortalGenerator();
            artifacts.addAll(wrongdoerPortalGenerator.generateZalimPortals(
                    outputDir,
                    com.sovereign.warlock.domain.WrongdoerArchetypeOrder.allCanonicalZalimProfiles()
            ));

            IslamicWorldsGenerator islamicWorldsGenerator = new IslamicWorldsGenerator();
            artifacts.addAll(islamicWorldsGenerator.generateAllWorlds(outputDir));

            WarlockSequesterPortalGenerator sequesterPortalGenerator = new WarlockSequesterPortalGenerator();
            artifacts.addAll(sequesterPortalGenerator.generateFormationDissolutionAndSequesters(outputDir));

            IslamicInterlockerPortalGenerator interlockerPortalGenerator = new IslamicInterlockerPortalGenerator();
            artifacts.add(interlockerPortalGenerator.generateInterlockerPortal(outputDir));

            WarlockApocryphaPortalGenerator apocryphaPortalGenerator = new WarlockApocryphaPortalGenerator();
            artifacts.add(apocryphaPortalGenerator.generateApocryphaPortal(outputDir));

            IslamicHusbandryPortalGenerator husbandryPortalGenerator = new IslamicHusbandryPortalGenerator();
            artifacts.add(husbandryPortalGenerator.generateHusbandryPortal(outputDir));

            IslamicRoseGardenPortalGenerator roseGardenPortalGenerator = new IslamicRoseGardenPortalGenerator();
            artifacts.add(roseGardenPortalGenerator.generateRoseGardenPortal(outputDir));

            IslamicDisneyMicrocosmPortalGenerator disneyMicrocosmPortalGenerator = new IslamicDisneyMicrocosmPortalGenerator();
            artifacts.add(disneyMicrocosmPortalGenerator.generateDisneyMicrocosmPortal(outputDir));

            WarlockIslamicVisualErasPortalGenerator visualErasPortalGenerator = new WarlockIslamicVisualErasPortalGenerator();
            artifacts.add(visualErasPortalGenerator.generateVisualErasPortal(outputDir));

            ConjoinedNodeGridPortalGenerator conjoinedNodeGridGenerator = new ConjoinedNodeGridPortalGenerator();
            artifacts.add(conjoinedNodeGridGenerator.generateConjoinedNodeGridPortal(outputDir));

            IslamicCaravansAndConquestPortalGenerator caravansAndConquestGenerator = new IslamicCaravansAndConquestPortalGenerator();
            artifacts.add(caravansAndConquestGenerator.generateCaravansAndConquestPortal(outputDir));

            GrecoRomanIslamicJudgmentPortalGenerator grecoRomanJudgmentGenerator = new GrecoRomanIslamicJudgmentPortalGenerator();
            artifacts.add(grecoRomanJudgmentGenerator.generateGrecoRomanIslamicJudgmentPortal(outputDir));

            Path philosophyAlchemyPath = IslamicPhilosophyAlchemyPortalGenerator.generatePortal(outputDir);
            String philosophyAlchemyHtml = Files.readString(philosophyAlchemyPath, StandardCharsets.UTF_8);
            artifacts.add(new GeneratedHtmlArtifact(
                    IslamicPhilosophyAlchemyPortalGenerator.PORTAL_FILENAME,
                    philosophyAlchemyPath,
                    Files.size(philosophyAlchemyPath),
                    sha256(philosophyAlchemyHtml),
                    "Philosophy & Alchemy in Islam, Canonical Adjustments to 7 Theocracies & Theocrats, 5 Socratic Critiques & 7 Stages of Message Meaning Shift"
            ));

            Path modestyFrontierPath = IslamicModestyWesternFrontierPortalGenerator.generatePortal(outputDir);
            String modestyFrontierHtml = Files.readString(modestyFrontierPath, StandardCharsets.UTF_8);
            artifacts.add(new GeneratedHtmlArtifact(
                    IslamicModestyWesternFrontierPortalGenerator.PORTAL_FILENAME,
                    modestyFrontierPath,
                    Files.size(modestyFrontierPath),
                    sha256(modestyFrontierHtml),
                    "Islamic Modesty Standard (Al-Haya' & Libas At-Taqwa) for Men & Women Across the 7 Epochs of the Western Frontier & Expansions"
            ));

            Path namingIndonesiaPath = IslamicNamingIndonesiaCalligraphyPortalGenerator.generatePortal(outputDir);
            String namingIndonesiaHtml = Files.readString(namingIndonesiaPath, StandardCharsets.UTF_8);
            artifacts.add(new GeneratedHtmlArtifact(
                    IslamicNamingIndonesiaCalligraphyPortalGenerator.PORTAL_FILENAME,
                    namingIndonesiaPath,
                    Files.size(namingIndonesiaPath),
                    sha256(namingIndonesiaHtml),
                    "Canonical Naming in Islam by Region (Abjad 261 Wafq of Zakeem Malik McCaleb), Development of Indonesia (87.2% Muslim), Sanitation/Sewer Project Structure, Language & Calligraphy"
            ));

            Path islamicCountriesPath = IslamicCountriesCanonicalEmbracePortalGenerator.generatePortal(outputDir);
            String islamicCountriesHtml = Files.readString(islamicCountriesPath, StandardCharsets.UTF_8);
            artifacts.add(new GeneratedHtmlArtifact(
                    IslamicCountriesCanonicalEmbracePortalGenerator.PORTAL_FILENAME,
                    islamicCountriesPath,
                    Files.size(islamicCountriesPath),
                    sha256(islamicCountriesHtml),
                    "The History of Islamic Countries (57 OIC Nations Across 7 Civilizational Zones), 5 Pathways of Embrace & 6 Institutional Pillars"
            ));

            Path caliphatesSultansReturnPath = IslamicCaliphatesSultansReturnPortalGenerator.generatePortal(outputDir);
            String caliphatesSultansReturnHtml = Files.readString(caliphatesSultansReturnPath, StandardCharsets.UTF_8);
            artifacts.add(new GeneratedHtmlArtifact(
                    IslamicCaliphatesSultansReturnPortalGenerator.PORTAL_FILENAME,
                    caliphatesSultansReturnPath,
                    Files.size(caliphatesSultansReturnPath),
                    sha256(caliphatesSultansReturnHtml),
                    "The Caliphates, the Sultans, the Shahs & the Dynasties Instantiated & Dissolved by Islam: Origin, Journey & The Promise of Returning"
            ));

            List<Path> multiVolPaths = QuranicTimelinePropertiesBeautyMultiPortalGenerator.generateAllThreeVolumes(outputDir);
            String[] multiVolDescriptions = {
                    "Collegiate Multi-HTML Vol. I (#58): Canonical Qur'anic Timeline of Islamic Expansion Across 10 Epochs (Alast & Ibrahim to 2B+ Ummah)",
                    "Collegiate Multi-HTML Vol. II (#59): Canonical Islamic Properties (Waqf, Kharaj, 'Ushr, Fay', Hima, Mawat), Countries & Kingdoms Across 7 Climes",
                    "Collegiate Multi-HTML Vol. III (#60): The 7 Dimensions of the Beauty of Islam (Jamal Al-Islam) & 8-Chapter Collegiate Universal Thesis Monograph"
            };
            for (int idx = 0; idx < multiVolPaths.size(); idx++) {
                Path p = multiVolPaths.get(idx);
                String content = Files.readString(p, StandardCharsets.UTF_8);
                artifacts.add(new GeneratedHtmlArtifact(
                        p.getFileName().toString(),
                        p,
                        Files.size(p),
                        sha256(content),
                        multiVolDescriptions[idx]
                ));
            }

            List<Path> agesPhilSciPaths = IslamThroughAgesPhilosophyScienceMultiPortalGenerator.generateAllThreeVolumes(outputDir);
            String[] agesPhilSciDescriptions = {
                    "Expansive Multi-HTML Vol. I (#61): Islam Through the Ages & Its Global Civilizational Reception Across 7 Historical Ages (610 CE – 21st Century)",
                    "Expansive Multi-HTML Vol. II (#62): The 7 Philosophical Connotations & Paradigms of Islam (Modal Ontology, Floating Man, Sunnat Allah, Reason/Revelation, Empiricism, Substantial Motion, 'Umran)",
                    "Expansive Multi-HTML Vol. III (#63): Qur'anic & Prophetic Scientific Allusions (Ayat Kawniyyah) Instantiated Through Classical & Modern Empirical Science"
            };
            for (int idx = 0; idx < agesPhilSciPaths.size(); idx++) {
                Path p = agesPhilSciPaths.get(idx);
                String content = Files.readString(p, StandardCharsets.UTF_8);
                artifacts.add(new GeneratedHtmlArtifact(
                        p.getFileName().toString(),
                        p,
                        Files.size(p),
                        sha256(content),
                        agesPhilSciDescriptions[idx]
                ));
            }

            IslamicMaritimeOmanYemenPortalGenerator maritimeGenerator = new IslamicMaritimeOmanYemenPortalGenerator();
            artifacts.add(maritimeGenerator.generateMaritimeOmanYemenPortal(outputDir));

            IslamicCompassCaliphateMapsAndFlagsPortalGenerator compassMapsFlagsGenerator =
                    new IslamicCompassCaliphateMapsAndFlagsPortalGenerator();
            artifacts.add(compassMapsFlagsGenerator.generatePortal(outputDir));

            IslamicAlchemicalHygieneCaravanAndSuffragePortalGenerator alchemicalCaravanSuffrageGenerator =
                    new IslamicAlchemicalHygieneCaravanAndSuffragePortalGenerator();
            artifacts.add(alchemicalCaravanSuffrageGenerator.generatePortal(outputDir));

            IslamicConquestMovementsPinnaclesAndRecessionsPortalGenerator conquestMovementsGenerator =
                    new IslamicConquestMovementsPinnaclesAndRecessionsPortalGenerator();
            artifacts.add(conquestMovementsGenerator.generatePortal(outputDir));

            MasterNavigationAndIndexGenerator masterNavGenerator = new MasterNavigationAndIndexGenerator();
            return masterNavGenerator.integrateAllPortalsAndGenerateMasterIndex(outputDir, artifacts);
        } catch (IOException e) {
            throw new IllegalStateException("Failed generating HTML portals in " + outputDir, e);
        }
    }

    private String renderOrderHtml(
            WarlockCovenantEngine.InvocationTelemetry t,
            String sha256Seal,
            WarlockIslamChronicle c) {
        String activeLowHex = String.format("#%06X", t.activeLow24());
        int r = (t.rgb24() >> 16) & 0xFF;
        int g = (t.rgb24() >> 8) & 0xFF;
        int b = t.rgb24() & 0xFF;
        String accentColor = (t.orderIndex() == 2) ? "#A78BFA" : (t.orderIndex() == 1 ? "#D4AF37" : t.hexCode());

        StringBuilder navLinks = new StringBuilder();
        for (WarlockColorOrder co : WarlockColorOrder.orderedBySevenColors()) {
            WarlockIslamChronicle ch = WarlockIslamChronicle.forOrderIndex(co.orderIndex());
            String activeClass = (co.orderIndex() == t.orderIndex()) ? "nav-pill active" : "nav-pill";
            navLinks.append(String.format(
                    "<a class=\"%s\" href=\"%s\"><span class=\"swatch\" style=\"background:%s\"></span>#%d %s</a>%n",
                    activeClass, ch.htmlFileName(), co.hexCode(), co.orderIndex(), co.profileId()
            ));
        }
        String suffix = t.profileId().substring("warlock-".length());
        String realmFile = "realm-" + suffix + ".html";
        String planeFile = "plane-" + suffix + ".html";
        navLinks.append(String.format(
                "<a class=\"nav-pill\" href=\"%s\" style=\"border-color:#34D399;color:#34D399;\">Order #%d Realm</a>",
                realmFile, t.orderIndex()
        ));
        navLinks.append(String.format(
                "<a class=\"nav-pill\" href=\"%s\" style=\"border-color:#A5F3FC;color:#A5F3FC;\">Plane P%d</a>",
                planeFile, t.orderIndex()
        ));
        navLinks.append("<a class=\"nav-pill\" href=\"priory-negentropy-order.html\" style=\"border-color:#FDE68A;color:#FDE68A;\">Negentropic Priory</a>");
        navLinks.append("<a class=\"nav-pill\" href=\"zalim-1-fasad.html\" style=\"border-color:#EF4444;color:#FCA5A5;\">7 Wrongdoers (Zalim)</a>");
        navLinks.append("<a class=\"nav-pill\" href=\"worlds-hegemon-disorder.html\" style=\"border-color:#C084FC;color:#E9D5FF;\">7 Islamic Worlds</a>");
        navLinks.append("<a class=\"nav-pill\" href=\"warlock-formation-dissolution-jafar-aladdin.html\" style=\"border-color:#F43F5E;color:#FDA4AF;\">Ja'far &amp; Aladdin (Qumqum)</a>");
        navLinks.append("<a class=\"nav-pill\" href=\"sequester-between-worlds.html\" style=\"border-color:#38BDF8;color:#7DD3FC;\">Inter-World Sequester</a>");
        navLinks.append("<a class=\"nav-pill\" href=\"interlocker-egg-binder-islam.html\" style=\"border-color:#FBBF24;color:#FDE68A;\">Islamic Intelocketer (Egg Binder)</a>");
        navLinks.append("<a class=\"nav-pill\" href=\"warlock-apocrypha-islamic-theorems.html\" style=\"border-color:#C084FC;color:#E9D5FF;\">Warlock Apocrypha &amp; Theorems</a>");
        navLinks.append("<a class=\"nav-pill\" href=\"islamic-husbandry-sovereign-estate.html\" style=\"border-color:#34D399;color:#A7F3D0;\">Islamic Husbandry (Al-Qiwamah)</a>");
        navLinks.append("<a class=\"nav-pill\" href=\"way-of-the-flower-rose-garden-islam.html\" style=\"border-color:#F43F5E;color:#FDA4AF;\">Way of the Flower, Rose &amp; Garden</a>");
        navLinks.append("<a class=\"nav-pill\" href=\"disney-daffy-donald-islamic-microcosm.html\" style=\"border-color:#38BDF8;color:#A5F3FC;\">Disney/Daffy Animalism Microcosm</a>");
        navLinks.append("<a class=\"nav-pill\" href=\"warlock-3d-sanctum.html\" style=\"border-color:#D4AF37;color:#FDE68A;\">3D Sanctum</a>");
        navLinks.append("<a class=\"nav-pill dep-link\" href=\"dependencies-report.html\">Dependencies Report</a>");

        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <title>Order #%d: %s (%s) | Abrahamic Warlock &amp; The Testimony to Islam</title>
                  <style>
                    :root {
                      --order-color: %s;
                      --active-low: %s;
                      --accent: %s;
                      --bg-deep: #0B0D13;
                      --bg-card: #131722;
                      --bg-card-alt: #181E2C;
                      --text-main: #ECEFF4;
                      --text-muted: #9AA5B8;
                      --border-subtle: rgba(255,255,255,0.12);
                    }
                    * { box-sizing: border-box; margin: 0; padding: 0; }
                    body {
                      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
                      background: radial-gradient(circle at top right, rgba(%d,%d,%d,0.22), var(--bg-deep) 60%%);
                      color: var(--text-main);
                      line-height: 1.65;
                      padding-bottom: 4rem;
                    }
                    header {
                      border-bottom: 2px solid var(--order-color);
                      background: rgba(11, 13, 19, 0.92);
                      backdrop-filter: blur(8px);
                      padding: 1.25rem 2rem;
                      position: sticky;
                      top: 0;
                      z-index: 10;
                    }
                    .nav-bar {
                      display: flex;
                      flex-wrap: wrap;
                      gap: 0.5rem;
                      max-width: 1280px;
                      margin: 0 auto;
                      align-items: center;
                    }
                    .nav-pill {
                      display: inline-flex;
                      align-items: center;
                      gap: 0.4rem;
                      padding: 0.4rem 0.75rem;
                      border-radius: 999px;
                      background: var(--bg-card);
                      border: 1px solid var(--border-subtle);
                      color: var(--text-muted);
                      text-decoration: none;
                      font-size: 0.82rem;
                      font-weight: 600;
                      transition: all 0.15s ease;
                    }
                    .nav-pill:hover, .nav-pill.active {
                      color: #FFF;
                      border-color: var(--accent);
                      background: rgba(255,255,255,0.08);
                    }
                    .nav-pill.dep-link {
                      margin-left: auto;
                      border-color: #38BDF8;
                      color: #38BDF8;
                    }
                    .swatch {
                      width: 11px;
                      height: 11px;
                      border-radius: 50%%;
                      border: 1px solid rgba(255,255,255,0.45);
                      display: inline-block;
                    }
                    main {
                      max-width: 1280px;
                      margin: 2.2rem auto;
                      padding: 0 2rem;
                    }
                    .hero {
                      background: linear-gradient(135deg, var(--bg-card) 0%%, rgba(%d,%d,%d,0.18) 100%%);
                      border: 1px solid var(--border-subtle);
                      border-left: 6px solid var(--order-color);
                      border-radius: 14px;
                      padding: 2rem;
                      margin-bottom: 2rem;
                      box-shadow: 0 16px 40px rgba(0,0,0,0.45);
                    }
                    .badge-row {
                      display: flex;
                      flex-wrap: wrap;
                      gap: 0.6rem;
                      margin-bottom: 1rem;
                    }
                    .badge {
                      font-family: 'Consolas', monospace;
                      font-size: 0.78rem;
                      padding: 0.25rem 0.65rem;
                      border-radius: 6px;
                      background: rgba(255,255,255,0.07);
                      border: 1px solid var(--border-subtle);
                    }
                    h1 {
                      font-size: 2.1rem;
                      margin-bottom: 0.4rem;
                      letter-spacing: -0.02em;
                    }
                    .titles {
                      color: var(--text-muted);
                      font-size: 1.02rem;
                      margin-bottom: 1rem;
                    }
                    .grid-2 {
                      display: grid;
                      grid-template-columns: repeat(auto-fit, minmax(360px, 1fr));
                      gap: 1.5rem;
                      margin-bottom: 2rem;
                    }
                    .card {
                      background: var(--bg-card);
                      border: 1px solid var(--border-subtle);
                      border-radius: 12px;
                      padding: 1.5rem;
                    }
                    .card h2 {
                      font-size: 1.15rem;
                      text-transform: uppercase;
                      letter-spacing: 0.06em;
                      color: var(--accent);
                      margin-bottom: 1rem;
                      border-bottom: 1px solid var(--border-subtle);
                      padding-bottom: 0.5rem;
                    }
                    .kv-table {
                      width: 100%%;
                      border-collapse: collapse;
                    }
                    .kv-table tr {
                      border-bottom: 1px solid rgba(255,255,255,0.06);
                    }
                    .kv-table th {
                      text-align: left;
                      color: var(--text-muted);
                      font-weight: 500;
                      padding: 0.55rem 0.4rem;
                      width: 38%%;
                      font-size: 0.9rem;
                    }
                    .kv-table td {
                      padding: 0.55rem 0.4rem;
                      font-family: 'Consolas', monospace;
                      font-size: 0.88rem;
                    }
                    .color-preview-bar {
                      display: flex;
                      height: 44px;
                      border-radius: 8px;
                      overflow: hidden;
                      margin-top: 1rem;
                      border: 1px solid rgba(255,255,255,0.2);
                    }
                    .color-half {
                      flex: 1;
                      display: flex;
                      align-items: center;
                      justify-content: center;
                      font-family: 'Consolas', monospace;
                      font-size: 0.8rem;
                      font-weight: 700;
                    }
                    .chronicle-box {
                      background: var(--bg-card-alt);
                      border: 1px solid var(--border-subtle);
                      border-top: 4px solid var(--accent);
                      border-radius: 14px;
                      padding: 2.2rem;
                      margin-bottom: 2rem;
                    }
                    .chronicle-box h2 {
                      font-size: 1.55rem;
                      margin-bottom: 0.5rem;
                    }
                    .epigraph {
                      font-style: italic;
                      color: #FDE68A;
                      background: rgba(253, 230, 138, 0.07);
                      border-left: 3px solid #FDE68A;
                      padding: 0.85rem 1.2rem;
                      margin: 1rem 0 1.75rem 0;
                      border-radius: 0 8px 8px 0;
                    }
                    .story-section {
                      margin-bottom: 1.6rem;
                    }
                    .story-section h3 {
                      font-size: 1.08rem;
                      color: #38BDF8;
                      margin-bottom: 0.55rem;
                      text-transform: uppercase;
                      letter-spacing: 0.04em;
                    }
                    .story-section.removed h3 {
                      color: #F87171;
                    }
                    .story-section.foundation h3 {
                      color: #34D399;
                    }
                    .story-section p {
                      font-size: 1.02rem;
                      color: #E2E8F0;
                      text-align: justify;
                    }
                    .formula-banner {
                      background: #090B10;
                      border: 1px solid var(--border-subtle);
                      border-radius: 8px;
                      padding: 1rem 1.2rem;
                      font-family: 'Consolas', monospace;
                      font-size: 0.88rem;
                      color: #A5F3FC;
                      overflow-x: auto;
                    }
                  </style>
                </head>
                <body>
                  <header>
                    <nav class="nav-bar">
                      %s
                    </nav>
                  </header>
                  <main>
                    <section class="hero">
                      <div class="badge-row">
                        <span class="badge">COLOR ORDER #%d OF 7</span>
                        <span class="badge">@Profile("%s")</span>
                        <span class="badge">HEX: %s</span>
                        <span class="badge">ACTIVE-LOW: %s</span>
                        <span class="badge">SPC STATE: %s (Cp = %.2f)</span>
                      </div>
                      <h1>%s — %s</h1>
                      <div class="titles">
                        <strong>Hebrew Title:</strong> %s &nbsp;|&nbsp;
                        <strong>Arabic Title:</strong> %s &nbsp;|&nbsp;
                        <strong>Pre-Prophetic Stratum:</strong> <code>%s</code>
                      </div>
                      <div class="formula-banner">
                        %s
                      </div>
                    </section>

                    <section class="chronicle-box">
                      <h2>%s</h2>
                      <div class="epigraph">%s</div>

                      <div class="story-section">
                        <h3>I. The Order's Ancient Testimony to Islam (Hikayat al-Martabah ila al-Islam)</h3>
                        <p>%s</p>
                      </div>

                      <div class="story-section removed">
                        <h3>II. Why This Warlock Order Was Wholly Removed from the Foundation of Islam (Al-Izalah min Al-Asas)</h3>
                        <p>%s</p>
                      </div>

                      <div class="story-section">
                        <h3>III. The Scriptural Criterion of Severance (Ayat Al-Furqan)</h3>
                        <p><strong>%s</strong></p>
                      </div>

                      <div class="story-section foundation">
                        <h3>IV. What Stands in the Pure Foundation After Removal (Al-Asas Al-Khalis)</h3>
                        <p>%s</p>
                      </div>
                    </section>

                    <div class="grid-2">
                      <div class="card">
                        <h2>Spring Boot @Profile &amp; Chromatic Optics</h2>
                        <table class="kv-table">
                          <tr><th>Spring Profile ID</th><td>%s</td></tr>
                          <tr><th>Color Order Index</th><td>#%d of 7</td></tr>
                          <tr><th>Sacred Color Name</th><td>%s</td></tr>
                          <tr><th>Standard Hex / RGB</th><td>%s (R:%d, G:%d, B:%d)</td></tr>
                          <tr><th>Active-Low (~RGB)</th><td>%s (0x%06X)</td></tr>
                          <tr><th>Optical Wavelength</th><td>%d nm</td></tr>
                          <tr><th>ITU-R BT.709 Luminance</th><td>%.2f / 255.00</td></tr>
                        </table>
                        <div class="color-preview-bar">
                          <div class="color-half" style="background:%s; color:%s;">STANDARD: %s</div>
                          <div class="color-half" style="background:%s; color:%s;">ACTIVE-LOW: %s</div>
                        </div>
                      </div>

                      <div class="card">
                        <h2>Covenant Architecture &amp; GEMINI.md SPC Audit</h2>
                        <table class="kv-table">
                          <tr><th>Primary Esoteric Pillar</th><td>%s</td></tr>
                          <tr><th>Patron Hierarchy</th><td>%s</td></tr>
                          <tr><th>Sacred Implement</th><td>%s</td></tr>
                          <tr><th>Signature Invocation</th><td>%s</td></tr>
                          <tr><th>Sacred Recitation Mode</th><td>%s</td></tr>
                          <tr><th>SPC State / Capability</th><td>%s (C_p = %.2f, sigma = %.2f)</td></tr>
                          <tr><th>SHA-256 Covenant Seal</th><td>%s</td></tr>
                        </table>
                      </div>
                    </div>
                  </main>
                </body>
                </html>
                """.formatted(
                t.orderIndex(), escape(t.warlockName()), escape(t.profileId()),
                t.hexCode(), activeLowHex, accentColor,
                r, g, b,
                r, g, b,
                navLinks.toString(),
                t.orderIndex(), escape(t.profileId()), t.hexCode(), activeLowHex, t.spcState().code(), t.cp(),
                escape(t.warlockName()), escape(t.colorName()),
                escape(t.hebrewTitle()), escape(t.arabicTitle()), escape(t.prePropheticStratum()),
                escape(t.theurgicFormula()),
                escape(c.storyTitle()),
                escape(c.arabicEpigraph()),
                escape(c.storyToldToIslam()),
                escape(c.whyWhollyRemovedFromFoundation()),
                escape(c.quranicCriterionAnchor()),
                escape(c.pureFoundationReplacement()),
                escape(t.profileId()),
                t.orderIndex(),
                escape(t.colorName()),
                t.hexCode(), r, g, b,
                activeLowHex, t.activeLow24(),
                t.wavelengthNm(),
                t.luminance(),
                t.hexCode(), (t.luminance() > 130.0 ? "#0B0D13" : "#FFFFFF"), t.hexCode(),
                activeLowHex, (t.luminance() > 130.0 ? "#FFFFFF" : "#0B0D13"), activeLowHex,
                escape(t.pillar().title()),
                escape(t.patronEntity()),
                escape(t.sacredImplement()),
                escape(t.signatureInvocation()),
                escape(t.recitationMode()),
                t.spcState().code(), t.cp(), t.sigma(),
                sha256Seal.substring(0, 32) + "..."
        );
    }

    private String renderDependencyReportHtml(
            List<GeneratedHtmlArtifact> orderArtifacts,
            List<PactOutcome<WarlockCovenantEngine.InvocationTelemetry>> outcomes) {
        StringBuilder navLinks = new StringBuilder();
        for (WarlockColorOrder co : WarlockColorOrder.orderedBySevenColors()) {
            WarlockIslamChronicle ch = WarlockIslamChronicle.forOrderIndex(co.orderIndex());
            navLinks.append(String.format(
                    "<a class=\"nav-pill\" href=\"%s\"><span class=\"swatch\" style=\"background:%s\"></span>#%d %s</a>%n",
                    ch.htmlFileName(), co.hexCode(), co.orderIndex(), co.profileId()
            ));
        }
        navLinks.append("<a class=\"nav-pill\" href=\"warlock-3d-sanctum.html\" style=\"border-color:#D4AF37;color:#FDE68A;\">3D Sanctum Render</a>");
        navLinks.append("<a class=\"nav-pill dep-link active\" href=\"dependencies-report.html\">Dependencies Report</a>");

        StringBuilder springRows = new StringBuilder();
        for (DependencyDescriptor d : SPRING_BOOT_DEPENDENCIES) {
            springRows.append(String.format("""
                    <tr>
                      <td><span class="tag">%s</span></td>
                      <td><code>%s</code></td>
                      <td><code>%s</code></td>
                      <td><code>%s</code></td>
                      <td><code>%s</code></td>
                      <td>%s</td>
                    </tr>
                    """,
                    escape(d.category()),
                    escape(d.coordinateOrModule()),
                    escape(d.versionOrRuntime()),
                    escape(d.scope()),
                    escape(d.classesAndAnnotationsUsed()),
                    escape(d.usageAcrossSevenOrders())
            ));
        }

        StringBuilder javaRows = new StringBuilder();
        for (DependencyDescriptor d : JAVA_ESSENTIALS_DEPENDENCIES) {
            javaRows.append(String.format("""
                    <tr>
                      <td><span class="tag java-tag">%s</span></td>
                      <td><code>%s</code></td>
                      <td><code>%s</code></td>
                      <td><code>%s</code></td>
                      <td><code>%s</code></td>
                      <td>%s</td>
                    </tr>
                    """,
                    escape(d.category()),
                    escape(d.coordinateOrModule()),
                    escape(d.versionOrRuntime()),
                    escape(d.scope()),
                    escape(d.classesAndAnnotationsUsed()),
                    escape(d.usageAcrossSevenOrders())
            ));
        }

        StringBuilder artifactRows = new StringBuilder();
        for (int i = 0; i < orderArtifacts.size(); i++) {
            GeneratedHtmlArtifact art = orderArtifacts.get(i);
            var outcome = outcomes.get(i);
            String colorHex = "#FFFFFF";
            String profileId = "";
            String removedSummary = "";
            if (outcome instanceof PactOutcome.CovenantSealed<WarlockCovenantEngine.InvocationTelemetry> s) {
                colorHex = s.payload().hexCode();
                profileId = s.payload().profileId();
                WarlockIslamChronicle ch = WarlockIslamChronicle.forOrderIndex(s.payload().orderIndex());
                removedSummary = ch.pureFoundationReplacement();
            }
            artifactRows.append(String.format("""
                    <tr>
                      <td><strong>#%d</strong></td>
                      <td><a href="%s" style="color:#38BDF8;font-weight:600;">%s</a></td>
                      <td><code>%s</code></td>
                      <td><span class="swatch" style="background:%s"></span> <code>%s</code></td>
                      <td><code>%d bytes</code></td>
                      <td><code>%s...</code></td>
                      <td>%s</td>
                    </tr>
                    """,
                    i + 1,
                    art.fileName(),
                    art.fileName(),
                    escape(profileId),
                    colorHex,
                    colorHex,
                    art.byteSize(),
                    art.sha256Hash().substring(0, 20),
                    escape(removedSummary)
            ));
        }

        boolean tensorConserved = SpcControlMatrix.verifyTransformationTensorConservation();

        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <title>Spring Boot &amp; Java Essentials Dependency Usage Report | 7 Warlock Orders</title>
                  <style>
                    :root {
                      --bg-deep: #0B0D13;
                      --bg-card: #131722;
                      --text-main: #ECEFF4;
                      --text-muted: #9AA5B8;
                      --border-subtle: rgba(255,255,255,0.12);
                    }
                    * { box-sizing: border-box; margin: 0; padding: 0; }
                    body {
                      font-family: 'Segoe UI', system-ui, -apple-system, sans-serif;
                      background: var(--bg-deep);
                      color: var(--text-main);
                      line-height: 1.6;
                      padding-bottom: 4rem;
                    }
                    header {
                      border-bottom: 2px solid #38BDF8;
                      background: rgba(11, 13, 19, 0.94);
                      padding: 1.25rem 2rem;
                      position: sticky;
                      top: 0;
                      z-index: 10;
                    }
                    .nav-bar {
                      display: flex;
                      flex-wrap: wrap;
                      gap: 0.5rem;
                      max-width: 1360px;
                      margin: 0 auto;
                      align-items: center;
                    }
                    .nav-pill {
                      display: inline-flex;
                      align-items: center;
                      gap: 0.4rem;
                      padding: 0.4rem 0.75rem;
                      border-radius: 999px;
                      background: var(--bg-card);
                      border: 1px solid var(--border-subtle);
                      color: var(--text-muted);
                      text-decoration: none;
                      font-size: 0.82rem;
                      font-weight: 600;
                    }
                    .nav-pill.active, .nav-pill:hover {
                      color: #FFF;
                      border-color: #38BDF8;
                    }
                    .nav-pill.dep-link { margin-left: auto; }
                    .swatch {
                      width: 11px;
                      height: 11px;
                      border-radius: 50%%;
                      border: 1px solid rgba(255,255,255,0.45);
                      display: inline-block;
                    }
                    main {
                      max-width: 1360px;
                      margin: 2.2rem auto;
                      padding: 0 2rem;
                    }
                    .hero {
                      background: linear-gradient(135deg, #131722 0%%, #0F2C59 100%%);
                      border: 1px solid var(--border-subtle);
                      border-left: 6px solid #38BDF8;
                      border-radius: 14px;
                      padding: 2rem;
                      margin-bottom: 2rem;
                    }
                    h1 { font-size: 2rem; margin-bottom: 0.5rem; }
                    .section-card {
                      background: var(--bg-card);
                      border: 1px solid var(--border-subtle);
                      border-radius: 12px;
                      padding: 1.75rem;
                      margin-bottom: 2rem;
                      overflow-x: auto;
                    }
                    .section-card h2 {
                      font-size: 1.25rem;
                      color: #38BDF8;
                      margin-bottom: 1rem;
                      border-bottom: 1px solid var(--border-subtle);
                      padding-bottom: 0.5rem;
                    }
                    table {
                      width: 100%%;
                      border-collapse: collapse;
                      font-size: 0.9rem;
                    }
                    th, td {
                      text-align: left;
                      padding: 0.75rem 0.65rem;
                      border-bottom: 1px solid rgba(255,255,255,0.07);
                      vertical-align: top;
                    }
                    th {
                      color: var(--text-muted);
                      font-weight: 600;
                      text-transform: uppercase;
                      font-size: 0.78rem;
                      letter-spacing: 0.05em;
                    }
                    code {
                      font-family: 'Consolas', monospace;
                      font-size: 0.84rem;
                      color: #A5F3FC;
                    }
                    .tag {
                      display: inline-block;
                      padding: 0.2rem 0.55rem;
                      border-radius: 5px;
                      background: rgba(56, 189, 248, 0.15);
                      color: #38BDF8;
                      font-size: 0.78rem;
                      font-weight: 600;
                    }
                    .tag.java-tag {
                      background: rgba(52, 211, 153, 0.15);
                      color: #34D399;
                    }
                  </style>
                </head>
                <body>
                  <header>
                    <nav class="nav-bar">
                      %s
                    </nav>
                  </header>
                  <main>
                    <section class="hero">
                      <h1>Spring Boot &amp; Java 21+/26 Dependency Usage Report</h1>
                      <p style="color:#CBD5E1;">
                        Comprehensive dependency audit across all <strong>7 Pre-Prophetic Abrahamic Warlock Color Orders (1..7)</strong>,
                        mapping every Maven/Spring Boot Starter coordinate in <code>pom.xml</code>, every Java Standard Library
                        module/package, and the 7 generated Order HTML portals (with their Foundation Severance Chronicles).
                      </p>
                      <p style="margin-top:0.75rem;font-family:Consolas,monospace;font-size:0.86rem;color:#34D399;">
                        GEMINI.md SPC Transformation Tensor Conservation (sum_j T_ij == 0): %s | Runtime: Java %s
                      </p>
                    </section>

                    <section class="section-card">
                      <h2>1. Spring Boot &amp; Maven Dependencies (pom.xml — Spring Boot 3.4.3)</h2>
                      <table>
                        <thead>
                          <tr>
                            <th>Category</th>
                            <th>Maven Coordinate</th>
                            <th>Version</th>
                            <th>Scope</th>
                            <th>Annotations / Classes Used</th>
                            <th>Architectural Role Across the 7 Warlock Orders</th>
                          </tr>
                        </thead>
                        <tbody>
                          %s
                        </tbody>
                      </table>
                    </section>

                    <section class="section-card">
                      <h2>2. Java 21+ / 26 Standard Library Essentials (Zero-Bloat JDK Dependencies)</h2>
                      <table>
                        <thead>
                          <tr>
                            <th>Java Essential</th>
                            <th>JDK Module / Package</th>
                            <th>Runtime Target</th>
                            <th>Scope</th>
                            <th>Constructs &amp; APIs Used</th>
                            <th>Architectural Role Across the 7 Warlock Orders</th>
                          </tr>
                        </thead>
                        <tbody>
                          %s
                        </tbody>
                      </table>
                    </section>

                    <section class="section-card">
                      <h2>3. Generated Per-Order HTML Portals &amp; Foundation Replacement Ledger (Ordered 1..7)</h2>
                      <table>
                        <thead>
                          <tr>
                            <th>Order</th>
                            <th>HTML Portal File</th>
                            <th>Spring @Profile</th>
                            <th>Color Hex</th>
                            <th>Size</th>
                            <th>SHA-256 Checksum</th>
                            <th>Pure Islamic Foundation Replacement (After Complete Removal)</th>
                          </tr>
                        </thead>
                        <tbody>
                          %s
                        </tbody>
                      </table>
                    </section>
                  </main>
                </body>
                </html>
                """.formatted(
                navLinks.toString(),
                tensorConserved ? "VERIFIED (PASS)" : "FAILED",
                Runtime.version().toString(),
                springRows.toString(),
                javaRows.toString(),
                artifactRows.toString()
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
