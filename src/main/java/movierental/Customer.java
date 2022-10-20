package movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

  private final String _name;
  private final List<Rental> _rentals = new ArrayList<>();

  public Customer(String name) {
    _name = name;
  }


  public void addRental(Rental arg) {
    _rentals.add(arg);
  }

  public String getName() {
    return _name;
  }

  public String statement(Report report) {
    report.setCustomerName(_name);
    report.setRentals(_rentals);
    return report.generate();
  }
}
