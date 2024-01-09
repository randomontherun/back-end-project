package com.example.demo.services;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

   private CustomerRepository customerRepository;

   public CheckoutServiceImpl(CustomerRepository customerRepository) {
       this.customerRepository = customerRepository;
   }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();

        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> item.setCart(cart));

        Customer customer = purchase.getCustomer();

        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

       return UUID.randomUUID().toString();
    }
}