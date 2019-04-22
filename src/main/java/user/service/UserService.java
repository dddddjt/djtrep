package user.service;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.util.Assert;
import user.entity.User;
import user.entity.UserData;
/*
 * 增删改查的方法实现
 */
@SuppressWarnings("unused")
public class UserService {
	//虚拟参数的数据插入
	List<User>list=UserData.in();
	
	String id;
	String name;
	String age;
	String gender;
	String date;
	String address;
	
	//显示所有User对象的方法
	public List<User> select(){
		return list;
	}
	
	//根据ID查询user对象
	public User selectById(String id) throws UnsupportedEncodingException{		 
		
		for(User user:list) {
			//若ID存在则返回对象
			if(user.getId().equals(id)) {
				return user;
			}
		} 	
		//id不存在则返回空
		 return null;
	}
	//插入方法
	public boolean insert(User user){
		String id=user.getId();
		for(User u:list) {
			if(u.getId().equals(id)) {
				//Assert.isTrue(false, "id已存在");
				//ID已存在，插入失败			
				 return false;
			}
		}
		//插入成功 返回true
		list.add(user);
		 return true;
	}
	
	public boolean delete(String id){
		for(User user:list) {
			if(user.getId().equals(id)) {
				list.remove(user);
				return true;
			}
		}
		//Assert.isTrue(false, "id不存在");
		//删除失败 ID不存在
		return false;
	}
	
	public boolean update(String id,User user){
		for(User u1:list) {
			//若ID相同进行数据更新
			//若提交的参数中存在user对应的属性的值则进行更新,若没有对应的值就不更新
			if(u1.getId().equals(id)) {
				if((name=user.getName())!=null) {
					u1.setName(name);
				}
				if((age=user.getAge())!=null) {
					u1.setAge(age);
				}
				if((gender=user.getGender())!=null) {
					u1.setGender(gender);
				}
				if((date=user.getDate())!=null) {
					u1.setDate(date);
				}
				if((address=user.getAddress())!=null) {
					u1.setAddress(address);
				}
				//更新成功返回true
				return true;
			}					
		}
		//未找到相同的id,更新失败,返回false
		return false;
	}
}
