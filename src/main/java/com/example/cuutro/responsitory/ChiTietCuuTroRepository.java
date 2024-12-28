package com.example.cuutro.responsitory;

import com.example.cuutro.dto.response.SearchCuuTroDetail;
import com.example.cuutro.entity.ChiTietCuuTro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChiTietCuuTroRepository extends JpaRepository<ChiTietCuuTro, Long> {

    @Query("SELECT new com.example.cuutro.dto.response.SearchCuuTroDetail(s.maSV, s.hoTen, " +
            "detail.truong.tenTruong, detail.dotCuuTro.maDotCuuTro, detail.dotCuuTro.khauHieu, " +
            "detail.ngayCuuTro, detail.deXuatCaiThien) " +
            "FROM SinhVien s " +
            "LEFT JOIN s.chiTietCuuTros detail " +
            "WHERE CONCAT(s.maSV, s.hoTen, detail.truong.tenTruong, detail.dotCuuTro.maDotCuuTro, " +
            "detail.ngayCuuTro) LIKE %:keyword%")
  public List<SearchCuuTroDetail> findInfoDetail(@Param("keyword") String keyword);
}
