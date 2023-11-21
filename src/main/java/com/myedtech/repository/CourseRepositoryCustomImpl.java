package com.myedtech.repository;

import org.springframework.transaction.annotation.Transactional;
import com.myedtech.models.dto.CourseDto;
import com.myedtech.models.dto.SearchDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional(rollbackFor = Exception.class)
public class CourseRepositoryCustomImpl implements CourseRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CourseDto> searchCourse(SearchDto dto) {
        String hql = "SELECT new com.myedtech.models.dto.CourseDto("
                + "c.id, "
                + "c.title, "
                + "c.image, "
                + "c.hourCount, "
                + "c.viewCount, "
                + "c.price, "
                + "c.desc, "
                + "c.content, "
                + "c.cateId, "
                + "c.lastUpdate, "
                + "ca.name) "
                + "FROM Course c "
                + "JOIN Category ca ON c.cateId = ca.id ";

        String filter = "WHERE (c.title LIKE '%" + dto.getKey() + "%' "
                + "OR c.content LIKE '%" + dto.getKey() + "%' "
                + ") ";

        String[] cateFilter =  dto.getCategory();
        for (int i = 0; i < cateFilter.length; i++) {
            if (i == 0) filter += "AND ( ";
            filter += "ca.name = '" + cateFilter[i] + "' ";
            if (i != cateFilter.length - 1) {
                filter += "OR ";
            }
            else {
                filter += ") ";
            }
        }

        hql = hql + filter;

        System.out.println("++++++++++++++++= " + hql);

        Query query = entityManager.createQuery(hql);
        List<CourseDto> dtos = query.getResultList();
        return dtos;
    }
}