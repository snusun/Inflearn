package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Person implements Comparable<Person> {
    int time;
    char state;
    Person(int time, char state){
        this.time = time;
        this.state = state;
    }
    @Override
    public int compareTo(Person p){
        if(this.time==p.time) {
            return this.state-p.state;
        }
        return this.time-p.time;
    }
}

public class Wedding {
    static int solution(ArrayList<Person> people){
        Collections.sort(people);
        int cnt=0;
        int max=-1;

        for(Person p : people){
            if(p.state=='s'){
                cnt++;
            } else{
                cnt--;
            }
            if(max<cnt) max=cnt;
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Person> people = new ArrayList<>();

        for(int i=0; i<n; i++){
            int s = in.nextInt();
            int e = in.nextInt();
            people.add(new Person(s, 's'));
            people.add(new Person(e, 'e'));
        }

        System.out.println(solution(people));
    }
}
