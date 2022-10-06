package com.prodemy.coffeeshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="order_history")
public class Order {
    
    @Id
    @Column(name="order_id")
    private String orderId;
    
    @Column(name="order_date")
    private String orderDate;
    
    @Column(name="customer_name")
    private String customerName;
    
    @Column(name="order_list")
    private String orderList;
    
    @Column(name="total_amount")
    private String totalAmount;
    
}
