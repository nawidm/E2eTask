package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import org.apache.commons.io.FilenameUtils;

public class FileServiceImpl implements FileService{

	public String[] getAllFilesInfo() {
		File files = new File("/Users/nawidmujadidi/Documents/test");
		String[] fileInfo = new String[(int) files.length()];
		int index = 0;
		for( File f : files.listFiles()) {
			try {
				fileInfo[index] = f.getName()+" "+Files.probeContentType(f.toPath())+" "+f.length()+" "+FilenameUtils.getExtension(f.getAbsolutePath());
			} catch (IOException e) {
				fileInfo[index] = f.getName()+" No Mime type "+f.length()+" "+FilenameUtils.getExtension(f.getAbsolutePath());
			}
		}
		return fileInfo;
	}

	public ArrayList<File> getSupportedFiles() {
		ArrayList<File> filesToReturn = new ArrayList<File>();
		File files = new File("/Users/nawidmujadidi/Documents/test");
		for( File f : files.listFiles()) {
			try {
				String mimeType = Files.probeContentType(f.toPath()).toString();
				if(mimeType.equals("application/vnd.ms-excel") || mimeType.equals("text/csv")) {
					filesToReturn.add(f);
				}
			} catch (Exception e) {
				
			}
		}
		return filesToReturn;
	}

}
