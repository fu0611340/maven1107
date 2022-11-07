import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductDAO {
	
	public static void main(String args[]) {
		List<Product> l = new ProductDAO().getProductList();
		l.forEach((p)->System.out.println(
				p.getCode()+"\t"+
				p.getDescription()+"\t"+
				p.getPrice()+"\t"+
				p.getQuantity()
		));
	}
	
	public ArrayList<Product> getProductList() {
		// MySQL DB Connection URL
		String url = "jdbc:mysql://localhost:3306/classicmodels";
		String username = "root";
		String password = "1234";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Product> list = new ArrayList<>();
		String query = "SELECT productCode  as  code, "
				+ "quantityInStock  as  quantity, "
				+ "productDescription  as  description, "
				+ "buyPrice  as  price "
				+ "FROM  classicmodels.products "
				+ "where buyPrice>=90.0";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Product ur = new Product();
				ur.setCode(rs.getString("code"));
				ur.setQuantity(rs.getInt("quantity"));
				ur.setDescription(rs.getString("description"));
				ur.setPrice(rs.getString("price"));
				list.add(ur);
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
}
