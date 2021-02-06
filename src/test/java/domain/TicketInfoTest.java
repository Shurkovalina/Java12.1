package domain;

import manager.TicketInfoManager;
import org.junit.jupiter.api.Test;
import repository.TicketInfoRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketInfoTest {

    @Test
    public void shouldSortByPrice() {
        TicketInfoManager manager = new TicketInfoManager(new TicketInfoRepository());
        TicketInfo ticket1 = new TicketInfo(1, 3706, "DME", "KGD", 125);
        TicketInfo ticket2 = new TicketInfo(2, 2499, "VKO", "KGD", 120);
        TicketInfo ticket3 = new TicketInfo(3, 2931, "DME", "KGD", 120);
        TicketInfo ticket4 = new TicketInfo(4, 3031, "DME", "KGD", 125);
        TicketInfo ticket5 = new TicketInfo(5, 2130, "DME", "KGD", 120);
        TicketInfo ticket6 = new TicketInfo(6, 3985, "VKO", "KGD", 120);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        TicketInfo[] expected = new TicketInfo[]{ticket5, ticket3, ticket4, ticket1};
        TicketInfo[] actual = manager.searchBy("DME","KGD");

        assertArrayEquals(expected, actual);
    }

}