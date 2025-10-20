import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Habit {
    String name;
    ArrayList<String> completedDates;  // Stores the dates when habit was completed

    public Habit(String name) {
        this.name = name;
        this.completedDates = new ArrayList<>();
    }

    // Mark habit as done for a specific date if not already marked
    public void markCompleted(String date) {
        if (!completedDates.contains(date)) {
            completedDates.add(date);
        }
    }

    // Check if habit was done on a given date
    public boolean isCompleted(String date) {
        return completedDates.contains(date);
    }

    // Calculate the current streak of consecutive days the habit was done
    public int getStreak() {
        if (completedDates.isEmpty()) return 0;

        // Sort dates to be sure they're in order (just in case)
        completedDates.sort(String::compareTo);

        int streak = 0;
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        // Count backwards from today, day by day, as long as habit was done
        for (int i = 0; ; i++) {
            LocalDate checkDate = today.minusDays(i);
            String checkDateStr = checkDate.format(formatter);
            if (completedDates.contains(checkDateStr)) {
                streak++;  // Increase streak if habit done on this date
            } else {
                break;  // Stop counting if a day was missed
            }
        }
        return streak;
    }

    // Print habit info and progress (dates done + streak)
    public void showProgress() {
        System.out.println("Habit: " + name);
        System.out.println("Completed on dates: " + completedDates);
        System.out.println("Current streak: " + getStreak() + " day(s) 🔥");
    }
}

public class Main {
    static ArrayList<Habit> habits = new ArrayList<>();  // List of all habits
    static Scanner scanner = new Scanner(System.in);     // To read user input

    public static void main(String[] args) {
        showReminders();  // At program start, remind user about habits not done today

        int choice = 0;
        while (choice != 5) {  // Loop until user chooses to exit (option 5)
            System.out.println("\n--- HABIT TRACKER ---");
            System.out.println("1. Add a new habit");
            System.out.println("2. Mark habit as done for today");
            System.out.println("3. View habits");
            System.out.println("4. View reminders");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character leftover

            if (choice == 1) {
                addHabit();
            } else if (choice == 2) {
                markHabitDone();
            } else if (choice == 3) {
                viewHabits();
            } else if (choice == 4) {
                showReminders();
            } else if (choice == 5) {
                System.out.println("Keep your discipline sharp! Goodbye!");
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Add a new habit, check for duplicates before adding
    public static void addHabit() {
        System.out.print("Enter habit name: ");
        String name = scanner.nextLine();

        for (Habit h : habits) {
            if (h.name.equalsIgnoreCase(name)) {
                System.out.println("This habit already exists.");
                return;
            }
        }

        habits.add(new Habit(name));
        System.out.println("Habit added successfully!");
    }

    // Mark a habit as done for today's date
    public static void markHabitDone() {
        System.out.print("Enter habit name to mark as done: ");
        String name = scanner.nextLine();
        String today = LocalDate.now().toString();
        boolean found = false;

        // Find the habit by name (case-insensitive)
        for (Habit h : habits) {
            if (h.name.equalsIgnoreCase(name)) {
                h.markCompleted(today);
                System.out.println("Marked '" + name + "' as done for today (" + today + ").");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Habit not found.");
        }
    }

    // View all habits with status for today and their streak progress
    public static void viewHabits() {
        if (habits.isEmpty()) {
            System.out.println("You have no habits yet.");
            return;
        }

        String today = LocalDate.now().toString();

        for (Habit h : habits) {
            System.out.println("\nHabit: " + h.name);
            if (h.isCompleted(today)) {
                System.out.println("Status today: Done ✅");
            } else {
                System.out.println("Status today: Not done ❌");
            }
            h.showProgress();
        }
    }

    // Show reminders for habits that are NOT done today
    public static void showReminders() {
        if (habits.isEmpty()) {
            System.out.println("\nNo habits to remind you about yet.");
            return;
        }

        String today = LocalDate.now().toString();
        System.out.println("\n--- REMINDERS ---");

        boolean anyPending = false;
        for (Habit h : habits) {
            if (!h.isCompleted(today)) {
                System.out.println("Don't forget to do: " + h.name + " today!");
                anyPending = true;
            }
        }

        if (!anyPending) {
            System.out.println("You're all caught up for today! Keep shining!");
        }
    }
}
