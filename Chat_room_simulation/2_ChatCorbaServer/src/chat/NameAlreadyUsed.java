package chat;

public final class NameAlreadyUsed extends org.omg.CORBA.UserException
{

  public NameAlreadyUsed ()
  {
    super(NameAlreadyUsedHelper.id());
  } // ctor


  public NameAlreadyUsed (String $reason)
  {
    super(NameAlreadyUsedHelper.id() + "  " + $reason);
  } // ctor

} // class NameAlreadyUsed
