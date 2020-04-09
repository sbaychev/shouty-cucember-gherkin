package shouty;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;

import static java.util.Collections.emptyMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class ShoutSteps {

    private static final String ARBITRARY_MESSAGE = "Hello, world";
    private final Shouty shouty = new Shouty();

    @Given("{word} is at {int}, {int}")
    public void lucy_is_at(String name, int xCoord, int yCoord) {
        shouty.setLocation(name, new Coordinate(xCoord, yCoord));
    }

    @When("{word} shouts")
    public void sean_shouts(String name) {
        shouty.shout(name, ARBITRARY_MESSAGE);
    }

    @Then("{word} should hear Sean")
    public void lucy_should_hear_sean(String shout_hear) {
        assertEquals(1, shouty.getShoutsHeardBy(shout_hear).size());
    }

    @Then("{word} should hear nothing")
    public void lucy_should_hear_nothing(String shout_consumer) {
        assertEquals(emptyMap(), shouty.getShoutsHeardBy(shout_consumer));
    }

    @Then("{word} should not hear {word}")
    public void lucyShouldNotHearOscar(String shout_consumer, String shout_producer) {
        assertFalse(shouty.getShoutsHeardBy(shout_consumer).containsKey(shout_producer));
    }

    @Then("Lucy should shout at Oscar")
    public void lucyShouldShoutAtOscar() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("people are located at")
    public void peopleAreLocatedAt(List<PersonLocation> dataTable) {

        dataTable.forEach(
                row -> lucy_is_at(row.getName(),
                        row.getxCoord(),
                        row.getyCoord()));
    }

//    @Then("{word} should not hear {word}")
//    public void lucyShouldNotHearOscar(String shout_consumer,  String shout_producer) {
//        assertFalse(shouty.getShoutsHeardBy(shout_consumer).containsKey(shout_producer));
//    }

    static class PersonLocation {

        String name;
        int xCoord;
        int yCoord;

        public PersonLocation(String name, int xCoord, int yCoord) {
            this.name = name;
            this.xCoord = xCoord;
            this.yCoord = yCoord;
        }

        public String getName() {
            return name;
        }

        public PersonLocation setName(String name) {
            this.name = name;
            return this;
        }

        public int getxCoord() {
            return xCoord;
        }

        public PersonLocation setxCoord(int xCoord) {
            this.xCoord = xCoord;
            return this;
        }

        public int getyCoord() {
            return yCoord;
        }

        public PersonLocation setyCoord(int yCoord) {
            this.yCoord = yCoord;
            return this;
        }
    }
}
