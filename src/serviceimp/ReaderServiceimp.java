package serviceimp;

import java.sql.SQLException;
import java.util.List;

import dao.ReaderDao;
import javabean.Reader;
import javabean.Book;
import javabean.Manager;
import javabean.Page;
import service.ReaderService;

public class ReaderServiceimp implements ReaderService {
   ReaderDao readerDao = new ReaderDao();
   @Override
	public List<Reader> queryAllReader() {
		try {
			List<Reader> list= readerDao.queryAllReader();
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
	public List<Reader> quaryLimitReader(Page p) {
		// TODO Auto-generated method stub
		try {
			List<Reader> list= readerDao.quaryLimitReader(p);
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
		return readerDao.page(p);
	}
	//���ѧ����Ϣ
	@Override
	public Reader getReaderInfo(String barcode){
			// TODO Auto-generated method stub
		   try{
			   Reader reader=readerDao.getReaderInfo(barcode);
		       return reader;
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   return null;
		 
		}
	@Override
	public int checkReader(Reader reader) {
		int check = readerDao.checkReader(reader);
		return check;
	}
	@Override
	public int borrowNumber(String readerType) {
		int number = readerDao.borrowNumber(readerType);
		return number;
	}
	@Override
	public int insertReader(Reader reader,Manager manager) {
		int number = readerDao.insertReader(reader,manager);
		return number;
	}
	@Override
	public boolean afterDelete(String id) {
		// TODO Auto-generated method stub
				boolean delete=false;
				try {
					delete = readerDao.afterDelete(id);
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
	@Override
	public boolean updateReader(Reader reader) {
		return readerDao.updateReader(reader);
	}
	
}
