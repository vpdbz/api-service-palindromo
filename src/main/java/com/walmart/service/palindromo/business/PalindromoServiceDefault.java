package com.walmart.service.palindromo.business;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walmart.service.palindromo.dao.ProductDAO;
import com.walmart.service.palindromo.model.Product;
import com.walmart.service.palindromo.util.PalindromoHelper;

@Service("PALINDROMO_SERVICE")
public class PalindromoServiceDefault implements PalindromoService {

    @Autowired
    protected ProductDAO productDAO;

    @Override
    public Product searchById(long id) {
        Product product = productDAO.findById(id);

        if (PalindromoHelper.evaluate(id + "")) {
            product.setDiscount(50);
        }

        return product;
    }

    @Override
    public List<Product> searchByDescription(String description) {
        List<Product> products = productDAO.findByBrandOrDescription(description);
        
        if (PalindromoHelper.evaluate(description)) {
            products = products.stream()
                    .map(f -> new Product(new ObjectId(f.get_id()), f.getId(), f.getBrand(), f.getDescription(), f.getImage(), f.getPrice(), 50))
                    .collect(Collectors.toList());
        }
        
        return products;
    }

}
