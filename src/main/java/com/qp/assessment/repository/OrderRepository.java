package com.qp.assessment.repository;

import com.qp.assessment.model.GroceryOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<GroceryOrder, Integer> {
}
