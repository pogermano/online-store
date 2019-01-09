package com.w3safety.store.repository;

import java.util.Optional;

import com.w3safety.store.domain.OrderItem;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Spring Data  repository for the OrderItem entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    Page<OrderItem> findAllByOrderCustomerUserLogin(String login, Pageable pageable);


    Optional<OrderItem> findOneByIdAndOrderCustomerUserLogin(Long id, String login);

}
