package com.myapp.finance_tracker.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * JPA entity representing a single item (e.g. an expense or income) in finance tracking.
 * Mapped to the {@code items} table, which Hibernate creates via {@code ddl-auto: update}.
 */
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    /**
     * No-arg constructor required by the JPA specification.
     */
    protected Item() {
    }

    /**
     * Creates a new item with the given data.
     *
     * @param name      the item name
     * @param category  the item category
     * @param amount    the monetary amount of the item
     * @param createdAt the creation timestamp of the item
     */
    public Item(String name, String category, BigDecimal amount, Instant createdAt) {
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    /**
     * @return the unique identifier of the item
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the item name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the item category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @return the monetary amount of the item
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @return the creation timestamp of the item
     */
    public Instant getCreatedAt() {
        return createdAt;
    }
}
