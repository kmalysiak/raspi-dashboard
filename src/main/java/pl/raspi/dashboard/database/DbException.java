package pl.raspi.dashboard.database;

public class DbException extends RuntimeException {

  public DbException(String message) {
    super(message);
  }

  public DbException(String message, Exception previousException) {
    super(message, previousException);
  }

}
