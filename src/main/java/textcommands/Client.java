package textcommands;

import java.util.*;

public class Client {

    public static void main(String[] args) {

        if (args.length < 2) {
            printUsage();
            return;
        }

        String commandName = args[0].toLowerCase();
        String text;
        TextCommand command;

        try {
            switch (commandName) {

                case "capitalize":
                    command = new CapitalizeTextCommand();
                    text = args[1];
                    break;

                case "capitalizewords":
                    command = new CapitalizeWordsTextCommand();
                    text = args[1];
                    break;

                case "wrap":
                    if (args.length < 4) {
                        printUsage();
                        return;
                    }
                    command = new WrapTextCommand(args[1], args[2]);
                    text = args[3];
                    break;

                case "replace":
                    if (args.length < 4) {
                        printUsage();
                        return;
                    }
                    command = new ReplaceTextCommand(args[1], args[2]);
                    text = args[3];
                    break;

                case "script":
                    // Eksempel på script med flere kommandoer
                    List<TextCommand> commands = new ArrayList<>();
                    commands.add(new CapitalizeTextCommand());
                    commands.add(new WrapTextCommand("<p>", "</p>"));

                    command = new Script(commands);
                    text = args[1];
                    break;

                default:
                    System.out.println("Ukjent kommando: " + commandName);
                    printUsage();
                    return;
            }

            String result = command.execute(text);
            System.out.println(result);

        } catch (Exception e) {
            System.out.println("Feil under kjøring: " + e.getMessage());
        }
    }

    private static void printUsage() {
        System.out.println("Bruk:");
        System.out.println(" capitalize <tekst>");
        System.out.println(" capitalizeWords <tekst>");
        System.out.println(" wrap <opening> <end> <tekst>");
        System.out.println(" replace <target> <replacement> <tekst>");
        System.out.println(" script <tekst>");
    }
}