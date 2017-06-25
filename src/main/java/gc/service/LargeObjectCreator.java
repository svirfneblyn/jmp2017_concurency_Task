package gc.service;

import gc.entity.LargeObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
public class LargeObjectCreator {

    public LargeObject getLargeObject(LargeObject largeObject) {
        Path path = Paths.get("d:/00113.MTS");
        byte[] data = new byte[1];
        try {
            data = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new LargeObject().setLargeObgect(data).setPerviousObj(largeObject);
    }
}
