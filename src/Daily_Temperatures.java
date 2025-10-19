import java.util.Stack;

public class Daily_Temperatures {
    static {
        int [] temp = {30, 60, 90};
        for(int i = 0; i < 500; i++)
            dailyTemperatures(temp);
    }
    public static int[] dailyTemperatures(int[] temp)
    {
        //method 1
        int n=temp.length;
        int[] stack =new int[n];
        int top=-1;
        int[] ans =new int[n];

        for(int i=0;i<n;i++)
        {
            while(top>-1 && temp[stack[top]]<temp[i])
            {
                ans[stack[top]]=i-stack[top];
                top--;
            }
            stack[++top]=i;
        }
        return ans;

        // method 2

        // int n=temp.length;
        // int ans[]=new int[n];

        // Stack<Integer> st=new Stack<>();
        // for(int i=n-1;i>=0;i--)
        // {
        //     while(!st.isEmpty() && temp[st.peek()]<=temp[i])
        //        st.pop();
        //     if(st.isEmpty())
        //     {
        //         ans[i]=0;
        //     }
        //     else
        //     {
        //         ans[i]=st.peek()-i;
        //     }
        //     st.push(i);
        // }
        // return ans;
    }
}
