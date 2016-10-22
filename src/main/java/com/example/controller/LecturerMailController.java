package com.example.controller;

import com.example.SmtpMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;

/**
 * Created by kk on 22/10/2016.
 */

@Controller
@RequestMapping("/lecturer/mail")
public class LecturerMailController {
    @Autowired
    private SmtpMailSender smtpMailSender;

    @RequestMapping(value="", method= RequestMethod.GET)
    public String listMail(){
        return "lecturer/mail/list";
    }

    //    send mail
    @RequestMapping(value="/sendmail", method=RequestMethod.GET)
    public String sendMail(){
        return "lecturer/mail/sendmail";
    }

    @RequestMapping(value="/send", method=RequestMethod.POST)
    public String create(@RequestParam("title") String title,
                         @RequestParam("content") String content) throws MessagingException {

//        long course_id;

// send email to all students enrolled in course by course_id
//        Unit unit = unitRepository.findOne(course_id);
//        Set<StuUnit> stuUnitSet = unit.getStuunits();
//        for(StuUnit p: stuUnitSet){
//            String emailAdress = p.getStudent().getEmail();
//            smtpMailSender.send(emailAdress,title,content);

        smtpMailSender.send("sherry9218@gmail.com", title, content);
        return "lecturer/mail/sendmail";
    }

}
