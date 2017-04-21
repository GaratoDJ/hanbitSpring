package service;

import java.io.File;
import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

import model.Board;

public interface BoardService {
	
	public int writeBoard(Board board, MultipartFile file);
	public int modifyBoard(Board board);
	public int deleteBoard(int num);
	public Board readBoard(int num);
	
	//게시물 페이지 정보 구하기
	//현재 페이지의 게시물 리스트
	
	public HashMap<String, Object> getBoardListPage(int page);
	
	//네이게이터의 첫번째 번호 얻기
	public int getStartPage(int page);
	
	//네비게이터의 마지막 번호 얻기
	public int getEndPage(int page);
	
	//맨 마지막 페이지 얻기
	public int getLastPage(int numOfBoards);
	
	//현재 페이지에서 보여줄 게시물의 시작지점
	public int getOffset(int page);
	
	//게시물 정보 하나 가져오기
	public Board getBoard(int num);
	
	//첨부파일 가져다 주는 기능
	public File getAttachedFile(int num);
	
	public HashMap<String, Object> getBoardListByCondition(int page, String keyword, int type);

}
