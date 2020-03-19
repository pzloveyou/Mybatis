import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/blankyours?useUnicode=true&amp&characterEncoding=utf-8";
        String user="root";
        String  password="0000";
        try {
            //1. 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获取连接
            Connection conn= DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("连接成功");

    }
}
