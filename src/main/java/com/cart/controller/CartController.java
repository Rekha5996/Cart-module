package com.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.dto.CartDTO;
import com.cart.exception.ResourceNotFoundException;
import com.cart.model.Cart;
import com.cart.repository.CartRepo;




@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartRepo crepo;
	
	//adding product to the cart
	@PostMapping("/addproduct")
	public Cart addProduct(@RequestBody CartDTO cart) {
		return crepo.save(cart.getCart());
	}
	
	//update items quantity in cart
	@PutMapping("/updatequantity/{cid}")
	public Cart updateQtn(@RequestBody Cart cart,@PathVariable("cid") long cid) {
		Cart cobj= crepo.findById(cid)
				.orElseThrow(() -> new ResourceNotFoundException("cart product not found with id:"+cid)); 
		cobj.setCartitems(cart.getCartitems());
		return crepo.save(cobj);
	}
	
	// remove items from the cart
	@DeleteMapping("removeitems/{cid}")
	public String removeItems(@PathVariable("cid") long cid) {
		Cart cobj= crepo.findById(cid)
				.orElseThrow(() -> new ResourceNotFoundException("cart product not found with id:"+cid));
		crepo.delete(cobj);
		return "items removed from cart";
		
		
	}



}
