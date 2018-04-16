package service;

import java.util.List;

import javabean.Page;
import javabean.Book;
import javabean.Manager;

public interface BookService {
	//��ҳ��ѯ
    List<Book> quaryLimitBook(Page p);
    public List<Book> queryAllBook();
	public Page page(Page p);
	//��ȡѧ����Ϣ
	public Book getBookInfo(int id);
	//通过条形码获取图书信息
	public Book getBookInfoByBarcode(String barcode);
    //ɾ��ѧ����¼
	public boolean afterDelete(String id);
	//����ѧ����¼
	public int insertBook(Book book,Manager manager);
	//�༭ѧ����¼
	public boolean updateBook(Book book);
	//验证管理员身份
	
	

}