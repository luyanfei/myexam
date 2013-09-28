// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package cn.jhc.myexam.server.service;

import cn.jhc.myexam.server.domain.Glossary;
import cn.jhc.myexam.server.repository.GlossaryRepository;
import cn.jhc.myexam.server.service.GlossaryServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect GlossaryServiceImpl_Roo_Service {
    
    declare @type: GlossaryServiceImpl: @Service;
    
    declare @type: GlossaryServiceImpl: @Transactional;
    
    @Autowired
    GlossaryRepository GlossaryServiceImpl.glossaryRepository;
    
    public long GlossaryServiceImpl.countAllGlossarys() {
        return glossaryRepository.count();
    }
    
    public void GlossaryServiceImpl.deleteGlossary(Glossary glossary) {
        glossaryRepository.delete(glossary);
    }
    
    public Glossary GlossaryServiceImpl.findGlossary(Long id) {
        return glossaryRepository.findOne(id);
    }
    
    public List<Glossary> GlossaryServiceImpl.findAllGlossarys() {
        return glossaryRepository.findAll();
    }
    
    public List<Glossary> GlossaryServiceImpl.findGlossaryEntries(int firstResult, int maxResults) {
        return glossaryRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }
    
    public void GlossaryServiceImpl.saveGlossary(Glossary glossary) {
        glossaryRepository.save(glossary);
    }
    
    public Glossary GlossaryServiceImpl.updateGlossary(Glossary glossary) {
        return glossaryRepository.save(glossary);
    }
    
}
