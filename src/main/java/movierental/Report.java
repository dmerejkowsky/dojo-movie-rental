package movierental;

import java.util.ArrayList;
import java.util.List;

public abstract class Report {
  protected List<Rental> _rentals = new ArrayList<>();
  protected String _customerName = "";

  public void setRentals(List<Rental> rentals) {
    _rentals = rentals;
  }

  public void setCustomerName(String customerName) {
    _customerName = customerName;
  }

  public abstract String header();

  public abstract String footer();

  public abstract String row(Rental rental);

  public String generate() {
    String result = header();
    for (Rental rental : _rentals) {
      result += row(rental);
    }
    result += footer();
    return result;
  }


  public double totalCharge() {
    return _rentals.stream().mapToDouble(Rental::getCharge).sum();
  }

  public int totalFrequentRenterPoints() {
    return _rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
  }
}
