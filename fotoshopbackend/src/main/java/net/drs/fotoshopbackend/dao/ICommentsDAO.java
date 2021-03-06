package net.drs.fotoshopbackend.dao;

import java.util.List;

import net.drs.fotoshopbackend.dto.Comments;
import net.drs.fotoshopbackend.dto.Fotographer;

public interface ICommentsDAO {
	
	boolean saveComment(Comments comments);
	
	boolean editComment(Comments comments);
	
	boolean delete(Comments comments);
	
	boolean replyforaComment(Comments comments);
	
	boolean likeacomment(Comments comments);
	
	boolean dislikeacomment(Comments comments);
	
	
	List<Comments> getCommentsForFotographer(Fotographer fotographer);

}
