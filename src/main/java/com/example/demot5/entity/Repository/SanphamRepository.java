package com.example.demot5.entity.Repository;

import com.example.demot5.entity.SanPham;
import com.example.demot5.entity.ThanhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface SanphamRepository extends JpaRepository<SanPham,Integer> {
    @Query(value = "select * from sanpham", nativeQuery = true)
    public List<SanPham> laydanhsachSP();

    @Query(value = "delete from sanpham where id = ?1", nativeQuery = true)
    public void XoaSP(int id);

    @Query(value = "select *  from sanpham where id = ?1", nativeQuery = true)
    public SanPham laySPtheoID(int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Sanpham(tenSP,gia,theloai,linkHA,luotmua) VALUES(?1,?2,?3,?4,?5)",nativeQuery = true)
    public void themSP(String tenSP,int gia, String theloai, String linkHA,int luotmua);


}
