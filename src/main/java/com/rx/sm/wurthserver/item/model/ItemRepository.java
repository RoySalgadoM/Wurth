package com.rx.sm.wurthserver.item.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<ItemBean, Long> {

    Optional<ItemBean> findById(long id);
    boolean existsById(long id);
}
