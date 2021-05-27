package com.example.demot5.controller;

import com.example.demot5.entity.Repository.SanphamRepository;
import com.example.demot5.entity.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    SanphamRepository sanphamRepository;
    @RequestMapping("/index")
    public String index()
    {
        return "index";
    }
    @RequestMapping("/admin2")
    public String admin2(Model model)
    {
        List<SanPham> ds = sanphamRepository.laydanhsachSP();
        model.addAttribute("dsSanPham",ds);
        return "admin2";
    }
}
