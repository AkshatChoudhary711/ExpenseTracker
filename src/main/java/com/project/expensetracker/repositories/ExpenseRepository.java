package com.project.expensetracker.repositories;

import com.project.expensetracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    Expense findByid(long id);
    Boolean existsById(long id);
    void deleteById(long id);

}
