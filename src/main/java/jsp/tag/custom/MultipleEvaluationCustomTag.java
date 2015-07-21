package jsp.tag.custom;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

/**
 * Created by dc on 2015/7/21.
 */
public class MultipleEvaluationCustomTag extends BodyTagSupport {
    private int times = 0;
    private BodyContent bodyContent;

    public void setTimes(int times){
        this.times = times;
    }

    /**
     * called by the JSP container to check for more than one loop
     * @param bodyContent
     */
    @Override
    public void setBodyContent(BodyContent bodyContent) {
        this.bodyContent = bodyContent;
    }

    /**
     * called at the start of the tag,it checks if the loop needs to be performed
     * @return
     * @throws JspException
     */
    @Override
    public int doStartTag() throws JspException {
        if(times>1){
            return EVAL_BODY_TAG;
        }else{
            return SKIP_BODY;
        }
    }

    /**
     * called after each evaluation; the number of times the loop needs to be performed is
     * decreased by one
     * @return
     * @throws JspException
     */
    @Override
    public int doAfterBody() throws JspException {
        if(this.times>1) {
            this.times--;
            return EVAL_BODY_TAG;
        }else {
            return SKIP_BODY;
        }
    }


    /**
     * The doEndTag method is called at the end of the tag, and the content (if any) is written to the enclosing writer.
     * @return
     * @throws JspException
     */
    @Override
    public int doEndTag() throws JspException {
        try {
            if (bodyContent != null) {
                bodyContent.writeOut(bodyContent.getEnclosingWriter());
            }
        } catch (IOException pIOEx) {
            throw new JspException("Error: " + pIOEx.getMessage());
        }
        return EVAL_PAGE;
    }


}
