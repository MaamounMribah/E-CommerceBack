package tn.camps.tuncamps.persistence.entity.ecomerce;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Allocation")
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Allocation {
    public  int id;
    public Date dateDebut;
    public Date dateFin;
    public double price;
    public int Quantity;
    @JsonIgnore
    @ManyToOne(optional = true)
    @JoinColumn(name = "cart_id", nullable = true)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
