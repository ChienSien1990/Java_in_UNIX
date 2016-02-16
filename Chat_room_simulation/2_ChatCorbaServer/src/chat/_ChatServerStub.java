package chat;


public class _ChatServerStub extends org.omg.CORBA.portable.ObjectImpl implements chat.ChatServer
{

  public String subscribe (String nick, chat.ChatClient c) throws chat.NameAlreadyUsed
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("subscribe", true);
                $out.write_string (nick);
                chat.ChatClientHelper.write ($out, c);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:chat/NameAlreadyUsed:1.0"))
                    throw chat.NameAlreadyUsedHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return subscribe (nick, c        );
            } finally {
                _releaseReply ($in);
            }
  } // subscribe

  public void unsubscribe (String id) throws chat.UnknownID
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("unsubscribe", true);
                $out.write_string (id);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:chat/UnknownID:1.0"))
                    throw chat.UnknownIDHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                unsubscribe (id        );
            } finally {
                _releaseReply ($in);
            }
  } // unsubscribe

  public void comment (String id, String text) throws chat.UnknownID
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("comment", true);
                $out.write_string (id);
                $out.write_string (text);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:chat/UnknownID:1.0"))
                    throw chat.UnknownIDHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                comment (id, text        );
            } finally {
                _releaseReply ($in);
            }
  } // comment

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:chat/ChatServer:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _ChatServerStub
