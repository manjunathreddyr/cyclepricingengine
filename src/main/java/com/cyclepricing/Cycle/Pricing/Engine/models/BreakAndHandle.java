package com.cyclepricing.Cycle.Pricing.Engine.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BreakAndHandle {

    private String type;
    private Double price = 0.0;
    public BreakAndHandle(){

    }
}
