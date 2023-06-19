package com.wjdwo1104.controller.member;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.wjdwo1104.model.MemberDao;
import com.wjdwo1104.model.MemberDto;
import com.wjdwo1104.utils.ScriptWriter;
//DefultFileRenamePolicy fileRenamePolicy = new 
//
//MultipartRequest multipartRequest = new MultipartRequest(request, currentDir,fileSize,encoding,fileRenamePolicy);
//
//DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
//diskFileItemFactory.setRepository(currentDir);
//diskFileItemFactory.setSizeThreshold(fileSize);
//
//ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
//try {
//	//List<FileItem> items = new ArrayList<>();
//	List<FileItem> items = upload.parseRequest(request);
//	
//	Iterator<E> it = request.get();
//	List<MultipartFile> list = request.getFiles(it.next().toString());
////	
//	for(FileItem fileItem:items) {
//		if(fileItem.isFormField()) {
//			
//		}else {
//			System.out.println("filedName==="+fileItem.getFieldName());
//			String originalName = fileItem.getName();
//			System.out.println("originalName==="+originalName);
//			String extension = originalName.substring(originalName.lastIndexOf("."));
//			//profile.jpg pro.file.jpg lastIndexof 뒤에서
//			UUID uuid = UUID.randomUUID();
//			System.out.println(uuid);
//			String fileName = uuid+extension;
//			
//			File uploadPath = new File(currentDir + "\\"+ getToday());
//			if(!uploadPath.exists()) {
//				uploadPath.mkdir();
//			}
//			fileItem.write(currentDir);
//		}
//	}
//} catch (Exception e) {
//	e.printStackTrace();
//}


@WebServlet("/member/joinProcess")
public class JoinProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("왜 안넘어오니...");
		
		// linux cli 속도이득 무료 
		request.setCharacterEncoding("utf-8"); 
		String encoding = "utf-8";
		
		int fileSize = 1024*1024*10;
		String savePath = "C:\\Users\\y\\upload";
		File currentDir = new File(savePath);

		
		DefaultFileRenamePolicy fileRenamePolicy = new DefaultFileRenamePolicy();
		
		
		MultipartRequest multipartRequest = new MultipartRequest(request,savePath,fileSize,encoding,fileRenamePolicy);
		
		
		
		
		String userId = multipartRequest.getParameter("userId"); 
		String userPw = multipartRequest.getParameter("userPw"); 
		String userName = multipartRequest.getParameter("userName"); 
		String userEmail = multipartRequest.getParameter("userEmail"); 
		int zonecode = Integer.parseInt(multipartRequest.getParameter("zonecode")); 
		String userAddress = multipartRequest.getParameter("userAddress"); 
		String detailAddress = multipartRequest.getParameter("detailAddress"); 
		String extraAddress = multipartRequest.getParameter("extraAddress"); 
		MemberDao memberDao = new MemberDao();
		
		String origianlFile = multipartRequest.getOriginalFileName("profile");
		String renameFile = multipartRequest.getFilesystemName("porfile");
		
		
		MemberDto memberDto = new MemberDto();
		memberDto.setId(userId);
		memberDto.setPassword(userPw);
		memberDto.setName(userName);
		memberDto.setZonecode(zonecode);
		memberDto.setAddress(userAddress);
		memberDto.setExtraAddress(extraAddress);
		memberDto.setDetailAddress(detailAddress);
		memberDto.setEmail(userEmail);
		memberDto.setRealProfile(renameFile);
		
		int result = memberDao.insertMember(memberDto);
		System.out.println(result);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "회원가입 되었습니다.", "../member/login");
		} else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류가 발생 되었습니다. 다시 시도해 주세요");
		}
	}

	private String getToday() {
		return new SimpleDateFormat("yyyy-MM-dd").format(System.currentTimeMillis());
	}


}




















