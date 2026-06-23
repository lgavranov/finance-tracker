package com.myapp.finance_tracker.model.projections;

import java.math.BigDecimal;

public interface ItemSummaryProjection {

    Long getId();

    String getName();

    String getCategory();

    BigDecimal getAmount();
}
