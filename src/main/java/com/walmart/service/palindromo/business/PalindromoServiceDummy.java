package com.walmart.service.palindromo.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.walmart.service.palindromo.model.Product;

@Service("PALINDROMO_DUMMY_SERVICE")
public class PalindromoServiceDummy implements PalindromoService {

    @Override
    public Product searchById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Product> searchByDescription(String description) {
        // TODO Auto-generated method stub
        return null;
    }

	
}
