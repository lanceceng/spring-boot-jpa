package com.attc.cattail.repository.primary;

import com.attc.cattail.entity.primary.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MyRepository extends JpaRepository<Student,Integer> {

    @Modifying
    @Transactional
    @Query("update Student u set u.name=?1,u.age=?2,u.classname=?3 where u.id=?5")
    void modifyOne(int name, int age, String classname, int id);
}
