//package LeetCode.Easy;
//
//public class MysqlDuplicateEntry {
////    Truncate table Person
////    insert into Person (Id, Email) values ('1', 'john@example.com')
////    insert into Person (Id, Email) values ('2', 'bob@example.com')
////    insert into Person (Id, Email) values ('3', 'john@example.com')
////    Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based
////    on its smallest Id.
////
////+----+------------------+
////        | Id | Email            |
////            +----+------------------+
////            | 1  | john@example.com |
////            | 2  | bob@example.com  |
////            | 3  | john@example.com |
////            +----+------------------+
////    Id is the primary key column for this table.
////    For example, after running your query, the above Person table should have the following rows:
////
////            +----+------------------+
////            | Id | Email            |
////            +----+------------------+
////            | 1  | john@example.com |
////            | 2  | bob@example.com  |
////            +----+------------------+
//
////    SELECT Email COUNT(email) from Person Group By Email Having COUNT(email) = 1
//
//    DELETE p1 from Person p1, Person p2 WHERE p1.Email = p2.Email AND p1.Id > p2.Id;
//}
