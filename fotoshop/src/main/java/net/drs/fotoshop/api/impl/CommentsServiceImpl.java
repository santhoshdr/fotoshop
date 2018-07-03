package net.drs.fotoshop.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.drs.fotoshop.api.userdetails.ICommentsService;
import net.drs.fotoshopbackend.dao.ICommentsDAO;
import net.drs.fotoshopbackend.dto.Comments;
import net.drs.fotoshopbackend.dto.Fotographer;

@Repository("commentsService")
@Transactional
public class CommentsServiceImpl implements ICommentsService {

	@Autowired
	public ICommentsDAO commentsDAO;
	
	@Override
	public boolean saveComment(Comments comments) {
		return commentsDAO.saveComment(comments);
	}

	@Override
	public boolean editComment(Comments comments) {
		return commentsDAO.editComment(comments);
	}

	@Override
	public boolean delete(Comments comments) {
		return commentsDAO.delete(comments);
	}

	@Override
	public boolean replyforaComment(Comments comments) {
		return commentsDAO.replyforaComment(comments);
	}

	@Override
	public boolean likeacomment(Comments comments) {
		return commentsDAO.likeacomment(comments);
	}

	@Override
	public boolean dislikeacomment(Comments comments) {
		return commentsDAO.dislikeacomment(comments);
	}

	@Override
	public List<Comments> getCommentsForFotographer(Fotographer fotographer) {
		return commentsDAO.getCommentsForFotographer(fotographer);
	}


}
