package manager;

import domain.TicketInfo;
import repository.TicketInfoRepository;

import java.util.Arrays;

public class TicketInfoManager {
    private TicketInfoRepository repository;

    public TicketInfoManager(TicketInfoRepository repository) {
        this.repository = repository;
    }

    public void add(TicketInfo item) {
        repository.save(item);
    }

    public TicketInfo[] searchBy(String text1, String text2) {
        TicketInfo[] result = new TicketInfo[0];
        for (TicketInfo ticketInfo : repository.findAll()) {
            if (matches(ticketInfo, text1, text2)) {
                TicketInfo[] tmp = new TicketInfo[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[tmp.length - 1] = ticketInfo;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(TicketInfo ticketInfo, String search1, String search2) {
        if (ticketInfo.getFrom().equalsIgnoreCase(search1) && (ticketInfo.getTo().equalsIgnoreCase(search2))) {
            return true;
        }
        return false;
    }

}
