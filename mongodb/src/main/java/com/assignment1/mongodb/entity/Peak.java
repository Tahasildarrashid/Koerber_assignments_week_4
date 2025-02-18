package com.assignment1.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Map;

@Document(collection = "peaks")
public class Peak {
    @Id
    private String id;

    private String name;
    private int height;

    private List<String> location;

    @Field("ascents")
    private Map<String, Ascent> ascents;

    public Peak(String name, int height, List<String> location, Map<String, Ascent> ascents) {
        this.name = name;
        this.height = height;
        this.location = location;
        this.ascents = ascents;
    }
}
