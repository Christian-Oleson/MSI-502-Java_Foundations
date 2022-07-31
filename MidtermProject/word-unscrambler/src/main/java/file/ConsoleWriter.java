package file;

import jakarta.inject.Singleton;

/**
 * @author Christian Oleson
 * @version 1.0
 * A wrapper for system.out.println() that can be injected into other classes.
 */
@Singleton
public class ConsoleWriter implements Writer {
    public void write(String contents) {
        System.out.println(contents);
    }
}
