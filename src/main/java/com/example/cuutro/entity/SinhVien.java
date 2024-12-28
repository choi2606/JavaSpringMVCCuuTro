package com.example.cuutro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "sinh_vien")
public class SinhVien {
    @Id
    @Column(name = "masv")
    private Long maSV;
    @Column(name = "ho_ten")
    private String hoTen;
    @Column(name = "sdt")
    private String sdt;
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "sinhVien")
    List<ChiTietCuuTro> chiTietCuuTros;

}
