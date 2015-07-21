package jsp.tag.custom;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dc on 2015/7/21.
 * link:http://www.codeproject.com/Articles/31614/JSP-JSTL-Custom-Tag-Library
 *      http://docs.oracle.com/javaee/5/tutorial/doc/bnalk.html
 *
 * step:
 *      1.Write the tag handler class
 *      2.Create the tag library descriptor(TLD)
 *      3.Make the TLD file and handle classes accessible
 *      4.Reference the tag library
 *      5.Use the tag in the jsp
 */
public class TodayTag extends TagSupport {
    private String format;

    /**
     * this set method must be defined .
     * @param format
     */
    public void setFormat(String format){
        this.format = format;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            Date today = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            out.print(dateFormat.format(today));
        } catch(IOException ioe) {
            throw new JspException("Error: " + ioe.getMessage());
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
         return SKIP_PAGE;
    }
}
