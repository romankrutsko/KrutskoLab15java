import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ThreadsManager {

    public List<String> manageThreads(List<String> list) throws InterruptedException {
        List<FileReaderCustom> threads = new ArrayList<>();
        for (String str : list) {
            threads.add(new FileReaderCustom(new File(str)));
        }

        for (FileReaderCustom t : threads) {
            t.start();
        }

        List<String> allLines = new ArrayList<>();

        for (FileReaderCustom t : threads) {
            t.join();
            allLines.addAll(t.getLines());
        }

        return allLines;
    }
}
