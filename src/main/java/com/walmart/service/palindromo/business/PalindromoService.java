package com.walmart.service.palindromo.business;

import java.util.List;

import com.walmart.service.palindromo.model.Product;

public interface PalindromoService {

    Product searchById(long id);

    List<Product> searchByDescription(String description);

}
