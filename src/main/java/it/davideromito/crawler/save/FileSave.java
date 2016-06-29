package it.davideromito.crawler.save;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class FileSave implements Save {
    private File file;

    /**
     * Create a new file with the filePath passed as parameter
     * @param filePath path of the file
     * @throws IOException
     */
    public FileSave(String filePath) throws IOException {
        file = new File(filePath);
        file.createNewFile();
    }

    /**
     * Save in the File file the set of strings passed as parameter
     * @param setOfString set of string to save
     * @throws IOException
     */
    public void saveSet(Set<String> setOfString) throws IOException {
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        for (String string : setOfString){
            bw.write(string);
        }
        bw.close();
    }

    /**
     * Save in the File file the string passed as parameter
     * @param string string to save
     * @throws IOException
     */
    public void saveString(String string) throws IOException {
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(string);
        bw.close();
    }
}
