// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package cn.jhc.myexam.server.domain;

import cn.jhc.myexam.server.domain.TrueOrFalse;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

privileged aspect TrueOrFalse_Roo_Jpa_Entity {
    
    declare @type: TrueOrFalse: @Entity;
    
    @Id
    @SequenceGenerator(name = "trueOrFalseGen", sequenceName = "true_or_false_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "trueOrFalseGen")
    @Column(name = "id")
    private Long TrueOrFalse.id;
    
    @Version
    @Column(name = "version")
    private Integer TrueOrFalse.version;
    
    public Long TrueOrFalse.getId() {
        return this.id;
    }
    
    public void TrueOrFalse.setId(Long id) {
        this.id = id;
    }
    
    public Integer TrueOrFalse.getVersion() {
        return this.version;
    }
    
    public void TrueOrFalse.setVersion(Integer version) {
        this.version = version;
    }
    
}
