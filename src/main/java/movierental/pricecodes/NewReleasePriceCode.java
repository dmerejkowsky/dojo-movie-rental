package movierental.pricecodes;

public class NewReleasePriceCode implements PriceCode {
  @Override
  public double getCharge(int daysRented) {
    return daysRented * 3;
  }

  @Override
  public int getFrequentRenterPoints(int daysRented) {
    return daysRented > 1 ? 2 : 1;
  }

}
