// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package cn.jhc.myexam.server.repository;

import cn.jhc.myexam.server.domain.Attempt;
import cn.jhc.myexam.server.repository.AttemptRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

privileged aspect AttemptRepository_Roo_Jpa_Repository {
    
    declare parents: AttemptRepository extends JpaRepository<Attempt, Long>;
    
    declare parents: AttemptRepository extends JpaSpecificationExecutor<Attempt>;
    
    declare @type: AttemptRepository: @Repository;
    
}