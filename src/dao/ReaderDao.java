package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javabean.Reader;
import javabean.Book;
import javabean.Manager;
import javabean.Page;
import util.ConnectionDB;

public class ReaderDao {
	//查询所有管理员信息
		public List<Reader> queryAllReader() throws ClassNotFoundException, SQLException{
	   	  List<Reader> result=new ArrayList<Reader>();
	   	  Connection conn=ConnectionDB.getConnection();
	   	  String sql="select * from tb_reader";
	   	  PreparedStatement pstate=conn.prepareStatement(sql);
	   	  ResultSet rs=pstate.executeQuery();
	   	  while(rs.next()){
	   		Reader reader=new Reader();
	   		  reader.setId(rs.getInt(1));
	   		  reader.setName(rs.getString(2));
	   		  reader.setSex(rs.getString(3));
	   		  reader.setBarcode(rs.getString(4));
	   		  reader.setVocation(rs.getString(5));
	   		  reader.setBirthday(rs.getString(6));
	   		  reader.setPaperType(rs.getString(7));
	   		  reader.setPaperNO(rs.getString(8));
	   		  reader.setTel(rs.getString(9));
	   		  reader.setEmail(rs.getString(10));
	   		  reader.setCreateDate(rs.getString(11));
	   		  reader.setOperator(rs.getString(12));
	   		  reader.setRemark(rs.getString(13));
	   		  reader.setTypeid(rs.getInt(14));
	   		  reader.setReaderType(rs.getString(15));
	   		  
	   		  result.add(reader);
	   	  }
	   	  
	   	  return result;
	     }
	    
