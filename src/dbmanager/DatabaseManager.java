
package dbmanager;

import beanclasses.*;
import java.sql.*;
import java.util.*;

/**
 * @author Shakeel Jamali
 */
public class DatabaseManager {
    public static Connection con;
    static {
        try{ 
            init(); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
    } 
    
    private static void init()throws Exception{
    
//        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); //package
//        con=DriverManager.getConnection("jdbc:odbc:USindh");// url address

        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        System.out.println("Drivers Loaded Succesfully");
        
	con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\N TECH\\Documents\\New folder\\USindhLiberarymanagement\\database\\MUET.accdb");
        System.out.println("Connection Establish");
    
    }//------------------------------------------------ init() close -------------------------------------------------------------------------------------//

    
////////////////////////////////////////////////////////////////////  getMathods()  ///////////////////////////////////////////////////////////////////////////////////////////
    
    
    public static Vector getDepartments()throws Exception{
        
        String query="select * from department";
        System.out.println(query);
       
        Statement st=null;
        ResultSet result=null;     
       
        try{       
            st=con.createStatement();
            result=st.executeQuery(query);
            
            Vector v=new Vector();
            
            while(result.next()){               
                DepartmentBean bean=new DepartmentBean();
                
                bean.setDeptId(result.getInt("Dept_id"));
                bean.setDeptName(result.getString("Dept_name"));
                bean.setRemarks(result.getString("Remarks"));
                v.addElement(bean);
            }
            return v;
        }finally{
           if(result!=null)result.close();
           if(st!=null)st.close();
        }//close of finally
        
    }//============================================================== close getDepartments() =================================================================//

    
    public static Vector getPrograms(int deptId)throws Exception{
     
        String query="select * from program where Dept_id="+deptId;
        System.out.println(query);
       
        Statement st=null;
        ResultSet result=null;     
       
        try{
       
            st=con.createStatement();
            result=st.executeQuery(query);
            
            Vector v=new Vector();
            
            while(result.next()){
               
                ProgramBean bean=new ProgramBean();
                
                bean.setDeptId(result.getInt("Dept_id"));
                bean.setProgId(result.getInt("Prog_id"));
                bean.setProgName(result.getString("Prog_name"));
                bean.setSemDuration(result.getString("Sem_duration"));
                bean.setRemarks(result.getString("Remarks"));

                v.addElement(bean);
            }
            return v;
        }finally{
           if(result!=null)result.close();
           if(st!=null)st.close();
        }//close of finally
    
    }//============================================================== close getPrograms() =================================================================//

    
    public static Vector getBatches(int progId)throws Exception{
     
        String query="select  Prog_id, Batch_id, Batch_year, Group_desc, Remarks from batch where Prog_id="+progId;
        System.out.println(query);
       
        Statement st=null;
        ResultSet result=null;     
       
        try{
         
            st=con.createStatement();
            result=st.executeQuery(query);
            
            Vector v=new Vector();
            
            while(result.next()){
               
                BatchBean bean=new BatchBean();
                
                bean.setProgId(result.getInt("Prog_id"));
                bean.setBatchId(result.getInt("Batch_id"));
                bean.setBatchYear(result.getString("Batch_year"));
                bean.setGroupDesc(result.getString("Group_desc"));
                bean.setRemarks(result.getString("Remarks"));
                v.addElement(bean);
            }
            return v;
        }finally{
           if(result!=null)result.close();
           if(st!=null)st.close();
        }//close of finally

    }//============================================================== close getBatches() =================================================================//

    
    public static Vector getStudents(int batchId)throws Exception{
     
        String query="select * from student where Batch_id="+batchId;
        System.out.println(query);
       
        Statement st=null;
        ResultSet result=null;     
       
        try{       
            st=con.createStatement();
            result=st.executeQuery(query);
            
            Vector v=new Vector();
            
            while(result.next()){               
                StudentBean bean=new StudentBean();
                
                bean.setBatchId(result.getInt("Batch_id"));
                bean.setStdId(result.getInt("Std_id"));
                bean.setStdName(result.getString("Std_name"));
                bean.setFName(result.getString("Fname"));
                bean.setSurname(result.getString("Surname"));
                bean.setRollNo(result.getString("Roll_no"));
                bean.setRemarks(result.getString("Remarks"));
                v.addElement(bean);
            }
            return v;
        }finally{
           if(result!=null)result.close();
           if(st!=null)st.close();
        }//close of finally
    
    }//============================================================== close getBatches() =================================================================//

    
    
////////////////////////////////////////////////////////////////////   ADD METHODS  ///////////////////////////////////////////////////////////////////////////////////////////

    
    
    public static int addDepartment(String deptName, String remarks)throws Exception{
        String query ="insert into department (Dept_name, Remarks) values('"+deptName+"', '"+remarks+"')";
        System.out.println(query);
        Statement st = null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;   
        }finally{
        if (st!=null) st.close();
        }

    }//============================================================== close addDepartment() =================================================================//

    
    
