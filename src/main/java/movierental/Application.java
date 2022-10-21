package movierental;

import movierental.pricecodes.RegularPriceCode;

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
