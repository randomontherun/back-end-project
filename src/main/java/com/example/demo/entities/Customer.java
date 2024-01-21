package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.validation.constraints.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="customers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "customer_first_name", nullable = false)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "customer_last_name", nullable = false)
    private String lastName;

    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "address", nullable = false)
    private String address;

    @NotNull
    @Pattern(regexp = "^[0-9]{5}$")
    @Column(name = "postal_code", nullable = false)
    private String postal_code;

    @NotNull
    @Pattern(regexp = "^[0-9]{10}$")
    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    private Division division;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> carts;

    public Customer (String firstName, String lastName, String address, String postal_code, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postal_code = postal_code;
        this.phone = phone;
    }

}
