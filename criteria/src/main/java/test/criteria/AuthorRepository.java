package test.criteria;

import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import jakarta.persistence.criteria.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepository {

    @Autowired
    private EntityViewManager evm;

    public List<AuthorView> findAll() {
        CriteriaBuilder<Author> cb = evm.getCriteriaBuilder(Author.class);
        CriteriaQuery<AuthorView> query = evm.createQuery(cb, AuthorView.class);
        return evm.applySetting(EntityViewSetting.create(AuthorView.class), query).getResultList();
    }
}
