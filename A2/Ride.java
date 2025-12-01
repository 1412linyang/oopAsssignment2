// Part 3-5: Implements all requirements from RideInterface
import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Comparator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
public class Ride implements RideInterface {
    // Core attributes
    private String rideName;
    private String rideType;
    private Employee operator;
    private final Queue<Visitor> waitingQueue; // Part 3: FIFO queue storage
    private final LinkedList<Visitor> rideHistory; // Part 4: History storage

    // Part 5: Ride cycle attributes
    private int maxRider; // Maximum visitors per cycle (minimum 1)
    private int numOfCycles = 0; // Total number of cycles run

    // Default Constructor
    public Ride() {
        this.rideName = "";
        this.rideType = "";
        this.operator = new Employee();
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 2; // Default: 2 riders per cycle
    }

    // Parameterized Constructor
    public Ride(String rideName, String rideType, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = (maxRider >= 1) ? maxRider : 2; // Enforce valid max riders
    }

    // Getters and Setters
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    public String getRideType() { return rideType; }
    public void setRideType(String rideType) { this.rideType = rideType; }
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }
    public Queue<Visitor> getWaitingQueue() { return waitingQueue; }
    public LinkedList<Visitor> getRideHistory() { return rideHistory; }
    public int getMaxRider() { return maxRider; }
    public void setMaxRider(int maxRider) {
        this.maxRider = (maxRider >= 1) ? maxRider : this.maxRider;
    }
    public int getNumOfCycles() { return numOfCycles; }

    // --------------------------
    // Part 4B: Sort Ride History
    // --------------------------
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (comparator == null) {
            System.out.println("❌ Sort failed: Comparator cannot be null.");
            return;
        }
        if (rideHistory.isEmpty()) {
            System.out.println("⚠️ Sort skipped: Ride history is empty.");
            return;
        }
        rideHistory.sort(comparator);
        System.out.println("✅ '" + rideName + "' ride history sorted successfully.");
    }

    // --------------------------
    // Part 3: FIFO Queue Management Implementation
    // --------------------------
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null && waitingQueue.offer(visitor)) {
            System.out.println("➕ Visitor '" + visitor.getName() + "' added to '" + rideName + "' queue.");
        } else {
            if (visitor != null) {
                System.out.println("❌ Failed to add visitor '" + visitor.getName() + "' to queue.");
            }
        }
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (visitor != null && waitingQueue.contains(visitor)) {
            waitingQueue.remove(visitor);
            System.out.println("➖ Visitor '" + visitor.getName() + "' removed from '" + rideName + "' queue.");
        } else {
            System.out.println("❌ Visitor '" + visitor.getName() + "' not found in queue.");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("\n=== '" + rideName + "' Waiting Queue (FIFO Order) ===");
        if (waitingQueue.isEmpty()) {
            System.out.println("📭 Queue is empty.");
            return;
        }
        int index = 1;
        for (Visitor visitor : waitingQueue) {
            System.out.println(index + ". Name: " + visitor.getName() + " | Ticket ID: " + visitor.getTicketId());
            index++;
        }
    }

    // --------------------------
    // Part 4A: Core Ride History Implementation
    // --------------------------
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("❌ Cannot add null visitor to history.");
            return;
        }
        // Prevent duplicates (check by unique ticket ID)
        for (Visitor v : rideHistory) {
            if (v.getTicketId().equals(visitor.getTicketId())) {
                System.out.println("⚠️ Visitor '" + visitor.getName() + "' (Ticket: " + visitor.getTicketId() + ") is already in history.");
                return;
            }
        }
        rideHistory.add(visitor);
        System.out.println("✅ Visitor '" + visitor.getName() + "' (Ticket: " + visitor.getTicketId() + ") added to history.");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("❌ Cannot check null visitor.");
            return false;
        }
        for (Visitor historyVisitor : rideHistory) {
            if (historyVisitor.getTicketId().equals(visitor.getTicketId())) {
                System.out.println("✅ Visitor '" + visitor.getName() + "' (Ticket: " + visitor.getTicketId() + ") exists in history.");
                return true;
            }
        }
        System.out.println("❌ Visitor '" + visitor.getName() + "' (Ticket: " + visitor.getTicketId() + ") not found in history.");
        return false;
    }

    @Override
    public int numberOfVisitors() {
        int total = rideHistory.size();
        System.out.println("📊 Total visitors in '" + rideName + "' history: " + total);
        return total;
    }

    @Override
    public void printRideHistory() {
        System.out.println("\n=== '" + rideName + "' Ride History (Iterator Traversal) ===");
        if (rideHistory.isEmpty()) {
            System.out.println("📭 No ride history available.");
            return;
        }
        Iterator<Visitor> iterator = rideHistory.iterator();
        int index = 1;
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(index + ". Name: " + visitor.getName()
                    + " | Age: " + visitor.getAge()
                    + " | Ticket ID: " + visitor.getTicketId()
                    + " | Visit Date: " + visitor.getVisitDate());
            index++;
        }
    }

    // --------------------------
    // Part 5: Ride Cycle Implementation
    // --------------------------
    @Override
    public void runOneCycle() {
        System.out.println("\n--- Running Ride Cycle for '" + rideName + "' ---");

        // Validation 1: Ensure a valid operator is assigned
        if (operator == null || operator.getEmployeeId().isEmpty()) {
            System.out.println("❌ Cycle failed: No valid operator assigned.");
            return;
        }
        // Validation 2: Ensure there are visitors in the queue
        if (waitingQueue.isEmpty()) {
            System.out.println("❌ Cycle failed: No visitors in the waiting queue.");
            return;
        }

        // Process visitors (up to maxRider per cycle, FIFO order)
        int processedVisitors = 0;
        while (!waitingQueue.isEmpty() && processedVisitors < maxRider) {
            Visitor nextVisitor = waitingQueue.poll(); // Remove from front of queue
            addVisitorToHistory(nextVisitor);
            processedVisitors++;
        }

        // Update total cycle count
        numOfCycles++;

        // Print cycle results
        System.out.println("✅ Cycle " + numOfCycles + " completed successfully!");
        System.out.println("   - Visitors processed this cycle: " + processedVisitors);
        System.out.println("   - Total cycles run: " + numOfCycles);
    }

    // --------------------------
    // Helper Methods (Optional Extensions)
    // --------------------------
    /**
     * Removes the first visitor from the queue (FIFO priority)
     */
    public void removeFirstFromQueue() {
        Visitor firstVisitor = waitingQueue.poll();
        if (firstVisitor != null) {
            System.out.println("➡️ First visitor '" + firstVisitor.getName() + "' removed from queue.");
        } else {
            System.out.println("❌ Cannot remove: Queue is empty.");
        }
    }

    /** Removes a visitor from history (by unique ticket ID) */
    public boolean removeVisitorFromHistory(Visitor visitor) {
        if (visitor == null) return false;
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getTicketId().equals(visitor.getTicketId())) {
                iterator.remove();
                System.out.println("🗑️ Visitor '" + visitor.getName() + "' removed from history.");
                return true;
            }
        }
        System.out.println("❌ Failed to remove: Visitor not found in history.");
        return false;
    }

    /** Clears all entries from the ride history */
    public void clearRideHistory() {
        rideHistory.clear();
        System.out.println("🧹 '" + rideName + "' ride history cleared.");
    }
    // Ride 类中已有的方法（如 removeVisitorFromHistory、clearRideHistory）之后
