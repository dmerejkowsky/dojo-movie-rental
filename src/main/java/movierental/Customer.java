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
    String result = getHeader();
    for (Rental rental : _rentals) {
      result += getRow(rental);
    }
    result += getFooter();
    return result;
  }

  private String getFooter() {
    String result = "";
    double totalAmount = getTotalCharge();
    int frequentRenterPoints = getTotalFrequentRenterPoints();

    // add footer lines
    result += "Amount owed is " + totalAmount + "\n";
    result += "You earned " + frequentRenterPoints + " frequent renter points";
    return result;
  }

  private String getHeader() {
    return "Rental Record for " + getName() + "\n";
  }

  private String getRow(Rental rental) {
    var movie = rental.getMovie();
    double charge = rental.getCharge();
    return "\t" + movie.getTitle() + "\t" + charge + "\n";
  }

  public double getTotalCharge() {
    return _rentals.stream().mapToDouble(Rental::getCharge).sum();
  }

  public int getTotalFrequentRenterPoints() {
    return _rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
  }

}
