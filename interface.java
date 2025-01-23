 interface Shape {
        int numberOfSides();
    }
    
    class Rectangle implements Shape {
        public int numberOfSides() {
            int side = 4;
            return side;
        }
    }
    
    class Triangle implements Shape {
        public int numberOfSides() {
            int side = 3;
            return side;
        }
    }
    
    class Hexagon implements Shape {
        public int numberOfSides() {
            int side = 6;
            return side;
        }
    }
    
    public class area {
        public static void main(String[] args) {
            Rectangle r1 = new Rectangle();
            Triangle t1 = new Triangle();
            Hexagon h1 = new Hexagon();
            Shape s = r1;
    
            System.out.println("Triangle has " + t1.numberOfSides() + " sides.");
            System.out.println("Rectangle has " + r1.numberOfSides() + " sides.");
            System.out.println("Hexagon has " + h1.numberOfSides() + " sides.");
    
            try {
                int sides = s.numberOfSides();
                System.out.println("Shape has " + sides + " sides.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

