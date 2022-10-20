package movierental;

import java.util.List;

public class TextReport extends Report {

  public TextReport(String customerName, List<Rental> rentals) {
    super(rentals, customerName);
  }

  @Override
  public String header() {
    return "Rental Record for " + _customerName + "\n";
  }

  @Override
  public String row(Rental rental) {
    var movie = rental.getMovie();
    double charge = rental.getCharge();
    return "\t" + movie.getTitle() + "\t" + charge + "\n";
  }

  @Override
  public String footer() {
    String result = "";
    result += "Amount owed is " + getTotalCharge() + "\n";
    result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
    return result;
  }


}
