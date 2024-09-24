import java.util.Scanner;
public class LRPOne{
    static int [] [] matrix=new int[20][20];
    //Make 2D array that will contain the graph
    public static void main (String [] args) {
        int e=8, n=5; //e is number of edges, n is number of vetices
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
        for(i=0; i<e; i++){
            j=sn.next().charAt(0);
            k=sn.next().charAt(0);
            matrix[(int) j-65] [(int)k-65]=matrix [(int)k-65] [(int)j-65]=1;
            //An undirected edge has both ways access between the nodes.
            //If A to B has a way to go then B to A has the same way.
        }
    }
}
