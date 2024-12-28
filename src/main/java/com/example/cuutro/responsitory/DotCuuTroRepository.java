package com.example.cuutro.responsitory;

import com.example.cuutro.entity.DotCuuTro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DotCuuTroRepository extends JpaRepository<DotCuuTro, Long> {
}
