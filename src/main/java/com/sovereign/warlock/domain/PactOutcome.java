package com.sovereign.warlock.domain;

import java.util.Objects;
import java.util.function.Function;

/**
 * Algebraic Sealed Outcome Type (Java 21+ Essentials) modeling deterministic Covenantal execution.
 */
public sealed interface PactOutcome<T>
        permits PactOutcome.CovenantSealed, PactOutcome.VesselFracture {

    record CovenantSealed<T>(
            T payload,
            SpcControlMatrix.SpcState spcState,
            String sha256Seal
    ) implements PactOutcome<T> {
        public CovenantSealed {
            Objects.requireNonNull(payload, "payload must not be null");
            Objects.requireNonNull(spcState, "spcState must not be null");
            Objects.requireNonNull(sha256Seal, "sha256Seal must not be null");
        }
    }

    record VesselFracture<T>(
            String errorCode,
            String diagnosticMessage,
            SpcControlMatrix.SpcState fallbackState
    ) implements PactOutcome<T> {
        public VesselFracture {
            Objects.requireNonNull(errorCode, "errorCode must not be null");
            Objects.requireNonNull(diagnosticMessage, "diagnosticMessage must not be null");
            Objects.requireNonNull(fallbackState, "fallbackState must not be null");
        }
    }

    default <R> R fold(
            Function<? super CovenantSealed<T>, ? extends R> onSealed,
            Function<? super VesselFracture<T>, ? extends R> onFracture) {
        return switch (this) {
            case CovenantSealed<T> s -> onSealed.apply(s);
            case VesselFracture<T> f -> onFracture.apply(f);
        };
    }
}
