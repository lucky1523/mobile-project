package activities.calculator;

import controles.Button;
import controles.Label;
import org.openqa.selenium.By;

public class MainScreen {
    public Button twoButton = new Button(By.id("com.android.calculator2:id/digit_2"));
    public Button plusButton = new Button(By.id("com.android.calculator2:id/op_add"));
    public Button fiveButton = new Button(By.id("com.android.calculator2:id/digit_5"));
    public Button equalsButton = new Button(By.id("com.android.calculator2:id/eq"));
    public Label resultLabel = new Label(By.id("com.android.calculator2:id/formula"));
}
