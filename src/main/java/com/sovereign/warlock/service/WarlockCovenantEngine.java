package com.sovereign.warlock.service;

import com.sovereign.warlock.domain.MysticalPillar;
import com.sovereign.warlock.domain.PactOutcome;
import com.sovereign.warlock.domain.SpcControlMatrix;
import com.sovereign.warlock.domain.WarlockColorOrder;
import com.sovereign.warlock.domain.WarlockOrder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Comparator;
import java.util.HexFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * Core Covenant Engine executing the 7 Color-Ordered Abrahamic Warlock Profiles.
 * Demonstrates Java 21+ Essentials:
 * - Record Pattern Deconstruction in exhaustive switch expressions
 * - Virtual Threads (Executors.newVirtualThreadPerTaskExecutor())
 * - Stream pipelines, Grouping Collectors, Comparators, HexFormat & SHA-256
 */
public final class WarlockCovenantEngine {

    public record InvocationTelemetry(
            int orderIndex,
            String profileId,
            String colorName,
            String hexCode,
            int rgb24,
            int activeLow24,
            int wavelengthNm,
            double luminance,
            String warlockName,
            String hebrewTitle,
            String arabicTitle,
            String prePropheticStratum,
            String patronEntity,
            String sacredImplement,
            String signatureInvocation,
            String recitationMode,
            MysticalPillar pillar,
            String theurgicFormula,
            SpcControlMatrix.SpcState spcState,
            double cp,
            double sigma,
            String virtualThreadName,
            Instant timestamp
    ) {
    }

    /**
     * Exhaustive Java 21+ Record Pattern Matching switch across all 7 permitted WarlockOrder records.
     */
    public String synthesizeTheurgicFormula(WarlockOrder warlock) {
        return switch (warlock) {
            case WarlockOrder.WhiteFireWarlock(var color, var props, var pillar, int radiusFeet) ->
                    String.format("[Order %d | %s] %s (%s) contracts %dft Tzimtzum void -> %s [%s]",
                            color.orderIndex(), color.hexCode(), props.warlockName(),
                            props.hebrewTitle(), radiusFeet, props.signatureInvocation(), pillar.name());

            case WarlockOrder.BlackFireWarlock(var color, var props, var pillar, int gatesCount) ->
                    String.format("[Order %d | %s] %s (%s) permutes %d Sefer Yetzirah Gates -> %s [%s]",
                            color.orderIndex(), color.hexCode(), props.warlockName(),
                            props.arabicTitle(), gatesCount, props.signatureInvocation(), pillar.name());

            case WarlockOrder.SapphireMerkabahWarlock(var color, var props, var pillar, int palaces) ->
                    String.format("[Order %d | %s] %s (%s) ascends %d Heikhalot Palaces -> %s [%s]",
                            color.orderIndex(), color.hexCode(), props.warlockName(),
                            props.hebrewTitle(), palaces, props.signatureInvocation(), pillar.name());

            case WarlockOrder.GoldAlastWarlock(var color, var props, var pillar, int triplets) ->
                    String.format("[Order %d | %s] %s (%s) intones %d Shem HaMephorash Triplets -> %s [%s]",
                            color.orderIndex(), color.hexCode(), props.warlockName(),
                            props.arabicTitle(), triplets, props.signatureInvocation(), pillar.name());

            case WarlockOrder.CrimsonSeraphWarlock(var color, var props, var pillar, int wings) ->
                    String.format("[Order %d | %s] %s (%s) unfurls %d Seraphic Wings of Coal-Fire -> %s [%s]",
                            color.orderIndex(), color.hexCode(), props.warlockName(),
                            props.hebrewTitle(), wings, props.signatureInvocation(), pillar.name());

            case WarlockOrder.BrassGoeticWarlock(var color, var props, var pillar, int spirits) ->
                    String.format("[Order %d | %s] %s (%s) arraigns %d Pre-Adamic Smokeless Spirits -> %s [%s]",
                            color.orderIndex(), color.hexCode(), props.warlockName(),
                            props.arabicTitle(), spirits, props.signatureInvocation(), pillar.name());

            case WarlockOrder.EmeraldTwilightWarlock(var color, var props, var pillar, int dhikrCount) ->
                    String.format("[Order %d | %s] %s (%s) cleaves bedrock via Shamir & %d Unseen Names -> %s [%s]",
                            color.orderIndex(), color.hexCode(), props.warlockName(),
                            props.arabicTitle(), dhikrCount, props.signatureInvocation(), pillar.name());
        };
    }

