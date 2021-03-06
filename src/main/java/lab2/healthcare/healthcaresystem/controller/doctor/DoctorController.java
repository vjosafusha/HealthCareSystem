package lab2.healthcare.healthcaresystem.controller.doctor;

import lab2.healthcare.healthcaresystem.models.Doctor;
import lab2.healthcare.healthcaresystem.models.Patient;
import lab2.healthcare.healthcaresystem.service.DoctorService;
import lab2.healthcare.healthcaresystem.service.DoctorServiceImpl;
import lab2.healthcare.healthcaresystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller

public class DoctorController {


    @Autowired
    private DoctorService doctorService;



    @RequestMapping("/doctorData")
    public String doctorData(Model model) {

        Doctor doctor = doctorService.currentDoctor();
        if(doctor==null) {
            doctor=new Doctor();
            model.addAttribute("doctor", doctor);
        }else{
            model.addAttribute("doctor",doctor);
        }
        return "doctor/doctor-data";
    }

    @RequestMapping(value = {"/registerDoctorData"}, method = RequestMethod.POST)
    public String insertPatientData(@ModelAttribute("doctor") Doctor doctor) {
        doctorService.saveDoctorData(doctor);
        return "doctor/doctor";
    }







}
