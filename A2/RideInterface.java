// Part 2: Interface defining mandatory operations for rides
public interface RideInterface {
    // --------------------------
    // Part 3: FIFO Queue Management
    // --------------------------
    /**
     * Adds a visitor to the end of the FIFO waiting queue.
     * @param visitor The visitor to add to the queue
     */
    void addVisitorToQueue(Visitor visitor);

    /**
     * Removes a specific visitor from the waiting queue.
     * @param visitor The visitor to remove from the queue
     */
    void removeVisitorFromQueue(Visitor visitor);

    /**
     * Prints all visitors in the queue (FIFO order: front to end).
     */
    void printQueue();

    // --------------------------
    // Part 4A: Core Ride History Management
    // --------------------------
    /**
     * Adds a visitor to the ride history (stored in LinkedList).
     * @param visitor The visitor to add to history
     */
    void addVisitorToHistory(Visitor visitor);

    /**
     * Checks if a visitor exists in the ride history (using unique ticket ID).
     * @param visitor The visitor to verify
     * @return true if the visitor exists in history; false otherwise
     */
    boolean checkVisitorFromHistory(Visitor visitor);

    /**
     * Returns the total number of visitors in the ride history.
     * @return Total count of historical visitors
     */
    int numberOfVisitors();

    /**
     * Prints the full ride history using Iterator traversal.
     */
    void printRideHistory();

    // --------------------------
    // Part 5: Ride Cycle Execution
    // --------------------------
    /**
     * Runs one complete cycle of the ride:
     * 1. Validates operator and queue status
     * 2. Processes up to maxRider visitors (FIFO order)
     * 3. Moves processed visitors to ride history
     * 4. Increments the total cycle count
     */
    void runOneCycle();
}