package org.coding.greedy.ActivitySelection;

// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;

class Driverclass1
{
  public static void main (String[] args) throws IOException
  {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //testcases
    int t = Integer.parseInt(br.readLine().trim());

    while(t-- > 0)
    {
      String inputLine[] = br.readLine().trim().split(" ");
      //size of array
      int n = Integer.parseInt(inputLine[0]);
      int start[] = new int[n];
      int end[] = new int[n];

      //adding elements to arrays start and end
      inputLine = br.readLine().trim().split(" ");
      for(int i = 0; i < n; i++)
        start[i] = Integer.parseInt(inputLine[i]);

      inputLine = br.readLine().trim().split(" ");
      for(int i= 0; i < n; i++)
        end[i] = Integer.parseInt(inputLine[i]);

      //function call
      System.out.println(new Activity().activitySelection(start, end, n));
    }
  }
}

// } Driver Code Ends
class MyActivity
    implements Comparable<MyActivity>
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

  MyActivity(int startTime,int endTime)
  {
    this.startTime = startTime;
    this.endTime = endTime;
  }

  @Override
  public int compareTo(MyActivity o) {
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

class Activity
{
  static int activitySelection(int start[], int end[], int n)
  {
    // add your code here
    int numberOfActivities =0;

    ArrayList<MyActivity> activityList = new ArrayList<>();

    for(int i =0;i< end.length; i++)
    {
      activityList.add(new MyActivity(start[i],end[i]));
    }

    Collections.sort(activityList);

    int lastMeetingEndTime =-1;

    for(int i =0; i< activityList.size(); i++)
    {
      if(lastMeetingEndTime ==-1)
      {
        numberOfActivities++;
        lastMeetingEndTime = activityList.get(i).endTime;
      }
      else
      {
        if(lastMeetingEndTime <= activityList.get(i).startTime)
        {
          numberOfActivities++;
          lastMeetingEndTime = activityList.get(i).endTime;
        }
      }
    }
    return numberOfActivities;
  }
}