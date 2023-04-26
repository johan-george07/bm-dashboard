package bm.product.dashboard.controller;
import bm.product.dashboard.model.Product;
import java.util.List;
import java.util.Map;

import bm.product.dashboard.model.Client;
import bm.product.dashboard.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;



@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	 //http://localhost:8080/products/all-products
	 @GetMapping("/all")
	    public List<Product> getAllProducts(){
	        return productService.findAll();
	    }

	@GetMapping("/{product_id}")
		public Product getProductById(@PathVariable("product_id") Integer product_id){
		 return productService.getProductById(product_id);
	}

	@GetMapping("/no-of-users")
		public Map<String, Object> getSumOfUsers(){
			return productService.countAllUsers();
	}
	@GetMapping("/all-clients")
		public List<Client> getAllClients(){
		 	return(productService.findAllClients());
	}
	@GetMapping("/{product_id}/revenue")
	public Map<String,Object> getProductRevenueById(@PathVariable("product_id") Integer product_id){
		 Map<String,Object> revenue= productService.getProductRevenueById(product_id);
		 if(revenue.isEmpty()){
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		 }
		 return(revenue);
	}

	@GetMapping("/{product_id}/clients")
	public Map<String,Object> getClientByProductId(@PathVariable("product_id") Integer product_id){
		 return productService.getClientByProductId(product_id);
	}

	@GetMapping("/{product_id}/description")
	public Map<String,Object> getDescriptionByProductId(@PathVariable("product_id") Integer product_id){
		return productService.getDescriptionByProductId(product_id);
	}

	@GetMapping("/{product_id}/no-of-users")
	public Map<String,Object> getUsersByProductId(@PathVariable("product_id") Integer product_id){
		return productService.getUsersByProductId(product_id);
	}

	@GetMapping("/{product_id}/countries")
	public Map<String,Object> getCountriesByProductId(@PathVariable("product_id") Integer product_id){
		return productService.getCountriesByProductId(product_id);
	}
	
}

