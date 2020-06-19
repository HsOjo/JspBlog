package dao.base;

public class Order {
    public static final String ASC = "ASC";
    public static final String DESC = "DESC";

    public String column;
    public String order;

    public Order(String column, String order) {
        this.column = column;
        this.order = order;
    }

    public static Order by(String column, String order) {
        return new Order(column, order);
    }
}
