package com.almameal.api.poc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private String totalPrice;

    @OneToOne
    private User user;

    @OneToMany
    private List<Product> productList;

    private Date createdDate;
    private Date updatedDate;
}
