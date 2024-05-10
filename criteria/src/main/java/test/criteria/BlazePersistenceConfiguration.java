package test.criteria;

import com.blazebit.persistence.Criteria;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViews;
import com.blazebit.persistence.view.spi.EntityViewConfiguration;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlazePersistenceConfiguration {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Bean
    public EntityViewManager entityViewManager() {
        CriteriaBuilderFactory cbf = Criteria.getDefault().createCriteriaBuilderFactory(entityManagerFactory);
        EntityViewConfiguration cfg = EntityViews.createDefaultConfiguration();
        return cfg.createEntityViewManager(cbf);
    }
}
