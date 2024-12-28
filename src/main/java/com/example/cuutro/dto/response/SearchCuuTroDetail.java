package com.example.cuutro.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class SearchCuuTroDetail {
    private Long maSV;
    private String hoTen;
    private String tenTruong;
    private Long maDotCuuTro;
    private String khauHieu;
    private LocalDate ngayCuuTro;
    private String deXuatCaiThien;
}
