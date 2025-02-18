package com.assignment1.mongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Ascent {
    private Integer year;
    private Integer total;

    public Ascent(Integer year, Integer total) {
        this.year = year;
        this.total = total;
    }
}
