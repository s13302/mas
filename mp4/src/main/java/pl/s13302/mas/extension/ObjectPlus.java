package pl.s13302.mas.extension;

import java.util.*;

public abstract class ObjectPlus {

    private static Map<Class, Collection<ObjectPlus>> extension = new HashMap<>();

    protected ObjectPlus() {
        addToExtension(this);
    }

    public static Collection<ObjectPlus> getExtension(Class clazz) {
        Collection<ObjectPlus> result = extension.get(clazz);
        if (result == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableCollection(result);
    }

    private static void addToExtension(ObjectPlus element) {
        if (element != null) {
            Class elementClass = element.getClass();
            if (extension.get(elementClass) == null) {
                extension.put(elementClass, new ArrayList<>());
            }
            Collection<ObjectPlus> objectExtension = extension.get(elementClass);
            if (! objectExtension.contains(element)) {
                objectExtension.add(element);
            }
        }
    }

}
