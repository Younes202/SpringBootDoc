package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Beans.User;

public class UserDaoImpl implements DaoUser {
   private DaoFactory daoFactory;
   UserDaoImpl(DaoFactory daoFactory)
   {
	   this.daoFactory = daoFactory;
   }
@Override
public void adding(User user) {
	// TODO Auto-generated method stub
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	try {
		connection = daoFactory.getConnection();
		preparedStatement = connection.prepareStatement("INSERT INTO name(name,lastname) VALUES(?,?);");
		preparedStatement.setString(1,user.getName());
		preparedStatement.setString(2,user.getLastname());
		preparedStatement.executeUpdate();

		}catch (SQLException e) {
            e.printStackTrace();
        }

	}
@Override
public List<User> show() {
	// TODO Auto-generated method stub
	 List<User> users = new ArrayList<User>();
     Connection connexion = null;
     Statement statement = null;
     ResultSet resultat = null;

     try {
         connexion = daoFactory.getConnection();
         statement = connexion.createStatement();
         resultat = statement.executeQuery("SELECT name, lastname FROM name;");

         while (resultat.next()) {
             String name = resultat.getString("name");
             String lastname = resultat.getString("lastname");

             User user = new User();
             user.setName(name);
             user.setLastname(lastname);

             users.add(user);
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return users;
 }

}
