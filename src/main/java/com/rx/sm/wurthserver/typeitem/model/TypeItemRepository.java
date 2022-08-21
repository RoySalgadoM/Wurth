package com.rx.sm.wurthserver.typeitem.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeItemRepository extends JpaRepository<TypeItemBean, Long> {
    Optional<TypeItemBean> findById(long id);

    boolean existsById(long id);
}
