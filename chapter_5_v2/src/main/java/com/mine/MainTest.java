package com.mine;

import com.alibaba.fastjson.util.TypeUtils;
import lombok.Cleanup;
import lombok.CustomLog;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.print.DocFlavor;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Pattern;

/**
 * @author yanyimim
 * @since 2019/12/30 14:06
 */
public class MainTest {

    @Test
    public void method1() throws ClassNotFoundException, SQLException {
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        @Cleanup
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/icc_mz", "root", "1217");
        @Cleanup
        PreparedStatement ps = conn.prepareStatement("select * from t_exam");
        conn.setAutoCommit(false);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString(1));
            System.out.println(rs.getString("examname"));
        }
    }

    @Test
    public void method2() throws ClassNotFoundException, SQLException {
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        @Cleanup
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/icc_mz", "root", "1217");
        DatabaseMetaData dm = conn.getMetaData();
        String schema = conn.getSchema();
        assert dm.getMaxStatements() == 0;
        Statement st = conn.createStatement();
    }

    @Test
    public void method3() throws IOException, ClassNotFoundException {
        Properties prop = new Properties();
        try (InputStream in = Files.newInputStream(
            Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "database.properties"));) {
            prop.load(in);
            String driver = prop.getProperty("driver.name");
            Class.forName(driver);
            String url = prop.getProperty("datasource.url");
            String username = prop.getProperty("datasource.username");
            String password = prop.getProperty("datasource.password");
            @Cleanup
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            boolean is = st.execute("select * from t_exam");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void method4() throws IOException {
        File file = Paths.get("database.properties").toFile();

        try (FileInputStream fin = new FileInputStream(Paths.get("database.properties").toFile())) {
            Properties prop = new Properties();
            prop.load(fin);
            System.out.println(prop.getProperty("driver.name"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void method5() throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL url = classLoader.getResource("database.properties");
        @Cleanup
        InputStream in = Files.newInputStream(Paths.get(url.getPath()));
        Properties prop = new Properties();
        System.out.println(prop.getProperty("driver.name"));
    }

    @Test
    public void method6() throws ClassNotFoundException, SQLException {
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        @Cleanup
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/icc_mz", "root", "1217");
        conn.setAutoCommit(false);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from t_exam");
        while (rs.next()) {
            System.out.println(rs.getString(1));
        }
        conn.commit();
    }

    @Test
    public void method7() throws SQLException, ClassNotFoundException {
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        @Cleanup
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/icc_mz", "root", "1217");
        @Cleanup
        Statement st = conn.createStatement();
        boolean isrs = st.execute("update t_exam set creator = '严以' ");
        System.out.println(isrs);
        if (isrs) {
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                System.out.println(rs.getString("examname"));
            }
        } else {
            System.out.println(st.getUpdateCount());
            st.closeOnCompletion();
        }
    }

    @Test
    public void before() throws ClassNotFoundException {
        try {
            @Cleanup
            Connection conn = ConnectionMine.getInstance();
            System.out.println(conn.getMetaData().getMaxStatements());
            Statement st = conn.createStatement();
            st.setMaxFieldSize(3);
            st.setMaxRows(2);
            Statement st2 = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from t_exam");
            ResultSet rs1 = st2.executeQuery("select * from t_exam");
            while (!rs.isClosed() && rs.next()) {
                System.out.println(rs.getDate(9));
//                System.out.println(rs.getObject(9, java.sql.Date.class));
//                System.out.println(rs.getObject("examenddate", java.sql.Date.class));
//                System.out.println(rs.findColumn("examenddate"));
//                System.out.println(st.isClosed() + ":" + st2.isClosed());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            for (Throwable ex : e) {
                System.out.println(ex.getMessage());
            }
        }
    }
    @Test
    public void method8() throws SQLException, ClassNotFoundException {
       @Cleanup Connection conn = ConnectionMine.getInstance();
       @Cleanup Statement st = conn.createStatement();
       ResultSet rs = st.executeQuery("select * from t_exam");
       ResultSetMetaData rsmd = rs.getMetaData();
       int c_count = rsmd.getColumnCount();
       System.out.println(c_count);
       System.out.println(rsmd.getCatalogName(6));
       System.out.println(rsmd.getColumnClassName(9));
       System.out.println(rsmd.getColumnLabel(1));
       System.out.println(rsmd.getColumnName(9));
       System.out.println(rsmd.isSearchable(1));
       System.out.println(rsmd.getColumnDisplaySize(1));
    }
}
