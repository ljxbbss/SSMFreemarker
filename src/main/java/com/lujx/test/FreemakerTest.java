package com.lujx.test;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @author Lujx 🐯 🐶 🐼 🦁 ✨
 * @date 创建时间：2017年7月10日
 */
public class FreemakerTest {

	public static void main(String[] args) throws Exception {
		// 创建一个freemarker.template.Configuration实例，它是存储 FreeMarker 应用级设置的核心部分
		// 指定版本号
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
		// 设置模板目录
		cfg.setDirectoryForTemplateLoading(new File("src/main/java/templates"));
		// 设置默认编码格式
		cfg.setDefaultEncoding("UTF-8");
		   //数据
        Map<String, Object> postMap = new HashMap<>();
        postMap.put("postName", "Huwei P8");
        postMap.put("postCode", "sales");
        postMap.put("postDesc", "销售就是卖东西的");
        postMap.put("posts", new String[]{"Tom","Jack","Rose"});
        //从设置的目录中获得模板
        Template temp = cfg.getTemplate("post.ftl");
        
        //合并模板和数据模型
        Writer out = new OutputStreamWriter(System.out);
        temp.process(postMap, out);
        //关闭
        out.flush();
        out.close();
	}

}
