package me.sunand.assignment5.core;

import me.sunand.assignment5.core.FileFormat;
import me.sunand.assignment5.core.IncompleteInfo;

import java.io.File;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.time.LocalDate;


public class GitLogParser {
    public static List<LocalDate> getDatesBetween(
            LocalDate startDate, LocalDate endDate) {

        return startDate.datesUntil(endDate)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws Exception {
        try {
            File f = new File("C:\\Users\\HP\\IdeaProjects\\java-assignments\\JavaAssignment-05\\src\\main\\java\\me\\sunand\\assignment5\\core\\git_log");
            if (f.length() == 0)
                throw new Exception1();
            if (!(new FileFormat().fileformat(f)))
                throw new Exception2();
            if (new IncompleteInfo().incompleteinfo(f))
                throw new Exception3();

            Scanner sc = new Scanner(f);

            //key:username  value:list of dates of commits
            Map<String, List<Date>> m = new HashMap<String, List<Date>>();
            String name=null;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if(line.contains("Author")){
                    String[] arr = line.split(" ");
                    name=arr[1];
                }
                if(line.contains("Date")) {
                    String[] arr = line.split(" ");
                    Date commitDate = new Date(Integer.parseInt(arr[7]), Integer.parseInt(arr[4]), Integer.parseInt(arr[5]));
                    if(m.containsKey(name)){
                        List<Date> old_list=m.get(name);
                        List<Date> new_list=m.get(name);
                        new_list.add(commitDate);
                        m.replace(name,old_list,new_list);
                    }
                    else
                        m.put(name,(List<Date>) commitDate);
                }
            }

            //Question a
            Date d=new Date(2021,6,10);
            System.out.println("Number of commits by each user after date" +d);
            for(Map.Entry<String,List<Date>> me : m.entrySet()){
                System.out.print(me.getKey() + ":");
                List<Date> l=me.getValue();
                int count=0;
                for(Date commitDate:l){
                    if(commitDate.after(d)){
                        count++;
                    }
                }
                System.out.println(count);
            }

            //Question b
            System.out.println("Number of commits by each user for particular date");
            LocalDate startDate = LocalDate.of(2021,6,10);
            LocalDate endDate = LocalDate.of(2021,6,25);

            List<LocalDate> listOfDates = startDate.datesUntil(endDate)
                    .collect(Collectors.toList());
            for(LocalDate date1 :listOfDates){
                Date date2 = java.sql.Date.valueOf(date1);
                System.out.println(date1);
                for(Map.Entry<String,List<Date>> me : m.entrySet()){
                    System.out.print(me.getKey() + ":");
                    int count=0;
                    List<Date> l=me.getValue();
                    for(Date date3 : l){
                        if((date2.compareTo(date3))==0)
                            count++;
                    }
                    System.out.println(count);
                }
            }

            //Question c
            for(Map.Entry<String,List<Date>> me:m.entrySet()){
                int successiveCount=0;
                for(LocalDate date1:listOfDates){
                    Date date2=java.sql.Date.valueOf(date1);
                    List<Date> l=me.getValue();
                    boolean flag=false;
                    for(Date date3:l){
                        if((date2.compareTo(date3))==0)
                            flag=true;
                    }
                    if(!flag)
                        successiveCount++;
                    if(successiveCount==2){
                        System.out.println(me.getKey());
                        break;
                    }
                }
            }

        } catch (Exception1 e) {
            System.out.println(e);
        } catch (Exception2 e) {
            System.out.println(e);
        } catch (Exception3 e) {
            System.out.println(e);
        }
    }
}
class Exception1 extends Exception {
    @Override
    public String toString() {
        return "File is null";
    }
}

class Exception2 extends Exception {
    @Override
    public String toString() {
        return "File format is not correct as per the git log format";
    }
}

class Exception3 extends Exception {
    @Override
    public String toString() {
        return "Incomplete information of the git log";
    }
}

