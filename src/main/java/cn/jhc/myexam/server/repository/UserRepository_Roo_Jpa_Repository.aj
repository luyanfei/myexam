// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package cn.jhc.myexam.server.repository;

import cn.jhc.myexam.server.domain.User;
import cn.jhc.myexam.server.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

privileged aspect UserRepository_Roo_Jpa_Repository {
    
    declare parents: UserRepository extends JpaRepository<User, Long>;
    
    declare parents: UserRepository extends JpaSpecificationExecutor<User>;
    
    declare @type: UserRepository: @Repository;
    
}
