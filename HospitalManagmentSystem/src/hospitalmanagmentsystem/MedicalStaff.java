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
public class MedicalStaff extends Staff{
    int DocNurseId;
    String Specialization;
    List<Integer> PatientsIdList=new ArrayList<Integer>();
    char TypeDocOrNurse;
    void AddPatient(int PatientsId)
    {
        this.PatientsIdList.add(PatientsId);
    }
}
