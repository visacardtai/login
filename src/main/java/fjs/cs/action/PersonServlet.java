package fjs.cs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/them-nguoi-dung"})
public class PersonServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter printWriter = resp.getWriter();
		
		String ten = req.getParameter("ten");
		String tuoi = req.getParameter("tuoi");
		String diaChi = req.getParameter("diaChi");
		
		printWriter.println("ten " + ten + "tuoi " + tuoi + "diaChi " + diaChi);
		printWriter.close();
	}
}
