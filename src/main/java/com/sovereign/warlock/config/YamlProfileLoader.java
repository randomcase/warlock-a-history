package com.sovereign.warlock.config;

import com.sovereign.warlock.domain.WrongdoerArchetypeOrder.ZalimProfileProperties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Pure Java NIO parser for Spring Boot application-<profile>.yml files.
 * Zero external library dependencies; uses java.nio.file and Stream pipelines.
 */
public final class YamlProfileLoader {

    private YamlProfileLoader() {
    }

    public static WarlockProfileProperties loadProfile(Path resourcesDir, String profileId) {
        Path yamlPath = resourcesDir.resolve("application-" + profileId + ".yml");
        if (!Files.exists(yamlPath)) {
            throw new IllegalStateException("Missing Spring Boot profile resource: " + yamlPath.toAbsolutePath());
        }
        try {
            List<String> lines = Files.readAllLines(yamlPath, StandardCharsets.UTF_8);
            Map<String, String> kv = parseSectionBlock(lines, "warlock:");
            return new WarlockProfileProperties(
                    Integer.parseInt(requireKey(kv, "warlock", "orderIndex")),
                    requireKey(kv, "warlock", "profileId"),
                    requireKey(kv, "warlock", "colorName"),
                    requireKey(kv, "warlock", "hexCode"),
                    Integer.parseInt(requireKey(kv, "warlock", "rgbRed")),
                    Integer.parseInt(requireKey(kv, "warlock", "rgbGreen")),
                    Integer.parseInt(requireKey(kv, "warlock", "rgbBlue")),
                    Integer.parseInt(requireKey(kv, "warlock", "wavelengthNm")),
                    requireKey(kv, "warlock", "warlockName"),
                    requireKey(kv, "warlock", "hebrewTitle"),
                    requireKey(kv, "warlock", "arabicTitle"),
                    requireKey(kv, "warlock", "prePropheticStratum"),
                    requireKey(kv, "warlock", "primaryPillar"),
                    requireKey(kv, "warlock", "patronEntity"),
                    requireKey(kv, "warlock", "sacredImplement"),
                    requireKey(kv, "warlock", "signatureInvocation"),
                    requireKey(kv, "warlock", "recitationMode"),
                    Double.parseDouble(requireKey(kv, "warlock", "processCapabilityCp")),
                    Double.parseDouble(requireKey(kv, "warlock", "varianceSigma"))
            );
        } catch (IOException e) {
            throw new IllegalStateException("Failed reading YAML profile: " + yamlPath, e);
        }
    }

    public static ZalimProfileProperties loadZalimProfile(Path resourcesDir, String profileId) {
        Path yamlPath = resourcesDir.resolve("application-" + profileId + ".yml");
        if (!Files.exists(yamlPath)) {
            throw new IllegalStateException("Missing Spring Boot Zalim profile resource: " + yamlPath.toAbsolutePath());
        }
        try {
            List<String> lines = Files.readAllLines(yamlPath, StandardCharsets.UTF_8);
            Map<String, String> kv = parseSectionBlock(lines, "zalim:");
            return new ZalimProfileProperties(
                    Integer.parseInt(requireKey(kv, "zalim", "zalimIndex")),
                    requireKey(kv, "zalim", "profileId"),
                    requireKey(kv, "zalim", "arabicPrinciple"),
                    requireKey(kv, "zalim", "hexCode"),
                    Integer.parseInt(requireKey(kv, "zalim", "rgbRed")),
                    Integer.parseInt(requireKey(kv, "zalim", "rgbGreen")),
                    Integer.parseInt(requireKey(kv, "zalim", "rgbBlue")),
                    requireKey(kv, "zalim", "warlockName"),
                    requireKey(kv, "zalim", "arabicArchetypeTitle"),
                    requireKey(kv, "zalim", "quranicAnchor"),
                    requireKey(kv, "zalim", "abrahamicChallenge"),
                    requireKey(kv, "zalim", "wrongdoerCategory"),
                    Double.parseDouble(requireKey(kv, "zalim", "rawEntropyBits")),
                    Double.parseDouble(requireKey(kv, "zalim", "uncorrectedCp")),
                    Double.parseDouble(requireKey(kv, "zalim", "uncorrectedSigma")),
                    Double.parseDouble(requireKey(kv, "zalim", "correctedCp")),
                    requireKey(kv, "zalim", "prioryContainmentCell")
            );
        } catch (IOException e) {
            throw new IllegalStateException("Failed reading Zalim YAML profile: " + yamlPath, e);
        }
    }

    private static Map<String, String> parseSectionBlock(List<String> lines, String sectionHeader) {
        Map<String, String> map = new LinkedHashMap<>();
        boolean inSection = false;
        for (String rawLine : lines) {
            String trimmed = rawLine.trim();
            if (trimmed.isEmpty() || trimmed.startsWith("#")) {
                continue;
            }
            if (!rawLine.startsWith(" ") && !rawLine.startsWith("\t")) {
                inSection = trimmed.equals(sectionHeader);
                continue;
            }
            if (inSection) {
                int colonIdx = trimmed.indexOf(':');
                if (colonIdx > 0) {
                    String key = trimmed.substring(0, colonIdx).trim();
                    String val = trimmed.substring(colonIdx + 1).trim();
                    if (val.startsWith("\"") && val.endsWith("\"") && val.length() >= 2) {
                        val = val.substring(1, val.length() - 1);
                    }
                    map.put(key, val);
                }
            }
        }
        return map;
    }

    private static String requireKey(Map<String, String> map, String prefix, String key) {
        String value = map.get(key);
        if (value == null) {
            throw new IllegalArgumentException("Missing required YAML property '" + prefix + "." + key + "'");
        }
        return value;
    }
}
