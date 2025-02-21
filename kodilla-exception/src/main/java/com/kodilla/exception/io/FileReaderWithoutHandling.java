package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReaderWithoutHandling {

    public void readFile(String fileName) throws FileReaderException {
        ClassLoader classLoader = getClass().getClassLoader();

        try {
            // Get the file using the provided file name
            File file = new File(classLoader.getResource(fileName).getFile());
            Stream<String> fileLines = Files.lines(Paths.get(file.getPath()));
            fileLines.forEach(System.out::println);  // Print each line of the file
        } catch (IOException e) {
            throw new FileReaderException("An error occurred while reading the file: " + fileName, e);
        } finally {
            System.out.println("This block always runs, regardless of errors!");
        }
    }

    public static void main(String[] args) {
        FileReaderWithoutHandling fileReader = new FileReaderWithoutHandling();

        try {
            // Provide the file name to read
            fileReader.readFile("names.txt");
        } catch (FileReaderException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();  // Prints the stack trace for debugging
        }
    }
}
