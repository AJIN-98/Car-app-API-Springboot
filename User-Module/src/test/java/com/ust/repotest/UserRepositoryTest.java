package com.ust.repotest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.ust.Repository.UserRepository;
import com.ust.model.User;

import java.util.NoSuchElementException;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    
    private User user;


    @Before
    public void setUp() throws Exception {
        user = new User();
        this.user.setUserId(1);
        user.setAddress("abc address");
        user.setGmail("abc@gmail.com");
        user.setPassword("pass123");
        user.setUsername("person");
    }

    @After
    public void tearDown() throws Exception {

        userRepository.deleteAll();

    }

    @Test
    public void registerUserTest() {

        userRepository.save(user);
        User fetcheduser = userRepository.findById(1).get();
        Assert.assertEquals(user.getUserId(), fetcheduser.getUserId());

    }

    @Test(expected = NoSuchElementException.class)
    public void deleteUserTest() {
        userRepository.save(user);
        User fetcheduser = userRepository.findById(1).get();
        Assert.assertEquals(1, fetcheduser.getUserId());
        userRepository.delete(fetcheduser);
        fetcheduser = userRepository.findById(1).get();

    }

    @Test
    public void updateUserTest() {
        userRepository.save(user);
        User fetcheduser = userRepository.findById(1).get();
        fetcheduser.setPassword("pass122");
        userRepository.save(fetcheduser);
        fetcheduser = userRepository.findById(1).get();
        Assert.assertEquals("pass122", fetcheduser.getPassword());
    }

    @Test
    public void getUserByIdTest() {
        userRepository.save(user);
        User fetcheduser = userRepository.findById(1).get();
        Assert.assertEquals(user.getUserId(),fetcheduser.getUserId());

    }
}
