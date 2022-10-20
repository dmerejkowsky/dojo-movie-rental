package movierental;

import movierental.pricecodes.PriceCode;

public class Movie {
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
    return _priceCode.getFrequentRenterPoints(daysRented);
  }

  public String getTitle() {
    return _title;
  }

}
