package listeners;

import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContext;

import java.util.ArrayList;

import models.City;
import models.User;

public class ContextListener implements ServletContextListener{
	public void contextInitialized(ServletContextEvent sce){
		//############# all cities #############
		ServletContext sc = sce.getServletContext();

		ArrayList<City> cities = City.GetAllCities();

		sc.setAttribute("cities",cities);	

	}
	public void contextDestroyed(ServletContextEvent sce){

	}
}