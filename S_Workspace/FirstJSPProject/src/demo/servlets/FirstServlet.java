package demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String colour = "aqua";
		int table;
		if(request.getParameter("colour")!=null) {
			colour = request.getParameter("colour");
			
		}
		PrintWriter out = response.getWriter();
		out.print("<html><body style=\"background-color:" +colour+ "\">" + 
				"<h1>JSP Demo website</h1>" + 
				"<h2>Site links</h2>" + 
				"<a href = index.html>Home page</a><br><br>");
		if(request.getParameter("number")!= null) {
				table = Integer.parseInt(request.getParameter("number"));
				out.print(timesTable(table));
		}
			out.print("</body>" + 
				"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private String timesTable(int n) {
		String table = "<ul>";
		for(int i = 1; i <= 12; i++ ) {
			table += "<li>" + i + "times" + n +"=" +(i*n) + "</li>";
		}
		table += "</ul>";
		return table;
	}
}
