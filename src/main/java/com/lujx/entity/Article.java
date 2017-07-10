package com.lujx.entity;

/**
 * @author Lujx 🐯 🐶 🐼 🦁 ✨
 * @date 创建时间：2017年7月10日
 */
public class Article {
	
	
	public Article() {
		// TODO Auto-generated constructor stub
	}

	public Article(int id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	/*
	 * 编号
	 */
	private int id;
	/*
	 * 标题
	 */
	private String title;
	/*
	 * 内容
	 */
	private String content;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
	
}
