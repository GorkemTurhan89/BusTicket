

import java.util.Scanner;

public class Ticket {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int km = 0;
        int age = 0;
        byte roundOrOneWay = 1;
        double price=0;

        do {
            System.out.println("Please enter the distance planned to go  ");

            km = input.nextInt();
            if (km < 0) {
                System.out.println("Please enter distance carefully");
            }
        } while (km < 0);

        do {
            System.out.println("Please enter your age");

            age = input.nextInt();
            if (age < 0) {
                System.out.println("Please enter distance carefully");
            }
        } while (age < 0);


        do {    System.out.println("Please enter '1' oneway or '2' roundtrip  ");
            roundOrOneWay = input.nextByte();
            if (roundOrOneWay!=1&roundOrOneWay!=2) {
                System.out.println("Try again");
            }
        } while (roundOrOneWay!=1&roundOrOneWay!=2);

        price= distanceRegulation(km,roundOrOneWay);
        price =ageDiscount(age,price);
        System.out.println(price);


    }
    public static double distanceRegulation(int km, int roundOrOneWay){
        double price =0;
        if(roundOrOneWay==1){
            price = km*0.1;
        }else if(roundOrOneWay==2){
            price = km*0.1*2;
            price-= price*0.2;//discount
        }
        return price;

    }

    public static double ageDiscount (double age, double price){
        if(age<12){
            price -= 0.5*price;
        } else if (age>=12||age<24) {
            price-= 0.1*price;
        }else if(age>65){
            price -=0.3*price;
        }else{
            price=price;
        }return price;

    }//discount

}