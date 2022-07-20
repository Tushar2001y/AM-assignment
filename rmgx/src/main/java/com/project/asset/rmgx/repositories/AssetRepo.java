package com.project.asset.rmgx.repositories;

import com.project.asset.rmgx.entities.Assets;
import com.project.asset.rmgx.entities.Category;
import com.project.asset.rmgx.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetRepo extends JpaRepository<Assets,Integer> {

        List<Assets> findByUser(User user);
        List<Assets> findByCategory(Category category);
        List<Assets> findByName(String name);

}
