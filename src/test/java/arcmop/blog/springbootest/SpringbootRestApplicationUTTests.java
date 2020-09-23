package arcmop.blog.springbootest;

import arcmop.blog.springbootest.configuracion.StartApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartApplication.class)
public class SpringbootRestApplicationUTTests {

	@Test
	public void contextLoads() {
	}

}
