package com.first.pkg;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.h2.jdbcx.JdbcConnectionPool;

public class Application {

  public static void main(String[] args) throws IOException {
    try (InputStream is = Application.class.getResourceAsStream("/application.properties")) {
      Properties p = new Properties();
      p.load(is);
      System.out.println(p);
    }

    JdbcConnectionPool cp = JdbcConnectionPool.
        create("jdbc:h2:mem:", "sa", "sa"); //
    try (Connection conn = cp.getConnection()) { //
      System.out.println("Is my database connection valid: " + conn.isValid(0));
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
