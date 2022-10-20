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
    var textReport = new TextReport();
    String result = textReport.getHeader(getName());
    for (Rental rental : _rentals) {
      result += textReport.getRow(rental);
    }
    result += textReport.getFooter(getTotalCharge(), getTotalFrequentRenterPoints());
    return result;
  }


  public double getTotalCharge() {
    return _rentals.stream().mapToDouble(Rental::getCharge).sum();
  }

  public int getTotalFrequentRenterPoints() {
    return _rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
  }

}
