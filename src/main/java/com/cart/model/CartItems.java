package com.cart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Table(name="cartitems_tab")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartItems {
	
	@Id
	private long cartitem_id;
	private String productName;
	private String brandName;
	private String productQtn;
	private int price;
	

}
