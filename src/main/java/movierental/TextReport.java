package movierental;

public class TextReport {
  public String getHeader(String name) {
    return "Rental Record for " + name + "\n";
  }

  public String getRow(Rental rental) {
    var movie = rental.getMovie();
    double charge = rental.getCharge();
    return "\t" + movie.getTitle() + "\t" + charge + "\n";
  }

  public String getFooter(double totalAmount, int frequentRenterPoints) {
    String result = "";
    result += "Amount owed is " + totalAmount + "\n";
    result += "You earned " + frequentRenterPoints + " frequent renter points";
    return result;
  }

}
