
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class FilterA
 */
@WebFilter(filterName = "FilterA", urlPatterns = {"/FAServlet", "/product.jsp", "/index.jsp"})
public class FilterA extends HttpFilter implements Filter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FilterConfig filterConfig = null;

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public FilterA() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// place your code here
		System.out.println("Pre-Process Start");
		System.out.println("Pre-Process==>" + filterConfig.getFilterName());
		long start = System.currentTimeMillis();

		// pass the request along the filter chain
		chain.doFilter(request, response);

		// code after process
		long end = System.currentTimeMillis();
		System.out.println("Post-Process Start");
		System.out.println("Post-Process==>" + filterConfig.getFilterName());
		System.out.println("執行時間:" + (end - start) + "ms");

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

}
