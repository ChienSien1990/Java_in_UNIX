package chat;


public final class ChatServerHolder implements org.omg.CORBA.portable.Streamable
{
  public chat.ChatServer value = null;

  public ChatServerHolder ()
  {
  }

  public ChatServerHolder (chat.ChatServer initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = chat.ChatServerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    chat.ChatServerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return chat.ChatServerHelper.type ();
  }

}
