package com.ilabs.cardservice.repository;

import com.ilabs.cardservice.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM item i WHERE i.item_id = :itemId AND i.card_id_fk= :cardId", nativeQuery = true)
    public void removeCaItem(@Param("cardId") long cardId, @Param("itemId") long itemId);

    @Query(value = "SELECT count(*) FROM item i WHERE i.item_id = :itemId AND i.card_id_fk= :cardId", nativeQuery = true)
    public int cardItemExist(@Param("cardId") long cardId, @Param("itemId") long itemId);

}
