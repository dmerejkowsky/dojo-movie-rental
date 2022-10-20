package movierental;

import java.util.List;

public abstract class Report {
  protected final String _customerName;
  private final List<Rental> _rentals;

  public Report(Customer customer) {
    _customerName = customer.getName();
    _rentals = customer.rentals();
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
