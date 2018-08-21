package service;

import java.io.File;
import java.util.ArrayList;

public interface FileService {
	String[] getAllFilesInfo();
	
	ArrayList<File> getSupportedFiles();
}
