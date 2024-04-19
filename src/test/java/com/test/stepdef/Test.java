package com.test.stepdef;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.test.manager.TestContextManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test {

	TestContextManager manager;

	private static final Logger LOG = LogManager.getLogger();

	public Test(TestContextManager manager) {
		this.manager = manager;
	}

	@Given("I'm on the home page.")
	public void i_m_on_the_home_page() {

	}

	@When("I enter userID as {string} and passwor as {string}")
	public void i_enter_user_id_as_and_passwor_as(String userName, String userPwd) {
		manager.pageManager.getTestPage().sendUserName(userName).sendUserPwd(userPwd);
	}

	@And("I click on login button")
	public void i_click_on_login_button() {
		manager.pageManager.getTestPage().clickLoginBtn();
	}

	@Then("I'm logged in")
	public void i_m_logged_in() {
		String title = manager.pageManager.getTestPage().getProductsTitle();
		assertThat(title).isEqualTo("Product");
	}

	@Then("I'm not logged in")
	public void i_m_not_logged_in() {
		String title = manager.pageManager.getTestPage().getProductsTitle();
		assertThat(title).isNotNull().isEqualTo("Products");
	}

	@When("I enter userID and password")
	public void iEnterUserIDAndPassword(DataTable dataTable) {
		List<Map<String, String>> map = dataTable.asMaps(String.class, String.class);
		manager.pageManager.getTestPage().sendUserName(map.get(0).get("username")).sendUserPwd(map.get(0).get("password"));
	}

}
