package movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

  private final String _name;
  private final List<Rental> _rentals = new ArrayList<>();

  public Customer(String name) {
    _name = name;
  }

  public void addRental(Rental arg) {
    _rentals.add(arg);
  }

  public String getName() {
    return _name;
  }

  public String statement() {
    String result = "Rental Record for " + getName() + "\n";

    for (Rental rental : _rentals) {
      // show figures for this rental
      double charge = rental.getCharge();
      result += "\t" + rental.getMovie().getTitle() + "\t" + charge + "\n";
    }

    double totalAmount = getTotalCharge();
    int frequentRenterPoints = getTotalFrequentRenterPoints();
    
    // add footer lines
    result += "Amount owed is " + totalAmount + "\n";
    result += "You earned " + frequentRenterPoints + " frequent renter points";

    return result;
  }

  public double getTotalCharge() {
    return _rentals.stream().mapToDouble(Rental::getCharge).sum();
  }

  public int getTotalFrequentRenterPoints() {
    return _rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
  }

}
