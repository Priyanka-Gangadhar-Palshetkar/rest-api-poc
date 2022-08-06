package com.almameal.api.poc.repository;

import com.almameal.api.poc.model.OrderDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderDetails, Long> {
}
