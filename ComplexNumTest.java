class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex add(Complex other) {
        double newReal = this.real + other.real;
        double newImaginary = this.imaginary + other.imaginary;
        return new Complex(newReal, newImaginary);
    }

    public Complex subtract(Complex other) {
        double newReal = this.real - other.real;
        double newImaginary = this.imaginary - other.imaginary;
        return new Complex(newReal, newImaginary);
    }

    public void display() {
        if (imaginary >= 0) {
            System.out.println(real + " + " + imaginary + "i");
        } else {
            System.out.println(real + " - " + Math.abs(imaginary) + "i");
        }
    }
}

public class ComplexNumTest {
    public static void main(String[] args) {
        Complex num1 = new Complex(3, 4);
        Complex num2 = new Complex(1, 2);

        System.out.print("First Complex Number: ");
        num1.display();

        System.out.print("Second Complex Number: ");
        num2.display();

        Complex sum = num1.add(num2);
        System.out.print("Sum: ");
        sum.display();

        Complex difference = num1.subtract(num2);
        System.out.print("Difference: ");
        difference.display();
    }
}
