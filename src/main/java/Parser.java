import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Parser {

    public static Command parse(String fullCommand) {
        if (fullCommand.equals("list")) {
            return new ListCommand();
        } else {
            if (fullCommand.contains("unmark")) {
                return new UpdateCommand(fullCommand);
            } else {

                if (fullCommand.contains("mark")) {
                    return new UpdateCommand(fullCommand);
                } else {
                    if (fullCommand.contains("todo")) {
                        return new AddCommand(fullCommand);

                    } else {
                        if (fullCommand.contains("deadline")) {
                            return new AddCommand(fullCommand);
                        } else {
                            if (fullCommand.contains("event")) {
                                return new AddCommand(fullCommand);

                            } else {
                                if (fullCommand.contains("delete")) {

                                    return new DeleteCommand(fullCommand);
                                } else {
                                    if (fullCommand.equals("bye")) {
                                        return new ExitCommand();

                                    }

                                }
                            }
                        }

                    }

                }
            }


        }
    return new Command();
    }
}
