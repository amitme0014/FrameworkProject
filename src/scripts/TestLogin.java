package scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestLogin extends BaseTest{
	@Test
	public void testLogin() throws InterruptedException{
		LoginPage l=new LoginPage(driver);
		String un=Lib.getCellValue(EXCEL_PATH, "Validlogin",1,0);
		String pw=Lib.getCellValue(EXCEL_PATH, "Validlogin", 1,1);
		String expectedTitle=Lib.getCellValue(EXCEL_PATH, "Validlogin", 1, 2);
		l.setUsername(un);
		l.setPassword(pw);
		l.clickLogin();
		Thread.sleep(6000);
		String actualtitle=driver.getTitle();
		SoftAssert s=new SoftAssert();
		s.assertEquals(actualtitle, expectedTitle);
		s.assertAll();
	}
}
