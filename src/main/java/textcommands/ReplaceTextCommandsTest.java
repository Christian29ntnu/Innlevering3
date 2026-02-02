package textcommands;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReplaceTextCommandTest {

    @Test
    void testReplaceTextCommand() {
        ReplaceTextCommand command = new ReplaceTextCommand("target", "replacement");
        String input = "text with target and target";
        String expected = "text with replacement and replacement";

        assertEquals(expected, command.execute(input));
    }

    @Test
    void testReplaceFirstTextCommand() {
        ReplaceFirstTextCommand command = new ReplaceFirstTextCommand("target", "replacement");
        String input = "text with target and target";
        String expected = "text with replacement and target";

        assertEquals(expected, command.execute(input));
    }

    @Test
    void testAccessors() {
        ReplaceTextCommand command = new ReplaceTextCommand("old", "new");
        assertEquals("old", command.getTarget());
        assertEquals("new", command.getReplacement());
    }

    @Test
    void testNoMatch() {
        ReplaceTextCommand command = new ReplaceTextCommand("missing", "new");
        String input = "some text here";
        // Hvis teksten ikke finnes, skal originalen fortsatt bli returnert
        assertEquals(input, command.execute(input));

        ReplaceFirstTextCommand firstCommand = new ReplaceFirstTextCommand("missing", "new");
        assertEquals(input, firstCommand.execute(input));
    }

    @Test
    void testEmptyString() {
        ReplaceTextCommand command = new ReplaceTextCommand("a", "b");
        assertEquals("", command.execute(""));
    }

    @Test
    void testNullReplacementTarget() {
        // Dette vil kaste NullPointerException hvis input er null
        ReplaceTextCommand command = new ReplaceTextCommand("a", "b");
        assertThrows(NullPointerException.class, () -> command.execute(null));
    }
}
