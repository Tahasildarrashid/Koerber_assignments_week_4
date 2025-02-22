package com.assignment1.mongodb.repository;

import com.assignment1.mongodb.entity.Peak;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Mountainrepo extends MongoRepository<Peak, String> {
    @Query("{'name': 'Everest'}")
    List<Peak> findByName(String name);

    @Query("{'height': {$gt:8000}}")
    List<Peak> findByHeightGreaterThan(int height);

    @Query("{'name': 'Everest', 'height': '8848'}")
    List<Peak> findByNameAndHeight(String name, int height);

    @Query("{'$or': [{'name': 'Everest'}, {'height': 8848}]}")
    List<Peak> findByNameOrHeight(String name, int height);

    @Query("{'location': {'$all: ['China', 'Nepal']}}")
    List<Peak> findByLocationIn(List<String> locations);

    @Query("{'ascents': {$gt: 1000}}")
    List<Peak> findByAscentsTotalGreaterThan(int total);
}
