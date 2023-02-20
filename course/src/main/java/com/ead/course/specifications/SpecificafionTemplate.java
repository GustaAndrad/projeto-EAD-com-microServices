package com.ead.course.specifications;

import com.ead.course.models.CourseModel;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

public class SpecificafionTemplate {

    @And({
            @Spec(path = "name", spec = Like.class),
            @Spec(path = "courseStatus", spec = Equal.class ),
            @Spec(path = "courseLevel", spec = Equal.class)
    })
    public interface CourseSpec extends Specification<CourseModel> {};
}
