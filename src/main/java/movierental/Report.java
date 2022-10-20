package movierental;

import java.util.List;

public abstract class Report {
  protected final List<Rental> _rentals;
  protected final String _customerName;

  public Report(List<Rental> rentals, String customerName) {
    _rentals = rentals;
    _customerName = customerName;
  }

  public abstract String header();

  public abstract String footer();

  public abstract String row(Rental rental);

  public String statement() {
    String result = header();
    for (Rental rental : _rentals) {
      result += row(rental);
    }
    result += footer();
    return result;
  }


  public double getTotalCharge() {
    return _rentals.stream().mapToDouble(Rental::getCharge).sum();
  }

  public int getTotalFrequentRenterPoints() {
    return _rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
  }
}
