


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
 * Servlet implementation class Final
 */
@WebServlet("/OutPut")
public class OutPut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement prs;
	ResultSet rs1;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OutPut() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bhargav","root","root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			if(con!=null)
			con.close();
			if(rs1!=null)
			rs1.close();
			if(prs!=null)
			prs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("final start");
		
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("name1");
			
			System.out.println("out "+username);
			prs=con.prepareStatement("SELECT * FROM regist where name1=?");
			prs.setString(1, username);
			ResultSet	rs1=prs.executeQuery();
			while(rs1.next()) {
			String name = rs1.getString("name1");
			String fullName=rs1.getString("full_name");
			long phone=rs1.getLong("phone");
			String mail = rs1.getString("mail_id");
			String g=rs1.getString("gender");
			String c=rs1.getString("Country");
			String s=rs1.getString("state");
			String ci=rs1.getString("city");

			PrintWriter pw=response.getWriter();
			System.out.println("done "+ name);
			pw.println("your reqired information is ");
			pw.println("Name = "+name);
		
			pw.println("Full Name = "+fullName);
			pw.println("Email Id = "+mail);
			pw.println("Phone No = "+phone);
			pw.println("Gender = "+g);
			pw.println("Country  = "+c);
			pw.println("State = "+s);
			pw.println("City = "+ci);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
