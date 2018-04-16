package action;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import com.opensymphony.xwork2.ActionContext;

import javabean.Page;
import javabean.Book;
import javabean.Manager;
import service.BookService;
import serviceimp.BookServiceimp;
public class BookAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	BookService bookService=new BookServiceimp();
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
//��ҳ��ѯ
private List<Book> queryAllBook(){
	List<Book> bookList=new ArrayList<Book>();
	bookList=bookService.queryAllBook();
	return bookList;
}

public String page(){
	int start=0;
	int count=0;
	List<Book> bookList=queryAllBook();
	int totalCount=bookList.size();
	int everyCount=6;
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
	Page page=bookService.page( p);
	request.setAttribute("page", page);
	//ActionContext.getContext().put("page",page);
	List<Book> currentList=new ArrayList<Book>();
	currentList=bookService.quaryLimitBook(p);
	request.setAttribute("currentList", currentList);
	//ActionContext.getContext().put("currentList",currentList);
	return "bookinfo";
}

    //ɾ��ѧ���¼
	public String deleteBook() throws IOException, ServletException{
		boolean bookdel;
		String id=(String)request.getParameter("id");
		bookdel=bookService.afterDelete(id);
		if(bookdel){
			this.msg="success";
		}else{
			this.msg="failed";
		}
		return "success";
	}

	//删除多个
	public String deleteServal() throws IOException, ServletException{
		try{
			String idAll=request.getParameter("idAll");
			String[] id=idAll.split(",");
			for(int i=0;i<id.length;i++){
				bookService.afterDelete(id[i]);
			}
			this.msg="success";
		}catch(Exception ex){
			ex.printStackTrace();
			this.msg="failed";
		}

		return "success";
	}

	//����ѧ��༭ҳ��
	public String editBook(){
		String id=request.getParameter("id");
		int bookId=0;
		
		try{
			bookId=Integer.parseInt(id);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		Book book=bookService.getBookInfo(bookId);
		if(book==null) {
			book=new Book();
		}
		
		
		request.setAttribute("book", book);
		return "success";
	} 

	//�޸�ѧ��
	public String updateBook(){
		BookService bookService=new BookServiceimp();
		Book book=new Book();
		int id=Integer.parseInt(request.getParameter("id"));
		String bookname=request.getParameter("bookname");
		int typeid = Integer.parseInt(request.getParameter("typeid"));
		String author = request.getParameter("author");
		String translator = request.getParameter("translator");
	    String ISBN = request.getParameter("ISBN");
	    float price = Float.parseFloat(request.getParameter("price"));
	    String bookpage = (String)request.getParameter("bookpage");
	    String bookcase = (String)request.getParameter("bookcase");
	    //String operator = request.getParameter("operator");
	      book.setBookname(bookname);
 		  book.setTypeid(typeid);
 		  book.setAuthor(author);
 		  book.setTranslator(translator);
 		  book.setISBN(ISBN);
 		  book.setPrice(price);
 		  book.setBookpage(bookpage);
 		  
 		  //book.setOperator(operator);
 		  book.setId(id);
 		  book.setBookcase(bookcase);
		boolean updateflag=bookService.updateBook(book);
		if(updateflag){
			this.msg="success";
		}else{
			this.msg="failed";
		}
		return "success";
	}
	//�鿴ѧ���¼����
		public String lookBook(){
			String id=request.getParameter("id");
			int bookId=0;
			bookId=Integer.parseInt(id);
			Book book=bookService.getBookInfo(bookId);
			if(book==null){ 
				book=new Book();
			}else
				request.setAttribute("book", book);
			return "success";
		}
		//����ѧ���¼
		public String searchBook(){
			String id=request.getParameter("context");
			int bookId=0;
			bookId=Integer.parseInt(id);
			Book book=bookService.getBookInfo(bookId);
			if(book==null){ 
				book=new Book();
				this.msg="搜索无效";
			}else
				request.setAttribute("book", book);
			return "success";
		}
	//����ѧ���¼
		public String insertBook(){
			BookService bookService=new BookServiceimp();
			Book book=new Book();
			Manager manager = new Manager();
			manager.setName((String)request.getParameter("managername"));
			//int id=Integer.parseInt(request.getParameter("id"));
			String bookname=(String)request.getParameter("bookname");
			int typeid = Integer.parseInt(request.getParameter("typeid"));
			String author = (String)request.getParameter("author");
			String translator = (String)request.getParameter("translator");
		    String ISBN = (String)request.getParameter("ISBN");
		    float price = Float.parseFloat(request.getParameter("price"));
		    String bookpage;
		    if((String)request.getParameter("bookpage")==null) {
		         bookpage = null;
		    }else {
		    	 bookpage = (String)request.getParameter("bookpage");
		    }
		    String bookcase = (String)(request.getParameter("bookcase"));
		    String operator = (String)request.getParameter("operator");
		      book.setBookname(bookname);
	 		  book.setTypeid(typeid);
	 		  book.setAuthor(author);
	 		  book.setTranslator(translator);
	 		  book.setISBN(ISBN);
	 		  book.setPrice(price);
	 		  book.setBookpage(bookpage);
	 		  
	 		  book.setOperator(operator);
	 		 // book.setId(id);
	 		  book.setBookcase(bookcase);
			
			int count =bookService.insertBook(book,manager);
			request.setAttribute("count", count);
			if(count==1){
				this.msg="success";
			}else{
				this.msg="insert failed";
			}
			return "success";


		}
		
	}
