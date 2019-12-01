package tests;

import app.model.TestMinTimeWorking;
import app.model.iml.SqlColumnName;
import framework.db.SqlMapper;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class DatabaseTest {

    @Test
    public void testBaseAuth() throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        TestMinTimeWorking testMinTimeWorking = new TestMinTimeWorking();
        for (Field field : TestMinTimeWorking.class.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(SqlColumnName.class)) {
                field.set(testMinTimeWorking,field.getAnnotation(SqlColumnName.class).name());
            }
        }
        System.out.println(testMinTimeWorking.toString());
        System.out.println(SqlMapper.mapping("ds",TestMinTimeWorking.class));
    }
}

