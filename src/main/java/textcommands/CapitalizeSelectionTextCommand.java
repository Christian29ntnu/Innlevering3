package textcommands;

public class CapitalizeSelectionTextCommand extends CapitalizeTextCommand {

    private final String selection;

    public CapitalizeSelectionTextCommand(String selection) {
        if (selection == null || selection.isEmpty()) {
            throw new IllegalArgumentException("Selection kan ikke være null eller tom");
        }
        this.selection = selection;
    }

    public String getSelection() {
        return selection;
    }

    @Override
    public String execute(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        String capitalized = super.execute(selection);
        return text.replace(selection, capitalized);
    }
}
