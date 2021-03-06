import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileNamesGetter {
    public List<String> listFilesForFolder(final File folder) {
        List<String> list = new ArrayList<>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                list.add(fileEntry.getAbsolutePath());
            }
        }
        return list;
    }
}
