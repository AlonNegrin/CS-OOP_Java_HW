
import java.io.IOException;
import java.io.Writer;

@SuppressWarnings("serial")
public class HW3Exception extends Exception {


    public HW3Exception(String message) {
        super(message);

    }

    public void writeError(Writer file, int line, String lineInput) throws IOException {
        String result = String.format("line number=%d, input line=%s, Error message = %s", line, lineInput, getMessage());

        file.append(result);
        file.append("\n");

        file.flush();

    }

}
