package shouty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertEquals;


public class ShoutSteps {

    private static final String ARBITRARY_MESSAGE = "Hello, world";
    private final Shouty shouty = new Shouty();

    @Given("{string} is at {int}, {int}")
    public void lucy_is_at(String name, int xCoord, int yCoord) {
        shouty.setLocation(name, new Coordinate(xCoord, yCoord));
    }

//    @Given("{string} is at {int}, {int}")
//    public void sean_is_at(String name, int xCoord, int yCoord) {
//        shouty.setLocation(name, new Coordinate(xCoord, yCoord));
//    }

    @When("{string} shouts")
    public void sean_shouts(String name) {
        shouty.shout(name, ARBITRARY_MESSAGE);
    }

    @Then("{string} should hear Sean")
    public void lucy_should_hear_sean(String shout_hear) {
        assertEquals(1, shouty.getShoutsHeardBy(shout_hear).size());
    }

    @Then("Lucy should hear nothing")
    public void lucy_should_hear_nothing() {
        assertEquals(emptyMap(), shouty.getShoutsHeardBy("Lucy"));
    }
}
