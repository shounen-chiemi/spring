package com.example.demot5.entity.Repository;

import com.example.demot5.entity.ThanhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


public interface ThanhvienRepository extends JpaRepository<ThanhVien, Integer> {
    @Query(value = "select * from thanhvien where taikhoan = ?1 and matkhau = ?2", nativeQuery = true)
    public ThanhVien KiemTraDangNhap(String tk, String mk);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Thanhvien(taikhoan,matkhau,chucvu,ten,sdt,email,diachi) VALUES(?1,?2,?3,?4,?5,?6,?7)",nativeQuery = true)
    public void themSP(String taikhoan, String matkhau,String chucvu,String ten, String sdt, String email,String diachi);
}
