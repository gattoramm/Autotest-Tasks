package com.itvdn.rules;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.*;

public class TemporaryFolderRuleTest {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	private static File txtFile, tempFolder;

	@Test
	public void createTempFile() throws IOException {
		txtFile = folder.newFile("some.txt");

		assertTrue(txtFile.exists());
		assertTrue(txtFile.canWrite());

		FileUtils.writeStringToFile(txtFile, "I'm writing to a temp file!");
		String contents = FileUtils.readFileToString(txtFile);

		assertEquals("I'm writing to a temp file!", contents);
	}

	@Test
	public void createTempFolder() throws IOException {

		tempFolder = folder.newFolder("tmp");
		File childFile = new File(tempFolder, "child.txt");
		childFile.createNewFile();

		@SuppressWarnings("unchecked")
		Collection<File> containedFiles = FileUtils.listFiles(
				tempFolder,
				new String[]{"txt"},
				false);

		assertThat(containedFiles, hasItem(childFile));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
