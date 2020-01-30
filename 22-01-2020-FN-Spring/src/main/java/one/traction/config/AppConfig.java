package one.traction.config;

import one.traction.models.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("file:src/main/resources/application.properties")
public class AppConfig {
    @Autowired
    private Environment env;

    @Bean(name="point")
    public Point display() {
        Point point = new Point(Integer.parseInt(env.getProperty("x")), Integer.parseInt(env.getProperty("x")));
        return point;
    }
}