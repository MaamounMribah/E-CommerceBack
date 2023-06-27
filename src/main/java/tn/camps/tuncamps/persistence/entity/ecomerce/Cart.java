package tn.camps.tuncamps.persistence.entity.ecomerce;

import javax.persistence.JoinColumn;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Cart")
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Cart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idCart;
	private Boolean promotionAdded;
	private Boolean empty;
	private Double total;

	@OneToMany(mappedBy = "cart", orphanRemoval = true)
	private List<CartItem> cartItems;

	@OneToMany(mappedBy = "cart", orphanRemoval = true)
	private List<Allocation> allocations;

	@JsonIgnore
	@OneToOne(mappedBy = "cart", optional = true, orphanRemoval = true)
	private Order order;
}