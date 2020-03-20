package com.project.test.springbootlesson1.dbServices;

import com.project.test.springbootlesson1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends JpaRepository<User,Integer> {
}
