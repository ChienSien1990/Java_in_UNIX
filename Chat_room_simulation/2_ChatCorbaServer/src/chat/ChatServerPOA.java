package chat;


public abstract class ChatServerPOA extends org.omg.PortableServer.Servant
 implements chat.ChatServerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("subscribe", new java.lang.Integer (0));
    _methods.put ("unsubscribe", new java.lang.Integer (1));
    _methods.put ("comment", new java.lang.Integer (2));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // chat/ChatServer/subscribe
       {
         try {
           String nick = in.read_string ();
           chat.ChatClient c = chat.ChatClientHelper.read (in);
           String $result = null;
           $result = this.subscribe (nick, c);
           out = $rh.createReply();
           out.write_string ($result);
         } catch (chat.NameAlreadyUsed $ex) {
           out = $rh.createExceptionReply ();
           chat.NameAlreadyUsedHelper.write (out, $ex);
         }
         break;
       }

       case 1:  // chat/ChatServer/unsubscribe
       {
         try {
           String id = in.read_string ();
           this.unsubscribe (id);
           out = $rh.createReply();
         } catch (chat.UnknownID $ex) {
           out = $rh.createExceptionReply ();
           chat.UnknownIDHelper.write (out, $ex);
         }
         break;
       }

       case 2:  // chat/ChatServer/comment
       {
         try {
           String id = in.read_string ();
           String text = in.read_string ();
           this.comment (id, text);
           out = $rh.createReply();
         } catch (chat.UnknownID $ex) {
           out = $rh.createExceptionReply ();
           chat.UnknownIDHelper.write (out, $ex);
         }
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:chat/ChatServer:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public ChatServer _this() 
  {
    return ChatServerHelper.narrow(
    super._this_object());
  }

  public ChatServer _this(org.omg.CORBA.ORB orb) 
  {
    return ChatServerHelper.narrow(
    super._this_object(orb));
  }


} // class ChatServerPOA
