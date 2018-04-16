package serviceimp;
import java.sql.SQLException;
import java.util.List;

import dao.BookDao;
import javabean.Page;
import javabean.Book;
import javabean.Manager;
import service.BookService;
public class BookServiceimp implements BookService {
	BookDao bookDao=new BookDao();
	//��ҳ��ѯ
	@Override
	public List<Book> queryAllBook() {
		try {
			List<Book> list= bookDao.queryAllBook();
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Book> quaryLimitBook(Page p) {
		// TODO Auto-generated method stub
		try {
			List<Book> list= bookDao.quaryLimitBook(p);
			return list;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Page page(Page p) {
		// TODO Auto-generated method stub
		return bookDao.page(p);
	}
	//���ѧ����Ϣ
	@Override
	public Book getBookInfo(int id)
		
		{
			// TODO Auto-generated method stub
		   try{
			   Book book=bookDao.getBookInfo(id);
		       return book;
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   return null;
		 
		}
	
	//���ѧ����Ϣ
		@Override
		public Book getBookInfoByBarcode(String barcode)
			
			{
				// TODO Auto-generated method stub
			   try{
				   Book book=bookDao.getBookInfoByBarcode(barcode);
			       return book;
			   }catch(Exception e){
				   e.printStackTrace();
			   }
			   return null;
			 
			}
	//ɾ��ѧ����¼
	@Override
	public boolean afterDelete(String id) {
		// TODO Auto-generated method stub
				boolean delete=false;
				try {
					delete = bookDao.afterDelete(id);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("11111");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("11111");
				}
				return delete;
				
	}
	//����ѧ����¼
	@Override
	public int insertBook(Book book,Manager manager) {
		// TODO Auto-generated method stub
				int count=BookDao.insertBook(book,manager);
				return count;
	}
	//�༭ѧ����¼
	@Override
	public boolean updateBook(Book book) {
		return bookDao.updateBook(book);
	}
	
	
	
	
	
}
