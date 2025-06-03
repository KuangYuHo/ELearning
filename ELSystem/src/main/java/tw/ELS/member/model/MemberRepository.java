package tw.ELS.member.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface MemberRepository extends JpaRepository<Member, Integer> {
	public Optional<Member> findByAccount(String account);
	public List<Member> findAllByAccountContaining(String account);
	public List<Member> findAllByEmailContaining(String email);

	@Query(value="select * from Member where ACCOUNT like concat('%',:account,'%')",nativeQuery = true)
	public Page<Member> findAccountPage(String account,Pageable pageable);
	
	@Query(value="select * from Member where EMAIL like concat('%',:email,'%')",nativeQuery = true)
	public Page<Member> findEmailPage(String email,Pageable pageable);

}
