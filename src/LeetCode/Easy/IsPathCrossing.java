package LeetCode.Easy;

import java.nio.channels.Pipe;
import java.util.*;

public class IsPathCrossing {
//    Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east,
//    or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
//
//    Return True if the path crosses itself at any point, that is, if at any time you are on a location you've
//    previously visited. Return False otherwise.

//    Example 1:

//    Input: path = "NES"
//    Output: false
//    Explanation: Notice that the path doesn't cross any point more than once.
//    Example 2:
//
//
//
//    Input: path = "NESWW"
//    Output: true
//    Explanation: Notice that the path visits the origin twice.
//
//
//    Constraints:
//
//            1 <= path.length <= 10^4
//    path will only consist of characters in {'N', 'S', 'E', 'W}

   class Pair {
       Integer a;
       Integer b;

       public Pair(Integer a, Integer b) {
           this.a = a;
           this.b = b;
       }

       public Integer getA() {
           return a;
       }

       public Integer getB() {
           return b;
       }

       @Override
       public int hashCode() {
           List<Integer> l = new LinkedList<>();
           l.add(a);
           l.add(b);
           int hash = l.hashCode();
           return hash;
       }

       @Override
       public boolean equals(Object obj) {
           if (this == obj)
               return true;
           if (obj == null)
               return false;
           if (getClass() != obj.getClass())
               return false;

           Pair other = (Pair) obj;

           if (a != other.a)
               return false;
           if (b != other.b)
               return false;
           return true;
       }
   }

    public boolean isPathCrossing(String path) {
       if (path == null && path.length() == 0) {
           return true;
       }
       Set<Pair> coordinateSet = new HashSet<>();

       int x = 0, y = 0;
       Pair points = new Pair(x, y);
       coordinateSet.add(points);

       for (int i = 0; i < path.length(); i++) {
           if (path.charAt(i) == 'N') {
               y++;
           }
           else if (path.charAt(i) == 'S') {
               y--;
           }
           else if (path.charAt(i) == 'E') {
               x++;
           }
           else if (path.charAt(i) == 'W') {
               x--;
           }

           Pair p = new Pair(x, y);
           if (!coordinateSet.add(p)) { //if the char is already added to the hashset, then return its passing paths.
               return true;
           }
       }
       return false;
    }

    public static void main(String[] args) {
        String path1 = "NES";
        String path2 = "NESWW";
        String path3 = "SN";
        String path4 = "SS";
        IsPathCrossing res = new IsPathCrossing();
        System.out.println(res.isPathCrossing(path1));
        System.out.println(res.isPathCrossing(path2));
        System.out.println(res.isPathCrossing(path3));
        System.out.println(res.isPathCrossing(path4));
    }
}

