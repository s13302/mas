package pl.s13302.mas.extension;

import java.io.*;
import java.util.*;

public abstract class ObjectPlus implements Serializable {

    private static final String FILE_NAME = "extension.dat";

    private static Map<Class, Collection<ObjectPlus>> extension = new HashMap<>();

    protected ObjectPlus() {
        addToExtension(this);
    }

    public static Collection<ObjectPlus> getExtension(Class clazz) {
        Collection<ObjectPlus> classExtension = extension.get(clazz);
        if (classExtension == null) {
            classExtension = Collections.emptyList();
        }
        return Collections.unmodifiableCollection(classExtension);
    }

    public static boolean loadExtension() {
        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                extension = (Map<Class, Collection<ObjectPlus>>) ois.readObject();
                if (extension == null) {
                    extension = new HashMap<>();
                }
                ois.close();
                fis.close();
            }
        } catch (ClassNotFoundException cnf) {
            handleException(cnf);
        } catch (IOException io) {
            handleException(io);
        }
        return (! extension.isEmpty());
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
        if (element != null && !extension.containsValue(element)) {
            Collection<ObjectPlus> objects = extension.get(element.getClass());
            if (objects == null) {
                objects = new ArrayList<>();
            }
            objects.add(element);
            extension.put(element.getClass(), objects);
        }
    }

    private static void handleException(Exception e) {
        e.printStackTrace();
    }

}
