

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GugudanRadioResult")
public class GugudanRadioResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GugudanRadioResult() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int dan = Integer.parseInt(request.getParameter("dan"));
		String dans[] = request.getParameterValues("dan");
		for(String item:dans) {
			System.out.println(item);
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		for(String item:dans) {
		int dans1 = Integer.parseInt(item);
		out.println("<h1>"+item+"단을 출력합니다</h1>");
		
		for(int i =1; i<10;i++) {
			out.println("<p>"+item+"x"+i+"="+dans1*i+"</p>");
		}
		};
		
		out.println("<a href='javascript:history.back()'>뒤로가기</a>");
		out.println("</body>");
		out.println("</html>");
		
		}
	}

	



