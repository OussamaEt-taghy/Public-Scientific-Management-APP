package oussama.it.backend.Repositorys;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import oussama.it.backend.Entities.ENUMs.Roles;
import oussama.it.backend.Entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    User findByRole(Roles role);
    @Transactional
    @Modifying
    @Query("update User u set u.password= ?2 where u.email =?1")
    void updatePassword(String email, String password);



}
