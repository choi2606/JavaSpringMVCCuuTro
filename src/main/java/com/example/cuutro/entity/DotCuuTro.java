package com.example.cuutro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dot_cuu_tro")
public class DotCuuTro {
    @Id
    @Column(name = "ma_dot_cuu_tro")
    public Long maDotCuuTro;
    @Column(name = "khau_hieu")
    public String khauHieu;
    @Column(name = "ngay_bat_dau")
    public LocalDate ngayBatDau;
    @Column(name = "ngay_ket_thuc")
    public LocalDate ngayKetThuc;

    @OneToMany(mappedBy = "dotCuuTro")
    List<ChiTietCuuTro> chiTietCuuTros;
}