// --------------------------
// Part 6: Export Ride History to CSV File
// --------------------------
    public void exportRideHistory(String fileName) {
        // 1. 检查历史记录是否为空
        if (rideHistory.isEmpty()) {
            System.out.println("⚠️ Export failed: Ride history is empty.");
            return;
        }

        // 2. 写入文件（try-with-resources 自动关闭流）
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // 遍历历史中的所有游客，按 CSV 格式写入
            for (Visitor visitor : rideHistory) {
                String csvLine = String.join(",",
                        visitor.getName(),
                        String.valueOf(visitor.getAge()),
                        visitor.getEmail(),
                        visitor.getTicketId(),
                        visitor.getVisitDate()
                );
                writer.write(csvLine);
                writer.newLine(); // 换行
            }
            System.out.println("✅ Ride history exported successfully to: " + fileName);
        } catch (IOException e) {
            // 捕获文件写入异常（如权限不足、路径错误）
            System.out.println("❌ Export failed: " + e.getMessage());
        }
    }
    public abstract class ride implements RideInterface {
        // （已有的属性、构造函数、方法保持不变）

        // --------------------------
        // Part 7: Import Ride History from CSV File
        // --------------------------
        /**
         * Reads a CSV file (exported in Part 6) and adds all visitors to ride history.
         * @param fileName The name/path of the CSV file to read
         */
        public void importRideHistory(String fileName) {
            // 清空现有历史（可选，根据需求决定是否覆盖）
            rideHistory.clear();

            // 读取文件并处理异常
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                int lineNumber = 0;
                while ((line = reader.readLine()) != null) {
                    lineNumber++;
                    // 分割CSV行（按逗号分隔）
                    String[] fields = line.split(",");
                    // 验证字段数量（需包含姓名、年龄、邮箱、门票ID、游玩日期共5个字段）
                    if (fields.length != 5) {
                        System.out.println("⚠️ Invalid format in line " + lineNumber + ": Expected 5 fields, got " + fields.length);
                        continue;
                    }

                    try {
                        // 解析每个字段（处理年龄的数字转换）
                        String name = fields[0].trim();
                        int age = Integer.parseInt(fields[1].trim());
                        String email = fields[2].trim();
                        String ticketId = fields[3].trim();
                        String visitDate = fields[4].trim();

                        // 创建Visitor对象并添加到历史
                        Visitor visitor = new Visitor(name, age, email, ticketId, visitDate);
                        rideHistory.add(visitor);
                        System.out.println("✅ Imported visitor (line " + lineNumber + "): " + name);
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ Invalid age in line " + lineNumber + ": " + fields[1].trim() + " (must be a number)");
                    }
                }
                System.out.println("\n✅ Import completed: " + rideHistory.size() + " valid visitors added to history.");
            } catch (IOException e) {
                System.out.println("❌ Import failed: " + e.getMessage());
            }
        }

    }
}