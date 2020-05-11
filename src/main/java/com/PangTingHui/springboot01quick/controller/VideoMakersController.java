package com.PangTingHui.springboot01quick.controller;

import com.PangTingHui.springboot01quick.Service.IikesService;
import com.PangTingHui.springboot01quick.Task.VideoProcessor;
import com.PangTingHui.springboot01quick.Task.WebMagicData;
import com.PangTingHui.springboot01quick.entities.VideoMakers;
import com.PangTingHui.springboot01quick.mapper.VideoMakerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VideoMakersController {

    @Autowired
    VideoMakerMapper videoMakerMapper;

    @Autowired
    IikesService iikesServiceImp;

    @Autowired
    VideoProcessor videoProcessor;

    @Autowired
    WebMagicData webMagicData;
    @GetMapping("/emps")
    public String list(Model model){
        List<VideoMakers> all = iikesServiceImp.findAll();
        model.addAttribute("emps", all);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        List<VideoMakers> all = iikesServiceImp.findAll();
        model.addAttribute("emps", all);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(VideoMakers videoMakers){
        iikesServiceImp.save(videoMakers);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        VideoMakers byID = videoMakerMapper.getByID(id);
        videoProcessor.setS(byID.getUid().toString());
        webMagicData.r(id);
        videoProcessor.process();
        model.addAttribute("emp",byID);
        return "redirect:/emps";
    }

    @PutMapping("/emp")
    public String updateEmployee(VideoMakers videoMakers){
        videoMakerMapper.updateVM(videoMakers);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        videoMakerMapper.deleteById(id);
        return "redirect:/emps";
    }
}
