package lk.ijse.gdse.springboot.back_end;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(lk.ijse.gdse.springboot.back_end.HelloShoesBackendApplication.class);
	}

}
