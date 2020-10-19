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

class User {
    int id;
    String name;
    HashMap<String,Integer> record;
    User(int id,String name){
        this.id = id;
        this.name = name;
    }
}
