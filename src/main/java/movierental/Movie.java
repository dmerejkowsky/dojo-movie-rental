package movierental;

public class Movie {

  public static final int CHILDRENS = 2;
  public static final int NEW_RELEASE = 1;
  public static final int REGULAR = 0;

  private final String _title;
  private final int _priceCodeInt;
  private final PriceCode _priceCode;

  public Movie(String title, int priceCode) {
    _title = title;
    _priceCodeInt = priceCode;
    _priceCode = switch (priceCode) {
      case REGULAR -> new RegularPriceCode();
      case CHILDRENS -> new ChildrenPriceCode();
      case NEW_RELEASE -> new NewReleasePriceCode();
      default -> throw new IllegalArgumentException();
    };
  }


  double getCharge(int daysRented) {
    return _priceCode.getCharge(daysRented);
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
    return _priceCodeInt;
  }

  public String getTitle() {
    return _title;
  }

}
