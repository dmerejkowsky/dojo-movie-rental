package movierental.pricecodes;

public class NewReleasePriceCode implements PriceCode {
  @Override
  public double getCharge(int daysRented) {
    return daysRented * 3;
  }

  @Override
  public int getFrequentRenterPoints(int daysRented) {
    if (daysRented > 1) {
      return 2;
    } else {
      return 1;
    }
  }

}
