package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class StepDefinitions {

    private String time;
    private String actualAnswer;

    @Given("time is over {string}")
    public void today_is(String today) {
        this.time = today;
    }

    @When("I ask whether it's over 20")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = IsItFriday.isItFriday(time);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

    @Given("you can relax now")
    public void today_is_Friday() {
        time = "20";
    }

}

class IsItFriday {
    static String isItFriday(String today) {
        return "20".equals(today) ? "relax" : "Nope";
    }
}
