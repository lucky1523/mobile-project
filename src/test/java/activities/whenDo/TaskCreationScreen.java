package activities.whenDo;

import controles.Button;
import controles.TextBox;
import org.openqa.selenium.By;
import java.net.MalformedURLException;

public class TaskCreationScreen {
    public TextBox newTaskNameTxtBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
    public TextBox newTaskDescriptionTxtBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"));
    public Button saveTaskButton = new Button(By.id("com.vrproductiveapps.whendo:id/saveItem"));

    public void createTask (String t_name, String t_description) throws MalformedURLException {
        this.newTaskNameTxtBox.setValue(t_name);
        this.newTaskDescriptionTxtBox.setValue(t_description);
        this.saveTaskButton.click();
    }
}
