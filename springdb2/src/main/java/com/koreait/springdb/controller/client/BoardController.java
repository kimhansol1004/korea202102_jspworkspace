  
package com.koreait.springdb.controller.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.springdb.model.domain.Board;
import com.koreait.springdb.model.service.board.Boardservice;

import lombok.Setter;

@Controller  //스프링의 컴포넌트 스캔의 대상이 되기 위해..
@Setter
public class BoardController {
	
	@Autowired
	private Boardservice boardservice;
	
	//ID는 생성자 주입도 가능
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test() {
		System.out.println("클라이언트의 test() 호출");
		return null;
	}
	
	//게시판 목록 요청을 처리
	@RequestMapping(value="/board/list",method=RequestMethod.GET)
	public String getList(Model model) {
		//3단계 - 일시키기
		List boardList = boardservice.selectAll();
		
		//4단계 - 저장
		model.addAttribute("boardList",boardList); //application, session, request 중 request에 저장
		//그래서 포워딩을 하는것
		
		return "user/board/list";
	}
	
	@RequestMapping(value="/board/detail",method=RequestMethod.GET)
		public String getDetail(int board_id, Model model) {
			Board board = boardservice.select(board_id);
			
			model.addAttribute("board",board);
			return "user/board/detail";
	} 
}





