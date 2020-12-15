package fi.lahti.unit_7.homework;

import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;





public class Main {
    public static void main(String[] args) throws Exception {
        start(TestManager.class);
    }

    public static <T> void start(Class<T> className) throws Exception {
        final int TOP_PRIORITY = 0;
        final int LOWEST_PRIORITY = 11;
        boolean isBeforeSuiteExists = false;
        boolean isAfterSuiteExists = false;

        TestManager testManager = new TestManager();
        Map<Integer, Set<Method>> applicationOrder = new TreeMap<>();

        for (Method method : className.getDeclaredMethods()) {
            method.setAccessible(true);
            if (method.getAnnotation(BeforeSuite.class) != null) {
                if (!isBeforeSuiteExists) {
                    applicationOrder.putIfAbsent(TOP_PRIORITY, new HashSet<>());
                    applicationOrder.get(TOP_PRIORITY).add(method);
                    isBeforeSuiteExists = true;
                } else throw new RuntimeException("SWW");
            } else if (method.getAnnotation(AfterSuite.class) != null) {
                if (!isAfterSuiteExists) {
                    applicationOrder.putIfAbsent(LOWEST_PRIORITY, new HashSet<>());
                    applicationOrder.get(LOWEST_PRIORITY).add(method);
                    isAfterSuiteExists = true;
                } else throw new RuntimeException("SWW");
            } else if (method.getAnnotation(Test.class) != null) {
                Test test = method.getAnnotation(Test.class);
                applicationOrder.putIfAbsent(test.priority(), new HashSet<>());
                applicationOrder.get(test.priority()).add(method);
            }
        }

        System.out.println(applicationOrder);

        for (Integer key : applicationOrder.keySet()) {
            Set<? extends Method> methodsSet = applicationOrder.get(key);
            for (Method method : methodsSet) {
                method.invoke(testManager);
            }
        }
        applicationOrder.clear();

        for (Method method : className.getDeclaredMethods()) {
            method.setAccessible(false);
        }

        System.out.println(applicationOrder);

    }
}
