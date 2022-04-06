package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Meeting implements Comparable<Meeting>{
    int start, end;
    Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Meeting m){
        if(m.end==this.end){
            return this.start-m.start;
        }
        return this.end-m.end;
    }
}

public class MeetingRoom {
    static int solution(ArrayList<Meeting> meetings){
        Collections.sort(meetings);
        int cnt=0;
        int time = Integer.MIN_VALUE;

        for(Meeting m : meetings){
            if(time<=m.start){
                cnt++;
                time=m.end;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Meeting> meetings = new ArrayList<>();

        for(int i=0; i<n; i++){
            int s = in.nextInt();
            int e = in.nextInt();
            meetings.add(new Meeting(s, e));
        }

        System.out.println(solution(meetings));
    }
}
