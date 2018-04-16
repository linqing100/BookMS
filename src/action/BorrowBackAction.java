package action;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import com.opensymphony.xwork2.ActionContext;

import javabean.Page;

import javabean.Borrow;
import javabean.BorrowBack;
import javabean.Book;
import javabean.Reader;
import javabean.Manager;
import service.BorrowBackService;
import service.BookService;
import service.ReaderService;
import serviceimp.BorrowBackServiceimp;
import serviceimp.BookServiceimp;
import serviceimp.ReaderServiceimp;
public class BorrowBackAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	BorrowBackService borrowBackService=new BorrowBackServiceimp();
	public String msg;
    Page p=new Page();
    public Page getP() {
		return p;
	}
	public void setP(Page p) {
		this.p = p;
	}
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
//查询所有借阅信息
private List<Borrow> queryAllBorrow(){
	List<Borrow> borrowList=new ArrayList<Borrow>();
	String readerid=request.getParameter("context");
	borrowList=borrowBackService.queryAllBorrow(readerid);
	return borrowList;
}

public String page(){
	int start=0;
	int count=0;
	List<Borrow> borrowList=queryAllBorrow();
	int totalCount=borrowList.size();
	int everyCount=2;
	String cp = request.getParameter("currentPage");
	int currentPage=1;
	if(cp != null && !"".equals(cp)){
		currentPage = Integer.parseInt(cp);
	}
	p.setEveryCount(everyCount);
	p.setTotalCount(totalCount);
 	p.setCurrentPage(currentPage);
 	int remainder=0;
 	remainder=p.getTotalCount()%p.getEveryCount();
 	if(remainder==0){
 		p.setPageCount(p.getTotalCount()/p.getEveryCount());
 	}else{
 		p.setPageCount(p.getTotalCount()/p.getEveryCount()+1);
 	}
 	start=(p.getCurrentPage()-1)*(p.getEveryCount());
    count=p.getEveryCount();
    p.setStart(start);
	p.setCount(count);
	Page page=borrowBackService.page( p);
	request.setAttribute("page", page);
	//ActionContext.getContext().put("page",page);
	List<BorrowBack> currentList=new ArrayList<BorrowBack>();
	String readerid=request.getParameter("context");
	currentList=borrowBackService.queryLimitBorrowBook(p,readerid);
	request.setAttribute("currentList", currentList);
	ReaderService readerService = new ReaderServiceimp();
	Reader reader=readerService.getReaderInfo(readerid);
	if(reader==null){ 
		reader=new Reader();
		this.msg="search reader fail";
	}else {
	request.setAttribute("reader", reader);
	    this.msg="success";
	}
	
	
	//ActionContext.getContext().put("currentList",currentList);
	return "renewok";
}
public String pageback(){
	int start=0;
	int count=0;
	List<Borrow> borrowList=queryAllBorrow();
	int totalCount=borrowList.size();
	int everyCount=2;
	String cp = request.getParameter("currentPage");
	int currentPage=1;
	if(cp != null && !"".equals(cp)){
		currentPage = Integer.parseInt(cp);
	}
	p.setEveryCount(everyCount);
	p.setTotalCount(totalCount);
 	p.setCurrentPage(currentPage);
 	int remainder=0;
 	remainder=p.getTotalCount()%p.getEveryCount();
 	if(remainder==0){
 		p.setPageCount(p.getTotalCount()/p.getEveryCount());
 	}else{
 		p.setPageCount(p.getTotalCount()/p.getEveryCount()+1);
 	}
 	start=(p.getCurrentPage()-1)*(p.getEveryCount());
    count=p.getEveryCount();
    p.setStart(start);
	p.setCount(count);
	Page page=borrowBackService.page( p);
	request.setAttribute("page", page);
	//ActionContext.getContext().put("page",page);
	List<BorrowBack> currentList=new ArrayList<BorrowBack>();
	String readerid=request.getParameter("context");
	currentList=borrowBackService.queryLimitBorrowBook(p,readerid);
	request.setAttribute("currentList", currentList);
	ReaderService readerService = new ReaderServiceimp();
	Reader reader=readerService.getReaderInfo(readerid);
	if(reader==null){ 
		reader=new Reader();
		this.msg="search reader fail";
	}else {
	request.setAttribute("reader", reader);
	    this.msg="success";
	}
	
	
	//ActionContext.getContext().put("currentList",currentList);
	return "bookbackok";
}

    //ɾ��ѧ���¼
	public String deleteBorrow() throws IOException, ServletException{
		boolean borrowdel;
		Borrow borrow=new Borrow();
		String readerid=request.getParameter("readerid");
		String bookid = request.getParameter("bookid");
 		borrow.setReaderid(readerid);
 		borrow.setBookid(bookid);
		borrowdel=borrowBackService.afterDelete(borrow);
		if(borrowdel){
			this.msg="success";
		}else{
			this.msg="failed";
		}
		return "success";
	}

	//删除多个
	/*public String deleteServal() throws IOException, ServletException{
		try{
			String idAll=request.getParameter("idAll");
			String[] id=idAll.split(",");
			for(int i=0;i<id.length;i++){
				borrowBackService.afterDelete(id[i]);
			}
			this.msg="success";
		}catch(Exception ex){
			ex.printStackTrace();
			this.msg="failed";
		}

		return "success";
	}*/

	//����ѧ��༭ҳ��
	/*public String editBorrow(){
		String id=request.getParameter("id");
		int borrowId=0;
		
		try{
			borrowId=Integer.parseInt(id);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		Borrow borrow=borrowBackService.getBorrowInfo(borrowId);
		if(borrow==null) {
			borrow=new Borrow();
		}
		
		
		request.setAttribute("borrow", borrow);
		return "success";
	} */

	//�޸�ѧ��
	public String updateBorrow(){
		BorrowBackService borrowBackService=new BorrowBackServiceimp();
		Borrow borrow=new Borrow();
		String readerid=request.getParameter("readerid");
		String bookid = request.getParameter("bookid");
 		  borrow.setReaderid(readerid);
 		  borrow.setBookid(bookid);
 		 
		boolean updateflag=borrowBackService.updateBorrow(borrow);
		if(updateflag){
			this.msg="success";
		}else{
			this.msg="failed";
		}
		return "success";
	}
	//�鿴ѧ���¼����
		/*public String lookBorrow(){
			String id=request.getParameter("id");
			int borrowId=0;
			borrowId=Integer.parseInt(id);
			Borrow borrow=borrowBackService.getBorrowInfo(borrowId);
			if(borrow==null){ 
				borrow=new Borrow();
			}else
				request.setAttribute("borrow", borrow);
			return "success";
		}*/
		//查询图书和借阅信息
		public String searchBorrowByBook(){
			BookService bookService = new BookServiceimp();
			String code=request.getParameter("context");
			//int barcode=0;
			//barcode=Integer.parseInt(code);
			Book book=bookService.getBookInfoByBarcode(code);
			Borrow borrow=borrowBackService.getBorrowInfoByBook(code);
			if(book==null||borrow==null){ 
				borrow=new Borrow();
				book=new Book();
				this.msg="搜索无效";
			}else {
				request.setAttribute("book", book);
				request.setAttribute("borrow", borrow);
			}
			return "success";
		}
		//通过读者条形码查询图书和借阅信息
				public String searchBorrowByReader(){
					ReaderService readerService = new ReaderServiceimp();
					//BookService bookService = new BookServiceimp();
					String code=request.getParameter("context");
					//int barcode=0;
					//barcode=Integer.parseInt(code);
					Reader reader=readerService.getReaderInfo(code);
					//Borrow borrow=borrowBackService.getBorrowInfoByReader(code);
					if(reader==null){ 
						reader=new Reader();
						this.msg="search reader fail";
					}//if(borrow==null){
						//borrow=new Borrow();
						//this.msg="search borrow fail";
					else {
						request.setAttribute("reader", reader);
						/*request.setAttribute("borrow", borrow);
						String bookid = borrow.getBookid();
						Book book = bookService.getBookInfoByBarcode(bookid);
						if(book==null) {
							book = new Book();
	                        this.msg="search book fail";
						}else {
							request.setAttribute("book", book);
						}*/
						this.msg = "success";
					}
					return "success";
				}
	//����ѧ���¼
		public String insertBorrow(){
			BorrowBackService borrowBackService=new BorrowBackServiceimp();
			Borrow borrow=new Borrow();
			Manager manager = new Manager();
			manager.setName((String)request.getParameter("managername"));
			//int id=Integer.parseInt(request.getParameter("id"));
			String readerid = request.getParameter("readerid");
			String bookid = request.getParameter("bookid");
			String borrowTime = (String)request.getParameter("borrowTime");
			String backTime = (String)request.getParameter("backTime");
			String operator = (String)request.getParameter("operater");
			int ifback = Integer.parseInt(request.getParameter("ifback"));
			
		    
			  borrow.setReaderid(readerid);
	 		  borrow.setBookid(bookid);
	 		  borrow.setBorrowTime(borrowTime);
	 		  borrow.setBackTime(backTime);
	 		  borrow.setOperator(operator);
	 		  borrow.setIfback(ifback);
			
			int count =borrowBackService.insertBorrow(borrow,manager);
			request.setAttribute("count", count);
			if(count==1){
				this.msg="success";
			}else{
				this.msg="insert failed";
			}
			return "success";


		}
		
	}
