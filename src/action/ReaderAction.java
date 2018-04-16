package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import javabean.Book;
import javabean.Manager;
import javabean.Page;
import javabean.Reader;
import service.BookService;
import service.ReaderService;
import serviceimp.BookServiceimp;
import serviceimp.ReaderServiceimp;

public class ReaderAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	ReaderService readerService = new ReaderServiceimp();
	public String msg;
	Page p = new Page();
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
	//查看所有读者信息
	private List<Reader> queryAllReader(){
		List<Reader> readerList=new ArrayList<Reader>();
		readerList=readerService.queryAllReader();
		return readerList;
	}
    //分页显示
	public String page(){
		int start=0;
		int count=0;
		List<Reader> readerList=queryAllReader();
		int totalCount=readerList.size();
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
		Page page=readerService.page( p);
		request.setAttribute("page", page);
		//ActionContext.getContext().put("page",page);
		List<Reader> currentList=new ArrayList<Reader>();
		currentList=readerService.quaryLimitReader(p);
		request.setAttribute("currentList", currentList);
		//ActionContext.getContext().put("currentList",currentList);
		return "reader";
	}
	//查看读者信息
	public String lookReader(){
		String barcode=(String)request.getParameter("readerBarcode");
		//String readerBarcode="";
		//readerBarcode=barcode;
		Reader reader=readerService.getReaderInfo(barcode);
		
		if(reader==null){ 
			reader=new Reader();
		}else {
			request.setAttribute("reader", reader);
			int number=readerService.borrowNumber(reader.getReaderType());
			request.setAttribute("number", number);
		}
		return "success";
	}
	
	//验证读者信息
	public String checkReader(){
		String barcode=(String)request.getParameter("readerBarcode");
		//String pwd=request.getParameter("pwd");
		Reader reader=new Reader();
		reader.setBarcode(barcode);
		//reader.setPwd(pwd);
		int flag = readerService.checkReader(reader);
		if(flag==1){ 
			this.msg="验证成功";
			request.setAttribute("reader", reader);
			return "success";
		}else
			this.msg="不存在该用户";
		    return "fail";
		
	}
	//增加读者信息
	public String insertReader(){
		ReaderService Service=new ReaderServiceimp();
		Reader reader=new Reader();
		Manager manager = new Manager();
		manager.setName((String)request.getParameter("managername"));
		String name = (String)request.getParameter("readername");
		String sex = (String)request.getParameter("sex");
		String paperType = (String)request.getParameter("paperType");
		String paperNO = (String)request.getParameter("paperNO");
		String birthday = (String)request.getParameter("birthday");
		String tel = (String)request.getParameter("tel");
		String email = (String)request.getParameter("email");
		String barcode = (String)request.getParameter("barcode");
		String readerType = (String)request.getParameter("readerType");
		String remark = (String)request.getParameter("remark");
	
		reader.setBarcode(barcode);
	    reader.setBirthday(birthday);
	    reader.setEmail(email);
	    reader.setName(name);
	    reader.setPaperNO(paperNO);
	    reader.setPaperType(paperType);
	    reader.setReaderType(readerType);
	    reader.setRemark(remark);
	    reader.setSex(sex);
	    reader.setTel(tel);
	      
		
		int count =readerService.insertReader(reader,manager);
		request.setAttribute("count", count);
		if(count==1){
			this.msg="success";
		}else{
			this.msg="insert failed";
		}
		return "success";


	}
	 //删除读者信息
		public String deleteReader() throws IOException, ServletException{
			boolean readerdel;
			String id=(String)request.getParameter("id");
			readerdel=readerService.afterDelete(id);
			if(readerdel){
				this.msg="success";
			}else{
				this.msg="failed";
			}
			return "success";
		}
		
		//编辑读者信息
		public String editReader(){
			String barcode=request.getParameter("barcode");
			
			Reader reader=readerService.getReaderInfo(barcode);
			if(reader==null) {
				reader=new Reader();
			}
			
			
			request.setAttribute("reader", reader);
			return "success";
		} 
		//更新
		public String updateReader(){
			ReaderService readerService=new ReaderServiceimp();
			Reader reader=new Reader();
			int id=Integer.parseInt(request.getParameter("id"));
			String name = (String)request.getParameter("readername");
			String sex = (String)request.getParameter("sex");
			String paperType = (String)request.getParameter("paperType");
			String paperNO = (String)request.getParameter("paperNO");
			String birthday = (String)request.getParameter("birthday");
			String tel = (String)request.getParameter("tel");
			String email = (String)request.getParameter("email");
			String barcode = (String)request.getParameter("barcode");
			String readerType = (String)request.getParameter("readerType");
			String remark = (String)request.getParameter("remark");
			
			reader.setBarcode(barcode);
		    reader.setBirthday(birthday);
		    reader.setEmail(email);
		    reader.setName(name);
		    reader.setPaperNO(paperNO);
		    reader.setPaperType(paperType);
		    reader.setReaderType(readerType);
		    reader.setRemark(remark);
		    reader.setSex(sex);
		    reader.setTel(tel);
		    reader.setId(id);
			boolean updateflag=readerService.updateReader(reader);
			if(updateflag){
				this.msg="success";
			}else{
				this.msg="failed";
			}
			return "success";
		}
		//搜索读者
				public String searchReader(){
					String barcode=request.getParameter("context");
					
					Reader reader=readerService.getReaderInfo(barcode);
					if(reader==null){ 
						reader=new Reader();
						this.msg="搜索无效";
					}else
						request.setAttribute("reader", reader);
					return "success";
				}
}
