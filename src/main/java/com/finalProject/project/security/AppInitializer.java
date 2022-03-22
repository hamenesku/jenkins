//package com.finalProject.project.security;
//
//
//import javax.servlet.ServletContext;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.ImportResource;
//import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
//import org.springframework.web.context.ContextLoaderListener;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.filter.DelegatingFilterProxy;
//
//public class AppInitializer extends AbstractSecurityWebApplicationInitializer {
//
//	@Configuration
//	@ImportResource({ "classpath:webSecurityConfig.xml" })
//	public class SecSecurityConfig {
//	   public SecSecurityConfig() {
//	      super();
//	   }
//	}
//	
//    @Override
//    public void onStartup(ServletContext sc) {
//
//        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
//        root.register(SecSecurityConfig.class);
//
//        sc.addListener(new ContextLoaderListener(root));
//
//        sc.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain"))
//          .addMappingForUrlPatterns(null, false, "/*");
//    }
//	
//}
