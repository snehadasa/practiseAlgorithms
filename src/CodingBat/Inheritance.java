package CodingBat;

public class Inheritance
{
    public static void main(String[] args)
    {

//        Given a string, if the string "del" appears starting at index 1, return a string where
//        that "del" has been deleted. Otherwise, return the string unchanged.
//
//
//        delDel("adelbc") → "abc"
//        delDel("adelHello") → "aHello"
//        delDel("adedbc") → "adedbc"
            
            
        Inheritance inheritance = new Inheritance();
        System.out.println(inheritance.delDel("adelbc"));

//        Vehicle car = new Vehicle();
//
//        Truck truck = new Truck(car);
//
//        System.out.println(car.kmsRan);
//
//        System.out.println(truck.kmsRan);
//
//        System.out.println(truck.vehicle.kmsRan);
//
//        truck.vehicle.kmsRan = 2121;
//
//        System.out.println("--------");
//
//        System.out.println(car.kmsRan);
//
//        System.out.println(truck.kmsRan);
//        System.out.println(truck.vehicle.kmsRan);
    }

    public String delDel(String str) {
        if (str.length() < 4) {
            return str;
        }
        if (str.substring(1,4).equals("del")) {
            String prefix = str.substring(0,1);
            String suffix = "";
            if (str.length() > 4) {
                suffix = str.substring(4, str.length());
            }
            return prefix + suffix;
        }
        return str;

//        if (str.length()>=4 && str.substring(1, 4).equals("del")) {
//            // First char + rest of string starting at 4
//            return str.substring(0, 1) + str.substring(4);
//        }
//        // Otherwise return the original string.
//        return str;
    }

}