

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Hello() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
//		리퀘스트로 받아오는 모든것은 스트링 
		
		int num01 = Integer.parseInt(request.getParameter("num01")) ;
		int num02 = Integer.parseInt(request.getParameter("num02")) ;
		
		int sum = num01+num02;
		String name = "";
		name = request.getParameter("name");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>"+name+num01+num02+sum+"hello servlet</h1>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
		
		
		
	}

}
