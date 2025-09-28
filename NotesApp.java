import java.io.*;
import java.util.Scanner;

public class NotesApp {
    private static final String FILE_NAME = "notes.txt";

    // Method to write notes
    public static void writeNote() {
        try (Scanner sc = new Scanner(System.in);
             FileWriter fw = new FileWriter(FILE_NAME, true)) { // append mode
            System.out.println("Enter your note (type 'exit' on a new line to stop):");
            while (true) {
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("exit")) break;
                fw.write(line + System.lineSeparator());
            }
            System.out.println("✅ Notes saved successfully!");
        } catch (IOException e) {
            System.out.println("⚠️ Error writing to file: " + e.getMessage());
        }
    }

    // Method to read notes
    public static void readNotes() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n📖 Your Notes:");
            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("⚠️ No notes found! Please add some first.");
        } catch (IOException e) {
            System.out.println("⚠️ Error reading file: " + e.getMessage());
        }
    }

    // Main Menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Notes App =====");
            System.out.println("1. Write Notes");
            System.out.println("2. Read Notes");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline
            switch (choice) {
                case 1 -> writeNote();
                case 2 -> readNotes();
                case 3 -> {
                    System.out.println("👋 Exiting Notes App. Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("❌ Invalid choice, try again.");
            }
        }
    }
}
