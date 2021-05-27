package com.example.demot5.controller;

import com.example.demot5.entity.Repository.SanphamRepository;
import com.example.demot5.entity.SanPham;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;

@EnableScheduling
@EnableAsync
@Controller
public class SanphamController {
    @Autowired
    SanphamRepository sanphamRepository;

    @RequestMapping("xoaSP")
    public String xoaSP(HttpServletRequest request, Model model)
    {
        String id = request.getParameter("txtID");
        SanPham sp = new SanPham();
        sp = sanphamRepository.laySPtheoID(Integer.parseInt(id));
//        sanphamRepository.XoaSP(Integer.parseInt(id));
        sanphamRepository.delete(sp);
        model.addAttribute("thongbao","xóa thành công");
        return "thongbaoSanpham";
    }
    @RequestMapping("suaSP")
    public String suaSP(HttpServletRequest request, MultipartFile fileImage, Model model, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String tenSP,giatien,theloai,linkHA;
        tenSP = request.getParameter("txt_TenSP");
        giatien = request.getParameter("txt_Giatien");
        theloai = request.getParameter("txt_Theloai");
        Part filePart = request.getPart("txt_HA");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String s = "C:\\Users\\Hiep Le\\Desktop\\qldt\\demot5\\src\\main\\resources\\static\\img";
        String appPath = s.replace('\\', '/');

        String id = request.getParameter("txt_Id");
        int idSP = Integer.parseInt(id);

        SanPham sp = new SanPham();
        sp.setId(idSP);
        sp.setTenSP(tenSP);
        sp.setGia(Integer.parseInt(giatien));
        sp.setTheloai(theloai);
        sp.setLinkHA("img/" + fileName);

        sanphamRepository.save(sp);
//        File file = new File(appPath + "\\" + fileName);
//        if(file.exists())
//        {
//            file.mkdirs();
//        }
//        String name = fileImage.getOriginalFilename();
//        String filePath = filePart.getSubmittedFileName();
//        fileImage.transferTo(new File(filePath));
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        try{
            File file = new File(appPath + "\\" + fileName);
            if(file.exists())
                file.mkdirs();
            InputStream filez = filePart.getInputStream();
            bis = new BufferedInputStream(filez);
            fos = new FileOutputStream(file);
            BufferedOutputStream bout = new BufferedOutputStream(fos,1024);
            byte[] data = new byte[1024];
            int read = 0;
            while((read = bis.read(data,0,1024))>=0)
            {
                bout.write(data, 0, read);
            }
            bout.close();
            bis.close();
            fos.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        model.addAttribute("thongbao","sửa thành công");
        return "thongbaoSanpham";
    }
    @RequestMapping("themSP")
    public String themSP(HttpServletRequest request, Model model,MultipartFile fileImage, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String tenSP,giatien,theloai,linkHA;
        tenSP = request.getParameter("txt_TenSP");
        giatien = request.getParameter("txt_Giatien");
        theloai = request.getParameter("txt_Theloai");
        Part filePart = request.getPart("txt_HA");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String s = "C:\\Users\\Hiep Le\\Desktop\\qldt\\demot5\\src\\main\\resources\\static\\img";
        String appPath = s.replace('\\', '/');

        SanPham sp = new SanPham();
        sp.setTenSP(tenSP);
        sp.setGia(Integer.parseInt(giatien));
        sp.setTheloai(theloai);
        sp.setLinkHA("img/" + fileName);

        sanphamRepository.themSP(sp.getTenSP(),sp.getGia(),sp.getTheloai(),sp.getLinkHA(),0);

        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        try{
            File file = new File(appPath + "\\" + fileName);
            if(file.exists())
                file.mkdirs();
            InputStream filez = filePart.getInputStream();
            bis = new BufferedInputStream(filez);
            fos = new FileOutputStream(file);
            BufferedOutputStream bout = new BufferedOutputStream(fos,1024);
            byte[] data = new byte[1024];
            int read = 0;
            while((read = bis.read(data,0,1024))>=0)
            {
                bout.write(data, 0, read);
            }
            bout.close();
            bis.close();
            fos.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        model.addAttribute("thongbao","thêm thành công");
        return "thongbaoSanpham";
    }
}
