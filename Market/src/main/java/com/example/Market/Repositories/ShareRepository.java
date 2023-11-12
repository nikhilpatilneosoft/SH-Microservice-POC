package com.example.Market.Repositories;

import com.example.Market.Models.Share;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShareRepository extends JpaRepository<Share, Integer> {

    Optional<Share> findShareByName(String name);
}
