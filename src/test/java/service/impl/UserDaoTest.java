package service.impl;

import domain.User;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserDaoTest {

    private UserDao userDao; //pot pune interfata ca tip? Dao
    private List<User> users;

    @Before
    public void setUserDao() {
        userDao = new UserDao();
        users = new ArrayList<User>();
    }

    //READ --- get -- no element
    @Test(expected = RuntimeException.class)
    public void testWhenTheListOfUsersIsEmptyGetMethodThrowsRuntimeException() {
        System.out.println("testWhenTheListOfUsersIsEmptyGetMethodThrowsRuntimeException");
        users.get(0);
        //testWhenTheListOfUsersIsEmptyGetMethodThrowsRuntimeException
    }
    //READ --- get -- one element
    @Test
    public void testWhenTheListOfUsersHasOneElementGetMethodReturnsIt() {
        System.out.println("testWhenTheListOfUsersHasOneElementGetMethodReturnsIt");
        userDao.save(new User("Sorina", "sorina@gmail.com"));
        assertEquals("Sorina", userDao.get(0).getName());
        assertEquals("sorina@gmail.com", userDao.get(0).getEmail());
        assertEquals(0, users.size());
        //testWhenTheListOfUsersHasOneElementGetMethodReturnsIt
    }

    //READ --- getAll -- no element
    @Test
    public void testWhenTheListOfUsersIsEmptyGetAllMethodReturnsEmptyList() {
        System.out.println("testWhenTheListOfUsersIsEmptyGetAllMethodReturnsEmptyList");
        assertEquals(0, userDao.getAll().size());
        //testWhenTheListOfUsersIsEmptyGetAllMethodReturnsEmptyList
    }
    //READ --- getAll -- one element
    @Test
    public void testWhenTheListOfUsersHasOneElementGetAllMethodReturnsListOfSizeOne() {
        System.out.println("testWhenTheListOfUsersHasOneElementGetAllMethodReturnsListOfSizeOne");
        userDao.save(new User("Sorina", "sorina@gmail.com"));
        assertEquals(1, userDao.getAll().size());
        //testWhenTheListOfUsersHasOneElementGetAllMethodReturnsListOfSizeOne
    }

    //READ --- getAll --  two element2
    @Test
    public void testWhenTheListOfUsersHasTwoElementsGetAllMethodReturnsListOfSizeTwo() {
        System.out.println("testWhenTheListOfUsersHasTwoElementsGetAllMethodReturnsListOfSizeTwo");
        userDao.save(new User("Sorina", "sorina@gmail.com"));
        userDao.save(new User("S", "soa@gmail.com"));
        assertEquals(2, userDao.getAll().size());
        //testWhenTheListOfUsersHasTwoElementsGetAllMethodReturnsListOfSizeTwo
    }


    //CREATE --- save -- on empty list
    @Test
    public void testWhenTheListOfUsersIsEmptySaveMethodAddsOneUser() {
        System.out.println("testWhenTheListOfUsersIsEmptySaveMethodAddsOneUser");
        User user1 = new User("Sorina", "sorina@gmail.com");
        userDao.save(user1);
        System.out.println(userDao.get(users.size()));
//        testWhenTheListOfUsersIsEmptySaveMethodAddsOneUser
//        User{name='Sorina', email='sorina@gmail.com'}
    }
    //CREATE --- save -- when list has one element, initially
    @Test
    public void testWhenTheListOfUsersHasOneElementSaveMethodAddSecondUser() {
          System.out.println("testWhenTheListOfUsersHasOneElementSaveMethodAddSecondUser");
          userDao.save(new User("Sorina", "sorina@gmail.com"));
          userDao.save(new User("Georgiana", "georgiana@gmail.com"));
          assertEquals(2, userDao.getAll().size());
          //testWhenTheListOfUsersHasOneElementSaveMethodAddSecondUser
    }

    //DELETE --- delete -- when the list is empty
    @Test(expected = RuntimeException.class)
    public void testWhenTheListOfUsersIsEmptyDeleteMethodThrowsRuntimeException() {
        System.out.println("testWhenTheListOfUsersIsEmptyDeleteMethodThrowsRuntimeException");
        User user1 = new User("", "s@s.com");
        userDao.delete(user1);
        //testWhenTheListOfUsersIsEmptyDeleteMethodThrowsRuntimeException
    }
    //DELETE --- delete -- when the list has one element
    @Test
    public void testWhenTheListOfUsersHasOneElementDeleteMethodEraseThatElement() {
        System.out.println(" testWhenTheListOfUsersHasOneElementDeleteMethodEraseThatElement");
        User user1 = new User("Sorina", "s@s.com");
        userDao.save(user1);
        assertEquals(1, userDao.getAll().size());
        userDao.delete(user1);
        assertEquals(0, userDao.getAll().size());
        //testWhenTheListOfUsersHasOneElementDeleteMethodEraseThatElement
    }

    //UPDATE--- update -- one element in list
    @Test(expected = RuntimeException.class)
    public void testWhenTheListOfUsersHasOneElementUpdateMethodThrowsRuntimeException() {
        System.out.println("testWhenTheListOfUsersHasOneElementUpdateMethodThrowsRuntimeException");
        User user1 = new User("Sorina", "sorina@gmail.com");
        userDao.save(user1);
        assertEquals("Sorina", userDao.get(0).getName());
        assertEquals("sorina@gmail.com", userDao.get(0).getEmail());

        userDao.update(user1, new String[]{"", "serban@gmail.com"});//empty name
        //!!! nu merge asta
        //java.lang.AssertionError: Expected exception: java.lang.AssertionError
    }

    //UPDATE--- update -- one element in list
    @Test
    public void testWhenTheListOfUsersHasOneElementUpdateMethodReturnsObjectModified() {
        System.out.println("testWhenTheListOfUsersHasOneElementUpdateMethodReturnsObjectModified");
        User user1 = new User("Sorina", "sorina@gmail.com");
        userDao.save(user1);
        assertEquals("Sorina", userDao.get(0).getName());
        assertEquals("sorina@gmail.com", userDao.get(0).getEmail());

        userDao.update(user1, new String[]{"Georgiana", "serban@gmail.com"});//
        System.out.println(userDao.getAll());

        assertEquals("Georgiana", user1.getName());
        assertEquals("serban@gmail.com", user1.getEmail());
        // testWhenTheListOfUsersHasOneElementUpdateMethodReturnsObjectModified
        // [User{name='Georgiana', email='serban@gmail.com'}]
    }



}
