package movierental;

import java.util.List;

public class TextReport {
  private final List<Rental> _rentals;
  private final String _name;

  public TextReport(String customerName, List<Rental> rentals) {
    _name = customerName;
    _rentals = rentals;
  }

  public String getStatement() {
    String result = getHeader();
    for (Rental rental : _rentals) {
      result += getRow(rental);
    }
    result += getFooter();
    return result;
  }

  public String getHeader() {
    return "Rental Record for " + _name + "\n";
  }

  public String getRow(Rental rental) {
    var movie = rental.getMovie();
    double charge = rental.getCharge();
    return "\t" + movie.getTitle() + "\t" + charge + "\n";
  }

  public String getFooter() {
    String result = "";
    result += "Amount owed is " + getTotalCharge() + "\n";
    result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
    return result;
  }


  public double getTotalCharge() {
    return _rentals.stream().mapToDouble(Rental::getCharge).sum();
  }

  public int getTotalFrequentRenterPoints() {
    return _rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
  }


}
