package repository;

import domain.TicketInfo;

public class TicketInfoRepository {
    private TicketInfo[] items = new TicketInfo[0];

    public void save(TicketInfo item) {
        int length = items.length + 1;
        TicketInfo[] tmp = new TicketInfo[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public TicketInfo[] findAll() {
        return items;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        TicketInfo[] tmp = new TicketInfo[length];
        int index = 0;
        for (TicketInfo item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}
