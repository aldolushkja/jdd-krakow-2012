package airhacks.service;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class Configurator {

    @Produces
    public String configures(InjectionPoint ip, Environment e){
        Class<?> declaringClass = ip.getMember().getDeclaringClass();
        String name = ip.getMember().getName();
        return declaringClass.getName() + " *** " + name + e;
    }
}
