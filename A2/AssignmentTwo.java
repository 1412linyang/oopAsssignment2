// Main class to demonstrate all requirements from Part 1 to Part 5


public class AssignmentTwo {
    void main() {
        AssignmentTwo assignment = new AssignmentTwo();

        // Run all parts in order (Part 1 → Part 5)
        System.out.println("=".repeat(70));
        assignment.partOne(); // Part 1: Abstract Class & Inheritance
        System.out.println("\n" + "=".repeat(70));
        assignment.partTwo(); // Part 2: Interface Implementation
        System.out.println("\n" + "=".repeat(70));
        assignment.partThree(); // Part 3: FIFO Queue Management
        System.out.println("\n" + "=".repeat(70));
        assignment.partFourA(); // Part 4A: Core Ride History
        System.out.println("\n" + "=".repeat(70));
        assignment.partFourB(); // Part 4B: Sort Ride History
        System.out.println("\n" + "=".repeat(70));
        assignment.partFive(); // Part 5: Ride Cycle Execution
        System.out.println("=".repeat(70));
    }

    // --------------------------
    // Part 1: Abstract Class & Inheritance Demo
    // --------------------------
    public void partOne() {
        System.out.println("=== Part 1: Abstract Class & Inheritance Demo ===");

        // Create Employee object (extends Person)
        Employee rideOperator = new Employee(
                "John Doe", 35, "john.doe@themepark.com",
                "EMP101", "Ride Operations"
        );
        System.out.println("\n1. Employee Object (extends Person):");
        System.out.println("   Name: " + rideOperator.getName());
        System.out.println("   Age: " + rideOperator.getAge());
        System.out.println("   Employee ID: " + rideOperator.getEmployeeId());
        System.out.println("   Department: " + rideOperator.getDepartment());

        // Create Visitor object (extends Person)
        Visitor testVisitor = new Visitor(
                "Alice Smith", 28, "alice@example.com",
                "TKT2025001", "2025-12-03"
        );
        System.out.println("\n2. Visitor Object (extends Person):");
        System.out.println("   Name: " + testVisitor.getName());
        System.out.println("   Age: " + testVisitor.getAge());
        System.out.println("   Ticket ID: " + testVisitor.getTicketId());
        System.out.println("   Visit Date: " + testVisitor.getVisitDate());
    }

    // --------------------------
    // Part 2: Interface Implementation Demo
    // --------------------------
    public void partTwo() {
        System.out.println("=== Part 2: Interface Implementation Demo ===");

        // Create Employee and Ride (implements RideInterface)
        Employee operator = new Employee("Emma Wilson", 32, "emma@themepark.com", "EMP102", "Ride Operations");
        Ride ferrisWheel = new Ride("Giant Ferris Wheel", "Family Ride", operator, 4);

        System.out.println("\n1. Ride Object (implements RideInterface):");
        System.out.println("   Ride Name: " + ferrisWheel.getRideName());
        System.out.println("   Ride Type: " + ferrisWheel.getRideType());
        System.out.println("   Operator: " + ferrisWheel.getOperator().getName());

        // List supported interface methods
        System.out.println("\n2. Mandatory Methods from RideInterface:");
        System.out.println("   - addVisitorToQueue(Visitor)");
        System.out.println("   - removeVisitorFromQueue(Visitor)");
        System.out.println("   - addVisitorToHistory(Visitor)");
        System.out.println("   - checkVisitorFromHistory(Visitor)");
        System.out.println("   - runOneCycle()");
        System.out.println("   (And all other methods defined in RideInterface)");
    }

    // --------------------------
    // Part 3: FIFO Queue Management Demo
    // --------------------------
    public void partThree() {
        System.out.println("=== Part 3: FIFO Queue Management Demo ===");

        // Create ride and operator
        Employee operator = new Employee("Mike Roberts", 38, "mike@themepark.com", "EMP103", "Ride Operations");
        Ride spaceMountain = new Ride("Space Mountain", "Thrill Ride", operator, 3);

        // Create 5 test visitors
        Visitor v1 = new Visitor("Bob Johnson", 32, "bob@example.com", "TKT2025002", "2025-12-03");
        Visitor v2 = new Visitor("Charlie Brown", 24, "charlie@example.com", "TKT2025003", "2025-12-03");
        Visitor v3 = new Visitor("Diana Prince", 29, "diana@example.com", "TKT2025004", "2025-12-03");
        Visitor v4 = new Visitor("Ethan Hunt", 31, "ethan@example.com", "TKT2025005", "2025-12-03");
        Visitor v5 = new Visitor("Fiona Green", 27, "fiona@example.com", "TKT2025006", "2025-12-03");

        // Step 1: Add visitors to FIFO queue
        System.out.println("\nStep 1: Add 5 visitors to the FIFO queue");
        spaceMountain.addVisitorToQueue(v1);
        spaceMountain.addVisitorToQueue(v2);
        spaceMountain.addVisitorToQueue(v3);
        spaceMountain.addVisitorToQueue(v4);
        spaceMountain.addVisitorToQueue(v5);

        // Step 2: Print initial queue (FIFO order)
        System.out.println("\nStep 2: Print initial queue (FIFO order)");
        spaceMountain.printQueue();

        // Step 3: Remove a specific visitor (Charlie Brown)
        System.out.println("\nStep 3: Remove specific visitor (Charlie Brown)");
        spaceMountain.removeVisitorFromQueue(v2);

        // Step 4: Print queue after removal
        System.out.println("\nStep 4: Print queue after removal");
        spaceMountain.printQueue();

        // Step 5: Remove the first visitor (FIFO priority: Bob Johnson)
        System.out.println("\nStep 5: Remove first visitor (FIFO rule)");
        spaceMountain.removeFirstFromQueue();

        // Step 6: Print final queue
        System.out.println("\nStep 6: Print final queue");
        spaceMountain.printQueue();
    }

