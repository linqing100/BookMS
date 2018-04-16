   package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javabean.Page;
import javabean.Book;
import javabean.Manager;
import util.ConnectionDB;

public class BookDao {
	//查询所有管理员信息
	public List<Book> queryAllBook() throws ClassNotFoundException, SQLException{
   	  List<Book> result=new ArrayList<Book>();
   	  Connection conn=ConnectionDB.getConnection();
   	  String sql="select * from tb_bookinfo";
   	  PreparedStatement pstate=conn.prepareStatement(sql);
   	  ResultSet rs=pstate.executeQuery();
   	  while(rs.next()){
   		Book book=new Book();
   		  book.setBookname(rs.getString(1));
   		  book.setTypeid(rs.getInt(2));
   		  book.setAuthor(rs.getString(3));
   		  book.setTranslator(rs.getString(4));
   		  book.setISBN(rs.getString(5));
   		  book.setPrice(rs.getFloat(6));
   		  book.setBookpage(rs.getString(7));
   		  book.setInTime(rs.getString(9));
   		  book.setOperator(rs.getString(10));
   		  book.setId(rs.getInt(11));
   		  book.setBookcase(rs.getString(8));
   		  
   		  result.add(book);
   	  }
   	  
   	  return result;
     }
    
     public Page page(Page p){
   	  return p;
   	  
   	  }
   public List<Book> quaryLimitBook( Page p) throws ClassNotFoundException, SQLException{
    	  page(p);
    	  List<Book> result=new ArrayList<Book>();
    	  Connection conn=ConnectionDB.getConnection();
    	  String sql="select * from tb_bookinfo limit ?,?";
    	  PreparedStatement pstate=conn.prepareStatement(sql);
    	  pstate.setInt(1, p.getStart());
    	  pstate.setInt(2, p.getCount());
    	  ResultSet rs=pstate.executeQuery();
    	  while(rs.next()){
    		  Book book=new Book();
    		  book.setBookname(rs.getString(1));
       		  book.setTypeid(rs.getInt(2));
       		  book.setAuthor(rs.getString(3));
       		  book.setTranslator(rs.getString(4));
       		  book.setISBN(rs.getString(5));
       		  book.setPrice(rs.getFloat(6));
       		  book.setBookpage(rs.getString(7));
       		  book.setInTime(rs.getString(9));
       		  book.setOperator(rs.getString(10));
       		  book.setId(rs.getInt(11));
       		  book.setBookcase(rs.getString(8));
       		  
       		  result.add(book);
    	  }
    	  
    	  return result;
  
      }
   //删除管理员信息
   public  boolean afterDelete(String id) throws ClassNotFoundException,SQLException{
 	  Connection conn=ConnectionDB.getConnection();
 	  String sql="delete from tb_bookinfo where id=?";
 	 // String sql2="delete from tb_bookcase where id=?";
 	 // String sql3="delete from tb_booktype where id=?";
 	  PreparedStatement pstate=conn.prepareStatement(sql);
 	  //PreparedStatement pstate2=conn.prepareStatement(sql2);
 	  //PreparedStatement pstate3=conn.prepareStatement(sql3);
 	  pstate.setString(1, id);
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

   //更新管理员信息
   public boolean updateBook(Book book) {
   	Connection conn;
		try {
			conn = ConnectionDB.getConnection();
			
			String sql2="update tb_bookinfo set bookname=?,typeid=?,author=?,translator=?,ISBN=?,price=?,bookpage=?,bookcase=?  where id=?";
	    	 
	    	  PreparedStatement pstate2=conn.prepareStatement(sql2);
	    	  pstate2.setString(1, book.getBookname());
	    	  pstate2.setInt(2, book.getTypeid());
	    	  pstate2.setString(3, book.getAuthor());
	    	  pstate2.setString(4, book.getTranslator());
	    	  pstate2.setString(5, book.getISBN());
	    	  pstate2.setFloat(6, book.getPrice());
	    	  pstate2.setString(7, book.getBookpage());
	    	  pstate2.setString(8, book.getBookcase());
	    	  pstate2.setInt(9, book.getId());
	    	  
	    	  
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
   //获取管理员信息
   public static Book getBookInfo(int id) throws ClassNotFoundException,SQLException{
 	  Connection conn=ConnectionDB.getConnection();
 	  String sql="select * from tb_bookinfo where id=?";
 	 //String sql2="select tb_powerview.sysset,tb_powerview.readerset,tb_powerview.bookset,tb_powerview.borrowback from tb_powerview where id=?";
 	  PreparedStatement pstate=conn.prepareStatement(sql);
 	 // PreparedStatement pstate2=conn.prepareStatement(sql2);
 	  pstate.setInt(1, id);
 	 // pstate2.setInt(1, id);
 	  ResultSet rs=pstate.executeQuery();
 	 // ResultSet rs2=pstate2.executeQuery();
 	 Book book=new Book();
 	  if(rs.next()){
  		  book.setId(rs.getInt(11));
  		  book.setBookname(rs.getString(1));
  		  book.setAuthor(rs.getString(3));
  		  book.setTypeid(rs.getInt(2));
  		  book.setTranslator(rs.getString(4));
  		  book.setISBN(rs.getString(5));
  		  book.setPrice(rs.getFloat(6));
  		  book.setBookpage(rs.getString(7));
  		  book.setBookcase(rs.getString(8));
  		 // book.setName(rs.getString(2));
  		 
 	  }
 	  
 	  return book;
   } 
   
 
 //通过图书条形码获取图书信息
   public static Book getBookInfoByBarcode(String barcode) throws ClassNotFoundException,SQLException{
 	  Connection conn=ConnectionDB.getConnection();
 	  String sql="select * from tb_bookinfo where barcode=?";
 	 //String sql2="select tb_powerview.sysset,tb_powerview.readerset,tb_powerview.bookset,tb_powerview.borrowback from tb_powerview where id=?";
 	  PreparedStatement pstate=conn.prepareStatement(sql);
 	 // PreparedStatement pstate2=conn.prepareStatement(sql2);
 	  pstate.setString(1, barcode);
 	 // pstate2.setInt(1, id);
 	  ResultSet rs=pstate.executeQuery();
 	 // ResultSet rs2=pstate2.executeQuery();
 	 Book book=new Book();
 	  if(rs.next()){
  		  book.setId(rs.getInt(11));
  		  book.setBookname(rs.getString(1));
  		  book.setAuthor(rs.getString(3));
  		  book.setTypeid(rs.getInt(2));
  		  book.setTranslator(rs.getString(4));
  		  book.setISBN(rs.getString(5));
  		  book.setPrice(rs.getFloat(6));
  		  book.setBookpage(rs.getString(7));
  		  book.setBookcase(rs.getString(8));
  		  book.setBarcode(rs.getString(12));
  		 // book.setName(rs.getString(2));
  		 
 	  }
 	  
 	  return book;
   } 
   
   //新增管理员信息
   public static int insertBook(Book book,Manager manager){
 	  Connection conn;
		try {
			conn = ConnectionDB.getConnection();
			String sql="insert into tb_bookinfo(bookname,typeid,author,translator,ISBN,price,bookpage,bookcase,inTime,operator) values(?,?,?,?,?,?,?,?,?,?)";
			String sql2="insert into tb_bookcase(bookcase) values(?)";
			//String sql3="insert into tb_booktype(typename,days) values(?,?)";
	    	  PreparedStatement pstate=conn.prepareStatement(sql);
	    	  PreparedStatement pstate2=conn.prepareStatement(sql2);
	    	 // PreparedStatement pstate3=conn.prepareStatement(sql3);
	    	  Date date = new Date();
	    	  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	  String time = df.format(date);
	    	  pstate.setString(1, book.getBookname());
	    	  pstate.setInt(2, book.getTypeid());
	    	  pstate.setString(3, book.getAuthor());
	    	  pstate.setString(4, book.getTranslator());
	    	  pstate.setString(5, book.getISBN());
	    	  pstate.setFloat(6, book.getPrice());
	    	  pstate.setString(7, book.getBookpage());
	    	  pstate.setString(8, book.getBookcase());
	    	  pstate.setString(9, time);
	    	  pstate.setString(10, manager.getName());
	    	  
	    	  pstate2.setString(1, book.getBookcase());
	    	 
	    	 // pstate3.setInt(3, book.g);
	    	 // pstate2.setInt(4, book.getBorrowback());
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
}