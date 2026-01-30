package textcommands;

public class WrapLinesTextCommand extends WrapTextCommand {

    public WrapLinesTextCommand(String opening, String end) {
        super(opening, end);
    }

    @Override
    public String execute(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }

        String[] lines = text.split("\n");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < lines.length; i++) {
            result.append(getOpening())
                    .append(lines[i])
                    .append(getEnd());

            if (i < lines.length - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }
}
