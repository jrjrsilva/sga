package br.gov.ba.pm.sga.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.dialect.springdata.SpringDataDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

/*import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
*/
@Configuration
public class ThymeleafConfiguration {
	
	@Bean
	public ITemplateEngine templateEngine(ITemplateResolver templateResolver) {
	    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver);
	    templateEngine.setEnableSpringELCompiler(true);
	    templateEngine.addDialect(new SpringDataDialect());
	    return templateEngine;
	}
	
	/*@Bean
    public SpringDataDialect springDataDialect() {
        return new SpringDataDialect();
    }
	*/
	
	
	/*@Bean
	public ClassLoaderTemplateResolver  emailTemplateResolver() {
		ClassLoaderTemplateResolver emailTemplateResolver=new ClassLoaderTemplateResolver();
	    emailTemplateResolver.setPrefix("templates/");
	    emailTemplateResolver.setTemplateMode("HTML5");
	    emailTemplateResolver.setSuffix(".html");
	    emailTemplateResolver.setTemplateMode("XHTML");
	    emailTemplateResolver.setCharacterEncoding("UTF-8");
	    emailTemplateResolver.setOrder(1);
	    return emailTemplateResolver;
	}*/
	
}
