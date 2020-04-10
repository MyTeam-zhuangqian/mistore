package com.example.mistroe.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;


public class UpUtils {

	public static void upfile(MultipartFile file, HttpServletRequest request) {

		//获取当前服务器的路径
		String realPath = request.getSession().getServletContext().getRealPath("/img/");
		System.out.println(realPath);
		//获取本地路径
		String basePath=System.getProperty("user.dir")+"\\src\\main\\resources\\static\\img\\";

		//创建一个文件夹
		File file1 = new File(realPath);

		//判定当前路径是否存在
		if (!file1.exists()) {
			file1.mkdirs();
		}
		File file2 = new File(basePath);
		if(!file2.exists()) {
             file2.mkdirs();
		}

		//获取文件的名称
		String orgName = file.getOriginalFilename();
		try {
			//这里需要将服务器存放视频的路径进行拼接              路径            不覆盖
			FileOutputStream fos = new FileOutputStream(realPath+orgName,true);
			FileOutputStream fos1 = new FileOutputStream(basePath+orgName,true);
			fos.write(file.getBytes());
			fos1.write(file.getBytes());
			fos1.flush();
			fos.flush();
			fos1.close();
			fos.close();
		} catch (Exception e) {
			//  Auto-generated catch block
			e.printStackTrace();

		}
	}

}
