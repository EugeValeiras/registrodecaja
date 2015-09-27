package registrodecaja.initialize;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import registrodecaja.configuration.AppConfig;
import registrodecaja.configuration.WebMvcConfig;

public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { AppConfig.class, WebMvcConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}
