package mportal.dao.impl;

import mportal.dao.MentorCategoryDao;
import mportal.domain.MentorCategory;
import mportal.domain.User;
import mportal.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by RuBen on 01.12.2016.
 */
public class MentorCategoryImpl implements MentorCategoryDao {
    private Session session;

    public MentorCategoryImpl() {
        session = HibernateUtil.createSessionFactory().openSession();
    }

    @Override
    public List<Integer> getUserIdByCategoryId(int id) {
        Query query =session.createSQLQuery("select user_id from mentor_category WHERE category_id='"+id+"'");
        System.out.println(query.list().toString()+"query");
        return (List<Integer>) query.list();
    }


    public void create(MentorCategory mentorCategory){
            session.beginTransaction();
            session.save(mentorCategory);
            session.getTransaction().commit();
        }

    @Override
    public MentorCategory getById(int id) throws Exception {
        Criteria criteria = session.createCriteria(User.class);
        return (MentorCategory) criteria.add(Restrictions.eq("userId", id)).uniqueResult();

    }

    @Override
    public void update(MentorCategory entity) throws Exception {

    }

    @Override
    public List<MentorCategory> getAll() throws Exception {
        return null;
    }

    @Override
    public void delete(MentorCategory entity) throws Exception {

    }

}
