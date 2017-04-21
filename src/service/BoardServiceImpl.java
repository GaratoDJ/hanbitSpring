package service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dao.BoardDao;
import model.Board;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDao bDao;

	@Override
	public int writeBoard(Board board, MultipartFile file) {
		// TODO Auto-generated method stub
		
		String path = "/Temp/attach/";
		File dir = new File(path);
		
		if(!dir.exists()) dir.mkdirs(); //해당 경로가 없을 시 디렉토리 생성요청 명령어
		
		String fileName = file.getOriginalFilename();
		File attachedFile = new File(path + fileName); //첨부 파일 저장된 경로 + 파일의 이름
		
		try {
			file.transferTo(attachedFile); //파일을 복사
			board.setFile(fileName); //DB에 파일 정보(파일이름) 저장
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		board.setWriteDate(new Date());
		return bDao.insertBoard(board);
	}

	@Override
	public int modifyBoard(Board board) {
		// TODO Auto-generated method stub
		//게시물 정보 수정
		//웹에서 비밀번호를 받아와서 DB에 있는 비밀번호랑 비교해서 동일하면 수정
		Board originBoard = bDao.selectOne(board.getNum());
		if(originBoard.getPass().equals(board.getPass())){
			return bDao.updateBoard(board);
		}
		else
		return 0;
	}

	@Override
	public int deleteBoard(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Board readBoard(int num) {
		// TODO Auto-generated method stub
		
		//게시물 번호를 이용해서 DB에서 게시물 조회. 게시물이 있으면 조회수 1 올리기
		//게시물 하나 가져오기 : DAO의 selectOne을 이용
		
		Board b = bDao.selectOne(num);
		
		if(b !=null){
			b.setReadCount(b.getReadCount()+1);
			bDao.updateBoard(b);
		}
		
		return b;
	}

	@Override
	public HashMap<String, Object> getBoardListPage(int page) {
		// TODO Auto-generated method stub
		HashMap<String, Object> result = new HashMap<>();
		result.put("current", page);
		result.put("start", getStartPage(page));
		result.put("end", getEndPage(page));
		result.put("last", getLastPage(bDao.getCount()));
		result.put("totalPage", bDao.getCount());
		
		HashMap<String, Object> params = new HashMap<>();
		params.put("offset", getOffset(page));
		params.put("boardsPerPage", 10);
		result.put("boardList", bDao.selectBoardPage(params));
		
		return result;
	}

	@Override
	public int getStartPage(int page) {
		// TODO Auto-generated method stub
		//현재페이지 - (현재 페이지 -1) % 네비게이터 블록 크기
		return page - ((page-1)%10);
	}

	@Override
	public int getEndPage(int page) {
		// TODO Auto-generated method stub
		//네비게이터의 첫번째 번호 + (네이게이터 블록 크기 -1 )
		return page - ((page-1)%10) + (10-1);
	}

	@Override
	public int getLastPage(int numOfBoards) {
		// TODO Auto-generated method stub
		//Dao에 등록한 메소드를 사용해서 총 게시물 수 가져오기
		//한 페이지 당 10개의 게시물
		
		return (numOfBoards-1)/10 + 1;
	}

	@Override
	public int getOffset(int page) {
		// TODO Auto-generated method stub
		return (page - 1)*10;
	}

	@Override
	public Board getBoard(int num) {
		// TODO Auto-generated method stub
		return bDao.selectOne(num);
	}

	@Override
	public File getAttachedFile(int num) {
		// TODO Auto-generated method stub
		Board b = bDao.selectOne(num);
		String fileName = b.getFile(); //DB에 저장된 파일 이름 얻어내기. 쓸거니까 String으로 저장
		String path = "/Temp/attach/";
		return new File(path + fileName);
	}

	@Override
	public HashMap<String, Object> getBoardListByCondition(int page, String keyword, int type) {
		// TODO Auto-generated method stub
		
		//sql문 작성에 필요한 파라미터 설정
		HashMap<String, Object> params = new HashMap<>();
		//검색 결과 얻은 게시물 리스트를 담기 위한 해쉬맵
		HashMap<String, Object> result = new HashMap<>();
		
		params.put("keyword", keyword);
		params.put("type", type);
		params.put("offset", getOffset(page));
		params.put("boardsPerPage", 10);
		
		result.put("boardList", bDao.selectSearchByKeyword(params));
		//찾아낸 게시물들 페이지 처리
		result.put("current", page);
		result.put("start", getStartPage(page));
		result.put("end", getEndPage(page));
		result.put("last", getLastPage(bDao.getCountSearchByKeyword(params)));

		
		return result;
	}

}
