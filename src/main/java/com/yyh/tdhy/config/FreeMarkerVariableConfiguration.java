package com.yyh.tdhy.config;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import freemarker.template.TemplateModelException;

/*${staticPath}路径配置*/
@Configuration
public class FreeMarkerVariableConfiguration {

	@Autowired
	private ServletContext servletContext;
	@Autowired
	private freemarker.template.Configuration configuration;

	@PostConstruct
	public void setVariableConfiguration() throws TemplateModelException {
		configuration.setSharedVariable("staticPath", "/static");
	}
}
