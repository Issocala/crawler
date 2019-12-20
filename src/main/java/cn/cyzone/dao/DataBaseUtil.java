package cn.cyzone.dao;

import cn.cyzone.redis.RedisService;
import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.fabric.xmlrpc.base.Param;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DataBaseUtil<t> {
    RedisService redisService = new RedisService();

    private ResultSetMetaData metaData;
    public static String jdbcDriver = "com.mysql.jdbc.Driver";
    public static String jdbcUrl = "jdbc:mysql://localhost:3306/cyzone?characterEncoding=utf-8&useSSL=false";
    public static String username = "root";
    public static String password = "123456";

    static class Druid{
        static DruidDataSource druid = null;
        static {
            druid=new DruidDataSource();
            druid.setDriverClassName(jdbcDriver);
            druid.setUrl(jdbcUrl);
            druid.setUsername(username);
            druid.setPassword(password);
//            druid.setInitialSize(16);
//            druid.setMinIdle(16);
            druid.setMaxActive(500);
            druid.setRemoveAbandoned(true);
            druid.setRemoveAbandonedTimeout(600);
            druid.setLogAbandoned(true);
//            druid.setMaxWait(60000);
//            druid.setTimeBetweenEvictionRunsMillis(60000);
        }
        public static DruidDataSource getConnection(){
                return druid;
        }
    }
    // 得到连接对象
    public static Connection getConnection() {
        try {
            return Druid.getConnection().getConnection();
//            Class.forName(jdbcDriver);
//            return DriverManager.getConnection(jdbcUrl,username,password);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 关闭资源
    public static void closeAll(AutoCloseable... autoCloseables) {
        for (AutoCloseable autoCloseable : autoCloseables) {
            if (autoCloseable != null) {
                try {
                    autoCloseable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 增删改操作
     *
     * @return
     */
    public static int commonOper(String sql, Object... param) {
        // select * from t_user where id = ? and username = ?
        // User
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            // 得到一个连接对象
            connection = getConnection();
            // 开启事务
            connection.setAutoCommit(false);
            // 得到一个执行对象
            ps = connection.prepareStatement(sql);
            // 给sql语句的参数赋值
            for (int i = 0; i < param.length; i++) {
                ps.setObject(i + 1, param[i]);
            }
            // 执行增删改操作
            int result = ps.executeUpdate();

            // 提交事务
            connection.commit();
            System.out.println("执行成功！受影响的行数-->" + result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    // 回滚
                    connection.rollback();
                    connection.setAutoCommit(true);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            // 关闭资源
            closeAll(ps, connection);
        }

        return -1;
    }

    /***
     * 查询集合数据
     *
     * @param sql
     * @return
     */
    public List<t> getList(String sql, Class<t> clazz, Param... param) {
        List<t> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = getConnection();

            ps = connection.prepareStatement(sql);
            for (int i = 0; i < param.length; i++) {
                ps.setObject(i + 1, param[i]);
            }
            rs = ps.executeQuery();
            // 得到ResultSetMetaData对象，这个对象包括列的信息(列的名称和类型等等)
            metaData = rs.getMetaData();
            // 得到结果集中列的个数
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                t ins = clazz.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    // 得到列名
                    String name = metaData.getColumnName(i);
                    Object value = rs.getObject(i);
                    Field field = clazz.getDeclaredField(name);
                    field.setAccessible(true);
                    // user.setUsername(name)
                    field.set(ins, value);
                }
                list.add(ins);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, connection);
        }
        return list;
    }

    /**
     * 获得公司全部url
     * @param sql
     * @return
     */
    public List<String> getCompanyUrlAll(String sql) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            List<String> list = new ArrayList<>();
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()){
                list.add(rs.getString(1));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 得到单个对象
     *
     * @param sql
     * @param clazz
     * @param param
     * @return
     */
    public t getSingleInstace(String sql, Class<t> clazz, Object... param) {
        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < param.length; i++) {
                ps.setObject(i + 1, param[i]);
            }
            rs = ps.executeQuery();
            metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (rs.next()) {
                t ins = clazz.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    // 得到列名
                    String columnName = metaData.getColumnName(i);
                    // 得到列名对应的数据
                    Object value = rs.getObject(i);
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(ins, value);
                }
                return ins;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, ps, connection);
        }
        return null;
    }

    /**
     * 查询条数
     * @return
     */
    public int getCount(String sql,Object...param){
        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < param.length; i++) {
                ps.setObject(i + 1, param[i]);
            }
            rs = ps.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            closeAll(rs,ps,connection);
        }
        return count;
    }

    /**
     * 获取id
     * @return
     */
    public int getId(String sql,Object...param){
        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement ps = null;
        int id = 0;
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < param.length; i++) {
                ps.setObject(i + 1, param[i]);
            }
            rs = ps.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            closeAll(rs,ps,connection);
        }
        return id;
    }

    /**
     * 批量数据插入数据
     *
     * @return
     */
    public int addNewsAll(String sql, ArrayList<t> arrayList) {
        Connection connection = null;
        PreparedStatement ps = null;
        AtomicInteger result = new AtomicInteger();
        try {
            // 得到一个连接对象
            connection = getConnection();
//            // 开启事务
            connection.setAutoCommit(false);
            // 得到一个执行对象
            ps = connection.prepareStatement(sql);
            PreparedStatement finalPs = ps;
            Connection finalConnection = connection;
            arrayList.forEach(a->{
                setObject(finalPs,a);
                try {
                    finalPs.addBatch();
                } catch (SQLException e) {
                    System.out.println("执行失败！");
                    try {
                        finalConnection.rollback();
                        finalConnection.setAutoCommit(true);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            // 执行增删改操作
            finalPs.executeBatch();
            // 提交事务
            connection.commit();
            System.out.println("执行成功！");
            return 1;
        } catch (SQLException e) {
            System.out.println("执行失败！");
            e.printStackTrace();
            if(connection != null){
                try {
                    connection.rollback();
                    connection.setAutoCommit(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            // 关闭资源
            closeAll(ps, connection);
        }
        return -1;
    }

    /**
     * 单个增删改操作
     *
     * @return
     */
    public int addOne(String sql,t t) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            // 得到一个连接对象
            connection = getConnection();
            // 开启事务
            connection.setAutoCommit(false);
            // 得到一个执行对象
            ps = connection.prepareStatement(sql);
            // 给sql语句的参数赋值
            setObject(ps,t);
            // 执行增删改操作
            int result = ps.executeUpdate();
            // 提交事务
            connection.commit();
            System.out.println("执行成功！受影响的行数-->" + result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    // 回滚
                    connection.rollback();
                    connection.setAutoCommit(true);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            // 关闭资源
            closeAll(ps, connection);
        }

        return -1;
    }


    //对占位符进行填充
    public void setObject(PreparedStatement ps,t t){
        Class cla = t.getClass();
        Field[] fields = cla.getDeclaredFields();
        for(int i = 1; i < fields.length; i++){
            try {
                int j = fields[i].toString().lastIndexOf(".")+1;
                String s1 = fields[i].toString().substring(j);
                String field ="get" + s1.substring(0,1).toUpperCase() + s1.substring(1);
                Method method = cla.getMethod(field,null);
                //给sql赋值
                ps.setObject(i,method.invoke(t));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
