package movierental;

public class Rental {

  private final Movie _movie;
  private final int _daysRented;

  public Rental(Movie movie, int daysRented) {
    _movie = movie;
    _daysRented = daysRented;
  }

  int getFrequentRenterPoints() {
    return _movie.getFrequentRenterPoints(_daysRented);
  }

  double getCharge() {
    return _movie.getCharge(_daysRented);
  }

  public int getDaysRented() {
    return _daysRented;
  }

  public Movie getMovie() {
    return _movie;
  }
}
