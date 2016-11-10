package org.lighthouse.conf;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import org.lighthouse.modules.simple.MyFirstVerticle;
import org.slf4j.LoggerFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;

/**
 * Created by christian on 10/11/16.
 */
@Configuration
public class VerticleConf implements EnvironmentAware {

    private  Class[] verticles = new Class[]{MyFirstVerticle.class};

    private Environment environment;
    private Vertx vertx;



    private <T extends AbstractVerticle> void deployVerticle(Class<T> verticle) {
        vertx.deployVerticle(verticle.getName());
    }

    private <T extends AbstractVerticle> void unDeployVerticle(Class<T> verticle) {
        vertx.undeploy(verticle.getName());
    }

    @PostConstruct
    public void init() {
        vertx = Vertx.vertx();
        Arrays.stream(verticles)
                .forEach(v -> {
                    deployVerticle(v);
                    LoggerFactory.getLogger(this.getClass()).info(String.format("%s verticle deployed",v.getName()));
                });

    }

    @PreDestroy
    public void clean () {
        Arrays.stream(verticles)
                .forEach(v ->{
                    unDeployVerticle(v);
                    LoggerFactory.getLogger(this.getClass()).info(String.format("%s verticle undeployed",v.getName()));
                });
        vertx.close();
    }




    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
