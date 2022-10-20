package movierental.pricecodes;

import movierental.Customer;
import movierental.HTMLReport;
import movierental.Movie;
import movierental.Rental;

public class Application {
  public static void main(String[] args) {
    var regularPrice = new RegularPriceCode();
    var movie = new Movie("Gone with the Wind", regularPrice);
    var customer = new Customer("Sallie");
    var rental = new Rental(movie, 3);
    customer.addRental(rental);
    var html = new HTMLReport(customer).generate();
    System.out.println(html);
  }
}
