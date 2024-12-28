package com.example.cuutro.service;

import com.example.cuutro.dto.request.ThongTinRequest;
import com.example.cuutro.dto.response.DotCuuTroResponse;
import com.example.cuutro.dto.response.SearchCuuTroDetail;
import com.example.cuutro.dto.response.TruongResponse;
import com.example.cuutro.entity.ChiTietCuuTro;
import com.example.cuutro.entity.DotCuuTro;
import com.example.cuutro.entity.SinhVien;
import com.example.cuutro.entity.Truong;
import com.example.cuutro.mapper.CuuTroMapper;
import com.example.cuutro.responsitory.ChiTietCuuTroRepository;
import com.example.cuutro.responsitory.DotCuuTroRepository;
import com.example.cuutro.responsitory.SinhVienRepository;
import com.example.cuutro.responsitory.TruongRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CuuTroService {
    TruongRepository truongRepository;
    DotCuuTroRepository dotCuuTroRepository;
    CuuTroMapper cuuTroMapper;
    SinhVienRepository sinhVienRepository;
    ChiTietCuuTroRepository chiTietCuuTroRepository;

    public List<TruongResponse> getTruongs() {
        List<Truong> truongs = truongRepository.findAll();
        return truongs.stream().map(cuuTroMapper::toTruongResponse).collect(Collectors.toList());
    }

    public List<DotCuuTroResponse> getDotCuuTros() {
        List<DotCuuTro> dotCuuTros = dotCuuTroRepository.findAll();
        return dotCuuTros.stream().map(cuuTroMapper::toDotCuuTroResponse).collect(Collectors.toList());
    }

    public void saveCuuTro(ThongTinRequest request) {
        DotCuuTro dotCuuTro = dotCuuTroRepository.findById(request.getMaDotCuuTro()).orElseThrow(() -> new RuntimeException("Mã Đợt Cứu Trợ Không Tìm Thấy"));
        Truong truong = truongRepository.findById(request.getMaTruong()).orElseThrow(() -> new RuntimeException("Mã Trường Không Tìm Thấy"));
        SinhVien sinhVien = SinhVien.builder()
                .maSV(request.getMaSV())
                .email(request.getEmail())
                .hoTen(request.getHoTen())
                .sdt(request.getSdt())
                .build();
        ChiTietCuuTro chiTietCuuTro = ChiTietCuuTro.builder()
                .maSV(request.getMaSV())
                .truong(truong)
                .dotCuuTro(dotCuuTro)
                .ngayCuuTro(request.getNgayCuuTro())
                .deXuatCaiThien(request.getDeXuatCaiThien())
                .build();

        sinhVienRepository.save(sinhVien);
        chiTietCuuTroRepository.save(chiTietCuuTro);
    }

    public List<SearchCuuTroDetail> findInfoDetail(String keyword) {
        if(keyword != null)
            return chiTietCuuTroRepository.findInfoDetail(keyword);
        return chiTietCuuTroRepository.findInfoDetail("1");
    }

    public void deleteInfo(Long maSV) {
        chiTietCuuTroRepository.deleteById(maSV);
        sinhVienRepository.deleteById(maSV);
    }
}
