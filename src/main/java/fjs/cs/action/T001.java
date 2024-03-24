package fjs.cs.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T001 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		
		RequestDispatcher rd= req.getRequestDispatcher("/WEB-INF/jsp/T001.jsp");    
        rd.forward(req, resp);
//		printWriter.println("<form action='/Servlet/form' method = 'post'>");
//		printWriter.println("ten: <input type='text' name='ten' />");
//		printWriter.println("<br/>");
//		printWriter.println("tuoi: <input type='text' name='tuoi' />");
//		printWriter.println("<br/>");
//		printWriter.println("dia chi: <input type='text' name='diaChi' />");
//		printWriter.println("<br/>");
//		printWriter.println("<input type='submit' value='submit' />");
//		printWriter.println("</form>");
		printWriter.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("userpass");
		
		if (username.trim() != "" || password.trim() != "") {
			SQLServerConnection connection = new SQLServerConnection();
			boolean checkAuth = connection.authentication(username, password);
			connection.disconnect();
			if(checkAuth) {
				printWriter.println("username " + username + "password " + password);
				printWriter.close();
			} else {
				resp.sendRedirect("/Servlet/T001?error=1");
			}
		}
	}
}
