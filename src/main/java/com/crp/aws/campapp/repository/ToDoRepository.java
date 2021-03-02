package com.crp.aws.campapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crp.aws.campapp.domain.ToDo;

/**
 * JPAリポジトリのインタフェース
 *
 * @author ytkng
 *
 */
@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long>{

}
