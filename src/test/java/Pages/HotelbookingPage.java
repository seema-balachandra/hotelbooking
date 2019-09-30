package Pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import managers.FileReaderManager;



public class HotelbookingPage {
	WebDriver driver;
    private static int bookingCountBeforeCreatingANewBooking = 0;


	
	public HotelbookingPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "firstname") 
	 private WebElement FirstName;
	
	@FindBy(how = How.ID, using = "lastname") 
	 private WebElement SurName;
	
	@FindBy(how = How.ID, using = "totalprice") 
	 private WebElement Price;
	
	@FindBy(how = How.ID, using = "depositpaid") 
	 private WebElement Diposit;
	
	@FindBy(how = How.ID, using = "checkin") 
	 private WebElement CheckIn;
	
	@FindBy(how = How.ID, using = "checkout") 
	 private WebElement CheckOut;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='form']/div/div[7]/input") 
	 private WebElement SaveBtn;
	
	@FindAll(@FindBy(how = How.ID, using = "depositpaid"))
	private List<WebElement> diposit_List;
	
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@id='bookings']/div"))
	private List<WebElement> recordcount;
	
	@FindBy(how = How.XPATH, using = "//div[@id='bookings']/div[2]/div/input[@value='Delete']")
	private WebElement deleteButton;
	
	public void enter_FirstName(String fName){
		FirstName.sendKeys(fName);
	}
	
	public void enter_SurName(String sName){
		SurName.sendKeys(sName);
	}
	
	public void enter_Price(String pr){
		Price.sendKeys(pr);
	}
	
	public void enter_Deposit(String d){
		Diposit.sendKeys(d);
	}
	
	public void enter_CheckIn(String chkIn){
		CheckIn.sendKeys(chkIn);
	}
	
	public void enter_CheckOut(String chkOut){
		CheckOut.sendKeys(chkOut);
	}
	
	private int findNumberOfExistingBookings() {
       // waitForElement(driver, By.xpath("//input[@value = 'Delete']"));
        return recordcount.size();
    }
	
	public void assertCreateBooking() {
        driver.navigate().refresh();
        System.out.println("Bookings count after new booking " + findNumberOfExistingBookings());
        //Assert.assertArrayEquals(expecteds, actuals);
        assertTrue("Booking creation failed", findNumberOfExistingBookings() - bookingCountBeforeCreatingANewBooking >= 1);
        System.out.println("Booking created sucessfully");
    }
	
	public void assertDeleteBooking(){
		driver.navigate().refresh();
        System.out.println("Bookings count after new booking " + findNumberOfExistingBookings());
        //Assert.assertArrayEquals(expecteds, actuals);
        assertTrue("Booking deletion failed", findNumberOfExistingBookings() > bookingCountBeforeCreatingANewBooking);
        System.out.println("Booking deleted sucessfully");	
	}
	
	
	public void clickDelete(){
		deleteButton.click();	
	}
	
	public void click_Save(){
		SaveBtn.click();
	}
	
	public void select_Deposit(String diposit) {
		 if(diposit.equals("true")) {
			 diposit_List.get(0).click();
		 }else if(diposit.equals("false")) {
			 diposit_List.get(1).click();
		 }else {
		 new Exception("Diposit not recognised : " + diposit);
		 }
		 try { Thread.sleep(3000);}
		 catch (InterruptedException e) {}
		 
		 }
	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

	

}
