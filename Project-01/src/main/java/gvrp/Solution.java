package gvrp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringJoiner;

@SuppressWarnings("serial")
public class Solution extends ArrayList<Route> {

	private Instance instance;
	
	/**
	 * @return the instance
	 */
	public Instance getInstance() {
		return instance;
	}

	public Solution(Instance instance) {
		this.instance = instance;
		for (int i = 1; i <= instance.getFleet(); i++) {
			add(new Route(i, instance.getDepot(), instance.getCapacity()));
		}
	}
	
	public boolean isValid(boolean printError) {
		HashSet<Customer> customersInRoutes = new HashSet<Customer>();
		int customerCount = 0;
		for (Route route : this) {
			int customersInRoute = route.size();
			if (route.getCapacity() > instance.getCapacity()) {
				if (printError) System.out.println("Route capacity surpasses maximum");
				return false;
			}
			if (customersInRoute == 0) {
				if (printError) System.out.println("Empty route");
				return false;
			}
			customerCount += customersInRoute;
			customersInRoutes.addAll(route);
			if (customerCount != customersInRoutes.size()) {
				if (printError) System.out.println("Overlapping customer sets");
				return false;
			}
		}
		return true;
	}
	
	public int getCost() {
		int totalCost = 0;
		for (Route route : this) {
			totalCost += route.getCost();
		}
		return totalCost;
	}
	
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner("\n");
		for (Route route : this) {
			sj.add(route.toString());
		}
		return sj.toString();
	}
	
}