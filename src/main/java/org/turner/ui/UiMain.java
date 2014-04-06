package org.turner.ui;

import org.apache.pivot.collections.Map;
import org.apache.pivot.wtk.*;
import org.apache.pivot.wtk.Label;
import org.apache.pivot.wtk.Window;
import org.springframework.stereotype.Component;

import java.awt.*;

/**
 * Created by turner on 06/04/14.
 */
@Component("UiMain")
public class UiMain implements Application {

  private Window window;

  @Override
  public void startup(Display display, Map<String, String> strings) throws Exception {
    window = new Window();

    Label label = new Label();
    label.setText("Hello World!");
    label.getStyles().put("font", new Font("Arial", Font.BOLD, 24));
    label.getStyles().put("color", Color.RED);
    label.getStyles().put("horizontalAlignment",
            HorizontalAlignment.CENTER);
    label.getStyles().put("verticalAlignment",
            VerticalAlignment.CENTER);

    window.setContent(label);
    window.setTitle("Hello World!");
    window.setMaximized(true);

    window.open(display);
  }

  @Override
  public boolean shutdown(boolean b) throws Exception {
    if (window != null) {
      window.close();
    }
    return true;
  }

  @Override
  public void suspend() throws Exception {

  }

  @Override
  public void resume() throws Exception {

  }
}
