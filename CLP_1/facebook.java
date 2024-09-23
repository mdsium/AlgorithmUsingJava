import java.util.*;
public class Main {
    static class Post {
        int likes;
        int comments;
        int index;
        Post(int likes, int comments, int index) {
            this.likes = likes;
            this.comments = comments;
            this.index = index;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of posts
        int N = sc.nextInt();

        // Input the likes array
        int[] likes = new int[N];
        for (int i = 0; i < N; i++) {
            likes[i] = sc.nextInt();
        }
        // Input the comments array
        int[] comments = new int[N];
        for (int i = 0; i < N; i++) {
            comments[i] = sc.nextInt();
        }

        // Create an array of Post objects
        Post[] posts = new Post[N];
        for (int i = 0; i < N; i++) {
            posts[i] = new Post(likes[i], comments[i], i + 1); // i+1 to store 1-based index
        }

        // Sort based on popularity (likes first, then comments)
        Arrays.sort(posts, (p1, p2) -> {
            if (p1.likes != p2.likes) {
                return p2.likes - p1.likes; // Sort by likes in descending order
            } else {
                return p2.comments - p1.comments; // If likes are equal, sort by comments in descending order
            }
        });

        // Output the sorted indices
        for (Post post : posts) {
            System.out.print(post.index + " ");
        }
        System.out.println();

        sc.close();
    }
}