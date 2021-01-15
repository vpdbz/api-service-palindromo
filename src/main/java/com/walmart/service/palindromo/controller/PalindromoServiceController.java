package com.walmart.service.palindromo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.platform.controller.BaseController;
import com.walmart.platform.response.BaseResponse;
import com.walmart.service.palindromo.business.PalindromoServiceFactory;
import com.walmart.service.palindromo.model.Product;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/palindromo")
public class PalindromoServiceController extends BaseController {

	@Autowired
	PalindromoServiceFactory palindromoServiceFactory;
	
	@Value("${palindromo.service.impl}")
	protected String palindromoService;

	public PalindromoServiceController() {
		super("api-service-palindromo");
	}
	
	@ApiOperation(value = "Search by ID",
            notes = "Return a product",
            response = Product.class,
            responseContainer = "BaseResponse",
            tags = { "search" })
	@GetMapping("search/id/{id}")
	public ResponseEntity<BaseResponse> searchById(@PathVariable("id") long id) {
		Product product = palindromoServiceFactory.get(palindromoService).searchById(id);

	    return createSuccessResponse(product, null);
	}
    
    @ApiOperation(value = "Search by Brand or Description",
            notes = "Return a list of products",
            response = List.class,
            responseContainer = "BaseResponse",
            tags = { "search" })
    @GetMapping("search/string/{string}")
    public ResponseEntity<BaseResponse> searchByBrandOrdescription(@PathVariable("string") String description) {
        List<Product> products = palindromoServiceFactory.get(palindromoService).searchByDescription(description);

        return createSuccessResponse(products, null);
    }

}
