package com.PangTingHui.springboot01quick;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class SpringBoot01QuickApplicationTests {

    @Autowired
    DataSource dataSource;
        @Test
        public void run() throws SQLException{
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~"+dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println("-------------------"+connection);
        connection.close();
    }
}
