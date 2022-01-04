package com.pgiles.slacker.utils;

public class SimpleXMLNodeParser {

	  // NOTE: Usually these would be < >.  However we are
	  // dealing with Microsoft XML Content from Soap Service
	  // This is encoded as data is contained within a string tag
	  private static final String LEFT_BRACE = "<";
	  private static final String RIGHT_BRACE = ">";

	  private String xml_;
	  private int    index_;

	  /**
	   * Constructs the Node Parser with the specified xml content
	   */
	  public SimpleXMLNodeParser( String xml ) {
	    xml_ = xml;
	    index_=0;
	  }

	  /**
	   * getNextNode - Get the contents of the contents of the specified node name;
	   */
	  public String getNextNode( String nodeName ) {

	    String content = null;

	    // Get the index of the start node
	    String startNode = LEFT_BRACE + nodeName + RIGHT_BRACE;
	    int startIndex = xml_.indexOf( startNode, index_ );

	    // If we have a start, get the end node
	    if( startIndex != -1 ) {
	      String endNode = LEFT_BRACE + "/" + nodeName  +  RIGHT_BRACE;
	      int endIndex   = xml_.indexOf( endNode, startIndex + startNode.length() );

	      // set the content and the index for the Next Node
	      content = xml_.substring( startIndex + startNode.length(), endIndex );
	      index_ = endIndex + endNode.length();
	    }

	    // return the content
	    return content;
	  }
	
}
