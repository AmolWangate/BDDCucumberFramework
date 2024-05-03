package com.test.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.enums.WaitType;
import com.test.utils.DriverUtilites;

public class TestPage {

	@FindBy(xpath = "//div[@class='login_logo']")
	private WebElement logo;

	@FindBy(xpath = "//input[@data-test='username']")
	private WebElement inputUserName;

	@FindBy(xpath = "//input[@data-test='password']")
	private WebElement inputUserPwd;

	@FindBy(xpath = "//input[@data-test='login-button']")
	private WebElement btnLogin;

	@FindBy(xpath = "//h3[@data-test='error']")
	private WebElement titleLoginError;

	@FindBy(xpath = "//span[@data-test='title']")
	private WebElement titleProducts;

	public TestPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public boolean isLogoDisplayed() {
		return DriverUtilites.isDisplayed(logo, WaitType.VISIBLE, "logo on login page");
	}

	public TestPage sendUserName(String userName) {
		DriverUtilites.sendKeys(inputUserName, WaitType.VISIBLE, userName, "user name");
		return this;
	}

	public TestPage sendUserPwd(String userPwd) {
		DriverUtilites.sendKeys(inputUserPwd, WaitType.VISIBLE, userPwd, "user password");
		return this;
	}

	public void clickLoginBtn() {
		DriverUtilites.click(btnLogin, WaitType.CLICKABLE, "login button");
	}

	public String getProductsTitle() {
		return DriverUtilites.getText(titleProducts, WaitType.VISIBLE, "products title");
	}

	public boolean isErrorMessageDisplayed() {
		return DriverUtilites.isDisplayed(titleLoginError, WaitType.VISIBLE, "Error message on login page");
	}

}
