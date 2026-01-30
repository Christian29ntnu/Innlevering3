package textcommands;

public class WrapSelectionTextCommand extends WrapTextCommand {

    private final String selection;

    public WrapSelectionTextCommand(String opening, String end, String selection) {
        super(opening, end);
        this.selection = selection;
    }

    public String getSelection() {
        return selection;
    }

    @Override
    public String execute(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        return text.replace(
                selection,
                getOpening() + selection + getEnd()
        );
    }
}
