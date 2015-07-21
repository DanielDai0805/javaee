package jsp.tag.custom;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

/**
 * Created by dc on 2015/7/21.
 */
public class SingleEvaluationCustomTag extends BodyTagSupport {
    private String caseFlag;

    public void setCaseFlag(String caseFlag){
        this.caseFlag = caseFlag;
    }

    @Override
    public int doAfterBody() throws JspException {
        try {
            BodyContent bc = getBodyContent();
            String body = bc.getString();
            JspWriter out = bc.getEnclosingWriter();
            if (body != null) {
                if ("upper".equals(caseFlag)) {
                    out.print(body.toUpperCase());
                } else {
                    out.print(body.toLowerCase());
                }
            }
        } catch (IOException ex) {

            throw new JspException("Error: " + ex.getMessage());
        }
        return  SKIP_BODY;
    }

}
