package movierental.pricecodes;

public interface PriceCode {
  double getCharge(int daysRented);

  default int getFrequentRenterPoints(int daysRented) {
    return 1;
  }

}
