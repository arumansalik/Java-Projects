import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

class AttendanceRecord {
    Integer rollNo;
    Date date;
    boolean present;

    public AttendanceRecord(Integer rollNo, Date date, boolean present) {
        this.rollNo = rollNo;
        this.date = date;
        this.present = present;
    }

    @Override
    public String toString() {
        return "Roll No: " + rollNo + ", Date: " + date + ", Present: " + (present ? "Yes" : "No");
    }
}


public class SimpleAttendanceSystem {
    public static void main(String[] args) {
        ArrayList<AttendanceRecord> attendanceList = new ArrayList<>();
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        studentMap.put(01, "Aameer Moahmmed");
        studentMap.put(02, "AbiShek");
        studentMap.put(03, "Abitha Lakshmi");
        studentMap.put(04, "Ajith");
        studentMap.put(05, "Aruman Salik");


        while (true) {
            System.out.println("\nAttendance System Menu:");
            System.out.println("1. Mark Attendance");
            System.out.println("2. View Attendance");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    markAttendance(attendanceList,studentMap ,sc);
                    break;
                case 2:
                    viewAttendance(attendanceList, studentMap);
                    break;
                case 3:
                    System.out.println("Exiting..");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Choice. Please try again..");
            }
        }
    }

    public static void markAttendance(ArrayList<AttendanceRecord> attendanceList, HashMap<Integer, String> studentMap,Scanner sc) {
        System.out.println("Enter the student roll number: ");
        Integer rollNo = sc.nextInt();
        sc.nextLine();

        if(!studentMap.containsKey(rollNo)) {
            System.out.println("Roll Number Not Found....");
            return;
        }

        System.out.println("Is the Student present? (yes/no): ");
        String presence = sc.nextLine().toLowerCase();

        boolean isPresent = presence.equals("yes");
        Date currentDate = new Date();

        AttendanceRecord record = new AttendanceRecord(rollNo, currentDate, isPresent);
        attendanceList.add(record);

        System.out.println("Attendance marked successfully.");
    }

    public static void viewAttendance(ArrayList<AttendanceRecord> attendanceList, HashMap<Integer, String> studentMap) {
        if(attendanceList.isEmpty()) {
            System.out.println("No attendance records found....");
            return;
        }

        System.out.println("\nAttendance Records:");
        for(AttendanceRecord record: attendanceList) {
            String studentName = studentMap.get(record.rollNo);
            if (studentName != null) {
                System.out.println("Name: " + studentName + "(22CS" + record.rollNo + ") , Date: " + record.date + ", Present: " + (record.present ? "Yes" : "No"));
            } else {
                System.out.println(record);
            }
        }
    }
}
