package net.madvirus.spring4.chap07.file;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//이걸 적으면 404error
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoFileInfoException extends Exception{
	private static final long serialVersionUID = 1L;

}
