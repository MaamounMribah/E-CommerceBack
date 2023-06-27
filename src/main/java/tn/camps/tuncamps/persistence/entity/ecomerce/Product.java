package tn.camps.tuncamps.persistence.entity.ecomerce;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

@Table(name = "Product")
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idProduct;
	private int barcode;
	private String name;
	private double price;
	private int stockQuantity;
	private String category;
	private String owner;
	private Boolean reorder;
	private String description;
	private String image;
	@Enumerated(EnumType.STRING)
	private TypeProprietaire typeProprietaire;

	public enum TypeProprietaire {
		PP, PM
	}


    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<CartItem> cartItems;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<Allocation> allocations;

}
