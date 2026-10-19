package com.sovereign.warlock.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.Objects;

/**
 * Spring Boot @ConfigurationProperties record bound to each application-warlock-<N>-<color>.yml profile.
 * Demonstrates Java 21+ Record compact constructor validation and immutability.
 */
@ConfigurationProperties(prefix = "warlock")
public record WarlockProfileProperties(
        int orderIndex,
        String profileId,
        String colorName,
        String hexCode,
        int rgbRed,
        int rgbGreen,
        int rgbBlue,
        int wavelengthNm,
        String warlockName,
        String hebrewTitle,
        String arabicTitle,
        String prePropheticStratum,
        String primaryPillar,
        String patronEntity,
        String sacredImplement,
        String signatureInvocation,
        String recitationMode,
        double processCapabilityCp,
        double varianceSigma
) {
    public WarlockProfileProperties {
        if (orderIndex < 1 || orderIndex > 7) {
            throw new IllegalArgumentException("Warlock orderIndex must be in [1..7], got: " + orderIndex);
        }
        Objects.requireNonNull(profileId, "profileId must not be null");
        Objects.requireNonNull(colorName, "colorName must not be null");
        Objects.requireNonNull(hexCode, "hexCode must not be null");
        if (rgbRed < 0 || rgbRed > 255 || rgbGreen < 0 || rgbGreen > 255 || rgbBlue < 0 || rgbBlue > 255) {
            throw new IllegalArgumentException("RGB components must be in [0..255]");
        }
        Objects.requireNonNull(warlockName, "warlockName must not be null");
        Objects.requireNonNull(hebrewTitle, "hebrewTitle must not be null");
        Objects.requireNonNull(arabicTitle, "arabicTitle must not be null");
        Objects.requireNonNull(prePropheticStratum, "prePropheticStratum must not be null");
        Objects.requireNonNull(primaryPillar, "primaryPillar must not be null");
        Objects.requireNonNull(patronEntity, "patronEntity must not be null");
        Objects.requireNonNull(sacredImplement, "sacredImplement must not be null");
        Objects.requireNonNull(signatureInvocation, "signatureInvocation must not be null");
        Objects.requireNonNull(recitationMode, "recitationMode must not be null");
    }
}
