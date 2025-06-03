package tw.ELS.mylesson.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface MyLessonRepository extends JpaRepository<MyLesson, Integer> {
	Page<MyLesson> findByMemberId(int memberId,Pageable pageable);
	MyLesson findByMemberIdAndLessonId(int memberId,int lessonId);
	void deleteByMemberIdAndLessonId(int memberId,int lessonId);

}
