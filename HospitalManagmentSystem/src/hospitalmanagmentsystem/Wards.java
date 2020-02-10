/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagmentsystem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author DELL
 */
public class Wards {
    String Name;
    int Number;
    List<MedicalStaff> MedicalStaffList=new ArrayList<MedicalStaff>();
    void AddMedicalStaff()
    {
                MedicalStaff mdc=new MedicalStaff();
                //
                Scanner inp = new Scanner(System.in);
                //
                System.out.println("ADD MEDICAL STAFF\n");
                                
                System.out.println("Enter Name:");
                mdc.Name=inp.next();
                
                System.out.println("Enter BirthDate\n");
                mdc.BirthDate.setdate();
                
                System.out.println("Enter Gender:");
                mdc.Gender=inp.next().charAt(0);
                
                System.out.println("Enter Joining Date\n");
                mdc.JoiningDate.setdate();
                
                System.out.println("Enter Education:");
                mdc.Education=inp.next();
                
                System.out.println("Enter Specialization:");
                mdc.Specialization=inp.next();
                
                System.out.println("Enter Specialization:");
                mdc.Specialization=inp.next();
                
                System.out.println("Enter 'D' for Doctor & 'N' for Nurse:");
                mdc.TypeDocOrNurse=inp.next().charAt(0);
                

                mdc.DocNurseId=this.MedicalStaffList.size();
                
                mdc.PatientsIdList=null;
                
                this.MedicalStaffList.add(mdc);
                
    }
    void AddPatientInWard(int DocId,int PId)
    {
        this.MedicalStaffList.get(DocId).PatientsIdList.add(PId);
    }
}
