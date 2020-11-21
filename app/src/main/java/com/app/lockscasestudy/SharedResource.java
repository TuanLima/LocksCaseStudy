package com.app.lockscasestudy;

public class SharedResource {
    private Worker owner;

    public SharedResource(Worker owner){
        this.owner = owner;
    }
    public synchronized void setOwner(Worker owner) {
        this.owner = owner;
    }
    public Worker getOwner() {
        return owner;
    }
}
