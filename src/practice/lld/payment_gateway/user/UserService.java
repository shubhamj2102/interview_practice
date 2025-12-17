package practice.lld.payment_gateway.user;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class UserService {
   private  final Map<String, UserDao> usersList;

    public UserService() {
        this.usersList = new HashMap<>();
    }

    public void addUser(UserDao userDao){
       usersList.put(userDao.getUserId(),userDao);
       System.out.println("User is add with id="+userDao.getUserId());
   }

   public void updateUser(UserDao userDao){
       if(usersList.containsKey(userDao.getUserId())){
           usersList.put(userDao.getUserId(), userDao);
           System.out.println("user is updated having id="+userDao.getUserId());
           return;
       }
       throw new NoSuchElementException("User is not found");
   }

   public void deleteUser(String userId){
        if(usersList.containsKey(userId)){
            usersList.remove(userId);
            return;
        }
        throw new NoSuchElementException("User doesn't exist");
   }

   public UserDao getUser(String userId){
       if(usersList.containsKey(userId)){
           System.out.println("user found with id="+userId);
           return usersList.get(userId);
       }
       throw new NoSuchElementException("No user found with id="+userId);
   }
}