    public static int addProgram(int deptId, String progName, String semDuration, String remarks)throws Exception{
        String query ="insert into program (Dept_id, Prog_name, Sem_duration, Remarks) values( "+deptId+", '"+progName+"', '"+semDuration+"', '"+remarks+"')";
        System.out.println(query);
        Statement st = null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;   
        }finally{
        if (st!=null) st.close();
        }

    }//============================================================== close addProgram() =================================================================//

    
    
    public static int addBatch(int progId, String batchYear, String groupDesc, String remarks)throws Exception{
        String query ="insert into batch (Prog_id, Batch_year, Group_desc, Remarks) values( "+progId+", '"+batchYear+"', '"+groupDesc+"','"+remarks+"')";
        System.out.println(query);
        Statement st = null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;   
        }finally{
        if (st!=null) st.close();
        }

    }//============================================================== close addBatch() =================================================================//

    
    
    public static int addStudent(int batchId, String stdName, String fName, String surname, String rollNo, String remarks)throws Exception{
        String query ="insert into student (Batch_id, Std_name, Fname, Surname, Roll_no, Remarks) values( "+batchId+", '"+stdName+"', '"+fName+"', '"+surname+"', '"+rollNo+"', '"+remarks+"')";
        System.out.println(query);
        Statement st = null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;   
        }finally{
        if (st!=null) st.close();
        }

    }//============================================================== close addStudent() =================================================================//

    
    
//////////////////////////////////////////////////////////////////////  DELETE METHODS  /////////////////////////////////////////////////////////////////////////////////////////

    
    public static int deleteDepartment(int deptId)throws Exception{
        String query ="delete from department where Dept_id="+deptId;
        System.out.println(query);
        Statement st = null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;   
        }finally{
        if (st!=null) st.close();
        }

    }//============================================================== close deleteDepartment() =================================================================//

    
    public static int deleteProgram(int progId)throws Exception{
        String query ="delete from program where Prog_id="+progId;
        System.out.println(query);
        Statement st = null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;   
        }finally{
        if (st!=null) st.close();
        }

    }//============================================================== close deleteProgram() =================================================================//

    
    public static int deleteBatch(int batchId)throws Exception{
        String query ="delete from batch where Batch_id="+batchId;
        System.out.println(query);
        Statement st = null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;   
        }finally{
        if (st!=null) st.close();
        }

    }//============================================================== close deleteBatch() =================================================================//

    
    public static int deleteStudent(int stdId)throws Exception{
        String query ="delete from student where Std_id="+stdId;
        System.out.println(query);
        Statement st = null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;   
        }finally{
        if (st!=null) st.close();
        }

    }//============================================================== close deleteStudent() =================================================================//

    
    
