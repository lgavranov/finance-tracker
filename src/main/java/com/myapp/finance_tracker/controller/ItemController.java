package com.myapp.finance_tracker.controller;

import com.myapp.finance_tracker.model.response.ItemSummaryResponse;
import com.myapp.finance_tracker.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller exposing read endpoints for items under {@code /items}.
 * It depends on the {@link ItemService} abstraction only (DIP) and holds no business logic.
 */
@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    /**
     * Returns all items as lightweight summaries.
     *
     * @return HTTP 200 with the list of item summaries
     */
    @GetMapping
    public ResponseEntity<List<ItemSummaryResponse>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItemSummaries());
    }
}
