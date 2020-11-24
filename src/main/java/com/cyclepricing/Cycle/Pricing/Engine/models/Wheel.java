package com.cyclepricing.Cycle.Pricing.Engine.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Wheel {

    private Spoke spokes;
    private Rim rim;
    private Tube tube;
    private Tyre tyre;
    private Double price = 0.0;
    public Wheel(){

    }
}
