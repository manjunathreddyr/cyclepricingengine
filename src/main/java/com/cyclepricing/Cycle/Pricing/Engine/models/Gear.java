package com.cyclepricing.Cycle.Pricing.Engine.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Gear {

    private String type;
    private Double price;
    public Gear(){

    }
}
