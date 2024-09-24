import java.util.Scanner;

public class LRPOne{
    static int [] [] matrix=new int[20][20];
    //Make 2D array that will contain the graph
    public static void main (String [] args) {
        int e=7, n=5; //e is number of edges, n is number of vetices
        Inmatrix(e);
        System.out.println("Output: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }

    }
    static void Inmatrix(int e){
        Scanner sn=new Scanner(System.in);
        System.out.println("Enter The Edges: ");
        int i;
        char j,k;
    }
}