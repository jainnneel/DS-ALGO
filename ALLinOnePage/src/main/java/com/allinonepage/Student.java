package com.allinonepage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student{
    private int id;
    private String name;
    private double cgpa;
    public Student(int id, String name, double cgpa) {
        super();
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public int getID() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getCGPA() {
        return cgpa;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        
        List<Student> studentList = new ArrayList<Student>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();
            
            Student st = new Student(id, fname, cgpa);
            studentList.add(st);
            
            testCases--;
        }
      
        Collections.sort(studentList,new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getCGPA()>o2.getCGPA()) {
                    return 1;
                }else if(o1.getCGPA()<o2.getCGPA()){
                    return -1;
                }else {
                    if (o1.getName().compareTo(o2.getName())>0) {
                        return 1;
                    }else if(o1.getName().compareTo(o2.getName())<0) {
                        return -1;
                    }else {
                        if (o1.getID()>o2.getID()) {
                            return 1;
                        }else {
                            return -1;
                        }
                    }
                }
            }
        } );
      
        for(Student st: studentList){
            System.out.println(st.getName());
        }
    }
}

//boolean isPrime(int n) {
//    if (n < 2) {
//        return false;
//    } else if (n == 2) {
//        return true;
//    } else if (n % 2 == 0) {
//        return false;
//    }
//    int sqrt = (int) Math.sqrt(n);
//    for (int i = 3; i <= sqrt; i += 2) {
//        if (n % i == 0) {
//            return false;
//        }
//    }
//    return true;
//} 
//public static PerformOperation isOdd(){
//    return (int a) -> a%2 != 0;
// }   
//   
//    public static PerformOperation isPrime(){
//         return (int a) -> java.math.BigInteger.valueOf(a).isProbablePrime(1);
//    }
//    
//    public static PerformOperation isPalindrome(){
//         return (int a) -> String.valueOf(a).equals(new StringBuilder(String.valueOf(a)).reverse().toString());
//     } 
class Priorities{
    List<Student> getStudents(List<String> events){
        
        List<Student> sList = new ArrayList<>();
        
        for (String evn : events) {
            String[] strings = evn.split(" ");
            if (strings[0].equals("ENTER")) {
                sList.add(new Student(Integer.parseInt(strings[3]),strings[1], Double.parseDouble(strings[2])));
                Collections.sort(sList,new Comparator<Student>() {

                            @Override
                            public int compare(Student o1, Student o2) {
                                if (o1.getCGPA()>o2.getCGPA()) {
                                    return -1;
                                }else if(o1.getCGPA()<o2.getCGPA()){
                                    return 1;
                                }else {
                                    if (o1.getName().compareTo(o2.getName())>0) {
                                        return 1;
                                    }else if(o1.getName().compareTo(o2.getName())<0) {
                                        return -1;
                                    }else {
                                        if (o1.getID()>o2.getID()) {
                                            return 1;
                                        }else {
                                            return -1;
                                        }
                                    }
                                }
                            }
                } );
            }else if (strings[0].equals("SERVED")){
                sList.remove(0);
            }
        }
        
        return sList;
    }
}
//PriorityQueue < Student > student_queue = new PriorityQueue(Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getName).thenComparing(Student::getToken));
