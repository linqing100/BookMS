   package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javabean.Page;
import javabean.Manager;
import util.ConnectionDB;

public class ManagerDao {
	//查询所有管理员信息
	public List<Manager> queryAllManager() throws ClassNotFoundException, SQLException{
   	  List<Manager> result=new ArrayList<Manager>();
   	  Connection conn=ConnectionDB.getConnection();
   	  String sql="select tb_manager.id,tb_manager.name,tb_powerview.sysset,tb_powerview.readerset,tb_powerview.bookset,tb_powerview.borrowback from tb_manager,tb_powerview where tb_manager.id=tb_powerview.id";
   	  PreparedStatement pstate=conn.prepareStatement(sql);
   	  ResultSet rs=pstate.executeQuery();
   	  while(rs.next()){
   		Manager manager=new Manager();
   		  manager.setId(rs.getInt(1));
   		  manager.setName(rs.getString(2));
   		  manager.setSysset(rs.getInt(3));
   		  manager.setReaderset(rs.getInt(4));
   		  manager.setBookset(rs.getInt(5));
   		  manager.setBorrowback(rs.getInt(6));
   		  
   		  result.add(manager);
   	  }
   	  
   	  return result;
     }
    
     public Page page(Page p){
   	  return p;
   	  
   	  }
   public List<Manager> quaryLimitManager( Page p) throws ClassNotFoundException, SQLException{
    	  page(p);
    	  List<Manager> result=new ArrayList<Manager>();
    	  Connection conn=ConnectionDB.getConnection();
    	  String sql="select tb_manager.id,tb_manager.name,tb_powerview.sysset,tb_powerview.readerset,tb_powerview.bookset,tb_powerview.borrowback from tb_manager,tb_powerview where tb_manager.id=tb_powerview.id limit ?,?";
    	  PreparedStatement pstate=conn.prepareStatement(sql);
    	  pstate.setInt(1, p.getStart());
    	  pstate.setInt(2, p.getCount());
    	  ResultSet rs=pstate.executeQuery();
    	  while(rs.next()){
    		  Manager manager=new Manager();
       		  manager.setId(rs.getInt(1));
       		  manager.setName(rs.getString(2));
       		  manager.setSysset(rs.getInt(3));
       		  manager.setReaderset(rs.getInt(4));
       		  manager.setBookset(rs.getInt(5));
       		  manager.setBorrowback(rs.getInt(6));
       		  
       		  result.add(manager);
    	  }
    	  
    	  return result;
  
      }
   //删除管理员信息
   public  boolean afterDelete(String id) throws ClassNotFoundException,SQLException{
 	  Connection conn=ConnectionDB.getConnection();
 	  String sql="delete from tb_manager where id=?";
 	  String sql2="delete from tb_powerview where id=?";
 	  PreparedStatement pstate=conn.prepareStatement(sql);
 	  PreparedStatement pstate2=conn.prepareStatement(sql2);
 	  pstate.setString(1, id);
 	  pstate2.setString(1, id);
 	  int rs=pstate.executeUpdate();
 	  int rs2=pstate.executeUpdate();
 	  if(rs==1&&rs2==1){
 		  return true;
 	  }
 	  return false;
   }

   //更新管理员信息
   public boolean updateManager(Manager manager) {
   	Connection conn;
		try {
			conn = ConnectionDB.getConnection();
			String sql="update tb_manager set name=? where id=?";
			String sql2="update tb_powerview set sysset=?,readerset=?,bookset=?,borrowback=?  where id=?";
	    	  PreparedStatement pstate=conn.prepareStatement(sql);
	    	  PreparedStatement pstate2=conn.prepareStatement(sql2);
	    	  pstate.setString(1, manager.getName());
	    	  pstate.setInt(2, manager.getId());
	    	  pstate2.setInt(1, manager.getSysset());
	    	  pstate2.setInt(2, manager.getReaderset());
	    	  pstate2.setInt(3, manager.getBookset());
	    	  pstate2.setInt(4, manager.getBorrowback());
	    	  pstate2.setInt(5, manager.getId());
	    	  int shu=pstate.executeUpdate();
	    	  int shu2=pstate2.executeUpdate();
	    	  if(shu>0&&shu2>0){
	    		  return true;
	    	  }else{
	    		  return false;
	    	  }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	 return false; 
     }
   //获取管理员信息
   public static Manager getManagerInfo(int id) throws ClassNotFoundException,SQLException{
 	  Connection conn=ConnectionDB.getConnection();
 	  String sql="select tb_manager.id,tb_manager.name from tb_manager where id=?";
 	 String sql2="select tb_powerview.sysset,tb_powerview.readerset,tb_powerview.bookset,tb_powerview.borrowback from tb_powerview where id=?";
 	  PreparedStatement pstate=conn.prepareStatement(sql);
 	  PreparedStatement pstate2=conn.prepareStatement(sql2);
 	  pstate.setInt(1, id);
 	  pstate2.setInt(1, id);
 	  ResultSet rs=pstate.executeQuery();
 	  ResultSet rs2=pstate2.executeQuery();
 	  Manager manager=new Manager();
 	  if(rs.next()){
  		  manager.setId(rs.getInt(1));
  		  manager.setName(rs.getString(2));
  		 
 	  }
 	  if(rs2.next()) {
 		 manager.setSysset(rs2.getInt(1));
 		  manager.setReaderset(rs2.getInt(2));
 		  manager.setBookset(rs2.getInt(3));
 		  manager.setBorrowback(rs2.getInt(4));
 	  }
 	  return manager;
   } 

   
   //新增管理员信息
   public static int insertManager(Manager manager){
 	  Connection conn;
		try {
			conn = ConnectionDB.getConnection();
			String sql="insert into tb_manager(name,pwd) values(?,?)";
			String sql2="insert into tb_powerview(sysset,readerset,bookset,borrowback) values(?,?,?,?)";
	    	  PreparedStatement pstate=conn.prepareStatement(sql);
	    	  PreparedStatement pstate2=conn.prepareStatement(sql2);
	    	  pstate.setString(1, manager.getName());
	    	  pstate.setString(2, manager.getPwd());
	    	  
	    	  pstate2.setInt(1, manager.getSysset());
	    	  pstate2.setInt(2, manager.getReaderset());
	    	  pstate2.setInt(3, manager.getBookset());
	    	  pstate2.setInt(4, manager.getBorrowback());
	    	  int count=pstate.executeUpdate();
	    	  int count2=pstate2.executeUpdate();
	    	  if(count>0&&count2>0){
	    		  System.out.println("新增成功") ;
	    		  return count;
	    	  }else{
	    		  System.out.println("新增失败");
	    		  return 0;
	    	  }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	  return 0;
   }
   //验证管理员身份
      public int checkManager(Manager manager) {
    	  int flag = 0;
    	  Connection conn;
    	  try {
    	  conn = ConnectionDB.getConnection();
    	  String sql = "select * from tb_manager where name ='"+manager.getName()+"' ";
    	  PreparedStatement pstate=conn.prepareStatement(sql);
    	  ResultSet rs = pstate.executeQuery(sql);
    	   if(rs.next()) {
    		   String pwd = manager.getPwd();
    		   if(pwd.equals(rs.getString(3))) {
    			   flag = 1;
    		   }else {
    			   flag = 0;
    		   }
    	   }else {
    			   flag = 0;
    		   }   
    	   
    	  }catch (ClassNotFoundException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		  } catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		  }return flag;
      }
}