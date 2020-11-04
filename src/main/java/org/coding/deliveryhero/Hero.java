package org.coding.deliveryhero;

public class Hero {

    public static void main(String[] args) {


       System.out.println(solution(new String("a,0 b,0 a,10 a,20 b,20 b,40 b,50 b,60 a,60"),"b",10));

    }

    public static  int solution(
            String p,
            String d,
            int s
    ) {

        String[] splittedString  = p.split("\\s*(=>|,|\\s)\\s*");

        String lastCharIs ="";
        int lastSecForChar = 0;
        int onlineToOfflineCount = 0;

        for(int i =0; i< splittedString.length; i++)
        {

            if(lastCharIs.equals(d))
            {
                int j =Integer.parseInt(splittedString[i]);
                if(( j-lastSecForChar) > s)
                {
                    onlineToOfflineCount ++;
                }

                lastSecForChar = j;

            }


            lastCharIs = splittedString[i];


        }

        return onlineToOfflineCount;
    }
}
