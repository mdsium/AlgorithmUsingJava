public class Labreport {
    static int [] [] matrix=new int[20][20];
    //Make 2D array that will contain the graph
    public static void main (String [] args) {
        int e=8, n=5; 
        System.out.println("Output: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }

    }
}
