package com.wjdwo1104.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wjdwo1104.model.MemberDao;
import com.wjdwo1104.model.MemberDto;


@WebServlet("/member/delete")
public class DeleteFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteFormController() {
        super();
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		MemberDao memberDao = new MemberDao();
		MemberDto infoMemberDto = memberDao.getMemberInfo(userId);//변수 보내려면 request에다가 실음
		request.setAttribute("infoMemberDto", infoMemberDto);//변수배열 이해
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/member/Delete.jsp");
		dispatcher.forward(request, response);
	}

}
