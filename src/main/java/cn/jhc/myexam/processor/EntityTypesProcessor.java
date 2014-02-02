package cn.jhc.myexam.processor;

import cn.jhc.myexam.server.domain.Attempt;
import cn.jhc.myexam.server.domain.BriefAnswer;
import cn.jhc.myexam.server.domain.Category;
import cn.jhc.myexam.server.domain.FillBlank;
import cn.jhc.myexam.server.domain.Glossary;
import cn.jhc.myexam.server.domain.Quiz;
import cn.jhc.myexam.server.domain.Role;
import cn.jhc.myexam.server.domain.SingleChoice;
import cn.jhc.myexam.server.domain.TrueOrFalse;
import cn.jhc.myexam.server.domain.User;

public abstract class EntityTypesProcessor<T> {

	private final T defaultValue;

    private T result;
    
    public EntityTypesProcessor() {
    	defaultValue = null;
    }
    
    public EntityTypesProcessor(T defaultValue) {
    	this.defaultValue = defaultValue;
    }
    
    private static void process(EntityTypesProcessor<?> processor, Class<?> clazz) {
        if (Attempt.class.equals(clazz)) {
            processor.handleAttempt((Attempt) null);
            return;
        }
        if (BriefAnswer.class.equals(clazz)) {
            processor.handleBriefAnswer((BriefAnswer) null);
            return;
        }
        if (Category.class.equals(clazz)) {
            processor.handleCategory((Category) null);
            return;
        }
        if (FillBlank.class.equals(clazz)) {
            processor.handleFillBlank((FillBlank) null);
            return;
        }
        if (Glossary.class.equals(clazz)) {
            processor.handleGlossary((Glossary) null);
            return;
        }
        if (Quiz.class.equals(clazz)) {
            processor.handleQuiz((Quiz) null);
            return;
        }
        if (Role.class.equals(clazz)) {
            processor.handleRole((Role) null);
            return;
        }
        if (SingleChoice.class.equals(clazz)) {
            processor.handleSingleChoice((SingleChoice) null);
            return;
        }
        if (TrueOrFalse.class.equals(clazz)) {
            processor.handleTrueOrFalse((TrueOrFalse) null);
            return;
        }
        if (User.class.equals(clazz)) {
            processor.handleUser((User) null);
            return;
        }
        processor.handleNonEntity(null);
    }

    private static void process(EntityTypesProcessor<?> processor, Object object) {
        if (object instanceof Attempt) {
            processor.handleAttempt((Attempt) object);
            return;
        }
        if (object instanceof BriefAnswer) {
            processor.handleBriefAnswer((BriefAnswer) object);
            return;
        }
        if (object instanceof Category) {
            processor.handleCategory((Category) object);
            return;
        }
        if (object instanceof FillBlank) {
            processor.handleFillBlank((FillBlank) object);
            return;
        }
        if (object instanceof Glossary) {
            processor.handleGlossary((Glossary) object);
            return;
        }
        if (object instanceof Quiz) {
            processor.handleQuiz((Quiz) object);
            return;
        }
        if (object instanceof Role) {
            processor.handleRole((Role) object);
            return;
        }
        if (object instanceof SingleChoice) {
            processor.handleSingleChoice((SingleChoice) object);
            return;
        }
        if (object instanceof TrueOrFalse) {
            processor.handleTrueOrFalse((TrueOrFalse) object);
            return;
        }
        if (object instanceof User) {
            processor.handleUser((User) object);
            return;
        }
        processor.handleNonEntity(object);
    }

    public void handleNonEntity(Object object) {
    }

    public abstract void handleAttempt(Attempt attempt);

    public abstract void handleBriefAnswer(BriefAnswer briefAnswer);

    public abstract void handleCategory(Category category);

    public abstract void handleFillBlank(FillBlank fillBlank);

    public abstract void handleGlossary(Glossary glossary);

    public abstract void handleQuiz(Quiz quiz);

    public abstract void handleRole(Role role);

    public abstract void handleSingleChoice(SingleChoice singleChoice);

    public abstract void handleTrueOrFalse(TrueOrFalse trueOrFalse);

    public abstract void handleUser(User user);

    public T process(Class<?> clazz) {
        setResult(defaultValue);
        EntityTypesProcessor.process(this, clazz);
        return result;
    }

    public T process(Object object) {
        setResult(defaultValue);
        EntityTypesProcessor.process(this, object);
        return result;
    }

    protected void setResult(T result) {
        this.result = result;
    }
}
