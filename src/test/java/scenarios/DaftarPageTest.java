package scenarios;

import org.testng.annotations.*;

import pages.DaftarPage;
import pages.HomePage;
import pages.SuccessDaftarPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;

@Listeners({ScreenshootsListener.class})
@Features("Registrasi Feature")
public class DaftarPageTest extends AndroidSetup{
	private DaftarPage daftarPage;
	private String emailDaftarInvalidFormat="daftar";
	private String emailDaftarValidFormat="daftar@gmail.com";
	private String passwordValid="12345";
	private String konfirmasiPasswordInvalid="54321";
	
	 @Test(priority=1)
	 @Stories("As A User I Will Not Be Able To Register")
	 @TestCaseId("TC_ADR_004_001")
	 @Title("Verify User Not Able to Register with InValid Email Format")
	 public void userNotAbleToRegisterWithWrongEmailFormat(){
		 System.out.println("Verify User Not Able to Register with InValid Email Format");
		 HomePage homepage = new HomePage(driver);
		 homepage.clickLocationNotif();
		 daftarPage = homepage.clickDaftarPage();
		 daftarPage.setElementDaftar();
		 daftarPage.setEmailDaftar(emailDaftarInvalidFormat);
		 daftarPage.clickSetuju();
		 daftarPage.clickSubmitRegister();
		 daftarPage.verifyEmailLoginFormatWrong();
		 daftarPage.clickBackButton();
	 }
	 
	 @Test(priority=2)
	 @Stories("As A User I Will Not Be Able to Register")
	 @TestCaseId("TC_ADR_004_002")
	 @Title("Verify User Not Able to Register with Blank Password")
	 public void userNotAbleToRegisterWithBlankPassword(){
		 System.out.println("Verify User Not Able to Register with Blank Password");
		 HomePage homepage = new HomePage(driver);
		 daftarPage = homepage.clickDaftarPage();
		 daftarPage.setElementDaftar();
		 daftarPage.setEmailDaftar(emailDaftarValidFormat);
		 daftarPage.setPasswordDaftar("");//setBlankPassword
		 daftarPage.clickSetuju();
		 daftarPage.clickSubmitRegister();
	     daftarPage.verifyPasswordCantBeBlank();
	     daftarPage.clickBackButton();
	 }
	 
	 @Test(priority=3)
	 @Stories("As A User I Will Not Be Able to Register")
	 @TestCaseId("TC_ADR_004_003")
	 @Title("Verify User Not Able to Register with Blank Konfirmasi Password")
	 public void userNotAbleToRegisterWithBlankKonfirmasiPassword(){
		 System.out.println("Verify User Not Able to Register with Blank Konfirmasi Password");
		 HomePage homepage = new HomePage(driver);
		 daftarPage = homepage.clickDaftarPage();
		 daftarPage.setElementDaftar();
		 daftarPage.setEmailDaftar(emailDaftarValidFormat);
		 daftarPage.setPasswordDaftar(passwordValid);//setBlankPassword
		 daftarPage.clickSetuju();
		 daftarPage.clickSubmitRegister();
	     daftarPage.verifyKonfirmasiPasswordCantBeBlank();
	     daftarPage.clickBackButton();
	 }
    
	 @Test(priority=4)
	 @Stories("As A User I Will Not Be Able to Register")
	 @TestCaseId("TC_ADR_004_004")
	 @Title("Verify User Not Able to Register with Different Konfirmasi Password")
	 public void userNotAbleToRegisterWithDifferentKonfirmasiPassword(){
		 System.out.println("Verify User Not Able to Register with Different Konfirmasi Password");
		 HomePage homepage = new HomePage(driver);
		 daftarPage = homepage.clickDaftarPage();
		 daftarPage.setElementDaftar();
		 daftarPage.setEmailDaftar(emailDaftarValidFormat);
		 daftarPage.setPasswordDaftar(passwordValid);//setBlankPassword
		 daftarPage.setKonfirmasiPasswordDaftar(konfirmasiPasswordInvalid);
		 daftarPage.clickSetuju();
		 daftarPage.clickSubmitRegister();
	     daftarPage.verifyKonfirmasiPasswordNotSame();
	     daftarPage.clickBackButton();
	 }
	 
	 @Test(priority=5)
	 @Stories("As A User I Will Not Be Able to Register")
	 @TestCaseId("TC_ADR_004_005")
	 @Title("Verify User Not Able to Register with UnCheck Pernyataan Setuju")
	 public void userNotAbleToRegisterWithUnCheckPernyataanSetuju(){
		 System.out.println("Verify User Not Able to Register with UnCheck Pernyataan Setuju");
		 HomePage homepage = new HomePage(driver);
		 daftarPage = homepage.clickDaftarPage();
		 daftarPage.setElementDaftar();
		 daftarPage.setEmailDaftar(emailDaftarValidFormat);
		 daftarPage.setPasswordDaftar(passwordValid);//setBlankPassword
		 daftarPage.setKonfirmasiPasswordDaftar(passwordValid);
		 daftarPage.clickSubmitRegister();
	     daftarPage.verifyUnCheckPernyataanSetuju();
	     daftarPage.clickBackButton();
	 }
	 
	 @Test(priority=6)
	 @Stories("As A User I Want to Be Able to Register")
	 @TestCaseId("TC_ADR_004_006")
	 @Title("Verify User Able to Daftar")
	 public void userAbleToRegister(){
		 System.out.println("Verify User Able to Daftar");
		 HomePage homepage = new HomePage(driver);
		 daftarPage = homepage.clickDaftarPage();
		 daftarPage.setElementDaftar();
		 daftarPage.setEmailDaftar(emailDaftarValidFormat);
		 daftarPage.setPasswordDaftar(passwordValid);
		 daftarPage.setKonfirmasiPasswordDaftar(passwordValid);
		 daftarPage.clickSetuju();
		 SuccessDaftarPage successDaftarPage = daftarPage.clickSubmitRegister();
		 successDaftarPage.verifySucessDaftar();
		 successDaftarPage.clickBackToHomePages();
	 }
 
}
