// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.managed.request;
import cn.jhc.myexam.client.request.BriefAnswerRequest;
import cn.jhc.myexam.client.request.CategoryRequest;
import cn.jhc.myexam.client.request.FillBlankRequest;
import cn.jhc.myexam.client.request.GlossaryRequest;
import cn.jhc.myexam.client.request.QuizRequest;
import cn.jhc.myexam.client.request.RoleRequest;
import cn.jhc.myexam.client.request.SingleChoiceRequest;
import cn.jhc.myexam.client.request.TrueOrFalseRequest;
import cn.jhc.myexam.client.request.UserRequest;
import cn.jhc.myexam.shared.scaffold.ScaffoldRequestFactory;

public interface ApplicationRequestFactory extends ScaffoldRequestFactory {

    BriefAnswerRequest briefAnswerRequest();

    CategoryRequest categoryRequest();

    FillBlankRequest fillBlankRequest();

    GlossaryRequest glossaryRequest();

    QuizRequest quizRequest();

    RoleRequest roleRequest();

    SingleChoiceRequest singleChoiceRequest();

    TrueOrFalseRequest trueOrFalseRequest();

    UserRequest userRequest();
}
