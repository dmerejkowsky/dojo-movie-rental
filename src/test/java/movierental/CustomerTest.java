package movierental;

import movierental.pricecodes.ChildrenPriceCode;
import movierental.pricecodes.NewReleasePriceCode;
import movierental.pricecodes.RegularPriceCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerTest {

  private final RegularPriceCode REGULAR = new RegularPriceCode();
  private final Movie GONE_WITH_THE_WIND = new Movie("Gone with the Wind", REGULAR);
  private final NewReleasePriceCode NEW_RELEASE = new NewReleasePriceCode();
  private final ChildrenPriceCode CHILDREN = new ChildrenPriceCode();
  private final Movie MADAGASCAR = new Movie("Madagascar", CHILDREN);
  private final Movie STAR_WARS = new Movie("Star Wars", NEW_RELEASE);

  @Test
  public void testCustomer() {
    Customer c = new CustomerBuilder().build();
    assertNotNull(c);
  }

  @Test
  public void testAddRental() {
    Customer julia = new CustomerBuilder().withName("Julia").build();
    Rental rental = new Rental(GONE_WITH_THE_WIND, 3);
    julia.addRental(rental);
  }

  @Test
  public void testGetName() {
    Customer c = new Customer("David");
    assertEquals("David", c.getName());
  }

  @Test
  public void statementForRegularMovie() {
    // 3 day rental
    Customer sallie =
      new CustomerBuilder()
        .withName("Sallie")
        .withRentals(new Rental(GONE_WITH_THE_WIND, 3))
        .build();
    String expected = "Rental Record for Sallie\n" +
      "\tGone with the Wind\t3.5\n" +
      "Amount owed is 3.5\n" +
      "You earned 1 frequent renter points";
    String statement = sallie.statement();
    assertEquals(expected, statement);
  }

  @Test
  public void statementForNewReleaseMovie() {
    // 3 day rental
    Customer sallie =
      new CustomerBuilder()
        .withName("Sallie")
        .withRentals(new Rental(STAR_WARS, 3))
        .build();
    String expected = "Rental Record for Sallie\n" +
      "\tStar Wars\t9.0\n" +
      "Amount owed is 9.0\n" +
      "You earned 2 frequent renter points";
    String statement = sallie.statement();
    assertEquals(expected, statement);
  }

  @Test
  public void statementForChildrensMovie() {
    // 3 day rental
    Customer sallie
      = new CustomerBuilder()
      .withName("Sallie")
      .withRentals(new Rental(MADAGASCAR, 3))
      .build();
    String expected = "Rental Record for Sallie\n" +
      "\tMadagascar\t1.5\n" +
      "Amount owed is 1.5\n" +
      "You earned 1 frequent renter points";
    String statement = sallie.statement();
    assertEquals(expected, statement);
  }

  @Test
  public void statementForManyMovies() {

    Customer david
      = new CustomerBuilder()
      .withName("David")
      .withRentals(
        new Rental(MADAGASCAR, 6),
        new Rental(STAR_WARS, 2),
        new Rental(GONE_WITH_THE_WIND, 8)
      )
      .build();
    String expected = "Rental Record for David\n" +
      "\tMadagascar\t6.0\n" +
      "\tStar Wars\t6.0\n" +
      "\tGone with the Wind\t11.0\n" +
      "Amount owed is 23.0\n" +
      "You earned 4 frequent renter points";
    String statement = david.statement();
    assertEquals(expected, statement);
  }
}
