package foo.filter.bean;

import java.util.Arrays;

import javax.servlet.DispatcherType;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

	@Bean
	public FilterRegistrationBean myFilterRegistrationBean(MyBeanFilter myBeanFilter){
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setDispatcherTypes(DispatcherType.REQUEST);
		registration.setFilter(myBeanFilter);
		registration.setUrlPatterns(Arrays.asList("/index"));
		return registration;
	}
}
