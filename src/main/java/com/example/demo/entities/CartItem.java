package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="cart-items")
@Getter
@Setter
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vacation_id", nullable = false)
    private Vacation vacation;

    @ManyToMany(cascade =  {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable( name = "excursion_cartitem",
                joinColumns = @JoinColumn(name = "cart_item_id"),
                inverseJoinColumns = @JoinColumn(name = "excursion_id"))
    private Set<Excursion> excursions;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @Column(name = "cart_item_id")
    private Date create_date;

    @Column(name = "cart_item_id")
    private Date last_update;
}
