package rover;

/**
 * STEP 7 · A Rover OWNS two Servos. That is the filled diamond on the diagram.
 *
 *      ┌────────────────────────────────┐
 *      │             Rover              │
 *      ├────────────────────────────────┤
 *      │ - name: String                 │
 *      │ - left: Servo                  │
 *      │ - right: Servo                 │
 *      ├────────────────────────────────┤
 *      │ + getName(): String            │
 *      │ + getLeftServo(): Servo        │
 *      │ + getRightServo(): Servo       │
 *      │ + steerLeft(int): void         │
 *      │ + steerRight(int): void        │
 *      └───────────────◆────────────────┘
 *                      │ owns 2
 *                    Servo
 *
 * README Step 7 gives you the whole class. Type it in below.
 */
public class Rover {

    // ▼ README · Step 7.
    private  String name;
    private  Servo left;
    private  Servo right;
    private int batteryCapacity = 300;
    private int charge = batteryCapacity;

    public Rover(String name){
        this.name = name;
        this.left = new Servo("left");
        this.right = new Servo("right");
    }

    public Rover(String name, int batteryCapacity){
        this.name = name;
        this.left = new Servo("left");
        this.right = new Servo("right");
        this.batteryCapacity = batteryCapacity;
        this.charge = batteryCapacity;
    }

    public String getName() {
        return name;
    }

    public Servo getLeftServo(){
        return left;
    }

    public Servo getRightServo(){
        return right;
    }

    public void drain(int amount){
        if(amount >= batteryCapacity){
            charge = 0;
        } else {
            charge = charge - amount;
        }

    }

    public int batteryPercent(){
        return charge * 100 / batteryCapacity;

    }




    public int getCharge(){
        return charge;
    }

    public void steerLeft(int degrees){
        left.turnTo(degrees);
    }

    public void steerRight(int degrees){
        right.turnTo(degrees);
    }

    public void centerAll(){
        left.turnTo(90);
        right.turnTo(90);
    }

    public boolean hasName(String other){
        return name.equals(other);
    }

    public String toString(){
        return ""+name + " [" + left  + ", " + right + "]";
    }

}
