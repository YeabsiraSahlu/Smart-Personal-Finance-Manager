// Yeabsira Sahlu Personal Finance Calculator 2023 Summer project

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class pfc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the monthly expenses for different categories
        Map<String, Double> monthlyExpenses = new HashMap<>();
        monthlyExpenses.put("Housing", 1500.0);
        monthlyExpenses.put("Transportation", 500.0);
        monthlyExpenses.put("Food", 400.0);
        monthlyExpenses.put("Utilities", 250.0);
        monthlyExpenses.put("Entertainment", 150.0);

        System.out.println("Personal Finance Calculator");
        System.out.print("Enter your monthly income: ");
        double monthlyIncome = scanner.nextDouble();

        // Track expenses for multiple months
        System.out.print("Enter the number of months to track expenses: ");
        int months = scanner.nextInt();

        double totalExpenses = 0.0;
        Map<String, Double> categoryTotalExpenses = new HashMap<>();

        for (int i = 1; i <= months; i++) {
            System.out.println("Month " + i + " expenses:");
            double monthlyTotalExpenses = 0.0;
            // Get expenses for each category and calculate the total for this month
            for (Map.Entry<String, Double> entry : monthlyExpenses.entrySet()) {
                System.out.print("Enter " + entry.getKey() + " expenses: ");
                double expenseAmount = scanner.nextDouble();
                monthlyTotalExpenses += expenseAmount;

                // Update category total expenses for each category
                categoryTotalExpenses.put(entry.getKey(), categoryTotalExpenses.getOrDefault(entry.getKey(), 0.0) + expenseAmount);
            }

            totalExpenses += monthlyTotalExpenses;

            double monthlySavings = monthlyIncome - monthlyTotalExpenses;
            System.out.println("Monthly Savings for Month " + i + ": " + monthlySavings);
        }
        // User's average monthly savings over however long
        double averageMonthlySavings = (monthlyIncome * months - totalExpenses) / months;
        System.out.println("Average Monthly Savings for " + months + " months: " + averageMonthlySavings);
        // User's savings goal and calculate the remaining months to achieve it
        System.out.print("Enter your savings goal: ");
        double savingsGoal = scanner.nextDouble();

        int remainingMonthsToGoal = (int) Math.ceil((savingsGoal - totalExpenses) / averageMonthlySavings);
        System.out.println("Remaining months to reach your savings goal: " + remainingMonthsToGoal);

        // Display a summary of total expenses for each category
        System.out.println("\nTotal Expenses Summary:");
        for (Map.Entry<String, Double> entry : categoryTotalExpenses.entrySet()) {
            System.out.println(entry.getKey() + " expenses: " + entry.getValue());
        }

        // Display the percentage of total expenses for each category
        System.out.println("\nPercentage of Total Expenses for Each Category:");
        for (Map.Entry<String, Double> entry : categoryTotalExpenses.entrySet()) {
            double percentage = (entry.getValue() / totalExpenses) * 100;
            System.out.println(entry.getKey() + ": " + String.format("%.2f", percentage) + "%");
        }
        scanner.close();
    }
}
