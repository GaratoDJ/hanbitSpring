package test;

import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import dao.BoardDao;
import model.Board;
import service.BoardService;

public class serviceTest {
	public static void main(String[] args) {
		
		ApplicationContext context 
		= new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService mService = context.getBean("BoardService", BoardService.class);
		
		
		
	}

}
