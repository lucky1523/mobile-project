package activities.whenDo;

import controles.Button;
import controles.Label;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

public class TaskEditingScreen {
    public Button deleteTaskButton =  new Button(By.id("com.vrproductiveapps.whendo:id/deleteItem"));
    public Button confirmDeleteButton =  new Button(By.id("android:id/button1"));


}
