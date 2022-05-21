import java.io.IOException;
import java.sql.*;

public class MySQLSolution {

// Exercise 1
    public static void main(String[] args) throws SQLException, IOException {
        Connection con = DriverManager.getConnection("jdbc:mysql://"+Constants.SERVER+":"+Constants.PORT, Constants.USER_NAME, Constants.PASSWORD);
        Databases db = new Databases();


        db.createTable(con,"dogs");
        db.insertDog(con ,"Osho", 4,"coated Retriever");
        db.insertDog(con ,"Zeus", 10,"Pitbull");
        db.insertDog(con ,"Fox", 4,"Labrador");
        db.deleteUserByName(con, "Fox");
        db.updateUserName(con,12, "Zeus");
        System.out.println("the dog names:");
        db.getTableContentDogs(con);
        System.out.println();

        con.close();



    }



}