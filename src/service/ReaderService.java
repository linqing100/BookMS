package service;

import java.util.List;


import javabean.Page;
import javabean.Reader;
import javabean.Manager;
public interface ReaderService {
	//查读者信息
    List<Reader> quaryLimitReader(Page p);
    public List<Reader> queryAllReader();
	public Page page(Page p);
	//获取一条读者信息
	public Reader getReaderInfo(String barcode);
	public int checkReader(Reader reader);
	public int borrowNumber(String readerType);
	public int insertReader(Reader reader,Manager manager);
	public boolean afterDelete(String id);
	public boolean updateReader(Reader reader);
}
