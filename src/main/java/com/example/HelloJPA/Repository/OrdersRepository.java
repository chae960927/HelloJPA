package com.example.HelloJPA.Repository;

import com.example.HelloJPA.Domain.Orders;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OrdersRepository {

    @PersistenceContext
    EntityManager em;

    public Long save(Orders orders){
        em.persist(orders);
        return orders.getOrderId();
    }

    public Orders findById(Long orderId){
        return em.find(Orders.class, orderId);
    }
}
