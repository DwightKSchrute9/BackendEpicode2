package pizzeriaDomain;

import java.math.BigDecimal;

public class OrderItem {
    
    private MenuItem menuItem;
    private BigDecimal price;
    private String note;
    private int quantity;
    
    public OrderItem(MenuItem menuItem, BigDecimal price, String note, int quantity) {
        this.menuItem = menuItem;
        this.price = price;
        this.note = note;
        this.quantity = quantity;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public BigDecimal getTotalPrice() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
    
}
