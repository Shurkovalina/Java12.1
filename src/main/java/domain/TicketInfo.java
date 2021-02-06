package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketInfo implements Comparable<TicketInfo>{
    private int id;
    private int price;
    private String from;
    private String to;
    private int travelTime;

    @Override
    public int compareTo(TicketInfo o) {
        return this.price - o.price;
    }
}
