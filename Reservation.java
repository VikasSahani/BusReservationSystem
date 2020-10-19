/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay Gupta
 */

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.Date;
import java.util.Calendar;

class Reservation {
    ArrayList<Bus> busList;
    HashMap<String,Bus> busmap;
    
    Reservation(ArrayList<Bus> buslist,HashMap<String,Bus> map){
        this.busList = buslist;
        this.busmap = map;
    }
    
    public ArrayList<Bus> searchBus(String source,String destination,Date date){
        ArrayList<Bus> alist = new ArrayList<>();
        int day = date.getDay();
        String days[] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        for(Bus b : busList){
            if(b.source.equals(source)&&b.destination.equals(destination)&&b.freq.contains(days[day])){
                alist.add(b);
            }
        }
        return alist;
    }
    
    public boolean reserveBus(int n,String id){
        if(!busmap.containsKey(id)){
            return false;
        }
        Bus b = busmap.get(id);
        if(b.capacity >= n && b.capacity > 0){
            b.capacity = b.capacity - n;
            return true;
        }
        return false;
    }
    
}

