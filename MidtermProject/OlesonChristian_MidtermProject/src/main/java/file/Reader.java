package file;

import java.util.ArrayList;

/**
 * @author Christian Oleson
 * @version 1.0
 * An interface for reading. Can be files, databases, RESTful APIs, etc.
 */
public interface Reader {
    Boolean exists(String name);
    ArrayList<String> readToEnd(String name);
    String getValidInput();
}
