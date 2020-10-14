package airhacks.service;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class Index {

    @Inject
    GoodMorningKrakow goodMorningKrakow;

    @PostConstruct
    public void init(){
        System.out.println("Model");
    }

    public String message(){
        return "Hello from universe!" + " and " + goodMorningKrakow.sayHello();
    }

}
