package com.example.cuutro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "truong")
public class Truong {

    @Id
    @Column(name = "ma_truong")
    private String maTruong;
    @Column(name = "ten_truong")
    private String tenTruong;
    @Column(name = "dia_chi")
    private String diaChi;
    @Column(name = "so_dien_thoai")
    private String soDT;

    @OneToMany(mappedBy = "truong")
    List<ChiTietCuuTro> chiTietCuuTros;
}
