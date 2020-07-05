package com.cos.pantone.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.pantone.action.Action;
import com.cos.pantone.model.Member;
import com.cos.pantone.model.RoleType;
import com.cos.pantone.repository.MemberRepository;
import com.cos.pantone.utill.SHA256;
import com.cos.pantone.utill.Script;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberProfileUploadProcAction implements Action {
	private final static String TAG = "MemberProfileUploadProcAction : ";
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String realPath = request.getServletContext().getRealPath("image");
		
		// 디비에 경로를 저장하기 위한 코드.
		int id;
		String fileName = null;
		String contextPath = request.getServletContext().getContextPath();
		String userProfile = null;
		
		try {
			MultipartRequest multi = new MultipartRequest // 파일만 받을 수 있음
					(
							request,
							realPath,
							1024*1024*1,
							"UTF-8",
							new DefaultFileRenamePolicy()
					);
			fileName = multi.getFilesystemName("userProfile");
			System.out.println(TAG + "fileName : " + fileName);
			id = Integer.parseInt(multi.getParameter("id"));
			
			userProfile = contextPath + "/image/" + fileName;
			System.out.println(TAG + "userProfile : " + userProfile);
			
			MemberRepository memberRepository = MemberRepository.getInstance();
			int result = memberRepository.update(id, userProfile);
			
			if (result == 1) {
				HttpSession session = request.getSession();
				Member principal = memberRepository.findById(id);
				session.setAttribute("principal", principal);
				
				Script.href("프로필을 변경하였습니다.", "/pantone/index.jsp", response);
			} else {
				Script.back("프로필 변경에 실패하였습니다.", response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			Script.getMessage("오류 : " + e.getMessage(), response);
		}
	}
}
