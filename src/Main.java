import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    String gender;
    String classroom;
    float java;
    float html;
    float git;
    float score;
    float avg;
    Student() {
    }


    public Student(int id, String name, String gender, String classroom, float java, float html, float git, float score,float avg) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.classroom = classroom;
        this.java = java;
        this.html = html;
        this.git = git;
        this.score = score;
        this.avg = avg;
    }

    float findScore() {
        score = java + html + git;
        return score;
    }
    float Average() {
        avg = (java + html + git)/3;
        return avg;
    }

    void outputInformation() {
        System.out.println("---------------------------------");
        System.out.println("ID       : " + id);
        System.out.println("Name     : " + name);
        System.out.println("Gender   : " + gender);
        System.out.println("Classroom: ");
        System.out.println("Java     : " + java);
        System.out.println("Html     : " + html);
        System.out.println("Git      : " + git);
        System.out.println("Salary   : " + findScore());
        System.out.println("Average  : " + Average());
    }

    void inputInformation(Scanner input) {
        boolean isIDValid = false;
        do {
            String strId;
            System.out.print("Enter ID : ");
            try {
                strId = input.next();
                id = Integer.parseInt(strId);
                isIDValid = true;
            } catch (Exception ex) {
                System.out.println(" Invalid ID format!! (Integer only! )");
            }
        } while (!isIDValid);

        System.out.print("Enter Name   : ");
        input.nextLine();
        name = input.nextLine();
        System.out.print("Enter Gender : ");
        gender = input.nextLine();
        System.out.print("Enter Classroom : ");
        classroom = input.nextLine();
        System.out.print("Enter Java   : ");
        java = input.nextInt();
        System.out.print("Enter Html   : ");
        html = input.nextInt();
        System.out.print("Enter Git    : ");
        git = input.nextInt();
        System.out.print("Enter Score  : "+findScore());
//        score = input.nextInt();
        System.out.print("Enter Average: "+Average());
//        avg = input.nextInt();
    }

}

public class Main {
    static void pressEnterKey(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ======= Press Enter to continue ========");
        scanner.nextLine();
    }
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("--------------- Student System ------------------");
            System.out.println("1. Insert Student to system");
            System.out.println("2. Edit Student information ");
            System.out.println("3. Search Student information");
            System.out.println("4. Delete Student information");
            System.out.println("5. Show Student information ");
            System.out.println("6. Exit");

            String strOption;
            System.out.print("==> Choose option from 1 - 6 : ");
            strOption = input.nextLine();
            try {
                option = Integer.parseInt(strOption);
            } catch (Exception ex) {
                option = 0;
                System.out.println("Invalid Input !!!");
            }


            switch (option) {
                case 1:
                    System.out.println("----------- Add New Student ----------- ");
                    Student newStudents = new Student();
                    newStudents.inputInformation(input);
                    students.add(newStudents);
                    System.out.println("Successfully added.....!");
                    input.nextLine();
                    break;
                case 2 :
                    System.out.println("Edit Information by ID");
                    System.out.println("Enter ID For edit : ");
                    Integer edit  = input.nextInt();
                    boolean check = false;
                    if (students.size()>0){
                        for (Student student:students){
                            if (student.id == edit){
                                System.out.print("Enter id : ");
                                student.id = input.nextInt();
                                System.out.print("Enter name : ");input.nextLine();
                                student.name = input.nextLine();
                                System.out.print("Enter Gender : ");
                                student.gender = input.nextLine();
                                System.out.print("Enter the Classroom :");
                                student.classroom = input.nextLine();

                                System.out.print("Enter Java : ");
                                student.java = input.nextInt();
                                System.out.print("Enter Html : ");
                                student.html = input.nextInt();
                                System.out.print("Enter Git : ");
                                student.git = input.nextInt();
                            }
                        }
                    }

                    break;

                case 3 :
                    int searchOption;
                    System.out.println("************ Search Student ***********");
                    System.out.println("1. Search By ID ");
                    System.out.println("2. Search By Name ");
                    System.out.println("3. Exit....");

                    System.out.print("Choose option 1 - 3 : ");
                    searchOption = input.nextInt();
                    switch(searchOption){
                        case 1 :
                            int searchID;
                            boolean isStudentExist = false;
                            System.out.println("*********** Search By ID *********** ");
                            System.out.println("Enter ID to search : ");
                            searchID = input.nextInt();

                            for(int i = 0; i < students.size(); i++){
                                if(searchID== students.get(i).id){
                                    // Student exist
                                    isStudentExist = true;
                                    students.get(i).outputInformation();
                                }
                            }
                            if(!isStudentExist){
                                System.out.println("Student with ID = "+searchID+" doesn't exist !!!");
                            }
                            pressEnterKey();
                            break;
                        case 2 :
                            System.out.println("----------- Edit Student ------------");
                            String editName;
                        case 3 :
                            System.out.println("*********** Search By Name *********** ");
                            String searchName ;
                            System.out.println("Enter name to search : ");
                            searchName = input.nextLine();

                            for(int i =0; i < students.size(); i++){
                                if(searchName.equals(students.get(i).name)){
                                    // user exist
                                }
                            }
                    }
                    input.nextLine();
                    break;
                case 4 :
                    System.out.println("Delete Student By id");
                    System.out.println("Enter Id Student for delete");
                    Integer delete = input.nextInt();
                    System.out.println(delete);
                    boolean isDelete = false;
                    for (int i = 0; i<students.size(); i++){
                        if (students.get(i).id == delete){
                            students.remove(i);
                            isDelete = true;
                        }
                    }
                    if(!isDelete){
                    System.out.println("Id is not fount");
                }
                    break;
                case 5 :
                    System.out.println("------------- Show Student information ------------- ");
                    for (int i = 0; i < students.size(); i++) {
                        students.get(i).outputInformation();
                    }
                    break;

                case 6:
                    System.out.println("Exit the program...!!");
                    break;
                default:
                    System.out.println("Wrong option !! ");  break;
            }
        } while (option != 6);

    }
}
