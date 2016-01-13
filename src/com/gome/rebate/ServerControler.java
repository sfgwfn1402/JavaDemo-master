package com.gome.rebate;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

import com.andieguo.saxparserdemo.Book;

/**
 * 启动服务
 * 
 * @author duwei
 */
public class ServerControler {
	private static final Logger logger = Logger.getLogger("ServerControler");
	private static String projectName = "";
	private static String source = "/WEB-INF/classes";
	private static String currentPath = System.getProperty("user.dir");

	public static void main(String[] args) {
		if (args.length == 0) {
			logger.warning("请输入参数: projectName");
			System.exit(-1);
		}
		projectName = args[0];
		logger.info("在当前目录及子目录查找【" + projectName + "】项目名");
	}

}
