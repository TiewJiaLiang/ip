package wizt.parser;


import wizt.command.AddCommand;
import wizt.command.Command;
import wizt.command.DeleteCommand;
import wizt.command.ExitCommand;
import wizt.command.FindCommand;
import wizt.command.ListCommand;
import wizt.command.UpdateCommand;
/**
 *  Represents the different command the application recognises
 */
public class Parser {
    /**
     * Identify which command user has inputted
     * @param fullCommand
     * @return the corresponding command type
     */
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

                                    } else {
                                        if (fullCommand.contains("find")) {
                                            return new FindCommand(fullCommand);
                                        }
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
