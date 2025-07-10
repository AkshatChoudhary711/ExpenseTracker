package com.project.expensetracker.services;

import com.project.expensetracker.entity.Expense;
import com.project.expensetracker.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getExpenses(){
        return expenseRepository.findAll();
    }

    public List<Expense> getExpenseByCategory(Expense.category category){
        return expenseRepository.findAll().stream()
                .filter(expense -> expense.getCategory()==category)
                .toList();
    }

    public List<Expense> getExpensesByMonth(int month){
        return expenseRepository.findAll().stream()
                .filter(expense -> expense.getDate()
                        .getMonthValue()==month)
                .toList();
    }

    public List<Expense> getExpensesByDay(int day){
        return expenseRepository.findAll().stream()
                .filter(expense -> expense.getDate()
                        .getDayOfMonth() == day)
                .toList();
    }

    public List<Expense> getExpensesLessThan(double amount){
        return expenseRepository.findAll().stream()
                .filter(expense -> expense.getAmount()<=(amount))
                .toList();
    }

    public List<Expense> getExpensesByYear(int year){
        return expenseRepository.findAll().stream()
                .filter(expense -> expense.getDate()
                        .getYear() == year)
                .toList();
    }

    public void addExpense(Expense expense) throws IllegalArgumentException{
        if (expense.getCategory() == null) expense.setCategory(Expense.category.OTHERS);
        expenseRepository.save(expense);
    }

    public void deleteExpense(long id) throws IllegalArgumentException{
        if (!expenseRepository.existsById(id)) throw new IllegalArgumentException("Expense with id "+id+" does not exist");
        expenseRepository.deleteById(id);
    }

}
