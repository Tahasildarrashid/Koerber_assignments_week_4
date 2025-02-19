package com.example.demo.repository;
import com.example.demo.entity.Peaks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;

public interface Peakrepository extends MongoRepository<Peaks, String> {
    @Query("{ $and: [ { 'name': 'Everest' }, { 'height': 8848 } ] }")
    List<Peaks> findByNameEverestAndHeight8848();

    @Query("{ 'location': { $all: ['China', 'Nepal'] } }")
    List<Peaks> findByLocationChinaAndNepal();

    @Query("{ 'ascents.firstWinter': { $gt: 2000 } }")
    List<Peaks> findByFirstWinterAscendedAfter2000();

    @Query("{ }, { 'ascents': 0, 'location': 0 }")
    List<Peaks> findAllExcludingAscentsAndLocation();
}
