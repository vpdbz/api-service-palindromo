package com.walmart.service.palindromo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.walmart.service.palindromo.model.Product;

@Component
public class ProductDAO {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Product> findByBrandOrDescription(String str) {
        Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("brand").regex(str), Criteria.where("description").regex(str));
        Query query = new Query(criteria);

        return mongoTemplate.find(query, Product.class);
    }

    public Product findById(long id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));

        return mongoTemplate.findOne(query, Product.class);
    }

}
