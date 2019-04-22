package user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import user.entity.User;
import user.entity.UserData;
import user.service.UserService;

/*
 * 控制层
 */
@Controller
public class UserController {
	
	@Autowired
	UserService userservice;	
	List<User> list;
	@Autowired
	User user;
	String msg;	
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList(Model model) throws IOException {		
				list=userservice.select();	
				model.addAttribute("list", list);
				return "list";
				
	}
	
	@RequestMapping(value = "/select", method = RequestMethod.GET)
	public String getUserById( String id,Model model) throws IOException {		
				if(null==id) {
					model.addAttribute("msg", "id不能为空");
				}else {
					user=userservice.selectById(id);	
					if(null==user) {
						model.addAttribute("msg", "id不存在");
					}else {
						model.addAttribute("msg", user);			
					}
				}						
				return "getUserById";
	}
	

	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insertList(User u,Model model) throws IOException {	
			System.out.println("testinsert");
			if(userservice.insert(u)) {
				//如果插入成功
				model.addAttribute("msg", "插入成功");
			}else {
				model.addAttribute("msg", "id已存在,插入失败");
			}
		return "result";
			
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteList(@RequestParam(value="id", required=false) String id,Model model) throws IOException {	
			if(null==id) {
				model.addAttribute("msg", "id不能为空");
			}
			else if(userservice.delete(id)) {
				//如果删除成功
				model.addAttribute("msg", "删除成功");
			}else {
				//如果删除失败
				model.addAttribute("msg", "ID不存在,删除失败");
			}		
			return "result";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateList(Model model,User user) throws IOException {	
		    String id;
			id=user.getId();
			if(userservice.update(id, user)) {
				//更新成功
				model.addAttribute("msg", "更新成功");
			}else {
				//更新失败
				model.addAttribute("msg", "ID不存在,更新失败");
			}
			return "result";
	}
}
