import java.util.Scanner;

abstract class shape {
    abstract double area();
}

class triangle extends shape {
    int height, base;

    triangle(int height, int base) {
        this.height = height;
        this.base = base;
    }

    double area() {
        return 0.5 * height * base; 
    }
}

class rectangle extends shape {
    int length, breadth;

    rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

  
    double area() {
        return length * breadth;
    }
}

class circle extends shape {
    int radius;

    circle(int radius) {
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius; 
    }
}


public class l6q1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int l, bre, r, h, b;


        System.out.println("Enter the height and base of the triangle: ");
        h = scan.nextInt();
        b = scan.nextInt();


        System.out.println("Enter the length and breadth of the rectangle: ");
        l = scan.nextInt();
        bre = scan.nextInt();


        System.out.println("Enter the radius of the circle: ");
        r = scan.nextInt();


        triangle t = new triangle(h, b);
        rectangle rect = new rectangle(l, bre);
        circle c = new circle(r);


        System.out.println("Area of the triangle: " + t.area());
        System.out.println("Area of the rectangle: " + rect.area());
        System.out.println("Area of the circle: " + c.area());
    }
}
