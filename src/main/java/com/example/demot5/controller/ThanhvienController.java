package com.example.demot5.controller;

import com.example.demot5.entity.Repository.SanphamRepository;
import com.example.demot5.entity.Repository.ThanhvienRepository;
import com.example.demot5.entity.SanPham;
import com.example.demot5.entity.ThanhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@Controller
public class ThanhvienController {
    @Autowired
    ThanhvienRepository thanhvienRepository;
    @Autowired
    SanphamRepository sanphamRepository;
    @RequestMapping("dangnhap")
    public String dangnhap(HttpServletRequest request, Model model)
    {
        String taikhoan = request.getParameter("txtU");
        String matkhau = request.getParameter("txtP");
        ThanhVien tv = new ThanhVien();
        tv = thanhvienRepository.KiemTraDangNhap(taikhoan,matkhau);
        if(tv.getChucvu().equals("admin"))
        {
            List<SanPham>  ds = sanphamRepository.laydanhsachSP();
            model.addAttribute("dsSanPham",ds);

            return "admin2";
        }
        else
        {
            model.addAttribute("thongbao","notok");
            return "thongbaoDangnhap";
        }

    }

    @RequestMapping("dangky")
    public String dangky(HttpServletRequest request, HttpServletResponse response,Model model)
    {
        String taikhoan = request.getParameter("txtU");
        String matkhau = request.getParameter("txtP");
        String sdt = request.getParameter("txtS");
        String email = request.getParameter("txtE");
        String diachi = request.getParameter("txtD");
        String chucvu = "admin";
        String ten = request.getParameter("txtT");

        thanhvienRepository.themSP(taikhoan,matkhau,chucvu,ten,sdt,email,diachi);
        model.addAttribute("thongbao","Đăng ký thành công");
        return "thongbaoDangnhap";
    }
}
