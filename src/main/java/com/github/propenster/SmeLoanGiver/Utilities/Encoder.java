package com.github.propenster.SmeLoanGiver.Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class Encoder {


    public static String encodeFileToBase64(File file) {
        String encodedFile = "";
        try {
           byte[] fileContent = Files.readAllBytes(file.toPath());
            encodedFile = Base64.getEncoder().encodeToString(fileContent);
       } catch (IOException e) {
           throw new IllegalStateException("could not read file " + file, e);
       }
        return encodedFile;
    }

}

