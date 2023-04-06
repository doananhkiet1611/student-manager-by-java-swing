/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.store;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author doananhkiet
 */
public class FileGenegator {
    public static File creatNewFile(String fileName) throws IOException {
        File file = new File(fileName);
        
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        file.createNewFile();
    
        return file;
    }
}
