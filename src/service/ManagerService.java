package service;

import java.util.List;

import javabean.Page;
import javabean.Manager;

public interface ManagerService {
	//��ҳ��ѯ
    List<Manager> quaryLimitManager(Page p);
    public List<Manager> queryAllManager();
	public Page page(Page p);
	//��ȡѧ����Ϣ
	public Manager getManagerInfo(int id);
    //ɾ��ѧ����¼
	public boolean afterDelete(String id);
	//����ѧ����¼
	public int insertManager(Manager manager);
	//�༭ѧ����¼
	public boolean updateManager(Manager manager);
	//验证管理员身份
	
	public int checkManager(Manager manager);

}