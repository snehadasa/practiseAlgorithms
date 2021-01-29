package LeetCode.Easy;

import java.util.ArrayList;
import java.util.List;

public class Generate {
//    Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
//
//
//    In Pascal's triangle, each number is the sum of the two numbers directly above it.
//
//    Example:
//
//    Input: 5
//    Output:
//            [
//            [1],
//            [1,1],
//            [1,2,1],
//            [1,3,3,1],
//            [1,4,6,4,1]
//            ]

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        if (numRows == 0) {
            return pascalTriangle;
        }

        pascalTriangle.add(new ArrayList<>());
        pascalTriangle.get(0).add(1); //first row, top element is always 1.

        for (int row = 1; row < numRows; row++) {
            List<Integer> addRow = new ArrayList<>();
            List<Integer> prevRow = pascalTriangle.get(row-1);

            addRow.add(1);  //each row, first element is always 1.

            for (int j = 1; j < row; j++) {
                addRow.add(prevRow.get(j-1) + prevRow.get(j));  //add prev row's element and its prev element to get present element.
            }
            addRow.add(1);  //each row last element is always 1.

            pascalTriangle.add(addRow);
        }
        return pascalTriangle;
    }

    public List<List<Integer>> generate1(int numRows)
    {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        for(int i=0;i<numRows;i++)
        {
            row.add(0, 1);
            for(int j=1;j<row.size()-1;j++)
                row.set(j, row.get(j)+row.get(j+1));
            allrows.add(new ArrayList<Integer>(row));
        }
        return allrows;
    }

    public static void main(String[] args) {
        int numRows = 5;
        Generate res = new Generate();
        System.out.println(res.generate(numRows));
    }
}
