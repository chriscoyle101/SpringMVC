
/**
 * ErrorFaultException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.nextgate.chriscoyle.webservice;

public class ErrorFaultException extends java.lang.Exception{

    private static final long serialVersionUID = 1503532770024L;
    
    private com.nextgate.chriscoyle.webservice.MusicServiceStub.ErrorFault faultMessage;

    
        public ErrorFaultException() {
            super("ErrorFaultException");
        }

        public ErrorFaultException(java.lang.String s) {
           super(s);
        }

        public ErrorFaultException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ErrorFaultException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.nextgate.chriscoyle.webservice.MusicServiceStub.ErrorFault msg){
       faultMessage = msg;
    }
    
    public com.nextgate.chriscoyle.webservice.MusicServiceStub.ErrorFault getFaultMessage(){
       return faultMessage;
    }
}
    