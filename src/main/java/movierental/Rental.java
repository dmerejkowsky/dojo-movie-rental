package movierental;

public class Rental {

  private final Movie _movie;
  private final int _daysRented;

  public Rental(Movie movie, int daysRented) {
    _movie = movie;
    _daysRented = daysRented;
  }

  int getFrequentRenterPoints() {
    // add bonus for a two-day new release rental
    if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && _daysRented > 1)
      return 2;
    else {
      return 1;
    }
  }

  double getCharge() {
    return _movie.getCharge(_daysRented);
  }

  public int getDaysRented() {
    return _daysRented;
  }

  public Movie getMovie() {
    return _movie;
  }
}
