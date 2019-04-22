package user.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import user.exception.MyException;

@ControllerAdvice
public class ExService {
	
	@ExceptionHandler(MyException.class)

	public String MyExceptionHandler(MyException exception,Model model) throws UnsupportedEncodingException {
		String msg=exception.getErrMsg();
		model.addAttribute("msg",msg);
		return "exception";
	}
}
