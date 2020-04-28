package com.czp.project.web.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.czp.project.common.bean.extend.FileUrl;
import com.czp.project.utils.CodeStatus;
import com.czp.project.utils.Message;

/**
 * 用来返回需要json数据的ajax接口
 * @author mastercgx
 *
 */
@RestController
@RequestMapping("/commonJson")
public class CommonJsonController {
	
	@RequestMapping("/upload")
	public FileUrl uploadFile(HttpServletRequest req,
											  @RequestParam MultipartFile file){
		String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/";
		String filename = "";
		if(file!=null){
			filename =System.currentTimeMillis()+"_"+file.getOriginalFilename();
			System.out.println("获取到的文件:"+file.getOriginalFilename());
			//找到一个路径存放文件
			String realPath = 
					req.getServletContext().getRealPath("/file");
			System.out.println(realPath);
			//创建一个文件，并将上传文件资料传入
			File dest = new File(realPath, filename);
			try {
				file.transferTo(dest);
			} catch (Exception e) {
				e.printStackTrace();
				return new FileUrl(500,"错误");
			}
		}
		return new FileUrl(200,basePath+"file/"+filename);

		
	}
}
