package com.myapp.finance_tracker.repository;

import com.myapp.finance_tracker.model.entity.Item;
import com.myapp.finance_tracker.model.projections.ItemSummaryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data JPA repository for the {@link Item} entity.
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    /**
     * Loads all items as read-only summaries using a native SQL query.
     * <p>
     * The result is mapped onto {@link ItemSummaryProjection}; the column aliases
     * ({@code id}, {@code name}, {@code category}, {@code amount}) must match the
     * projection getter names so Spring Data can bind them.
     *
     * @return all item summaries ordered by creation time, newest first
     */
    @Query(value = """
            SELECT i.id        AS id,
                   i.name      AS name,
                   i.category  AS category,
                   i.amount    AS amount
            FROM items i
            ORDER BY i.created_at DESC
            """, nativeQuery = true)
    List<ItemSummaryProjection> findAllSummaries();
}
