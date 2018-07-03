package net.drs.fotoshop;

import static org.junit.Assert.assertEquals;

import java.util.List;

import net.drs.fotoshop.api.userdetails.ICommentsService;
import net.drs.fotoshop.utility.FotoshopUtility;
import net.drs.fotoshopbackend.dto.Comments;
import net.drs.fotoshopbackend.dto.Fotographer;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentsServiceTest {

private static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	
	@Autowired
	private static ICommentsService commentsService;
	
	
	
	@BeforeClass
	public static void init(){
		
		annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("net.drs.fotoshop.api","net.drs.fotoshopbackend");
		annotationConfigApplicationContext.refresh();
		commentsService = (ICommentsService)annotationConfigApplicationContext.getBean("commentsService");
		}
	
/*	@Test
	public void addCommentsforFotographer(){
		
		Fotographer fotographer = new Fotographer();
		fotographer.setFotographerId(new Long(9));
		boolean result=false;
		
		Comments comments = new Comments();
		comments.setComment("My Comments");
		comments.setCommentedAt(FotoshopUtility.getCurrentDateandTime());
		comments.setCommentedBy("Santhosh");
		comments.setFotographer(fotographer);
		comments.setCommentedByUserId(new Long(9));

		result = commentsService.saveComment(comments);
		assertEquals("Success",true,result);
	}
*/
	
	@Test
	public void addCommentstoCommentsforFotographer(){
		
		Fotographer fotographer = new Fotographer();
		fotographer.setFotographerId(new Long(2));
		boolean result=false;
		
		Comments comments = new Comments();
		comments.setComment("New COmment to comment ID 9 ");
		comments.setCommentedAt(FotoshopUtility.getCurrentDateandTime());
		comments.setCommentedBy("Santhosh");
		comments.setFotographer(fotographer);
		comments.setCommentedByUserId(new Long(10));
		comments.setReplytocommentId(new Long(9));
		result = commentsService.replyforaComment(comments);
		assertEquals("Success",true,result);
	}

	
	
	/*@Test
	public void getCommentsForFotographer(){
		
		Fotographer fotographer = new Fotographer();
		fotographer.setFotographerId(new Long(2));
		boolean result=false;

		List<Comments> comments = commentsService.getCommentsForFotographer(fotographer);
		assertEquals("Success",true,result);
	}*/
	
}
