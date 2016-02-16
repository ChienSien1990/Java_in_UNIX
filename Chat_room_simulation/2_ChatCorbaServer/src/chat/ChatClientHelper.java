package chat;


abstract public class ChatClientHelper
{
  private static String  _id = "IDL:chat/ChatClient:1.0";

  public static void insert (org.omg.CORBA.Any a, chat.ChatClient that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static chat.ChatClient extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (chat.ChatClientHelper.id (), "ChatClient");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static chat.ChatClient read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ChatClientStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, chat.ChatClient value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static chat.ChatClient narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof chat.ChatClient)
      return (chat.ChatClient)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      chat._ChatClientStub stub = new chat._ChatClientStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static chat.ChatClient unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof chat.ChatClient)
      return (chat.ChatClient)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      chat._ChatClientStub stub = new chat._ChatClientStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
