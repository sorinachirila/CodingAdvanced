package application;

import domain.User;
import service.dao.Dao;
import service.impl.UserDao;

import java.util.List;

public class Application {

    private static Dao userDao;

    public static void main(String[] args) {

         userDao = new UserDao();

        System.out.println("======== READ ALL USERS ========");
         //READ
         //getAll();
         List<User> users = userDao.getAll(); //si get(index) se poate apela ======== READ

         for(User user:users){
             System.out.println(user);
         }
        System.out.println("=============================\n");
        System.out.println("======== READ ONE USER ========");
         //get(index)
        User user1 = users.get(0);
        System.out.println(user1);
        System.out.println("=============================\n");
        System.out.println("======== UPDATE ONE USER ========");
         //UPDATE
        userDao.update(user1, new String[]{"Serban", "serban@gmail.com"});
        System.out.println(user1);
        System.out.println("=============================\n");

        System.out.println("======== DELETE ONE USER ========");
        //DELETE
        User user2 = users.get(1);
        userDao.delete(user2);
        for(User user:users){
            System.out.println(user);
        }
        System.out.println("=============================\n");

        System.out.println("======== CREATE ONE USER ========");
        //CREATE
        userDao.save(new User("Matei", "matei@y.com"));
        System.out.println(users.get(users.size()-1));
        System.out.println("=============================\n");

/*======== READ ALL USERS ========
        User{name='Gabi', email='gabi@a.com'}
        User{name='Sorina', email='sorina@y.com'}
        User{name='Georgiana', email='georgiana@g.com'}
=============================

======== READ ONE USER ========
        User{name='Gabi', email='gabi@a.com'}
=============================

======== UPDATE ONE USER ========
        User{name='Serban', email='serban@gmail.com'}
=============================

======== DELETE ONE USER ========
        User{name='Serban', email='serban@gmail.com'}
        User{name='Georgiana', email='georgiana@g.com'}
=============================

======== CREATE ONE USER ========
        User{name='Matei', email='matei@y.com'}
=============================*/
    }
}
