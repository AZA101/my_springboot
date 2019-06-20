package com.imooc.demo.Repository;

import com.imooc.demo.Dom.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author YJB
 * 2019-06-01
 * 继承jpa规范
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {
    public List<Girl> findByAge(Integer age);
}