//////////////////////////////////////////////////////////////////// UPDATE METHODS ///////////////////////////////////////////////////////////////////////////////////////////

    
    public static int updateDepartment(int deptId, String deptName, String remarks)throws Exception{
        String query ="update department set Dept_name ='"+deptName+"', Remarks='"+remarks+"' where Dept_id="+deptId;
        System.out.println(query);
        Statement st = null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;   
        }finally{
        if (st!=null) st.close();
        }

    }//============================================================== close updateDepartment() =================================================================//

    
    public static int updateProgram(int progId, int deptId, String progName, String semDuration, String remarks)throws Exception{
        String query ="update program set  Dept_id ="+deptId+", Prog_name ='"+progName+"', Sem_duration='"+semDuration+"', Remarks='"+remarks+"' where Prog_id="+progId;
        System.out.println(query);
        Statement st = null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;   
        }finally{
        if (st!=null) st.close();
        }

    }//============================================================== close updateProgram() =================================================================//

    
    public static int updateBatch(int batchId, int progId, String batchYear, String groupDesc, String remarks)throws Exception{
        String query ="update batch set Prog_id="+progId+", Batch_year='"+batchYear+"', Group_desc='"+groupDesc+"', Remarks='"+remarks+"' where Batch_id="+batchId;
        System.out.println(query);
        Statement st = null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;   
        }finally{
        if (st!=null) st.close();
        }

    }//============================================================== close updateBatch() =================================================================//

    
    public static int updateStudent(int stdId, int batchId, String stdName, String fName, String surname, String rollNo, String remarks)throws Exception{
        String query ="update student set Batch_id="+batchId+", Std_name='"+stdName+"', Fname='"+fName+"', Surname='"+surname+"', Roll_no='"+rollNo+"', Remarks='"+remarks+"' where Std_id="+stdId;
        System.out.println(query);
        Statement st = null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;   
        }finally{
        if (st!=null) st.close();
        }

    }//============================================================== close updateStudent() =================================================================//

    

    
