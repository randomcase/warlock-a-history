package com.sovereign.warlock.domain;

/**
 * Statistical Process Control (SPC) Matrix & Transformation Tensor (T)
 * compliant with GEMINI.md Quality Control Matrix Specification.
 */
public final class SpcControlMatrix {

    public enum SpcState {
        S0_OPTIMAL("S0", "Optimal Performance (Mizan / Tiferet)", 1.33, 1.0,
                "Nominal Merkabah operation; zero drift; 72 Names in harmonic phase."),
        S1_WARNING("S1", "Warning Threshold (Qelipotic Jitter)", 1.00, 2.5,
                "Minor cantillation drift; proactive Tajwid/Ta'amei calibration pulse."),
        S2_CRITICAL("S2", "Critical Failure (Shevirat HaKelim)", 0.67, 4.0,
                "Structural Offset Bias Injection (-1.2 sigma_x) & Active Loop Re-init."),
        S3_SHUTDOWN("S3", "Hard Shutdown (Pargod Isolation)", 0.00, Double.POSITIVE_INFINITY,
                "Dynamic Shunt Attenuation: De-energize circuits & seal Tehom within 12ms.");

        private final String code;
        private final String phaseDefinition;
        private final double minCp;
        private final double maxSigma;
        private final String correctiveAlgorithm;

        SpcState(String code, String phaseDefinition, double minCp, double maxSigma, String correctiveAlgorithm) {
            this.code = code;
            this.phaseDefinition = phaseDefinition;
            this.minCp = minCp;
            this.maxSigma = maxSigma;
            this.correctiveAlgorithm = correctiveAlgorithm;
        }

        public String code() {
            return code;
        }

        public String phaseDefinition() {
            return phaseDefinition;
        }

        public double minCp() {
            return minCp;
        }

        public double maxSigma() {
            return maxSigma;
        }

        public String correctiveAlgorithm() {
            return correctiveAlgorithm;
        }
    }

    public static final double[][] P_BASELINE = {
            {0.85, 0.12, 0.03, 0.00},
            {0.30, 0.55, 0.15, 0.00},
            {0.05, 0.10, 0.60, 0.25},
            {0.00, 0.00, 0.00, 1.00}
    };

    public static final double[][] P_CORRECTED = {
            {0.92, 0.07, 0.01, 0.00},
            {0.42, 0.55, 0.03, 0.00},
            {0.25, 0.50, 0.23, 0.02},
            {0.00, 0.00, 0.00, 1.00}
    };

    private SpcControlMatrix() {
    }

    public static SpcState evaluateState(double cp, double sigma) {
        if (cp >= 1.33 && sigma < 1.0) {
            return SpcState.S0_OPTIMAL;
        } else if (cp >= 1.00 && sigma < 2.5) {
            return SpcState.S1_WARNING;
        } else if (cp >= 0.67 && sigma < 4.0) {
            return SpcState.S2_CRITICAL;
        }
        return SpcState.S3_SHUTDOWN;
    }

    /**
     * Verifies Conservation of Stochastic Probability: sum_j(T_ij) == 0 for all rows i.
     */
    public static boolean verifyTransformationTensorConservation() {
        for (int i = 0; i < P_BASELINE.length; i++) {
            double rowDeltaSum = 0.0;
            for (int j = 0; j < P_BASELINE[i].length; j++) {
                double tij = P_CORRECTED[i][j] - P_BASELINE[i][j];
                rowDeltaSum += tij;
            }
            if (Math.abs(rowDeltaSum) > 1e-9) {
                return false;
            }
        }
        return true;
    }
}
