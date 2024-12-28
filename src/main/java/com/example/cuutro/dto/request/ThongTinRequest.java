package com.example.cuutro.dto.request;

import com.example.cuutro.entity.DotCuuTro;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ThongTinRequest {
    @NotNull(message = "Mã sinh viên không được để trống")
    private Long maSV;
    @NotBlank(message = "Họ tên không được để trống")
    private String hoTen;
    private String sdt;
    private String email;
    @NotBlank(message = "Mã trường không được để trống")
    private String maTruong;
    @NotNull(message = "Mã đợt cứu trợ không được để trống")
    private Long maDotCuuTro;
    @NotNull(message = "Ngày cứu trợ không được chọn")
    @Past(message = "Ngày cứu trợ phải nhỏ hơn ngày hiện tại, vui lòng nhập lại")
    private LocalDate ngayCuuTro;
    private String deXuatCaiThien;
}
