package bookSQL;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//����û������ݿ�ʵ��ע��
public class txSQL {

    public void addrow(String id,String book_name,String numb,String s) throws ClassNotFoundException, SQLException  {
        String URL="jdbc:mysql://127.0.0.1:3306/new_schema?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT";
        String USER="dubai";
        String PASSWORD="qq2572891795";
        //1.������������
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.������ݿ�����
        Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //3.ͨ�����ݿ�����Ӳ������ݿ⣬ʵ����ɾ�Ĳ飨ʹ��Statement�ࣩ
//        String s="insert into book(id,book_name,numb) values(?,?,?);";
        PreparedStatement pst=conn.prepareStatement(s);

        pst.setString(1, id);
        pst.setString(2, book_name);
        pst.setString(3, numb);
        
        //�ر���Դ
        pst.execute();
        pst.close();
        conn.close();
    }
}