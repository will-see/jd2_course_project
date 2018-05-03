package com.pvt.DAO.impl;

import com.pvt.DAO.FormularDao;
import com.pvt.dto.FormularDto;
import com.pvt.entities.Formular;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FormularDaoImpl extends BaseDao<Formular> implements FormularDao<Formular> {


//    private static final String getQuery = "SELECT formularId, userId, bookId FROM formular WHERE userId=?";
//    private static final String getUserFormularQuery = "SELECT books.name, authors.author_name FROM books JOIN formular on formular.bookId=books.bookId JOIN authors ON books.authorId = id_author WHERE userId=?";
//    private static final String getAllByUserQuery = "SELECT formularId, userId FROM formular WHERE userId = ? ORDER BY formularId DESC";

    public FormularDaoImpl() {
        super();
        clazz = Formular.class;
    }

    @Override
    @SuppressWarnings("all")
    public List<FormularDto> getUserBooksInFormular(long userId) throws SQLException {
        EntityManager em = getEm();
        Session unwrap = em.unwrap(Session.class);

        List<FormularDto> formularDto = unwrap.createSQLQuery("SELECT books.title as name, authors.name author FROM books JOIN formulars ON formulars.bookId=books.bookId JOIN authors ON books.AUTHOR_ID = authors.authorId WHERE USER_ID=(:values)")
                .setInteger("values",(int)userId)
//                .addScalar("name", StandardBasicTypes.STRING)
//                .addScalar("author", StandardBasicTypes.STRING)
                .setResultTransformer(Transformers.aliasToBean(FormularDto.class))
                .list();
        return formularDto;
    }

    @Override
    public List<Formular> getByUserId(long userId) throws SQLException {
        Query query = getEm().createNativeQuery("SELECT formularId, userId FROM formular WHERE userId = ? ORDER BY formularId DESC");
//        Query query = getEm().createNativeQuery("formularId, userId FROM formular WHERE userId = ? ORDER BY formularId DESC");
        return query.getResultList();
    }
}
