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

  static double getCharge(Movie movie, int _daysRented) {
    double charge = 0;
    switch (movie.getPriceCode()) {
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

  public int getPriceCode() {
    return _priceCode;
  }

  public String getTitle() {
    return _title;
  }

}
