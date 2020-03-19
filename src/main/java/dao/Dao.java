package dao;

import java.sql.ResultSet;
public class Dao extends BaseDao implements Daoservlet{

    @Override
    public int Selectmysql(String name, String pwd) {
        String sql="select count(*) from denglu where name=? and pwd=?";
        Object[] params={name,pwd};
        int count=0;
        try{
            ResultSet rs=super.exceuteQuery(sql,params);
            rs.next();
            count=rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
