package com.cyclepricing.Cycle.Pricing.Engine.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class Bicycle {

    private String modelName;

    private Price price;

    private BreakAndHandle breakAndHandle;

    private ChainAssemble chainAssemble;

    private Frame frame;

    private Gear gear;

    private Wheel wheel;

    public Bicycle(){

    }
}