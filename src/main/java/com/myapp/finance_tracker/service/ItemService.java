package com.myapp.finance_tracker.service;

import com.myapp.finance_tracker.model.response.ItemSummaryResponse;

import java.util.List;

/**
 * Application service abstraction for item read operations.
 * The web layer depends on this interface rather than a concrete class (DIP),
 * which keeps the controller testable and the implementation interchangeable.
 */
public interface ItemService {

    /**
     * Retrieves all items as lightweight summaries.
     *
     * @return an immutable list of item summaries; never {@code null}
     */
    List<ItemSummaryResponse> getAllItemSummaries();
}
