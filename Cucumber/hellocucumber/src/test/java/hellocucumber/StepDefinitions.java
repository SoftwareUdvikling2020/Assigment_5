package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class StepDefinitions {

    private String time;
    private String actualAnswer;

    @Given("time is over {string}")
    public void time_is(String today) {
        this.time = today;
    }

    @When("I ask whether it's over 20")
    public void i_ask_whether_it_s_20() {
        actualAnswer = IsIt20.isIt20(time);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

    @Given("you can relax now")
    public void time_is_now_20() {
        time = "20";
    }

}

class IsIt20 {
    static String isIt20(String today) {
        return "20".equals(today) ? "relax" : "Nope";
    }
}
