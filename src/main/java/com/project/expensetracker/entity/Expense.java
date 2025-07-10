package com.project.expensetracker.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Expense {
    public enum category{
        MOBILE_RECHARGE,
        FOOD,
        UTILITIES,
        GIFT,
        CONTRIBUTION,
        MONEY_TRANSFER,
        OTHERS
    };


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(nullable = false)
    double amount;
    @Column(nullable = false)
    LocalDateTime date;
    @Column(nullable = false)
    String description;
    @Enumerated(EnumType.STRING)
    category category;

    @PrePersist
    @PreUpdate
    protected void onCreate() {
        date = LocalDateTime.now();
    }


}