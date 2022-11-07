

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.Product;

/**
 * Application Lifecycle Listener implementation class DBProductListener
 *
 */
@WebListener
public class DBProductListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DBProductListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         ServletContext context = sce.getServletContext();
         ArrayList<Product> list = getArrayList();
         context.setAttribute("catalog", list);
    }
	
    public ArrayList<Product> getArrayList(){
    	ArrayList<Product> list ;
        ProductDAO dao=new ProductDAO();
        list=dao.getProductList();
        return list;
    }
}
