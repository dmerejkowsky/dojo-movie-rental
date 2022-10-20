package movierental;

public class Rental {

  private final Movie _movie;
  private final int _daysRented;

  public Rental(Movie movie, int daysRented) {
    _movie = movie;
    _daysRented = daysRented;
  }

  static int getFrequentRenterPoints(Rental rental) {
    int frequentRenterPoints = 0;

    // add frequent renter points
    frequentRenterPoints++;
    // add bonus for a two day new release rental
    if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
      frequentRenterPoints++;

    return frequentRenterPoints;
  }

  double getCharge() {
    double charge = 0;
    switch (getMovie().getPriceCode()) {
      case Movie.REGULAR:
        charge += 2;
        if (getDaysRented() > 2)
          charge += (getDaysRented() - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        charge += getDaysRented() * 3;
        break;
      case Movie.CHILDRENS:
        charge += 1.5;
        if (getDaysRented() > 3)
          charge += (getDaysRented() - 3) * 1.5;
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
