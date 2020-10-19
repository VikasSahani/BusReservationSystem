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
public class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Bus> buslist = new ArrayList<>();
        HashMap<String,Bus> busmap = new HashMap<>();
        System.out.println("Add buses into the database first");
        System.out.println("Enter the number of buses in depot");
        int nobus = Integer.parseInt(br.readLine());
        for(int i=0;i<nobus;i++){
            System.out.println("Enter the company Name");
            String comp = br.readLine();
            System.out.println("Enter the bus Number");
            String id = br.readLine();
            System.out.println("Enter the Source");
            String source = br.readLine();
            System.out.println("Enter the destination");
            String destination = br.readLine();
            System.out.println("Enter the Start time");
            String start = br.readLine();
            System.out.println("Enter the End time");
            String end = br.readLine();
            System.out.println("Enter the frequency (days on which the bus is active )");
            String freq = br.readLine();
            StringTokenizer st = new StringTokenizer(freq);
            HashSet<String> days = new HashSet<>();
            while(st.hasMoreTokens()){
                days.add(st.nextToken());
            }
            System.out.println("Enter the capacity of the bus");
            int cap = Integer.parseInt(br.readLine());
            Bus b = new Bus(comp,id,source,destination,start,end,days,cap);
            buslist.add(b);
            busmap.put(id,b);
        }
        
        Reservation reserve = new Reservation(buslist,busmap);
        
        UserReservation users = new UserReservation();
        HashMap<Integer,User> mapuser = new HashMap<>();
        int iduser = 0;
        boolean check = true;
        while(check){
            System.out.println("Are you a new UserName(y/n)");
            if(br.readLine().equals("y")){

               
                System.out.println("Enter your name");
                String name = br.readLine();
                
                User use = new User(iduser,name);
                users.userlist.add(use);
                mapuser.put(iduser,use);
                
                System.out.println("your user id is - "+iduser+" please note it down for future purpose");
                iduser++;
                System.out.println("Search Bus by typing - \"source destination date(YYYY/MM/DD)\"");
                String str = br.readLine();
                String strs[] = str.split(" ");
                
                Date date = new Date(strs[2]);
                ArrayList<Bus>  buses = reserve.searchBus(strs[0], strs[1], date);
                for(Bus b: buses){
                    System.out.println(b.company+" "+b.number+" "+b.start+" "+b.end+" "+b.capacity);
                }
                System.out.println("To reserve the seats in particular bus enter - (number of seats     bus number");
                String tmpo = br.readLine();
                String tempo[] = tmpo.split(" ");
                int seat = Integer.parseInt(tempo[0]);
                String number = tempo[1];
                boolean result = reserve.reserveBus(seat, number);
                if(result){
                    use.record.put(number,use.record.getOrDefault(number,0)+seat);
                    
                }
                
            }
            else{
                System.out.println("Enter your id");
                int ids = Integer.parseInt(br.readLine());
                User use = mapuser.get(ids);
                System.out.println("Search Bus by typing - \"source destination date(YYYY/MM/DD)\"");
                String str = br.readLine();
                String strs[] = str.split(" ");
                
                Date date = new Date(strs[2]);
                ArrayList<Bus>  buses = reserve.searchBus(strs[0], strs[1], date);
                for(Bus b: buses){
                    System.out.println(b.company+" "+b.number+" "+b.start+" "+b.end+" "+b.capacity);
                }
                System.out.println("To reserve the seats in particular bus enter - (number of seats     bus number)");
                String tmpo = br.readLine();
                String tempo[] = tmpo.split(" ");
                int seat = Integer.parseInt(tempo[0]);
                String number = tempo[1];
                boolean result = reserve.reserveBus(seat, number);
                if(result){
                    use.record.put(number,use.record.getOrDefault(number,0)+seat);
                    
                }
                
            }
            System.out.println("Do you want to check User Reservation list(y/n)");
            while(br.readLine().equals("y")){
                System.out.println("Enter the userid");
                int idd = Integer.parseInt(br.readLine());
                User user = mapuser.get(idd);
                for(Map.Entry<String,Integer> e : user.record.entrySet()){
                    System.out.println(e.getKey()+" "+e.getValue());
                }
            }
            System.out.println("Do you want to book more tickets(y/n)");
            if(br.readLine().equals("y")){
                check = true;
            }
            else{
                check = false;
            }
            
        }
        
    }
}
