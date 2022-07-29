package file;

import jakarta.inject.Singleton;

@Singleton
public class ConsoleWriter implements Writer {

    public void write(String contents) {
        System.out.println(contents);
    }
}
