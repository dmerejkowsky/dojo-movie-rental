package movierental;

public class RegularPrice implements Price {
  @Override
  public double getCharge(int daysRented) {
    double charge = 2;
    if (daysRented > 2)
      charge += (daysRented - 2) * 1.5;
    return charge;
  }
}
