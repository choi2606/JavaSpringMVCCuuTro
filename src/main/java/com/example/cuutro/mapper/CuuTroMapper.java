package com.example.cuutro.mapper;

import com.example.cuutro.dto.response.DotCuuTroResponse;
import com.example.cuutro.dto.response.TruongResponse;
import com.example.cuutro.entity.DotCuuTro;
import com.example.cuutro.entity.Truong;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CuuTroMapper {
    TruongResponse toTruongResponse(Truong truong);
    DotCuuTroResponse toDotCuuTroResponse(DotCuuTro dotCuuTro);
}
