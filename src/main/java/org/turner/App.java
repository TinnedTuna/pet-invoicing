package org.turner;

import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.turner.ui.MainUI;

/**
 * Hello world!
 *
 */
public class App {
  
  private static final String SPRING_CONTEXT 
          = "classpath:org/turner/spring-context.xml";
  
  public static void main(final String[] args) 
          throws InterruptedException, InvocationTargetException {
    ApplicationContext ctx = new ClassPathXmlApplicationContext(SPRING_CONTEXT);
    final MainUI mainUI = new MainUI();
    SwingUtilities.invokeAndWait(new Runnable() {

      @Override
      public void run() {
        mainUI.show();;
      }
    });
    
  }
}
