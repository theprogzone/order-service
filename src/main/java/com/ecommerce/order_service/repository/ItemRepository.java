package com.ecommerce.order_service.repository;

import com.ecommerce.order_service.model.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<LineItem, Long> {
}
