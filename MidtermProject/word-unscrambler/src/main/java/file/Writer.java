package file;

/**
 * @author Christian Oleson
 * @version 1.0
 * An interface for writing. Can be console, files, databases, RESTful APIs, etc.
 */
public interface Writer {
    void write(String contents);
}
