import org.junit.Assert;
import org.junit.Test;
import org.lighthouse.common.annotation.Module;
import org.reflections.Reflections;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by christian on 09/11/16.
 */
public class TestReflections {

    String basePackage = "org.lighthouse.modules.*";

    @Test
    public void testReflections() {
        Set<Class<?>> modules = new Reflections(basePackage).getTypesAnnotatedWith(Module.class);
        Arrays.stream(modules.toArray(new Class<?>[modules.size()]))
                .forEach(c -> {
                    try {
                        System.out.println(c.newInstance());
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
        Assert.assertTrue(modules.size() > 0);
    }
}
