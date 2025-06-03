package tw.ELS.lesson.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.ELS.article.model.Article;

@Service
@Transactional
public class LessonService {
	@Autowired
	private LessonRepository lResp;
	
	public Lesson findById(Integer id) {
		Optional<Lesson> op1 = lResp.findById(id);
		if(op1.isPresent()) {
			return op1.get();
		}
		return null;
	}
	
	public List<Lesson> findAll(){
		return lResp.findAll();
	}
	
	public Page<Lesson> findAllByPage(Pageable pageable){
		return lResp.findAll(pageable);
	}
	
	public Lesson insertLesson(Lesson lesson) {
		return lResp.save(lesson);
	}
	
	public Lesson updateLesson(Lesson lesson) {
		return lResp.save(lesson);
	}
	
	public void deleteLesson(Lesson lesson) {
		lResp.delete(lesson);
	}

	public Page<Lesson> findAllByLessonName(String lessonName, Pageable pageable){
		return lResp.findLessonNamePage(lessonName, pageable);
	}
}
