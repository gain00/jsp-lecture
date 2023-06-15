package com.wjdwo1104.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wjdwo1104.model.MemberDao;
import com.wjdwo1104.model.MemberDto;
import com.wjdwo1104.utils.ScriptWriter;

/**
 * Servlet implementation class DeleteFormProcessController
 */
@WebServlet("/member/DeleteProcess")
public class DeleteFormProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFormProcessController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		String userId = request.getParameter("userId"); 
		String userPw = request.getParameter("userPw");
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		memberDto.setId(userId);
		memberDto.setPassword(userPw);
		
		int result = memberDao.deleteMember(memberDto);
		System.out.println(result);
		if(result>0) {
			HttpSession session = request.getSession();
			session.invalidate();
			ScriptWriter.alertAndNext(response, "수정 되었습니다.", "../member/login");
		} else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류가 발생 되었습니다. 다시 시도해 주세요");
		}
	}
	

}
