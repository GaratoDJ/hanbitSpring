package controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import model.Board;
import service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService bService;
	
	@RequestMapping("boardList.do")
	public ModelAndView BoardList(
			@RequestParam(defaultValue="1") int page,
			@RequestParam(required=false) String keyword, //2222222. 두번째 작성하는 리퀘스트 파람
			@RequestParam(defaultValue="0") int type) throws UnsupportedEncodingException{  //세번째 파람. 두번째, 세번째는 검색창 만들 때 작성함.

		// 111111. 첫번째임... 페이지 네비게이터의 첫번째 번호, 마지막 번호, 맨 끝 페이지 번호 등의 정보 알아내기
		//서비스에 위의 기능을 구현할 메소드 만들기
		//getBoardList 메소드 호출
		
		ModelAndView mav = new ModelAndView();
		

		System.out.println("입장" + keyword);
		System.out.println("입장" + type);
		
		if(type == 0){
			HashMap<String, Object> result = bService.getBoardListPage(page);
			mav.addAllObjects(result);
		}
		
		if(type==1||type==2||type==3||type==4){
			//검색을 적용한 한정된 결과 게시글 가져오기
			//검색 결과에 해당하는 게시물 가져오기 기능 구현
			//서비스 : getBoardListByCondition
			HashMap<String, Object> result = bService.getBoardListByCondition(page, keyword, type);
			mav.addObject("keyword", URLEncoder.encode(keyword,"UTF-8"));
			mav.addObject("type",type);
			
			mav.addAllObjects(result);
			
			System.out.println("퇴장" + keyword);
			System.out.println("퇴장" + type);
		}
		
//		HashMap<String, Object> result = bService.getBoardListPage(page);
//		mav.addAllObjects(result);
		mav.setViewName("boardList");
		return mav;
	}
	
	@RequestMapping("view.do")
	public ModelAndView boardView(int num){
		ModelAndView mav = new ModelAndView();
		//게시물 번호에 해당하는 게시물 정보 가져오기
		//서비스의 readBoard가 수행
		mav.addObject(bService.readBoard(num));
		mav.setViewName("view");
		
		return mav;
	}
	
	@RequestMapping("modifyForm.do")
	public void modifyForm(Model model, int num){
		//DB에서 가져온 게시판 정보 하나 : 데이터
		//modifyForm.jsp 페이지 : view
		//서비스의 getBoard
		
		model.addAttribute(bService.getBoard(num));		
	}
	
	@RequestMapping("modify.do")
	public String modify(Board board){
		//게시물 정보를 파라미터로 받아서 DB에 수정작업
		//서비스의 modifyBoard
		bService.modifyBoard(board);
		System.out.println(board);
		return "redirect:view.do?num=" + board.getNum();		
	}
	
	@RequestMapping("writeForm.do")
	public void writeForm(){
		
	}
	
	@RequestMapping("write.do")
	public String write(Board board, @RequestParam("ufile") MultipartFile file){
		//게시글 작성하기
		//페이지에서 파라미터 얻어와서 DB에 저장
		//서비스의 writeBoard 메소드
		//내가 작성한 게시글의 상세보기로 이동
		
//		System.out.println(file.getName());
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getContentType());
//		System.out.println(file.getSize());
		
		bService.writeBoard(board, file);
		return "redirect:view.do?num=" + board.getNum();
		
	}
	
	@RequestMapping("download.do")
	public View download(int num){
		
		View view = new DownloadView(bService.getAttachedFile(num)); //게시물 번호에 해당하는 DB의 레코드. file정보를 얻어 위치파악후 file을 얻음
		return view;
	}

}