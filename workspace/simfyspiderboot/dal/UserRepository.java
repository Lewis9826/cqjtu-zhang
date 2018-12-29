package edu.cqjtu.zhang.simfyspiderboot.dal;


import edu.cqjtu.zhang.simfyspiderboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lewis
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
