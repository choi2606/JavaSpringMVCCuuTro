package com.example.cuutro.responsitory;

import com.example.cuutro.entity.Truong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruongRepository extends JpaRepository<Truong, String> {
}
