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
class Bus {
    String company;
    String number;
    String source;
    String destination;
    String start;
    String end;
    HashSet<String> freq;
    int capacity;
    //boolean cap[];
    //int rem;
    Bus(String c,String n,String s,String d,String st,String ed,HashSet<String> set,int cp){
        company = c;
        number = n;
        source = s;
        destination = d;
        start = st;
        end = ed;
        freq = set;
        capacity = cp;
        //cap = new boolean[cp+1];
        //rem = cp;
    }
    
}
