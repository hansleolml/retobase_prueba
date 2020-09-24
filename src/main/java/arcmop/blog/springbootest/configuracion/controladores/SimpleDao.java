package arcmop.blog.springbootest.configuracion.controladores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
/**
 *
 * @author Hans
 */
@Service
public interface SimpleDao extends JpaRepository <Simple, Long>{
    
}
