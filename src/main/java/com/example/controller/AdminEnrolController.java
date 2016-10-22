package com.example.controller;

import com.example.domain.StuUnit;
import com.example.domain.Student;
import com.example.domain.Unit;
import com.example.repository.ProgramRepository;
import com.example.repository.StudentRepository;
import com.example.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin/enrol")
public class AdminEnrolController {

    @Autowired
    private UnitRepository unitRepo;
    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private ProgramRepository programRepo;

    private Student pathStudent;
    private int unitLimt;

    @RequestMapping(value="", method= RequestMethod.GET)
    public String listStudents(Model model){
        model.addAttribute("students", studentRepo.findAll());
        return "admin/enrol/list";
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public ModelAndView update(@RequestParam("student_id") long studentId,
                               @RequestParam("unit") String unitStr){
        this.pathStudent = studentRepo.findOne(studentId);
        String[] unitStrs = unitStr.split(":");
        long unitId = Long.parseLong(unitStrs[0]);

        Unit unit = unitRepo.findOne(unitId);
        StuUnit stuunit = new StuUnit(this.pathStudent, unit);

        this.unitLimt = programRepo.findByName(this.pathStudent.getProgram()).getUnitLimit();
        if(this.pathStudent.getStuunits().size() < this.unitLimt){

            this.pathStudent.getStuunits().add(stuunit);
            unitRepo.save(unit);
            studentRepo.save(this.pathStudent);

            return new ModelAndView("redirect:/admin/enrol/result");
        }
        else{

            return new ModelAndView("redirect:/admin/enrol/overlimit");
        }

    }

    @RequestMapping(value="/{id}/edit", method=RequestMethod.GET)
    public String edit(@PathVariable long id,
                       Model model){
        this.pathStudent = studentRepo.findOne(id);
        Set<Unit> units = unitRepo.findByProgram(this.pathStudent.getProgram());
        Set<Unit> selectedUnits = new HashSet<Unit>();
        for(StuUnit stuunit : this.pathStudent.getStuunits()){
            selectedUnits.add(stuunit.getUnit());
        }
        units.removeAll(selectedUnits);

        model.addAttribute("student", this.pathStudent);
        model.addAttribute("stuunits", this.pathStudent.getStuunits());
        model.addAttribute("units", units);
        return "admin/enrol/edit";
    }

    @RequestMapping(value="/result", method=RequestMethod.GET)
    public String result(Model model){

        model.addAttribute("student", this.pathStudent);
        model.addAttribute("stuunits", this.pathStudent.getStuunits());
        return "admin/enrol/result";
    }

    @RequestMapping(value="/overLimit", method=RequestMethod.GET)
    public String overLimit(Model model){

        model.addAttribute("unitLimit", this.unitLimt);
        return "admin/enrol/overlimit";
    }
}
