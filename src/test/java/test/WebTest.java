package test;

import java.util.List;

import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import user.entity.User;
import user.service.UserService;

public class WebTest {
	private String url ="http://127.0.0.1:8080/user-web2/";
	//private String method;
	Gson gson=new Gson();
	private String id;
	private String name;
	private String age;
	private String gender;
	private String date;
	private String address;
	private User user=new User();
	
	private UserService userserv;
	RestTemplate restTemplate=new RestTemplate();
	
	@Test
	public void testSelectById() {
		id="1";
		restTemplate.getForObject(url+"select?id="+id, String.class);
	}
	
	@Test
	public void testUpdate() {
		id="4";
		name="zxc";
		age="18";
		gender="man";
		date="2019-04-04";
		address="hangz";
		user.setId(id);
		user.setName(name);
		user.setAge(age);
		user.setGender(gender);
		user.setDate(date);
		user.setAddress(address);
		System.out.println(user.toString());
		restTemplate.postForObject(url+"update", user,String.class);
	}
}









