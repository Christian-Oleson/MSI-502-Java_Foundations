package FinalAssignment;

/**
 * A class of string messages
 */
public class Messages {
    private Messages() {}

    public static final String OPTIONS_FOR_USER = """
            1 - Find the best year for a name
            2 - Find the best rank for a name
            3 - Plot the popularity of a name
            4 - Clear the plot
            5 - Quit
            Enter your selection.""";

    public static final String NAME_PROMPT = "Enter the name for which you want data:";

    public static final String INVALID_INPUT = "Not a valid selection. Please input an integer";
}
