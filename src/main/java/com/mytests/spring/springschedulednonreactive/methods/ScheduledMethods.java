package com.mytests.spring.springschedulednonreactive.methods;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ScheduledMethods {

    String foo = "";
    String rez = "invoked at : \n";

    @Scheduled(cron = "0 */1 * * May *")
    public String returns_string() {
        System.out.println("++++++++++++++ returns_string method scheduled! +++++++++++++");
        rez = rez + new Date().getTime()+"\n";
        return rez;
    }

    @Scheduled(cron = "0 */2 * * May Wed ")
    public void display() {

        System.out.println(this.returns_string());

    }

    @Scheduled(cron = "${cron.props.first}")
    void scheduledOne(){

        System.out.println("***!!! one !!! ***");
        this.foo = this.foo + " one: " +new Date().getTime() + "; ";
    }
    @Scheduled(cron = "${cron.props.second}")
    public void scheduledTwo(){
        this.foo = this.foo + " two: " +new Date().getTime() + "; ";
        System.out.println("***!!! two !!!***");
    }

    @Scheduled(cron = "0 */1 * * * *")
    public void scheduledVoid(){
        // some comment
        String message =  " triggered: " +new Date().getTime() + "; ";
        System.out.println("***!!! " + message + " !!!***");

    }

    @Scheduled(cron = "0 */1 * * * *")
    public boolean scheduledNotVoid(){
        this.foo = this.foo + " three: " +new Date().getTime() + "; ";
        System.out.println("***!!! three !!!***");
        return false;
    }
    @Scheduled(cron = "0 */1 * * * *")
    public List<String> scheduledGeneric(){
        this.foo = this.foo + " four: " +new Date().getTime() + "; ";
        System.out.println("***!!! four !!!***");
        return new ArrayList<>();
    }

    @Scheduled(cron = "0 * * * * *")
    private void scheduledPrivate() {
        System.out.println("++++!!!!private!!!!+++++");
    }

// Only no-arg methods may be annotated with @Scheduled  - show error
   // @Scheduled(cron = "* * * * * *")
     void scheduledWithArgs(String arg) {


        System.out.println("++++!!!!" + arg + "!!!!+++++");
    }

    // scheduled debugger doesn't work here - fixed
    @Scheduled(cron = "0 1 * * * *")
    public static void scheduledStatic() {
        System.out.println("++++!!!! static !!!!+++++");
    }
    public String getFoo() {
        return foo;
    }

    @Schedules({
            @Scheduled(fixedRate = 10000000),
            @Scheduled(cron = "0 * * * * THU-FRI")
    })
    void shedulesTest() {

        System.out.println("++++!!! shedules !!! ++++");
    }

}
