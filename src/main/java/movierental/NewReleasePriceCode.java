package movierental;

public class NewReleasePriceCode implements PriceCode {
  @Override
  public double getCharge(int daysRented) {
    return daysRented * 3;
  }
}
