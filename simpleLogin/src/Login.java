

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	Connection con;
	PreparedStatement prs;
	ResultSet rs;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhargav", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			con.close();
			rs.close();
			prs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			prs = con.prepareStatement("select count(*) from regist where name1=? and password1=?");
			String name1 = request.getParameter("uname");
			String password = request.getParameter("password");
			prs.setString(1, name1);
			prs.setString(2, password);
			rs = prs.executeQuery();
			
			HttpSession session = request.getSession(true);
			session.setAttribute("name1", name1);
			
			setUserAction(response);
		} catch (SQLException e) {
			response.sendRedirect("error.jsp");
		}
		
		

	}

	private void setUserAction(HttpServletResponse response) throws SQLException, IOException {
		if(rs!=null && rs.next()) {
			int i = rs.getInt(1);
			System.out.println(i);
			if (i >= 1) {
				response.sendRedirect("output.jsp");
				System.out.println("done");
				
				
			} else {
				PrintWriter pw = response.getWriter();
				pw.println("your account is invaid please create the account ");
				response.sendRedirect("creat.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
