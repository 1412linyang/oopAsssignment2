// Part 1: Visitor class (extends Person)
public class Visitor extends Person {
    private String ticketId; // Unique ticket ID (for history tracking)
    private String visitDate; // Visit date (format: yyyy-MM-dd)

    // Default Constructor
    public Visitor() {
        super();
        this.ticketId = "";
        this.visitDate = "";
    }

    // Parameterized Constructor
    public Visitor(String name, int age, String email, String ticketId, String visitDate) {
        super(name, age, email);
        this.ticketId = ticketId;
        this.visitDate = visitDate;
    }

    // Getters and Setters
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }
}