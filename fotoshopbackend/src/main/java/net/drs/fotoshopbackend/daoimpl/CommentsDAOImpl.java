package net.drs.fotoshopbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.drs.fotoshopbackend.dao.ICommentsDAO;
import net.drs.fotoshopbackend.dto.Comments;
import net.drs.fotoshopbackend.dto.Fotographer;


@Repository("commentsDAO")
@Transactional
public class CommentsDAOImpl implements ICommentsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean saveComment(Comments comments) {
		sessionFactory.getCurrentSession().save(comments);
		return true;
	}

	public boolean editComment(Comments comments) {
		sessionFactory.getCurrentSession().update(comments);
		return false;
	}

	public boolean delete(Comments comments) {
		String selectQuery = "update Comments set active = :isActive WHERE commentId = :commentId";
		return sessionFactory.getCurrentSession()
				.createQuery(selectQuery)
					.setParameter("commentId", comments.getCommentId())
					.setParameter("isActive", false)
						.executeUpdate() >=  1 ? true : false;
	}

	public boolean replyforaComment(Comments comments) {
		sessionFactory.getCurrentSession().save(comments);
		return true;
	}

	public boolean likeacomment(Comments comments) {
		return false;
	}

	public boolean dislikeacomment(Comments comments) {
		return false;
	}

	public List<Comments> getCommentsForFotographer(Fotographer fotographer) {
		return null;
	}

}
