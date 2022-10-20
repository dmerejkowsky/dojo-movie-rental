package movierental;

public class Movie {

  public static final int CHILDRENS = 2;
  public static final int NEW_RELEASE = 1;
  public static final int REGULAR = 0;

  private final String _title;
  private final int _priceCode;

  public Movie(String title, int priceCode) {
    _title = title;
    _priceCode = priceCode;
  }

  double regularPrice(int daysRented) {
    double charge = 0;
    charge += 2;
    if (daysRented > 2)
      charge += (daysRented - 2) * 1.5;
    return charge;
  }

  double getCharge(int daysRented) {
    double charge = 0;
    switch (getPriceCode()) {
      case Movie.REGULAR:
        return regularPrice(daysRented);
      case Movie.NEW_RELEASE:
        charge += daysRented * 3;
        break;
      case Movie.CHILDRENS:
        charge += 1.5;
        if (daysRented > 3)
          charge += (daysRented - 3) * 1.5;
        break;
    }
    return charge;
  }

  int getFrequentRenterPoints(int daysRented) {
    // add bonus for a two-day new release rental
    if ((getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
      return 2;
    } else {
      return 1;
    }
  }

  public int getPriceCode() {
    return _priceCode;
  }

  public String getTitle() {
    return _title;
  }

}
