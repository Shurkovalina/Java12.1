package manager;

import domain.TicketInfo;
import repository.TicketInfoRepository;

import java.util.Arrays;

public class TicketInfoManager {
    private TicketInfoRepository repository;

    public TicketInfoManager(TicketInfoRepository repository) {
        this.repository = repository;
    }

    public TicketInfo[] items = new TicketInfo[0];

    public void add(TicketInfo item) {
        repository.save(item);
    }

    public TicketInfo[] searchBy(String from, String to) {
        TicketInfo[] result = new TicketInfo[0];
        for (TicketInfo ticketInfo : repository.findAll(from,to)) {
            if (matches(ticketInfo, from, to)) {
                TicketInfo[] tmp = new TicketInfo[result.length + 1];
                System.arraycopy(items, 0, tmp, 0, items.length);
                int lastIndex = tmp.length - 1;
                tmp[tmp.length - 1] = ticketInfo;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(TicketInfo ticketInfo, String search1, String search2) {
        if (ticketInfo.getFrom().equalsIgnoreCase(search1)) {
            return true;
        }
        if (ticketInfo.getTo().equalsIgnoreCase(search2)) {
            return true;
        }
        return true;
    }

}
