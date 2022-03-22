package testClean;


import activities.whenDo.MainScreen;

import activities.whenDo.TaskCreationScreen;
import activities.whenDo.TaskEditingScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.net.MalformedURLException;

public class WhenDoTest {
    TaskCreationScreen taskCreationScreen= new TaskCreationScreen();
    TaskEditingScreen taskEditingScreen= new TaskEditingScreen();
    MainScreen mainScreen= new MainScreen();
    @Test
    public void CrearYBorrarTarea() throws MalformedURLException {
        String nombreProyecto = "Luciano";
        mainScreen.addTaskButton.click();
        taskCreationScreen.newTaskNameTxtBox.setValue(nombreProyecto);
        taskCreationScreen.newTaskDescriptionTxtBox.setValue("Descripcion Luciano");
        taskCreationScreen.saveTaskButton.click();


        String expectResult = nombreProyecto;
        String actualResult = mainScreen.getTaskName(nombreProyecto);
        Assertions.assertEquals(expectResult, actualResult, "ERROR la suma es incorrecta");

        mainScreen.clickTaskName(nombreProyecto);
        taskEditingScreen.deleteTaskButton.click();
        taskEditingScreen.confirmDeleteButton.click();

        Assertions.assertFalse(mainScreen.isTaskNameDisplayed(nombreProyecto), "error");
    }
    @AfterEach
    public void closeApp() throws MalformedURLException {
        Session.getInstance().closeSession();
    }
}