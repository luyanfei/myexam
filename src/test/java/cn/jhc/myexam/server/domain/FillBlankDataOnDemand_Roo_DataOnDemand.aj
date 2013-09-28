// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package cn.jhc.myexam.server.domain;

import cn.jhc.myexam.server.domain.Category;
import cn.jhc.myexam.server.domain.CategoryDataOnDemand;
import cn.jhc.myexam.server.domain.FillBlank;
import cn.jhc.myexam.server.domain.FillBlankDataOnDemand;
import cn.jhc.myexam.server.repository.FillBlankRepository;
import cn.jhc.myexam.server.service.FillBlankService;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect FillBlankDataOnDemand_Roo_DataOnDemand {
    
    declare @type: FillBlankDataOnDemand: @Component;
    
    private Random FillBlankDataOnDemand.rnd = new SecureRandom();
    
    private List<FillBlank> FillBlankDataOnDemand.data;
    
    @Autowired
    CategoryDataOnDemand FillBlankDataOnDemand.categoryDataOnDemand;
    
    @Autowired
    FillBlankService FillBlankDataOnDemand.fillBlankService;
    
    @Autowired
    FillBlankRepository FillBlankDataOnDemand.fillBlankRepository;
    
    public FillBlank FillBlankDataOnDemand.getNewTransientFillBlank(int index) {
        FillBlank obj = new FillBlank();
        setAnswer(obj, index);
        setCategory(obj, index);
        setQuantity(obj, index);
        setQuestion(obj, index);
        return obj;
    }
    
    public void FillBlankDataOnDemand.setAnswer(FillBlank obj, int index) {
        String answer = "answer_" + index;
        if (answer.length() > 2048) {
            answer = answer.substring(0, 2048);
        }
        obj.setAnswer(answer);
    }
    
    public void FillBlankDataOnDemand.setCategory(FillBlank obj, int index) {
        Category category = categoryDataOnDemand.getRandomCategory();
        obj.setCategory(category);
    }
    
    public void FillBlankDataOnDemand.setQuantity(FillBlank obj, int index) {
        Integer quantity = new Integer(index);
        obj.setQuantity(quantity);
    }
    
    public void FillBlankDataOnDemand.setQuestion(FillBlank obj, int index) {
        String question = "question_" + index;
        if (question.length() > 2048) {
            question = question.substring(0, 2048);
        }
        obj.setQuestion(question);
    }
    
    public FillBlank FillBlankDataOnDemand.getSpecificFillBlank(int index) {
        init();
        if (index < 0) {
            index = 0;
        }
        if (index > (data.size() - 1)) {
            index = data.size() - 1;
        }
        FillBlank obj = data.get(index);
        Long id = obj.getId();
        return fillBlankService.findFillBlank(id);
    }
    
    public FillBlank FillBlankDataOnDemand.getRandomFillBlank() {
        init();
        FillBlank obj = data.get(rnd.nextInt(data.size()));
        Long id = obj.getId();
        return fillBlankService.findFillBlank(id);
    }
    
    public boolean FillBlankDataOnDemand.modifyFillBlank(FillBlank obj) {
        return false;
    }
    
    public void FillBlankDataOnDemand.init() {
        int from = 0;
        int to = 10;
        data = fillBlankService.findFillBlankEntries(from, to);
        if (data == null) {
            throw new IllegalStateException("Find entries implementation for 'FillBlank' illegally returned null");
        }
        if (!data.isEmpty()) {
            return;
        }
        
        data = new ArrayList<FillBlank>();
        for (int i = 0; i < 10; i++) {
            FillBlank obj = getNewTransientFillBlank(i);
            try {
                fillBlankService.saveFillBlank(obj);
            } catch (final ConstraintViolationException e) {
                final StringBuilder msg = new StringBuilder();
                for (Iterator<ConstraintViolation<?>> iter = e.getConstraintViolations().iterator(); iter.hasNext();) {
                    final ConstraintViolation<?> cv = iter.next();
                    msg.append("[").append(cv.getRootBean().getClass().getName()).append(".").append(cv.getPropertyPath()).append(": ").append(cv.getMessage()).append(" (invalid value = ").append(cv.getInvalidValue()).append(")").append("]");
                }
                throw new IllegalStateException(msg.toString(), e);
            }
            fillBlankRepository.flush();
            data.add(obj);
        }
    }
    
}
