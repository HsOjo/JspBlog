package dao.base;

import java.util.List;

public class Paginate<Entity> {
    private final int current_page;
    private final int max_page;
    private final int per_page;
    private final long count;
    private final List<Entity> items;

    public Paginate(int current_page, int max_page, int per_page, long count, List<Entity> items) {
        this.current_page = current_page;
        this.max_page = max_page;
        this.per_page = per_page;
        this.count = count;
        this.items = items;
    }

    public int getCurrentPage() {
        return current_page;
    }

    public int getMaxPage() {
        return max_page;
    }

    public int getPerPage() {
        return per_page;
    }

    public long getCount() {
        return count;
    }

    public List<Entity> getItems() {
        return items;
    }
}
