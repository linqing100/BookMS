   package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import javabean.Page;
import javabean.Borrow;
import javabean.BorrowBack;
import javabean.Manager;
import util.ConnectionDB;

public class BorrowDao {
	//查询该读者所有借阅信息
	public List<Borrow> queryAllBorrow(String barcode) throws ClassNotFoundException, SQLException{
   	  List<Borrow> result=new ArrayList<Borrow>();
   	  Connection conn=ConnectionDB.getConnection();
   	  String sql="select * from tb_borrow where readerid=?";
   	  PreparedStatement pstate=conn.prepareStatement(sql);
   	  pstate.setString(1, barcode);
   	  ResultSet rs=pstate.executeQuery();
   	  while(rs.next()){
   		Borrow borrow=new Borrow();
   		borrow.setId(rs.getInt(1));
   		borrow.setReaderid(rs.getString(2));
   		borrow.setBookid(rs.getString(3));
   		borrow.setBorrowTime(rs.getString(4));
   		borrow.setBackTime(rs.getString(5));
   		borrow.setOperator(rs.getString(6));
   		borrow.setIfback(rs.getInt(7));
   		  
   		  result.add(borrow);
   	  }
   	  
   	  return result;
     }
    
     public Page page(Page p){
   	  return p;
   	  
   	  }
   public List<Borrow> quaryLimitBorrow( Page p,String barcode) throws ClassNotFoundException, SQLException{
    	  page(p);
    	  List<Borrow> result=new ArrayList<Borrow>();
    	  Connection conn=ConnectionDB.getConnection();
    	  String sql="select * from tb_borrow where readerid=? limit ?,?";
    	  PreparedStatement pstate=conn.prepareStatement(sql);
    	  pstate.setString(1, barcode);
    	  pstate.setInt(2, p.getStart());
    	  pstate.setInt(3, p.getCount());
    	  ResultSet rs=pstate.executeQuery();
    	  while(rs.next()){
    		  Borrow borrow=new Borrow();
    		  borrow.setId(rs.getInt(1));
       		  borrow.setReaderid(rs.getString(2));
       		  borrow.setBookid(rs.getString(3));
       		  borrow.setBorrowTime(rs.getString(4));
       		  borrow.setBackTime(rs.getString(5));
       		  borrow.setOperator(rs.getString(6));
       		  borrow.setIfback(rs.getInt(7));
       		 
       		  
       		  result.add(borrow);
    	  }
    	  
    	  return result;
  
      }
   public List<BorrowBack> quaryLimitBorrowBook( Page p,String barcode) throws ClassNotFoundException, SQLException{
 	  page(p);
 	  List<BorrowBack> result=new ArrayList<BorrowBack>();
 	  Connection conn=ConnectionDB.getConnection();
 	  String sql="select * from tb_borrow where readerid=? limit ?,?";
 	  PreparedStatement pstate=conn.prepareStatement(sql);
 	  pstate.setString(1, barcode);
 	  pstate.setInt(2, p.getStart());
 	  pstate.setInt(3, p.getCount());
 	  ResultSet rs=pstate.executeQuery();
 	  while(rs.next()){
 		 
 		  BorrowBack borrowback = new BorrowBack();
 		  borrowback.setBackTime(rs.getString(5));
 		  borrowback.setBorrowTime(rs.getString(4));
 		  borrowback.setReaderid(rs.getString(2));
 		  String sql2="select * from tb_bookinfo where barcode=?";
 		  PreparedStatement pstate2=conn.prepareStatement(sql2);
 		  String bookid = rs.getString(3);
 	 	  pstate2.setString(1, bookid);
 	 	  ResultSet rs2=pstate2.executeQuery();
 	 	  while(rs2.next()){
 	 		  borrowback.setBookname(rs2.getString(1));
 	 		  borrowback.setISBN(rs2.getString(5));
 	 		  borrowback.setPrice(rs2.getString(6));
 	 		  borrowback.setBookcase(rs2.getString(8));
 	 		  borrowback.setBookid(rs2.getString(12));
 	 	  }
 	 	 
    		  result.add(borrowback);
 	  }
 	  
 	  return result;

   }
   //删除管理员信息
   public  boolean afterDelete(Borrow borrow) throws ClassNotFoundException,SQLException{
 	  Connection conn=ConnectionDB.getConnection();
 	  String sql="delete from tb_borrow where readerid=? and bookid=?";
 	 // String sql2="delete from tb_bookcase where id=?";
 	 // String sql3="delete from tb_booktype where id=?";
 	  PreparedStatement pstate=conn.prepareStatement(sql);
 	  //PreparedStatement pstate2=conn.prepareStatement(sql2);
 	  //PreparedStatement pstate3=conn.prepareStatement(sql3);
 	  pstate.setString(1, borrow.getReaderid());
 	  pstate.setString(2, borrow.getBookid());
 	 // pstate2.setString(1, id);
 	 // pstate3.setString(1, id);
 	  int rs=pstate.executeUpdate();
 	 // int rs2=pstate2.executeUpdate();
 	 // int rs3=pstate3.executeUpdate();
 	  if(rs==1){
 		  return true;
 	  }
 	  return false;
   }

