import java.util.*;
public class LRPOne {
    static char [] c={'A','B','C','D','E','F','G','S'};
    static int e[]={2,2,2,2,2,2,3,3};
    static list [] [] ={{3,7},{4,7},{5,7},{0,6},{1,6},{2,6},{3,4,5},{0,1,2}};

    static int [] checked=new int[20];
    static int [] stk=new int[20];
    static int top=0;
    public static void main(String[] args){
        int i,n,f=0;
        push(7);
        while (top!=0) {
            n=stk[top-1];
            for(i=0;i<e[n];i++){
                f=0;
                if (notChecked(list[n][i])==1) {
                    push(list[n][i]);
                    f=1;
                    break;
                }
            }
            if (f==0) 
                pop();
            }
            
        }
        static int notChecked(int n){
            if(checked[n]==1)
            return 0;
            return 1;
        }
        static int pop(){
            top--;
            return stk[top];
        }
        static void push(int n){
            checked[n]=1;
            System.err.println(c[n]+"");
            stk[top]=n;
            top++;
        }
    }

