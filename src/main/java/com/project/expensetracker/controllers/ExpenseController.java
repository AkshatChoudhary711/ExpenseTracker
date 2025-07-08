package com.project.expensetracker.controllers;

import com.project.expensetracker.entity.Expense;
import com.project.expensetracker.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<Expense> getExpenses(){
        return expenseService.getExpenses();
    }

    @GetMapping("/month/{month}")
    public List<Expense> getExpensesByMonth( @PathVariable int month){
        return expenseService.getExpensesByMonth(month);
    }

    @GetMapping("/day/{day}")
    public List<Expense> getExpensesByDay(@PathVariable int day){
        return expenseService.getExpensesByDay(day);
    }

    @GetMapping("/year/{year}")
    public List<Expense> getExpensesByYear(@PathVariable int year){
        return expenseService.getExpensesByYear(year);
    }

    @GetMapping("/lessThan/{amount}")
    public List<Expense> getExpensesLessThan(@PathVariable double amount){
        return expenseService.getExpensesLessThan(amount);
    }

    @PostMapping
    public void addExpense(@RequestBody Expense expense){
        expenseService.addExpense(expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable long id){
        expenseService.deleteExpense(id);
    }
}
