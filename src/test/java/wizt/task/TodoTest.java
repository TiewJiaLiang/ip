package wizt.task;

import org.junit.jupiter.api.Test;
import wizt.ui.WizTException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {

    @Test
    public void CreateToDoTask(){
            String input1 = "todo code";

            String substr = input1.substring("todo".length());
            Task t = new Todo(substr);
            assertEquals("[T][ ] code",t.toString());
    }



}
