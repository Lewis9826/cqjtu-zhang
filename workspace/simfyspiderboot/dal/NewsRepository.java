package edu.cqjtu.zhang.simfyspiderboot.dal;

import edu.cqjtu.zhang.simfyspiderboot.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News,Integer> {


}
