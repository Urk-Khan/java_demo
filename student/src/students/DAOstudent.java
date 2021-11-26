package students;
import java.sql.*;

class student {

    int no;
    String name;
    int rollNo;
    String degree;
    String dept;
    String posts;
    String statuss;
}

public class DAOstudent {

    Connection con = null;

    void Connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/tblstudent";
            con = DriverManager.getConnection(url, "root", "");
        } catch (Exception ex) {
            System.out.println("Student_Connection Error try again");
            System.out.println(ex);
        }
    }
    int insert(student s) {
        int ret = 0;
        try {
            Connection();
            String qry = "insert into tbstudent values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, s.no);
            pst.setString(2, s.name);
            pst.setInt(3, s.rollNo);
            pst.setString(4, s.degree);
            ret = pst.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error in st_insertion try again");
        }
        return ret;
    }
    int update(student s) {
        int ret = 0;
        try {
            Connection();
            String qry = "update tbstudent set name=?, rollNo=?, degree=? where no=?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, s.name);
            pst.setInt(2, s.rollNo);
            pst.setString(3, s.degree);
            pst.setInt(4, s.no);
            ret = pst.executeUpdate();
        } 
        catch (Exception ex) {
            System.out.println("Error in st_update try again");
            System.out.println(ex);
        }
        return ret;
    }
    int delete(student s) {
        int ret = 0;
        try {
            Connection();
            String qry = "delete from tbstudent where no=?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, s.no);
            ret = pst.executeUpdate();
           
        } 
        catch (Exception ex) {
            System.out.println("Error in deletion try again");
            System.out.println(ex);
        }
        return ret;
    }
    ResultSet SelectById(student s) {
        ResultSet ret = null;
        try {
            Connection();
            String qry = "select * from tbstudent where no = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, s.no);
            ret = pst.executeQuery();
            
        } 
        catch (Exception ex) {
            System.out.println("Error in selected by ID, try again");
            System.out.println(ex);
        }
        return ret;
    }
    ResultSet SelectAll(student s) {
        ResultSet ret = null;
        try {
            Connection();
            String qry = "select * from tbstudent";
            Statement st = con.createStatement();
            ret = st.executeQuery(qry);
            
        } 
        catch (Exception ex) {
            System.out.println("Error in selected All, try again");
            System.out.println(ex);
        }
        return ret;
    }
}
