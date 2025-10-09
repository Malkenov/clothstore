package com.example.clothstore.clothstore.controller;

import com.example.clothstore.clothstore.entity.Option;
import com.example.clothstore.clothstore.entity.Product;
import com.example.clothstore.clothstore.service.OptionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/options")
public class OptionController {

    private final OptionService optionService;

    public OptionController(OptionService optionService){
        this.optionService = optionService;
    }

    @GetMapping("/{id}")
    public Option getById(Long id){
        return optionService.getById(id);
    }

    @PostMapping("/add-option")
    public Option postOption(
            @RequestBody Option option,
            @PathVariable Long id,
            @PathVariable List<Long> value_id){
        return optionService.addOption(option,id,value_id);
    }

    @DeleteMapping("/{delete-id}")
    public void deleteOption(Long id){
        optionService.deleteOption(id);
    }
}
