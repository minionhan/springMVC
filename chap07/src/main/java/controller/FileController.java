package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.madvirus.spring4.chap07.file.FileInfo;
import net.madvirus.spring4.chap07.file.NoFileInfoException;

@Controller
public class FileController {
	@RequestMapping(value="/files/{fileId:[a-zA-Z]\\d{3}}",method=RequestMethod.GET)
	public String fileInfo(@PathVariable String fileId) throws NoFileInfoException{
		FileInfo fileInfo = getFileInfo(fileId);
		if(fileInfo==null){
			throw new NoFileInfoException();
		}
		return "files/fileInfo";
	}
	private FileInfo getFileInfo(String fileId){
		if("a111".equals(fileId))
			return null;
		return new FileInfo(fileId);
	}
	@RequestMapping(value="/files/{fileId:[a-zA-Z]\\d{3}}", method=RequestMethod.POST)
	public String updateFile(@PathVariable String fileId){
		return "redirect:/files/{fileId}";
	}
	//확장자가 download이면 다 걸림
	@RequestMapping("/files/?*.download")
	public String fileInfo(HttpServletRequest request){
		return "files/fileDownload";
	}
	//files이면 다 걸림 
	@RequestMapping("/folders/**/files")
	public String list(HttpServletRequest request, Model model){
		String uri = request.getRequestURI();
		//파일이 없으면
		if(uri.endsWith("/folders/files")){
			model.addAttribute("folderIds",new String[0]);
		}else{
			String ctxPath=request.getContextPath();
			String path = ctxPath.isEmpty()? uri: uri.substring(ctxPath.length());
			String folderTreePath = path.substring("/folders/".length(), path.length()-"/files".length());
			//짤라서 페이지에 folder가 몇개 있는지 나타냄
			String[] folderIds = folderTreePath.split("/");
			model.addAttribute("folderIds",folderIds);
		}
		return "files/filesInFolder";
	}
	
}
