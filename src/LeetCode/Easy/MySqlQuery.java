//package LeetCode.Easy;
//
////public class MySqlQuery {
////    SQL Schema
////    Table: Department
////
////+---------------+---------+
////        | Column Name   | Type    |
////            +---------------+---------+
////            | id            | int     |
////            | revenue       | int     |
////            | month         | varchar |
////            +---------------+---------+
////            (id, month) is the primary key of this table.
////    The table has information about the revenue of each department per month.
////    The month has values in ["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"].
////
////
////    Write an SQL query to reformat the table such that there is a department id column and a revenue column for each month.
////
////    The query result format is in the following example:
////
////    Department table:
////            +------+---------+-------+
////            | id   | revenue | month |
////            +------+---------+-------+
////            | 1    | 8000    | Jan   |
////            | 2    | 9000    | Jan   |
////            | 3    | 10000   | Feb   |
////            | 1    | 7000    | Feb   |
////            | 1    | 6000    | Mar   |
////            +------+---------+-------+
////
////    Result table:
////            +------+-------------+-------------+-------------+-----+-------------+
////            | id   | Jan_Revenue | Feb_Revenue | Mar_Revenue | ... | Dec_Revenue |
////            +------+-------------+-------------+-------------+-----+-------------+
////            | 1    | 8000        | 7000        | 6000        | ... | null        |
////            | 2    | 9000        | null        | null        | ... | null        |
////            | 3    | null        | 10000       | null        | ... | null        |
////            +------+-------------+-------------+-------------+-----+-------------+
////
////    Note that the result table has 13 columns (1 for the department id + 12 for the months).
//
////CREATE TABLE IF NOT EXISTS new_table(Id int, Jan_Revenue int, Feb_Revenue int, Mar_Revenue int, Apr_Revenue int,
////        May_Revenue int, June_Revenue int, July_Revenue int, Aug_Revenue int, Sep_Revenue int, Oct_Revenue int,
////        Nov_Revenue int, Dec_Revenue int, month VARCHAR(255));
////
////        INSERT INTO new_table(id) SELECT (id) FROM Department;
////
////        UPDATE new_table
////        SET new_table.Jan_Revenue = Department.revenue
////        INNER JOIN Department ON new_table.id = Department.id;
////
////        Update new_table
////        SET new_table.Feb_Revenue = Department.revenue
////        SELECT new_table
////        inner join Department ON new_table.id = Department.id;
////
////        Update new_table
////        SET new_table.Mar_Revenue = Department.revenue
////        SELECT new_table
////        inner join Department ON new_table.id = Department.id;
////
////        Update new_table
////        SET new_table.Apr_Revenue = Department.revenue
////        SELECT new_table
////        inner join Department ON new_table.id = Department.id;
////
////        Update new_table
////        SET new_table.May_Revenue = Department.revenue
////        SELECT new_table
////        inner join Department ON new_table.id = Department.id;
////
////        Update new_table
////        SET new_table.June_Revenue = Department.revenue
////        SELECT new_table
////        inner join Department ON new_table.id = Department.id;
////
////        Update new_table
////        SET new_table.July_Revenue = Department.revenue
////        SELECT new_table
////        inner join Department ON new_table.id = Department.id;
////
////        Update new_table
////        SET new_table.Aug_Revenue = Department.revenue
////        SELECT new_table
////        inner join Department ON new_table.id = Department.id;
////
////        Update new_table
////        SET new_table.Sep_Revenue = Department.revenue
////        SELECT new_table
////        inner join Department ON new_table.id = Department.id;
////
////        Update new_table
////        SET new_table.Oct_Revenue = Department.revenue
////        SELECT new_table
////        inner join Department ON new_table.id = Department.id;
////
////        Update new_table
////        SET new_table.Nov_Revenue = Department.revenue
////        SELECT new_table
////        inner join Department ON new_table.id = Department.id;
////
////        Update new_table
////        SET new_table.Dec_Revenue = Department.revenue
////        SELECT new_table
////        inner join Department ON new_table.id = Department.id;
//
//SELECT id,
//        sum(if(month='Jan',revenue,null)) as Jan_Revenue,
//        sum(if(month='Feb',revenue,null)) as Feb_Revenue,
//        sum(if(month='Mar',revenue,null)) as Mar_Revenue,
//        sum(if(month='Apr',revenue,null)) as Apr_Revenue,
//        sum(if(month='May',revenue,null)) as May_Revenue,
//        sum(if(month='Jun',revenue,null)) as Jun_Revenue,
//        sum(if(month='Jul',revenue,null)) as Jul_Revenue,
//        sum(if(month='Aug',revenue,null)) as Aug_Revenue,
//        sum(if(month='Sep',revenue,null)) as Sep_Revenue,
//        sum(if(month='Oct',revenue,null)) as Oct_Revenue,
//        sum(if(month='Nov',revenue,null)) as Nov_Revenue,
//        sum(if(month='Dec',revenue,null)) as Dec_Revenue
//        FROM Department
//        GROUP BY id;