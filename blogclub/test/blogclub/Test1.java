package blogclub;

import java.util.List;

import javax.servlet.ServletContext;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.bean.BlogKind;
import com.company.listener.KindsListener;
import com.company.service.IBlogKindService;

public class Test1 {

	@Test
	public void test() {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring.xml");
		KindsListener kindsListener = context.getBean(KindsListener.class);
		System.out.println(kindsListener);
//		List<BlogKind> blogKinds = iBlogKindService.findList();
//		
//		System.out.println(blogKinds.size());
	}
}