	     public Page page(Page p){
	   	  return p;
	   	  
	   	  }
	   public List<Reader> quaryLimitReader( Page p) throws ClassNotFoundException, SQLException{
	    	  page(p);
	    	  List<Reader> result=new ArrayList<Reader>();
	    	  Connection conn=ConnectionDB.getConnection();
	    	  String sql="select * from tb_reader limit ?,?";
	    	  PreparedStatement pstate=conn.prepareStatement(sql);
	    	  pstate.setInt(1, p.getStart());
	    	  pstate.setInt(2, p.getCount());
	    	  ResultSet rs=pstate.executeQuery();
	    	  while(rs.next()){
	    		  Reader reader=new Reader();
		   		  reader.setId(rs.getInt(1));
		   		  reader.setName(rs.getString(2));
		   		  reader.setSex(rs.getString(3));
		   		  reader.setBarcode(rs.getString(4));
		   		  reader.setVocation(rs.getString(5));
		   		  reader.setBirthday(rs.getString(6));
		   		  reader.setPaperType(rs.getString(7));
		   		  reader.setPaperNO(rs.getString(8));
		   		  reader.setTel(rs.getString(9));
		   		  reader.setEmail(rs.getString(10));
		   		  reader.setCreateDate(rs.getString(11));
		   		  reader.setOperator(rs.getString(12));
		   		  reader.setRemark(rs.getString(13));
		   		  reader.setTypeid(rs.getInt(14));
		   		  reader.setReaderType(rs.getString(15));
		   		  
		   		  result.add(reader);
	    	  }
	    	  
	    	  return result;
	  
	      }
	 //获取管理员信息
	   public static Reader getReaderInfo(String barcode) throws ClassNotFoundException,SQLException{
	 	  Connection conn=ConnectionDB.getConnection();
	 	  String sql="select * from tb_reader where barcode=?";
	 	  
	 	 //String sql2="select tb_powerview.sysset,tb_powerview.readerset,tb_powerview.bookset,tb_powerview.borrowback from tb_powerview where id=?";
	 	  PreparedStatement pstate=conn.prepareStatement(sql);
	 	 // PreparedStatement pstate2=conn.prepareStatement(sql2);
	 	  pstate.setString(1, barcode);
	 	 // pstate2.setInt(1, id);
	 	  ResultSet rs=pstate.executeQuery();
	 	 // ResultSet rs2=pstate2.executeQuery();
	 	 Reader reader=new Reader();
	 	  if(rs.next()){
	 		 reader.setId(rs.getInt(1));
	   		  reader.setName(rs.getString(2));
	   		  reader.setSex(rs.getString(3));
	   		  reader.setBarcode(rs.getString(4));
	   		  reader.setVocation(rs.getString(5));
	   		  reader.setBirthday(rs.getString(6));
	   		  reader.setPaperType(rs.getString(7));
	   		  reader.setPaperNO(rs.getString(8));
	   		  reader.setTel(rs.getString(9));
	   		  reader.setEmail(rs.getString(10));
	   		  reader.setCreateDate(rs.getString(11));
	   		  reader.setOperator(rs.getString(12));
	   		  reader.setRemark(rs.getString(13));
	   		  reader.setTypeid(rs.getInt(14));
	  		  reader.setReaderType(rs.getString(15));
	  		 
	    	  
	    		  String readerType = reader.getReaderType();
	    		  String sql4="select * from tb_readertype where readertype=?"; 
	    		  PreparedStatement pstate4=conn.prepareStatement(sql4);
	    		  pstate4.setString(1,readerType);
	     	 	  ResultSet rs4=pstate4.executeQuery();
	     	 	  while(rs4.next()) {
	     	 		  reader.setNumber(rs4.getInt(3));
	     	 		  reader.setTypeid(rs4.getInt(1));
	     	 	  }
	    	   
	  		
	 	  }
	 	  
	 	  return reader;
	 	  
	   } 
	 //获取读者可借数量
	      public int borrowNumber(String readerType) {
	    	  int number=0;
	    	  try {
	    	  Connection conn = ConnectionDB.getConnection();
	    	  String sql = "select * from tb_readertype where readertype=?";
	    	  PreparedStatement pstate=conn.prepareStatement(sql);
		  	    pstate.setString(1,readerType);
		  	    ResultSet rs=pstate.executeQuery();
		  	    if(rs.next()) {
		  	      number = rs.getInt(3);
		  	    }
		  	    }catch(ClassNotFoundException e) {
		  	    	e.printStackTrace();
		  	    }catch(SQLException e) {
		  	    	e.printStackTrace();
		  	    }
	    	  return number;
	      }
	 //验证读者身份
	      public int checkReader(Reader reader) {
	    	  int flag = 0;
	    	  Connection conn;
	    	  try {
	    	  conn = ConnectionDB.getConnection();
	    	  String sql = "select * from tb_reader where  ='"+reader.getBarcode()+"' ";
	    	  PreparedStatement pstate=conn.prepareStatement(sql);
	    	  ResultSet rs = pstate.executeQuery(sql);
	    	   if(rs.next()) {
	    		   
	    			   flag = 1;
	    		  
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
	    //新增读者信息
	      public static int insertReader(Reader reader,Manager manager){
	    	  Connection conn;
	   		try {
	   			conn = ConnectionDB.getConnection();
	   			String sql="insert into tb_reader(name,sex,barcode,birthday,paperType,paperNO,tel,email,createDate,operator,remark,readerType) values(?,?,?,?,?,?,?,?,?,?,?,?)";
	   	    	  PreparedStatement pstate=conn.prepareStatement(sql);
	   	    	 
	   	    	 
	   	    	  Date date = new Date();
	   	    	  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   	    	  String time = df.format(date);
	   	    	  pstate.setString(1, reader.getName());
	   	    	  pstate.setString(2, reader.getSex());
	   	    	  pstate.setString(3, reader.getBarcode());
	   	    	  pstate.setString(4, reader.getBirthday() );
	   	    	  pstate.setString(5, reader.getPaperType() );
	   	    	  pstate.setString(6, reader.getPaperNO() );
	   	    	  pstate.setString(7, reader.getTel() );
	   	    	  pstate.setString(8, reader.getEmail() );
	   	    	  pstate.setString(9, time);
	   	    	  pstate.setString(10,manager.getName() );
	   	    	  pstate.setString(11, reader.getRemark());
	   	    	  pstate.setString(12, reader.getReaderType() );
	   	    	 
	   	    	  int count=pstate.executeUpdate();
	   	    	 
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
	      //删除读者信息
	      public  boolean afterDelete(String id) throws ClassNotFoundException,SQLException{
	    	  Connection conn=ConnectionDB.getConnection();
	    	  String sql="delete from tb_reader where id=?";
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
	    //更新读者信息
	      public boolean updateReader(Reader reader) {
	      	Connection conn;
	   		try {
	   			conn = ConnectionDB.getConnection();
	   			
	   			String sql="update tb_reader set name=?,sex=?,birthday=?,paperType=?,paperNO=?,tel=?,email=?,readerType=?,remark=?  where id=?";
	   	    	 
	   	    	  PreparedStatement pstate=conn.prepareStatement(sql);
	   	    	  pstate.setString(1, reader.getName());
	   	    	  pstate.setString(2, reader.getSex());
	   	    	  pstate.setString(3, reader.getBirthday());
	   	    	  pstate.setString(4, reader.getPaperType());
	   	    	  pstate.setString(5, reader.getPaperNO());
	   	    	  pstate.setString(6, reader.getTel());
	   	    	  pstate.setString(7, reader.getEmail());
	   	    	  pstate.setString(8, reader.getReaderType());
	   	    	  pstate.setString(9, reader.getRemark());
	   	    	  pstate.setInt(10, reader.getId());
	   	    	  
	   	    	  int shu=pstate.executeUpdate();
	   	    	  if(shu>0){
	   	    		 
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

}
