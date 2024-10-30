package com.tca.maximum;

public class Maximum {

    public static int max(int []a)
    {
        int max = a[0];
        for(int i=1; i<a.length; ++i)
        {
            if(max < a[i]) max = a[i];
        }
        return max;
    }
    public static int max(int a, int b)
    {
        if(a>b) return a;
        return b;
    }
}
