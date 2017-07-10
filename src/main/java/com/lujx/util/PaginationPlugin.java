package com.lujx.util;

import java.util.List;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.ShellRunner;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class PaginationPlugin extends PluginAdapter {

	@Override
	public boolean validate(List<String> arg0) {
		return true;
	}

	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		addLimit(topLevelClass, introspectedTable, "limitClause");

		return super.modelExampleClassGenerated(topLevelClass,
				introspectedTable);
	}

	@Override
	public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(
			XmlElement element, IntrospectedTable introspectedTable) {
		XmlElement isNotNull = new XmlElement("if");
		isNotNull.addAttribute(new Attribute("test", "limitClause != null"));
		isNotNull.addElement(new TextElement("limit ${limitClause}"));

		element.addElement(isNotNull);

		return super.sqlMapSelectByExampleWithBLOBsElementGenerated(element,
				introspectedTable);
	}

	@Override
	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(
			XmlElement element, IntrospectedTable introspectedTable) {
		XmlElement isNotNull = new XmlElement("if");
		isNotNull.addAttribute(new Attribute("test", "limitClause != null"));
		isNotNull.addElement(new TextElement("limit ${limitClause}"));

		element.addElement(isNotNull);

		return super.sqlMapSelectByExampleWithoutBLOBsElementGenerated(element,
				introspectedTable);
	}

	private void addLimit(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable, String name) {
		CommentGenerator cg = context.getCommentGenerator();

		Field field = new Field();

		field.setVisibility(JavaVisibility.PROTECTED);
		field.setType(FullyQualifiedJavaType.getStringInstance());
		field.setName(name);
		cg.addFieldComment(field, introspectedTable);
		topLevelClass.addField(field);

		char c = name.charAt(0);

		String camel = Character.toUpperCase(c) + name.substring(1);

		// 添加setter方法
		Method method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setName("set" + camel);
		method.addParameter(new Parameter(FullyQualifiedJavaType
				.getStringInstance(), name));
		method.addBodyLine("this." + name + " = " + name + ";");
		cg.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);

		// 添加getter方法
		method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(FullyQualifiedJavaType.getStringInstance());
		method.setName("get" + camel);
		method.addBodyLine("return " + name + ";");
		cg.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);
	}

	public static void generate() {

		String genCfg = "/Users/lujx/Documents/java/devSpace/aooreyWorkSpace/springDemo/src/main/resources/mybatis-gen.xml"; // src的一级目录下
		String[] args = { "-configfile", genCfg, "-overwrite" };

		ShellRunner.main(args);
	}

	 public static void main(String[] args) {
	 generate();
	 }
}
