package com.github.hirethem.util;

import java.util.ResourceBundle;

/**
 * Util for language internationalization.
 */
public class ResourceBundleUtil {

    /**
     * Get resource bundle for specific language
     * @param language language of resource bundle
     * @return resource bundle for some language
     */
    public static ResourceBundle getResourceBundle(String language){
        String path = "i18n.restaurant";

        if(language!=null && !language.equals("en")){
            path+="_"+language;
        }

        return ResourceBundle.getBundle(path);
    }
}
