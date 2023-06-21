package com.wjdwo1104.controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wjdwo1104.model.BoardDao;
import com.wjdwo1104.model.BoardDto;

@WebServlet("/board/searchProcess")
public class SearchProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public SearchProcessController() {
        super();
        
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		String searchWord = request.getParameter("searchWord");// jsp파일에서 무엇이 넘어오는지 먼저 생각하고 코드짜기
		
		ArrayList<BoardDto> searchList = null;
		//뭐만들어야해? DAO
		BoardDao boardDao = new BoardDao();
		// 틀을 생각해서 명령어 먼저적고 커서올리면
		boardDao.search(category,searchWord);
		searchList = boardDao.search(category, searchWord);
		request.setAttribute("searchList", searchList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/board/search-list.jsp");
		dispatcher.forward(request, response);
		
		System.out.println();
	}

}
