package gvrp;

public class Customer {

	CustomerSet set;
	Point pos;
	int id;
	
	public Customer(int id) {
		this.id = id;
	}
	
	public int getDemand() {
		return set.getDemand();
	}
	
	public void setSet(CustomerSet set) {
		this.set = set;
	}
	
	public void setPosition(Point pos) {
		this.pos = pos;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Customer) {
			Customer customer = (Customer) o;
			return customer.id == this.id;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return id;
	}
	
	@Override
	public String toString() {
		return String.format("C%d = %s", id, pos.toString());
	}
	
}
