package activities.whenDo;

import controles.Button;
import controles.Label;
import org.openqa.selenium.By;
import java.net.MalformedURLException;

public class MainScreen {
    public Button addTaskButton = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));

    public boolean isTaskNameDisplayed(String name){
        Label nameProject = new Label(By.xpath("//android.widget.TextView[@text='"+name+"']"));
        return nameProject.isControlDisplayed();
    }

    public String getTaskName(String name) throws MalformedURLException {
        Label nameTask = new Label(By.xpath("//android.widget.TextView[@text='"+name+"']"));
        return nameTask.getText();
    }
    public void clickTaskName (String name) throws MalformedURLException {
        Label nameTask = new Label(By.xpath("//android.widget.TextView[@text='"+name+"']"));
        nameTask.click();
    }
}
