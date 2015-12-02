package pe.edu.upc.veterinaryapp.DBDAO;
import  pe.edu.upc.veterinaryapp.entities.User;
import java.util.List;

public interface IUserDao {
     User fetchUserById(int userId);
     User findUser(String user_name,String password);
     List<User> fetchAllUsers();
    // add user
     boolean addUser(User user);
    // add users in bulk
     boolean addUsers(List<User> users);
     boolean deleteAllUsers();
}
