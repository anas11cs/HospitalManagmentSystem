/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hospitalmanagmentsystem;
import java.util.Scanner;
/**
 *
 * @author DELL
 */
public class CompleteDate {
    int day;
    int month;
    int year;
    void setdate(){
                Scanner inp = new Scanner(System.in);
                System.out.println("Enter Day[Number]:");
                inp.nextInt(this.day);
                System.out.println("Enter Month(e.g Enter Month:2 for feb):");
                inp.nextInt(this.month);
                System.out.println("Enter year:");
                inp.nextInt(this.year);
    }
    
}
