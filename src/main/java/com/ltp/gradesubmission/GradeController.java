package com.ltp.gradesubmission;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GradeController {

    List<Grade>li=new ArrayList<Grade>();
    @GetMapping("/")
    public String getGrade(Model model){
        model.addAttribute("grades",li);
        return "grades";
    }
    @GetMapping("/form")
    public String getForm(Model model,@RequestParam(required = false) String id){
        Grade grade;
        if(find(id)==Constant.NOT_FOUND){
             grade=new Grade();
        }
        else{
            grade=li.get(find(id));
        }
        model.addAttribute("form",grade);
        return "form";
    }
    @PostMapping("/handle")
    public String handleSubmit(@Valid Grade grade, BindingResult result){
        System.out.println("Has Any errors?"+result.hasErrors());
        if(result.hasErrors()){
            return "form";
        }
        int index=find(grade.getId());
        if (index==Constant.NOT_FOUND) {
            li.add(grade);
        }
        else{
            li.set(index,grade);
        }
         return "redirect:/";
    }

    public Integer find(String id){
        for(int i=0;i< li.size();i++){
            if(li.get(i).getId().equals(id)) {
                return i;
            }
        }
        return Constant.NOT_FOUND;
    }
}