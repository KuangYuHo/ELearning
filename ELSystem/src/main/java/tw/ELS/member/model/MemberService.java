package tw.ELS.member.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberRepository memRep;
	
	public Member insertMember(Member m) {
		return memRep.save(m);
	}
	
	public Member updateMember(Member m) {
		return memRep.save(m);
	}
	
	public List<Member> findAll(){
		return memRep.findAll();
	}
	
	public Member findByAccount(String Account) {
		Optional<Member> op1 = memRep.findByAccount(Account);
		if(op1.isEmpty()) {
			return null;
		}
		
		return op1.get();
	}
	
	public Member findById(Integer id) {
		Optional<Member> op1 = memRep.findById(id);
		if(op1.isPresent()) {
			return op1.get();
		}
		return null;
	}
	
	public Page<Member>findAllByPage(Pageable pageable){
		return memRep.findAll(pageable);
	}
	
	public Page<Member>searchfindAllByAccountPage(String account,Pageable pageable){
		return memRep.findAccountPage(account,pageable);
	}
	
	public Page<Member>searchfindAllByEmailPage(String email,Pageable pageable){
		return memRep.findEmailPage(email,pageable);
	}
	
	
	public void deleteMember(Member m) {
		memRep.delete(m);
	}
}
