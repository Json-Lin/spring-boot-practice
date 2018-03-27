package foo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * <p>Description: </p>
 * @author JiaSonglin
 * @version V1.0,2017年4月1日 上午9:43:16
 */
@SpringBootApplication
@ServletComponentScan
public class SimpleApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(SimpleApplicationStarter.class, args);
	}
}
