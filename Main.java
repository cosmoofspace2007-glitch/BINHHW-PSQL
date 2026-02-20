package Baiseasion11;

import java.util.Scanner;

public class Main
{ public  static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

//        Shape[] shapes=new Shape[2];
//
//        shapes[0]=new Circle("Circle1", 3.4);
//        shapes[1]=new Rectangle("Rectagle1",34,25);
//
//        for(Shape s:shapes)
//        {
//            s.displayInfo();
//            System.out.println("Area  "+s.getArea());
//            System.out.println("Perimeter"+s.getPerimeter());
//
//            Drawable drawable = (Drawable)s;
//            drawable.draw();
//        }


//        Payment[] payments=new Payment[3];
//
//        payments[0] = new CashPayment(23.000);
//        payments[1] = new CreditCardPayment(12.000);
//        payments[2] = new EWalletPayment(100.000);
//
//        for(Payment p:payments)
//        {
//
//            p.printAmount();
//            p.pay();
//
//            if(p instanceof Refundable)
//            {
//                Refundable r=(Refundable)p;
//                r.refund();
//            }
//        }

//        Employee[] e =  new Employee[6];
//
//        e[0] = new PartTimeEmployee(123, "Nguyễn Văn A",4);
//        e[1] = new FullTimeEmployee(345, "Trần Văn B");
//        e[2] = new PartTimeEmployee(678, "Nguyễn Quang A",3);
//        e[3] = new FullTimeEmployee(910, "Bùi Văn C");
//        e[4] = new FullTimeEmployee(112, "Quang Văn T");
//        e[5] = new PartTimeEmployee(224, "Nguyễn Phương L",6);
//
//        for(Employee e1: e)
//        {
//            e1.showInfo();
//
//            System.out.println("Salary:" + e1.calculateSalary());
//
//            if(e1 instanceof BonusEligible)
//                {
//                PartTimeEmployee p = (PartTimeEmployee)e1;
//                p.calculateBonus();
//                }
//        }

        Device[] device = new Device[7];

        device[0] = new Laptop(111,"Lap Asus");
        device[1] = new Laptop(222,"Lap Window");
        device[2] = new SmartPhone(333,"Nokia");
        device[3] = new Laptop(444,"Lap Apple");
        device[4] = new Television(555,"4D LED");
        device[5] = new SmartPhone(666,"Apple Galaxy");
        device[6] = new Television(777,"TV Lồi");

        for(Device d:device)
        {
            System.out.printf("Thiết bị: %s có mã là %d\n",d.name,d.id);

            if(d instanceof Laptop)
            {
                Laptop l=(Laptop)d;
                l.turnOn();
                l.turnOff();
                l.charge();
                l.connectWifi();
            }

            if(d instanceof SmartPhone)
            {
                SmartPhone sm=(SmartPhone)d;
                sm.turnOn();
                sm.turnOff();
                sm.charge();
                sm.connectWifi();
            }

            if(d instanceof Television)
            {
                Television tele=(Television)d;
                tele.turnOff();
                tele.turnOn();
                tele.connectWifi();
            }
        }
    }
}
