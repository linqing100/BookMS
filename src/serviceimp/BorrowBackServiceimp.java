package serviceimp;
import java.sql.SQLException;
import java.util.List;

import dao.BorrowDao;
import javabean.Page;
import javabean.Borrow;
import javabean.BorrowBack;
import javabean.Manager;
import service.BorrowBackService;
public class BorrowBackServiceimp implements BorrowBackService {
	BorrowDao borrowDao=new BorrowDao();
	//��ҳ��ѯ
	@Override
	public List<Borrow> queryAllBorrow(String barcode) {
		try {
			List<Borrow> list= borrowDao.queryAllBorrow(barcode);
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
	public List<Borrow> quaryLimitBorrow(Page p,String barcode) {
		// TODO Auto-generated method stub
		try {
			List<Borrow> list= borrowDao.quaryLimitBorrow(p,barcode);
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
	public List<BorrowBack> queryLimitBorrowBook(Page p,String barcode) {
		// TODO Auto-generated method stub
		try {
			List<BorrowBack> list= borrowDao.quaryLimitBorrowBook(p,barcode);
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
		return borrowDao.page(p);
	}
	//���ѧ����Ϣ
	@Override
	public Borrow getBorrowInfoByBook(String barcode)
		
		{
			// TODO Auto-generated method stub
		   try{
			   Borrow borrow=borrowDao.getBorrowInfoByBook(barcode);
		       return borrow;
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   return null;
		 
		}
	//���ѧ����Ϣ
		@Override
		public Borrow getBorrowInfoByReader(String barcode)
			
			{
				// TODO Auto-generated method stub
			   try{
				   Borrow borrow=borrowDao.getBorrowInfoByReader(barcode);
			       return borrow;
			   }catch(Exception e){
				   e.printStackTrace();
			   }
			   return null;
			 
			}
	//ɾ��ѧ����¼
	@Override
	public boolean afterDelete(Borrow borrow) {
		// TODO Auto-generated method stub
				boolean delete=false;
				try {
					delete = borrowDao.afterDelete(borrow);
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
	public int insertBorrow(Borrow borrow,Manager manager) {
		// TODO Auto-generated method stub
				int count=BorrowDao.insertBorrow(borrow,manager);
				return count;
	}
	//�༭ѧ����¼
	@Override
	public boolean updateBorrow(Borrow borrow) {
		return borrowDao.updateBorrow(borrow);
	}
	
	
	
	
	
}
