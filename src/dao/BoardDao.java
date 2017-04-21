package dao;

import java.util.HashMap;
import java.util.List;

import model.Board;

public interface BoardDao {
	
	public int insertBoard(Board board);
	public int updateBoard(Board board);
	public void deleteBoard(int num);
	public Board selectOne(int num);
	public int getCount();
	
	//현재 페이지에 해당하는 게시물만 가져오기
	public List<Board> selectBoardPage(HashMap<String, Object> params);
	
	//검색 결과에 해당하는 게시물 가져오기 + 페이징
	public List<Board> selectSearchByKeyword(HashMap<String, Object> params);
	
	public int getCountSearchByKeyword(HashMap<String, Object> params);

}
