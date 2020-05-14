
package com.czp.project.web.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.czp.project.common.bean.Medical;
import com.czp.project.common.bean.OldMan;
import com.czp.project.common.bean.extend.MainData;
import com.czp.project.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

	@Autowired
	private OldManMsgImpl oldimpl;
	@Autowired
	private OmwcImpl wcimpl;
	@Autowired
	private OmqjImpl qjipml;
	@Autowired
	private MonitorImpl monitorImpl;
	@Autowired
	private MedicalImpl medicalImpl;
	@Autowired
	private CostServiceImpl costImpl;



	@RequestMapping("/upload")
	public FileUrl uploadFile(HttpServletRequest req,
											  @RequestParam MultipartFile file){
		String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+"/";
		String filename = "";
		if(file!=null){
			filename =System.currentTimeMillis()+"_"+file.getOriginalFilename();
			//找到一个路径存放文件
			String realPath = 
					req.getServletContext().getRealPath("/file");
			//创建一个文件，并将上传文件资料传入
			File dest = new File(realPath, filename);
			try {
				file.transferTo(dest);
			} catch (Exception e) {
				e.printStackTrace();
				return new FileUrl(500,"错误");
			}
		}
		//return new FileUrl(200,basePath+"file/"+filename);
		return new FileUrl(200,"file/"+filename);


	}

	@RequestMapping("/mainData/{member_id}")
	public ResponseEntity<Message> getMainData(@PathVariable String member_id){
		//根据家属id查出老人id
		OldMan oldMan = oldimpl.getOldmanByFamiluId(member_id);
		if (oldMan==null){
			return ResponseEntity.ok(new Message(CodeStatus.ERROR));
		}
		String id = String.valueOf(oldMan.getId());
		//获取数目
		MainData md = new MainData();
		md.setQjNumb(qjipml.selectByOldManId(id).size());
		md.setJyNumb(medicalImpl.selectByOldManId(id).size());
		md.setTjNumb(monitorImpl.selectAllByOldManId(id).size());
		md.setWcNumb(wcimpl.selectByOldManId(id).size());
		//获取老人的缴费记录
		md.setCostLogs(costImpl.selectByOldManId(id));
		return ResponseEntity.ok(new Message(CodeStatus.SUCCESS,md));
	}
}
