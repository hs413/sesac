package spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.security.domain.APIUser;

public interface APIUserRepository extends JpaRepository<APIUser, String> {

}
