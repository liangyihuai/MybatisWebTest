package com.daniel.util;

//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DbUtil {
	//private static Connection connection = null;

	
	private static SqlSessionFactory sqlSessionFactory = null;

	static {
		try {
			// 加载mybatis配置文件，并创建SqlSessionFactory实例
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			//这个build方法可以接受几种不同的参数，如Reader/InputSteam等
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}

	public static void closeSqlSession(SqlSession sqlSession){
		if (sqlSession != null) {
			sqlSession.close();
		}
	}
	
//    public static Connection getConnection() {
//        if (connection != null)
//            return connection;
//        else {
//            try {
//            	Properties prop = new Properties();
//                InputStream inputStream = DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");
//                prop.load(inputStream);
//                String driver = prop.getProperty("driver");
//                String url = prop.getProperty("url");
//                String user = prop.getProperty("user");
//                String password = prop.getProperty("password");
//                Class.forName(driver);
//                connection = DriverManager.getConnection(url, user, password);
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return connection;
//        }
//
//    }
}
