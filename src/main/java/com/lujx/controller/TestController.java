package com.lujx.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lujx.entity.Article;
import com.lujx.service.impl.ArticleService;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author Lujx 🐯 🐶 🐼 🦁 ✨
 * @date 创建时间：2017年7月7日
 */
@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	ArticleService service;

	@RequestMapping("/parse")
	@ResponseBody
	public void parse(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		 //首页新闻列表路径
        String indexPath=request.getRealPath("/index.html");
        
        //文件是否存在
        File file=new File(indexPath);
        if(!file.exists()){
            //如果新闻列表不存在，生成新闻列表
            
            //创建一个freemarker.template.Configuration实例，它是存储 FreeMarker 应用级设置的核心部分
            //指定版本号
            Configuration cfg=new Configuration(Configuration.VERSION_2_3_22);
            //获得模板文件路径
            String templatePath=this.getClass().getClassLoader().getResource("/templates").getPath();
            //设置模板目录
            cfg.setDirectoryForTemplateLoading(new File(templatePath));
            //设置默认编码格式
            cfg.setDefaultEncoding("UTF-8");
            
            //数据
            Map<String, Object> articleData = new HashMap<>();
            List<Article> articles=service.getArticles();
            articleData.put("articles", articles);
            
            //从设置的目录中获得模板
            Template template = cfg.getTemplate("newsList.ftl");
            
            //合并模板和数据模型
            try {
                //将数据与模板渲染的结果写入文件中
                Writer writer=new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
                template.process(articleData, writer);
                writer.flush();
                
                articleData.clear();
                template = cfg.getTemplate("news.ftl");
                //生成单个新闻文件
                for (Article article : articles) {
                    articleData.put("article", article);
                    //单个新闻文件
                    file=new File(request.getRealPath("/news/"+article.getId()+".html"));
                    //文件输出流写入器
                    writer=new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
                    //将模板+数据生成的结果写入文件中，得到一个静态文件
                    template.process(articleData, writer);
                    writer.flush();
                }
                writer.close();
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        }
        //如果新闻单页下存在，生成新闻单页
        request.getRequestDispatcher("index.html").forward(request, response);
		
		
		
	}
}
