package serviceimp;
import java.sql.SQLException;
import java.util.List;

import dao.ManagerDao;
import javabean.Page;
import javabean.Manager;

import service.ManagerService;
public class ManagerServiceimp implements ManagerService {
	ManagerDao managerDao=new ManagerDao();
	//��ҳ��ѯ
	@Override
	public List<Manager> queryAllManager() {
		try {
			List<Manager> list= managerDao.queryAllManager();
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
	public List<Manager> quaryLimitManager(Page p) {
		// TODO Auto-generated method stub
		try {
			List<Manager> list= managerDao.quaryLimitManager(p);
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
		return managerDao.page(p);
	}
	//���ѧ����Ϣ
	@Override
	public Manager getManagerInfo(int id)
		
		{
			// TODO Auto-generated method stub
		   try{
			   Manager manager=managerDao.getManagerInfo(id);
		       return manager;
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
					delete = managerDao.afterDelete(id);
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
	public int insertManager(Manager manager) {
		// TODO Auto-generated method stub
				int count=ManagerDao.insertManager(manager);
				return count;
	}
	//�༭ѧ����¼
	@Override
	public boolean updateManager(Manager manager) {
		return managerDao.updateManager(manager);
	}
	
	@Override
	public int checkManager(Manager manager) {
		int check = managerDao.checkManager(manager);
		return check;
	}
	
	
	
}
