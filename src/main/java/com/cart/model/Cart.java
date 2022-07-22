package com.cart.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Table(name="cart_tab")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long cart_id;
	@NotNull
	private int uid;
	
	
	@OneToMany(targetEntity = CartItems.class,cascade = CascadeType.ALL)
	@JoinColumn(name="cid_fk",referencedColumnName = "cart_id")
	//@JoinColumn(name="uid_fk",referencedColumnName = "uid")
	private List<CartItems> cartitems;
	

}
