package action;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import com.opensymphony.xwork2.ActionContext;

import javabean.Page;
import javabean.Manager;
import service.ManagerService;
import serviceimp.ManagerServiceimp;
public class ManagerAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	ManagerService managerService=new ManagerServiceimp();
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
private List<Manager> queryAllManager(){
	List<Manager> managerList=new ArrayList<Manager>();
	managerList=managerService.queryAllManager();
	return managerList;
}

public String page(){
	int start=0;
	int count=0;
	List<Manager> managerList=queryAllManager();
	int totalCount=managerList.size();
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
	Page page=managerService.page( p);
	request.setAttribute("page", page);
	//ActionContext.getContext().put("page",page);
	List<Manager> currentList=new ArrayList<Manager>();
	currentList=managerService.quaryLimitManager(p);
	request.setAttribute("currentList", currentList);
	//ActionContext.getContext().put("currentList",currentList);
	return "manager";
}

    //ɾ��ѧ���¼
	public String deleteManager() throws IOException, ServletException{
		boolean managerdel;
		String id=(String)request.getParameter("id");
		managerdel=managerService.afterDelete(id);
		if(managerdel){
			this.msg="success";
		}else{
			this.msg="failed";
		}
		return "success";
	}

	//ɾ������¼
	public String deleteServal() throws IOException, ServletException{
		try{
			String idAll=request.getParameter("idAll");
			String[] id=idAll.split(",");
			for(int i=0;i<id.length;i++){
				managerService.afterDelete(id[i]);
			}
			this.msg="success";
		}catch(Exception ex){
			ex.printStackTrace();
			this.msg="failed";
		}

		return "success";
	}

	//����ѧ��༭ҳ��
	public String editManager(){
		String id=request.getParameter("id");
		int managerId=0;
		
		try{
			managerId=Integer.parseInt(id);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		Manager manager=managerService.getManagerInfo(managerId);
		if(manager==null) {
			manager=new Manager();
		}
		
		
		request.setAttribute("manager", manager);
		return "success";
	} 

	//�޸�ѧ��
	public String updateManager(){
		ManagerService managerService=new ManagerServiceimp();
		Manager manager=new Manager();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		
		int sysset;
		int readerset;
		int bookset;
		int borrowback;
		if(request.getParameter("sysset")==null) {
			sysset = 0;
		}else {
			sysset = 1;
		}
		if(request.getParameter("readerset")==null) {
			readerset = 0;
		}else {
			readerset = 1;
		}
		if(request.getParameter("bookset")==null) {
			bookset = 0;
		}else {
			bookset = 1;
		}
		if(request.getParameter("borrowback")==null) {
			borrowback = 0;
		}else {
			borrowback = 1;
		}
		
		manager.setId(id);
		manager.setName(name);
		manager.setSysset(sysset);
		manager.setReaderset(readerset);
		manager.setBookset(bookset);
		manager.setBorrowback(borrowback);
		boolean updateflag=managerService.updateManager(manager);
		if(updateflag){
			this.msg="success";
		}else{
			this.msg="failed";
		}
		return "success";
	}
	//�鿴ѧ���¼����
		public String lookManager(){
			String id=request.getParameter("id");
			int managerId=0;
			managerId=Integer.parseInt(id);
			Manager manager=managerService.getManagerInfo(managerId);
			if(manager==null){ 
				manager=new Manager();
			}else
				request.setAttribute("manager", manager);
			return "success";
		}
		//����ѧ���¼
		public String searchManager(){
			String id=request.getParameter("context");
			int managerId=0;
			managerId=Integer.parseInt(id);
			Manager manager=managerService.getManagerInfo(managerId);
			if(manager==null){ 
				manager=new Manager();
				this.msg="搜索无效";
			}else
				request.setAttribute("manager", manager);
			return "success";
		}
	//����ѧ���¼
		public String insertManager(){
			ManagerService managerService=new ManagerServiceimp();
			Manager manager=new Manager();
			//int id=Integer.parseInt(request.getParameter("id"));
			String name=(String)request.getParameter("name");
			String pwd=(String)request.getParameter("pwd");
			int sysset;
			int readerset;
			int bookset;
			int borrowback;
			if(request.getParameter("sysset")==null) {
				sysset = 0;
			}else {
				sysset = 1;
			}
			if(request.getParameter("readerset")==null) {
				readerset = 0;
			}else {
				readerset = 1;
			}
			if(request.getParameter("bookset")==null) {
				bookset = 0;
			}else {
				bookset = 1;
			}
			if(request.getParameter("borrowback")==null) {
				borrowback = 0;
			}else {
				borrowback = 1;
			}
			
			//manager.setId(id);
			manager.setName(name);
			manager.setPwd(pwd);
			manager.setSysset(sysset);
			manager.setReaderset(readerset);
			manager.setBookset(bookset);
			manager.setBorrowback(borrowback);
			int count =managerService.insertManager(manager);
			request.setAttribute("count", count);
			if(count==1){
				this.msg="success";
			}else{
				this.msg="insert failed";
			}
			return "success";


		}
		public String checkManager(){
			String managername=(String)request.getParameter("managername");
			String pwd=request.getParameter("pwd");
			Manager manager=new Manager();
			manager.setName(managername);
			manager.setPwd(pwd);
			int flag = managerService.checkManager(manager);
			if(flag==1){ 
				this.msg="验证成功";
				request.setAttribute("manager", manager);
				return "success";
			}else
				this.msg="用户名或密码错误";
			    return "fail";
			
		}
	}
