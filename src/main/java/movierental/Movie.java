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
  

  double getCharge(int daysRented) {
    double charge = 0;
    return switch (getPriceCode()) {
      case Movie.REGULAR -> new RegularPriceCode().getCharge(daysRented);
      case Movie.NEW_RELEASE -> new NewReleasePriceCode().getCharge(daysRented);
      case Movie.CHILDRENS -> new ChildrenPriceCode().getCharge(daysRented);
      default -> charge;
    };
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
