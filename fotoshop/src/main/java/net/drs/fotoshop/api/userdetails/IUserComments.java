package net.drs.fotoshop.api.userdetails;

import net.drs.fotoshopbackend.dto.Comments;

public interface IUserComments {

	boolean saveComment(Comments comments);
	
	boolean editComment(Comments comments);
	
	boolean delete(Comments comments);
	
	boolean replyforaComment(Comments comments);
	
	boolean likeacomment(Comments comments);
	
	boolean dislikeacomment(Comments comments);
	
	
}