    /**
     * Executes a single Warlock Order invocation and wraps it in an algebraic PactOutcome.
     */
    public PactOutcome<InvocationTelemetry> invokeWarlock(WarlockOrder warlock) {
        var color = warlock.colorOrder();
        var props = warlock.properties();
        var state = warlock.spcState();

        String formula = synthesizeTheurgicFormula(warlock);
        String vThread = Thread.currentThread().toString();
        Instant now = Instant.now();

        InvocationTelemetry telemetry = new InvocationTelemetry(
                color.orderIndex(),
                color.profileId(),
                color.colorName(),
                color.hexCode(),
                color.rgb24(),
                color.activeLow24(),
                color.wavelengthNm(),
                color.relativeLuminance(),
                props.warlockName(),
                props.hebrewTitle(),
                props.arabicTitle(),
                props.prePropheticStratum(),
                props.patronEntity(),
                props.sacredImplement(),
                props.signatureInvocation(),
                props.recitationMode(),
                warlock.pillar(),
                formula,
                state,
                props.processCapabilityCp(),
                props.varianceSigma(),
                vThread,
                now
        );

        String seal = computeSha256(
                color.orderIndex() + "|" + color.profileId() + "|" + color.hexCode() + "|" + formula
        );

        if (state == SpcControlMatrix.SpcState.S3_SHUTDOWN) {
            return new PactOutcome.VesselFracture<>(
                    "ERR_PARGOD_SHUTDOWN",
                    "Catastrophic variance exceeded 4.0 sigma for " + color.profileId(),
                    state
            );
        }
        return new PactOutcome.CovenantSealed<>(telemetry, state, seal);
    }

    /**
     * Executes all active Warlock Orders concurrently using Java 21+ Virtual Threads,
     * returning outcomes strictly ordered by Color Order (1..7).
     */
    public List<PactOutcome<InvocationTelemetry>> invokeAllOrderedByColor(List<WarlockOrder> orders) {
        try (ExecutorService vExecutor = Executors.newVirtualThreadPerTaskExecutor()) {
            List<Callable<PactOutcome<InvocationTelemetry>>> tasks = orders.stream()
                    .sorted(Comparator.comparing(WarlockOrder::colorOrder, WarlockColorOrder.BY_COLOR_ORDER_7))
                    .map(order -> (Callable<PactOutcome<InvocationTelemetry>>) () -> invokeWarlock(order))
                    .toList();

            List<Future<PactOutcome<InvocationTelemetry>>> futures = vExecutor.invokeAll(tasks);
            return futures.stream()
                    .map(f -> {
                        try {
                            return f.get();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            throw new IllegalStateException("Virtual thread invocation interrupted", e);
                        } catch (ExecutionException e) {
                            throw new IllegalStateException("Virtual thread invocation failed", e);
                        }
                    })
                    .toList();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Virtual thread executor interrupted", e);
        }
    }

    /**
     * Groups the 7 Warlocks by their Primary Abrahamic Mystical Pillar while preserving Color Order (1..7).
     */
    public Map<MysticalPillar, List<WarlockOrder>> groupByMysticalPillar(List<WarlockOrder> orders) {
        return orders.stream()
                .sorted(Comparator.comparing(WarlockOrder::colorOrder, WarlockColorOrder.BY_COLOR_ORDER_7))
                .collect(Collectors.groupingBy(WarlockOrder::pillar));
    }

    private static String computeSha256(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(input.getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 unavailable", e);
        }
    }
}
