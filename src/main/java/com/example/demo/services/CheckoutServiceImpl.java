package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.Cart;
import com.example.demo.entities.CartItem;
import com.example.demo.entities.StatusType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

   private CustomerRepository customerRepository;
   private final CartRepository cartRepository;

   public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository) {
       this.customerRepository = customerRepository;
       this.cartRepository = cartRepository;
   }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        try {
            Cart cart = purchase.getCart();
          //  return new PurchaseResponse("Check cart crt can not be null");


            String orderTrackingNumber = generateOrderTrackingNumber();
            cart.setOrderTrackingNumber(orderTrackingNumber);
    // cartItems not null and cartItems.isEmpty
            Set<CartItem> cartItems = purchase.getCartItems();
            cartItems.forEach(item -> item.setCart(cart));


           // Customer customer = purchase.getCustomer();
            cart.setStatus(StatusType.ordered);
            cartRepository.save(cart);

            return new PurchaseResponse(orderTrackingNumber);
        } catch (Exception exception) {
            return new PurchaseResponse(exception.getMessage());
        }
    }


    private String generateOrderTrackingNumber() {

       return UUID.randomUUID().toString();
    }
}