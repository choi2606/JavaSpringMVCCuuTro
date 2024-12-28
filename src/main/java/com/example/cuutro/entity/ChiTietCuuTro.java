package com.example.cuutro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "chi_tiet_cuu_tro")
public class ChiTietCuuTro {
    @Id
    @JoinColumn(name = "masv")
    private Long maSV;

    @ManyToOne
    @JoinColumn(name = "masv", referencedColumnName = "masv",insertable = false, updatable = false)
    private SinhVien sinhVien;

    @ManyToOne
    @JoinColumn(name = "ma_truong")
    private Truong truong;

    @ManyToOne
    @JoinColumn(name = "ma_dot_cuu_tro")
    private DotCuuTro dotCuuTro;

    @Column(name = "ngay_cuu_tro")
    private LocalDate ngayCuuTro;

    @Column(name = "de_xuat_cai_thien")
    private String deXuatCaiThien;
}
