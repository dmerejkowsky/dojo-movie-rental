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
    double charge = 0;
    switch (getMovie().getPriceCode()) {
      case Movie.REGULAR:
        charge += 2;
        if (_daysRented > 2)
          charge += (_daysRented - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        charge += _daysRented * 3;
        break;
      case Movie.CHILDRENS:
        charge += 1.5;
        if (_daysRented > 3)
          charge += (_daysRented - 3) * 1.5;
        break;
    }
    return charge;
  }

  public int getDaysRented() {
    return _daysRented;
  }

  public Movie getMovie() {
    return _movie;
  }
}
