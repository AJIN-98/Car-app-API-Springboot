package com.ust.controllertest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ust.Exception.UserAlreadyExistsException;
import com.ust.Service.UserService;
import com.ust.controller.UserController;
import com.ust.model.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.any;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private User user;
	@MockBean
	UserService userService;
	@InjectMocks
	UserController userController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
		user = new User();
		user.setGmail("abc@gmail.com");
		user.setAddress("abcd");
		user.setPassword("pass123");
		user.setUserId(1);
		user.setUsername("raju");
	}

	@Test
	public void registerUserSuccess() throws Exception {

		when(userService.userRegisteration(user)).thenReturn(true);
		mockMvc.perform(post("/user/register").contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
				.andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());

	}

    @Test
    public void registerUserFailure() throws Exception {

        when(userService.userRegisteration(any())).thenThrow(NullPointerException.class);
        mockMvc.perform(post("/user/register")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());

    }


    @Test
    public void updateUserSuccess() throws Exception {
        user.setPassword("23456789");
        when(userService.updateUser((user))).thenReturn(true);
        mockMvc.perform(put("/user/update")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void updateUserFailure() throws Exception {
    	user.setPassword("23456789");
        when(userService.updateUser((User) any())).thenThrow(NullPointerException.class);
        mockMvc.perform(put("/user/update")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());

    }


	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}