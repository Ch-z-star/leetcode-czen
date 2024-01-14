package exercise;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Exercises {
    public static void main(String[] args) {
        // 测试练习一，反射调用特定方法
        Exercises ex = new Exercises();
        try {
            ex.exerciseReflect();
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public void exerciseReflect() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> clazz = Exercises.class;
        Method m1 = clazz.getMethod("testReflect", Integer.class);
        Exercises exercises = (Exercises) clazz.newInstance();
        m1.invoke(exercises, 33);
    }

    public void testReflect(Integer x) {
        System.out.println("reflect func has been used...");
        System.out.println("the arg is " + x);
    }
}
