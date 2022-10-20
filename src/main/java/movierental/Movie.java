package movierental;

public class Movie {

  public static final int CHILDRENS = 2;
  public static final int NEW_RELEASE = 1;
  public static final int REGULAR = 0;

  private final String _title;
  private final PriceCode _priceCode;

  public Movie(String title, PriceCode priceCode) {
    _title = title;
    _priceCode = priceCode;
  }


  double getCharge(int daysRented) {
    return _priceCode.getCharge(daysRented);
  }

  int getFrequentRenterPoints(int daysRented) {
    // add bonus for a two-day new release rental
    if ((_priceCode instanceof NewReleasePriceCode) && daysRented > 1) {
      return 2;
    } else {
      return 1;
    }
  }

  public String getTitle() {
    return _title;
  }

}
