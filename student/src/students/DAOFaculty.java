package students;

import java.sql.*;

public class DAOFaculty {
    Connection con = null;

    void Connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/tblstudent";
            con = DriverManager.getConnection(url, "root", "");
        } catch (Exception ex) {
            System.out.println("Connection Error try again");
            System.out.println(ex);
        }
    }
    int insert(student s) {
        int ret = 0;
        try {
            Connection();
            String qry = "insert into tbfaculty values(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, s.no);
            pst.setString(2, s.name);
            pst.setString(3, s.dept);
            pst.setString(4, s.posts);
            pst.setString(5, s.statuss);
            ret = pst.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error in ft_insertion try again");
        }
        return ret;
    }
    int update(student s) {
        int ret = 0;
        try {
            Connection();
            String qry = "update tbfaculty set name=?, department=?, post=?, status=? where no=?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, s.name);
            pst.setString(2, s.dept);
            pst.setString(3, s.posts);
            pst.setString(4, s.statuss);
            pst.setInt(5, s.no);
            
            ret = pst.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Error in ft_update try again");
            System.out.println(ex);
        }
        return ret;
    }
    int delete(student s) {
        int ret = 0;
        try {
            Connection();
            String qry = "delete from tbfaculty where no=?";
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
}
