package service.impl;


import domain.User;
import service.dao.Dao;

import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User> {

    //sistem de persistenta intr-o lista - joaca rol de BD
    private List<User> users = new ArrayList<User>();

    //constructor
    public UserDao() {
//        users.add(new User("Gabi", "gabi@a.com"));
//        users.add(new User("Sorina", "sorina@y.com"));
//        users.add(new User("Georgiana", "georgiana@g.com"));
    }

    public void save(User user) {
       users.add(user);
    }

    public User get(int index) {
        if(users.size() == 0){
            throw new RuntimeException();
        }
        return users.get(index);
    }

    public List<User> getAll() {

        return users;
    }

    public void update(User user, String[] parameters) throws RuntimeException {

        String name = parameters[0];
        String email = parameters[1];

        if(name == null){
            throw new RuntimeException();
        }
        user.setName(name);
        user.setEmail(email);
    }

    public void delete(User user) {
        if(users.size() == 0){
            throw new RuntimeException();
        }
          users.remove(user);
    }
}
