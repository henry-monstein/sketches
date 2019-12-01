package framework.db;

import app.model.iml.SqlColumnName;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class SqlMapper {
    public static <T> Object mapping(String query, Class T) throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        ClassLoader classL = T.getClassLoader();
        Class<?> aClass = classL.loadClass(T.getCanonicalName());
        Constructor<?> constr = aClass.getConstructor();
        Object obj = constr.newInstance();
        System.out.println("o = " + obj);
        for (Field field : T.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(SqlColumnName.class)) {
                field.set(obj, field.getAnnotation(SqlColumnName.class).name());
            }
        }
        return obj;
    }
}
