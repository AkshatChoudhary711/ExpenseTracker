package com.project.expensetracker.controllers;

import com.project.expensetracker.entity.Expense;
import com.project.expensetracker.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<List<Expense>> getExpenses() {
        List<Expense> expenses = expenseService.getExpenses();
        if (expenses.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Expense>> getExpenseByCategory(@PathVariable Expense.category category) {
        List<Expense> expenses = expenseService.getExpenseByCategory(category);
        if (expenses.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @GetMapping("/month/{month}")
    public ResponseEntity<List<Expense>> getExpensesByMonth(@PathVariable int month) {
        List<Expense> expenses = expenseService.getExpensesByMonth(month);
        if (expenses.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @GetMapping("/day/{day}")
    public ResponseEntity<List<Expense>> getExpensesByDay(@PathVariable int day) {
        List<Expense> expenses = expenseService.getExpensesByDay(day);
        if (expenses.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(expenses, HttpStatus.OK);

    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<Expense>> getExpensesByYear(@PathVariable int year) {
        List<Expense> expenses = expenseService.getExpensesByYear(year);
        if (expenses.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @GetMapping("/lessThan/{amount}")
    public ResponseEntity<List<Expense>> getExpensesLessThan(@PathVariable double amount) {
        List<Expense> expenses = expenseService.getExpensesLessThan(amount);
        if (expenses.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addExpense(@RequestBody Expense expense) {
        try {
            expenseService.addExpense(expense);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable long id) {
        try {
            expenseService.deleteExpense(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
