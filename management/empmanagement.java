import java.util.*;

interface Eoperations{
    void delete();
}

interface menu{
    void show();
}
class emp{
    String Ename;
    int EID;
    int Esal;
    String Edep;

    public emp(String Ename, int EID,int Esal,String Edep){
        this.Ename=Ename;
        this.EID=EID;
        this.Esal=Esal;
        this.Edep=Edep;
    }
    public void display(){
        System.out.println("Name : "+Ename);
        System.out.println("ID : "+EID);
        System.out.println("Salary : "+Esal);
        System.out.println("Department : "+Edep);
    }
}

public class empmanagement implements Eoperations,menu {
    private emp[] employees;
    private int empcount;
    private Scanner sr;
    public empmanagement(){
        sr=new Scanner(System.in);
    }
    public void input(){
        System.out.print("Enter the total number of employees : ");
        int num=sr.nextInt();
        employees=new emp[num];
        empcount=0;
        for(int i=1;i<=num;i++){
            System.out.print("Employee Name : ");
            String Ename=sr.next();
            System.out.print("Employee ID : ");
            int EID=sr.nextInt();
            System.out.print("Employee Salary : ");
            int Esal=sr.nextInt();
            System.out.print("Employee Department : ");
            String Edep=sr.next();
            employees[empcount++]=new emp(Ename,EID,Esal,Edep);
            System.out.println("-------------------------------"+i+" Emp1loyee(s) Added"+"----------------------------------------------------");
        }
    }

    public void delete() {
        System.out.println("----------------------------------------Menu to perform deletion operation------------------------------------");
        System.out.print("Do you want to delete any employee details (yes/no) : ");
        String choice1 = sr.next();
        if ("yes".equalsIgnoreCase(choice1)) {
            System.out.print("Enter the ID of employee you want to delete : ");
            int del = sr.nextInt();
            int remove = -1;
            for (int i = 0; i < empcount; i++) {
                if (employees[i].EID == del) {
                    remove = i;
                    break;
                }
            }
            if (remove != -1) {
                for (int i = remove; i < empcount - 1; i++) {
                    employees[i] = employees[i + 1];
                }
                employees[--empcount] = null;
                System.out.println("Employee with ID " + del + " is deleted");
            } else {
                System.out.println("Employee with ID " + del + " not found");
            }
        } else {
            System.out.println("........................................Exiting.....................................................");
        }
    }

    public void show(){
        while (true) {
            System.out.println("--------------------------------Menu to display details of the employees--------------------------------------");
            System.out.println("1. Display details of all the employees");
            System.out.println("2. Get the employee details by ID");
            System.out.println("3. Exit");
            System.out.print("Enter your choice : ");
            int choice2=sr.nextInt();
            switch (choice2) {
                case 1:
                    for(int i=0;i<empcount;i++){
                        employees[i].display();
                    } 
                    break;
                case 2:
                    System.out.print("Enter employee ID : ");
                    int EID=sr.nextInt();
                    boolean found=false;
                    for(int i=0;i<empcount;i++){
                        if (employees[i].EID ==EID) {
                            employees[i].display();
                            found =true;
                            break;
                        }
                    }    
                    if (!found) {
                        System.out.println("Employee ID"+EID+" not found");
                    } 
                    break;
                case 3:
                    System.out.println("........................................Exiting.....................................................");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        empmanagement obj=new empmanagement();
        obj.input();
        obj.delete();
        obj.show();
    }
}