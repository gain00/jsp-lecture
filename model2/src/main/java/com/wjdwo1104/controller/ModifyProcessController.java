package com.wjdwo1104.controller;

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


@WebServlet("/member/ModifyProcess")
public class ModifyProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ModifyProcessController() {
        super();
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		String userId = request.getParameter("userId"); 
		String userPw = request.getParameter("userPw"); 
		String userName = request.getParameter("userName"); 
		String userEmail = request.getParameter("userEmail"); 
		int zonecode = Integer.parseInt(request.getParameter("zonecode")); 
		String userAddress = request.getParameter("userAddress"); 
		String detailAddress = request.getParameter("detailAddress"); 
		String extraAddress = request.getParameter("extraAddress"); 
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		memberDto.setId(userId);
		memberDto.setPassword(userPw);
		memberDto.setName(userName);
		memberDto.setZonecode(zonecode);
		memberDto.setAddress(userAddress);
		memberDto.setExtraAddress(extraAddress);
		memberDto.setDetailAddress(detailAddress);
		memberDto.setEmail(userEmail);
		int result = memberDao.modifyMember(memberDto);
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
