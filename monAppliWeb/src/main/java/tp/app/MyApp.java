package tp.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tp.dao.DeviseDao;
import tp.entity.Devise;

public class MyApp {

	public static void main(String[] args) {
		ApplicationContext contextSpring =
				new ClassPathXmlApplicationContext("/springContext.xml");
        //DeviseDao deviseDao = (DeviseDao) contextSpring.getBean("deviseDaoJpa");
        DeviseDao deviseDao =  contextSpring.getBean(DeviseDao.class);
        Devise d = deviseDao.findDeviseByCode("EUR");
        System.out.println(d);
        ( (ClassPathXmlApplicationContext) contextSpring).close();
	}

}
