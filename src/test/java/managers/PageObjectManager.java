package managers;

import org.openqa.selenium.WebDriver;
import Pages.HotelbookingPage;

public class PageObjectManager {
	private WebDriver driver;
	private HotelbookingPage hotel;
	
	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}
	
	public HotelbookingPage getHotelbookingPage(){

		return (hotel == null) ? hotel = new HotelbookingPage(driver) : hotel;

	}

}
