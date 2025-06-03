package tw.ELS.lesson.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface LessonRepository extends JpaRepository<Lesson, Integer> {

	 @Query(value="select * from Lesson where LESSONNAME like concat('%',:lessonName,'%')",nativeQuery = true)
	  public Page<Lesson> findLessonNamePage(String lessonName, Pageable pageable);
}
