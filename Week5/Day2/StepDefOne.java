package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefOne {
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
        System.out.println("Given method");
	}
	@When("the user enters username as demosalesmanager")
	public void the_user_enters_username_as_demosalesmanager() {
		System.out.println("when user enters username");
	}
	@When("the user enters password as crmsfa")
	public void the_user_enters_password_as_crmsfa() {
		System.out.println("when user enters password");
	}
	@When("the user clicks the login button")
	public void the_user_clicks_the_login_button() {
		System.out.println("when user click login button");
	}
	@Then("the user should be redirected to welcome page")
	public void the_user_should_be_redirected_to_welcome_page() {
		System.out.println("then directed to welcome page");
	}
	@Then("user should view the welcome message")
	public void user_should_view_the_welcome_message() {
		System.out.println("then view welcome message");
	}
	@Given("the user in on the login page")
	public void the_user_in_on_the_login_page() {
		System.out.println("given login page for negative scenario");
	}
	@When("the user enters password as crms")
	public void the_user_enters_password_as_crms() {
		System.out.println("when user enters password");
	}
	@When("the user should not to redirected to welcome page")
	public void the_user_should_not_to_redirected_to_welcome_page() {
		System.out.println("when user not redirected to welcome page");
	}
}
