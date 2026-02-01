package textcommands;

import java.util.List;
import textcommands.TextCommand;

public class Script implements TextCommand {

    private final List<TextCommand> textCommands;

    public Script(List<TextCommand> textCommands) {
        if (textCommands == null) {
            throw new IllegalArgumentException("Command list cannot be null");
        }
        this.textCommands = textCommands;
    }

    @Override
    public String execute(String text) {
        String result = text;
        for (TextCommand command : textCommands) {
            result = command.execute(result);
        }
        return result;
    }

    public List<TextCommand> getTextCommands() {
        return textCommands;
    }
}