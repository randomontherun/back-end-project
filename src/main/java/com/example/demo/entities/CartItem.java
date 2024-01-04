package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="cart-items")
@Getter
@Setter
public class CartItem {

    private Long id;


    private Vacation vacation;


    private Set<Excursion> excursions;


    private Cart cart;


    private Date create_date;


    private Date last_update;
}
