package org.lighthouse;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import org.lighthouse.common.annotation.Module;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Pattern;

@SpringBootApplication
public class BridgeApplication {

	public static void main(String[] args) {

        String basePackage = "org.lighthouse.modules.*";



        /*Set<Class<?>> modules = new Reflections(basePackage).getTypesAnnotatedWith(Module.class);

        Arrays.stream(modules.toArray(new Class<?>[modules.size()]))
                .forEach(c ->  vertx.deployVerticle(c.getName()));*/

		SpringApplication.run(BridgeApplication.class, args);
	}
}
