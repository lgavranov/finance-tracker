package com.myapp.finance_tracker.service;

import com.myapp.finance_tracker.model.response.ItemSummaryResponse;
import com.myapp.finance_tracker.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Default {@link ItemService} implementation backed by {@link ItemRepository}.
 * The mapping from persistence projection to response DTO happens here, inside the
 * transactional boundary, in line with {@code open-in-view: false}.
 * <p>
 * {@code @RequiredArgsConstructor} generates a constructor for the {@code final}
 * dependencies, so injection stays constructor-based (no field injection).
 */
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<ItemSummaryResponse> getAllItemSummaries() {
        return itemRepository.findAllSummaries().stream()
                .map(ItemSummaryResponse::from)
                .toList();
    }
}
