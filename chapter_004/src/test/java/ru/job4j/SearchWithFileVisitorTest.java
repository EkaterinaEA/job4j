package ru.job4j;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import ru.job4j.io.SearchWithFileVisitor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SearchWithFileVisitorTest {

    private static File file2;
    private static File file3;
    private static File file4;
    private static File file5;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        File folder1 = folder.newFolder("folder1");
        file2 = new File(folder1.getAbsolutePath(), "1.txt");
        file2.createNewFile();
        file3 = new File(folder1.getAbsolutePath(), "2.txt");
        file3.createNewFile();
        file4 = new File(folder1.getAbsolutePath(), "3.pdf");
        file4.createNewFile();
        File folder2 = new File(folder1.getAbsolutePath(), "folder2");
        folder2.mkdir();
        file5 = new File(folder2.getAbsolutePath(), "4.pdf");
        file5.createNewFile();
    }

    @Test
    public void searchTxt() throws IOException {
        Path path = Paths.get(folder.getRoot().getAbsolutePath());
        List<String> actualList = SearchWithFileVisitor.search(path, "txt");
        assertThat(actualList.get(0), is(file2.getAbsolutePath()));
        assertThat(actualList.get(1), is(file3.getAbsolutePath()));
    }

    @Test
    public void searchPdf() throws IOException {
        Path path = Paths.get(folder.getRoot().getAbsolutePath());
        List<String> actualList = SearchWithFileVisitor.search(path, "pdf");
        assertThat(actualList.get(0), is(file4.getAbsolutePath()));
        assertThat(actualList.get(1), is(file5.getAbsolutePath()));
    }

}
