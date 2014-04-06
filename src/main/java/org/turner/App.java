package org.turner;

import org.apache.pivot.wtk.DesktopApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.turner.ui.UiMain;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
      ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:org/turner/spring-context.xml");
      DesktopApplicationContext.main(UiMain.class, args);
    }
}
