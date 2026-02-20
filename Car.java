package Baiseasion10;

public class Car
{
    int currentSpeed = 0;

    public int accelerate()
        {
        currentSpeed += 10;
            System.out.println("Car accelerates by default: +10 km/h");
        return currentSpeed;
        }

    public int accelerate(int speed)
    {
        currentSpeed += speed;
        System.out.println("Car accelerates by " + speed + " km/h");
        return currentSpeed;
    }

    public int accelerate(int speed, int seconds)
    {
        double increase = speed * seconds;
        currentSpeed += increase;
        System.out.println("Car accelerates " + increase + " km/h (speed x time)");
        return currentSpeed;
    }

    public void printStatus()
    {
        System.out.printf( "Current speed: %d km/h", accelerate());
    }
}
