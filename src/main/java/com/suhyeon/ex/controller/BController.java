package com.suhyeon.ex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suhyeon.ex.command.BCommand;
import com.suhyeon.ex.command.BContentCommand;
import com.suhyeon.ex.command.BDeleteCommand;
import com.suhyeon.ex.command.BListCommand;
import com.suhyeon.ex.command.BModifyCommand;
import com.suhyeon.ex.command.BReplyCommand;
import com.suhyeon.ex.command.BReplyViewCommand;
import com.suhyeon.ex.command.BWriteCommand;

@Controller
public class BController {

	BCommand command = null;
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		
		command = new BListCommand();
		command.excute(model);
		
		return "list";
	}
	
	@RequestMapping(value = "/write_view")
	public String write_view() {
		
		return "write_view";
	}
	
	@RequestMapping(value = "/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BContentCommand();
		command.excute(model);
		
		return "content_view";
	}
	
	@RequestMapping(value = "/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BReplyViewCommand();
		command.excute(model);
		return "reply_view";
	}
	
	@RequestMapping(value = "/write")
	public String write(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BWriteCommand();
		command.excute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BModifyCommand();
		command.excute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BDeleteCommand();
		command.excute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/reply")
	public String reply(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BReplyCommand();
		command.excute(model);
		
		return "redirect:list";
	}
}

