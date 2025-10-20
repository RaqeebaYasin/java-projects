import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    class Expense {
        private static int idCounter = 1;
        private int id;
        private String description;
        private double amount;
        private String date;

        public Expense(String description, double amount, String date) {
            this.id = idCounter++;
            this.description = description;
            this.amount = amount;
            this.date = date;
        }

        public int getId() {
            return id;
        }

        public double getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return "ID: " + id +
                    " | Description: " + description +
                    " | Amount: $" + amount +
                    " | Date: " + date;
        }
    }

    public class ExpenseTracker {
        private List<Expense> expenses;
        private Scanner scanner;

        public ExpenseTracker() {
            expenses = new ArrayList<>();
            scanner = new Scanner(System.in);
        }

        public void start() {
            boolean running = true;

            while (running) {
                printMenu();
                int choice = readInt("Enter your choice: ");

                switch (choice) {
                    case 1:
                        addExpense();
                        break;
                    case 2:
                        viewExpenses();
                        break;
                    case 3:
                        calculateTotal();
                        break;
                    case 4:
                        deleteExpense();
                        break;
                    case 5:
                        System.out.println("Exiting... Take care of your finances.");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }

        private void printMenu() {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Calculate Total");
            System.out.println("4. Delete Expense");
            System.out.println("5. Exit");
        }

        private void addExpense() {
            System.out.print("Description: ");
            String description = scanner.nextLine();

            double amount = readDouble("Amount ($): ");

            System.out.print("Date (YYYY-MM-DD): ");
            String date = scanner.nextLine();

            Expense expense = new Expense(description, amount, date);
            expenses.add(expense);
            System.out.println("Expense added successfully.");
        }

        private void viewExpenses() {
            if (expenses.isEmpty()) {
                System.out.println("No expenses to show.");
                return;
            }

            System.out.println("List of Expenses:");
            for (Expense e : expenses) {
                System.out.println(e);
            }
        }

        private void calculateTotal() {
            double total = 0;
            for (Expense e : expenses) {
                total += e.getAmount();
            }
            System.out.println("Total Expense: ₹" + total);
        }

        private void deleteExpense() {
            int idToDelete = readInt("Enter the ID to delete: ");
            boolean removed = expenses.removeIf(e -> e.getId() == idToDelete);

            if (removed) {
                System.out.println("Expense deleted.");
            } else {
                System.out.println("No expense found with that ID.");
            }
        }

        private int readInt(String prompt) {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                scanner.next();
            }
            int number = scanner.nextInt();
            scanner.nextLine(); // Clear the newline
            return number;
        }

        private double readDouble(String prompt) {
            System.out.print(prompt);
            while (!scanner.hasNextDouble()) {
                System.out.print("Please enter a valid amount: ");
                scanner.next();
            }
            double value = scanner.nextDouble();
            scanner.nextLine(); // Clear the newline
            return value;
        }

        public static void main(String[] args) {
            ExpenseTracker tracker = new ExpenseTracker();
            tracker.start();
        }
    }


