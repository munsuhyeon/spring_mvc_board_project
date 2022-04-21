package com.suhyeon.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.suhyeon.ex.dao.BDao;
import com.suhyeon.ex.dto.BDto;

public class BReplyCommand implements BCommand {

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bGroup = request.getParameter("bGroup");
		String bStept = request.getParameter("bStept");
		String bIndent = request.getParameter("bIndent");
		
		BDao dao = new BDao();
		
		dao.reply(bId, bName, bTitle, bContent, bGroup, bStept, bIndent);
	}

}
