package airhacks.service;

import javax.enterprise.inject.Produces;

public class EnvironmentProvider {

    @Produces
    public Environment stage(){
        return Environment.TEST;
    }
}
