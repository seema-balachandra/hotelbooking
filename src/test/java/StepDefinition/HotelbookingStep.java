package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Pages.HotelbookingPage;
import managers.PageObjectManager;
import managers.WebDriverManager;
import cucumber.TestContext;

	


public class HotelbookingStep {
	TestContext testContext;
	HotelbookingPage hotel;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	
	public HotelbookingStep(TestContext context){
		testContext = context;
		hotel = testContext.getPageObjectManager().getHotelbookingPage();
	}


@Given("^I am on the hotel booking application$")
public void i_am_on_the_hotel_booking_application(){
	hotel.navigateTo_HomePage();

}

@When("^I enter \"([^\"]*)\" into Firstname$")
public void i_enter_into_Firstname(String firstName) {
	hotel.enter_FirstName(firstName);
	
}

@When("^I enter \"([^\"]*)\" into Surname$")
public void i_enter_into_Surname(String surName) {
	hotel.enter_SurName(surName);
    
}

@When("^I enter \"([^\"]*)\" into Price$")
public void i_enter_into_Price(String price) {
	hotel.enter_Price(price);
}

@When("^I choose \"([^\"]*)\" into Deposit$")
public void i_choose_into_Deposit(String diposit) {
	hotel.select_Deposit(diposit);
    
}

@When("^I select \"([^\"]*)\" into Check-in$")
public void i_select_into_Check_in(String chkIn){
    hotel.enter_CheckIn(chkIn);
    
}

@When("^I select \"([^\"]*)\" into Check-out$")
public void i_select_into_Check_out(String chkOut) {
	hotel.enter_CheckOut(chkOut);
}

@When("^I click on Save$")
public void i_click_on_Save() {
    hotel.click_Save();
    
}

@Then("^I should see the record added to the table$")
public void i_should_see_the_record_added_to_the_table() {
	hotel.assertCreateBooking();

}

@When("^I see \"([^\"]*)\" record$")
public void i_see_record(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
}

@When("^I click on first delete button$")
public void i_click_on_first_delete_button() {
   hotel.clickDelete(); 
}

@Then("^I should see record deleted from the table$")
public void record_delete_from_the_table() {
	hotel.assertDeleteBooking();
}


	}
