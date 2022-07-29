package file;

import java.util.ArrayList;

public interface Reader {
    Boolean exists(String name);
    ArrayList<String> readToEnd(String name);
    String getValidInput();
}
