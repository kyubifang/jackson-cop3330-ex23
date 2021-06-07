/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Jamar Jackson
 */

package base;

import java.util.Scanner;

/*
Exercise 23 - Troubleshooting Car Issues

An expert system is a type of artificial intelligence program that uses a knowledge base and a set of rules to perform a task that a human expert might do. Many websites are available that will help you self-diagnose a medical issue by answering a series of questions. And many hardware and software companies offer online troubleshooting tools to help people solve simple technical issues before calling a human.

Create a program that walks the user through troubleshooting issues with a car. Use the following decision tree to build the system:

@startuml
if (Is the car silent when you turn the key?) then (yes)
    if (Are the battery terminals corroded?) then (yes)
        :Clean terminals and try starting again.;
        stop
    else (no)
        :Replace cables and try again.;
        stop
    endif
else (no)
    if (Does the car make a slicking noise?) then (yes)
        :Replace the battery.;
        stop
    else (no)
        if (Does the car crank up but fail to start?) then (yes)
            :Check spark plug connections.;
            stop
        else (no)
            if (Does the engine start and then die?) then (yes)
                if (Does you car have fuel injection?) then (yes)
                    :Get it in for service.;
                    stop
                else (no)
                    :Check to ensure the choke is opening and closing.;
                    stop
                endif
            else (no)
                :This should not be possible.;
                stop
            endif
        endif
    endif
endif
@enduml

Example Output

Is the car silent when you turn the key? y
Are the battery terminals corroded? n
Replace cables and try again.

Constraint

Ask only questions that are relevant to the situation and to the previous answers. Don’t ask for all inputs at once.
Challenge

Investigate rules engines and inference engines. These are powerful ways to solve complex problems that are based on rules and facts. Identify a rules engine for your programming language and use it to solve this problem
 */
public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();
        String help = myApp.listOfQuestions();
        String outputString = myApp.generateOutputString(help);
        myApp.printOutput(outputString);
    }

    public void printOutput(String outputString) {
        System.out.println(outputString);
    }

    public String listOfQuestions() {
        System.out.println("Is the car silent when you turn the key? ");
        String choice = in.nextLine();

        if(choice.equals("y")){
            System.out.println("Are the battery terminals corroded? ");
            choice = in.nextLine();
            if(choice.equals("y")){
                choice = "Clean terminals and try starting again.";
            }else{
                choice = "Replace cables and try again.";
            }
        }else{
            System.out.println("Does the car make a slicking noise? ");
            choice = in.nextLine();
            if(choice.equals("y")){
                choice = "Replace the battery.";
            }else{
                System.out.println("Does the car crank up but fail to start? ");
                choice = in.nextLine();
                if(choice.equals("y")){
                    choice = "Check spark plug connections.";
                }else{
                    System.out.println("Does the engine start and then die? ");
                    choice = in.nextLine();
                    if(choice.equals("y")){
                        System.out.println("Does your car have fuel injection? ");
                        choice = in.nextLine();
                        if(choice.equals("y")){
                            choice = "Get in for service.";
                        }else{
                            choice = "Check to ensure the choke is opening and closing.";
                        }
                    }else{
                        choice = "This should not be possible.";
                    }
                }
            }
        }
        return choice;
    }

    public String generateOutputString(String help) {
        return help;
    }
}
