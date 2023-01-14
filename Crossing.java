/* You are given an array of integers distance... You start at the point (0, 0) on an X-Y plane, and you move distance[0] meters to the north, then distance[1] meters to the west, distance[2] meters to the south, distance[3] meters to the east, and so on. In other words, after each move, your direction changes counter-clockwise... Return true if your path crosses itself or false if it does not...
 * Eg 1: distance = [2,1,1,2]           Output = true
 * Eg 2: distance = [1,2,3,4]           Output = false
 * Eg 3: distance = [1,1,1,2,1]         Output = true
 * Eg 4: distance = [1,1,2,1,1]         Output = true
 * Eg 5: distance = [1,1,2,2,1,1]       Output = true
 * Eg 6: distance = [3,4,5,3,4]         Output = false
 */
import java.util.*;
public class Crossing
{
    public boolean SelfCrossing(int dist[])
    {
        if(dist.length < 4)   // If there are less than four values, then the path is never self crossed...
            return false;
        int i = 3;
        while(i < dist.length)
        {
            if((i >= 3) && (dist[i-1] <= dist[i-3]) && (dist[i] >= dist[i-2]))
                return true;   // Path self crossed in at least three iterations...
            if((i >= 4) && (dist[i-1] == dist[i-3]) && (dist[i] + dist[i-4] >= dist[i-2]))
                return true;   // Path self crossed in at least four iterations...
            if((i >= 5) && (dist[i-2] >= dist[i-4]) && (dist[i-5] + dist[i-1] >= dist[i-3]) && (dist[i-1] <= dist[i-3]) && (dist[i-4] + dist[i] >= dist[i-2]))
                return true;   // Path self crossed in at least five iterations...
            i++;
        }
        return false;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.print("Enter the number of Distances traversed : ");
        x = sc.nextInt();
        int distance[] = new int[x];
        for(int i = 0; i < distance.length; i++)
        {
            System.out.print("Enter the "+(i+1)+" distance : ");
            distance[i] = sc.nextInt();
        }
        Crossing crossing = new Crossing();    // Object creation...
        System.out.println("The Crossing is : "+crossing.SelfCrossing(distance));
        sc.close();
    }
}

// Time Complexity  - O(n) time...
// Space Complexity - O(1) space...

/* DEDUCTIONS :- 
 * 1. We can only traverse in a particular direction after every 3 iterations...
 * 2. Accordingly we can create the sub-problems in which the path is self crossed...
 * 3. Then we can used Divide-and-Conquer or Dynamic Programming to check if any of the sub-problems exist in the array then, the path is self crossed... 
*/