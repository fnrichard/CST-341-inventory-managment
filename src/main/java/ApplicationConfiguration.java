import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.controller.CreateProductController;
import com.gcu.controller.HomeController;
import com.gcu.controller.LoginController;
import com.gcu.controller.MainLandingController;
import com.gcu.controller.RegisterController;

@Configuration
public class ApplicationConfiguration {

	@Bean(name="LoginController")
	public LoginController getLoginController() {
		return new LoginController();
	}
	
	@Bean(name="HomeController")
	public HomeController getHomeController() {
		return new HomeController();
	}
	
	@Bean(name="CreateProductController")
	public CreateProductController getCreateProductController() {
		return new CreateProductController();
	}
	
	@Bean(name="MainLandingController")
	public MainLandingController getMainLandingController() {
		return new MainLandingController();
	}
	
	@Bean(name="RegisterController")
	public RegisterController getRegisterController() {
		return new RegisterController();
	}
	
}