    // --------------------------
    // Part 4A: Core Ride History Demo
    // --------------------------
    public void partFourA() {
        System.out.println("=== Part 4A: Core Ride History Demo ===");

        // Create ride and operator
        Employee operator = new Employee("Lisa Miller", 29, "lisa@themepark.com", "EMP104", "Ride Operations");
        Ride pirateShip = new Ride("Pirate Ship", "Family Ride", operator, 2);

        // Create test visitors
        Visitor v1 = new Visitor("Oliver Queen", 30, "oliver@example.com", "TKT2025007", "2025-12-04");
        Visitor v2 = new Visitor("Felicity Smoak", 28, "felicity@example.com", "TKT2025008", "2025-12-04");
        Visitor v3 = new Visitor("Barry Allen", 27, "barry@example.com", "TKT2025009", "2025-12-04");
        Visitor v4 = new Visitor("Caitlin Snow", 29, "caitlin@example.com", "TKT2025010", "2025-12-04");
        Visitor v5 = new Visitor("Ray Palmer", 32, "ray@example.com", "TKT2025011", "2025-12-04");
        Visitor v6 = new Visitor("Clark Kent", 33, "clark@example.com", "TKT2025012", "2025-12-04"); // Non-existent visitor

        // Step 1: Add 5 visitors to history (with duplicate test)
        System.out.println("\nStep 1: Add 5 visitors to ride history");
        pirateShip.addVisitorToHistory(v1);
        pirateShip.addVisitorToHistory(v2);
        pirateShip.addVisitorToHistory(v3);
        pirateShip.addVisitorToHistory(v4);
        pirateShip.addVisitorToHistory(v5);
        pirateShip.addVisitorToHistory(v2); // Test duplicate visitor

        // Step 2: Check if visitors exist in history
        System.out.println("\nStep 2: Check visitor existence in history");
        pirateShip.checkVisitorFromHistory(v3); // Exists
        pirateShip.checkVisitorFromHistory(v6); // Does not exist

        // Step 3: Get total number of historical visitors
        System.out.println("\nStep 3: Get total visitors in history");
        pirateShip.numberOfVisitors();

        // Step 4: Print full ride history (Iterator traversal)
        System.out.println("\nStep 4: Print ride history (Iterator traversal)");
        pirateShip.printRideHistory();
    }

    // --------------------------
    // Part 4B: Sort Ride History Demo
    // --------------------------
    public void partFourB() {
        System.out.println("=== Part 4B: Organize Ride History (Sorting) ===");

        // Create ride and operator
        Employee operator = new Employee("Emma Wilson", 32, "emma@themepark.com", "EMP104", "Ride Operations");
        Ride ferrisWheel = new Ride("Giant Ferris Wheel", "Family Ride", operator, 2);

        // Create visitors in unsorted order
        Visitor v1 = new Visitor("Bob", 24, "bob@example.com", "TKT2025015", "2025-12-05");
        Visitor v2 = new Visitor("Alice", 28, "alice@example.com", "TKT2025014", "2025-12-05");
        Visitor v3 = new Visitor("Charlie", 30, "charlie@example.com", "TKT2025016", "2025-12-05");
        Visitor v4 = new Visitor("Alice", 26, "alice2@example.com", "TKT2025017", "2025-12-06");
        Visitor v5 = new Visitor("David", 29, "david@example.com", "TKT2025018", "2025-12-06");

        // Step 1: Add visitors to history (unsorted)
        System.out.println("\nStep 1: Add 5 visitors to history (unsorted order)");
        ferrisWheel.addVisitorToHistory(v1);
        ferrisWheel.addVisitorToHistory(v2);
        ferrisWheel.addVisitorToHistory(v3);
        ferrisWheel.addVisitorToHistory(v4);
        ferrisWheel.addVisitorToHistory(v5);

        // Step 2: Print unsorted history
        System.out.println("\nStep 2: Print unsorted ride history");
        ferrisWheel.printRideHistory();

        // Step 3: Sort history using custom Comparator (Name → Ticket ID)
        System.out.println("\nStep 3: Sort history by Name → Ticket ID");
        VisitorComparator comparator = new VisitorComparator();
        ferrisWheel.sortRideHistory(comparator);

        // Step 4: Print sorted history
        System.out.println("\nStep 4: Print sorted ride history");
        ferrisWheel.printRideHistory();
    }