///////////////////////////////////////////////////////////////                      /////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////  Methods Of Library  /////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////                      /////////////////////////////////////////////////////////
    
    
    
    
    public static Vector getBookTypes()throws Exception{
     
        String query="select Type_id, Type, Remarks from Book_type ";
        System.out.println(query);
       
        Statement st=null;
        ResultSet result=null;            

        try{
            
            st=con.createStatement();
            result=st.executeQuery(query);
            
            Vector v=new Vector();
            
            while(result.next()){
               
                BookTypeBean bean=new BookTypeBean();
                
                bean.setTypeId(result.getInt("Type_id"));
                bean.setType(result.getString("Type"));
                bean.setRemarks(result.getString("Remarks"));
                v.addElement(bean);
            }
            return v;
        }finally{
           if(result!=null)result.close();
           if(st!=null)st.close();
        }//close of finally
    
    }//============================================================== close getBookTyes() =================================================================//

    
    public static int addBookType(String type, String remarks)throws Exception{
        String query ="insert into Book_type (Type, Remarks) values( '"+type+"', '"+remarks+"')";
        System.out.println(query);
        Statement st = null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;   
        }finally{
        if (st!=null) st.close();
        }
    
    }//============================================================== close addBookTyes() =================================================================//
 
    
    public static int deleteBookType(int typeId)throws Exception{
        String query ="delete from Book_type where Type_id="+typeId;
        System.out.println(query);
        Statement st = null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;   
        }finally{
        if (st!=null) st.close();
        }

    }//============================================================== close deleteBookType() =================================================================//

    
    public static int updateBookType(int typeId, String type, String remarks)throws Exception{
        String query ="update Book_type set  Type ='"+type+"', Remarks='"+remarks+"' where Type_id="+typeId;
        System.out.println(query);
        Statement st = null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;   
        }finally{
        if (st!=null) st.close();
        }

    }//============================================================== close updateBookType() =================================================================//


    public static Vector getBooks(int typeId, int deptId)throws Exception{
     
        String query="select * from Books where Dept_id="+deptId+" and Type_id="+typeId;
        System.out.println(query);
       
        Statement st=null;
        ResultSet result=null;            

        try{
            
            st=con.createStatement();
            result=st.executeQuery(query);
            

            Vector v=new Vector();
            
            while(result.next()){
               
                BooksBean bean=new BooksBean();
                
                bean.setBookId(result.getInt("Book_id"));
                bean.setDeptId(result.getInt("Dept_id"));
                bean.setTypeId(result.getInt("Type_id"));
                bean.setBookName(result.getString("Book_name"));
                bean.setPublisher(result.getString("Publisher"));
                bean.setAutherEditor(result.getString("Author_editor"));
                bean.setEditionVolume(result.getString("Edition_volume"));
                bean.setYearOfPublish(result.getString("Year_of_publish"));
                bean.setPrice(result.getInt("Price"));
                bean.setPurchaseFrom(result.getString("Purchase_from"));
                bean.setISBN(result.getString("ISBN"));
                bean.setAccessNo(result.getString("Access_no"));
                bean.setQuantity(result.getInt("Quantity"));
                bean.setDateOfPurchase(result.getString("Date_of_purchase"));                
                bean.setRemarks(result.getString("Remarks"));
                v.addElement(bean);
            }
            return v;
        }finally{
           if(result!=null)result.close();
           if(st!=null)st.close();
        }//close of finally
    
    }//============================================================== close getBooks() =================================================================//
    
        
    public static int deleteBook(int bookId)throws Exception{
        String query ="delete from Books where Book_id="+bookId;
        System.out.println(query);
        Statement st = null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;   
        }finally{
        if (st!=null) st.close();
        }

    }//============================================================== close deleteBookType() =================================================================//


    public static int updateBook(int bookId, int typeId, int deptId, String bookName, String publisher, String autherEditor, String editionVolume, String yearOfPublish, int price, String purchaseFrom, String isbn, String accessNo, int quantity, String dateOfPurchase, String remarks)throws Exception{
        
        String query ="update Books set  Type_id ="+typeId+", Dept_id ="+deptId+", Book_name ='"+bookName+"', Publisher ='"+publisher+"', Author_editor ='"+autherEditor+"', Edition_volume ='"+editionVolume+"', Year_of_publish ='"+yearOfPublish+"', Price ="+price+", Purchase_from ='"+purchaseFrom+"', ISBN ='"+isbn+"', Access_no ='"+accessNo+"', Quantity ="+quantity+", Date_of_purchase ='"+dateOfPurchase+"', Remarks='"+remarks+"' where Book_id="+bookId;

        System.out.println(query);
        Statement st = null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;   
        }finally{
        if (st!=null) st.close();
        }

    }//============================================================== close updateBook() =================================================================//


    public static int addBook(int typeId, int deptId, String bookName, String publisher, String autherEditor, String editionVolume, String yearOfPublish, int price, String purchaseFrom, String isbn, String accessNo, int quantity, String dateOfPurchase, String remarks)throws Exception{
        String query ="insert into Books (Type_id, Dept_id, Book_name,Publisher, Author_editor, Edition_volume, Year_of_publish, Price, Purchase_from, ISBN, Access_no, Quantity, Date_of_purchase, Remarks) values( "+typeId+", "+deptId+", '"+bookName+"', '"+publisher+"', '"+autherEditor+"', '"+editionVolume+"', '"+yearOfPublish+"', "+price+", '"+purchaseFrom+"', '"+isbn+"', '"+accessNo+"', "+quantity+", '"+dateOfPurchase+"', '"+remarks+"')";
        System.out.println(query);
        Statement st = null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;   
        }finally{
        if (st!=null) st.close();
        }

    }//============================================================== close addStudent() =================================================================//


    public static Vector getAllDepartments()throws Exception{
     
        String query="select * from department";
        System.out.println(query);
       
        Statement st=null;
        ResultSet result=null;     
       
        try{
       
            st=con.createStatement();
            result=st.executeQuery(query);
            
            Vector v=new Vector();
            
            while(result.next()){
               
                DepartmentBean bean=new DepartmentBean();
                
                bean.setDeptId(result.getInt("Dept_id"));
                bean.setDeptName(result.getString("Dept_name"));
                bean.setRemarks(result.getString("Remarks"));
                v.addElement(bean);
            }
            return v;
        }finally{
           if(result!=null)result.close();
           if(st!=null)st.close();
        }//close of finally
        
    }//============================================================== close getDepartments() =================================================================//

    public static Vector getBooks(int deptId)throws Exception{
     
        String query="select * from Books where Dept_id="+deptId;
        System.out.println(query);
       
        Statement st=null;
        ResultSet result=null;            

        try{
            
            st=con.createStatement();
            result=st.executeQuery(query);
            

            Vector v=new Vector();
            
            while(result.next()){
               
                BooksBean bean=new BooksBean();
                
                bean.setBookId(result.getInt("Book_id"));
                bean.setDeptId(result.getInt("Dept_id"));
                bean.setTypeId(result.getInt("Type_id"));
                bean.setBookName(result.getString("Book_name"));
                bean.setPublisher(result.getString("Publisher"));
                bean.setAutherEditor(result.getString("Author_editor"));
                bean.setEditionVolume(result.getString("Edition_volume"));
                bean.setYearOfPublish(result.getString("Year_of_publish"));
                bean.setPrice(result.getInt("Price"));
                bean.setPurchaseFrom(result.getString("Purchase_from"));
                bean.setISBN(result.getString("ISBN"));
                bean.setAccessNo(result.getString("Access_no"));
                bean.setQuantity(result.getInt("Quantity"));
                bean.setDateOfPurchase(result.getString("Date_of_purchase"));                
                bean.setRemarks(result.getString("Remarks"));
                v.addElement(bean);
            }
            return v;
        }finally{
           if(result!=null)result.close();
           if(st!=null)st.close();
        }//close of finally
    
    }//============================================================== close getBooks() =================================================================//
    
    
    public static Vector getBookIssued(int bookId, int stdId)throws Exception{ 
        String query="select * from Book_issued where Book_id="+bookId+" and Std_id="+stdId;
        System.out.println(query);
       
        Statement st=null;
        ResultSet result=null;            

        try{
            
            st=con.createStatement();
            result=st.executeQuery(query);

            Vector v=new Vector();
            BookIssueBean bean=null;
            while(result.next()){               
                bean=new BookIssueBean();
                
                bean.setIssuedId(result.getInt("Issued_id"));
                bean.setBookId(result.getInt("Book_id"));
                bean.setStdId(result.getInt("Std_id"));
                bean.setDateOfIssue(result.getString("Date_of_issue"));
                bean.setDateOfReturn(result.getString("Date_of_return"));
                bean.setFinePanalityAmount(result.getInt("Fine_panality_amount"));
                bean.setRemarks(result.getString("Remarks"));
                v.addElement(bean);
            }
            return v;
        }finally{
           if(result!=null)result.close();
           if(st!=null)st.close();
        }//close of finally
        
    }//============================================================== close getBooks() =================================================================//

    
    public static int updateBookIssued(int issuedId, int bookId, int stdId, String dateOfIssue, String dateOfReturn, int finePanalityAmount, String remarks)throws Exception{
        String query ="update Book_issued set Book_id="+bookId+", Std_id="+stdId+", Date_of_issue='"+dateOfIssue+"', Date_of_return='"+dateOfReturn+"', Fine_panality_amount="+finePanalityAmount+", Remarks='"+remarks+"' where Issued_id="+issuedId;
        System.out.println(query);
        Statement st = null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;   
        }finally{
        if (st!=null) st.close();
        }

    }//============================================================== close updateStudent() =================================================================//


    public static int addBookIssued(int bookId, int stdId, String dateOfIssue, String dateOfReturn, int finePanalityAmount, String remarks)throws Exception{
        String query ="insert into Book_issued (Book_id, Std_id, Date_of_issue, Date_of_return, Fine_panality_amount, Remarks) values( "+bookId+", "+stdId+", '"+dateOfIssue+"', '"+dateOfReturn+"', "+finePanalityAmount+", '"+remarks+"')";
        System.out.println(query);
        Statement st = null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;   
        }finally{
        if (st!=null) st.close();
        }
    }//============================================================== close addStudent() =================================================================//

    
    public static int deleteBookIssued(int issuedId)throws Exception{
        String query ="delete from Book_issued where Issued_id="+issuedId;
        System.out.println(query);
        Statement st = null;
        try{
            st=con.createStatement();
            int rows=st.executeUpdate(query);
            return rows;   
        }finally{
        if (st!=null) st.close();
        }
    }//============================================================== close deleteBookType() =================================================================//

        
    public static Vector getBookIssued()throws Exception{
        String query="select * from Book_issued";
        System.out.println(query);
       
        Statement st=null;
        ResultSet result=null;            

        try{           
            st=con.createStatement();
            result=st.executeQuery(query);
            
            Vector v=new Vector();
            BookIssueBean bean=null;
            
            while(result.next()){   
                bean=new BookIssueBean();
                
                bean.setIssuedId(result.getInt("Issued_id"));
                bean.setBookId(result.getInt("Book_id"));
                bean.setStdId(result.getInt("Std_id"));
                bean.setDateOfIssue(result.getString("Date_of_issue"));
                bean.setDateOfReturn(result.getString("Date_of_return"));
                bean.setFinePanalityAmount(result.getInt("Fine_panality_amount"));
                bean.setRemarks(result.getString("Remarks"));
                v.addElement(bean);
            }
            return v;
        }finally{
           if(result!=null)result.close();
           if(st!=null)st.close();
        }//close of finally        
    }//============================================================== close getBooks() =================================================================//

    
    public static StudentBean getStudent(int stdId)throws Exception{
     
        String query="select * from student where Std_id="+stdId;
        System.out.println(query);       
        Statement st=null;
        ResultSet result=null;     
       
        try{        
            st=con.createStatement();
            result=st.executeQuery(query);
            
            StudentBean bean= null;
                
            if(result.next()){               
                bean=new StudentBean();
                
                bean.setBatchId(result.getInt("Batch_id"));
                bean.setStdId(result.getInt("Std_id"));
                bean.setStdName(result.getString("Std_name"));
                bean.setFName(result.getString("Fname"));
                bean.setSurname(result.getString("Surname"));
                bean.setRollNo(result.getString("Roll_no"));
                bean.setRemarks(result.getString("Remarks"));
            }
            return bean;
        }finally{
           if(result!=null)result.close();
           if(st!=null)st.close();
        }//close of finally
    
    }//============================================================== close getBatches() =================================================================//

    
    public static BooksBean getBook(int bookId)throws Exception{
    
        String query="select * from Books where Book_id="+bookId;
        System.out.println(query);       
        
        Statement st=null;
        ResultSet result=null;     
       
        try{        
            st=con.createStatement();
            result=st.executeQuery(query);
            
            BooksBean bean= null;
                
            if(result.next()){
               
                bean=new BooksBean();
                
                bean.setBookId(result.getInt("Book_id"));
                bean.setDeptId(result.getInt("Dept_id"));
                bean.setTypeId(result.getInt("Type_id"));
                bean.setBookName(result.getString("Book_name"));
                bean.setPublisher(result.getString("Publisher"));
                bean.setAutherEditor(result.getString("Author_editor"));
                bean.setEditionVolume(result.getString("Edition_volume"));
                bean.setYearOfPublish(result.getString("Year_of_publish"));
                bean.setPrice(result.getInt("Price"));
                bean.setPurchaseFrom(result.getString("Purchase_from"));
                bean.setISBN(result.getString("ISBN"));
                bean.setAccessNo(result.getString("Access_no"));
                bean.setQuantity(result.getInt("Quantity"));
                bean.setDateOfPurchase(result.getString("Date_of_purchase"));                

                bean.setRemarks(result.getString("Remarks"));
            }
            return bean;
        }finally{
           if(result!=null)result.close();
           if(st!=null)st.close();
        }//close of finally
    
    }//============================================================== close getBooks() =================================================================//

    
}// End class DatabaseManager  