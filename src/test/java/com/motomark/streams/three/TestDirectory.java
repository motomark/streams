package com.motomark.streams.three;

import java.io.IOException;

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


}
