package tags;

import utils.BlockUtils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class OverrideTag extends BodyTagSupport {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int doStartTag() throws JspException {
        return isOverrided() ? SKIP_BODY : EVAL_BODY_BUFFERED;
    }

    @Override
    public int doEndTag() throws JspException {
        if (isOverrided()) {
            return EVAL_PAGE;
        }
        BodyContent b = getBodyContent();
        String varName = BlockUtils.getOverrideVariableName(name);
        pageContext.setAttribute(varName, b.getString());
        return EVAL_PAGE;
    }

    private boolean isOverrided() {
        String varName = BlockUtils.getOverrideVariableName(name);
        return pageContext.getAttribute(varName) != null;
    }

}