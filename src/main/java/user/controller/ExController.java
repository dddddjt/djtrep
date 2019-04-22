package user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import user.exception.MyException;

@Controller
public class ExController {
	
	@RequestMapping(value="/exception",method=RequestMethod.GET)
	public void ExceptionController(@RequestParam(value="id") String id) throws Exception{
		if(id.equals("1")) {
			throw new MyException("1", "id不存在");
		}else if(id.equals("2")) {
			throw new MyException("2", "id已存在");
		}
	}
}
