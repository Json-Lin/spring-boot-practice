package foo.filter.anno;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 注解方式配置Filter，需在启动类上加入
 * 
 * @ServletComponentScan注解
 *
 */
@WebFilter
public class MyAnnotationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init MyAnnotationFilter...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(request, response);
		System.out.println("do MyAnnotationFilter...");
	}

	@Override
	public void destroy() {
		System.out.println("destroy MyAnnotationFilter...");
	}

}
