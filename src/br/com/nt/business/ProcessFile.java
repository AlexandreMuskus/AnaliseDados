package br.com.nt.business;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Optional;

public class ProcessFile {
	static String path = System.getProperty("user.home") + File.separator + "data"  + File.separator ;
	static WatchService watcher;
	ProcessData processData;

	public void start(){
		if(checkDiretories()) {
			try {
				watcher = FileSystems.getDefault().newWatchService();
				Path diretorio = Paths.get(path+"in");
				diretorio.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
				readFiles();
				watcher.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	private void readFiles(){
		try {
			WatchKey key = watcher.take();
			Optional<WatchEvent<?>> watchEvent = key.pollEvents().stream().findFirst();
			Path path = (Path) watchEvent.get().context();
			System.out.println ("Processing: "+path.toString());
			processData = new ProcessData();
			processData.LoadFile(path.toString());
			processData.GenerateReport();
			boolean valid = key.reset();
			if (valid) {
				readFiles();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private boolean checkDiretories() {
		if (!checkDiretory("in") || !checkDiretory("out")) {
		    return false;
		}
		
		return true;
	}
	
	private boolean checkDiretory(String folder) {
		File customDir = new File(path+folder);
		if (customDir.exists()) {
		    System.out.println(customDir + " already exists");
		} else if (customDir.mkdirs()) {
		    System.out.println(customDir + " was created");
		} else {
		    System.out.println(customDir + " was not created");
		    return false;
		}
		
		return true;
	}
	
}
