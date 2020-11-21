package pl.s13302.mas.extension;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ObjectPlus implements Serializable {

    private static final String FILE_NAME = "extension.dat";

    private static List<ObjectPlus> extension = new ArrayList<>();

    protected ObjectPlus() {
        addToExtension(this);
    }

    public static List<ObjectPlus> getExtension() {
        return extension;
    }

    public static void loadExtension() {
        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                extension = (List<ObjectPlus>) ois.readObject();
                ois.close();
                fis.close();
            }
        } catch (ClassNotFoundException cnf) {
            handleException(cnf);
        } catch (IOException io) {
            handleException(io);
        }
    }

    public static void saveExtension() {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(extension);
                oos.close();
                fos.close();
            }
        } catch (IOException io) {
            handleException(io);
        }
    }

    private static void addToExtension(ObjectPlus element) {
        if (!extension.contains(element)) {
            extension.add(element);
        }
    }

    private static void handleException(Exception e) {
        e.printStackTrace();
    }

}
