import java.util.ArrayList;
import java.util.Scanner;

public class LegacyAppointmentSystem {

    // Global mutable state (smell)
    static ArrayList<String> appointments = new ArrayList<>();

    // Hard-coded secret (smell)
    static String adminPassword = "admin123";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 5) {
            printMenu();
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) { // Add appointment
                System.out.print("Patient Name: ");
                String name = sc.nextLine();
                System.out.print("Date: ");
                String date = sc.nextLine();
                appointments.add(name + " - " + date);
                System.out.println("Appointment added");
            }

            if (choice == 2) { // View appointments
                for (String a : appointments) {
                    System.out.println(a);
                }
            }

            if (choice == 3) { // Search appointment
                System.out.print("Search name: ");
                String search = sc.nextLine();
                boolean found = false;
                for (String a : appointments) {
                    if (a.contains(search)) {
                        found = true;
                    }
                }
                if (found == true) { // Duplicate boolean check (smell)
                    System.out.println("Appointment found");
                } else {
                    System.out.println("Appointment not found");
                }
            }

            if (choice == 4) { // Admin panel
                System.out.print("Enter admin password: ");
                String pwd = sc.nextLine();
                if (pwd.equals(adminPassword)) {
                    System.out.println("Admin access granted");
                    System.out.println("Total appointments: " + appointments.size());
                } else {
                    System.out.println("Wrong password");
                }
            }

            if (choice > 5) { // Magic number smell
                System.out.println("Invalid choice");
            }
        }

        sc.close();
    }

    // Menu method
    public static void printMenu() {
        System.out.println("1 Add Appointment");
        System.out.println("2 View Appointments");
        System.out.println("3 Search Appointment");
        System.out.println("4 Admin Panel");
        System.out.println("5 Exit");
    }
}
