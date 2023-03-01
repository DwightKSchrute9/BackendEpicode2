
package pizzeriaDomain;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class TableOrder<OrderStatus> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int orderNumber;

    private LocalDateTime acquisitionTime;

    private OrderStatus status;

    private int seats;

    private double totalCost;

    @ManyToOne
    private Table table;

    @OneToMany(mappedBy = "order")
    private Set<OrderItem> items;

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public LocalDateTime getAcquisitionTime() {
		return acquisitionTime;
	}

	public void setAcquisitionTime(LocalDateTime acquisitionTime) {
		this.acquisitionTime = acquisitionTime;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

}
