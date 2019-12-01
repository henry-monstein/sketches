package app.model;

import app.model.iml.SqlColumnName;
import app.model.iml.SqlSerializable;
import lombok.Data;

import java.lang.reflect.Field;

@Data
@SqlSerializable
public class TestMinTimeWorking {
    @SqlColumnName(name = "PROJECT")
    String project;
    @SqlColumnName(name = "TEST")
    String test;
    @SqlColumnName(name = "MIN_TIME_WORKING")
    String minTimeWorking;

    public TestMinTimeWorking() {
    }
}
