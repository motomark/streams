package com.motomark.streams.three;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

public class TestDirectory {

    Directory dir;

    @Before
    public void init() {
        dir = new Directory();
    }

    @Test
    public void testListDirs() throws IOException {
        System.out.println(dir.listDirs("."));
    }

    @Test
    public void testListJavaDirStream() throws IOException {
        dir.listJavaFilesDirStream("./src/main/java/com/motomark/streams/onetwo").forEach(System.out::println);
    }

    @Test
    public void testListJava() throws IOException {
        dir.listJavaFilesStream("./src/main/java/com/motomark/streams/onetwo").forEach(System.out::println);
    }

    @Test
    public void testListFileJava() throws IOException {
        dir.listJavaFilesStreamStrings("./src/main/java/com/motomark/streams/onetwo").forEach(System.out::println);
    }

    @Test
    public void testListDirsUsingFlattenMap() throws IOException {
        dir.listDirsUsingFlattenMap("./src/main/java/com/motomark/streams").forEach(System.out::println);
    }

    @Test
    public void testWatchForDeleteChange() throws IOException, InterruptedException {
        final String fileName = "./src/main/java/com/motomark/streams/three";
        final Path path = Paths.get(fileName + "/temp.txt");
        // Create a temp filer to test with.
        Files.createFile(path, new FileAttribute[0]);

        // Set a timer running to delete the file in 5 seconds.
        TimerTask task = new TimerTask() {
            public void run() {
                try {
                    Files.deleteIfExists(path);
                } catch (IOException e) {
                }
            }
        };
        Timer timer = new Timer("Timer");
        long delay = 5000L;
        timer.schedule(task, delay);

        // This will poll every 1 minute and see the delete.
        WatchFileChange watch = new WatchFileChange();
        watch.watchForDeleteChange(fileName);
        timer.cancel();
    }

}
