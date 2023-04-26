package bm.product.dashboard.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import bm.product.dashboard.model.Product;

public interface ProductRepository extends MongoRepository<Product,ObjectId> {

    @Query("{product_id: ?0}")
    Product getProductById(Integer product_id);
}
