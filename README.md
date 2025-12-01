# oopAsssignment2
# Theme Park Ride Management System - Assignment Documentation
This repository contains the complete implementation of the Theme Park Ride Management System, developed as part of a Java programming assignment (Part 1 to Part 7). The project adheres to object-oriented programming (OOP) principles and covers core Java concepts through practical functionality for theme park ride operations.

## 📋 Assignment Overview
The assignment requires building a comprehensive system to manage theme park rides, including visitor queues, ride history tracking, ride cycle execution, and data persistence. The system is divided into 7 sequential parts, each focusing on specific Java concepts and functional requirements.

### Core Functional Requirements (Part 1-7)
| Part | Topic | Key Functionality |
|------|-------|-------------------|
| 1 | Abstract Class & Inheritance | Create `Person` (abstract parent class) + `Employee`/`Visitor` (subclasses) |
| 2 | Interface Design | Define `RideInterface` with mandatory operations for rides |
| 3 | FIFO Queue Management | Implement visitor queue (add/remove/print) using `LinkedList` |
| 4A | Ride History Core | Track visitor history (add/check/count/print with `Iterator`) |
| 4B | History Sorting | Sort history by name → ticket ID using custom `Comparator` |
| 5 | Ride Cycle Execution | Process visitors in cycles (max riders per cycle + cycle count) |
| 6 | Export to File | Backup ride history to CSV format (data persistence) |
| 7 | Import from File | Restore ride history from CSV files (error handling + format validation) |


## 🛠️ Technical Knowledge & Tools Used
The project is built entirely with **Java SE** (Standard Edition) and leverages the following key concepts:
1. **Object-Oriented Programming (OOP)**
   - Abstract classes (`Person`) and inheritance (`Employee`/`Visitor` extends `Person`)
   - Interface implementation (`Ride` implements `RideInterface`)
   - Encapsulation (private fields + public getters/setters)
2. **Data Structures**
   - `LinkedList` (for ride history storage and iterator traversal)
   - `Queue` (FIFO queue for visitor waiting lines)
3. **Java Core Features**
   - `Comparator` interface (custom sorting for visitors)
   - Exception handling (file I/O errors, invalid data formats)
   - File I/O (`BufferedReader`/`BufferedWriter` for CSV import/export)
   - Loop/conditional logic (cycle execution, data validation)
4. **Development Tools**
   - Git & GitHub (version control, progress tracking)
   - Java IDE (IntelliJ/Eclipse) for compilation and testing
   - CSV file handling (data persistence)


## 📂 Project Structure
The repository follows a standard Java project structure, with all source code organized in the `src/` folder and documentation in the root:
```
theme-park-ride-management/
├─ src/                     # Java source code (all .java files)
│  ├─ Person.java           # Part 1: Abstract parent class
│  ├─ Employee.java         # Part 1: Subclass of Person (ride operators)
│  ├─ Visitor.java          # Part 1: Subclass of Person (park visitors)
│  ├─ RideInterface.java    # Part 2: Core interface for ride operations
│  ├─ Ride.java             # Parts 3-7: Implements RideInterface (core logic)
│  ├─ VisitorComparator.java# Part 4B: Custom comparator for sorting
│  └─ AssignmentTwo.java    # Main class (demonstrates all Part 1-7 features)
├─ README.md                # Project documentation (this file)
└─ .gitignore               # Ignores compiled files, IDE config, and CSV exports
```


## 🚀 How to Run the Project
1. **Prerequisites**: Install Java SE 8+ and Git (for cloning the repository).
2. **Clone the Repository**:
   ```bash
   git clone https://github.com/[your-username]/theme-park-ride-management.git
   ```
3. **Compile & Execute**:
   - Open the project in a Java IDE (IntelliJ/Eclipse) or compile via terminal.
   - Run the `AssignmentTwo.java` class (contains the `main` method).
   - The program will execute demos for all 7 parts in sequence, with clear console output for each functionality.


## 📝 Progress Tracking
This repository uses **GitHub Commits** to track development progress sequentially. Each commit corresponds to a completed part of the assignment, with detailed messages explaining changes made. The commit history follows this structure:
1. Initialize project structure & docs
2. Implement Part 1 (Abstract Class & Inheritance)
3. Implement Part 2 (Interface Design)
4. Implement Part 3 (FIFO Queue Management)
5. Implement Part 4A (Ride History Core)
6. Implement Part 4B (History Sorting)
7. Implement Part 5 (Ride Cycle Execution)
8. Implement Part 6 (Export to File)
9. Implement Part 7 (Import from File)
10. Refactor & add final documentation


## ✅ Key Compliance Notes
- All methods and classes are named semantically for readability.
- Input validation and error handling are implemented for critical operations (e.g., file I/O, invalid visitor data).
- The system is modular: Each part builds on previous functionality, ensuring scalability and maintainability.
- CSV export/import follows a standard format (name, age, email, ticketId, visitDate) for compatibility.

