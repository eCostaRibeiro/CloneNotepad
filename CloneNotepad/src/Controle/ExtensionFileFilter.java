/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author eduar_000
 */
public final class ExtensionFileFilter  extends FileFilter{

//    String[] extensions;
//    String description;
//    
//    /**
//     * Creates a file filter with several extensions.
//     * 
//     * @param f
//     * @return 
//     */
//        
//    @Override
//    public boolean accept(File f) {
//        // we always allow directories, regardless of their extension
//        if (f.isDirectory()){
//            return true;
//        }
//        
//        // ok, it's a regular file so check the extension
//        for (String extension : extensions)
//            if (f.getName().toLowerCase().endsWith(extension)){
//                return true;
//            }
//        
//        return false;
//    }
//    
//    public ExtensionFileFilter(String descr, String... exts){
//            // clone and lowercase the extensions
//            extensions = new String[exts.length];
//            
//            for (int i = exts.length - 1; i >= 0; i--){
//                extensions[i] = exts[i].toLowerCase();
//            }
//
//            // make sure we have a valid (if simplistic) description
//            description = (descr == null ? exts[0] + " files" : descr);
//    }
//    
//    /**
// * Creates a file filter with several extensions.
// * 
// * @param descr The filter description.
//     * @param exts
// */
//    public ExtensionFileFilter (String descr, List<String> exts) {
//        this(descr, exts.toArray(new String[exts.size()]));
//    }
//
///**
// * Verify if its a valid file. This method is automatically called by the
// * &lt;code&gt;FileChooser&lt;/code&gt; object.
// * 
// * @return A boolean indicated if the file was accepted by the filter or
// *         not.
// */
//    @Override
//    public String getDescription() {
//        return description;
//    }
    
    
    private String description = null;
    private String fullDescription = null;
    private boolean useExtensionsInDescription = true;

    private LinkedList endings = null;

    /**
     * Creates a file filter. If no filters are added, then all
     * files are rejected.
     *
     * @see #addExtension
     */
    public ExtensionFileFilter() {
        this.endings = new LinkedList();
    }

    /**
     * Creates a file filter that accepts files with the given ending.
     *
     * @param extension
     * @see #addExtension
     */
    public ExtensionFileFilter(String extension) {
	    this(extension, null);
    }

    /**
     * Creates a file filter that accepts the files with the given endings.
     *
     * @param extension
     * @param description
     * @see #addExtension
     */
    public ExtensionFileFilter(String extension, String description) {
	    this();
	    if (extension!=null) addExtension(extension);
 	    if (description!=null) setDescription(description);
    }

    /**
     * Creates a file filter from the array of given endings.
     *
     * @param filters
     * @see #addExtension
     */
    public ExtensionFileFilter(String[] filters) {
	    this(filters, null);
    }

    /**
     * Creates a file filter from the given string array and description.
     *
     * @param filters
     * @param description
     * @see #addExtension
     */
    public ExtensionFileFilter(String[] filters, String description) {
	    this();
        for (String filter : filters) {
            // add filters one by one
            addExtension(filter);
        }
     	if  (description!=null) setDescription(description);
    }

    /**
     * Return true if this file should be shown in the directory pane,
     * false if it shouldn't.
     *
     * @param f
     * @return 
     * @see FileFilter#accept
     */
    @Override
    public boolean accept(File f) {
    	if (f!=null) {
    	    if (f.isDirectory()) return true;
    	    if (match(f)) return true;
    	}
    	return false;
    }

    /**
     * This determines if the file matches any of the extensions. 
     * @param f
     * @return 
     */
    protected boolean match(File f) {
        return (getExtension(f) != null);
    }

    /**
     * Returns the extension portion of the files name (if part of this file filter).
     * 
     * @param f
     * @return extension including leading ".", or null if not found in filter.
     */
    public String getExtension(File f) {

    	if (f!=null) {
    	    String filename = f.getName();
            Iterator i = endings.iterator();
            while (i.hasNext()) {
                String end = (String) i.next();
                if (filename.endsWith(end)) return end;
    	    }
    	}
        return null;
    }

    /**
     * Adds an extension to filter against.
     * Leading "." is not mandatory.
     * @param extension
     */
    public void addExtension(String extension) {
        endings.add(extension.startsWith(".") ? extension : "."+extension);
    	fullDescription = null;
    }


    /**
     * Returns the human readable description of this filter. For
     * example: "JPEG and GIF Image Files (*.jpg, *.gif)"
     *
     * @return 
     * @see #setDescription
     * @see #setExtensionListInDescription
     * @see #isExtensionListInDescription
     * @see FileFilter#getDescription
     */
    @Override
    public String getDescription() {
    	if (fullDescription == null) {
    	    if (description == null || isExtensionListInDescription()) {
     		    fullDescription = description==null ? "(" : description + " (";
    		    // build the description from the extension list
    		    Iterator i = endings.iterator();
    		    while (i.hasNext()) {
    		        fullDescription += (String) i.next();
                    if (i.hasNext()) fullDescription += ", ";
    		    }
    		    fullDescription += ")";
    	    } else {
    		    fullDescription = description;
    	    }
    	}
    	return fullDescription;
    }

    /**
     * Sets the human readable description of this filter. For
     * example: filter.setDescription("Gif and JPG Images");
     *
     * @param description
     * @see #setDescription
     * @see #setExtensionListInDescription
     * @see #isExtensionListInDescription
     */
    public void setDescription(String description) {
    	this.description = description;
    	fullDescription = null;
    }

    /**
     * Determines whether the extension list (.jpg, .gif, etc) should
     * show up in the human readable description.
     *
     * Only relevent if a description was provided in the constructor
     * or using setDescription();
     *
     * @param b
     * @see #getDescription
     * @see #setDescription
     * @see #isExtensionListInDescription
     */
    public void setExtensionListInDescription(boolean b) {
    	useExtensionsInDescription = b;
    	fullDescription = null;
    }

    /**
     * Returns whether the extension list (.jpg, .gif, etc) should
     * show up in the human readable description.
     *
     * Only relevent if a description was provided in the constructor
     * or using setDescription();
     *
     * @return 
     * @see #getDescription
     * @see #setDescription
     * @see #setExtensionListInDescription
     */
    public boolean isExtensionListInDescription() {
    	return useExtensionsInDescription;
    }
}
