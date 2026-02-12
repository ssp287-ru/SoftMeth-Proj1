package project1;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 This class is the user interface for the registration system.
 It reads command lines from the terminal and dispatches them for processing.
 @author Lucas Barrales, Shivang Patel
 */
public class Frontend {

    private static final String MSG_RUNNING = "Registration System is running.";
    private static final String MSG_TERMINATED = "Registration System is terminated.";
    private static final String MSG_INVALID = "Invalid command.";

    /**
     Run the registration system by continuously reading and processing commands.
     The system terminates when the user enters the Q command.
     */
    public void run() {
        System.out.println(MSG_RUNNING);

        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            String line = readNonNullLine(scanner);
            if (line == null) {
                break; // end of input stream
            }
            keepRunning = processLine(line);
        }

        System.out.println(MSG_TERMINATED);
        scanner.close();
    }

    /**
     Read one line from the scanner and return it.
     @param scanner the scanner reading from System.in.
     @return the line read from input; return null if there is no more input.
     */
    private String readNonNullLine(Scanner scanner) {
        if (!scanner.hasNextLine()) {
            return null;
        }
        return scanner.nextLine();
    }

    /**
     Process one command line entered by the user.
     Empty lines are ignored.
     @param line the command line from the terminal.
     @return false if the command is Q; true otherwise.
     */
    private boolean processLine(String line) {
        String trimmed = line.trim();
        if (trimmed.length() == 0) {
            return true; // ignore empty line
        }

        StringTokenizer tokens = new StringTokenizer(trimmed);
        String command = tokens.nextToken();

        if (command.equals("Q")) {
            return false;
        }

        handleCommand(command, tokens);
        return true;
    }

    /**
     Dispatch the command to the correct handler.
     This starter version only acknowledges commands.
     @param command the command token (case-sensitive).
     @param tokens the remaining tokens after the command.
     */
    private void handleCommand(String command, StringTokenizer tokens) {
        if (command.equals("A")) {
            handleAdd(tokens);
            return;
        }
        if (command.equals("R")) {
            handleRemove(tokens);
            return;
        }
        if (command.equals("O")) {
            handleOpenSection(tokens);
            return;
        }
        if (command.equals("C")) {
            handleCloseSection(tokens);
            return;
        }
        if (command.equals("E")) {
            handleEnroll(tokens);
            return;
        }
        if (command.equals("D")) {
            handleDrop(tokens);
            return;
        }
        if (command.equals("PS")) {
            handlePrintStudents();
            return;
        }
        if (command.equals("PL")) {
            handlePrintScheduleByLocation();
            return;
        }
        if (command.equals("PC")) {
            handlePrintScheduleByCourse();
            return;
        }

        System.out.println(MSG_INVALID);
    }

    /**
     Handle the A command to add a student.
     @param tokens the remaining tokens after the command.
     */
    private void handleAdd(StringTokenizer tokens) {
        System.out.println("Add command received.");
    }

    /**
     Handle the R command to remove a student.
     @param tokens the remaining tokens after the command.
     */
    private void handleRemove(StringTokenizer tokens) {
        System.out.println("Remove command received.");
    }

    /**
     Handle the O command to open a new course section.
     @param tokens the remaining tokens after the command.
     */
    private void handleOpenSection(StringTokenizer tokens) {
        System.out.println("Offer section command received.");
    }

    /**
     Handle the C command to close an existing course section.
     @param tokens the remaining tokens after the command.
     */
    private void handleCloseSection(StringTokenizer tokens) {
        System.out.println("Close section command received.");
    }

    /**
     Handle the E command to enroll a student in a section.
     @param tokens the remaining tokens after the command.
     */
    private void handleEnroll(StringTokenizer tokens) {
        System.out.println("Enroll command received.");
    }

    /**
     Handle the D command to drop a student from a section.
     @param tokens the remaining tokens after the command.
     */
    private void handleDrop(StringTokenizer tokens) {
        System.out.println("Drop command received.");
    }

    /**
     Handle the PS command to print students sorted by last name, first name, then DOB.
     */
    private void handlePrintStudents() {
        System.out.println("Print students command received.");
    }

    /**
     Handle the PL command to print schedule sorted by campus, then building.
     */
    private void handlePrintScheduleByLocation() {
        System.out.println("Print schedule by location command received.");
    }

    /**
     Handle the PC command to print schedule sorted by course number, then period.
     */
    private void handlePrintScheduleByCourse() {
        System.out.println("Print schedule by course command received.");
    }
}
