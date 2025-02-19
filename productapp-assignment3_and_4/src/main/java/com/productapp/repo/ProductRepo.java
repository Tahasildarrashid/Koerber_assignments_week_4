package com.productapp.repo;

import com.productapp.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends MongoRepository<Product, String> {

    @Query("{id :?0}")
    Optional<Product> getProdcutById(Integer id);

    @Query("{qty : {$lt: ?0}}")
    List<Product> getProductsByQtyLessThan(Integer qty);

    @Query("{ qty : { $gte: ?0 } }")
    List<Product> getProductdByPagesGreaterThanEqual(Integer qty);

    @Query("{ qty : ?0 }")
    List<Product> getProductsByQty(Integer pages);

    @Query("{vendor : ?0}")
    List<Product> getProductsByVendor(String vendor);

    @Query("{$and :[{vendor: ?0},{cost: ?1}] }")
    List<Product> getProductsByVendorAndCost(String vendor, Double cost);

    @Query("{$or :[{vendor: ?0},{name: ?1}]}")
    List<Product> getProductsByVendorOrName(String vendor, String name);

    @Query(value ="{vendor: ?0}", count=true)
    Integer getProductsCountByVendor(String vendor);

    //Sorting
    @Query(value = "{vendor:?0}", sort= "{name:1}") //ASC
    List<Product> getProductsByVendorSortByName(String vendor);

    //@Query with Projection
    // only data of name & vendor properties will be displayed

    @Query(value= "{qty: ?0}", fields="{name:1, vendor:1}")
    //@Query(value= "{qty: ?0}", fields="{name:1, vendor:1, cost:1, qty:1}") // will display all properties data
    List<Product> getProductNameAndVendorByQty(Integer qty);

    @Query(value= "{vendor : ?0}")
    List<Product> getAllProductByVendor(String vendor);

    @Query("{ vendor : { $regex : ?0 } }")
    List<Product> getProductsByVendorRegEx(String vendor);

}
