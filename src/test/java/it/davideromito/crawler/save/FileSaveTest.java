package it.davideromito.crawler.save;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * TEst for the class used to save the values in a file
 */
public class FileSaveTest {
    private final static String FILE_NAME = "MOCK_FILE";
    File file;
    FileSave fs;

    @Before
    public void setUp() throws Exception {
        fs = new FileSave(FILE_NAME);
        file = new File(FILE_NAME);
    }

    @After
    public void tearDown() throws Exception {
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testGenerateFile() throws Exception {
        assertTrue(file.exists());
    }

    @Test
    public void testSaveSet() throws Exception {
        String stringToSave = "Example of string to save in the file";
        fs.saveString(stringToSave);
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        assertEquals(stringToSave, br.readLine());
        assertNull(br.readLine());
        br.close();
    }

    @Test
    public void testSaveString() throws Exception {
        Set<String> set = new HashSet<>();
        String string1 = "MOCK_STRING_1";
        String string2 = "MOCK_STRING_1";
        String string3 = "MOCK_STRING_1";
        String string4 = "MOCK_STRING_1";
        set.add(string1);
        set.add(string2);
        set.add(string3);
        set.add(string4);
        fs.saveSet(set);
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        while ((line = br.readLine()) != null) {
            assertTrue(set.contains(line));
            set.remove(line);
        }
        br.close();
        assertTrue(set.isEmpty());
    }
}