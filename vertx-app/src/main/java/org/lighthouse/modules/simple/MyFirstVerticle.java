package org.lighthouse.modules.simple;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import org.lighthouse.common.annotation.Module;

/**
 * Created by christian on 09/11/16.
 */
@Module
public class MyFirstVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> fut) {
        vertx
                .createHttpServer()
                .requestHandler(r -> {
                    r.response().end("<h1>Hello from my first " +
                            "Vert.x 3 application</h1>");
                })
                .listen(3000, result -> {
                    if (result.succeeded()) {
                        fut.complete();
                    } else {
                        fut.fail(result.cause());
                    }
                });
    }
}
