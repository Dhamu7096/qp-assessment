package com.qp.assessment.repository;

import com.qp.assessment.model.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryRepository extends JpaRepository<GroceryItem, Integer> {
}
