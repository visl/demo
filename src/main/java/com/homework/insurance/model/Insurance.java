package com.homework.insurance.model;

/**
 * Contains all data realted to insurance.
 * <p>
 * Created by v_slo on 24/02/2017.
 */
public class Insurance {

    private String module;

    private Double fromCoverageRange;
    private String fromCoverageRangeLabel;

    private Double toCoverageRange;
    private String toCoverageRangeLabel;

    private int risk;

    //Constructor and getters/setters could be replaced by Lombok

    public Insurance(String module, Double fromCoverageRange, String fromCoverageRangeLabel,
                     Double toCoverageRange, String toCoverageRangeLabel, int risk) {
        this.module = module;
        this.fromCoverageRange = fromCoverageRange;
        this.fromCoverageRangeLabel = fromCoverageRangeLabel;
        this.toCoverageRange = toCoverageRange;
        this.toCoverageRangeLabel = toCoverageRangeLabel;
        this.risk = risk;
    }

    public Insurance(String module, Double fromCoverageRange, Double toCoverageRange, int risk) {
        this.module = module;
        this.fromCoverageRange = fromCoverageRange;
        this.toCoverageRange = toCoverageRange;
        this.risk = risk;
    }

    public String getModule() {
        return module;
    }

    public Double getFromCoverageRange() {
        return fromCoverageRange;
    }

    public String getFromCoverageRangeLabel() {
        return fromCoverageRangeLabel;
    }

    public Double getToCoverageRange() {
        return toCoverageRange;
    }

    public String getToCoverageRangeLabel() {
        return toCoverageRangeLabel;
    }

    public int getRisk() {
        return risk;
    }
}