   //图书续借更新
   public boolean updateBorrow(Borrow borrow) {
   	Connection conn;
		try {
			conn = ConnectionDB.getConnection();
			
			String sql2="update tb_borrow set borrowTime=?,backTime=? where readerid=? and bookid=? ";
	    	 
	    	  PreparedStatement pstate2=conn.prepareStatement(sql2);
	    	  Date date = new Date();
	    	  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    	  String time = df.format(date);
	    	  pstate2.setString(1, time);
	    	  Calendar cal = Calendar.getInstance();
	    	  cal.setTime(date);
	    	  cal.add(Calendar.DAY_OF_MONTH, 20);
	    	  String backTime = df.format(cal.getTime());
	    	  pstate2.setString(2, backTime);
	    	  pstate2.setString(3, borrow.getReaderid());
	    	  pstate2.setString(4, borrow.getBookid());
	    	  
	    	  
	    	  int shu2=pstate2.executeUpdate();
	    	  if(shu2>0){
	    		 
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
   //通过图书条形码获取借阅信息
   public static Borrow getBorrowInfoByBook(String barcode) throws ClassNotFoundException,SQLException{
 	  Connection conn=ConnectionDB.getConnection();
 	  String sql="select * from tb_borrow where bookid=?";
 	 //String sql2="select tb_powerview.sysset,tb_powerview.readerset,tb_powerview.bookset,tb_powerview.borrowback from tb_powerview where id=?";
 	  PreparedStatement pstate=conn.prepareStatement(sql);
 	 // PreparedStatement pstate2=conn.prepareStatement(sql2);
 	  pstate.setString(3, barcode);
 	 // pstate2.setInt(1, id);
 	  ResultSet rs=pstate.executeQuery();
 	 // ResultSet rs2=pstate2.executeQuery();
 	 Borrow borrow=new Borrow();
 	  if(rs.next()){
 		  borrow.setId(rs.getInt(1));
  		  borrow.setReaderid(rs.getString(2));
  		  borrow.setBookid(rs.getString(3));
  		  borrow.setBorrowTime(rs.getString(4));
  		  borrow.setBackTime(rs.getString(5));
  		  borrow.setOperator(rs.getString(6));
  		  borrow.setIfback(rs.getInt(7));
  		 
  		 // book.setName(rs.getString(2));
  		 
 	  }
 	  
 	  return borrow;
   } 
   
   
 //通过读者条形码获取借阅信息
   public static Borrow getBorrowInfoByReader(String barcode) throws ClassNotFoundException,SQLException{
 	  Connection conn=ConnectionDB.getConnection();
 	  String sql="select * from tb_borrow where readerid=?";
 	 //String sql2="select tb_powerview.sysset,tb_powerview.readerset,tb_powerview.bookset,tb_powerview.borrowback from tb_powerview where id=?";
 	  PreparedStatement pstate=conn.prepareStatement(sql);
 	 // PreparedStatement pstate2=conn.prepareStatement(sql2);
 	  pstate.setString(1, barcode);
 	 // pstate2.setInt(1, id);
 	  ResultSet rs=pstate.executeQuery();
 	 // ResultSet rs2=pstate2.executeQuery();
 	 Borrow borrow=new Borrow();
 	  if(rs.next()){
 		  borrow.setId(rs.getInt(1));
  		  borrow.setReaderid(rs.getString(2));
  		  borrow.setBookid(rs.getString(3));
  		  borrow.setBorrowTime(rs.getString(4));
  		  borrow.setBackTime(rs.getString(5));
  		  borrow.setOperator(rs.getString(6));
  		  borrow.setIfback(rs.getInt(7));
  		 
  		 // book.setName(rs.getString(2));
  		 
 	  }
 	  
 	  return borrow;
   } 

   
   //新增管理员信息
   public static int insertBorrow(Borrow borrow,Manager manager){
 	  Connection conn;
		try {
			conn = ConnectionDB.getConnection();
			String sql="insert into tb_borrow(readerid,bookid,borrowTime,backTime,operator,ifback) values(?,?,?,?,?,?)";
			//String sql2="insert into tb_bookcase(bookcase) values(?)";
			//String sql3="insert into tb_booktype(typename,days) values(?,?)";
	    	  PreparedStatement pstate=conn.prepareStatement(sql);
	    	  //PreparedStatement pstate2=conn.prepareStatement(sql2);
	    	 // PreparedStatement pstate3=conn.prepareStatement(sql3);
	    	  //Date date = new Date();
	    	 // SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	  //String time = df.format(date);
	    	  pstate.setString(1, borrow.getReaderid());
	    	  pstate.setString(2, borrow.getBookid());
	    	  pstate.setString(3, borrow.getBorrowTime());
	    	  pstate.setString(4, borrow.getBackTime());
	    	  pstate.setString(5, borrow.getOperator());
	    	  pstate.setInt(6, borrow.getIfback());
	    	 
	    	 // pstate.setString(10, manager.getName());
	    	  
	    	 // pstate2.setString(1, book.getBookcase());
	    	 
	    	 // pstate3.setInt(3, book.g);
	    	 // pstate2.setInt(4, book.getBorrowback());
	    	  int count=pstate.executeUpdate();
	    	  //int count2=pstate2.executeUpdate();
	    	  if(count>0){
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
}