// Part 4B: Comparator to sort Visitor objects (Name → Ticket ID)
import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // 1. Primary sort: Name (ascending alphabetical order)
        int nameComparison = v1.getName().compareTo(v2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }
        // 2. Secondary sort: Ticket ID (ascending) (for duplicate names)
        return v1.getTicketId().compareTo(v2.getTicketId());
    }
}
