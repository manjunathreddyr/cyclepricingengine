package com.cyclepricing.Cycle.Pricing.Engine.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class Price {

    private Double price;
    private Date duration;
}
