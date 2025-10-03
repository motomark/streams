package com.motomark.streams;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;

public class Reduce {

    public static void main(String[] args) {

        try {

            File inFile = new File(Reduce.class.getClassLoader().getResource("test.txt").getFile());
            File outFile = new File("/home/ec2-user/git/streams/test2.txt");
            outFile.createNewFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outFile, StandardCharsets.UTF_8)); 
                 BufferedReader reader = new BufferedReader(new FileReader(inFile, StandardCharsets.UTF_8))) {
                 writer.write(reader.lines().reduce("",(a,b) -> a+b).replaceAll("dog", "cat"));
            }

        }
        catch (Exception e) {
            e.printStackTrace();

        }
    }

}
