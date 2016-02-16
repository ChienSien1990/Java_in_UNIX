package chat;


public final class UnknownID extends org.omg.CORBA.UserException
{

  public UnknownID ()
  {
    super(UnknownIDHelper.id());
  } // ctor


  public UnknownID (String $reason)
  {
    super(UnknownIDHelper.id() + "  " + $reason);
  } // ctor

} // class UnknownID
