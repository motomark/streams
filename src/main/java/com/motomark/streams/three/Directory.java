package com.motomark.streams.three;

import static java.util.stream.Collectors.toList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Directory {

    public List<Path> listDirs(String path) throws IOException {
        return Files.list(Paths.get(path)).filter(Files::isDirectory).collect(toList());
    }

    // p.58 Listing files.
    public List<String> listJavaFilesDirStream(String filePath) throws IOException {
        List<String> list = new ArrayList<String>();
        Files.newDirectoryStream(Paths.get(filePath), path -> path.toString().endsWith(".java"))
                .forEach(path -> list.add(path.toString()));
        return list;
    }

    // Prefer this approach where we filter down and map from Path to String and
    // then collect a list.
    public List<String> listJavaFilesStream(String filePath) throws IOException {
        return Files.list(Paths.get(filePath)).filter(path -> path.toString().endsWith(".java")).map(Path::toString)
                .collect(toList());
    }

    // Or this approach?
    public List<String> listJavaFilesStreamStrings(String filePath) throws IOException {
        // listFiles accepts the filter lambda, rather than use filter() with the
        // lambda.
        File[] files = new File(filePath).listFiles(file -> file.getName().endsWith(".java"));
        return Stream.of(files).map(File::getPath).collect(toList());
    }

    //  p.60 using flatMap.
    public List<String> listDirsUsingFlattenMap(String filePath) {
        // Streams over the parent, and for each file it lists the files in any subDir
        // and provides a Strream for those. The flattenMap combines the two streams
        // (parent dir and subdir) and flattens them into a combined list.
        List<File> files = Stream.of(new File((filePath)).listFiles())
                .flatMap(file -> file.listFiles() == null ? Stream.of(file) : Stream.of(file.listFiles()))
                .collect(toList());
        return files.stream().map(file -> file.getName()).toList();
    }

}
