package com.monopoco.arcade.repository;

import com.monopoco.arcade.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface ImageStorageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByName(String imageName);

}
