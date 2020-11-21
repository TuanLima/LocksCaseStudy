package com.app.lockscasestudy;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class Worker {
    private String name;
    private boolean active;
    private String color;

    public Worker(String name, boolean active, String color ) {
        this.name = name;
        this.active = active;
        this.color = color;
    }

    public String getName(){
        return name;
    }
    public boolean isActive(){
        return active;
    }
    public synchronized void work(SharedResource sharedResource, Worker coworker, Context context){
        while(active){
            if(sharedResource.getOwner() != this){
                try {
                    wait(10);
                } catch (InterruptedException e){

                }
                continue;
            }
            if (coworker.isActive()){
                System.out.println(color + getName() + ": give resource to the other worker, " + coworker.getName());
                sharedResource.setOwner(coworker);
                continue;
            }
            System.out.println(color + getName()+": working on the common resource");
            active = false;
            sharedResource.setOwner(coworker);
        }
    }

}
