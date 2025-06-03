package tw.ELS.mylesson.model;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MyLessonService {
	
	@Autowired
	private MyLessonRepository mResp;
	
	public MyLesson insertMyLesson(MyLesson myLesson) {
		return mResp.save(myLesson);
	}
	
	public List<MyLesson> insertAllMyLesson(List<MyLesson> lml){
		return mResp.saveAll(lml);
	}
	
	public Page<MyLesson> findByMemberId(int memberId,Pageable pageable){
		return mResp.findByMemberId(memberId, pageable);
	}
	
	public MyLesson findByMemberIdAndLessonId(int memberId,int lessonId) {
		return mResp.findByMemberIdAndLessonId(memberId, lessonId);
	}
	
	public void deleteByMemberIdAndLessonId(int memberId,int lessonId) {
		mResp.deleteByMemberIdAndLessonId(memberId, lessonId);
	}

}
