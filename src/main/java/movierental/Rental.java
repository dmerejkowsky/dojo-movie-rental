package movierental;

public class Rental {

  private final Movie _movie;
  private final int _daysRented;

  public Rental(Movie movie, int daysRented) {
    _movie = movie;
    _daysRented = daysRented;
  }

  static double getAmount(Rental rental) {
    double amount = 0;
    switch (rental.getMovie().getPriceCode()) {
      case Movie.REGULAR:
        amount += 2;
        if (rental.getDaysRented() > 2)
          amount += (rental.getDaysRented() - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        amount += rental.getDaysRented() * 3;
        break;
      case Movie.CHILDRENS:
        amount += 1.5;
        if (rental.getDaysRented() > 3)
          amount += (rental.getDaysRented() - 3) * 1.5;
        break;
    }
    return amount;
  }

  public int getDaysRented() {
    return _daysRented;
  }

  public Movie getMovie() {
    return _movie;
  }
}
