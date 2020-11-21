package pl.s13302.mas;

import pl.s13302.mas.extension.ObjectPlus;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TestHelper {

    public static final void setupEmptyExtension() throws NoSuchFieldException, IllegalAccessException {
        Map<Class, Collection<ObjectPlus>> extension = new HashMap<>();
        Field extensionField = ObjectPlus.class.getDeclaredField("extension");
        extensionField.setAccessible(true);
        extensionField.set(null, extension);
        extensionField.setAccessible(false);
    }

}
