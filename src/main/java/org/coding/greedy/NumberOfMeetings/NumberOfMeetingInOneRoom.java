package org.coding.greedy.NumberOfMeetings;

// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class Driverclass {
  public static void main(String args[]) throws IOException {
    BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());

    while (t-- > 0) {
      String inputLine[] = br.readLine().trim().split(" ");
      int n = Integer.parseInt(inputLine[0]);

      int start[] = new int[n];
      int end[] = new int[n];

      inputLine = br.readLine().trim().split(" ");
      for (int i = 0; i < n; i++)
        start[i] = Integer.parseInt(inputLine[i]);

      inputLine = br.readLine().trim().split(" ");
      for (int i = 0; i < n; i++)
        end[i] = Integer.parseInt(inputLine[i]);

      int ans = new Result().maxMeetings(start, end, n);
      System.out.println(ans);
    }
  }
}
// } Driver Code Ends
 class MyMeeting implements Comparable<MyMeeting>
{

  public int getStartTime() {
    return startTime;
  }

  public void setStartTime(int startTime) {
    this.startTime = startTime;
  }

  public int getEndTime() {
    return endTime;
  }

  public void setEndTime(int endTime) {
    this.endTime = endTime;
  }

  int startTime;
  int endTime;

  MyMeeting(int startTime,int endTime)
  {
    this.startTime = startTime;
    this.endTime = endTime;
  }

  @Override
  public int compareTo(MyMeeting o) {
      if(this.endTime > o.endTime)
      {
        return 1;
      }
      else if(this.endTime < o.endTime)
      {
        return -1;
      }
      else
      {
        return 0;
      }
  }
}

class Result {
  public static int maxMeetings(int start[], int end[], int n) {

    int numberOfMeetings =0;

    ArrayList<MyMeeting> meetingsList = new ArrayList<>();

    for(int i =0;i< end.length; i++)
    {
      meetingsList.add(new MyMeeting(start[i],end[i]));
    }

    Collections.sort(meetingsList);

    int lastMeetingEndTime =-1;

    for(int i =0; i< meetingsList.size(); i++)
    {
       if(lastMeetingEndTime ==-1)
       {
         numberOfMeetings++;
         lastMeetingEndTime = meetingsList.get(i).endTime;
       }
       else
       {
         if(lastMeetingEndTime < meetingsList.get(i).startTime)
         {
           numberOfMeetings++;
           lastMeetingEndTime = meetingsList.get(i).endTime;
         }
       }
    }
    return numberOfMeetings;
  }
}