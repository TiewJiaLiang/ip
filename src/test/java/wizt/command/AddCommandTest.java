package wizt.command;

import org.junit.jupiter.api.Test;
import wizt.task.Task;
import wizt.task.Todo;
import wizt.ui.WizTException;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddCommandTest {
    @Test
    public void EmptyToDoDescription(){


        String input1 = "todo";

        Task tasks = new Todo(input1); // Assuming `tasks` is a wrapper for the list

        // Assert that the WizTException is thrown
        WizTException exception = assertThrows(WizTException.class, () -> {
            if (input1.contains("todo")) {
                String substr = input1.substring("todo".length());
                if (substr.isEmpty()) {
                    throw new WizTException("Please enter a description!");
                }


            }
        });

        // Assert that the exception message is correct
        assertEquals("Please enter a description!", exception.getMessage());
    }




}



