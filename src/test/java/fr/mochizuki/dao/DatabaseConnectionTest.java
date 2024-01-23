package fr.mochizuki.dao;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;

import fr.mochizuki.dao.DatabaseConnection;



/**
 * Unit test for simple App.
 */
public class DatabaseConnectionTest 
{
   
    @Test
    public void getProperty_should_recognizeDatabaseProperties(){
        String driver = DatabaseConnection.getProperty("driver");
        assertThat(driver).isEqualTo("com.mysql.cj.jdbc.Driver");
        String url = DatabaseConnection.getProperty("url");
        assertThat(url).isEqualTo("jdbc:mysql://localhost:3306/gestionecole");
        String user = DatabaseConnection.getProperty("user");
        assertThat(user).isEqualTo("root");
        String password = DatabaseConnection.getProperty("password");
        assertThat(password).isEqualTo("root");
    }
    
    @Test
    public void getInstance_should_connectMySQL_withoutException()
    {
        Connection conn = DatabaseConnection.getInstance();
        assertThat(conn).isNotNull();
    }

}
