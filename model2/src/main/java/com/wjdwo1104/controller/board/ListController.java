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

@WebServlet("/board/list")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// board 테이블의 row값을 가지고 오기....
		BoardDao boardDao = new BoardDao();
		ArrayList<BoardDto> boardList = boardDao.getList();
		
		request.setAttribute("boardList", boardList);
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/board/write.jsp");
		dispatcher.forward(request, response);
	}
}










