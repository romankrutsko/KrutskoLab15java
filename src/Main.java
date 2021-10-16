import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static final String DIR_PATH = "C:\\Users\\romak\\Desktop\\LabJava15";

    public static void main(String[] args) throws InterruptedException, IOException {
        List<String> list;

        ThreadsManager threadsManager = new ThreadsManager();

        FileNamesGetter fileNamesGetter = new FileNamesGetter();
        list = fileNamesGetter.listFilesForFolder(new File(DIR_PATH));

        List<String> toWrite = threadsManager.manageThreads(list);

        WriterToFile writer = new WriterToFile();

        writer.write(toWrite);

        System.out.println(toWrite);
    }
}
