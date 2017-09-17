
/**
 * ErrorFaultException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package music;

public class ErrorFaultException extends java.lang.Exception{

    private static final long serialVersionUID = 1503416731350L;
    
    private music.ErrorFault faultMessage;

    
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
    

    public void setFaultMessage(music.ErrorFault msg){
       faultMessage = msg;
    }
    
    public music.ErrorFault getFaultMessage(){
       return faultMessage;
    }
}
    