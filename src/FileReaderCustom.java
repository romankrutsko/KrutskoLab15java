import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderCustom extends Thread{
    private final File file;
    private List<String> lines;

    public FileReaderCustom(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile() throws IOException {
        String in;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        List<String> listOfSorted = new ArrayList<>();
        RegexToCheck regexToCheck = new RegexToCheck();

        while ((in = bufferedReader.readLine()) != null) {
            regexToCheck.regex(in, listOfSorted);

        }
        setLines(listOfSorted);

        bufferedReader.close();
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }
}
