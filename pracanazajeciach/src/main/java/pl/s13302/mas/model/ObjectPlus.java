package pl.s13302.mas.model;

import java.io.*;
import java.util.Vector;

public abstract class ObjectPlus implements Serializable {

    private static final String FILE_NAME = "extension.dat";

    private static Vector<ObjectPlus> extension = new Vector<>();

    protected ObjectPlus() {
        addToExtension(this);
    }

    public static Vector<ObjectPlus> getExtension() {
        return extension;
    }

    public static void saveExtension() {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(extension);
                oos.close();
                fos.close();
            }
        } catch (IOException e) {
            handleException(e);
        }
    }

    public static void loadExtension() {
        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                extension = (Vector<ObjectPlus>) ois.readObject();
                ois.close();
                fis.close();
            }
        } catch (ClassNotFoundException cnf) {
            handleException(cnf);
        } catch (IOException e) {
            handleException(e);
        }
    }

    private static void addToExtension(ObjectPlus element) {
        if (! getExtension().contains(element)) {
            getExtension().add(element);
        }
    }

    private static void handleException(Exception e) {
        e.printStackTrace();
    }

}
