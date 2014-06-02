package ru.yandex.qatools.allure.config;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static ru.yandex.qatools.allure.config.AllureNamingUtils.*;

/**
 * @author Artem Eroshenko eroshenkoam@yandex-team.ru
 *         Date: 12/25/13
 */
public class AllureNamingUtilsTest {

    private File directory;

    @Before
    public void initDirectory() {
        directory = mock(File.class);
        when(directory.isDirectory()).thenReturn(true);
        when(directory.canRead()).thenReturn(true);
    }

    @Test(expected = IllegalStateException.class)
    public void createInstanceTest() throws Exception {
        new AllureNamingUtils();
    }

    @Test
    public void generatedTestSuiteFileNamesMustBeFoundByListTestSuiteFilesMethod() {
        File[] testSuiteFiles = new File[]{
                new File(generateTestSuiteFileName()),
                new File(generateTestSuiteFileName())
        };

        when(directory.listFiles(any(FileFilter.class))).thenReturn(testSuiteFiles);
        assertThat(listTestSuiteFiles(directory).size(), equalTo(testSuiteFiles.length));
    }

    @Test
    public void ListAttachmentFilesTest() {
        File[] attachmentFiles = new File[]{
                new File("a-attachment"),
                new File("b-attachment.xml")
        };

        when(directory.listFiles(any(FileFilter.class))).thenReturn(attachmentFiles);
        assertThat(listAttachmentFiles(directory).size(), equalTo(attachmentFiles.length));
    }
}