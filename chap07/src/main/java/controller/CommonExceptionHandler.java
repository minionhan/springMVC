package controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//이 밑에 error가 뜨면 commonException으로 보내줘라
@ControllerAdvice("net.madvirus.spring4.chap07")
public class CommonExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	public String handleException(){
		return "error/commonException";
	}

}
