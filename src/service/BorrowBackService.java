package service;

import java.util.List;

import javabean.Borrow;
import javabean.BorrowBack;
import javabean.Manager;
import javabean.Page;

public interface BorrowBackService {
	//��ҳ��ѯ
    List<Borrow> quaryLimitBorrow(Page p,String barcode);
    public List<Borrow> queryAllBorrow(String barcode);
    List<BorrowBack> queryLimitBorrowBook(Page p,String barcode);
	public Page page(Page p);
	//通过图书条形码获取借阅信息
	public Borrow getBorrowInfoByBook(String barcode);
	//通过读者条形码获取借阅信息
	public Borrow getBorrowInfoByReader(String barcode);
    //ɾ��ѧ����¼
	public boolean afterDelete(Borrow borrow);
	//����ѧ����¼
	public int insertBorrow(Borrow borrow,Manager manager);
	//�༭ѧ����¼
	public boolean updateBorrow(Borrow borrow);
	//验证管理员身份
	
	
}
