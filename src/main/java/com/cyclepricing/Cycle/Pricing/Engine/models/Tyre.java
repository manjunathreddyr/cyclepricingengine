package com.cyclepricing.Cycle.Pricing.Engine.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Tyre {
    private String type;
    private Double price;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
    private Date date;

    public Double getTyrePrice(Date date){
        this.date = date;
        if(date.after(new Date("01/01/2016")) && date.before(new Date("30/11/2016"))){
            this.price = 200.0;
        }else if(date.after(new Date("01/12/2016"))){
            this.price = 230.0;
        }
        return price;
    }
    public Tyre(){

    }
}
