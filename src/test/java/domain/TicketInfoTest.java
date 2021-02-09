package domain;

import manager.TicketInfoManager;
import org.junit.jupiter.api.Test;
import repository.TicketInfoRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketInfoTest {
    private TicketInfo[] ticketInfo;
    private TicketInfoManager manager = new TicketInfoManager(new TicketInfoRepository());
    private TicketInfoRepository ticketInfoRepository = new TicketInfoRepository();

    @Test
    public void shouldSortByPrice() {
        ticketInfo = new TicketInfo[6];
        ticketInfo[0] = new TicketInfo(1, 3706, "DME", "KGD", 125);
        ticketInfo[1] = new TicketInfo(2, 2499, "VKO", "KGD", 120);
        ticketInfo[2] = new TicketInfo(3, 2931, "DME", "KGD", 120);
        ticketInfo[3] = new TicketInfo(4, 3031, "DME", "KGD", 125);
        ticketInfo[4] = new TicketInfo(5, 2130, "DME", "KGD", 120);
        ticketInfo[5] = new TicketInfo(6, 3985, "VKO", "KGD", 120);

        for (int i = 0; i < 6; i++) {
            manager.add(ticketInfo[i]);
        }

        TicketInfo[] expected = new TicketInfo[]{ticketInfo[4], ticketInfo[2], ticketInfo[3], ticketInfo[0]};
        TicketInfo[] actual = manager.searchBy("DME", "KGD");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void sortingByThePriceOfAnEmptySet() {
        ticketInfo = new TicketInfo[0];

        TicketInfo[] expected = new TicketInfo[]{};
        TicketInfo[] actual = manager.searchBy("DME", "KGD");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void sortingByPriceOfASetOfOneItem() {
        ticketInfo = new TicketInfo[1];
        ticketInfo[0] = new TicketInfo(1, 3706, "DME", "KGD", 125);

        for (int i = 0; i < 1; i++) {
            manager.add(ticketInfo[i]);
        }

        TicketInfo[] expected = new TicketInfo[]{ticketInfo[0]};
        TicketInfo[] actual = manager.searchBy("DME", "KGD");

        assertArrayEquals(expected, actual);
    }
}