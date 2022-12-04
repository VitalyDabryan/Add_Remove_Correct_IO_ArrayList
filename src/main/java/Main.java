import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

//    The list of employees should allow:
//       -Upload a list from a file,
//       -Add an employee
//       -Delete an employee
//       -Change employee data
//       -Sort the list by last name
//       -Write list to file
    public static void main(String[] args) throws FileNotFoundException, java.io.IOException {
        ArrayList<MyParametr> myArray = new ArrayList<>();
        String name, surname, secondName, data1, data2, profession;
        char choice;

        File myfile = new File("C:\\Users\\100nout\\IdeaProjects\\ParserTapanar\\src\\main\\java\\Workers.txt");
        FileReader fr = new FileReader(myfile);
        BufferedReader reader = new BufferedReader(fr);
        String line;

        while (true) {   //  -Upload a list from a file
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] convertString = line.split(" ");

            name = convertString[0];
            secondName = convertString[1];
            surname = convertString[2];
            data1 = convertString[3];
            data2 = convertString[4];
            profession = convertString[5];
            MyParametr myParametr = new MyParametr(name, secondName,surname,data1, data2, profession);

            myArray.add(myParametr);   // -Add an employee in ArrayList

        }
            myArray.forEach((a)->System.out.println(a));

        PrintMenu();

        Scanner scanner = new Scanner(System.in);
        choice = (char) System.in.read ();

        while (choice != 'e') {
                switch (choice) {
                    case '1':
                        myArray = addEmployee(myArray);
                        printMenu();
                        choice = (char) System.in.read ();
                        break;
                    case  '2':
                        myArray = deleteEmployee(myArray, scanner);
                        myArray.forEach((a)->System.out.println(a));
                        printMenu();
                        choice = (char) System.in.read ();
                        break;
                    case  'e':
                         break;
                    default:
                        System.out.println("Wrong simbol!");
                        printMenu();
                        break;// throw new IllegalStateException("Unexpected value: " + choice);
                }
        }
        myArray.forEach((a)->System.out.println(a));
    }

    private static ArrayList<MyParametr> deleteEmployee(ArrayList<MyParametr> myArray, Scanner scanner) {
        String surname;
        System.out.print("Enter  the employee's name: ");
        surname = scanner.next();
        Iterator<MyParametr> myParametrIterator = myArray.iterator();//создаем итератор
        while(myParametrIterator.hasNext()) {//до тех пор, пока в списке есть элементы

            MyParametr nextMyParametr = myParametrIterator.next();//получаем следующий элемент
            if (nextMyParametr.surname.equals(surname)) {
                myParametrIterator.remove();//удаляем работника с нужным именем
            }
        }
        return myArray;
    }

    private static void PrintMenu() {
        System.out.println("Make your choice:");
        System.out.println("1. Add an employee.");
        System.out.println("2. Delete an employee.");
        System.out.println("Press 'e' to exit ");
    }

    private static void printMenu() {
        System.out.println("Make your choice:");
        System.out.println("1. Add an employee.");
        System.out.println("2. Delete an employee.");
        System.out.println("Press 'e' to exit");
    }


    private static ArrayList<MyParametr> addEmployee(ArrayList<MyParametr> myArray) {
        String profession, secondName, data1, surname, data2, name;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        name = scanner.next();
        System.out.print("Enter secondname: ");
        secondName = scanner.next();;
        System.out.print("Enter lastname: ");
        surname = scanner.next();
        System.out.print("Enter date of birth: ");
        data1 = scanner.next();
        System.out.print("Enter date of employment: ");
        data2 = scanner.next();
        System.out.print("Enter position: ");
        profession = scanner.next();;
        MyParametr myParametr = new MyParametr(name, secondName, surname, data1, data2, profession);

        myArray.add(myParametr);
        return myArray;
    }


}
