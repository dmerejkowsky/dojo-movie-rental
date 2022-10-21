package movierental.reports;

import movierental.Customer;
import movierental.Rental;

public class HTMLReport extends Report {
  public HTMLReport(Customer customer) {
    super(customer);
  }

  @Override
  public String header() {
    return String.format("<h1>Report for %s</h1>\n<ul>\n", _customerName);
  }

  @Override
  public String footer() {
    return String.format("</ul>\n<p>Total owed: %.1f, points: %d<p>", totalCharge(), totalFrequentRenterPoints());
  }

  @Override
  public String row(Rental rental) {
    return String.format("<li>%s</li>\n", rental.getMovie().getTitle());
  }
}
