package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dao.ProductDao;
import model.Amount;
import model.Product;



@WebServlet("/product")
public class ProductController extends HttpServlet {
	private ProductDao pd = new ProductDao();

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String opt = req.getParameter("opt");
		if (opt != null) {
			int choice = Integer.parseInt(opt);

			switch (choice) {
			case 1:
				try {
					register(req,res);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//addProduct(req, res);
				break;
			case 2:
				try {
					login(req,res);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//searchProductByDate(req, res);
				break;
			case 3:
				try {
					addProduct(req, res);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//RegisterCustomer(req, res);
				break;
			case 4:
				searchProductByDate(req, res);
				
				break;
			case 5:
				allProduct(req, res);
				break;
			case 6:
				try {
					delete(req, res);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 7:
				try {
					update(req, res);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 8:
				try {
					updateshow(req,res);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			case 9:
				try {
					categoryAmount(req, res);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			

			}
		}
	}

	private void categoryAmount(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		
		String from = req.getParameter("from");
		String to = req.getParameter("to");

		List<Amount> amount = pd.TotalAmount(from, to);
		req.setAttribute("list", amount);
		req.getRequestDispatcher("amountTable.jsp").forward(req, res);

		
	}

	private void updateshow(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("product_id"));
		String category = req.getParameter("category");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String dates = req.getParameter("dates");
		System.out.println(price);
		Product p = new Product();
		p.setCategory(category);
		p.setName(name);
		p.setPrice(Float.parseFloat(price));
		p.setDates(dates);
		p.setProduct_id(id);
		if (pd.update(p) > 0) {
			RequestDispatcher rd = req.getRequestDispatcher("product?opt=5");
			rd.include(req, res);
			
		} else {
		res.getWriter().print(" Added Failed");
		}

		
	}

	private void update(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		int pid = Integer.parseInt(req.getParameter("product_id"));
		Product p = pd.getRecordById(pid);
		req.setAttribute("product", p);
		req.getRequestDispatcher("update.jsp").forward(req, res);
		
		
	}

	private void delete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		Product p = new Product();
		p.setProduct_id(Integer.parseInt(req.getParameter("product_id")));
		if (pd.delete(p) > 0) {
			RequestDispatcher rd = req.getRequestDispatcher("product?opt=5");
			rd.include(req, res);
			
		} else {
		res.getWriter().print(" Added Failed");
		}
		
	}

	private void allProduct(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Product> products = pd.showAllDetail();
		req.setAttribute("list", products);
		req.getRequestDispatcher("showAll.jsp").forward(req, res);
	}

	private void searchProductByDate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String from = req.getParameter("from");
		String to = req.getParameter("to");

		List<Product> products = pd.findRecode(from, to);
		req.setAttribute("list", products);
		req.getRequestDispatcher("table.jsp").forward(req, res);
		
		
	}

	private void addProduct(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		String category = req.getParameter("category");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String dates = req.getParameter("dates");
		System.out.println(price);
		Product p = new Product();
		p.setCategory(category);
		p.setName(name);
		p.setPrice(Float.parseFloat(price));
		p.setDates(dates);
		
		if (pd.AddProduct(p) > 0) {
			RequestDispatcher rd = req.getRequestDispatcher("add.jsp");
			rd.include(req, res);
			
		} else {
		res.getWriter().print(" Added Failed");
		}
		
	}

	private void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Product p = new Product();
		p.setUsername(username);
		p.setPassword(password);
		
		if (pd.Login(p) > 0) {
			RequestDispatcher rd = req.getRequestDispatcher("productHome.jsp");
			rd.include(req, res);
			
		} else {
		res.getWriter().print(" Added Failed");}

		
	}

	private void register(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, SQLException {
		// TODO Auto-generated method 
		String name = req.getParameter("name");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		Product p = new Product();
		p.setName(name);
		p.setUsername(username);
		p.setPassword(password);
		
		if (pd.Register(p) > 0) {
			RequestDispatcher rd = req.getRequestDispatcher("adduser.jsp");
			rd.include(req, res);


		} else {
		res.getWriter().print(" Added Failed");}

		
		
		
	}


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);

	}
}