    // --------------------------
    // Part 5: Ride Cycle Execution Demo
    // --------------------------
    public void partFive() {
        System.out.println("=== Part 5: Ride Cycle Execution Demo ===");

        // Create ride and operator (max 3 riders per cycle)
        Employee operator = new Employee("Mike Roberts", 38, "mike@themepark.com", "EMP105", "Ride Operations");
        Ride rollerCoaster = new Ride("Thunder Roller", "Roller Coaster", operator, 3);

        // Step 1: Add 10 visitors to the queue
        System.out.println("\nStep 1: Add 10 visitors to the waiting queue");
        for (int i = 1; i <= 10; i++) {
            Visitor visitor = new Visitor(
                    "Visitor " + i,
                    20 + (i % 10),
                    "visitor" + i + "@example.com",
                    "TKT20250" + (20 + i),
                    "2025-12-07"
            );
            rollerCoaster.addVisitorToQueue(visitor);
        }

        // Step 2: Print queue before any cycles
        System.out.println("\nStep 2: Print queue (before ride cycles)");
        rollerCoaster.printQueue();

        // Step 3: Run first ride cycle
        System.out.println("\nStep 3: Run first ride cycle (max 3 riders)");
        rollerCoaster.runOneCycle();

        // Step 4: Print queue after first cycle
        System.out.println("\nStep 4: Print queue (after first cycle)");
        rollerCoaster.printQueue();

        // Step 5: Print history after first cycle
        System.out.println("\nStep 5: Print ride history (after first cycle)");
        rollerCoaster.printRideHistory();

        // Step 6: Run second ride cycle
        System.out.println("\nStep 6: Run second ride cycle");
        rollerCoaster.runOneCycle();

        // Step 7: Print final status
        System.out.println("\nStep 7: Print queue (after second cycle)");
        rollerCoaster.printQueue();
        System.out.println("\nStep 8: Print ride history (after second cycle)");
        rollerCoaster.printRideHistory();
        System.out.println("\nTotal cycles run: " + rollerCoaster.getNumOfCycles());
    }
        public static void main(String[] args) {
            AssignmentTwo assignment = new AssignmentTwo();

            // （已有的 Part 1-5 调用保持不变）
            System.out.println("\n" + "=".repeat(70));
            assignment.partSix(); // Part 6: Export to File
            System.out.println("=".repeat(70));
        }

        // --------------------------
        // Part 6: Export Ride History to File Demo
        // --------------------------
        public void partSix() {
            System.out.println("=== Part 6: Export Ride History to File ===");

            // 1. Create operator and Ride object
            Employee operator = new Employee("Sarah Lee", 31, "sarah@themepark.com", "EMP106", "Ride Operations");
            Ride logFlume = new Ride("Log Flume", "Family Ride", operator, 4);

            // 2. Add at least 5 visitors to ride history
            System.out.println("\nStep 1: Add 5 visitors to ride history");
            Visitor v1 = new Visitor("Mia Clark", 27, "mia@example.com", "TKT2025025", "2025-12-08");
            Visitor v2 = new Visitor("Noah Wilson", 29, "noah@example.com", "TKT2025026", "2025-12-08");
            Visitor v3 = new Visitor("Zoe Martinez", 25, "zoe@example.com", "TKT2025027", "2025-12-08");
            Visitor v4 = new Visitor("Liam Anderson", 30, "liam@example.com", "TKT2025028", "2025-12-09");
            Visitor v5 = new Visitor("Ella Thomas", 26, "ella@example.com", "TKT2025029", "2025-12-09");
            logFlume.addVisitorToHistory(v1);
            logFlume.addVisitorToHistory(v2);
            logFlume.addVisitorToHistory(v3);
            logFlume.addVisitorToHistory(v4);
            logFlume.addVisitorToHistory(v5);

            // 3. Export history to CSV file
            System.out.println("\nStep 2: Export ride history to CSV file");
            String exportFile = "ride_history.csv"; // File will be created in project root
            logFlume.exportRideHistory(exportFile);

        }
    public void partSeven() {
        System.out.println("=== Part 7: Import Ride History from File ===");
        Employee operator = new Employee("Tom Harris", 34, "tom@themepark.com", "EMP107", "Ride Operations");
        Ride riverRafting = new Ride("River Rafting", "Thrill Ride", operator, 5);

        System.out.println("\nStep 1: Import from CSV file");
        String importFile = "ride_history.csv";
        riverRafting.exportRideHistory(importFile);

        System.out.println("\nStep 2: Check imported visitor count");
        riverRafting.numberOfVisitors();

        System.out.println("\nStep 3: Print imported visitors");
        riverRafting.printRideHistory();
    }
}



