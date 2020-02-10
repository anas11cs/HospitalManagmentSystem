/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagmentsystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author DELL
 */
public class Hospital {
    List<Wards> ListOfWards=new ArrayList<Wards>();
    List<TechnicalStaff> ListOfTechnicalStaff=new ArrayList<TechnicalStaff>();
    List<Person> ListOfVisitors=new ArrayList<Person>();
    List<Patient> ListOfPatients=new ArrayList<Patient>();
    void AddVisitor()
    {
                Person visitor=new Person();
                //
                Scanner inp = new Scanner(System.in);
                //
                System.out.println("ADD VISITOR\n");
                                
                System.out.println("Enter Name:");
                visitor.Name=inp.next();
                
                System.out.println("Enter BirthDate\n");
                visitor.BirthDate.setdate();
                
                System.out.println("Enter Gender:");
                visitor.Gender=inp.next().charAt(0);
                
                this.ListOfVisitors.add(visitor);
                
    }
    void AddTechnicalStaff()
    {
                TechnicalStaff techstaff=new TechnicalStaff();
                //
                Scanner inp = new Scanner(System.in);
                //
                System.out.println("ADD TECHNICAL STAFF\n");
                                
                System.out.println("Enter Name:");
                techstaff.Name=inp.next();
                
                System.out.println("Enter BirthDate\n");
                techstaff.BirthDate.setdate();
                
                System.out.println("Enter Gender:");
                techstaff.Gender=inp.next().charAt(0);
                
                System.out.println("Enter Joining Date\n");
                techstaff.JoiningDate.setdate();
                
                System.out.println("Enter Education:");
                techstaff.Education=inp.next();
                
                techstaff.TechId=this.ListOfTechnicalStaff.size();
                     
                this.ListOfTechnicalStaff.add(techstaff);
                
    }
    void AddWard()
    {
        Wards wrd=new Wards();
        Scanner inp = new Scanner(System.in);
        //
        System.out.println("OPEN NEW WARD\n");
                                
        System.out.println("Enter Name:");
        wrd.Name=inp.next();
                
        wrd.Number=this.ListOfWards.size();
        
        this.ListOfWards.add(wrd);
    }
    void AddPatient()
    {
        Scanner inp = new Scanner(System.in);
        // show wards select ward
        // and add that patient there
        
        
                Patient patient=new Patient();
                //
                System.out.println("ADMIT PATIENT\n");
                                
                System.out.println("Enter Name:");
                patient.Name=inp.next();
                
                System.out.println("Enter BirthDate\n");
                patient.BirthDate.setdate();
                
                System.out.println("Enter Gender:");
                patient.Gender=inp.next().charAt(0);
                
                System.out.println("Enter Health Issue:");
                patient.HealthIssue=inp.next();
                
                System.out.println("Enter Date Of Vist:");
                patient.LastVisit.setdate();
                
                patient.PId=this.ListOfPatients.size();
                     
                this.ListOfPatients.add(patient);
        
        
        
        System.out.println("Select the Ward to Admit Patient\n");
        if(this.ListOfWards.size()==0)
        {
            System.out.println("No Wards Available.\n\nOPEN THE WARD TO ADMIT THE PATIENT");
            AddWard();
            System.out.println("\nSelect the Doctor\n");
            for(int j=0;j<this.ListOfWards.get(0).MedicalStaffList.size();j++)
            {
                if(this.ListOfWards.get(0).MedicalStaffList.get(j).TypeDocOrNurse=='D')
                {
                    System.out.println("Specialization :");
                    System.out.println(this.ListOfWards.get(0).MedicalStaffList.get(j).Specialization);
                    System.out.println("\n");
                    System.out.println("Doctor Id:");
                    System.out.println(this.ListOfWards.get(0).MedicalStaffList.get(j).DocNurseId);
                    System.out.println("\n==");
                }
            }
            System.out.println("Enter the Selected Doctor Id:");
            int docid=inp.nextInt();
            this.ListOfWards.get(0).AddPatientInWard(docid,patient.PId);
        }
        else   
        {
            int wardid=0;
            System.out.println("\nSelect the Ward to Admit the Patient\n");
            for(int i=0;i<this.ListOfWards.size();i++)
            {
                System.out.println("Ward Name:");
                System.out.println(this.ListOfWards.get(i).Name);
                System.out.println("\n");
                System.out.println("Ward Number:");
                System.out.println(this.ListOfWards.get(i).Number);
                System.out.println("\n==");
            }
            System.out.println("Enter the Selected Ward Number:");
            inp.nextInt(wardid);
            System.out.println("\nSelect the Doctor\n");
            for(int j=0;j<this.ListOfWards.get(wardid).MedicalStaffList.size();j++)
            {
                if(this.ListOfWards.get(wardid).MedicalStaffList.get(j).TypeDocOrNurse=='D')
                {
                    System.out.println("Specialization :");
                    System.out.println(this.ListOfWards.get(wardid).MedicalStaffList.get(j).Specialization);
                    System.out.println("Doctor Id:");
                    System.out.println(this.ListOfWards.get(wardid).MedicalStaffList.get(j).DocNurseId);
                }
            }
            System.out.println("Enter the Selected Doctor Id:");
            int docid=inp.nextInt();
            this.ListOfWards.get(wardid).AddPatientInWard(docid,patient.PId);
        }
        
    }
    void VisitPatient()
    {
        Scanner inp = new Scanner(System.in);
        System.out.println("\nEnter Patients Id:");
        int Pid=inp.nextInt();
        if (this.ListOfPatients.get(Pid)!=null)
        {
            CompleteDate timenow=new CompleteDate();
            timenow.setdate();
            if(this.ListOfPatients.get(Pid).LastVisit.day==timenow.day&&this.ListOfPatients.get(Pid).LastVisit.month==timenow.month&&this.ListOfPatients.get(Pid).LastVisit.year==timenow.year)
            {
                System.out.println("\nPatient Cannot Visit Twice A Day !\n");
            }
            else
            {
                System.out.println("\nPatient Can Visit!\n");
                this.ListOfPatients.get(Pid).LastVisit.setdate();
            }
        }
        else
        {
            System.out.println("\nAdmit Patient First");
        }
    }
}
