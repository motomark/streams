package com.motomark.streams.three;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

public class WatchFileChange {

    // p. 60 / 61. 
    public void watchForDeleteChange(String dirName) throws IOException, InterruptedException {

        final Path path = Paths.get(dirName);
        final WatchService watchService = path.getFileSystem().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_DELETE);
        System.out.println("Report any file delete in 1 minute...");
        final WatchKey watchKey = watchService.poll(1, TimeUnit.MINUTES);

        if(watchKey != null) {
            watchKey.pollEvents().stream()
                .forEach(event -> {
                    System.out.println("Seen deletion of file: "+event.context());
                    try {
                        watchService.close();
                    } catch (IOException e) {
                    }
                }
            );
        }
        watchService.close();
    }

}
