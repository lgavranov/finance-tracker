package com.myapp.finance_tracker.model.response;

import com.myapp.finance_tracker.model.projections.ItemSummaryProjection;

import java.math.BigDecimal;

/**
 * Immutable response DTO exposed by the web layer for item summaries.
 * Keeping a dedicated DTO decouples the API contract from the persistence projection.
 *
 * @param id       the item identifier
 * @param name     the item name
 * @param category the item category
 * @param amount   the monetary amount of the item
 */
public record ItemSummaryResponse(Long id, String name, String category, BigDecimal amount) {

    /**
     * Builds a response DTO from a persistence-layer projection.
     *
     * @param projection the source projection
     * @return a new immutable response instance
     */
    public static ItemSummaryResponse from(ItemSummaryProjection projection) {
        return new ItemSummaryResponse(
                projection.getId(),
                projection.getName(),
                projection.getCategory(),
                projection.getAmount());
    }
}
