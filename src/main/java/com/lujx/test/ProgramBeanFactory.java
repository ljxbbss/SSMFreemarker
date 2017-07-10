package com.lujx.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.lujx.service.TestBean;

/**
 * @author Lujx 🐯 🐶 🐼 🦁 ✨
 * @date 创建时间：2017年7月3日
 */
public class ProgramBeanFactory {

	public static void main(String[] args) {
		ClassPathResource resource = new ClassPathResource(
				"spring-applicationContext.xml");
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(resource);
		TestBean bean = (TestBean) factory.getBean("testBean");
		bean.test();
	}
}
