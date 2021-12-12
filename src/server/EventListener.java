package server;

import mvc.controller.Controller;

public class EventListener {
    public void received(Object p) {
        if(p instanceof Controller) {
            Controller c = (Controller) p;
        }
    }
}
