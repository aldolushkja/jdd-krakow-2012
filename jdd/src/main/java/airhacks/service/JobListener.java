package airhacks.service;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;
import java.io.IOException;
import java.util.Date;

@Stateless
public class JobListener {

    @PostConstruct
    public void init(){
        System.out.println("JOB_LISTENER");
    }

    public void successful(@Observes(during = TransactionPhase.AFTER_SUCCESS) String message){
        System.out.println("######## Receveid: " + message);
    }

    public void failed(@Observes(during = TransactionPhase.AFTER_FAILURE) String message){
        System.out.println("--------- Receveid: " + message);
    }

    public void onWindowsRequest(@Observes AsyncContext asyncContext){
        try {
            ServletRequest request = asyncContext.getRequest();
            String string = request.toString();
            System.out.println("request: " + string);
            asyncContext.getResponse().getWriter().println("From EJB : " + new Date());
        } catch (IOException e) {
            e.printStackTrace();
        }
        asyncContext.complete();
    }
}
