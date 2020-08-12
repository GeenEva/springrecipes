package eva.recipes.chapter3mvc3.library;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

public class CustomizedErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String,Object> getErrorAttributes(WebRequest webRequest,
                                                ErrorAttributeOptions includeStackTrace){

        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("parameters", webRequest.getParameterMap());
        return errorAttributes;
    }
}
