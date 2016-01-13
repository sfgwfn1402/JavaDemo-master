package com.gome.rebate;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

import com.andieguo.saxparserdemo.Book;

/**
 * ��������
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
			logger.warning("���������: projectName");
			System.exit(-1);
		}
		projectName = args[0];
		logger.info("�ڵ�ǰĿ¼����Ŀ¼���ҡ�" + projectName + "����Ŀ��");
	}

}
