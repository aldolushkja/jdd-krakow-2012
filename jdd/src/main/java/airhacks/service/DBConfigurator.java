package airhacks.service;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.Specializes;
import javax.enterprise.inject.spi.InjectionPoint;

public class DBConfigurator extends Configurator {

    @Override @Produces @Specializes
    public String configures(InjectionPoint ip, Environment e) {
        return "from database";
    }
}
