package movierental;

public class TextReport extends Report {

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
    result += "Amount owed is " + totalCharge() + "\n";
    result += "You earned " + totalFrequentRenterPoints() + " frequent renter points";
    return result;
  }


}
