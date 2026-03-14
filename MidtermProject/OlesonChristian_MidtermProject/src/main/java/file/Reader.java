package file;

import java.util.List;

/**
 * @author Christian Oleson
 * @version 1.0
 * An interface for reading. Can be files, databases, RESTful APIs, etc.
 */
public interface Reader {
    boolean exists(String name);
    List<String> readToEnd(String name);
    String getValidInput();
}
