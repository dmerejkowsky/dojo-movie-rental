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
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    String result = "Rental Record for " + getName() + "\n";

    for (Rental rental : _rentals) {

      // add frequent renter points
      frequentRenterPoints++;
      // add bonus for a two day new release rental
      if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
        frequentRenterPoints++;

      // show figures for this rental
      double charge = rental.getCharge();
      result += "\t" + rental.getMovie().getTitle() + "\t" + charge + "\n";
      totalAmount += charge;
    }

    // add footer lines
    result += "Amount owed is " + totalAmount + "\n";
    result += "You earned " + frequentRenterPoints + " frequent renter points";

    return result;
  }

  int getFrequentRenterPoints(Rental rental) {
    int frequentRenterPoints = 0;

    // add frequent renter points
    frequentRenterPoints++;
    // add bonus for a two day new release rental
    if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
      frequentRenterPoints++;

    return frequentRenterPoints;
  }
}
