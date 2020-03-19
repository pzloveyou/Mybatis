package service;

import dao.Dao;

public class ServiceImpl implements Service {
    Dao dap=new Dao();
    @Override
    public int Selectmysql(String name, String pwd) {
        return dap.Selectmysql(name,pwd);
    }
}
