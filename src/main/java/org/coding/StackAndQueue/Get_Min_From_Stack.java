package org.coding.StackAndQueue;// { Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int q = sc.nextInt();
            GfG g = new GfG();
            while(q>0)
            {
                int qt = sc.nextInt();

                if(qt == 1)
                {
                    int att = sc.nextInt();
                    g.push(att);
                    //System.out.println(att);
                }
                else if(qt == 2)
                {
                    System.out.print(g.pop()+" ");
                }
                else if(qt == 3)
                {
                    System.out.print(g.getMin()+" ");
                }

                q--;
            }
            System.out.println();
            T--;
        }

    }
}


// } Driver Code Ends


class GfG
{
    int minEle;
    Stack<Integer> s = new Stack<>();

    /*returns min element from stack*/
    int getMin()
    {
        if(!s.isEmpty()) {
            return minEle;
        }

        else
        {
            return -1;
        }
    }

    /*returns poped element from stack*/
    int pop()
    {
        // Your code here

        if(!s.empty()) {
            int poppedElement = s.pop();

            if (poppedElement < minEle) {
                int returnableElement = minEle;
                minEle = (2*minEle) -poppedElement;
                return  returnableElement;

            } else {
                return poppedElement;
            }
        }

        else
        {
            return -1;
        }

    }

    /*push element x into the stack*/
    void push(int x)
    {
       if(s.empty())
       {
           minEle =x;
           s.push(x);
       }

       else
       {
           if(x < minEle)
           {
               s.push(2*x - minEle);
               minEle =x;

           }

           else
           {
               s.push(x);
           }
       }
    }
}

