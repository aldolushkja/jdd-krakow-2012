package airhacks.service;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;

@Stateless
public class GoodMorningKrakow {

    @Inject
    String complexConfiguration;

    @Inject
    ThreadStarter threadStarter;

    @PostConstruct
    public void init(){
        System.out.println("EJB");
    }

    public String sayHello(){
        threadStarter.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Done!!" + new Date());
        });
        return "Hello from EJB" + this.complexConfiguration;
    }
}
